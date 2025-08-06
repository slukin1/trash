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
import org.bouncycastle.crypto.StatelessProcessing;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.signers.PSSSigner;
import org.jmrtd.lds.CVCAFile;

public class CamelliaLightEngine implements BlockCipher, StatelessProcessing {
    private static final int BLOCK_SIZE = 16;
    private static final int MASK8 = 255;
    private static final byte[] SBOX1 = {ISO7816.INS_MANAGE_CHANNEL, -126, ISO7816.INS_UNBLOCK_CHV, -20, ISO7816.INS_READ_RECORD2, 39, ISO7816.INS_GET_RESPONSE, -27, ISO7816.INS_DELETE_FILE, ISOFileInfo.PROP_INFO, 87, 53, -22, 12, -82, 65, 35, -17, 107, -109, 69, Ascii.EM, ISOFileInfo.A5, Framer.ENTER_FRAME_PREFIX, -19, 14, 79, 78, 29, 101, -110, -67, -122, -72, -81, -113, 124, -21, Ascii.US, -50, 62, ISO7816.INS_DECREASE, ISO7816.INS_UPDATE_RECORD, 95, 94, -59, 11, Ascii.SUB, -90, -31, 57, ISO7816.INS_GET_DATA, -43, 71, 93, 61, -39, 1, 90, ISO7816.INS_UPDATE_BINARY, 81, 86, 108, 77, ISOFileInfo.SECURITY_ATTR_EXP, 13, -102, 102, -5, -52, ISO7816.INS_READ_BINARY, Framer.STDIN_FRAME_PREFIX, 116, 18, 43, 32, -16, ISO7816.INS_READ_BINARY2, -124, -103, -33, 76, -53, ISO7816.INS_ENVELOPE, ISO7816.INS_DECREASE_STAMPED, 126, 118, 5, 109, -73, -87, Framer.STDOUT_FRAME_PREFIX, -47, 23, 4, -41, 20, 88, 58, 97, -34, Ascii.ESC, 17, 28, 50, 15, -100, 22, 83, Ascii.CAN, -14, ISO7816.INS_MSE, -2, ISO7816.INS_REHABILITATE_CHV, -49, -78, -61, -75, 122, -111, ISO7816.INS_CHANGE_CHV, 8, -24, -88, 96, -4, 105, 80, -86, ISO7816.INS_WRITE_BINARY, ISOFileInfo.A0, 125, ISOFileInfo.A1, -119, ISOFileInfo.FCP_BYTE, -105, 84, 91, 30, -107, ISO7816.INS_CREATE_FILE, -1, 100, ISO7816.INS_WRITE_RECORD, 16, -60, 0, 72, -93, -9, 117, -37, ISOFileInfo.LCS_BYTE, 3, -26, ISO7816.INS_PUT_DATA, 9, Utf8.REPLACEMENT_BYTE, -35, -108, ISOFileInfo.FCI_EXT, 92, ISOFileInfo.FILE_IDENTIFIER, 2, -51, 74, -112, 51, 115, 103, -10, -13, -99, Ascii.DEL, -65, ISO7816.INS_APPEND_RECORD, 82, -101, ISO7816.INS_LOAD_KEY_FILE, 38, -56, 55, -58, 59, ISOFileInfo.DATA_BYTES2, -106, ISOFileInfo.FCI_BYTE, 75, 19, -66, 99, 46, -23, 121, -89, ISOFileInfo.SECURITY_ATTR_COMPACT, -97, 110, PSSSigner.TRAILER_IMPLICIT, ISOFileInfo.CHANNEL_SECURITY, 41, -11, -7, ISO7816.INS_READ_RECORD_STAMPED, 47, -3, ISO7816.INS_READ_BINARY_STAMPED, 89, Framer.EXIT_FRAME_PREFIX, -104, 6, 106, -25, 70, 113, -70, -44, 37, ISOFileInfo.AB, CVCAFile.CAR_TAG, -120, -94, ISOFileInfo.ENV_TEMP_EF, -6, 114, 7, -71, 85, -8, -18, -84, 10, 54, 73, ISO7816.INS_PSO, 104, 60, 56, -15, -92, SignedBytes.MAX_POWER_OF_TWO, 40, -45, 123, -69, -55, 67, -63, 21, -29, -83, -12, 119, -57, Byte.MIN_VALUE, -98};
    private static final int[] SIGMA = {-1600231809, 1003262091, -1233459112, 1286239154, -957401297, -380665154, 1426019237, -237801700, 283453434, -563598051, -1336506174, -1276722691};
    private boolean _keyis128;
    private boolean initialized;

