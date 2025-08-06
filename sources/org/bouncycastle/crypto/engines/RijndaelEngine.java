package org.bouncycastle.crypto.engines;

import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.sumsub.sns.prooface.network.d;
import com.twitter.sdk.android.core.internal.TwitterApiConstants;
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
import org.jmrtd.lds.CVCAFile;

public class RijndaelEngine implements BlockCipher {
    private static final int MAXKC = 64;
    private static final int MAXROUNDS = 14;
    private static final byte[] S = {99, 124, 119, 123, -14, 107, ISOFileInfo.FCI_BYTE, -59, ISO7816.INS_DECREASE, 1, 103, 43, -2, -41, ISOFileInfo.AB, 118, ISO7816.INS_GET_DATA, -126, -55, 125, -6, 89, 71, -16, -83, -44, -94, -81, -100, -92, 114, ISO7816.INS_GET_RESPONSE, -73, -3, -109, 38, 54, Utf8.REPLACEMENT_BYTE, -9, -52, ISO7816.INS_DECREASE_STAMPED, ISOFileInfo.A5, -27, -15, 113, ISO7816.INS_LOAD_KEY_FILE, Framer.STDOUT_FRAME_PREFIX, 21, 4, -57, 35, -61, Ascii.CAN, -106, 5, -102, 7, 18, Byte.MIN_VALUE, ISO7816.INS_APPEND_RECORD, -21, 39, -78, 117, 9, ISOFileInfo.FILE_IDENTIFIER, ISO7816.INS_UNBLOCK_CHV, Ascii.SUB, Ascii.ESC, 110, 90, ISOFileInfo.A0, 82, 59, ISO7816.INS_UPDATE_BINARY, ISO7816.INS_READ_RECORD2, 41, -29, 47, -124, 83, -47, 0, -19, 32, -4, ISO7816.INS_READ_BINARY2, 91, 106, -53, -66, 57, 74, 76, 88, -49, ISO7816.INS_WRITE_BINARY, -17, -86, -5, 67, 77, 51, ISOFileInfo.PROP_INFO, 69, -7, 2, Ascii.DEL, 80, 60, -97, -88, 81, -93, SignedBytes.MAX_POWER_OF_TWO, -113, -110, -99, 56, -11, PSSSigner.TRAILER_IMPLICIT, ISO7816.INS_READ_RECORD_STAMPED, ISO7816.INS_PUT_DATA, Framer.ENTER_FRAME_PREFIX, 16, -1, -13, ISO7816.INS_WRITE_RECORD, -51, 12, 19, -20, 95, -105, ISO7816.INS_REHABILITATE_CHV, 23, -60, -89, 126, 61, 100, 93, Ascii.EM, 115, 96, ISOFileInfo.DATA_BYTES2, 79, ISO7816.INS_UPDATE_RECORD, ISO7816.INS_MSE, ISO7816.INS_PSO, -112, -120, 70, -18, -72, 20, -34, 94, 11, -37, ISO7816.INS_CREATE_FILE, 50, 58, 10, 73, 6, ISO7816.INS_CHANGE_CHV, 92, ISO7816.INS_ENVELOPE, -45, -84, ISOFileInfo.FCP_BYTE, -111, -107, ISO7816.INS_DELETE_FILE, 121, -25, -56, 55, 109, ISOFileInfo.ENV_TEMP_EF, -43, 78, -87, 108, 86, -12, -22, 101, 122, -82, 8, -70, Framer.EXIT_FRAME_PREFIX, 37, 46, 28, -90, ISO7816.INS_READ_BINARY_STAMPED, -58, -24, -35, 116, Ascii.US, 75, -67, ISOFileInfo.SECURITY_ATTR_EXP, ISOFileInfo.LCS_BYTE, ISO7816.INS_MANAGE_CHANNEL, 62, -75, 102, 72, 3, -10, 14, 97, 53, 87, -71, -122, -63, 29, -98, -31, -8, -104, 17, 105, -39, ISOFileInfo.CHANNEL_SECURITY, -108, -101, 30, ISOFileInfo.FCI_EXT, -23, -50, 85, 40, -33, ISOFileInfo.SECURITY_ATTR_COMPACT, ISOFileInfo.A1, -119, 13, -65, -26, CVCAFile.CAR_TAG, 104, 65, -103, Framer.STDIN_FRAME_PREFIX, 15, ISO7816.INS_READ_BINARY, 84, -69, 22};
    private static final byte[] Si = {82, 9, 106, -43, ISO7816.INS_DECREASE, 54, ISOFileInfo.A5, 56, -65, SignedBytes.MAX_POWER_OF_TWO, -93, -98, ISOFileInfo.DATA_BYTES2, -13, -41, -5, 124, -29, 57, -126, -101, 47, -1, ISOFileInfo.FCI_EXT, ISO7816.INS_DECREASE_STAMPED, ISOFileInfo.CHANNEL_SECURITY, 67, ISO7816.INS_REHABILITATE_CHV, -60, -34, -23, -53, 84, 123, -108, 50, -90, ISO7816.INS_ENVELOPE, 35, 61, -18, 76, -107, 11, CVCAFile.CAR_TAG, -6, -61, 78, 8, 46, ISOFileInfo.A1, 102, 40, -39, ISO7816.INS_CHANGE_CHV, -78, 118, 91, -94, 73, 109, ISOFileInfo.SECURITY_ATTR_EXP, -47, 37, 114, -8, -10, 100, -122, 104, -104, 22, -44, -92, 92, -52, 93, 101, ISO7816.INS_READ_RECORD_STAMPED, -110, 108, ISO7816.INS_MANAGE_CHANNEL, 72, 80, -3, -19, -71, ISO7816.INS_PUT_DATA, 94, 21, 70, 87, -89, ISOFileInfo.ENV_TEMP_EF, -99, -124, -112, ISO7816.INS_LOAD_KEY_FILE, ISOFileInfo.AB, 0, ISOFileInfo.SECURITY_ATTR_COMPACT, PSSSigner.TRAILER_IMPLICIT, -45, 10, -9, ISO7816.INS_DELETE_FILE, 88, 5, -72, ISO7816.INS_READ_RECORD2, 69, 6, ISO7816.INS_WRITE_BINARY, ISO7816.INS_UNBLOCK_CHV, 30, -113, ISO7816.INS_GET_DATA, Utf8.REPLACEMENT_BYTE, 15, 2, -63, -81, -67, 3, 1, 19, ISOFileInfo.LCS_BYTE, 107, 58, -111, 17, 65, 79, 103, ISO7816.INS_UPDATE_RECORD, -22, -105, -14, -49, -50, -16, ISO7816.INS_READ_BINARY_STAMPED, -26, 115, -106, -84, 116, ISO7816.INS_MSE, -25, -83, 53, ISOFileInfo.PROP_INFO, ISO7816.INS_APPEND_RECORD, -7, 55, -24, 28, 117, -33, 110, 71, -15, Ascii.SUB, 113, 29, 41, -59, -119, ISOFileInfo.FCI_BYTE, -73, ISOFileInfo.FCP_BYTE, 14, -86, Ascii.CAN, -66, Ascii.ESC, -4, 86, 62, 75, -58, ISO7816.INS_WRITE_RECORD, 121, 32, -102, -37, ISO7816.INS_GET_RESPONSE, -2, Framer.EXIT_FRAME_PREFIX, -51, 90, -12, Ascii.US, -35, -88, 51, -120, 7, -57, Framer.STDOUT_FRAME_PREFIX, ISO7816.INS_READ_BINARY2, 18, 16, 89, 39, Byte.MIN_VALUE, -20, 95, 96, 81, Ascii.DEL, -87, Ascii.EM, -75, 74, 13, Framer.STDIN_FRAME_PREFIX, -27, 122, -97, -109, -55, -100, -17, ISOFileInfo.A0, ISO7816.INS_CREATE_FILE, 59, 77, -82, ISO7816.INS_PSO, -11, ISO7816.INS_READ_BINARY, -56, -21, -69, 60, ISOFileInfo.FILE_IDENTIFIER, 83, -103, 97, 23, 43, 4, 126, -70, 119, ISO7816.INS_UPDATE_BINARY, 38, -31, 105, 20, 99, 85, Framer.ENTER_FRAME_PREFIX, 12, 125};
    private static final byte[] aLogtable = {0, 3, 5, 15, 17, 51, 85, -1, Ascii.SUB, 46, 114, -106, ISOFileInfo.A1, -8, 19, 53, 95, -31, 56, 72, ISO7816.INS_LOAD_KEY_FILE, 115, -107, -92, -9, 2, 6, 10, 30, ISO7816.INS_MSE, 102, -86, -27, ISO7816.INS_DECREASE_STAMPED, 92, ISO7816.INS_DELETE_FILE, 55, 89, -21, 38, 106, -66, -39, ISO7816.INS_MANAGE_CHANNEL, -112, ISOFileInfo.AB, -26, Framer.STDOUT_FRAME_PREFIX, 83, -11, 4, 12, 20, 60, ISO7816.INS_REHABILITATE_CHV, -52, 79, -47, 104, -72, -45, 110, -78, -51, 76, -44, 103, -87, ISO7816.INS_CREATE_FILE, 59, 77, -41, ISOFileInfo.FCP_BYTE, -90, -15, 8, Ascii.CAN, 40, Framer.EXIT_FRAME_PREFIX, -120, ISOFileInfo.FILE_IDENTIFIER, -98, -71, ISO7816.INS_WRITE_BINARY, 107, -67, ISO7816.INS_UPDATE_RECORD, Ascii.DEL, ISOFileInfo.DATA_BYTES2, -104, ISO7816.INS_READ_RECORD2, -50, 73, -37, 118, -102, -75, -60, 87, -7, 16, ISO7816.INS_DECREASE, 80, -16, 11, 29, 39, 105, -69, ISO7816.INS_UPDATE_BINARY, 97, -93, -2, Ascii.EM, 43, 125, ISOFileInfo.FCI_EXT, -110, -83, -20, 47, 113, -109, -82, -23, 32, 96, ISOFileInfo.A0, -5, 22, 58, 78, ISO7816.INS_WRITE_RECORD, 109, -73, ISO7816.INS_ENVELOPE, 93, -25, 50, 86, -6, 21, Utf8.REPLACEMENT_BYTE, 65, -61, 94, ISO7816.INS_APPEND_RECORD, 61, 71, -55, SignedBytes.MAX_POWER_OF_TWO, ISO7816.INS_GET_RESPONSE, 91, -19, ISO7816.INS_UNBLOCK_CHV, 116, -100, -65, ISO7816.INS_PUT_DATA, 117, -97, -70, -43, 100, -84, -17, ISO7816.INS_PSO, 126, -126, -99, PSSSigner.TRAILER_IMPLICIT, -33, 122, ISOFileInfo.CHANNEL_SECURITY, -119, Byte.MIN_VALUE, -101, ISO7816.INS_READ_RECORD_STAMPED, -63, 88, -24, 35, 101, -81, -22, 37, ISOFileInfo.FCI_BYTE, ISO7816.INS_READ_BINARY2, -56, 67, -59, 84, -4, Ascii.US, Framer.ENTER_FRAME_PREFIX, 99, ISOFileInfo.A5, -12, 7, 9, Ascii.ESC, Framer.STDIN_FRAME_PREFIX, 119, -103, ISO7816.INS_READ_BINARY, -53, 70, ISO7816.INS_GET_DATA, 69, -49, 74, -34, 121, ISOFileInfo.SECURITY_ATTR_EXP, -122, -111, -88, -29, 62, CVCAFile.CAR_TAG, -58, 81, -13, 14, 18, 54, 90, -18, 41, 123, ISOFileInfo.ENV_TEMP_EF, ISOFileInfo.SECURITY_ATTR_COMPACT, -113, ISOFileInfo.LCS_BYTE, ISOFileInfo.PROP_INFO, -108, -89, -14, 13, 23, 57, 75, -35, 124, -124, -105, -94, -3, 28, ISO7816.INS_CHANGE_CHV, 108, ISO7816.INS_READ_BINARY_STAMPED, -57, 82, -10, 1, 3, 5, 15, 17, 51, 85, -1, Ascii.SUB, 46, 114, -106, ISOFileInfo.A1, -8, 19, 53, 95, -31, 56, 72, ISO7816.INS_LOAD_KEY_FILE, 115, -107, -92, -9, 2, 6, 10, 30, ISO7816.INS_MSE, 102, -86, -27, ISO7816.INS_DECREASE_STAMPED, 92, ISO7816.INS_DELETE_FILE, 55, 89, -21, 38, 106, -66, -39, ISO7816.INS_MANAGE_CHANNEL, -112, ISOFileInfo.AB, -26, Framer.STDOUT_FRAME_PREFIX, 83, -11, 4, 12, 20, 60, ISO7816.INS_REHABILITATE_CHV, -52, 79, -47, 104, -72, -45, 110, -78, -51, 76, -44, 103, -87, ISO7816.INS_CREATE_FILE, 59, 77, -41, ISOFileInfo.FCP_BYTE, -90, -15, 8, Ascii.CAN, 40, Framer.EXIT_FRAME_PREFIX, -120, ISOFileInfo.FILE_IDENTIFIER, -98, -71, ISO7816.INS_WRITE_BINARY, 107, -67, ISO7816.INS_UPDATE_RECORD, Ascii.DEL, ISOFileInfo.DATA_BYTES2, -104, ISO7816.INS_READ_RECORD2, -50, 73, -37, 118, -102, -75, -60, 87, -7, 16, ISO7816.INS_DECREASE, 80, -16, 11, 29, 39, 105, -69, ISO7816.INS_UPDATE_BINARY, 97, -93, -2, Ascii.EM, 43, 125, ISOFileInfo.FCI_EXT, -110, -83, -20, 47, 113, -109, -82, -23, 32, 96, ISOFileInfo.A0, -5, 22, 58, 78, ISO7816.INS_WRITE_RECORD, 109, -73, ISO7816.INS_ENVELOPE, 93, -25, 50, 86, -6, 21, Utf8.REPLACEMENT_BYTE, 65, -61, 94, ISO7816.INS_APPEND_RECORD, 61, 71, -55, SignedBytes.MAX_POWER_OF_TWO, ISO7816.INS_GET_RESPONSE, 91, -19, ISO7816.INS_UNBLOCK_CHV, 116, -100, -65, ISO7816.INS_PUT_DATA, 117, -97, -70, -43, 100, -84, -17, ISO7816.INS_PSO, 126, -126, -99, PSSSigner.TRAILER_IMPLICIT, -33, 122, ISOFileInfo.CHANNEL_SECURITY, -119, Byte.MIN_VALUE, -101, ISO7816.INS_READ_RECORD_STAMPED, -63, 88, -24, 35, 101, -81, -22, 37, ISOFileInfo.FCI_BYTE, ISO7816.INS_READ_BINARY2, -56, 67, -59, 84, -4, Ascii.US, Framer.ENTER_FRAME_PREFIX, 99, ISOFileInfo.A5, -12, 7, 9, Ascii.ESC, Framer.STDIN_FRAME_PREFIX, 119, -103, ISO7816.INS_READ_BINARY, -53, 70, ISO7816.INS_GET_DATA, 69, -49, 74, -34, 121, ISOFileInfo.SECURITY_ATTR_EXP, -122, -111, -88, -29, 62, CVCAFile.CAR_TAG, -58, 81, -13, 14, 18, 54, 90, -18, 41, 123, ISOFileInfo.ENV_TEMP_EF, ISOFileInfo.SECURITY_ATTR_COMPACT, -113, ISOFileInfo.LCS_BYTE, ISOFileInfo.PROP_INFO, -108, -89, -14, 13, 23, 57, 75, -35, 124, -124, -105, -94, -3, 28, ISO7816.INS_CHANGE_CHV, 108, ISO7816.INS_READ_BINARY_STAMPED, -57, 82, -10, 1};
    private static final byte[] logtable = {0, 0, Ascii.EM, 1, 50, 2, Ascii.SUB, -58, 75, -57, Ascii.ESC, 104, 51, -18, -33, 3, 100, 4, ISO7816.INS_CREATE_FILE, 14, ISO7816.INS_DECREASE_STAMPED, ISOFileInfo.ENV_TEMP_EF, ISOFileInfo.DATA_BYTES2, -17, 76, 113, 8, -56, -8, 105, 28, -63, 125, ISO7816.INS_ENVELOPE, 29, -75, -7, -71, 39, 106, 77, ISO7816.INS_DELETE_FILE, -90, 114, -102, -55, 9, Framer.EXIT_FRAME_PREFIX, 101, 47, ISOFileInfo.LCS_BYTE, 5, Framer.ENTER_FRAME_PREFIX, 15, -31, ISO7816.INS_CHANGE_CHV, 18, -16, -126, 69, 53, -109, ISO7816.INS_PUT_DATA, ISOFileInfo.CHANNEL_SECURITY, -106, -113, -37, -67, 54, ISO7816.INS_WRITE_BINARY, -50, -108, 19, 92, ISO7816.INS_WRITE_RECORD, -15, SignedBytes.MAX_POWER_OF_TWO, 70, ISOFileInfo.FILE_IDENTIFIER, 56, 102, -35, -3, ISO7816.INS_DECREASE, -65, 6, ISOFileInfo.SECURITY_ATTR_EXP, ISOFileInfo.FCP_BYTE, ISO7816.INS_READ_RECORD2, 37, ISO7816.INS_APPEND_RECORD, -104, ISO7816.INS_MSE, -120, -111, 16, 126, 110, 72, -61, -93, ISO7816.INS_READ_RECORD_STAMPED, 30, CVCAFile.CAR_TAG, 58, 107, 40, 84, -6, ISOFileInfo.PROP_INFO, 61, -70, 43, 121, 10, 21, -101, -97, 94, ISO7816.INS_GET_DATA, 78, -44, -84, -27, -13, 115, -89, 87, -81, 88, -88, 80, -12, -22, ISO7816.INS_UPDATE_BINARY, 116, 79, -82, -23, -43, -25, -26, -83, -24, ISO7816.INS_UNBLOCK_CHV, -41, 117, 122, -21, 22, 11, -11, 89, -53, 95, ISO7816.INS_READ_BINARY, -100, -87, 81, ISOFileInfo.A0, Ascii.DEL, 12, -10, ISOFileInfo.FCI_BYTE, 23, -60, 73, -20, ISO7816.INS_LOAD_KEY_FILE, 67, Ascii.US, Framer.STDIN_FRAME_PREFIX, -92, 118, 123, -73, -52, -69, 62, 90, -5, 96, ISO7816.INS_READ_BINARY2, -122, 59, 82, ISOFileInfo.A1, 108, -86, 85, 41, -99, -105, -78, ISOFileInfo.FCI_EXT, -112, 97, -66, ISO7816.INS_UPDATE_RECORD, -4, PSSSigner.TRAILER_IMPLICIT, -107, -49, -51, 55, Utf8.REPLACEMENT_BYTE, 91, -47, 83, 57, -124, 60, 65, -94, 109, 71, 20, ISO7816.INS_PSO, -98, 93, 86, -14, -45, ISOFileInfo.AB, ISO7816.INS_REHABILITATE_CHV, 17, -110, -39, 35, 32, 46, -119, ISO7816.INS_READ_BINARY_STAMPED, 124, -72, 38, 119, -103, -29, ISOFileInfo.A5, 103, 74, -19, -34, -59, Framer.STDOUT_FRAME_PREFIX, -2, Ascii.CAN, 13, 99, ISOFileInfo.SECURITY_ATTR_COMPACT, Byte.MIN_VALUE, ISO7816.INS_GET_RESPONSE, -9, ISO7816.INS_MANAGE_CHANNEL, 7};
    private static final int[] rcon = {1, 2, 4, 8, 16, 32, 64, 128, 27, 54, 108, 216, 171, 77, 154, 47, 94, 188, 99, 198, 151, 53, 106, 212, 179, 125, 250, TwitterApiConstants.Errors.GUEST_AUTH_ERROR_CODE, 197, 145};
    public static byte[][] shifts0 = {new byte[]{0, 8, 16, Ascii.CAN}, new byte[]{0, 8, 16, Ascii.CAN}, new byte[]{0, 8, 16, Ascii.CAN}, new byte[]{0, 8, 16, 32}, new byte[]{0, 8, Ascii.CAN, 32}};
    public static byte[][] shifts1 = {new byte[]{0, Ascii.CAN, 16, 8}, new byte[]{0, 32, Ascii.CAN, 16}, new byte[]{0, 40, 32, Ascii.CAN}, new byte[]{0, ISO7816.INS_DECREASE, 40, Ascii.CAN}, new byte[]{0, 56, 40, 32}};
    private long A0;
    private long A1;
    private long A2;
    private long A3;
    private int BC;
    private long BC_MASK;
    private int ROUNDS;
    private int blockBits;
    private boolean forEncryption;
    private byte[] shifts0SC;
    private byte[] shifts1SC;
    private long[][] workingKey;

