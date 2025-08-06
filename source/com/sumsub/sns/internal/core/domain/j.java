package com.sumsub.sns.internal.core.domain;

import com.sumsub.sns.internal.core.data.model.g;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.internal.r;

public final class j extends com.sumsub.sns.internal.core.domain.base.b<g, a> {

    /* renamed from: b  reason: collision with root package name */
    public final com.sumsub.sns.internal.core.data.source.dynamic.b f33613b;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final boolean f33614a;

        public a() {
            this(false, 1, (r) null);
        }

        public final boolean a() {
            return this.f33614a;
        }

        public a(boolean z11) {
            this.f33614a = z11;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ a(boolean z11, int i11, r rVar) {
            this((i11 & 1) != 0 ? false : z11);
        }
    }

    @d(c = "com.sumsub.sns.internal.core.domain.GetApplicantUseCase", f = "GetApplicantUseCase.kt", l = {23, 26}, m = "run")
    public static final class b extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f33615a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f33616b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ j f33617c;

        /* renamed from: d  reason: collision with root package name */
        public int f33618d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(j jVar, c<? super b> cVar) {
            super(cVar);
            this.f33617c = jVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f33616b = obj;
            this.f33618d |= Integer.MIN_VALUE;
            return this.f33617c.b((a) null, this);
        }
    }

    public j(com.sumsub.sns.internal.core.data.source.common.a aVar, com.sumsub.sns.internal.core.data.source.dynamic.b bVar) {
        super(aVar);
        this.f33613b = bVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object b(com.sumsub.sns.internal.core.domain.j.a r10, kotlin.coroutines.c<? super com.sumsub.sns.internal.core.domain.model.a<? extends java.lang.Exception, com.sumsub.sns.internal.core.data.model.g>> r11) {
        /*
            r9 = this;
            boolean r0 = r11 instanceof com.sumsub.sns.internal.core.domain.j.b
            if (r0 == 0) goto L_0x0013
            r0 = r11
            com.sumsub.sns.internal.core.domain.j$b r0 = (com.sumsub.sns.internal.core.domain.j.b) r0
            int r1 = r0.f33618d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f33618d = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.internal.core.domain.j$b r0 = new com.sumsub.sns.internal.core.domain.j$b
            r0.<init>(r9, r11)
        L_0x0018:
            java.lang.Object r11 = r0.f33616b
            java.lang.Object r7 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r1 = r0.f33618d
            r8 = 2
            r2 = 1
            if (r1 == 0) goto L_0x003e
            if (r1 == r2) goto L_0x0034
            if (r1 != r8) goto L_0x002c
            kotlin.k.b(r11)
            goto L_0x006e
        L_0x002c:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L_0x0034:
            java.lang.Object r10 = r0.f33615a
            com.sumsub.sns.internal.core.domain.j r10 = (com.sumsub.sns.internal.core.domain.j) r10
            kotlin.k.b(r11)     // Catch:{ Exception -> 0x003c }
            goto L_0x0058
        L_0x003c:
            r11 = move-exception
            goto L_0x0062
        L_0x003e:
            kotlin.k.b(r11)
            com.sumsub.sns.internal.core.data.source.dynamic.b r1 = r9.f33613b     // Catch:{ Exception -> 0x0060 }
            r11 = 0
            boolean r3 = r10.a()     // Catch:{ Exception -> 0x0060 }
            r5 = 1
            r6 = 0
            r0.f33615a = r9     // Catch:{ Exception -> 0x0060 }
            r0.f33618d = r2     // Catch:{ Exception -> 0x0060 }
            r2 = r11
            r4 = r0
            java.lang.Object r11 = com.sumsub.sns.internal.core.data.source.dynamic.h.e(r1, r2, r3, r4, r5, r6)     // Catch:{ Exception -> 0x0060 }
            if (r11 != r7) goto L_0x0057
            return r7
        L_0x0057:
            r10 = r9
        L_0x0058:
            com.sumsub.sns.internal.core.data.model.g r11 = (com.sumsub.sns.internal.core.data.model.g) r11     // Catch:{ Exception -> 0x003c }
            com.sumsub.sns.internal.core.domain.model.a$b r1 = new com.sumsub.sns.internal.core.domain.model.a$b     // Catch:{ Exception -> 0x003c }
            r1.<init>(r11)     // Catch:{ Exception -> 0x003c }
            return r1
        L_0x0060:
            r11 = move-exception
            r10 = r9
        L_0x0062:
            r1 = 0
            r0.f33615a = r1
            r0.f33618d = r8
            java.lang.Object r11 = r10.a((java.lang.Exception) r11, (kotlin.coroutines.c<? super java.lang.Exception>) r0)
            if (r11 != r7) goto L_0x006e
            return r7
        L_0x006e:
            com.sumsub.sns.internal.core.domain.model.a$a r10 = new com.sumsub.sns.internal.core.domain.model.a$a
            r10.<init>(r11)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.domain.j.b(com.sumsub.sns.internal.core.domain.j$a, kotlin.coroutines.c):java.lang.Object");
    }

    public j(com.sumsub.sns.internal.core.a aVar) {
        this(aVar.n(), aVar.p());
    }
}
