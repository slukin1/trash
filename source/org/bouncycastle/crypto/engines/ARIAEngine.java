package org.bouncycastle.crypto.engines;

import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import java.lang.reflect.Array;
import net.sf.scuba.smartcards.ISO7816;
import net.sf.scuba.smartcards.ISOFileInfo;
import okio.Utf8;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.signers.PSSSigner;
import org.bouncycastle.util.encoders.Hex;
import org.jmrtd.lds.CVCAFile;

public class ARIAEngine implements BlockCipher {
    public static final int BLOCK_SIZE = 16;
    private static final byte[][] C = {Hex.decodeStrict("517cc1b727220a94fe13abe8fa9a6ee0"), Hex.decodeStrict("6db14acc9e21c820ff28b1d5ef5de2b0"), Hex.decodeStrict("db92371d2126e9700324977504e8c90e")};
    private static final byte[] SB1_sbox = {99, 124, 119, 123, -14, 107, ISOFileInfo.FCI_BYTE, -59, ISO7816.INS_DECREASE, 1, 103, 43, -2, -41, ISOFileInfo.AB, 118, ISO7816.INS_GET_DATA, -126, -55, 125, -6, 89, 71, -16, -83, -44, -94, -81, -100, -92, 114, ISO7816.INS_GET_RESPONSE, -73, -3, -109, 38, 54, Utf8.REPLACEMENT_BYTE, -9, -52, ISO7816.INS_DECREASE_STAMPED, ISOFileInfo.A5, -27, -15, 113, ISO7816.INS_LOAD_KEY_FILE, Framer.STDOUT_FRAME_PREFIX, 21, 4, -57, 35, -61, Ascii.CAN, -106, 5, -102, 7, 18, Byte.MIN_VALUE, ISO7816.INS_APPEND_RECORD, -21, 39, -78, 117, 9, ISOFileInfo.FILE_IDENTIFIER, ISO7816.INS_UNBLOCK_CHV, Ascii.SUB, Ascii.ESC, 110, 90, ISOFileInfo.A0, 82, 59, ISO7816.INS_UPDATE_BINARY, ISO7816.INS_READ_RECORD2, 41, -29, 47, -124, 83, -47, 0, -19, 32, -4, ISO7816.INS_READ_BINARY2, 91, 106, -53, -66, 57, 74, 76, 88, -49, ISO7816.INS_WRITE_BINARY, -17, -86, -5, 67, 77, 51, ISOFileInfo.PROP_INFO, 69, -7, 2, Ascii.DEL, 80, 60, -97, -88, 81, -93, SignedBytes.MAX_POWER_OF_TWO, -113, -110, -99, 56, -11, PSSSigner.TRAILER_IMPLICIT, ISO7816.INS_READ_RECORD_STAMPED, ISO7816.INS_PUT_DATA, Framer.ENTER_FRAME_PREFIX, 16, -1, -13, ISO7816.INS_WRITE_RECORD, -51, 12, 19, -20, 95, -105, ISO7816.INS_REHABILITATE_CHV, 23, -60, -89, 126, 61, 100, 93, Ascii.EM, 115, 96, ISOFileInfo.DATA_BYTES2, 79, ISO7816.INS_UPDATE_RECORD, ISO7816.INS_MSE, ISO7816.INS_PSO, -112, -120, 70, -18, -72, 20, -34, 94, 11, -37, ISO7816.INS_CREATE_FILE, 50, 58, 10, 73, 6, ISO7816.INS_CHANGE_CHV, 92, ISO7816.INS_ENVELOPE, -45, -84, ISOFileInfo.FCP_BYTE, -111, -107, ISO7816.INS_DELETE_FILE, 121, -25, -56, 55, 109, ISOFileInfo.ENV_TEMP_EF, -43, 78, -87, 108, 86, -12, -22, 101, 122, -82, 8, -70, Framer.EXIT_FRAME_PREFIX, 37, 46, 28, -90, ISO7816.INS_READ_BINARY_STAMPED, -58, -24, -35, 116, Ascii.US, 75, -67, ISOFileInfo.SECURITY_ATTR_EXP, ISOFileInfo.LCS_BYTE, ISO7816.INS_MANAGE_CHANNEL, 62, -75, 102, 72, 3, -10, 14, 97, 53, 87, -71, -122, -63, 29, -98, -31, -8, -104, 17, 105, -39, ISOFileInfo.CHANNEL_SECURITY, -108, -101, 30, ISOFileInfo.FCI_EXT, -23, -50, 85, 40, -33, ISOFileInfo.SECURITY_ATTR_COMPACT, ISOFileInfo.A1, -119, 13, -65, -26, CVCAFile.CAR_TAG, 104, 65, -103, Framer.STDIN_FRAME_PREFIX, 15, ISO7816.INS_READ_BINARY, 84, -69, 22};
    private static final byte[] SB2_sbox = {ISO7816.INS_APPEND_RECORD, 78, 84, -4, -108, ISO7816.INS_ENVELOPE, 74, -52, ISOFileInfo.FCP_BYTE, 13, 106, 70, 60, 77, ISOFileInfo.SECURITY_ATTR_EXP, -47, 94, -6, 100, -53, ISO7816.INS_READ_BINARY_STAMPED, -105, -66, 43, PSSSigner.TRAILER_IMPLICIT, 119, 46, 3, -45, Ascii.EM, 89, -63, 29, 6, 65, 107, 85, -16, -103, 105, -22, -100, Ascii.CAN, -82, 99, -33, -25, -69, 0, 115, 102, -5, -106, 76, ISOFileInfo.PROP_INFO, ISO7816.INS_DELETE_FILE, 58, 9, 69, -86, 15, -18, 16, -21, Framer.STDIN_FRAME_PREFIX, Ascii.DEL, -12, 41, -84, -49, -83, -111, ISOFileInfo.ENV_TEMP_EF, Framer.EXIT_FRAME_PREFIX, -56, -107, -7, 47, -50, -51, 8, 122, -120, 56, 92, ISOFileInfo.FILE_IDENTIFIER, ISO7816.INS_PSO, 40, 71, -37, -72, -57, -109, -92, 18, 83, -1, ISOFileInfo.FCI_EXT, 14, Framer.STDOUT_FRAME_PREFIX, 54, Framer.ENTER_FRAME_PREFIX, 88, 72, 1, ISOFileInfo.CHANNEL_SECURITY, 55, 116, 50, ISO7816.INS_GET_DATA, -23, ISO7816.INS_READ_BINARY2, -73, ISOFileInfo.AB, 12, -41, -60, 86, CVCAFile.CAR_TAG, 38, 7, -104, 96, -39, ISO7816.INS_READ_RECORD_STAMPED, -71, 17, SignedBytes.MAX_POWER_OF_TWO, -20, 32, ISOFileInfo.SECURITY_ATTR_COMPACT, -67, ISOFileInfo.A0, -55, -124, 4, 73, 35, -15, 79, 80, Ascii.US, 19, ISO7816.INS_UPDATE_RECORD, ISO7816.INS_LOAD_KEY_FILE, ISO7816.INS_GET_RESPONSE, -98, 87, -29, -61, 123, 101, 59, 2, -113, 62, -24, 37, -110, -27, 21, -35, -3, 23, -87, -65, -44, -102, 126, -59, 57, 103, -2, 118, -99, 67, -89, -31, ISO7816.INS_WRITE_BINARY, -11, 104, -14, Ascii.ESC, ISO7816.INS_DECREASE_STAMPED, ISO7816.INS_MANAGE_CHANNEL, 5, -93, ISOFileInfo.LCS_BYTE, -43, 121, -122, -88, ISO7816.INS_DECREASE, -58, 81, 75, 30, -90, 39, -10, 53, ISO7816.INS_WRITE_RECORD, 110, ISO7816.INS_CHANGE_CHV, 22, -126, 95, ISO7816.INS_PUT_DATA, -26, 117, -94, -17, ISO7816.INS_UNBLOCK_CHV, -78, 28, -97, 93, ISOFileInfo.FCI_BYTE, Byte.MIN_VALUE, 10, 114, ISO7816.INS_REHABILITATE_CHV, -101, 108, -112, 11, 91, 51, 125, 90, 82, -13, 97, ISOFileInfo.A1, -9, ISO7816.INS_READ_BINARY, ISO7816.INS_UPDATE_BINARY, Utf8.REPLACEMENT_BYTE, 124, 109, -19, 20, ISO7816.INS_CREATE_FILE, ISOFileInfo.A5, 61, ISO7816.INS_MSE, ISO7816.INS_READ_RECORD2, -8, -119, -34, 113, Ascii.SUB, -81, -70, -75, ISOFileInfo.DATA_BYTES2};
    private static final byte[] SB3_sbox = {82, 9, 106, -43, ISO7816.INS_DECREASE, 54, ISOFileInfo.A5, 56, -65, SignedBytes.MAX_POWER_OF_TWO, -93, -98, ISOFileInfo.DATA_BYTES2, -13, -41, -5, 124, -29, 57, -126, -101, 47, -1, ISOFileInfo.FCI_EXT, ISO7816.INS_DECREASE_STAMPED, ISOFileInfo.CHANNEL_SECURITY, 67, ISO7816.INS_REHABILITATE_CHV, -60, -34, -23, -53, 84, 123, -108, 50, -90, ISO7816.INS_ENVELOPE, 35, 61, -18, 76, -107, 11, CVCAFile.CAR_TAG, -6, -61, 78, 8, 46, ISOFileInfo.A1, 102, 40, -39, ISO7816.INS_CHANGE_CHV, -78, 118, 91, -94, 73, 109, ISOFileInfo.SECURITY_ATTR_EXP, -47, 37, 114, -8, -10, 100, -122, 104, -104, 22, -44, -92, 92, -52, 93, 101, ISO7816.INS_READ_RECORD_STAMPED, -110, 108, ISO7816.INS_MANAGE_CHANNEL, 72, 80, -3, -19, -71, ISO7816.INS_PUT_DATA, 94, 21, 70, 87, -89, ISOFileInfo.ENV_TEMP_EF, -99, -124, -112, ISO7816.INS_LOAD_KEY_FILE, ISOFileInfo.AB, 0, ISOFileInfo.SECURITY_ATTR_COMPACT, PSSSigner.TRAILER_IMPLICIT, -45, 10, -9, ISO7816.INS_DELETE_FILE, 88, 5, -72, ISO7816.INS_READ_RECORD2, 69, 6, ISO7816.INS_WRITE_BINARY, ISO7816.INS_UNBLOCK_CHV, 30, -113, ISO7816.INS_GET_DATA, Utf8.REPLACEMENT_BYTE, 15, 2, -63, -81, -67, 3, 1, 19, ISOFileInfo.LCS_BYTE, 107, 58, -111, 17, 65, 79, 103, ISO7816.INS_UPDATE_RECORD, -22, -105, -14, -49, -50, -16, ISO7816.INS_READ_BINARY_STAMPED, -26, 115, -106, -84, 116, ISO7816.INS_MSE, -25, -83, 53, ISOFileInfo.PROP_INFO, ISO7816.INS_APPEND_RECORD, -7, 55, -24, 28, 117, -33, 110, 71, -15, Ascii.SUB, 113, 29, 41, -59, -119, ISOFileInfo.FCI_BYTE, -73, ISOFileInfo.FCP_BYTE, 14, -86, Ascii.CAN, -66, Ascii.ESC, -4, 86, 62, 75, -58, ISO7816.INS_WRITE_RECORD, 121, 32, -102, -37, ISO7816.INS_GET_RESPONSE, -2, Framer.EXIT_FRAME_PREFIX, -51, 90, -12, Ascii.US, -35, -88, 51, -120, 7, -57, Framer.STDOUT_FRAME_PREFIX, ISO7816.INS_READ_BINARY2, 18, 16, 89, 39, Byte.MIN_VALUE, -20, 95, 96, 81, Ascii.DEL, -87, Ascii.EM, -75, 74, 13, Framer.STDIN_FRAME_PREFIX, -27, 122, -97, -109, -55, -100, -17, ISOFileInfo.A0, ISO7816.INS_CREATE_FILE, 59, 77, -82, ISO7816.INS_PSO, -11, ISO7816.INS_READ_BINARY, -56, -21, -69, 60, ISOFileInfo.FILE_IDENTIFIER, 83, -103, 97, 23, 43, 4, 126, -70, 119, ISO7816.INS_UPDATE_BINARY, 38, -31, 105, 20, 99, 85, Framer.ENTER_FRAME_PREFIX, 12, 125};
    private static final byte[] SB4_sbox = {ISO7816.INS_DECREASE, 104, -103, Ascii.ESC, ISOFileInfo.FCI_EXT, -71, Framer.ENTER_FRAME_PREFIX, Framer.EXIT_FRAME_PREFIX, 80, 57, -37, -31, 114, 9, ISOFileInfo.FCP_BYTE, 60, 62, 126, 94, ISOFileInfo.CHANNEL_SECURITY, -15, ISOFileInfo.A0, -52, -93, ISO7816.INS_PSO, 29, -5, ISO7816.INS_READ_RECORD_STAMPED, ISO7816.INS_UPDATE_BINARY, 32, -60, ISOFileInfo.ENV_TEMP_EF, ISOFileInfo.DATA_BYTES2, 101, -11, -119, -53, -99, 119, -58, 87, 67, 86, 23, -44, SignedBytes.MAX_POWER_OF_TWO, Ascii.SUB, 77, ISO7816.INS_GET_RESPONSE, 99, 108, -29, -73, -56, 100, 106, 83, -86, 56, -104, 12, -12, -101, -19, Ascii.DEL, ISO7816.INS_MSE, 118, -81, -35, 58, 11, 88, 103, -120, 6, -61, 53, 13, 1, ISOFileInfo.SECURITY_ATTR_EXP, ISOFileInfo.SECURITY_ATTR_COMPACT, ISO7816.INS_ENVELOPE, -26, 95, 2, ISO7816.INS_CHANGE_CHV, 117, -109, 102, 30, -27, ISO7816.INS_APPEND_RECORD, 84, ISO7816.INS_LOAD_KEY_FILE, 16, -50, 122, -24, 8, ISO7816.INS_UNBLOCK_CHV, 18, -105, 50, ISOFileInfo.AB, ISO7816.INS_READ_BINARY_STAMPED, 39, 10, 35, -33, -17, ISO7816.INS_GET_DATA, -39, -72, -6, ISO7816.INS_UPDATE_RECORD, Framer.STDOUT_FRAME_PREFIX, 107, -47, -83, Ascii.EM, 73, -67, 81, -106, -18, ISO7816.INS_DELETE_FILE, -88, 65, ISO7816.INS_PUT_DATA, -1, -51, 85, -122, 54, -66, 97, 82, -8, -69, 14, -126, 72, 105, -102, ISO7816.INS_CREATE_FILE, 71, -98, 92, 4, 75, ISO7816.INS_DECREASE_STAMPED, 21, 121, 38, -89, -34, 41, -82, -110, -41, -124, -23, ISO7816.INS_WRITE_RECORD, -70, 93, -13, -59, ISO7816.INS_READ_BINARY, -65, -92, 59, 113, ISO7816.INS_REHABILITATE_CHV, 70, 43, -4, -21, ISOFileInfo.FCI_BYTE, -43, -10, 20, -2, 124, ISO7816.INS_MANAGE_CHANNEL, 90, 125, -3, 47, Ascii.CAN, ISOFileInfo.FILE_IDENTIFIER, 22, ISOFileInfo.A5, -111, Ascii.US, 5, -107, 116, -87, -63, 91, 74, ISOFileInfo.PROP_INFO, 109, 19, 7, 79, 78, 69, -78, 15, -55, 28, -90, PSSSigner.TRAILER_IMPLICIT, -20, 115, -112, 123, -49, 89, -113, ISOFileInfo.A1, -7, Framer.STDIN_FRAME_PREFIX, -14, ISO7816.INS_READ_BINARY2, 0, -108, 55, -97, ISO7816.INS_WRITE_BINARY, 46, -100, 110, 40, Utf8.REPLACEMENT_BYTE, Byte.MIN_VALUE, -16, 61, -45, 37, ISOFileInfo.LCS_BYTE, -75, -25, CVCAFile.CAR_TAG, ISO7816.INS_READ_RECORD2, -57, -22, -9, 76, 17, 51, 3, -94, -84, 96};
    private byte[][] roundKeys;

