package com.alibaba.fastjson.serializer;

import h2.k;
import h2.n;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Enumeration;

public class EnumerationSerializer implements k {

    /* renamed from: a  reason: collision with root package name */
    public static EnumerationSerializer f14269a = new EnumerationSerializer();

    public void c(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i11) throws IOException {
        SerializeWriter serializeWriter = jSONSerializer.f14277k;
        if (obj == null) {
            serializeWriter.J(SerializerFeature.WriteNullListAsEmpty);
            return;
        }
        Type type2 = null;
        int i12 = 0;
        if (serializeWriter.n(SerializerFeature.WriteClassName) && (type instanceof ParameterizedType)) {
            type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
        }
        Enumeration enumeration = (Enumeration) obj;
        n nVar = jSONSerializer.f14283q;
        jSONSerializer.B(nVar, obj, obj2, 0);
        try {
            serializeWriter.append('[');
            while (enumeration.hasMoreElements()) {
                Object nextElement = enumeration.nextElement();
                int i13 = i12 + 1;
                if (i12 != 0) {
                    serializeWriter.append(',');
                }
                if (nextElement == null) {
                    serializeWriter.H();
                } else {
                    jSONSerializer.v(nextElement.getClass()).c(jSONSerializer, nextElement, Integer.valueOf(i13 - 1), type2, 0);
                }
                i12 = i13;
            }
            serializeWriter.append(']');
        } finally {
            jSONSerializer.f14283q = nVar;
        }
    }
}
