package org.bouncycastle.crypto.engines;

import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import net.sf.scuba.smartcards.ISO7816;
import net.sf.scuba.smartcards.ISOFileInfo;
import okio.Utf8;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.signers.PSSSigner;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Pack;
import org.jmrtd.lds.CVCAFile;

public class DSTU7624Engine implements BlockCipher {
    private static final int ROUNDS_128 = 10;
    private static final int ROUNDS_256 = 14;
    private static final int ROUNDS_512 = 18;
    private static final byte[] S0 = {-88, 67, 95, 6, 107, 117, 108, 89, 113, -33, ISOFileInfo.FCI_EXT, -107, 23, -16, ISO7816.INS_LOAD_KEY_FILE, 9, 109, -13, 29, -53, -55, 77, ISO7816.INS_UNBLOCK_CHV, -81, 121, ISO7816.INS_CREATE_FILE, -105, -3, ISOFileInfo.FCI_BYTE, 75, 69, 57, 62, -35, -93, 79, ISO7816.INS_READ_BINARY_STAMPED, ISO7816.INS_READ_RECORD_STAMPED, -102, 14, Ascii.US, -65, 21, -31, 73, ISO7816.INS_WRITE_RECORD, -109, -58, -110, 114, -98, 97, -47, 99, -6, -18, -12, Ascii.EM, -43, -83, 88, -92, -69, ISOFileInfo.A1, ISO7816.INS_UPDATE_RECORD, -14, ISOFileInfo.FILE_IDENTIFIER, 55, CVCAFile.CAR_TAG, ISO7816.INS_DELETE_FILE, 122, 50, -100, -52, ISOFileInfo.AB, 74, -113, 110, 4, 39, 46, -25, ISO7816.INS_APPEND_RECORD, 90, -106, 22, 35, 43, ISO7816.INS_ENVELOPE, 101, 102, 15, PSSSigner.TRAILER_IMPLICIT, -87, 71, 65, ISO7816.INS_DECREASE_STAMPED, 72, -4, -73, 106, -120, ISOFileInfo.A5, 83, -122, -7, 91, -37, 56, 123, -61, 30, ISO7816.INS_MSE, 51, ISO7816.INS_CHANGE_CHV, 40, 54, -57, -78, 59, ISOFileInfo.CHANNEL_SECURITY, 119, -70, -11, 20, -97, 8, 85, -101, 76, -2, 96, 92, ISO7816.INS_PUT_DATA, Ascii.CAN, 70, -51, 125, Framer.ENTER_FRAME_PREFIX, ISO7816.INS_READ_BINARY, Utf8.REPLACEMENT_BYTE, Ascii.ESC, -119, -1, -21, -124, 105, 58, -99, -41, -45, ISO7816.INS_MANAGE_CHANNEL, 103, SignedBytes.MAX_POWER_OF_TWO, -75, -34, 93, ISO7816.INS_DECREASE, -111, ISO7816.INS_READ_BINARY2, Framer.EXIT_FRAME_PREFIX, 17, 1, -27, 0, 104, -104, ISOFileInfo.A0, -59, 2, -90, 116, Framer.STDIN_FRAME_PREFIX, 11, -94, 118, ISO7816.INS_READ_RECORD2, -66, -50, -67, -82, -23, ISOFileInfo.LCS_BYTE, Framer.STDOUT_FRAME_PREFIX, 28, -20, -15, -103, -108, -86, -10, 38, 47, -17, -24, ISOFileInfo.SECURITY_ATTR_COMPACT, 53, 3, -44, Ascii.DEL, -5, 5, -63, 94, -112, 32, 61, -126, -9, -22, 10, 13, 126, -8, 80, Ascii.SUB, -60, 7, 87, -72, 60, ISOFileInfo.FCP_BYTE, -29, -56, -84, 82, 100, 16, ISO7816.INS_WRITE_BINARY, -39, 19, 12, 18, 41, 81, -71, -49, ISO7816.INS_UPDATE_BINARY, 115, ISOFileInfo.ENV_TEMP_EF, ISOFileInfo.DATA_BYTES2, 84, ISO7816.INS_GET_RESPONSE, -19, 78, ISO7816.INS_REHABILITATE_CHV, -89, ISO7816.INS_PSO, ISOFileInfo.PROP_INFO, 37, -26, ISO7816.INS_GET_DATA, 124, ISOFileInfo.SECURITY_ATTR_EXP, 86, Byte.MIN_VALUE};
    private static final byte[] S1 = {-50, -69, -21, -110, -22, -53, 19, -63, -23, 58, ISO7816.INS_UPDATE_BINARY, -78, ISO7816.INS_WRITE_RECORD, -112, 23, -8, CVCAFile.CAR_TAG, 21, 86, ISO7816.INS_READ_BINARY_STAMPED, 101, 28, -120, 67, -59, 92, 54, -70, -11, 87, 103, ISOFileInfo.ENV_TEMP_EF, Framer.STDOUT_FRAME_PREFIX, -10, 100, 88, -98, -12, ISO7816.INS_MSE, -86, 117, 15, 2, ISO7816.INS_READ_BINARY2, -33, 109, 115, 77, 124, 38, 46, -9, 8, 93, ISO7816.INS_REHABILITATE_CHV, 62, -97, 20, -56, -82, 84, 16, ISO7816.INS_LOAD_KEY_FILE, PSSSigner.TRAILER_IMPLICIT, Ascii.SUB, 107, 105, -13, -67, 51, ISOFileInfo.AB, -6, -47, -101, 104, 78, 22, -107, -111, -18, 76, 99, ISOFileInfo.CHANNEL_SECURITY, 91, -52, 60, Ascii.EM, ISOFileInfo.A1, ISOFileInfo.DATA_BYTES2, 73, 123, -39, ISOFileInfo.FCI_BYTE, 55, 96, ISO7816.INS_GET_DATA, -25, 43, 72, -3, -106, 69, -4, 65, 18, 13, 121, -27, -119, ISOFileInfo.SECURITY_ATTR_COMPACT, -29, 32, ISO7816.INS_DECREASE, ISO7816.INS_UPDATE_RECORD, -73, 108, 74, -75, Utf8.REPLACEMENT_BYTE, -105, -44, ISOFileInfo.FCP_BYTE, Framer.STDIN_FRAME_PREFIX, 6, -92, ISOFileInfo.A5, ISOFileInfo.FILE_IDENTIFIER, 95, ISO7816.INS_PSO, ISO7816.INS_PUT_DATA, -55, 0, 126, -94, 85, -65, 17, -43, -100, -49, 14, 10, 61, 81, 125, -109, Ascii.ESC, -2, -60, 71, 9, -122, 11, -113, -99, 106, 7, -71, ISO7816.INS_READ_BINARY, -104, Ascii.CAN, 50, 113, 75, -17, 59, ISO7816.INS_MANAGE_CHANNEL, ISOFileInfo.A0, ISO7816.INS_DELETE_FILE, SignedBytes.MAX_POWER_OF_TWO, -1, -61, -87, -26, Framer.EXIT_FRAME_PREFIX, -7, ISOFileInfo.SECURITY_ATTR_EXP, 70, Byte.MIN_VALUE, 30, 56, -31, -72, -88, ISO7816.INS_CREATE_FILE, 12, 35, 118, 29, 37, ISO7816.INS_CHANGE_CHV, 5, -15, 110, -108, 40, -102, -124, -24, -93, 79, 119, -45, ISOFileInfo.PROP_INFO, ISO7816.INS_APPEND_RECORD, 82, -14, -126, 80, 122, 47, 116, 83, ISO7816.INS_READ_RECORD2, 97, -81, 57, 53, -34, -51, Ascii.US, -103, -84, -83, 114, ISO7816.INS_UNBLOCK_CHV, -35, ISO7816.INS_WRITE_BINARY, ISOFileInfo.FCI_EXT, -66, 94, -90, -20, 4, -58, 3, ISO7816.INS_DECREASE_STAMPED, -5, -37, 89, ISO7816.INS_READ_RECORD_STAMPED, ISO7816.INS_ENVELOPE, 1, -16, 90, -19, -89, 102, Framer.ENTER_FRAME_PREFIX, Ascii.DEL, ISOFileInfo.LCS_BYTE, 39, -57, ISO7816.INS_GET_RESPONSE, 41, -41};
    private static final byte[] S2 = {-109, -39, -102, -75, -104, ISO7816.INS_MSE, 69, -4, -70, 106, -33, 2, -97, ISO7816.INS_UPDATE_RECORD, 81, 89, 74, 23, 43, ISO7816.INS_ENVELOPE, -108, -12, -69, -93, ISOFileInfo.FCP_BYTE, ISO7816.INS_DELETE_FILE, 113, -44, -51, ISO7816.INS_MANAGE_CHANNEL, 22, -31, 73, 60, ISO7816.INS_GET_RESPONSE, ISO7816.INS_LOAD_KEY_FILE, 92, -101, -83, ISOFileInfo.PROP_INFO, 83, ISOFileInfo.A1, 122, -56, Framer.STDIN_FRAME_PREFIX, ISO7816.INS_CREATE_FILE, -47, 114, -90, ISO7816.INS_UNBLOCK_CHV, -60, -29, 118, Framer.EXIT_FRAME_PREFIX, -73, ISO7816.INS_READ_BINARY_STAMPED, 9, 59, 14, 65, 76, -34, -78, -112, 37, ISOFileInfo.A5, -41, 3, 17, 0, -61, 46, -110, -17, 78, 18, -99, 125, -53, 53, 16, -43, 79, -98, 77, -87, 85, -58, ISO7816.INS_WRITE_BINARY, 123, Ascii.CAN, -105, -45, 54, -26, 72, 86, ISOFileInfo.DATA_BYTES2, -113, 119, -52, -100, -71, ISO7816.INS_APPEND_RECORD, -84, -72, 47, 21, -92, 124, ISO7816.INS_PUT_DATA, 56, 30, 11, 5, ISO7816.INS_UPDATE_BINARY, 20, 110, 108, 126, 102, -3, ISO7816.INS_READ_BINARY2, -27, 96, -81, 94, 51, ISOFileInfo.FCI_EXT, -55, -16, 93, 109, Utf8.REPLACEMENT_BYTE, -120, ISOFileInfo.ENV_TEMP_EF, -57, -9, 29, -23, -20, -19, Byte.MIN_VALUE, 41, 39, -49, -103, -88, 80, 15, 55, ISO7816.INS_CHANGE_CHV, 40, ISO7816.INS_DECREASE, -107, ISO7816.INS_WRITE_RECORD, 62, 91, SignedBytes.MAX_POWER_OF_TWO, ISOFileInfo.FILE_IDENTIFIER, ISO7816.INS_READ_RECORD2, 105, 87, Ascii.US, 7, 28, ISOFileInfo.LCS_BYTE, PSSSigner.TRAILER_IMPLICIT, 32, -21, -50, ISOFileInfo.CHANNEL_SECURITY, ISOFileInfo.AB, -18, Framer.STDOUT_FRAME_PREFIX, -94, 115, -7, ISO7816.INS_GET_DATA, 58, Ascii.SUB, -5, 13, -63, -2, -6, -14, ISOFileInfo.FCI_BYTE, -67, -106, -35, 67, 82, ISO7816.INS_READ_RECORD_STAMPED, 8, -13, -82, -66, Ascii.EM, -119, 50, 38, ISO7816.INS_READ_BINARY, -22, 75, 100, -124, -126, 107, -11, 121, -65, 1, 95, 117, 99, Ascii.ESC, 35, 61, 104, ISO7816.INS_PSO, 101, -24, -111, -10, -1, 19, 88, -15, 71, 10, Ascii.DEL, -59, -89, -25, 97, 90, 6, 70, ISO7816.INS_REHABILITATE_CHV, CVCAFile.CAR_TAG, 4, ISOFileInfo.A0, -37, 57, -122, 84, -86, ISOFileInfo.SECURITY_ATTR_COMPACT, ISO7816.INS_DECREASE_STAMPED, Framer.ENTER_FRAME_PREFIX, ISOFileInfo.SECURITY_ATTR_EXP, -8, 12, 116, 103};
    private static final byte[] S3 = {104, ISOFileInfo.ENV_TEMP_EF, ISO7816.INS_GET_DATA, 77, 115, 75, 78, ISO7816.INS_PSO, -44, 82, 38, ISO7816.INS_READ_RECORD2, 84, 30, Ascii.EM, Ascii.US, ISO7816.INS_MSE, 3, 70, 61, Framer.STDIN_FRAME_PREFIX, 74, 83, ISOFileInfo.FILE_IDENTIFIER, 19, ISOFileInfo.LCS_BYTE, -73, -43, 37, 121, -11, -67, 88, 47, 13, 2, -19, 81, -98, 17, -14, 62, 85, 94, -47, 22, 60, 102, ISO7816.INS_MANAGE_CHANNEL, 93, -13, 69, SignedBytes.MAX_POWER_OF_TWO, -52, -24, -108, 86, 8, -50, Ascii.SUB, 58, ISO7816.INS_WRITE_RECORD, -31, -33, -75, 56, 110, 14, -27, -12, -7, -122, -23, 79, ISO7816.INS_UPDATE_BINARY, ISOFileInfo.PROP_INFO, 35, -49, 50, -103, Framer.STDOUT_FRAME_PREFIX, 20, -82, -18, -56, 72, -45, ISO7816.INS_DECREASE, ISOFileInfo.A1, -110, 65, ISO7816.INS_READ_BINARY2, Ascii.CAN, -60, ISO7816.INS_UNBLOCK_CHV, 113, 114, ISO7816.INS_REHABILITATE_CHV, 21, -3, 55, -66, 95, -86, -101, -120, ISO7816.INS_LOAD_KEY_FILE, ISOFileInfo.AB, -119, -100, -6, 96, -22, PSSSigner.TRAILER_IMPLICIT, ISOFileInfo.FCP_BYTE, 12, ISO7816.INS_CHANGE_CHV, -90, -88, -20, 103, 32, -37, 124, 40, -35, -84, 91, ISO7816.INS_DECREASE_STAMPED, 126, 16, -15, 123, -113, 99, ISOFileInfo.A0, 5, -102, 67, 119, Framer.ENTER_FRAME_PREFIX, -65, 39, 9, -61, -97, ISO7816.INS_READ_RECORD_STAMPED, -41, 41, ISO7816.INS_ENVELOPE, -21, ISO7816.INS_GET_RESPONSE, -92, ISOFileInfo.SECURITY_ATTR_EXP, ISOFileInfo.SECURITY_ATTR_COMPACT, 29, -5, -1, -63, -78, -105, 46, -8, 101, -10, 117, 7, 4, 73, 51, ISO7816.INS_DELETE_FILE, -39, -71, ISO7816.INS_WRITE_BINARY, CVCAFile.CAR_TAG, -57, 108, -112, 0, ISOFileInfo.CHANNEL_SECURITY, ISOFileInfo.FCI_BYTE, 80, 1, -59, ISO7816.INS_PUT_DATA, 71, Utf8.REPLACEMENT_BYTE, -51, 105, -94, ISO7816.INS_APPEND_RECORD, 122, -89, -58, -109, 15, 10, 6, -26, 43, -106, -93, 28, -81, 106, 18, -124, 57, -25, ISO7816.INS_READ_BINARY, -126, -9, -2, -99, ISOFileInfo.FCI_EXT, 92, ISOFileInfo.DATA_BYTES2, 53, -34, ISO7816.INS_READ_BINARY_STAMPED, ISOFileInfo.A5, -4, Byte.MIN_VALUE, -17, -53, -69, 107, 118, -70, 90, 125, Framer.EXIT_FRAME_PREFIX, 11, -107, -29, -83, 116, -104, 59, 54, 100, 109, ISO7816.INS_UPDATE_RECORD, -16, 89, -87, 76, 23, Ascii.DEL, -111, -72, -55, 87, Ascii.ESC, ISO7816.INS_CREATE_FILE, 97};
    private static final byte[] T0 = {-92, -94, -87, -59, 78, -55, 3, -39, 126, 15, ISO7816.INS_WRITE_RECORD, -83, -25, -45, 39, 91, -29, ISOFileInfo.A1, -24, -26, 124, ISO7816.INS_PSO, 85, 12, -122, 57, -41, ISOFileInfo.ENV_TEMP_EF, -72, 18, ISOFileInfo.FCI_BYTE, 40, -51, ISOFileInfo.LCS_BYTE, ISO7816.INS_MANAGE_CHANNEL, 86, 114, -7, -65, 79, 115, -23, -9, 87, 22, -84, 80, ISO7816.INS_GET_RESPONSE, -99, -73, 71, 113, 96, -60, 116, 67, 108, Ascii.US, -109, 119, ISO7816.INS_UPDATE_RECORD, -50, 32, ISOFileInfo.SECURITY_ATTR_COMPACT, -103, 95, ISO7816.INS_REHABILITATE_CHV, 1, -11, 30, ISOFileInfo.FCI_EXT, 94, 97, ISO7816.INS_UNBLOCK_CHV, 75, 29, ISOFileInfo.DATA_BYTES2, 21, -12, 35, ISO7816.INS_UPDATE_BINARY, -22, -31, 103, -15, Ascii.DEL, -2, ISO7816.INS_PUT_DATA, 60, 7, 83, 106, -124, -100, -53, 2, ISOFileInfo.FILE_IDENTIFIER, 51, -35, 53, ISO7816.INS_APPEND_RECORD, 89, 90, -104, ISOFileInfo.A5, -110, 100, 4, 6, 16, 77, 28, -105, 8, Framer.STDOUT_FRAME_PREFIX, -18, ISOFileInfo.AB, 5, -81, 121, ISOFileInfo.A0, Ascii.CAN, 70, 109, -4, -119, -44, -57, -1, -16, -49, CVCAFile.CAR_TAG, -111, -8, 104, 10, 101, ISOFileInfo.CHANNEL_SECURITY, ISO7816.INS_READ_RECORD_STAMPED, -3, -61, -17, Framer.EXIT_FRAME_PREFIX, 76, -52, -98, ISO7816.INS_DECREASE, 46, PSSSigner.TRAILER_IMPLICIT, 11, 84, Ascii.SUB, -90, -69, 38, Byte.MIN_VALUE, 72, -108, 50, 125, -89, Utf8.REPLACEMENT_BYTE, -82, ISO7816.INS_MSE, 61, 102, -86, -10, 0, 93, -67, 74, ISO7816.INS_CREATE_FILE, 59, ISO7816.INS_READ_BINARY_STAMPED, 23, ISOFileInfo.SECURITY_ATTR_EXP, -97, 118, ISO7816.INS_READ_BINARY, ISO7816.INS_CHANGE_CHV, -102, 37, 99, -37, -21, 122, 62, 92, ISO7816.INS_READ_RECORD2, ISO7816.INS_READ_BINARY2, 41, -14, ISO7816.INS_GET_DATA, 88, 110, ISO7816.INS_LOAD_KEY_FILE, -88, 47, 117, -33, 20, -5, 19, 73, -120, -78, -20, ISO7816.INS_DELETE_FILE, ISO7816.INS_DECREASE_STAMPED, Framer.STDIN_FRAME_PREFIX, -106, -58, 58, -19, -107, 14, -27, ISOFileInfo.PROP_INFO, 107, SignedBytes.MAX_POWER_OF_TWO, Framer.ENTER_FRAME_PREFIX, -101, 9, Ascii.EM, 43, 82, -34, 69, -93, -6, 81, ISO7816.INS_ENVELOPE, -75, -47, -112, -71, -13, 55, -63, 13, -70, 65, 17, 56, 123, -66, ISO7816.INS_WRITE_BINARY, -43, 105, 54, -56, ISOFileInfo.FCP_BYTE, Ascii.ESC, -126, -113};
    private static final byte[] T1 = {ISOFileInfo.FILE_IDENTIFIER, -14, ISO7816.INS_PSO, -21, -23, -65, 123, -100, ISO7816.INS_DECREASE_STAMPED, -106, ISOFileInfo.ENV_TEMP_EF, -104, -71, 105, ISOFileInfo.SECURITY_ATTR_COMPACT, 41, 61, -120, 104, 6, 57, 17, 76, 14, ISOFileInfo.A0, 86, SignedBytes.MAX_POWER_OF_TWO, -110, 21, PSSSigner.TRAILER_IMPLICIT, ISO7816.INS_READ_RECORD2, ISO7816.INS_UPDATE_RECORD, ISOFileInfo.FCI_BYTE, -8, 38, -70, -66, -67, Framer.STDOUT_FRAME_PREFIX, -5, -61, -2, Byte.MIN_VALUE, 97, -31, 122, 50, ISO7816.INS_WRITE_RECORD, ISO7816.INS_MANAGE_CHANNEL, 32, ISOFileInfo.A1, 69, -20, -39, Ascii.SUB, 93, ISO7816.INS_READ_BINARY_STAMPED, ISO7816.INS_LOAD_KEY_FILE, 9, ISOFileInfo.A5, 85, ISOFileInfo.CHANNEL_SECURITY, 55, 118, -87, 103, 16, 23, 54, 101, ISO7816.INS_READ_BINARY2, -107, ISOFileInfo.FCP_BYTE, 89, 116, -93, 80, 47, 75, -56, ISO7816.INS_WRITE_BINARY, -113, -51, -44, 60, -122, 18, 29, 35, -17, -12, 83, Ascii.EM, 53, -26, Ascii.DEL, 94, ISO7816.INS_UPDATE_BINARY, 121, 81, ISO7816.INS_MSE, 20, -9, 30, 74, CVCAFile.CAR_TAG, -101, 65, 115, Framer.STDIN_FRAME_PREFIX, -63, 92, -90, -94, ISO7816.INS_CREATE_FILE, 46, -45, 40, -69, -55, -82, 106, -47, 90, ISO7816.INS_DECREASE, -112, -124, -7, -78, 88, -49, 126, -59, -53, -105, ISO7816.INS_DELETE_FILE, 22, 108, -6, ISO7816.INS_READ_BINARY, 109, Ascii.US, 82, -103, 13, 78, 3, -111, ISO7816.INS_ENVELOPE, 77, 100, 119, -97, -35, -60, 73, ISOFileInfo.LCS_BYTE, -102, ISO7816.INS_CHANGE_CHV, 56, -89, 87, ISOFileInfo.PROP_INFO, -57, 124, 125, -25, -10, -73, -84, 39, 70, -34, -33, 59, -41, -98, 43, 11, -43, 19, 117, -16, 114, ISO7816.INS_READ_RECORD_STAMPED, -99, Ascii.ESC, 1, Utf8.REPLACEMENT_BYTE, ISO7816.INS_REHABILITATE_CHV, -27, ISOFileInfo.FCI_EXT, -3, 7, -15, ISOFileInfo.AB, -108, Ascii.CAN, -22, -4, 58, -126, 95, 5, 84, -37, 0, ISOFileInfo.SECURITY_ATTR_EXP, -29, 72, 12, ISO7816.INS_GET_DATA, Framer.EXIT_FRAME_PREFIX, -119, 10, -1, 62, 91, ISOFileInfo.DATA_BYTES2, -18, 113, ISO7816.INS_APPEND_RECORD, ISO7816.INS_PUT_DATA, ISO7816.INS_UNBLOCK_CHV, -72, -75, -52, 110, -88, 107, -83, 96, -58, 8, 4, 2, -24, -11, 79, -92, -13, ISO7816.INS_GET_RESPONSE, -50, 67, 37, 28, Framer.ENTER_FRAME_PREFIX, 51, 15, -81, 71, -19, 102, 99, -109, -86};
    private static final byte[] T2 = {69, -44, 11, 67, -15, 114, -19, -92, ISO7816.INS_ENVELOPE, 56, -26, 113, -3, ISO7816.INS_READ_RECORD_STAMPED, 58, -107, 80, ISO7816.INS_REHABILITATE_CHV, 75, ISO7816.INS_APPEND_RECORD, 116, 107, 30, 17, 90, -58, ISO7816.INS_READ_BINARY_STAMPED, ISO7816.INS_LOAD_KEY_FILE, ISOFileInfo.A5, ISOFileInfo.LCS_BYTE, ISO7816.INS_MANAGE_CHANNEL, -93, -88, -6, 5, -39, -105, SignedBytes.MAX_POWER_OF_TWO, -55, -112, -104, -113, ISO7816.INS_UPDATE_RECORD, 18, Framer.STDOUT_FRAME_PREFIX, ISO7816.INS_UNBLOCK_CHV, 71, 106, -103, -82, -56, Ascii.DEL, -7, 79, 93, -106, ISOFileInfo.FCI_BYTE, -12, ISO7816.INS_READ_RECORD2, 57, Framer.ENTER_FRAME_PREFIX, ISO7816.INS_PUT_DATA, -100, ISOFileInfo.PROP_INFO, -98, 59, -16, -65, -17, 6, -18, -27, 95, 32, 16, -52, 60, 84, 74, 82, -108, 14, ISO7816.INS_GET_RESPONSE, 40, -10, 86, 96, -94, -29, 15, -20, -99, ISO7816.INS_CHANGE_CHV, ISOFileInfo.FILE_IDENTIFIER, 126, -43, 124, -21, Ascii.CAN, -41, -51, -35, Framer.EXIT_FRAME_PREFIX, -1, -37, ISOFileInfo.A1, 9, ISO7816.INS_WRITE_BINARY, 118, -124, 117, -69, 29, Ascii.SUB, 47, ISO7816.INS_READ_BINARY, -2, ISO7816.INS_UPDATE_BINARY, ISO7816.INS_DECREASE_STAMPED, 99, 53, ISO7816.INS_WRITE_RECORD, ISO7816.INS_PSO, 89, 109, 77, 119, -25, ISOFileInfo.CHANNEL_SECURITY, 97, -49, -97, -50, 39, -11, Byte.MIN_VALUE, -122, -57, -90, -5, -8, ISOFileInfo.FCI_EXT, ISOFileInfo.AB, ISOFileInfo.FCP_BYTE, Utf8.REPLACEMENT_BYTE, -33, 72, 0, 20, -102, -67, 91, 4, -110, 2, 37, 101, 76, 83, 12, -14, 41, -81, 23, 108, 65, ISO7816.INS_DECREASE, -23, -109, 85, -9, -84, 104, 38, -60, 125, ISO7816.INS_GET_DATA, 122, 62, ISOFileInfo.A0, 55, 3, -63, 54, 105, 102, 8, 22, -89, PSSSigner.TRAILER_IMPLICIT, -59, -45, ISO7816.INS_MSE, -73, 19, 70, 50, -24, 87, -120, 43, ISOFileInfo.DATA_BYTES2, -78, 78, 100, 28, -86, -111, 88, 46, -101, 92, Ascii.ESC, 81, 115, CVCAFile.CAR_TAG, 35, 1, 110, -13, 13, -66, 61, 10, Framer.STDIN_FRAME_PREFIX, Ascii.US, 103, 51, Ascii.EM, 123, 94, -22, -34, ISOFileInfo.SECURITY_ATTR_EXP, -53, -87, ISOFileInfo.SECURITY_ATTR_COMPACT, ISOFileInfo.ENV_TEMP_EF, -83, 73, -126, ISO7816.INS_DELETE_FILE, -70, -61, 21, -47, ISO7816.INS_CREATE_FILE, -119, -4, ISO7816.INS_READ_BINARY2, -71, -75, 7, 121, -72, -31};
    private static final byte[] T3 = {-78, ISO7816.INS_READ_RECORD_STAMPED, 35, 17, -89, -120, -59, -90, 57, -113, -60, -24, 115, ISO7816.INS_MSE, 67, -61, -126, 39, -51, Ascii.CAN, 81, ISOFileInfo.FCP_BYTE, Framer.STDIN_FRAME_PREFIX, -9, 92, 14, 59, -3, ISO7816.INS_GET_DATA, -101, 13, 15, 121, ISOFileInfo.SECURITY_ATTR_COMPACT, 16, 76, 116, 28, 10, ISOFileInfo.CHANNEL_SECURITY, 124, -108, 7, -57, 94, 20, ISOFileInfo.A1, Framer.ENTER_FRAME_PREFIX, 87, 80, 78, -87, Byte.MIN_VALUE, -39, -17, 100, 65, -49, 60, -18, 46, 19, 41, -70, ISO7816.INS_DECREASE_STAMPED, 90, -82, ISOFileInfo.LCS_BYTE, 97, 51, 18, -71, 85, -88, 21, 5, -10, 3, 6, 73, -75, 37, 9, 22, 12, ISO7816.INS_PSO, 56, -4, 32, -12, -27, Ascii.DEL, -41, Framer.STDOUT_FRAME_PREFIX, 43, 102, ISOFileInfo.FCI_BYTE, -1, 114, -122, -16, -93, 47, Framer.EXIT_FRAME_PREFIX, 0, PSSSigner.TRAILER_IMPLICIT, -52, ISO7816.INS_APPEND_RECORD, ISO7816.INS_READ_BINARY, -15, CVCAFile.CAR_TAG, ISO7816.INS_READ_BINARY_STAMPED, ISO7816.INS_DECREASE, 95, 96, 4, -20, ISOFileInfo.A5, -29, ISOFileInfo.SECURITY_ATTR_EXP, -25, 29, -65, -124, 123, -26, ISOFileInfo.DATA_BYTES2, -8, -34, ISO7816.INS_LOAD_KEY_FILE, ISO7816.INS_WRITE_RECORD, 23, -50, 75, 71, ISO7816.INS_UPDATE_BINARY, 105, 108, Ascii.EM, -103, -102, 1, ISO7816.INS_READ_RECORD2, ISOFileInfo.PROP_INFO, ISO7816.INS_READ_BINARY2, -7, 89, ISO7816.INS_ENVELOPE, 55, -23, -56, ISOFileInfo.A0, -19, 79, -119, 104, 109, -43, 38, -111, ISOFileInfo.FCI_EXT, 88, -67, -55, -104, ISO7816.INS_UPDATE_RECORD, 117, ISO7816.INS_GET_RESPONSE, 118, -11, 103, 107, 126, -21, 82, -53, -47, 91, -97, 11, -37, SignedBytes.MAX_POWER_OF_TWO, -110, Ascii.SUB, -6, -84, ISO7816.INS_DELETE_FILE, -31, 113, Ascii.US, 101, ISOFileInfo.ENV_TEMP_EF, -105, -98, -107, -112, 93, -73, -63, -81, 84, -5, 2, ISO7816.INS_CREATE_FILE, 53, -69, 58, 77, -83, ISO7816.INS_UNBLOCK_CHV, 61, 86, 8, Ascii.ESC, 74, -109, 106, ISOFileInfo.AB, -72, 122, -14, 125, ISO7816.INS_PUT_DATA, Utf8.REPLACEMENT_BYTE, -2, 62, -66, -22, -86, ISO7816.INS_REHABILITATE_CHV, -58, ISO7816.INS_WRITE_BINARY, 54, 72, ISO7816.INS_MANAGE_CHANNEL, -106, 119, ISO7816.INS_CHANGE_CHV, 83, -33, -13, ISOFileInfo.FILE_IDENTIFIER, 40, 50, 69, 30, -92, -45, -94, 70, 110, -100, -35, 99, -44, -99};
    private boolean forEncryption;
    private long[] internalState;
    private long[][] roundKeys;
    private int roundsAmount;
    private int wordsInBlock;
    private int wordsInKey;
    private long[] workingKey;

