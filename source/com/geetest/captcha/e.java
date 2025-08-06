package com.geetest.captcha;

import android.util.Base64;
import com.sumsub.sns.internal.core.common.k;
import com.sumsub.sns.prooface.network.b;
import java.security.Key;
import java.security.spec.AlgorithmParameterSpec;

final class e {
    public static byte[] a(byte[] bArr, String str) throws Exception {
        return a(bArr, str.getBytes("utf-8"), a());
    }

    public static byte[] a(byte[] bArr, String str, String str2) throws Exception {
        return a(bArr, str.getBytes("utf-8"), str2.getBytes("utf-8"));
    }

    private static byte[] a(byte[] bArr, byte[] bArr2, byte[] bArr3) throws Exception {
        Class<String> cls = String.class;
        Class<byte[]> cls2 = byte[].class;
        Object newInstance = Class.forName(a("amF2YXguY3J5cHRvLnNwZWMuSXZQYXJhbWV0ZXJTcGVj")).getConstructor(new Class[]{cls2}).newInstance(new Object[]{bArr3});
        Object newInstance2 = Class.forName(a("amF2YXguY3J5cHRvLnNwZWMuU2VjcmV0S2V5U3BlYw==")).getConstructor(new Class[]{cls2, cls}).newInstance(new Object[]{bArr2, b.f40261d});
        Class<?> cls3 = Class.forName(a("amF2YXguY3J5cHRvLkNpcGhlcg=="));
        Object invoke = cls3.getMethod("getInstance", new Class[]{cls}).invoke(cls3, new Object[]{k.f32093a});
        cls3.getMethod(ZendeskBlipsProvider.ACTION_CORE_INIT, new Class[]{Integer.TYPE, Key.class, AlgorithmParameterSpec.class}).invoke(invoke, new Object[]{2, newInstance2, newInstance});
        return (byte[]) cls3.getMethod("doFinal", new Class[]{cls2}).invoke(invoke, new Object[]{bArr});
    }

    public static byte[] a() {
        return k.a(new String(Base64.decode("MzAzMDMwMzAzMDMwMzAzMDMwMzAzMDMwMzAzMDMwMzA=", 0)));
    }

    public static String a(String str) {
        return new String(Base64.decode(str, 0));
    }
}
