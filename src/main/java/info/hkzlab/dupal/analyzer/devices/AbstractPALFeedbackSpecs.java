package info.hkzlab.dupal.analyzer.devices;

import java.util.Arrays;

import info.hkzlab.dupal.analyzer.utilities.BitUtils;

public abstract class AbstractPALFeedbackSpecs implements PALSpecs {

	private boolean discardFeedbacks = false;

	private Integer ioAsOutputMask = 0x0;

	public AbstractPALFeedbackSpecs(Integer ioAsOutputMask) {
		assert ioAsOutputMask == null || ioAsOutputMask <= this.getMask_IO_R_initial();
		this.ioAsOutputMask = ioAsOutputMask;
		this.discardFeedbacks = ioAsOutputMask != null;
	}

	public abstract int getMask_IN_initial();
	public abstract int getMask_IO_R_initial();
	public abstract int getMask_IO_W_initial();
	public abstract int getMask_O_R_initial();
	public abstract int getMask_O_W_initial();

	protected int getFirstNotInputIndex() {
		return BitUtils.getLowestSignificantBitSetPosition(this.getMask_IO_W_initial() | this.getMask_O_W_initial());
	}

	@Override
	public boolean isDiscardFeedbacks() {
		return this.discardFeedbacks;
	}

	@Override
	public int getIoAsOutMask() {
		return this.ioAsOutputMask;
	}

	@Override
    public int getMask_IN() {
        return !this.discardFeedbacks ? this.getMask_IN_initial() : this.getMask_IN_initial() | (this.getMask_IO_W_initial() ^ (this.ioAsOutputMask << this.getFirstNotInputIndex()));
    }

	@Override
    public int getMask_IO_R() {
        return !this.discardFeedbacks ? this.getMask_IO_R_initial() : 0x0;
    }

	@Override
    public int getMask_IO_W() {
        return !this.discardFeedbacks ? this.getMask_IO_W_initial() : 0x0;
    }

	@Override
    public int getMask_O_R() {
        return !this.discardFeedbacks ? this.getMask_O_R_initial() : getMask_O_R_initial() | (this.getMask_IO_R_initial() & this.ioAsOutputMask);
    }

	@Override
    public  int getMask_O_W() {
        return !this.discardFeedbacks ? this.getMask_O_W_initial() : this.getMask_O_W_initial() | (this.getMask_IO_W_initial() & (this.ioAsOutputMask << this.getFirstNotInputIndex()));
    }

	protected String[] getLabels_IN_internal(String[] labelsIn, String[] labelsIo) {
		if (this.discardFeedbacks) {
			String ioAsOutputMaskStr = new StringBuffer(String.format("%".concat(String.valueOf(labelsIo.length)).concat("s"), Integer.toBinaryString(this.ioAsOutputMask << this.getFirstNotInputIndex())).replace(' ', '0')).reverse().toString();
			String[] labelsInTmp = labelsIn.clone();
			for (int i = 0; i < ioAsOutputMaskStr.length(); i++) {
				if (labelsInTmp[i] == null && labelsIo[i] != null && '0' == ioAsOutputMaskStr.charAt(i)) {
					labelsInTmp[i] = labelsIo[i].replace("io", "i");
				}
			}
			return stripEmptyArray(labelsInTmp);
		} else {
			return labelsIn;
		}
	}

	protected String[] getLabels_IO_internal(String[] labelsIo) {
		if (this.discardFeedbacks) {
			return new String[] {};
		} else {
			return labelsIo;
		}
	}

	protected String[] getLabels_O_internal(String[] labelsO, String[] labelsIo) {
		if (this.discardFeedbacks) {
			String ioAsOutputMaskStr = new StringBuffer(String.format("%".concat(String.valueOf(labelsIo.length)).concat("s"), Integer.toBinaryString(this.ioAsOutputMask << this.getFirstNotInputIndex())).replace(' ', '0')).reverse().toString();
			String[] labelsOTmp = labelsO.length > 0 ? labelsO.clone() : new String[labelsIo.length];
			for (int i = 0; i < ioAsOutputMaskStr.length(); i++) {
				if (labelsOTmp[i] == null && labelsIo[i] != null && '1' == ioAsOutputMaskStr.charAt(i)) {
					labelsOTmp[i] = labelsIo[i].replace("io", "o");
				}
			}
			return stripEmptyArray(labelsOTmp);
		} else {
			return labelsO;
		}
	}

	@Override
	public boolean isVariable() {
		return false;
	}

	@Override
	public int getPinCount_IN() {
		return BitUtils.countBits(this.getMask_IN());
	}

	@Override
	public int getPinCount_IO() {
		return BitUtils.countBits(this.getMask_IO_R());
	}

	@Override
	public int getPinCount_RO() {
		return BitUtils.countBits(this.getMask_RO_R());
	}

	@Override
	public int getPinCount_O() {
		return BitUtils.countBits(this.getMask_O_R());
	}

	protected static String[] stripEmptyArray(String[] arr) {
		return Arrays.asList(arr).stream().filter(o -> o != null).count() > 0 ? arr : new String[] {};
	}
}