package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSONArray;
import com.sumsub.sns.internal.core.analytics.d;
import f2.a;
import g2.l;
import h2.k;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;

public class AtomicCodec implements k, l {

    /* renamed from: a  reason: collision with root package name */
    public static final AtomicCodec f14252a = new AtomicCodec();

    public int b() {
        return 14;
    }

    public void c(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i11) throws IOException {
        SerializeWriter serializeWriter = jSONSerializer.f14277k;
        if (obj instanceof AtomicInteger) {
            serializeWriter.E(((AtomicInteger) obj).get());
        } else if (obj instanceof AtomicLong) {
            serializeWriter.G(((AtomicLong) obj).get());
        } else if (obj instanceof AtomicBoolean) {
            serializeWriter.append(((AtomicBoolean) obj).get() ? "true" : d.f31895b);
        } else if (obj == null) {
            serializeWriter.J(SerializerFeature.WriteNullListAsEmpty);
        } else {
            int i12 = 0;
            if (obj instanceof AtomicIntegerArray) {
                AtomicIntegerArray atomicIntegerArray = (AtomicIntegerArray) obj;
                int length = atomicIntegerArray.length();
                serializeWriter.write(91);
                while (i12 < length) {
                    int i13 = atomicIntegerArray.get(i12);
                    if (i12 != 0) {
                        serializeWriter.write(44);
                    }
                    serializeWriter.E(i13);
                    i12++;
                }
                serializeWriter.write(93);
                return;
            }
            AtomicLongArray atomicLongArray = (AtomicLongArray) obj;
            int length2 = atomicLongArray.length();
            serializeWriter.write(91);
            while (i12 < length2) {
                long j11 = atomicLongArray.get(i12);
                if (i12 != 0) {
                    serializeWriter.write(44);
                }
                serializeWriter.G(j11);
                i12++;
            }
            serializeWriter.write(93);
        }
    }

    public <T> T e(a aVar, Type type, Object obj) {
        if (aVar.f15701g.J() == 8) {
            aVar.f15701g.f(16);
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        aVar.F(jSONArray);
        int i11 = 0;
        if (type == AtomicIntegerArray.class) {
            T atomicIntegerArray = new AtomicIntegerArray(jSONArray.size());
            while (i11 < jSONArray.size()) {
                atomicIntegerArray.set(i11, jSONArray.getInteger(i11).intValue());
                i11++;
            }
            return atomicIntegerArray;
        }
        T atomicLongArray = new AtomicLongArray(jSONArray.size());
        while (i11 < jSONArray.size()) {
            atomicLongArray.set(i11, jSONArray.getLong(i11).longValue());
            i11++;
        }
        return atomicLongArray;
    }
}
