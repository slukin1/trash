package com.engagelab.privates.common.utils;

import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import java.util.Arrays;
import net.sf.scuba.smartcards.ISO7816;
import net.sf.scuba.smartcards.ISOFileInfo;
import okio.Utf8;
import org.bouncycastle.crypto.signers.PSSSigner;
import org.jmrtd.lds.CVCAFile;

public class SM4Util {
    private static final int BLOCK = 16;
    private static int[] CK = {462357, 472066609, 943670861, 1415275113, 1886879365, -1936483679, -1464879427, -993275175, -521670923, -66909679, 404694573, 876298825, 1347903077, 1819507329, -2003855715, -1532251463, -1060647211, -589042959, -117504499, 337322537, 808926789, 1280531041, 1752135293, -2071227751, -1599623499, -1128019247, -656414995, -184876535, 269950501, 741554753, 1213159005, 1684763257};
    private static final int ROUND = 32;
    private static byte[] Sbox = {ISO7816.INS_UPDATE_BINARY, -112, -23, -2, -52, -31, 61, -73, 22, ISO7816.INS_READ_RECORD_STAMPED, 20, ISO7816.INS_ENVELOPE, 40, -5, ISO7816.INS_UNBLOCK_CHV, 5, 43, 103, -102, 118, ISO7816.INS_PSO, -66, 4, -61, -86, ISO7816.INS_REHABILITATE_CHV, 19, 38, 73, -122, 6, -103, -100, CVCAFile.CAR_TAG, 80, -12, -111, -17, -104, 122, 51, 84, 11, 67, -19, -49, -84, ISOFileInfo.FCP_BYTE, ISO7816.INS_DELETE_FILE, ISO7816.INS_READ_RECORD2, 28, -87, -55, 8, -24, -107, Byte.MIN_VALUE, -33, -108, -6, 117, -113, Utf8.REPLACEMENT_BYTE, -90, 71, 7, -89, -4, -13, 115, 23, -70, ISOFileInfo.FILE_IDENTIFIER, 89, 60, Ascii.EM, -26, ISOFileInfo.PROP_INFO, 79, -88, 104, 107, ISOFileInfo.DATA_BYTES2, -78, 113, 100, ISO7816.INS_PUT_DATA, ISOFileInfo.SECURITY_ATTR_EXP, -8, -21, 15, 75, ISO7816.INS_MANAGE_CHANNEL, 86, -99, 53, 30, ISO7816.INS_CHANGE_CHV, 14, 94, 99, 88, -47, -94, 37, ISO7816.INS_MSE, 124, 59, 1, Framer.ENTER_FRAME_PREFIX, Framer.EXIT_FRAME_PREFIX, ISOFileInfo.FCI_EXT, -44, 0, 70, 87, -97, -45, 39, 82, 76, 54, 2, -25, ISOFileInfo.A0, -60, -56, -98, -22, -65, ISOFileInfo.LCS_BYTE, ISO7816.INS_WRITE_RECORD, SignedBytes.MAX_POWER_OF_TWO, -57, 56, -75, -93, -9, -14, -50, -7, 97, 21, ISOFileInfo.A1, ISO7816.INS_CREATE_FILE, -82, 93, -92, -101, ISO7816.INS_DECREASE_STAMPED, Ascii.SUB, 85, -83, -109, 50, ISO7816.INS_DECREASE, -11, ISOFileInfo.SECURITY_ATTR_COMPACT, ISO7816.INS_READ_BINARY2, -29, 29, -10, ISO7816.INS_APPEND_RECORD, 46, -126, 102, ISO7816.INS_GET_DATA, 96, ISO7816.INS_GET_RESPONSE, 41, 35, ISOFileInfo.AB, 13, 83, 78, ISOFileInfo.FCI_BYTE, -43, -37, 55, 69, -34, -3, ISOFileInfo.CHANNEL_SECURITY, 47, 3, -1, 106, 114, 109, 108, 91, 81, ISOFileInfo.ENV_TEMP_EF, Ascii.ESC, -81, -110, -69, -35, PSSSigner.TRAILER_IMPLICIT, Ascii.DEL, 17, -39, 92, 65, Ascii.US, 16, 90, ISO7816.INS_LOAD_KEY_FILE, 10, -63, Framer.STDOUT_FRAME_PREFIX, -120, ISOFileInfo.A5, -51, 123, -67, Framer.STDIN_FRAME_PREFIX, 116, ISO7816.INS_WRITE_BINARY, 18, -72, -27, ISO7816.INS_READ_BINARY_STAMPED, ISO7816.INS_READ_BINARY, -119, 105, -105, 74, 12, -106, 119, 126, 101, -71, -15, 9, -59, 110, -58, -124, Ascii.CAN, -16, 125, -20, 58, ISO7816.INS_UPDATE_RECORD, 77, 32, 121, -18, 95, 62, -41, -53, 57, 72};
    private static final String TAG = "SM4";

