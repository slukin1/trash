package com.huobi.vulcan.core;

import android.util.Base64;
import com.huobi.vulcan.utils.StringUtils;
import com.sumsub.sns.internal.core.common.k;
import com.sumsub.sns.prooface.network.b;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.SignatureException;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import lu.a;

public class CipherUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final Charset f20596a = Charset.forName("UTF-8");

    /* renamed from: b  reason: collision with root package name */
    public static final SecureRandom f20597b = new SecureRandom();

    public static String a(byte[][] bArr) {
        if (bArr == null || bArr.length != 2) {
            return "";
        }
        return f(bArr[0]) + "\n" + f(bArr[1]);
    }

    public static byte[] b(String str) {
        return Base64.decode(str, 2);
    }

    public static String c(String str, String str2, String str3) {
        Charset charset = f20596a;
        byte[] d11 = d(str.getBytes(charset), str2.getBytes(charset), b(str3));
        if (d11 == null) {
            return "";
        }
        return new String(d11, charset);
    }

    public static byte[] d(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        try {
            Cipher instance = Cipher.getInstance(k.f32093a);
            instance.init(2, new SecretKeySpec(bArr, b.f40261d), new IvParameterSpec(bArr2));
            return instance.doFinal(bArr3);
        } catch (GeneralSecurityException e11) {
            e11.printStackTrace();
            return null;
        }
    }

    public static String e(String str) {
        if (StringUtils.d(str)) {
            return "";
        }
        return Base64.encodeToString(str.getBytes(f20596a), 2);
    }

    public static String f(byte[] bArr) {
        return (bArr == null || bArr.length <= 0) ? "" : Base64.encodeToString(bArr, 2).trim();
    }

    public static String g(String str, String str2, String str3) {
        Charset charset = f20596a;
        return f(h(str.getBytes(charset), str2.getBytes(charset), str3.getBytes(charset)));
    }

    public static byte[] h(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        try {
            Cipher instance = Cipher.getInstance(k.f32093a);
            instance.init(1, new SecretKeySpec(bArr, b.f40261d), new IvParameterSpec(bArr2));
            return instance.doFinal(bArr3);
        } catch (GeneralSecurityException e11) {
            e11.printStackTrace();
            return null;
        }
    }

    public static byte[] i(PublicKey publicKey, byte[] bArr) {
        try {
            Cipher instance = Cipher.getInstance("RSA/NONE/PKCS1Padding");
            instance.init(1, publicKey);
            return instance.doFinal(bArr);
        } catch (GeneralSecurityException e11) {
            e11.printStackTrace();
            return null;
        }
    }

    public static byte[][] j() {
        try {
            KeyGenerator instance = KeyGenerator.getInstance(b.f40261d);
            instance.init(256, SecureRandom.getInstance("SHA1PRNG"));
            byte[] encoded = instance.generateKey().getEncoded();
            SecretKeySpec secretKeySpec = new SecretKeySpec(encoded, b.f40261d);
            Cipher instance2 = Cipher.getInstance(k.f32093a);
            instance2.init(3, secretKeySpec);
            return new byte[][]{encoded, instance2.getIV()};
        } catch (Exception e11) {
            e11.printStackTrace();
            return null;
        }
    }

    public static RSAPublicKey k(String str) {
        try {
            return (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(b(str.replaceAll("-----BEGIN PUBLIC KEY-----", "").replaceAll("-----END PUBLIC KEY-----", "").replaceAll("\\s", ""))));
        } catch (GeneralSecurityException e11) {
            e11.printStackTrace();
            return null;
        }
    }

    public static String l(String str, String str2) throws SignatureException {
        try {
            Charset charset = f20596a;
            SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(charset), "HmacSHA256");
            Mac instance = Mac.getInstance("HmacSHA256");
            instance.init(secretKeySpec);
            String encodeToString = Base64.encodeToString(instance.doFinal(str.getBytes(charset)), 2);
            a.b("CipherUtils", "signHmacSha256:" + encodeToString);
            return encodeToString;
        } catch (Exception e11) {
            throw new SignatureException("Failed to generate HMAC : " + e11.getMessage());
        }
    }
}
