package org.bouncycastle.crypto.digests;

import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import net.sf.scuba.smartcards.ISO7816;
import net.sf.scuba.smartcards.ISOFileInfo;
import okio.Utf8;
import org.bouncycastle.crypto.ExtendedDigest;
import org.bouncycastle.crypto.signers.PSSSigner;
import org.bouncycastle.util.Memoable;
import org.jmrtd.lds.CVCAFile;

public class MD2Digest implements ExtendedDigest, Memoable {
    private static final int DIGEST_LENGTH = 16;
    private static final byte[] S = {41, 46, 67, -55, -94, ISO7816.INS_LOAD_KEY_FILE, 124, 1, 61, 54, 84, ISOFileInfo.A1, -20, -16, 6, 19, ISOFileInfo.FCP_BYTE, -89, 5, -13, ISO7816.INS_GET_RESPONSE, -57, 115, ISOFileInfo.SECURITY_ATTR_COMPACT, -104, -109, 43, -39, PSSSigner.TRAILER_IMPLICIT, 76, -126, ISO7816.INS_GET_DATA, 30, -101, 87, 60, -3, -44, ISO7816.INS_CREATE_FILE, 22, 103, CVCAFile.CAR_TAG, ISOFileInfo.FCI_BYTE, Ascii.CAN, ISOFileInfo.LCS_BYTE, 23, -27, 18, -66, 78, -60, ISO7816.INS_UPDATE_BINARY, ISO7816.INS_PUT_DATA, -98, -34, 73, ISOFileInfo.A0, -5, -11, ISOFileInfo.CHANNEL_SECURITY, -69, 47, -18, 122, -87, 104, 121, -111, 21, -78, 7, Utf8.REPLACEMENT_BYTE, -108, ISO7816.INS_ENVELOPE, 16, -119, 11, ISO7816.INS_MSE, 95, Framer.ENTER_FRAME_PREFIX, Byte.MIN_VALUE, Ascii.DEL, 93, -102, 90, -112, 50, 39, 53, 62, -52, -25, -65, -9, -105, 3, -1, Ascii.EM, ISO7816.INS_DECREASE, ISO7816.INS_READ_RECORD2, 72, ISOFileInfo.A5, -75, -47, -41, 94, -110, ISO7816.INS_PSO, -84, 86, -86, -58, 79, -72, 56, ISO7816.INS_WRITE_RECORD, -106, -92, 125, ISO7816.INS_READ_RECORD_STAMPED, 118, -4, 107, ISO7816.INS_APPEND_RECORD, -100, 116, 4, -15, 69, -99, ISO7816.INS_MANAGE_CHANNEL, 89, 100, 113, ISOFileInfo.FCI_EXT, 32, -122, 91, -49, 101, -26, Framer.STDIN_FRAME_PREFIX, -88, 2, Ascii.ESC, 96, 37, -83, -82, ISO7816.INS_READ_BINARY, -71, -10, 28, 70, 97, 105, ISO7816.INS_DECREASE_STAMPED, SignedBytes.MAX_POWER_OF_TWO, 126, 15, 85, 71, -93, 35, -35, 81, -81, 58, -61, 92, -7, -50, -70, -59, -22, 38, ISO7816.INS_UNBLOCK_CHV, 83, 13, 110, ISOFileInfo.PROP_INFO, 40, -124, 9, -45, -33, -51, -12, 65, ISOFileInfo.DATA_BYTES2, 77, 82, 106, ISO7816.INS_UPDATE_RECORD, 55, -56, 108, -63, ISOFileInfo.AB, -6, ISO7816.INS_CHANGE_CHV, -31, 123, 8, 12, -67, ISO7816.INS_READ_BINARY2, 74, Framer.EXIT_FRAME_PREFIX, -120, -107, ISOFileInfo.SECURITY_ATTR_EXP, -29, 99, -24, 109, -23, -53, -43, -2, 59, 0, 29, 57, -14, -17, -73, 14, 102, 88, ISO7816.INS_WRITE_BINARY, ISO7816.INS_DELETE_FILE, -90, 119, 114, -8, -21, 117, 75, 10, Framer.STDOUT_FRAME_PREFIX, ISO7816.INS_REHABILITATE_CHV, 80, ISO7816.INS_READ_BINARY_STAMPED, -113, -19, Ascii.US, Ascii.SUB, -37, -103, ISOFileInfo.ENV_TEMP_EF, 51, -97, 17, ISOFileInfo.FILE_IDENTIFIER, 20};
    private byte[] C = new byte[16];
    private int COff;
    private byte[] M = new byte[16];
    private byte[] X = new byte[48];
    private int mOff;
    private int xOff;

