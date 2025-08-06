package com.alibaba.fastjson.serializer;

import h2.k;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.concurrent.atomic.DoubleAdder;
import java.util.concurrent.atomic.LongAdder;

public class AdderSerializer implements k {

    /* renamed from: a  reason: collision with root package name */
    public static final AdderSerializer f14246a = new AdderSerializer();

    public void c(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i11) throws IOException {
        SerializeWriter serializeWriter = jSONSerializer.f14277k;
        if (obj instanceof LongAdder) {
            serializeWriter.z('{', "value", ((LongAdder) obj).longValue());
            serializeWriter.write(125);
        } else if (obj instanceof DoubleAdder) {
            serializeWriter.x('{', "value", ((DoubleAdder) obj).doubleValue());
            serializeWriter.write(125);
        }
    }
}
