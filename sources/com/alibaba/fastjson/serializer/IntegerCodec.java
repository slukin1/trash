package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.util.TypeUtils;
import f2.a;
import f2.b;
import g2.l;
import h2.k;
import java.io.IOException;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicInteger;

public class IntegerCodec implements k, l {

    /* renamed from: a  reason: collision with root package name */
    public static IntegerCodec f14273a = new IntegerCodec();

    public int b() {
        return 2;
    }

    public void c(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i11) throws IOException {
        SerializeWriter serializeWriter = jSONSerializer.f14277k;
        Number number = (Number) obj;
        if (number == null) {
            serializeWriter.J(SerializerFeature.WriteNullNumberAsZero);
            return;
        }
        if (obj instanceof Long) {
            serializeWriter.G(number.longValue());
        } else {
            serializeWriter.E(number.intValue());
        }
        if (serializeWriter.n(SerializerFeature.WriteClassName)) {
            Class<?> cls = number.getClass();
            if (cls == Byte.class) {
                serializeWriter.write(66);
            } else if (cls == Short.class) {
                serializeWriter.write(83);
            }
        }
    }

    public <T> T e(a aVar, Type type, Object obj) {
        T t11;
        b bVar = aVar.f15701g;
        int J = bVar.J();
        if (J == 8) {
            bVar.f(16);
            return null;
        }
        if (J == 2) {
            try {
                int w11 = bVar.w();
                bVar.f(16);
                t11 = Integer.valueOf(w11);
            } catch (NumberFormatException e11) {
                throw new JSONException("int value overflow, field : " + obj, e11);
            }
        } else if (J == 3) {
            BigDecimal G = bVar.G();
            bVar.f(16);
            t11 = Integer.valueOf(G.intValue());
        } else if (J == 12) {
            JSONObject jSONObject = new JSONObject(true);
            aVar.N(jSONObject);
            t11 = TypeUtils.q(jSONObject);
        } else {
            t11 = TypeUtils.q(aVar.z());
        }
        return type == AtomicInteger.class ? new AtomicInteger(t11.intValue()) : t11;
    }
}
