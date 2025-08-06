package org.bouncycastle.crypto.engines;

import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.sumsub.sns.prooface.network.b;
import com.twitter.sdk.android.core.internal.TwitterApiConstants;
import java.lang.reflect.Array;
import net.sf.scuba.smartcards.ISO7816;
import net.sf.scuba.smartcards.ISOFileInfo;
import okio.Utf8;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.StatelessProcessing;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.signers.PSSSigner;
import org.bouncycastle.util.Pack;
import org.jmrtd.lds.CVCAFile;

public class AESLightEngine implements BlockCipher, StatelessProcessing {
    private static final int BLOCK_SIZE = 16;
    private static final byte[] S = {99, 124, 119, 123, -14, 107, ISOFileInfo.FCI_BYTE, -59, ISO7816.INS_DECREASE, 1, 103, 43, -2, -41, ISOFileInfo.AB, 118, ISO7816.INS_GET_DATA, -126, -55, 125, -6, 89, 71, -16, -83, -44, -94, -81, -100, -92, 114, ISO7816.INS_GET_RESPONSE, -73, -3, -109, 38, 54, Utf8.REPLACEMENT_BYTE, -9, -52, ISO7816.INS_DECREASE_STAMPED, ISOFileInfo.A5, -27, -15, 113, ISO7816.INS_LOAD_KEY_FILE, Framer.STDOUT_FRAME_PREFIX, 21, 4, -57, 35, -61, Ascii.CAN, -106, 5, -102, 7, 18, Byte.MIN_VALUE, ISO7816.INS_APPEND_RECORD, -21, 39, -78, 117, 9, ISOFileInfo.FILE_IDENTIFIER, ISO7816.INS_UNBLOCK_CHV, Ascii.SUB, Ascii.ESC, 110, 90, ISOFileInfo.A0, 82, 59, ISO7816.INS_UPDATE_BINARY, ISO7816.INS_READ_RECORD2, 41, -29, 47, -124, 83, -47, 0, -19, 32, -4, ISO7816.INS_READ_BINARY2, 91, 106, -53, -66, 57, 74, 76, 88, -49, ISO7816.INS_WRITE_BINARY, -17, -86, -5, 67, 77, 51, ISOFileInfo.PROP_INFO, 69, -7, 2, Ascii.DEL, 80, 60, -97, -88, 81, -93, SignedBytes.MAX_POWER_OF_TWO, -113, -110, -99, 56, -11, PSSSigner.TRAILER_IMPLICIT, ISO7816.INS_READ_RECORD_STAMPED, ISO7816.INS_PUT_DATA, Framer.ENTER_FRAME_PREFIX, 16, -1, -13, ISO7816.INS_WRITE_RECORD, -51, 12, 19, -20, 95, -105, ISO7816.INS_REHABILITATE_CHV, 23, -60, -89, 126, 61, 100, 93, Ascii.EM, 115, 96, ISOFileInfo.DATA_BYTES2, 79, ISO7816.INS_UPDATE_RECORD, ISO7816.INS_MSE, ISO7816.INS_PSO, -112, -120, 70, -18, -72, 20, -34, 94, 11, -37, ISO7816.INS_CREATE_FILE, 50, 58, 10, 73, 6, ISO7816.INS_CHANGE_CHV, 92, ISO7816.INS_ENVELOPE, -45, -84, ISOFileInfo.FCP_BYTE, -111, -107, ISO7816.INS_DELETE_FILE, 121, -25, -56, 55, 109, ISOFileInfo.ENV_TEMP_EF, -43, 78, -87, 108, 86, -12, -22, 101, 122, -82, 8, -70, Framer.EXIT_FRAME_PREFIX, 37, 46, 28, -90, ISO7816.INS_READ_BINARY_STAMPED, -58, -24, -35, 116, Ascii.US, 75, -67, ISOFileInfo.SECURITY_ATTR_EXP, ISOFileInfo.LCS_BYTE, ISO7816.INS_MANAGE_CHANNEL, 62, -75, 102, 72, 3, -10, 14, 97, 53, 87, -71, -122, -63, 29, -98, -31, -8, -104, 17, 105, -39, ISOFileInfo.CHANNEL_SECURITY, -108, -101, 30, ISOFileInfo.FCI_EXT, -23, -50, 85, 40, -33, ISOFileInfo.SECURITY_ATTR_COMPACT, ISOFileInfo.A1, -119, 13, -65, -26, CVCAFile.CAR_TAG, 104, 65, -103, Framer.STDIN_FRAME_PREFIX, 15, ISO7816.INS_READ_BINARY, 84, -69, 22};
    private static final byte[] Si = {82, 9, 106, -43, ISO7816.INS_DECREASE, 54, ISOFileInfo.A5, 56, -65, SignedBytes.MAX_POWER_OF_TWO, -93, -98, ISOFileInfo.DATA_BYTES2, -13, -41, -5, 124, -29, 57, -126, -101, 47, -1, ISOFileInfo.FCI_EXT, ISO7816.INS_DECREASE_STAMPED, ISOFileInfo.CHANNEL_SECURITY, 67, ISO7816.INS_REHABILITATE_CHV, -60, -34, -23, -53, 84, 123, -108, 50, -90, ISO7816.INS_ENVELOPE, 35, 61, -18, 76, -107, 11, CVCAFile.CAR_TAG, -6, -61, 78, 8, 46, ISOFileInfo.A1, 102, 40, -39, ISO7816.INS_CHANGE_CHV, -78, 118, 91, -94, 73, 109, ISOFileInfo.SECURITY_ATTR_EXP, -47, 37, 114, -8, -10, 100, -122, 104, -104, 22, -44, -92, 92, -52, 93, 101, ISO7816.INS_READ_RECORD_STAMPED, -110, 108, ISO7816.INS_MANAGE_CHANNEL, 72, 80, -3, -19, -71, ISO7816.INS_PUT_DATA, 94, 21, 70, 87, -89, ISOFileInfo.ENV_TEMP_EF, -99, -124, -112, ISO7816.INS_LOAD_KEY_FILE, ISOFileInfo.AB, 0, ISOFileInfo.SECURITY_ATTR_COMPACT, PSSSigner.TRAILER_IMPLICIT, -45, 10, -9, ISO7816.INS_DELETE_FILE, 88, 5, -72, ISO7816.INS_READ_RECORD2, 69, 6, ISO7816.INS_WRITE_BINARY, ISO7816.INS_UNBLOCK_CHV, 30, -113, ISO7816.INS_GET_DATA, Utf8.REPLACEMENT_BYTE, 15, 2, -63, -81, -67, 3, 1, 19, ISOFileInfo.LCS_BYTE, 107, 58, -111, 17, 65, 79, 103, ISO7816.INS_UPDATE_RECORD, -22, -105, -14, -49, -50, -16, ISO7816.INS_READ_BINARY_STAMPED, -26, 115, -106, -84, 116, ISO7816.INS_MSE, -25, -83, 53, ISOFileInfo.PROP_INFO, ISO7816.INS_APPEND_RECORD, -7, 55, -24, 28, 117, -33, 110, 71, -15, Ascii.SUB, 113, 29, 41, -59, -119, ISOFileInfo.FCI_BYTE, -73, ISOFileInfo.FCP_BYTE, 14, -86, Ascii.CAN, -66, Ascii.ESC, -4, 86, 62, 75, -58, ISO7816.INS_WRITE_RECORD, 121, 32, -102, -37, ISO7816.INS_GET_RESPONSE, -2, Framer.EXIT_FRAME_PREFIX, -51, 90, -12, Ascii.US, -35, -88, 51, -120, 7, -57, Framer.STDOUT_FRAME_PREFIX, ISO7816.INS_READ_BINARY2, 18, 16, 89, 39, Byte.MIN_VALUE, -20, 95, 96, 81, Ascii.DEL, -87, Ascii.EM, -75, 74, 13, Framer.STDIN_FRAME_PREFIX, -27, 122, -97, -109, -55, -100, -17, ISOFileInfo.A0, ISO7816.INS_CREATE_FILE, 59, 77, -82, ISO7816.INS_PSO, -11, ISO7816.INS_READ_BINARY, -56, -21, -69, 60, ISOFileInfo.FILE_IDENTIFIER, 83, -103, 97, 23, 43, 4, 126, -70, 119, ISO7816.INS_UPDATE_BINARY, 38, -31, 105, 20, 99, 85, Framer.ENTER_FRAME_PREFIX, 12, 125};

