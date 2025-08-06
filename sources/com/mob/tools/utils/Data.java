package com.mob.tools.utils;

import android.text.TextUtils;
import android.util.Base64;
import com.mob.commons.l;
import com.mob.commons.v;
import com.mob.tools.MobLog;
import com.mob.tools.proguard.PublicMemberKeeper;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.Provider;
import java.security.Security;
import java.util.zip.CRC32;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.spec.SecretKeySpec;

public class Data implements PublicMemberKeeper {
    public static String AES128Decode(String str, byte[] bArr) throws Throwable {
        if (str == null || bArr == null) {
            return null;
        }
        return new String(AES128Decode(str.getBytes("UTF-8"), bArr), "UTF-8").trim();
    }

    public static byte[] AES128Encode(String str, String str2) throws Throwable {
        if (str == null || str2 == null) {
            return null;
        }
        byte[] bytes = str.getBytes("UTF-8");
        byte[] bArr = new byte[16];
        System.arraycopy(bytes, 0, bArr, 0, Math.min(bytes.length, 16));
        return AES128Encode(bArr, str2);
    }

    public static String AES128PaddingDecode(byte[] bArr, byte[] bArr2) throws Throwable {
        if (bArr == null || bArr2 == null) {
            return null;
        }
        byte[] bArr3 = new byte[16];
        System.arraycopy(bArr, 0, bArr3, 0, Math.min(bArr.length, 16));
        return new String(paddingDecode(bArr3, bArr2), "UTF-8").trim();
    }

    public static String Base64AES(String str, String str2) {
        try {
            String encodeToString = Base64.encodeToString(AES128Encode(str2, str), 0);
            if (encodeToString.contains("\n")) {
                return encodeToString.replace("\n", "");
            }
            return encodeToString;
        } catch (Throwable th2) {
            MobLog.getInstance().w(th2);
            return null;
        }
    }

    public static String CRC32(byte[] bArr) throws Throwable {
        CRC32 crc32 = new CRC32();
        crc32.update(bArr);
        long value = crc32.getValue();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(String.format("%02x", new Object[]{Integer.valueOf(((byte) ((int) (value >>> 56))) & 255)}));
        sb2.append(String.format("%02x", new Object[]{Integer.valueOf(((byte) ((int) (value >>> 48))) & 255)}));
        sb2.append(String.format("%02x", new Object[]{Integer.valueOf(((byte) ((int) (value >>> 40))) & 255)}));
        sb2.append(String.format("%02x", new Object[]{Integer.valueOf(((byte) ((int) (value >>> 32))) & 255)}));
        sb2.append(String.format("%02x", new Object[]{Integer.valueOf(((byte) ((int) (value >>> 24))) & 255)}));
        sb2.append(String.format("%02x", new Object[]{Integer.valueOf(((byte) ((int) (value >>> 16))) & 255)}));
        sb2.append(String.format("%02x", new Object[]{Integer.valueOf(((byte) ((int) (value >>> 8))) & 255)}));
        sb2.append(String.format("%02x", new Object[]{Integer.valueOf(((byte) ((int) value)) & 255)}));
        while (sb2.charAt(0) == '0') {
            sb2 = sb2.deleteCharAt(0);
        }
        return sb2.toString().toLowerCase();
    }

