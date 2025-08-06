package com.alibaba.fastjson.parser.deserializer;

import f2.a;
import g2.l;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;

public class JavaObjectDeserializer implements l {

    /* renamed from: a  reason: collision with root package name */
    public static final JavaObjectDeserializer f14196a = new JavaObjectDeserializer();

    public int b() {
        return 12;
    }

    /* JADX WARNING: type inference failed for: r2v7, types: [T, java.lang.Object[]] */
    public <T> T e(a aVar, Type type, Object obj) {
        if (type instanceof GenericArrayType) {
            Type genericComponentType = ((GenericArrayType) type).getGenericComponentType();
            if (genericComponentType instanceof TypeVariable) {
                genericComponentType = ((TypeVariable) genericComponentType).getBounds()[0];
            }
            ArrayList arrayList = new ArrayList();
            aVar.D(genericComponentType, arrayList);
            if (!(genericComponentType instanceof Class)) {
                return arrayList.toArray();
            }
            ? r22 = (Object[]) Array.newInstance((Class) genericComponentType, arrayList.size());
            arrayList.toArray(r22);
            return r22;
        } else if (!(type instanceof Class) || type == Object.class || type == Serializable.class) {
            return aVar.B(obj);
        } else {
            return aVar.L(type);
        }
    }
}
