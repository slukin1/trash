package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.util.TypeUtils;
import f2.a;
import f2.b;
import g2.l;
import java.lang.reflect.Type;
import java.math.BigDecimal;

public class NumberDeserializer implements l {

    /* renamed from: a  reason: collision with root package name */
    public static final NumberDeserializer f14218a = new NumberDeserializer();

    public int b() {
        return 2;
    }

    public <T> T e(a aVar, Type type, Object obj) {
        Class<Byte> cls = Byte.class;
        Class<Short> cls2 = Short.class;
        Class<Double> cls3 = Double.class;
        b bVar = aVar.f15701g;
        if (bVar.J() == 2) {
            if (type == Double.TYPE || type == cls3) {
                String N = bVar.N();
                bVar.f(16);
                return Double.valueOf(Double.parseDouble(N));
            }
            long u11 = bVar.u();
            bVar.f(16);
            if (type == Short.TYPE || type == cls2) {
                if (u11 <= 32767 && u11 >= -32768) {
                    return Short.valueOf((short) ((int) u11));
                }
                throw new JSONException("short overflow : " + u11);
            } else if (type == Byte.TYPE || type == cls) {
                if (u11 <= 127 && u11 >= -128) {
                    return Byte.valueOf((byte) ((int) u11));
                }
                throw new JSONException("short overflow : " + u11);
            } else if (u11 < -2147483648L || u11 > 2147483647L) {
                return Long.valueOf(u11);
            } else {
                return Integer.valueOf((int) u11);
            }
        } else if (bVar.J() != 3) {
            Object z11 = aVar.z();
            if (z11 == null) {
                return null;
            }
            if (type == Double.TYPE || type == cls3) {
                return TypeUtils.n(z11);
            }
            if (type == Short.TYPE || type == cls2) {
                return TypeUtils.u(z11);
            }
            if (type == Byte.TYPE || type == cls) {
                return TypeUtils.j(z11);
            }
            return TypeUtils.g(z11);
        } else if (type == Double.TYPE || type == cls3) {
            String N2 = bVar.N();
            bVar.f(16);
            return Double.valueOf(Double.parseDouble(N2));
        } else {
            T G = bVar.G();
            bVar.f(16);
            if (type == Short.TYPE || type == cls2) {
                if (G.compareTo(BigDecimal.valueOf(32767)) <= 0 && G.compareTo(BigDecimal.valueOf(-32768)) >= 0) {
                    return Short.valueOf(G.shortValue());
                }
                throw new JSONException("short overflow : " + G);
            } else if (type == Byte.TYPE || type == cls) {
                return Byte.valueOf(G.byteValue());
            } else {
                return G;
            }
        }
    }
}
