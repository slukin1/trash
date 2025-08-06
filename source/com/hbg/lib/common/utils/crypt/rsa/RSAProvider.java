package com.hbg.lib.common.utils.crypt.rsa;

import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

public class RSAProvider {

    /* renamed from: a  reason: collision with root package name */
    public static int f67560a = (1024 / 8);

    /* renamed from: b  reason: collision with root package name */
    public static int f67561b = 110;

    public static byte[] a(byte[] bArr, String str) throws Exception {
        if (bArr != null) {
            PrivateKey e11 = e(str);
            Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            instance.init(2, e11);
            return instance.doFinal(bArr);
        }
        throw new IllegalArgumentException("Input data is null");
    }

    public static byte[] b(byte[] bArr, String str) throws Exception {
        if (bArr != null) {
            byte[] bArr2 = new byte[0];
            for (int i11 = 0; i11 < bArr.length; i11 += f67560a) {
                bArr2 = ArrayUtils.a(bArr2, a(ArrayUtils.c(bArr, i11, Math.min(f67560a + i11, bArr.length)), str));
            }
            return bArr2;
        }
        throw new IllegalArgumentException("Input data is null");
    }

    public static byte[] c(byte[] bArr, String str) throws Exception {
        if (bArr != null) {
            PublicKey f11 = f(str);
            Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            instance.init(1, f11);
            return instance.doFinal(bArr);
        }
        throw new IllegalArgumentException("Input data is null");
    }

    public static byte[] d(byte[] bArr, String str) throws Exception {
        if (bArr != null) {
            byte[] bArr2 = new byte[0];
            for (int i11 = 0; i11 < bArr.length; i11 += f67561b) {
                bArr2 = ArrayUtils.a(bArr2, c(ArrayUtils.c(bArr, i11, f67561b + i11), str));
            }
            return bArr2;
        }
        throw new IllegalArgumentException("Input encryption data is null");
    }

    public static PrivateKey e(String str) throws Exception {
        try {
            return KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(Base64Utils.a(str)));
        } catch (NoSuchAlgorithmException unused) {
            throw new Exception("无此算法");
        } catch (InvalidKeySpecException unused2) {
            throw new Exception("私钥非法");
        } catch (NullPointerException unused3) {
            throw new Exception("私钥数据为空");
        }
    }

    public static PublicKey f(String str) throws Exception {
        try {
            return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64Utils.a(str)));
        } catch (NoSuchAlgorithmException unused) {
            throw new Exception("无此算法");
        } catch (InvalidKeySpecException unused2) {
            throw new Exception("公钥非法");
        } catch (NullPointerException unused3) {
            throw new Exception("公钥数据为空");
        }
    }
}