    public static void A(byte[] bArr) {
        byte b11 = bArr[0];
        byte b12 = bArr[1];
        byte b13 = bArr[2];
        byte b14 = bArr[3];
        byte b15 = bArr[4];
        byte b16 = bArr[5];
        byte b17 = bArr[6];
        byte b18 = bArr[7];
        byte b19 = bArr[8];
        byte b21 = bArr[9];
        byte b22 = bArr[10];
        byte b23 = bArr[11];
        byte b24 = bArr[12];
        byte b25 = bArr[13];
        byte b26 = bArr[14];
        byte b27 = bArr[15];
        bArr[0] = (byte) ((((((b14 ^ b15) ^ b17) ^ b19) ^ b21) ^ b25) ^ b26);
        bArr[1] = (byte) ((((((b13 ^ b16) ^ b18) ^ b19) ^ b21) ^ b24) ^ b27);
        bArr[2] = (byte) ((((((b12 ^ b15) ^ b17) ^ b22) ^ b23) ^ b24) ^ b27);
        bArr[3] = (byte) ((((((b11 ^ b16) ^ b18) ^ b22) ^ b23) ^ b25) ^ b26);
        byte b28 = b11 ^ b13;
        bArr[4] = (byte) (((((b28 ^ b16) ^ b19) ^ b23) ^ b26) ^ b27);
        byte b29 = b12 ^ b14;
        bArr[5] = (byte) (((((b29 ^ b15) ^ b21) ^ b22) ^ b26) ^ b27);
        bArr[6] = (byte) (((((b28 ^ b18) ^ b21) ^ b22) ^ b24) ^ b25);
        bArr[7] = (byte) (((((b29 ^ b17) ^ b19) ^ b23) ^ b24) ^ b25);
        byte b31 = b11 ^ b12;
        bArr[8] = (byte) (((((b31 ^ b15) ^ b18) ^ b22) ^ b25) ^ b27);
        bArr[9] = (byte) (((((b31 ^ b16) ^ b17) ^ b23) ^ b24) ^ b26);
        byte b32 = b13 ^ b14;
        bArr[10] = (byte) (((((b32 ^ b16) ^ b17) ^ b19) ^ b25) ^ b27);
        bArr[11] = (byte) (((((b32 ^ b15) ^ b18) ^ b21) ^ b24) ^ b26);
        byte b33 = b12 ^ b13;
        bArr[12] = (byte) (((((b33 ^ b17) ^ b18) ^ b21) ^ b23) ^ b24);
        byte b34 = b11 ^ b14;
        bArr[13] = (byte) (((((b34 ^ b17) ^ b18) ^ b19) ^ b22) ^ b25);
        bArr[14] = (byte) (((((b34 ^ b15) ^ b16) ^ b21) ^ b23) ^ b26);
        bArr[15] = (byte) (((((b33 ^ b15) ^ b16) ^ b19) ^ b22) ^ b27);
    }

