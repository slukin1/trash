package com.sumsub.sns.internal.geo.domain;

import com.sumsub.sns.internal.core.data.source.applicant.e;
import kotlin.Result;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.d;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public final e f34684a;

    /* renamed from: b  reason: collision with root package name */
    public final com.sumsub.sns.internal.core.data.source.common.a f34685b;

    /* renamed from: c  reason: collision with root package name */
    public final com.sumsub.sns.internal.core.data.source.dynamic.b f34686c;

    /* renamed from: d  reason: collision with root package name */
    public final kotlinx.serialization.json.a f34687d;

    @d(c = "com.sumsub.sns.internal.geo.domain.GetLocationUseCase", f = "GetLocationUseCase.kt", l = {65, 67}, m = "clearImagesIfNeeded")
    public static final class a extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f34688a;

        /* renamed from: b  reason: collision with root package name */
        public Object f34689b;

        /* renamed from: c  reason: collision with root package name */
        public Object f34690c;

        /* renamed from: d  reason: collision with root package name */
        public /* synthetic */ Object f34691d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f34692e;

        /* renamed from: f  reason: collision with root package name */
        public int f34693f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(b bVar, c<? super a> cVar) {
            super(cVar);
            this.f34692e = bVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f34691d = obj;
            this.f34693f |= Integer.MIN_VALUE;
            return this.f34692e.a((String) null, (String) null, this);
        }
    }

    @d(c = "com.sumsub.sns.internal.geo.domain.GetLocationUseCase", f = "GetLocationUseCase.kt", l = {31, 47, 49}, m = "invoke-yxL6bBk")
    /* renamed from: com.sumsub.sns.internal.geo.domain.b$b  reason: collision with other inner class name */
    public static final class C0394b extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f34694a;

        /* renamed from: b  reason: collision with root package name */
        public Object f34695b;

        /* renamed from: c  reason: collision with root package name */
        public Object f34696c;

        /* renamed from: d  reason: collision with root package name */
        public Object f34697d;

        /* renamed from: e  reason: collision with root package name */
        public double f34698e;

        /* renamed from: f  reason: collision with root package name */
        public double f34699f;

        /* renamed from: g  reason: collision with root package name */
        public float f34700g;

        /* renamed from: h  reason: collision with root package name */
        public /* synthetic */ Object f34701h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ b f34702i;

        /* renamed from: j  reason: collision with root package name */
        public int f34703j;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C0394b(b bVar, c<? super C0394b> cVar) {
            super(cVar);
            this.f34702i = bVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f34701h = obj;
            this.f34703j |= Integer.MIN_VALUE;
            Object a11 = this.f34702i.a((String) null, 0.0d, 0.0d, 0.0f, this);
            return a11 == IntrinsicsKt__IntrinsicsKt.d() ? a11 : Result.m3071boximpl(a11);
        }
    }

    public b(e eVar, com.sumsub.sns.internal.core.data.source.common.a aVar, com.sumsub.sns.internal.core.data.source.dynamic.b bVar, kotlinx.serialization.json.a aVar2) {
        this.f34684a = eVar;
        this.f34685b = aVar;
        this.f34686c = bVar;
        this.f34687d = aVar2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00c7 A[Catch:{ Exception -> 0x01f5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x019e A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x019f  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x01b9 A[Catch:{ Exception -> 0x0045 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(java.lang.String r19, double r20, double r22, float r24, kotlin.coroutines.c<? super kotlin.Result<? extends java.util.List<com.sumsub.sns.internal.geo.model.a>>> r25) {
        /*
            r18 = this;
            r1 = r18
            r0 = r25
            java.lang.String r2 = "kotlinx.serialization.serializer.withModule"
            java.lang.Class<java.lang.String> r3 = java.lang.String.class
            boolean r4 = r0 instanceof com.sumsub.sns.internal.geo.domain.b.C0394b
            if (r4 == 0) goto L_0x001b
            r4 = r0
            com.sumsub.sns.internal.geo.domain.b$b r4 = (com.sumsub.sns.internal.geo.domain.b.C0394b) r4
            int r5 = r4.f34703j
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            r7 = r5 & r6
            if (r7 == 0) goto L_0x001b
            int r5 = r5 - r6
            r4.f34703j = r5
            goto L_0x0020
        L_0x001b:
            com.sumsub.sns.internal.geo.domain.b$b r4 = new com.sumsub.sns.internal.geo.domain.b$b
            r4.<init>(r1, r0)
        L_0x0020:
            java.lang.Object r0 = r4.f34701h
            java.lang.Object r11 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r5 = r4.f34703j
            r12 = 3
            r6 = 1
            r14 = 2
            if (r5 == 0) goto L_0x0083
            if (r5 == r6) goto L_0x0068
            if (r5 == r14) goto L_0x0050
            if (r5 != r12) goto L_0x0048
            java.lang.Object r2 = r4.f34696c
            java.util.Map r2 = (java.util.Map) r2
            java.lang.Object r3 = r4.f34695b
            java.util.List r3 = (java.util.List) r3
            java.lang.Object r4 = r4.f34694a
            com.sumsub.sns.internal.geo.domain.b r4 = (com.sumsub.sns.internal.geo.domain.b) r4
            kotlin.k.b(r0)     // Catch:{ Exception -> 0x0045 }
            r1 = 0
            goto L_0x01a2
        L_0x0045:
            r0 = move-exception
            goto L_0x01fb
        L_0x0048:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x0050:
            java.lang.Object r2 = r4.f34697d
            java.util.List r2 = (java.util.List) r2
            java.lang.Object r3 = r4.f34696c
            java.lang.String r3 = (java.lang.String) r3
            java.lang.Object r5 = r4.f34695b
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r6 = r4.f34694a
            com.sumsub.sns.internal.geo.domain.b r6 = (com.sumsub.sns.internal.geo.domain.b) r6
            kotlin.k.b(r0)     // Catch:{ Exception -> 0x01f5 }
            goto L_0x018a
        L_0x0065:
            r4 = r6
            goto L_0x01fb
        L_0x0068:
            float r5 = r4.f34700g
            double r6 = r4.f34699f
            double r8 = r4.f34698e
            java.lang.Object r10 = r4.f34695b
            java.lang.String r10 = (java.lang.String) r10
            java.lang.Object r15 = r4.f34694a
            com.sumsub.sns.internal.geo.domain.b r15 = (com.sumsub.sns.internal.geo.domain.b) r15
            kotlin.k.b(r0)     // Catch:{ Exception -> 0x007f }
            r16 = r6
            r6 = r15
            r14 = r16
            goto L_0x00af
        L_0x007f:
            r0 = move-exception
            r4 = r15
            goto L_0x01fb
        L_0x0083:
            kotlin.k.b(r0)
            com.sumsub.sns.internal.core.data.source.dynamic.b r5 = r1.f34686c     // Catch:{ Exception -> 0x01f8 }
            r0 = 0
            r7 = 0
            r9 = 3
            r10 = 0
            r4.f34694a = r1     // Catch:{ Exception -> 0x01f8 }
            r15 = r19
            r4.f34695b = r15     // Catch:{ Exception -> 0x01f8 }
            r12 = r20
            r4.f34698e = r12     // Catch:{ Exception -> 0x01f8 }
            r14 = r22
            r4.f34699f = r14     // Catch:{ Exception -> 0x01f8 }
            r8 = r24
            r4.f34700g = r8     // Catch:{ Exception -> 0x01f8 }
            r4.f34703j = r6     // Catch:{ Exception -> 0x01f8 }
            r6 = r0
            r8 = r4
            java.lang.Object r0 = com.sumsub.sns.internal.core.data.source.dynamic.h.e(r5, r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x01f8 }
            if (r0 != r11) goto L_0x00a9
            return r11
        L_0x00a9:
            r10 = r19
            r5 = r24
            r6 = r1
            r8 = r12
        L_0x00af:
            com.sumsub.sns.internal.core.data.model.g r0 = (com.sumsub.sns.internal.core.data.model.g) r0     // Catch:{ Exception -> 0x01f5 }
            java.lang.String r7 = r0.B()     // Catch:{ Exception -> 0x01f5 }
            com.sumsub.sns.internal.core.data.model.g$c r0 = r0.I()     // Catch:{ Exception -> 0x01f5 }
            java.util.List r0 = r0.g()     // Catch:{ Exception -> 0x01f5 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ Exception -> 0x01f5 }
        L_0x00c1:
            boolean r12 = r0.hasNext()     // Catch:{ Exception -> 0x01f5 }
            if (r12 == 0) goto L_0x01ed
            java.lang.Object r12 = r0.next()     // Catch:{ Exception -> 0x01f5 }
            r13 = r12
            com.sumsub.sns.internal.core.data.model.g$c$a r13 = (com.sumsub.sns.internal.core.data.model.g.c.a) r13     // Catch:{ Exception -> 0x01f5 }
            com.sumsub.sns.internal.core.data.model.DocumentType r13 = r13.m()     // Catch:{ Exception -> 0x01f5 }
            java.lang.String r13 = r13.c()     // Catch:{ Exception -> 0x01f5 }
            boolean r13 = kotlin.jvm.internal.x.b(r13, r10)     // Catch:{ Exception -> 0x01f5 }
            if (r13 == 0) goto L_0x01e9
            com.sumsub.sns.internal.core.data.model.g$c$a r12 = (com.sumsub.sns.internal.core.data.model.g.c.a) r12     // Catch:{ Exception -> 0x01f5 }
            java.util.List r0 = r12.l()     // Catch:{ Exception -> 0x01f5 }
            if (r0 != 0) goto L_0x00f6
            kotlin.Result$a r0 = kotlin.Result.Companion     // Catch:{ Exception -> 0x01f5 }
            com.sumsub.sns.core.data.model.SNSInvalidConfigurationException r0 = new com.sumsub.sns.core.data.model.SNSInvalidConfigurationException     // Catch:{ Exception -> 0x01f5 }
            java.lang.String r2 = "Configuration error: no fields found"
            r0.<init>(r2)     // Catch:{ Exception -> 0x01f5 }
            java.lang.Object r0 = kotlin.k.a(r0)     // Catch:{ Exception -> 0x01f5 }
            java.lang.Object r0 = kotlin.Result.m3072constructorimpl(r0)     // Catch:{ Exception -> 0x01f5 }
            return r0
        L_0x00f6:
            com.sumsub.sns.internal.geo.model.b r12 = new com.sumsub.sns.internal.geo.model.b     // Catch:{ Exception -> 0x01f5 }
            r19 = r12
            r20 = r8
            r22 = r14
            r24 = r5
            r19.<init>(r20, r22, r24)     // Catch:{ Exception -> 0x01f5 }
            kotlinx.serialization.json.a r5 = r6.f34687d     // Catch:{ Exception -> 0x01f5 }
            kotlinx.serialization.modules.d r8 = r5.a()     // Catch:{ Exception -> 0x01f5 }
            java.lang.Class<com.sumsub.sns.internal.geo.model.b> r9 = com.sumsub.sns.internal.geo.model.b.class
            kotlin.reflect.p r9 = kotlin.jvm.internal.Reflection.n(r9)     // Catch:{ Exception -> 0x01f5 }
            kotlin.jvm.internal.MagicApiIntrinsics.a(r2)     // Catch:{ Exception -> 0x01f5 }
            kotlinx.serialization.b r8 = kotlinx.serialization.h.d(r8, r9)     // Catch:{ Exception -> 0x01f5 }
            java.lang.String r5 = r5.b(r8, r12)     // Catch:{ Exception -> 0x01f5 }
            r8 = 16
            java.lang.String r8 = kotlin.text.StringsKt___StringsKt.r1(r7, r8)     // Catch:{ Exception -> 0x01f5 }
            java.nio.charset.Charset r9 = kotlin.text.b.f56908b     // Catch:{ Exception -> 0x01f5 }
            byte[] r8 = r8.getBytes(r9)     // Catch:{ Exception -> 0x01f5 }
            byte[] r5 = r5.getBytes(r9)     // Catch:{ Exception -> 0x01f5 }
            byte[] r5 = com.sumsub.sns.internal.core.common.k.b(r5, r8)     // Catch:{ Exception -> 0x01f5 }
            r8 = 2
            java.lang.String r5 = android.util.Base64.encodeToString(r5, r8)     // Catch:{ Exception -> 0x01f5 }
            java.lang.String r8 = "data"
            kotlin.Pair r5 = kotlin.l.a(r8, r5)     // Catch:{ Exception -> 0x01f5 }
            java.util.Map r5 = kotlin.collections.MapsKt__MapsJVMKt.e(r5)     // Catch:{ Exception -> 0x01f5 }
            kotlinx.serialization.json.a r8 = r6.f34687d     // Catch:{ Exception -> 0x01f5 }
            kotlinx.serialization.modules.d r12 = r8.a()     // Catch:{ Exception -> 0x01f5 }
            java.lang.Class<java.util.Map> r13 = java.util.Map.class
            kotlin.reflect.q$a r14 = kotlin.reflect.q.f56856c     // Catch:{ Exception -> 0x01f5 }
            kotlin.reflect.p r15 = kotlin.jvm.internal.Reflection.n(r3)     // Catch:{ Exception -> 0x01f5 }
            kotlin.reflect.q r15 = r14.a(r15)     // Catch:{ Exception -> 0x01f5 }
            kotlin.reflect.p r1 = kotlin.jvm.internal.Reflection.n(r3)     // Catch:{ Exception -> 0x01f5 }
            kotlin.reflect.p r3 = kotlin.jvm.internal.Reflection.g(r3)     // Catch:{ Exception -> 0x01f5 }
            kotlin.reflect.p r1 = kotlin.jvm.internal.Reflection.h(r1, r3)     // Catch:{ Exception -> 0x01f5 }
            kotlin.reflect.q r1 = r14.a(r1)     // Catch:{ Exception -> 0x01f5 }
            kotlin.reflect.p r1 = kotlin.jvm.internal.Reflection.p(r13, r15, r1)     // Catch:{ Exception -> 0x01f5 }
            kotlin.jvm.internal.MagicApiIntrinsics.a(r2)     // Catch:{ Exception -> 0x01f5 }
            kotlinx.serialization.b r1 = kotlinx.serialization.h.d(r12, r1)     // Catch:{ Exception -> 0x01f5 }
            java.lang.String r1 = r8.b(r1, r5)     // Catch:{ Exception -> 0x01f5 }
            com.sumsub.sns.internal.core.data.source.applicant.e r2 = r6.f34684a     // Catch:{ Exception -> 0x01f5 }
            byte[] r1 = r1.getBytes(r9)     // Catch:{ Exception -> 0x01f5 }
            r4.f34694a = r6     // Catch:{ Exception -> 0x01f5 }
            r4.f34695b = r10     // Catch:{ Exception -> 0x01f5 }
            r4.f34696c = r7     // Catch:{ Exception -> 0x01f5 }
            r4.f34697d = r0     // Catch:{ Exception -> 0x01f5 }
            r12 = 2
            r4.f34703j = r12     // Catch:{ Exception -> 0x01f5 }
            java.lang.Object r1 = r2.a((java.lang.String) r7, (byte[]) r1, (kotlin.coroutines.c<? super java.util.Map<java.lang.String, ? extends java.lang.Object>>) r4)     // Catch:{ Exception -> 0x01f5 }
            if (r1 != r11) goto L_0x0186
            return r11
        L_0x0186:
            r2 = r0
            r0 = r1
            r3 = r7
            r5 = r10
        L_0x018a:
            java.util.Map r0 = (java.util.Map) r0     // Catch:{ Exception -> 0x01f5 }
            r4.f34694a = r6     // Catch:{ Exception -> 0x01f5 }
            r4.f34695b = r2     // Catch:{ Exception -> 0x01f5 }
            r4.f34696c = r0     // Catch:{ Exception -> 0x01f5 }
            r1 = 0
            r4.f34697d = r1     // Catch:{ Exception -> 0x01f5 }
            r13 = 3
            r4.f34703j = r13     // Catch:{ Exception -> 0x01f5 }
            java.lang.Object r3 = r6.a(r3, r5, r4)     // Catch:{ Exception -> 0x01f5 }
            if (r3 != r11) goto L_0x019f
            return r11
        L_0x019f:
            r3 = r2
            r4 = r6
            r2 = r0
        L_0x01a2:
            kotlin.Result$a r0 = kotlin.Result.Companion     // Catch:{ Exception -> 0x0045 }
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ Exception -> 0x0045 }
            r5 = 10
            int r5 = kotlin.collections.CollectionsKt__IterablesKt.u(r3, r5)     // Catch:{ Exception -> 0x0045 }
            r0.<init>(r5)     // Catch:{ Exception -> 0x0045 }
            java.util.Iterator r3 = r3.iterator()     // Catch:{ Exception -> 0x0045 }
        L_0x01b3:
            boolean r5 = r3.hasNext()     // Catch:{ Exception -> 0x0045 }
            if (r5 == 0) goto L_0x01e4
            java.lang.Object r5 = r3.next()     // Catch:{ Exception -> 0x0045 }
            com.sumsub.sns.internal.core.data.model.h$d r5 = (com.sumsub.sns.internal.core.data.model.h.d) r5     // Catch:{ Exception -> 0x0045 }
            com.sumsub.sns.internal.core.data.model.FieldName r6 = r5.q()     // Catch:{ Exception -> 0x0045 }
            if (r6 == 0) goto L_0x01ca
            java.lang.String r6 = r6.getValue()     // Catch:{ Exception -> 0x0045 }
            goto L_0x01cb
        L_0x01ca:
            r6 = r1
        L_0x01cb:
            java.lang.Object r6 = r2.get(r6)     // Catch:{ Exception -> 0x0045 }
            boolean r7 = r6 instanceof java.lang.String     // Catch:{ Exception -> 0x0045 }
            if (r7 == 0) goto L_0x01d6
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ Exception -> 0x0045 }
            goto L_0x01d7
        L_0x01d6:
            r6 = r1
        L_0x01d7:
            if (r6 != 0) goto L_0x01db
            java.lang.String r6 = ""
        L_0x01db:
            com.sumsub.sns.internal.geo.model.a r7 = new com.sumsub.sns.internal.geo.model.a     // Catch:{ Exception -> 0x0045 }
            r7.<init>(r5, r6)     // Catch:{ Exception -> 0x0045 }
            r0.add(r7)     // Catch:{ Exception -> 0x0045 }
            goto L_0x01b3
        L_0x01e4:
            java.lang.Object r0 = kotlin.Result.m3072constructorimpl(r0)     // Catch:{ Exception -> 0x0045 }
            goto L_0x020b
        L_0x01e9:
            r1 = r18
            goto L_0x00c1
        L_0x01ed:
            java.util.NoSuchElementException r0 = new java.util.NoSuchElementException     // Catch:{ Exception -> 0x01f5 }
            java.lang.String r1 = "Collection contains no element matching the predicate."
            r0.<init>(r1)     // Catch:{ Exception -> 0x01f5 }
            throw r0     // Catch:{ Exception -> 0x01f5 }
        L_0x01f5:
            r0 = move-exception
            goto L_0x0065
        L_0x01f8:
            r0 = move-exception
            r4 = r18
        L_0x01fb:
            kotlin.Result$a r1 = kotlin.Result.Companion
            com.sumsub.sns.internal.core.data.source.common.a r1 = r4.f34685b
            java.lang.Exception r0 = com.sumsub.sns.internal.core.domain.base.d.a(r1, r0)
            java.lang.Object r0 = kotlin.k.a(r0)
            java.lang.Object r0 = kotlin.Result.m3072constructorimpl(r0)
        L_0x020b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.geo.domain.b.a(java.lang.String, double, double, float, kotlin.coroutines.c):java.lang.Object");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v8, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v10, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0082 A[Catch:{ Exception -> 0x003a }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00b9 A[Catch:{ Exception -> 0x003a }] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0098 A[EDGE_INSN: B:50:0x0098->B:32:0x0098 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(java.lang.String r9, java.lang.String r10, kotlin.coroutines.c<? super kotlin.Unit> r11) {
        /*
            r8 = this;
            boolean r0 = r11 instanceof com.sumsub.sns.internal.geo.domain.b.a
            if (r0 == 0) goto L_0x0013
            r0 = r11
            com.sumsub.sns.internal.geo.domain.b$a r0 = (com.sumsub.sns.internal.geo.domain.b.a) r0
            int r1 = r0.f34693f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f34693f = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.internal.geo.domain.b$a r0 = new com.sumsub.sns.internal.geo.domain.b$a
            r0.<init>(r8, r11)
        L_0x0018:
            java.lang.Object r11 = r0.f34691d
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.f34693f
            r3 = 0
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x0056
            if (r2 == r5) goto L_0x0045
            if (r2 != r4) goto L_0x003d
            java.lang.Object r9 = r0.f34690c
            java.util.Iterator r9 = (java.util.Iterator) r9
            java.lang.Object r10 = r0.f34689b
            java.lang.String r10 = (java.lang.String) r10
            java.lang.Object r2 = r0.f34688a
            com.sumsub.sns.internal.geo.domain.b r2 = (com.sumsub.sns.internal.geo.domain.b) r2
            kotlin.k.b(r11)     // Catch:{ Exception -> 0x003a }
            goto L_0x00b3
        L_0x003a:
            r9 = move-exception
            goto L_0x00d6
        L_0x003d:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x0045:
            java.lang.Object r9 = r0.f34690c
            r10 = r9
            java.lang.String r10 = (java.lang.String) r10
            java.lang.Object r9 = r0.f34689b
            java.lang.String r9 = (java.lang.String) r9
            java.lang.Object r2 = r0.f34688a
            com.sumsub.sns.internal.geo.domain.b r2 = (com.sumsub.sns.internal.geo.domain.b) r2
            kotlin.k.b(r11)     // Catch:{ Exception -> 0x003a }
            goto L_0x006c
        L_0x0056:
            kotlin.k.b(r11)
            com.sumsub.sns.internal.core.data.source.dynamic.b r11 = r8.f34686c     // Catch:{ Exception -> 0x00d4 }
            r2 = 0
            r0.f34688a = r8     // Catch:{ Exception -> 0x00d4 }
            r0.f34689b = r9     // Catch:{ Exception -> 0x00d4 }
            r0.f34690c = r10     // Catch:{ Exception -> 0x00d4 }
            r0.f34693f = r5     // Catch:{ Exception -> 0x00d4 }
            java.lang.Object r11 = com.sumsub.sns.internal.core.data.source.dynamic.h.f(r11, r2, r0, r5, r3)     // Catch:{ Exception -> 0x00d4 }
            if (r11 != r1) goto L_0x006b
            return r1
        L_0x006b:
            r2 = r8
        L_0x006c:
            com.sumsub.sns.internal.core.data.source.dynamic.e r11 = (com.sumsub.sns.internal.core.data.source.dynamic.e) r11     // Catch:{ Exception -> 0x003a }
            java.lang.Object r11 = r11.e()     // Catch:{ Exception -> 0x003a }
            com.sumsub.sns.internal.core.data.model.t r11 = (com.sumsub.sns.internal.core.data.model.t) r11     // Catch:{ Exception -> 0x003a }
            java.util.List r11 = r11.d()     // Catch:{ Exception -> 0x003a }
            java.util.Iterator r11 = r11.iterator()     // Catch:{ Exception -> 0x003a }
        L_0x007c:
            boolean r5 = r11.hasNext()     // Catch:{ Exception -> 0x003a }
            if (r5 == 0) goto L_0x0098
            java.lang.Object r5 = r11.next()     // Catch:{ Exception -> 0x003a }
            r6 = r5
            com.sumsub.sns.internal.core.data.model.Document r6 = (com.sumsub.sns.internal.core.data.model.Document) r6     // Catch:{ Exception -> 0x003a }
            com.sumsub.sns.internal.core.data.model.DocumentType r6 = r6.getType()     // Catch:{ Exception -> 0x003a }
            java.lang.String r6 = r6.c()     // Catch:{ Exception -> 0x003a }
            boolean r6 = kotlin.jvm.internal.x.b(r6, r10)     // Catch:{ Exception -> 0x003a }
            if (r6 == 0) goto L_0x007c
            r3 = r5
        L_0x0098:
            com.sumsub.sns.internal.core.data.model.Document r3 = (com.sumsub.sns.internal.core.data.model.Document) r3     // Catch:{ Exception -> 0x003a }
            if (r3 == 0) goto L_0x00a8
            com.sumsub.sns.internal.core.data.model.Document$b r10 = r3.getResult()     // Catch:{ Exception -> 0x003a }
            if (r10 == 0) goto L_0x00a8
            java.util.List r10 = r10.h()     // Catch:{ Exception -> 0x003a }
            if (r10 != 0) goto L_0x00ac
        L_0x00a8:
            java.util.List r10 = kotlin.collections.CollectionsKt__CollectionsKt.k()     // Catch:{ Exception -> 0x003a }
        L_0x00ac:
            java.util.Iterator r10 = r10.iterator()     // Catch:{ Exception -> 0x003a }
            r7 = r10
            r10 = r9
            r9 = r7
        L_0x00b3:
            boolean r11 = r9.hasNext()     // Catch:{ Exception -> 0x003a }
            if (r11 == 0) goto L_0x00e1
            java.lang.Object r11 = r9.next()     // Catch:{ Exception -> 0x003a }
            java.lang.Number r11 = (java.lang.Number) r11     // Catch:{ Exception -> 0x003a }
            int r11 = r11.intValue()     // Catch:{ Exception -> 0x003a }
            com.sumsub.sns.internal.core.data.source.applicant.e r3 = r2.f34684a     // Catch:{ Exception -> 0x003a }
            r0.f34688a = r2     // Catch:{ Exception -> 0x003a }
            r0.f34689b = r10     // Catch:{ Exception -> 0x003a }
            r0.f34690c = r9     // Catch:{ Exception -> 0x003a }
            r0.f34693f = r4     // Catch:{ Exception -> 0x003a }
            java.lang.Object r11 = r3.a((java.lang.String) r10, (int) r11, (kotlin.coroutines.c<? super kotlin.Unit>) r0)     // Catch:{ Exception -> 0x003a }
            if (r11 != r1) goto L_0x00b3
            return r1
        L_0x00d4:
            r9 = move-exception
            r2 = r8
        L_0x00d6:
            com.sumsub.sns.internal.log.a r10 = com.sumsub.sns.internal.log.a.f34862a
            java.lang.String r11 = com.sumsub.sns.internal.log.c.a(r2)
            java.lang.String r0 = "can't clear images"
            r10.e(r11, r0, r9)
        L_0x00e1:
            kotlin.Unit r9 = kotlin.Unit.f56620a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.geo.domain.b.a(java.lang.String, java.lang.String, kotlin.coroutines.c):java.lang.Object");
    }
}