    public RijndaelEngine() {
        this(128);
    }

    public RijndaelEngine(int i11) {
        if (i11 == 128) {
            this.BC = 32;
            this.BC_MASK = 4294967295L;
            this.shifts0SC = shifts0[0];
            this.shifts1SC = shifts1[0];
        } else if (i11 == 160) {
            this.BC = 40;
            this.BC_MASK = 1099511627775L;
            this.shifts0SC = shifts0[1];
            this.shifts1SC = shifts1[1];
        } else if (i11 == 192) {
            this.BC = 48;
            this.BC_MASK = d.f40278e;
            this.shifts0SC = shifts0[2];
            this.shifts1SC = shifts1[2];
        } else if (i11 == 224) {
            this.BC = 56;
            this.BC_MASK = 72057594037927935L;
            this.shifts0SC = shifts0[3];
            this.shifts1SC = shifts1[3];
        } else if (i11 == 256) {
            this.BC = 64;
            this.BC_MASK = -1;
            this.shifts0SC = shifts0[4];
            this.shifts1SC = shifts1[4];
        } else {
            throw new IllegalArgumentException("unknown blocksize to Rijndael");
        }
        this.blockBits = i11;
    }

    private void InvMixColumn() {
        long j11 = 0;
        long j12 = 0;
        long j13 = 0;
        long j14 = 0;
        for (int i11 = 0; i11 < this.BC; i11 += 8) {
            int i12 = (int) ((this.A0 >> i11) & 255);
            int i13 = (int) ((this.A1 >> i11) & 255);
            int i14 = (int) ((this.A2 >> i11) & 255);
            long j15 = j13;
            int i15 = (int) ((this.A3 >> i11) & 255);
            byte b11 = -1;
            byte b12 = i12 != 0 ? logtable[i12 & 255] & 255 : -1;
            byte b13 = i13 != 0 ? logtable[i13 & 255] & 255 : -1;
            byte b14 = i14 != 0 ? logtable[i14 & 255] & 255 : -1;
            if (i15 != 0) {
                b11 = logtable[i15 & 255] & 255;
            }
            j11 |= ((long) ((((mul0xe(b12) ^ mul0xb(b13)) ^ mul0xd(b14)) ^ mul0x9(b11)) & 255)) << i11;
            j14 |= ((long) ((((mul0xe(b13) ^ mul0xb(b14)) ^ mul0xd(b11)) ^ mul0x9(b12)) & 255)) << i11;
            j12 |= ((long) ((((mul0xe(b14) ^ mul0xb(b11)) ^ mul0xd(b12)) ^ mul0x9(b13)) & 255)) << i11;
            j13 = (((long) ((((mul0xe(b11) ^ mul0xb(b12)) ^ mul0xd(b13)) ^ mul0x9(b14)) & 255)) << i11) | j15;
        }
        this.A0 = j11;
        this.A1 = j14;
        this.A2 = j12;
        this.A3 = j13;
    }

