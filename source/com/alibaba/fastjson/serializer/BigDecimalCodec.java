package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.util.TypeUtils;
import f2.a;
import f2.b;
import g2.l;
import h2.k;
import java.io.IOException;
import java.lang.reflect.Type;
import java.math.BigDecimal;

public class BigDecimalCodec implements k, l {

    /* renamed from: a  reason: collision with root package name */
    public static final BigDecimalCodec f14257a = new BigDecimalCodec();

    public static <T> T f(a aVar) {
        b bVar = aVar.f15701g;
        if (bVar.J() == 2) {
            T G = bVar.G();
            bVar.f(16);
            return G;
        } else if (bVar.J() == 3) {
            T G2 = bVar.G();
            bVar.f(16);
            return G2;
        } else {
            Object z11 = aVar.z();
            if (z11 == null) {
                return null;
            }
            return TypeUtils.g(z11);
        }
    }

    public int b() {
        return 2;
    }

    public void c(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i11) throws IOException {
        String str;
        SerializeWriter serializeWriter = jSONSerializer.f14277k;
        if (obj == null) {
            serializeWriter.J(SerializerFeature.WriteNullNumberAsZero);
            return;
        }
        BigDecimal bigDecimal = (BigDecimal) obj;
        if (serializeWriter.n(SerializerFeature.WriteBigDecimalAsPlain)) {
            str = bigDecimal.toPlainString();
        } else {
            str = bigDecimal.toString();
        }
        serializeWriter.write(str);
        if (serializeWriter.n(SerializerFeature.WriteClassName) && type != BigDecimal.class && bigDecimal.scale() == 0) {
            serializeWriter.write(46);
        }
    }

    public <T> T e(a aVar, Type type, Object obj) {
        return f(aVar);
    }
}
