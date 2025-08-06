package com.alibaba.fastjson.serializer;

import h2.k;
import java.io.IOException;
import java.lang.reflect.Type;

public class PrimitiveArraySerializer implements k {

    /* renamed from: a  reason: collision with root package name */
    public static PrimitiveArraySerializer f14293a = new PrimitiveArraySerializer();

    public final void c(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i11) throws IOException {
        SerializeWriter serializeWriter = jSONSerializer.f14277k;
        if (obj == null) {
            serializeWriter.J(SerializerFeature.WriteNullListAsEmpty);
            return;
        }
        int i12 = 0;
        if (obj instanceof int[]) {
            int[] iArr = (int[]) obj;
            serializeWriter.write(91);
            while (i12 < iArr.length) {
                if (i12 != 0) {
                    serializeWriter.write(44);
                }
                serializeWriter.E(iArr[i12]);
                i12++;
            }
            serializeWriter.write(93);
        } else if (obj instanceof short[]) {
            short[] sArr = (short[]) obj;
            serializeWriter.write(91);
            while (i12 < sArr.length) {
                if (i12 != 0) {
                    serializeWriter.write(44);
                }
                serializeWriter.E(sArr[i12]);
                i12++;
            }
            serializeWriter.write(93);
        } else if (obj instanceof long[]) {
            long[] jArr = (long[]) obj;
            serializeWriter.write(91);
            while (i12 < jArr.length) {
                if (i12 != 0) {
                    serializeWriter.write(44);
                }
                serializeWriter.G(jArr[i12]);
                i12++;
            }
            serializeWriter.write(93);
        } else if (obj instanceof boolean[]) {
            boolean[] zArr = (boolean[]) obj;
            serializeWriter.write(91);
            while (i12 < zArr.length) {
                if (i12 != 0) {
                    serializeWriter.write(44);
                }
                serializeWriter.r(zArr[i12]);
                i12++;
            }
            serializeWriter.write(93);
        } else if (obj instanceof float[]) {
            float[] fArr = (float[]) obj;
            serializeWriter.write(91);
            while (i12 < fArr.length) {
                if (i12 != 0) {
                    serializeWriter.write(44);
                }
                float f11 = fArr[i12];
                if (Float.isNaN(f11)) {
                    serializeWriter.H();
                } else {
                    serializeWriter.append(Float.toString(f11));
                }
                i12++;
            }
            serializeWriter.write(93);
        } else if (obj instanceof double[]) {
            double[] dArr = (double[]) obj;
            serializeWriter.write(91);
            while (i12 < dArr.length) {
                if (i12 != 0) {
                    serializeWriter.write(44);
                }
                double d11 = dArr[i12];
                if (Double.isNaN(d11)) {
                    serializeWriter.H();
                } else {
                    serializeWriter.append(Double.toString(d11));
                }
                i12++;
            }
            serializeWriter.write(93);
        } else if (obj instanceof byte[]) {
            serializeWriter.s((byte[]) obj);
        } else {
            serializeWriter.K(new String((char[]) obj));
        }
    }
}
