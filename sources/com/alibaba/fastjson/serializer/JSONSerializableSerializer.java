package com.alibaba.fastjson.serializer;

import h2.g;
import h2.k;
import java.io.IOException;
import java.lang.reflect.Type;

public class JSONSerializableSerializer implements k {

    /* renamed from: a  reason: collision with root package name */
    public static JSONSerializableSerializer f14275a = new JSONSerializableSerializer();

    public void c(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i11) throws IOException {
        ((g) obj).a(jSONSerializer, obj2, type, i11);
    }
}