    public DSTU7624Engine(int i11) throws IllegalArgumentException {
        if (i11 == 128 || i11 == 256 || i11 == 512) {
            int i12 = i11 >>> 6;
            this.wordsInBlock = i12;
            this.internalState = new long[i12];
            return;
        }
        throw new IllegalArgumentException("unsupported block length: only 128/256/512 are allowed");
    }

    private void addRoundKey(int i11) {
        long[] jArr = this.roundKeys[i11];
        for (int i12 = 0; i12 < this.wordsInBlock; i12++) {
            long[] jArr2 = this.internalState;
            jArr2[i12] = jArr2[i12] + jArr[i12];
        }
    }

    private void decryptBlock_128(byte[] bArr, int i11, byte[] bArr2, int i12) {
        byte[] bArr3 = bArr2;
        int i13 = i12;
        long littleEndianToLong = Pack.littleEndianToLong(bArr, i11);
        long littleEndianToLong2 = Pack.littleEndianToLong(bArr, i11 + 8);
        long[][] jArr = this.roundKeys;
        int i14 = this.roundsAmount;
        long[] jArr2 = jArr[i14];
        long j11 = littleEndianToLong - jArr2[0];
        long j12 = littleEndianToLong2 - jArr2[1];
        while (true) {
            long mixColumnInv = mixColumnInv(j11);
            long mixColumnInv2 = mixColumnInv(j12);
            int i15 = (int) mixColumnInv;
            int i16 = (int) (mixColumnInv >>> 32);
            int i17 = (int) mixColumnInv2;
            int i18 = (int) (mixColumnInv2 >>> 32);
            byte[] bArr4 = T0;
            byte b11 = bArr4[i15 & 255];
            byte[] bArr5 = T1;
            byte b12 = bArr5[(i15 >>> 8) & 255];
            byte[] bArr6 = T2;
            byte b13 = bArr6[(i15 >>> 16) & 255];
            byte[] bArr7 = T3;
            byte b14 = (bArr7[i15 >>> 24] << Ascii.CAN) | ((b13 & 255) << 16) | (b11 & 255) | ((b12 & 255) << 8);
            long j13 = (((long) ((bArr7[i18 >>> 24] << Ascii.CAN) | (((bArr4[i18 & 255] & 255) | ((bArr5[(i18 >>> 8) & 255] & 255) << 8)) | ((bArr6[(i18 >>> 16) & 255] & 255) << 16)))) << 32) | (((long) b14) & 4294967295L);
            long j14 = (((long) ((bArr7[i17 >>> 24] << Ascii.CAN) | (bArr4[i17 & 255] & 255) | ((bArr5[(i17 >>> 8) & 255] & 255) << 8) | ((bArr6[(i17 >>> 16) & 255] & 255) << 16))) & 4294967295L) | (((long) ((bArr7[i16 >>> 24] << Ascii.CAN) | (((bArr4[i16 & 255] & 255) | ((bArr5[(i16 >>> 8) & 255] & 255) << 8)) | ((bArr6[(i16 >>> 16) & 255] & 255) << 16)))) << 32);
            i14--;
            if (i14 == 0) {
                long[] jArr3 = this.roundKeys[0];
                long j15 = j13 - jArr3[0];
                byte[] bArr8 = bArr2;
                int i19 = i12;
                Pack.longToLittleEndian(j15, bArr8, i19);
                Pack.longToLittleEndian(j14 - jArr3[1], bArr8, i19 + 8);
                return;
            }
            long[] jArr4 = this.roundKeys[i14];
            long j16 = j13 ^ jArr4[0];
            byte[] bArr9 = bArr2;
            int i21 = i12;
            j12 = j14 ^ jArr4[1];
            j11 = j16;
        }
    }