    private void KeyAddition(long[] jArr) {
        this.A0 ^= jArr[0];
        this.A1 ^= jArr[1];
        this.A2 ^= jArr[2];
        this.A3 ^= jArr[3];
    }

    private void MixColumn() {
        long j11 = 0;
        long j12 = 0;
        long j13 = 0;
        long j14 = 0;
        for (int i11 = 0; i11 < this.BC; i11 += 8) {
            int i12 = (int) ((this.A0 >> i11) & 255);
            int i13 = (int) ((this.A1 >> i11) & 255);
            int i14 = (int) ((this.A2 >> i11) & 255);
            long j15 = j13;
            int i15 = (int) ((this.A3 >> i11) & 255);
            j11 |= ((long) ((((mul0x2(i12) ^ mul0x3(i13)) ^ i14) ^ i15) & 255)) << i11;
            j14 |= ((long) ((((mul0x2(i13) ^ mul0x3(i14)) ^ i15) ^ i12) & 255)) << i11;
            j12 |= ((long) ((((mul0x2(i14) ^ mul0x3(i15)) ^ i12) ^ i13) & 255)) << i11;
            j13 = (((long) ((((mul0x2(i15) ^ mul0x3(i12)) ^ i13) ^ i14) & 255)) << i11) | j15;
        }
        this.A0 = j11;
        this.A1 = j14;
        this.A2 = j12;
        this.A3 = j13;
    }

