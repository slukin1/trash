package com.iproov.sdk.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* renamed from: com.iproov.sdk.utils.do  reason: invalid class name */
public class Cdo {
    /* renamed from: do  reason: not valid java name */
    public static byte[] m2230do(byte[] bArr) throws NoSuchAlgorithmException {
        MessageDigest instance = MessageDigest.getInstance("SHA-256");
        instance.reset();
        return instance.digest(bArr);
    }
}
