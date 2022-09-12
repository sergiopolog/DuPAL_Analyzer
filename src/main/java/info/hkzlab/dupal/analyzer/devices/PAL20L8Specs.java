package info.hkzlab.dupal.analyzer.devices;

public class PAL20L8Specs extends AbstractPALFeedbackSpecs implements PALSpecs {

    public static final String PAL_TYPE = "20L8";

    private static final String[] LABELS_RO = { };
    private static final String[] LABELS_IN =  {  "i1",  "i2",  "i3",  "i4",  "i5",  "i6",  "i7",  "i8",  "i9", "i10",   null,   null,   null,   null,   null,   null,   null,   null,  "i11",  "i13",  "i14",  "i23" };
    private static final String[] LABELS_IO =  {  null,  null,  null,  null,  null,  null,  null,  null,  null,  null,   null, "io16", "io17", "io18", "io19", "io20", "io21",   null,   null,   null,   null,   null };
    private static final String[] LABELS_O  = {   null,  null,  null,  null,  null,  null,  null,  null,  null,  null,  "o15",   null,   null,   null,   null,   null,   null,  "o22",   null,   null,   null,   null };

	public PAL20L8Specs() {
		super(null);
	}

	public PAL20L8Specs(Integer ioAsOutputMask) {
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
        return 0x00;
    }

    @Override
    public int getMask_OE() {
        return 0x00;
    }

    @Override
    public int getMask_IN_initial() {
        return 0x3C03FF;
    }

    @Override
    public int getMask_IO_R_initial() {
        return 0x7E;
    }

    @Override
    public int getMask_IO_W_initial() {
        return 0x1F800;
    }

    @Override
    public int getMask_RO_R() {
        return 0x00;
    }

    @Override
    public int getMask_RO_W() {
        return 0x00;
    }

    @Override
    public int getMask_O_R_initial() {
        return 0x81;
    }

    @Override
    public int getMask_O_W_initial() {
        return 0x020400;
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
        return 2;
    }

    @Override
    public int slotNumber() {
        return 1;
    }
}