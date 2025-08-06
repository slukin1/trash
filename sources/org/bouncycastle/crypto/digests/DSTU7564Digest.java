package org.bouncycastle.crypto.digests;

import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import net.sf.scuba.smartcards.ISO7816;
import net.sf.scuba.smartcards.ISOFileInfo;
import okio.Utf8;
import org.bouncycastle.crypto.ExtendedDigest;
import org.bouncycastle.crypto.signers.PSSSigner;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Memoable;
import org.bouncycastle.util.Pack;
import org.jmrtd.lds.CVCAFile;

public class DSTU7564Digest implements ExtendedDigest, Memoable {
    private static final int NB_1024 = 16;
    private static final int NB_512 = 8;
    private static final int NR_1024 = 14;
    private static final int NR_512 = 10;
    private static final byte[] S0 = {-88, 67, 95, 6, 107, 117, 108, 89, 113, -33, ISOFileInfo.FCI_EXT, -107, 23, -16, ISO7816.INS_LOAD_KEY_FILE, 9, 109, -13, 29, -53, -55, 77, ISO7816.INS_UNBLOCK_CHV, -81, 121, ISO7816.INS_CREATE_FILE, -105, -3, ISOFileInfo.FCI_BYTE, 75, 69, 57, 62, -35, -93, 79, ISO7816.INS_READ_BINARY_STAMPED, ISO7816.INS_READ_RECORD_STAMPED, -102, 14, Ascii.US, -65, 21, -31, 73, ISO7816.INS_WRITE_RECORD, -109, -58, -110, 114, -98, 97, -47, 99, -6, -18, -12, Ascii.EM, -43, -83, 88, -92, -69, ISOFileInfo.A1, ISO7816.INS_UPDATE_RECORD, -14, ISOFileInfo.FILE_IDENTIFIER, 55, CVCAFile.CAR_TAG, ISO7816.INS_DELETE_FILE, 122, 50, -100, -52, ISOFileInfo.AB, 74, -113, 110, 4, 39, 46, -25, ISO7816.INS_APPEND_RECORD, 90, -106, 22, 35, 43, ISO7816.INS_ENVELOPE, 101, 102, 15, PSSSigner.TRAILER_IMPLICIT, -87, 71, 65, ISO7816.INS_DECREASE_STAMPED, 72, -4, -73, 106, -120, ISOFileInfo.A5, 83, -122, -7, 91, -37, 56, 123, -61, 30, ISO7816.INS_MSE, 51, ISO7816.INS_CHANGE_CHV, 40, 54, -57, -78, 59, ISOFileInfo.CHANNEL_SECURITY, 119, -70, -11, 20, -97, 8, 85, -101, 76, -2, 96, 92, ISO7816.INS_PUT_DATA, Ascii.CAN, 70, -51, 125, Framer.ENTER_FRAME_PREFIX, ISO7816.INS_READ_BINARY, Utf8.REPLACEMENT_BYTE, Ascii.ESC, -119, -1, -21, -124, 105, 58, -99, -41, -45, ISO7816.INS_MANAGE_CHANNEL, 103, SignedBytes.MAX_POWER_OF_TWO, -75, -34, 93, ISO7816.INS_DECREASE, -111, ISO7816.INS_READ_BINARY2, Framer.EXIT_FRAME_PREFIX, 17, 1, -27, 0, 104, -104, ISOFileInfo.A0, -59, 2, -90, 116, Framer.STDIN_FRAME_PREFIX, 11, -94, 118, ISO7816.INS_READ_RECORD2, -66, -50, -67, -82, -23, ISOFileInfo.LCS_BYTE, Framer.STDOUT_FRAME_PREFIX, 28, -20, -15, -103, -108, -86, -10, 38, 47, -17, -24, ISOFileInfo.SECURITY_ATTR_COMPACT, 53, 3, -44, Ascii.DEL, -5, 5, -63, 94, -112, 32, 61, -126, -9, -22, 10, 13, 126, -8, 80, Ascii.SUB, -60, 7, 87, -72, 60, ISOFileInfo.FCP_BYTE, -29, -56, -84, 82, 100, 16, ISO7816.INS_WRITE_BINARY, -39, 19, 12, 18, 41, 81, -71, -49, ISO7816.INS_UPDATE_BINARY, 115, ISOFileInfo.ENV_TEMP_EF, ISOFileInfo.DATA_BYTES2, 84, ISO7816.INS_GET_RESPONSE, -19, 78, ISO7816.INS_REHABILITATE_CHV, -89, ISO7816.INS_PSO, ISOFileInfo.PROP_INFO, 37, -26, ISO7816.INS_GET_DATA, 124, ISOFileInfo.SECURITY_ATTR_EXP, 86, Byte.MIN_VALUE};
    private static final byte[] S1 = {-50, -69, -21, -110, -22, -53, 19, -63, -23, 58, ISO7816.INS_UPDATE_BINARY, -78, ISO7816.INS_WRITE_RECORD, -112, 23, -8, CVCAFile.CAR_TAG, 21, 86, ISO7816.INS_READ_BINARY_STAMPED, 101, 28, -120, 67, -59, 92, 54, -70, -11, 87, 103, ISOFileInfo.ENV_TEMP_EF, Framer.STDOUT_FRAME_PREFIX, -10, 100, 88, -98, -12, ISO7816.INS_MSE, -86, 117, 15, 2, ISO7816.INS_READ_BINARY2, -33, 109, 115, 77, 124, 38, 46, -9, 8, 93, ISO7816.INS_REHABILITATE_CHV, 62, -97, 20, -56, -82, 84, 16, ISO7816.INS_LOAD_KEY_FILE, PSSSigner.TRAILER_IMPLICIT, Ascii.SUB, 107, 105, -13, -67, 51, ISOFileInfo.AB, -6, -47, -101, 104, 78, 22, -107, -111, -18, 76, 99, ISOFileInfo.CHANNEL_SECURITY, 91, -52, 60, Ascii.EM, ISOFileInfo.A1, ISOFileInfo.DATA_BYTES2, 73, 123, -39, ISOFileInfo.FCI_BYTE, 55, 96, ISO7816.INS_GET_DATA, -25, 43, 72, -3, -106, 69, -4, 65, 18, 13, 121, -27, -119, ISOFileInfo.SECURITY_ATTR_COMPACT, -29, 32, ISO7816.INS_DECREASE, ISO7816.INS_UPDATE_RECORD, -73, 108, 74, -75, Utf8.REPLACEMENT_BYTE, -105, -44, ISOFileInfo.FCP_BYTE, Framer.STDIN_FRAME_PREFIX, 6, -92, ISOFileInfo.A5, ISOFileInfo.FILE_IDENTIFIER, 95, ISO7816.INS_PSO, ISO7816.INS_PUT_DATA, -55, 0, 126, -94, 85, -65, 17, -43, -100, -49, 14, 10, 61, 81, 125, -109, Ascii.ESC, -2, -60, 71, 9, -122, 11, -113, -99, 106, 7, -71, ISO7816.INS_READ_BINARY, -104, Ascii.CAN, 50, 113, 75, -17, 59, ISO7816.INS_MANAGE_CHANNEL, ISOFileInfo.A0, ISO7816.INS_DELETE_FILE, SignedBytes.MAX_POWER_OF_TWO, -1, -61, -87, -26, Framer.EXIT_FRAME_PREFIX, -7, ISOFileInfo.SECURITY_ATTR_EXP, 70, Byte.MIN_VALUE, 30, 56, -31, -72, -88, ISO7816.INS_CREATE_FILE, 12, 35, 118, 29, 37, ISO7816.INS_CHANGE_CHV, 5, -15, 110, -108, 40, -102, -124, -24, -93, 79, 119, -45, ISOFileInfo.PROP_INFO, ISO7816.INS_APPEND_RECORD, 82, -14, -126, 80, 122, 47, 116, 83, ISO7816.INS_READ_RECORD2, 97, -81, 57, 53, -34, -51, Ascii.US, -103, -84, -83, 114, ISO7816.INS_UNBLOCK_CHV, -35, ISO7816.INS_WRITE_BINARY, ISOFileInfo.FCI_EXT, -66, 94, -90, -20, 4, -58, 3, ISO7816.INS_DECREASE_STAMPED, -5, -37, 89, ISO7816.INS_READ_RECORD_STAMPED, ISO7816.INS_ENVELOPE, 1, -16, 90, -19, -89, 102, Framer.ENTER_FRAME_PREFIX, Ascii.DEL, ISOFileInfo.LCS_BYTE, 39, -57, ISO7816.INS_GET_RESPONSE, 41, -41};
    private static final byte[] S2 = {-109, -39, -102, -75, -104, ISO7816.INS_MSE, 69, -4, -70, 106, -33, 2, -97, ISO7816.INS_UPDATE_RECORD, 81, 89, 74, 23, 43, ISO7816.INS_ENVELOPE, -108, -12, -69, -93, ISOFileInfo.FCP_BYTE, ISO7816.INS_DELETE_FILE, 113, -44, -51, ISO7816.INS_MANAGE_CHANNEL, 22, -31, 73, 60, ISO7816.INS_GET_RESPONSE, ISO7816.INS_LOAD_KEY_FILE, 92, -101, -83, ISOFileInfo.PROP_INFO, 83, ISOFileInfo.A1, 122, -56, Framer.STDIN_FRAME_PREFIX, ISO7816.INS_CREATE_FILE, -47, 114, -90, ISO7816.INS_UNBLOCK_CHV, -60, -29, 118, Framer.EXIT_FRAME_PREFIX, -73, ISO7816.INS_READ_BINARY_STAMPED, 9, 59, 14, 65, 76, -34, -78, -112, 37, ISOFileInfo.A5, -41, 3, 17, 0, -61, 46, -110, -17, 78, 18, -99, 125, -53, 53, 16, -43, 79, -98, 77, -87, 85, -58, ISO7816.INS_WRITE_BINARY, 123, Ascii.CAN, -105, -45, 54, -26, 72, 86, ISOFileInfo.DATA_BYTES2, -113, 119, -52, -100, -71, ISO7816.INS_APPEND_RECORD, -84, -72, 47, 21, -92, 124, ISO7816.INS_PUT_DATA, 56, 30, 11, 5, ISO7816.INS_UPDATE_BINARY, 20, 110, 108, 126, 102, -3, ISO7816.INS_READ_BINARY2, -27, 96, -81, 94, 51, ISOFileInfo.FCI_EXT, -55, -16, 93, 109, Utf8.REPLACEMENT_BYTE, -120, ISOFileInfo.ENV_TEMP_EF, -57, -9, 29, -23, -20, -19, Byte.MIN_VALUE, 41, 39, -49, -103, -88, 80, 15, 55, ISO7816.INS_CHANGE_CHV, 40, ISO7816.INS_DECREASE, -107, ISO7816.INS_WRITE_RECORD, 62, 91, SignedBytes.MAX_POWER_OF_TWO, ISOFileInfo.FILE_IDENTIFIER, ISO7816.INS_READ_RECORD2, 105, 87, Ascii.US, 7, 28, ISOFileInfo.LCS_BYTE, PSSSigner.TRAILER_IMPLICIT, 32, -21, -50, ISOFileInfo.CHANNEL_SECURITY, ISOFileInfo.AB, -18, Framer.STDOUT_FRAME_PREFIX, -94, 115, -7, ISO7816.INS_GET_DATA, 58, Ascii.SUB, -5, 13, -63, -2, -6, -14, ISOFileInfo.FCI_BYTE, -67, -106, -35, 67, 82, ISO7816.INS_READ_RECORD_STAMPED, 8, -13, -82, -66, Ascii.EM, -119, 50, 38, ISO7816.INS_READ_BINARY, -22, 75, 100, -124, -126, 107, -11, 121, -65, 1, 95, 117, 99, Ascii.ESC, 35, 61, 104, ISO7816.INS_PSO, 101, -24, -111, -10, -1, 19, 88, -15, 71, 10, Ascii.DEL, -59, -89, -25, 97, 90, 6, 70, ISO7816.INS_REHABILITATE_CHV, CVCAFile.CAR_TAG, 4, ISOFileInfo.A0, -37, 57, -122, 84, -86, ISOFileInfo.SECURITY_ATTR_COMPACT, ISO7816.INS_DECREASE_STAMPED, Framer.ENTER_FRAME_PREFIX, ISOFileInfo.SECURITY_ATTR_EXP, -8, 12, 116, 103};
    private static final byte[] S3 = {104, ISOFileInfo.ENV_TEMP_EF, ISO7816.INS_GET_DATA, 77, 115, 75, 78, ISO7816.INS_PSO, -44, 82, 38, ISO7816.INS_READ_RECORD2, 84, 30, Ascii.EM, Ascii.US, ISO7816.INS_MSE, 3, 70, 61, Framer.STDIN_FRAME_PREFIX, 74, 83, ISOFileInfo.FILE_IDENTIFIER, 19, ISOFileInfo.LCS_BYTE, -73, -43, 37, 121, -11, -67, 88, 47, 13, 2, -19, 81, -98, 17, -14, 62, 85, 94, -47, 22, 60, 102, ISO7816.INS_MANAGE_CHANNEL, 93, -13, 69, SignedBytes.MAX_POWER_OF_TWO, -52, -24, -108, 86, 8, -50, Ascii.SUB, 58, ISO7816.INS_WRITE_RECORD, -31, -33, -75, 56, 110, 14, -27, -12, -7, -122, -23, 79, ISO7816.INS_UPDATE_BINARY, ISOFileInfo.PROP_INFO, 35, -49, 50, -103, Framer.STDOUT_FRAME_PREFIX, 20, -82, -18, -56, 72, -45, ISO7816.INS_DECREASE, ISOFileInfo.A1, -110, 65, ISO7816.INS_READ_BINARY2, Ascii.CAN, -60, ISO7816.INS_UNBLOCK_CHV, 113, 114, ISO7816.INS_REHABILITATE_CHV, 21, -3, 55, -66, 95, -86, -101, -120, ISO7816.INS_LOAD_KEY_FILE, ISOFileInfo.AB, -119, -100, -6, 96, -22, PSSSigner.TRAILER_IMPLICIT, ISOFileInfo.FCP_BYTE, 12, ISO7816.INS_CHANGE_CHV, -90, -88, -20, 103, 32, -37, 124, 40, -35, -84, 91, ISO7816.INS_DECREASE_STAMPED, 126, 16, -15, 123, -113, 99, ISOFileInfo.A0, 5, -102, 67, 119, Framer.ENTER_FRAME_PREFIX, -65, 39, 9, -61, -97, ISO7816.INS_READ_RECORD_STAMPED, -41, 41, ISO7816.INS_ENVELOPE, -21, ISO7816.INS_GET_RESPONSE, -92, ISOFileInfo.SECURITY_ATTR_EXP, ISOFileInfo.SECURITY_ATTR_COMPACT, 29, -5, -1, -63, -78, -105, 46, -8, 101, -10, 117, 7, 4, 73, 51, ISO7816.INS_DELETE_FILE, -39, -71, ISO7816.INS_WRITE_BINARY, CVCAFile.CAR_TAG, -57, 108, -112, 0, ISOFileInfo.CHANNEL_SECURITY, ISOFileInfo.FCI_BYTE, 80, 1, -59, ISO7816.INS_PUT_DATA, 71, Utf8.REPLACEMENT_BYTE, -51, 105, -94, ISO7816.INS_APPEND_RECORD, 122, -89, -58, -109, 15, 10, 6, -26, 43, -106, -93, 28, -81, 106, 18, -124, 57, -25, ISO7816.INS_READ_BINARY, -126, -9, -2, -99, ISOFileInfo.FCI_EXT, 92, ISOFileInfo.DATA_BYTES2, 53, -34, ISO7816.INS_READ_BINARY_STAMPED, ISOFileInfo.A5, -4, Byte.MIN_VALUE, -17, -53, -69, 107, 118, -70, 90, 125, Framer.EXIT_FRAME_PREFIX, 11, -107, -29, -83, 116, -104, 59, 54, 100, 109, ISO7816.INS_UPDATE_RECORD, -16, 89, -87, 76, 23, Ascii.DEL, -111, -72, -55, 87, Ascii.ESC, ISO7816.INS_CREATE_FILE, 97};
    private int blockSize;
    private byte[] buf;
    private int bufOff;
    private int columns;
    private int hashSize;
    private long inputBlocks;
    private int rounds;
    private long[] state;
    private long[] tempState1;
    private long[] tempState2;

