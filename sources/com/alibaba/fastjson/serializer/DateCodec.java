package com.alibaba.fastjson.serializer;

import com.adjust.sdk.Constants;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.deserializer.AbstractDateDeserializer;
import com.alibaba.fastjson.util.IOUtils;
import com.alibaba.fastjson.util.TypeUtils;
import com.tencent.thumbplayer.tcmedia.tplayer.plugins.report.TPReportParams;
import f2.a;
import f2.e;
import h2.k;
import java.io.IOException;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateCodec extends AbstractDateDeserializer implements k {

    /* renamed from: a  reason: collision with root package name */
    public static final DateCodec f14265a = new DateCodec();

    public int b() {
        return 2;
    }

    public void c(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i11) throws IOException {
        Date date;
        char[] cArr;
        JSONSerializer jSONSerializer2 = jSONSerializer;
        Object obj3 = obj;
        SerializeWriter serializeWriter = jSONSerializer2.f14277k;
        if (obj3 == null) {
            serializeWriter.H();
            return;
        }
        if (obj3 instanceof Date) {
            date = (Date) obj3;
        } else {
            date = TypeUtils.m(obj);
        }
        if (serializeWriter.n(SerializerFeature.WriteDateUseDateFormat)) {
            DateFormat t11 = jSONSerializer.t();
            if (t11 == null) {
                t11 = new SimpleDateFormat(JSON.DEFFAULT_DATE_FORMAT, jSONSerializer2.f14285s);
                t11.setTimeZone(jSONSerializer2.f14284r);
            }
            serializeWriter.K(t11.format(date));
        } else if (!serializeWriter.n(SerializerFeature.WriteClassName) || obj.getClass() == type) {
            long time = date.getTime();
            if (serializeWriter.n(SerializerFeature.UseISO8601DateFormat)) {
                int i12 = serializeWriter.n(SerializerFeature.UseSingleQuotes) ? 39 : 34;
                serializeWriter.write(i12);
                Calendar instance = Calendar.getInstance(jSONSerializer2.f14284r, jSONSerializer2.f14285s);
                instance.setTimeInMillis(time);
                int i13 = instance.get(1);
                int i14 = instance.get(2) + 1;
                int i15 = instance.get(5);
                int i16 = instance.get(11);
                int i17 = instance.get(12);
                int i18 = instance.get(13);
                int i19 = instance.get(14);
                if (i19 != 0) {
                    cArr = "0000-00-00T00:00:00.000".toCharArray();
                    IOUtils.i(i19, 23, cArr);
                    IOUtils.i(i18, 19, cArr);
                    IOUtils.i(i17, 16, cArr);
                    IOUtils.i(i16, 13, cArr);
                    IOUtils.i(i15, 10, cArr);
                    IOUtils.i(i14, 7, cArr);
                    IOUtils.i(i13, 4, cArr);
                } else if (i18 == 0 && i17 == 0 && i16 == 0) {
                    cArr = "0000-00-00".toCharArray();
                    IOUtils.i(i15, 10, cArr);
                    IOUtils.i(i14, 7, cArr);
                    IOUtils.i(i13, 4, cArr);
                } else {
                    cArr = "0000-00-00T00:00:00".toCharArray();
                    IOUtils.i(i18, 19, cArr);
                    IOUtils.i(i17, 16, cArr);
                    IOUtils.i(i16, 13, cArr);
                    IOUtils.i(i15, 10, cArr);
                    IOUtils.i(i14, 7, cArr);
                    IOUtils.i(i13, 4, cArr);
                }
                serializeWriter.write(cArr);
                int rawOffset = instance.getTimeZone().getRawOffset() / Constants.ONE_HOUR;
                if (rawOffset == 0) {
                    serializeWriter.write(90);
                } else {
                    if (rawOffset > 0) {
                        serializeWriter.append('+').append(String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, new Object[]{Integer.valueOf(rawOffset)}));
                    } else {
                        serializeWriter.append('-').append(String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, new Object[]{Integer.valueOf(-rawOffset)}));
                    }
                    serializeWriter.append(":00");
                }
                serializeWriter.write(i12);
                return;
            }
            serializeWriter.G(time);
        } else if (obj.getClass() == Date.class) {
            serializeWriter.write("new Date(");
            serializeWriter.G(((Date) obj3).getTime());
            serializeWriter.write(41);
        } else {
            serializeWriter.write(123);
            serializeWriter.v(JSON.DEFAULT_TYPE_KEY);
            jSONSerializer2.F(obj.getClass().getName());
            serializeWriter.z(',', TPReportParams.JSON_KEY_VAL, ((Date) obj3).getTime());
            serializeWriter.write(125);
        }
    }

    public <T> T g(a aVar, Type type, Object obj, Object obj2) {
        if (obj2 == null) {
            return null;
        }
        if (obj2 instanceof Date) {
            return obj2;
        }
        if (obj2 instanceof Number) {
            return new Date(((Number) obj2).longValue());
        }
        if (obj2 instanceof String) {
            String str = (String) obj2;
            if (str.length() == 0) {
                return null;
            }
            e eVar = new e(str);
            try {
                if (eVar.D0(false)) {
                    T U = eVar.U();
                    if (type == Calendar.class) {
                        return U;
                    }
                    T time = U.getTime();
                    eVar.close();
                    return time;
                }
                eVar.close();
                if (str.length() == aVar.m().length()) {
                    try {
                        return aVar.n().parse(str);
                    } catch (ParseException unused) {
                    }
                }
                if (str.startsWith("/Date(") && str.endsWith(")/")) {
                    str = str.substring(6, str.length() - 2);
                }
                if ("0000-00-00".equals(str) || "0000-00-00T00:00:00".equalsIgnoreCase(str) || "0001-01-01T00:00:00+08:00".equalsIgnoreCase(str)) {
                    return null;
                }
                return new Date(Long.parseLong(str));
            } finally {
                eVar.close();
            }
        } else {
            throw new JSONException("parse error");
        }
    }
}
