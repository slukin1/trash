package com.alibaba.fastjson.serializer;

import h2.k;
import java.io.IOException;
import java.lang.reflect.Type;

public class ToStringSerializer implements k {

    /* renamed from: a  reason: collision with root package name */
    public static final ToStringSerializer f14337a = new ToStringSerializer();

    public void c(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i11) throws IOException {
        SerializeWriter serializeWriter = jSONSerializer.f14277k;
        if (obj == null) {
            serializeWriter.H();
        } else {
            serializeWriter.K(obj.toString());
        }
    }
}
