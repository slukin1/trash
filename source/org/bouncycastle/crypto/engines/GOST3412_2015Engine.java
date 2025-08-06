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
import org.bouncycastle.util.Arrays;
import org.jmrtd.lds.CVCAFile;

public class GOST3412_2015Engine implements BlockCipher {
    public static final int BLOCK_SIZE = 16;
    private static final byte[] PI = {-4, -18, -35, 17, -49, 110, Framer.STDOUT_FRAME_PREFIX, 22, -5, -60, -6, ISO7816.INS_PUT_DATA, 35, -59, 4, 77, -23, 119, -16, -37, -109, 46, -103, -70, 23, 54, -15, -69, 20, -51, 95, -63, -7, Ascii.CAN, 101, 90, ISO7816.INS_APPEND_RECORD, 92, -17, Framer.ENTER_FRAME_PREFIX, ISOFileInfo.DATA_BYTES2, 28, 60, CVCAFile.CAR_TAG, ISOFileInfo.SECURITY_ATTR_EXP, 1, ISOFileInfo.CHANNEL_SECURITY, 79, 5, -124, 2, -82, -29, 106, -113, ISOFileInfo.A0, 6, 11, -19, -104, Ascii.DEL, -44, -45, Ascii.US, -21, ISO7816.INS_DECREASE_STAMPED, ISO7816.INS_UNBLOCK_CHV, 81, -22, -56, 72, ISOFileInfo.AB, -14, ISO7816.INS_PSO, 104, -94, -3, 58, -50, -52, -75, ISO7816.INS_MANAGE_CHANNEL, 14, 86, 8, 12, 118, 18, -65, 114, 19, 71, -100, -73, 93, ISOFileInfo.FCI_EXT, 21, ISOFileInfo.A1, -106, 41, 16, 123, -102, -57, -13, -111, Framer.EXIT_FRAME_PREFIX, ISOFileInfo.FCI_BYTE, -99, -98, -78, ISO7816.INS_READ_BINARY2, 50, 117, Ascii.EM, 61, -1, 53, ISOFileInfo.LCS_BYTE, 126, 109, 84, -58, Byte.MIN_VALUE, -61, -67, 13, 87, -33, -11, ISO7816.INS_CHANGE_CHV, -87, 62, -88, 67, -55, -41, 121, ISO7816.INS_UPDATE_BINARY, -10, 124, ISO7816.INS_MSE, -71, 3, ISO7816.INS_CREATE_FILE, 15, -20, -34, 122, -108, ISO7816.INS_READ_BINARY, PSSSigner.TRAILER_IMPLICIT, ISO7816.INS_UPDATE_RECORD, -24, 40, 80, 78, 51, 10, 74, -89, -105, 96, 115, 30, 0, ISOFileInfo.FCP_BYTE, ISO7816.INS_REHABILITATE_CHV, Ascii.SUB, -72, 56, -126, 100, -97, 38, 65, -83, 69, 70, -110, 39, 94, 85, 47, ISOFileInfo.SECURITY_ATTR_COMPACT, -93, ISOFileInfo.A5, 125, 105, -43, -107, 59, 7, 88, ISO7816.INS_READ_RECORD2, SignedBytes.MAX_POWER_OF_TWO, -122, -84, 29, -9, ISO7816.INS_DECREASE, 55, 107, ISO7816.INS_DELETE_FILE, -120, -39, -25, -119, -31, Ascii.ESC, ISOFileInfo.FILE_IDENTIFIER, 73, 76, Utf8.REPLACEMENT_BYTE, -8, -2, ISOFileInfo.ENV_TEMP_EF, 83, -86, -112, ISO7816.INS_GET_DATA, ISO7816.INS_LOAD_KEY_FILE, ISOFileInfo.PROP_INFO, 97, 32, 113, 103, -92, Framer.STDIN_FRAME_PREFIX, 43, 9, 91, -53, -101, 37, ISO7816.INS_WRITE_BINARY, -66, -27, 108, 82, 89, -90, 116, ISO7816.INS_WRITE_RECORD, -26, -12, ISO7816.INS_READ_BINARY_STAMPED, ISO7816.INS_GET_RESPONSE, -47, 102, -81, ISO7816.INS_ENVELOPE, 57, 75, 99, ISO7816.INS_READ_RECORD_STAMPED};
    private static final byte[] inversePI = {ISOFileInfo.A5, Framer.STDIN_FRAME_PREFIX, 50, -113, 14, ISO7816.INS_DECREASE, 56, ISO7816.INS_GET_RESPONSE, 84, -26, -98, 57, 85, 126, 82, -111, 100, 3, 87, 90, 28, 96, 7, Ascii.CAN, Framer.ENTER_FRAME_PREFIX, 114, -88, -47, 41, -58, -92, Utf8.REPLACEMENT_BYTE, ISO7816.INS_CREATE_FILE, 39, ISOFileInfo.ENV_TEMP_EF, 12, -126, -22, -82, ISO7816.INS_READ_BINARY_STAMPED, -102, 99, 73, -27, CVCAFile.CAR_TAG, ISO7816.INS_DELETE_FILE, 21, -73, -56, 6, ISO7816.INS_MANAGE_CHANNEL, -99, 65, 117, Ascii.EM, -55, -86, -4, 77, -65, ISO7816.INS_PSO, 115, -124, -43, -61, -81, 43, -122, -89, ISO7816.INS_READ_BINARY2, -78, 91, 70, -45, -97, -3, -44, 15, -100, 47, -101, 67, -17, -39, 121, ISO7816.INS_READ_RECORD_STAMPED, 83, Ascii.DEL, -63, -16, 35, -25, 37, 94, -75, 30, -94, -33, -90, -2, -84, ISO7816.INS_MSE, -7, ISO7816.INS_APPEND_RECORD, 74, PSSSigner.TRAILER_IMPLICIT, 53, ISO7816.INS_GET_DATA, -18, Framer.EXIT_FRAME_PREFIX, 5, 107, 81, -31, 89, -93, -14, 113, 86, 17, 106, -119, -108, 101, ISOFileInfo.SECURITY_ATTR_COMPACT, -69, 119, 60, 123, 40, ISOFileInfo.AB, ISO7816.INS_WRITE_RECORD, Framer.STDOUT_FRAME_PREFIX, -34, -60, 95, -52, -49, 118, ISO7816.INS_UNBLOCK_CHV, -72, ISO7816.INS_LOAD_KEY_FILE, 46, 54, -37, 105, ISO7816.INS_READ_RECORD2, 20, -107, -66, ISOFileInfo.FCP_BYTE, ISOFileInfo.A1, 59, 22, 102, -23, 92, 108, 109, -83, 55, 97, 75, -71, -29, -70, -15, ISOFileInfo.A0, ISOFileInfo.PROP_INFO, ISOFileInfo.FILE_IDENTIFIER, ISO7816.INS_PUT_DATA, 71, -59, ISO7816.INS_READ_BINARY, 51, -6, -106, ISOFileInfo.FCI_BYTE, 110, ISO7816.INS_ENVELOPE, -10, 80, -1, 93, -87, ISOFileInfo.CHANNEL_SECURITY, 23, Ascii.ESC, -105, 125, -20, 88, -9, Ascii.US, -5, 124, 9, 13, 122, 103, 69, ISOFileInfo.FCI_EXT, ISO7816.INS_UPDATE_RECORD, -24, 79, 29, 78, 4, -21, -8, -13, 62, 61, -67, ISOFileInfo.LCS_BYTE, -120, -35, -51, 11, 19, -104, 2, -109, Byte.MIN_VALUE, -112, ISO7816.INS_WRITE_BINARY, ISO7816.INS_CHANGE_CHV, ISO7816.INS_DECREASE_STAMPED, -53, -19, -12, -50, -103, 16, ISO7816.INS_REHABILITATE_CHV, SignedBytes.MAX_POWER_OF_TWO, -110, 58, 1, 38, 18, Ascii.SUB, 72, 104, -11, ISOFileInfo.DATA_BYTES2, ISOFileInfo.SECURITY_ATTR_EXP, -57, ISO7816.INS_UPDATE_BINARY, 32, 10, 8, 0, 76, -41, 116};
    private int KEY_LENGTH = 32;
    private int SUB_LENGTH = (32 / 2);
    private byte[][] _gf_mul = init_gf256_mul_table();
    private boolean forEncryption;
    private final byte[] lFactors = {-108, 32, ISOFileInfo.PROP_INFO, 16, ISO7816.INS_ENVELOPE, ISO7816.INS_GET_RESPONSE, 1, -5, 1, ISO7816.INS_GET_RESPONSE, ISO7816.INS_ENVELOPE, 16, ISOFileInfo.PROP_INFO, 32, -108, 1};
    private byte[][] subKeys = null;