    public DSTU7564Digest(int i11) {
        int i12;
        if (i11 == 256 || i11 == 384 || i11 == 512) {
            this.hashSize = i11 >>> 3;
            if (i11 > 256) {
                this.columns = 16;
                i12 = 14;
            } else {
                this.columns = 8;
                i12 = 10;
            }
            this.rounds = i12;
            int i13 = this.columns;
            int i14 = i13 << 3;
            this.blockSize = i14;
            long[] jArr = new long[i13];
            this.state = jArr;
            jArr[0] = (long) i14;
            this.tempState1 = new long[i13];
            this.tempState2 = new long[i13];
            this.buf = new byte[i14];
            return;
        }
        throw new IllegalArgumentException("Hash size is not recommended. Use 256/384/512 instead");
    }

    public DSTU7564Digest(DSTU7564Digest dSTU7564Digest) {
        copyIn(dSTU7564Digest);
    }

    private void P(long[] jArr) {
        for (int i11 = 0; i11 < this.rounds; i11++) {
            long j11 = (long) i11;
            for (int i12 = 0; i12 < this.columns; i12++) {
                jArr[i12] = jArr[i12] ^ j11;
                j11 += 16;
            }
            shiftRows(jArr);
            subBytes(jArr);
            mixColumns(jArr);
        }
    }

