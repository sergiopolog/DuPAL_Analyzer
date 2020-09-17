package info.hkzlab.dupal.analyzer.board.boardio;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import info.hkzlab.dupal.analyzer.exceptions.*;
import info.hkzlab.dupal.analyzer.palanalisys.explorers.OSExplorer;
import info.hkzlab.dupal.analyzer.palanalisys.explorers.SimpleExplorer;
import info.hkzlab.dupal.analyzer.palanalisys.formatter.JSONFormatter;
import info.hkzlab.dupal.analyzer.palanalisys.graph.OutState;
import info.hkzlab.dupal.analyzer.palanalisys.simple.SimpleState;
import info.hkzlab.dupal.analyzer.utilities.BitUtils;

public class DuPALAnalyzer {
    private static final Logger logger = LoggerFactory.getLogger(DuPALAnalyzer.class);

    private final String outFile;

    private final DuPALCmdInterface dpci;
    private int ioAsOutMask;
    
    public DuPALAnalyzer(final DuPALCmdInterface dpci, int ioAsOutMask, final String outFile) {
        this.dpci = dpci;
        this.ioAsOutMask = ioAsOutMask;
        this.outFile = outFile;
    } 

    public int detectIOTypeMask(final DuPALCmdInterface dpci) throws DuPALBoardException {
        int ioAsOutMask = 0;
        int maxINVal = 1 << (dpci.palSpecs.getPinCount_IN() + dpci.palSpecs.getPinCount_IO());

        logger.info("detectIOTypeMask -> Starting IO type detection... This could take a while.");
        logger.info("detectIOTypeMask -> Highest address for input pins: " + String.format("%06X", maxINVal-1));

        for(int idx = 0; idx < maxINVal; idx++) {

            int o_write_mask = BitUtils.scatterBitField(BitUtils.consolidateBitField(ioAsOutMask, (dpci.palSpecs.getMask_IO_R())), dpci.palSpecs.getMask_IO_W());
            int writeAddr = BitUtils.scatterBitField(idx, dpci.palSpecs.getMask_IN()) | BitUtils.scatterBitField((idx >> dpci.palSpecs.getPinCount_IN()), dpci.palSpecs.getMask_IO_W());
            
            if((writeAddr & o_write_mask) != 0) continue;

            for(int sub_idx = 0; sub_idx < maxINVal; sub_idx++) {
                if(ioAsOutMask == dpci.palSpecs.getMask_IO_R()) break; // All the IOs we already found to be outputs, no need to continue

                int sub_o_write_mask = BitUtils.scatterBitField(BitUtils.consolidateBitField(ioAsOutMask, (dpci.palSpecs.getMask_IO_R())), dpci.palSpecs.getMask_IO_W());
                int sub_writeAddr = BitUtils.scatterBitField(sub_idx, dpci.palSpecs.getMask_IN()) | BitUtils.scatterBitField(sub_idx >> dpci.palSpecs.getPinCount_IN(), dpci.palSpecs.getMask_IO_W());
                
                if((sub_writeAddr & sub_o_write_mask) != 0) continue; // Skip this run, as we're tryng to set something we found to be an output

                dpci.write(sub_writeAddr);
                int pinstat = dpci.read();

                ioAsOutMask |= (pinstat ^ BitUtils.scatterBitField((sub_idx >> dpci.palSpecs.getPinCount_IN()), dpci.palSpecs.getMask_IO_R())) & dpci.palSpecs.getMask_IO_R();
                
                logger.info(String.format("detectIOTypeMask -> idx: C(%06X) -> S(%06X) | M[%06X]", sub_idx, sub_writeAddr, ioAsOutMask));
            }

            if(dpci.palSpecs.getPinCount_RO() == 0) break; // No need to try multiple registered states

            logger.info("detectIOTypeMask -> Pulsing clock with address " + String.format("%06X", writeAddr));
            dpci.writeAndPulseClock(writeAddr);
        }

        return ioAsOutMask;
    }
    
    public DuPALAnalyzer(final DuPALCmdInterface dpci) {
        this(dpci, -1, null);
    }

    public void startAnalisys() throws Exception {
        startAnalisys(false);
    }

    public void startAnalisys(boolean padTable) throws Exception {
        int board_revision = dpci.getBoardVersion();
        DuPALCmdInterface.DuPAL_LED led;
        String formatterOutput = null;
       
        logger.info("startAnalisys() -> Espresso table results will"+(padTable?"":" not")+" be padded.");
        
        switch(dpci.palSpecs.slotNumber()) {
            default:
            case 0:
                led = DuPALCmdInterface.DuPAL_LED.P20_LED;
                break;
            case 1:
                 led = DuPALCmdInterface.DuPAL_LED.P24_LED;               
                break;
        }

        if(board_revision >= 2) dpci.setLED(led, true);

        try {
            if((dpci.palSpecs.getPinCount_IO() == 0) && (dpci.palSpecs.getPinCount_RO() == 0)) { // Purely combinatorial and no feedbacks, we can perform simple bruteforcing
                SimpleState[] ssArray = SimpleExplorer.exploreStates(dpci);
                
                logger.info("Got " + ssArray.length + " output states!");

                formatterOutput = JSONFormatter.formatJSON(dpci.palSpecs, ssArray);
            } else { // Either registered, or with feedbacks
                if(ioAsOutMask < 0) {
                    ioAsOutMask = detectIOTypeMask(dpci);
                    logger.info("startAnalisys() -> Detected the following IO Type mask: " + String.format("%06X", ioAsOutMask));
                }
                
                OutState[] osArray = OSExplorer.exploreOutStates(dpci, ioAsOutMask);

                logger.info("Got " + osArray.length + " output states!");
                formatterOutput = JSONFormatter.formatJSON(dpci.palSpecs, ioAsOutMask, osArray);
            }

            saveOutputToFile(outFile, formatterOutput);
        } catch(Exception e) {
            throw e;
        } finally {
            if(board_revision >= 2) dpci.setLED(led, false);
        }
    }

    private void saveOutputToFile(String destination, String out) throws IOException {
        FileOutputStream fout = null;
        
        logger.info("saveOutputToFile() -> Saving to " + destination);

        try {
            fout = new FileOutputStream(outFile);

            fout.write(out.getBytes(StandardCharsets.US_ASCII));
            
            fout.flush();
            fout.close();
        } catch(IOException e) {
            logger.error("Error printing out the registered outputs table (not including outputs).");
            throw e;
        }
    }
}