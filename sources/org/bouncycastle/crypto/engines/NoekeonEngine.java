package org.bouncycastle.crypto.engines;

import com.google.common.base.Ascii;
import net.sf.scuba.smartcards.ISO7816;
import net.sf.scuba.smartcards.ISOFileInfo;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.signers.PSSSigner;
import org.bouncycastle.util.Integers;
import org.bouncycastle.util.Pack;

public class NoekeonEngine implements BlockCipher {
    private static final int SIZE = 16;
    private static final byte[] roundConstants = {Byte.MIN_VALUE, Ascii.ESC, 54, 108, ISO7816.INS_LOAD_KEY_FILE, ISOFileInfo.AB, 77, -102, 47, 94, PSSSigner.TRAILER_IMPLICIT, 99, -58, -105, 53, 106, -44};
    private boolean _forEncryption;
    private boolean _initialised = false;

    /* renamed from: k  reason: collision with root package name */
    private final int[] f59178k = new int[4];

    private int decryptBlock(byte[] bArr, int i11, byte[] bArr2, int i12) {
        byte[] bArr3 = bArr;
        byte[] bArr4 = bArr2;
        int i13 = i12;
        int bigEndianToInt = Pack.bigEndianToInt(bArr, i11);
        int bigEndianToInt2 = Pack.bigEndianToInt(bArr3, i11 + 4);
        int bigEndianToInt3 = Pack.bigEndianToInt(bArr3, i11 + 8);
        int bigEndianToInt4 = Pack.bigEndianToInt(bArr3, i11 + 12);
        int[] iArr = this.f59178k;
        int i14 = iArr[0];
        int i15 = iArr[1];
        int i16 = iArr[2];
        int i17 = iArr[3];
        int i18 = 16;
        while (true) {
            byte b11 = bigEndianToInt ^ bigEndianToInt3;
            byte rotateLeft = b11 ^ (Integers.rotateLeft(b11, 8) ^ Integers.rotateLeft(b11, 24));
            byte b12 = bigEndianToInt2 ^ i15;
            byte b13 = bigEndianToInt4 ^ i17;
            byte b14 = b12 ^ b13;
            byte rotateLeft2 = (Integers.rotateLeft(b14, 24) ^ Integers.rotateLeft(b14, 8)) ^ b14;
            byte b15 = b12 ^ rotateLeft;
            byte b16 = (bigEndianToInt3 ^ i16) ^ rotateLeft2;
            byte b17 = b13 ^ rotateLeft;
            byte b18 = ((bigEndianToInt ^ i14) ^ rotateLeft2) ^ (roundConstants[i18] & 255);
            i18--;
            if (i18 < 0) {
                Pack.intToBigEndian((int) b18, bArr4, i13);
                Pack.intToBigEndian((int) b15, bArr4, i13 + 4);
                Pack.intToBigEndian((int) b16, bArr4, i13 + 8);
                Pack.intToBigEndian((int) b17, bArr4, i13 + 12);
                return 16;
            }
            int rotateLeft3 = Integers.rotateLeft(b15, 1);
            int rotateLeft4 = Integers.rotateLeft(b16, 5);
            int rotateLeft5 = Integers.rotateLeft(b17, 2);
            byte b19 = rotateLeft3 ^ (rotateLeft5 | rotateLeft4);
            int i19 = ~b19;
            byte b21 = b18 ^ (rotateLeft4 & i19);
            byte b22 = (rotateLeft4 ^ (i19 ^ rotateLeft5)) ^ b21;
            byte b23 = b19 ^ (b21 | b22);
            bigEndianToInt2 = Integers.rotateLeft(b23, 31);
            bigEndianToInt3 = Integers.rotateLeft(b22, 27);
            int rotateLeft6 = Integers.rotateLeft(b21, 30);
            bigEndianToInt = rotateLeft5 ^ (b22 & b23);
            bigEndianToInt4 = rotateLeft6;
        }
    }

