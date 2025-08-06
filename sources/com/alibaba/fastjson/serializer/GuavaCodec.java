package com.alibaba.fastjson.serializer;

import com.google.common.collect.Multimap;
import h2.k;
import java.io.IOException;
import java.lang.reflect.Type;

public class GuavaCodec implements k {

    /* renamed from: a  reason: collision with root package name */
    public static GuavaCodec f14272a = new GuavaCodec();

    public void c(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i11) throws IOException {
        SerializeWriter serializeWriter = jSONSerializer.f14277k;
        if (obj instanceof Multimap) {
            jSONSerializer.E(((Multimap) obj).asMap());
        }
    }
}
