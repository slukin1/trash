package com.sumsub.sns.internal.core.domain;

import com.sumsub.sns.internal.core.data.model.e;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.d;

public final class k extends com.sumsub.sns.internal.core.domain.base.b<e, a> {

    /* renamed from: b  reason: collision with root package name */
    public final com.sumsub.sns.internal.core.data.source.dynamic.b f33619b;

    public static final class a {
    }

    @d(c = "com.sumsub.sns.internal.core.domain.GetConfigUseCase", f = "GetConfigUseCase.kt", l = {24, 27}, m = "run")
    public static final class b extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f33620a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f33621b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ k f33622c;

        /* renamed from: d  reason: collision with root package name */
        public int f33623d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(k kVar, c<? super b> cVar) {
            super(cVar);
            this.f33622c = kVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f33621b = obj;
            this.f33623d |= Integer.MIN_VALUE;
            return this.f33622c.b((a) null, this);
        }
    }

    public k(com.sumsub.sns.internal.core.data.source.common.a aVar, com.sumsub.sns.internal.core.data.source.dynamic.b bVar) {
        super(aVar);
        this.f33619b = bVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object b(com.sumsub.sns.internal.core.domain.k.a r6, kotlin.coroutines.c<? super com.sumsub.sns.internal.core.domain.model.a<? extends java.lang.Exception, com.sumsub.sns.internal.core.data.model.e>> r7) {
        /*
            r5 = this;
            boolean r6 = r7 instanceof com.sumsub.sns.internal.core.domain.k.b
            if (r6 == 0) goto L_0x0013
            r6 = r7
            com.sumsub.sns.internal.core.domain.k$b r6 = (com.sumsub.sns.internal.core.domain.k.b) r6
            int r0 = r6.f33623d
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r0 & r1
            if (r2 == 0) goto L_0x0013
            int r0 = r0 - r1
            r6.f33623d = r0
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.internal.core.domain.k$b r6 = new com.sumsub.sns.internal.core.domain.k$b
            r6.<init>(r5, r7)
        L_0x0018:
            java.lang.Object r7 = r6.f33621b
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r1 = r6.f33623d
            r2 = 0
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L_0x003f
            if (r1 == r4) goto L_0x0035
            if (r1 != r3) goto L_0x002d
            kotlin.k.b(r7)
            goto L_0x0066
        L_0x002d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0035:
            java.lang.Object r1 = r6.f33620a
            com.sumsub.sns.internal.core.domain.k r1 = (com.sumsub.sns.internal.core.domain.k) r1
            kotlin.k.b(r7)     // Catch:{ Exception -> 0x003d }
            goto L_0x0051
        L_0x003d:
            r7 = move-exception
            goto L_0x005b
        L_0x003f:
            kotlin.k.b(r7)
            com.sumsub.sns.internal.core.data.source.dynamic.b r7 = r5.f33619b     // Catch:{ Exception -> 0x0059 }
            r1 = 0
            r6.f33620a = r5     // Catch:{ Exception -> 0x0059 }
            r6.f33623d = r4     // Catch:{ Exception -> 0x0059 }
            java.lang.Object r7 = com.sumsub.sns.internal.core.data.source.dynamic.h.b(r7, r1, r6, r4, r2)     // Catch:{ Exception -> 0x0059 }
            if (r7 != r0) goto L_0x0050
            return r0
        L_0x0050:
            r1 = r5
        L_0x0051:
            com.sumsub.sns.internal.core.data.model.e r7 = (com.sumsub.sns.internal.core.data.model.e) r7     // Catch:{ Exception -> 0x003d }
            com.sumsub.sns.internal.core.domain.model.a$b r4 = new com.sumsub.sns.internal.core.domain.model.a$b     // Catch:{ Exception -> 0x003d }
            r4.<init>(r7)     // Catch:{ Exception -> 0x003d }
            return r4
        L_0x0059:
            r7 = move-exception
            r1 = r5
        L_0x005b:
            r6.f33620a = r2
            r6.f33623d = r3
            java.lang.Object r7 = r1.a((java.lang.Exception) r7, (kotlin.coroutines.c<? super java.lang.Exception>) r6)
            if (r7 != r0) goto L_0x0066
            return r0
        L_0x0066:
            com.sumsub.sns.internal.core.domain.model.a$a r6 = new com.sumsub.sns.internal.core.domain.model.a$a
            r6.<init>(r7)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.domain.k.b(com.sumsub.sns.internal.core.domain.k$a, kotlin.coroutines.c):java.lang.Object");
    }

    public k(com.sumsub.sns.internal.core.a aVar) {
        this(aVar.n(), aVar.p());
    }
}