    private int encryptBlock(byte[] bArr, int i11, byte[] bArr2, int i12) {
        byte[] bArr3 = bArr;
        byte[] bArr4 = bArr2;
        int i13 = i12;
        int bigEndianToInt = Pack.bigEndianToInt(bArr, i11);
        int bigEndianToInt2 = Pack.bigEndianToInt(bArr3, i11 + 4);
        int bigEndianToInt3 = Pack.bigEndianToInt(bArr3, i11 + 8);
        int bigEndianToInt4 = Pack.bigEndianToInt(bArr3, i11 + 12);
        int[] iArr = this.f59178k;
        int i14 = 0;
        int i15 = iArr[0];
        int i16 = iArr[1];
        int i17 = iArr[2];
        int i18 = iArr[3];
        while (true) {
            byte b11 = bigEndianToInt ^ (roundConstants[i14] & 255);
            byte b12 = b11 ^ bigEndianToInt3;
            byte rotateLeft = b12 ^ (Integers.rotateLeft(b12, 8) ^ Integers.rotateLeft(b12, 24));
            byte b13 = bigEndianToInt2 ^ i16;
            byte b14 = bigEndianToInt4 ^ i18;
            byte b15 = b13 ^ b14;
            byte rotateLeft2 = b15 ^ (Integers.rotateLeft(b15, 24) ^ Integers.rotateLeft(b15, 8));
            byte b16 = (b11 ^ i15) ^ rotateLeft2;
            byte b17 = b13 ^ rotateLeft;
            byte b18 = (bigEndianToInt3 ^ i17) ^ rotateLeft2;
            byte b19 = b14 ^ rotateLeft;
            i14++;
            if (i14 > 16) {
                Pack.intToBigEndian((int) b16, bArr4, i13);
                Pack.intToBigEndian((int) b17, bArr4, i13 + 4);
                Pack.intToBigEndian((int) b18, bArr4, i13 + 8);
                Pack.intToBigEndian((int) b19, bArr4, i13 + 12);
                return 16;
            }
            int rotateLeft3 = Integers.rotateLeft(b17, 1);
            int rotateLeft4 = Integers.rotateLeft(b18, 5);
            int rotateLeft5 = Integers.rotateLeft(b19, 2);
            byte b21 = rotateLeft3 ^ (rotateLeft5 | rotateLeft4);
            int i19 = ~b21;
            byte b22 = b16 ^ (rotateLeft4 & i19);
            byte b23 = (rotateLeft4 ^ (i19 ^ rotateLeft5)) ^ b22;
            byte b24 = b21 ^ (b22 | b23);
            bigEndianToInt2 = Integers.rotateLeft(b24, 31);
            bigEndianToInt3 = Integers.rotateLeft(b23, 27);
            int rotateLeft6 = Integers.rotateLeft(b22, 30);
            bigEndianToInt = rotateLeft5 ^ (b23 & b24);
            bigEndianToInt4 = rotateLeft6;
        }
    }

    public String getAlgorithmName() {
        return "Noekeon";
    }

    public int getBlockSize() {
        return 16;
    }

    public void init(boolean z11, CipherParameters cipherParameters) {
        if (cipherParameters instanceof KeyParameter) {
            byte[] key = ((KeyParameter) cipherParameters).getKey();
            if (key.length == 16) {
                Pack.bigEndianToInt(key, 0, this.f59178k, 0, 4);
                if (!z11) {
                    int[] iArr = this.f59178k;
                    int i11 = iArr[0];
                    int i12 = iArr[1];
                    int i13 = iArr[2];
                    int i14 = iArr[3];
                    int i15 = i11 ^ i13;
                    int rotateLeft = i15 ^ (Integers.rotateLeft(i15, 8) ^ Integers.rotateLeft(i15, 24));
                    int i16 = i12 ^ i14;
                    int rotateLeft2 = (Integers.rotateLeft(i16, 8) ^ Integers.rotateLeft(i16, 24)) ^ i16;
                    int i17 = i12 ^ rotateLeft;
                    int i18 = i14 ^ rotateLeft;
                    int[] iArr2 = this.f59178k;
                    iArr2[0] = i11 ^ rotateLeft2;
                    iArr2[1] = i17;
                    iArr2[2] = i13 ^ rotateLeft2;
                    iArr2[3] = i18;
                }
                this._forEncryption = z11;
                this._initialised = true;
                return;
            }
            throw new IllegalArgumentException("Key length not 128 bits.");
        }
        throw new IllegalArgumentException("invalid parameter passed to Noekeon init - " + cipherParameters.getClass().getName());
    }

    public int processBlock(byte[] bArr, int i11, byte[] bArr2, int i12) {
        if (!this._initialised) {
            throw new IllegalStateException(getAlgorithmName() + " not initialised");
        } else if (i11 > bArr.length - 16) {
            throw new DataLengthException("input buffer too short");
        } else if (i12 <= bArr2.length - 16) {
            return this._forEncryption ? encryptBlock(bArr, i11, bArr2, i12) : decryptBlock(bArr, i11, bArr2, i12);
        } else {
            throw new OutputLengthException("output buffer too short");
        }
    }

    public void reset() {
    }
}