    private void ShiftRow(byte[] bArr) {
        this.A1 = shift(this.A1, bArr[1]);
        this.A2 = shift(this.A2, bArr[2]);
        this.A3 = shift(this.A3, bArr[3]);
    }

    private void Substitution(byte[] bArr) {
        this.A0 = applyS(this.A0, bArr);
        this.A1 = applyS(this.A1, bArr);
        this.A2 = applyS(this.A2, bArr);
        this.A3 = applyS(this.A3, bArr);
    }

    private long applyS(long j11, byte[] bArr) {
        long j12 = 0;
        for (int i11 = 0; i11 < this.BC; i11 += 8) {
            j12 |= ((long) (bArr[(int) ((j11 >> i11) & 255)] & 255)) << i11;
        }
        return j12;
    }

    private void decryptBlock(long[][] jArr) {
        KeyAddition(jArr[this.ROUNDS]);
        Substitution(Si);
        ShiftRow(this.shifts1SC);
        for (int i11 = this.ROUNDS - 1; i11 > 0; i11--) {
            KeyAddition(jArr[i11]);
            InvMixColumn();
            Substitution(Si);
            ShiftRow(this.shifts1SC);
        }
        KeyAddition(jArr[0]);
    }

    private void encryptBlock(long[][] jArr) {
        KeyAddition(jArr[0]);
        for (int i11 = 1; i11 < this.ROUNDS; i11++) {
            Substitution(S);
            ShiftRow(this.shifts0SC);
            MixColumn();
            KeyAddition(jArr[i11]);
        }
        Substitution(S);
        ShiftRow(this.shifts0SC);
        KeyAddition(jArr[this.ROUNDS]);
    }