    private void C(byte[] bArr, int i11) {
        Arrays.clear(bArr);
        bArr[15] = (byte) i11;
        L(bArr);
    }

    private void F(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        byte[] LSX = LSX(bArr, bArr2);
        X(LSX, bArr3);
        System.arraycopy(bArr2, 0, bArr3, 0, this.SUB_LENGTH);
        System.arraycopy(LSX, 0, bArr2, 0, this.SUB_LENGTH);
    }

    private void GOST3412_2015Func(byte[] bArr, int i11, byte[] bArr2, int i12) {
        byte[][] bArr3;
        byte[] bArr4 = new byte[16];
        System.arraycopy(bArr, i11, bArr4, 0, 16);
        int i13 = 9;
        if (this.forEncryption) {
            for (int i14 = 0; i14 < 9; i14++) {
                bArr4 = Arrays.copyOf(LSX(this.subKeys[i14], bArr4), 16);
            }
            X(bArr4, this.subKeys[9]);
        } else {
            while (true) {
                bArr3 = this.subKeys;
                if (i13 <= 0) {
                    break;
                }
                bArr4 = Arrays.copyOf(XSL(bArr3[i13], bArr4), 16);
                i13--;
            }
            X(bArr4, bArr3[0]);
        }
        System.arraycopy(bArr4, 0, bArr2, i12, 16);
    }

