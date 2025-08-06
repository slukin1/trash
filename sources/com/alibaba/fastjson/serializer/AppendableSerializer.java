package com.alibaba.fastjson.serializer;

import h2.k;
import java.io.IOException;
import java.lang.reflect.Type;

public class AppendableSerializer implements k {

    /* renamed from: a  reason: collision with root package name */
    public static final AppendableSerializer f14251a = new AppendableSerializer();

    public void c(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i11) throws IOException {
        if (obj == null) {
            jSONSerializer.f14277k.J(SerializerFeature.WriteNullStringAsEmpty);
        } else {
            jSONSerializer.F(obj.toString());
        }
    }
}
