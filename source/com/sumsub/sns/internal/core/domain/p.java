package com.sumsub.sns.internal.core.domain;

import com.sumsub.sns.internal.core.data.model.g;
import com.sumsub.sns.internal.core.data.source.dynamic.b;
import kotlin.Result;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.d;

public final class p {

    /* renamed from: a  reason: collision with root package name */
    public final com.sumsub.sns.internal.core.data.source.common.a f33659a;

    /* renamed from: b  reason: collision with root package name */
    public final b f33660b;

    @d(c = "com.sumsub.sns.internal.core.domain.SendAgreementUseCase", f = "SendAgreementUseCase.kt", l = {32, 37}, m = "invoke-yxL6bBk")
    public static final class a extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f33661a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f33662b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ p f33663c;

        /* renamed from: d  reason: collision with root package name */
        public int f33664d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(p pVar, c<? super a> cVar) {
            super(cVar);
            this.f33663c = pVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f33662b = obj;
            this.f33664d |= Integer.MIN_VALUE;
            Object a11 = this.f33663c.a((com.sumsub.sns.internal.core.data.source.applicant.b) null, (g) null, (com.sumsub.sns.internal.core.data.model.b) null, false, this);
            return a11 == IntrinsicsKt__IntrinsicsKt.d() ? a11 : Result.m3071boximpl(a11);
        }
    }

    public p(com.sumsub.sns.internal.core.data.source.common.a aVar, b bVar) {
        this.f33659a = aVar;
        this.f33660b = bVar;
    }

    public final com.sumsub.sns.internal.core.data.source.common.a a() {
        return this.f33659a;
    }

    public final b b() {
        return this.f33660b;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v6, resolved type: com.sumsub.sns.internal.core.data.model.g} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006b A[Catch:{ Exception -> 0x0040 }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(com.sumsub.sns.internal.core.data.source.applicant.b r6, com.sumsub.sns.internal.core.data.model.g r7, com.sumsub.sns.internal.core.data.model.b r8, boolean r9, kotlin.coroutines.c<? super kotlin.Result<kotlin.Unit>> r10) {
        /*
            r5 = this;
            boolean r0 = r10 instanceof com.sumsub.sns.internal.core.domain.p.a
            if (r0 == 0) goto L_0x0013
            r0 = r10
            com.sumsub.sns.internal.core.domain.p$a r0 = (com.sumsub.sns.internal.core.domain.p.a) r0
            int r1 = r0.f33664d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f33664d = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.internal.core.domain.p$a r0 = new com.sumsub.sns.internal.core.domain.p$a
            r0.<init>(r5, r10)
        L_0x0018:
            java.lang.Object r10 = r0.f33662b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.f33664d
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0042
            if (r2 == r4) goto L_0x0038
            if (r2 != r3) goto L_0x0030
            java.lang.Object r6 = r0.f33661a
            com.sumsub.sns.internal.core.domain.p r6 = (com.sumsub.sns.internal.core.domain.p) r6
            kotlin.k.b(r10)     // Catch:{ Exception -> 0x0040 }
            goto L_0x006c
        L_0x0030:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0038:
            java.lang.Object r6 = r0.f33661a
            com.sumsub.sns.internal.core.domain.p r6 = (com.sumsub.sns.internal.core.domain.p) r6
            kotlin.k.b(r10)     // Catch:{ Exception -> 0x0040 }
            goto L_0x005c
        L_0x0040:
            r7 = move-exception
            goto L_0x0077
        L_0x0042:
            kotlin.k.b(r10)
            com.sumsub.sns.internal.core.data.model.b r10 = r7.r()     // Catch:{ Exception -> 0x0075 }
            if (r10 == 0) goto L_0x0050
            if (r9 == 0) goto L_0x004e
            goto L_0x0050
        L_0x004e:
            r6 = r5
            goto L_0x005f
        L_0x0050:
            r0.f33661a = r5     // Catch:{ Exception -> 0x0075 }
            r0.f33664d = r4     // Catch:{ Exception -> 0x0075 }
            java.lang.Object r10 = r6.a((com.sumsub.sns.internal.core.data.model.b) r8, (kotlin.coroutines.c<? super com.sumsub.sns.internal.core.data.model.g>) r0)     // Catch:{ Exception -> 0x0075 }
            if (r10 != r1) goto L_0x005b
            return r1
        L_0x005b:
            r6 = r5
        L_0x005c:
            r7 = r10
            com.sumsub.sns.internal.core.data.model.g r7 = (com.sumsub.sns.internal.core.data.model.g) r7     // Catch:{ Exception -> 0x0040 }
        L_0x005f:
            com.sumsub.sns.internal.core.data.source.dynamic.b r8 = r6.f33660b     // Catch:{ Exception -> 0x0040 }
            r0.f33661a = r6     // Catch:{ Exception -> 0x0040 }
            r0.f33664d = r3     // Catch:{ Exception -> 0x0040 }
            java.lang.Object r7 = r8.b((com.sumsub.sns.internal.core.data.model.g) r7, (kotlin.coroutines.c<? super kotlin.Unit>) r0)     // Catch:{ Exception -> 0x0040 }
            if (r7 != r1) goto L_0x006c
            return r1
        L_0x006c:
            kotlin.Result$a r7 = kotlin.Result.Companion     // Catch:{ Exception -> 0x0040 }
            kotlin.Unit r7 = kotlin.Unit.f56620a     // Catch:{ Exception -> 0x0040 }
            java.lang.Object r6 = kotlin.Result.m3072constructorimpl(r7)     // Catch:{ Exception -> 0x0040 }
            goto L_0x0092
        L_0x0075:
            r7 = move-exception
            r6 = r5
        L_0x0077:
            com.sumsub.sns.internal.log.a r8 = com.sumsub.sns.internal.log.a.f34862a
            java.lang.String r9 = com.sumsub.sns.internal.log.c.a(r6)
            java.lang.String r10 = "Error during agreement acceptance"
            com.sumsub.sns.internal.log.b.b(r8, r9, r10, r7)
            kotlin.Result$a r8 = kotlin.Result.Companion
            com.sumsub.sns.internal.core.data.source.common.a r6 = r6.f33659a
            java.lang.Exception r6 = com.sumsub.sns.internal.core.domain.base.d.a(r6, r7)
            java.lang.Object r6 = kotlin.k.a(r6)
            java.lang.Object r6 = kotlin.Result.m3072constructorimpl(r6)
        L_0x0092:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.domain.p.a(com.sumsub.sns.internal.core.data.source.applicant.b, com.sumsub.sns.internal.core.data.model.g, com.sumsub.sns.internal.core.data.model.b, boolean, kotlin.coroutines.c):java.lang.Object");
    }

    public p(com.sumsub.sns.internal.core.a aVar) {
        this(aVar.n(), aVar.p());
    }

    public static /* synthetic */ Object a(p pVar, com.sumsub.sns.internal.core.data.source.applicant.b bVar, g gVar, com.sumsub.sns.internal.core.data.model.b bVar2, boolean z11, c cVar, int i11, Object obj) {
        if ((i11 & 8) != 0) {
            z11 = true;
        }
        return pVar.a(bVar, gVar, bVar2, z11, cVar);
    }
}
