package org.bouncycastle.crypto.engines;

import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import net.sf.scuba.smartcards.ISO7816;
import net.sf.scuba.smartcards.ISOFileInfo;
import okio.Utf8;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.signers.PSSSigner;
import org.bouncycastle.util.Pack;
import org.jmrtd.lds.CVCAFile;

public class SM4Engine implements BlockCipher {
    private static final int BLOCK_SIZE = 16;
    private static final int[] CK = {462357, 472066609, 943670861, 1415275113, 1886879365, -1936483679, -1464879427, -993275175, -521670923, -66909679, 404694573, 876298825, 1347903077, 1819507329, -2003855715, -1532251463, -1060647211, -589042959, -117504499, 337322537, 808926789, 1280531041, 1752135293, -2071227751, -1599623499, -1128019247, -656414995, -184876535, 269950501, 741554753, 1213159005, 1684763257};
    private static final int[] FK = {-1548633402, 1453994832, 1736282519, -1301273892};
    private static final byte[] Sbox = {ISO7816.INS_UPDATE_BINARY, -112, -23, -2, -52, -31, 61, -73, 22, ISO7816.INS_READ_RECORD_STAMPED, 20, ISO7816.INS_ENVELOPE, 40, -5, ISO7816.INS_UNBLOCK_CHV, 5, 43, 103, -102, 118, ISO7816.INS_PSO, -66, 4, -61, -86, ISO7816.INS_REHABILITATE_CHV, 19, 38, 73, -122, 6, -103, -100, CVCAFile.CAR_TAG, 80, -12, -111, -17, -104, 122, 51, 84, 11, 67, -19, -49, -84, ISOFileInfo.FCP_BYTE, ISO7816.INS_DELETE_FILE, ISO7816.INS_READ_RECORD2, 28, -87, -55, 8, -24, -107, Byte.MIN_VALUE, -33, -108, -6, 117, -113, Utf8.REPLACEMENT_BYTE, -90, 71, 7, -89, -4, -13, 115, 23, -70, ISOFileInfo.FILE_IDENTIFIER, 89, 60, Ascii.EM, -26, ISOFileInfo.PROP_INFO, 79, -88, 104, 107, ISOFileInfo.DATA_BYTES2, -78, 113, 100, ISO7816.INS_PUT_DATA, ISOFileInfo.SECURITY_ATTR_EXP, -8, -21, 15, 75, ISO7816.INS_MANAGE_CHANNEL, 86, -99, 53, 30, ISO7816.INS_CHANGE_CHV, 14, 94, 99, 88, -47, -94, 37, ISO7816.INS_MSE, 124, 59, 1, Framer.ENTER_FRAME_PREFIX, Framer.EXIT_FRAME_PREFIX, ISOFileInfo.FCI_EXT, -44, 0, 70, 87, -97, -45, 39, 82, 76, 54, 2, -25, ISOFileInfo.A0, -60, -56, -98, -22, -65, ISOFileInfo.LCS_BYTE, ISO7816.INS_WRITE_RECORD, SignedBytes.MAX_POWER_OF_TWO, -57, 56, -75, -93, -9, -14, -50, -7, 97, 21, ISOFileInfo.A1, ISO7816.INS_CREATE_FILE, -82, 93, -92, -101, ISO7816.INS_DECREASE_STAMPED, Ascii.SUB, 85, -83, -109, 50, ISO7816.INS_DECREASE, -11, ISOFileInfo.SECURITY_ATTR_COMPACT, ISO7816.INS_READ_BINARY2, -29, 29, -10, ISO7816.INS_APPEND_RECORD, 46, -126, 102, ISO7816.INS_GET_DATA, 96, ISO7816.INS_GET_RESPONSE, 41, 35, ISOFileInfo.AB, 13, 83, 78, ISOFileInfo.FCI_BYTE, -43, -37, 55, 69, -34, -3, ISOFileInfo.CHANNEL_SECURITY, 47, 3, -1, 106, 114, 109, 108, 91, 81, ISOFileInfo.ENV_TEMP_EF, Ascii.ESC, -81, -110, -69, -35, PSSSigner.TRAILER_IMPLICIT, Ascii.DEL, 17, -39, 92, 65, Ascii.US, 16, 90, ISO7816.INS_LOAD_KEY_FILE, 10, -63, Framer.STDOUT_FRAME_PREFIX, -120, ISOFileInfo.A5, -51, 123, -67, Framer.STDIN_FRAME_PREFIX, 116, ISO7816.INS_WRITE_BINARY, 18, -72, -27, ISO7816.INS_READ_BINARY_STAMPED, ISO7816.INS_READ_BINARY, -119, 105, -105, 74, 12, -106, 119, 126, 101, -71, -15, 9, -59, 110, -58, -124, Ascii.CAN, -16, 125, -20, 58, ISO7816.INS_UPDATE_RECORD, 77, 32, 121, -18, 95, 62, -41, -53, 57, 72};
    private final int[] X = new int[4];

