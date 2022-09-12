package info.hkzlab.dupal.analyzer;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

import info.hkzlab.dupal.analyzer.devices.PAL16L8Specs;
import info.hkzlab.dupal.analyzer.devices.PAL16V8Specs;
import info.hkzlab.dupal.analyzer.devices.PAL20L8Specs;
import info.hkzlab.dupal.analyzer.devices.PAL20V8Specs;
import info.hkzlab.dupal.analyzer.devices.PALSpecs;

public class DevicesTest 
{
    @Test
    public void discardFeedbacksAllOutputsPal16l8Features() {
    	
    	/* ***************** Initialized for discard All Feedbacks and All Outputs configuration PAL ***************** */
    	String[] LABELS_IN = { "i1", "i2", "i3", "i4", "i5", "i6", "i7", "i8", "i9", "i11", null, null, null, null, null, null, null, null };
    	String[] LABELS_IO = {};
    	String[] LABELS_RO = {};
    	String[] LABELS_O  = { null, null, null, null, null, null, null, null, null, null, "o18", "o17", "o16", "o15", "o14", "o13", "o19", "o12" };

    	// All IOs as Outputs:
    	int ioAsOutputMask = 0x3F;

    	PALSpecs discardFeedbacksAllOutputsPal16l8 = new PAL16L8Specs(ioAsOutputMask);
    	int discardFeedbacksAllOutputsBitMaskCLK  = Integer.parseInt(new StringBuffer("0 00000000 0 00000000".replace(" ", "")).reverse().toString(), 2);
    	int discardFeedbacksAllOutputsBitMaskOE   = Integer.parseInt(new StringBuffer("0 00000000 0 00000000".replace(" ", "")).reverse().toString(), 2);
    	int discardFeedbacksAllOutputsBitMaskIN   = Integer.parseInt(new StringBuffer("1 11111111 1 00000000".replace(" ", "")).reverse().toString(), 2);
    	int discardFeedbacksAllOutputsBitMaskIO_R = Integer.parseInt(new StringBuffer("             00000000".replace(" ", "")).reverse().toString(), 2);
    	int discardFeedbacksAllOutputsBitMaskIO_W = Integer.parseInt(new StringBuffer("0 00000000 0 00000000".replace(" ", "")).reverse().toString(), 2);
    	int discardFeedbacksAllOutputsBitMaskRO_R = Integer.parseInt(new StringBuffer("             00000000".replace(" ", "")).reverse().toString(), 2);
    	int discardFeedbacksAllOutputsBitMaskRO_W = Integer.parseInt(new StringBuffer("0 00000000 0 00000000".replace(" ", "")).reverse().toString(), 2);
    	int discardFeedbacksAllOutputsBitMaskO_R  = Integer.parseInt(new StringBuffer("             11111111".replace(" ", "")).reverse().toString(), 2);
    	int discardFeedbacksAllOutputsBitMaskO_W  = Integer.parseInt(new StringBuffer("0 00000000 0 11111111".replace(" ", "")).reverse().toString(), 2);

        assertEquals("A PAL16L8 should not be variable", false, discardFeedbacksAllOutputsPal16l8.isVariable());
        
        assertEquals(String.format("Discard Feedbacks All Outputs PAL16L8  CLK Mask should be: 0x%05X, and it's: 0x%05X", discardFeedbacksAllOutputsBitMaskCLK,  discardFeedbacksAllOutputsPal16l8.getMask_CLK()),  discardFeedbacksAllOutputsBitMaskCLK,  discardFeedbacksAllOutputsPal16l8.getMask_CLK());
        assertEquals(String.format("Discard Feedbacks All Outputs PAL16L8   OE Mask should be: 0x%05X, and it's: 0x%05X", discardFeedbacksAllOutputsBitMaskOE,   discardFeedbacksAllOutputsPal16l8.getMask_OE()),   discardFeedbacksAllOutputsBitMaskOE,   discardFeedbacksAllOutputsPal16l8.getMask_OE());
        assertEquals(String.format("Discard Feedbacks All Outputs PAL16L8   IN Mask should be: 0x%05X, and it's: 0x%05X", discardFeedbacksAllOutputsBitMaskIN,   discardFeedbacksAllOutputsPal16l8.getMask_IN()),   discardFeedbacksAllOutputsBitMaskIN,   discardFeedbacksAllOutputsPal16l8.getMask_IN());
        assertEquals(String.format("Discard Feedbacks All Outputs PAL16L8 IO_R Mask should be: 0x%05X, and it's: 0x%05X", discardFeedbacksAllOutputsBitMaskIO_R, discardFeedbacksAllOutputsPal16l8.getMask_IO_R()), discardFeedbacksAllOutputsBitMaskIO_R, discardFeedbacksAllOutputsPal16l8.getMask_IO_R());
        assertEquals(String.format("Discard Feedbacks All Outputs PAL16L8 IO_W Mask should be: 0x%05X, and it's: 0x%05X", discardFeedbacksAllOutputsBitMaskIO_W, discardFeedbacksAllOutputsPal16l8.getMask_IO_W()), discardFeedbacksAllOutputsBitMaskIO_W, discardFeedbacksAllOutputsPal16l8.getMask_IO_W());
        assertEquals(String.format("Discard Feedbacks All Outputs PAL16L8 RO_R Mask should be: 0x%05X, and it's: 0x%05X", discardFeedbacksAllOutputsBitMaskRO_R, discardFeedbacksAllOutputsPal16l8.getMask_RO_R()), discardFeedbacksAllOutputsBitMaskRO_R, discardFeedbacksAllOutputsPal16l8.getMask_RO_R());
        assertEquals(String.format("Discard Feedbacks All Outputs PAL16L8 RO_W Mask should be: 0x%05X, and it's: 0x%05X", discardFeedbacksAllOutputsBitMaskRO_W, discardFeedbacksAllOutputsPal16l8.getMask_RO_W()), discardFeedbacksAllOutputsBitMaskRO_W, discardFeedbacksAllOutputsPal16l8.getMask_RO_W());
        assertEquals(String.format("Discard Feedbacks All Outputs PAL16L8  O_R Mask should be: 0x%05X, and it's: 0x%05X", discardFeedbacksAllOutputsBitMaskO_R,  discardFeedbacksAllOutputsPal16l8.getMask_O_R()),  discardFeedbacksAllOutputsBitMaskO_R,  discardFeedbacksAllOutputsPal16l8.getMask_O_R());
        assertEquals(String.format("Discard Feedbacks All Outputs PAL16L8  O_W Mask should be: 0x%05X, and it's: 0x%05X", discardFeedbacksAllOutputsBitMaskO_W,  discardFeedbacksAllOutputsPal16l8.getMask_O_W()),  discardFeedbacksAllOutputsBitMaskO_W,  discardFeedbacksAllOutputsPal16l8.getMask_O_W());

        assertArrayEquals(String.format("Discard Feedbacks All Outputs PAL16L8 LABELS_IN should be: %s, and it's: %S", Arrays.toString(LABELS_IN), Arrays.toString(discardFeedbacksAllOutputsPal16l8.getLabels_IN())), LABELS_IN, discardFeedbacksAllOutputsPal16l8.getLabels_IN());
        assertArrayEquals(String.format("Discard Feedbacks All Outputs PAL16L8 LABELS_IO should be: %s, and it's: %S", Arrays.toString(LABELS_IO), Arrays.toString(discardFeedbacksAllOutputsPal16l8.getLabels_IO())), LABELS_IO, discardFeedbacksAllOutputsPal16l8.getLabels_IO());
        assertArrayEquals(String.format("Discard Feedbacks All Outputs PAL16L8 LABELS_RO should be: %s, and it's: %S", Arrays.toString(LABELS_RO), Arrays.toString(discardFeedbacksAllOutputsPal16l8.getLabels_RO())), LABELS_RO, discardFeedbacksAllOutputsPal16l8.getLabels_RO());
        assertArrayEquals(String.format("Discard Feedbacks All Outputs PAL16L8  LABELS_O should be: %s, and it's: %S", Arrays.toString(LABELS_O),  Arrays.toString(discardFeedbacksAllOutputsPal16l8.getLabels_O())),  LABELS_O,  discardFeedbacksAllOutputsPal16l8.getLabels_O());

        assertEquals(String.format("Discard Feedbacks All Outputs PAL16L8 Pin Count IN should be: %d, and it's: %d", 10, discardFeedbacksAllOutputsPal16l8.getPinCount_IN()), 10, discardFeedbacksAllOutputsPal16l8.getPinCount_IN());
        assertEquals(String.format("Discard Feedbacks All Outputs PAL16L8 Pin Count IO should be: %d, and it's: %d",  0, discardFeedbacksAllOutputsPal16l8.getPinCount_IO()),  0, discardFeedbacksAllOutputsPal16l8.getPinCount_IO());
        assertEquals(String.format("Discard Feedbacks All Outputs PAL16L8 Pin Count RO should be: %d, and it's: %d",  0, discardFeedbacksAllOutputsPal16l8.getPinCount_RO()),  0, discardFeedbacksAllOutputsPal16l8.getPinCount_RO());
        assertEquals(String.format("Discard Feedbacks All Outputs PAL16L8 Pin Count  O should be: %d, and it's: %d",  8, discardFeedbacksAllOutputsPal16l8.getPinCount_O()),   8, discardFeedbacksAllOutputsPal16l8.getPinCount_O());
    }

    @Test
    public void discardFeedbacksAllInputsPal16l8Features() {
    	
    	/* ***************** Initialized for discard All Feedbacks and All Inputs configuration PAL ***************** */
    	String[] LABELS_IN = { "i1", "i2", "i3", "i4", "i5", "i6", "i7", "i8", "i9", "i11", "i18", "i17", "i16", "i15", "i14", "i13", null, null};
    	String[] LABELS_IO = {};
    	String[] LABELS_RO = {};
    	String[] LABELS_O  = { null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,        "o19", "o12" };

    	// All IOs as Inputs:
    	int ioAsOutputMask = 0x00;

    	PALSpecs discardFeedbacksAllInputsPal16l8 = new PAL16L8Specs(ioAsOutputMask);
    	int discardFeedbacksAllInputsBitMaskCLK  = Integer.parseInt(new StringBuffer("0 00000000 0 00000000".replace(" ", "")).reverse().toString(), 2);
    	int discardFeedbacksAllInputsBitMaskOE   = Integer.parseInt(new StringBuffer("0 00000000 0 00000000".replace(" ", "")).reverse().toString(), 2);
    	int discardFeedbacksAllInputsBitMaskIN   = Integer.parseInt(new StringBuffer("1 11111111 1 11111100".replace(" ", "")).reverse().toString(), 2);
    	int discardFeedbacksAllInputsBitMaskIO_R = Integer.parseInt(new StringBuffer("             00000000".replace(" ", "")).reverse().toString(), 2);
    	int discardFeedbacksAllInputsBitMaskIO_W = Integer.parseInt(new StringBuffer("0 00000000 0 00000000".replace(" ", "")).reverse().toString(), 2);
    	int discardFeedbacksAllInputsBitMaskRO_R = Integer.parseInt(new StringBuffer("             00000000".replace(" ", "")).reverse().toString(), 2);
    	int discardFeedbacksAllInputsBitMaskRO_W = Integer.parseInt(new StringBuffer("0 00000000 0 00000000".replace(" ", "")).reverse().toString(), 2);
    	int discardFeedbacksAllInputsBitMaskO_R  = Integer.parseInt(new StringBuffer("             00000011".replace(" ", "")).reverse().toString(), 2);
    	int discardFeedbacksAllInputsBitMaskO_W  = Integer.parseInt(new StringBuffer("0 00000000 0 00000011".replace(" ", "")).reverse().toString(), 2);

        assertEquals("A PAL16L8 should not be variable", false, discardFeedbacksAllInputsPal16l8.isVariable());
        
        assertEquals(String.format("Discard Feedbacks All Inputs PAL16L8  CLK Mask should be: 0x%05X, and it's: 0x%05X", discardFeedbacksAllInputsBitMaskCLK,  discardFeedbacksAllInputsPal16l8.getMask_CLK()),  discardFeedbacksAllInputsBitMaskCLK,  discardFeedbacksAllInputsPal16l8.getMask_CLK());
        assertEquals(String.format("Discard Feedbacks All Inputs PAL16L8   OE Mask should be: 0x%05X, and it's: 0x%05X", discardFeedbacksAllInputsBitMaskOE,   discardFeedbacksAllInputsPal16l8.getMask_OE()),   discardFeedbacksAllInputsBitMaskOE,   discardFeedbacksAllInputsPal16l8.getMask_OE());
        assertEquals(String.format("Discard Feedbacks All Inputs PAL16L8   IN Mask should be: 0x%05X, and it's: 0x%05X", discardFeedbacksAllInputsBitMaskIN,   discardFeedbacksAllInputsPal16l8.getMask_IN()),   discardFeedbacksAllInputsBitMaskIN,   discardFeedbacksAllInputsPal16l8.getMask_IN());
        assertEquals(String.format("Discard Feedbacks All Inputs PAL16L8 IO_R Mask should be: 0x%05X, and it's: 0x%05X", discardFeedbacksAllInputsBitMaskIO_R, discardFeedbacksAllInputsPal16l8.getMask_IO_R()), discardFeedbacksAllInputsBitMaskIO_R, discardFeedbacksAllInputsPal16l8.getMask_IO_R());
        assertEquals(String.format("Discard Feedbacks All Inputs PAL16L8 IO_W Mask should be: 0x%05X, and it's: 0x%05X", discardFeedbacksAllInputsBitMaskIO_W, discardFeedbacksAllInputsPal16l8.getMask_IO_W()), discardFeedbacksAllInputsBitMaskIO_W, discardFeedbacksAllInputsPal16l8.getMask_IO_W());
        assertEquals(String.format("Discard Feedbacks All Inputs PAL16L8 RO_R Mask should be: 0x%05X, and it's: 0x%05X", discardFeedbacksAllInputsBitMaskRO_R, discardFeedbacksAllInputsPal16l8.getMask_RO_R()), discardFeedbacksAllInputsBitMaskRO_R, discardFeedbacksAllInputsPal16l8.getMask_RO_R());
        assertEquals(String.format("Discard Feedbacks All Inputs PAL16L8 RO_W Mask should be: 0x%05X, and it's: 0x%05X", discardFeedbacksAllInputsBitMaskRO_W, discardFeedbacksAllInputsPal16l8.getMask_RO_W()), discardFeedbacksAllInputsBitMaskRO_W, discardFeedbacksAllInputsPal16l8.getMask_RO_W());
        assertEquals(String.format("Discard Feedbacks All Inputs PAL16L8  O_R Mask should be: 0x%05X, and it's: 0x%05X", discardFeedbacksAllInputsBitMaskO_R,  discardFeedbacksAllInputsPal16l8.getMask_O_R()),  discardFeedbacksAllInputsBitMaskO_R,  discardFeedbacksAllInputsPal16l8.getMask_O_R());
        assertEquals(String.format("Discard Feedbacks All Inputs PAL16L8  O_W Mask should be: 0x%05X, and it's: 0x%05X", discardFeedbacksAllInputsBitMaskO_W,  discardFeedbacksAllInputsPal16l8.getMask_O_W()),  discardFeedbacksAllInputsBitMaskO_W,  discardFeedbacksAllInputsPal16l8.getMask_O_W());

        assertArrayEquals(String.format("Discard Feedbacks All Inputs PAL16L8 LABELS_IN should be: %s, and it's: %S", Arrays.toString(LABELS_IN), Arrays.toString(discardFeedbacksAllInputsPal16l8.getLabels_IN())), LABELS_IN, discardFeedbacksAllInputsPal16l8.getLabels_IN());
        assertArrayEquals(String.format("Discard Feedbacks All Inputs PAL16L8 LABELS_IO should be: %s, and it's: %S", Arrays.toString(LABELS_IO), Arrays.toString(discardFeedbacksAllInputsPal16l8.getLabels_IO())), LABELS_IO, discardFeedbacksAllInputsPal16l8.getLabels_IO());
        assertArrayEquals(String.format("Discard Feedbacks All Inputs PAL16L8 LABELS_RO should be: %s, and it's: %S", Arrays.toString(LABELS_RO), Arrays.toString(discardFeedbacksAllInputsPal16l8.getLabels_RO())), LABELS_RO, discardFeedbacksAllInputsPal16l8.getLabels_RO());
        assertArrayEquals(String.format("Discard Feedbacks All Inputs PAL16L8  LABELS_O should be: %s, and it's: %S", Arrays.toString(LABELS_O),  Arrays.toString(discardFeedbacksAllInputsPal16l8.getLabels_O())),  LABELS_O,  discardFeedbacksAllInputsPal16l8.getLabels_O());

        assertEquals(String.format("Discard Feedbacks All Inputs PAL16L8 Pin Count IN should be: %d, and it's: %d", 16, discardFeedbacksAllInputsPal16l8.getPinCount_IN()), 16, discardFeedbacksAllInputsPal16l8.getPinCount_IN());
        assertEquals(String.format("Discard Feedbacks All Inputs PAL16L8 Pin Count IO should be: %d, and it's: %d",  0, discardFeedbacksAllInputsPal16l8.getPinCount_IO()),  0, discardFeedbacksAllInputsPal16l8.getPinCount_IO());
        assertEquals(String.format("Discard Feedbacks All Inputs PAL16L8 Pin Count RO should be: %d, and it's: %d",  0, discardFeedbacksAllInputsPal16l8.getPinCount_RO()),  0, discardFeedbacksAllInputsPal16l8.getPinCount_RO());
        assertEquals(String.format("Discard Feedbacks All Inputs PAL16L8 Pin Count  O should be: %d, and it's: %d",  2, discardFeedbacksAllInputsPal16l8.getPinCount_O()),   2, discardFeedbacksAllInputsPal16l8.getPinCount_O());
    }

    @Test
    public void discardFeedbacksMixedInputsAndOutputsPal16l8Features() {
    	
    	/* ***************** Initialized for discard All Feedbacks and Mixed Inputs and Outputs configuration PAL ***************** */
    	String[] LABELS_IN = { "i1", "i2", "i3", "i4", "i5", "i6", "i7", "i8", "i9", "i11", null, "i17", "i16", null, "i14", "i13", null, null };
    	String[] LABELS_IO = {};
    	String[] LABELS_RO = {};
    	String[] LABELS_O  = { null, null, null, null, null, null, null, null, null, null, "o18", null, null, "o15", null, null, "o19", "o12" };

    	// Mixed IOs as Inputs and Outputs:
    	int ioAsOutputMask = 0x09;

    	PALSpecs discardFeedbacksMixedInputsAndOutputsPal16l8 = new PAL16L8Specs(ioAsOutputMask);
    	int discardFeedbacksMixedInputsAndOutputsBitMaskCLK  = Integer.parseInt(new StringBuffer("0 00000000 0 00000000".replace(" ", "")).reverse().toString(), 2);
    	int discardFeedbacksMixedInputsAndOutputsBitMaskOE   = Integer.parseInt(new StringBuffer("0 00000000 0 00000000".replace(" ", "")).reverse().toString(), 2);
    	int discardFeedbacksMixedInputsAndOutputsBitMaskIN   = Integer.parseInt(new StringBuffer("1 11111111 1 01101100".replace(" ", "")).reverse().toString(), 2);
    	int discardFeedbacksMixedInputsAndOutputsBitMaskIO_R = Integer.parseInt(new StringBuffer("             00000000".replace(" ", "")).reverse().toString(), 2);
    	int discardFeedbacksMixedInputsAndOutputsBitMaskIO_W = Integer.parseInt(new StringBuffer("0 00000000 0 00000000".replace(" ", "")).reverse().toString(), 2);
    	int discardFeedbacksMixedInputsAndOutputsBitMaskRO_R = Integer.parseInt(new StringBuffer("             00000000".replace(" ", "")).reverse().toString(), 2);
    	int discardFeedbacksMixedInputsAndOutputsBitMaskRO_W = Integer.parseInt(new StringBuffer("0 00000000 0 00000000".replace(" ", "")).reverse().toString(), 2);
    	int discardFeedbacksMixedInputsAndOutputsBitMaskO_R  = Integer.parseInt(new StringBuffer("             10010011".replace(" ", "")).reverse().toString(), 2);
    	int discardFeedbacksMixedInputsAndOutputsBitMaskO_W  = Integer.parseInt(new StringBuffer("0 00000000 0 10010011".replace(" ", "")).reverse().toString(), 2);

        assertEquals("A PAL16L8 should not be variable", false, discardFeedbacksMixedInputsAndOutputsPal16l8.isVariable());
        
        assertEquals(String.format("Discard Feedbacks Mixed Inputs And Outputs PAL16L8  CLK Mask should be: 0x%05X, and it's: 0x%05X", discardFeedbacksMixedInputsAndOutputsBitMaskCLK,  discardFeedbacksMixedInputsAndOutputsPal16l8.getMask_CLK()),  discardFeedbacksMixedInputsAndOutputsBitMaskCLK,  discardFeedbacksMixedInputsAndOutputsPal16l8.getMask_CLK());
        assertEquals(String.format("Discard Feedbacks Mixed Inputs And Outputs PAL16L8   OE Mask should be: 0x%05X, and it's: 0x%05X", discardFeedbacksMixedInputsAndOutputsBitMaskOE,   discardFeedbacksMixedInputsAndOutputsPal16l8.getMask_OE()),   discardFeedbacksMixedInputsAndOutputsBitMaskOE,   discardFeedbacksMixedInputsAndOutputsPal16l8.getMask_OE());
        assertEquals(String.format("Discard Feedbacks Mixed Inputs And Outputs PAL16L8   IN Mask should be: 0x%05X, and it's: 0x%05X", discardFeedbacksMixedInputsAndOutputsBitMaskIN,   discardFeedbacksMixedInputsAndOutputsPal16l8.getMask_IN()),   discardFeedbacksMixedInputsAndOutputsBitMaskIN,   discardFeedbacksMixedInputsAndOutputsPal16l8.getMask_IN());
        assertEquals(String.format("Discard Feedbacks Mixed Inputs And Outputs PAL16L8 IO_R Mask should be: 0x%05X, and it's: 0x%05X", discardFeedbacksMixedInputsAndOutputsBitMaskIO_R, discardFeedbacksMixedInputsAndOutputsPal16l8.getMask_IO_R()), discardFeedbacksMixedInputsAndOutputsBitMaskIO_R, discardFeedbacksMixedInputsAndOutputsPal16l8.getMask_IO_R());
        assertEquals(String.format("Discard Feedbacks Mixed Inputs And Outputs PAL16L8 IO_W Mask should be: 0x%05X, and it's: 0x%05X", discardFeedbacksMixedInputsAndOutputsBitMaskIO_W, discardFeedbacksMixedInputsAndOutputsPal16l8.getMask_IO_W()), discardFeedbacksMixedInputsAndOutputsBitMaskIO_W, discardFeedbacksMixedInputsAndOutputsPal16l8.getMask_IO_W());
        assertEquals(String.format("Discard Feedbacks Mixed Inputs And Outputs PAL16L8 RO_R Mask should be: 0x%05X, and it's: 0x%05X", discardFeedbacksMixedInputsAndOutputsBitMaskRO_R, discardFeedbacksMixedInputsAndOutputsPal16l8.getMask_RO_R()), discardFeedbacksMixedInputsAndOutputsBitMaskRO_R, discardFeedbacksMixedInputsAndOutputsPal16l8.getMask_RO_R());
        assertEquals(String.format("Discard Feedbacks Mixed Inputs And Outputs PAL16L8 RO_W Mask should be: 0x%05X, and it's: 0x%05X", discardFeedbacksMixedInputsAndOutputsBitMaskRO_W, discardFeedbacksMixedInputsAndOutputsPal16l8.getMask_RO_W()), discardFeedbacksMixedInputsAndOutputsBitMaskRO_W, discardFeedbacksMixedInputsAndOutputsPal16l8.getMask_RO_W());
        assertEquals(String.format("Discard Feedbacks Mixed Inputs And Outputs PAL16L8  O_R Mask should be: 0x%05X, and it's: 0x%05X", discardFeedbacksMixedInputsAndOutputsBitMaskO_R,  discardFeedbacksMixedInputsAndOutputsPal16l8.getMask_O_R()),  discardFeedbacksMixedInputsAndOutputsBitMaskO_R,  discardFeedbacksMixedInputsAndOutputsPal16l8.getMask_O_R());
        assertEquals(String.format("Discard Feedbacks Mixed Inputs And Outputs PAL16L8  O_W Mask should be: 0x%05X, and it's: 0x%05X", discardFeedbacksMixedInputsAndOutputsBitMaskO_W,  discardFeedbacksMixedInputsAndOutputsPal16l8.getMask_O_W()),  discardFeedbacksMixedInputsAndOutputsBitMaskO_W,  discardFeedbacksMixedInputsAndOutputsPal16l8.getMask_O_W());

        assertArrayEquals(String.format("Discard Feedbacks Mixed Inputs And Outputs PAL16L8 LABELS_IN should be: %s, and it's: %S", Arrays.toString(LABELS_IN), Arrays.toString(discardFeedbacksMixedInputsAndOutputsPal16l8.getLabels_IN())), LABELS_IN, discardFeedbacksMixedInputsAndOutputsPal16l8.getLabels_IN());
        assertArrayEquals(String.format("Discard Feedbacks Mixed Inputs And Outputs PAL16L8 LABELS_IO should be: %s, and it's: %S", Arrays.toString(LABELS_IO), Arrays.toString(discardFeedbacksMixedInputsAndOutputsPal16l8.getLabels_IO())), LABELS_IO, discardFeedbacksMixedInputsAndOutputsPal16l8.getLabels_IO());
        assertArrayEquals(String.format("Discard Feedbacks Mixed Inputs And Outputs PAL16L8 LABELS_RO should be: %s, and it's: %S", Arrays.toString(LABELS_RO), Arrays.toString(discardFeedbacksMixedInputsAndOutputsPal16l8.getLabels_RO())), LABELS_RO, discardFeedbacksMixedInputsAndOutputsPal16l8.getLabels_RO());
        assertArrayEquals(String.format("Discard Feedbacks Mixed Inputs And Outputs PAL16L8  LABELS_O should be: %s, and it's: %S", Arrays.toString(LABELS_O),  Arrays.toString(discardFeedbacksMixedInputsAndOutputsPal16l8.getLabels_O())),  LABELS_O,  discardFeedbacksMixedInputsAndOutputsPal16l8.getLabels_O());

        assertEquals(String.format("Discard Feedbacks Mixed Inputs And Outputs PAL16L8 Pin Count IN should be: %d, and it's: %d", 14, discardFeedbacksMixedInputsAndOutputsPal16l8.getPinCount_IN()), 14, discardFeedbacksMixedInputsAndOutputsPal16l8.getPinCount_IN());
        assertEquals(String.format("Discard Feedbacks Mixed Inputs And Outputs PAL16L8 Pin Count IO should be: %d, and it's: %d",  0, discardFeedbacksMixedInputsAndOutputsPal16l8.getPinCount_IO()),  0, discardFeedbacksMixedInputsAndOutputsPal16l8.getPinCount_IO());
        assertEquals(String.format("Discard Feedbacks Mixed Inputs And Outputs PAL16L8 Pin Count RO should be: %d, and it's: %d",  0, discardFeedbacksMixedInputsAndOutputsPal16l8.getPinCount_RO()),  0, discardFeedbacksMixedInputsAndOutputsPal16l8.getPinCount_RO());
        assertEquals(String.format("Discard Feedbacks Mixed Inputs And Outputs PAL16L8 Pin Count  O should be: %d, and it's: %d",  4, discardFeedbacksMixedInputsAndOutputsPal16l8.getPinCount_O()),   4, discardFeedbacksMixedInputsAndOutputsPal16l8.getPinCount_O());
    }