    private void encryptBlock_128(byte[] bArr, int i11, byte[] bArr2, int i12) {
        byte[] bArr3 = bArr2;
        int i13 = i12;
        long littleEndianToLong = Pack.littleEndianToLong(bArr, i11);
        long littleEndianToLong2 = Pack.littleEndianToLong(bArr, i11 + 8);
        long[] jArr = this.roundKeys[0];
        long j11 = littleEndianToLong + jArr[0];
        long j12 = littleEndianToLong2 + jArr[1];
        int i14 = 0;
        while (true) {
            int i15 = (int) j11;
            int i16 = (int) (j11 >>> 32);
            int i17 = (int) j12;
            int i18 = (int) (j12 >>> 32);
            byte[] bArr4 = S0;
            byte b11 = bArr4[i15 & 255];
            byte[] bArr5 = S1;
            byte b12 = bArr5[(i15 >>> 8) & 255];
            byte[] bArr6 = S2;
            byte b13 = bArr6[(i15 >>> 16) & 255];
            byte[] bArr7 = S3;
            byte b14 = ((b13 & 255) << 16) | (b11 & 255) | ((b12 & 255) << 8) | (bArr7[i15 >>> 24] << Ascii.CAN);
            long j13 = (((long) ((bArr7[i18 >>> 24] << Ascii.CAN) | (((bArr4[i18 & 255] & 255) | ((bArr5[(i18 >>> 8) & 255] & 255) << 8)) | ((bArr6[(i18 >>> 16) & 255] & 255) << 16)))) << 32) | (((long) b14) & 4294967295L);
            byte b15 = (bArr7[i17 >>> 24] << Ascii.CAN) | (bArr4[i17 & 255] & 255) | ((bArr5[(i17 >>> 8) & 255] & 255) << 8) | ((bArr6[(i17 >>> 16) & 255] & 255) << 16);
            byte b16 = bArr4[i16 & 255];
            byte b17 = bArr5[(i16 >>> 8) & 255];
            byte b18 = bArr6[(i16 >>> 16) & 255];
            int i19 = bArr7[i16 >>> 24] << Ascii.CAN;
            long mixColumn = mixColumn(j13);
            long mixColumn2 = mixColumn((((long) b15) & 4294967295L) | (((long) (i19 | (((b16 & 255) | ((b17 & 255) << 8)) | ((b18 & 255) << 16)))) << 32));
            i14++;
            int i21 = this.roundsAmount;
            if (i14 == i21) {
                long[] jArr2 = this.roundKeys[i21];
                byte[] bArr8 = bArr2;
                int i22 = i12;
                Pack.longToLittleEndian(mixColumn + jArr2[0], bArr8, i22);
                Pack.longToLittleEndian(mixColumn2 + jArr2[1], bArr8, i22 + 8);
                return;
            }
            long[] jArr3 = this.roundKeys[i14];
            long j14 = mixColumn ^ jArr3[0];
            byte[] bArr9 = bArr2;
            j12 = mixColumn2 ^ jArr3[1];
            int i23 = i12;
            j11 = j14;
        }
    }

