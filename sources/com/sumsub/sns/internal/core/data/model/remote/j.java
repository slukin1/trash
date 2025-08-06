package com.sumsub.sns.internal.core.data.model.remote;

public final class j {
    /* JADX WARNING: Removed duplicated region for block: B:102:0x018e  */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x0250  */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x0264  */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x026a  */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x0271  */
    /* JADX WARNING: Removed duplicated region for block: B:206:0x0325  */
    /* JADX WARNING: Removed duplicated region for block: B:256:0x03f3  */
    /* JADX WARNING: Removed duplicated region for block: B:259:0x0401  */
    /* JADX WARNING: Removed duplicated region for block: B:263:0x0421  */
    /* JADX WARNING: Removed duplicated region for block: B:266:0x0428  */
    /* JADX WARNING: Removed duplicated region for block: B:269:0x0439  */
    /* JADX WARNING: Removed duplicated region for block: B:270:0x043b  */
    /* JADX WARNING: Removed duplicated region for block: B:272:0x043e  */
    /* JADX WARNING: Removed duplicated region for block: B:273:0x0441  */
    /* JADX WARNING: Removed duplicated region for block: B:278:0x002a A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:290:0x0191 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:299:0x0253 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:308:0x0328 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:317:0x03f6 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00b8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final com.sumsub.sns.internal.core.data.model.e a(com.sumsub.sns.internal.core.data.model.remote.i r22) {
        /*
            java.lang.String r0 = r22.x()
            if (r0 != 0) goto L_0x0008
            java.lang.String r0 = "<unknown>"
        L_0x0008:
            r2 = r0
            com.sumsub.sns.core.data.model.FlowType r0 = r22.J()
            if (r0 != 0) goto L_0x0011
            com.sumsub.sns.core.data.model.FlowType r0 = com.sumsub.sns.core.data.model.FlowType.Standalone
        L_0x0011:
            r3 = r0
            java.lang.String r4 = r22.L()
            java.util.Map r0 = r22.R()
            r1 = 1
            if (r0 == 0) goto L_0x00c2
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            java.util.Set r0 = r0.entrySet()
            java.util.Iterator r0 = r0.iterator()
        L_0x002a:
            boolean r7 = r0.hasNext()
            if (r7 == 0) goto L_0x00bd
            java.lang.Object r7 = r0.next()
            java.util.Map$Entry r7 = (java.util.Map.Entry) r7
            java.lang.Object r8 = r7.getKey()
            boolean r9 = r8 instanceof java.lang.String
            if (r9 != 0) goto L_0x003f
            r8 = 0
        L_0x003f:
            java.lang.String r8 = (java.lang.String) r8
            if (r8 != 0) goto L_0x0045
            goto L_0x00b5
        L_0x0045:
            java.lang.Object r7 = r7.getValue()
            boolean r9 = r7 instanceof java.util.Map
            if (r9 == 0) goto L_0x0050
            java.util.Map r7 = (java.util.Map) r7
            goto L_0x0051
        L_0x0050:
            r7 = 0
        L_0x0051:
            if (r7 == 0) goto L_0x00b5
            java.util.Set r9 = r7.keySet()
            if (r9 == 0) goto L_0x00b5
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
            java.util.Iterator r9 = r9.iterator()
        L_0x0062:
            boolean r11 = r9.hasNext()
            if (r11 == 0) goto L_0x0074
            java.lang.Object r11 = r9.next()
            boolean r12 = r11 instanceof java.lang.Object
            if (r12 == 0) goto L_0x0062
            r10.add(r11)
            goto L_0x0062
        L_0x0074:
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            java.util.Iterator r10 = r10.iterator()
        L_0x007d:
            boolean r11 = r10.hasNext()
            if (r11 == 0) goto L_0x009f
            java.lang.Object r11 = r10.next()
            java.lang.Object r12 = r7.get(r11)
            boolean r13 = r12 instanceof java.lang.Object
            if (r13 == 0) goto L_0x0090
            goto L_0x0091
        L_0x0090:
            r12 = 0
        L_0x0091:
            if (r12 == 0) goto L_0x0098
            kotlin.Pair r11 = kotlin.l.a(r11, r12)
            goto L_0x0099
        L_0x0098:
            r11 = 0
        L_0x0099:
            if (r11 == 0) goto L_0x007d
            r9.add(r11)
            goto L_0x007d
        L_0x009f:
            boolean r7 = r9.isEmpty()
            r7 = r7 ^ r1
            if (r7 == 0) goto L_0x00a7
            goto L_0x00a8
        L_0x00a7:
            r9 = 0
        L_0x00a8:
            if (r9 == 0) goto L_0x00b5
            java.util.Map r7 = kotlin.collections.MapsKt__MapsKt.s(r9)
            if (r7 == 0) goto L_0x00b5
            kotlin.Pair r7 = kotlin.l.a(r8, r7)
            goto L_0x00b6
        L_0x00b5:
            r7 = 0
        L_0x00b6:
            if (r7 == 0) goto L_0x002a
            r6.add(r7)
            goto L_0x002a
        L_0x00bd:
            java.util.Map r0 = kotlin.collections.MapsKt__MapsKt.s(r6)
            goto L_0x00c3
        L_0x00c2:
            r0 = 0
        L_0x00c3:
            java.util.Map r6 = r22.z()
            java.util.Map r7 = r22.V()
            java.util.Map r8 = r22.P()
            java.util.Map r9 = r22.N()
            java.util.Map r10 = r22.T()
            if (r10 == 0) goto L_0x00de
            java.util.Map r10 = com.sumsub.sns.internal.core.common.i.c((java.util.Map<java.lang.String, ? extends java.lang.Object>) r10)
            goto L_0x00df
        L_0x00de:
            r10 = 0
        L_0x00df:
            java.util.Map r11 = r22.R()
            if (r11 == 0) goto L_0x025d
            java.util.ArrayList r12 = new java.util.ArrayList
            r12.<init>()
            java.util.Set r11 = r11.entrySet()
            java.util.Iterator r11 = r11.iterator()
        L_0x00f2:
            boolean r13 = r11.hasNext()
            if (r13 == 0) goto L_0x0196
            java.lang.Object r13 = r11.next()
            java.util.Map$Entry r13 = (java.util.Map.Entry) r13
            java.lang.Object r14 = r13.getKey()
            boolean r15 = r14 instanceof java.lang.String
            if (r15 != 0) goto L_0x0107
            r14 = 0
        L_0x0107:
            java.lang.String r14 = (java.lang.String) r14
            if (r14 != 0) goto L_0x010f
        L_0x010b:
            r18 = r11
            goto L_0x018b
        L_0x010f:
            java.lang.Object r13 = r13.getValue()
            boolean r15 = r13 instanceof java.util.Map
            if (r15 == 0) goto L_0x011a
            java.util.Map r13 = (java.util.Map) r13
            goto L_0x011b
        L_0x011a:
            r13 = 0
        L_0x011b:
            if (r13 == 0) goto L_0x010b
            java.util.Set r15 = r13.keySet()
            if (r15 == 0) goto L_0x010b
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            java.util.Iterator r15 = r15.iterator()
        L_0x012c:
            boolean r17 = r15.hasNext()
            if (r17 == 0) goto L_0x0143
            java.lang.Object r1 = r15.next()
            r18 = r11
            boolean r11 = r1 instanceof java.lang.Object
            if (r11 == 0) goto L_0x013f
            r5.add(r1)
        L_0x013f:
            r11 = r18
            r1 = 1
            goto L_0x012c
        L_0x0143:
            r18 = r11
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Iterator r5 = r5.iterator()
        L_0x014e:
            boolean r11 = r5.hasNext()
            if (r11 == 0) goto L_0x0174
            java.lang.Object r11 = r5.next()
            java.lang.Object r15 = r13.get(r11)
            r19 = r5
            boolean r5 = r15 instanceof java.lang.Object
            if (r5 == 0) goto L_0x0163
            goto L_0x0164
        L_0x0163:
            r15 = 0
        L_0x0164:
            if (r15 == 0) goto L_0x016b
            kotlin.Pair r5 = kotlin.l.a(r11, r15)
            goto L_0x016c
        L_0x016b:
            r5 = 0
        L_0x016c:
            if (r5 == 0) goto L_0x0171
            r1.add(r5)
        L_0x0171:
            r5 = r19
            goto L_0x014e
        L_0x0174:
            boolean r5 = r1.isEmpty()
            r11 = 1
            r5 = r5 ^ r11
            if (r5 == 0) goto L_0x017d
            goto L_0x017e
        L_0x017d:
            r1 = 0
        L_0x017e:
            if (r1 == 0) goto L_0x018b
            java.util.Map r1 = kotlin.collections.MapsKt__MapsKt.s(r1)
            if (r1 == 0) goto L_0x018b
            kotlin.Pair r1 = kotlin.l.a(r14, r1)
            goto L_0x018c
        L_0x018b:
            r1 = 0
        L_0x018c:
            if (r1 == 0) goto L_0x0191
            r12.add(r1)
        L_0x0191:
            r11 = r18
            r1 = 1
            goto L_0x00f2
        L_0x0196:
            java.util.Map r1 = kotlin.collections.MapsKt__MapsKt.s(r12)
            if (r1 == 0) goto L_0x025d
            java.lang.String r5 = "countryStates"
            java.lang.Object r1 = r1.get(r5)
            java.util.Map r1 = (java.util.Map) r1
            if (r1 == 0) goto L_0x025d
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            java.util.Set r1 = r1.entrySet()
            java.util.Iterator r1 = r1.iterator()
        L_0x01b3:
            boolean r11 = r1.hasNext()
            if (r11 == 0) goto L_0x0257
            java.lang.Object r11 = r1.next()
            java.util.Map$Entry r11 = (java.util.Map.Entry) r11
            java.lang.Object r12 = r11.getKey()
            boolean r13 = r12 instanceof java.lang.String
            if (r13 != 0) goto L_0x01c8
            r12 = 0
        L_0x01c8:
            java.lang.String r12 = (java.lang.String) r12
            if (r12 != 0) goto L_0x01d0
        L_0x01cc:
            r18 = r1
            goto L_0x024d
        L_0x01d0:
            java.lang.Object r11 = r11.getValue()
            boolean r13 = r11 instanceof java.util.Map
            if (r13 == 0) goto L_0x01db
            java.util.Map r11 = (java.util.Map) r11
            goto L_0x01dc
        L_0x01db:
            r11 = 0
        L_0x01dc:
            if (r11 == 0) goto L_0x01cc
            java.util.Set r13 = r11.keySet()
            if (r13 == 0) goto L_0x01cc
            java.util.ArrayList r14 = new java.util.ArrayList
            r14.<init>()
            java.util.Iterator r13 = r13.iterator()
        L_0x01ed:
            boolean r15 = r13.hasNext()
            if (r15 == 0) goto L_0x0203
            java.lang.Object r15 = r13.next()
            r18 = r1
            boolean r1 = r15 instanceof java.lang.String
            if (r1 == 0) goto L_0x0200
            r14.add(r15)
        L_0x0200:
            r1 = r18
            goto L_0x01ed
        L_0x0203:
            r18 = r1
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Iterator r13 = r14.iterator()
        L_0x020e:
            boolean r14 = r13.hasNext()
            if (r14 == 0) goto L_0x0236
            java.lang.Object r14 = r13.next()
            java.lang.Object r15 = r11.get(r14)
            r19 = r11
            boolean r11 = r15 instanceof java.lang.String
            if (r11 == 0) goto L_0x0223
            goto L_0x0224
        L_0x0223:
            r15 = 0
        L_0x0224:
            if (r15 == 0) goto L_0x022d
            java.lang.String r15 = (java.lang.String) r15
            kotlin.Pair r11 = kotlin.l.a(r14, r15)
            goto L_0x022e
        L_0x022d:
            r11 = 0
        L_0x022e:
            if (r11 == 0) goto L_0x0233
            r1.add(r11)
        L_0x0233:
            r11 = r19
            goto L_0x020e
        L_0x0236:
            boolean r11 = r1.isEmpty()
            r13 = 1
            r11 = r11 ^ r13
            if (r11 == 0) goto L_0x023f
            goto L_0x0240
        L_0x023f:
            r1 = 0
        L_0x0240:
            if (r1 == 0) goto L_0x024d
            java.util.Map r1 = kotlin.collections.MapsKt__MapsKt.s(r1)
            if (r1 == 0) goto L_0x024d
            kotlin.Pair r1 = kotlin.l.a(r12, r1)
            goto L_0x024e
        L_0x024d:
            r1 = 0
        L_0x024e:
            if (r1 == 0) goto L_0x0253
            r5.add(r1)
        L_0x0253:
            r1 = r18
            goto L_0x01b3
        L_0x0257:
            java.util.Map r1 = kotlin.collections.MapsKt__MapsKt.s(r5)
            r11 = r1
            goto L_0x025e
        L_0x025d:
            r11 = 0
        L_0x025e:
            com.sumsub.sns.internal.core.data.model.remote.a r1 = r22.B()
            if (r1 == 0) goto L_0x026a
            java.util.Map r1 = com.sumsub.sns.internal.core.data.model.f.a((com.sumsub.sns.internal.core.data.model.remote.a) r1)
            r12 = r1
            goto L_0x026b
        L_0x026a:
            r12 = 0
        L_0x026b:
            java.util.Map r1 = r22.R()
            if (r1 == 0) goto L_0x0401
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            java.util.Set r1 = r1.entrySet()
            java.util.Iterator r1 = r1.iterator()
        L_0x027e:
            boolean r13 = r1.hasNext()
            if (r13 == 0) goto L_0x032e
            java.lang.Object r13 = r1.next()
            java.util.Map$Entry r13 = (java.util.Map.Entry) r13
            java.lang.Object r14 = r13.getKey()
            boolean r15 = r14 instanceof java.lang.String
            if (r15 != 0) goto L_0x0293
            r14 = 0
        L_0x0293:
            java.lang.String r14 = (java.lang.String) r14
            if (r14 != 0) goto L_0x029d
        L_0x0297:
            r18 = r1
            r19 = r12
            goto L_0x0322
        L_0x029d:
            java.lang.Object r13 = r13.getValue()
            boolean r15 = r13 instanceof java.util.Map
            if (r15 == 0) goto L_0x02a8
            java.util.Map r13 = (java.util.Map) r13
            goto L_0x02a9
        L_0x02a8:
            r13 = 0
        L_0x02a9:
            if (r13 == 0) goto L_0x0297
            java.util.Set r15 = r13.keySet()
            if (r15 == 0) goto L_0x0297
            r18 = r1
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Iterator r15 = r15.iterator()
        L_0x02bc:
            boolean r19 = r15.hasNext()
            if (r19 == 0) goto L_0x02d6
            r19 = r12
            java.lang.Object r12 = r15.next()
            r20 = r15
            boolean r15 = r12 instanceof java.lang.Object
            if (r15 == 0) goto L_0x02d1
            r1.add(r12)
        L_0x02d1:
            r12 = r19
            r15 = r20
            goto L_0x02bc
        L_0x02d6:
            r19 = r12
            java.util.ArrayList r12 = new java.util.ArrayList
            r12.<init>()
            java.util.Iterator r1 = r1.iterator()
        L_0x02e1:
            boolean r15 = r1.hasNext()
            if (r15 == 0) goto L_0x030b
            java.lang.Object r15 = r1.next()
            r20 = r1
            java.lang.Object r1 = r13.get(r15)
            r21 = r13
            boolean r13 = r1 instanceof java.lang.Object
            if (r13 == 0) goto L_0x02f8
            goto L_0x02f9
        L_0x02f8:
            r1 = 0
        L_0x02f9:
            if (r1 == 0) goto L_0x0300
            kotlin.Pair r1 = kotlin.l.a(r15, r1)
            goto L_0x0301
        L_0x0300:
            r1 = 0
        L_0x0301:
            if (r1 == 0) goto L_0x0306
            r12.add(r1)
        L_0x0306:
            r1 = r20
            r13 = r21
            goto L_0x02e1
        L_0x030b:
            boolean r1 = r12.isEmpty()
            r13 = 1
            r1 = r1 ^ r13
            if (r1 == 0) goto L_0x0314
            goto L_0x0315
        L_0x0314:
            r12 = 0
        L_0x0315:
            if (r12 == 0) goto L_0x0322
            java.util.Map r1 = kotlin.collections.MapsKt__MapsKt.s(r12)
            if (r1 == 0) goto L_0x0322
            kotlin.Pair r1 = kotlin.l.a(r14, r1)
            goto L_0x0323
        L_0x0322:
            r1 = 0
        L_0x0323:
            if (r1 == 0) goto L_0x0328
            r5.add(r1)
        L_0x0328:
            r1 = r18
            r12 = r19
            goto L_0x027e
        L_0x032e:
            r19 = r12
            java.util.Map r1 = kotlin.collections.MapsKt__MapsKt.s(r5)
            if (r1 == 0) goto L_0x0403
            java.lang.String r5 = "countryDependingFields"
            java.lang.Object r1 = r1.get(r5)
            java.util.Map r1 = (java.util.Map) r1
            if (r1 == 0) goto L_0x0403
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            java.util.Set r1 = r1.entrySet()
            java.util.Iterator r1 = r1.iterator()
        L_0x034d:
            boolean r12 = r1.hasNext()
            if (r12 == 0) goto L_0x03fa
            java.lang.Object r12 = r1.next()
            java.util.Map$Entry r12 = (java.util.Map.Entry) r12
            java.lang.Object r13 = r12.getKey()
            boolean r14 = r13 instanceof java.lang.String
            if (r14 != 0) goto L_0x0362
            r13 = 0
        L_0x0362:
            java.lang.String r13 = (java.lang.String) r13
            if (r13 != 0) goto L_0x036b
        L_0x0366:
            r18 = r1
            r14 = 1
            goto L_0x03f0
        L_0x036b:
            java.lang.Object r12 = r12.getValue()
            boolean r14 = r12 instanceof java.util.Map
            if (r14 == 0) goto L_0x0376
            java.util.Map r12 = (java.util.Map) r12
            goto L_0x0377
        L_0x0376:
            r12 = 0
        L_0x0377:
            if (r12 == 0) goto L_0x0366
            java.util.Set r14 = r12.keySet()
            if (r14 == 0) goto L_0x0366
            java.util.ArrayList r15 = new java.util.ArrayList
            r15.<init>()
            java.util.Iterator r14 = r14.iterator()
        L_0x0388:
            boolean r18 = r14.hasNext()
            if (r18 == 0) goto L_0x03a2
            r18 = r1
            java.lang.Object r1 = r14.next()
            r20 = r14
            boolean r14 = r1 instanceof java.lang.String
            if (r14 == 0) goto L_0x039d
            r15.add(r1)
        L_0x039d:
            r1 = r18
            r14 = r20
            goto L_0x0388
        L_0x03a2:
            r18 = r1
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Iterator r14 = r15.iterator()
        L_0x03ad:
            boolean r15 = r14.hasNext()
            if (r15 == 0) goto L_0x03d9
            java.lang.Object r15 = r14.next()
            r20 = r14
            java.lang.Object r14 = r12.get(r15)
            r21 = r12
            boolean r12 = r14 instanceof java.lang.String
            if (r12 == 0) goto L_0x03c4
            goto L_0x03c5
        L_0x03c4:
            r14 = 0
        L_0x03c5:
            if (r14 == 0) goto L_0x03ce
            java.lang.String r14 = (java.lang.String) r14
            kotlin.Pair r12 = kotlin.l.a(r15, r14)
            goto L_0x03cf
        L_0x03ce:
            r12 = 0
        L_0x03cf:
            if (r12 == 0) goto L_0x03d4
            r1.add(r12)
        L_0x03d4:
            r14 = r20
            r12 = r21
            goto L_0x03ad
        L_0x03d9:
            boolean r12 = r1.isEmpty()
            r14 = 1
            r12 = r12 ^ r14
            if (r12 == 0) goto L_0x03e2
            goto L_0x03e3
        L_0x03e2:
            r1 = 0
        L_0x03e3:
            if (r1 == 0) goto L_0x03f0
            java.util.Map r1 = kotlin.collections.MapsKt__MapsKt.s(r1)
            if (r1 == 0) goto L_0x03f0
            kotlin.Pair r1 = kotlin.l.a(r13, r1)
            goto L_0x03f1
        L_0x03f0:
            r1 = 0
        L_0x03f1:
            if (r1 == 0) goto L_0x03f6
            r5.add(r1)
        L_0x03f6:
            r1 = r18
            goto L_0x034d
        L_0x03fa:
            r14 = 1
            java.util.Map r1 = kotlin.collections.MapsKt__MapsKt.s(r5)
            r13 = r1
            goto L_0x0405
        L_0x0401:
            r19 = r12
        L_0x0403:
            r14 = 1
            r13 = 0
        L_0x0405:
            com.sumsub.sns.internal.core.data.model.w$a r1 = com.sumsub.sns.internal.core.data.model.w.f32937c
            java.util.Map r5 = r22.R()
            java.util.Map r15 = r1.b(r5)
            java.lang.String r17 = r22.X()
            java.lang.String r18 = r22.r()
            com.sumsub.sns.internal.core.data.model.e$a r1 = new com.sumsub.sns.internal.core.data.model.e$a
            java.lang.String r5 = r22.t()
            java.lang.String r12 = ""
            if (r5 != 0) goto L_0x0422
            r5 = r12
        L_0x0422:
            com.sumsub.sns.core.data.model.FlowActionType r20 = r22.v()
            if (r20 != 0) goto L_0x042e
            com.sumsub.sns.core.data.model.FlowActionType$Companion r14 = com.sumsub.sns.core.data.model.FlowActionType.Companion
            com.sumsub.sns.core.data.model.FlowActionType r20 = r14.get(r12)
        L_0x042e:
            r12 = r20
            r1.<init>(r5, r12)
            java.lang.String r5 = r22.t()
            if (r5 == 0) goto L_0x043b
            r5 = 1
            goto L_0x043c
        L_0x043b:
            r5 = 0
        L_0x043c:
            if (r5 == 0) goto L_0x0441
            r20 = r1
            goto L_0x0443
        L_0x0441:
            r20 = 0
        L_0x0443:
            com.sumsub.sns.internal.core.data.model.e r21 = new com.sumsub.sns.internal.core.data.model.e
            r1 = r21
            r5 = r0
            r12 = r19
            r14 = r15
            r15 = r17
            r16 = r18
            r17 = r20
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
            return r21
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.data.model.remote.j.a(com.sumsub.sns.internal.core.data.model.remote.i):com.sumsub.sns.internal.core.data.model.e");
    }
}
