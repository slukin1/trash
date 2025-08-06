package org.bouncycastle.crypto.digests;

import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import java.lang.reflect.Array;
import net.sf.scuba.smartcards.ISO7816;
import net.sf.scuba.smartcards.ISOFileInfo;
import org.bouncycastle.crypto.signers.PSSSigner;
import org.bouncycastle.util.Arrays;

public class Haraka256Digest extends HarakaBase {
    private static final byte[][] RC = {new byte[]{6, -124, ISO7816.INS_MANAGE_CHANNEL, 76, -26, 32, ISO7816.INS_GET_RESPONSE, 10, -78, -59, -2, -16, 117, ISOFileInfo.DATA_BYTES2, 123, -99}, new byte[]{ISOFileInfo.SECURITY_ATTR_EXP, 102, ISO7816.INS_READ_BINARY_STAMPED, -31, -120, -13, ISOFileInfo.A0, 107, 100, 15, 107, -92, 47, 8, -9, 23}, new byte[]{ISO7816.INS_DECREASE_STAMPED, 2, -34, Framer.STDIN_FRAME_PREFIX, 83, -14, -124, -104, -49, 2, -99, 96, -97, 2, -111, 20}, new byte[]{14, ISO7816.INS_UPDATE_BINARY, -22, -26, 46, 123, 79, 8, -69, -13, PSSSigner.TRAILER_IMPLICIT, -81, -3, 91, 79, 121}, new byte[]{-53, -49, ISO7816.INS_READ_BINARY, -53, 72, 114, ISO7816.INS_REHABILITATE_CHV, ISOFileInfo.SECURITY_ATTR_EXP, 121, -18, -51, 28, -66, 57, ISO7816.INS_MANAGE_CHANNEL, ISO7816.INS_REHABILITATE_CHV}, new byte[]{126, -22, -51, -18, 110, -112, 50, -73, ISOFileInfo.ENV_TEMP_EF, 83, 53, -19, 43, ISOFileInfo.LCS_BYTE, 5, 123}, new byte[]{103, ISO7816.INS_ENVELOPE, -113, 67, 94, 46, 124, ISO7816.INS_WRITE_BINARY, ISO7816.INS_APPEND_RECORD, 65, 39, 97, ISO7816.INS_PUT_DATA, 79, -17, Ascii.ESC}, new byte[]{41, ISO7816.INS_CHANGE_CHV, -39, ISO7816.INS_READ_BINARY, -81, ISO7816.INS_GET_DATA, -52, 7, 103, 95, -3, ISO7816.INS_APPEND_RECORD, Ascii.US, -57, 11, 59}, new byte[]{ISOFileInfo.AB, 77, 99, -15, -26, -122, Ascii.DEL, -23, -20, -37, -113, ISO7816.INS_GET_DATA, -71, -44, 101, -18}, new byte[]{28, ISO7816.INS_DECREASE, -65, -124, -44, -73, -51, 100, 91, ISO7816.INS_PSO, SignedBytes.MAX_POWER_OF_TWO, 79, -83, 3, 126, 51}, new byte[]{-78, -52, 11, -71, -108, 23, 35, -65, 105, 2, ISOFileInfo.SECURITY_ATTR_EXP, 46, ISOFileInfo.ENV_TEMP_EF, -10, -104, 0}, new byte[]{-6, 4, Framer.EXIT_FRAME_PREFIX, -90, -34, ISOFileInfo.FCI_BYTE, 85, 114, 74, -86, -98, -56, 92, -99, Framer.STDIN_FRAME_PREFIX, ISOFileInfo.LCS_BYTE}, new byte[]{-33, ISO7816.INS_READ_BINARY_STAMPED, -97, 43, 107, 119, ISO7816.INS_PSO, 18, 14, -6, 79, 46, 41, 18, -97, -44}, new byte[]{30, ISOFileInfo.A1, 3, ISO7816.INS_REHABILITATE_CHV, -12, 73, -94, 54, 50, ISO7816.INS_UPDATE_BINARY, 17, -82, -69, 106, 18, -18}, new byte[]{-81, 4, 73, -120, 75, 5, 0, -124, 95, -106, 0, -55, -100, -88, -20, -90}, new byte[]{Framer.ENTER_FRAME_PREFIX, 2, 94, ISO7816.INS_LOAD_KEY_FILE, -99, Ascii.EM, -100, 79, Framer.EXIT_FRAME_PREFIX, -94, -57, -29, 39, -27, -109, -20}, new byte[]{-65, 58, -86, -8, -89, 89, -55, -73, -71, 40, 46, -51, -126, -44, 1, 115}, new byte[]{ISOFileInfo.FCP_BYTE, 96, ISO7816.INS_MANAGE_CHANNEL, 13, 97, -122, ISO7816.INS_READ_BINARY, 23, 55, -14, -17, -39, 16, ISO7816.INS_DECREASE, 125, 107}, new byte[]{90, ISO7816.INS_GET_DATA, 69, ISO7816.INS_ENVELOPE, Framer.ENTER_FRAME_PREFIX, ISO7816.INS_DECREASE, 4, 67, ISOFileInfo.DATA_BYTES2, ISO7816.INS_ENVELOPE, -111, 83, -10, -4, -102, -58}, new byte[]{-110, 35, -105, 60, ISO7816.INS_MSE, 107, 104, -69, ISO7816.INS_UNBLOCK_CHV, -81, -110, -24, 54, -47, -108, 58}};
    private final byte[] buffer;
    private int off;