    /* renamed from: m1  reason: collision with root package name */
    private static final int f59156m1 = -2139062144;

    /* renamed from: m2  reason: collision with root package name */
    private static final int f59157m2 = 2139062143;

    /* renamed from: m3  reason: collision with root package name */
    private static final int f59158m3 = 27;

    /* renamed from: m4  reason: collision with root package name */
    private static final int f59159m4 = -1061109568;

    /* renamed from: m5  reason: collision with root package name */
    private static final int f59160m5 = 1061109567;
    private static final int[] rcon = {1, 2, 4, 8, 16, 32, 64, 128, 27, 54, 108, 216, 171, 77, 154, 47, 94, 188, 99, 198, 151, 53, 106, 212, 179, 125, 250, TwitterApiConstants.Errors.GUEST_AUTH_ERROR_CODE, 197, 145};
    private int ROUNDS;
    private int[][] WorkingKey = null;
    private boolean forEncryption;

    private static int FFmulX(int i11) {
        return (((i11 & f59156m1) >>> 7) * 27) ^ ((f59157m2 & i11) << 1);
    }

    private static int FFmulX2(int i11) {
        int i12 = i11 & f59159m4;
        int i13 = i12 ^ (i12 >>> 1);
        return (i13 >>> 5) ^ (((f59160m5 & i11) << 2) ^ (i13 >>> 2));
    }