    private long[][] generateWorkingKey(byte[] bArr) {
        int i11;
        int i12;
        byte[] bArr2 = bArr;
        int i13 = 8;
        int length = bArr2.length * 8;
        byte[][] bArr3 = (byte[][]) Array.newInstance(byte.class, new int[]{4, 64});
        long[][] jArr = (long[][]) Array.newInstance(long.class, new int[]{15, 4});
        int i14 = 4;
        if (length == 128) {
            i11 = 4;
        } else if (length == 160) {
            i11 = 5;
        } else if (length == 192) {
            i11 = 6;
        } else if (length == 224) {
            i11 = 7;
        } else if (length == 256) {
            i11 = 8;
        } else {
            throw new IllegalArgumentException("Key length not 128/160/192/224/256 bits.");
        }
        this.ROUNDS = length >= this.blockBits ? i11 + 6 : (this.BC / 8) + 6;
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        while (i16 < bArr2.length) {
            bArr3[i16 % 4][i16 / 4] = bArr2[i17];
            i16++;
            i17++;
        }
        int i18 = 0;
        int i19 = 0;
        while (i18 < i11 && i19 < (this.ROUNDS + 1) * (this.BC / 8)) {
            int i21 = 0;
            while (i21 < i14) {
                int i22 = this.BC;
                long[] jArr2 = jArr[i19 / (i22 / 8)];
                jArr2[i21] = (((long) (bArr3[i21][i18] & 255)) << ((i19 * 8) % i22)) | jArr2[i21];
                i21++;
                i14 = 4;
            }
            i18++;
            i19++;
            i14 = 4;
        }
        int i23 = 0;
        while (i19 < (this.ROUNDS + 1) * (this.BC / i13)) {
            int i24 = i15;
            while (i24 < 4) {
                byte[] bArr4 = bArr3[i24];
                i24++;
                bArr4[i15] = (byte) (bArr4[i15] ^ S[bArr3[i24 % 4][i11 - 1] & 255]);
            }
            byte[] bArr5 = bArr3[i15];
            int i25 = i23 + 1;
            bArr5[i15] = (byte) (rcon[i23] ^ bArr5[i15]);
            int i26 = 1;
            if (i11 <= 6) {
                while (i26 < i11) {
                    for (int i27 = i15; i27 < 4; i27++) {
                        byte[] bArr6 = bArr3[i27];
                        bArr6[i26] = (byte) (bArr6[i26] ^ bArr3[i27][i26 - 1]);
                    }
                    i26++;
                }
            } else {
                while (true) {
                    i12 = 4;
                    if (i26 >= 4) {
                        break;
                    }
                    int i28 = i15;
                    while (i28 < i12) {
                        byte[] bArr7 = bArr3[i28];
                        bArr7[i26] = (byte) (bArr7[i26] ^ bArr3[i28][i26 - 1]);
                        i28++;
                        i12 = 4;
                    }
                    i26++;
                }
                for (int i29 = i15; i29 < 4; i29++) {
                    byte[] bArr8 = bArr3[i29];
                    bArr8[4] = (byte) (bArr8[4] ^ S[bArr3[i29][3] & 255]);
                }
                int i30 = 5;
                while (i30 < i11) {
                    int i31 = i15;
                    while (i31 < i12) {
                        byte[] bArr9 = bArr3[i31];
                        bArr9[i30] = (byte) (bArr9[i30] ^ bArr3[i31][i30 - 1]);
                        i31++;
                        i12 = 4;
                    }
                    i30++;
                    i12 = 4;
                }
            }
            int i32 = i15;
            while (i32 < i11 && i19 < (this.ROUNDS + 1) * (this.BC / i13)) {
                for (int i33 = i15; i33 < 4; i33++) {
                    int i34 = this.BC;
                    long[] jArr3 = jArr[i19 / (i34 / 8)];
                    jArr3[i33] = (((long) (bArr3[i33][i32] & 255)) << ((i19 * 8) % i34)) | jArr3[i33];
                }
                i32++;
                i19++;
                i15 = 0;
                i13 = 8;
            }
            i23 = i25;
            i15 = 0;
            i13 = 8;
        }
        return jArr;
    }