    public static void FE(byte[] bArr, byte[] bArr2) {
        xor(bArr, bArr2);
        SL2(bArr);
        A(bArr);
    }

    public static void FO(byte[] bArr, byte[] bArr2) {
        xor(bArr, bArr2);
        SL1(bArr);
        A(bArr);
    }

    public static byte SB1(byte b11) {
        return SB1_sbox[b11 & 255];
    }

    public static byte SB2(byte b11) {
        return SB2_sbox[b11 & 255];
    }

    public static byte SB3(byte b11) {
        return SB3_sbox[b11 & 255];
    }

    public static byte SB4(byte b11) {
        return SB4_sbox[b11 & 255];
    }

    public static void SL1(byte[] bArr) {
        bArr[0] = SB1(bArr[0]);
        bArr[1] = SB2(bArr[1]);
        bArr[2] = SB3(bArr[2]);
        bArr[3] = SB4(bArr[3]);
        bArr[4] = SB1(bArr[4]);
        bArr[5] = SB2(bArr[5]);
        bArr[6] = SB3(bArr[6]);
        bArr[7] = SB4(bArr[7]);
        bArr[8] = SB1(bArr[8]);
        bArr[9] = SB2(bArr[9]);
        bArr[10] = SB3(bArr[10]);
        bArr[11] = SB4(bArr[11]);
        bArr[12] = SB1(bArr[12]);
        bArr[13] = SB2(bArr[13]);
        bArr[14] = SB3(bArr[14]);
        bArr[15] = SB4(bArr[15]);
    }

