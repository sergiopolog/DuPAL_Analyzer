package info.hkzlab.dupal.analyzer.devices;

public class PAL16V8Specs extends AbstractPALVariableSpecs implements PALSpecs {

	public static final String PAL_TYPE = "16V8";

	// Initialized for pure combinatorial configuration PAL
	private static final String[] LABELS_RO = {};
	private static final String[] LABELS_IN = { "i1", "i2", "i3", "i4", "i5", "i6", "i7", "i8", "i9", "i11", null, null, null, null, null, null, null, null };
	private static final String[] LABELS_IO = { null, null, null, null, null, null, null, null, null, null, "io18", "io17", "io16", "io15", "io14", "io13", "io19", "io12" };
	private static final String[] LABELS_O  = {};

	public PAL16V8Specs() {
		super(null);
	}

	public PAL16V8Specs(Integer ioAsOutputMask) {
		super(ioAsOutputMask);
	}

	public PAL16V8Specs(Integer ioAsOutputMask, Integer roMask) {
		super(ioAsOutputMask, roMask);
	}

	@Override
	public String toString() {
		return "PAL" + PAL_TYPE;
	}

	@Override
	public boolean isActiveLow() {
		return true;
	}

	@Override
	public int getMask_CLK() {
		return this.isRegistered() ? 0x01 : 0x00;
	}

	@Override
	public int getMask_OE() {
		return this.isRegistered() ? 0x0200 : 0x00;
	}

	@Override
	public int getMask_IN_initial() {
		return this.isRegistered() ? 0x1FE : 0x3FF;
	}

	@Override
	public int getMask_IO_R_initial() {
		return 0xFF;
	}

	@Override
	public int getMask_IO_W_initial() {
		return this.getMask_IO_R_initial() << 10;
	}
	/*
	@Override
	public int getMask_RO_R() {
		return this.roMask;
	}

	@Override
	public int getMask_RO_W() {
		return this.getMask_RO_R() << 10;
	}
	*/
	@Override
	public int getMask_O_R_initial() {
		return 0x00;
	}

	@Override
	public int getMask_O_W_initial() {
		return 0x00;
	}

	@Override
	public String[] getLabels_IN() {
		return this.getLabels_IN_internal(LABELS_IN, LABELS_IO);
	}

	@Override
	public String[] getLabels_IO() {
		return this.getLabels_IO_internal(LABELS_IO);
	}

	@Override
	public String[] getLabels_RO() {
		return this.getLabels_RO_internal(LABELS_IO, LABELS_RO);
	}

	@Override
	public String[] getLabels_O() {
		return this.getLabels_O_internal(LABELS_O, LABELS_IO);
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