    @Test
    public void pureCombinatorialPal16v8Features() {
    	
    	/* ***************** Initialized for pure combinatorial configuration PAL ***************** */
    	String[] LABELS_IN = { "i1", "i2", "i3", "i4", "i5", "i6", "i7", "i8", "i9", "i11", null, null, null, null, null, null, null, null };
    	String[] LABELS_IO = { null, null, null, null, null, null, null, null, null, null, "io18", "io17", "io16", "io15", "io14", "io13", "io19", "io12" };
    	String[] LABELS_RO = {};
    	String[] LABELS_O  = {};

    	PALSpecs pureCombinatorialPal16v8 = new PAL16V8Specs();
    	int pureCombinatorialBitMaskCLK  = Integer.parseInt(new StringBuffer("0 00000000 0 00000000".replace(" ", "")).reverse().toString(), 2);
    	int pureCombinatorialBitMaskOE   = Integer.parseInt(new StringBuffer("0 00000000 0 00000000".replace(" ", "")).reverse().toString(), 2);
    	int pureCombinatorialBitMaskIN   = Integer.parseInt(new StringBuffer("1 11111111 1 00000000".replace(" ", "")).reverse().toString(), 2);
    	int pureCombinatorialBitMaskIO_R = Integer.parseInt(new StringBuffer("             11111111".replace(" ", "")).reverse().toString(), 2);
    	int pureCombinatorialBitMaskIO_W = Integer.parseInt(new StringBuffer("0 00000000 0 11111111".replace(" ", "")).reverse().toString(), 2);
    	int pureCombinatorialBitMaskRO_R = Integer.parseInt(new StringBuffer("             00000000".replace(" ", "")).reverse().toString(), 2);
    	int pureCombinatorialBitMaskRO_W = Integer.parseInt(new StringBuffer("0 00000000 0 00000000".replace(" ", "")).reverse().toString(), 2);
    	int pureCombinatorialBitMaskO_R  = Integer.parseInt(new StringBuffer("             00000000".replace(" ", "")).reverse().toString(), 2);
    	int pureCombinatorialBitMaskO_W  = Integer.parseInt(new StringBuffer("0 00000000 0 00000000".replace(" ", "")).reverse().toString(), 2);

        assertEquals("A PAL16V8 should be variable", true, pureCombinatorialPal16v8.isVariable());
        
        assertEquals(String.format("Pure Combinatorial PAL16V8  CLK Mask should be: 0x%05X, and it's: 0x%05X", pureCombinatorialBitMaskCLK,  pureCombinatorialPal16v8.getMask_CLK()),  pureCombinatorialBitMaskCLK,  pureCombinatorialPal16v8.getMask_CLK());
        assertEquals(String.format("Pure Combinatorial PAL16V8   OE Mask should be: 0x%05X, and it's: 0x%05X", pureCombinatorialBitMaskOE,   pureCombinatorialPal16v8.getMask_OE()),   pureCombinatorialBitMaskOE,   pureCombinatorialPal16v8.getMask_OE());
        assertEquals(String.format("Pure Combinatorial PAL16V8   IN Mask should be: 0x%05X, and it's: 0x%05X", pureCombinatorialBitMaskIN,   pureCombinatorialPal16v8.getMask_IN()),   pureCombinatorialBitMaskIN,   pureCombinatorialPal16v8.getMask_IN());
        assertEquals(String.format("Pure Combinatorial PAL16V8 IO_R Mask should be: 0x%05X, and it's: 0x%05X", pureCombinatorialBitMaskIO_R, pureCombinatorialPal16v8.getMask_IO_R()), pureCombinatorialBitMaskIO_R, pureCombinatorialPal16v8.getMask_IO_R());
        assertEquals(String.format("Pure Combinatorial PAL16V8 IO_W Mask should be: 0x%05X, and it's: 0x%05X", pureCombinatorialBitMaskIO_W, pureCombinatorialPal16v8.getMask_IO_W()), pureCombinatorialBitMaskIO_W, pureCombinatorialPal16v8.getMask_IO_W());
        assertEquals(String.format("Pure Combinatorial PAL16V8 RO_R Mask should be: 0x%05X, and it's: 0x%05X", pureCombinatorialBitMaskRO_R, pureCombinatorialPal16v8.getMask_RO_R()), pureCombinatorialBitMaskRO_R, pureCombinatorialPal16v8.getMask_RO_R());
        assertEquals(String.format("Pure Combinatorial PAL16V8 RO_W Mask should be: 0x%05X, and it's: 0x%05X", pureCombinatorialBitMaskRO_W, pureCombinatorialPal16v8.getMask_RO_W()), pureCombinatorialBitMaskRO_W, pureCombinatorialPal16v8.getMask_RO_W());
        assertEquals(String.format("Pure Combinatorial PAL16V8  O_R Mask should be: 0x%05X, and it's: 0x%05X", pureCombinatorialBitMaskO_R,  pureCombinatorialPal16v8.getMask_O_R()),  pureCombinatorialBitMaskO_R,  pureCombinatorialPal16v8.getMask_O_R());
        assertEquals(String.format("Pure Combinatorial PAL16V8  O_W Mask should be: 0x%05X, and it's: 0x%05X", pureCombinatorialBitMaskO_W,  pureCombinatorialPal16v8.getMask_O_W()),  pureCombinatorialBitMaskO_W,  pureCombinatorialPal16v8.getMask_O_W());

        assertArrayEquals(String.format("Pure Combinatorial PAL16V8 LABELS_IN should be: %s, and it's: %S", Arrays.toString(LABELS_IN), Arrays.toString(pureCombinatorialPal16v8.getLabels_IN())), LABELS_IN, pureCombinatorialPal16v8.getLabels_IN());
        assertArrayEquals(String.format("Pure Combinatorial PAL16V8 LABELS_IO should be: %s, and it's: %S", Arrays.toString(LABELS_IO), Arrays.toString(pureCombinatorialPal16v8.getLabels_IO())), LABELS_IO, pureCombinatorialPal16v8.getLabels_IO());
        assertArrayEquals(String.format("Pure Combinatorial PAL16V8 LABELS_RO should be: %s, and it's: %S", Arrays.toString(LABELS_RO), Arrays.toString(pureCombinatorialPal16v8.getLabels_RO())), LABELS_RO, pureCombinatorialPal16v8.getLabels_RO());
        assertArrayEquals(String.format("Pure Combinatorial PAL16V8  LABELS_O should be: %s, and it's: %S", Arrays.toString(LABELS_O),  Arrays.toString(pureCombinatorialPal16v8.getLabels_O())),  LABELS_O,  pureCombinatorialPal16v8.getLabels_O());

        assertEquals(String.format("Pure Combinatorial PAL16V8 Pin Count IN should be: %d, and it's: %d", 10, pureCombinatorialPal16v8.getPinCount_IN()), 10, pureCombinatorialPal16v8.getPinCount_IN());
        assertEquals(String.format("Pure Combinatorial PAL16V8 Pin Count IO should be: %d, and it's: %d",  8, pureCombinatorialPal16v8.getPinCount_IO()),  8, pureCombinatorialPal16v8.getPinCount_IO());
        assertEquals(String.format("Pure Combinatorial PAL16V8 Pin Count RO should be: %d, and it's: %d",  0, pureCombinatorialPal16v8.getPinCount_RO()),  0, pureCombinatorialPal16v8.getPinCount_RO());
        assertEquals(String.format("Pure Combinatorial PAL16V8 Pin Count  O should be: %d, and it's: %d",  0, pureCombinatorialPal16v8.getPinCount_O()),   0, pureCombinatorialPal16v8.getPinCount_O());
    }

    @Test
    public void pureCombinatorialDiscardFeedbacksAllOutputsPal16v8Features() {
    	
    	/* ***************** Initialized for pure combinatorial configuration PAL ***************** */
    	String[] LABELS_IN = { "i1", "i2", "i3", "i4", "i5", "i6", "i7", "i8", "i9", "i11", null, null, null, null, null, null, null, null };
    	String[] LABELS_IO = {};
    	String[] LABELS_RO = {};
    	String[] LABELS_O  = { null, null, null, null, null, null, null, null, null, null, "o18", "o17", "o16", "o15", "o14", "o13", "o19", "o12" };

    	// All IOs as Outputs:
    	int ioAsOutputMask = 0xFF;

    	PALSpecs pureCombinatorialDiscardFeedbacksAllOutputsPal16v8 = new PAL16V8Specs(ioAsOutputMask);
    	int pureCombinatorialDiscardFeedbacksAllOutputsBitMaskCLK  = Integer.parseInt(new StringBuffer("0 00000000 0 00000000".replace(" ", "")).reverse().toString(), 2);
    	int pureCombinatorialDiscardFeedbacksAllOutputsBitMaskOE   = Integer.parseInt(new StringBuffer("0 00000000 0 00000000".replace(" ", "")).reverse().toString(), 2);
    	int pureCombinatorialDiscardFeedbacksAllOutputsBitMaskIN   = Integer.parseInt(new StringBuffer("1 11111111 1 00000000".replace(" ", "")).reverse().toString(), 2);
    	int pureCombinatorialDiscardFeedbacksAllOutputsBitMaskIO_R = Integer.parseInt(new StringBuffer("             00000000".replace(" ", "")).reverse().toString(), 2);
    	int pureCombinatorialDiscardFeedbacksAllOutputsBitMaskIO_W = Integer.parseInt(new StringBuffer("0 00000000 0 00000000".replace(" ", "")).reverse().toString(), 2);
    	int pureCombinatorialDiscardFeedbacksAllOutputsBitMaskRO_R = Integer.parseInt(new StringBuffer("             00000000".replace(" ", "")).reverse().toString(), 2);
    	int pureCombinatorialDiscardFeedbacksAllOutputsBitMaskRO_W = Integer.parseInt(new StringBuffer("0 00000000 0 00000000".replace(" ", "")).reverse().toString(), 2);
    	int pureCombinatorialDiscardFeedbacksAllOutputsBitMaskO_R  = Integer.parseInt(new StringBuffer("             11111111".replace(" ", "")).reverse().toString(), 2);
    	int pureCombinatorialDiscardFeedbacksAllOutputsBitMaskO_W  = Integer.parseInt(new StringBuffer("0 00000000 0 11111111".replace(" ", "")).reverse().toString(), 2);

        assertEquals("A PAL16V8 should be variable", true, pureCombinatorialDiscardFeedbacksAllOutputsPal16v8.isVariable());
        
        assertEquals(String.format("Pure Combinatorial Discard Feedbacks All Outputs PAL16V8  CLK Mask should be: 0x%05X, and it's: 0x%05X", pureCombinatorialDiscardFeedbacksAllOutputsBitMaskCLK,  pureCombinatorialDiscardFeedbacksAllOutputsPal16v8.getMask_CLK()),  pureCombinatorialDiscardFeedbacksAllOutputsBitMaskCLK,  pureCombinatorialDiscardFeedbacksAllOutputsPal16v8.getMask_CLK());
        assertEquals(String.format("Pure Combinatorial Discard Feedbacks All Outputs PAL16V8   OE Mask should be: 0x%05X, and it's: 0x%05X", pureCombinatorialDiscardFeedbacksAllOutputsBitMaskOE,   pureCombinatorialDiscardFeedbacksAllOutputsPal16v8.getMask_OE()),   pureCombinatorialDiscardFeedbacksAllOutputsBitMaskOE,   pureCombinatorialDiscardFeedbacksAllOutputsPal16v8.getMask_OE());
        assertEquals(String.format("Pure Combinatorial Discard Feedbacks All Outputs PAL16V8   IN Mask should be: 0x%05X, and it's: 0x%05X", pureCombinatorialDiscardFeedbacksAllOutputsBitMaskIN,   pureCombinatorialDiscardFeedbacksAllOutputsPal16v8.getMask_IN()),   pureCombinatorialDiscardFeedbacksAllOutputsBitMaskIN,   pureCombinatorialDiscardFeedbacksAllOutputsPal16v8.getMask_IN());
        assertEquals(String.format("Pure Combinatorial Discard Feedbacks All Outputs PAL16V8 IO_R Mask should be: 0x%05X, and it's: 0x%05X", pureCombinatorialDiscardFeedbacksAllOutputsBitMaskIO_R, pureCombinatorialDiscardFeedbacksAllOutputsPal16v8.getMask_IO_R()), pureCombinatorialDiscardFeedbacksAllOutputsBitMaskIO_R, pureCombinatorialDiscardFeedbacksAllOutputsPal16v8.getMask_IO_R());
        assertEquals(String.format("Pure Combinatorial Discard Feedbacks All Outputs PAL16V8 IO_W Mask should be: 0x%05X, and it's: 0x%05X", pureCombinatorialDiscardFeedbacksAllOutputsBitMaskIO_W, pureCombinatorialDiscardFeedbacksAllOutputsPal16v8.getMask_IO_W()), pureCombinatorialDiscardFeedbacksAllOutputsBitMaskIO_W, pureCombinatorialDiscardFeedbacksAllOutputsPal16v8.getMask_IO_W());
        assertEquals(String.format("Pure Combinatorial Discard Feedbacks All Outputs PAL16V8 RO_R Mask should be: 0x%05X, and it's: 0x%05X", pureCombinatorialDiscardFeedbacksAllOutputsBitMaskRO_R, pureCombinatorialDiscardFeedbacksAllOutputsPal16v8.getMask_RO_R()), pureCombinatorialDiscardFeedbacksAllOutputsBitMaskRO_R, pureCombinatorialDiscardFeedbacksAllOutputsPal16v8.getMask_RO_R());
        assertEquals(String.format("Pure Combinatorial Discard Feedbacks All Outputs PAL16V8 RO_W Mask should be: 0x%05X, and it's: 0x%05X", pureCombinatorialDiscardFeedbacksAllOutputsBitMaskRO_W, pureCombinatorialDiscardFeedbacksAllOutputsPal16v8.getMask_RO_W()), pureCombinatorialDiscardFeedbacksAllOutputsBitMaskRO_W, pureCombinatorialDiscardFeedbacksAllOutputsPal16v8.getMask_RO_W());
        assertEquals(String.format("Pure Combinatorial Discard Feedbacks All Outputs PAL16V8  O_R Mask should be: 0x%05X, and it's: 0x%05X", pureCombinatorialDiscardFeedbacksAllOutputsBitMaskO_R,  pureCombinatorialDiscardFeedbacksAllOutputsPal16v8.getMask_O_R()),  pureCombinatorialDiscardFeedbacksAllOutputsBitMaskO_R,  pureCombinatorialDiscardFeedbacksAllOutputsPal16v8.getMask_O_R());
        assertEquals(String.format("Pure Combinatorial Discard Feedbacks All Outputs PAL16V8  O_W Mask should be: 0x%05X, and it's: 0x%05X", pureCombinatorialDiscardFeedbacksAllOutputsBitMaskO_W,  pureCombinatorialDiscardFeedbacksAllOutputsPal16v8.getMask_O_W()),  pureCombinatorialDiscardFeedbacksAllOutputsBitMaskO_W,  pureCombinatorialDiscardFeedbacksAllOutputsPal16v8.getMask_O_W());

        assertArrayEquals(String.format("Pure Combinatorial Discard Feedbacks All Outputs PAL16V8 LABELS_IN should be: %s, and it's: %S", Arrays.toString(LABELS_IN), Arrays.toString(pureCombinatorialDiscardFeedbacksAllOutputsPal16v8.getLabels_IN())), LABELS_IN, pureCombinatorialDiscardFeedbacksAllOutputsPal16v8.getLabels_IN());
        assertArrayEquals(String.format("Pure Combinatorial Discard Feedbacks All Outputs PAL16V8 LABELS_IO should be: %s, and it's: %S", Arrays.toString(LABELS_IO), Arrays.toString(pureCombinatorialDiscardFeedbacksAllOutputsPal16v8.getLabels_IO())), LABELS_IO, pureCombinatorialDiscardFeedbacksAllOutputsPal16v8.getLabels_IO());
        assertArrayEquals(String.format("Pure Combinatorial Discard Feedbacks All Outputs PAL16V8 LABELS_RO should be: %s, and it's: %S", Arrays.toString(LABELS_RO), Arrays.toString(pureCombinatorialDiscardFeedbacksAllOutputsPal16v8.getLabels_RO())), LABELS_RO, pureCombinatorialDiscardFeedbacksAllOutputsPal16v8.getLabels_RO());
        assertArrayEquals(String.format("Pure Combinatorial Discard Feedbacks All Outputs PAL16V8  LABELS_O should be: %s, and it's: %S", Arrays.toString(LABELS_O),  Arrays.toString(pureCombinatorialDiscardFeedbacksAllOutputsPal16v8.getLabels_O())),  LABELS_O,  pureCombinatorialDiscardFeedbacksAllOutputsPal16v8.getLabels_O());

        assertEquals(String.format("Pure Combinatorial Discard Feedbacks All Outputs PAL16V8 Pin Count IN should be: %d, and it's: %d", 10, pureCombinatorialDiscardFeedbacksAllOutputsPal16v8.getPinCount_IN()), 10, pureCombinatorialDiscardFeedbacksAllOutputsPal16v8.getPinCount_IN());
        assertEquals(String.format("Pure Combinatorial Discard Feedbacks All Outputs PAL16V8 Pin Count IO should be: %d, and it's: %d",  0, pureCombinatorialDiscardFeedbacksAllOutputsPal16v8.getPinCount_IO()),  0, pureCombinatorialDiscardFeedbacksAllOutputsPal16v8.getPinCount_IO());
        assertEquals(String.format("Pure Combinatorial Discard Feedbacks All Outputs PAL16V8 Pin Count RO should be: %d, and it's: %d",  0, pureCombinatorialDiscardFeedbacksAllOutputsPal16v8.getPinCount_RO()),  0, pureCombinatorialDiscardFeedbacksAllOutputsPal16v8.getPinCount_RO());
        assertEquals(String.format("Pure Combinatorial Discard Feedbacks All Outputs PAL16V8 Pin Count  O should be: %d, and it's: %d",  8, pureCombinatorialDiscardFeedbacksAllOutputsPal16v8.getPinCount_O()),   8, pureCombinatorialDiscardFeedbacksAllOutputsPal16v8.getPinCount_O());
    }

