package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.util.TypeUtils;
import f2.a;
import g2.l;
import h2.k;
import h2.n;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.HashSet;
import java.util.TreeSet;

public class CollectionCodec implements k, l {

    /* renamed from: a  reason: collision with root package name */
    public static final CollectionCodec f14264a = new CollectionCodec();

    public int b() {
        return 14;
    }

    public void c(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i11) throws IOException {
        SerializeWriter serializeWriter = jSONSerializer.f14277k;
        if (obj == null) {
            serializeWriter.J(SerializerFeature.WriteNullListAsEmpty);
            return;
        }
        Type type2 = null;
        SerializerFeature serializerFeature = SerializerFeature.WriteClassName;
        if (serializeWriter.n(serializerFeature)) {
            type2 = TypeUtils.G(type);
        }
        Collection collection = (Collection) obj;
        n nVar = jSONSerializer.f14283q;
        int i12 = 0;
        jSONSerializer.B(nVar, obj, obj2, 0);
        if (serializeWriter.n(serializerFeature)) {
            if (HashSet.class == collection.getClass()) {
                serializeWriter.append("Set");
            } else if (TreeSet.class == collection.getClass()) {
                serializeWriter.append("TreeSet");
            }
        }
        try {
            serializeWriter.append('[');
            for (Object next : collection) {
                int i13 = i12 + 1;
                if (i12 != 0) {
                    serializeWriter.append(',');
                }
                if (next == null) {
                    serializeWriter.H();
                } else {
                    Class<?> cls = next.getClass();
                    if (cls == Integer.class) {
                        serializeWriter.E(((Integer) next).intValue());
                    } else if (cls == Long.class) {
                        serializeWriter.G(((Long) next).longValue());
                        if (serializeWriter.n(SerializerFeature.WriteClassName)) {
                            serializeWriter.write(76);
                        }
                    } else {
                        jSONSerializer.v(cls).c(jSONSerializer, next, Integer.valueOf(i13 - 1), type2, 0);
                    }
                }
                i12 = i13;
            }
            serializeWriter.append(']');
        } finally {
            jSONSerializer.f14283q = nVar;
        }
    }

    public <T> T e(a aVar, Type type, Object obj) {
        if (aVar.f15701g.J() == 8) {
            aVar.f15701g.f(16);
            return null;
        } else if (type == JSONArray.class) {
            T jSONArray = new JSONArray();
            aVar.F(jSONArray);
            return jSONArray;
        } else {
            T B = TypeUtils.B(type);
            aVar.E(TypeUtils.G(type), B, obj);
            return B;
        }
    }
}
