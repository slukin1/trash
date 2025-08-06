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
import org.bouncycastle.util.Integers;
import org.bouncycastle.util.Pack;
import org.jmrtd.lds.CVCAFile;

public final class TwofishEngine implements BlockCipher {
    private static final int BLOCK_SIZE = 16;
    private static final int GF256_FDBK = 361;
    private static final int GF256_FDBK_2 = 180;
    private static final int GF256_FDBK_4 = 90;
    private static final int INPUT_WHITEN = 0;
    private static final int MAX_KEY_BITS = 256;
    private static final int MAX_ROUNDS = 16;
    private static final int OUTPUT_WHITEN = 4;
    private static final byte[][] P = {new byte[]{-87, 103, ISO7816.INS_READ_RECORD2, -24, 4, -3, -93, 118, -102, -110, Byte.MIN_VALUE, Framer.EXIT_FRAME_PREFIX, ISO7816.INS_DELETE_FILE, -35, -47, 56, 13, -58, 53, -104, Ascii.CAN, -9, -20, 108, 67, 117, 55, 38, -6, 19, -108, 72, -14, ISO7816.INS_WRITE_BINARY, ISOFileInfo.SECURITY_ATTR_EXP, ISO7816.INS_DECREASE, -124, 84, -33, 35, Ascii.EM, 91, 61, 89, -13, -82, -94, -126, 99, 1, ISOFileInfo.FILE_IDENTIFIER, 46, -39, 81, -101, 124, -90, -21, ISOFileInfo.A5, -66, 22, 12, -29, 97, ISO7816.INS_GET_RESPONSE, ISOFileInfo.SECURITY_ATTR_COMPACT, 58, -11, 115, ISO7816.INS_UNBLOCK_CHV, 37, 11, -69, 78, -119, 107, 83, 106, ISO7816.INS_READ_BINARY_STAMPED, -15, -31, -26, -67, 69, ISO7816.INS_APPEND_RECORD, -12, ISO7816.INS_READ_RECORD_STAMPED, 102, -52, -107, 3, 86, -44, 28, 30, -41, -5, -61, ISOFileInfo.CHANNEL_SECURITY, -75, -23, -49, -65, -70, -22, 119, 57, -81, 51, -55, ISOFileInfo.FCP_BYTE, 113, ISOFileInfo.DATA_BYTES2, 121, 9, -83, ISO7816.INS_CHANGE_CHV, -51, -7, ISO7816.INS_LOAD_KEY_FILE, -27, -59, -71, 77, ISO7816.INS_REHABILITATE_CHV, 8, -122, -25, ISOFileInfo.A1, 29, -86, -19, 6, ISO7816.INS_MANAGE_CHANNEL, -78, ISO7816.INS_WRITE_RECORD, 65, 123, ISOFileInfo.A0, 17, Framer.STDOUT_FRAME_PREFIX, ISO7816.INS_ENVELOPE, 39, -112, 32, -10, 96, -1, -106, 92, ISO7816.INS_READ_BINARY2, ISOFileInfo.AB, -98, -100, 82, Ascii.ESC, 95, -109, 10, -17, -111, ISOFileInfo.PROP_INFO, 73, -18, Framer.STDIN_FRAME_PREFIX, 79, -113, 59, 71, ISOFileInfo.FCI_EXT, 109, 70, ISO7816.INS_UPDATE_BINARY, 62, 105, 100, ISO7816.INS_PSO, -50, -53, 47, -4, -105, 5, 122, -84, Ascii.DEL, -43, Ascii.SUB, 75, 14, -89, 90, 40, 20, Utf8.REPLACEMENT_BYTE, 41, -120, 60, 76, 2, -72, ISO7816.INS_PUT_DATA, ISO7816.INS_READ_BINARY, 23, 85, Ascii.US, ISOFileInfo.LCS_BYTE, 125, 87, -57, ISOFileInfo.ENV_TEMP_EF, 116, -73, -60, -97, 114, 126, 21, ISO7816.INS_MSE, 18, 88, 7, -103, ISO7816.INS_DECREASE_STAMPED, 110, 80, -34, 104, 101, PSSSigner.TRAILER_IMPLICIT, -37, -8, -56, -88, 43, SignedBytes.MAX_POWER_OF_TWO, ISO7816.INS_UPDATE_RECORD, -2, 50, -92, ISO7816.INS_GET_DATA, 16, Framer.ENTER_FRAME_PREFIX, -16, -45, 93, 15, 0, ISOFileInfo.FCI_BYTE, -99, 54, CVCAFile.CAR_TAG, 74, 94, -63, ISO7816.INS_CREATE_FILE}, new byte[]{117, -13, -58, -12, -37, 123, -5, -56, 74, -45, -26, 107, 69, 125, -24, 75, ISO7816.INS_UPDATE_BINARY, 50, ISO7816.INS_LOAD_KEY_FILE, -3, 55, 113, -15, -31, ISO7816.INS_DECREASE, 15, -8, Ascii.ESC, ISOFileInfo.FCI_EXT, -6, 6, Utf8.REPLACEMENT_BYTE, 94, -70, -82, 91, ISOFileInfo.LCS_BYTE, 0, PSSSigner.TRAILER_IMPLICIT, -99, 109, -63, ISO7816.INS_READ_BINARY2, 14, Byte.MIN_VALUE, 93, ISO7816.INS_WRITE_RECORD, -43, ISOFileInfo.A0, -124, 7, 20, -75, -112, ISO7816.INS_UNBLOCK_CHV, -93, -78, 115, 76, 84, -110, 116, 54, 81, 56, ISO7816.INS_READ_BINARY, -67, 90, -4, 96, ISOFileInfo.FCP_BYTE, -106, 108, CVCAFile.CAR_TAG, -9, 16, 124, 40, 39, ISOFileInfo.SECURITY_ATTR_COMPACT, 19, -107, -100, -57, ISO7816.INS_CHANGE_CHV, 70, 59, ISO7816.INS_MANAGE_CHANNEL, ISO7816.INS_GET_DATA, -29, ISOFileInfo.PROP_INFO, -53, 17, ISO7816.INS_WRITE_BINARY, -109, -72, -90, ISOFileInfo.FILE_IDENTIFIER, 32, -1, -97, 119, -61, -52, 3, ISOFileInfo.FCI_BYTE, 8, -65, SignedBytes.MAX_POWER_OF_TWO, -25, 43, ISO7816.INS_APPEND_RECORD, 121, 12, -86, -126, 65, 58, -22, -71, ISO7816.INS_DELETE_FILE, -102, -92, -105, 126, ISO7816.INS_PUT_DATA, 122, 23, 102, -108, ISOFileInfo.A1, 29, 61, -16, -34, ISO7816.INS_READ_RECORD2, 11, 114, -89, 28, -17, -47, 83, 62, -113, 51, 38, 95, -20, 118, ISO7816.INS_PSO, 73, ISOFileInfo.DATA_BYTES2, -120, -18, Framer.ENTER_FRAME_PREFIX, -60, Ascii.SUB, -21, -39, -59, 57, -103, -51, -83, Framer.STDOUT_FRAME_PREFIX, ISOFileInfo.SECURITY_ATTR_EXP, 1, Ascii.CAN, 35, -35, Ascii.US, 78, Framer.STDIN_FRAME_PREFIX, -7, 72, 79, -14, 101, ISOFileInfo.CHANNEL_SECURITY, Framer.EXIT_FRAME_PREFIX, 92, 88, Ascii.EM, ISOFileInfo.ENV_TEMP_EF, -27, -104, 87, 103, Ascii.DEL, 5, 100, -81, 99, ISO7816.INS_READ_RECORD_STAMPED, -2, -11, -73, 60, ISOFileInfo.A5, -50, -23, 104, ISO7816.INS_REHABILITATE_CHV, ISO7816.INS_CREATE_FILE, 77, 67, 105, 41, 46, -84, 21, 89, -88, 10, -98, 110, 71, -33, ISO7816.INS_DECREASE_STAMPED, 53, 106, -49, ISO7816.INS_UPDATE_RECORD, ISO7816.INS_MSE, -55, ISO7816.INS_GET_RESPONSE, -101, -119, -44, -19, ISOFileInfo.AB, 18, -94, 13, 82, -69, 2, 47, -87, -41, 97, 30, ISO7816.INS_READ_BINARY_STAMPED, 80, 4, -10, ISO7816.INS_ENVELOPE, 22, 37, -122, 86, 85, 9, -66, -111}};
    private static final int P_00 = 1;
    private static final int P_01 = 0;
    private static final int P_02 = 0;
    private static final int P_03 = 1;
    private static final int P_04 = 1;
    private static final int P_10 = 0;
    private static final int P_11 = 0;
    private static final int P_12 = 1;
    private static final int P_13 = 1;
    private static final int P_14 = 0;
    private static final int P_20 = 1;
    private static final int P_21 = 1;
    private static final int P_22 = 0;
    private static final int P_23 = 0;
    private static final int P_24 = 0;
    private static final int P_30 = 0;
    private static final int P_31 = 1;
    private static final int P_32 = 1;
    private static final int P_33 = 0;
    private static final int P_34 = 1;
    private static final int ROUNDS = 16;
    private static final int ROUND_SUBKEYS = 8;
    private static final int RS_GF_FDBK = 333;
    private static final int SK_BUMP = 16843009;
    private static final int SK_ROTL = 9;
    private static final int SK_STEP = 33686018;
    private static final int TOTAL_SUBKEYS = 40;
    private boolean encrypting = false;
    private int[] gMDS0 = new int[256];
    private int[] gMDS1 = new int[256];
    private int[] gMDS2 = new int[256];
    private int[] gMDS3 = new int[256];
    private int[] gSBox;
    private int[] gSubKeys;
    private int k64Cnt = 0;
    private byte[] workingKey = null;