    private byte mul0x2(int i11) {
        if (i11 != 0) {
            return aLogtable[(logtable[i11] & 255) + Ascii.EM];
        }
        return 0;
    }

    private byte mul0x3(int i11) {
        if (i11 != 0) {
            return aLogtable[(logtable[i11] & 255) + 1];
        }
        return 0;
    }

    private byte mul0x9(int i11) {
        if (i11 >= 0) {
            return aLogtable[i11 + 199];
        }
        return 0;
    }

    private byte mul0xb(int i11) {
        if (i11 >= 0) {
            return aLogtable[i11 + 104];
        }
        return 0;
    }

    private byte mul0xd(int i11) {
        if (i11 >= 0) {
            return aLogtable[i11 + 238];
        }
        return 0;
    }

    private byte mul0xe(int i11) {
        if (i11 >= 0) {
            return aLogtable[i11 + 223];
        }
        return 0;
    }

    private void packBlock(byte[] bArr, int i11) {
        for (int i12 = 0; i12 != this.BC; i12 += 8) {
            int i13 = i11 + 1;
            bArr[i11] = (byte) ((int) (this.A0 >> i12));
            int i14 = i13 + 1;
            bArr[i13] = (byte) ((int) (this.A1 >> i12));
            int i15 = i14 + 1;
            bArr[i14] = (byte) ((int) (this.A2 >> i12));
            i11 = i15 + 1;
            bArr[i15] = (byte) ((int) (this.A3 >> i12));
        }
    }

