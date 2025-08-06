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
import org.bouncycastle.crypto.params.RC2Parameters;
import org.bouncycastle.crypto.signers.PSSSigner;
import org.jmrtd.lds.CVCAFile;

public class RC2Engine implements BlockCipher {
    private static final int BLOCK_SIZE = 8;
    private static byte[] piTable = {-39, Framer.EXIT_FRAME_PREFIX, -7, -60, Ascii.EM, -35, -75, -19, 40, -23, -3, 121, 74, ISOFileInfo.A0, ISO7816.INS_LOAD_KEY_FILE, -99, -58, 126, 55, ISOFileInfo.FILE_IDENTIFIER, 43, 118, 83, ISOFileInfo.CHANNEL_SECURITY, ISOFileInfo.FCP_BYTE, 76, 100, -120, ISO7816.INS_REHABILITATE_CHV, ISOFileInfo.SECURITY_ATTR_EXP, -5, -94, 23, -102, 89, -11, ISOFileInfo.FCI_EXT, ISO7816.INS_READ_RECORD2, 79, 19, 97, 69, 109, ISOFileInfo.ENV_TEMP_EF, 9, ISOFileInfo.DATA_BYTES2, 125, 50, -67, -113, SignedBytes.MAX_POWER_OF_TWO, -21, -122, -73, 123, 11, -16, -107, Framer.ENTER_FRAME_PREFIX, ISO7816.INS_MSE, 92, 107, 78, -126, 84, ISO7816.INS_UPDATE_BINARY, 101, -109, -50, 96, -78, 28, 115, 86, ISO7816.INS_GET_RESPONSE, 20, -89, ISOFileInfo.SECURITY_ATTR_COMPACT, -15, ISO7816.INS_UPDATE_RECORD, 18, 117, ISO7816.INS_GET_DATA, Ascii.US, 59, -66, ISO7816.INS_DELETE_FILE, -47, CVCAFile.CAR_TAG, 61, -44, ISO7816.INS_DECREASE, -93, 60, ISO7816.INS_READ_RECORD_STAMPED, 38, ISOFileInfo.FCI_BYTE, -65, 14, ISO7816.INS_PUT_DATA, 70, 105, 7, 87, 39, -14, 29, -101, PSSSigner.TRAILER_IMPLICIT, -108, 67, 3, -8, 17, -57, -10, -112, -17, 62, -25, 6, -61, -43, 47, -56, 102, 30, -41, 8, -24, -22, -34, Byte.MIN_VALUE, 82, -18, -9, -124, -86, 114, -84, 53, 77, 106, ISO7816.INS_PSO, -106, Ascii.SUB, ISO7816.INS_WRITE_RECORD, 113, 90, 21, 73, 116, 75, -97, ISO7816.INS_WRITE_BINARY, 94, 4, Ascii.CAN, -92, -20, ISO7816.INS_ENVELOPE, ISO7816.INS_CREATE_FILE, 65, 110, 15, 81, -53, -52, ISO7816.INS_CHANGE_CHV, -111, -81, 80, ISOFileInfo.A1, -12, ISO7816.INS_MANAGE_CHANNEL, 57, -103, 124, 58, ISOFileInfo.PROP_INFO, 35, -72, ISO7816.INS_READ_BINARY_STAMPED, 122, -4, 2, 54, 91, 37, 85, -105, Framer.STDOUT_FRAME_PREFIX, Framer.STDIN_FRAME_PREFIX, 93, -6, -104, -29, ISOFileInfo.LCS_BYTE, -110, -82, 5, -33, 41, 16, 103, 108, -70, -55, -45, 0, -26, -49, -31, -98, -88, ISO7816.INS_UNBLOCK_CHV, 99, 22, 1, Utf8.REPLACEMENT_BYTE, 88, ISO7816.INS_APPEND_RECORD, -119, -87, 13, 56, ISO7816.INS_DECREASE_STAMPED, Ascii.ESC, ISOFileInfo.AB, 51, -1, ISO7816.INS_READ_BINARY, -69, 72, 12, 95, -71, ISO7816.INS_READ_BINARY2, -51, 46, -59, -13, -37, 71, -27, ISOFileInfo.A5, -100, 119, 10, -90, 32, 104, -2, Ascii.DEL, -63, -83};
    private boolean encrypting;
    private int[] workingKey;