    @Test
    public void pureCombinatorialDiscardFeedbacksAllInputsPal16v8Features() {
    	
    	/* ***************** Initialized for pure combinatorial configuration PAL ***************** */
    	String[] LABELS_IN = { "i1", "i2", "i3", "i4", "i5", "i6", "i7", "i8", "i9", "i11", "i18", "i17", "i16", "i15", "i14", "i13", "i19", "i12" };
    	String[] LABELS_IO = {};
    	String[] LABELS_RO = {};
    	String[] LABELS_O  = {};

    	// All IOs as Inputs (should never happen in real world):
    	int ioAsOutputMask = 0x00;

    	PALSpecs pureCombinatorialDiscardFeedbacksAllInputsPal16v8 = new PAL16V8Specs(ioAsOutputMask);
    	int pureCombinatorialDiscardFeedbacksAllInputsBitMaskCLK  = Integer.parseInt(new StringBuffer("0 00000000 0 00000000".replace(" ", "")).reverse().toString(), 2);
    	int pureCombinatorialDiscardFeedbacksAllInputsBitMaskOE   = Integer.parseInt(new StringBuffer("0 00000000 0 00000000".replace(" ", "")).reverse().toString(), 2);
    	int pureCombinatorialDiscardFeedbacksAllInputsBitMaskIN   = Integer.parseInt(new StringBuffer("1 11111111 1 11111111".replace(" ", "")).reverse().toString(), 2);
    	int pureCombinatorialDiscardFeedbacksAllInputsBitMaskIO_R = Integer.parseInt(new StringBuffer("             00000000".replace(" ", "")).reverse().toString(), 2);
    	int pureCombinatorialDiscardFeedbacksAllInputsBitMaskIO_W = Integer.parseInt(new StringBuffer("0 00000000 0 00000000".replace(" ", "")).reverse().toString(), 2);
    	int pureCombinatorialDiscardFeedbacksAllInputsBitMaskRO_R = Integer.parseInt(new StringBuffer("             00000000".replace(" ", "")).reverse().toString(), 2);
    	int pureCombinatorialDiscardFeedbacksAllInputsBitMaskRO_W = Integer.parseInt(new StringBuffer("0 00000000 0 00000000".replace(" ", "")).reverse().toString(), 2);
    	int pureCombinatorialDiscardFeedbacksAllInputsBitMaskO_R  = Integer.parseInt(new StringBuffer("             00000000".replace(" ", "")).reverse().toString(), 2);
    	int pureCombinatorialDiscardFeedbacksAllInputsBitMaskO_W  = Integer.parseInt(new StringBuffer("0 00000000 0 00000000".replace(" ", "")).reverse().toString(), 2);

        assertEquals("A PAL16V8 should be variable", true, pureCombinatorialDiscardFeedbacksAllInputsPal16v8.isVariable());
        
        assertEquals(String.format("Pure Combinatorial Discard Feedbacks All Inputs PAL16V8  CLK Mask should be: 0x%05X, and it's: 0x%05X", pureCombinatorialDiscardFeedbacksAllInputsBitMaskCLK,  pureCombinatorialDiscardFeedbacksAllInputsPal16v8.getMask_CLK()),  pureCombinatorialDiscardFeedbacksAllInputsBitMaskCLK,  pureCombinatorialDiscardFeedbacksAllInputsPal16v8.getMask_CLK());
        assertEquals(String.format("Pure Combinatorial Discard Feedbacks All Inputs PAL16V8   OE Mask should be: 0x%05X, and it's: 0x%05X", pureCombinatorialDiscardFeedbacksAllInputsBitMaskOE,   pureCombinatorialDiscardFeedbacksAllInputsPal16v8.getMask_OE()),   pureCombinatorialDiscardFeedbacksAllInputsBitMaskOE,   pureCombinatorialDiscardFeedbacksAllInputsPal16v8.getMask_OE());
        assertEquals(String.format("Pure Combinatorial Discard Feedbacks All Inputs PAL16V8   IN Mask should be: 0x%05X, and it's: 0x%05X", pureCombinatorialDiscardFeedbacksAllInputsBitMaskIN,   pureCombinatorialDiscardFeedbacksAllInputsPal16v8.getMask_IN()),   pureCombinatorialDiscardFeedbacksAllInputsBitMaskIN,   pureCombinatorialDiscardFeedbacksAllInputsPal16v8.getMask_IN());
        assertEquals(String.format("Pure Combinatorial Discard Feedbacks All Inputs PAL16V8 IO_R Mask should be: 0x%05X, and it's: 0x%05X", pureCombinatorialDiscardFeedbacksAllInputsBitMaskIO_R, pureCombinatorialDiscardFeedbacksAllInputsPal16v8.getMask_IO_R()), pureCombinatorialDiscardFeedbacksAllInputsBitMaskIO_R, pureCombinatorialDiscardFeedbacksAllInputsPal16v8.getMask_IO_R());
        assertEquals(String.format("Pure Combinatorial Discard Feedbacks All Inputs PAL16V8 IO_W Mask should be: 0x%05X, and it's: 0x%05X", pureCombinatorialDiscardFeedbacksAllInputsBitMaskIO_W, pureCombinatorialDiscardFeedbacksAllInputsPal16v8.getMask_IO_W()), pureCombinatorialDiscardFeedbacksAllInputsBitMaskIO_W, pureCombinatorialDiscardFeedbacksAllInputsPal16v8.getMask_IO_W());
        assertEquals(String.format("Pure Combinatorial Discard Feedbacks All Inputs PAL16V8 RO_R Mask should be: 0x%05X, and it's: 0x%05X", pureCombinatorialDiscardFeedbacksAllInputsBitMaskRO_R, pureCombinatorialDiscardFeedbacksAllInputsPal16v8.getMask_RO_R()), pureCombinatorialDiscardFeedbacksAllInputsBitMaskRO_R, pureCombinatorialDiscardFeedbacksAllInputsPal16v8.getMask_RO_R());
        assertEquals(String.format("Pure Combinatorial Discard Feedbacks All Inputs PAL16V8 RO_W Mask should be: 0x%05X, and it's: 0x%05X", pureCombinatorialDiscardFeedbacksAllInputsBitMaskRO_W, pureCombinatorialDiscardFeedbacksAllInputsPal16v8.getMask_RO_W()), pureCombinatorialDiscardFeedbacksAllInputsBitMaskRO_W, pureCombinatorialDiscardFeedbacksAllInputsPal16v8.getMask_RO_W());
        assertEquals(String.format("Pure Combinatorial Discard Feedbacks All Inputs PAL16V8  O_R Mask should be: 0x%05X, and it's: 0x%05X", pureCombinatorialDiscardFeedbacksAllInputsBitMaskO_R,  pureCombinatorialDiscardFeedbacksAllInputsPal16v8.getMask_O_R()),  pureCombinatorialDiscardFeedbacksAllInputsBitMaskO_R,  pureCombinatorialDiscardFeedbacksAllInputsPal16v8.getMask_O_R());
        assertEquals(String.format("Pure Combinatorial Discard Feedbacks All Inputs PAL16V8  O_W Mask should be: 0x%05X, and it's: 0x%05X", pureCombinatorialDiscardFeedbacksAllInputsBitMaskO_W,  pureCombinatorialDiscardFeedbacksAllInputsPal16v8.getMask_O_W()),  pureCombinatorialDiscardFeedbacksAllInputsBitMaskO_W,  pureCombinatorialDiscardFeedbacksAllInputsPal16v8.getMask_O_W());

        assertArrayEquals(String.format("Pure Combinatorial Discard Feedbacks All Inputs PAL16V8 LABELS_IN should be: %s, and it's: %S", Arrays.toString(LABELS_IN), Arrays.toString(pureCombinatorialDiscardFeedbacksAllInputsPal16v8.getLabels_IN())), LABELS_IN, pureCombinatorialDiscardFeedbacksAllInputsPal16v8.getLabels_IN());
        assertArrayEquals(String.format("Pure Combinatorial Discard Feedbacks All Inputs PAL16V8 LABELS_IO should be: %s, and it's: %S", Arrays.toString(LABELS_IO), Arrays.toString(pureCombinatorialDiscardFeedbacksAllInputsPal16v8.getLabels_IO())), LABELS_IO, pureCombinatorialDiscardFeedbacksAllInputsPal16v8.getLabels_IO());
        assertArrayEquals(String.format("Pure Combinatorial Discard Feedbacks All Inputs PAL16V8 LABELS_RO should be: %s, and it's: %S", Arrays.toString(LABELS_RO), Arrays.toString(pureCombinatorialDiscardFeedbacksAllInputsPal16v8.getLabels_RO())), LABELS_RO, pureCombinatorialDiscardFeedbacksAllInputsPal16v8.getLabels_RO());
        assertArrayEquals(String.format("Pure Combinatorial Discard Feedbacks All Inputs PAL16V8  LABELS_O should be: %s, and it's: %S", Arrays.toString(LABELS_O),  Arrays.toString(pureCombinatorialDiscardFeedbacksAllInputsPal16v8.getLabels_O())),  LABELS_O,  pureCombinatorialDiscardFeedbacksAllInputsPal16v8.getLabels_O());

        assertEquals(String.format("Pure Combinatorial Discard Feedbacks All Inputs PAL16V8 Pin Count IN should be: %d, and it's: %d", 18, pureCombinatorialDiscardFeedbacksAllInputsPal16v8.getPinCount_IN()), 18, pureCombinatorialDiscardFeedbacksAllInputsPal16v8.getPinCount_IN());
        assertEquals(String.format("Pure Combinatorial Discard Feedbacks All Inputs PAL16V8 Pin Count IO should be: %d, and it's: %d",  0, pureCombinatorialDiscardFeedbacksAllInputsPal16v8.getPinCount_IO()),  0, pureCombinatorialDiscardFeedbacksAllInputsPal16v8.getPinCount_IO());
        assertEquals(String.format("Pure Combinatorial Discard Feedbacks All Inputs PAL16V8 Pin Count RO should be: %d, and it's: %d",  0, pureCombinatorialDiscardFeedbacksAllInputsPal16v8.getPinCount_RO()),  0, pureCombinatorialDiscardFeedbacksAllInputsPal16v8.getPinCount_RO());
        assertEquals(String.format("Pure Combinatorial Discard Feedbacks All Inputs PAL16V8 Pin Count  O should be: %d, and it's: %d",  0, pureCombinatorialDiscardFeedbacksAllInputsPal16v8.getPinCount_O()),   0, pureCombinatorialDiscardFeedbacksAllInputsPal16v8.getPinCount_O());
    }

    @Test
    public void pureCombinatorialDiscardFeedbacksMixedInputsAndOutputsPal16v8Features() {
    	
    	/* ***************** Initialized for pure combinatorial configuration PAL ***************** */
    	String[] LABELS_IN = { "i1", "i2", "i3", "i4", "i5", "i6", "i7", "i8", "i9", "i11", null, "i17", "i16", null, "i14", "i13", null, null };
    	String[] LABELS_IO = {};
    	String[] LABELS_RO = {};
    	String[] LABELS_O  = { null, null, null, null, null, null, null, null, null, null, "o18", null, null, "o15", null, null, "o19", "o12" };

    	// Mixed IOs as Inputs and Outputs:
    	int ioAsOutputMask = 0xC9;

    	PALSpecs pureCombinatorialDiscardFeedbacksMixedInputsAndOutputsPal16v8 = new PAL16V8Specs(ioAsOutputMask);
    	int pureCombinatorialDiscardFeedbacksMixedInputsAndOutputsBitMaskCLK  = Integer.parseInt(new StringBuffer("0 00000000 0 00000000".replace(" ", "")).reverse().toString(), 2);
    	int pureCombinatorialDiscardFeedbacksMixedInputsAndOutputsBitMaskOE   = Integer.parseInt(new StringBuffer("0 00000000 0 00000000".replace(" ", "")).reverse().toString(), 2);
    	int pureCombinatorialDiscardFeedbacksMixedInputsAndOutputsBitMaskIN   = Integer.parseInt(new StringBuffer("1 11111111 1 01101100".replace(" ", "")).reverse().toString(), 2);
    	int pureCombinatorialDiscardFeedbacksMixedInputsAndOutputsBitMaskIO_R = Integer.parseInt(new StringBuffer("             00000000".replace(" ", "")).reverse().toString(), 2);
    	int pureCombinatorialDiscardFeedbacksMixedInputsAndOutputsBitMaskIO_W = Integer.parseInt(new StringBuffer("0 00000000 0 00000000".replace(" ", "")).reverse().toString(), 2);
    	int pureCombinatorialDiscardFeedbacksMixedInputsAndOutputsBitMaskRO_R = Integer.parseInt(new StringBuffer("             00000000".replace(" ", "")).reverse().toString(), 2);
    	int pureCombinatorialDiscardFeedbacksMixedInputsAndOutputsBitMaskRO_W = Integer.parseInt(new StringBuffer("0 00000000 0 00000000".replace(" ", "")).reverse().toString(), 2);
    	int pureCombinatorialDiscardFeedbacksMixedInputsAndOutputsBitMaskO_R  = Integer.parseInt(new StringBuffer("             10010011".replace(" ", "")).reverse().toString(), 2);
    	int pureCombinatorialDiscardFeedbacksMixedInputsAndOutputsBitMaskO_W  = Integer.parseInt(new StringBuffer("0 00000000 0 10010011".replace(" ", "")).reverse().toString(), 2);

        assertEquals("A PAL16V8 should be variable", true, pureCombinatorialDiscardFeedbacksMixedInputsAndOutputsPal16v8.isVariable());
        
        assertEquals(String.format("Pure Combinatorial Discard Feedbacks Mixed Inputs And Outputs PAL16V8  CLK Mask should be: 0x%05X, and it's: 0x%05X", pureCombinatorialDiscardFeedbacksMixedInputsAndOutputsBitMaskCLK,  pureCombinatorialDiscardFeedbacksMixedInputsAndOutputsPal16v8.getMask_CLK()),  pureCombinatorialDiscardFeedbacksMixedInputsAndOutputsBitMaskCLK,  pureCombinatorialDiscardFeedbacksMixedInputsAndOutputsPal16v8.getMask_CLK());
        assertEquals(String.format("Pure Combinatorial Discard Feedbacks Mixed Inputs And Outputs PAL16V8   OE Mask should be: 0x%05X, and it's: 0x%05X", pureCombinatorialDiscardFeedbacksMixedInputsAndOutputsBitMaskOE,   pureCombinatorialDiscardFeedbacksMixedInputsAndOutputsPal16v8.getMask_OE()),   pureCombinatorialDiscardFeedbacksMixedInputsAndOutputsBitMaskOE,   pureCombinatorialDiscardFeedbacksMixedInputsAndOutputsPal16v8.getMask_OE());
        assertEquals(String.format("Pure Combinatorial Discard Feedbacks Mixed Inputs And Outputs PAL16V8   IN Mask should be: 0x%05X, and it's: 0x%05X", pureCombinatorialDiscardFeedbacksMixedInputsAndOutputsBitMaskIN,   pureCombinatorialDiscardFeedbacksMixedInputsAndOutputsPal16v8.getMask_IN()),   pureCombinatorialDiscardFeedbacksMixedInputsAndOutputsBitMaskIN,   pureCombinatorialDiscardFeedbacksMixedInputsAndOutputsPal16v8.getMask_IN());
        assertEquals(String.format("Pure Combinatorial Discard Feedbacks Mixed Inputs And Outputs PAL16V8 IO_R Mask should be: 0x%05X, and it's: 0x%05X", pureCombinatorialDiscardFeedbacksMixedInputsAndOutputsBitMaskIO_R, pureCombinatorialDiscardFeedbacksMixedInputsAndOutputsPal16v8.getMask_IO_R()), pureCombinatorialDiscardFeedbacksMixedInputsAndOutputsBitMaskIO_R, pureCombinatorialDiscardFeedbacksMixedInputsAndOutputsPal16v8.getMask_IO_R());
        assertEquals(String.format("Pure Combinatorial Discard Feedbacks Mixed Inputs And Outputs PAL16V8 IO_W Mask should be: 0x%05X, and it's: 0x%05X", pureCombinatorialDiscardFeedbacksMixedInputsAndOutputsBitMaskIO_W, pureCombinatorialDiscardFeedbacksMixedInputsAndOutputsPal16v8.getMask_IO_W()), pureCombinatorialDiscardFeedbacksMixedInputsAndOutputsBitMaskIO_W, pureCombinatorialDiscardFeedbacksMixedInputsAndOutputsPal16v8.getMask_IO_W());
        assertEquals(String.format("Pure Combinatorial Discard Feedbacks Mixed Inputs And Outputs PAL16V8 RO_R Mask should be: 0x%05X, and it's: 0x%05X", pureCombinatorialDiscardFeedbacksMixedInputsAndOutputsBitMaskRO_R, pureCombinatorialDiscardFeedbacksMixedInputsAndOutputsPal16v8.getMask_RO_R()), pureCombinatorialDiscardFeedbacksMixedInputsAndOutputsBitMaskRO_R, pureCombinatorialDiscardFeedbacksMixedInputsAndOutputsPal16v8.getMask_RO_R());
        assertEquals(String.format("Pure Combinatorial Discard Feedbacks Mixed Inputs And Outputs PAL16V8 RO_W Mask should be: 0x%05X, and it's: 0x%05X", pureCombinatorialDiscardFeedbacksMixedInputsAndOutputsBitMaskRO_W, pureCombinatorialDiscardFeedbacksMixedInputsAndOutputsPal16v8.getMask_RO_W()), pureCombinatorialDiscardFeedbacksMixedInputsAndOutputsBitMaskRO_W, pureCombinatorialDiscardFeedbacksMixedInputsAndOutputsPal16v8.getMask_RO_W());
        assertEquals(String.format("Pure Combinatorial Discard Feedbacks Mixed Inputs And Outputs PAL16V8  O_R Mask should be: 0x%05X, and it's: 0x%05X", pureCombinatorialDiscardFeedbacksMixedInputsAndOutputsBitMaskO_R,  pureCombinatorialDiscardFeedbacksMixedInputsAndOutputsPal16v8.getMask_O_R()),  pureCombinatorialDiscardFeedbacksMixedInputsAndOutputsBitMaskO_R,  pureCombinatorialDiscardFeedbacksMixedInputsAndOutputsPal16v8.getMask_O_R());
        assertEquals(String.format("Pure Combinatorial Discard Feedbacks Mixed Inputs And Outputs PAL16V8  O_W Mask should be: 0x%05X, and it's: 0x%05X", pureCombinatorialDiscardFeedbacksMixedInputsAndOutputsBitMaskO_W,  pureCombinatorialDiscardFeedbacksMixedInputsAndOutputsPal16v8.getMask_O_W()),  pureCombinatorialDiscardFeedbacksMixedInputsAndOutputsBitMaskO_W,  pureCombinatorialDiscardFeedbacksMixedInputsAndOutputsPal16v8.getMask_O_W());

        assertArrayEquals(String.format("Pure Combinatorial Discard Feedbacks Mixed Inputs And Outputs PAL16V8 LABELS_IN should be: %s, and it's: %S", Arrays.toString(LABELS_IN), Arrays.toString(pureCombinatorialDiscardFeedbacksMixedInputsAndOutputsPal16v8.getLabels_IN())), LABELS_IN, pureCombinatorialDiscardFeedbacksMixedInputsAndOutputsPal16v8.getLabels_IN());
        assertArrayEquals(String.format("Pure Combinatorial Discard Feedbacks Mixed Inputs And Outputs PAL16V8 LABELS_IO should be: %s, and it's: %S", Arrays.toString(LABELS_IO), Arrays.toString(pureCombinatorialDiscardFeedbacksMixedInputsAndOutputsPal16v8.getLabels_IO())), LABELS_IO, pureCombinatorialDiscardFeedbacksMixedInputsAndOutputsPal16v8.getLabels_IO());
        assertArrayEquals(String.format("Pure Combinatorial Discard Feedbacks Mixed Inputs And Outputs PAL16V8 LABELS_RO should be: %s, and it's: %S", Arrays.toString(LABELS_RO), Arrays.toString(pureCombinatorialDiscardFeedbacksMixedInputsAndOutputsPal16v8.getLabels_RO())), LABELS_RO, pureCombinatorialDiscardFeedbacksMixedInputsAndOutputsPal16v8.getLabels_RO());
        assertArrayEquals(String.format("Pure Combinatorial Discard Feedbacks Mixed Inputs And Outputs PAL16V8  LABELS_O should be: %s, and it's: %S", Arrays.toString(LABELS_O),  Arrays.toString(pureCombinatorialDiscardFeedbacksMixedInputsAndOutputsPal16v8.getLabels_O())),  LABELS_O,  pureCombinatorialDiscardFeedbacksMixedInputsAndOutputsPal16v8.getLabels_O());

        assertEquals(String.format("Pure Combinatorial Discard Feedbacks Mixed Inputs And Outputs PAL16V8 Pin Count IN should be: %d, and it's: %d", 14, pureCombinatorialDiscardFeedbacksMixedInputsAndOutputsPal16v8.getPinCount_IN()), 14, pureCombinatorialDiscardFeedbacksMixedInputsAndOutputsPal16v8.getPinCount_IN());
        assertEquals(String.format("Pure Combinatorial Discard Feedbacks Mixed Inputs And Outputs PAL16V8 Pin Count IO should be: %d, and it's: %d",  0, pureCombinatorialDiscardFeedbacksMixedInputsAndOutputsPal16v8.getPinCount_IO()),  0, pureCombinatorialDiscardFeedbacksMixedInputsAndOutputsPal16v8.getPinCount_IO());
        assertEquals(String.format("Pure Combinatorial Discard Feedbacks Mixed Inputs And Outputs PAL16V8 Pin Count RO should be: %d, and it's: %d",  0, pureCombinatorialDiscardFeedbacksMixedInputsAndOutputsPal16v8.getPinCount_RO()),  0, pureCombinatorialDiscardFeedbacksMixedInputsAndOutputsPal16v8.getPinCount_RO());
        assertEquals(String.format("Pure Combinatorial Discard Feedbacks Mixed Inputs And Outputs PAL16V8 Pin Count  O should be: %d, and it's: %d",  4, pureCombinatorialDiscardFeedbacksMixedInputsAndOutputsPal16v8.getPinCount_O()),   4, pureCombinatorialDiscardFeedbacksMixedInputsAndOutputsPal16v8.getPinCount_O());
    }
    