    private void decryptBlock(byte[] bArr, int i11, byte[] bArr2, int i12, int[][] iArr) {
        byte[] bArr3 = bArr;
        byte[] bArr4 = bArr2;
        int littleEndianToInt = Pack.littleEndianToInt(bArr3, i11 + 0);
        int littleEndianToInt2 = Pack.littleEndianToInt(bArr3, i11 + 4);
        int littleEndianToInt3 = Pack.littleEndianToInt(bArr3, i11 + 8);
        int littleEndianToInt4 = Pack.littleEndianToInt(bArr3, i11 + 12);
        int i13 = this.ROUNDS;
        int i14 = littleEndianToInt ^ iArr[i13][0];
        int i15 = littleEndianToInt2 ^ iArr[i13][1];
        int i16 = littleEndianToInt3 ^ iArr[i13][2];
        int i17 = i13 - 1;
        int i18 = littleEndianToInt4 ^ iArr[i13][3];
        while (true) {
            byte[] bArr5 = Si;
            int i19 = i14 & 255;
            if (i17 > 1) {
                int inv_mcol = inv_mcol((((bArr5[i19] & 255) ^ ((bArr5[(i18 >> 8) & 255] & 255) << 8)) ^ ((bArr5[(i16 >> 16) & 255] & 255) << 16)) ^ (bArr5[(i15 >> 24) & 255] << Ascii.CAN)) ^ iArr[i17][0];
                int inv_mcol2 = inv_mcol((((bArr5[i15 & 255] & 255) ^ ((bArr5[(i14 >> 8) & 255] & 255) << 8)) ^ ((bArr5[(i18 >> 16) & 255] & 255) << 16)) ^ (bArr5[(i16 >> 24) & 255] << Ascii.CAN)) ^ iArr[i17][1];
                int inv_mcol3 = inv_mcol((((bArr5[i16 & 255] & 255) ^ ((bArr5[(i15 >> 8) & 255] & 255) << 8)) ^ ((bArr5[(i14 >> 16) & 255] & 255) << 16)) ^ (bArr5[(i18 >> 24) & 255] << Ascii.CAN)) ^ iArr[i17][2];
                int i21 = i17 - 1;
                int inv_mcol4 = inv_mcol((((bArr5[i18 & 255] & 255) ^ ((bArr5[(i16 >> 8) & 255] & 255) << 8)) ^ ((bArr5[(i15 >> 16) & 255] & 255) << 16)) ^ (bArr5[(i14 >> 24) & 255] << Ascii.CAN)) ^ iArr[i17][3];
                int inv_mcol5 = inv_mcol((((bArr5[inv_mcol & 255] & 255) ^ ((bArr5[(inv_mcol4 >> 8) & 255] & 255) << 8)) ^ ((bArr5[(inv_mcol3 >> 16) & 255] & 255) << 16)) ^ (bArr5[(inv_mcol2 >> 24) & 255] << Ascii.CAN)) ^ iArr[i21][0];
                int inv_mcol6 = inv_mcol((((bArr5[inv_mcol2 & 255] & 255) ^ ((bArr5[(inv_mcol >> 8) & 255] & 255) << 8)) ^ ((bArr5[(inv_mcol4 >> 16) & 255] & 255) << 16)) ^ (bArr5[(inv_mcol3 >> 24) & 255] << Ascii.CAN)) ^ iArr[i21][1];
                int i22 = i21 - 1;
                i18 = inv_mcol((((bArr5[inv_mcol4 & 255] & 255) ^ ((bArr5[(inv_mcol3 >> 8) & 255] & 255) << 8)) ^ ((bArr5[(inv_mcol2 >> 16) & 255] & 255) << 16)) ^ (bArr5[(inv_mcol >> 24) & 255] << Ascii.CAN)) ^ iArr[i21][3];
                i14 = inv_mcol5;
                i15 = inv_mcol6;
                i16 = inv_mcol((((bArr5[inv_mcol3 & 255] & 255) ^ ((bArr5[(inv_mcol2 >> 8) & 255] & 255) << 8)) ^ ((bArr5[(inv_mcol >> 16) & 255] & 255) << 16)) ^ (bArr5[(inv_mcol4 >> 24) & 255] << Ascii.CAN)) ^ iArr[i21][2];
                i17 = i22;
            } else {
                int inv_mcol7 = inv_mcol((((bArr5[i19] & 255) ^ ((bArr5[(i18 >> 8) & 255] & 255) << 8)) ^ ((bArr5[(i16 >> 16) & 255] & 255) << 16)) ^ (bArr5[(i15 >> 24) & 255] << Ascii.CAN)) ^ iArr[i17][0];
                int inv_mcol8 = inv_mcol((((bArr5[i15 & 255] & 255) ^ ((bArr5[(i14 >> 8) & 255] & 255) << 8)) ^ ((bArr5[(i18 >> 16) & 255] & 255) << 16)) ^ (bArr5[(i16 >> 24) & 255] << Ascii.CAN)) ^ iArr[i17][1];
                int inv_mcol9 = inv_mcol((((bArr5[i16 & 255] & 255) ^ ((bArr5[(i15 >> 8) & 255] & 255) << 8)) ^ ((bArr5[(i14 >> 16) & 255] & 255) << 16)) ^ (bArr5[(i18 >> 24) & 255] << Ascii.CAN)) ^ iArr[i17][2];
                int inv_mcol10 = inv_mcol((((bArr5[i18 & 255] & 255) ^ ((bArr5[(i16 >> 8) & 255] & 255) << 8)) ^ ((bArr5[(i15 >> 16) & 255] & 255) << 16)) ^ (bArr5[(i14 >> 24) & 255] << Ascii.CAN)) ^ iArr[i17][3];
                byte b11 = ((((bArr5[inv_mcol7 & 255] & 255) ^ ((bArr5[(inv_mcol10 >> 8) & 255] & 255) << 8)) ^ ((bArr5[(inv_mcol9 >> 16) & 255] & 255) << 16)) ^ (bArr5[(inv_mcol8 >> 24) & 255] << Ascii.CAN)) ^ iArr[0][0];
                byte b12 = ((((bArr5[inv_mcol8 & 255] & 255) ^ ((bArr5[(inv_mcol7 >> 8) & 255] & 255) << 8)) ^ ((bArr5[(inv_mcol10 >> 16) & 255] & 255) << 16)) ^ (bArr5[(inv_mcol9 >> 24) & 255] << Ascii.CAN)) ^ iArr[0][1];
                byte b13 = ((((bArr5[inv_mcol9 & 255] & 255) ^ ((bArr5[(inv_mcol8 >> 8) & 255] & 255) << 8)) ^ ((bArr5[(inv_mcol7 >> 16) & 255] & 255) << 16)) ^ (bArr5[(inv_mcol10 >> 24) & 255] << Ascii.CAN)) ^ iArr[0][2];
                byte b14 = ((((bArr5[inv_mcol10 & 255] & 255) ^ ((bArr5[(inv_mcol9 >> 8) & 255] & 255) << 8)) ^ ((bArr5[(inv_mcol8 >> 16) & 255] & 255) << 16)) ^ (bArr5[(inv_mcol7 >> 24) & 255] << Ascii.CAN)) ^ iArr[0][3];
                Pack.intToLittleEndian((int) b11, bArr4, i12 + 0);
                Pack.intToLittleEndian((int) b12, bArr4, i12 + 4);
                Pack.intToLittleEndian((int) b13, bArr4, i12 + 8);
                Pack.intToLittleEndian((int) b14, bArr4, i12 + 12);
                return;
            }
        }
    }

