package com.sumsub.sns.internal.core.domain.base;

import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.d;

public abstract class b<Type, Params> {

    /* renamed from: a  reason: collision with root package name */
    public final com.sumsub.sns.internal.core.data.source.common.a f33516a;

    @d(c = "com.sumsub.sns.internal.core.domain.base.BaseUseCase", f = "BaseUseCase.kt", l = {12, 14}, m = "invoke$suspendImpl")
    public static final class a extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f33517a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f33518b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b<Type, Params> f33519c;

        /* renamed from: d  reason: collision with root package name */
        public int f33520d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(b<? extends Type, ? super Params> bVar, c<? super a> cVar) {
            super(cVar);
            this.f33519c = bVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f33518b = obj;
            this.f33520d |= Integer.MIN_VALUE;
            return b.a(this.f33519c, (Object) null, this);
        }
    }

    public b(com.sumsub.sns.internal.core.data.source.common.a aVar) {
        this.f33516a = aVar;
    }

    public Object a(Params params, c<? super com.sumsub.sns.internal.core.domain.model.a<? extends Exception, ? extends Type>> cVar) {
        return a(this, params, cVar);
    }

    public abstract Object b(Params params, c<? super com.sumsub.sns.internal.core.domain.model.a<? extends Exception, ? extends Type>> cVar);

    public final com.sumsub.sns.internal.core.data.source.common.a a() {
        return this.f33516a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ java.lang.Object a(com.sumsub.sns.internal.core.domain.base.b r5, java.lang.Object r6, kotlin.coroutines.c r7) {
        /*
            boolean r0 = r7 instanceof com.sumsub.sns.internal.core.domain.base.b.a
            if (r0 == 0) goto L_0x0013
            r0 = r7
            com.sumsub.sns.internal.core.domain.base.b$a r0 = (com.sumsub.sns.internal.core.domain.base.b.a) r0
            int r1 = r0.f33520d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f33520d = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.internal.core.domain.base.b$a r0 = new com.sumsub.sns.internal.core.domain.base.b$a
            r0.<init>(r5, r7)
        L_0x0018:
            java.lang.Object r7 = r0.f33518b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.f33520d
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x003c
            if (r2 == r4) goto L_0x0034
            if (r2 != r3) goto L_0x002c
            kotlin.k.b(r7)
            goto L_0x005a
        L_0x002c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0034:
            java.lang.Object r5 = r0.f33517a
            com.sumsub.sns.internal.core.domain.base.b r5 = (com.sumsub.sns.internal.core.domain.base.b) r5
            kotlin.k.b(r7)     // Catch:{ Exception -> 0x004d }
            goto L_0x004a
        L_0x003c:
            kotlin.k.b(r7)
            r0.f33517a = r5     // Catch:{ Exception -> 0x004d }
            r0.f33520d = r4     // Catch:{ Exception -> 0x004d }
            java.lang.Object r7 = r5.b(r6, r0)     // Catch:{ Exception -> 0x004d }
            if (r7 != r1) goto L_0x004a
            return r1
        L_0x004a:
            com.sumsub.sns.internal.core.domain.model.a r7 = (com.sumsub.sns.internal.core.domain.model.a) r7     // Catch:{ Exception -> 0x004d }
            goto L_0x0060
        L_0x004d:
            r6 = move-exception
            r7 = 0
            r0.f33517a = r7
            r0.f33520d = r3
            java.lang.Object r7 = r5.a((java.lang.Exception) r6, (kotlin.coroutines.c<? super java.lang.Exception>) r0)
            if (r7 != r1) goto L_0x005a
            return r1
        L_0x005a:
            com.sumsub.sns.internal.core.domain.model.a$a r5 = new com.sumsub.sns.internal.core.domain.model.a$a
            r5.<init>(r7)
            r7 = r5
        L_0x0060:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.domain.base.b.a(com.sumsub.sns.internal.core.domain.base.b, java.lang.Object, kotlin.coroutines.c):java.lang.Object");
    }

    public final Object a(Exception exc, c<? super Exception> cVar) {
        return d.a(this.f33516a, exc);
    }
}