    public TwofishEngine() {
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        int[] iArr3 = new int[2];
        for (int i11 = 0; i11 < 256; i11++) {
            byte[][] bArr = P;
            int i12 = bArr[0][i11] & 255;
            iArr[0] = i12;
            iArr2[0] = Mx_X(i12) & 255;
            iArr3[0] = Mx_Y(i12) & 255;
            int i13 = bArr[1][i11] & 255;
            iArr[1] = i13;
            iArr2[1] = Mx_X(i13) & 255;
            iArr3[1] = Mx_Y(i13) & 255;
            this.gMDS0[i11] = iArr[1] | (iArr2[1] << 8) | (iArr3[1] << 16) | (iArr3[1] << 24);
            this.gMDS1[i11] = iArr3[0] | (iArr3[0] << 8) | (iArr2[0] << 16) | (iArr[0] << 24);
            this.gMDS2[i11] = (iArr3[1] << 24) | iArr2[1] | (iArr3[1] << 8) | (iArr[1] << 16);
            this.gMDS3[i11] = iArr2[0] | (iArr[0] << 8) | (iArr3[0] << 16) | (iArr2[0] << 24);
        }
    }

    private int F32(int i11, int[] iArr) {
        int i12;
        int i13;
        int b02 = b0(i11);
        int b12 = b1(i11);
        int b22 = b2(i11);
        int b32 = b3(i11);
        int i14 = iArr[0];
        int i15 = iArr[1];
        int i16 = iArr[2];
        int i17 = iArr[3];
        int i18 = this.k64Cnt & 3;
        if (i18 == 0) {
            byte[][] bArr = P;
            b02 = (bArr[1][b02] & 255) ^ b0(i17);
            b12 = (bArr[0][b12] & 255) ^ b1(i17);
            b22 = (bArr[0][b22] & 255) ^ b2(i17);
            b32 = (bArr[1][b32] & 255) ^ b3(i17);
        } else if (i18 != 1) {
            if (i18 != 2) {
                if (i18 != 3) {
                    return 0;
                }
            }
            int[] iArr2 = this.gMDS0;
            byte[][] bArr2 = P;
            i12 = (iArr2[(bArr2[0][(bArr2[0][b02] & 255) ^ b0(i15)] & 255) ^ b0(i14)] ^ this.gMDS1[(bArr2[0][(bArr2[1][b12] & 255) ^ b1(i15)] & 255) ^ b1(i14)]) ^ this.gMDS2[(bArr2[1][(bArr2[0][b22] & 255) ^ b2(i15)] & 255) ^ b2(i14)];
            i13 = this.gMDS3[(bArr2[1][(bArr2[1][b32] & 255) ^ b3(i15)] & 255) ^ b3(i14)];
            return i12 ^ i13;
        } else {
            int[] iArr3 = this.gMDS0;
            byte[][] bArr3 = P;
            i12 = (iArr3[(bArr3[0][b02] & 255) ^ b0(i14)] ^ this.gMDS1[(bArr3[0][b12] & 255) ^ b1(i14)]) ^ this.gMDS2[(bArr3[1][b22] & 255) ^ b2(i14)];
            i13 = this.gMDS3[(bArr3[1][b32] & 255) ^ b3(i14)];
            return i12 ^ i13;
        }
        byte[][] bArr4 = P;
        b02 = (bArr4[1][b02] & 255) ^ b0(i16);
        b12 = (bArr4[1][b12] & 255) ^ b1(i16);
        b22 = (bArr4[0][b22] & 255) ^ b2(i16);
        b32 = (bArr4[0][b32] & 255) ^ b3(i16);
        int[] iArr22 = this.gMDS0;
        byte[][] bArr22 = P;
        i12 = (iArr22[(bArr22[0][(bArr22[0][b02] & 255) ^ b0(i15)] & 255) ^ b0(i14)] ^ this.gMDS1[(bArr22[0][(bArr22[1][b12] & 255) ^ b1(i15)] & 255) ^ b1(i14)]) ^ this.gMDS2[(bArr22[1][(bArr22[0][b22] & 255) ^ b2(i15)] & 255) ^ b2(i14)];
        i13 = this.gMDS3[(bArr22[1][(bArr22[1][b32] & 255) ^ b3(i15)] & 255) ^ b3(i14)];
        return i12 ^ i13;
    }