    @Test
    public void fullRegisteredPal16v8Features() {
    	
    	/* ***************** Initialized for full registered configuration PAL ***************** */
    	String[] LABELS_IN = { null, "i2", "i3", "i4", "i5", "i6", "i7", "i8", "i9", null, null, null, null, null, null, null, null, null };
    	String[] LABELS_IO = {};
    	String[] LABELS_RO = { null, null, null, null, null, null, null, null, null, null, "ro18", "ro17", "ro16", "ro15", "ro14", "ro13", "ro19", "ro12" };
    	String[] LABELS_O  = {};

    	int roMask = 0xFF;
    	
    	PALSpecs fullRegisteredPal16v8 = new PAL16V8Specs(null, roMask);
    	int fullRegisteredBitMaskCLK  = Integer.parseInt(new StringBuffer("1 00000000 0 00000000".replace(" ", "")).reverse().toString(), 2);
    	int fullRegisteredBitMaskOE   = Integer.parseInt(new StringBuffer("0 00000000 1 00000000".replace(" ", "")).reverse().toString(), 2);
    	int fullRegisteredBitMaskIN   = Integer.parseInt(new StringBuffer("0 11111111 0 00000000".replace(" ", "")).reverse().toString(), 2);
    	int fullRegisteredBitMaskIO_R = Integer.parseInt(new StringBuffer("             00000000".replace(" ", "")).reverse().toString(), 2);
    	int fullRegisteredBitMaskIO_W = Integer.parseInt(new StringBuffer("0 00000000 0 00000000".replace(" ", "")).reverse().toString(), 2);
    	int fullRegisteredBitMaskRO_R = Integer.parseInt(new StringBuffer("             11111111".replace(" ", "")).reverse().toString(), 2);
    	int fullRegisteredBitMaskRO_W = Integer.parseInt(new StringBuffer("0 00000000 0 11111111".replace(" ", "")).reverse().toString(), 2);
    	int fullRegisteredBitMaskO_R  = Integer.parseInt(new StringBuffer("             00000000".replace(" ", "")).reverse().toString(), 2);
    	int fullRegisteredBitMaskO_W  = Integer.parseInt(new StringBuffer("0 00000000 0 00000000".replace(" ", "")).reverse().toString(), 2);

        assertEquals("A PAL16V8 should be variable", true, fullRegisteredPal16v8.isVariable());
        
        assertEquals(String.format("Pure Combinatorial PAL16V8  CLK Mask should be: 0x%05X, and it's: 0x%05X", fullRegisteredBitMaskCLK,  fullRegisteredPal16v8.getMask_CLK()),  fullRegisteredBitMaskCLK,  fullRegisteredPal16v8.getMask_CLK());
        assertEquals(String.format("Pure Combinatorial PAL16V8   OE Mask should be: 0x%05X, and it's: 0x%05X", fullRegisteredBitMaskOE,   fullRegisteredPal16v8.getMask_OE()),   fullRegisteredBitMaskOE,   fullRegisteredPal16v8.getMask_OE());
        assertEquals(String.format("Pure Combinatorial PAL16V8   IN Mask should be: 0x%05X, and it's: 0x%05X", fullRegisteredBitMaskIN,   fullRegisteredPal16v8.getMask_IN()),   fullRegisteredBitMaskIN,   fullRegisteredPal16v8.getMask_IN());
        assertEquals(String.format("Pure Combinatorial PAL16V8 IO_R Mask should be: 0x%05X, and it's: 0x%05X", fullRegisteredBitMaskIO_R, fullRegisteredPal16v8.getMask_IO_R()), fullRegisteredBitMaskIO_R, fullRegisteredPal16v8.getMask_IO_R());
        assertEquals(String.format("Pure Combinatorial PAL16V8 IO_W Mask should be: 0x%05X, and it's: 0x%05X", fullRegisteredBitMaskIO_W, fullRegisteredPal16v8.getMask_IO_W()), fullRegisteredBitMaskIO_W, fullRegisteredPal16v8.getMask_IO_W());
        assertEquals(String.format("Pure Combinatorial PAL16V8 RO_R Mask should be: 0x%05X, and it's: 0x%05X", fullRegisteredBitMaskRO_R, fullRegisteredPal16v8.getMask_RO_R()), fullRegisteredBitMaskRO_R, fullRegisteredPal16v8.getMask_RO_R());
        assertEquals(String.format("Pure Combinatorial PAL16V8 RO_W Mask should be: 0x%05X, and it's: 0x%05X", fullRegisteredBitMaskRO_W, fullRegisteredPal16v8.getMask_RO_W()), fullRegisteredBitMaskRO_W, fullRegisteredPal16v8.getMask_RO_W());
        assertEquals(String.format("Pure Combinatorial PAL16V8  O_R Mask should be: 0x%05X, and it's: 0x%05X", fullRegisteredBitMaskO_R,  fullRegisteredPal16v8.getMask_O_R()),  fullRegisteredBitMaskO_R,  fullRegisteredPal16v8.getMask_O_R());
        assertEquals(String.format("Pure Combinatorial PAL16V8  O_W Mask should be: 0x%05X, and it's: 0x%05X", fullRegisteredBitMaskO_W,  fullRegisteredPal16v8.getMask_O_W()),  fullRegisteredBitMaskO_W,  fullRegisteredPal16v8.getMask_O_W());

        assertArrayEquals(String.format("Pure Combinatorial PAL16V8 LABELS_IN should be: %s, and it's: %S", Arrays.toString(LABELS_IN), Arrays.toString(fullRegisteredPal16v8.getLabels_IN())), LABELS_IN, fullRegisteredPal16v8.getLabels_IN());
        assertArrayEquals(String.format("Pure Combinatorial PAL16V8 LABELS_IO should be: %s, and it's: %S", Arrays.toString(LABELS_IO), Arrays.toString(fullRegisteredPal16v8.getLabels_IO())), LABELS_IO, fullRegisteredPal16v8.getLabels_IO());
        assertArrayEquals(String.format("Pure Combinatorial PAL16V8 LABELS_RO should be: %s, and it's: %S", Arrays.toString(LABELS_RO), Arrays.toString(fullRegisteredPal16v8.getLabels_RO())), LABELS_RO, fullRegisteredPal16v8.getLabels_RO());
        assertArrayEquals(String.format("Pure Combinatorial PAL16V8  LABELS_O should be: %s, and it's: %S", Arrays.toString(LABELS_O),  Arrays.toString(fullRegisteredPal16v8.getLabels_O())),  LABELS_O,  fullRegisteredPal16v8.getLabels_O());

        assertEquals(String.format("Pure Combinatorial PAL16V8 Pin Count IN should be: %d, and it's: %d",  8, fullRegisteredPal16v8.getPinCount_IN()),  8, fullRegisteredPal16v8.getPinCount_IN());
        assertEquals(String.format("Pure Combinatorial PAL16V8 Pin Count IO should be: %d, and it's: %d",  0, fullRegisteredPal16v8.getPinCount_IO()),  0, fullRegisteredPal16v8.getPinCount_IO());
        assertEquals(String.format("Pure Combinatorial PAL16V8 Pin Count RO should be: %d, and it's: %d",  8, fullRegisteredPal16v8.getPinCount_RO()),  8, fullRegisteredPal16v8.getPinCount_RO());
        assertEquals(String.format("Pure Combinatorial PAL16V8 Pin Count  O should be: %d, and it's: %d",  0, fullRegisteredPal16v8.getPinCount_O()),   0, fullRegisteredPal16v8.getPinCount_O());
    }
    
    @Test
    public void partiallyRegisteredPal16v8Features1() {
    	
    	/* ***************** Initialized for partially registered configuration PAL ***************** */
    	String[] LABELS_IN = { null, "i2", "i3", "i4", "i5", "i6", "i7", "i8", "i9", null, null,   null,   null,   null,   null,   null,   null,   null };
    	String[] LABELS_IO = { null, null, null, null, null, null, null, null, null, null, null,   null,   null,   null,   null,   null,   null,   "io12" };
    	String[] LABELS_RO = { null, null, null, null, null, null, null, null, null, null, "ro18", "ro17", "ro16", "ro15", "ro14", "ro13", "ro19", null };
    	String[] LABELS_O  = {};

    	int roMask = 0x7F;
    	
    	PALSpecs partiallyRegistered7FPal16v8 = new PAL16V8Specs(null, roMask);
    	int partiallyRegistered7FBitMaskCLK  = Integer.parseInt(new StringBuffer("1 00000000 0 00000000".replace(" ", "")).reverse().toString(), 2);
    	int partiallyRegistered7FBitMaskOE   = Integer.parseInt(new StringBuffer("0 00000000 1 00000000".replace(" ", "")).reverse().toString(), 2);
    	int partiallyRegistered7FBitMaskIN   = Integer.parseInt(new StringBuffer("0 11111111 0 00000000".replace(" ", "")).reverse().toString(), 2);
    	int partiallyRegistered7FBitMaskIO_R = Integer.parseInt(new StringBuffer("             00000001".replace(" ", "")).reverse().toString(), 2);
    	int partiallyRegistered7FBitMaskIO_W = Integer.parseInt(new StringBuffer("0 00000000 0 00000001".replace(" ", "")).reverse().toString(), 2);
    	int partiallyRegistered7FBitMaskRO_R = Integer.parseInt(new StringBuffer("             11111110".replace(" ", "")).reverse().toString(), 2);
    	int partiallyRegistered7FBitMaskRO_W = Integer.parseInt(new StringBuffer("0 00000000 0 11111110".replace(" ", "")).reverse().toString(), 2);
    	int partiallyRegistered7FBitMaskO_R  = Integer.parseInt(new StringBuffer("             00000000".replace(" ", "")).reverse().toString(), 2);
    	int partiallyRegistered7FBitMaskO_W  = Integer.parseInt(new StringBuffer("0 00000000 0 00000000".replace(" ", "")).reverse().toString(), 2);

        assertEquals("A PAL16V8 should be variable", true, partiallyRegistered7FPal16v8.isVariable());
        
        assertEquals(String.format("Pure Combinatorial PAL16V8  CLK Mask should be: 0x%05X, and it's: 0x%05X", partiallyRegistered7FBitMaskCLK,  partiallyRegistered7FPal16v8.getMask_CLK()),  partiallyRegistered7FBitMaskCLK,  partiallyRegistered7FPal16v8.getMask_CLK());
        assertEquals(String.format("Pure Combinatorial PAL16V8   OE Mask should be: 0x%05X, and it's: 0x%05X", partiallyRegistered7FBitMaskOE,   partiallyRegistered7FPal16v8.getMask_OE()),   partiallyRegistered7FBitMaskOE,   partiallyRegistered7FPal16v8.getMask_OE());
        assertEquals(String.format("Pure Combinatorial PAL16V8   IN Mask should be: 0x%05X, and it's: 0x%05X", partiallyRegistered7FBitMaskIN,   partiallyRegistered7FPal16v8.getMask_IN()),   partiallyRegistered7FBitMaskIN,   partiallyRegistered7FPal16v8.getMask_IN());
        assertEquals(String.format("Pure Combinatorial PAL16V8 IO_R Mask should be: 0x%05X, and it's: 0x%05X", partiallyRegistered7FBitMaskIO_R, partiallyRegistered7FPal16v8.getMask_IO_R()), partiallyRegistered7FBitMaskIO_R, partiallyRegistered7FPal16v8.getMask_IO_R());
        assertEquals(String.format("Pure Combinatorial PAL16V8 IO_W Mask should be: 0x%05X, and it's: 0x%05X", partiallyRegistered7FBitMaskIO_W, partiallyRegistered7FPal16v8.getMask_IO_W()), partiallyRegistered7FBitMaskIO_W, partiallyRegistered7FPal16v8.getMask_IO_W());
        assertEquals(String.format("Pure Combinatorial PAL16V8 RO_R Mask should be: 0x%05X, and it's: 0x%05X", partiallyRegistered7FBitMaskRO_R, partiallyRegistered7FPal16v8.getMask_RO_R()), partiallyRegistered7FBitMaskRO_R, partiallyRegistered7FPal16v8.getMask_RO_R());
        assertEquals(String.format("Pure Combinatorial PAL16V8 RO_W Mask should be: 0x%05X, and it's: 0x%05X", partiallyRegistered7FBitMaskRO_W, partiallyRegistered7FPal16v8.getMask_RO_W()), partiallyRegistered7FBitMaskRO_W, partiallyRegistered7FPal16v8.getMask_RO_W());
        assertEquals(String.format("Pure Combinatorial PAL16V8  O_R Mask should be: 0x%05X, and it's: 0x%05X", partiallyRegistered7FBitMaskO_R,  partiallyRegistered7FPal16v8.getMask_O_R()),  partiallyRegistered7FBitMaskO_R,  partiallyRegistered7FPal16v8.getMask_O_R());
        assertEquals(String.format("Pure Combinatorial PAL16V8  O_W Mask should be: 0x%05X, and it's: 0x%05X", partiallyRegistered7FBitMaskO_W,  partiallyRegistered7FPal16v8.getMask_O_W()),  partiallyRegistered7FBitMaskO_W,  partiallyRegistered7FPal16v8.getMask_O_W());

        assertArrayEquals(String.format("Pure Combinatorial PAL16V8 LABELS_IN should be: %s, and it's: %S", Arrays.toString(LABELS_IN), Arrays.toString(partiallyRegistered7FPal16v8.getLabels_IN())), LABELS_IN, partiallyRegistered7FPal16v8.getLabels_IN());
        assertArrayEquals(String.format("Pure Combinatorial PAL16V8 LABELS_IO should be: %s, and it's: %S", Arrays.toString(LABELS_IO), Arrays.toString(partiallyRegistered7FPal16v8.getLabels_IO())), LABELS_IO, partiallyRegistered7FPal16v8.getLabels_IO());
        assertArrayEquals(String.format("Pure Combinatorial PAL16V8 LABELS_RO should be: %s, and it's: %S", Arrays.toString(LABELS_RO), Arrays.toString(partiallyRegistered7FPal16v8.getLabels_RO())), LABELS_RO, partiallyRegistered7FPal16v8.getLabels_RO());
        assertArrayEquals(String.format("Pure Combinatorial PAL16V8  LABELS_O should be: %s, and it's: %S", Arrays.toString(LABELS_O),  Arrays.toString(partiallyRegistered7FPal16v8.getLabels_O())),  LABELS_O,  partiallyRegistered7FPal16v8.getLabels_O());

        assertEquals(String.format("Pure Combinatorial PAL16V8 Pin Count IN should be: %d, and it's: %d",  8, partiallyRegistered7FPal16v8.getPinCount_IN()),  8, partiallyRegistered7FPal16v8.getPinCount_IN());
        assertEquals(String.format("Pure Combinatorial PAL16V8 Pin Count IO should be: %d, and it's: %d",  1, partiallyRegistered7FPal16v8.getPinCount_IO()),  1, partiallyRegistered7FPal16v8.getPinCount_IO());
        assertEquals(String.format("Pure Combinatorial PAL16V8 Pin Count RO should be: %d, and it's: %d",  7, partiallyRegistered7FPal16v8.getPinCount_RO()),  7, partiallyRegistered7FPal16v8.getPinCount_RO());
        assertEquals(String.format("Pure Combinatorial PAL16V8 Pin Count  O should be: %d, and it's: %d",  0, partiallyRegistered7FPal16v8.getPinCount_O()),   0, partiallyRegistered7FPal16v8.getPinCount_O());
    }
    
    @Test
    public void partiallyRegisteredPal16v8Features2() {
    	
    	/* ***************** Initialized for partially registered configuration PAL ***************** */
    	String[] LABELS_IN = { null, "i2", "i3", "i4", "i5", "i6", "i7", "i8", "i9", null, null,   null,   null,   null,   null,   null,   null,   null };
    	String[] LABELS_IO = { null, null, null, null, null, null, null, null, null, null, "io18", null,   null,   null,   null,   "io13", "io19", "io12" };
    	String[] LABELS_RO = { null, null, null, null, null, null, null, null, null, null, null,   "ro17", "ro16", "ro15", "ro14", null,   null,   null };
    	String[] LABELS_O  = {};

    	int roMask = 0x1E;
    	
    	PALSpecs partiallyRegistered1EPal16v8 = new PAL16V8Specs(null, roMask);
    	int partiallyRegistered1EBitMaskCLK  = Integer.parseInt(new StringBuffer("1 00000000 0 00000000".replace(" ", "")).reverse().toString(), 2);
    	int partiallyRegistered1EBitMaskOE   = Integer.parseInt(new StringBuffer("0 00000000 1 00000000".replace(" ", "")).reverse().toString(), 2);
    	int partiallyRegistered1EBitMaskIN   = Integer.parseInt(new StringBuffer("0 11111111 0 00000000".replace(" ", "")).reverse().toString(), 2);
    	int partiallyRegistered1EBitMaskIO_R = Integer.parseInt(new StringBuffer("             10000111".replace(" ", "")).reverse().toString(), 2);
    	int partiallyRegistered1EBitMaskIO_W = Integer.parseInt(new StringBuffer("0 00000000 0 10000111".replace(" ", "")).reverse().toString(), 2);
    	int partiallyRegistered1EBitMaskRO_R = Integer.parseInt(new StringBuffer("             01111000".replace(" ", "")).reverse().toString(), 2);
    	int partiallyRegistered1EBitMaskRO_W = Integer.parseInt(new StringBuffer("0 00000000 0 01111000".replace(" ", "")).reverse().toString(), 2);
    	int partiallyRegistered1EBitMaskO_R  = Integer.parseInt(new StringBuffer("             00000000".replace(" ", "")).reverse().toString(), 2);
    	int partiallyRegistered1EBitMaskO_W  = Integer.parseInt(new StringBuffer("0 00000000 0 00000000".replace(" ", "")).reverse().toString(), 2);

        assertEquals("A PAL16V8 should be variable", true, partiallyRegistered1EPal16v8.isVariable());
        
        assertEquals(String.format("Pure Combinatorial PAL16V8  CLK Mask should be: 0x%05X, and it's: 0x%05X", partiallyRegistered1EBitMaskCLK,  partiallyRegistered1EPal16v8.getMask_CLK()),  partiallyRegistered1EBitMaskCLK,  partiallyRegistered1EPal16v8.getMask_CLK());
        assertEquals(String.format("Pure Combinatorial PAL16V8   OE Mask should be: 0x%05X, and it's: 0x%05X", partiallyRegistered1EBitMaskOE,   partiallyRegistered1EPal16v8.getMask_OE()),   partiallyRegistered1EBitMaskOE,   partiallyRegistered1EPal16v8.getMask_OE());
        assertEquals(String.format("Pure Combinatorial PAL16V8   IN Mask should be: 0x%05X, and it's: 0x%05X", partiallyRegistered1EBitMaskIN,   partiallyRegistered1EPal16v8.getMask_IN()),   partiallyRegistered1EBitMaskIN,   partiallyRegistered1EPal16v8.getMask_IN());
        assertEquals(String.format("Pure Combinatorial PAL16V8 IO_R Mask should be: 0x%05X, and it's: 0x%05X", partiallyRegistered1EBitMaskIO_R, partiallyRegistered1EPal16v8.getMask_IO_R()), partiallyRegistered1EBitMaskIO_R, partiallyRegistered1EPal16v8.getMask_IO_R());
        assertEquals(String.format("Pure Combinatorial PAL16V8 IO_W Mask should be: 0x%05X, and it's: 0x%05X", partiallyRegistered1EBitMaskIO_W, partiallyRegistered1EPal16v8.getMask_IO_W()), partiallyRegistered1EBitMaskIO_W, partiallyRegistered1EPal16v8.getMask_IO_W());
        assertEquals(String.format("Pure Combinatorial PAL16V8 RO_R Mask should be: 0x%05X, and it's: 0x%05X", partiallyRegistered1EBitMaskRO_R, partiallyRegistered1EPal16v8.getMask_RO_R()), partiallyRegistered1EBitMaskRO_R, partiallyRegistered1EPal16v8.getMask_RO_R());
        assertEquals(String.format("Pure Combinatorial PAL16V8 RO_W Mask should be: 0x%05X, and it's: 0x%05X", partiallyRegistered1EBitMaskRO_W, partiallyRegistered1EPal16v8.getMask_RO_W()), partiallyRegistered1EBitMaskRO_W, partiallyRegistered1EPal16v8.getMask_RO_W());
        assertEquals(String.format("Pure Combinatorial PAL16V8  O_R Mask should be: 0x%05X, and it's: 0x%05X", partiallyRegistered1EBitMaskO_R,  partiallyRegistered1EPal16v8.getMask_O_R()),  partiallyRegistered1EBitMaskO_R,  partiallyRegistered1EPal16v8.getMask_O_R());
        assertEquals(String.format("Pure Combinatorial PAL16V8  O_W Mask should be: 0x%05X, and it's: 0x%05X", partiallyRegistered1EBitMaskO_W,  partiallyRegistered1EPal16v8.getMask_O_W()),  partiallyRegistered1EBitMaskO_W,  partiallyRegistered1EPal16v8.getMask_O_W());

        assertArrayEquals(String.format("Pure Combinatorial PAL16V8 LABELS_IN should be: %s, and it's: %S", Arrays.toString(LABELS_IN), Arrays.toString(partiallyRegistered1EPal16v8.getLabels_IN())), LABELS_IN, partiallyRegistered1EPal16v8.getLabels_IN());
        assertArrayEquals(String.format("Pure Combinatorial PAL16V8 LABELS_IO should be: %s, and it's: %S", Arrays.toString(LABELS_IO), Arrays.toString(partiallyRegistered1EPal16v8.getLabels_IO())), LABELS_IO, partiallyRegistered1EPal16v8.getLabels_IO());
        assertArrayEquals(String.format("Pure Combinatorial PAL16V8 LABELS_RO should be: %s, and it's: %S", Arrays.toString(LABELS_RO), Arrays.toString(partiallyRegistered1EPal16v8.getLabels_RO())), LABELS_RO, partiallyRegistered1EPal16v8.getLabels_RO());
        assertArrayEquals(String.format("Pure Combinatorial PAL16V8  LABELS_O should be: %s, and it's: %S", Arrays.toString(LABELS_O),  Arrays.toString(partiallyRegistered1EPal16v8.getLabels_O())),  LABELS_O,  partiallyRegistered1EPal16v8.getLabels_O());

        assertEquals(String.format("Pure Combinatorial PAL16V8 Pin Count IN should be: %d, and it's: %d",  8, partiallyRegistered1EPal16v8.getPinCount_IN()),  8, partiallyRegistered1EPal16v8.getPinCount_IN());
        assertEquals(String.format("Pure Combinatorial PAL16V8 Pin Count IO should be: %d, and it's: %d",  4, partiallyRegistered1EPal16v8.getPinCount_IO()),  4, partiallyRegistered1EPal16v8.getPinCount_IO());
        assertEquals(String.format("Pure Combinatorial PAL16V8 Pin Count RO should be: %d, and it's: %d",  4, partiallyRegistered1EPal16v8.getPinCount_RO()),  4, partiallyRegistered1EPal16v8.getPinCount_RO());
        assertEquals(String.format("Pure Combinatorial PAL16V8 Pin Count  O should be: %d, and it's: %d",  0, partiallyRegistered1EPal16v8.getPinCount_O()),   0, partiallyRegistered1EPal16v8.getPinCount_O());
    }
    
    
    
    
    
    
    /**************************************** PAL 20 X 8 **************************************************/
    
    
    
    
    @Test
    public void discardFeedbacksAllOutputsPal20l8Features() {
    	
    	/* ***************** Initialized for discard All Feedbacks and All Outputs configuration PAL ***************** */
        String[] LABELS_IN = {  "i1",  "i2",  "i3",  "i4",  "i5",  "i6",  "i7",  "i8",  "i9", "i10",   null,   null,   null,   null,   null,   null,   null,   null,  "i11",  "i13",  "i14",  "i23" };
        String[] LABELS_IO = {};
    	String[] LABELS_RO = {};
        String[] LABELS_O  = {  null,  null,  null,  null,  null,  null,  null,  null,  null,  null,  "o15",   "o16",  "o17", "o18",   "o19",  "o20",  "o21",  "o22", null,   null,   null,   null };

    	// All IOs as Outputs:
    	int ioAsOutputMask = 0x7E;

    	PALSpecs discardFeedbacksAllOutputsPal20l8 = new PAL20L8Specs(ioAsOutputMask);
    	int discardFeedbacksAllOutputsBitMaskCLK  = Integer.parseInt(new StringBuffer("0 000000000 00000000 0000".replace(" ", "")).reverse().toString(), 2);
    	int discardFeedbacksAllOutputsBitMaskOE   = Integer.parseInt(new StringBuffer("0 000000000 00000000 0000".replace(" ", "")).reverse().toString(), 2);
    	int discardFeedbacksAllOutputsBitMaskIN   = Integer.parseInt(new StringBuffer("1 111111111 00000000 1111".replace(" ", "")).reverse().toString(), 2);
    	int discardFeedbacksAllOutputsBitMaskIO_R = Integer.parseInt(new StringBuffer("            00000000     ".replace(" ", "")).reverse().toString(), 2);
    	int discardFeedbacksAllOutputsBitMaskIO_W = Integer.parseInt(new StringBuffer("0 000000000 00000000 0000".replace(" ", "")).reverse().toString(), 2);
    	int discardFeedbacksAllOutputsBitMaskRO_R = Integer.parseInt(new StringBuffer("            00000000     ".replace(" ", "")).reverse().toString(), 2);
    	int discardFeedbacksAllOutputsBitMaskRO_W = Integer.parseInt(new StringBuffer("0 000000000 00000000 0000".replace(" ", "")).reverse().toString(), 2);
    	int discardFeedbacksAllOutputsBitMaskO_R  = Integer.parseInt(new StringBuffer("            11111111     ".replace(" ", "")).reverse().toString(), 2);
    	int discardFeedbacksAllOutputsBitMaskO_W  = Integer.parseInt(new StringBuffer("0 000000000 11111111 0000".replace(" ", "")).reverse().toString(), 2);

        assertEquals("A PAL20L8 should not be variable", false, discardFeedbacksAllOutputsPal20l8.isVariable());
        
        assertEquals(String.format("Discard Feedbacks All Outputs PAL20L8  CLK Mask should be: 0x%05X, and it's: 0x%05X", discardFeedbacksAllOutputsBitMaskCLK,  discardFeedbacksAllOutputsPal20l8.getMask_CLK()),  discardFeedbacksAllOutputsBitMaskCLK,  discardFeedbacksAllOutputsPal20l8.getMask_CLK());
        assertEquals(String.format("Discard Feedbacks All Outputs PAL20L8   OE Mask should be: 0x%05X, and it's: 0x%05X", discardFeedbacksAllOutputsBitMaskOE,   discardFeedbacksAllOutputsPal20l8.getMask_OE()),   discardFeedbacksAllOutputsBitMaskOE,   discardFeedbacksAllOutputsPal20l8.getMask_OE());
        assertEquals(String.format("Discard Feedbacks All Outputs PAL20L8   IN Mask should be: 0x%05X, and it's: 0x%05X", discardFeedbacksAllOutputsBitMaskIN,   discardFeedbacksAllOutputsPal20l8.getMask_IN()),   discardFeedbacksAllOutputsBitMaskIN,   discardFeedbacksAllOutputsPal20l8.getMask_IN());
        assertEquals(String.format("Discard Feedbacks All Outputs PAL20L8 IO_R Mask should be: 0x%05X, and it's: 0x%05X", discardFeedbacksAllOutputsBitMaskIO_R, discardFeedbacksAllOutputsPal20l8.getMask_IO_R()), discardFeedbacksAllOutputsBitMaskIO_R, discardFeedbacksAllOutputsPal20l8.getMask_IO_R());
        assertEquals(String.format("Discard Feedbacks All Outputs PAL20L8 IO_W Mask should be: 0x%05X, and it's: 0x%05X", discardFeedbacksAllOutputsBitMaskIO_W, discardFeedbacksAllOutputsPal20l8.getMask_IO_W()), discardFeedbacksAllOutputsBitMaskIO_W, discardFeedbacksAllOutputsPal20l8.getMask_IO_W());
        assertEquals(String.format("Discard Feedbacks All Outputs PAL20L8 RO_R Mask should be: 0x%05X, and it's: 0x%05X", discardFeedbacksAllOutputsBitMaskRO_R, discardFeedbacksAllOutputsPal20l8.getMask_RO_R()), discardFeedbacksAllOutputsBitMaskRO_R, discardFeedbacksAllOutputsPal20l8.getMask_RO_R());
        assertEquals(String.format("Discard Feedbacks All Outputs PAL20L8 RO_W Mask should be: 0x%05X, and it's: 0x%05X", discardFeedbacksAllOutputsBitMaskRO_W, discardFeedbacksAllOutputsPal20l8.getMask_RO_W()), discardFeedbacksAllOutputsBitMaskRO_W, discardFeedbacksAllOutputsPal20l8.getMask_RO_W());
        assertEquals(String.format("Discard Feedbacks All Outputs PAL20L8  O_R Mask should be: 0x%05X, and it's: 0x%05X", discardFeedbacksAllOutputsBitMaskO_R,  discardFeedbacksAllOutputsPal20l8.getMask_O_R()),  discardFeedbacksAllOutputsBitMaskO_R,  discardFeedbacksAllOutputsPal20l8.getMask_O_R());
        assertEquals(String.format("Discard Feedbacks All Outputs PAL20L8  O_W Mask should be: 0x%05X, and it's: 0x%05X", discardFeedbacksAllOutputsBitMaskO_W,  discardFeedbacksAllOutputsPal20l8.getMask_O_W()),  discardFeedbacksAllOutputsBitMaskO_W,  discardFeedbacksAllOutputsPal20l8.getMask_O_W());

        assertArrayEquals(String.format("Discard Feedbacks All Outputs PAL20L8 LABELS_IN should be: %s, and it's: %S", Arrays.toString(LABELS_IN), Arrays.toString(discardFeedbacksAllOutputsPal20l8.getLabels_IN())), LABELS_IN, discardFeedbacksAllOutputsPal20l8.getLabels_IN());
        assertArrayEquals(String.format("Discard Feedbacks All Outputs PAL20L8 LABELS_IO should be: %s, and it's: %S", Arrays.toString(LABELS_IO), Arrays.toString(discardFeedbacksAllOutputsPal20l8.getLabels_IO())), LABELS_IO, discardFeedbacksAllOutputsPal20l8.getLabels_IO());
        assertArrayEquals(String.format("Discard Feedbacks All Outputs PAL20L8 LABELS_RO should be: %s, and it's: %S", Arrays.toString(LABELS_RO), Arrays.toString(discardFeedbacksAllOutputsPal20l8.getLabels_RO())), LABELS_RO, discardFeedbacksAllOutputsPal20l8.getLabels_RO());
        assertArrayEquals(String.format("Discard Feedbacks All Outputs PAL20L8  LABELS_O should be: %s, and it's: %S", Arrays.toString(LABELS_O),  Arrays.toString(discardFeedbacksAllOutputsPal20l8.getLabels_O())),  LABELS_O,  discardFeedbacksAllOutputsPal20l8.getLabels_O());

        assertEquals(String.format("Discard Feedbacks All Outputs PAL20L8 Pin Count IN should be: %d, and it's: %d", 14, discardFeedbacksAllOutputsPal20l8.getPinCount_IN()), 14, discardFeedbacksAllOutputsPal20l8.getPinCount_IN());
        assertEquals(String.format("Discard Feedbacks All Outputs PAL20L8 Pin Count IO should be: %d, and it's: %d",  0, discardFeedbacksAllOutputsPal20l8.getPinCount_IO()),  0, discardFeedbacksAllOutputsPal20l8.getPinCount_IO());
        assertEquals(String.format("Discard Feedbacks All Outputs PAL20L8 Pin Count RO should be: %d, and it's: %d",  0, discardFeedbacksAllOutputsPal20l8.getPinCount_RO()),  0, discardFeedbacksAllOutputsPal20l8.getPinCount_RO());
        assertEquals(String.format("Discard Feedbacks All Outputs PAL20L8 Pin Count  O should be: %d, and it's: %d",  8, discardFeedbacksAllOutputsPal20l8.getPinCount_O()),   8, discardFeedbacksAllOutputsPal20l8.getPinCount_O());
    }

