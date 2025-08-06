package com.sumsub.sns.internal.domain;

import com.sumsub.sns.internal.core.data.source.applicant.b;
import kotlin.Result;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.d;

public final class j {

    /* renamed from: a  reason: collision with root package name */
    public final com.sumsub.sns.internal.core.data.source.common.a f34141a;

    @d(c = "com.sumsub.sns.internal.domain.SetApplicantLanguageUseCase", f = "SetApplicantLanguageUseCase.kt", l = {17}, m = "invoke-0E7RQCE")
    public static final class a extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f34142a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f34143b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ j f34144c;

        /* renamed from: d  reason: collision with root package name */
        public int f34145d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(j jVar, c<? super a> cVar) {
            super(cVar);
            this.f34144c = jVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f34143b = obj;
            this.f34145d |= Integer.MIN_VALUE;
            Object a11 = this.f34144c.a((String) null, (b) null, this);
            return a11 == IntrinsicsKt__IntrinsicsKt.d() ? a11 : Result.m3071boximpl(a11);
        }
    }

    public j(com.sumsub.sns.internal.core.data.source.common.a aVar) {
        this.f34141a = aVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(java.lang.String r5, com.sumsub.sns.internal.core.data.source.applicant.b r6, kotlin.coroutines.c<? super kotlin.Result<kotlin.Unit>> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof com.sumsub.sns.internal.domain.j.a
            if (r0 == 0) goto L_0x0013
            r0 = r7
            com.sumsub.sns.internal.domain.j$a r0 = (com.sumsub.sns.internal.domain.j.a) r0
            int r1 = r0.f34145d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f34145d = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.internal.domain.j$a r0 = new com.sumsub.sns.internal.domain.j$a
            r0.<init>(r4, r7)
        L_0x0018:
            java.lang.Object r7 = r0.f34143b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.f34145d
            r3 = 1
            if (r2 == 0) goto L_0x0037
            if (r2 != r3) goto L_0x002f
            java.lang.Object r5 = r0.f34142a
            com.sumsub.sns.internal.domain.j r5 = (com.sumsub.sns.internal.domain.j) r5
            kotlin.k.b(r7)     // Catch:{ Exception -> 0x002d }
            goto L_0x0046
        L_0x002d:
            r6 = move-exception
            goto L_0x0051
        L_0x002f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0037:
            kotlin.k.b(r7)
            r0.f34142a = r4     // Catch:{ Exception -> 0x004f }
            r0.f34145d = r3     // Catch:{ Exception -> 0x004f }
            java.lang.Object r5 = r6.a((java.lang.String) r5, (kotlin.coroutines.c<? super kotlin.Unit>) r0)     // Catch:{ Exception -> 0x004f }
            if (r5 != r1) goto L_0x0045
            return r1
        L_0x0045:
            r5 = r4
        L_0x0046:
            kotlin.Result$a r6 = kotlin.Result.Companion     // Catch:{ Exception -> 0x002d }
            kotlin.Unit r6 = kotlin.Unit.f56620a     // Catch:{ Exception -> 0x002d }
            java.lang.Object r5 = kotlin.Result.m3072constructorimpl(r6)     // Catch:{ Exception -> 0x002d }
            goto L_0x0061
        L_0x004f:
            r6 = move-exception
            r5 = r4
        L_0x0051:
            kotlin.Result$a r7 = kotlin.Result.Companion
            com.sumsub.sns.internal.core.data.source.common.a r5 = r5.f34141a
            java.lang.Exception r5 = com.sumsub.sns.internal.core.domain.base.d.a(r5, r6)
            java.lang.Object r5 = kotlin.k.a(r5)
            java.lang.Object r5 = kotlin.Result.m3072constructorimpl(r5)
        L_0x0061:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.domain.j.a(java.lang.String, com.sumsub.sns.internal.core.data.source.applicant.b, kotlin.coroutines.c):java.lang.Object");
    }
}