    private int Fe32_0(int i11) {
        int[] iArr = this.gSBox;
        return iArr[(((i11 >>> 24) & 255) * 2) + 513] ^ ((iArr[((i11 & 255) * 2) + 0] ^ iArr[(((i11 >>> 8) & 255) * 2) + 1]) ^ iArr[(((i11 >>> 16) & 255) * 2) + 512]);
    }

    private int Fe32_3(int i11) {
        int[] iArr = this.gSBox;
        return iArr[(((i11 >>> 16) & 255) * 2) + 513] ^ ((iArr[(((i11 >>> 24) & 255) * 2) + 0] ^ iArr[((i11 & 255) * 2) + 1]) ^ iArr[(((i11 >>> 8) & 255) * 2) + 512]);
    }

    private int LFSR1(int i11) {
        return ((i11 & 1) != 0 ? 180 : 0) ^ (i11 >> 1);
    }

    private int LFSR2(int i11) {
        int i12 = 0;
        int i13 = (i11 >> 2) ^ ((i11 & 2) != 0 ? 180 : 0);
        if ((i11 & 1) != 0) {
            i12 = 90;
        }
        return i13 ^ i12;
    }

    private int Mx_X(int i11) {
        return i11 ^ LFSR2(i11);
    }

    private int Mx_Y(int i11) {
        return LFSR2(i11) ^ (LFSR1(i11) ^ i11);
    }