    private void Q(long[] jArr) {
        for (int i11 = 0; i11 < this.rounds; i11++) {
            long j11 = (((long) (((this.columns - 1) << 4) ^ i11)) << 56) | 67818912035696883L;
            for (int i12 = 0; i12 < this.columns; i12++) {
                jArr[i12] = jArr[i12] + j11;
                j11 -= 1152921504606846976L;
            }
            shiftRows(jArr);
            subBytes(jArr);
            mixColumns(jArr);
        }
    }

    private void copyIn(DSTU7564Digest dSTU7564Digest) {
        this.hashSize = dSTU7564Digest.hashSize;
        this.blockSize = dSTU7564Digest.blockSize;
        this.rounds = dSTU7564Digest.rounds;
        int i11 = this.columns;
        if (i11 <= 0 || i11 != dSTU7564Digest.columns) {
            this.columns = dSTU7564Digest.columns;
            this.state = Arrays.clone(dSTU7564Digest.state);
            int i12 = this.columns;
            this.tempState1 = new long[i12];
            this.tempState2 = new long[i12];
            this.buf = Arrays.clone(dSTU7564Digest.buf);
        } else {
            System.arraycopy(dSTU7564Digest.state, 0, this.state, 0, i11);
            System.arraycopy(dSTU7564Digest.buf, 0, this.buf, 0, this.blockSize);
        }
        this.inputBlocks = dSTU7564Digest.inputBlocks;
        this.bufOff = dSTU7564Digest.bufOff;
    }