    private void invShiftRows() {
        int i11 = this.wordsInBlock;
        if (i11 == 2) {
            long[] jArr = this.internalState;
            long j11 = jArr[0];
            long j12 = jArr[1];
            long j13 = -4294967296L & (j11 ^ j12);
            jArr[0] = j11 ^ j13;
            jArr[1] = j13 ^ j12;
        } else if (i11 == 4) {
            long[] jArr2 = this.internalState;
            long j14 = jArr2[0];
            long j15 = jArr2[1];
            long j16 = jArr2[2];
            long j17 = jArr2[3];
            long j18 = (j14 ^ j15) & -281470681808896L;
            long j19 = j14 ^ j18;
            long j21 = j15 ^ j18;
            long j22 = (j16 ^ j17) & -281470681808896L;
            long j23 = j16 ^ j22;
            long j24 = j17 ^ j22;
            long j25 = (j19 ^ j23) & -4294967296L;
            long j26 = j19 ^ j25;
            long j27 = (j21 ^ j24) & 281474976645120L;
            jArr2[0] = j26;
            jArr2[1] = j21 ^ j27;
            jArr2[2] = j23 ^ j25;
            jArr2[3] = j27 ^ j24;
        } else if (i11 == 8) {
            long[] jArr3 = this.internalState;
            long j28 = jArr3[0];
            long j29 = jArr3[1];
            long j30 = jArr3[2];
            long j31 = jArr3[3];
            long j32 = jArr3[4];
            long j33 = jArr3[5];
            long j34 = jArr3[6];
            long j35 = jArr3[7];
            long j36 = (j28 ^ j29) & -71777214294589696L;
            long j37 = j28 ^ j36;
            long j38 = j29 ^ j36;
            long j39 = (j30 ^ j31) & -71777214294589696L;
            long j40 = j30 ^ j39;
            long j41 = j31 ^ j39;
            long j42 = (j32 ^ j33) & -71777214294589696L;
            long j43 = j32 ^ j42;
            long j44 = j33 ^ j42;
            long j45 = (j34 ^ j35) & -71777214294589696L;
            long j46 = j34 ^ j45;
            long j47 = j35 ^ j45;
            long j48 = (j37 ^ j40) & -281470681808896L;
            long j49 = j37 ^ j48;
            long j50 = j40 ^ j48;
            long j51 = (j38 ^ j41) & 72056494543077120L;
            long j52 = j38 ^ j51;
            long j53 = j41 ^ j51;
            long j54 = (j43 ^ j46) & -281470681808896L;
            long j55 = j43 ^ j54;
            long j56 = j46 ^ j54;
            long j57 = (j44 ^ j47) & 72056494543077120L;
            long j58 = j44 ^ j57;
            long j59 = j47 ^ j57;
            long j60 = (j49 ^ j55) & -4294967296L;
            long j61 = j49 ^ j60;
            long j62 = j55 ^ j60;
            long j63 = (j52 ^ j58) & 72057594021150720L;
            long j64 = j52 ^ j63;
            long j65 = (j50 ^ j56) & 281474976645120L;
            long j66 = j50 ^ j65;
            long j67 = j65 ^ j56;
            long j68 = (j53 ^ j59) & 1099511627520L;
            jArr3[0] = j61;
            jArr3[1] = j64;
            jArr3[2] = j66;
            jArr3[3] = j53 ^ j68;
            jArr3[4] = j62;
            jArr3[5] = j58 ^ j63;
            jArr3[6] = j67;
            jArr3[7] = j59 ^ j68;
        } else {
            throw new IllegalStateException("unsupported block length: only 128/256/512 are allowed");
        }
    }