    private static int ByteSub(int i11) {
        byte[] bArr = Sbox;
        return (bArr[i11 & 255] & 255) | ((bArr[(i11 >>> 24) & 255] & 255) << Ascii.CAN) | ((bArr[(i11 >>> 16) & 255] & 255) << 16) | ((bArr[(i11 >>> 8) & 255] & 255) << 8);
    }

    private static int L1(int i11) {
        return Rotl(i11, 24) ^ (((Rotl(i11, 2) ^ i11) ^ Rotl(i11, 10)) ^ Rotl(i11, 18));
    }

    private static int L2(int i11) {
        return Rotl(i11, 23) ^ (Rotl(i11, 13) ^ i11);
    }

    private static int[] L3(byte[] bArr) {
        int[] iArr = new int[4];
        for (int i11 = 0; i11 < 4; i11++) {
            int i12 = i11 * 4;
            iArr[i11] = (bArr[i12 + 3] & 255) | ((bArr[i12] & 255) << Ascii.CAN) | ((bArr[i12 + 1] & 255) << 16) | ((bArr[i12 + 2] & 255) << 8);
        }
        return iArr;
    }

    private static int Rotl(int i11, int i12) {
        return (i11 >>> (32 - i12)) | (i11 << i12);
    }

    private static void cbcXor(byte[] bArr, byte[] bArr2) {
        for (int i11 = 0; i11 < bArr.length; i11++) {
            bArr[i11] = (byte) (bArr[i11] ^ bArr2[i11]);
        }
    }

    public static byte[] decode(byte[] bArr, byte[] bArr2, byte[] bArr3) throws Exception {
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        if (bArr2 == null || bArr2.length != 16) {
            throw new IllegalArgumentException("key's length should be 16");
        }
        if (!(bArr3 == null || bArr3.length == 16)) {
            bArr3 = null;
        }
        int[] sm4KeyExt = sm4KeyExt(bArr2, true);
        byte[] bArr4 = new byte[16];
        byte[] bArr5 = new byte[16];
        byte[] bArr6 = new byte[bArr.length];
        int i11 = 0;
        while (true) {
            int i12 = i11 + 16;
            if (i12 > bArr.length) {
                return revertPkcs7Padding(bArr6);
            }
            System.arraycopy(bArr, i11, bArr4, 0, 16);
            sm4Crypt(bArr4, bArr5, sm4KeyExt);
            if (bArr3 != null) {
                cbcXor(bArr5, bArr3);
            } else {
                bArr3 = new byte[16];
            }
            System.arraycopy(bArr, i11, bArr3, 0, 16);
            System.arraycopy(bArr5, 0, bArr6, i11, 16);
            i11 = i12;
        }
    }

    public static byte[] decryptBytes(byte[] bArr, String str) throws Exception {
        return decode(bArr, hexStringToByte(str), str.substring(0, 16).getBytes("utf-8"));
    }

    public static byte[] encode(byte[] bArr, byte[] bArr2, byte[] bArr3) throws Exception {
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        if (bArr2 == null || bArr2.length != 16) {
            throw new IllegalArgumentException("key's length should be 16");
        }
        if (!(bArr3 == null || bArr3.length == 16)) {
            bArr3 = null;
        }
        byte[] pkcs7padding = pkcs7padding(bArr);
        int[] sm4KeyExt = sm4KeyExt(bArr2, false);
        byte[] bArr4 = new byte[16];
        byte[] bArr5 = new byte[pkcs7padding.length];
        int i11 = 0;
        while (true) {
            int i12 = i11 + 16;
            if (i12 > pkcs7padding.length) {
                return bArr5;
            }
            System.arraycopy(pkcs7padding, i11, bArr4, 0, 16);
            if (bArr3 != null) {
                cbcXor(bArr4, bArr3);
            } else {
                bArr3 = new byte[16];
            }
            sm4Crypt(bArr4, bArr3, sm4KeyExt);
            System.arraycopy(bArr3, 0, bArr5, i11, bArr3.length);
            i11 = i12;
        }
    }