    private int RS_MDS_Encode(int i11, int i12) {
        for (int i13 = 0; i13 < 4; i13++) {
            i12 = RS_rem(i12);
        }
        int i14 = i11 ^ i12;
        for (int i15 = 0; i15 < 4; i15++) {
            i14 = RS_rem(i14);
        }
        return i14;
    }

    private int RS_rem(int i11) {
        int i12 = (i11 >>> 24) & 255;
        int i13 = 0;
        int i14 = ((i12 << 1) ^ ((i12 & 128) != 0 ? RS_GF_FDBK : 0)) & 255;
        int i15 = i12 >>> 1;
        if ((i12 & 1) != 0) {
            i13 = 166;
        }
        int i16 = (i15 ^ i13) ^ i14;
        return ((((i11 << 8) ^ (i16 << 24)) ^ (i14 << 16)) ^ (i16 << 8)) ^ i12;
    }

    private int b0(int i11) {
        return i11 & 255;
    }

    private int b1(int i11) {
        return (i11 >>> 8) & 255;
    }

    private int b2(int i11) {
        return (i11 >>> 16) & 255;
    }

    private int b3(int i11) {
        return (i11 >>> 24) & 255;
    }

    private void decryptBlock(byte[] bArr, int i11, byte[] bArr2, int i12) {
        int littleEndianToInt = Pack.littleEndianToInt(bArr, i11) ^ this.gSubKeys[4];
        int littleEndianToInt2 = Pack.littleEndianToInt(bArr, i11 + 4) ^ this.gSubKeys[5];
        int littleEndianToInt3 = Pack.littleEndianToInt(bArr, i11 + 8) ^ this.gSubKeys[6];
        int littleEndianToInt4 = Pack.littleEndianToInt(bArr, i11 + 12) ^ this.gSubKeys[7];
        int i13 = 39;
        int i14 = 0;
        while (i14 < 16) {
            int Fe32_0 = Fe32_0(littleEndianToInt);
            int Fe32_3 = Fe32_3(littleEndianToInt2);
            int i15 = i13 - 1;
            int i16 = Fe32_0 + Fe32_3;
            int i17 = i15 - 1;
            littleEndianToInt3 = Integers.rotateLeft(littleEndianToInt3, 1) ^ (i16 + this.gSubKeys[i15]);
            littleEndianToInt4 = Integers.rotateRight(littleEndianToInt4 ^ (((Fe32_3 * 2) + Fe32_0) + this.gSubKeys[i13]), 1);
            int Fe32_02 = Fe32_0(littleEndianToInt3);
            int Fe32_32 = Fe32_3(littleEndianToInt4);
            int i18 = i17 - 1;
            littleEndianToInt = Integers.rotateLeft(littleEndianToInt, 1) ^ ((Fe32_02 + Fe32_32) + this.gSubKeys[i18]);
            littleEndianToInt2 = Integers.rotateRight(littleEndianToInt2 ^ (((Fe32_32 * 2) + Fe32_02) + this.gSubKeys[i17]), 1);
            i14 += 2;
            i13 = i18 - 1;
        }
        Pack.intToLittleEndian(this.gSubKeys[0] ^ littleEndianToInt3, bArr2, i12);
        Pack.intToLittleEndian(littleEndianToInt4 ^ this.gSubKeys[1], bArr2, i12 + 4);
        Pack.intToLittleEndian(this.gSubKeys[2] ^ littleEndianToInt, bArr2, i12 + 8);
        Pack.intToLittleEndian(this.gSubKeys[3] ^ littleEndianToInt2, bArr2, i12 + 12);
    }