    private void invSubBytes() {
        for (int i11 = 0; i11 < this.wordsInBlock; i11++) {
            long[] jArr = this.internalState;
            long j11 = jArr[i11];
            int i12 = (int) j11;
            int i13 = (int) (j11 >>> 32);
            byte[] bArr = T0;
            byte b11 = bArr[i12 & 255];
            byte[] bArr2 = T1;
            byte b12 = bArr2[(i12 >>> 8) & 255];
            byte[] bArr3 = T2;
            byte b13 = bArr3[(i12 >>> 16) & 255];
            byte[] bArr4 = T3;
            byte b14 = (bArr4[i12 >>> 24] << Ascii.CAN) | (b11 & 255) | ((b12 & 255) << 8) | ((b13 & 255) << 16);
            byte b15 = bArr[i13 & 255];
            byte b16 = bArr2[(i13 >>> 8) & 255];
            byte b17 = bArr3[(i13 >>> 16) & 255];
            jArr[i11] = (((long) b14) & 4294967295L) | (((long) ((bArr4[i13 >>> 24] << Ascii.CAN) | (((b15 & 255) | ((b16 & 255) << 8)) | ((b17 & 255) << 16)))) << 32);
        }
    }

    private static long mixColumn(long j11) {
        long mulX = mulX(j11);
        long rotate = rotate(8, j11) ^ j11;
        long rotate2 = (rotate ^ rotate(16, rotate)) ^ rotate(48, j11);
        return ((rotate(32, mulX2((j11 ^ rotate2) ^ mulX)) ^ rotate2) ^ rotate(40, mulX)) ^ rotate(48, mulX);
    }