    @Test
    public void discardFeedbacksAllInputsPal120l8Features() {
    	
    	/* ***************** Initialized for discard All Feedbacks and All Inputs configuration PAL ***************** */
        String[] LABELS_IN = {  "i1",  "i2",  "i3",  "i4",  "i5",  "i6",  "i7",  "i8",  "i9", "i10",   null,   "i16",  "i17", "i18",  "i19",  "i20",  "i21",  null,  "i11",  "i13",  "i14",  "i23" };
        String[] LABELS_IO = {};
    	String[] LABELS_RO = {};
        String[] LABELS_O  = {  null,  null,  null,  null,  null,  null,  null,  null,  null,  null,  "o15",   null,   null,   null,   null,   null,   null,  "o22", null,   null,   null,   null };

    	// All IOs as Inputs:
    	int ioAsOutputMask = 0x00;

    	PALSpecs discardFeedbacksAllInputsPal20v8 = new PAL20L8Specs(ioAsOutputMask);
    	int discardFeedbacksAllInputsBitMaskCLK  = Integer.parseInt(new StringBuffer("0 000000000 00000000 0000".replace(" ", "")).reverse().toString(), 2);
    	int discardFeedbacksAllInputsBitMaskOE   = Integer.parseInt(new StringBuffer("0 000000000 00000000 0000".replace(" ", "")).reverse().toString(), 2);
    	int discardFeedbacksAllInputsBitMaskIN   = Integer.parseInt(new StringBuffer("1 111111111 01111110 1111".replace(" ", "")).reverse().toString(), 2);
    	int discardFeedbacksAllInputsBitMaskIO_R = Integer.parseInt(new StringBuffer("            00000000     ".replace(" ", "")).reverse().toString(), 2);
    	int discardFeedbacksAllInputsBitMaskIO_W = Integer.parseInt(new StringBuffer("0 000000000 00000000 0000".replace(" ", "")).reverse().toString(), 2);
    	int discardFeedbacksAllInputsBitMaskRO_R = Integer.parseInt(new StringBuffer("            00000000     ".replace(" ", "")).reverse().toString(), 2);
    	int discardFeedbacksAllInputsBitMaskRO_W = Integer.parseInt(new StringBuffer("0 000000000 00000000 0000".replace(" ", "")).reverse().toString(), 2);
    	int discardFeedbacksAllInputsBitMaskO_R  = Integer.parseInt(new StringBuffer("            10000001     ".replace(" ", "")).reverse().toString(), 2);
    	int discardFeedbacksAllInputsBitMaskO_W  = Integer.parseInt(new StringBuffer("0 000000000 10000001 0000".replace(" ", "")).reverse().toString(), 2);

        assertEquals("A PAL20L8 should not be variable", false, discardFeedbacksAllInputsPal20v8.isVariable());
        
        assertEquals(String.format("Discard Feedbacks All Inputs PAL20L8  CLK Mask should be: 0x%05X, and it's: 0x%05X", discardFeedbacksAllInputsBitMaskCLK,  discardFeedbacksAllInputsPal20v8.getMask_CLK()),  discardFeedbacksAllInputsBitMaskCLK,  discardFeedbacksAllInputsPal20v8.getMask_CLK());
        assertEquals(String.format("Discard Feedbacks All Inputs PAL20L8   OE Mask should be: 0x%05X, and it's: 0x%05X", discardFeedbacksAllInputsBitMaskOE,   discardFeedbacksAllInputsPal20v8.getMask_OE()),   discardFeedbacksAllInputsBitMaskOE,   discardFeedbacksAllInputsPal20v8.getMask_OE());
        assertEquals(String.format("Discard Feedbacks All Inputs PAL20L8   IN Mask should be: 0x%05X, and it's: 0x%05X", discardFeedbacksAllInputsBitMaskIN,   discardFeedbacksAllInputsPal20v8.getMask_IN()),   discardFeedbacksAllInputsBitMaskIN,   discardFeedbacksAllInputsPal20v8.getMask_IN());
        assertEquals(String.format("Discard Feedbacks All Inputs PAL20L8 IO_R Mask should be: 0x%05X, and it's: 0x%05X", discardFeedbacksAllInputsBitMaskIO_R, discardFeedbacksAllInputsPal20v8.getMask_IO_R()), discardFeedbacksAllInputsBitMaskIO_R, discardFeedbacksAllInputsPal20v8.getMask_IO_R());
        assertEquals(String.format("Discard Feedbacks All Inputs PAL20L8 IO_W Mask should be: 0x%05X, and it's: 0x%05X", discardFeedbacksAllInputsBitMaskIO_W, discardFeedbacksAllInputsPal20v8.getMask_IO_W()), discardFeedbacksAllInputsBitMaskIO_W, discardFeedbacksAllInputsPal20v8.getMask_IO_W());
        assertEquals(String.format("Discard Feedbacks All Inputs PAL20L8 RO_R Mask should be: 0x%05X, and it's: 0x%05X", discardFeedbacksAllInputsBitMaskRO_R, discardFeedbacksAllInputsPal20v8.getMask_RO_R()), discardFeedbacksAllInputsBitMaskRO_R, discardFeedbacksAllInputsPal20v8.getMask_RO_R());
        assertEquals(String.format("Discard Feedbacks All Inputs PAL20L8 RO_W Mask should be: 0x%05X, and it's: 0x%05X", discardFeedbacksAllInputsBitMaskRO_W, discardFeedbacksAllInputsPal20v8.getMask_RO_W()), discardFeedbacksAllInputsBitMaskRO_W, discardFeedbacksAllInputsPal20v8.getMask_RO_W());
        assertEquals(String.format("Discard Feedbacks All Inputs PAL20L8  O_R Mask should be: 0x%05X, and it's: 0x%05X", discardFeedbacksAllInputsBitMaskO_R,  discardFeedbacksAllInputsPal20v8.getMask_O_R()),  discardFeedbacksAllInputsBitMaskO_R,  discardFeedbacksAllInputsPal20v8.getMask_O_R());
        assertEquals(String.format("Discard Feedbacks All Inputs PAL20L8  O_W Mask should be: 0x%05X, and it's: 0x%05X", discardFeedbacksAllInputsBitMaskO_W,  discardFeedbacksAllInputsPal20v8.getMask_O_W()),  discardFeedbacksAllInputsBitMaskO_W,  discardFeedbacksAllInputsPal20v8.getMask_O_W());

        assertArrayEquals(String.format("Discard Feedbacks All Inputs PAL20L8 LABELS_IN should be: %s, and it's: %S", Arrays.toString(LABELS_IN), Arrays.toString(discardFeedbacksAllInputsPal20v8.getLabels_IN())), LABELS_IN, discardFeedbacksAllInputsPal20v8.getLabels_IN());
        assertArrayEquals(String.format("Discard Feedbacks All Inputs PAL20L8 LABELS_IO should be: %s, and it's: %S", Arrays.toString(LABELS_IO), Arrays.toString(discardFeedbacksAllInputsPal20v8.getLabels_IO())), LABELS_IO, discardFeedbacksAllInputsPal20v8.getLabels_IO());
        assertArrayEquals(String.format("Discard Feedbacks All Inputs PAL20L8 LABELS_RO should be: %s, and it's: %S", Arrays.toString(LABELS_RO), Arrays.toString(discardFeedbacksAllInputsPal20v8.getLabels_RO())), LABELS_RO, discardFeedbacksAllInputsPal20v8.getLabels_RO());
        assertArrayEquals(String.format("Discard Feedbacks All Inputs PAL20L8  LABELS_O should be: %s, and it's: %S", Arrays.toString(LABELS_O),  Arrays.toString(discardFeedbacksAllInputsPal20v8.getLabels_O())),  LABELS_O,  discardFeedbacksAllInputsPal20v8.getLabels_O());

        assertEquals(String.format("Discard Feedbacks All Inputs PAL20L8 Pin Count IN should be: %d, and it's: %d", 20, discardFeedbacksAllInputsPal20v8.getPinCount_IN()), 20, discardFeedbacksAllInputsPal20v8.getPinCount_IN());
        assertEquals(String.format("Discard Feedbacks All Inputs PAL20L8 Pin Count IO should be: %d, and it's: %d",  0, discardFeedbacksAllInputsPal20v8.getPinCount_IO()),  0, discardFeedbacksAllInputsPal20v8.getPinCount_IO());
        assertEquals(String.format("Discard Feedbacks All Inputs PAL20L8 Pin Count RO should be: %d, and it's: %d",  0, discardFeedbacksAllInputsPal20v8.getPinCount_RO()),  0, discardFeedbacksAllInputsPal20v8.getPinCount_RO());
        assertEquals(String.format("Discard Feedbacks All Inputs PAL20L8 Pin Count  O should be: %d, and it's: %d",  2, discardFeedbacksAllInputsPal20v8.getPinCount_O()),   2, discardFeedbacksAllInputsPal20v8.getPinCount_O());
    }

    @Test
    public void discardFeedbacksMixedInputsAndOutputsPal20l8Features() {
    	
    	/* ***************** Initialized for discard All Feedbacks and Mixed Inputs and Outputs configuration PAL ***************** */
        String[] LABELS_IN = {  "i1",  "i2",  "i3",  "i4",  "i5",  "i6",  "i7",  "i8",  "i9", "i10",   null,   "i16",  "i17",  null,  "i19",  "i20",   null,   null,  "i11",  "i13",  "i14",  "i23" };
        String[] LABELS_IO = {};
    	String[] LABELS_RO = {};
        String[] LABELS_O  = {  null,  null,  null,  null,  null,  null,  null,  null,  null,  null,  "o15",   null,   null,   "o18",   null,   null,  "o21",  "o22", null,   null,   null,   null };

    	// Mixed IOs as Inputs and Outputs:
    	int ioAsOutputMask = 0x48;

    	PALSpecs discardFeedbacksMixedInputsAndOutputsPal20v8 = new PAL20L8Specs(ioAsOutputMask);
    	int discardFeedbacksMixedInputsAndOutputsBitMaskCLK  = Integer.parseInt(new StringBuffer("0 000000000 00000000 0000".replace(" ", "")).reverse().toString(), 2);
    	int discardFeedbacksMixedInputsAndOutputsBitMaskOE   = Integer.parseInt(new StringBuffer("0 000000000 00000000 0000".replace(" ", "")).reverse().toString(), 2);
    	int discardFeedbacksMixedInputsAndOutputsBitMaskIN   = Integer.parseInt(new StringBuffer("1 111111111 01101100 1111".replace(" ", "")).reverse().toString(), 2);
    	int discardFeedbacksMixedInputsAndOutputsBitMaskIO_R = Integer.parseInt(new StringBuffer("            00000000     ".replace(" ", "")).reverse().toString(), 2);
    	int discardFeedbacksMixedInputsAndOutputsBitMaskIO_W = Integer.parseInt(new StringBuffer("0 000000000 00000000 0000".replace(" ", "")).reverse().toString(), 2);
    	int discardFeedbacksMixedInputsAndOutputsBitMaskRO_R = Integer.parseInt(new StringBuffer("            00000000     ".replace(" ", "")).reverse().toString(), 2);
    	int discardFeedbacksMixedInputsAndOutputsBitMaskRO_W = Integer.parseInt(new StringBuffer("0 000000000 00000000 0000".replace(" ", "")).reverse().toString(), 2);
    	int discardFeedbacksMixedInputsAndOutputsBitMaskO_R  = Integer.parseInt(new StringBuffer("            10010011     ".replace(" ", "")).reverse().toString(), 2);
    	int discardFeedbacksMixedInputsAndOutputsBitMaskO_W  = Integer.parseInt(new StringBuffer("0 000000000 10010011 0000".replace(" ", "")).reverse().toString(), 2);

        assertEquals("A PAL20L8 should not be variable", false, discardFeedbacksMixedInputsAndOutputsPal20v8.isVariable());
        
        assertEquals(String.format("Discard Feedbacks Mixed Inputs And Outputs PAL20L8  CLK Mask should be: 0x%05X, and it's: 0x%05X", discardFeedbacksMixedInputsAndOutputsBitMaskCLK,  discardFeedbacksMixedInputsAndOutputsPal20v8.getMask_CLK()),  discardFeedbacksMixedInputsAndOutputsBitMaskCLK,  discardFeedbacksMixedInputsAndOutputsPal20v8.getMask_CLK());
        assertEquals(String.format("Discard Feedbacks Mixed Inputs And Outputs PAL20L8   OE Mask should be: 0x%05X, and it's: 0x%05X", discardFeedbacksMixedInputsAndOutputsBitMaskOE,   discardFeedbacksMixedInputsAndOutputsPal20v8.getMask_OE()),   discardFeedbacksMixedInputsAndOutputsBitMaskOE,   discardFeedbacksMixedInputsAndOutputsPal20v8.getMask_OE());
        assertEquals(String.format("Discard Feedbacks Mixed Inputs And Outputs PAL20L8   IN Mask should be: 0x%05X, and it's: 0x%05X", discardFeedbacksMixedInputsAndOutputsBitMaskIN,   discardFeedbacksMixedInputsAndOutputsPal20v8.getMask_IN()),   discardFeedbacksMixedInputsAndOutputsBitMaskIN,   discardFeedbacksMixedInputsAndOutputsPal20v8.getMask_IN());
        assertEquals(String.format("Discard Feedbacks Mixed Inputs And Outputs PAL20L8 IO_R Mask should be: 0x%05X, and it's: 0x%05X", discardFeedbacksMixedInputsAndOutputsBitMaskIO_R, discardFeedbacksMixedInputsAndOutputsPal20v8.getMask_IO_R()), discardFeedbacksMixedInputsAndOutputsBitMaskIO_R, discardFeedbacksMixedInputsAndOutputsPal20v8.getMask_IO_R());
        assertEquals(String.format("Discard Feedbacks Mixed Inputs And Outputs PAL20L8 IO_W Mask should be: 0x%05X, and it's: 0x%05X", discardFeedbacksMixedInputsAndOutputsBitMaskIO_W, discardFeedbacksMixedInputsAndOutputsPal20v8.getMask_IO_W()), discardFeedbacksMixedInputsAndOutputsBitMaskIO_W, discardFeedbacksMixedInputsAndOutputsPal20v8.getMask_IO_W());
        assertEquals(String.format("Discard Feedbacks Mixed Inputs And Outputs PAL20L8 RO_R Mask should be: 0x%05X, and it's: 0x%05X", discardFeedbacksMixedInputsAndOutputsBitMaskRO_R, discardFeedbacksMixedInputsAndOutputsPal20v8.getMask_RO_R()), discardFeedbacksMixedInputsAndOutputsBitMaskRO_R, discardFeedbacksMixedInputsAndOutputsPal20v8.getMask_RO_R());
        assertEquals(String.format("Discard Feedbacks Mixed Inputs And Outputs PAL20L8 RO_W Mask should be: 0x%05X, and it's: 0x%05X", discardFeedbacksMixedInputsAndOutputsBitMaskRO_W, discardFeedbacksMixedInputsAndOutputsPal20v8.getMask_RO_W()), discardFeedbacksMixedInputsAndOutputsBitMaskRO_W, discardFeedbacksMixedInputsAndOutputsPal20v8.getMask_RO_W());
        assertEquals(String.format("Discard Feedbacks Mixed Inputs And Outputs PAL20L8  O_R Mask should be: 0x%05X, and it's: 0x%05X", discardFeedbacksMixedInputsAndOutputsBitMaskO_R,  discardFeedbacksMixedInputsAndOutputsPal20v8.getMask_O_R()),  discardFeedbacksMixedInputsAndOutputsBitMaskO_R,  discardFeedbacksMixedInputsAndOutputsPal20v8.getMask_O_R());
        assertEquals(String.format("Discard Feedbacks Mixed Inputs And Outputs PAL20L8  O_W Mask should be: 0x%05X, and it's: 0x%05X", discardFeedbacksMixedInputsAndOutputsBitMaskO_W,  discardFeedbacksMixedInputsAndOutputsPal20v8.getMask_O_W()),  discardFeedbacksMixedInputsAndOutputsBitMaskO_W,  discardFeedbacksMixedInputsAndOutputsPal20v8.getMask_O_W());

        assertArrayEquals(String.format("Discard Feedbacks Mixed Inputs And Outputs PAL20L8 LABELS_IN should be: %s, and it's: %S", Arrays.toString(LABELS_IN), Arrays.toString(discardFeedbacksMixedInputsAndOutputsPal20v8.getLabels_IN())), LABELS_IN, discardFeedbacksMixedInputsAndOutputsPal20v8.getLabels_IN());
        assertArrayEquals(String.format("Discard Feedbacks Mixed Inputs And Outputs PAL20L8 LABELS_IO should be: %s, and it's: %S", Arrays.toString(LABELS_IO), Arrays.toString(discardFeedbacksMixedInputsAndOutputsPal20v8.getLabels_IO())), LABELS_IO, discardFeedbacksMixedInputsAndOutputsPal20v8.getLabels_IO());
        assertArrayEquals(String.format("Discard Feedbacks Mixed Inputs And Outputs PAL20L8 LABELS_RO should be: %s, and it's: %S", Arrays.toString(LABELS_RO), Arrays.toString(discardFeedbacksMixedInputsAndOutputsPal20v8.getLabels_RO())), LABELS_RO, discardFeedbacksMixedInputsAndOutputsPal20v8.getLabels_RO());
        assertArrayEquals(String.format("Discard Feedbacks Mixed Inputs And Outputs PAL20L8  LABELS_O should be: %s, and it's: %S", Arrays.toString(LABELS_O),  Arrays.toString(discardFeedbacksMixedInputsAndOutputsPal20v8.getLabels_O())),  LABELS_O,  discardFeedbacksMixedInputsAndOutputsPal20v8.getLabels_O());

        assertEquals(String.format("Discard Feedbacks Mixed Inputs And Outputs PAL20L8 Pin Count IN should be: %d, and it's: %d", 18, discardFeedbacksMixedInputsAndOutputsPal20v8.getPinCount_IN()), 18, discardFeedbacksMixedInputsAndOutputsPal20v8.getPinCount_IN());
        assertEquals(String.format("Discard Feedbacks Mixed Inputs And Outputs PAL20L8 Pin Count IO should be: %d, and it's: %d",  0, discardFeedbacksMixedInputsAndOutputsPal20v8.getPinCount_IO()),  0, discardFeedbacksMixedInputsAndOutputsPal20v8.getPinCount_IO());
        assertEquals(String.format("Discard Feedbacks Mixed Inputs And Outputs PAL20L8 Pin Count RO should be: %d, and it's: %d",  0, discardFeedbacksMixedInputsAndOutputsPal20v8.getPinCount_RO()),  0, discardFeedbacksMixedInputsAndOutputsPal20v8.getPinCount_RO());
        assertEquals(String.format("Discard Feedbacks Mixed Inputs And Outputs PAL20L8 Pin Count  O should be: %d, and it's: %d",  4, discardFeedbacksMixedInputsAndOutputsPal20v8.getPinCount_O()),   4, discardFeedbacksMixedInputsAndOutputsPal20v8.getPinCount_O());
    }
    