    /* renamed from: ke  reason: collision with root package name */
    private int[] f59162ke = new int[12];
    private int[] kw = new int[8];
    private int[] subkey = new int[96];

    private int bytes2int(byte[] bArr, int i11) {
        int i12 = 0;
        for (int i13 = 0; i13 < 4; i13++) {
            i12 = (i12 << 8) + (bArr[i13 + i11] & 255);
        }
        return i12;
    }

    private void camelliaF2(int[] iArr, int[] iArr2, int i11) {
        int i12 = iArr[0] ^ iArr2[i11 + 0];
        int sbox4 = sbox4(i12 & 255) | (sbox3((i12 >>> 8) & 255) << 8) | (sbox2((i12 >>> 16) & 255) << 16);
        byte[] bArr = SBOX1;
        int i13 = iArr[1] ^ iArr2[i11 + 1];
        int leftRotate = leftRotate((sbox2((i13 >>> 24) & 255) << 24) | (bArr[i13 & 255] & 255) | (sbox4((i13 >>> 8) & 255) << 8) | (sbox3((i13 >>> 16) & 255) << 16), 8);
        int i14 = (((bArr[(i12 >>> 24) & 255] & 255) << Ascii.CAN) | sbox4) ^ leftRotate;
        int leftRotate2 = leftRotate(leftRotate, 8) ^ i14;
        int rightRotate = rightRotate(i14, 8) ^ leftRotate2;
        iArr[2] = (leftRotate(leftRotate2, 16) ^ rightRotate) ^ iArr[2];
        iArr[3] = leftRotate(rightRotate, 8) ^ iArr[3];
        int i15 = iArr[2] ^ iArr2[i11 + 2];
        int sbox42 = ((bArr[(i15 >>> 24) & 255] & 255) << Ascii.CAN) | sbox4(i15 & 255) | (sbox3((i15 >>> 8) & 255) << 8) | (sbox2((i15 >>> 16) & 255) << 16);
        int i16 = iArr2[i11 + 3] ^ iArr[3];
        int leftRotate3 = leftRotate((sbox2((i16 >>> 24) & 255) << 24) | (bArr[i16 & 255] & 255) | (sbox4((i16 >>> 8) & 255) << 8) | (sbox3((i16 >>> 16) & 255) << 16), 8);
        int i17 = sbox42 ^ leftRotate3;
        int leftRotate4 = leftRotate(leftRotate3, 8) ^ i17;
        int rightRotate2 = rightRotate(i17, 8) ^ leftRotate4;
        iArr[0] = (leftRotate(leftRotate4, 16) ^ rightRotate2) ^ iArr[0];
        iArr[1] = iArr[1] ^ leftRotate(rightRotate2, 8);
    }

    private void camelliaFLs(int[] iArr, int[] iArr2, int i11) {
        iArr[1] = iArr[1] ^ leftRotate(iArr[0] & iArr2[i11 + 0], 1);
        iArr[0] = iArr[0] ^ (iArr2[i11 + 1] | iArr[1]);
        iArr[2] = iArr[2] ^ (iArr2[i11 + 3] | iArr[3]);
        iArr[3] = leftRotate(iArr2[i11 + 2] & iArr[2], 1) ^ iArr[3];
    }

    private static void decroldq(int i11, int[] iArr, int i12, int[] iArr2, int i13) {
        int i14 = i13 + 2;
        int i15 = i12 + 0;
        int i16 = i12 + 1;
        int i17 = 32 - i11;
        iArr2[i14] = (iArr[i15] << i11) | (iArr[i16] >>> i17);
        int i18 = i13 + 3;
        int i19 = i12 + 2;
        iArr2[i18] = (iArr[i16] << i11) | (iArr[i19] >>> i17);
        int i21 = i13 + 0;
        int i22 = i12 + 3;
        iArr2[i21] = (iArr[i19] << i11) | (iArr[i22] >>> i17);
        int i23 = i13 + 1;
        iArr2[i23] = (iArr[i22] << i11) | (iArr[i15] >>> i17);
        iArr[i15] = iArr2[i14];
        iArr[i16] = iArr2[i18];
        iArr[i19] = iArr2[i21];
        iArr[i22] = iArr2[i23];
    }

