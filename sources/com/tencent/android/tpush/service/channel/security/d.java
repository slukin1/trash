package com.tencent.android.tpush.service.channel.security;

import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class d {

    /* renamed from: a  reason: collision with root package name */
    private static RSAPublicKey f69675a;

    public static RSAPublicKey a(String str) {
        try {
            return (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(a.a(str, 0)));
        } catch (NoSuchAlgorithmException unused) {
            throw new Exception("无此算法");
        } catch (InvalidKeySpecException unused2) {
            throw new Exception("公钥非法");
        } catch (NullPointerException unused3) {
            throw new Exception("公钥数据为空");
        }
    }

    public static String a(byte[] bArr, RSAPublicKey rSAPublicKey) {
        try {
            Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            instance.init(2, rSAPublicKey);
            int bitLength = rSAPublicKey.getModulus().bitLength() / 8;
            if (bitLength != 0) {
                String str = "";
                for (byte[] bArr2 : a(bArr, bitLength)) {
                    str = str + new String(instance.doFinal(bArr2), "UTF-8");
                }
                return str;
            }
            throw new Exception("模长为0");
        } catch (NoSuchAlgorithmException unused) {
            throw new Exception("无此解密算法");
        } catch (NoSuchPaddingException e11) {
            e11.printStackTrace();
            return null;
        } catch (InvalidKeyException unused2) {
            throw new Exception("解密私钥非法,请检查");
        } catch (IllegalBlockSizeException unused3) {
            throw new Exception("密文长度非法");
        } catch (BadPaddingException unused4) {
            throw new Exception("密文数据已损坏");
        }
    }

    public static byte[][] a(byte[] bArr, int i11) {
        int length = bArr.length / i11;
        int length2 = bArr.length % i11;
        int i12 = length + (length2 != 0 ? 1 : 0);
        byte[][] bArr2 = new byte[i12][];
        for (int i13 = 0; i13 < i12; i13++) {
            byte[] bArr3 = new byte[i11];
            if (i13 != i12 - 1 || length2 == 0) {
                System.arraycopy(bArr, i13 * i11, bArr3, 0, i11);
            } else {
                System.arraycopy(bArr, i13 * i11, bArr3, 0, length2);
            }
            bArr2[i13] = bArr3;
        }
        return bArr2;
    }
}
