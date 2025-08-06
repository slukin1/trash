package com.alibaba.fastjson.serializer;

import h2.k;
import java.io.IOException;
import java.lang.reflect.Type;

public class MapSerializer extends SerializeFilterable implements k {

    /* renamed from: j  reason: collision with root package name */
    public static MapSerializer f14288j = new MapSerializer();

    public void c(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i11) throws IOException {
        q(jSONSerializer, obj, obj2, type, i11, false);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:60:0x00d5, code lost:
        if (f(r8, r0, (java.lang.String) r1) == false) goto L_0x00d7;
     */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x0221 A[Catch:{ all -> 0x02b5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x0238 A[Catch:{ all -> 0x02b5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x0268 A[Catch:{ all -> 0x02b5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:181:0x0271 A[Catch:{ all -> 0x02b5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:192:0x02af  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:201:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0096 A[Catch:{ all -> 0x02b5 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void q(com.alibaba.fastjson.serializer.JSONSerializer r21, java.lang.Object r22, java.lang.Object r23, java.lang.reflect.Type r24, int r25, boolean r26) throws java.io.IOException {
        /*
            r20 = this;
            r7 = r20
            r8 = r21
            r0 = r22
            com.alibaba.fastjson.serializer.SerializeWriter r9 = r8.f14277k
            if (r0 != 0) goto L_0x000e
            r9.H()
            return
        L_0x000e:
            r1 = r0
            java.util.Map r1 = (java.util.Map) r1
            com.alibaba.fastjson.serializer.SerializerFeature r2 = com.alibaba.fastjson.serializer.SerializerFeature.MapSortField
            int r2 = r2.mask
            int r3 = r9.f14322d
            r3 = r3 & r2
            if (r3 != 0) goto L_0x001e
            r2 = r25 & r2
            if (r2 == 0) goto L_0x002d
        L_0x001e:
            boolean r2 = r1 instanceof java.util.SortedMap
            if (r2 != 0) goto L_0x002d
            boolean r2 = r1 instanceof java.util.LinkedHashMap
            if (r2 != 0) goto L_0x002d
            java.util.TreeMap r2 = new java.util.TreeMap     // Catch:{ Exception -> 0x002d }
            r2.<init>(r1)     // Catch:{ Exception -> 0x002d }
            r10 = r2
            goto L_0x002e
        L_0x002d:
            r10 = r1
        L_0x002e:
            boolean r1 = r21.r(r22)
            if (r1 == 0) goto L_0x0038
            r21.H(r22)
            return
        L_0x0038:
            h2.n r11 = r8.f14283q
            r12 = 0
            r1 = r23
            r8.B(r11, r0, r1, r12)
            if (r26 != 0) goto L_0x0047
            r1 = 123(0x7b, float:1.72E-43)
            r9.write((int) r1)     // Catch:{ all -> 0x02b5 }
        L_0x0047:
            r21.x()     // Catch:{ all -> 0x02b5 }
            com.alibaba.fastjson.serializer.SerializerFeature r1 = com.alibaba.fastjson.serializer.SerializerFeature.WriteClassName     // Catch:{ all -> 0x02b5 }
            boolean r1 = r9.n(r1)     // Catch:{ all -> 0x02b5 }
            r13 = 1
            if (r1 == 0) goto L_0x0082
            com.alibaba.fastjson.serializer.SerializeConfig r1 = r8.f14276j     // Catch:{ all -> 0x02b5 }
            java.lang.String r1 = r1.f14303c     // Catch:{ all -> 0x02b5 }
            java.lang.Class r2 = r10.getClass()     // Catch:{ all -> 0x02b5 }
            java.lang.Class<com.alibaba.fastjson.JSONObject> r3 = com.alibaba.fastjson.JSONObject.class
            if (r2 == r3) goto L_0x0067
            java.lang.Class<java.util.HashMap> r3 = java.util.HashMap.class
            if (r2 == r3) goto L_0x0067
            java.lang.Class<java.util.LinkedHashMap> r3 = java.util.LinkedHashMap.class
            if (r2 != r3) goto L_0x006f
        L_0x0067:
            boolean r2 = r10.containsKey(r1)     // Catch:{ all -> 0x02b5 }
            if (r2 == 0) goto L_0x006f
            r2 = r13
            goto L_0x0070
        L_0x006f:
            r2 = r12
        L_0x0070:
            if (r2 != 0) goto L_0x0082
            r9.v(r1)     // Catch:{ all -> 0x02b5 }
            java.lang.Class r1 = r22.getClass()     // Catch:{ all -> 0x02b5 }
            java.lang.String r1 = r1.getName()     // Catch:{ all -> 0x02b5 }
            r9.K(r1)     // Catch:{ all -> 0x02b5 }
            r1 = r12
            goto L_0x0083
        L_0x0082:
            r1 = r13
        L_0x0083:
            java.util.Set r2 = r10.entrySet()     // Catch:{ all -> 0x02b5 }
            java.util.Iterator r14 = r2.iterator()     // Catch:{ all -> 0x02b5 }
            r2 = 0
            r15 = r1
            r6 = r2
            r16 = r6
        L_0x0090:
            boolean r1 = r14.hasNext()     // Catch:{ all -> 0x02b5 }
            if (r1 == 0) goto L_0x0297
            java.lang.Object r1 = r14.next()     // Catch:{ all -> 0x02b5 }
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1     // Catch:{ all -> 0x02b5 }
            java.lang.Object r5 = r1.getValue()     // Catch:{ all -> 0x02b5 }
            java.lang.Object r1 = r1.getKey()     // Catch:{ all -> 0x02b5 }
            java.util.List<h2.m> r2 = r8.f14312f     // Catch:{ all -> 0x02b5 }
            if (r2 == 0) goto L_0x00db
            int r2 = r2.size()     // Catch:{ all -> 0x02b5 }
            if (r2 <= 0) goto L_0x00db
            if (r1 == 0) goto L_0x00ce
            boolean r2 = r1 instanceof java.lang.String     // Catch:{ all -> 0x02b5 }
            if (r2 == 0) goto L_0x00b5
            goto L_0x00ce
        L_0x00b5:
            java.lang.Class r2 = r1.getClass()     // Catch:{ all -> 0x02b5 }
            boolean r2 = r2.isPrimitive()     // Catch:{ all -> 0x02b5 }
            if (r2 != 0) goto L_0x00c3
            boolean r2 = r1 instanceof java.lang.Number     // Catch:{ all -> 0x02b5 }
            if (r2 == 0) goto L_0x00db
        L_0x00c3:
            java.lang.String r2 = com.alibaba.fastjson.JSON.toJSONString(r1)     // Catch:{ all -> 0x02b5 }
            boolean r2 = r7.f(r8, r0, r2)     // Catch:{ all -> 0x02b5 }
            if (r2 != 0) goto L_0x00db
            goto L_0x00d7
        L_0x00ce:
            r2 = r1
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x02b5 }
            boolean r2 = r7.f(r8, r0, r2)     // Catch:{ all -> 0x02b5 }
            if (r2 != 0) goto L_0x00db
        L_0x00d7:
            r19 = r6
            goto L_0x0216
        L_0x00db:
            java.util.List<h2.m> r2 = r7.f14312f     // Catch:{ all -> 0x02b5 }
            if (r2 == 0) goto L_0x010f
            int r2 = r2.size()     // Catch:{ all -> 0x02b5 }
            if (r2 <= 0) goto L_0x010f
            if (r1 == 0) goto L_0x0105
            boolean r2 = r1 instanceof java.lang.String     // Catch:{ all -> 0x02b5 }
            if (r2 == 0) goto L_0x00ec
            goto L_0x0105
        L_0x00ec:
            java.lang.Class r2 = r1.getClass()     // Catch:{ all -> 0x02b5 }
            boolean r2 = r2.isPrimitive()     // Catch:{ all -> 0x02b5 }
            if (r2 != 0) goto L_0x00fa
            boolean r2 = r1 instanceof java.lang.Number     // Catch:{ all -> 0x02b5 }
            if (r2 == 0) goto L_0x010f
        L_0x00fa:
            java.lang.String r2 = com.alibaba.fastjson.JSON.toJSONString(r1)     // Catch:{ all -> 0x02b5 }
            boolean r2 = r7.f(r8, r0, r2)     // Catch:{ all -> 0x02b5 }
            if (r2 != 0) goto L_0x010f
            goto L_0x00d7
        L_0x0105:
            r2 = r1
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x02b5 }
            boolean r2 = r7.f(r8, r0, r2)     // Catch:{ all -> 0x02b5 }
            if (r2 != 0) goto L_0x010f
            goto L_0x00d7
        L_0x010f:
            java.util.List<h2.l> r2 = r8.f14309c     // Catch:{ all -> 0x02b5 }
            if (r2 == 0) goto L_0x0143
            int r2 = r2.size()     // Catch:{ all -> 0x02b5 }
            if (r2 <= 0) goto L_0x0143
            if (r1 == 0) goto L_0x0139
            boolean r2 = r1 instanceof java.lang.String     // Catch:{ all -> 0x02b5 }
            if (r2 == 0) goto L_0x0120
            goto L_0x0139
        L_0x0120:
            java.lang.Class r2 = r1.getClass()     // Catch:{ all -> 0x02b5 }
            boolean r2 = r2.isPrimitive()     // Catch:{ all -> 0x02b5 }
            if (r2 != 0) goto L_0x012e
            boolean r2 = r1 instanceof java.lang.Number     // Catch:{ all -> 0x02b5 }
            if (r2 == 0) goto L_0x0143
        L_0x012e:
            java.lang.String r2 = com.alibaba.fastjson.JSON.toJSONString(r1)     // Catch:{ all -> 0x02b5 }
            boolean r2 = r7.e(r8, r0, r2, r5)     // Catch:{ all -> 0x02b5 }
            if (r2 != 0) goto L_0x0143
            goto L_0x00d7
        L_0x0139:
            r2 = r1
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x02b5 }
            boolean r2 = r7.e(r8, r0, r2, r5)     // Catch:{ all -> 0x02b5 }
            if (r2 != 0) goto L_0x0143
            goto L_0x00d7
        L_0x0143:
            java.util.List<h2.l> r2 = r7.f14309c     // Catch:{ all -> 0x02b5 }
            if (r2 == 0) goto L_0x0179
            int r2 = r2.size()     // Catch:{ all -> 0x02b5 }
            if (r2 <= 0) goto L_0x0179
            if (r1 == 0) goto L_0x016e
            boolean r2 = r1 instanceof java.lang.String     // Catch:{ all -> 0x02b5 }
            if (r2 == 0) goto L_0x0154
            goto L_0x016e
        L_0x0154:
            java.lang.Class r2 = r1.getClass()     // Catch:{ all -> 0x02b5 }
            boolean r2 = r2.isPrimitive()     // Catch:{ all -> 0x02b5 }
            if (r2 != 0) goto L_0x0162
            boolean r2 = r1 instanceof java.lang.Number     // Catch:{ all -> 0x02b5 }
            if (r2 == 0) goto L_0x0179
        L_0x0162:
            java.lang.String r2 = com.alibaba.fastjson.JSON.toJSONString(r1)     // Catch:{ all -> 0x02b5 }
            boolean r2 = r7.e(r8, r0, r2, r5)     // Catch:{ all -> 0x02b5 }
            if (r2 != 0) goto L_0x0179
            goto L_0x00d7
        L_0x016e:
            r2 = r1
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x02b5 }
            boolean r2 = r7.e(r8, r0, r2, r5)     // Catch:{ all -> 0x02b5 }
            if (r2 != 0) goto L_0x0179
            goto L_0x00d7
        L_0x0179:
            java.util.List<h2.j> r2 = r8.f14311e     // Catch:{ all -> 0x02b5 }
            if (r2 == 0) goto L_0x01a7
            int r2 = r2.size()     // Catch:{ all -> 0x02b5 }
            if (r2 <= 0) goto L_0x01a7
            if (r1 == 0) goto L_0x01a1
            boolean r2 = r1 instanceof java.lang.String     // Catch:{ all -> 0x02b5 }
            if (r2 == 0) goto L_0x018a
            goto L_0x01a1
        L_0x018a:
            java.lang.Class r2 = r1.getClass()     // Catch:{ all -> 0x02b5 }
            boolean r2 = r2.isPrimitive()     // Catch:{ all -> 0x02b5 }
            if (r2 != 0) goto L_0x0198
            boolean r2 = r1 instanceof java.lang.Number     // Catch:{ all -> 0x02b5 }
            if (r2 == 0) goto L_0x01a7
        L_0x0198:
            java.lang.String r1 = com.alibaba.fastjson.JSON.toJSONString(r1)     // Catch:{ all -> 0x02b5 }
            java.lang.String r1 = r7.o(r8, r0, r1, r5)     // Catch:{ all -> 0x02b5 }
            goto L_0x01a7
        L_0x01a1:
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ all -> 0x02b5 }
            java.lang.String r1 = r7.o(r8, r0, r1, r5)     // Catch:{ all -> 0x02b5 }
        L_0x01a7:
            java.util.List<h2.j> r2 = r7.f14311e     // Catch:{ all -> 0x02b5 }
            if (r2 == 0) goto L_0x01d5
            int r2 = r2.size()     // Catch:{ all -> 0x02b5 }
            if (r2 <= 0) goto L_0x01d5
            if (r1 == 0) goto L_0x01cf
            boolean r2 = r1 instanceof java.lang.String     // Catch:{ all -> 0x02b5 }
            if (r2 == 0) goto L_0x01b8
            goto L_0x01cf
        L_0x01b8:
            java.lang.Class r2 = r1.getClass()     // Catch:{ all -> 0x02b5 }
            boolean r2 = r2.isPrimitive()     // Catch:{ all -> 0x02b5 }
            if (r2 != 0) goto L_0x01c6
            boolean r2 = r1 instanceof java.lang.Number     // Catch:{ all -> 0x02b5 }
            if (r2 == 0) goto L_0x01d5
        L_0x01c6:
            java.lang.String r1 = com.alibaba.fastjson.JSON.toJSONString(r1)     // Catch:{ all -> 0x02b5 }
            java.lang.String r1 = r7.o(r8, r0, r1, r5)     // Catch:{ all -> 0x02b5 }
            goto L_0x01d5
        L_0x01cf:
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ all -> 0x02b5 }
            java.lang.String r1 = r7.o(r8, r0, r1, r5)     // Catch:{ all -> 0x02b5 }
        L_0x01d5:
            r4 = r1
            if (r4 == 0) goto L_0x01f6
            boolean r1 = r4 instanceof java.lang.String     // Catch:{ all -> 0x02b5 }
            if (r1 == 0) goto L_0x01dd
            goto L_0x01f6
        L_0x01dd:
            java.lang.String r17 = com.alibaba.fastjson.JSON.toJSONString(r4)     // Catch:{ all -> 0x02b5 }
            r3 = 0
            r1 = r20
            r2 = r21
            r12 = r4
            r4 = r22
            r18 = r5
            r5 = r17
            r19 = r6
            r6 = r18
            java.lang.Object r1 = r1.p(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x02b5 }
            goto L_0x020b
        L_0x01f6:
            r12 = r4
            r18 = r5
            r19 = r6
            r3 = 0
            r5 = r12
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ all -> 0x02b5 }
            r1 = r20
            r2 = r21
            r4 = r22
            r6 = r18
            java.lang.Object r1 = r1.p(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x02b5 }
        L_0x020b:
            r3 = r1
            if (r3 != 0) goto L_0x021b
            int r1 = com.alibaba.fastjson.serializer.SerializerFeature.WRITE_MAP_NULL_FEATURES     // Catch:{ all -> 0x02b5 }
            boolean r1 = r9.m(r1)     // Catch:{ all -> 0x02b5 }
            if (r1 != 0) goto L_0x021b
        L_0x0216:
            r6 = r19
            r12 = 0
            goto L_0x0090
        L_0x021b:
            boolean r1 = r12 instanceof java.lang.String     // Catch:{ all -> 0x02b5 }
            r2 = 44
            if (r1 == 0) goto L_0x0238
            r4 = r12
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ all -> 0x02b5 }
            if (r15 != 0) goto L_0x0229
            r9.write((int) r2)     // Catch:{ all -> 0x02b5 }
        L_0x0229:
            com.alibaba.fastjson.serializer.SerializerFeature r1 = com.alibaba.fastjson.serializer.SerializerFeature.PrettyFormat     // Catch:{ all -> 0x02b5 }
            boolean r1 = r9.n(r1)     // Catch:{ all -> 0x02b5 }
            if (r1 == 0) goto L_0x0234
            r21.A()     // Catch:{ all -> 0x02b5 }
        L_0x0234:
            r9.w(r4, r13)     // Catch:{ all -> 0x02b5 }
            goto L_0x0266
        L_0x0238:
            if (r15 != 0) goto L_0x023d
            r9.write((int) r2)     // Catch:{ all -> 0x02b5 }
        L_0x023d:
            com.alibaba.fastjson.serializer.SerializerFeature r1 = com.alibaba.fastjson.serializer.SerializerFeature.BrowserCompatible     // Catch:{ all -> 0x02b5 }
            boolean r1 = r9.n(r1)     // Catch:{ all -> 0x02b5 }
            if (r1 != 0) goto L_0x025a
            com.alibaba.fastjson.serializer.SerializerFeature r1 = com.alibaba.fastjson.serializer.SerializerFeature.WriteNonStringKeyAsString     // Catch:{ all -> 0x02b5 }
            boolean r1 = r9.n(r1)     // Catch:{ all -> 0x02b5 }
            if (r1 != 0) goto L_0x025a
            com.alibaba.fastjson.serializer.SerializerFeature r1 = com.alibaba.fastjson.serializer.SerializerFeature.BrowserSecure     // Catch:{ all -> 0x02b5 }
            boolean r1 = r9.n(r1)     // Catch:{ all -> 0x02b5 }
            if (r1 == 0) goto L_0x0256
            goto L_0x025a
        L_0x0256:
            r8.E(r12)     // Catch:{ all -> 0x02b5 }
            goto L_0x0261
        L_0x025a:
            java.lang.String r1 = com.alibaba.fastjson.JSON.toJSONString(r12)     // Catch:{ all -> 0x02b5 }
            r8.F(r1)     // Catch:{ all -> 0x02b5 }
        L_0x0261:
            r1 = 58
            r9.write((int) r1)     // Catch:{ all -> 0x02b5 }
        L_0x0266:
            if (r3 != 0) goto L_0x0271
            r9.H()     // Catch:{ all -> 0x02b5 }
        L_0x026b:
            r6 = r19
        L_0x026d:
            r12 = 0
            r15 = 0
            goto L_0x0090
        L_0x0271:
            java.lang.Class r15 = r3.getClass()     // Catch:{ all -> 0x02b5 }
            r6 = r19
            if (r15 != r6) goto L_0x0287
            r5 = 0
            r15 = 0
            r1 = r16
            r2 = r21
            r4 = r12
            r19 = r6
            r6 = r15
            r1.c(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x02b5 }
            goto L_0x026b
        L_0x0287:
            h2.k r16 = r8.v(r15)     // Catch:{ all -> 0x02b5 }
            r5 = 0
            r6 = 0
            r1 = r16
            r2 = r21
            r4 = r12
            r1.c(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x02b5 }
            r6 = r15
            goto L_0x026d
        L_0x0297:
            r8.f14283q = r11
            r21.s()
            com.alibaba.fastjson.serializer.SerializerFeature r0 = com.alibaba.fastjson.serializer.SerializerFeature.PrettyFormat
            boolean r0 = r9.n(r0)
            if (r0 == 0) goto L_0x02ad
            int r0 = r10.size()
            if (r0 <= 0) goto L_0x02ad
            r21.A()
        L_0x02ad:
            if (r26 != 0) goto L_0x02b4
            r0 = 125(0x7d, float:1.75E-43)
            r9.write((int) r0)
        L_0x02b4:
            return
        L_0x02b5:
            r0 = move-exception
            r8.f14283q = r11
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.serializer.MapSerializer.q(com.alibaba.fastjson.serializer.JSONSerializer, java.lang.Object, java.lang.Object, java.lang.reflect.Type, int, boolean):void");
    }
}
