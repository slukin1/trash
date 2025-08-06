package com.sumsub.sns.internal.core.domain;

import com.sumsub.sns.internal.core.data.source.dynamic.b;
import kotlin.Result;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public final com.sumsub.sns.internal.core.data.source.common.a f33574a;

    /* renamed from: b  reason: collision with root package name */
    public final b f33575b;

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.core.domain.CountriesUseCase", f = "CountriesUseCase.kt", l = {26, 41, 42, 52}, m = "invoke-gIAlu-s")
    public static final class a extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f33576a;

        /* renamed from: b  reason: collision with root package name */
        public Object f33577b;

        /* renamed from: c  reason: collision with root package name */
        public Object f33578c;

        /* renamed from: d  reason: collision with root package name */
        public Object f33579d;

        /* renamed from: e  reason: collision with root package name */
        public Object f33580e;

        /* renamed from: f  reason: collision with root package name */
        public Object f33581f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f33582g;

        /* renamed from: h  reason: collision with root package name */
        public /* synthetic */ Object f33583h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ d f33584i;

        /* renamed from: j  reason: collision with root package name */
        public int f33585j;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(d dVar, c<? super a> cVar) {
            super(cVar);
            this.f33584i = dVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f33583h = obj;
            this.f33585j |= Integer.MIN_VALUE;
            Object a11 = this.f33584i.a(false, this);
            return a11 == IntrinsicsKt__IntrinsicsKt.d() ? a11 : Result.m3071boximpl(a11);
        }
    }

    public d(com.sumsub.sns.internal.core.data.source.common.a aVar, b bVar) {
        this.f33574a = aVar;
        this.f33575b = bVar;
    }

    public final com.sumsub.sns.internal.core.data.source.common.a a() {
        return this.f33574a;
    }

    public final b b() {
        return this.f33575b;
    }

    /* JADX WARNING: Removed duplicated region for block: B:108:0x0242 A[Catch:{ Exception -> 0x02ec }] */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x0276 A[Catch:{ Exception -> 0x02ec }] */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x0289 A[Catch:{ Exception -> 0x02ec }] */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x0296 A[Catch:{ Exception -> 0x02ec }] */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x0298 A[Catch:{ Exception -> 0x02ec }] */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x029b A[Catch:{ Exception -> 0x02ec }] */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x02d5 A[Catch:{ Exception -> 0x02ec }] */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x0130 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x0245 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00bc A[SYNTHETIC, Splitter:B:37:0x00bc] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00e7 A[Catch:{ Exception -> 0x02ec }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0125 A[Catch:{ Exception -> 0x02ec }] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0136 A[Catch:{ Exception -> 0x02ec }] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0139 A[Catch:{ Exception -> 0x02ec }] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x013e A[Catch:{ Exception -> 0x02ec }] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0141 A[Catch:{ Exception -> 0x02ec }] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0146 A[Catch:{ Exception -> 0x02ec }] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0184 A[Catch:{ Exception -> 0x02ec }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0185 A[Catch:{ Exception -> 0x02ec }] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0197 A[Catch:{ Exception -> 0x02ec }] */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x019c A[Catch:{ Exception -> 0x02ec }] */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x019f A[Catch:{ Exception -> 0x02ec }] */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x01b8 A[Catch:{ Exception -> 0x02ec }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(boolean r27, kotlin.coroutines.c<? super kotlin.Result<com.sumsub.sns.internal.core.domain.e>> r28) {
        /*
            r26 = this;
            r1 = r26
            r0 = r28
            boolean r2 = r0 instanceof com.sumsub.sns.internal.core.domain.d.a
            if (r2 == 0) goto L_0x0017
            r2 = r0
            com.sumsub.sns.internal.core.domain.d$a r2 = (com.sumsub.sns.internal.core.domain.d.a) r2
            int r3 = r2.f33585j
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L_0x0017
            int r3 = r3 - r4
            r2.f33585j = r3
            goto L_0x001c
        L_0x0017:
            com.sumsub.sns.internal.core.domain.d$a r2 = new com.sumsub.sns.internal.core.domain.d$a
            r2.<init>(r1, r0)
        L_0x001c:
            java.lang.Object r0 = r2.f33583h
            java.lang.Object r9 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r3 = r2.f33585j
            r10 = 4
            r11 = 3
            r4 = 2
            r12 = 0
            r13 = 1
            r14 = 0
            if (r3 == 0) goto L_0x0097
            if (r3 == r13) goto L_0x0087
            if (r3 == r4) goto L_0x0070
            if (r3 == r11) goto L_0x0059
            if (r3 != r10) goto L_0x0051
            java.lang.Object r3 = r2.f33581f
            java.util.Map r3 = (java.util.Map) r3
            java.lang.Object r4 = r2.f33580e
            java.util.Map r4 = (java.util.Map) r4
            java.lang.Object r5 = r2.f33579d
            java.util.Map r5 = (java.util.Map) r5
            java.lang.Object r6 = r2.f33578c
            java.util.Map r6 = (java.util.Map) r6
            java.lang.Object r7 = r2.f33577b
            java.util.Map r7 = (java.util.Map) r7
            java.lang.Object r2 = r2.f33576a
            java.lang.String r2 = (java.lang.String) r2
            kotlin.k.b(r0)     // Catch:{ Exception -> 0x02ec }
            goto L_0x02c2
        L_0x0051:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x0059:
            boolean r3 = r2.f33582g
            java.lang.Object r4 = r2.f33579d
            java.util.Map r4 = (java.util.Map) r4
            java.lang.Object r5 = r2.f33578c
            java.util.Map r5 = (java.util.Map) r5
            java.lang.Object r6 = r2.f33577b
            com.sumsub.sns.internal.core.data.model.e r6 = (com.sumsub.sns.internal.core.data.model.e) r6
            java.lang.Object r7 = r2.f33576a
            com.sumsub.sns.internal.core.domain.d r7 = (com.sumsub.sns.internal.core.domain.d) r7
            kotlin.k.b(r0)     // Catch:{ Exception -> 0x02ec }
            goto L_0x01b4
        L_0x0070:
            boolean r3 = r2.f33582g
            java.lang.Object r4 = r2.f33579d
            java.util.Map r4 = (java.util.Map) r4
            java.lang.Object r5 = r2.f33578c
            java.util.Map r5 = (java.util.Map) r5
            java.lang.Object r6 = r2.f33577b
            com.sumsub.sns.internal.core.data.model.e r6 = (com.sumsub.sns.internal.core.data.model.e) r6
            java.lang.Object r7 = r2.f33576a
            com.sumsub.sns.internal.core.domain.d r7 = (com.sumsub.sns.internal.core.domain.d) r7
            kotlin.k.b(r0)     // Catch:{ Exception -> 0x02ec }
            goto L_0x018f
        L_0x0087:
            boolean r3 = r2.f33582g
            java.lang.Object r5 = r2.f33576a
            com.sumsub.sns.internal.core.domain.d r5 = (com.sumsub.sns.internal.core.domain.d) r5
            kotlin.k.b(r0)     // Catch:{ Exception -> 0x02ec }
            r15 = r5
        L_0x0091:
            r25 = r3
            r3 = r0
            r0 = r25
            goto L_0x00ad
        L_0x0097:
            kotlin.k.b(r0)
            com.sumsub.sns.internal.core.data.source.dynamic.b r0 = r1.f33575b     // Catch:{ Exception -> 0x02ec }
            r2.f33576a = r1     // Catch:{ Exception -> 0x02ec }
            r3 = r27
            r2.f33582g = r3     // Catch:{ Exception -> 0x02ec }
            r2.f33585j = r13     // Catch:{ Exception -> 0x02ec }
            java.lang.Object r0 = com.sumsub.sns.internal.core.data.source.dynamic.h.b(r0, r12, r2, r13, r14)     // Catch:{ Exception -> 0x02ec }
            if (r0 != r9) goto L_0x00ab
            return r9
        L_0x00ab:
            r15 = r1
            goto L_0x0091
        L_0x00ad:
            r8 = r3
            com.sumsub.sns.internal.core.data.model.e r8 = (com.sumsub.sns.internal.core.data.model.e) r8     // Catch:{ Exception -> 0x02ec }
            java.util.Map r3 = r8.v()     // Catch:{ Exception -> 0x02ec }
            java.util.Map r7 = com.sumsub.sns.internal.core.data.model.f.a((com.sumsub.sns.internal.core.data.model.e) r8)     // Catch:{ Exception -> 0x02ec }
            java.lang.String r5 = "filtered out "
            if (r7 == 0) goto L_0x0136
            java.util.LinkedHashMap r6 = new java.util.LinkedHashMap     // Catch:{ Exception -> 0x02ec }
            r6.<init>()     // Catch:{ Exception -> 0x02ec }
            java.util.Set r16 = r7.entrySet()     // Catch:{ Exception -> 0x02ec }
            java.util.Iterator r16 = r16.iterator()     // Catch:{ Exception -> 0x02ec }
        L_0x00c9:
            boolean r17 = r16.hasNext()     // Catch:{ Exception -> 0x02ec }
            if (r17 == 0) goto L_0x0134
            java.lang.Object r17 = r16.next()     // Catch:{ Exception -> 0x02ec }
            java.util.Map$Entry r17 = (java.util.Map.Entry) r17     // Catch:{ Exception -> 0x02ec }
            if (r0 == 0) goto L_0x00f4
            if (r3 == 0) goto L_0x00e3
            boolean r18 = r3.isEmpty()     // Catch:{ Exception -> 0x02ec }
            if (r18 == 0) goto L_0x00e0
            goto L_0x00e3
        L_0x00e0:
            r18 = r12
            goto L_0x00e5
        L_0x00e3:
            r18 = r13
        L_0x00e5:
            if (r18 != 0) goto L_0x00f4
            java.lang.Object r14 = r17.getKey()     // Catch:{ Exception -> 0x02ec }
            boolean r14 = r3.containsKey(r14)     // Catch:{ Exception -> 0x02ec }
            if (r14 == 0) goto L_0x00f2
            goto L_0x00f4
        L_0x00f2:
            r14 = r12
            goto L_0x00f5
        L_0x00f4:
            r14 = r13
        L_0x00f5:
            com.sumsub.sns.internal.core.common.e0 r18 = com.sumsub.sns.internal.core.common.e0.f32018a     // Catch:{ Exception -> 0x02ec }
            boolean r18 = r18.isDebug()     // Catch:{ Exception -> 0x02ec }
            if (r18 == 0) goto L_0x0123
            if (r14 != 0) goto L_0x0123
            com.sumsub.sns.internal.log.a r19 = com.sumsub.sns.internal.log.a.f34862a     // Catch:{ Exception -> 0x02ec }
            java.lang.String r20 = "CountriesUseCase"
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02ec }
            r10.<init>()     // Catch:{ Exception -> 0x02ec }
            r10.append(r5)     // Catch:{ Exception -> 0x02ec }
            java.lang.Object r21 = r17.getValue()     // Catch:{ Exception -> 0x02ec }
            r12 = r21
            java.lang.String r12 = (java.lang.String) r12     // Catch:{ Exception -> 0x02ec }
            r10.append(r12)     // Catch:{ Exception -> 0x02ec }
            java.lang.String r21 = r10.toString()     // Catch:{ Exception -> 0x02ec }
            r22 = 0
            r23 = 4
            r24 = 0
            com.sumsub.log.logger.a.d(r19, r20, r21, r22, r23, r24)     // Catch:{ Exception -> 0x02ec }
        L_0x0123:
            if (r14 == 0) goto L_0x0130
            java.lang.Object r10 = r17.getKey()     // Catch:{ Exception -> 0x02ec }
            java.lang.Object r12 = r17.getValue()     // Catch:{ Exception -> 0x02ec }
            r6.put(r10, r12)     // Catch:{ Exception -> 0x02ec }
        L_0x0130:
            r10 = 4
            r12 = 0
            r14 = 0
            goto L_0x00c9
        L_0x0134:
            r10 = r6
            goto L_0x0137
        L_0x0136:
            r10 = 0
        L_0x0137:
            if (r7 == 0) goto L_0x013e
            int r3 = r7.size()     // Catch:{ Exception -> 0x02ec }
            goto L_0x013f
        L_0x013e:
            r3 = 0
        L_0x013f:
            if (r10 == 0) goto L_0x0146
            int r6 = r10.size()     // Catch:{ Exception -> 0x02ec }
            goto L_0x0147
        L_0x0146:
            r6 = 0
        L_0x0147:
            com.sumsub.sns.internal.log.a r19 = com.sumsub.sns.internal.log.a.f34862a     // Catch:{ Exception -> 0x02ec }
            java.lang.String r20 = "CountriesUseCase"
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02ec }
            r12.<init>()     // Catch:{ Exception -> 0x02ec }
            r12.append(r5)     // Catch:{ Exception -> 0x02ec }
            int r3 = r3 - r6
            r12.append(r3)     // Catch:{ Exception -> 0x02ec }
            java.lang.String r21 = r12.toString()     // Catch:{ Exception -> 0x02ec }
            r22 = 0
            r23 = 4
            r24 = 0
            com.sumsub.log.logger.a.d(r19, r20, r21, r22, r23, r24)     // Catch:{ Exception -> 0x02ec }
            com.sumsub.sns.internal.core.data.source.dynamic.b r3 = r15.f33575b     // Catch:{ Exception -> 0x02ec }
            r5 = 0
            r6 = 0
            r12 = 3
            r14 = 0
            r2.f33576a = r15     // Catch:{ Exception -> 0x02ec }
            r2.f33577b = r8     // Catch:{ Exception -> 0x02ec }
            r2.f33578c = r7     // Catch:{ Exception -> 0x02ec }
            r2.f33579d = r10     // Catch:{ Exception -> 0x02ec }
            r2.f33582g = r0     // Catch:{ Exception -> 0x02ec }
            r2.f33585j = r4     // Catch:{ Exception -> 0x02ec }
            r4 = r5
            r5 = r6
            r6 = r2
            r16 = r7
            r7 = r12
            r12 = r8
            r8 = r14
            java.lang.Object r3 = com.sumsub.sns.internal.core.data.source.dynamic.h.e(r3, r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x02ec }
            if (r3 != r9) goto L_0x0185
            return r9
        L_0x0185:
            r4 = r10
            r6 = r12
            r7 = r15
            r5 = r16
            r25 = r3
            r3 = r0
            r0 = r25
        L_0x018f:
            com.sumsub.sns.internal.core.data.model.g r0 = (com.sumsub.sns.internal.core.data.model.g) r0     // Catch:{ Exception -> 0x02ec }
            com.sumsub.sns.internal.core.data.model.g$a r0 = r0.C()     // Catch:{ Exception -> 0x02ec }
            if (r0 == 0) goto L_0x019c
            java.lang.String r0 = r0.o()     // Catch:{ Exception -> 0x02ec }
            goto L_0x019d
        L_0x019c:
            r0 = 0
        L_0x019d:
            if (r0 != 0) goto L_0x026c
            com.sumsub.sns.internal.core.data.source.common.a r0 = r7.f33574a     // Catch:{ Exception -> 0x02ec }
            r2.f33576a = r7     // Catch:{ Exception -> 0x02ec }
            r2.f33577b = r6     // Catch:{ Exception -> 0x02ec }
            r2.f33578c = r5     // Catch:{ Exception -> 0x02ec }
            r2.f33579d = r4     // Catch:{ Exception -> 0x02ec }
            r2.f33582g = r3     // Catch:{ Exception -> 0x02ec }
            r2.f33585j = r11     // Catch:{ Exception -> 0x02ec }
            java.lang.Object r0 = r0.a((kotlin.coroutines.c<? super java.util.Map<java.lang.String, ? extends java.lang.Object>>) r2)     // Catch:{ Exception -> 0x02ec }
            if (r0 != r9) goto L_0x01b4
            return r9
        L_0x01b4:
            java.util.Map r0 = (java.util.Map) r0     // Catch:{ Exception -> 0x02ec }
            if (r0 == 0) goto L_0x0268
            java.lang.String r19 = "geoIpCountry"
            r8 = 47
            char[] r10 = new char[r13]     // Catch:{ Exception -> 0x02ec }
            char r8 = (char) r8     // Catch:{ Exception -> 0x02ec }
            r11 = 0
            r10[r11] = r8     // Catch:{ Exception -> 0x02ec }
            r21 = 0
            r22 = 0
            r23 = 6
            r24 = 0
            r20 = r10
            java.util.List r8 = kotlin.text.StringsKt__StringsKt.K0(r19, r20, r21, r22, r23, r24)     // Catch:{ Exception -> 0x02ec }
            kotlin.jvm.internal.Ref$ObjectRef r10 = new kotlin.jvm.internal.Ref$ObjectRef     // Catch:{ Exception -> 0x02ec }
            r10.<init>()     // Catch:{ Exception -> 0x02ec }
            r10.element = r0     // Catch:{ Exception -> 0x02ec }
            int r0 = r8.size()     // Catch:{ Exception -> 0x02ec }
            int r0 = r0 - r13
            r11 = 0
            kotlin.ranges.h r0 = kotlin.ranges.RangesKt___RangesKt.o(r11, r0)     // Catch:{ Exception -> 0x02ec }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ Exception -> 0x02ec }
        L_0x01e5:
            boolean r12 = r0.hasNext()     // Catch:{ Exception -> 0x02ec }
            if (r12 == 0) goto L_0x0254
            r12 = r0
            kotlin.collections.IntIterator r12 = (kotlin.collections.IntIterator) r12     // Catch:{ Exception -> 0x02ec }
            int r12 = r12.a()     // Catch:{ Exception -> 0x02ec }
            T r14 = r10.element     // Catch:{ Exception -> 0x02ec }
            java.util.Map r14 = (java.util.Map) r14     // Catch:{ Exception -> 0x02ec }
            java.lang.Object r12 = r8.get(r12)     // Catch:{ Exception -> 0x02ec }
            java.lang.Object r12 = r14.get(r12)     // Catch:{ Exception -> 0x02ec }
            boolean r14 = r12 instanceof java.util.Map     // Catch:{ Exception -> 0x02ec }
            if (r14 == 0) goto L_0x0205
            java.util.Map r12 = (java.util.Map) r12     // Catch:{ Exception -> 0x02ec }
            goto L_0x0206
        L_0x0205:
            r12 = 0
        L_0x0206:
            if (r12 == 0) goto L_0x0268
            java.util.ArrayList r14 = new java.util.ArrayList     // Catch:{ Exception -> 0x02ec }
            r14.<init>()     // Catch:{ Exception -> 0x02ec }
            java.util.Set r12 = r12.entrySet()     // Catch:{ Exception -> 0x02ec }
            java.util.Iterator r12 = r12.iterator()     // Catch:{ Exception -> 0x02ec }
        L_0x0215:
            boolean r15 = r12.hasNext()     // Catch:{ Exception -> 0x02ec }
            if (r15 == 0) goto L_0x0248
            java.lang.Object r15 = r12.next()     // Catch:{ Exception -> 0x02ec }
            java.util.Map$Entry r15 = (java.util.Map.Entry) r15     // Catch:{ Exception -> 0x02ec }
            java.lang.Object r11 = r15.getKey()     // Catch:{ Exception -> 0x02ec }
            boolean r13 = r11 instanceof java.lang.String     // Catch:{ Exception -> 0x02ec }
            if (r13 != 0) goto L_0x022a
            r11 = 0
        L_0x022a:
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ Exception -> 0x02ec }
            if (r11 != 0) goto L_0x022f
            goto L_0x023a
        L_0x022f:
            java.lang.Object r13 = r15.getValue()     // Catch:{ Exception -> 0x02ec }
            boolean r15 = r13 instanceof java.lang.Object     // Catch:{ Exception -> 0x02ec }
            if (r15 != 0) goto L_0x0238
            r13 = 0
        L_0x0238:
            if (r13 != 0) goto L_0x023c
        L_0x023a:
            r11 = 0
            goto L_0x0240
        L_0x023c:
            kotlin.Pair r11 = kotlin.l.a(r11, r13)     // Catch:{ Exception -> 0x02ec }
        L_0x0240:
            if (r11 == 0) goto L_0x0245
            r14.add(r11)     // Catch:{ Exception -> 0x02ec }
        L_0x0245:
            r11 = 0
            r13 = 1
            goto L_0x0215
        L_0x0248:
            java.util.Map r11 = kotlin.collections.MapsKt__MapsKt.s(r14)     // Catch:{ Exception -> 0x02ec }
            if (r11 != 0) goto L_0x024f
            goto L_0x0268
        L_0x024f:
            r10.element = r11     // Catch:{ Exception -> 0x02ec }
            r11 = 0
            r13 = 1
            goto L_0x01e5
        L_0x0254:
            T r0 = r10.element     // Catch:{ Exception -> 0x02ec }
            java.util.Map r0 = (java.util.Map) r0     // Catch:{ Exception -> 0x02ec }
            java.lang.Object r8 = kotlin.collections.CollectionsKt___CollectionsKt.n0(r8)     // Catch:{ Exception -> 0x02ec }
            java.lang.Object r0 = r0.get(r8)     // Catch:{ Exception -> 0x02ec }
            boolean r8 = r0 instanceof java.lang.String     // Catch:{ Exception -> 0x02ec }
            if (r8 != 0) goto L_0x0265
            r0 = 0
        L_0x0265:
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ Exception -> 0x02ec }
            goto L_0x026c
        L_0x0268:
            r11 = r4
            r10 = r5
            r0 = 0
            goto L_0x026e
        L_0x026c:
            r11 = r4
            r10 = r5
        L_0x026e:
            com.sumsub.sns.internal.core.data.source.common.a r4 = r7.f33574a     // Catch:{ Exception -> 0x02ec }
            java.lang.String r4 = r4.a()     // Catch:{ Exception -> 0x02ec }
            if (r4 != 0) goto L_0x0289
            if (r0 == 0) goto L_0x0287
            if (r11 == 0) goto L_0x0283
            boolean r4 = r11.containsKey(r0)     // Catch:{ Exception -> 0x02ec }
            r5 = 1
            if (r4 != r5) goto L_0x0283
            r12 = r5
            goto L_0x0284
        L_0x0283:
            r12 = 0
        L_0x0284:
            if (r12 == 0) goto L_0x0287
            goto L_0x028a
        L_0x0287:
            r0 = 0
            goto L_0x028a
        L_0x0289:
            r0 = r4
        L_0x028a:
            kotlin.Result$a r4 = kotlin.Result.Companion     // Catch:{ Exception -> 0x02ec }
            java.util.Map r12 = com.sumsub.sns.internal.core.data.model.f.a((com.sumsub.sns.internal.core.data.model.e) r6)     // Catch:{ Exception -> 0x02ec }
            java.util.Map r13 = com.sumsub.sns.internal.core.data.model.f.o(r6)     // Catch:{ Exception -> 0x02ec }
            if (r3 == 0) goto L_0x0298
            r14 = r10
            goto L_0x0299
        L_0x0298:
            r14 = 0
        L_0x0299:
            if (r10 == 0) goto L_0x02d5
            com.sumsub.sns.internal.core.data.source.dynamic.b r3 = r7.f33575b     // Catch:{ Exception -> 0x02ec }
            r4 = 0
            r5 = 0
            r7 = 3
            r8 = 0
            r2.f33576a = r0     // Catch:{ Exception -> 0x02ec }
            r2.f33577b = r12     // Catch:{ Exception -> 0x02ec }
            r2.f33578c = r13     // Catch:{ Exception -> 0x02ec }
            r2.f33579d = r11     // Catch:{ Exception -> 0x02ec }
            r2.f33580e = r14     // Catch:{ Exception -> 0x02ec }
            r2.f33581f = r10     // Catch:{ Exception -> 0x02ec }
            r6 = 4
            r2.f33585j = r6     // Catch:{ Exception -> 0x02ec }
            r6 = r2
            java.lang.Object r2 = com.sumsub.sns.internal.core.data.source.dynamic.h.e(r3, r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x02ec }
            if (r2 != r9) goto L_0x02b8
            return r9
        L_0x02b8:
            r3 = r10
            r5 = r11
            r7 = r12
            r6 = r13
            r4 = r14
            r25 = r2
            r2 = r0
            r0 = r25
        L_0x02c2:
            com.sumsub.sns.internal.core.data.model.g r0 = (com.sumsub.sns.internal.core.data.model.g) r0     // Catch:{ Exception -> 0x02ec }
            java.util.Map r14 = com.sumsub.sns.internal.core.data.model.f.a((java.util.Map<java.lang.String, java.lang.String>) r3, (com.sumsub.sns.internal.core.data.model.g) r0)     // Catch:{ Exception -> 0x02ec }
            r21 = r2
            r19 = r4
            r18 = r5
            r17 = r6
            r16 = r7
            r20 = r14
            goto L_0x02e1
        L_0x02d5:
            r21 = r0
            r18 = r11
            r16 = r12
            r17 = r13
            r19 = r14
            r20 = 0
        L_0x02e1:
            com.sumsub.sns.internal.core.domain.e r0 = new com.sumsub.sns.internal.core.domain.e     // Catch:{ Exception -> 0x02ec }
            r15 = r0
            r15.<init>(r16, r17, r18, r19, r20, r21)     // Catch:{ Exception -> 0x02ec }
            java.lang.Object r0 = kotlin.Result.m3072constructorimpl(r0)     // Catch:{ Exception -> 0x02ec }
            return r0
        L_0x02ec:
            r0 = move-exception
            kotlin.Result$a r2 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.k.a(r0)
            java.lang.Object r0 = kotlin.Result.m3072constructorimpl(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.domain.d.a(boolean, kotlin.coroutines.c):java.lang.Object");
    }
}