    private static long mixColumnInv(long j11) {
        long j12 = j11;
        long rotate = rotate(8, j12) ^ j12;
        long rotate2 = (rotate ^ rotate(32, rotate)) ^ rotate(48, j12);
        long j13 = rotate2 ^ j12;
        long rotate3 = rotate(48, j12);
        long rotate4 = rotate(56, j12);
        long rotate5 = rotate(16, rotate2);
        return mulX(rotate(40, ((j12 ^ rotate(32, j13)) ^ rotate4) ^ mulX(((rotate3 ^ (rotate(24, j12) ^ j13)) ^ rotate4) ^ mulX(mulX(mulX(rotate(40, mulX(mulX(j13 ^ rotate4) ^ rotate(56, j13)) ^ j12) ^ (rotate(16, j13) ^ j12)) ^ (j13 ^ rotate3)) ^ rotate5)))) ^ rotate2;
    }

    private void mixColumns() {
        for (int i11 = 0; i11 < this.wordsInBlock; i11++) {
            long[] jArr = this.internalState;
            jArr[i11] = mixColumn(jArr[i11]);
        }
    }

    private void mixColumnsInv() {
        for (int i11 = 0; i11 < this.wordsInBlock; i11++) {
            long[] jArr = this.internalState;
            jArr[i11] = mixColumnInv(jArr[i11]);
        }
    }

    private static long mulX(long j11) {
        return (((j11 & -9187201950435737472L) >>> 7) * 29) ^ ((9187201950435737471L & j11) << 1);
    }

    private static long mulX2(long j11) {
        return (((j11 & 4629771061636907072L) >>> 6) * 29) ^ (((4557430888798830399L & j11) << 2) ^ (((-9187201950435737472L & j11) >>> 6) * 29));
    }

    private static long rotate(int i11, long j11) {
        return (j11 << (-i11)) | (j11 >>> i11);
    }

    private void rotateLeft(long[] jArr, long[] jArr2) {
        int i11 = this.wordsInBlock;
        if (i11 == 2) {
            long j11 = jArr[0];
            long j12 = jArr[1];
            jArr2[0] = (j11 >>> 56) | (j12 << 8);
            jArr2[1] = (j11 << 8) | (j12 >>> 56);
        } else if (i11 == 4) {
            long j13 = jArr[0];
            long j14 = jArr[1];
            long j15 = jArr[2];
            long j16 = jArr[3];
            jArr2[0] = (j14 >>> 24) | (j15 << 40);
            jArr2[1] = (j15 >>> 24) | (j16 << 40);
            jArr2[2] = (j16 >>> 24) | (j13 << 40);
            jArr2[3] = (j13 >>> 24) | (j14 << 40);
        } else if (i11 == 8) {
            long j17 = jArr[0];
            long j18 = jArr[1];
            long j19 = jArr[2];
            long j21 = jArr[3];
            long j22 = jArr[4];
            long j23 = jArr[5];
            long j24 = jArr[6];
            long j25 = jArr[7];
            jArr2[0] = (j19 >>> 24) | (j21 << 40);
            jArr2[1] = (j21 >>> 24) | (j22 << 40);
            jArr2[2] = (j22 >>> 24) | (j23 << 40);
            jArr2[3] = (j23 >>> 24) | (j24 << 40);
            jArr2[4] = (j24 >>> 24) | (j25 << 40);
            jArr2[5] = (j25 >>> 24) | (j17 << 40);
            jArr2[6] = (j17 >>> 24) | (j18 << 40);
            jArr2[7] = (j18 >>> 24) | (j19 << 40);
        } else {
            throw new IllegalStateException("unsupported block length: only 128/256/512 are allowed");
        }
    }

