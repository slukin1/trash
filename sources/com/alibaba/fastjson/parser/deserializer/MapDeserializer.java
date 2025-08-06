package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONToken;
import f2.a;
import f2.b;
import f2.f;
import g2.l;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class MapDeserializer implements l {

    /* renamed from: a  reason: collision with root package name */
    public static MapDeserializer f14217a = new MapDeserializer();

    public static Object f(a aVar, Map<Object, Object> map, Type type, Type type2, Object obj) {
        b bVar = aVar.f15701g;
        if (bVar.J() == 12 || bVar.J() == 16) {
            l j11 = aVar.k().j(type);
            l j12 = aVar.k().j(type2);
            bVar.f(j11.b());
            f l11 = aVar.l();
            while (bVar.J() != 13) {
                try {
                    Object obj2 = null;
                    if (bVar.J() != 4 || !bVar.D() || bVar.a(Feature.DisableSpecialKeyDetect)) {
                        if (map.size() == 0 && bVar.J() == 4 && JSON.DEFAULT_TYPE_KEY.equals(bVar.H()) && !bVar.a(Feature.DisableSpecialKeyDetect)) {
                            bVar.y(4);
                            bVar.f(16);
                            if (bVar.J() == 13) {
                                bVar.nextToken();
                                return map;
                            }
                            bVar.f(j11.b());
                        }
                        Object e11 = j11.e(aVar, type, (Object) null);
                        if (bVar.J() == 17) {
                            bVar.f(j12.b());
                            Object e12 = j12.e(aVar, type2, e11);
                            aVar.j(map, e11);
                            map.put(e11, e12);
                            if (bVar.J() == 16) {
                                bVar.f(j11.b());
                            }
                        } else {
                            throw new JSONException("syntax error, expect :, actual " + bVar.J());
                        }
                    } else {
                        bVar.y(4);
                        if (bVar.J() == 4) {
                            String H = bVar.H();
                            if ("..".equals(H)) {
                                obj2 = l11.f15740b.f15739a;
                            } else if ("$".equals(H)) {
                                f fVar = l11;
                                while (true) {
                                    f fVar2 = fVar.f15740b;
                                    if (fVar2 == null) {
                                        break;
                                    }
                                    fVar = fVar2;
                                }
                                obj2 = fVar.f15739a;
                            } else {
                                aVar.f(new a.C0078a(l11, H));
                                aVar.V(1);
                            }
                            bVar.f(13);
                            if (bVar.J() == 13) {
                                bVar.f(16);
                                aVar.T(l11);
                                return obj2;
                            }
                            throw new JSONException("illegal ref");
                        }
                        throw new JSONException("illegal ref, " + JSONToken.a(bVar.J()));
                    }
                } finally {
                    aVar.T(l11);
                }
            }
            bVar.f(16);
            aVar.T(l11);
            return map;
        }
        throw new JSONException("syntax error, expect {, actual " + bVar.b());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:61:?, code lost:
        r11 = r4.j(r3);
        r0.f(16);
        r10.V(2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0197, code lost:
        if (r1 == null) goto L_0x01a0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x019b, code lost:
        if ((r13 instanceof java.lang.Integer) != false) goto L_0x01a0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x019d, code lost:
        r10.Q();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x01a0, code lost:
        r11 = (java.util.Map) r11.e(r10, r3, r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x01a6, code lost:
        r10.T(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x01a9, code lost:
        return r11;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.Map g(f2.a r10, java.util.Map<java.lang.String, java.lang.Object> r11, java.lang.reflect.Type r12, java.lang.Object r13) {
        /*
            f2.b r0 = r10.f15701g
            int r1 = r0.J()
            r2 = 0
            r3 = 12
            if (r1 == r3) goto L_0x0088
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = "syntax error, expect {, actual "
            r11.append(r12)
            java.lang.String r12 = r0.b()
            r11.append(r12)
            java.lang.String r11 = r11.toString()
            boolean r12 = r13 instanceof java.lang.String
            if (r12 == 0) goto L_0x0044
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            r12.append(r11)
            java.lang.String r11 = ", fieldName "
            r12.append(r11)
            java.lang.String r11 = r12.toString()
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            r12.append(r11)
            r12.append(r13)
            java.lang.String r11 = r12.toString()
        L_0x0044:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            r12.append(r11)
            java.lang.String r11 = ", "
            r12.append(r11)
            java.lang.String r11 = r12.toString()
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            r12.append(r11)
            java.lang.String r11 = r0.t()
            r12.append(r11)
            java.lang.String r11 = r12.toString()
            com.alibaba.fastjson.JSONArray r12 = new com.alibaba.fastjson.JSONArray
            r12.<init>()
            r10.G(r12, r13)
            int r10 = r12.size()
            r13 = 1
            if (r10 != r13) goto L_0x0082
            java.lang.Object r10 = r12.get(r2)
            boolean r12 = r10 instanceof com.alibaba.fastjson.JSONObject
            if (r12 == 0) goto L_0x0082
            com.alibaba.fastjson.JSONObject r10 = (com.alibaba.fastjson.JSONObject) r10
            return r10
        L_0x0082:
            com.alibaba.fastjson.JSONException r10 = new com.alibaba.fastjson.JSONException
            r10.<init>(r11)
            throw r10
        L_0x0088:
            f2.f r1 = r10.l()
        L_0x008c:
            r0.p()     // Catch:{ all -> 0x0213 }
            char r3 = r0.A()     // Catch:{ all -> 0x0213 }
            com.alibaba.fastjson.parser.Feature r4 = com.alibaba.fastjson.parser.Feature.AllowArbitraryCommas     // Catch:{ all -> 0x0213 }
            boolean r4 = r0.a(r4)     // Catch:{ all -> 0x0213 }
            if (r4 == 0) goto L_0x00aa
        L_0x009b:
            r4 = 44
            if (r3 != r4) goto L_0x00aa
            r0.next()     // Catch:{ all -> 0x0213 }
            r0.p()     // Catch:{ all -> 0x0213 }
            char r3 = r0.A()     // Catch:{ all -> 0x0213 }
            goto L_0x009b
        L_0x00aa:
            java.lang.String r4 = "expect ':' at "
            r5 = 58
            r6 = 34
            r7 = 16
            if (r3 != r6) goto L_0x00e0
            f2.g r3 = r10.w()     // Catch:{ all -> 0x0213 }
            java.lang.String r3 = r0.o(r3, r6)     // Catch:{ all -> 0x0213 }
            r0.p()     // Catch:{ all -> 0x0213 }
            char r8 = r0.A()     // Catch:{ all -> 0x0213 }
            if (r8 != r5) goto L_0x00c7
            goto L_0x0149
        L_0x00c7:
            com.alibaba.fastjson.JSONException r11 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x0213 }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ all -> 0x0213 }
            r12.<init>()     // Catch:{ all -> 0x0213 }
            r12.append(r4)     // Catch:{ all -> 0x0213 }
            int r13 = r0.s()     // Catch:{ all -> 0x0213 }
            r12.append(r13)     // Catch:{ all -> 0x0213 }
            java.lang.String r12 = r12.toString()     // Catch:{ all -> 0x0213 }
            r11.<init>(r12)     // Catch:{ all -> 0x0213 }
            throw r11     // Catch:{ all -> 0x0213 }
        L_0x00e0:
            r8 = 125(0x7d, float:1.75E-43)
            if (r3 != r8) goto L_0x00f1
            r0.next()     // Catch:{ all -> 0x0213 }
            r0.K()     // Catch:{ all -> 0x0213 }
            r0.f(r7)     // Catch:{ all -> 0x0213 }
            r10.T(r1)
            return r11
        L_0x00f1:
            java.lang.String r8 = "syntax error"
            r9 = 39
            if (r3 != r9) goto L_0x0130
            com.alibaba.fastjson.parser.Feature r3 = com.alibaba.fastjson.parser.Feature.AllowSingleQuotes     // Catch:{ all -> 0x0213 }
            boolean r3 = r0.a(r3)     // Catch:{ all -> 0x0213 }
            if (r3 == 0) goto L_0x012a
            f2.g r3 = r10.w()     // Catch:{ all -> 0x0213 }
            java.lang.String r3 = r0.o(r3, r9)     // Catch:{ all -> 0x0213 }
            r0.p()     // Catch:{ all -> 0x0213 }
            char r8 = r0.A()     // Catch:{ all -> 0x0213 }
            if (r8 != r5) goto L_0x0111
            goto L_0x0149
        L_0x0111:
            com.alibaba.fastjson.JSONException r11 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x0213 }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ all -> 0x0213 }
            r12.<init>()     // Catch:{ all -> 0x0213 }
            r12.append(r4)     // Catch:{ all -> 0x0213 }
            int r13 = r0.s()     // Catch:{ all -> 0x0213 }
            r12.append(r13)     // Catch:{ all -> 0x0213 }
            java.lang.String r12 = r12.toString()     // Catch:{ all -> 0x0213 }
            r11.<init>(r12)     // Catch:{ all -> 0x0213 }
            throw r11     // Catch:{ all -> 0x0213 }
        L_0x012a:
            com.alibaba.fastjson.JSONException r11 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x0213 }
            r11.<init>(r8)     // Catch:{ all -> 0x0213 }
            throw r11     // Catch:{ all -> 0x0213 }
        L_0x0130:
            com.alibaba.fastjson.parser.Feature r3 = com.alibaba.fastjson.parser.Feature.AllowUnQuotedFieldNames     // Catch:{ all -> 0x0213 }
            boolean r3 = r0.a(r3)     // Catch:{ all -> 0x0213 }
            if (r3 == 0) goto L_0x020d
            f2.g r3 = r10.w()     // Catch:{ all -> 0x0213 }
            java.lang.String r3 = r0.C(r3)     // Catch:{ all -> 0x0213 }
            r0.p()     // Catch:{ all -> 0x0213 }
            char r8 = r0.A()     // Catch:{ all -> 0x0213 }
            if (r8 != r5) goto L_0x01ec
        L_0x0149:
            r0.next()     // Catch:{ all -> 0x0213 }
            r0.p()     // Catch:{ all -> 0x0213 }
            r0.A()     // Catch:{ all -> 0x0213 }
            r0.K()     // Catch:{ all -> 0x0213 }
            java.lang.String r4 = com.alibaba.fastjson.JSON.DEFAULT_TYPE_KEY     // Catch:{ all -> 0x0213 }
            r5 = 13
            r8 = 0
            if (r3 != r4) goto L_0x01aa
            com.alibaba.fastjson.parser.Feature r4 = com.alibaba.fastjson.parser.Feature.DisableSpecialKeyDetect     // Catch:{ all -> 0x0213 }
            boolean r4 = r0.a(r4)     // Catch:{ all -> 0x0213 }
            if (r4 != 0) goto L_0x01aa
            f2.g r3 = r10.w()     // Catch:{ all -> 0x0213 }
            java.lang.String r3 = r0.o(r3, r6)     // Catch:{ all -> 0x0213 }
            com.alibaba.fastjson.parser.ParserConfig r4 = r10.k()     // Catch:{ all -> 0x0213 }
            java.lang.Class r3 = r4.e(r3, r8)     // Catch:{ all -> 0x0213 }
            java.lang.Class<java.util.Map> r6 = java.util.Map.class
            boolean r6 = r6.isAssignableFrom(r3)     // Catch:{ all -> 0x0213 }
            if (r6 == 0) goto L_0x018c
            r0.f(r7)     // Catch:{ all -> 0x0213 }
            int r3 = r0.J()     // Catch:{ all -> 0x0213 }
            if (r3 != r5) goto L_0x01e4
            r0.f(r7)     // Catch:{ all -> 0x0213 }
            r10.T(r1)
            return r11
        L_0x018c:
            g2.l r11 = r4.j(r3)     // Catch:{ all -> 0x0213 }
            r0.f(r7)     // Catch:{ all -> 0x0213 }
            r12 = 2
            r10.V(r12)     // Catch:{ all -> 0x0213 }
            if (r1 == 0) goto L_0x01a0
            boolean r12 = r13 instanceof java.lang.Integer     // Catch:{ all -> 0x0213 }
            if (r12 != 0) goto L_0x01a0
            r10.Q()     // Catch:{ all -> 0x0213 }
        L_0x01a0:
            java.lang.Object r11 = r11.e(r10, r3, r13)     // Catch:{ all -> 0x0213 }
            java.util.Map r11 = (java.util.Map) r11     // Catch:{ all -> 0x0213 }
            r10.T(r1)
            return r11
        L_0x01aa:
            r0.nextToken()     // Catch:{ all -> 0x0213 }
            if (r2 == 0) goto L_0x01b2
            r10.T(r1)     // Catch:{ all -> 0x0213 }
        L_0x01b2:
            int r4 = r0.J()     // Catch:{ all -> 0x0213 }
            r6 = 8
            if (r4 != r6) goto L_0x01be
            r0.nextToken()     // Catch:{ all -> 0x0213 }
            goto L_0x01c2
        L_0x01be:
            java.lang.Object r8 = r10.M(r12, r3)     // Catch:{ all -> 0x0213 }
        L_0x01c2:
            r11.put(r3, r8)     // Catch:{ all -> 0x0213 }
            r10.j(r11, r3)     // Catch:{ all -> 0x0213 }
            r10.R(r1, r8, r3)     // Catch:{ all -> 0x0213 }
            r10.T(r1)     // Catch:{ all -> 0x0213 }
            int r3 = r0.J()     // Catch:{ all -> 0x0213 }
            r4 = 20
            if (r3 == r4) goto L_0x01e8
            r4 = 15
            if (r3 != r4) goto L_0x01db
            goto L_0x01e8
        L_0x01db:
            if (r3 != r5) goto L_0x01e4
            r0.nextToken()     // Catch:{ all -> 0x0213 }
            r10.T(r1)
            return r11
        L_0x01e4:
            int r2 = r2 + 1
            goto L_0x008c
        L_0x01e8:
            r10.T(r1)
            return r11
        L_0x01ec:
            com.alibaba.fastjson.JSONException r11 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x0213 }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ all -> 0x0213 }
            r12.<init>()     // Catch:{ all -> 0x0213 }
            r12.append(r4)     // Catch:{ all -> 0x0213 }
            int r13 = r0.s()     // Catch:{ all -> 0x0213 }
            r12.append(r13)     // Catch:{ all -> 0x0213 }
            java.lang.String r13 = ", actual "
            r12.append(r13)     // Catch:{ all -> 0x0213 }
            r12.append(r8)     // Catch:{ all -> 0x0213 }
            java.lang.String r12 = r12.toString()     // Catch:{ all -> 0x0213 }
            r11.<init>(r12)     // Catch:{ all -> 0x0213 }
            throw r11     // Catch:{ all -> 0x0213 }
        L_0x020d:
            com.alibaba.fastjson.JSONException r11 = new com.alibaba.fastjson.JSONException     // Catch:{ all -> 0x0213 }
            r11.<init>(r8)     // Catch:{ all -> 0x0213 }
            throw r11     // Catch:{ all -> 0x0213 }
        L_0x0213:
            r11 = move-exception
            r10.T(r1)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.deserializer.MapDeserializer.g(f2.a, java.util.Map, java.lang.reflect.Type, java.lang.Object):java.util.Map");
    }

    public int b() {
        return 12;
    }

    public Map<Object, Object> c(Type type) {
        if (type == Properties.class) {
            return new Properties();
        }
        if (type == Hashtable.class) {
            return new Hashtable();
        }
        if (type == IdentityHashMap.class) {
            return new IdentityHashMap();
        }
        if (type == SortedMap.class || type == TreeMap.class) {
            return new TreeMap();
        }
        if (type == ConcurrentMap.class || type == ConcurrentHashMap.class) {
            return new ConcurrentHashMap();
        }
        if (type == Map.class || type == HashMap.class) {
            return new HashMap();
        }
        if (type == LinkedHashMap.class) {
            return new LinkedHashMap();
        }
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Type rawType = parameterizedType.getRawType();
            if (EnumMap.class.equals(rawType)) {
                return new EnumMap((Class) parameterizedType.getActualTypeArguments()[0]);
            }
            return c(rawType);
        }
        Class cls = (Class) type;
        if (!cls.isInterface()) {
            try {
                return (Map) cls.newInstance();
            } catch (Exception e11) {
                throw new JSONException("unsupport type " + type, e11);
            }
        } else {
            throw new JSONException("unsupport type " + type);
        }
    }

    public Object d(a aVar, Type type, Object obj, Map map) {
        Type type2;
        if (!(type instanceof ParameterizedType)) {
            return aVar.O(map, obj);
        }
        ParameterizedType parameterizedType = (ParameterizedType) type;
        Type type3 = parameterizedType.getActualTypeArguments()[0];
        if (map.getClass().getName().equals("org.springframework.util.LinkedMultiValueMap")) {
            type2 = List.class;
        } else {
            type2 = parameterizedType.getActualTypeArguments()[1];
        }
        if (String.class == type3) {
            return g(aVar, map, type2, obj);
        }
        return f(aVar, map, type3, type2, obj);
    }

    public <T> T e(a aVar, Type type, Object obj) {
        if (type == JSONObject.class && aVar.r() == null) {
            return aVar.J();
        }
        b bVar = aVar.f15701g;
        if (bVar.J() == 8) {
            bVar.f(16);
            return null;
        }
        Map<Object, Object> c11 = c(type);
        f l11 = aVar.l();
        try {
            aVar.R(l11, c11, obj);
            return d(aVar, type, obj, c11);
        } finally {
            aVar.T(l11);
        }
    }
}