    /* renamed from: rk  reason: collision with root package name */
    private int[] f59184rk;

    private int F0(int[] iArr, int i11) {
        return T((iArr[3] ^ (iArr[1] ^ iArr[2])) ^ i11) ^ iArr[0];
    }

    private int F1(int[] iArr, int i11) {
        return T((iArr[0] ^ (iArr[2] ^ iArr[3])) ^ i11) ^ iArr[1];
    }

    private int F2(int[] iArr, int i11) {
        return T((iArr[1] ^ (iArr[3] ^ iArr[0])) ^ i11) ^ iArr[2];
    }

    private int F3(int[] iArr, int i11) {
        return T((iArr[2] ^ (iArr[0] ^ iArr[1])) ^ i11) ^ iArr[3];
    }

    private int L(int i11) {
        return rotateLeft(i11, 24) ^ (((rotateLeft(i11, 2) ^ i11) ^ rotateLeft(i11, 10)) ^ rotateLeft(i11, 18));
    }

    private int L_ap(int i11) {
        return rotateLeft(i11, 23) ^ (rotateLeft(i11, 13) ^ i11);
    }

    private int T(int i11) {
        return L(tau(i11));
    }

    private int T_ap(int i11) {
        return L_ap(tau(i11));
    }

    private int[] expandKey(boolean z11, byte[] bArr) {
        int[] iArr = new int[32];
        int[] iArr2 = {Pack.bigEndianToInt(bArr, 0), Pack.bigEndianToInt(bArr, 4), Pack.bigEndianToInt(bArr, 8), Pack.bigEndianToInt(bArr, 12)};
        int i11 = iArr2[0];
        int[] iArr3 = FK;
        int[] iArr4 = {i11 ^ iArr3[0], iArr2[1] ^ iArr3[1], iArr2[2] ^ iArr3[2], iArr2[3] ^ iArr3[3]};
        if (z11) {
            int i12 = iArr4[0];
            int i13 = (iArr4[1] ^ iArr4[2]) ^ iArr4[3];
            int[] iArr5 = CK;
            iArr[0] = i12 ^ T_ap(i13 ^ iArr5[0]);
            iArr[1] = iArr4[1] ^ T_ap(((iArr4[2] ^ iArr4[3]) ^ iArr[0]) ^ iArr5[1]);
            iArr[2] = iArr4[2] ^ T_ap(((iArr4[3] ^ iArr[0]) ^ iArr[1]) ^ iArr5[2]);
            iArr[3] = iArr4[3] ^ T_ap(((iArr[0] ^ iArr[1]) ^ iArr[2]) ^ iArr5[3]);
            for (int i14 = 4; i14 < 32; i14++) {
                iArr[i14] = iArr[i14 - 4] ^ T_ap(((iArr[i14 - 3] ^ iArr[i14 - 2]) ^ iArr[i14 - 1]) ^ CK[i14]);
            }
        } else {
            int i15 = iArr4[0];
            int i16 = (iArr4[1] ^ iArr4[2]) ^ iArr4[3];
            int[] iArr6 = CK;
            iArr[31] = i15 ^ T_ap(i16 ^ iArr6[0]);
            iArr[30] = iArr4[1] ^ T_ap(((iArr4[2] ^ iArr4[3]) ^ iArr[31]) ^ iArr6[1]);
            iArr[29] = iArr4[2] ^ T_ap(((iArr4[3] ^ iArr[31]) ^ iArr[30]) ^ iArr6[2]);
            iArr[28] = iArr4[3] ^ T_ap(((iArr[31] ^ iArr[30]) ^ iArr[29]) ^ iArr6[3]);
            for (int i17 = 27; i17 >= 0; i17--) {
                iArr[i17] = iArr[i17 + 4] ^ T_ap(((iArr[i17 + 3] ^ iArr[i17 + 2]) ^ iArr[i17 + 1]) ^ CK[31 - i17]);
            }
        }
        return iArr;
    }