    public MD2Digest() {
        reset();
    }

    public MD2Digest(MD2Digest mD2Digest) {
        copyIn(mD2Digest);
    }

    private void copyIn(MD2Digest mD2Digest) {
        byte[] bArr = mD2Digest.X;
        System.arraycopy(bArr, 0, this.X, 0, bArr.length);
        this.xOff = mD2Digest.xOff;
        byte[] bArr2 = mD2Digest.M;
        System.arraycopy(bArr2, 0, this.M, 0, bArr2.length);
        this.mOff = mD2Digest.mOff;
        byte[] bArr3 = mD2Digest.C;
        System.arraycopy(bArr3, 0, this.C, 0, bArr3.length);
        this.COff = mD2Digest.COff;
    }

    public Memoable copy() {
        return new MD2Digest(this);
    }

    public int doFinal(byte[] bArr, int i11) {
        int length = this.M.length;
        int i12 = this.mOff;
        byte b11 = (byte) (length - i12);
        while (true) {
            byte[] bArr2 = this.M;
            if (i12 < bArr2.length) {
                bArr2[i12] = b11;
                i12++;
            } else {
                processCheckSum(bArr2);
                processBlock(this.M);
                processBlock(this.C);
                System.arraycopy(this.X, this.xOff, bArr, i11, 16);
                reset();
                return 16;
            }
        }
    }

    public String getAlgorithmName() {
        return "MD2";
    }

    public int getByteLength() {
        return 16;
    }

    public int getDigestSize() {
        return 16;
    }

    public void processBlock(byte[] bArr) {
        for (int i11 = 0; i11 < 16; i11++) {
            byte[] bArr2 = this.X;
            bArr2[i11 + 16] = bArr[i11];
            bArr2[i11 + 32] = (byte) (bArr[i11] ^ bArr2[i11]);
        }
        int i12 = 0;
        for (int i13 = 0; i13 < 18; i13++) {
            for (int i14 = 0; i14 < 48; i14++) {
                byte[] bArr3 = this.X;
                byte b11 = (byte) (S[i12] ^ bArr3[i14]);
                bArr3[i14] = b11;
                i12 = b11 & 255;
            }
            i12 = (i12 + i13) % 256;
        }
    }

    public void processCheckSum(byte[] bArr) {
        byte b11 = this.C[15];
        for (int i11 = 0; i11 < 16; i11++) {
            byte[] bArr2 = this.C;
            bArr2[i11] = (byte) (S[(b11 ^ bArr[i11]) & 255] ^ bArr2[i11]);
            b11 = bArr2[i11];
        }
    }

    public void reset() {
        this.xOff = 0;
        int i11 = 0;
        while (true) {
            byte[] bArr = this.X;
            if (i11 == bArr.length) {
                break;
            }
            bArr[i11] = 0;
            i11++;
        }
        this.mOff = 0;
        int i12 = 0;
        while (true) {
            byte[] bArr2 = this.M;
            if (i12 == bArr2.length) {
                break;
            }
            bArr2[i12] = 0;
            i12++;
        }
        this.COff = 0;
        int i13 = 0;
        while (true) {
            byte[] bArr3 = this.C;
            if (i13 != bArr3.length) {
                bArr3[i13] = 0;
                i13++;
            } else {
                return;
            }
        }
    }

    public void reset(Memoable memoable) {
        copyIn((MD2Digest) memoable);
    }

    public void update(byte b11) {
        byte[] bArr = this.M;
        int i11 = this.mOff;
        int i12 = i11 + 1;
        this.mOff = i12;
        bArr[i11] = b11;
        if (i12 == 16) {
            processCheckSum(bArr);
            processBlock(this.M);
            this.mOff = 0;
        }
    }

    public void update(byte[] bArr, int i11, int i12) {
        while (this.mOff != 0 && i12 > 0) {
            update(bArr[i11]);
            i11++;
            i12--;
        }
        while (i12 > 16) {
            System.arraycopy(bArr, i11, this.M, 0, 16);
            processCheckSum(this.M);
            processBlock(this.M);
            i12 -= 16;
            i11 += 16;
        }
        while (i12 > 0) {
            update(bArr[i11]);
            i11++;
            i12--;
        }
    }
}