    private static void decroldqo32(int i11, int[] iArr, int i12, int[] iArr2, int i13) {
        int i14 = i13 + 2;
        int i15 = i12 + 1;
        int i16 = i11 - 32;
        int i17 = i12 + 2;
        int i18 = 64 - i11;
        iArr2[i14] = (iArr[i15] << i16) | (iArr[i17] >>> i18);
        int i19 = i13 + 3;
        int i21 = i12 + 3;
        iArr2[i19] = (iArr[i17] << i16) | (iArr[i21] >>> i18);
        int i22 = i13 + 0;
        int i23 = i12 + 0;
        iArr2[i22] = (iArr[i21] << i16) | (iArr[i23] >>> i18);
        int i24 = i13 + 1;
        iArr2[i24] = (iArr[i15] >>> i18) | (iArr[i23] << i16);
        iArr[i23] = iArr2[i14];
        iArr[i15] = iArr2[i19];
        iArr[i17] = iArr2[i22];
        iArr[i21] = iArr2[i24];
    }

    private void int2bytes(int i11, byte[] bArr, int i12) {
        for (int i13 = 0; i13 < 4; i13++) {
            bArr[(3 - i13) + i12] = (byte) i11;
            i11 >>>= 8;
        }
    }

    private byte lRot8(byte b11, int i11) {
        return (byte) (((b11 & 255) >>> (8 - i11)) | (b11 << i11));
    }

    private static int leftRotate(int i11, int i12) {
        return (i11 << i12) + (i11 >>> (32 - i12));
    }

    private int processBlock128(byte[] bArr, int i11, byte[] bArr2, int i12) {
        int[] iArr = new int[4];
        for (int i13 = 0; i13 < 4; i13++) {
            iArr[i13] = bytes2int(bArr, (i13 * 4) + i11) ^ this.kw[i13];
        }
        camelliaF2(iArr, this.subkey, 0);
        camelliaF2(iArr, this.subkey, 4);
        camelliaF2(iArr, this.subkey, 8);
        camelliaFLs(iArr, this.f59162ke, 0);
        camelliaF2(iArr, this.subkey, 12);
        camelliaF2(iArr, this.subkey, 16);
        camelliaF2(iArr, this.subkey, 20);
        camelliaFLs(iArr, this.f59162ke, 4);
        camelliaF2(iArr, this.subkey, 24);
        camelliaF2(iArr, this.subkey, 28);
        camelliaF2(iArr, this.subkey, 32);
        int i14 = iArr[2];
        int[] iArr2 = this.kw;
        iArr[2] = iArr2[4] ^ i14;
        iArr[3] = iArr[3] ^ iArr2[5];
        iArr[0] = iArr[0] ^ iArr2[6];
        iArr[1] = iArr2[7] ^ iArr[1];
        int2bytes(iArr[2], bArr2, i12);
        int2bytes(iArr[3], bArr2, i12 + 4);
        int2bytes(iArr[0], bArr2, i12 + 8);
        int2bytes(iArr[1], bArr2, i12 + 12);
        return 16;
    }

    private int processBlock192or256(byte[] bArr, int i11, byte[] bArr2, int i12) {
        int[] iArr = new int[4];
        for (int i13 = 0; i13 < 4; i13++) {
            iArr[i13] = bytes2int(bArr, (i13 * 4) + i11) ^ this.kw[i13];
        }
        camelliaF2(iArr, this.subkey, 0);
        camelliaF2(iArr, this.subkey, 4);
        camelliaF2(iArr, this.subkey, 8);
        camelliaFLs(iArr, this.f59162ke, 0);
        camelliaF2(iArr, this.subkey, 12);
        camelliaF2(iArr, this.subkey, 16);
        camelliaF2(iArr, this.subkey, 20);
        camelliaFLs(iArr, this.f59162ke, 4);
        camelliaF2(iArr, this.subkey, 24);
        camelliaF2(iArr, this.subkey, 28);
        camelliaF2(iArr, this.subkey, 32);
        camelliaFLs(iArr, this.f59162ke, 8);
        camelliaF2(iArr, this.subkey, 36);
        camelliaF2(iArr, this.subkey, 40);
        camelliaF2(iArr, this.subkey, 44);
        int i14 = iArr[2];
        int[] iArr2 = this.kw;
        iArr[2] = i14 ^ iArr2[4];
        iArr[3] = iArr[3] ^ iArr2[5];
        iArr[0] = iArr[0] ^ iArr2[6];
        iArr[1] = iArr2[7] ^ iArr[1];
        int2bytes(iArr[2], bArr2, i12);
        int2bytes(iArr[3], bArr2, i12 + 4);
        int2bytes(iArr[0], bArr2, i12 + 8);
        int2bytes(iArr[1], bArr2, i12 + 12);
        return 16;
    }