    private static long mixColumn(long j11) {
        long j12 = ((9187201950435737471L & j11) << 1) ^ (((j11 & -9187201950435737472L) >>> 7) * 29);
        long rotate = rotate(8, j11) ^ j11;
        long rotate2 = (rotate ^ rotate(16, rotate)) ^ rotate(48, j11);
        long j13 = (j11 ^ rotate2) ^ j12;
        long j14 = ((-9187201950435737472L & j13) >>> 6) * 29;
        return ((rotate(32, (((j13 & 4629771061636907072L) >>> 6) * 29) ^ (j14 ^ ((4557430888798830399L & j13) << 2))) ^ rotate2) ^ rotate(40, j12)) ^ rotate(48, j12);
    }

    private void mixColumns(long[] jArr) {
        for (int i11 = 0; i11 < this.columns; i11++) {
            jArr[i11] = mixColumn(jArr[i11]);
        }
    }

    private void processBlock(byte[] bArr, int i11) {
        for (int i12 = 0; i12 < this.columns; i12++) {
            long littleEndianToLong = Pack.littleEndianToLong(bArr, i11);
            i11 += 8;
            this.tempState1[i12] = this.state[i12] ^ littleEndianToLong;
            this.tempState2[i12] = littleEndianToLong;
        }
        P(this.tempState1);
        Q(this.tempState2);
        for (int i13 = 0; i13 < this.columns; i13++) {
            long[] jArr = this.state;
            jArr[i13] = jArr[i13] ^ (this.tempState1[i13] ^ this.tempState2[i13]);
        }
    }