    private void encryptBlock(byte[] bArr, int i11, byte[] bArr2, int i12) {
        int i13 = 0;
        int littleEndianToInt = Pack.littleEndianToInt(bArr, i11) ^ this.gSubKeys[0];
        int littleEndianToInt2 = Pack.littleEndianToInt(bArr, i11 + 4) ^ this.gSubKeys[1];
        int littleEndianToInt3 = Pack.littleEndianToInt(bArr, i11 + 8) ^ this.gSubKeys[2];
        int littleEndianToInt4 = Pack.littleEndianToInt(bArr, i11 + 12) ^ this.gSubKeys[3];
        int i14 = 8;
        while (i13 < 16) {
            int Fe32_0 = Fe32_0(littleEndianToInt);
            int Fe32_3 = Fe32_3(littleEndianToInt2);
            int i15 = i14 + 1;
            littleEndianToInt3 = Integers.rotateRight(littleEndianToInt3 ^ ((Fe32_0 + Fe32_3) + this.gSubKeys[i14]), 1);
            int i16 = Fe32_0 + (Fe32_3 * 2);
            int i17 = i15 + 1;
            littleEndianToInt4 = Integers.rotateLeft(littleEndianToInt4, 1) ^ (i16 + this.gSubKeys[i15]);
            int Fe32_02 = Fe32_0(littleEndianToInt3);
            int Fe32_32 = Fe32_3(littleEndianToInt4);
            int i18 = i17 + 1;
            littleEndianToInt = Integers.rotateRight(littleEndianToInt ^ ((Fe32_02 + Fe32_32) + this.gSubKeys[i17]), 1);
            littleEndianToInt2 = Integers.rotateLeft(littleEndianToInt2, 1) ^ ((Fe32_02 + (Fe32_32 * 2)) + this.gSubKeys[i18]);
            i13 += 2;
            i14 = i18 + 1;
        }
        Pack.intToLittleEndian(this.gSubKeys[4] ^ littleEndianToInt3, bArr2, i12);
        Pack.intToLittleEndian(littleEndianToInt4 ^ this.gSubKeys[5], bArr2, i12 + 4);
        Pack.intToLittleEndian(this.gSubKeys[6] ^ littleEndianToInt, bArr2, i12 + 8);
        Pack.intToLittleEndian(this.gSubKeys[7] ^ littleEndianToInt2, bArr2, i12 + 12);
    }

