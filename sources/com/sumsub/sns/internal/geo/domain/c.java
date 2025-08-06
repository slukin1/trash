package com.sumsub.sns.internal.geo.domain;

import com.sumsub.sns.internal.core.data.source.applicant.e;
import com.sumsub.sns.internal.core.data.source.settings.b;
import java.util.Map;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.d;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public final e f34704a;

    /* renamed from: b  reason: collision with root package name */
    public final b f34705b;

    /* renamed from: c  reason: collision with root package name */
    public final com.sumsub.sns.internal.core.data.source.common.a f34706c;

    @d(c = "com.sumsub.sns.internal.geo.domain.SendAddressUseCase", f = "SendAddressUseCase.kt", l = {21, 27}, m = "invoke-gIAlu-s")
    public static final class a extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f34707a;

        /* renamed from: b  reason: collision with root package name */
        public Object f34708b;

        /* renamed from: c  reason: collision with root package name */
        public Object f34709c;

        /* renamed from: d  reason: collision with root package name */
        public /* synthetic */ Object f34710d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f34711e;

        /* renamed from: f  reason: collision with root package name */
        public int f34712f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(c cVar, kotlin.coroutines.c<? super a> cVar2) {
            super(cVar2);
            this.f34711e = cVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f34710d = obj;
            this.f34712f |= Integer.MIN_VALUE;
            Object a11 = this.f34711e.a((Map<String, ? extends Object>) null, this);
            return a11 == IntrinsicsKt__IntrinsicsKt.d() ? a11 : Result.m3071boximpl(a11);
        }
    }

    public c(e eVar, b bVar, com.sumsub.sns.internal.core.data.source.common.a aVar) {
        this.f34704a = eVar;
        this.f34705b = bVar;
        this.f34706c = aVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0087 A[Catch:{ Exception -> 0x00fe }, LOOP:0: B:33:0x0081->B:35:0x0087, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00a7 A[Catch:{ Exception -> 0x00fe }, LOOP:1: B:37:0x00a1->B:39:0x00a7, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00d0 A[Catch:{ Exception -> 0x00fe }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00f7 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00f8  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(java.util.Map<java.lang.String, ? extends java.lang.Object> r13, kotlin.coroutines.c<? super kotlin.Result<com.sumsub.sns.internal.core.data.model.g.a>> r14) {
        /*
            r12 = this;
            boolean r0 = r14 instanceof com.sumsub.sns.internal.geo.domain.c.a
            if (r0 == 0) goto L_0x0013
            r0 = r14
            com.sumsub.sns.internal.geo.domain.c$a r0 = (com.sumsub.sns.internal.geo.domain.c.a) r0
            int r1 = r0.f34712f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f34712f = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.internal.geo.domain.c$a r0 = new com.sumsub.sns.internal.geo.domain.c$a
            r0.<init>(r12, r14)
        L_0x0018:
            java.lang.Object r14 = r0.f34710d
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.f34712f
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0053
            if (r2 == r4) goto L_0x003c
            if (r2 != r3) goto L_0x0034
            java.lang.Object r13 = r0.f34707a
            com.sumsub.sns.internal.geo.domain.c r13 = (com.sumsub.sns.internal.geo.domain.c) r13
            kotlin.k.b(r14)     // Catch:{ Exception -> 0x0031 }
            goto L_0x00f9
        L_0x0031:
            r14 = move-exception
            goto L_0x0103
        L_0x0034:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r14)
            throw r13
        L_0x003c:
            java.lang.Object r13 = r0.f34709c
            java.lang.String r13 = (java.lang.String) r13
            java.lang.Object r2 = r0.f34708b
            java.util.Map r2 = (java.util.Map) r2
            java.lang.Object r5 = r0.f34707a
            com.sumsub.sns.internal.geo.domain.c r5 = (com.sumsub.sns.internal.geo.domain.c) r5
            kotlin.k.b(r14)     // Catch:{ Exception -> 0x0050 }
            r11 = r14
            r14 = r13
            r13 = r2
            r2 = r11
            goto L_0x006e
        L_0x0050:
            r13 = move-exception
            goto L_0x0105
        L_0x0053:
            kotlin.k.b(r14)
            com.sumsub.sns.internal.core.data.source.settings.b r14 = r12.f34705b     // Catch:{ Exception -> 0x0101 }
            java.lang.String r14 = r14.a()     // Catch:{ Exception -> 0x0101 }
            com.sumsub.sns.internal.core.data.source.applicant.e r2 = r12.f34704a     // Catch:{ Exception -> 0x0101 }
            r0.f34707a = r12     // Catch:{ Exception -> 0x0101 }
            r0.f34708b = r13     // Catch:{ Exception -> 0x0101 }
            r0.f34709c = r14     // Catch:{ Exception -> 0x0101 }
            r0.f34712f = r4     // Catch:{ Exception -> 0x0101 }
            java.lang.Object r2 = r2.e(r14, r0)     // Catch:{ Exception -> 0x0101 }
            if (r2 != r1) goto L_0x006d
            return r1
        L_0x006d:
            r5 = r12
        L_0x006e:
            java.util.Map r2 = (java.util.Map) r2     // Catch:{ Exception -> 0x00fe }
            java.util.LinkedHashMap r6 = new java.util.LinkedHashMap     // Catch:{ Exception -> 0x00fe }
            r6.<init>()     // Catch:{ Exception -> 0x00fe }
            if (r2 == 0) goto L_0x0099
            java.util.Set r2 = r2.entrySet()     // Catch:{ Exception -> 0x00fe }
            if (r2 == 0) goto L_0x0099
            java.util.Iterator r2 = r2.iterator()     // Catch:{ Exception -> 0x00fe }
        L_0x0081:
            boolean r7 = r2.hasNext()     // Catch:{ Exception -> 0x00fe }
            if (r7 == 0) goto L_0x0099
            java.lang.Object r7 = r2.next()     // Catch:{ Exception -> 0x00fe }
            java.util.Map$Entry r7 = (java.util.Map.Entry) r7     // Catch:{ Exception -> 0x00fe }
            java.lang.Object r8 = r7.getKey()     // Catch:{ Exception -> 0x00fe }
            java.lang.Object r7 = r7.getValue()     // Catch:{ Exception -> 0x00fe }
            r6.put(r8, r7)     // Catch:{ Exception -> 0x00fe }
            goto L_0x0081
        L_0x0099:
            java.util.Set r2 = r13.entrySet()     // Catch:{ Exception -> 0x00fe }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ Exception -> 0x00fe }
        L_0x00a1:
            boolean r7 = r2.hasNext()     // Catch:{ Exception -> 0x00fe }
            if (r7 == 0) goto L_0x00b9
            java.lang.Object r7 = r2.next()     // Catch:{ Exception -> 0x00fe }
            java.util.Map$Entry r7 = (java.util.Map.Entry) r7     // Catch:{ Exception -> 0x00fe }
            java.lang.Object r8 = r7.getKey()     // Catch:{ Exception -> 0x00fe }
            java.lang.Object r7 = r7.getValue()     // Catch:{ Exception -> 0x00fe }
            r6.put(r8, r7)     // Catch:{ Exception -> 0x00fe }
            goto L_0x00a1
        L_0x00b9:
            kotlin.Result$a r2 = kotlin.Result.Companion     // Catch:{ Exception -> 0x00fe }
            com.sumsub.sns.internal.core.data.source.applicant.e r2 = r5.f34704a     // Catch:{ Exception -> 0x00fe }
            kotlin.Pair[] r7 = new kotlin.Pair[r3]     // Catch:{ Exception -> 0x00fe }
            r8 = 0
            com.sumsub.sns.internal.core.data.model.FieldName r9 = com.sumsub.sns.internal.core.data.model.FieldName.country     // Catch:{ Exception -> 0x00fe }
            java.lang.String r10 = r9.getValue()     // Catch:{ Exception -> 0x00fe }
            java.lang.String r9 = r9.getValue()     // Catch:{ Exception -> 0x00fe }
            java.lang.Object r13 = r13.get(r9)     // Catch:{ Exception -> 0x00fe }
            if (r13 != 0) goto L_0x00d2
            java.lang.String r13 = ""
        L_0x00d2:
            kotlin.Pair r13 = kotlin.l.a(r10, r13)     // Catch:{ Exception -> 0x00fe }
            r7[r8] = r13     // Catch:{ Exception -> 0x00fe }
            java.lang.String r13 = "addresses"
            java.util.List r6 = kotlin.collections.CollectionsKt__CollectionsJVMKt.e(r6)     // Catch:{ Exception -> 0x00fe }
            kotlin.Pair r13 = kotlin.l.a(r13, r6)     // Catch:{ Exception -> 0x00fe }
            r7[r4] = r13     // Catch:{ Exception -> 0x00fe }
            java.util.Map r13 = kotlin.collections.MapsKt__MapsKt.l(r7)     // Catch:{ Exception -> 0x00fe }
            r0.f34707a = r5     // Catch:{ Exception -> 0x00fe }
            r4 = 0
            r0.f34708b = r4     // Catch:{ Exception -> 0x00fe }
            r0.f34709c = r4     // Catch:{ Exception -> 0x00fe }
            r0.f34712f = r3     // Catch:{ Exception -> 0x00fe }
            java.lang.Object r14 = r2.a((java.lang.String) r14, (java.util.Map<java.lang.String, ? extends java.lang.Object>) r13, (java.util.List<java.lang.String>) r4, (kotlin.coroutines.c<? super com.sumsub.sns.internal.core.data.model.g.a>) r0)     // Catch:{ Exception -> 0x00fe }
            if (r14 != r1) goto L_0x00f8
            return r1
        L_0x00f8:
            r13 = r5
        L_0x00f9:
            java.lang.Object r13 = kotlin.Result.m3072constructorimpl(r14)     // Catch:{ Exception -> 0x0031 }
            goto L_0x0115
        L_0x00fe:
            r14 = move-exception
            r13 = r5
            goto L_0x0103
        L_0x0101:
            r14 = move-exception
            r13 = r12
        L_0x0103:
            r5 = r13
            r13 = r14
        L_0x0105:
            kotlin.Result$a r14 = kotlin.Result.Companion
            com.sumsub.sns.internal.core.data.source.common.a r14 = r5.f34706c
            java.lang.Exception r13 = com.sumsub.sns.internal.core.domain.base.d.a(r14, r13)
            java.lang.Object r13 = kotlin.k.a(r13)
            java.lang.Object r13 = kotlin.Result.m3072constructorimpl(r13)
        L_0x0115:
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.geo.domain.c.a(java.util.Map, kotlin.coroutines.c):java.lang.Object");
    }
}
