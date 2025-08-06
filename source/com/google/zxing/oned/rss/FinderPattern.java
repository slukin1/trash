package com.google.zxing.oned.rss;

import com.google.zxing.ResultPoint;

public final class FinderPattern {
    private final ResultPoint[] resultPoints;
    private final int[] startEnd;
    private final int value;

    public FinderPattern(int i11, int[] iArr, int i12, int i13, int i14) {
        this.value = i11;
        this.startEnd = iArr;
        float f11 = (float) i14;
        this.resultPoints = new ResultPoint[]{new ResultPoint((float) i12, f11), new ResultPoint((float) i13, f11)};
    }

    public boolean equals(Object obj) {
        if ((obj instanceof FinderPattern) && this.value == ((FinderPattern) obj).value) {
            return true;
        }
        return false;
    }

    public ResultPoint[] getResultPoints() {
        return this.resultPoints;
    }

    public int[] getStartEnd() {
        return this.startEnd;
    }

    public int getValue() {
        return this.value;
    }

    public int hashCode() {
        return this.value;
    }
}