    private void decryptBlock(byte[] bArr, int i11, byte[] bArr2, int i12) {
        int i13 = ((bArr[i11 + 7] & 255) << 8) + (bArr[i11 + 6] & 255);
        int i14 = ((bArr[i11 + 5] & 255) << 8) + (bArr[i11 + 4] & 255);
        int i15 = ((bArr[i11 + 3] & 255) << 8) + (bArr[i11 + 2] & 255);
        int i16 = ((bArr[i11 + 1] & 255) << 8) + (bArr[i11 + 0] & 255);
        for (int i17 = 60; i17 >= 44; i17 -= 4) {
            i13 = rotateWordLeft(i13, 11) - ((((~i14) & i16) + (i15 & i14)) + this.workingKey[i17 + 3]);
            i14 = rotateWordLeft(i14, 13) - ((((~i15) & i13) + (i16 & i15)) + this.workingKey[i17 + 2]);
            i15 = rotateWordLeft(i15, 14) - ((((~i16) & i14) + (i13 & i16)) + this.workingKey[i17 + 1]);
            i16 = rotateWordLeft(i16, 15) - ((((~i13) & i15) + (i14 & i13)) + this.workingKey[i17]);
        }
        int[] iArr = this.workingKey;
        int i18 = i13 - iArr[i14 & 63];
        int i19 = i14 - iArr[i15 & 63];
        int i21 = i15 - iArr[i16 & 63];
        int i22 = i16 - iArr[i18 & 63];
        for (int i23 = 40; i23 >= 20; i23 -= 4) {
            i18 = rotateWordLeft(i18, 11) - ((((~i19) & i22) + (i21 & i19)) + this.workingKey[i23 + 3]);
            i19 = rotateWordLeft(i19, 13) - ((((~i21) & i18) + (i22 & i21)) + this.workingKey[i23 + 2]);
            i21 = rotateWordLeft(i21, 14) - ((((~i22) & i19) + (i18 & i22)) + this.workingKey[i23 + 1]);
            i22 = rotateWordLeft(i22, 15) - ((((~i18) & i21) + (i19 & i18)) + this.workingKey[i23]);
        }
        int[] iArr2 = this.workingKey;
        int i24 = i18 - iArr2[i19 & 63];
        int i25 = i19 - iArr2[i21 & 63];
        int i26 = i21 - iArr2[i22 & 63];
        int i27 = i22 - iArr2[i24 & 63];
        for (int i28 = 16; i28 >= 0; i28 -= 4) {
            i24 = rotateWordLeft(i24, 11) - ((((~i25) & i27) + (i26 & i25)) + this.workingKey[i28 + 3]);
            i25 = rotateWordLeft(i25, 13) - ((((~i26) & i24) + (i27 & i26)) + this.workingKey[i28 + 2]);
            i26 = rotateWordLeft(i26, 14) - ((((~i27) & i25) + (i24 & i27)) + this.workingKey[i28 + 1]);
            i27 = rotateWordLeft(i27, 15) - ((((~i24) & i26) + (i25 & i24)) + this.workingKey[i28]);
        }
        bArr2[i12 + 0] = (byte) i27;
        bArr2[i12 + 1] = (byte) (i27 >> 8);
        bArr2[i12 + 2] = (byte) i26;
        bArr2[i12 + 3] = (byte) (i26 >> 8);
        bArr2[i12 + 4] = (byte) i25;
        bArr2[i12 + 5] = (byte) (i25 >> 8);
        bArr2[i12 + 6] = (byte) i24;
        bArr2[i12 + 7] = (byte) (i24 >> 8);
    }