    private static long rotate(int i11, long j11) {
        return (j11 << (-i11)) | (j11 >>> i11);
    }

    private void shiftRows(long[] jArr) {
        int i11 = this.columns;
        if (i11 == 8) {
            long j11 = jArr[0];
            long j12 = jArr[1];
            long j13 = jArr[2];
            long j14 = jArr[3];
            long j15 = jArr[4];
            long j16 = jArr[5];
            long j17 = jArr[6];
            long j18 = jArr[7];
            long j19 = (j11 ^ j15) & -4294967296L;
            long j21 = j11 ^ j19;
            long j22 = j15 ^ j19;
            long j23 = (j12 ^ j16) & 72057594021150720L;
            long j24 = j12 ^ j23;
            long j25 = j16 ^ j23;
            long j26 = (j13 ^ j17) & 281474976645120L;
            long j27 = j13 ^ j26;
            long j28 = j17 ^ j26;
            long j29 = (j14 ^ j18) & 1099511627520L;
            long j30 = j14 ^ j29;
            long j31 = j18 ^ j29;
            long j32 = (j21 ^ j27) & -281470681808896L;
            long j33 = j21 ^ j32;
            long j34 = j27 ^ j32;
            long j35 = (j24 ^ j30) & 72056494543077120L;
            long j36 = j24 ^ j35;
            long j37 = j30 ^ j35;
            long j38 = (j22 ^ j28) & -281470681808896L;
            long j39 = j22 ^ j38;
            long j40 = j28 ^ j38;
            long j41 = (j25 ^ j31) & 72056494543077120L;
            long j42 = j25 ^ j41;
            long j43 = j31 ^ j41;
            long j44 = (j33 ^ j36) & -71777214294589696L;
            long j45 = j33 ^ j44;
            long j46 = j36 ^ j44;
            long j47 = (j34 ^ j37) & -71777214294589696L;
            long j48 = j34 ^ j47;
            long j49 = j37 ^ j47;
            long j50 = (j39 ^ j42) & -71777214294589696L;
            long j51 = (j40 ^ j43) & -71777214294589696L;
            jArr[0] = j45;
            jArr[1] = j46;
            jArr[2] = j48;
            jArr[3] = j49;
            jArr[4] = j39 ^ j50;
            jArr[5] = j42 ^ j50;
            jArr[6] = j40 ^ j51;
            jArr[7] = j43 ^ j51;
        } else if (i11 == 16) {
            long j52 = jArr[0];
            long j53 = jArr[1];
            long j54 = jArr[2];
            long j55 = jArr[3];
            long j56 = jArr[4];
            long j57 = jArr[5];
            long j58 = jArr[6];
            long j59 = jArr[7];
            long j60 = jArr[8];
            long j61 = jArr[9];
            long j62 = jArr[10];
            long j63 = jArr[11];
            long j64 = jArr[12];
            long j65 = jArr[13];
            long j66 = jArr[14];
            long j67 = jArr[15];
            long j68 = (j52 ^ j60) & -72057594037927936L;
            long j69 = j52 ^ j68;
            long j70 = j60 ^ j68;
            long j71 = (j53 ^ j61) & -72057594037927936L;
            long j72 = j53 ^ j71;
            long j73 = j61 ^ j71;
            long j74 = (j54 ^ j62) & -281474976710656L;
            long j75 = j54 ^ j74;
            long j76 = j62 ^ j74;
            long j77 = (j55 ^ j63) & -1099511627776L;
            long j78 = j55 ^ j77;
            long j79 = j63 ^ j77;
            long j80 = (j56 ^ j64) & -4294967296L;
            long j81 = j56 ^ j80;
            long j82 = j64 ^ j80;
            long j83 = (j57 ^ j65) & 72057594021150720L;
            long j84 = j57 ^ j83;
            long j85 = j65 ^ j83;
            long j86 = (j58 ^ j66) & 72057594037862400L;
            long j87 = j58 ^ j86;
            long j88 = j66 ^ j86;
            long j89 = (j59 ^ j67) & 72057594037927680L;
            long j90 = j59 ^ j89;
            long j91 = j67 ^ j89;
            long j92 = (j69 ^ j81) & 72057589742960640L;
            long j93 = j69 ^ j92;
            long j94 = j81 ^ j92;
            long j95 = (j72 ^ j84) & -16777216;
            long j96 = j72 ^ j95;
            long j97 = j84 ^ j95;
            long j98 = (j75 ^ j87) & -71776119061282816L;
            long j99 = j75 ^ j98;
            long j100 = j87 ^ j98;
            long j101 = (j78 ^ j90) & -72056494526300416L;
            long j102 = j78 ^ j101;
            long j103 = j90 ^ j101;
            long j104 = (j70 ^ j82) & 72057589742960640L;
            long j105 = j70 ^ j104;
            long j106 = j82 ^ j104;
            long j107 = (j73 ^ j85) & -16777216;
            long j108 = j73 ^ j107;
            long j109 = j85 ^ j107;
            long j110 = (j76 ^ j88) & -71776119061282816L;
            long j111 = j76 ^ j110;
            long j112 = j88 ^ j110;
            long j113 = (j79 ^ j91) & -72056494526300416L;
            long j114 = j79 ^ j113;
            long j115 = j91 ^ j113;
            long j116 = (j93 ^ j99) & -281470681808896L;
            long j117 = j93 ^ j116;
            long j118 = j99 ^ j116;
            long j119 = (j96 ^ j102) & 72056494543077120L;
            long j120 = j96 ^ j119;
            long j121 = j102 ^ j119;
            long j122 = (j94 ^ j100) & -281470681808896L;
            long j123 = j94 ^ j122;
            long j124 = j100 ^ j122;
            long j125 = (j97 ^ j103) & 72056494543077120L;
            long j126 = j97 ^ j125;
            long j127 = j103 ^ j125;
            long j128 = (j105 ^ j111) & -281470681808896L;
            long j129 = j105 ^ j128;
            long j130 = j111 ^ j128;
            long j131 = (j108 ^ j114) & 72056494543077120L;
            long j132 = j108 ^ j131;
            long j133 = j114 ^ j131;
            long j134 = (j106 ^ j112) & -281470681808896L;
            long j135 = j106 ^ j134;
            long j136 = j112 ^ j134;
            long j137 = (j109 ^ j115) & 72056494543077120L;
            long j138 = j109 ^ j137;
            long j139 = j115 ^ j137;
            long j140 = (j117 ^ j120) & -71777214294589696L;
            long j141 = j117 ^ j140;
            long j142 = j120 ^ j140;
            long j143 = (j118 ^ j121) & -71777214294589696L;
            long j144 = j118 ^ j143;
            long j145 = j121 ^ j143;
            long j146 = (j123 ^ j126) & -71777214294589696L;
            long j147 = j123 ^ j146;
            long j148 = j126 ^ j146;
            long j149 = (j124 ^ j127) & -71777214294589696L;
            long j150 = j124 ^ j149;
            long j151 = j127 ^ j149;
            long j152 = (j129 ^ j132) & -71777214294589696L;
            long j153 = j129 ^ j152;
            long j154 = j132 ^ j152;
            long j155 = (j130 ^ j133) & -71777214294589696L;
            long j156 = j130 ^ j155;
            long j157 = j133 ^ j155;
            long j158 = (j135 ^ j138) & -71777214294589696L;
            long j159 = (j136 ^ j139) & -71777214294589696L;
            jArr[0] = j141;
            jArr[1] = j142;
            jArr[2] = j144;
            jArr[3] = j145;
            jArr[4] = j147;
            jArr[5] = j148;
            jArr[6] = j150;
            jArr[7] = j151;
            jArr[8] = j153;
            jArr[9] = j154;
            jArr[10] = j156;
            jArr[11] = j157;
            jArr[12] = j135 ^ j158;
            jArr[13] = j138 ^ j158;
            jArr[14] = j136 ^ j159;
            jArr[15] = j139 ^ j159;
        } else {
            throw new IllegalStateException("unsupported state size: only 512/1024 are allowed");
        }
    }