    public static void SL2(byte[] bArr) {
        bArr[0] = SB3(bArr[0]);
        bArr[1] = SB4(bArr[1]);
        bArr[2] = SB1(bArr[2]);
        bArr[3] = SB2(bArr[3]);
        bArr[4] = SB3(bArr[4]);
        bArr[5] = SB4(bArr[5]);
        bArr[6] = SB1(bArr[6]);
        bArr[7] = SB2(bArr[7]);
        bArr[8] = SB3(bArr[8]);
        bArr[9] = SB4(bArr[9]);
        bArr[10] = SB1(bArr[10]);
        bArr[11] = SB2(bArr[11]);
        bArr[12] = SB3(bArr[12]);
        bArr[13] = SB4(bArr[13]);
        bArr[14] = SB1(bArr[14]);
        bArr[15] = SB2(bArr[15]);
    }

    public static byte[][] keySchedule(boolean z11, byte[] bArr) {
        int length = bArr.length;
        if (length < 16 || length > 32 || (length & 7) != 0) {
            throw new IllegalArgumentException("Key length not 128/192/256 bits.");
        }
        int i11 = (length >>> 3) - 2;
        byte[][] bArr2 = C;
        byte[] bArr3 = bArr2[i11];
        byte[] bArr4 = bArr2[(i11 + 1) % 3];
        byte[] bArr5 = bArr2[(i11 + 2) % 3];
        byte[] bArr6 = new byte[16];
        byte[] bArr7 = new byte[16];
        System.arraycopy(bArr, 0, bArr6, 0, 16);
        System.arraycopy(bArr, 16, bArr7, 0, length - 16);
        byte[] bArr8 = new byte[16];
        byte[] bArr9 = new byte[16];
        byte[] bArr10 = new byte[16];
        byte[] bArr11 = new byte[16];
        System.arraycopy(bArr6, 0, bArr8, 0, 16);
        System.arraycopy(bArr8, 0, bArr9, 0, 16);
        FO(bArr9, bArr3);
        xor(bArr9, bArr7);
        System.arraycopy(bArr9, 0, bArr10, 0, 16);
        FE(bArr10, bArr4);
        xor(bArr10, bArr8);
        System.arraycopy(bArr10, 0, bArr11, 0, 16);
        FO(bArr11, bArr5);
        xor(bArr11, bArr9);
        int i12 = (i11 * 2) + 12;
        int[] iArr = new int[2];
        iArr[1] = 16;
        iArr[0] = i12 + 1;
        byte[][] bArr12 = (byte[][]) Array.newInstance(byte.class, iArr);
        keyScheduleRound(bArr12[0], bArr8, bArr9, 19);
        keyScheduleRound(bArr12[1], bArr9, bArr10, 19);
        keyScheduleRound(bArr12[2], bArr10, bArr11, 19);
        keyScheduleRound(bArr12[3], bArr11, bArr8, 19);
        keyScheduleRound(bArr12[4], bArr8, bArr9, 31);
        keyScheduleRound(bArr12[5], bArr9, bArr10, 31);
        keyScheduleRound(bArr12[6], bArr10, bArr11, 31);
        keyScheduleRound(bArr12[7], bArr11, bArr8, 31);
        keyScheduleRound(bArr12[8], bArr8, bArr9, 67);
        keyScheduleRound(bArr12[9], bArr9, bArr10, 67);
        keyScheduleRound(bArr12[10], bArr10, bArr11, 67);
        keyScheduleRound(bArr12[11], bArr11, bArr8, 67);
        keyScheduleRound(bArr12[12], bArr8, bArr9, 97);
        if (i12 > 12) {
            keyScheduleRound(bArr12[13], bArr9, bArr10, 97);
            keyScheduleRound(bArr12[14], bArr10, bArr11, 97);
            if (i12 > 14) {
                keyScheduleRound(bArr12[15], bArr11, bArr8, 97);
                keyScheduleRound(bArr12[16], bArr8, bArr9, 109);
            }
        }
        if (!z11) {
            reverseKeys(bArr12);
            for (int i13 = 1; i13 < i12; i13++) {
                A(bArr12[i13]);
            }
        }
        return bArr12;
    }