    private void encryptBlock(byte[] bArr, int i11, byte[] bArr2, int i12) {
        int i13 = ((bArr[i11 + 7] & 255) << 8) + (bArr[i11 + 6] & 255);
        int i14 = ((bArr[i11 + 5] & 255) << 8) + (bArr[i11 + 4] & 255);
        int i15 = ((bArr[i11 + 3] & 255) << 8) + (bArr[i11 + 2] & 255);
        int i16 = ((bArr[i11 + 1] & 255) << 8) + (bArr[i11 + 0] & 255);
        for (int i17 = 0; i17 <= 16; i17 += 4) {
            i16 = rotateWordLeft(i16 + ((~i13) & i15) + (i14 & i13) + this.workingKey[i17], 1);
            i15 = rotateWordLeft(i15 + ((~i16) & i14) + (i13 & i16) + this.workingKey[i17 + 1], 2);
            i14 = rotateWordLeft(i14 + ((~i15) & i13) + (i16 & i15) + this.workingKey[i17 + 2], 3);
            i13 = rotateWordLeft(i13 + ((~i14) & i16) + (i15 & i14) + this.workingKey[i17 + 3], 5);
        }
        int[] iArr = this.workingKey;
        int i18 = i16 + iArr[i13 & 63];
        int i19 = i15 + iArr[i18 & 63];
        int i21 = i14 + iArr[i19 & 63];
        int i22 = i13 + iArr[i21 & 63];
        for (int i23 = 20; i23 <= 40; i23 += 4) {
            i18 = rotateWordLeft(i18 + ((~i22) & i19) + (i21 & i22) + this.workingKey[i23], 1);
            i19 = rotateWordLeft(i19 + ((~i18) & i21) + (i22 & i18) + this.workingKey[i23 + 1], 2);
            i21 = rotateWordLeft(i21 + ((~i19) & i22) + (i18 & i19) + this.workingKey[i23 + 2], 3);
            i22 = rotateWordLeft(i22 + ((~i21) & i18) + (i19 & i21) + this.workingKey[i23 + 3], 5);
        }
        int[] iArr2 = this.workingKey;
        int i24 = i18 + iArr2[i22 & 63];
        int i25 = i19 + iArr2[i24 & 63];
        int i26 = i21 + iArr2[i25 & 63];
        int i27 = i22 + iArr2[i26 & 63];
        for (int i28 = 44; i28 < 64; i28 += 4) {
            i24 = rotateWordLeft(i24 + ((~i27) & i25) + (i26 & i27) + this.workingKey[i28], 1);
            i25 = rotateWordLeft(i25 + ((~i24) & i26) + (i27 & i24) + this.workingKey[i28 + 1], 2);
            i26 = rotateWordLeft(i26 + ((~i25) & i27) + (i24 & i25) + this.workingKey[i28 + 2], 3);
            i27 = rotateWordLeft(i27 + ((~i26) & i24) + (i25 & i26) + this.workingKey[i28 + 3], 5);
        }
        bArr2[i12 + 0] = (byte) i24;
        bArr2[i12 + 1] = (byte) (i24 >> 8);
        bArr2[i12 + 2] = (byte) i25;
        bArr2[i12 + 3] = (byte) (i25 >> 8);
        bArr2[i12 + 4] = (byte) i26;
        bArr2[i12 + 5] = (byte) (i26 >> 8);
        bArr2[i12 + 6] = (byte) i27;
        bArr2[i12 + 7] = (byte) (i27 >> 8);
    }

    private int[] generateWorkingKey(byte[] bArr, int i11) {
        int[] iArr = new int[128];
        for (int i12 = 0; i12 != bArr.length; i12++) {
            iArr[i12] = bArr[i12] & 255;
        }
        int length = bArr.length;
        if (length < 128) {
            int i13 = iArr[length - 1];
            int i14 = 0;
            while (true) {
                int i15 = i14 + 1;
                i13 = piTable[(i13 + iArr[i14]) & 255] & 255;
                int i16 = length + 1;
                iArr[length] = i13;
                if (i16 >= 128) {
                    break;
                }
                length = i16;
                i14 = i15;
            }
        }
        int i17 = (i11 + 7) >> 3;
        int i18 = 128 - i17;
        int i19 = piTable[(255 >> ((-i11) & 7)) & iArr[i18]] & 255;
        iArr[i18] = i19;
        for (int i21 = i18 - 1; i21 >= 0; i21--) {
            i19 = piTable[i19 ^ iArr[i21 + i17]] & 255;
            iArr[i21] = i19;
        }
        int[] iArr2 = new int[64];
        for (int i22 = 0; i22 != 64; i22++) {
            int i23 = i22 * 2;
            iArr2[i22] = iArr[i23] + (iArr[i23 + 1] << 8);
        }
        return iArr2;
    }

    private int rotateWordLeft(int i11, int i12) {
        int i13 = i11 & 65535;
        return (i13 >> (16 - i12)) | (i13 << i12);
    }

    public String getAlgorithmName() {
        return "RC2";
    }

    public int getBlockSize() {
        return 8;
    }

    public void init(boolean z11, CipherParameters cipherParameters) {
        this.encrypting = z11;
        if (cipherParameters instanceof RC2Parameters) {
            RC2Parameters rC2Parameters = (RC2Parameters) cipherParameters;
            this.workingKey = generateWorkingKey(rC2Parameters.getKey(), rC2Parameters.getEffectiveKeyBits());
        } else if (cipherParameters instanceof KeyParameter) {
            byte[] key = ((KeyParameter) cipherParameters).getKey();
            this.workingKey = generateWorkingKey(key, key.length * 8);
        } else {
            throw new IllegalArgumentException("invalid parameter passed to RC2 init - " + cipherParameters.getClass().getName());
        }
    }

    public final int processBlock(byte[] bArr, int i11, byte[] bArr2, int i12) {
        if (this.workingKey == null) {
            throw new IllegalStateException("RC2 engine not initialised");
        } else if (i11 + 8 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        } else if (i12 + 8 > bArr2.length) {
            throw new OutputLengthException("output buffer too short");
        } else if (this.encrypting) {
            encryptBlock(bArr, i11, bArr2, i12);
            return 8;
        } else {
            decryptBlock(bArr, i11, bArr2, i12);
            return 8;
        }
    }

    public void reset() {
    }
}