    private void encryptBlock(byte[] bArr, int i11, byte[] bArr2, int i12, int[][] iArr) {
        byte[] bArr3 = bArr;
        byte[] bArr4 = bArr2;
        int littleEndianToInt = Pack.littleEndianToInt(bArr3, i11 + 0);
        int littleEndianToInt2 = Pack.littleEndianToInt(bArr3, i11 + 4);
        int littleEndianToInt3 = Pack.littleEndianToInt(bArr3, i11 + 8);
        int littleEndianToInt4 = Pack.littleEndianToInt(bArr3, i11 + 12);
        int i13 = littleEndianToInt ^ iArr[0][0];
        int i14 = littleEndianToInt2 ^ iArr[0][1];
        int i15 = littleEndianToInt3 ^ iArr[0][2];
        int i16 = littleEndianToInt4 ^ iArr[0][3];
        int i17 = 1;
        while (i17 < this.ROUNDS - 1) {
            byte[] bArr5 = S;
            int mcol = mcol((((bArr5[i13 & 255] & 255) ^ ((bArr5[(i14 >> 8) & 255] & 255) << 8)) ^ ((bArr5[(i15 >> 16) & 255] & 255) << 16)) ^ (bArr5[(i16 >> 24) & 255] << Ascii.CAN)) ^ iArr[i17][0];
            int mcol2 = mcol((((bArr5[i14 & 255] & 255) ^ ((bArr5[(i15 >> 8) & 255] & 255) << 8)) ^ ((bArr5[(i16 >> 16) & 255] & 255) << 16)) ^ (bArr5[(i13 >> 24) & 255] << Ascii.CAN)) ^ iArr[i17][1];
            int mcol3 = mcol((((bArr5[i15 & 255] & 255) ^ ((bArr5[(i16 >> 8) & 255] & 255) << 8)) ^ ((bArr5[(i13 >> 16) & 255] & 255) << 16)) ^ (bArr5[(i14 >> 24) & 255] << Ascii.CAN)) ^ iArr[i17][2];
            int i18 = i17 + 1;
            int mcol4 = mcol((((bArr5[i16 & 255] & 255) ^ ((bArr5[(i13 >> 8) & 255] & 255) << 8)) ^ ((bArr5[(i14 >> 16) & 255] & 255) << 16)) ^ (bArr5[(i15 >> 24) & 255] << Ascii.CAN)) ^ iArr[i17][3];
            int mcol5 = mcol((((bArr5[mcol & 255] & 255) ^ ((bArr5[(mcol2 >> 8) & 255] & 255) << 8)) ^ ((bArr5[(mcol3 >> 16) & 255] & 255) << 16)) ^ (bArr5[(mcol4 >> 24) & 255] << Ascii.CAN)) ^ iArr[i18][0];
            int mcol6 = mcol((((bArr5[mcol2 & 255] & 255) ^ ((bArr5[(mcol3 >> 8) & 255] & 255) << 8)) ^ ((bArr5[(mcol4 >> 16) & 255] & 255) << 16)) ^ (bArr5[(mcol >> 24) & 255] << Ascii.CAN)) ^ iArr[i18][1];
            int i19 = i18 + 1;
            i16 = mcol((((bArr5[mcol4 & 255] & 255) ^ ((bArr5[(mcol >> 8) & 255] & 255) << 8)) ^ ((bArr5[(mcol2 >> 16) & 255] & 255) << 16)) ^ (bArr5[(mcol3 >> 24) & 255] << Ascii.CAN)) ^ iArr[i18][3];
            i13 = mcol5;
            i14 = mcol6;
            i15 = mcol((((bArr5[mcol3 & 255] & 255) ^ ((bArr5[(mcol4 >> 8) & 255] & 255) << 8)) ^ ((bArr5[(mcol >> 16) & 255] & 255) << 16)) ^ (bArr5[(mcol2 >> 24) & 255] << Ascii.CAN)) ^ iArr[i18][2];
            i17 = i19;
        }
        byte[] bArr6 = S;
        int mcol7 = mcol((((bArr6[i13 & 255] & 255) ^ ((bArr6[(i14 >> 8) & 255] & 255) << 8)) ^ ((bArr6[(i15 >> 16) & 255] & 255) << 16)) ^ (bArr6[(i16 >> 24) & 255] << Ascii.CAN)) ^ iArr[i17][0];
        int mcol8 = mcol((((bArr6[i14 & 255] & 255) ^ ((bArr6[(i15 >> 8) & 255] & 255) << 8)) ^ ((bArr6[(i16 >> 16) & 255] & 255) << 16)) ^ (bArr6[(i13 >> 24) & 255] << Ascii.CAN)) ^ iArr[i17][1];
        int mcol9 = mcol((((bArr6[i15 & 255] & 255) ^ ((bArr6[(i16 >> 8) & 255] & 255) << 8)) ^ ((bArr6[(i13 >> 16) & 255] & 255) << 16)) ^ (bArr6[(i14 >> 24) & 255] << Ascii.CAN)) ^ iArr[i17][2];
        int i21 = i17 + 1;
        int mcol10 = mcol((((bArr6[i16 & 255] & 255) ^ ((bArr6[(i13 >> 8) & 255] & 255) << 8)) ^ ((bArr6[(i14 >> 16) & 255] & 255) << 16)) ^ (bArr6[(i15 >> 24) & 255] << Ascii.CAN)) ^ iArr[i17][3];
        byte b11 = ((((bArr6[mcol7 & 255] & 255) ^ ((bArr6[(mcol8 >> 8) & 255] & 255) << 8)) ^ ((bArr6[(mcol9 >> 16) & 255] & 255) << 16)) ^ (bArr6[(mcol10 >> 24) & 255] << Ascii.CAN)) ^ iArr[i21][0];
        byte b12 = ((((bArr6[mcol8 & 255] & 255) ^ ((bArr6[(mcol9 >> 8) & 255] & 255) << 8)) ^ ((bArr6[(mcol10 >> 16) & 255] & 255) << 16)) ^ (bArr6[(mcol7 >> 24) & 255] << Ascii.CAN)) ^ iArr[i21][1];
        byte b13 = ((((bArr6[mcol9 & 255] & 255) ^ ((bArr6[(mcol10 >> 8) & 255] & 255) << 8)) ^ ((bArr6[(mcol7 >> 16) & 255] & 255) << 16)) ^ (bArr6[(mcol8 >> 24) & 255] << Ascii.CAN)) ^ iArr[i21][2];
        byte b14 = ((((bArr6[mcol10 & 255] & 255) ^ ((bArr6[(mcol7 >> 8) & 255] & 255) << 8)) ^ ((bArr6[(mcol8 >> 16) & 255] & 255) << 16)) ^ (bArr6[(mcol9 >> 24) & 255] << Ascii.CAN)) ^ iArr[i21][3];
        Pack.intToLittleEndian((int) b11, bArr4, i12 + 0);
        Pack.intToLittleEndian((int) b12, bArr4, i12 + 4);
        Pack.intToLittleEndian((int) b13, bArr4, i12 + 8);
        Pack.intToLittleEndian((int) b14, bArr4, i12 + 12);
    }