    private void L(byte[] bArr) {
        for (int i11 = 0; i11 < 16; i11++) {
            R(bArr);
        }
    }

    private byte[] LSX(byte[] bArr, byte[] bArr2) {
        byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
        X(copyOf, bArr2);
        S(copyOf);
        L(copyOf);
        return copyOf;
    }

    private void R(byte[] bArr) {
        byte l11 = l(bArr);
        System.arraycopy(bArr, 0, bArr, 1, 15);
        bArr[0] = l11;
    }

    private void S(byte[] bArr) {
        for (int i11 = 0; i11 < bArr.length; i11++) {
            bArr[i11] = PI[unsignedByte(bArr[i11])];
        }
    }

    private void X(byte[] bArr, byte[] bArr2) {
        for (int i11 = 0; i11 < bArr.length; i11++) {
            bArr[i11] = (byte) (bArr[i11] ^ bArr2[i11]);
        }
    }

    private byte[] XSL(byte[] bArr, byte[] bArr2) {
        byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
        X(copyOf, bArr2);
        inverseL(copyOf);
        inverseS(copyOf);
        return copyOf;
    }

    private void generateSubKeys(byte[] bArr) {
        int i11;
        if (bArr.length == this.KEY_LENGTH) {
            this.subKeys = new byte[10][];
            for (int i12 = 0; i12 < 10; i12++) {
                this.subKeys[i12] = new byte[this.SUB_LENGTH];
            }
            int i13 = this.SUB_LENGTH;
            byte[] bArr2 = new byte[i13];
            byte[] bArr3 = new byte[i13];
            int i14 = 0;
            while (true) {
                i11 = this.SUB_LENGTH;
                if (i14 >= i11) {
                    break;
                }
                byte[][] bArr4 = this.subKeys;
                byte[] bArr5 = bArr4[0];
                byte b11 = bArr[i14];
                bArr2[i14] = b11;
                bArr5[i14] = b11;
                byte[] bArr6 = bArr4[1];
                byte b12 = bArr[i11 + i14];
                bArr3[i14] = b12;
                bArr6[i14] = b12;
                i14++;
            }
            byte[] bArr7 = new byte[i11];
            for (int i15 = 1; i15 < 5; i15++) {
                for (int i16 = 1; i16 <= 8; i16++) {
                    C(bArr7, ((i15 - 1) * 8) + i16);
                    F(bArr7, bArr2, bArr3);
                }
                int i17 = i15 * 2;
                System.arraycopy(bArr2, 0, this.subKeys[i17], 0, this.SUB_LENGTH);
                System.arraycopy(bArr3, 0, this.subKeys[i17 + 1], 0, this.SUB_LENGTH);
            }
            return;
        }
        throw new IllegalArgumentException("Key length invalid. Key needs to be 32 byte - 256 bit!!!");
    }

