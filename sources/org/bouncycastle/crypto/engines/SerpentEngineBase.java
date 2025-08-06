package org.bouncycastle.crypto.engines;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.StatelessProcessing;
import org.bouncycastle.crypto.params.KeyParameter;

public abstract class SerpentEngineBase implements BlockCipher, StatelessProcessing {
    public static final int BLOCK_SIZE = 16;
    public static final int PHI = -1640531527;
    public static final int ROUNDS = 32;
    public boolean encrypting;
    public int[] wKey;

    public static int rotateLeft(int i11, int i12) {
        return (i11 >>> (-i12)) | (i11 << i12);
    }

    public static int rotateRight(int i11, int i12) {
        return (i11 << (-i12)) | (i11 >>> i12);
    }

    public final void LT(int[] iArr) {
        int rotateLeft = rotateLeft(iArr[0], 13);
        int rotateLeft2 = rotateLeft(iArr[2], 3);
        iArr[1] = rotateLeft((iArr[1] ^ rotateLeft) ^ rotateLeft2, 1);
        iArr[3] = rotateLeft((iArr[3] ^ rotateLeft2) ^ (rotateLeft << 3), 7);
        iArr[0] = rotateLeft((rotateLeft ^ iArr[1]) ^ iArr[3], 5);
        iArr[2] = rotateLeft((iArr[3] ^ rotateLeft2) ^ (iArr[1] << 7), 22);
    }

    public abstract void decryptBlock(byte[] bArr, int i11, byte[] bArr2, int i12);

    public abstract void encryptBlock(byte[] bArr, int i11, byte[] bArr2, int i12);

    public String getAlgorithmName() {
        return "Serpent";
    }

    public int getBlockSize() {
        return 16;
    }

    public final void ib0(int[] iArr, int i11, int i12, int i13, int i14) {
        int i15 = ~i11;
        int i16 = i12 ^ i11;
        int i17 = (i15 | i16) ^ i14;
        int i18 = i13 ^ i17;
        iArr[2] = i16 ^ i18;
        int i19 = (i16 & i14) ^ i15;
        iArr[1] = (iArr[2] & i19) ^ i17;
        iArr[3] = (i11 & i17) ^ (iArr[1] | i18);
        iArr[0] = iArr[3] ^ (i19 ^ i18);
    }

    public final void ib1(int[] iArr, int i11, int i12, int i13, int i14) {
        int i15 = i14 ^ i12;
        int i16 = i11 ^ (i12 & i15);
        int i17 = i15 ^ i16;
        iArr[3] = i13 ^ i17;
        int i18 = i12 ^ (i15 & i16);
        iArr[1] = i16 ^ (iArr[3] | i18);
        int i19 = ~iArr[1];
        int i21 = i18 ^ iArr[3];
        iArr[0] = i19 ^ i21;
        iArr[2] = (i19 | i21) ^ i17;
    }

    public final void ib2(int[] iArr, int i11, int i12, int i13, int i14) {
        int i15 = i12 ^ i14;
        int i16 = ~i15;
        int i17 = i11 ^ i13;
        int i18 = i13 ^ i15;
        iArr[0] = (i12 & i18) ^ i17;
        iArr[3] = (((i11 | i16) ^ i14) | i17) ^ i15;
        int i19 = ~i18;
        int i21 = iArr[3] | iArr[0];
        iArr[1] = i19 ^ i21;
        iArr[2] = (i19 & i14) ^ (i21 ^ i17);
    }

    public final void ib3(int[] iArr, int i11, int i12, int i13, int i14) {
        int i15 = i11 | i12;
        int i16 = i12 ^ i13;
        int i17 = i11 ^ (i12 & i16);
        int i18 = i13 ^ i17;
        int i19 = i14 | i17;
        iArr[0] = i16 ^ i19;
        int i21 = (i19 | i16) ^ i14;
        iArr[2] = i18 ^ i21;
        int i22 = i15 ^ i21;
        iArr[3] = i17 ^ (iArr[0] & i22);
        iArr[1] = iArr[3] ^ (i22 ^ iArr[0]);
    }

