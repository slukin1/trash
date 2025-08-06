package com.iproov.sdk.core;

import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: com.iproov.sdk.core.do  reason: invalid class name */
class Cdo {
    /* renamed from: do  reason: not valid java name */
    public static byte[] m360do(String str, byte[] bArr, byte[] bArr2) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException, InvalidAlgorithmParameterException {
        int i11 = 24;
        if (bArr2.length >= 32) {
            i11 = 32;
        } else if (bArr2.length < 24) {
            i11 = 16;
        }
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr2, 0, i11, Ctry.m456do());
        IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr);
        Cipher instance = Cipher.getInstance(Ctry.m464if());
        instance.init(1, secretKeySpec, ivParameterSpec);
        return instance.doFinal(str.getBytes(StandardCharsets.UTF_8));
    }
}
