package info.hkzlab.dupal.analyzer.devices;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PAL16GenericSpecs implements PALSpecs {

	public static final String PAL_TYPE = "16Generic";
	public static final int PINS_COUNT = 18;

	// Initialized for pure combinational configuration PAL
    private String[] LABELS_RO =  { };
    private String[] LABELS_IN =  {  "i1",  "i2",  "i3",  "i4",  "i5",  "i6",  "i7",  "i8",  "i9", "i11",   null,   null,   null,   null,   null,   null,   null,   null };
    private String[] LABELS_IO =  {  null,  null,  null,  null,  null,  null,  null,  null,  null,  null, "io18", "io17", "io16", "io15", "io14", "io13", "io19", "io12" };
    private String[] LABELS_O  =  { };
    private String[] LABELS_O_INT  =  { };
    private String[] LABELS_CLK  =  { };
    private String[] LABELS_OE  =  { };

    
    public PAL16GenericSpecs() {
    	
	}
    
    public PAL16GenericSpecs(String config) {
		this.initLabels(config);
	}
    
    private void initLabels(String config) {
    	if (config == null || config.split(",").length != PINS_COUNT) {
    		throw new RuntimeException("Invalid " + PAL_TYPE + " input config");
    	}
    	List<String> labelsRO = new ArrayList<>();
    	List<String> labelsIN = new ArrayList<>();
    	List<String> labelsIO = new ArrayList<>();
    	List<String> labelsO = new ArrayList<>();
    	List<String> labelsOINT = new ArrayList<>();
    	List<String> labelsCLK = new ArrayList<>();
    	List<String> labelsOE = new ArrayList<>();
    	Arrays.asList(config.split(",")).forEach(o -> {
    		if (o.trim().equals("null")) {
    			labelsRO.add(null);
				labelsIN.add(null);
				labelsIO.add(null);
				labelsO.add(null);
				labelsOINT.add(null);
				labelsCLK.add(null);
				labelsOE.add(null);
    		} else if (o.trim().startsWith("clk")) {
    			labelsRO.add(null);
				labelsIN.add(null);
				labelsIO.add(null);
				labelsO.add(null);
				labelsOINT.add(null);
				labelsCLK.add(o.trim());
				labelsOE.add(null);
    		} else if (o.trim().startsWith("oe")) {
    			labelsRO.add(null);
				labelsIN.add(null);
				labelsIO.add(null);
				labelsO.add(null);
				labelsOINT.add(null);
				labelsCLK.add(null);
				labelsOE.add(o.trim());
    		} else if (o.trim().startsWith("io")) {
    			labelsRO.add(null);
				labelsIN.add(null);
				labelsIO.add(o.trim());
				labelsO.add(null);
				labelsOINT.add(o.trim());
				labelsCLK.add(null);
				labelsOE.add(null);
    		} else if (o.trim().startsWith("ro")) {
    			labelsRO.add(o.trim());
				labelsIN.add(null);
				labelsIO.add(null);
				labelsO.add(null);
				labelsOINT.add(o.trim());
				labelsCLK.add(null);
				labelsOE.add(null);
    		} else if (o.trim().startsWith("o")) {
    			labelsRO.add(null);
				labelsIN.add(null);
				labelsIO.add(null);
				labelsO.add(o.trim());
				labelsOINT.add(o.trim());
				labelsCLK.add(null);
				labelsOE.add(null);
    		} else if (o.trim().startsWith("i")) {
    			labelsRO.add(null);
				labelsIN.add(o.trim());
				labelsIO.add(null);
				labelsO.add(null);
				labelsOINT.add(null);
				labelsCLK.add(null);
				labelsOE.add(null);
    		}
    	});
    	
    	LABELS_RO = labelsRO.stream().toArray(String[]::new);
    	LABELS_IN = labelsIN.stream().toArray(String[]::new);
    	LABELS_IO = labelsIO.stream().toArray(String[]::new);
    	LABELS_O = labelsO.stream().toArray(String[]::new);
    	LABELS_O_INT = labelsOINT.stream().toArray(String[]::new);
    	LABELS_CLK = labelsCLK.stream().toArray(String[]::new);
    	LABELS_OE = labelsOE.stream().toArray(String[]::new);
    }
    
    private int getHexMask(String[] arr) {
    	return this.getHexMask(arr, 0);
    }
    
    private int getHexMask(String[] arr, int startIdx) {
    	StringBuffer bitMask = new StringBuffer();
    	Arrays.asList(arr).subList(startIdx, arr.length).forEach(o -> {
    		if (o != null) {
    			bitMask.append("1");   			
    		} else {
    			bitMask.append("0");
    		}
    	});
    	
    	return bitMask.isEmpty() ? 0 : Integer.parseInt(bitMask.reverse().toString(), 2);
    }
    
    private int getMaskSize(String[] arr) {
    	return Long.valueOf(Arrays.asList(arr).stream().filter(o -> o != null).count()).intValue();
    }
    
    @Override
    public String toString() {
        return "PAL"+PAL_TYPE;
    }

    @Override
    public boolean isActiveLow() {
        return true;
    }

    @Override
    public boolean isVariable() {
        return true;
    }

    @Override
    public int getMask_CLK() {
        return this.getHexMask(LABELS_CLK);
    }

    @Override
    public int getMask_OE() {
        return this.getHexMask(LABELS_OE);
    }

    @Override
    public int getMask_IN() {
        return this.getHexMask(LABELS_IN);
    }

    @SuppressWarnings("unlikely-arg-type")
	@Override
    public int getMask_IO_R() {
        return this.getHexMask(LABELS_IO, Arrays.asList(LABELS_O_INT).indexOf(Arrays.asList(LABELS_O_INT).stream().filter(o -> o != null).findFirst()));
    }

    @Override
    public int getMask_IO_W() {
        return this.getHexMask(LABELS_IO);
    }

    @SuppressWarnings("unlikely-arg-type")
	@Override
    public int getMask_RO_R() {
        return this.getHexMask(LABELS_RO, Arrays.asList(LABELS_O_INT).indexOf(Arrays.asList(LABELS_O_INT).stream().filter(o -> o != null).findFirst()));
    }

    @Override
    public int getMask_RO_W() {
        return this.getHexMask(LABELS_RO);
    }

    @SuppressWarnings("unlikely-arg-type")
	@Override
    public int getMask_O_R() {
        return this.getHexMask(LABELS_O, Arrays.asList(LABELS_O_INT).indexOf(Arrays.asList(LABELS_O_INT).stream().filter(o -> o != null).findFirst()));
    }

    @Override
    public int getMask_O_W() {
        return this.getHexMask(LABELS_O);
    }

    @Override
    public String[] getLabels_RO() {
        return LABELS_RO;
    }

    @Override
    public String[] getLabels_O() {
        return LABELS_O;
    }

    @Override
    public String[] getLabels_IO() {
        return LABELS_IO;
    }

    @Override
    public String[] getLabels_IN() {
        return LABELS_IN;
    }

    @Override
    public int getPinCount_IN() {
        return this.getMaskSize(LABELS_IN);
    }

    @Override
    public int getPinCount_IO() {
        return this.getMaskSize(LABELS_IO);
    }

    @Override
    public int getPinCount_O() {
        return this.getMaskSize(LABELS_O);
    }

    @Override
    public int getPinCount_RO() {
        return this.getMaskSize(LABELS_RO);
    }

    @Override
    public int minimumBoardRev() {
        return 1;
    }

    @Override
    public int slotNumber() {
        return 0;
    }

	@Override
	public boolean isDiscardFeedbacks() {
		return false;
	}

	@Override
	public int getIoAsOutMask() {
		return 0x00;
	}
}