    public final void ib4(int[] iArr, int i11, int i12, int i13, int i14) {
        int i15 = i12 ^ ((i13 | i14) & i11);
        int i16 = i13 ^ (i11 & i15);
        iArr[1] = i14 ^ i16;
        int i17 = ~i11;
        iArr[3] = (i16 & iArr[1]) ^ i15;
        int i18 = (iArr[1] | i17) ^ i14;
        iArr[0] = iArr[3] ^ i18;
        iArr[2] = (i17 ^ iArr[1]) ^ (i15 & i18);
    }

    public final void ib5(int[] iArr, int i11, int i12, int i13, int i14) {
        int i15 = ~i13;
        int i16 = (i12 & i15) ^ i14;
        int i17 = i11 & i16;
        iArr[3] = (i12 ^ i15) ^ i17;
        int i18 = iArr[3] | i12;
        iArr[1] = i16 ^ (i11 & i18);
        int i19 = i14 | i11;
        iArr[0] = (i15 ^ i18) ^ i19;
        iArr[2] = ((i11 ^ i13) | i17) ^ (i12 & i19);
    }

    public final void ib6(int[] iArr, int i11, int i12, int i13, int i14) {
        int i15 = ~i11;
        int i16 = i11 ^ i12;
        int i17 = i13 ^ i16;
        int i18 = (i13 | i15) ^ i14;
        iArr[1] = i17 ^ i18;
        int i19 = i16 ^ (i17 & i18);
        iArr[3] = i18 ^ (i12 | i19);
        int i21 = i12 | iArr[3];
        iArr[0] = i19 ^ i21;
        iArr[2] = (i14 & i15) ^ (i21 ^ i17);
    }

    public final void ib7(int[] iArr, int i11, int i12, int i13, int i14) {
        int i15 = (i11 & i12) | i13;
        int i16 = (i11 | i12) & i14;
        iArr[3] = i15 ^ i16;
        int i17 = i12 ^ i16;
        iArr[1] = ((iArr[3] ^ (~i14)) | i17) ^ i11;
        iArr[0] = (i17 ^ i13) ^ (iArr[1] | i14);
        iArr[2] = ((i11 & iArr[3]) ^ iArr[0]) ^ (iArr[1] ^ i15);
    }

    public void init(boolean z11, CipherParameters cipherParameters) {
        if (cipherParameters instanceof KeyParameter) {
            this.encrypting = z11;
            this.wKey = makeWorkingKey(((KeyParameter) cipherParameters).getKey());
            return;
        }
        throw new IllegalArgumentException("invalid parameter passed to " + getAlgorithmName() + " init - " + cipherParameters.getClass().getName());
    }

    public final void inverseLT(int[] iArr) {
        int rotateRight = (rotateRight(iArr[2], 22) ^ iArr[3]) ^ (iArr[1] << 7);
        int rotateRight2 = (rotateRight(iArr[0], 5) ^ iArr[1]) ^ iArr[3];
        int rotateRight3 = rotateRight(iArr[3], 7);
        int rotateRight4 = rotateRight(iArr[1], 1);
        iArr[3] = (rotateRight3 ^ rotateRight) ^ (rotateRight2 << 3);
        iArr[1] = (rotateRight4 ^ rotateRight2) ^ rotateRight;
        iArr[2] = rotateRight(rotateRight, 3);
        iArr[0] = rotateRight(rotateRight2, 13);
    }

    public abstract int[] makeWorkingKey(byte[] bArr);

    public final int processBlock(byte[] bArr, int i11, byte[] bArr2, int i12) {
        if (this.wKey == null) {
            throw new IllegalStateException(getAlgorithmName() + " not initialised");
        } else if (i11 + 16 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        } else if (i12 + 16 > bArr2.length) {
            throw new OutputLengthException("output buffer too short");
        } else if (this.encrypting) {
            encryptBlock(bArr, i11, bArr2, i12);
            return 16;
        } else {
            decryptBlock(bArr, i11, bArr2, i12);
            return 16;
        }
    }

    public void reset() {
    }

    public final void sb0(int[] iArr, int i11, int i12, int i13, int i14) {
        int i15 = i11 ^ i14;
        int i16 = i13 ^ i15;
        int i17 = i12 ^ i16;
        iArr[3] = (i14 & i11) ^ i17;
        int i18 = i11 ^ (i12 & i15);
        iArr[2] = (i13 | i18) ^ i17;
        int i19 = iArr[3] & (i16 ^ i18);
        iArr[1] = (~i16) ^ i19;
        iArr[0] = (~i18) ^ i19;
    }

