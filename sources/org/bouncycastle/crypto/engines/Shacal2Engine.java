package org.bouncycastle.crypto.engines;

import com.google.common.base.Ascii;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.params.KeyParameter;

public class Shacal2Engine implements BlockCipher {
    private static final int BLOCK_SIZE = 32;
    private static final int[] K = {1116352408, 1899447441, -1245643825, -373957723, 961987163, 1508970993, -1841331548, -1424204075, -670586216, 310598401, 607225278, 1426881987, 1925078388, -2132889090, -1680079193, -1046744716, -459576895, -272742522, 264347078, 604807628, 770255983, 1249150122, 1555081692, 1996064986, -1740746414, -1473132947, -1341970488, -1084653625, -958395405, -710438585, 113926993, 338241895, 666307205, 773529912, 1294757372, 1396182291, 1695183700, 1986661051, -2117940946, -1838011259, -1564481375, -1474664885, -1035236496, -949202525, -778901479, -694614492, -200395387, 275423344, 430227734, 506948616, 659060556, 883997877, 958139571, 1322822218, 1537002063, 1747873779, 1955562222, 2024104815, -2067236844, -1933114872, -1866530822, -1538233109, -1090935817, -965641998};
    private static final int ROUNDS = 64;
    private boolean forEncryption = false;
    private int[] workingKey = null;

    private void byteBlockToInts(byte[] bArr, int[] iArr, int i11, int i12) {
        while (i12 < 8) {
            int i13 = i11 + 1;
            int i14 = i13 + 1;
            byte b11 = ((bArr[i11] & 255) << Ascii.CAN) | ((bArr[i13] & 255) << 16);
            int i15 = i14 + 1;
            iArr[i12] = b11 | ((bArr[i14] & 255) << 8) | (bArr[i15] & 255);
            i12++;
            i11 = i15 + 1;
        }
    }

    private void bytes2ints(byte[] bArr, int[] iArr, int i11, int i12) {
        while (i12 < bArr.length / 4) {
            int i13 = i11 + 1;
            int i14 = i13 + 1;
            byte b11 = ((bArr[i11] & 255) << Ascii.CAN) | ((bArr[i13] & 255) << 16);
            int i15 = i14 + 1;
            byte b12 = b11 | ((bArr[i14] & 255) << 8);
            iArr[i12] = b12 | (bArr[i15] & 255);
            i12++;
            i11 = i15 + 1;
        }
    }

    private void decryptBlock(byte[] bArr, int i11, byte[] bArr2, int i12) {
        int[] iArr = new int[8];
        byteBlockToInts(bArr, iArr, i11, 0);
        for (int i13 = 63; i13 > -1; i13--) {
            int i14 = (iArr[0] - ((((iArr[1] >>> 2) | (iArr[1] << -2)) ^ ((iArr[1] >>> 13) | (iArr[1] << -13))) ^ ((iArr[1] >>> 22) | (iArr[1] << -22)))) - (((iArr[1] & iArr[2]) ^ (iArr[1] & iArr[3])) ^ (iArr[2] & iArr[3]));
            iArr[0] = iArr[1];
            iArr[1] = iArr[2];
            iArr[2] = iArr[3];
            iArr[3] = iArr[4] - i14;
            iArr[4] = iArr[5];
            iArr[5] = iArr[6];
            iArr[6] = iArr[7];
            iArr[7] = (((i14 - K[i13]) - this.workingKey[i13]) - ((((iArr[4] >>> 6) | (iArr[4] << -6)) ^ ((iArr[4] >>> 11) | (iArr[4] << -11))) ^ ((iArr[4] >>> 25) | (iArr[4] << -25)))) - (((~iArr[4]) & iArr[6]) ^ (iArr[5] & iArr[4]));
        }
        ints2bytes(iArr, bArr2, i12);
    }

