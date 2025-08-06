package org.bouncycastle.crypto.digests;

import org.bouncycastle.crypto.ExtendedDigest;
import org.bouncycastle.util.Memoable;
import org.bouncycastle.util.Pack;

public abstract class GeneralDigest implements ExtendedDigest, Memoable {
    private static final int BYTE_LENGTH = 64;
    private long byteCount;
    private final byte[] xBuf;
    private int xBufOff;

    public GeneralDigest() {
        this.xBuf = new byte[4];
        this.xBufOff = 0;
    }

    public GeneralDigest(GeneralDigest generalDigest) {
        this.xBuf = new byte[4];
        copyIn(generalDigest);
    }

    public GeneralDigest(byte[] bArr) {
        byte[] bArr2 = new byte[4];
        this.xBuf = bArr2;
        System.arraycopy(bArr, 0, bArr2, 0, bArr2.length);
        this.xBufOff = Pack.bigEndianToInt(bArr, 4);
        this.byteCount = Pack.bigEndianToLong(bArr, 8);
    }

    public void copyIn(GeneralDigest generalDigest) {
        byte[] bArr = generalDigest.xBuf;
        System.arraycopy(bArr, 0, this.xBuf, 0, bArr.length);
        this.xBufOff = generalDigest.xBufOff;
        this.byteCount = generalDigest.byteCount;
    }

    public void finish() {
        long j11 = this.byteCount << 3;
        byte b11 = Byte.MIN_VALUE;
        while (true) {
            update(b11);
            if (this.xBufOff != 0) {
                b11 = 0;
            } else {
                processLength(j11);
                processBlock();
                return;
            }
        }
    }

    public int getByteLength() {
        return 64;
    }

    public void populateState(byte[] bArr) {
        System.arraycopy(this.xBuf, 0, bArr, 0, this.xBufOff);
        Pack.intToBigEndian(this.xBufOff, bArr, 4);
        Pack.longToBigEndian(this.byteCount, bArr, 8);
    }

    public abstract void processBlock();

    public abstract void processLength(long j11);

    public abstract void processWord(byte[] bArr, int i11);

    public void reset() {
        this.byteCount = 0;
        this.xBufOff = 0;
        int i11 = 0;
        while (true) {
            byte[] bArr = this.xBuf;
            if (i11 < bArr.length) {
                bArr[i11] = 0;
                i11++;
            } else {
                return;
            }
        }
    }

    public void update(byte b11) {
        byte[] bArr = this.xBuf;
        int i11 = this.xBufOff;
        int i12 = i11 + 1;
        this.xBufOff = i12;
        bArr[i11] = b11;
        if (i12 == bArr.length) {
            processWord(bArr, 0);
            this.xBufOff = 0;
        }
        this.byteCount++;
    }

    public void update(byte[] bArr, int i11, int i12) {
        int i13 = 0;
        int max = Math.max(0, i12);
        if (this.xBufOff != 0) {
            int i14 = 0;
            while (true) {
                if (i14 >= max) {
                    i13 = i14;
                    break;
                }
                byte[] bArr2 = this.xBuf;
                int i15 = this.xBufOff;
                int i16 = i15 + 1;
                this.xBufOff = i16;
                int i17 = i14 + 1;
                bArr2[i15] = bArr[i14 + i11];
                if (i16 == 4) {
                    processWord(bArr2, 0);
                    this.xBufOff = 0;
                    i13 = i17;
                    break;
                }
                i14 = i17;
            }
        }
        int i18 = ((max - i13) & -4) + i13;
        while (i13 < i18) {
            processWord(bArr, i11 + i13);
            i13 += 4;
        }
        while (i13 < max) {
            byte[] bArr3 = this.xBuf;
            int i19 = this.xBufOff;
            this.xBufOff = i19 + 1;
            bArr3[i19] = bArr[i13 + i11];
            i13++;
        }
        this.byteCount += (long) max;
    }
}
