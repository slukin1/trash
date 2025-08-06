package org.bouncycastle.crypto.engines;

import org.bouncycastle.util.Pack;

public class XSalsa20Engine extends Salsa20Engine {
    public String getAlgorithmName() {
        return "XSalsa20";
    }

    public int getNonceSize() {
        return 24;
    }

    public void setKey(byte[] bArr, byte[] bArr2) {
        if (bArr == null) {
            throw new IllegalArgumentException(getAlgorithmName() + " doesn't support re-init with null key");
        } else if (bArr.length == 32) {
            super.setKey(bArr, bArr2);
            Pack.littleEndianToInt(bArr2, 8, this.engineState, 8, 2);
            int[] iArr = this.engineState;
            int[] iArr2 = new int[iArr.length];
            Salsa20Engine.salsaCore(20, iArr, iArr2);
            int[] iArr3 = this.engineState;
            iArr3[1] = iArr2[0] - iArr3[0];
            iArr3[2] = iArr2[5] - iArr3[5];
            iArr3[3] = iArr2[10] - iArr3[10];
            iArr3[4] = iArr2[15] - iArr3[15];
            iArr3[11] = iArr2[6] - iArr3[6];
            iArr3[12] = iArr2[7] - iArr3[7];
            iArr3[13] = iArr2[8] - iArr3[8];
            iArr3[14] = iArr2[9] - iArr3[9];
            Pack.littleEndianToInt(bArr2, 16, iArr3, 6, 2);
        } else {
            throw new IllegalArgumentException(getAlgorithmName() + " requires a 256 bit key");
        }
    }
}