    private void shiftRows() {
        int i11 = this.wordsInBlock;
        if (i11 == 2) {
            long[] jArr = this.internalState;
            long j11 = jArr[0];
            long j12 = jArr[1];
            long j13 = -4294967296L & (j11 ^ j12);
            jArr[0] = j11 ^ j13;
            jArr[1] = j13 ^ j12;
        } else if (i11 == 4) {
            long[] jArr2 = this.internalState;
            long j14 = jArr2[0];
            long j15 = jArr2[1];
            long j16 = jArr2[2];
            long j17 = jArr2[3];
            long j18 = (j14 ^ j16) & -4294967296L;
            long j19 = j14 ^ j18;
            long j21 = j16 ^ j18;
            long j22 = (j15 ^ j17) & 281474976645120L;
            long j23 = j15 ^ j22;
            long j24 = j17 ^ j22;
            long j25 = (j19 ^ j23) & -281470681808896L;
            long j26 = (j21 ^ j24) & -281470681808896L;
            jArr2[0] = j19 ^ j25;
            jArr2[1] = j23 ^ j25;
            jArr2[2] = j21 ^ j26;
            jArr2[3] = j24 ^ j26;
        } else if (i11 == 8) {
            long[] jArr3 = this.internalState;
            long j27 = jArr3[0];
            long j28 = jArr3[1];
            long j29 = jArr3[2];
            long j30 = jArr3[3];
            long j31 = jArr3[4];
            long j32 = jArr3[5];
            long j33 = jArr3[6];
            long j34 = jArr3[7];
            long j35 = (j27 ^ j31) & -4294967296L;
            long j36 = j27 ^ j35;
            long j37 = j31 ^ j35;
            long j38 = (j28 ^ j32) & 72057594021150720L;
            long j39 = j28 ^ j38;
            long j40 = j32 ^ j38;
            long j41 = (j29 ^ j33) & 281474976645120L;
            long j42 = j29 ^ j41;
            long j43 = j33 ^ j41;
            long j44 = (j30 ^ j34) & 1099511627520L;
            long j45 = j30 ^ j44;
            long j46 = j34 ^ j44;
            long j47 = (j36 ^ j42) & -281470681808896L;
            long j48 = j36 ^ j47;
            long j49 = j42 ^ j47;
            long j50 = (j39 ^ j45) & 72056494543077120L;
            long j51 = j39 ^ j50;
            long j52 = j45 ^ j50;
            long j53 = (j37 ^ j43) & -281470681808896L;
            long j54 = j37 ^ j53;
            long j55 = j43 ^ j53;
            long j56 = (j40 ^ j46) & 72056494543077120L;
            long j57 = j40 ^ j56;
            long j58 = j46 ^ j56;
            long j59 = (j48 ^ j51) & -71777214294589696L;
            long j60 = j48 ^ j59;
            long j61 = j51 ^ j59;
            long j62 = (j49 ^ j52) & -71777214294589696L;
            long j63 = j49 ^ j62;
            long j64 = j52 ^ j62;
            long j65 = (j54 ^ j57) & -71777214294589696L;
            long j66 = j54 ^ j65;
            long j67 = j57 ^ j65;
            long j68 = (j55 ^ j58) & -71777214294589696L;
            jArr3[0] = j60;
            jArr3[1] = j61;
            jArr3[2] = j63;
            jArr3[3] = j64;
            jArr3[4] = j66;
            jArr3[5] = j67;
            jArr3[6] = j55 ^ j68;
            jArr3[7] = j58 ^ j68;
        } else {
            throw new IllegalStateException("unsupported block length: only 128/256/512 are allowed");
        }
    }

    private void subBytes() {
        for (int i11 = 0; i11 < this.wordsInBlock; i11++) {
            long[] jArr = this.internalState;
            long j11 = jArr[i11];
            int i12 = (int) j11;
            int i13 = (int) (j11 >>> 32);
            byte[] bArr = S0;
            byte b11 = bArr[i12 & 255];
            byte[] bArr2 = S1;
            byte b12 = bArr2[(i12 >>> 8) & 255];
            byte[] bArr3 = S2;
            byte b13 = bArr3[(i12 >>> 16) & 255];
            byte[] bArr4 = S3;
            byte b14 = (bArr4[i12 >>> 24] << Ascii.CAN) | (b11 & 255) | ((b12 & 255) << 8) | ((b13 & 255) << 16);
            byte b15 = bArr[i13 & 255];
            byte b16 = bArr2[(i13 >>> 8) & 255];
            byte b17 = bArr3[(i13 >>> 16) & 255];
            jArr[i11] = (((long) b14) & 4294967295L) | (((long) ((bArr4[i13 >>> 24] << Ascii.CAN) | (((b15 & 255) | ((b16 & 255) << 8)) | ((b17 & 255) << 16)))) << 32);
        }
    }

    private void subRoundKey(int i11) {
        long[] jArr = this.roundKeys[i11];
        for (int i12 = 0; i12 < this.wordsInBlock; i12++) {
            long[] jArr2 = this.internalState;
            jArr2[i12] = jArr2[i12] - jArr[i12];
        }
    }

    private void workingKeyExpandEven(long[] jArr, long[] jArr2) {
        int i11;
        int i12;
        int i13 = this.wordsInKey;
        long[] jArr3 = new long[i13];
        long[] jArr4 = new long[this.wordsInBlock];
        System.arraycopy(jArr, 0, jArr3, 0, i13);
        long j11 = 281479271743489L;
        int i14 = 0;
        while (true) {
            for (int i15 = 0; i15 < this.wordsInBlock; i15++) {
                jArr4[i15] = jArr2[i15] + j11;
            }
            for (int i16 = 0; i16 < this.wordsInBlock; i16++) {
                this.internalState[i16] = jArr3[i16] + jArr4[i16];
            }
            subBytes();
            shiftRows();
            mixColumns();
            for (int i17 = 0; i17 < this.wordsInBlock; i17++) {
                long[] jArr5 = this.internalState;
                jArr5[i17] = jArr5[i17] ^ jArr4[i17];
            }
            subBytes();
            shiftRows();
            mixColumns();
            int i18 = 0;
            while (true) {
                i11 = this.wordsInBlock;
                if (i18 >= i11) {
                    break;
                }
                long[] jArr6 = this.internalState;
                jArr6[i18] = jArr6[i18] + jArr4[i18];
                i18++;
            }
            System.arraycopy(this.internalState, 0, this.roundKeys[i14], 0, i11);
            if (this.roundsAmount != i14) {
                if (this.wordsInBlock != this.wordsInKey) {
                    i14 += 2;
                    j11 <<= 1;
                    for (int i19 = 0; i19 < this.wordsInBlock; i19++) {
                        jArr4[i19] = jArr2[i19] + j11;
                    }
                    int i21 = 0;
                    while (true) {
                        int i22 = this.wordsInBlock;
                        if (i21 >= i22) {
                            break;
                        }
                        this.internalState[i21] = jArr3[i22 + i21] + jArr4[i21];
                        i21++;
                    }
                    subBytes();
                    shiftRows();
                    mixColumns();
                    for (int i23 = 0; i23 < this.wordsInBlock; i23++) {
                        long[] jArr7 = this.internalState;
                        jArr7[i23] = jArr7[i23] ^ jArr4[i23];
                    }
                    subBytes();
                    shiftRows();
                    mixColumns();
                    int i24 = 0;
                    while (true) {
                        i12 = this.wordsInBlock;
                        if (i24 >= i12) {
                            break;
                        }
                        long[] jArr8 = this.internalState;
                        jArr8[i24] = jArr8[i24] + jArr4[i24];
                        i24++;
                    }
                    System.arraycopy(this.internalState, 0, this.roundKeys[i14], 0, i12);
                    if (this.roundsAmount == i14) {
                        return;
                    }
                }
                i14 += 2;
                j11 <<= 1;
                long j12 = jArr3[0];
                for (int i25 = 1; i25 < i13; i25++) {
                    jArr3[i25 - 1] = jArr3[i25];
                }
                jArr3[i13 - 1] = j12;
            } else {
                return;
            }
        }
    }