    private int[][] generateWorkingKey(byte[] bArr, boolean z11) {
        byte[] bArr2 = bArr;
        int length = bArr2.length;
        if (length < 16 || length > 32 || (length & 7) != 0) {
            throw new IllegalArgumentException("Key length not 128/192/256 bits.");
        }
        int i11 = length >>> 2;
        int i12 = i11 + 6;
        this.ROUNDS = i12;
        int[] iArr = new int[2];
        iArr[1] = 4;
        iArr[0] = i12 + 1;
        int[][] iArr2 = (int[][]) Array.newInstance(int.class, iArr);
        int i13 = 8;
        char c11 = 3;
        if (i11 == 4) {
            int littleEndianToInt = Pack.littleEndianToInt(bArr2, 0);
            iArr2[0][0] = littleEndianToInt;
            int littleEndianToInt2 = Pack.littleEndianToInt(bArr2, 4);
            iArr2[0][1] = littleEndianToInt2;
            int littleEndianToInt3 = Pack.littleEndianToInt(bArr2, 8);
            iArr2[0][2] = littleEndianToInt3;
            int littleEndianToInt4 = Pack.littleEndianToInt(bArr2, 12);
            iArr2[0][3] = littleEndianToInt4;
            for (int i14 = 1; i14 <= 10; i14++) {
                littleEndianToInt ^= subWord(shift(littleEndianToInt4, 8)) ^ rcon[i14 - 1];
                iArr2[i14][0] = littleEndianToInt;
                littleEndianToInt2 ^= littleEndianToInt;
                iArr2[i14][1] = littleEndianToInt2;
                littleEndianToInt3 ^= littleEndianToInt2;
                iArr2[i14][2] = littleEndianToInt3;
                littleEndianToInt4 ^= littleEndianToInt3;
                iArr2[i14][3] = littleEndianToInt4;
            }
        } else if (i11 == 6) {
            int littleEndianToInt5 = Pack.littleEndianToInt(bArr2, 0);
            iArr2[0][0] = littleEndianToInt5;
            int littleEndianToInt6 = Pack.littleEndianToInt(bArr2, 4);
            iArr2[0][1] = littleEndianToInt6;
            int littleEndianToInt7 = Pack.littleEndianToInt(bArr2, 8);
            iArr2[0][2] = littleEndianToInt7;
            int littleEndianToInt8 = Pack.littleEndianToInt(bArr2, 12);
            iArr2[0][3] = littleEndianToInt8;
            int littleEndianToInt9 = Pack.littleEndianToInt(bArr2, 16);
            int littleEndianToInt10 = Pack.littleEndianToInt(bArr2, 20);
            int i15 = 1;
            int i16 = 1;
            while (true) {
                iArr2[i15][0] = littleEndianToInt9;
                iArr2[i15][1] = littleEndianToInt10;
                int subWord = subWord(shift(littleEndianToInt10, 8)) ^ i16;
                int i17 = i16 << 1;
                int i18 = littleEndianToInt5 ^ subWord;
                iArr2[i15][2] = i18;
                int i19 = littleEndianToInt6 ^ i18;
                iArr2[i15][3] = i19;
                int i21 = littleEndianToInt7 ^ i19;
                int i22 = i15 + 1;
                iArr2[i22][0] = i21;
                int i23 = littleEndianToInt8 ^ i21;
                iArr2[i22][1] = i23;
                int i24 = littleEndianToInt9 ^ i23;
                iArr2[i22][2] = i24;
                int i25 = littleEndianToInt10 ^ i24;
                iArr2[i22][3] = i25;
                int subWord2 = subWord(shift(i25, 8)) ^ i17;
                i16 = i17 << 1;
                littleEndianToInt5 = i18 ^ subWord2;
                int i26 = i15 + 2;
                iArr2[i26][0] = littleEndianToInt5;
                littleEndianToInt6 = i19 ^ littleEndianToInt5;
                iArr2[i26][1] = littleEndianToInt6;
                littleEndianToInt7 = i21 ^ littleEndianToInt6;
                iArr2[i26][2] = littleEndianToInt7;
                littleEndianToInt8 = i23 ^ littleEndianToInt7;
                iArr2[i26][3] = littleEndianToInt8;
                i15 += 3;
                if (i15 >= 13) {
                    break;
                }
                littleEndianToInt9 = i24 ^ littleEndianToInt8;
                littleEndianToInt10 = i25 ^ littleEndianToInt9;
            }
        } else if (i11 == 8) {
            int littleEndianToInt11 = Pack.littleEndianToInt(bArr2, 0);
            iArr2[0][0] = littleEndianToInt11;
            int littleEndianToInt12 = Pack.littleEndianToInt(bArr2, 4);
            iArr2[0][1] = littleEndianToInt12;
            int littleEndianToInt13 = Pack.littleEndianToInt(bArr2, 8);
            iArr2[0][2] = littleEndianToInt13;
            int littleEndianToInt14 = Pack.littleEndianToInt(bArr2, 12);
            iArr2[0][3] = littleEndianToInt14;
            int littleEndianToInt15 = Pack.littleEndianToInt(bArr2, 16);
            iArr2[1][0] = littleEndianToInt15;
            int littleEndianToInt16 = Pack.littleEndianToInt(bArr2, 20);
            iArr2[1][1] = littleEndianToInt16;
            int littleEndianToInt17 = Pack.littleEndianToInt(bArr2, 24);
            iArr2[1][2] = littleEndianToInt17;
            int littleEndianToInt18 = Pack.littleEndianToInt(bArr2, 28);
            iArr2[1][3] = littleEndianToInt18;
            int i27 = 2;
            int i28 = 1;
            while (true) {
                int subWord3 = subWord(shift(littleEndianToInt18, i13)) ^ i28;
                i28 <<= 1;
                littleEndianToInt11 ^= subWord3;
                iArr2[i27][0] = littleEndianToInt11;
                littleEndianToInt12 ^= littleEndianToInt11;
                iArr2[i27][1] = littleEndianToInt12;
                littleEndianToInt13 ^= littleEndianToInt12;
                iArr2[i27][2] = littleEndianToInt13;
                littleEndianToInt14 ^= littleEndianToInt13;
                iArr2[i27][c11] = littleEndianToInt14;
                int i29 = i27 + 1;
                if (i29 >= 15) {
                    break;
                }
                littleEndianToInt15 ^= subWord(littleEndianToInt14);
                iArr2[i29][0] = littleEndianToInt15;
                littleEndianToInt16 ^= littleEndianToInt15;
                iArr2[i29][1] = littleEndianToInt16;
                littleEndianToInt17 ^= littleEndianToInt16;
                iArr2[i29][2] = littleEndianToInt17;
                littleEndianToInt18 ^= littleEndianToInt17;
                iArr2[i29][3] = littleEndianToInt18;
                i27 = i29 + 1;
                i13 = 8;
                c11 = 3;
            }
        } else {
            throw new IllegalStateException("Should never get here");
        }
        if (!z11) {
            for (int i30 = 1; i30 < this.ROUNDS; i30++) {
                for (int i31 = 0; i31 < 4; i31++) {
                    iArr2[i30][i31] = inv_mcol(iArr2[i30][i31]);
                }
            }
        }
        return iArr2;
    }

