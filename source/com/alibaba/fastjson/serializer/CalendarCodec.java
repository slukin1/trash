package com.alibaba.fastjson.serializer;

import com.adjust.sdk.Constants;
import com.alibaba.fastjson.util.IOUtils;
import f2.a;
import f2.b;
import g2.l;
import h2.k;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

public class CalendarCodec implements k, l {

    /* renamed from: b  reason: collision with root package name */
    public static final CalendarCodec f14260b = new CalendarCodec();

    /* renamed from: a  reason: collision with root package name */
    public DatatypeFactory f14261a;

    public int b() {
        return 2;
    }

    public void c(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i11) throws IOException {
        Calendar calendar;
        char[] cArr;
        JSONSerializer jSONSerializer2 = jSONSerializer;
        Object obj3 = obj;
        SerializeWriter serializeWriter = jSONSerializer2.f14277k;
        if (obj3 == null) {
            serializeWriter.H();
            return;
        }
        if (obj3 instanceof XMLGregorianCalendar) {
            calendar = ((XMLGregorianCalendar) obj3).toGregorianCalendar();
        } else {
            calendar = (Calendar) obj3;
        }
        if (serializeWriter.n(SerializerFeature.UseISO8601DateFormat)) {
            char c11 = serializeWriter.n(SerializerFeature.UseSingleQuotes) ? '\'' : '\"';
            serializeWriter.append(c11);
            int i12 = calendar.get(1);
            int i13 = calendar.get(2) + 1;
            int i14 = calendar.get(5);
            int i15 = calendar.get(11);
            int i16 = calendar.get(12);
            int i17 = calendar.get(13);
            int i18 = calendar.get(14);
            if (i18 != 0) {
                cArr = "0000-00-00T00:00:00.000".toCharArray();
                IOUtils.i(i18, 23, cArr);
                IOUtils.i(i17, 19, cArr);
                IOUtils.i(i16, 16, cArr);
                IOUtils.i(i15, 13, cArr);
                IOUtils.i(i14, 10, cArr);
                IOUtils.i(i13, 7, cArr);
                IOUtils.i(i12, 4, cArr);
            } else if (i17 == 0 && i16 == 0 && i15 == 0) {
                cArr = "0000-00-00".toCharArray();
                IOUtils.i(i14, 10, cArr);
                IOUtils.i(i13, 7, cArr);
                IOUtils.i(i12, 4, cArr);
            } else {
                cArr = "0000-00-00T00:00:00".toCharArray();
                IOUtils.i(i17, 19, cArr);
                IOUtils.i(i16, 16, cArr);
                IOUtils.i(i15, 13, cArr);
                IOUtils.i(i14, 10, cArr);
                IOUtils.i(i13, 7, cArr);
                IOUtils.i(i12, 4, cArr);
            }
            serializeWriter.write(cArr);
            int rawOffset = calendar.getTimeZone().getRawOffset() / Constants.ONE_HOUR;
            if (rawOffset == 0) {
                serializeWriter.append("Z");
            } else if (rawOffset > 0) {
                serializeWriter.append("+").append(String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, new Object[]{Integer.valueOf(rawOffset)})).append(":00");
            } else {
                serializeWriter.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, new Object[]{Integer.valueOf(-rawOffset)})).append(":00");
            }
            serializeWriter.append(c11);
            return;
        }
        jSONSerializer2.E(calendar.getTime());
    }

    public <T> T e(a aVar, Type type, Object obj) {
        T e11 = DateCodec.f14265a.e(aVar, type, obj);
        if (e11 instanceof Calendar) {
            return e11;
        }
        Date date = (Date) e11;
        if (date == null) {
            return null;
        }
        b bVar = aVar.f15701g;
        T instance = Calendar.getInstance(bVar.k(), bVar.getLocale());
        instance.setTime(date);
        return type == XMLGregorianCalendar.class ? f((GregorianCalendar) instance) : instance;
    }

    public XMLGregorianCalendar f(Calendar calendar) {
        if (this.f14261a == null) {
            try {
                this.f14261a = DatatypeFactory.newInstance();
            } catch (DatatypeConfigurationException e11) {
                throw new IllegalStateException("Could not obtain an instance of DatatypeFactory.", e11);
            }
        }
        return this.f14261a.newXMLGregorianCalendar((GregorianCalendar) calendar);
    }
}