    public static byte[] encryptBytes(byte[] bArr, String str, String str2) throws Exception {
        return encode(bArr, hexStringToByte(str), str2.getBytes("utf-8"));
    }

    public static byte[] hexStringToByte(String str) {
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        char[] charArray = str.toLowerCase().toCharArray();
        for (int i11 = 0; i11 < length; i11++) {
            int i12 = i11 * 2;
            bArr[i11] = (byte) (toByte(charArray[i12 + 1]) | (toByte(charArray[i12]) << 4));
        }
        return bArr;
    }

    private static byte[] pkcs7padding(byte[] bArr) {
        int length = 16 - (bArr.length % 16);
        byte[] copyOf = Arrays.copyOf(bArr, bArr.length + length);
        for (int i11 = 0; i11 < length; i11++) {
            copyOf[bArr.length + i11] = (byte) length;
        }
        return copyOf;
    }

    private static byte[] revertPkcs7Padding(byte[] bArr) {
        int length = bArr.length - bArr[bArr.length - 1];
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        return bArr2;
    }

    public static void sm4Crypt(byte[] bArr, byte[] bArr2, int[] iArr) {
        int[] L3 = L3(bArr);
        for (int i11 = 0; i11 < 32; i11 += 4) {
            L3[0] = L3[0] ^ L1(ByteSub(((L3[1] ^ L3[2]) ^ L3[3]) ^ iArr[i11]));
            L3[1] = L3[1] ^ L1(ByteSub(((L3[2] ^ L3[3]) ^ L3[0]) ^ iArr[i11 + 1]));
            L3[2] = L3[2] ^ L1(ByteSub(((L3[3] ^ L3[0]) ^ L3[1]) ^ iArr[i11 + 2]));
            L3[3] = L3[3] ^ L1(ByteSub(((L3[1] ^ L3[0]) ^ L3[2]) ^ iArr[i11 + 3]));
        }
        for (int i12 = 0; i12 < 16; i12 += 4) {
            int i13 = 3 - (i12 / 4);
            bArr2[i12] = (byte) ((L3[i13] >>> 24) & 255);
            bArr2[i12 + 1] = (byte) ((L3[i13] >>> 16) & 255);
            bArr2[i12 + 2] = (byte) ((L3[i13] >>> 8) & 255);
            bArr2[i12 + 3] = (byte) (L3[i13] & 255);
        }
    }

    public static int[] sm4KeyExt(byte[] bArr, boolean z11) {
        int[] L3 = L3(bArr);
        L3[0] = L3[0] ^ -1548633402;
        L3[1] = L3[1] ^ 1453994832;
        L3[2] = L3[2] ^ 1736282519;
        L3[3] = L3[3] ^ -1301273892;
        int[] iArr = new int[32];
        for (int i11 = 0; i11 < 32; i11 += 4) {
            int L2 = L3[0] ^ L2(ByteSub(((L3[1] ^ L3[2]) ^ L3[3]) ^ CK[i11]));
            L3[0] = L2;
            iArr[i11] = L2;
            int i12 = i11 + 1;
            int L22 = L3[1] ^ L2(ByteSub(((L3[2] ^ L3[3]) ^ L3[0]) ^ CK[i12]));
            L3[1] = L22;
            iArr[i12] = L22;
            int i13 = i11 + 2;
            int L23 = L3[2] ^ L2(ByteSub(((L3[3] ^ L3[0]) ^ L3[1]) ^ CK[i13]));
            L3[2] = L23;
            iArr[i13] = L23;
            int i14 = i11 + 3;
            int L24 = L3[3] ^ L2(ByteSub(((L3[0] ^ L3[1]) ^ L3[2]) ^ CK[i14]));
            L3[3] = L24;
            iArr[i14] = L24;
        }
        if (z11) {
            for (int i15 = 0; i15 < 16; i15++) {
                int i16 = iArr[i15];
                int i17 = 31 - i15;
                iArr[i15] = iArr[i17];
                iArr[i17] = i16;
            }
        }
        return iArr;
    }

    private static int toByte(char c11) {
        return (byte) "0123456789abcdef".indexOf(c11);
    }

    public static String toHexString(byte[] bArr) {
        if (bArr == null || bArr.length < 1) {
            throw new IllegalArgumentException("this byteArray must not be null or empty");
        }
        StringBuilder sb2 = new StringBuilder();
        for (byte b11 : bArr) {
            byte b12 = b11 & 255;
            if (b12 < 16) {
                sb2.append("0");
            }
            sb2.append(Integer.toHexString(b12));
        }
        return sb2.toString().toLowerCase();
    }
}