    @Test
    public void pureCombinatorialPal20v8Features() {

    	/* ***************** Initialized for pure combinatorial configuration PAL ***************** */
        String[] LABELS_IN = {  "i1",  "i2",  "i3",  "i4",  "i5",  "i6",  "i7",  "i8",  "i9", "i10",   null,   null,   null,   null,   null,   null,   null,   null,  "i11",  "i13",  "i14",  "i23" };
        String[] LABELS_IO = {  null,  null,  null,  null,  null,  null,  null,  null,  null,  null,  "io15", "io16", "io17", "io18", "io19", "io20", "io21", "io22", null,   null,   null,   null };
    	String[] LABELS_RO = {};
    	String[] LABELS_O  = {};

    	PALSpecs pureCombinatorialPal20v8 = new PAL20V8Specs();
    	int pureCombinatorialBitMaskCLK  = Integer.parseInt(new StringBuffer("0 000000000 00000000 0000".replace(" ", "")).reverse().toString(), 2);
    	int pureCombinatorialBitMaskOE   = Integer.parseInt(new StringBuffer("0 000000000 00000000 0000".replace(" ", "")).reverse().toString(), 2);
    	int pureCombinatorialBitMaskIN   = Integer.parseInt(new StringBuffer("1 111111111 00000000 1111".replace(" ", "")).reverse().toString(), 2);
    	int pureCombinatorialBitMaskIO_R = Integer.parseInt(new StringBuffer("            11111111     ".replace(" ", "")).reverse().toString(), 2);
    	int pureCombinatorialBitMaskIO_W = Integer.parseInt(new StringBuffer("0 000000000 11111111 0000".replace(" ", "")).reverse().toString(), 2);
    	int pureCombinatorialBitMaskRO_R = Integer.parseInt(new StringBuffer("            00000000     ".replace(" ", "")).reverse().toString(), 2);
    	int pureCombinatorialBitMaskRO_W = Integer.parseInt(new StringBuffer("0 000000000 00000000 0000".replace(" ", "")).reverse().toString(), 2);
    	int pureCombinatorialBitMaskO_R  = Integer.parseInt(new StringBuffer("            00000000 0000".replace(" ", "")).reverse().toString(), 2);
    	int pureCombinatorialBitMaskO_W  = Integer.parseInt(new StringBuffer("0 000000000 00000000 0000".replace(" ", "")).reverse().toString(), 2);

        assertEquals("A PAL20V8 should be variable", true, pureCombinatorialPal20v8.isVariable());
        
        assertEquals(String.format("Pure Combinatorial PAL20V8  CLK Mask should be: 0x%05X, and it's: 0x%05X", pureCombinatorialBitMaskCLK,  pureCombinatorialPal20v8.getMask_CLK()),  pureCombinatorialBitMaskCLK,  pureCombinatorialPal20v8.getMask_CLK());
        assertEquals(String.format("Pure Combinatorial PAL20V8   OE Mask should be: 0x%05X, and it's: 0x%05X", pureCombinatorialBitMaskOE,   pureCombinatorialPal20v8.getMask_OE()),   pureCombinatorialBitMaskOE,   pureCombinatorialPal20v8.getMask_OE());
        assertEquals(String.format("Pure Combinatorial PAL20V8   IN Mask should be: 0x%05X, and it's: 0x%05X", pureCombinatorialBitMaskIN,   pureCombinatorialPal20v8.getMask_IN()),   pureCombinatorialBitMaskIN,   pureCombinatorialPal20v8.getMask_IN());
        assertEquals(String.format("Pure Combinatorial PAL20V8 IO_R Mask should be: 0x%05X, and it's: 0x%05X", pureCombinatorialBitMaskIO_R, pureCombinatorialPal20v8.getMask_IO_R()), pureCombinatorialBitMaskIO_R, pureCombinatorialPal20v8.getMask_IO_R());
        assertEquals(String.format("Pure Combinatorial PAL20V8 IO_W Mask should be: 0x%05X, and it's: 0x%05X", pureCombinatorialBitMaskIO_W, pureCombinatorialPal20v8.getMask_IO_W()), pureCombinatorialBitMaskIO_W, pureCombinatorialPal20v8.getMask_IO_W());
        assertEquals(String.format("Pure Combinatorial PAL20V8 RO_R Mask should be: 0x%05X, and it's: 0x%05X", pureCombinatorialBitMaskRO_R, pureCombinatorialPal20v8.getMask_RO_R()), pureCombinatorialBitMaskRO_R, pureCombinatorialPal20v8.getMask_RO_R());
        assertEquals(String.format("Pure Combinatorial PAL20V8 RO_W Mask should be: 0x%05X, and it's: 0x%05X", pureCombinatorialBitMaskRO_W, pureCombinatorialPal20v8.getMask_RO_W()), pureCombinatorialBitMaskRO_W, pureCombinatorialPal20v8.getMask_RO_W());
        assertEquals(String.format("Pure Combinatorial PAL20V8  O_R Mask should be: 0x%05X, and it's: 0x%05X", pureCombinatorialBitMaskO_R,  pureCombinatorialPal20v8.getMask_O_R()),  pureCombinatorialBitMaskO_R,  pureCombinatorialPal20v8.getMask_O_R());
        assertEquals(String.format("Pure Combinatorial PAL20V8  O_W Mask should be: 0x%05X, and it's: 0x%05X", pureCombinatorialBitMaskO_W,  pureCombinatorialPal20v8.getMask_O_W()),  pureCombinatorialBitMaskO_W,  pureCombinatorialPal20v8.getMask_O_W());

        assertArrayEquals(String.format("Pure Combinatorial PAL20V8 LABELS_IN should be: %s, and it's: %S", Arrays.toString(LABELS_IN), Arrays.toString(pureCombinatorialPal20v8.getLabels_IN())), LABELS_IN, pureCombinatorialPal20v8.getLabels_IN());
        assertArrayEquals(String.format("Pure Combinatorial PAL20V8 LABELS_IO should be: %s, and it's: %S", Arrays.toString(LABELS_IO), Arrays.toString(pureCombinatorialPal20v8.getLabels_IO())), LABELS_IO, pureCombinatorialPal20v8.getLabels_IO());
        assertArrayEquals(String.format("Pure Combinatorial PAL20V8 LABELS_RO should be: %s, and it's: %S", Arrays.toString(LABELS_RO), Arrays.toString(pureCombinatorialPal20v8.getLabels_RO())), LABELS_RO, pureCombinatorialPal20v8.getLabels_RO());
        assertArrayEquals(String.format("Pure Combinatorial PAL20V8  LABELS_O should be: %s, and it's: %S", Arrays.toString(LABELS_O),  Arrays.toString(pureCombinatorialPal20v8.getLabels_O())),  LABELS_O,  pureCombinatorialPal20v8.getLabels_O());

        assertEquals(String.format("Pure Combinatorial PAL20V8 Pin Count IN should be: %d, and it's: %d", 14, pureCombinatorialPal20v8.getPinCount_IN()), 14, pureCombinatorialPal20v8.getPinCount_IN());
        assertEquals(String.format("Pure Combinatorial PAL20V8 Pin Count IO should be: %d, and it's: %d",  8, pureCombinatorialPal20v8.getPinCount_IO()),  8, pureCombinatorialPal20v8.getPinCount_IO());
        assertEquals(String.format("Pure Combinatorial PAL20V8 Pin Count RO should be: %d, and it's: %d",  0, pureCombinatorialPal20v8.getPinCount_RO()),  0, pureCombinatorialPal20v8.getPinCount_RO());
        assertEquals(String.format("Pure Combinatorial PAL20V8 Pin Count  O should be: %d, and it's: %d",  0, pureCombinatorialPal20v8.getPinCount_O()),   0, pureCombinatorialPal20v8.getPinCount_O());
    }
    
    @Test
    public void pureCombinatorialDiscardFeedbacksAllOutputsPal20v8Features() {

    	/* ***************** Initialized for pure combinatorial configuration PAL ***************** */
        String[] LABELS_IN = {  "i1",  "i2",  "i3",  "i4",  "i5",  "i6",  "i7",  "i8",  "i9", "i10",   null,   null,   null,   null,   null,   null,   null,   null,  "i11",  "i13",  "i14",  "i23" };
        String[] LABELS_IO = {};
    	String[] LABELS_RO = {};
        String[] LABELS_O  = {  null,  null,  null,  null,  null,  null,  null,  null,  null,  null,  "o15",   "o16",  "o17", "o18",   "o19",  "o20",  "o21",  "o22", null,   null,   null,   null };

    	// All IOs as Outputs:
    	int ioAsOutputMask = 0xFF;

    	PALSpecs pureCombinatorialDiscardFeedbacksAllOutputsPal20v8 = new PAL20V8Specs(ioAsOutputMask);
    	int pureCombinatorialDiscardFeedbacksAllOutputsBitMaskCLK  = Integer.parseInt(new StringBuffer("0 000000000 00000000 0000".replace(" ", "")).reverse().toString(), 2);
    	int pureCombinatorialDiscardFeedbacksAllOutputsBitMaskOE   = Integer.parseInt(new StringBuffer("0 000000000 00000000 0000".replace(" ", "")).reverse().toString(), 2);
    	int pureCombinatorialDiscardFeedbacksAllOutputsBitMaskIN   = Integer.parseInt(new StringBuffer("1 111111111 00000000 1111".replace(" ", "")).reverse().toString(), 2);
    	int pureCombinatorialDiscardFeedbacksAllOutputsBitMaskIO_R = Integer.parseInt(new StringBuffer("            00000000     ".replace(" ", "")).reverse().toString(), 2);
    	int pureCombinatorialDiscardFeedbacksAllOutputsBitMaskIO_W = Integer.parseInt(new StringBuffer("0 000000000 00000000 0000".replace(" ", "")).reverse().toString(), 2);
    	int pureCombinatorialDiscardFeedbacksAllOutputsBitMaskRO_R = Integer.parseInt(new StringBuffer("            00000000     ".replace(" ", "")).reverse().toString(), 2);
    	int pureCombinatorialDiscardFeedbacksAllOutputsBitMaskRO_W = Integer.parseInt(new StringBuffer("0 000000000 00000000 0000".replace(" ", "")).reverse().toString(), 2);
    	int pureCombinatorialDiscardFeedbacksAllOutputsBitMaskO_R  = Integer.parseInt(new StringBuffer("            11111111 0000".replace(" ", "")).reverse().toString(), 2);
    	int pureCombinatorialDiscardFeedbacksAllOutputsBitMaskO_W  = Integer.parseInt(new StringBuffer("0 000000000 11111111 0000".replace(" ", "")).reverse().toString(), 2);

        assertEquals("A PAL20V8 should be variable", true, pureCombinatorialDiscardFeedbacksAllOutputsPal20v8.isVariable());
        
        assertEquals(String.format("Pure Combinatorial Discard Feedbacks All Outputs PAL20V8  CLK Mask should be: 0x%05X, and it's: 0x%05X", pureCombinatorialDiscardFeedbacksAllOutputsBitMaskCLK,  pureCombinatorialDiscardFeedbacksAllOutputsPal20v8.getMask_CLK()),  pureCombinatorialDiscardFeedbacksAllOutputsBitMaskCLK,  pureCombinatorialDiscardFeedbacksAllOutputsPal20v8.getMask_CLK());
        assertEquals(String.format("Pure Combinatorial Discard Feedbacks All Outputs PAL20V8   OE Mask should be: 0x%05X, and it's: 0x%05X", pureCombinatorialDiscardFeedbacksAllOutputsBitMaskOE,   pureCombinatorialDiscardFeedbacksAllOutputsPal20v8.getMask_OE()),   pureCombinatorialDiscardFeedbacksAllOutputsBitMaskOE,   pureCombinatorialDiscardFeedbacksAllOutputsPal20v8.getMask_OE());
        assertEquals(String.format("Pure Combinatorial Discard Feedbacks All Outputs PAL20V8   IN Mask should be: 0x%05X, and it's: 0x%05X", pureCombinatorialDiscardFeedbacksAllOutputsBitMaskIN,   pureCombinatorialDiscardFeedbacksAllOutputsPal20v8.getMask_IN()),   pureCombinatorialDiscardFeedbacksAllOutputsBitMaskIN,   pureCombinatorialDiscardFeedbacksAllOutputsPal20v8.getMask_IN());
        assertEquals(String.format("Pure Combinatorial Discard Feedbacks All Outputs PAL20V8 IO_R Mask should be: 0x%05X, and it's: 0x%05X", pureCombinatorialDiscardFeedbacksAllOutputsBitMaskIO_R, pureCombinatorialDiscardFeedbacksAllOutputsPal20v8.getMask_IO_R()), pureCombinatorialDiscardFeedbacksAllOutputsBitMaskIO_R, pureCombinatorialDiscardFeedbacksAllOutputsPal20v8.getMask_IO_R());
        assertEquals(String.format("Pure Combinatorial Discard Feedbacks All Outputs PAL20V8 IO_W Mask should be: 0x%05X, and it's: 0x%05X", pureCombinatorialDiscardFeedbacksAllOutputsBitMaskIO_W, pureCombinatorialDiscardFeedbacksAllOutputsPal20v8.getMask_IO_W()), pureCombinatorialDiscardFeedbacksAllOutputsBitMaskIO_W, pureCombinatorialDiscardFeedbacksAllOutputsPal20v8.getMask_IO_W());
        assertEquals(String.format("Pure Combinatorial Discard Feedbacks All Outputs PAL20V8 RO_R Mask should be: 0x%05X, and it's: 0x%05X", pureCombinatorialDiscardFeedbacksAllOutputsBitMaskRO_R, pureCombinatorialDiscardFeedbacksAllOutputsPal20v8.getMask_RO_R()), pureCombinatorialDiscardFeedbacksAllOutputsBitMaskRO_R, pureCombinatorialDiscardFeedbacksAllOutputsPal20v8.getMask_RO_R());
        assertEquals(String.format("Pure Combinatorial Discard Feedbacks All Outputs PAL20V8 RO_W Mask should be: 0x%05X, and it's: 0x%05X", pureCombinatorialDiscardFeedbacksAllOutputsBitMaskRO_W, pureCombinatorialDiscardFeedbacksAllOutputsPal20v8.getMask_RO_W()), pureCombinatorialDiscardFeedbacksAllOutputsBitMaskRO_W, pureCombinatorialDiscardFeedbacksAllOutputsPal20v8.getMask_RO_W());
        assertEquals(String.format("Pure Combinatorial Discard Feedbacks All Outputs PAL20V8  O_R Mask should be: 0x%05X, and it's: 0x%05X", pureCombinatorialDiscardFeedbacksAllOutputsBitMaskO_R,  pureCombinatorialDiscardFeedbacksAllOutputsPal20v8.getMask_O_R()),  pureCombinatorialDiscardFeedbacksAllOutputsBitMaskO_R,  pureCombinatorialDiscardFeedbacksAllOutputsPal20v8.getMask_O_R());
        assertEquals(String.format("Pure Combinatorial Discard Feedbacks All Outputs PAL20V8  O_W Mask should be: 0x%05X, and it's: 0x%05X", pureCombinatorialDiscardFeedbacksAllOutputsBitMaskO_W,  pureCombinatorialDiscardFeedbacksAllOutputsPal20v8.getMask_O_W()),  pureCombinatorialDiscardFeedbacksAllOutputsBitMaskO_W,  pureCombinatorialDiscardFeedbacksAllOutputsPal20v8.getMask_O_W());

        assertArrayEquals(String.format("Pure Combinatorial Discard Feedbacks All Outputs PAL20V8 LABELS_IN should be: %s, and it's: %S", Arrays.toString(LABELS_IN), Arrays.toString(pureCombinatorialDiscardFeedbacksAllOutputsPal20v8.getLabels_IN())), LABELS_IN, pureCombinatorialDiscardFeedbacksAllOutputsPal20v8.getLabels_IN());
        assertArrayEquals(String.format("Pure Combinatorial Discard Feedbacks All Outputs PAL20V8 LABELS_IO should be: %s, and it's: %S", Arrays.toString(LABELS_IO), Arrays.toString(pureCombinatorialDiscardFeedbacksAllOutputsPal20v8.getLabels_IO())), LABELS_IO, pureCombinatorialDiscardFeedbacksAllOutputsPal20v8.getLabels_IO());
        assertArrayEquals(String.format("Pure Combinatorial Discard Feedbacks All Outputs PAL20V8 LABELS_RO should be: %s, and it's: %S", Arrays.toString(LABELS_RO), Arrays.toString(pureCombinatorialDiscardFeedbacksAllOutputsPal20v8.getLabels_RO())), LABELS_RO, pureCombinatorialDiscardFeedbacksAllOutputsPal20v8.getLabels_RO());
        assertArrayEquals(String.format("Pure Combinatorial Discard Feedbacks All Outputs PAL20V8  LABELS_O should be: %s, and it's: %S", Arrays.toString(LABELS_O),  Arrays.toString(pureCombinatorialDiscardFeedbacksAllOutputsPal20v8.getLabels_O())),  LABELS_O,  pureCombinatorialDiscardFeedbacksAllOutputsPal20v8.getLabels_O());

        assertEquals(String.format("Pure Combinatorial Discard Feedbacks All Outputs PAL20V8 Pin Count IN should be: %d, and it's: %d", 14, pureCombinatorialDiscardFeedbacksAllOutputsPal20v8.getPinCount_IN()), 14, pureCombinatorialDiscardFeedbacksAllOutputsPal20v8.getPinCount_IN());
        assertEquals(String.format("Pure Combinatorial Discard Feedbacks All Outputs PAL20V8 Pin Count IO should be: %d, and it's: %d",  0, pureCombinatorialDiscardFeedbacksAllOutputsPal20v8.getPinCount_IO()),  0, pureCombinatorialDiscardFeedbacksAllOutputsPal20v8.getPinCount_IO());
        assertEquals(String.format("Pure Combinatorial Discard Feedbacks All Outputs PAL20V8 Pin Count RO should be: %d, and it's: %d",  0, pureCombinatorialDiscardFeedbacksAllOutputsPal20v8.getPinCount_RO()),  0, pureCombinatorialDiscardFeedbacksAllOutputsPal20v8.getPinCount_RO());
        assertEquals(String.format("Pure Combinatorial Discard Feedbacks All Outputs PAL20V8 Pin Count  O should be: %d, and it's: %d",  8, pureCombinatorialDiscardFeedbacksAllOutputsPal20v8.getPinCount_O()),   8, pureCombinatorialDiscardFeedbacksAllOutputsPal20v8.getPinCount_O());
    }

