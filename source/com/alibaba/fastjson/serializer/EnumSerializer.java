package com.alibaba.fastjson.serializer;

import h2.k;
import java.io.IOException;
import java.lang.reflect.Type;

public class EnumSerializer implements k {

    /* renamed from: a  reason: collision with root package name */
    public static final EnumSerializer f14268a = new EnumSerializer();

    public void c(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i11) throws IOException {
        jSONSerializer.f14277k.u((Enum) obj);
    }
}
