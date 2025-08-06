package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.util.Assertions;
import java.util.Arrays;

final class NalUnitTargetBuffer {
    private boolean isCompleted;
    private boolean isFilling;
    public byte[] nalData;
    public int nalLength;
    private final int targetType;

    public NalUnitTargetBuffer(int i11, int i12) {
        this.targetType = i11;
        byte[] bArr = new byte[(i12 + 3)];
        this.nalData = bArr;
        bArr[2] = 1;
    }

    public void appendToNalUnit(byte[] bArr, int i11, int i12) {
        if (this.isFilling) {
            int i13 = i12 - i11;
            byte[] bArr2 = this.nalData;
            int length = bArr2.length;
            int i14 = this.nalLength;
            if (length < i14 + i13) {
                this.nalData = Arrays.copyOf(bArr2, (i14 + i13) * 2);
            }
            System.arraycopy(bArr, i11, this.nalData, this.nalLength, i13);
            this.nalLength += i13;
        }
    }

    public boolean endNalUnit(int i11) {
        if (!this.isFilling) {
            return false;
        }
        this.nalLength -= i11;
        this.isFilling = false;
        this.isCompleted = true;
        return true;
    }

    public boolean isCompleted() {
        return this.isCompleted;
    }

    public void reset() {
        this.isFilling = false;
        this.isCompleted = false;
    }

    public void startNalUnit(int i11) {
        boolean z11 = true;
        Assertions.checkState(!this.isFilling);
        if (i11 != this.targetType) {
            z11 = false;
        }
        this.isFilling = z11;
        if (z11) {
            this.nalLength = 3;
            this.isCompleted = false;
        }
    }
}
