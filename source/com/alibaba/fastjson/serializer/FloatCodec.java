package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.util.TypeUtils;
import f2.a;
import f2.b;
import g2.l;
import h2.k;
import java.io.IOException;
import java.lang.reflect.Type;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class FloatCodec implements k, l {

    /* renamed from: b  reason: collision with root package name */
    public static FloatCodec f14270b = new FloatCodec();

    /* renamed from: a  reason: collision with root package name */
    public NumberFormat f14271a;

    public FloatCodec() {
    }

    public static <T> T f(a aVar) {
        b bVar = aVar.f15701g;
        if (bVar.J() == 2) {
            String N = bVar.N();
            bVar.f(16);
            return Float.valueOf(Float.parseFloat(N));
        } else if (bVar.J() == 3) {
            float l11 = bVar.l();
            bVar.f(16);
            return Float.valueOf(l11);
        } else {
            Object z11 = aVar.z();
            if (z11 == null) {
                return null;
            }
            return TypeUtils.p(z11);
        }
    }

    public int b() {
        return 2;
    }

    public void c(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i11) throws IOException {
        SerializeWriter serializeWriter = jSONSerializer.f14277k;
        if (obj == null) {
            serializeWriter.J(SerializerFeature.WriteNullNumberAsZero);
            return;
        }
        float floatValue = ((Float) obj).floatValue();
        NumberFormat numberFormat = this.f14271a;
        if (numberFormat != null) {
            serializeWriter.write(numberFormat.format((double) floatValue));
        } else {
            serializeWriter.C(floatValue, true);
        }
    }

    public <T> T e(a aVar, Type type, Object obj) {
        return f(aVar);
    }

    public FloatCodec(DecimalFormat decimalFormat) {
        this.f14271a = decimalFormat;
    }

    public FloatCodec(String str) {
        this(new DecimalFormat(str));
    }
}
