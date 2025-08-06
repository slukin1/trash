package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.util.TypeUtils;
import f2.a;
import f2.b;
import g2.l;
import h2.k;
import java.io.IOException;
import java.lang.reflect.Type;
import java.math.BigInteger;

public class BigIntegerCodec implements k, l {

    /* renamed from: a  reason: collision with root package name */
    public static final BigIntegerCodec f14258a = new BigIntegerCodec();

    public static <T> T f(a aVar) {
        b bVar = aVar.f15701g;
        if (bVar.J() == 2) {
            String N = bVar.N();
            bVar.f(16);
            return new BigInteger(N);
        }
        Object z11 = aVar.z();
        if (z11 == null) {
            return null;
        }
        return TypeUtils.h(z11);
    }

    public int b() {
        return 2;
    }

    public void c(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i11) throws IOException {
        SerializeWriter serializeWriter = jSONSerializer.f14277k;
        if (obj == null) {
            serializeWriter.J(SerializerFeature.WriteNullNumberAsZero);
        } else {
            serializeWriter.write(((BigInteger) obj).toString());
        }
    }

    public <T> T e(a aVar, Type type, Object obj) {
        return f(aVar);
    }
}