    private void subBytes(long[] jArr) {
        for (int i11 = 0; i11 < this.columns; i11++) {
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

    public Memoable copy() {
        return new DSTU7564Digest(this);
    }

    public int doFinal(byte[] bArr, int i11) {
        int i12;
        int i13;
        int i14 = this.bufOff;
        byte[] bArr2 = this.buf;
        int i15 = i14 + 1;
        this.bufOff = i15;
        bArr2[i14] = Byte.MIN_VALUE;
        int i16 = this.blockSize - 12;
        int i17 = 0;
        if (i15 > i16) {
            while (true) {
                int i18 = this.bufOff;
                if (i18 >= this.blockSize) {
                    break;
                }
                byte[] bArr3 = this.buf;
                this.bufOff = i18 + 1;
                bArr3[i18] = 0;
            }
            this.bufOff = 0;
            processBlock(this.buf, 0);
        }
        while (true) {
            i12 = this.bufOff;
            if (i12 >= i16) {
                break;
            }
            byte[] bArr4 = this.buf;
            this.bufOff = i12 + 1;
            bArr4[i12] = 0;
        }
        long j11 = (((this.inputBlocks & 4294967295L) * ((long) this.blockSize)) + ((long) i14)) << 3;
        Pack.intToLittleEndian((int) j11, this.buf, i12);
        int i19 = this.bufOff + 4;
        this.bufOff = i19;
        Pack.longToLittleEndian((j11 >>> 32) + (((this.inputBlocks >>> 32) * ((long) this.blockSize)) << 3), this.buf, i19);
        processBlock(this.buf, 0);
        System.arraycopy(this.state, 0, this.tempState1, 0, this.columns);
        P(this.tempState1);
        while (true) {
            i13 = this.columns;
            if (i17 >= i13) {
                break;
            }
            long[] jArr = this.state;
            jArr[i17] = jArr[i17] ^ this.tempState1[i17];
            i17++;
        }
        for (int i21 = i13 - (this.hashSize >>> 3); i21 < this.columns; i21++) {
            Pack.longToLittleEndian(this.state[i21], bArr, i11);
            i11 += 8;
        }
        reset();
        return this.hashSize;
    }

    public String getAlgorithmName() {
        return "DSTU7564";
    }

    public int getByteLength() {
        return this.blockSize;
    }

    public int getDigestSize() {
        return this.hashSize;
    }

    public void reset() {
        Arrays.fill(this.state, 0);
        this.state[0] = (long) this.blockSize;
        this.inputBlocks = 0;
        this.bufOff = 0;
    }

    public void reset(Memoable memoable) {
        copyIn((DSTU7564Digest) memoable);
    }

    public void update(byte b11) {
        byte[] bArr = this.buf;
        int i11 = this.bufOff;
        int i12 = i11 + 1;
        this.bufOff = i12;
        bArr[i11] = b11;
        if (i12 == this.blockSize) {
            processBlock(bArr, 0);
            this.bufOff = 0;
            this.inputBlocks++;
        }
    }

    public void update(byte[] bArr, int i11, int i12) {
        while (this.bufOff != 0 && i12 > 0) {
            update(bArr[i11]);
            i12--;
            i11++;
        }
        if (i12 > 0) {
            while (i12 >= this.blockSize) {
                processBlock(bArr, i11);
                int i13 = this.blockSize;
                i11 += i13;
                i12 -= i13;
                this.inputBlocks++;
            }
            while (i12 > 0) {
                update(bArr[i11]);
                i12--;
                i11++;
            }
        }
    }
}
