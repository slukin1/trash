package com.qihoo.stat;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

public class v {
    public static String a(byte[] bArr, String str) {
        if (bArr != null) {
            try {
                SecretKey generateSecret = SecretKeyFactory.getInstance("DES").generateSecret(new DESKeySpec(str.getBytes("UTF-8")));
                Cipher instance = Cipher.getInstance("DES/CBC/PKCS5Padding");
                instance.init(2, generateSecret, new IvParameterSpec(str.getBytes("UTF-8")));
                return new String(instance.doFinal(bArr), "UTF-8");
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
        return null;
    }
}
