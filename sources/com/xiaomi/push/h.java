package com.xiaomi.push;

import com.sumsub.sns.internal.core.common.k;
import com.sumsub.sns.prooface.network.b;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import net.sf.scuba.smartcards.ISO7816;

public class h {

    /* renamed from: a  reason: collision with root package name */
    private static final byte[] f52166a = {100, 23, 84, 114, 72, 0, 4, 97, 73, 97, 2, ISO7816.INS_DECREASE_STAMPED, 84, 102, 18, 32};

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        return a(bArr, 2).doFinal(bArr2);
    }

    public static byte[] b(byte[] bArr, byte[] bArr2) {
        return a(bArr, 1).doFinal(bArr2);
    }

    private static Cipher a(byte[] bArr, int i11) {
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, b.f40261d);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(f52166a);
        Cipher instance = Cipher.getInstance(k.f32093a);
        instance.init(i11, secretKeySpec, ivParameterSpec);
        return instance;
    }
}
