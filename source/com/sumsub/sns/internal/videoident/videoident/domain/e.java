package com.sumsub.sns.internal.videoident.videoident.domain;

import com.sumsub.sns.internal.core.data.source.settings.b;
import kotlin.Result;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.d;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public final b f37127a;

    /* renamed from: b  reason: collision with root package name */
    public final com.sumsub.sns.internal.core.data.source.common.a f37128b;

    /* renamed from: c  reason: collision with root package name */
    public final com.sumsub.sns.internal.core.data.source.applicant.e f37129c;

    @d(c = "com.sumsub.sns.internal.videoident.videoident.domain.VideoIdentConfirmUseCase", f = "VideoIdentConfirmUseCase.kt", l = {18}, m = "invoke-IoAF18A")
    public static final class a extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f37130a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f37131b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ e f37132c;

        /* renamed from: d  reason: collision with root package name */
        public int f37133d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(e eVar, c<? super a> cVar) {
            super(cVar);
            this.f37132c = eVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f37131b = obj;
            this.f37133d |= Integer.MIN_VALUE;
            Object a11 = this.f37132c.a(this);
            return a11 == IntrinsicsKt__IntrinsicsKt.d() ? a11 : Result.m3071boximpl(a11);
        }
    }

    public e(b bVar, com.sumsub.sns.internal.core.data.source.common.a aVar, com.sumsub.sns.internal.core.data.source.applicant.e eVar) {
        this.f37127a = bVar;
        this.f37128b = aVar;
        this.f37129c = eVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0056 A[Catch:{ Exception -> 0x002d }] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0057 A[Catch:{ Exception -> 0x002d }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(kotlin.coroutines.c<? super kotlin.Result<com.sumsub.sns.internal.core.data.source.applicant.remote.g>> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof com.sumsub.sns.internal.videoident.videoident.domain.e.a
            if (r0 == 0) goto L_0x0013
            r0 = r6
            com.sumsub.sns.internal.videoident.videoident.domain.e$a r0 = (com.sumsub.sns.internal.videoident.videoident.domain.e.a) r0
            int r1 = r0.f37133d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f37133d = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.internal.videoident.videoident.domain.e$a r0 = new com.sumsub.sns.internal.videoident.videoident.domain.e$a
            r0.<init>(r5, r6)
        L_0x0018:
            java.lang.Object r6 = r0.f37131b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.f37133d
            r3 = 1
            if (r2 == 0) goto L_0x0037
            if (r2 != r3) goto L_0x002f
            java.lang.Object r0 = r0.f37130a
            com.sumsub.sns.internal.videoident.videoident.domain.e r0 = (com.sumsub.sns.internal.videoident.videoident.domain.e) r0
            kotlin.k.b(r6)     // Catch:{ Exception -> 0x002d }
            goto L_0x004e
        L_0x002d:
            r6 = move-exception
            goto L_0x00a2
        L_0x002f:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x0037:
            kotlin.k.b(r6)
            com.sumsub.sns.internal.core.data.source.settings.b r6 = r5.f37127a     // Catch:{ Exception -> 0x00a0 }
            java.lang.String r6 = r6.a()     // Catch:{ Exception -> 0x00a0 }
            com.sumsub.sns.internal.core.data.source.applicant.e r2 = r5.f37129c     // Catch:{ Exception -> 0x00a0 }
            r0.f37130a = r5     // Catch:{ Exception -> 0x00a0 }
            r0.f37133d = r3     // Catch:{ Exception -> 0x00a0 }
            java.lang.Object r6 = r2.b(r6, r0)     // Catch:{ Exception -> 0x00a0 }
            if (r6 != r1) goto L_0x004d
            return r1
        L_0x004d:
            r0 = r5
        L_0x004e:
            com.sumsub.sns.internal.core.data.source.applicant.remote.g r6 = (com.sumsub.sns.internal.core.data.source.applicant.remote.g) r6     // Catch:{ Exception -> 0x002d }
            java.lang.Integer r1 = r6.k()     // Catch:{ Exception -> 0x002d }
            if (r1 != 0) goto L_0x0057
            goto L_0x005d
        L_0x0057:
            int r1 = r1.intValue()     // Catch:{ Exception -> 0x002d }
            if (r1 == r3) goto L_0x0099
        L_0x005d:
            com.sumsub.sns.core.data.model.SNSException$Unknown r1 = new com.sumsub.sns.core.data.model.SNSException$Unknown     // Catch:{ Exception -> 0x002d }
            java.lang.Exception r2 = new java.lang.Exception     // Catch:{ Exception -> 0x002d }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x002d }
            r3.<init>()     // Catch:{ Exception -> 0x002d }
            java.lang.String r4 = "d="
            r3.append(r4)     // Catch:{ Exception -> 0x002d }
            java.lang.String r4 = r6.i()     // Catch:{ Exception -> 0x002d }
            r3.append(r4)     // Catch:{ Exception -> 0x002d }
            java.lang.String r4 = ", c="
            r3.append(r4)     // Catch:{ Exception -> 0x002d }
            java.lang.Integer r6 = r6.e()     // Catch:{ Exception -> 0x002d }
            r3.append(r6)     // Catch:{ Exception -> 0x002d }
            java.lang.String r6 = r3.toString()     // Catch:{ Exception -> 0x002d }
            r2.<init>(r6)     // Catch:{ Exception -> 0x002d }
            r1.<init>(r2)     // Catch:{ Exception -> 0x002d }
            kotlin.Result$a r6 = kotlin.Result.Companion     // Catch:{ Exception -> 0x002d }
            com.sumsub.sns.internal.core.data.source.common.a r6 = r0.f37128b     // Catch:{ Exception -> 0x002d }
            java.lang.Exception r6 = com.sumsub.sns.internal.core.domain.base.d.a(r6, r1)     // Catch:{ Exception -> 0x002d }
            java.lang.Object r6 = kotlin.k.a(r6)     // Catch:{ Exception -> 0x002d }
            java.lang.Object r6 = kotlin.Result.m3072constructorimpl(r6)     // Catch:{ Exception -> 0x002d }
            return r6
        L_0x0099:
            kotlin.Result$a r1 = kotlin.Result.Companion     // Catch:{ Exception -> 0x002d }
            java.lang.Object r6 = kotlin.Result.m3072constructorimpl(r6)     // Catch:{ Exception -> 0x002d }
            return r6
        L_0x00a0:
            r6 = move-exception
            r0 = r5
        L_0x00a2:
            kotlin.Result$a r1 = kotlin.Result.Companion
            com.sumsub.sns.internal.core.data.source.common.a r0 = r0.f37128b
            java.lang.Exception r6 = com.sumsub.sns.internal.core.domain.base.d.a(r0, r6)
            java.lang.Object r6 = kotlin.k.a(r6)
            java.lang.Object r6 = kotlin.Result.m3072constructorimpl(r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.videoident.videoident.domain.e.a(kotlin.coroutines.c):java.lang.Object");
    }
}
