package uy;

import com.huochat.community.util.FileTool;
import com.ta.a.e.h;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class d {

    /* renamed from: a  reason: collision with root package name */
    public static final char[] f40593a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String a(String str, String str2) {
        try {
            byte[] d11 = d(str.getBytes(), str2.getBytes());
            if (d11 != null) {
                return b(d11);
            }
            return "0000000000000000";
        } catch (Exception e11) {
            h.e("", e11);
            return "0000000000000000";
        }
    }

    public static String b(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder(bArr.length * 2);
        for (int i11 = 0; i11 < bArr.length; i11++) {
            char[] cArr = f40593a;
            sb2.append(cArr[(bArr[i11] & 240) >>> 4]);
            sb2.append(cArr[bArr[i11] & 15]);
        }
        return sb2.toString();
    }

    public static byte[] c(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            MessageDigest instance = MessageDigest.getInstance(FileTool.HASH_TYPE_MD5);
            instance.update(bArr);
            return instance.digest();
        } catch (Exception e11) {
            h.d("", e11, new Object[0]);
            return null;
        }
    }

    public static byte[] d(byte[] bArr, byte[] bArr2) throws NoSuchAlgorithmException {
        byte[] bArr3 = new byte[64];
        byte[] bArr4 = new byte[64];
        for (int i11 = 0; i11 < 64; i11++) {
            bArr3[i11] = 54;
            bArr4[i11] = 92;
        }
        byte[] bArr5 = new byte[64];
        if (bArr.length > 64) {
            bArr = c(bArr);
        }
        for (int i12 = 0; i12 < bArr.length; i12++) {
            bArr5[i12] = bArr[i12];
        }
        if (bArr.length < 64) {
            for (int length = bArr.length; length < 64; length++) {
                bArr5[length] = 0;
            }
        }
        byte[] bArr6 = new byte[64];
        for (int i13 = 0; i13 < 64; i13++) {
            bArr6[i13] = (byte) (bArr5[i13] ^ bArr3[i13]);
        }
        byte[] bArr7 = new byte[(bArr2.length + 64)];
        for (int i14 = 0; i14 < 64; i14++) {
            bArr7[i14] = bArr6[i14];
        }
        for (int i15 = 0; i15 < bArr2.length; i15++) {
            bArr7[i15 + 64] = bArr2[i15];
        }
        byte[] c11 = c(bArr7);
        byte[] bArr8 = new byte[64];
        for (int i16 = 0; i16 < 64; i16++) {
            bArr8[i16] = (byte) (bArr5[i16] ^ bArr4[i16]);
        }
        byte[] bArr9 = new byte[(c11.length + 64)];
        for (int i17 = 0; i17 < 64; i17++) {
            bArr9[i17] = bArr8[i17];
        }
        for (int i18 = 0; i18 < c11.length; i18++) {
            bArr9[i18 + 64] = c11[i18];
        }
        return c(bArr9);
    }

    public static String e(String str) {
        return a(f(), str);
    }

    public static String f() {
        byte[] bytes = "QrMgt8GGYI6T52ZY5AnhtxkLzb8egpFn".getBytes();
        byte b11 = 0;
        while (b11 < 32) {
            try {
                bytes[b11] = (byte) (bytes[b11] + b11);
                b11 = (byte) (b11 + 1);
            } catch (Exception unused) {
                return null;
            }
        }
        return b(bytes);
    }
}
