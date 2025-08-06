package org.bouncycastle.crypto.digests;

import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import java.lang.reflect.Array;
import net.sf.scuba.smartcards.ISO7816;
import net.sf.scuba.smartcards.ISOFileInfo;
import org.bouncycastle.crypto.signers.PSSSigner;
import org.bouncycastle.util.Arrays;
import org.jmrtd.lds.CVCAFile;

public class Haraka512Digest extends HarakaBase {
    private static byte[][] RC = {new byte[]{6, -124, ISO7816.INS_MANAGE_CHANNEL, 76, -26, 32, ISO7816.INS_GET_RESPONSE, 10, -78, -59, -2, -16, 117, ISOFileInfo.DATA_BYTES2, 123, -99}, new byte[]{ISOFileInfo.SECURITY_ATTR_EXP, 102, ISO7816.INS_READ_BINARY_STAMPED, -31, -120, -13, ISOFileInfo.A0, 107, 100, 15, 107, -92, 47, 8, -9, 23}, new byte[]{ISO7816.INS_DECREASE_STAMPED, 2, -34, Framer.STDIN_FRAME_PREFIX, 83, -14, -124, -104, -49, 2, -99, 96, -97, 2, -111, 20}, new byte[]{14, ISO7816.INS_UPDATE_BINARY, -22, -26, 46, 123, 79, 8, -69, -13, PSSSigner.TRAILER_IMPLICIT, -81, -3, 91, 79, 121}, new byte[]{-53, -49, ISO7816.INS_READ_BINARY, -53, 72, 114, ISO7816.INS_REHABILITATE_CHV, ISOFileInfo.SECURITY_ATTR_EXP, 121, -18, -51, 28, -66, 57, ISO7816.INS_MANAGE_CHANNEL, ISO7816.INS_REHABILITATE_CHV}, new byte[]{126, -22, -51, -18, 110, -112, 50, -73, ISOFileInfo.ENV_TEMP_EF, 83, 53, -19, 43, ISOFileInfo.LCS_BYTE, 5, 123}, new byte[]{103, ISO7816.INS_ENVELOPE, -113, 67, 94, 46, 124, ISO7816.INS_WRITE_BINARY, ISO7816.INS_APPEND_RECORD, 65, 39, 97, ISO7816.INS_PUT_DATA, 79, -17, Ascii.ESC}, new byte[]{41, ISO7816.INS_CHANGE_CHV, -39, ISO7816.INS_READ_BINARY, -81, ISO7816.INS_GET_DATA, -52, 7, 103, 95, -3, ISO7816.INS_APPEND_RECORD, Ascii.US, -57, 11, 59}, new byte[]{ISOFileInfo.AB, 77, 99, -15, -26, -122, Ascii.DEL, -23, -20, -37, -113, ISO7816.INS_GET_DATA, -71, -44, 101, -18}, new byte[]{28, ISO7816.INS_DECREASE, -65, -124, -44, -73, -51, 100, 91, ISO7816.INS_PSO, SignedBytes.MAX_POWER_OF_TWO, 79, -83, 3, 126, 51}, new byte[]{-78, -52, 11, -71, -108, 23, 35, -65, 105, 2, ISOFileInfo.SECURITY_ATTR_EXP, 46, ISOFileInfo.ENV_TEMP_EF, -10, -104, 0}, new byte[]{-6, 4, Framer.EXIT_FRAME_PREFIX, -90, -34, ISOFileInfo.FCI_BYTE, 85, 114, 74, -86, -98, -56, 92, -99, Framer.STDIN_FRAME_PREFIX, ISOFileInfo.LCS_BYTE}, new byte[]{-33, ISO7816.INS_READ_BINARY_STAMPED, -97, 43, 107, 119, ISO7816.INS_PSO, 18, 14, -6, 79, 46, 41, 18, -97, -44}, new byte[]{30, ISOFileInfo.A1, 3, ISO7816.INS_REHABILITATE_CHV, -12, 73, -94, 54, 50, ISO7816.INS_UPDATE_BINARY, 17, -82, -69, 106, 18, -18}, new byte[]{-81, 4, 73, -120, 75, 5, 0, -124, 95, -106, 0, -55, -100, -88, -20, -90}, new byte[]{Framer.ENTER_FRAME_PREFIX, 2, 94, ISO7816.INS_LOAD_KEY_FILE, -99, Ascii.EM, -100, 79, Framer.EXIT_FRAME_PREFIX, -94, -57, -29, 39, -27, -109, -20}, new byte[]{-65, 58, -86, -8, -89, 89, -55, -73, -71, 40, 46, -51, -126, -44, 1, 115}, new byte[]{ISOFileInfo.FCP_BYTE, 96, ISO7816.INS_MANAGE_CHANNEL, 13, 97, -122, ISO7816.INS_READ_BINARY, 23, 55, -14, -17, -39, 16, ISO7816.INS_DECREASE, 125, 107}, new byte[]{90, ISO7816.INS_GET_DATA, 69, ISO7816.INS_ENVELOPE, Framer.ENTER_FRAME_PREFIX, ISO7816.INS_DECREASE, 4, 67, ISOFileInfo.DATA_BYTES2, ISO7816.INS_ENVELOPE, -111, 83, -10, -4, -102, -58}, new byte[]{-110, 35, -105, 60, ISO7816.INS_MSE, 107, 104, -69, ISO7816.INS_UNBLOCK_CHV, -81, -110, -24, 54, -47, -108, 58}, new byte[]{-45, -65, -110, 56, ISO7816.INS_MSE, 88, -122, -21, 108, -70, -71, 88, -27, 16, 113, ISO7816.INS_READ_BINARY_STAMPED}, new byte[]{-37, -122, 60, -27, -82, -16, -58, 119, -109, 61, -3, -35, ISO7816.INS_CHANGE_CHV, -31, 18, ISOFileInfo.ENV_TEMP_EF}, new byte[]{-69, 96, ISOFileInfo.FCP_BYTE, 104, -1, -21, ISOFileInfo.A0, -100, ISOFileInfo.FILE_IDENTIFIER, ISO7816.INS_DELETE_FILE, ISOFileInfo.ENV_TEMP_EF, -29, -53, ISO7816.INS_MSE, 18, ISO7816.INS_READ_BINARY2}, new byte[]{115, 75, -45, ISO7816.INS_UPDATE_RECORD, ISO7816.INS_APPEND_RECORD, ISO7816.INS_DELETE_FILE, -47, -100, Framer.STDIN_FRAME_PREFIX, -71, Ascii.SUB, 78, -57, 43, -9, 125}, new byte[]{67, -69, 71, -61, 97, ISO7816.INS_DECREASE, Ascii.ESC, 67, 75, 20, 21, -60, ISO7816.INS_UNBLOCK_CHV, ISO7816.INS_READ_RECORD2, -110, 78}, new byte[]{-37, -89, 117, -88, -25, 7, -17, -10, 3, -78, Framer.STDOUT_FRAME_PREFIX, -35, 22, -21, 104, -103}, new byte[]{109, -13, 97, 75, 60, 117, 89, 119, ISOFileInfo.CHANNEL_SECURITY, 94, 35, 2, 126, ISO7816.INS_GET_DATA, 71, ISO7816.INS_UNBLOCK_CHV}, new byte[]{-51, -89, 90, 23, ISO7816.INS_UPDATE_BINARY, -34, 125, 119, 109, Ascii.ESC, -27, -71, -72, -122, 23, -7}, new byte[]{-20, 107, 67, -16, 107, -88, -23, -86, -99, 108, 6, -99, -87, 70, -18, 93}, new byte[]{-53, 30, 105, 80, -7, 87, 51, 43, -94, 83, 17, 89, 59, -13, 39, -63}, new byte[]{ISO7816.INS_UNBLOCK_CHV, -18, 12, 117, 0, ISO7816.INS_PUT_DATA, 97, -100, ISO7816.INS_DELETE_FILE, -19, 3, 83, 96, 14, ISO7816.INS_WRITE_BINARY, -39}, new byte[]{-16, ISO7816.INS_READ_BINARY2, ISOFileInfo.A5, ISOFileInfo.A1, -106, -23, 12, ISOFileInfo.AB, Byte.MIN_VALUE, -69, -70, PSSSigner.TRAILER_IMPLICIT, 99, -92, -93, 80}, new byte[]{-82, 61, ISO7816.INS_READ_BINARY2, 2, 94, -106, 41, -120, ISOFileInfo.AB, 13, -34, ISO7816.INS_DECREASE, -109, ISOFileInfo.ENV_TEMP_EF, ISO7816.INS_GET_DATA, 57}, new byte[]{23, -69, -113, 56, -43, 84, -92, 11, -120, 20, -13, -88, 46, 117, ISO7816.INS_READ_BINARY_STAMPED, CVCAFile.CAR_TAG}, new byte[]{ISO7816.INS_DECREASE_STAMPED, -69, ISOFileInfo.LCS_BYTE, 91, 95, CVCAFile.CAR_TAG, Ascii.DEL, -41, -82, ISO7816.INS_READ_RECORD_STAMPED, -73, 121, 54, 10, 22, -10}, new byte[]{38, -10, 82, 65, -53, -27, 84, 56, 67, -50, 89, Ascii.CAN, -1, -70, -81, -34}, new byte[]{76, -23, -102, 84, -71, -13, 2, 106, -94, ISO7816.INS_GET_DATA, -100, -9, ISOFileInfo.FILE_IDENTIFIER, -98, -55, Framer.EXIT_FRAME_PREFIX}, new byte[]{-82, 81, ISOFileInfo.A5, Ascii.SUB, Ascii.ESC, -33, -9, -66, SignedBytes.MAX_POWER_OF_TWO, ISO7816.INS_GET_RESPONSE, 110, 40, ISO7816.INS_MSE, -112, 18, 53}, new byte[]{ISOFileInfo.A0, -63, 97, 60, -70, 126, ISO7816.INS_WRITE_RECORD, 43, -63, 115, PSSSigner.TRAILER_IMPLICIT, 15, 72, -90, 89, -49}, new byte[]{117, 106, -52, 3, 2, 40, -126, -120, 74, ISO7816.INS_UPDATE_BINARY, -67, -3, -23, -59, -99, ISOFileInfo.A1}};
    private final byte[] buffer;
    private int off;