    @Test
    public void pureCombinatorialDiscardFeedbacksAllInputsPal20v8Features() {

    	/* ***************** Initialized for pure combinatorial configuration PAL ***************** */
        String[] LABELS_IN = {  "i1",  "i2",  "i3",  "i4",  "i5",  "i6",  "i7",  "i8",  "i9", "i10",  "i15", "i16", "i17", "i18", "i19", "i20", "i21", "i22",  "i11",  "i13",  "i14",  "i23" };
        String[] LABELS_IO = {};
    	String[] LABELS_RO = {};
    	String[] LABELS_O  = {};

    	// All IOs as Inputs (should never happen in real world):
    	int ioAsOutputMask = 0x00;

    	PALSpecs pureCombinatorialDiscardFeedbacksAllInputsPal20v8 = new PAL20V8Specs(ioAsOutputMask);
    	int pureCombinatorialDiscardFeedbacksAllInputsBitMaskCLK  = Integer.parseInt(new StringBuffer("0 000000000 00000000 0000".replace(" ", "")).reverse().toString(), 2);
    	int pureCombinatorialDiscardFeedbacksAllInputsBitMaskOE   = Integer.parseInt(new StringBuffer("0 000000000 00000000 0000".replace(" ", "")).reverse().toString(), 2);
    	int pureCombinatorialDiscardFeedbacksAllInputsBitMaskIN   = Integer.parseInt(new StringBuffer("1 111111111 11111111 1111".replace(" ", "")).reverse().toString(), 2);
    	int pureCombinatorialDiscardFeedbacksAllInputsBitMaskIO_R = Integer.parseInt(new StringBuffer("            00000000     ".replace(" ", "")).reverse().toString(), 2);
    	int pureCombinatorialDiscardFeedbacksAllInputsBitMaskIO_W = Integer.parseInt(new StringBuffer("0 000000000 00000000 0000".replace(" ", "")).reverse().toString(), 2);
    	int pureCombinatorialDiscardFeedbacksAllInputsBitMaskRO_R = Integer.parseInt(new StringBuffer("            00000000     ".replace(" ", "")).reverse().toString(), 2);
    	int pureCombinatorialDiscardFeedbacksAllInputsBitMaskRO_W = Integer.parseInt(new StringBuffer("0 000000000 00000000 0000".replace(" ", "")).reverse().toString(), 2);
    	int pureCombinatorialDiscardFeedbacksAllInputsBitMaskO_R  = Integer.parseInt(new StringBuffer("            00000000 0000".replace(" ", "")).reverse().toString(), 2);
    	int pureCombinatorialDiscardFeedbacksAllInputsBitMaskO_W  = Integer.parseInt(new StringBuffer("0 000000000 00000000 0000".replace(" ", "")).reverse().toString(), 2);

        assertEquals("A PAL20V8 should be variable", true, pureCombinatorialDiscardFeedbacksAllInputsPal20v8.isVariable());
        
        assertEquals(String.format("Pure Combinatorial Discard Feedbacks All Inputs PAL20V8  CLK Mask should be: 0x%05X, and it's: 0x%05X", pureCombinatorialDiscardFeedbacksAllInputsBitMaskCLK,  pureCombinatorialDiscardFeedbacksAllInputsPal20v8.getMask_CLK()),  pureCombinatorialDiscardFeedbacksAllInputsBitMaskCLK,  pureCombinatorialDiscardFeedbacksAllInputsPal20v8.getMask_CLK());
        assertEquals(String.format("Pure Combinatorial Discard Feedbacks All Inputs PAL20V8   OE Mask should be: 0x%05X, and it's: 0x%05X", pureCombinatorialDiscardFeedbacksAllInputsBitMaskOE,   pureCombinatorialDiscardFeedbacksAllInputsPal20v8.getMask_OE()),   pureCombinatorialDiscardFeedbacksAllInputsBitMaskOE,   pureCombinatorialDiscardFeedbacksAllInputsPal20v8.getMask_OE());
        assertEquals(String.format("Pure Combinatorial Discard Feedbacks All Inputs PAL20V8   IN Mask should be: 0x%05X, and it's: 0x%05X", pureCombinatorialDiscardFeedbacksAllInputsBitMaskIN,   pureCombinatorialDiscardFeedbacksAllInputsPal20v8.getMask_IN()),   pureCombinatorialDiscardFeedbacksAllInputsBitMaskIN,   pureCombinatorialDiscardFeedbacksAllInputsPal20v8.getMask_IN());
        assertEquals(String.format("Pure Combinatorial Discard Feedbacks All Inputs PAL20V8 IO_R Mask should be: 0x%05X, and it's: 0x%05X", pureCombinatorialDiscardFeedbacksAllInputsBitMaskIO_R, pureCombinatorialDiscardFeedbacksAllInputsPal20v8.getMask_IO_R()), pureCombinatorialDiscardFeedbacksAllInputsBitMaskIO_R, pureCombinatorialDiscardFeedbacksAllInputsPal20v8.getMask_IO_R());
        assertEquals(String.format("Pure Combinatorial Discard Feedbacks All Inputs PAL20V8 IO_W Mask should be: 0x%05X, and it's: 0x%05X", pureCombinatorialDiscardFeedbacksAllInputsBitMaskIO_W, pureCombinatorialDiscardFeedbacksAllInputsPal20v8.getMask_IO_W()), pureCombinatorialDiscardFeedbacksAllInputsBitMaskIO_W, pureCombinatorialDiscardFeedbacksAllInputsPal20v8.getMask_IO_W());
        assertEquals(String.format("Pure Combinatorial Discard Feedbacks All Inputs PAL20V8 RO_R Mask should be: 0x%05X, and it's: 0x%05X", pureCombinatorialDiscardFeedbacksAllInputsBitMaskRO_R, pureCombinatorialDiscardFeedbacksAllInputsPal20v8.getMask_RO_R()), pureCombinatorialDiscardFeedbacksAllInputsBitMaskRO_R, pureCombinatorialDiscardFeedbacksAllInputsPal20v8.getMask_RO_R());
        assertEquals(String.format("Pure Combinatorial Discard Feedbacks All Inputs PAL20V8 RO_W Mask should be: 0x%05X, and it's: 0x%05X", pureCombinatorialDiscardFeedbacksAllInputsBitMaskRO_W, pureCombinatorialDiscardFeedbacksAllInputsPal20v8.getMask_RO_W()), pureCombinatorialDiscardFeedbacksAllInputsBitMaskRO_W, pureCombinatorialDiscardFeedbacksAllInputsPal20v8.getMask_RO_W());
        assertEquals(String.format("Pure Combinatorial Discard Feedbacks All Inputs PAL20V8  O_R Mask should be: 0x%05X, and it's: 0x%05X", pureCombinatorialDiscardFeedbacksAllInputsBitMaskO_R,  pureCombinatorialDiscardFeedbacksAllInputsPal20v8.getMask_O_R()),  pureCombinatorialDiscardFeedbacksAllInputsBitMaskO_R,  pureCombinatorialDiscardFeedbacksAllInputsPal20v8.getMask_O_R());
        assertEquals(String.format("Pure Combinatorial Discard Feedbacks All Inputs PAL20V8  O_W Mask should be: 0x%05X, and it's: 0x%05X", pureCombinatorialDiscardFeedbacksAllInputsBitMaskO_W,  pureCombinatorialDiscardFeedbacksAllInputsPal20v8.getMask_O_W()),  pureCombinatorialDiscardFeedbacksAllInputsBitMaskO_W,  pureCombinatorialDiscardFeedbacksAllInputsPal20v8.getMask_O_W());

        assertArrayEquals(String.format("Pure Combinatorial Discard Feedbacks All Inputs PAL20V8 LABELS_IN should be: %s, and it's: %S", Arrays.toString(LABELS_IN), Arrays.toString(pureCombinatorialDiscardFeedbacksAllInputsPal20v8.getLabels_IN())), LABELS_IN, pureCombinatorialDiscardFeedbacksAllInputsPal20v8.getLabels_IN());
        assertArrayEquals(String.format("Pure Combinatorial Discard Feedbacks All Inputs PAL20V8 LABELS_IO should be: %s, and it's: %S", Arrays.toString(LABELS_IO), Arrays.toString(pureCombinatorialDiscardFeedbacksAllInputsPal20v8.getLabels_IO())), LABELS_IO, pureCombinatorialDiscardFeedbacksAllInputsPal20v8.getLabels_IO());
        assertArrayEquals(String.format("Pure Combinatorial Discard Feedbacks All Inputs PAL20V8 LABELS_RO should be: %s, and it's: %S", Arrays.toString(LABELS_RO), Arrays.toString(pureCombinatorialDiscardFeedbacksAllInputsPal20v8.getLabels_RO())), LABELS_RO, pureCombinatorialDiscardFeedbacksAllInputsPal20v8.getLabels_RO());
        assertArrayEquals(String.format("Pure Combinatorial Discard Feedbacks All Inputs PAL20V8  LABELS_O should be: %s, and it's: %S", Arrays.toString(LABELS_O),  Arrays.toString(pureCombinatorialDiscardFeedbacksAllInputsPal20v8.getLabels_O())),  LABELS_O,  pureCombinatorialDiscardFeedbacksAllInputsPal20v8.getLabels_O());

        assertEquals(String.format("Pure Combinatorial Discard Feedbacks All Inputs PAL20V8 Pin Count IN should be: %d, and it's: %d", 22, pureCombinatorialDiscardFeedbacksAllInputsPal20v8.getPinCount_IN()), 22, pureCombinatorialDiscardFeedbacksAllInputsPal20v8.getPinCount_IN());
        assertEquals(String.format("Pure Combinatorial Discard Feedbacks All Inputs PAL20V8 Pin Count IO should be: %d, and it's: %d",  0, pureCombinatorialDiscardFeedbacksAllInputsPal20v8.getPinCount_IO()),  0, pureCombinatorialDiscardFeedbacksAllInputsPal20v8.getPinCount_IO());
        assertEquals(String.format("Pure Combinatorial Discard Feedbacks All Inputs PAL20V8 Pin Count RO should be: %d, and it's: %d",  0, pureCombinatorialDiscardFeedbacksAllInputsPal20v8.getPinCount_RO()),  0, pureCombinatorialDiscardFeedbacksAllInputsPal20v8.getPinCount_RO());
        assertEquals(String.format("Pure Combinatorial Discard Feedbacks All Inputs PAL20V8 Pin Count  O should be: %d, and it's: %d",  0, pureCombinatorialDiscardFeedbacksAllInputsPal20v8.getPinCount_O()),   0, pureCombinatorialDiscardFeedbacksAllInputsPal20v8.getPinCount_O());
    }

    @Test
    public void pureCombinatorialDiscardFeedbacksMixedInputsAndOutputsPal20v8Features() {

    	/* ***************** Initialized for pure combinatorial configuration PAL ***************** */
        String[] LABELS_IN = {  "i1",  "i2",  "i3",  "i4",  "i5",  "i6",  "i7",  "i8",  "i9", "i10",   null,   "i16",  "i17",   null,   "i19",  "i20",   null,   null,  "i11",  "i13",  "i14",  "i23" };
        String[] LABELS_IO = {};
    	String[] LABELS_RO = {};
        String[] LABELS_O  = {  null,  null,  null,  null,  null,  null,  null,  null,  null,  null,  "o15",   null,   null, "o18",   null,   null,  "o21",  "o22", null,   null,   null,   null };

    	// Mixed IOs as Inputs and Outputs:
    	int ioAsOutputMask = 0xC9;

    	PALSpecs pureCombinatorialDiscardFeedbacksMixedInputsAndOutputsPal20v8 = new PAL20V8Specs(ioAsOutputMask);
    	int pureCombinatorialDiscardFeedbacksMixedInputsAndOutputsBitMaskCLK  = Integer.parseInt(new StringBuffer("0 000000000 00000000 0000".replace(" ", "")).reverse().toString(), 2);
    	int pureCombinatorialDiscardFeedbacksMixedInputsAndOutputsBitMaskOE   = Integer.parseInt(new StringBuffer("0 000000000 00000000 0000".replace(" ", "")).reverse().toString(), 2);
    	int pureCombinatorialDiscardFeedbacksMixedInputsAndOutputsBitMaskIN   = Integer.parseInt(new StringBuffer("1 111111111 01101100 1111".replace(" ", "")).reverse().toString(), 2);
    	int pureCombinatorialDiscardFeedbacksMixedInputsAndOutputsBitMaskIO_R = Integer.parseInt(new StringBuffer("            00000000     ".replace(" ", "")).reverse().toString(), 2);
    	int pureCombinatorialDiscardFeedbacksMixedInputsAndOutputsBitMaskIO_W = Integer.parseInt(new StringBuffer("0 000000000 00000000 0000".replace(" ", "")).reverse().toString(), 2);
    	int pureCombinatorialDiscardFeedbacksMixedInputsAndOutputsBitMaskRO_R = Integer.parseInt(new StringBuffer("            00000000     ".replace(" ", "")).reverse().toString(), 2);
    	int pureCombinatorialDiscardFeedbacksMixedInputsAndOutputsBitMaskRO_W = Integer.parseInt(new StringBuffer("0 000000000 00000000 0000".replace(" ", "")).reverse().toString(), 2);
    	int pureCombinatorialDiscardFeedbacksMixedInputsAndOutputsBitMaskO_R  = Integer.parseInt(new StringBuffer("            10010011 0000".replace(" ", "")).reverse().toString(), 2);
    	int pureCombinatorialDiscardFeedbacksMixedInputsAndOutputsBitMaskO_W  = Integer.parseInt(new StringBuffer("0 000000000 10010011 0000".replace(" ", "")).reverse().toString(), 2);

        assertEquals("A PAL20V8 should be variable", true, pureCombinatorialDiscardFeedbacksMixedInputsAndOutputsPal20v8.isVariable());
        
        assertEquals(String.format("Pure Combinatorial Discard Feedbacks Mixed Inputs AndOutputs PAL20V8  CLK Mask should be: 0x%05X, and it's: 0x%05X", pureCombinatorialDiscardFeedbacksMixedInputsAndOutputsBitMaskCLK,  pureCombinatorialDiscardFeedbacksMixedInputsAndOutputsPal20v8.getMask_CLK()),  pureCombinatorialDiscardFeedbacksMixedInputsAndOutputsBitMaskCLK,  pureCombinatorialDiscardFeedbacksMixedInputsAndOutputsPal20v8.getMask_CLK());
        assertEquals(String.format("Pure Combinatorial Discard Feedbacks Mixed Inputs AndOutputs PAL20V8   OE Mask should be: 0x%05X, and it's: 0x%05X", pureCombinatorialDiscardFeedbacksMixedInputsAndOutputsBitMaskOE,   pureCombinatorialDiscardFeedbacksMixedInputsAndOutputsPal20v8.getMask_OE()),   pureCombinatorialDiscardFeedbacksMixedInputsAndOutputsBitMaskOE,   pureCombinatorialDiscardFeedbacksMixedInputsAndOutputsPal20v8.getMask_OE());
        assertEquals(String.format("Pure Combinatorial Discard Feedbacks Mixed Inputs AndOutputs PAL20V8   IN Mask should be: 0x%05X, and it's: 0x%05X", pureCombinatorialDiscardFeedbacksMixedInputsAndOutputsBitMaskIN,   pureCombinatorialDiscardFeedbacksMixedInputsAndOutputsPal20v8.getMask_IN()),   pureCombinatorialDiscardFeedbacksMixedInputsAndOutputsBitMaskIN,   pureCombinatorialDiscardFeedbacksMixedInputsAndOutputsPal20v8.getMask_IN());
        assertEquals(String.format("Pure Combinatorial Discard Feedbacks Mixed Inputs AndOutputs PAL20V8 IO_R Mask should be: 0x%05X, and it's: 0x%05X", pureCombinatorialDiscardFeedbacksMixedInputsAndOutputsBitMaskIO_R, pureCombinatorialDiscardFeedbacksMixedInputsAndOutputsPal20v8.getMask_IO_R()), pureCombinatorialDiscardFeedbacksMixedInputsAndOutputsBitMaskIO_R, pureCombinatorialDiscardFeedbacksMixedInputsAndOutputsPal20v8.getMask_IO_R());
        assertEquals(String.format("Pure Combinatorial Discard Feedbacks Mixed Inputs AndOutputs PAL20V8 IO_W Mask should be: 0x%05X, and it's: 0x%05X", pureCombinatorialDiscardFeedbacksMixedInputsAndOutputsBitMaskIO_W, pureCombinatorialDiscardFeedbacksMixedInputsAndOutputsPal20v8.getMask_IO_W()), pureCombinatorialDiscardFeedbacksMixedInputsAndOutputsBitMaskIO_W, pureCombinatorialDiscardFeedbacksMixedInputsAndOutputsPal20v8.getMask_IO_W());
        assertEquals(String.format("Pure Combinatorial Discard Feedbacks Mixed Inputs AndOutputs PAL20V8 RO_R Mask should be: 0x%05X, and it's: 0x%05X", pureCombinatorialDiscardFeedbacksMixedInputsAndOutputsBitMaskRO_R, pureCombinatorialDiscardFeedbacksMixedInputsAndOutputsPal20v8.getMask_RO_R()), pureCombinatorialDiscardFeedbacksMixedInputsAndOutputsBitMaskRO_R, pureCombinatorialDiscardFeedbacksMixedInputsAndOutputsPal20v8.getMask_RO_R());
        assertEquals(String.format("Pure Combinatorial Discard Feedbacks Mixed Inputs AndOutputs PAL20V8 RO_W Mask should be: 0x%05X, and it's: 0x%05X", pureCombinatorialDiscardFeedbacksMixedInputsAndOutputsBitMaskRO_W, pureCombinatorialDiscardFeedbacksMixedInputsAndOutputsPal20v8.getMask_RO_W()), pureCombinatorialDiscardFeedbacksMixedInputsAndOutputsBitMaskRO_W, pureCombinatorialDiscardFeedbacksMixedInputsAndOutputsPal20v8.getMask_RO_W());
        assertEquals(String.format("Pure Combinatorial Discard Feedbacks Mixed Inputs AndOutputs PAL20V8  O_R Mask should be: 0x%05X, and it's: 0x%05X", pureCombinatorialDiscardFeedbacksMixedInputsAndOutputsBitMaskO_R,  pureCombinatorialDiscardFeedbacksMixedInputsAndOutputsPal20v8.getMask_O_R()),  pureCombinatorialDiscardFeedbacksMixedInputsAndOutputsBitMaskO_R,  pureCombinatorialDiscardFeedbacksMixedInputsAndOutputsPal20v8.getMask_O_R());
        assertEquals(String.format("Pure Combinatorial Discard Feedbacks Mixed Inputs AndOutputs PAL20V8  O_W Mask should be: 0x%05X, and it's: 0x%05X", pureCombinatorialDiscardFeedbacksMixedInputsAndOutputsBitMaskO_W,  pureCombinatorialDiscardFeedbacksMixedInputsAndOutputsPal20v8.getMask_O_W()),  pureCombinatorialDiscardFeedbacksMixedInputsAndOutputsBitMaskO_W,  pureCombinatorialDiscardFeedbacksMixedInputsAndOutputsPal20v8.getMask_O_W());

        assertArrayEquals(String.format("Pure Combinatorial Discard Feedbacks Mixed Inputs AndOutputs PAL20V8 LABELS_IN should be: %s, and it's: %S", Arrays.toString(LABELS_IN), Arrays.toString(pureCombinatorialDiscardFeedbacksMixedInputsAndOutputsPal20v8.getLabels_IN())), LABELS_IN, pureCombinatorialDiscardFeedbacksMixedInputsAndOutputsPal20v8.getLabels_IN());
        assertArrayEquals(String.format("Pure Combinatorial Discard Feedbacks Mixed Inputs AndOutputs PAL20V8 LABELS_IO should be: %s, and it's: %S", Arrays.toString(LABELS_IO), Arrays.toString(pureCombinatorialDiscardFeedbacksMixedInputsAndOutputsPal20v8.getLabels_IO())), LABELS_IO, pureCombinatorialDiscardFeedbacksMixedInputsAndOutputsPal20v8.getLabels_IO());
        assertArrayEquals(String.format("Pure Combinatorial Discard Feedbacks Mixed Inputs AndOutputs PAL20V8 LABELS_RO should be: %s, and it's: %S", Arrays.toString(LABELS_RO), Arrays.toString(pureCombinatorialDiscardFeedbacksMixedInputsAndOutputsPal20v8.getLabels_RO())), LABELS_RO, pureCombinatorialDiscardFeedbacksMixedInputsAndOutputsPal20v8.getLabels_RO());
        assertArrayEquals(String.format("Pure Combinatorial Discard Feedbacks Mixed Inputs AndOutputs PAL20V8  LABELS_O should be: %s, and it's: %S", Arrays.toString(LABELS_O),  Arrays.toString(pureCombinatorialDiscardFeedbacksMixedInputsAndOutputsPal20v8.getLabels_O())),  LABELS_O,  pureCombinatorialDiscardFeedbacksMixedInputsAndOutputsPal20v8.getLabels_O());

        assertEquals(String.format("Pure Combinatorial Discard Feedbacks Mixed Inputs AndOutputs PAL20V8 Pin Count IN should be: %d, and it's: %d", 18, pureCombinatorialDiscardFeedbacksMixedInputsAndOutputsPal20v8.getPinCount_IN()), 18, pureCombinatorialDiscardFeedbacksMixedInputsAndOutputsPal20v8.getPinCount_IN());
        assertEquals(String.format("Pure Combinatorial Discard Feedbacks Mixed Inputs AndOutputs PAL20V8 Pin Count IO should be: %d, and it's: %d",  0, pureCombinatorialDiscardFeedbacksMixedInputsAndOutputsPal20v8.getPinCount_IO()),  0, pureCombinatorialDiscardFeedbacksMixedInputsAndOutputsPal20v8.getPinCount_IO());
        assertEquals(String.format("Pure Combinatorial Discard Feedbacks Mixed Inputs AndOutputs PAL20V8 Pin Count RO should be: %d, and it's: %d",  0, pureCombinatorialDiscardFeedbacksMixedInputsAndOutputsPal20v8.getPinCount_RO()),  0, pureCombinatorialDiscardFeedbacksMixedInputsAndOutputsPal20v8.getPinCount_RO());
        assertEquals(String.format("Pure Combinatorial Discard Feedbacks Mixed Inputs AndOutputs PAL20V8 Pin Count  O should be: %d, and it's: %d",  4, pureCombinatorialDiscardFeedbacksMixedInputsAndOutputsPal20v8.getPinCount_O()),   4, pureCombinatorialDiscardFeedbacksMixedInputsAndOutputsPal20v8.getPinCount_O());
    }