    public static byte[] EncodeNoPadding(String str, String str2) throws Throwable {
        if (str == null || str2 == null) {
            return null;
        }
        byte[] bytes = str.getBytes("UTF-8");
        byte[] bArr = new byte[16];
        System.arraycopy(bytes, 0, bArr, 0, Math.min(bytes.length, 16));
        int length = 16 - (str2.length() % 16);
        StringBuilder sb2 = new StringBuilder(str2);
        for (int i11 = 0; i11 < length; i11++) {
            sb2.append(" ");
        }
        byte[] bytes2 = sb2.toString().getBytes("UTF-8");
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, l.a("003Ohfikgn"));
        Cipher cipher = getCipher(l.a("003Fhfikgn") + l.a("003n!ikgf") + l.a("005BhlQn?gifmin") + l.a("006fQfefefk>gRgl"), l.a("0022hlgf"));
        cipher.init(1, secretKeySpec);
        return cipher.doFinal(bytes2);
    }

    public static String MD5(String str) {
        byte[] rawMD5;
        if (str == null || (rawMD5 = rawMD5(str)) == null) {
            return null;
        }
        return bytesToHexFaster(rawMD5);
    }

    public static byte[] SHA1(String str) throws Throwable {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return SHA1(str.getBytes("utf-8"));
    }

    public static String byteToHex(byte[] bArr) {
        return byteToHex(bArr, 0, bArr.length);
    }

    public static String bytesToHexFaster(byte[] bArr) {
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        char[] cArr2 = new char[(bArr.length * 2)];
        int i11 = 0;
        for (byte b11 : bArr) {
            cArr2[i11] = cArr[(b11 >>> 4) & 15];
            int i12 = i11 + 1;
            cArr2[i12] = cArr[b11 & 15];
            i11 = i12 + 1;
        }
        return new String(cArr2);
    }

    public static Cipher getCipher(String str, String str2) throws Throwable {
        Cipher cipher = null;
        if (!TextUtils.isEmpty(str2)) {
            try {
                Provider provider = Security.getProvider(str2);
                if (provider != null) {
                    cipher = Cipher.getInstance(str, provider);
                }
            } catch (Throwable unused) {
            }
        }
        return cipher == null ? Cipher.getInstance(str, str2) : cipher;
    }

    public static byte[] paddingDecode(byte[] bArr, byte[] bArr2) throws Throwable {
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, l.a("0031hfikgn"));
        Cipher cipher = getCipher(l.a("003?hfikgn") + l.a("003nLikgf") + l.a("008,hl0nJinkegfgnkmin") + l.a("006fHfefefk]gDgl"), l.a("002Qhlgf"));
        cipher.init(2, secretKeySpec);
        return cipher.doFinal(bArr2);
    }

    public static byte[] rawMD5(String str) {
        if (str == null) {
            return null;
        }
        try {
            return rawMD5(str.getBytes("utf-8"));
        } catch (Throwable th2) {
            MobLog.getInstance().w(th2);
            return null;
        }
    }

    public static String urlEncode(String str) {
        try {
            return urlEncode(str, "utf-8");
        } catch (Throwable th2) {
            MobLog.getInstance().w(th2);
            return null;
        }
    }

    public static String byteToHex(byte[] bArr, int i11, int i12) {
        StringBuffer stringBuffer = new StringBuffer();
        if (bArr == null) {
            return stringBuffer.toString();
        }
        while (i11 < i12) {
            stringBuffer.append(String.format("%02x", new Object[]{Byte.valueOf(bArr[i11])}));
            i11++;
        }
        return stringBuffer.toString();
    }

    public static String MD5(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return MD5(bArr, 0, bArr.length);
    }

    public static byte[] rawMD5(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return rawMD5(bArr, 0, bArr.length);
    }

    public static String urlEncode(String str, String str2) throws Throwable {
        String encode = TextUtils.isEmpty(str) ? "" : URLEncoder.encode(str, str2);
        if (TextUtils.isEmpty(encode)) {
            return encode;
        }
        return encode.replace("+", "%20");
    }

    public static byte[] AES128Decode(byte[] bArr, byte[] bArr2) throws Throwable {
        if (bArr == null || bArr2 == null) {
            return null;
        }
        byte[] bArr3 = new byte[16];
        System.arraycopy(bArr, 0, bArr3, 0, Math.min(bArr.length, 16));
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr3, l.a("003'hfikgn"));
        Cipher cipher = getCipher(l.a("0032hfikgn") + l.a("003n_ikgf") + l.a("005-hl?n$gifmin") + l.a("006f fefefkSg_gl"), l.a("002_hlgf"));
        cipher.init(2, secretKeySpec);
        byte[] bArr4 = new byte[cipher.getOutputSize(bArr2.length)];
        cipher.doFinal(bArr4, cipher.update(bArr2, 0, bArr2.length, bArr4, 0));
        return bArr4;
    }

    public static byte[] AES128Encode(byte[] bArr, String str) throws Throwable {
        if (bArr == null || str == null) {
            return null;
        }
        return AES128Encode(bArr, str.getBytes("UTF-8"));
    }

    public static String MD5(byte[] bArr, int i11, int i12) {
        byte[] rawMD5;
        if (bArr == null || (rawMD5 = rawMD5(bArr, i11, i12)) == null) {
            return null;
        }
        return bytesToHexFaster(rawMD5);
    }

    public static byte[] SHA1(byte[] bArr) throws Throwable {
        MessageDigest instance = MessageDigest.getInstance(l.a("005-gnhmhfjmjh"));
        instance.update(bArr);
        return instance.digest();
    }

    public static byte[] rawMD5(byte[] bArr, int i11, int i12) {
        ByteArrayInputStream byteArrayInputStream;
        byte[] bArr2 = null;
        if (bArr == null) {
            return null;
        }
        try {
            byteArrayInputStream = new ByteArrayInputStream(bArr, i11, i12);
            try {
                bArr2 = rawMD5((InputStream) byteArrayInputStream);
                v.a(byteArrayInputStream);
            } catch (Throwable th2) {
                th = th2;
                try {
                    MobLog.getInstance().w(th);
                    return bArr2;
                } finally {
                    v.a(byteArrayInputStream);
                }
            }
        } catch (Throwable th3) {
            th = th3;
            byteArrayInputStream = null;
            MobLog.getInstance().w(th);
            return bArr2;
        }
        return bArr2;
    }

    public static byte[] AES128Encode(byte[] bArr, byte[] bArr2) throws Throwable {
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, l.a("003[hfikgn"));
        Cipher cipher = getCipher(l.a("003Khfikgn") + l.a("003nHikgf") + l.a("008=hlLnYinkegfgnkmin") + l.a("006f1fefefk<g8gl"), l.a("002Rhlgf"));
        cipher.init(1, secretKeySpec);
        byte[] bArr3 = new byte[cipher.getOutputSize(bArr2.length)];
        cipher.doFinal(bArr3, cipher.update(bArr2, 0, bArr2.length, bArr3, 0));
        return bArr3;
    }

    public static String MD5(File file) {
        FileInputStream fileInputStream;
        if (file == null || !file.exists()) {
            return null;
        }
        try {
            fileInputStream = new FileInputStream(file);
            try {
                byte[] rawMD5 = rawMD5((InputStream) fileInputStream);
                v.a(fileInputStream);
                if (rawMD5 == null) {
                    return null;
                }
                return bytesToHexFaster(rawMD5);
            } catch (Throwable th2) {
                th = th2;
                try {
                    MobLog.getInstance().w(th);
                    return null;
                } finally {
                    v.a(fileInputStream);
                }
            }
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
            MobLog.getInstance().w(th);
            return null;
        }
    }

    public static byte[] rawMD5(InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        try {
            byte[] bArr = new byte[1024];
            MessageDigest instance = MessageDigest.getInstance(l.a("003$jehnjk"));
            int read = inputStream.read(bArr);
            while (read != -1) {
                instance.update(bArr, 0, read);
                read = inputStream.read(bArr);
            }
            return instance.digest();
        } catch (Throwable th2) {
            MobLog.getInstance().w(th2);
            return null;
        }
    }

    public static void AES128Decode(String str, InputStream inputStream, OutputStream outputStream) throws Throwable {
        if (str != null) {
            AES128Decode(str.getBytes("UTF-8"), inputStream, outputStream);
        }
    }

    public static void AES128Decode(byte[] bArr, InputStream inputStream, OutputStream outputStream) throws Throwable {
        Throwable th2;
        CipherInputStream cipherInputStream;
        if (bArr != null && inputStream != null && outputStream != null) {
            byte[] bArr2 = new byte[16];
            System.arraycopy(bArr, 0, bArr2, 0, Math.min(bArr.length, 16));
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, l.a("003>hfikgn"));
            Cipher cipher = getCipher(l.a("003^hfikgn") + l.a("003n>ikgf") + l.a("008*hl+n)inkegfgnkmin") + l.a("006fFfefefk]gTgl"), l.a("002Bhlgf"));
            cipher.init(2, secretKeySpec);
            try {
                cipherInputStream = new CipherInputStream(inputStream, cipher);
                try {
                    byte[] bArr3 = new byte[1024];
                    for (int read = cipherInputStream.read(bArr3); read != -1; read = cipherInputStream.read(bArr3)) {
                        outputStream.write(bArr3, 0, read);
                    }
                    outputStream.flush();
                    v.a(cipherInputStream);
                } catch (Throwable th3) {
                    th2 = th3;
                    v.a(cipherInputStream);
                    throw th2;
                }
            } catch (Throwable th4) {
                cipherInputStream = null;
                th2 = th4;
                v.a(cipherInputStream);
                throw th2;
            }
        }
    }
}