    private void encryptBlock(byte[] bArr, int i11, byte[] bArr2, int i12) {
        int[] iArr = new int[8];
        byteBlockToInts(bArr, iArr, i11, 0);
        for (int i13 = 0; i13 < 64; i13++) {
            int i14 = ((((iArr[4] >>> 6) | (iArr[4] << -6)) ^ ((iArr[4] >>> 11) | (iArr[4] << -11))) ^ ((iArr[4] >>> 25) | (iArr[4] << -25))) + ((iArr[4] & iArr[5]) ^ ((~iArr[4]) & iArr[6])) + iArr[7] + K[i13] + this.workingKey[i13];
            iArr[7] = iArr[6];
            iArr[6] = iArr[5];
            iArr[5] = iArr[4];
            iArr[4] = iArr[3] + i14;
            iArr[3] = iArr[2];
            iArr[2] = iArr[1];
            iArr[1] = iArr[0];
            iArr[0] = i14 + ((((iArr[0] >>> 2) | (iArr[0] << -2)) ^ ((iArr[0] >>> 13) | (iArr[0] << -13))) ^ ((iArr[0] >>> 22) | (iArr[0] << -22))) + ((iArr[2] & iArr[3]) ^ ((iArr[0] & iArr[2]) ^ (iArr[0] & iArr[3])));
        }
        ints2bytes(iArr, bArr2, i12);
    }

    private void ints2bytes(int[] iArr, byte[] bArr, int i11) {
        for (int i12 = 0; i12 < iArr.length; i12++) {
            int i13 = i11 + 1;
            bArr[i11] = (byte) (iArr[i12] >>> 24);
            int i14 = i13 + 1;
            bArr[i13] = (byte) (iArr[i12] >>> 16);
            int i15 = i14 + 1;
            bArr[i14] = (byte) (iArr[i12] >>> 8);
            i11 = i15 + 1;
            bArr[i15] = (byte) iArr[i12];
        }
    }

    public String getAlgorithmName() {
        return "Shacal2";
    }

    public int getBlockSize() {
        return 32;
    }

    public void init(boolean z11, CipherParameters cipherParameters) throws IllegalArgumentException {
        if (cipherParameters instanceof KeyParameter) {
            this.forEncryption = z11;
            this.workingKey = new int[64];
            setKey(((KeyParameter) cipherParameters).getKey());
            return;
        }
        throw new IllegalArgumentException("only simple KeyParameter expected.");
    }

    public int processBlock(byte[] bArr, int i11, byte[] bArr2, int i12) throws DataLengthException, IllegalStateException {
        if (this.workingKey == null) {
            throw new IllegalStateException("Shacal2 not initialised");
        } else if (i11 + 32 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        } else if (i12 + 32 > bArr2.length) {
            throw new OutputLengthException("output buffer too short");
        } else if (this.forEncryption) {
            encryptBlock(bArr, i11, bArr2, i12);
            return 32;
        } else {
            decryptBlock(bArr, i11, bArr2, i12);
            return 32;
        }
    }

    public void reset() {
    }

    public void setKey(byte[] bArr) {
        if (bArr.length != 0 && bArr.length <= 64) {
            if (bArr.length >= 16 && bArr.length % 8 == 0) {
                bytes2ints(bArr, this.workingKey, 0, 0);
                for (int i11 = 16; i11 < 64; i11++) {
                    int[] iArr = this.workingKey;
                    int i12 = i11 - 2;
                    int i13 = i11 - 15;
                    iArr[i11] = ((iArr[i12] >>> 10) ^ (((iArr[i12] >>> 17) | (iArr[i12] << -17)) ^ ((iArr[i12] >>> 19) | (iArr[i12] << -19)))) + iArr[i11 - 7] + ((iArr[i13] >>> 3) ^ (((iArr[i13] >>> 7) | (iArr[i13] << -7)) ^ ((iArr[i13] >>> 18) | (iArr[i13] << -18)))) + iArr[i11 - 16];
                }
                return;
            }
        }
        throw new IllegalArgumentException("Shacal2-key must be 16 - 64 bytes and multiple of 8");
    }
}
