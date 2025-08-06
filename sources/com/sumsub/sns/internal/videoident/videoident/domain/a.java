package com.sumsub.sns.internal.videoident.videoident.domain;

import com.sumsub.sns.internal.core.data.source.applicant.e;
import kotlin.Result;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.d;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final com.sumsub.sns.internal.core.data.source.common.a f37088a;

    /* renamed from: b  reason: collision with root package name */
    public final e f37089b;

    @d(c = "com.sumsub.sns.internal.videoident.videoident.domain.AvailableLanguagesUseCase", f = "AvailableLanguagesUseCase.kt", l = {15}, m = "invoke-IoAF18A")
    /* renamed from: com.sumsub.sns.internal.videoident.videoident.domain.a$a  reason: collision with other inner class name */
    public static final class C0505a extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f37090a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f37091b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a f37092c;

        /* renamed from: d  reason: collision with root package name */
        public int f37093d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C0505a(a aVar, c<? super C0505a> cVar) {
            super(cVar);
            this.f37092c = aVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f37091b = obj;
            this.f37093d |= Integer.MIN_VALUE;
            Object a11 = this.f37092c.a(this);
            return a11 == IntrinsicsKt__IntrinsicsKt.d() ? a11 : Result.m3071boximpl(a11);
        }
    }

    public a(com.sumsub.sns.internal.core.data.source.common.a aVar, e eVar) {
        this.f37088a = aVar;
        this.f37089b = eVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(kotlin.coroutines.c<? super kotlin.Result<? extends java.util.List<com.sumsub.sns.internal.core.data.source.applicant.remote.n>>> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.sumsub.sns.internal.videoident.videoident.domain.a.C0505a
            if (r0 == 0) goto L_0x0013
            r0 = r5
            com.sumsub.sns.internal.videoident.videoident.domain.a$a r0 = (com.sumsub.sns.internal.videoident.videoident.domain.a.C0505a) r0
            int r1 = r0.f37093d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f37093d = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.internal.videoident.videoident.domain.a$a r0 = new com.sumsub.sns.internal.videoident.videoident.domain.a$a
            r0.<init>(r4, r5)
        L_0x0018:
            java.lang.Object r5 = r0.f37091b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.f37093d
            r3 = 1
            if (r2 == 0) goto L_0x0037
            if (r2 != r3) goto L_0x002f
            java.lang.Object r0 = r0.f37090a
            com.sumsub.sns.internal.videoident.videoident.domain.a r0 = (com.sumsub.sns.internal.videoident.videoident.domain.a) r0
            kotlin.k.b(r5)     // Catch:{ Exception -> 0x002d }
            goto L_0x004a
        L_0x002d:
            r5 = move-exception
            goto L_0x0051
        L_0x002f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x0037:
            kotlin.k.b(r5)
            kotlin.Result$a r5 = kotlin.Result.Companion     // Catch:{ Exception -> 0x004f }
            com.sumsub.sns.internal.core.data.source.applicant.e r5 = r4.f37089b     // Catch:{ Exception -> 0x004f }
            r0.f37090a = r4     // Catch:{ Exception -> 0x004f }
            r0.f37093d = r3     // Catch:{ Exception -> 0x004f }
            java.lang.Object r5 = r5.a(r0)     // Catch:{ Exception -> 0x004f }
            if (r5 != r1) goto L_0x0049
            return r1
        L_0x0049:
            r0 = r4
        L_0x004a:
            java.lang.Object r5 = kotlin.Result.m3072constructorimpl(r5)     // Catch:{ Exception -> 0x002d }
            return r5
        L_0x004f:
            r5 = move-exception
            r0 = r4
        L_0x0051:
            kotlin.Result$a r1 = kotlin.Result.Companion
            com.sumsub.sns.internal.core.data.source.common.a r0 = r0.f37088a
            java.lang.Exception r5 = com.sumsub.sns.internal.core.domain.base.d.a(r0, r5)
            java.lang.Object r5 = kotlin.k.a(r5)
            java.lang.Object r5 = kotlin.Result.m3072constructorimpl(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.videoident.videoident.domain.a.a(kotlin.coroutines.c):java.lang.Object");
    }
}