    public static void keyScheduleRound(byte[] bArr, byte[] bArr2, byte[] bArr3, int i11) {
        int i12 = i11 >>> 3;
        byte b11 = i11 & 7;
        int i13 = 8 - b11;
        byte b12 = bArr3[15 - i12] & 255;
        int i14 = 0;
        while (i14 < 16) {
            byte b13 = bArr3[(i14 - i12) & 15] & 255;
            bArr[i14] = (byte) (((b12 << i13) | (b13 >>> b11)) ^ (bArr2[i14] & 255));
            i14++;
            b12 = b13;
        }
    }

    public static void reverseKeys(byte[][] bArr) {
        int length = bArr.length;
        int i11 = length / 2;
        int i12 = length - 1;
        for (int i13 = 0; i13 < i11; i13++) {
            byte[] bArr2 = bArr[i13];
            int i14 = i12 - i13;
            bArr[i13] = bArr[i14];
            bArr[i14] = bArr2;
        }
    }

    public static void xor(byte[] bArr, byte[] bArr2) {
        for (int i11 = 0; i11 < 16; i11++) {
            bArr[i11] = (byte) (bArr[i11] ^ bArr2[i11]);
        }
    }

    public String getAlgorithmName() {
        return "ARIA";
    }

    public int getBlockSize() {
        return 16;
    }

