package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.util.TypeUtils;
import f2.a;
import f2.b;
import g2.l;
import h2.k;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.concurrent.atomic.AtomicLong;

public class LongCodec implements k, l {

    /* renamed from: a  reason: collision with root package name */
    public static LongCodec f14287a = new LongCodec();

    public int b() {
        return 2;
    }

    public void c(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i11) throws IOException {
        SerializeWriter serializeWriter = jSONSerializer.f14277k;
        if (obj == null) {
            serializeWriter.J(SerializerFeature.WriteNullNumberAsZero);
            return;
        }
        long longValue = ((Long) obj).longValue();
        serializeWriter.G(longValue);
        if (serializeWriter.n(SerializerFeature.WriteClassName) && longValue <= 2147483647L && longValue >= -2147483648L && type != Long.class && type != Long.TYPE) {
            serializeWriter.write(76);
        }
    }

    public <T> T e(a aVar, Type type, Object obj) {
        T t11;
        b bVar = aVar.f15701g;
        int J = bVar.J();
        if (J == 2) {
            long u11 = bVar.u();
            bVar.f(16);
            t11 = Long.valueOf(u11);
        } else {
            if (J == 12) {
                JSONObject jSONObject = new JSONObject(true);
                aVar.N(jSONObject);
                t11 = TypeUtils.t(jSONObject);
            } else {
                t11 = TypeUtils.t(aVar.z());
            }
            if (t11 == null) {
                return null;
            }
        }
        return type == AtomicLong.class ? new AtomicLong(t11.longValue()) : t11;
    }
}
