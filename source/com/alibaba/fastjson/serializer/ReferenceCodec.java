package com.alibaba.fastjson.serializer;

import f2.a;
import g2.l;
import h2.k;
import java.io.IOException;
import java.lang.ref.Reference;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.concurrent.atomic.AtomicReference;

public class ReferenceCodec implements k, l {

    /* renamed from: a  reason: collision with root package name */
    public static final ReferenceCodec f14294a = new ReferenceCodec();

    public int b() {
        return 12;
    }

    public void c(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i11) throws IOException {
        Object obj3;
        if (obj instanceof AtomicReference) {
            obj3 = ((AtomicReference) obj).get();
        } else {
            obj3 = ((Reference) obj).get();
        }
        jSONSerializer.E(obj3);
    }

    public <T> T e(a aVar, Type type, Object obj) {
        ParameterizedType parameterizedType = (ParameterizedType) type;
        Object L = aVar.L(parameterizedType.getActualTypeArguments()[0]);
        Type rawType = parameterizedType.getRawType();
        if (rawType == AtomicReference.class) {
            return new AtomicReference(L);
        }
        if (rawType == WeakReference.class) {
            return new WeakReference(L);
        }
        if (rawType == SoftReference.class) {
            return new SoftReference(L);
        }
        throw new UnsupportedOperationException(rawType.toString());
    }
}