    private void setKey(byte[] bArr) {
        byte b11;
        byte b12;
        byte b13;
        byte b14;
        byte b15;
        byte b16;
        byte b17;
        byte b18;
        byte[] bArr2 = bArr;
        int[] iArr = new int[4];
        int[] iArr2 = new int[4];
        int[] iArr3 = new int[4];
        this.gSubKeys = new int[40];
        for (int i11 = 0; i11 < this.k64Cnt; i11++) {
            int i12 = i11 * 8;
            iArr[i11] = Pack.littleEndianToInt(bArr2, i12);
            iArr2[i11] = Pack.littleEndianToInt(bArr2, i12 + 4);
            iArr3[(this.k64Cnt - 1) - i11] = RS_MDS_Encode(iArr[i11], iArr2[i11]);
        }
        for (int i13 = 0; i13 < 20; i13++) {
            int i14 = SK_STEP * i13;
            int F32 = F32(i14, iArr);
            int rotateLeft = Integers.rotateLeft(F32(i14 + 16843009, iArr2), 8);
            int i15 = F32 + rotateLeft;
            int[] iArr4 = this.gSubKeys;
            int i16 = i13 * 2;
            iArr4[i16] = i15;
            int i17 = i15 + rotateLeft;
            iArr4[i16 + 1] = (i17 << 9) | (i17 >>> 23);
        }
        int i18 = iArr3[0];
        int i19 = iArr3[1];
        int i21 = 2;
        int i22 = iArr3[2];
        int i23 = iArr3[3];
        this.gSBox = new int[1024];
        int i24 = 0;
        while (i24 < 256) {
            int i25 = this.k64Cnt & 3;
            if (i25 != 0) {
                if (i25 == 1) {
                    int[] iArr5 = this.gSBox;
                    int i26 = i24 * 2;
                    int[] iArr6 = this.gMDS0;
                    byte[][] bArr3 = P;
                    iArr5[i26] = iArr6[(bArr3[0][i24] & 255) ^ b0(i18)];
                    this.gSBox[i26 + 1] = this.gMDS1[(bArr3[0][i24] & 255) ^ b1(i18)];
                    this.gSBox[i26 + 512] = this.gMDS2[(bArr3[1][i24] & 255) ^ b2(i18)];
                    this.gSBox[i26 + 513] = this.gMDS3[(bArr3[1][i24] & 255) ^ b3(i18)];
                } else if (i25 == i21) {
                    b14 = i24;
                    b13 = b14;
                    b12 = b13;
                    b11 = b12;
                    int[] iArr7 = this.gSBox;
                    int i27 = i24 * 2;
                    int[] iArr8 = this.gMDS0;
                    byte[][] bArr4 = P;
                    iArr7[i27] = iArr8[(bArr4[0][(bArr4[0][b13] & 255) ^ b0(i19)] & 255) ^ b0(i18)];
                    this.gSBox[i27 + 1] = this.gMDS1[(bArr4[0][(bArr4[1][b12] & 255) ^ b1(i19)] & 255) ^ b1(i18)];
                    this.gSBox[i27 + 512] = this.gMDS2[(bArr4[1][(bArr4[0][b11] & 255) ^ b2(i19)] & 255) ^ b2(i18)];
                    this.gSBox[i27 + 513] = this.gMDS3[(bArr4[1][(bArr4[1][b14] & 255) ^ b3(i19)] & 255) ^ b3(i18)];
                } else if (i25 == 3) {
                    b18 = i24;
                    b17 = b18;
                    b16 = b17;
                    b15 = b16;
                }
                i24++;
                i21 = 2;
            } else {
                byte[][] bArr5 = P;
                b17 = (bArr5[1][i24] & 255) ^ b0(i23);
                b16 = (bArr5[0][i24] & 255) ^ b1(i23);
                b15 = (bArr5[0][i24] & 255) ^ b2(i23);
                b18 = (bArr5[1][i24] & 255) ^ b3(i23);
            }
            byte[][] bArr6 = P;
            b13 = (bArr6[1][b17] & 255) ^ b0(i22);
            b12 = (bArr6[1][b16] & 255) ^ b1(i22);
            b11 = (bArr6[0][b15] & 255) ^ b2(i22);
            b14 = (bArr6[0][b18] & 255) ^ b3(i22);
            int[] iArr72 = this.gSBox;
            int i272 = i24 * 2;
            int[] iArr82 = this.gMDS0;
            byte[][] bArr42 = P;
            iArr72[i272] = iArr82[(bArr42[0][(bArr42[0][b13] & 255) ^ b0(i19)] & 255) ^ b0(i18)];
            this.gSBox[i272 + 1] = this.gMDS1[(bArr42[0][(bArr42[1][b12] & 255) ^ b1(i19)] & 255) ^ b1(i18)];
            this.gSBox[i272 + 512] = this.gMDS2[(bArr42[1][(bArr42[0][b11] & 255) ^ b2(i19)] & 255) ^ b2(i18)];
            this.gSBox[i272 + 513] = this.gMDS3[(bArr42[1][(bArr42[1][b14] & 255) ^ b3(i19)] & 255) ^ b3(i18)];
            i24++;
            i21 = 2;
        }
    }

    public String getAlgorithmName() {
        return "Twofish";
    }

    public int getBlockSize() {
        return 16;
    }

    public void init(boolean z11, CipherParameters cipherParameters) {
        if (cipherParameters instanceof KeyParameter) {
            this.encrypting = z11;
            byte[] key = ((KeyParameter) cipherParameters).getKey();
            this.workingKey = key;
            int length = key.length * 8;
            if (length == 128 || length == 192 || length == 256) {
                this.k64Cnt = key.length / 8;
                setKey(key);
                return;
            }
            throw new IllegalArgumentException("Key length not 128/192/256 bits.");
        }
        throw new IllegalArgumentException("invalid parameter passed to Twofish init - " + cipherParameters.getClass().getName());
    }

    public int processBlock(byte[] bArr, int i11, byte[] bArr2, int i12) {
        if (this.workingKey == null) {
            throw new IllegalStateException("Twofish not initialised");
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
        byte[] bArr = this.workingKey;
        if (bArr != null) {
            setKey(bArr);
        }
    }
}
