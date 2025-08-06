package com.huochat.community.util;

import android.text.TextUtils;
import android.util.Base64;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptTool {
    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    private EncryptTool() {
    }

    public static String base64Decode(String str) {
        return new String(Base64.decode(str, 0), Charset.forName("utf-8"));
    }

    public static String base64Encode(String str) {
        return new String(Base64.encode(str.getBytes(), 0), Charset.forName("utf-8"));
    }

    public static String bytes2HexString(byte[] bArr) {
        char[] cArr = new char[(bArr.length << 1)];
        int i11 = 0;
        for (int i12 = 0; i12 < bArr.length; i12++) {
            int i13 = i11 + 1;
            char[] cArr2 = HEX_DIGITS;
            cArr[i11] = cArr2[(bArr[i12] >>> 4) & 15];
            i11 = i13 + 1;
            cArr[i13] = cArr2[bArr[i12] & 15];
        }
        return new String(cArr);
    }

    private static byte[] encryptAlgorithm(byte[] bArr, String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance(str);
            instance.update(bArr);
            return instance.digest();
        } catch (NoSuchAlgorithmException e11) {
            e11.printStackTrace();
            return new byte[0];
        }
    }

    public static byte[] encryptMD5(byte[] bArr) {
        return encryptAlgorithm(bArr, FileTool.HASH_TYPE_MD5);
    }

    public static String encryptMD5ToString(String str) {
        return encryptMD5ToString(str.getBytes());
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0046 A[SYNTHETIC, Splitter:B:21:0x0046] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x004c A[SYNTHETIC, Splitter:B:26:0x004c] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getFileMD5(java.io.File r9) {
        /*
            boolean r0 = r9.exists()
            java.lang.String r1 = ""
            if (r0 != 0) goto L_0x0009
            return r1
        L_0x0009:
            r0 = 0
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ NoSuchAlgorithmException -> 0x0040, IOException -> 0x003e }
            r2.<init>(r9)     // Catch:{ NoSuchAlgorithmException -> 0x0040, IOException -> 0x003e }
            java.nio.channels.FileChannel r3 = r2.getChannel()     // Catch:{ NoSuchAlgorithmException -> 0x0039, IOException -> 0x0037, all -> 0x0034 }
            java.nio.channels.FileChannel$MapMode r4 = java.nio.channels.FileChannel.MapMode.READ_ONLY     // Catch:{ NoSuchAlgorithmException -> 0x0039, IOException -> 0x0037, all -> 0x0034 }
            r5 = 0
            long r7 = r9.length()     // Catch:{ NoSuchAlgorithmException -> 0x0039, IOException -> 0x0037, all -> 0x0034 }
            java.nio.MappedByteBuffer r9 = r3.map(r4, r5, r7)     // Catch:{ NoSuchAlgorithmException -> 0x0039, IOException -> 0x0037, all -> 0x0034 }
            java.lang.String r0 = "MD5"
            java.security.MessageDigest r0 = java.security.MessageDigest.getInstance(r0)     // Catch:{ NoSuchAlgorithmException -> 0x0039, IOException -> 0x0037, all -> 0x0034 }
            r0.update(r9)     // Catch:{ NoSuchAlgorithmException -> 0x0039, IOException -> 0x0037, all -> 0x0034 }
            byte[] r9 = r0.digest()     // Catch:{ NoSuchAlgorithmException -> 0x0039, IOException -> 0x0037, all -> 0x0034 }
            java.lang.String r9 = bytes2HexString(r9)     // Catch:{ NoSuchAlgorithmException -> 0x0039, IOException -> 0x0037, all -> 0x0034 }
            r2.close()     // Catch:{ IOException -> 0x0033 }
        L_0x0033:
            return r9
        L_0x0034:
            r9 = move-exception
            r0 = r2
            goto L_0x004a
        L_0x0037:
            r9 = move-exception
            goto L_0x003a
        L_0x0039:
            r9 = move-exception
        L_0x003a:
            r0 = r2
            goto L_0x0041
        L_0x003c:
            r9 = move-exception
            goto L_0x004a
        L_0x003e:
            r9 = move-exception
            goto L_0x0041
        L_0x0040:
            r9 = move-exception
        L_0x0041:
            i6.d.g(r9)     // Catch:{ all -> 0x003c }
            if (r0 == 0) goto L_0x0049
            r0.close()     // Catch:{ IOException -> 0x0049 }
        L_0x0049:
            return r1
        L_0x004a:
            if (r0 == 0) goto L_0x004f
            r0.close()     // Catch:{ IOException -> 0x004f }
        L_0x004f:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huochat.community.util.EncryptTool.getFileMD5(java.io.File):java.lang.String");
    }

    public static String md5(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            String str2 = "";
            for (byte b11 : MessageDigest.getInstance(FileTool.HASH_TYPE_MD5).digest(str.getBytes())) {
                String hexString = Integer.toHexString(b11 & 255);
                if (hexString.length() == 1) {
                    hexString = "0" + hexString;
                }
                str2 = str2 + hexString;
            }
            return str2;
        } catch (NoSuchAlgorithmException e11) {
            e11.printStackTrace();
            return "";
        }
    }

    public static String encryptMD5ToString(String str, String str2) {
        return bytes2HexString(encryptMD5((str + str2).getBytes()));
    }

    public static String encryptMD5ToString(byte[] bArr) {
        return bytes2HexString(encryptMD5(bArr));
    }

    public static String encryptMD5ToString(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[(bArr.length + bArr2.length)];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
        return bytes2HexString(encryptMD5(bArr3));
    }
}
