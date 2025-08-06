package com.sumsub.sns.internal.core.domain;

import com.sumsub.sns.internal.core.data.source.applicant.b;
import kotlin.Result;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.d;

public final class n {

    /* renamed from: a  reason: collision with root package name */
    public final b f33645a;

    @d(c = "com.sumsub.sns.internal.core.domain.RequestCodeUseCase", f = "RequestCodeUseCase.kt", l = {17}, m = "invoke-0E7RQCE")
    public static final class a extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public /* synthetic */ Object f33646a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ n f33647b;

        /* renamed from: c  reason: collision with root package name */
        public int f33648c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(n nVar, c<? super a> cVar) {
            super(cVar);
            this.f33647b = nVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f33646a = obj;
            this.f33648c |= Integer.MIN_VALUE;
            Object a11 = this.f33647b.a((String) null, (String) null, this);
            return a11 == IntrinsicsKt__IntrinsicsKt.d() ? a11 : Result.m3071boximpl(a11);
        }
    }

    public n(b bVar) {
        this.f33645a = bVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(java.lang.String r6, java.lang.String r7, kotlin.coroutines.c<? super kotlin.Result<com.sumsub.sns.internal.core.data.source.applicant.remote.b0>> r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof com.sumsub.sns.internal.core.domain.n.a
            if (r0 == 0) goto L_0x0013
            r0 = r8
            com.sumsub.sns.internal.core.domain.n$a r0 = (com.sumsub.sns.internal.core.domain.n.a) r0
            int r1 = r0.f33648c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f33648c = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.internal.core.domain.n$a r0 = new com.sumsub.sns.internal.core.domain.n$a
            r0.<init>(r5, r8)
        L_0x0018:
            java.lang.Object r8 = r0.f33646a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.f33648c
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            kotlin.k.b(r8)     // Catch:{ Exception -> 0x004f }
            goto L_0x0046
        L_0x0029:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0031:
            kotlin.k.b(r8)
            com.sumsub.sns.internal.core.data.source.applicant.b r8 = r5.f33645a     // Catch:{ Exception -> 0x004f }
            com.sumsub.sns.internal.core.data.source.applicant.remote.a0 r2 = new com.sumsub.sns.internal.core.data.source.applicant.remote.a0     // Catch:{ Exception -> 0x004f }
            java.lang.String r4 = "applicant"
            r2.<init>(r4, r6, r7)     // Catch:{ Exception -> 0x004f }
            r0.f33648c = r3     // Catch:{ Exception -> 0x004f }
            java.lang.Object r8 = r8.a((com.sumsub.sns.internal.core.data.source.applicant.remote.a0) r2, (kotlin.coroutines.c<? super com.sumsub.sns.internal.core.data.source.applicant.remote.b0>) r0)     // Catch:{ Exception -> 0x004f }
            if (r8 != r1) goto L_0x0046
            return r1
        L_0x0046:
            com.sumsub.sns.internal.core.data.source.applicant.remote.b0 r8 = (com.sumsub.sns.internal.core.data.source.applicant.remote.b0) r8     // Catch:{ Exception -> 0x004f }
            kotlin.Result$a r6 = kotlin.Result.Companion     // Catch:{ Exception -> 0x004f }
            java.lang.Object r6 = kotlin.Result.m3072constructorimpl(r8)     // Catch:{ Exception -> 0x004f }
            goto L_0x005a
        L_0x004f:
            r6 = move-exception
            kotlin.Result$a r7 = kotlin.Result.Companion
            java.lang.Object r6 = kotlin.k.a(r6)
            java.lang.Object r6 = kotlin.Result.m3072constructorimpl(r6)
        L_0x005a:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.domain.n.a(java.lang.String, java.lang.String, kotlin.coroutines.c):java.lang.Object");
    }
}
