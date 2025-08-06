package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONToken;
import f2.a;
import f2.b;
import g2.l;
import java.lang.reflect.Type;

public class StackTraceElementDeserializer implements l {

    /* renamed from: a  reason: collision with root package name */
    public static final StackTraceElementDeserializer f14223a = new StackTraceElementDeserializer();

    public int b() {
        return 12;
    }

    public <T> T e(a aVar, Type type, Object obj) {
        b bVar = aVar.f15701g;
        if (bVar.J() == 8) {
            bVar.nextToken();
            return null;
        } else if (bVar.J() == 12 || bVar.J() == 16) {
            int i11 = 0;
            String str = null;
            String str2 = null;
            String str3 = null;
            while (true) {
                String L = bVar.L(aVar.w());
                if (L == null) {
                    if (bVar.J() == 13) {
                        bVar.f(16);
                        break;
                    } else if (bVar.J() == 16 && bVar.a(Feature.AllowArbitraryCommas)) {
                    }
                }
                bVar.y(4);
                if ("className".equals(L)) {
                    if (bVar.J() == 8) {
                        str = null;
                    } else if (bVar.J() == 4) {
                        str = bVar.H();
                    } else {
                        throw new JSONException("syntax error");
                    }
                } else if ("methodName".equals(L)) {
                    if (bVar.J() == 8) {
                        str2 = null;
                    } else if (bVar.J() == 4) {
                        str2 = bVar.H();
                    } else {
                        throw new JSONException("syntax error");
                    }
                } else if ("fileName".equals(L)) {
                    if (bVar.J() == 8) {
                        str3 = null;
                    } else if (bVar.J() == 4) {
                        str3 = bVar.H();
                    } else {
                        throw new JSONException("syntax error");
                    }
                } else if ("lineNumber".equals(L)) {
                    if (bVar.J() == 8) {
                        i11 = 0;
                    } else if (bVar.J() == 2) {
                        i11 = bVar.w();
                    } else {
                        throw new JSONException("syntax error");
                    }
                } else if ("nativeMethod".equals(L)) {
                    if (bVar.J() == 8) {
                        bVar.f(16);
                    } else if (bVar.J() == 6) {
                        bVar.f(16);
                    } else if (bVar.J() == 7) {
                        bVar.f(16);
                    } else {
                        throw new JSONException("syntax error");
                    }
                } else if (L == JSON.DEFAULT_TYPE_KEY) {
                    if (bVar.J() == 4) {
                        String H = bVar.H();
                        if (!H.equals("java.lang.StackTraceElement")) {
                            throw new JSONException("syntax error : " + H);
                        }
                    } else if (bVar.J() != 8) {
                        throw new JSONException("syntax error");
                    }
                } else if ("moduleName".equals(L)) {
                    if (bVar.J() != 8) {
                        if (bVar.J() == 4) {
                            bVar.H();
                        } else {
                            throw new JSONException("syntax error");
                        }
                    }
                } else if (!"moduleVersion".equals(L)) {
                    throw new JSONException("syntax error : " + L);
                } else if (bVar.J() != 8) {
                    if (bVar.J() == 4) {
                        bVar.H();
                    } else {
                        throw new JSONException("syntax error");
                    }
                }
                if (bVar.J() == 13) {
                    bVar.f(16);
                    break;
                }
            }
            return new StackTraceElement(str, str2, str3, i11);
        } else {
            throw new JSONException("syntax error: " + JSONToken.a(bVar.J()));
        }
    }
}