    public Haraka512Digest() {
        this.buffer = new byte[64];
    }

    public Haraka512Digest(Haraka512Digest haraka512Digest) {
        this.buffer = Arrays.clone(haraka512Digest.buffer);
        this.off = haraka512Digest.off;
    }

    private int haraka512256(byte[] bArr, byte[] bArr2, int i11) {
        byte[] bArr3 = bArr;
        byte[] bArr4 = bArr2;
        int i12 = i11;
        Class<byte> cls = byte.class;
        byte[][] bArr5 = (byte[][]) Array.newInstance(cls, new int[]{4, 16});
        byte[][] bArr6 = (byte[][]) Array.newInstance(cls, new int[]{4, 16});
        System.arraycopy(bArr3, 0, bArr5[0], 0, 16);
        System.arraycopy(bArr3, 16, bArr5[1], 0, 16);
        System.arraycopy(bArr3, 32, bArr5[2], 0, 16);
        System.arraycopy(bArr3, 48, bArr5[3], 0, 16);
        bArr5[0] = HarakaBase.aesEnc(bArr5[0], RC[0]);
        bArr5[1] = HarakaBase.aesEnc(bArr5[1], RC[1]);
        bArr5[2] = HarakaBase.aesEnc(bArr5[2], RC[2]);
        bArr5[3] = HarakaBase.aesEnc(bArr5[3], RC[3]);
        bArr5[0] = HarakaBase.aesEnc(bArr5[0], RC[4]);
        bArr5[1] = HarakaBase.aesEnc(bArr5[1], RC[5]);
        bArr5[2] = HarakaBase.aesEnc(bArr5[2], RC[6]);
        bArr5[3] = HarakaBase.aesEnc(bArr5[3], RC[7]);
        mix512(bArr5, bArr6);
        bArr5[0] = HarakaBase.aesEnc(bArr6[0], RC[8]);
        bArr5[1] = HarakaBase.aesEnc(bArr6[1], RC[9]);
        bArr5[2] = HarakaBase.aesEnc(bArr6[2], RC[10]);
        bArr5[3] = HarakaBase.aesEnc(bArr6[3], RC[11]);
        bArr5[0] = HarakaBase.aesEnc(bArr5[0], RC[12]);
        bArr5[1] = HarakaBase.aesEnc(bArr5[1], RC[13]);
        bArr5[2] = HarakaBase.aesEnc(bArr5[2], RC[14]);
        bArr5[3] = HarakaBase.aesEnc(bArr5[3], RC[15]);
        mix512(bArr5, bArr6);
        bArr5[0] = HarakaBase.aesEnc(bArr6[0], RC[16]);
        bArr5[1] = HarakaBase.aesEnc(bArr6[1], RC[17]);
        bArr5[2] = HarakaBase.aesEnc(bArr6[2], RC[18]);
        bArr5[3] = HarakaBase.aesEnc(bArr6[3], RC[19]);
        bArr5[0] = HarakaBase.aesEnc(bArr5[0], RC[20]);
        bArr5[1] = HarakaBase.aesEnc(bArr5[1], RC[21]);
        bArr5[2] = HarakaBase.aesEnc(bArr5[2], RC[22]);
        bArr5[3] = HarakaBase.aesEnc(bArr5[3], RC[23]);
        mix512(bArr5, bArr6);
        bArr5[0] = HarakaBase.aesEnc(bArr6[0], RC[24]);
        bArr5[1] = HarakaBase.aesEnc(bArr6[1], RC[25]);
        bArr5[2] = HarakaBase.aesEnc(bArr6[2], RC[26]);
        bArr5[3] = HarakaBase.aesEnc(bArr6[3], RC[27]);
        bArr5[0] = HarakaBase.aesEnc(bArr5[0], RC[28]);
        bArr5[1] = HarakaBase.aesEnc(bArr5[1], RC[29]);
        bArr5[2] = HarakaBase.aesEnc(bArr5[2], RC[30]);
        bArr5[3] = HarakaBase.aesEnc(bArr5[3], RC[31]);
        mix512(bArr5, bArr6);
        bArr5[0] = HarakaBase.aesEnc(bArr6[0], RC[32]);
        bArr5[1] = HarakaBase.aesEnc(bArr6[1], RC[33]);
        bArr5[2] = HarakaBase.aesEnc(bArr6[2], RC[34]);
        bArr5[3] = HarakaBase.aesEnc(bArr6[3], RC[35]);
        bArr5[0] = HarakaBase.aesEnc(bArr5[0], RC[36]);
        bArr5[1] = HarakaBase.aesEnc(bArr5[1], RC[37]);
        bArr5[2] = HarakaBase.aesEnc(bArr5[2], RC[38]);
        bArr5[3] = HarakaBase.aesEnc(bArr5[3], RC[39]);
        mix512(bArr5, bArr6);
        bArr5[0] = HarakaBase.xor(bArr6[0], bArr3, 0);
        bArr5[1] = HarakaBase.xor(bArr6[1], bArr3, 16);
        bArr5[2] = HarakaBase.xor(bArr6[2], bArr3, 32);
        bArr5[3] = HarakaBase.xor(bArr6[3], bArr3, 48);
        System.arraycopy(bArr5[0], 8, bArr4, i12, 8);
        System.arraycopy(bArr5[1], 8, bArr4, i12 + 8, 8);
        System.arraycopy(bArr5[2], 0, bArr4, i12 + 16, 8);
        System.arraycopy(bArr5[3], 0, bArr4, i12 + 24, 8);
        return 32;
    }