    public void init(boolean z11, CipherParameters cipherParameters) throws IllegalArgumentException {
        if (cipherParameters instanceof KeyParameter) {
            this.roundKeys = keySchedule(z11, ((KeyParameter) cipherParameters).getKey());
            return;
        }
        throw new IllegalArgumentException("invalid parameter passed to ARIA init - " + cipherParameters.getClass().getName());
    }

    public int processBlock(byte[] bArr, int i11, byte[] bArr2, int i12) throws DataLengthException, IllegalStateException {
        if (this.roundKeys == null) {
            throw new IllegalStateException("ARIA engine not initialised");
        } else if (i11 > bArr.length - 16) {
            throw new DataLengthException("input buffer too short");
        } else if (i12 <= bArr2.length - 16) {
            byte[] bArr3 = new byte[16];
            System.arraycopy(bArr, i11, bArr3, 0, 16);
            int length = this.roundKeys.length - 3;
            int i13 = 0;
            while (i13 < length) {
                int i14 = i13 + 1;
                FO(bArr3, this.roundKeys[i13]);
                FE(bArr3, this.roundKeys[i14]);
                i13 = i14 + 1;
            }
            int i15 = i13 + 1;
            FO(bArr3, this.roundKeys[i13]);
            xor(bArr3, this.roundKeys[i15]);
            SL2(bArr3);
            xor(bArr3, this.roundKeys[i15 + 1]);
            System.arraycopy(bArr3, 0, bArr2, i12, 16);
            return 16;
        } else {
            throw new OutputLengthException("output buffer too short");
        }
    }

    public void reset() {
    }
}