    public Haraka256Digest() {
        this.buffer = new byte[32];
    }

    public Haraka256Digest(Haraka256Digest haraka256Digest) {
        this.buffer = Arrays.clone(haraka256Digest.buffer);
        this.off = haraka256Digest.off;
    }

    private int haraka256256(byte[] bArr, byte[] bArr2, int i11) {
        Class<byte> cls = byte.class;
        byte[][] bArr3 = (byte[][]) Array.newInstance(cls, new int[]{2, 16});
        byte[][] bArr4 = (byte[][]) Array.newInstance(cls, new int[]{2, 16});
        System.arraycopy(bArr, 0, bArr3[0], 0, 16);
        System.arraycopy(bArr, 16, bArr3[1], 0, 16);
        byte[] bArr5 = bArr3[0];
        byte[][] bArr6 = RC;
        bArr3[0] = HarakaBase.aesEnc(bArr5, bArr6[0]);
        bArr3[1] = HarakaBase.aesEnc(bArr3[1], bArr6[1]);
        bArr3[0] = HarakaBase.aesEnc(bArr3[0], bArr6[2]);
        bArr3[1] = HarakaBase.aesEnc(bArr3[1], bArr6[3]);
        mix256(bArr3, bArr4);
        bArr3[0] = HarakaBase.aesEnc(bArr4[0], bArr6[4]);
        bArr3[1] = HarakaBase.aesEnc(bArr4[1], bArr6[5]);
        bArr3[0] = HarakaBase.aesEnc(bArr3[0], bArr6[6]);
        bArr3[1] = HarakaBase.aesEnc(bArr3[1], bArr6[7]);
        mix256(bArr3, bArr4);
        bArr3[0] = HarakaBase.aesEnc(bArr4[0], bArr6[8]);
        bArr3[1] = HarakaBase.aesEnc(bArr4[1], bArr6[9]);
        bArr3[0] = HarakaBase.aesEnc(bArr3[0], bArr6[10]);
        bArr3[1] = HarakaBase.aesEnc(bArr3[1], bArr6[11]);
        mix256(bArr3, bArr4);
        bArr3[0] = HarakaBase.aesEnc(bArr4[0], bArr6[12]);
        bArr3[1] = HarakaBase.aesEnc(bArr4[1], bArr6[13]);
        bArr3[0] = HarakaBase.aesEnc(bArr3[0], bArr6[14]);
        bArr3[1] = HarakaBase.aesEnc(bArr3[1], bArr6[15]);
        mix256(bArr3, bArr4);
        bArr3[0] = HarakaBase.aesEnc(bArr4[0], bArr6[16]);
        bArr3[1] = HarakaBase.aesEnc(bArr4[1], bArr6[17]);
        bArr3[0] = HarakaBase.aesEnc(bArr3[0], bArr6[18]);
        bArr3[1] = HarakaBase.aesEnc(bArr3[1], bArr6[19]);
        mix256(bArr3, bArr4);
        bArr3[0] = HarakaBase.xor(bArr4[0], bArr, 0);
        bArr3[1] = HarakaBase.xor(bArr4[1], bArr, 16);
        System.arraycopy(bArr3[0], 0, bArr2, i11, 16);
        System.arraycopy(bArr3[1], 0, bArr2, i11 + 16, 16);
        return 32;
    }

    private void mix256(byte[][] bArr, byte[][] bArr2) {
        System.arraycopy(bArr[0], 0, bArr2[0], 0, 4);
        System.arraycopy(bArr[1], 0, bArr2[0], 4, 4);
        System.arraycopy(bArr[0], 4, bArr2[0], 8, 4);
        System.arraycopy(bArr[1], 4, bArr2[0], 12, 4);
        System.arraycopy(bArr[0], 8, bArr2[1], 0, 4);
        System.arraycopy(bArr[1], 8, bArr2[1], 4, 4);
        System.arraycopy(bArr[0], 12, bArr2[1], 8, 4);
        System.arraycopy(bArr[1], 12, bArr2[1], 12, 4);
    }

    public int doFinal(byte[] bArr, int i11) {
        if (this.off != 32) {
            throw new IllegalStateException("input must be exactly 32 bytes");
        } else if (bArr.length - i11 >= 32) {
            int haraka256256 = haraka256256(this.buffer, bArr, i11);
            reset();
            return haraka256256;
        } else {
            throw new IllegalArgumentException("output too short to receive digest");
        }
    }

    public String getAlgorithmName() {
        return "Haraka-256";
    }

    public void reset() {
        this.off = 0;
        Arrays.clear(this.buffer);
    }

    public void update(byte b11) {
        int i11 = this.off;
        if (i11 + 1 <= 32) {
            byte[] bArr = this.buffer;
            this.off = i11 + 1;
            bArr[i11] = b11;
            return;
        }
        throw new IllegalArgumentException("total input cannot be more than 32 bytes");
    }

    public void update(byte[] bArr, int i11, int i12) {
        int i13 = this.off;
        if (i13 + i12 <= 32) {
            System.arraycopy(bArr, i11, this.buffer, i13, i12);
            this.off += i12;
            return;
        }
        throw new IllegalArgumentException("total input cannot be more than 32 bytes");
    }
}