    public final void sb1(int[] iArr, int i11, int i12, int i13, int i14) {
        int i15 = (~i11) ^ i12;
        int i16 = (i11 | i15) ^ i13;
        iArr[2] = i14 ^ i16;
        int i17 = i12 ^ (i14 | i15);
        int i18 = iArr[2] ^ i15;
        iArr[3] = (i16 & i17) ^ i18;
        int i19 = i17 ^ i16;
        iArr[1] = iArr[3] ^ i19;
        iArr[0] = i16 ^ (i19 & i18);
    }

    public final void sb2(int[] iArr, int i11, int i12, int i13, int i14) {
        int i15 = ~i11;
        int i16 = i12 ^ i14;
        iArr[0] = (i13 & i15) ^ i16;
        int i17 = i13 ^ i15;
        int i18 = i12 & (i13 ^ iArr[0]);
        iArr[3] = i17 ^ i18;
        iArr[2] = i11 ^ ((i18 | i14) & (iArr[0] | i17));
        iArr[1] = (iArr[3] ^ i16) ^ (iArr[2] ^ (i14 | i15));
    }

    public final void sb3(int[] iArr, int i11, int i12, int i13, int i14) {
        int i15 = i11 ^ i12;
        int i16 = i11 & i13;
        int i17 = i11 | i14;
        int i18 = i13 ^ i14;
        int i19 = i16 | (i15 & i17);
        iArr[2] = i18 ^ i19;
        int i21 = (i17 ^ i12) ^ i19;
        iArr[0] = i15 ^ (i18 & i21);
        int i22 = iArr[2] & iArr[0];
        iArr[1] = i21 ^ i22;
        iArr[3] = (i12 | i14) ^ (i18 ^ i22);
    }

    public final void sb4(int[] iArr, int i11, int i12, int i13, int i14) {
        int i15 = i11 ^ i14;
        int i16 = i13 ^ (i14 & i15);
        int i17 = i12 | i16;
        iArr[3] = i15 ^ i17;
        int i18 = ~i12;
        iArr[0] = (i15 | i18) ^ i16;
        int i19 = i18 ^ i15;
        iArr[2] = (i17 & i19) ^ (iArr[0] & i11);
        iArr[1] = (i11 ^ i16) ^ (i19 & iArr[2]);
    }

    public final void sb5(int[] iArr, int i11, int i12, int i13, int i14) {
        int i15 = ~i11;
        int i16 = i11 ^ i12;
        int i17 = i11 ^ i14;
        iArr[0] = (i13 ^ i15) ^ (i16 | i17);
        int i18 = iArr[0] & i14;
        iArr[1] = (iArr[0] ^ i16) ^ i18;
        int i19 = i17 ^ (iArr[0] | i15);
        iArr[2] = (i16 | i18) ^ i19;
        iArr[3] = (i19 & iArr[1]) ^ (i12 ^ i18);
    }

    public final void sb6(int[] iArr, int i11, int i12, int i13, int i14) {
        int i15 = ~i11;
        int i16 = i11 ^ i14;
        int i17 = i12 ^ i16;
        int i18 = i13 ^ (i15 | i16);
        iArr[1] = i12 ^ i18;
        int i19 = (i16 | iArr[1]) ^ i14;
        iArr[2] = (i18 & i19) ^ i17;
        int i21 = i19 ^ i18;
        iArr[0] = iArr[2] ^ i21;
        iArr[3] = (i21 & i17) ^ (~i18);
    }

    public final void sb7(int[] iArr, int i11, int i12, int i13, int i14) {
        int i15 = i12 ^ i13;
        int i16 = (i13 & i15) ^ i14;
        int i17 = i11 ^ i16;
        iArr[1] = i12 ^ ((i14 | i15) & i17);
        iArr[3] = (i11 & i17) ^ i15;
        int i18 = i17 ^ (iArr[1] | i16);
        iArr[2] = (iArr[3] & i18) ^ i16;
        iArr[0] = (~i18) ^ (iArr[3] & iArr[2]);
    }
}
