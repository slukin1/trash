package com.sumsub.sns.internal.core.common;

import com.sumsub.sns.prooface.network.b;
import java.security.SecureRandom;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class k {

    /* renamed from: a  reason: collision with root package name */
    public static final String f32093a = "AES/CBC/PKCS5Padding";

    /* renamed from: b  reason: collision with root package name */
    public static final int f32094b = 16;

    public static final byte[] a(byte[] bArr, byte[] bArr2) {
        return a(ArraysKt___ArraysJvmKt.i(bArr, 16, bArr.length), 2, bArr2, Arrays.copyOf(bArr, 16));
    }

    public static final byte[] b(byte[] bArr, byte[] bArr2) {
        byte[] a11 = a(16);
        return ArraysKt___ArraysJvmKt.q(a11, a(bArr, 1, bArr2, a11));
    }

    public static final byte[] b(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return a(bArr, 1, bArr2, bArr3);
    }

    public static final byte[] a(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return a(bArr, 2, bArr2, bArr3);
    }

    public static final byte[] a(byte[] bArr, int i11, byte[] bArr2, byte[] bArr3) {
        SecretKeySpec secretKeySpec = new SecretKeySpec(Arrays.copyOf(bArr2, 16), b.f40261d);
        Cipher instance = Cipher.getInstance(f32093a);
        instance.init(i11, secretKeySpec, new IvParameterSpec(bArr3));
        return instance.doFinal(bArr);
    }

    public static final byte[] a(int i11) {
        byte[] bArr = new byte[i11];
        new SecureRandom().nextBytes(bArr);
        return bArr;
    }
}