    private static int rightRotate(int i11, int i12) {
        return (i11 >>> i12) + (i11 << (32 - i12));
    }

    private static void roldq(int i11, int[] iArr, int i12, int[] iArr2, int i13) {
        int i14 = i13 + 0;
        int i15 = i12 + 0;
        int i16 = i12 + 1;
        int i17 = 32 - i11;
        iArr2[i14] = (iArr[i15] << i11) | (iArr[i16] >>> i17);
        int i18 = i13 + 1;
        int i19 = i12 + 2;
        iArr2[i18] = (iArr[i16] << i11) | (iArr[i19] >>> i17);
        int i21 = i13 + 2;
        int i22 = i12 + 3;
        iArr2[i21] = (iArr[i19] << i11) | (iArr[i22] >>> i17);
        int i23 = i13 + 3;
        iArr2[i23] = (iArr[i22] << i11) | (iArr[i15] >>> i17);
        iArr[i15] = iArr2[i14];
        iArr[i16] = iArr2[i18];
        iArr[i19] = iArr2[i21];
        iArr[i22] = iArr2[i23];
    }

    private static void roldqo32(int i11, int[] iArr, int i12, int[] iArr2, int i13) {
        int i14 = i13 + 0;
        int i15 = i12 + 1;
        int i16 = i11 - 32;
        int i17 = i12 + 2;
        int i18 = 64 - i11;
        iArr2[i14] = (iArr[i15] << i16) | (iArr[i17] >>> i18);
        int i19 = i13 + 1;
        int i21 = i12 + 3;
        iArr2[i19] = (iArr[i17] << i16) | (iArr[i21] >>> i18);
        int i22 = i13 + 2;
        int i23 = i12 + 0;
        iArr2[i22] = (iArr[i21] << i16) | (iArr[i23] >>> i18);
        int i24 = i13 + 3;
        iArr2[i24] = (iArr[i15] >>> i18) | (iArr[i23] << i16);
        iArr[i23] = iArr2[i14];
        iArr[i15] = iArr2[i19];
        iArr[i17] = iArr2[i22];
        iArr[i21] = iArr2[i24];
    }

    private int sbox2(int i11) {
        return lRot8(SBOX1[i11], 1) & 255;
    }

    private int sbox3(int i11) {
        return lRot8(SBOX1[i11], 7) & 255;
    }

    private int sbox4(int i11) {
        return SBOX1[lRot8((byte) i11, 1) & 255] & 255;
    }