    private int rotateLeft(int i11, int i12) {
        return (i11 >>> (-i12)) | (i11 << i12);
    }

    private int tau(int i11) {
        byte[] bArr = Sbox;
        return (bArr[i11 & 255] & 255) | ((bArr[(i11 >> 24) & 255] & 255) << Ascii.CAN) | ((bArr[(i11 >> 16) & 255] & 255) << 16) | ((bArr[(i11 >> 8) & 255] & 255) << 8);
    }

    public String getAlgorithmName() {
        return "SM4";
    }

    public int getBlockSize() {
        return 16;
    }

    public void init(boolean z11, CipherParameters cipherParameters) throws IllegalArgumentException {
        if (cipherParameters instanceof KeyParameter) {
            byte[] key = ((KeyParameter) cipherParameters).getKey();
            if (key.length == 16) {
                this.f59184rk = expandKey(z11, key);
                return;
            }
            throw new IllegalArgumentException("SM4 requires a 128 bit key");
        }
        throw new IllegalArgumentException("invalid parameter passed to SM4 init - " + cipherParameters.getClass().getName());
    }

    public int processBlock(byte[] bArr, int i11, byte[] bArr2, int i12) throws DataLengthException, IllegalStateException {
        if (this.f59184rk == null) {
            throw new IllegalStateException("SM4 not initialised");
        } else if (i11 + 16 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        } else if (i12 + 16 <= bArr2.length) {
            this.X[0] = Pack.bigEndianToInt(bArr, i11);
            this.X[1] = Pack.bigEndianToInt(bArr, i11 + 4);
            this.X[2] = Pack.bigEndianToInt(bArr, i11 + 8);
            this.X[3] = Pack.bigEndianToInt(bArr, i11 + 12);
            for (int i13 = 0; i13 < 32; i13 += 4) {
                int[] iArr = this.X;
                iArr[0] = F0(iArr, this.f59184rk[i13]);
                int[] iArr2 = this.X;
                iArr2[1] = F1(iArr2, this.f59184rk[i13 + 1]);
                int[] iArr3 = this.X;
                iArr3[2] = F2(iArr3, this.f59184rk[i13 + 2]);
                int[] iArr4 = this.X;
                iArr4[3] = F3(iArr4, this.f59184rk[i13 + 3]);
            }
            Pack.intToBigEndian(this.X[3], bArr2, i12);
            Pack.intToBigEndian(this.X[2], bArr2, i12 + 4);
            Pack.intToBigEndian(this.X[1], bArr2, i12 + 8);
            Pack.intToBigEndian(this.X[0], bArr2, i12 + 12);
            return 16;
        } else {
            throw new OutputLengthException("output buffer too short");
        }
    }

    public void reset() {
    }
}
