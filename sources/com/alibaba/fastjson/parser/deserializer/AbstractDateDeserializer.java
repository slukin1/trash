package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.Feature;
import com.tencent.thumbplayer.tcmedia.tplayer.plugins.report.TPReportParams;
import f2.a;
import f2.b;
import f2.e;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class AbstractDateDeserializer extends ContextObjectDeserializer {
    public <T> T e(a aVar, Type type, Object obj) {
        return f(aVar, type, obj, (String) null, 0);
    }

    public <T> T f(a aVar, Type type, Object obj, String str, int i11) {
        SimpleDateFormat simpleDateFormat;
        Date parse;
        b bVar = aVar.f15701g;
        Object obj2 = null;
        if (bVar.J() == 2) {
            obj2 = Long.valueOf(bVar.u());
            bVar.f(16);
        } else if (bVar.J() == 4) {
            String H = bVar.H();
            if (str != null) {
                try {
                    simpleDateFormat = new SimpleDateFormat(str, JSON.defaultLocale);
                } catch (IllegalArgumentException unused) {
                    if (str.equals("yyyy-MM-ddTHH:mm:ss.SSS")) {
                        simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
                        str = "yyyy-MM-dd'T'HH:mm:ss.SSS";
                    } else if (str.equals("yyyy-MM-ddTHH:mm:ss")) {
                        simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
                        str = "yyyy-MM-dd'T'HH:mm:ss";
                    } else {
                        simpleDateFormat = null;
                    }
                }
                try {
                    parse = simpleDateFormat.parse(H);
                } catch (ParseException unused2) {
                    if (str.equals("yyyy-MM-dd'T'HH:mm:ss.SSS") && H.length() == 19) {
                        try {
                            parse = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(H);
                        } catch (ParseException unused3) {
                        }
                    }
                }
                obj2 = parse;
            }
            if (obj2 == null) {
                bVar.f(16);
                String str2 = H;
                if (bVar.a(Feature.AllowISO8601DateFormat)) {
                    e eVar = new e(H);
                    Date date = H;
                    if (eVar.C0()) {
                        date = eVar.U().getTime();
                    }
                    eVar.close();
                    str2 = date;
                }
                obj2 = str2;
            }
        } else if (bVar.J() == 8) {
            bVar.nextToken();
        } else if (bVar.J() == 12) {
            bVar.nextToken();
            if (bVar.J() == 4) {
                if (JSON.DEFAULT_TYPE_KEY.equals(bVar.H())) {
                    bVar.nextToken();
                    aVar.a(17);
                    Class<?> e11 = aVar.k().e(bVar.H(), (Class<?>) null);
                    if (e11 != null) {
                        type = e11;
                    }
                    aVar.a(4);
                    aVar.a(16);
                }
                bVar.y(2);
                if (bVar.J() == 2) {
                    long u11 = bVar.u();
                    bVar.nextToken();
                    obj2 = Long.valueOf(u11);
                    aVar.a(13);
                } else {
                    throw new JSONException("syntax error : " + bVar.b());
                }
            } else {
                throw new JSONException("syntax error");
            }
        } else if (aVar.v() == 2) {
            aVar.V(0);
            aVar.a(16);
            if (bVar.J() != 4) {
                throw new JSONException("syntax error");
            } else if (TPReportParams.JSON_KEY_VAL.equals(bVar.H())) {
                bVar.nextToken();
                aVar.a(17);
                obj2 = aVar.z();
                aVar.a(13);
            } else {
                throw new JSONException("syntax error");
            }
        } else {
            obj2 = aVar.z();
        }
        return g(aVar, type, obj, obj2);
    }

    public abstract <T> T g(a aVar, Type type, Object obj, Object obj2);
}