    private static int inv_mcol(int i11) {
        int shift = shift(i11, 8) ^ i11;
        int FFmulX = i11 ^ FFmulX(shift);
        int FFmulX2 = shift ^ FFmulX2(FFmulX);
        return FFmulX ^ (FFmulX2 ^ shift(FFmulX2, 16));
    }

    private static int mcol(int i11) {
        int shift = shift(i11, 8);
        int i12 = i11 ^ shift;
        return FFmulX(i12) ^ (shift ^ shift(i12, 16));
    }

    private static int shift(int i11, int i12) {
        return (i11 << (-i12)) | (i11 >>> i12);
    }

    private static int subWord(int i11) {
        byte[] bArr = S;
        return (bArr[(i11 >> 24) & 255] << Ascii.CAN) | (bArr[i11 & 255] & 255) | ((bArr[(i11 >> 8) & 255] & 255) << 8) | ((bArr[(i11 >> 16) & 255] & 255) << 16);
    }

    public String getAlgorithmName() {
        return b.f40261d;
    }

    public int getBlockSize() {
        return 16;
    }

    public void init(boolean z11, CipherParameters cipherParameters) {
        if (cipherParameters instanceof KeyParameter) {
            this.WorkingKey = generateWorkingKey(((KeyParameter) cipherParameters).getKey(), z11);
            this.forEncryption = z11;
            return;
        }
        throw new IllegalArgumentException("invalid parameter passed to AES init - " + cipherParameters.getClass().getName());
    }

    public BlockCipher newInstance() {
        return new AESLightEngine();
    }

    public int processBlock(byte[] bArr, int i11, byte[] bArr2, int i12) {
        int[][] iArr = this.WorkingKey;
        if (iArr == null) {
            throw new IllegalStateException("AES engine not initialised");
        } else if (i11 > bArr.length - 16) {
            throw new DataLengthException("input buffer too short");
        } else if (i12 <= bArr2.length - 16) {
            if (this.forEncryption) {
                encryptBlock(bArr, i11, bArr2, i12, iArr);
            } else {
                decryptBlock(bArr, i11, bArr2, i12, iArr);
            }
            return 16;
        } else {
            throw new OutputLengthException("output buffer too short");
        }
    }

    public void reset() {
    }
}
