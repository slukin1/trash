package com.xiaomi.push;

import android.text.TextUtils;
import com.google.common.base.Ascii;
import com.huochat.community.util.FileTool;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class bb {
    private static String a(byte b11) {
        int i11 = (b11 & Ascii.DEL) + (b11 < 0 ? (byte) 128 : 0);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(i11 < 16 ? "0" : "");
        sb2.append(Integer.toHexString(i11).toLowerCase());
        return sb2.toString();
    }

    public static String b(String str) {
        return a(str).subSequence(8, 24).toString();
    }

    public static String a(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance(FileTool.HASH_TYPE_MD5);
            StringBuffer stringBuffer = new StringBuffer();
            instance.update(str.getBytes(), 0, str.length());
            byte[] digest = instance.digest();
            for (byte a11 : digest) {
                stringBuffer.append(a(a11));
            }
            return stringBuffer.toString();
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public static byte[] m2432a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            MessageDigest instance = MessageDigest.getInstance(FileTool.HASH_TYPE_MD5);
            instance.update(str.getBytes());
            return instance.digest();
        } catch (Exception unused) {
            return null;
        }
    }
}
