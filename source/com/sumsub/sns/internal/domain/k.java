package com.sumsub.sns.internal.domain;

import com.sumsub.sns.internal.core.data.source.applicant.b;
import com.sumsub.sns.internal.core.data.source.applicant.remote.u;
import kotlin.Result;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.d;

public final class k {

    @d(c = "com.sumsub.sns.internal.domain.SubmitQuestionnaireUseCase", f = "SubmitQuestionnaireUseCase.kt", l = {14}, m = "invoke-0E7RQCE")
    public static final class a extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public /* synthetic */ Object f34146a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ k f34147b;

        /* renamed from: c  reason: collision with root package name */
        public int f34148c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(k kVar, c<? super a> cVar) {
            super(cVar);
            this.f34147b = kVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f34146a = obj;
            this.f34148c |= Integer.MIN_VALUE;
            Object a11 = this.f34147b.a((b) null, (u) null, this);
            return a11 == IntrinsicsKt__IntrinsicsKt.d() ? a11 : Result.m3071boximpl(a11);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(com.sumsub.sns.internal.core.data.source.applicant.b r7, com.sumsub.sns.internal.core.data.source.applicant.remote.u r8, kotlin.coroutines.c<? super kotlin.Result<com.sumsub.sns.internal.core.data.source.applicant.remote.w>> r9) {
        /*
            r6 = this;
            boolean r0 = r9 instanceof com.sumsub.sns.internal.domain.k.a
            if (r0 == 0) goto L_0x0013
            r0 = r9
            com.sumsub.sns.internal.domain.k$a r0 = (com.sumsub.sns.internal.domain.k.a) r0
            int r1 = r0.f34148c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f34148c = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.internal.domain.k$a r0 = new com.sumsub.sns.internal.domain.k$a
            r0.<init>(r6, r9)
        L_0x0018:
            java.lang.Object r9 = r0.f34146a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.f34148c
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            kotlin.k.b(r9)     // Catch:{ Exception -> 0x0089 }
            goto L_0x0080
        L_0x0029:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0031:
            kotlin.k.b(r9)
            java.util.Map r9 = r8.e()     // Catch:{ Exception -> 0x0089 }
            java.util.LinkedHashMap r2 = new java.util.LinkedHashMap     // Catch:{ Exception -> 0x0089 }
            r2.<init>()     // Catch:{ Exception -> 0x0089 }
            java.util.Set r9 = r9.entrySet()     // Catch:{ Exception -> 0x0089 }
            java.util.Iterator r9 = r9.iterator()     // Catch:{ Exception -> 0x0089 }
        L_0x0045:
            boolean r4 = r9.hasNext()     // Catch:{ Exception -> 0x0089 }
            if (r4 == 0) goto L_0x006e
            java.lang.Object r4 = r9.next()     // Catch:{ Exception -> 0x0089 }
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4     // Catch:{ Exception -> 0x0089 }
            java.lang.Object r5 = r4.getValue()     // Catch:{ Exception -> 0x0089 }
            com.sumsub.sns.internal.core.data.source.applicant.remote.x r5 = (com.sumsub.sns.internal.core.data.source.applicant.remote.x) r5     // Catch:{ Exception -> 0x0089 }
            java.util.Map r5 = r5.b()     // Catch:{ Exception -> 0x0089 }
            boolean r5 = r5.isEmpty()     // Catch:{ Exception -> 0x0089 }
            r5 = r5 ^ r3
            if (r5 == 0) goto L_0x0045
            java.lang.Object r5 = r4.getKey()     // Catch:{ Exception -> 0x0089 }
            java.lang.Object r4 = r4.getValue()     // Catch:{ Exception -> 0x0089 }
            r2.put(r5, r4)     // Catch:{ Exception -> 0x0089 }
            goto L_0x0045
        L_0x006e:
            java.util.Map r9 = kotlin.collections.MapsKt__MapsKt.y(r2)     // Catch:{ Exception -> 0x0089 }
            r2 = 0
            com.sumsub.sns.internal.core.data.source.applicant.remote.u r8 = com.sumsub.sns.internal.core.data.source.applicant.remote.u.a(r8, r2, r9, r3, r2)     // Catch:{ Exception -> 0x0089 }
            r0.f34148c = r3     // Catch:{ Exception -> 0x0089 }
            java.lang.Object r9 = r7.a((com.sumsub.sns.internal.core.data.source.applicant.remote.u) r8, (kotlin.coroutines.c<? super com.sumsub.sns.internal.core.data.source.applicant.remote.w>) r0)     // Catch:{ Exception -> 0x0089 }
            if (r9 != r1) goto L_0x0080
            return r1
        L_0x0080:
            com.sumsub.sns.internal.core.data.source.applicant.remote.w r9 = (com.sumsub.sns.internal.core.data.source.applicant.remote.w) r9     // Catch:{ Exception -> 0x0089 }
            kotlin.Result$a r7 = kotlin.Result.Companion     // Catch:{ Exception -> 0x0089 }
            java.lang.Object r7 = kotlin.Result.m3072constructorimpl(r9)     // Catch:{ Exception -> 0x0089 }
            goto L_0x0094
        L_0x0089:
            r7 = move-exception
            kotlin.Result$a r8 = kotlin.Result.Companion
            java.lang.Object r7 = kotlin.k.a(r7)
            java.lang.Object r7 = kotlin.Result.m3072constructorimpl(r7)
        L_0x0094:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.domain.k.a(com.sumsub.sns.internal.core.data.source.applicant.b, com.sumsub.sns.internal.core.data.source.applicant.remote.u, kotlin.coroutines.c):java.lang.Object");
    }
}