    private long shift(long j11, int i11) {
        return ((j11 << (this.BC - i11)) | (j11 >>> i11)) & this.BC_MASK;
    }

    private void unpackBlock(byte[] bArr, int i11) {
        int i12 = i11 + 1;
        this.A0 = (long) (bArr[i11] & 255);
        int i13 = i12 + 1;
        this.A1 = (long) (bArr[i12] & 255);
        int i14 = i13 + 1;
        this.A2 = (long) (bArr[i13] & 255);
        int i15 = i14 + 1;
        this.A3 = (long) (bArr[i14] & 255);
        for (int i16 = 8; i16 != this.BC; i16 += 8) {
            int i17 = i15 + 1;
            this.A0 |= ((long) (bArr[i15] & 255)) << i16;
            int i18 = i17 + 1;
            this.A1 |= ((long) (bArr[i17] & 255)) << i16;
            int i19 = i18 + 1;
            this.A2 |= ((long) (bArr[i18] & 255)) << i16;
            i15 = i19 + 1;
            this.A3 |= ((long) (bArr[i19] & 255)) << i16;
        }
    }

    public String getAlgorithmName() {
        return "Rijndael";
    }

    public int getBlockSize() {
        return this.BC / 2;
    }

    public void init(boolean z11, CipherParameters cipherParameters) {
        if (cipherParameters instanceof KeyParameter) {
            this.workingKey = generateWorkingKey(((KeyParameter) cipherParameters).getKey());
            this.forEncryption = z11;
            return;
        }
        throw new IllegalArgumentException("invalid parameter passed to Rijndael init - " + cipherParameters.getClass().getName());
    }

    public int processBlock(byte[] bArr, int i11, byte[] bArr2, int i12) {
        if (this.workingKey != null) {
            int i13 = this.BC;
            if ((i13 / 2) + i11 > bArr.length) {
                throw new DataLengthException("input buffer too short");
            } else if ((i13 / 2) + i12 <= bArr2.length) {
                boolean z11 = this.forEncryption;
                unpackBlock(bArr, i11);
                long[][] jArr = this.workingKey;
                if (z11) {
                    encryptBlock(jArr);
                } else {
                    decryptBlock(jArr);
                }
                packBlock(bArr2, i12);
                return this.BC / 2;
            } else {
                throw new OutputLengthException("output buffer too short");
            }
        } else {
            throw new IllegalStateException("Rijndael engine not initialised");
        }
    }

    public void reset() {
    }
}
