package com.hbg.lib.core.util;

import android.util.Base64;
import com.sumsub.sns.prooface.network.b;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f68688a = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    /* renamed from: b  reason: collision with root package name */
    public static boolean f68689b = false;

    public static String a(String str) {
        try {
            return new String(b(e("asdfhajdsh1238@&*^@#"), f68688a, Base64.decode(str, 2)), "UTF-8");
        } catch (Exception unused) {
            return null;
        }
    }

    public static byte[] b(SecretKeySpec secretKeySpec, byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS7Padding");
        instance.init(2, secretKeySpec, new IvParameterSpec(bArr));
        return instance.doFinal(bArr2);
    }

    public static String c(String str) {
        try {
            return Base64.encodeToString(d(e("asdfhajdsh1238@&*^@#"), f68688a, str.getBytes("UTF-8")), 2);
        } catch (Exception unused) {
            return null;
        }
    }

    public static byte[] d(SecretKeySpec secretKeySpec, byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS7Padding");
        instance.init(1, secretKeySpec, new IvParameterSpec(bArr));
        return instance.doFinal(bArr2);
    }

    public static SecretKeySpec e(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest instance = MessageDigest.getInstance("SHA-256");
        byte[] bytes = str.getBytes("UTF-8");
        instance.update(bytes, 0, bytes.length);
        return new SecretKeySpec(instance.digest(), b.f40261d);
    }
}
