package com.alibaba.fastjson.serializer;

import f2.a;
import f2.b;
import g2.l;
import h2.k;
import java.io.IOException;
import java.lang.reflect.Type;

public class StringCodec implements k, l {

    /* renamed from: a  reason: collision with root package name */
    public static StringCodec f14336a = new StringCodec();

    public static <T> T f(a aVar) {
        b t11 = aVar.t();
        if (t11.J() == 4) {
            T H = t11.H();
            t11.f(16);
            return H;
        } else if (t11.J() == 2) {
            T N = t11.N();
            t11.f(16);
            return N;
        } else {
            Object z11 = aVar.z();
            if (z11 == null) {
                return null;
            }
            return z11.toString();
        }
    }

    public int b() {
        return 4;
    }

    public void c(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i11) throws IOException {
        g(jSONSerializer, (String) obj);
    }

    public <T> T e(a aVar, Type type, Object obj) {
        if (type == StringBuffer.class) {
            b bVar = aVar.f15701g;
            if (bVar.J() == 4) {
                String H = bVar.H();
                bVar.f(16);
                return new StringBuffer(H);
            }
            Object z11 = aVar.z();
            if (z11 == null) {
                return null;
            }
            return new StringBuffer(z11.toString());
        } else if (type != StringBuilder.class) {
            return f(aVar);
        } else {
            b bVar2 = aVar.f15701g;
            if (bVar2.J() == 4) {
                String H2 = bVar2.H();
                bVar2.f(16);
                return new StringBuilder(H2);
            }
            Object z12 = aVar.z();
            if (z12 == null) {
                return null;
            }
            return new StringBuilder(z12.toString());
        }
    }

    public void g(JSONSerializer jSONSerializer, String str) {
        SerializeWriter serializeWriter = jSONSerializer.f14277k;
        if (str == null) {
            serializeWriter.J(SerializerFeature.WriteNullStringAsEmpty);
        } else {
            serializeWriter.K(str);
        }
    }
}
