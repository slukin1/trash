package com.alibaba.sdk.android.tbrest.utils;

import com.huochat.community.util.FileTool;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Utils {

    /* renamed from: a  reason: collision with root package name */
    public static char[] f14750a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static byte[] a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            MessageDigest instance = MessageDigest.getInstance(FileTool.HASH_TYPE_MD5);
            instance.update(bArr);
            return instance.digest();
        } catch (NoSuchAlgorithmException e11) {
            e11.printStackTrace();
            return null;
        }
    }

    public static String b(byte[] bArr) {
        byte[] a11 = a(bArr);
        return a11 != null ? c(a11) : "0000000000000000";
    }

    public static String c(byte[] bArr) {
        StringBuilder sb2 = new StringBuilder(bArr.length * 2);
        for (byte b11 : bArr) {
            sb2.append(f14750a[(b11 & 240) >>> 4]);
            sb2.append(f14750a[b11 & 15]);
        }
        return sb2.toString();
    }
}