    private static byte[][] init_gf256_mul_table() {
        byte[][] bArr = new byte[256][];
        for (int i11 = 0; i11 < 256; i11++) {
            bArr[i11] = new byte[256];
            for (int i12 = 0; i12 < 256; i12++) {
                bArr[i11][i12] = kuz_mul_gf256_slow((byte) i11, (byte) i12);
            }
        }
        return bArr;
    }

    private void inverseL(byte[] bArr) {
        for (int i11 = 0; i11 < 16; i11++) {
            inverseR(bArr);
        }
    }

    private void inverseR(byte[] bArr) {
        byte[] bArr2 = new byte[16];
        System.arraycopy(bArr, 1, bArr2, 0, 15);
        bArr2[15] = bArr[0];
        byte l11 = l(bArr2);
        System.arraycopy(bArr, 1, bArr, 0, 15);
        bArr[15] = l11;
    }

    private void inverseS(byte[] bArr) {
        for (int i11 = 0; i11 < bArr.length; i11++) {
            bArr[i11] = inversePI[unsignedByte(bArr[i11])];
        }
    }

    private static byte kuz_mul_gf256_slow(byte b11, byte b12) {
        byte b13 = 0;
        for (byte b14 = 0; b14 < 8 && b11 != 0 && b12 != 0; b14 = (byte) (b14 + 1)) {
            if ((b12 & 1) != 0) {
                b13 = (byte) (b13 ^ b11);
            }
            byte b15 = (byte) (b11 & 128);
            b11 = (byte) (b11 << 1);
            if (b15 != 0) {
                b11 = (byte) (b11 ^ 195);
            }
            b12 = (byte) (b12 >> 1);
        }
        return b13;
    }

    private byte l(byte[] bArr) {
        byte b11 = bArr[15];
        for (int i11 = 14; i11 >= 0; i11--) {
            b11 = (byte) (b11 ^ this._gf_mul[unsignedByte(bArr[i11])][unsignedByte(this.lFactors[i11])]);
        }
        return b11;
    }

    private int unsignedByte(byte b11) {
        return b11 & 255;
    }

    public String getAlgorithmName() {
        return "GOST3412_2015";
    }

    public int getBlockSize() {
        return 16;
    }

    public void init(boolean z11, CipherParameters cipherParameters) throws IllegalArgumentException {
        if (cipherParameters instanceof KeyParameter) {
            this.forEncryption = z11;
            generateSubKeys(((KeyParameter) cipherParameters).getKey());
        } else if (cipherParameters != null) {
            throw new IllegalArgumentException("invalid parameter passed to GOST3412_2015 init - " + cipherParameters.getClass().getName());
        }
    }

    public int processBlock(byte[] bArr, int i11, byte[] bArr2, int i12) throws DataLengthException, IllegalStateException {
        if (this.subKeys == null) {
            throw new IllegalStateException("GOST3412_2015 engine not initialised");
        } else if (i11 + 16 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        } else if (i12 + 16 <= bArr2.length) {
            GOST3412_2015Func(bArr, i11, bArr2, i12);
            return 16;
        } else {
            throw new OutputLengthException("output buffer too short");
        }
    }

    public void reset() {
    }
}
