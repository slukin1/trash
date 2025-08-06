package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.util.TypeUtils;
import com.sumsub.sns.internal.core.analytics.d;
import f2.a;
import f2.b;
import g2.l;
import h2.k;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.concurrent.atomic.AtomicBoolean;

public class BooleanCodec implements k, l {

    /* renamed from: a  reason: collision with root package name */
    public static final BooleanCodec f14259a = new BooleanCodec();

    public int b() {
        return 6;
    }

    public void c(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i11) throws IOException {
        SerializeWriter serializeWriter = jSONSerializer.f14277k;
        Boolean bool = (Boolean) obj;
        if (bool == null) {
            serializeWriter.J(SerializerFeature.WriteNullBooleanAsFalse);
        } else if (bool.booleanValue()) {
            serializeWriter.write("true");
        } else {
            serializeWriter.write(d.f31895b);
        }
    }

    public <T> T e(a aVar, Type type, Object obj) {
        T t11;
        b bVar = aVar.f15701g;
        if (bVar.J() == 6) {
            bVar.f(16);
            t11 = Boolean.TRUE;
        } else if (bVar.J() == 7) {
            bVar.f(16);
            t11 = Boolean.FALSE;
        } else if (bVar.J() == 2) {
            int w11 = bVar.w();
            bVar.f(16);
            if (w11 == 1) {
                t11 = Boolean.TRUE;
            } else {
                t11 = Boolean.FALSE;
            }
        } else {
            Object z11 = aVar.z();
            if (z11 == null) {
                return null;
            }
            t11 = TypeUtils.i(z11);
        }
        return type == AtomicBoolean.class ? new AtomicBoolean(t11.booleanValue()) : t11;
    }
}
