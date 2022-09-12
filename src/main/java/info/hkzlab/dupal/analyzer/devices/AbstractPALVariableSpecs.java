package info.hkzlab.dupal.analyzer.devices;

import info.hkzlab.dupal.analyzer.utilities.BitUtils;

public abstract class AbstractPALVariableSpecs extends AbstractPALFeedbackSpecs implements PALSpecs {

	private int roMask = 0x00;

	public AbstractPALVariableSpecs(Integer ioAsOutputMask) {
		super(ioAsOutputMask);
	}

	public AbstractPALVariableSpecs(Integer ioAsOutputMask, Integer roMask) {
		super(ioAsOutputMask);
		assert roMask <= this.getMask_IO_R_initial();
		this.roMask = roMask;
	}

	protected boolean isRegistered() {
		return roMask != 0x00;
	}

	@Override
	public boolean isVariable() {
		return true;
	}

	@Override
	public int getMask_IO_R() {
		return super.getMask_IO_R() ^ this.roMask;
	}

	@Override
	public int getMask_IO_W() {
		return super.getMask_IO_W() ^ (this.roMask << this.getFirstNotInputIndex());
	}

	@Override
	public int getMask_RO_R() {
		return this.roMask;
	}

	@Override
	public int getMask_RO_W() {
		return this.getMask_RO_R() << this.getFirstNotInputIndex();
	}

	@Override
	protected String[] getLabels_IN_internal(String[] labelsIn, String[] labelsIo) {
		String[] labelsInTmp = super.getLabels_IN_internal(labelsIn, labelsIo).clone();
		if (this.isRegistered()) {
			labelsInTmp[BitUtils.getLowestSignificantBitSetPosition(this.getMask_CLK())] = null;
			labelsInTmp[BitUtils.getLowestSignificantBitSetPosition(this.getMask_OE())] = null;
			return stripEmptyArray(labelsInTmp);
		} else {
			return labelsInTmp;
		}
	}

	protected String[] getLabels_IO_internal(String[] labelsIo) {
		String[] labelsIoTmp = super.getLabels_IO_internal(labelsIo).clone();
		if (this.isRegistered()) {
			String roMaskStr = new StringBuffer(String.format("%".concat(String.valueOf(labelsIo.length)).concat("s"), Integer.toBinaryString(this.roMask << this.getFirstNotInputIndex())).replace(' ', '0')).reverse().toString();
			for (int i = 0; i < roMaskStr.length(); i++) {
				if ('1' == roMaskStr.charAt(i)) {
					labelsIoTmp[i] = null;
				}
			}
			return stripEmptyArray(labelsIoTmp);
		} else {
			return labelsIoTmp;
		}
	}

	protected String[] getLabels_RO_internal(String[] labelsIo, String[] labelsRo) {
		String[] labelsIoTmp = super.getLabels_IO_internal(labelsIo).clone();
		if (this.isRegistered()) {
			String roMaskStr = new StringBuffer(String.format("%".concat(String.valueOf(labelsIo.length)).concat("s"), Integer.toBinaryString(this.roMask << this.getFirstNotInputIndex())).replace(' ', '0')).reverse().toString();
			String[] labelsRoTmp = labelsIoTmp.clone();
			for (int i = 0; i < roMaskStr.length(); i++) {
				if ('0' == roMaskStr.charAt(i)) {
					labelsRoTmp[i] = null;
				} else {
					labelsRoTmp[i] = labelsRoTmp[i].replace("io", "ro");
				}
			}
			return stripEmptyArray(labelsRoTmp);
		} else {
			return labelsRo;
		}
	}
}