    @Test
    public void fullRegisteredPal20v8Features() {
   	
    	/* ***************** Initialized for full registered configuration PAL ***************** */
        String[] LABELS_IN = {  null,  "i2",  "i3",  "i4",  "i5",  "i6",  "i7",  "i8",  "i9", "i10",  null,   null,   null,   null,   null,   null,   null,   null,   "i11", null,  "i14",  "i23" };
        String[] LABELS_IO = {};
        String[] LABELS_RO = {  null,  null,  null,  null,  null,  null,  null,  null,  null,  null,  "ro15", "ro16", "ro17", "ro18", "ro19", "ro20", "ro21", "ro22", null,  null,   null,   null };
    	String[] LABELS_O  = {};

    	int roMask = 0xFF;

    	PALSpecs fullRegisteredPal20v8 = new PAL20V8Specs(null, roMask);
    	int fullRegisteredBitMaskCLK  = Integer.parseInt(new StringBuffer("1 000000000 00000000 0000".replace(" ", "")).reverse().toString(), 2);
    	int fullRegisteredBitMaskOE   = Integer.parseInt(new StringBuffer("0 000000000 00000000 0100".replace(" ", "")).reverse().toString(), 2);
    	int fullRegisteredBitMaskIN   = Integer.parseInt(new StringBuffer("0 111111111 00000000 1011".replace(" ", "")).reverse().toString(), 2);
    	int fullRegisteredBitMaskIO_R = Integer.parseInt(new StringBuffer("            00000000     ".replace(" ", "")).reverse().toString(), 2);
    	int fullRegisteredBitMaskIO_W = Integer.parseInt(new StringBuffer("0 000000000 00000000 0000".replace(" ", "")).reverse().toString(), 2);
    	int fullRegisteredBitMaskRO_R = Integer.parseInt(new StringBuffer("            11111111     ".replace(" ", "")).reverse().toString(), 2);
    	int fullRegisteredBitMaskRO_W = Integer.parseInt(new StringBuffer("0 000000000 11111111 0000".replace(" ", "")).reverse().toString(), 2);
    	int fullRegisteredBitMaskO_R  = Integer.parseInt(new StringBuffer("            00000000 0000".replace(" ", "")).reverse().toString(), 2);
    	int fullRegisteredBitMaskO_W  = Integer.parseInt(new StringBuffer("0 000000000 00000000 0000".replace(" ", "")).reverse().toString(), 2);

        assertEquals("A PAL20V8 should be variable", true, fullRegisteredPal20v8.isVariable());
        
        assertEquals(String.format("Pure Combinatorial PAL20V8  CLK Mask should be: 0x%05X, and it's: 0x%05X", fullRegisteredBitMaskCLK,  fullRegisteredPal20v8.getMask_CLK()),  fullRegisteredBitMaskCLK,  fullRegisteredPal20v8.getMask_CLK());
        assertEquals(String.format("Pure Combinatorial PAL20V8   OE Mask should be: 0x%05X, and it's: 0x%05X", fullRegisteredBitMaskOE,   fullRegisteredPal20v8.getMask_OE()),   fullRegisteredBitMaskOE,   fullRegisteredPal20v8.getMask_OE());
        assertEquals(String.format("Pure Combinatorial PAL20V8   IN Mask should be: 0x%05X, and it's: 0x%05X", fullRegisteredBitMaskIN,   fullRegisteredPal20v8.getMask_IN()),   fullRegisteredBitMaskIN,   fullRegisteredPal20v8.getMask_IN());
        assertEquals(String.format("Pure Combinatorial PAL20V8 IO_R Mask should be: 0x%05X, and it's: 0x%05X", fullRegisteredBitMaskIO_R, fullRegisteredPal20v8.getMask_IO_R()), fullRegisteredBitMaskIO_R, fullRegisteredPal20v8.getMask_IO_R());
        assertEquals(String.format("Pure Combinatorial PAL20V8 IO_W Mask should be: 0x%05X, and it's: 0x%05X", fullRegisteredBitMaskIO_W, fullRegisteredPal20v8.getMask_IO_W()), fullRegisteredBitMaskIO_W, fullRegisteredPal20v8.getMask_IO_W());
        assertEquals(String.format("Pure Combinatorial PAL20V8 RO_R Mask should be: 0x%05X, and it's: 0x%05X", fullRegisteredBitMaskRO_R, fullRegisteredPal20v8.getMask_RO_R()), fullRegisteredBitMaskRO_R, fullRegisteredPal20v8.getMask_RO_R());
        assertEquals(String.format("Pure Combinatorial PAL20V8 RO_W Mask should be: 0x%05X, and it's: 0x%05X", fullRegisteredBitMaskRO_W, fullRegisteredPal20v8.getMask_RO_W()), fullRegisteredBitMaskRO_W, fullRegisteredPal20v8.getMask_RO_W());
        assertEquals(String.format("Pure Combinatorial PAL20V8  O_R Mask should be: 0x%05X, and it's: 0x%05X", fullRegisteredBitMaskO_R,  fullRegisteredPal20v8.getMask_O_R()),  fullRegisteredBitMaskO_R,  fullRegisteredPal20v8.getMask_O_R());
        assertEquals(String.format("Pure Combinatorial PAL20V8  O_W Mask should be: 0x%05X, and it's: 0x%05X", fullRegisteredBitMaskO_W,  fullRegisteredPal20v8.getMask_O_W()),  fullRegisteredBitMaskO_W,  fullRegisteredPal20v8.getMask_O_W());

        assertArrayEquals(String.format("Pure Combinatorial PAL20V8 LABELS_IN should be: %s, and it's: %S", Arrays.toString(LABELS_IN), Arrays.toString(fullRegisteredPal20v8.getLabels_IN())), LABELS_IN, fullRegisteredPal20v8.getLabels_IN());
        assertArrayEquals(String.format("Pure Combinatorial PAL20V8 LABELS_IO should be: %s, and it's: %S", Arrays.toString(LABELS_IO), Arrays.toString(fullRegisteredPal20v8.getLabels_IO())), LABELS_IO, fullRegisteredPal20v8.getLabels_IO());
        assertArrayEquals(String.format("Pure Combinatorial PAL20V8 LABELS_RO should be: %s, and it's: %S", Arrays.toString(LABELS_RO), Arrays.toString(fullRegisteredPal20v8.getLabels_RO())), LABELS_RO, fullRegisteredPal20v8.getLabels_RO());
        assertArrayEquals(String.format("Pure Combinatorial PAL20V8  LABELS_O should be: %s, and it's: %S", Arrays.toString(LABELS_O),  Arrays.toString(fullRegisteredPal20v8.getLabels_O())),  LABELS_O,  fullRegisteredPal20v8.getLabels_O());

        assertEquals(String.format("Pure Combinatorial PAL20V8 Pin Count IN should be: %d, and it's: %d", 12, fullRegisteredPal20v8.getPinCount_IN()), 12, fullRegisteredPal20v8.getPinCount_IN());
        assertEquals(String.format("Pure Combinatorial PAL20V8 Pin Count IO should be: %d, and it's: %d",  0, fullRegisteredPal20v8.getPinCount_IO()),  0, fullRegisteredPal20v8.getPinCount_IO());
        assertEquals(String.format("Pure Combinatorial PAL20V8 Pin Count RO should be: %d, and it's: %d",  8, fullRegisteredPal20v8.getPinCount_RO()),  8, fullRegisteredPal20v8.getPinCount_RO());
        assertEquals(String.format("Pure Combinatorial PAL20V8 Pin Count  O should be: %d, and it's: %d",  0, fullRegisteredPal20v8.getPinCount_O()),   0, fullRegisteredPal20v8.getPinCount_O());
    }

    @Test
    public void partiallyRegisteredPal20v8Features1() {
   	
    	/* ***************** Initialized for partially registered configuration PAL ***************** */
        String[] LABELS_IN = {  null,  "i2",  "i3",  "i4",  "i5",  "i6",  "i7",  "i8",  "i9", "i10",   null,  null,   null,   null,   null,   null,   null,   null,   "i11",  null,  "i14",  "i23" };
        String[] LABELS_IO = {  null,  null,  null,  null,  null,  null,  null,  null,  null,  null,  "io15", null,   null,   null,   null,   null,   null,  "io22",  null,   null,   null,   null };
        String[] LABELS_RO = {  null,  null,  null,  null,  null,  null,  null,  null,  null,  null,  null,   "ro16", "ro17", "ro18", "ro19", "ro20", "ro21", null,   null,   null,   null,   null };
    	String[] LABELS_O  = {};

    	int roMask = 0x7E;

    	PALSpecs partiallyRegistered7EPal20v8 = new PAL20V8Specs(null, roMask);
    	int partiallyRegistered7EBitMaskCLK  = Integer.parseInt(new StringBuffer("1 000000000 00000000 0000".replace(" ", "")).reverse().toString(), 2);
    	int partiallyRegistered7EBitMaskOE   = Integer.parseInt(new StringBuffer("0 000000000 00000000 0100".replace(" ", "")).reverse().toString(), 2);
    	int partiallyRegistered7EBitMaskIN   = Integer.parseInt(new StringBuffer("0 111111111 00000000 1011".replace(" ", "")).reverse().toString(), 2);
    	int partiallyRegistered7EBitMaskIO_R = Integer.parseInt(new StringBuffer("            10000001     ".replace(" ", "")).reverse().toString(), 2);
    	int partiallyRegistered7EBitMaskIO_W = Integer.parseInt(new StringBuffer("0 000000000 10000001 0000".replace(" ", "")).reverse().toString(), 2);
    	int partiallyRegistered7EBitMaskRO_R = Integer.parseInt(new StringBuffer("            01111110     ".replace(" ", "")).reverse().toString(), 2);
    	int partiallyRegistered7EBitMaskRO_W = Integer.parseInt(new StringBuffer("0 000000000 01111110 0000".replace(" ", "")).reverse().toString(), 2);
    	int partiallyRegistered7EBitMaskO_R  = Integer.parseInt(new StringBuffer("            00000000 0000".replace(" ", "")).reverse().toString(), 2);
    	int partiallyRegistered7EBitMaskO_W  = Integer.parseInt(new StringBuffer("0 000000000 00000000 0000".replace(" ", "")).reverse().toString(), 2);

        assertEquals("A PAL20V8 should be variable", true, partiallyRegistered7EPal20v8.isVariable());
        
        assertEquals(String.format("Pure Combinatorial PAL20V8  CLK Mask should be: 0x%05X, and it's: 0x%05X", partiallyRegistered7EBitMaskCLK,  partiallyRegistered7EPal20v8.getMask_CLK()),  partiallyRegistered7EBitMaskCLK,  partiallyRegistered7EPal20v8.getMask_CLK());
        assertEquals(String.format("Pure Combinatorial PAL20V8   OE Mask should be: 0x%05X, and it's: 0x%05X", partiallyRegistered7EBitMaskOE,   partiallyRegistered7EPal20v8.getMask_OE()),   partiallyRegistered7EBitMaskOE,   partiallyRegistered7EPal20v8.getMask_OE());
        assertEquals(String.format("Pure Combinatorial PAL20V8   IN Mask should be: 0x%05X, and it's: 0x%05X", partiallyRegistered7EBitMaskIN,   partiallyRegistered7EPal20v8.getMask_IN()),   partiallyRegistered7EBitMaskIN,   partiallyRegistered7EPal20v8.getMask_IN());
        assertEquals(String.format("Pure Combinatorial PAL20V8 IO_R Mask should be: 0x%05X, and it's: 0x%05X", partiallyRegistered7EBitMaskIO_R, partiallyRegistered7EPal20v8.getMask_IO_R()), partiallyRegistered7EBitMaskIO_R, partiallyRegistered7EPal20v8.getMask_IO_R());
        assertEquals(String.format("Pure Combinatorial PAL20V8 IO_W Mask should be: 0x%05X, and it's: 0x%05X", partiallyRegistered7EBitMaskIO_W, partiallyRegistered7EPal20v8.getMask_IO_W()), partiallyRegistered7EBitMaskIO_W, partiallyRegistered7EPal20v8.getMask_IO_W());
        assertEquals(String.format("Pure Combinatorial PAL20V8 RO_R Mask should be: 0x%05X, and it's: 0x%05X", partiallyRegistered7EBitMaskRO_R, partiallyRegistered7EPal20v8.getMask_RO_R()), partiallyRegistered7EBitMaskRO_R, partiallyRegistered7EPal20v8.getMask_RO_R());
        assertEquals(String.format("Pure Combinatorial PAL20V8 RO_W Mask should be: 0x%05X, and it's: 0x%05X", partiallyRegistered7EBitMaskRO_W, partiallyRegistered7EPal20v8.getMask_RO_W()), partiallyRegistered7EBitMaskRO_W, partiallyRegistered7EPal20v8.getMask_RO_W());
        assertEquals(String.format("Pure Combinatorial PAL20V8  O_R Mask should be: 0x%05X, and it's: 0x%05X", partiallyRegistered7EBitMaskO_R,  partiallyRegistered7EPal20v8.getMask_O_R()),  partiallyRegistered7EBitMaskO_R,  partiallyRegistered7EPal20v8.getMask_O_R());
        assertEquals(String.format("Pure Combinatorial PAL20V8  O_W Mask should be: 0x%05X, and it's: 0x%05X", partiallyRegistered7EBitMaskO_W,  partiallyRegistered7EPal20v8.getMask_O_W()),  partiallyRegistered7EBitMaskO_W,  partiallyRegistered7EPal20v8.getMask_O_W());

        assertArrayEquals(String.format("Pure Combinatorial PAL20V8 LABELS_IN should be: %s, and it's: %S", Arrays.toString(LABELS_IN), Arrays.toString(partiallyRegistered7EPal20v8.getLabels_IN())), LABELS_IN, partiallyRegistered7EPal20v8.getLabels_IN());
        assertArrayEquals(String.format("Pure Combinatorial PAL20V8 LABELS_IO should be: %s, and it's: %S", Arrays.toString(LABELS_IO), Arrays.toString(partiallyRegistered7EPal20v8.getLabels_IO())), LABELS_IO, partiallyRegistered7EPal20v8.getLabels_IO());
        assertArrayEquals(String.format("Pure Combinatorial PAL20V8 LABELS_RO should be: %s, and it's: %S", Arrays.toString(LABELS_RO), Arrays.toString(partiallyRegistered7EPal20v8.getLabels_RO())), LABELS_RO, partiallyRegistered7EPal20v8.getLabels_RO());
        assertArrayEquals(String.format("Pure Combinatorial PAL20V8  LABELS_O should be: %s, and it's: %S", Arrays.toString(LABELS_O),  Arrays.toString(partiallyRegistered7EPal20v8.getLabels_O())),  LABELS_O,  partiallyRegistered7EPal20v8.getLabels_O());

        assertEquals(String.format("Pure Combinatorial PAL20V8 Pin Count IN should be: %d, and it's: %d", 12, partiallyRegistered7EPal20v8.getPinCount_IN()), 12, partiallyRegistered7EPal20v8.getPinCount_IN());
        assertEquals(String.format("Pure Combinatorial PAL20V8 Pin Count IO should be: %d, and it's: %d",  2, partiallyRegistered7EPal20v8.getPinCount_IO()),  2, partiallyRegistered7EPal20v8.getPinCount_IO());
        assertEquals(String.format("Pure Combinatorial PAL20V8 Pin Count RO should be: %d, and it's: %d",  6, partiallyRegistered7EPal20v8.getPinCount_RO()),  6, partiallyRegistered7EPal20v8.getPinCount_RO());
        assertEquals(String.format("Pure Combinatorial PAL20V8 Pin Count  O should be: %d, and it's: %d",  0, partiallyRegistered7EPal20v8.getPinCount_O()),   0, partiallyRegistered7EPal20v8.getPinCount_O());
    }

    @Test
    public void partiallyRegisteredPal20v8Features2() {
   	
    	/* ***************** Initialized for partially registered configuration PAL ***************** */
        String[] LABELS_IN = {  null,  "i2",  "i3",  "i4",  "i5",  "i6",  "i7",  "i8",  "i9", "i10",   null,  null,   null,   null,   null,   null,   null,   null,   "i11",  null,  "i14",  "i23" };
        String[] LABELS_IO = {  null,  null,  null,  null,  null,  null,  null,  null,  null,  null,  "io15", "io16", null,   null,   null,   null,   "io21", "io22", null,  null,   null,   null };
        String[] LABELS_RO = {  null,  null,  null,  null,  null,  null,  null,  null,  null,  null,  null,   null,   "ro17", "ro18", "ro19", "ro20", null,   null,   null,   null,   null,   null };
    	String[] LABELS_O  = {};

    	int roMask = 0x3C;

    	PALSpecs partiallyRegistered3CPal20v8 = new PAL20V8Specs(null, roMask);
    	int partiallyRegistered3CBitMaskCLK  = Integer.parseInt(new StringBuffer("1 000000000 00000000 0000".replace(" ", "")).reverse().toString(), 2);
    	int partiallyRegistered3CBitMaskOE   = Integer.parseInt(new StringBuffer("0 000000000 00000000 0100".replace(" ", "")).reverse().toString(), 2);
    	int partiallyRegistered3CBitMaskIN   = Integer.parseInt(new StringBuffer("0 111111111 00000000 1011".replace(" ", "")).reverse().toString(), 2);
    	int partiallyRegistered3CBitMaskIO_R = Integer.parseInt(new StringBuffer("            11000011     ".replace(" ", "")).reverse().toString(), 2);
    	int partiallyRegistered3CBitMaskIO_W = Integer.parseInt(new StringBuffer("0 000000000 11000011 0000".replace(" ", "")).reverse().toString(), 2);
    	int partiallyRegistered3CBitMaskRO_R = Integer.parseInt(new StringBuffer("            00111100     ".replace(" ", "")).reverse().toString(), 2);
    	int partiallyRegistered3CBitMaskRO_W = Integer.parseInt(new StringBuffer("0 000000000 00111100 0000".replace(" ", "")).reverse().toString(), 2);
    	int partiallyRegistered3CBitMaskO_R  = Integer.parseInt(new StringBuffer("            00000000 0000".replace(" ", "")).reverse().toString(), 2);
    	int partiallyRegistered3CBitMaskO_W  = Integer.parseInt(new StringBuffer("0 000000000 00000000 0000".replace(" ", "")).reverse().toString(), 2);

        assertEquals("A PAL20V8 should be variable", true, partiallyRegistered3CPal20v8.isVariable());
        
        assertEquals(String.format("Pure Combinatorial PAL20V8  CLK Mask should be: 0x%05X, and it's: 0x%05X", partiallyRegistered3CBitMaskCLK,  partiallyRegistered3CPal20v8.getMask_CLK()),  partiallyRegistered3CBitMaskCLK,  partiallyRegistered3CPal20v8.getMask_CLK());
        assertEquals(String.format("Pure Combinatorial PAL20V8   OE Mask should be: 0x%05X, and it's: 0x%05X", partiallyRegistered3CBitMaskOE,   partiallyRegistered3CPal20v8.getMask_OE()),   partiallyRegistered3CBitMaskOE,   partiallyRegistered3CPal20v8.getMask_OE());
        assertEquals(String.format("Pure Combinatorial PAL20V8   IN Mask should be: 0x%05X, and it's: 0x%05X", partiallyRegistered3CBitMaskIN,   partiallyRegistered3CPal20v8.getMask_IN()),   partiallyRegistered3CBitMaskIN,   partiallyRegistered3CPal20v8.getMask_IN());
        assertEquals(String.format("Pure Combinatorial PAL20V8 IO_R Mask should be: 0x%05X, and it's: 0x%05X", partiallyRegistered3CBitMaskIO_R, partiallyRegistered3CPal20v8.getMask_IO_R()), partiallyRegistered3CBitMaskIO_R, partiallyRegistered3CPal20v8.getMask_IO_R());
        assertEquals(String.format("Pure Combinatorial PAL20V8 IO_W Mask should be: 0x%05X, and it's: 0x%05X", partiallyRegistered3CBitMaskIO_W, partiallyRegistered3CPal20v8.getMask_IO_W()), partiallyRegistered3CBitMaskIO_W, partiallyRegistered3CPal20v8.getMask_IO_W());
        assertEquals(String.format("Pure Combinatorial PAL20V8 RO_R Mask should be: 0x%05X, and it's: 0x%05X", partiallyRegistered3CBitMaskRO_R, partiallyRegistered3CPal20v8.getMask_RO_R()), partiallyRegistered3CBitMaskRO_R, partiallyRegistered3CPal20v8.getMask_RO_R());
        assertEquals(String.format("Pure Combinatorial PAL20V8 RO_W Mask should be: 0x%05X, and it's: 0x%05X", partiallyRegistered3CBitMaskRO_W, partiallyRegistered3CPal20v8.getMask_RO_W()), partiallyRegistered3CBitMaskRO_W, partiallyRegistered3CPal20v8.getMask_RO_W());
        assertEquals(String.format("Pure Combinatorial PAL20V8  O_R Mask should be: 0x%05X, and it's: 0x%05X", partiallyRegistered3CBitMaskO_R,  partiallyRegistered3CPal20v8.getMask_O_R()),  partiallyRegistered3CBitMaskO_R,  partiallyRegistered3CPal20v8.getMask_O_R());
        assertEquals(String.format("Pure Combinatorial PAL20V8  O_W Mask should be: 0x%05X, and it's: 0x%05X", partiallyRegistered3CBitMaskO_W,  partiallyRegistered3CPal20v8.getMask_O_W()),  partiallyRegistered3CBitMaskO_W,  partiallyRegistered3CPal20v8.getMask_O_W());

        assertArrayEquals(String.format("Pure Combinatorial PAL20V8 LABELS_IN should be: %s, and it's: %S", Arrays.toString(LABELS_IN), Arrays.toString(partiallyRegistered3CPal20v8.getLabels_IN())), LABELS_IN, partiallyRegistered3CPal20v8.getLabels_IN());
        assertArrayEquals(String.format("Pure Combinatorial PAL20V8 LABELS_IO should be: %s, and it's: %S", Arrays.toString(LABELS_IO), Arrays.toString(partiallyRegistered3CPal20v8.getLabels_IO())), LABELS_IO, partiallyRegistered3CPal20v8.getLabels_IO());
        assertArrayEquals(String.format("Pure Combinatorial PAL20V8 LABELS_RO should be: %s, and it's: %S", Arrays.toString(LABELS_RO), Arrays.toString(partiallyRegistered3CPal20v8.getLabels_RO())), LABELS_RO, partiallyRegistered3CPal20v8.getLabels_RO());
        assertArrayEquals(String.format("Pure Combinatorial PAL20V8  LABELS_O should be: %s, and it's: %S", Arrays.toString(LABELS_O),  Arrays.toString(partiallyRegistered3CPal20v8.getLabels_O())),  LABELS_O,  partiallyRegistered3CPal20v8.getLabels_O());

        assertEquals(String.format("Pure Combinatorial PAL20V8 Pin Count IN should be: %d, and it's: %d", 12, partiallyRegistered3CPal20v8.getPinCount_IN()), 12, partiallyRegistered3CPal20v8.getPinCount_IN());
        assertEquals(String.format("Pure Combinatorial PAL20V8 Pin Count IO should be: %d, and it's: %d",  4, partiallyRegistered3CPal20v8.getPinCount_IO()),  4, partiallyRegistered3CPal20v8.getPinCount_IO());
        assertEquals(String.format("Pure Combinatorial PAL20V8 Pin Count RO should be: %d, and it's: %d",  4, partiallyRegistered3CPal20v8.getPinCount_RO()),  4, partiallyRegistered3CPal20v8.getPinCount_RO());
        assertEquals(String.format("Pure Combinatorial PAL20V8 Pin Count  O should be: %d, and it's: %d",  0, partiallyRegistered3CPal20v8.getPinCount_O()),   0, partiallyRegistered3CPal20v8.getPinCount_O());
    }

}
