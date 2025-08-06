package com.zendesk.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;
import mz.f;
import org.bouncycastle.pqc.jcajce.spec.McElieceCCA2KeyGenParameterSpec;

public class DigestUtils {
    public static byte[] a(String str, String str2) {
        if (!f.c(str) || !f.c(str2)) {
            return new byte[0];
        }
        try {
            MessageDigest instance = MessageDigest.getInstance(str);
            instance.update(str2.getBytes());
            return instance.digest();
        } catch (NoSuchAlgorithmException unused) {
            return new byte[0];
        }
    }

    public static String b(byte[] bArr) {
        StringBuilder sb2 = new StringBuilder(bArr.length * 2);
        for (byte b11 : bArr) {
            sb2.append(String.format(Locale.US, "%02x", new Object[]{Integer.valueOf(b11 & 255)}));
        }
        return sb2.toString();
    }

    public static String c(String str) {
        return f.c(str) ? b(a(McElieceCCA2KeyGenParameterSpec.SHA1, str)) : "";
    }
}
