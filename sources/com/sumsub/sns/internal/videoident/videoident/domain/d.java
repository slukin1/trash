package com.sumsub.sns.internal.videoident.videoident.domain;

import com.sumsub.sns.internal.core.data.source.applicant.e;
import com.sumsub.sns.internal.core.data.source.settings.b;
import kotlin.Result;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public final b f37120a;

    /* renamed from: b  reason: collision with root package name */
    public final com.sumsub.sns.internal.core.data.source.common.a f37121b;

    /* renamed from: c  reason: collision with root package name */
    public final e f37122c;

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.videoident.videoident.domain.VideoIdentApplyUseCase", f = "VideoIdentApplyUseCase.kt", l = {17}, m = "invoke-IoAF18A")
    public static final class a extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f37123a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f37124b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d f37125c;

        /* renamed from: d  reason: collision with root package name */
        public int f37126d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(d dVar, c<? super a> cVar) {
            super(cVar);
            this.f37125c = dVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f37124b = obj;
            this.f37126d |= Integer.MIN_VALUE;
            Object a11 = this.f37125c.a(this);
            return a11 == IntrinsicsKt__IntrinsicsKt.d() ? a11 : Result.m3071boximpl(a11);
        }
    }

    public d(b bVar, com.sumsub.sns.internal.core.data.source.common.a aVar, e eVar) {
        this.f37120a = bVar;
        this.f37121b = aVar;
        this.f37122c = eVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(kotlin.coroutines.c<? super kotlin.Result<com.sumsub.sns.internal.core.data.source.applicant.remote.h0>> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.sumsub.sns.internal.videoident.videoident.domain.d.a
            if (r0 == 0) goto L_0x0013
            r0 = r5
            com.sumsub.sns.internal.videoident.videoident.domain.d$a r0 = (com.sumsub.sns.internal.videoident.videoident.domain.d.a) r0
            int r1 = r0.f37126d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f37126d = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.internal.videoident.videoident.domain.d$a r0 = new com.sumsub.sns.internal.videoident.videoident.domain.d$a
            r0.<init>(r4, r5)
        L_0x0018:
            java.lang.Object r5 = r0.f37124b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.f37126d
            r3 = 1
            if (r2 == 0) goto L_0x0037
            if (r2 != r3) goto L_0x002f
            java.lang.Object r0 = r0.f37123a
            com.sumsub.sns.internal.videoident.videoident.domain.d r0 = (com.sumsub.sns.internal.videoident.videoident.domain.d) r0
            kotlin.k.b(r5)     // Catch:{ Exception -> 0x002d }
            goto L_0x0050
        L_0x002d:
            r5 = move-exception
            goto L_0x0057
        L_0x002f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x0037:
            kotlin.k.b(r5)
            com.sumsub.sns.internal.core.data.source.settings.b r5 = r4.f37120a     // Catch:{ Exception -> 0x0055 }
            java.lang.String r5 = r5.a()     // Catch:{ Exception -> 0x0055 }
            kotlin.Result$a r2 = kotlin.Result.Companion     // Catch:{ Exception -> 0x0055 }
            com.sumsub.sns.internal.core.data.source.applicant.e r2 = r4.f37122c     // Catch:{ Exception -> 0x0055 }
            r0.f37123a = r4     // Catch:{ Exception -> 0x0055 }
            r0.f37126d = r3     // Catch:{ Exception -> 0x0055 }
            java.lang.Object r5 = r2.c(r5, r0)     // Catch:{ Exception -> 0x0055 }
            if (r5 != r1) goto L_0x004f
            return r1
        L_0x004f:
            r0 = r4
        L_0x0050:
            java.lang.Object r5 = kotlin.Result.m3072constructorimpl(r5)     // Catch:{ Exception -> 0x002d }
            return r5
        L_0x0055:
            r5 = move-exception
            r0 = r4
        L_0x0057:
            kotlin.Result$a r1 = kotlin.Result.Companion
            com.sumsub.sns.internal.core.data.source.common.a r0 = r0.f37121b
            java.lang.Exception r5 = com.sumsub.sns.internal.core.domain.base.d.a(r0, r5)
            java.lang.Object r5 = kotlin.k.a(r5)
            java.lang.Object r5 = kotlin.Result.m3072constructorimpl(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.videoident.videoident.domain.d.a(kotlin.coroutines.c):java.lang.Object");
    }
}
