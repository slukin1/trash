package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSONException;
import f2.a;
import f2.b;
import f2.e;
import g2.l;
import java.lang.reflect.Type;
import java.sql.Time;

public class TimeDeserializer implements l {

    /* renamed from: a  reason: collision with root package name */
    public static final TimeDeserializer f14224a = new TimeDeserializer();

    public int b() {
        return 2;
    }

    public <T> T e(a aVar, Type type, Object obj) {
        long j11;
        b bVar = aVar.f15701g;
        if (bVar.J() == 16) {
            bVar.f(4);
            if (bVar.J() == 4) {
                bVar.y(2);
                if (bVar.J() == 2) {
                    long u11 = bVar.u();
                    bVar.f(13);
                    if (bVar.J() == 13) {
                        bVar.f(16);
                        return new Time(u11);
                    }
                    throw new JSONException("syntax error");
                }
                throw new JSONException("syntax error");
            }
            throw new JSONException("syntax error");
        }
        T z11 = aVar.z();
        if (z11 == null) {
            return null;
        }
        if (z11 instanceof Time) {
            return z11;
        }
        if (z11 instanceof Number) {
            return new Time(((Number) z11).longValue());
        }
        if (z11 instanceof String) {
            String str = (String) z11;
            if (str.length() == 0) {
                return null;
            }
            e eVar = new e(str);
            if (eVar.C0()) {
                j11 = eVar.U().getTimeInMillis();
            } else {
                boolean z12 = false;
                int i11 = 0;
                while (true) {
                    if (i11 >= str.length()) {
                        z12 = true;
                        break;
                    }
                    char charAt = str.charAt(i11);
                    if (charAt < '0' || charAt > '9') {
                        break;
                    }
                    i11++;
                }
                if (!z12) {
                    eVar.close();
                    return Time.valueOf(str);
                }
                j11 = Long.parseLong(str);
            }
            eVar.close();
            return new Time(j11);
        }
        throw new JSONException("parse error");
    }
}