    private void mix512(byte[][] bArr, byte[][] bArr2) {
        System.arraycopy(bArr[0], 12, bArr2[0], 0, 4);
        System.arraycopy(bArr[2], 12, bArr2[0], 4, 4);
        System.arraycopy(bArr[1], 12, bArr2[0], 8, 4);
        System.arraycopy(bArr[3], 12, bArr2[0], 12, 4);
        System.arraycopy(bArr[2], 0, bArr2[1], 0, 4);
        System.arraycopy(bArr[0], 0, bArr2[1], 4, 4);
        System.arraycopy(bArr[3], 0, bArr2[1], 8, 4);
        System.arraycopy(bArr[1], 0, bArr2[1], 12, 4);
        System.arraycopy(bArr[2], 4, bArr2[2], 0, 4);
        System.arraycopy(bArr[0], 4, bArr2[2], 4, 4);
        System.arraycopy(bArr[3], 4, bArr2[2], 8, 4);
        System.arraycopy(bArr[1], 4, bArr2[2], 12, 4);
        System.arraycopy(bArr[0], 8, bArr2[3], 0, 4);
        System.arraycopy(bArr[2], 8, bArr2[3], 4, 4);
        System.arraycopy(bArr[1], 8, bArr2[3], 8, 4);
        System.arraycopy(bArr[3], 8, bArr2[3], 12, 4);
    }

    public int doFinal(byte[] bArr, int i11) {
        if (this.off != 64) {
            throw new IllegalStateException("input must be exactly 64 bytes");
        } else if (bArr.length - i11 >= 32) {
            int haraka512256 = haraka512256(this.buffer, bArr, i11);
            reset();
            return haraka512256;
        } else {
            throw new IllegalArgumentException("output too short to receive digest");
        }
    }

    public String getAlgorithmName() {
        return "Haraka-512";
    }

    public void reset() {
        this.off = 0;
        Arrays.clear(this.buffer);
    }

    public void update(byte b11) {
        int i11 = this.off;
        if (i11 + 1 <= 64) {
            byte[] bArr = this.buffer;
            this.off = i11 + 1;
            bArr[i11] = b11;
            return;
        }
        throw new IllegalArgumentException("total input cannot be more than 64 bytes");
    }

    public void update(byte[] bArr, int i11, int i12) {
        int i13 = this.off;
        if (i13 + i12 <= 64) {
            System.arraycopy(bArr, i11, this.buffer, i13, i12);
            this.off += i12;
            return;
        }
        throw new IllegalArgumentException("total input cannot be more than 64 bytes");
    }
}
