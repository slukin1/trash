package com.alibaba.fastjson.serializer;

import h2.k;
import java.io.IOException;
import java.lang.reflect.Type;
import java.text.DecimalFormat;

public class DoubleSerializer implements k {

    /* renamed from: b  reason: collision with root package name */
    public static final DoubleSerializer f14266b = new DoubleSerializer();

    /* renamed from: a  reason: collision with root package name */
    public DecimalFormat f14267a;

    public DoubleSerializer() {
        this.f14267a = null;
    }

    public void c(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i11) throws IOException {
        SerializeWriter serializeWriter = jSONSerializer.f14277k;
        if (obj == null) {
            serializeWriter.J(SerializerFeature.WriteNullNumberAsZero);
            return;
        }
        double doubleValue = ((Double) obj).doubleValue();
        if (Double.isNaN(doubleValue) || Double.isInfinite(doubleValue)) {
            serializeWriter.H();
            return;
        }
        DecimalFormat decimalFormat = this.f14267a;
        if (decimalFormat == null) {
            serializeWriter.t(doubleValue, true);
        } else {
            serializeWriter.write(decimalFormat.format(doubleValue));
        }
    }

    public DoubleSerializer(DecimalFormat decimalFormat) {
        this.f14267a = null;
        this.f14267a = decimalFormat;
    }

    public DoubleSerializer(String str) {
        this(new DecimalFormat(str));
    }
}