    private void workingKeyExpandKT(long[] jArr, long[] jArr2) {
        int i11 = this.wordsInBlock;
        long[] jArr3 = new long[i11];
        long[] jArr4 = new long[i11];
        long[] jArr5 = new long[i11];
        this.internalState = jArr5;
        long j11 = jArr5[0];
        int i12 = this.wordsInKey;
        jArr5[0] = j11 + ((long) (i11 + i12 + 1));
        System.arraycopy(jArr, 0, jArr3, 0, i11);
        if (i11 == i12) {
            System.arraycopy(jArr, 0, jArr4, 0, i11);
        } else {
            int i13 = this.wordsInBlock;
            System.arraycopy(jArr, i13, jArr4, 0, i13);
        }
        int i14 = 0;
        while (true) {
            long[] jArr6 = this.internalState;
            if (i14 >= jArr6.length) {
                break;
            }
            jArr6[i14] = jArr6[i14] + jArr3[i14];
            i14++;
        }
        subBytes();
        shiftRows();
        mixColumns();
        int i15 = 0;
        while (true) {
            long[] jArr7 = this.internalState;
            if (i15 >= jArr7.length) {
                break;
            }
            jArr7[i15] = jArr7[i15] ^ jArr4[i15];
            i15++;
        }
        subBytes();
        shiftRows();
        mixColumns();
        int i16 = 0;
        while (true) {
            long[] jArr8 = this.internalState;
            if (i16 < jArr8.length) {
                jArr8[i16] = jArr8[i16] + jArr3[i16];
                i16++;
            } else {
                subBytes();
                shiftRows();
                mixColumns();
                System.arraycopy(this.internalState, 0, jArr2, 0, this.wordsInBlock);
                return;
            }
        }
    }

    private void workingKeyExpandOdd() {
        for (int i11 = 1; i11 < this.roundsAmount; i11 += 2) {
            long[][] jArr = this.roundKeys;
            rotateLeft(jArr[i11 - 1], jArr[i11]);
        }
    }

    private void xorRoundKey(int i11) {
        long[] jArr = this.roundKeys[i11];
        for (int i12 = 0; i12 < this.wordsInBlock; i12++) {
            long[] jArr2 = this.internalState;
            jArr2[i12] = jArr2[i12] ^ jArr[i12];
        }
    }

    public String getAlgorithmName() {
        return "DSTU7624";
    }

    public int getBlockSize() {
        return this.wordsInBlock << 3;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x005b A[LOOP:0: B:21:0x0056->B:23:0x005b, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0064 A[EDGE_INSN: B:32:0x0064->B:24:0x0064 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void init(boolean r5, org.bouncycastle.crypto.CipherParameters r6) throws java.lang.IllegalArgumentException {
        /*
            r4 = this;
            boolean r0 = r6 instanceof org.bouncycastle.crypto.params.KeyParameter
            if (r0 == 0) goto L_0x008c
            r4.forEncryption = r5
            org.bouncycastle.crypto.params.KeyParameter r6 = (org.bouncycastle.crypto.params.KeyParameter) r6
            byte[] r5 = r6.getKey()
            int r6 = r5.length
            int r6 = r6 << 3
            int r0 = r4.wordsInBlock
            int r0 = r0 << 6
            r1 = 512(0x200, float:7.175E-43)
            r2 = 256(0x100, float:3.59E-43)
            r3 = 128(0x80, float:1.794E-43)
            if (r6 == r3) goto L_0x0028
            if (r6 == r2) goto L_0x0028
            if (r6 != r1) goto L_0x0020
            goto L_0x0028
        L_0x0020:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.String r6 = "unsupported key length: only 128/256/512 are allowed"
            r5.<init>(r6)
            throw r5
        L_0x0028:
            if (r6 == r0) goto L_0x0037
            int r0 = r0 * 2
            if (r6 != r0) goto L_0x002f
            goto L_0x0037
        L_0x002f:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.String r6 = "Unsupported key length"
            r5.<init>(r6)
            throw r5
        L_0x0037:
            if (r6 == r3) goto L_0x0044
            if (r6 == r2) goto L_0x0041
            if (r6 == r1) goto L_0x003e
            goto L_0x0048
        L_0x003e:
            r0 = 18
            goto L_0x0046
        L_0x0041:
            r0 = 14
            goto L_0x0046
        L_0x0044:
            r0 = 10
        L_0x0046:
            r4.roundsAmount = r0
        L_0x0048:
            int r0 = r6 >>> 6
            r4.wordsInKey = r0
            int r0 = r4.roundsAmount
            int r0 = r0 + 1
            long[][] r0 = new long[r0][]
            r4.roundKeys = r0
            r0 = 0
            r1 = r0
        L_0x0056:
            long[][] r2 = r4.roundKeys
            int r3 = r2.length
            if (r1 >= r3) goto L_0x0064
            int r3 = r4.wordsInBlock
            long[] r3 = new long[r3]
            r2[r1] = r3
            int r1 = r1 + 1
            goto L_0x0056
        L_0x0064:
            int r1 = r4.wordsInKey
            long[] r1 = new long[r1]
            r4.workingKey = r1
            int r2 = r5.length
            int r6 = r6 >>> 3
            if (r2 != r6) goto L_0x0084
            org.bouncycastle.util.Pack.littleEndianToLong(r5, r0, r1)
            int r5 = r4.wordsInBlock
            long[] r5 = new long[r5]
            long[] r6 = r4.workingKey
            r4.workingKeyExpandKT(r6, r5)
            long[] r6 = r4.workingKey
            r4.workingKeyExpandEven(r6, r5)
            r4.workingKeyExpandOdd()
            return
        L_0x0084:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.String r6 = "Invalid key parameter passed to DSTU7624Engine init"
            r5.<init>(r6)
            throw r5
        L_0x008c:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.String r6 = "Invalid parameter passed to DSTU7624Engine init"
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.crypto.engines.DSTU7624Engine.init(boolean, org.bouncycastle.crypto.CipherParameters):void");
    }

    public int processBlock(byte[] bArr, int i11, byte[] bArr2, int i12) throws DataLengthException, IllegalStateException {
        int i13;
        if (this.workingKey == null) {
            throw new IllegalStateException("DSTU7624Engine not initialised");
        } else if (getBlockSize() + i11 > bArr.length) {
            throw new DataLengthException("Input buffer too short");
        } else if (getBlockSize() + i12 <= bArr2.length) {
            int i14 = 0;
            if (this.forEncryption) {
                if (this.wordsInBlock != 2) {
                    Pack.littleEndianToLong(bArr, i11, this.internalState);
                    addRoundKey(0);
                    while (true) {
                        subBytes();
                        shiftRows();
                        mixColumns();
                        i14++;
                        i13 = this.roundsAmount;
                        if (i14 == i13) {
                            break;
                        }
                        xorRoundKey(i14);
                    }
                    addRoundKey(i13);
                    Pack.longToLittleEndian(this.internalState, bArr2, i12);
                } else {
                    encryptBlock_128(bArr, i11, bArr2, i12);
                }
            } else if (this.wordsInBlock != 2) {
                Pack.littleEndianToLong(bArr, i11, this.internalState);
                subRoundKey(this.roundsAmount);
                int i15 = this.roundsAmount;
                while (true) {
                    mixColumnsInv();
                    invShiftRows();
                    invSubBytes();
                    i15--;
                    if (i15 == 0) {
                        break;
                    }
                    xorRoundKey(i15);
                }
                subRoundKey(0);
                Pack.longToLittleEndian(this.internalState, bArr2, i12);
            } else {
                decryptBlock_128(bArr, i11, bArr2, i12);
            }
            return getBlockSize();
        } else {
            throw new OutputLengthException("Output buffer too short");
        }
    }

    public void reset() {
        Arrays.fill(this.internalState, 0);
    }
}
