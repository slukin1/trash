package com.sumsub.sns.internal.core.domain;

import com.sumsub.sns.internal.core.data.source.applicant.b;
import kotlin.Result;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.d;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final b f33504a;

    @d(c = "com.sumsub.sns.internal.core.domain.CheckCodeUseCase", f = "CheckCodeUseCase.kt", l = {12}, m = "invoke-0E7RQCE")
    /* renamed from: com.sumsub.sns.internal.core.domain.a$a  reason: collision with other inner class name */
    public static final class C0370a extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public /* synthetic */ Object f33505a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f33506b;

        /* renamed from: c  reason: collision with root package name */
        public int f33507c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C0370a(a aVar, c<? super C0370a> cVar) {
            super(cVar);
            this.f33506b = aVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f33505a = obj;
            this.f33507c |= Integer.MIN_VALUE;
            Object a11 = this.f33506b.a((String) null, (String) null, this);
            return a11 == IntrinsicsKt__IntrinsicsKt.d() ? a11 : Result.m3071boximpl(a11);
        }
    }

    public a(b bVar) {
        this.f33504a = bVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(java.lang.String r5, java.lang.String r6, kotlin.coroutines.c<? super kotlin.Result<com.sumsub.sns.internal.core.data.source.applicant.remote.b0>> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof com.sumsub.sns.internal.core.domain.a.C0370a
            if (r0 == 0) goto L_0x0013
            r0 = r7
            com.sumsub.sns.internal.core.domain.a$a r0 = (com.sumsub.sns.internal.core.domain.a.C0370a) r0
            int r1 = r0.f33507c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f33507c = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.internal.core.domain.a$a r0 = new com.sumsub.sns.internal.core.domain.a$a
            r0.<init>(r4, r7)
        L_0x0018:
            java.lang.Object r7 = r0.f33505a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.f33507c
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            kotlin.k.b(r7)     // Catch:{ Exception -> 0x0048 }
            goto L_0x003f
        L_0x0029:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0031:
            kotlin.k.b(r7)
            com.sumsub.sns.internal.core.data.source.applicant.b r7 = r4.f33504a     // Catch:{ Exception -> 0x0048 }
            r0.f33507c = r3     // Catch:{ Exception -> 0x0048 }
            java.lang.Object r7 = r7.a(r5, r6, r0)     // Catch:{ Exception -> 0x0048 }
            if (r7 != r1) goto L_0x003f
            return r1
        L_0x003f:
            com.sumsub.sns.internal.core.data.source.applicant.remote.b0 r7 = (com.sumsub.sns.internal.core.data.source.applicant.remote.b0) r7     // Catch:{ Exception -> 0x0048 }
            kotlin.Result$a r5 = kotlin.Result.Companion     // Catch:{ Exception -> 0x0048 }
            java.lang.Object r5 = kotlin.Result.m3072constructorimpl(r7)     // Catch:{ Exception -> 0x0048 }
            goto L_0x0053
        L_0x0048:
            r5 = move-exception
            kotlin.Result$a r6 = kotlin.Result.Companion
            java.lang.Object r5 = kotlin.k.a(r5)
            java.lang.Object r5 = kotlin.Result.m3072constructorimpl(r5)
        L_0x0053:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.domain.a.a(java.lang.String, java.lang.String, kotlin.coroutines.c):java.lang.Object");
    }
}
