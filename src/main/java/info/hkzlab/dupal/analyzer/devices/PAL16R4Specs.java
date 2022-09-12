package info.hkzlab.dupal.analyzer.devices;

public class PAL16R4Specs extends AbstractPALFeedbackSpecs implements PALSpecs {

    public static final String PAL_TYPE = "16R4";

    private static final String[] LABELS_RO =  {  null,  null,  null,  null,  null,  null,  null,  null,  null,   null,   null, "ro17", "ro16", "ro15", "ro14",   null,   null,   null };
    private static final String[] LABELS_IN =  {  null,  "i2",  "i3",  "i4",  "i5",  "i6",  "i7",  "i8",  "i9",   null,   null,   null,   null,   null,   null,   null,   null,   null };
    private static final String[] LABELS_IO =  {  null,  null,  null,  null,  null,  null,  null,  null,  null,   null, "io18",   null,   null,   null,   null, "io13", "io19", "io12" };
    private static final String[] LABELS_O  =  { };

	public PAL16R4Specs() {
		super(null);
	}

	public PAL16R4Specs(Integer ioAsOutputMask) {
		super(ioAsOutputMask);
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
    public int getMask_CLK() {
        return 0x01;
    }

    @Override
    public int getMask_OE() {
        return 0x0200;
    }

    @Override
    public int getMask_IN_initial() {
        return 0x1FE;
    }

    @Override
    public int getMask_IO_R_initial() {
        return 0xE1;
    }

    @Override
    public int getMask_IO_W_initial() {
        return 0x038400;
    }

    @Override
    public int getMask_RO_R() {
        return 0x1E;
    }

    @Override
    public int getMask_RO_W() {
        return 0x7800;
    }

    @Override
    public int getMask_O_R_initial() {
        return 0x00;
    }

    @Override
    public int getMask_O_W_initial() {
        return 0x00;
    }

    @Override
    public String[] getLabels_RO() {
        return LABELS_RO;
    }

    @Override
    public String[] getLabels_O() {
        return this.getLabels_O_internal(LABELS_O, LABELS_IO);
    }

    @Override
    public String[] getLabels_IO() {
        return this.getLabels_IO_internal(LABELS_IO);
    }

    @Override
    public String[] getLabels_IN() {
        return this.getLabels_IN_internal(LABELS_IN, LABELS_IO);
    }

    @Override
    public int minimumBoardRev() {
        return 1;
    }

    @Override
    public int slotNumber() {
        return 0;
    }
}