    private void setKey(boolean z11, byte[] bArr) {
        byte[] bArr2 = bArr;
        int[] iArr = new int[8];
        int[] iArr2 = new int[4];
        int[] iArr3 = new int[4];
        int[] iArr4 = new int[4];
        int length = bArr2.length;
        if (length != 16) {
            if (length == 24) {
                iArr[0] = bytes2int(bArr2, 0);
                iArr[1] = bytes2int(bArr2, 4);
                iArr[2] = bytes2int(bArr2, 8);
                iArr[3] = bytes2int(bArr2, 12);
                iArr[4] = bytes2int(bArr2, 16);
                iArr[5] = bytes2int(bArr2, 20);
                iArr[6] = ~iArr[4];
                iArr[7] = ~iArr[5];
            } else if (length == 32) {
                iArr[0] = bytes2int(bArr2, 0);
                iArr[1] = bytes2int(bArr2, 4);
                iArr[2] = bytes2int(bArr2, 8);
                iArr[3] = bytes2int(bArr2, 12);
                iArr[4] = bytes2int(bArr2, 16);
                iArr[5] = bytes2int(bArr2, 20);
                iArr[6] = bytes2int(bArr2, 24);
                iArr[7] = bytes2int(bArr2, 28);
            } else {
                throw new IllegalArgumentException("key sizes are only 16/24/32 bytes.");
            }
            this._keyis128 = false;
        } else {
            this._keyis128 = true;
            iArr[0] = bytes2int(bArr2, 0);
            iArr[1] = bytes2int(bArr2, 4);
            iArr[2] = bytes2int(bArr2, 8);
            iArr[3] = bytes2int(bArr2, 12);
            iArr[7] = 0;
            iArr[6] = 0;
            iArr[5] = 0;
            iArr[4] = 0;
        }
        for (int i11 = 0; i11 < 4; i11++) {
            iArr2[i11] = iArr[i11] ^ iArr[i11 + 4];
        }
        camelliaF2(iArr2, SIGMA, 0);
        for (int i12 = 0; i12 < 4; i12++) {
            iArr2[i12] = iArr2[i12] ^ iArr[i12];
        }
        camelliaF2(iArr2, SIGMA, 4);
        if (this._keyis128) {
            int[] iArr5 = this.kw;
            if (z11) {
                iArr5[0] = iArr[0];
                iArr5[1] = iArr[1];
                iArr5[2] = iArr[2];
                iArr5[3] = iArr[3];
                roldq(15, iArr, 0, this.subkey, 4);
                roldq(30, iArr, 0, this.subkey, 12);
                roldq(15, iArr, 0, iArr4, 0);
                int[] iArr6 = this.subkey;
                iArr6[18] = iArr4[2];
                iArr6[19] = iArr4[3];
                roldq(17, iArr, 0, this.f59162ke, 4);
                roldq(17, iArr, 0, this.subkey, 24);
                roldq(17, iArr, 0, this.subkey, 32);
                int[] iArr7 = this.subkey;
                iArr7[0] = iArr2[0];
                iArr7[1] = iArr2[1];
                iArr7[2] = iArr2[2];
                iArr7[3] = iArr2[3];
                roldq(15, iArr2, 0, iArr7, 8);
                roldq(15, iArr2, 0, this.f59162ke, 0);
                roldq(15, iArr2, 0, iArr4, 0);
                int[] iArr8 = this.subkey;
                iArr8[16] = iArr4[0];
                iArr8[17] = iArr4[1];
                roldq(15, iArr2, 0, iArr8, 20);
                roldqo32(34, iArr2, 0, this.subkey, 28);
                roldq(17, iArr2, 0, this.kw, 4);
                return;
            }
            iArr5[4] = iArr[0];
            iArr5[5] = iArr[1];
            iArr5[6] = iArr[2];
            iArr5[7] = iArr[3];
            decroldq(15, iArr, 0, this.subkey, 28);
            decroldq(30, iArr, 0, this.subkey, 20);
            decroldq(15, iArr, 0, iArr4, 0);
            int[] iArr9 = this.subkey;
            iArr9[16] = iArr4[0];
            iArr9[17] = iArr4[1];
            decroldq(17, iArr, 0, this.f59162ke, 0);
            decroldq(17, iArr, 0, this.subkey, 8);
            decroldq(17, iArr, 0, this.subkey, 0);
            int[] iArr10 = this.subkey;
            iArr10[34] = iArr2[0];
            iArr10[35] = iArr2[1];
            iArr10[32] = iArr2[2];
            iArr10[33] = iArr2[3];
            decroldq(15, iArr2, 0, iArr10, 24);
            decroldq(15, iArr2, 0, this.f59162ke, 4);
            decroldq(15, iArr2, 0, iArr4, 0);
            int[] iArr11 = this.subkey;
            iArr11[18] = iArr4[2];
            iArr11[19] = iArr4[3];
            decroldq(15, iArr2, 0, iArr11, 12);
            decroldqo32(34, iArr2, 0, this.subkey, 4);
            roldq(17, iArr2, 0, this.kw, 0);
            return;
        }
        for (int i13 = 0; i13 < 4; i13++) {
            iArr3[i13] = iArr2[i13] ^ iArr[i13 + 4];
        }
        camelliaF2(iArr3, SIGMA, 8);
        int[] iArr12 = this.kw;
        if (z11) {
            iArr12[0] = iArr[0];
            iArr12[1] = iArr[1];
            iArr12[2] = iArr[2];
            iArr12[3] = iArr[3];
            roldqo32(45, iArr, 0, this.subkey, 16);
            roldq(15, iArr, 0, this.f59162ke, 4);
            roldq(17, iArr, 0, this.subkey, 32);
            roldqo32(34, iArr, 0, this.subkey, 44);
            roldq(15, iArr, 4, this.subkey, 4);
            roldq(15, iArr, 4, this.f59162ke, 0);
            roldq(30, iArr, 4, this.subkey, 24);
            roldqo32(34, iArr, 4, this.subkey, 36);
            roldq(15, iArr2, 0, this.subkey, 8);
            roldq(30, iArr2, 0, this.subkey, 20);
            int[] iArr13 = this.f59162ke;
            iArr13[8] = iArr2[1];
            iArr13[9] = iArr2[2];
            iArr13[10] = iArr2[3];
            iArr13[11] = iArr2[0];
            roldqo32(49, iArr2, 0, this.subkey, 40);
            int[] iArr14 = this.subkey;
            iArr14[0] = iArr3[0];
            iArr14[1] = iArr3[1];
            iArr14[2] = iArr3[2];
            iArr14[3] = iArr3[3];
            roldq(30, iArr3, 0, iArr14, 12);
            roldq(30, iArr3, 0, this.subkey, 28);
            roldqo32(51, iArr3, 0, this.kw, 4);
            return;
        }
        iArr12[4] = iArr[0];
        iArr12[5] = iArr[1];
        iArr12[6] = iArr[2];
        iArr12[7] = iArr[3];
        decroldqo32(45, iArr, 0, this.subkey, 28);
        decroldq(15, iArr, 0, this.f59162ke, 4);
        decroldq(17, iArr, 0, this.subkey, 12);
        decroldqo32(34, iArr, 0, this.subkey, 0);
        decroldq(15, iArr, 4, this.subkey, 40);
        decroldq(15, iArr, 4, this.f59162ke, 8);
        decroldq(30, iArr, 4, this.subkey, 20);
        decroldqo32(34, iArr, 4, this.subkey, 8);
        decroldq(15, iArr2, 0, this.subkey, 36);
        decroldq(30, iArr2, 0, this.subkey, 24);
        int[] iArr15 = this.f59162ke;
        iArr15[2] = iArr2[1];
        iArr15[3] = iArr2[2];
        iArr15[0] = iArr2[3];
        iArr15[1] = iArr2[0];
        decroldqo32(49, iArr2, 0, this.subkey, 4);
        int[] iArr16 = this.subkey;
        iArr16[46] = iArr3[0];
        iArr16[47] = iArr3[1];
        iArr16[44] = iArr3[2];
        iArr16[45] = iArr3[3];
        decroldq(30, iArr3, 0, iArr16, 32);
        decroldq(30, iArr3, 0, this.subkey, 16);
        roldqo32(51, iArr3, 0, this.kw, 0);
    }

    public String getAlgorithmName() {
        return "Camellia";
    }

    public int getBlockSize() {
        return 16;
    }

    public void init(boolean z11, CipherParameters cipherParameters) {
        if (cipherParameters instanceof KeyParameter) {
            setKey(z11, ((KeyParameter) cipherParameters).getKey());
            this.initialized = true;
            return;
        }
        throw new IllegalArgumentException("only simple KeyParameter expected.");
    }

    public BlockCipher newInstance() {
        return new CamelliaLightEngine();
    }

    public int processBlock(byte[] bArr, int i11, byte[] bArr2, int i12) throws IllegalStateException {
        if (!this.initialized) {
            throw new IllegalStateException("Camellia is not initialized");
        } else if (i11 + 16 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        } else if (i12 + 16 <= bArr2.length) {
            return this._keyis128 ? processBlock128(bArr, i11, bArr2, i12) : processBlock192or256(bArr, i11, bArr2, i12);
        } else {
            throw new OutputLengthException("output buffer too short");
        }
    }

    public void reset() {
    }
}
