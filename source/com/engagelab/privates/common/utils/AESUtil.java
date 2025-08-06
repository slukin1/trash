package com.engagelab.privates.common.utils;

import com.sumsub.sns.prooface.network.b;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AESUtil {
    private static byte[] aes_cbc(byte[] bArr, String str, String str2, int i11) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(generateKeyBytes(str, "UTF-8"), b.f40261d);
        IvParameterSpec reflectGetIv = reflectGetIv(str2.getBytes("UTF-8"));
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS7Padding");
        instance.init(i11, secretKeySpec, reflectGetIv);
        return instance.doFinal(bArr);
    }

    private static byte[] aes_ecb(byte[] bArr, String str, int i11) throws Exception {
        SecretKeySpec secretKeySpec = new SecretKeySpec(generateKeyBytes(str, "UTF-8"), b.f40261d);
        Cipher instance = Cipher.getInstance("AES/ECB/PKCS5Padding");
        instance.init(i11, secretKeySpec);
        return instance.doFinal(bArr);
    }

    public static byte[] decryptBytes(byte[] bArr, String str) throws Exception {
        return aes_ecb(bArr, str, 2);
    }

    public static byte[] encryptBytes(byte[] bArr, String str) throws Exception {
        return aes_ecb(bArr, str, 1);
    }

    private static byte[] generateKeyBytes(String str, String str2) throws UnsupportedEncodingException {
        byte[] bArr = new byte[str.length()];
        byte[] bytes = str.substring(0, str.length() / 2).getBytes(str2);
        byte[] bytes2 = str.substring(str.length() / 2).getBytes(str2);
        System.arraycopy(bytes, 0, bArr, 0, bytes.length);
        System.arraycopy(bytes2, 0, bArr, bytes.length, bytes2.length);
        return bArr;
    }

    public static int generateSeed() {
        return Math.abs(new SecureRandom().nextInt()) & FlexItem.MAX_SIZE;
    }

    public static String get16Md5AesKey(long j11) {
        long j12;
        long j13;
        switch ((int) (j11 % 10)) {
            case 1:
                j13 = 5 * j11;
                j12 = j11 % 88;
                break;
            case 2:
                j13 = 23 * j11;
                j12 = j11 % 15;
                break;
            case 3:
                j13 = 3 * j11;
                j12 = j11 % 73;
                break;
            case 4:
                j13 = 13 * j11;
                j12 = j11 % 96;
                break;
            case 5:
                j13 = 17 * j11;
                j12 = j11 % 49;
                break;
            case 6:
                j13 = 7 * j11;
                j12 = j11 % 68;
                break;
            case 7:
                j13 = 31 * j11;
                j12 = j11 % 39;
                break;
            case 8:
                j13 = 29 * j11;
                j12 = j11 % 41;
                break;
            case 9:
                j13 = 37 * j11;
                j12 = j11 % 91;
                break;
            default:
                j13 = 8 * j11;
                j12 = j11 % 74;
                break;
        }
        long j14 = j13 + j12;
        return StringUtil.get16MD5String("JCKP" + j14);
    }

    public static String getIv(String str, char c11) {
        byte[] bytes = str.getBytes(Charset.forName("UTF-8"));
        for (int i11 = 0; i11 < bytes.length; i11++) {
            bytes[i11] = (byte) (bytes[i11] ^ c11);
        }
        return new String(bytes, 0, bytes.length);
    }

    public static String getMd5AesKey(long j11) {
        long j12;
        long j13;
        switch ((int) (j11 % 10)) {
            case 1:
                j13 = 5 * j11;
                j12 = j11 % 88;
                break;
            case 2:
                j13 = 23 * j11;
                j12 = j11 % 15;
                break;
            case 3:
                j13 = 3 * j11;
                j12 = j11 % 73;
                break;
            case 4:
                j13 = 13 * j11;
                j12 = j11 % 96;
                break;
            case 5:
                j13 = 17 * j11;
                j12 = j11 % 49;
                break;
            case 6:
                j13 = 7 * j11;
                j12 = j11 % 68;
                break;
            case 7:
                j13 = 31 * j11;
                j12 = j11 % 39;
                break;
            case 8:
                j13 = 29 * j11;
                j12 = j11 % 41;
                break;
            case 9:
                j13 = 37 * j11;
                j12 = j11 % 91;
                break;
            default:
                j13 = 8 * j11;
                j12 = j11 % 74;
                break;
        }
        long j14 = j13 + j12;
        return StringUtil.get32MD5String("JCKP" + j14);
    }

    private static IvParameterSpec reflectGetIv(byte[] bArr) throws Exception {
        return (IvParameterSpec) ReflectUtil.invokeConstructor(IvParameterSpec.class, new Object[]{bArr}, new Class[]{byte[].class});
    }

    public static byte[] decryptBytes(byte[] bArr, String str, String str2) throws Exception {
        return aes_cbc(bArr, str, str2, 2);
    }

    public static byte[] encryptBytes(byte[] bArr, String str, String str2) throws Exception {
        return aes_cbc(bArr, str, str2, 1);
    }
}
