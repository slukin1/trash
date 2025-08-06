package com.sumsub.sns.internal.core.data.source.dynamic;

import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.d;

public final class g {

    @d(c = "com.sumsub.sns.internal.core.data.source.dynamic.SuspendableFlowKt", f = "SuspendableFlow.kt", l = {56}, m = "resumeAll")
    public static final class a extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f33492a;

        /* renamed from: b  reason: collision with root package name */
        public int f33493b;

        /* renamed from: c  reason: collision with root package name */
        public int f33494c;

        /* renamed from: d  reason: collision with root package name */
        public /* synthetic */ Object f33495d;

        /* renamed from: e  reason: collision with root package name */
        public int f33496e;

        public a(c<? super a> cVar) {
            super(cVar);
        }

        public final Object invokeSuspend(Object obj) {
            this.f33495d = obj;
            this.f33496e |= Integer.MIN_VALUE;
            return g.a((f<?>[]) null, this);
        }
    }

    @d(c = "com.sumsub.sns.internal.core.data.source.dynamic.SuspendableFlowKt", f = "SuspendableFlow.kt", l = {52}, m = "suspendAll")
    public static final class b extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f33497a;

        /* renamed from: b  reason: collision with root package name */
        public int f33498b;

        /* renamed from: c  reason: collision with root package name */
        public int f33499c;

        /* renamed from: d  reason: collision with root package name */
        public /* synthetic */ Object f33500d;

        /* renamed from: e  reason: collision with root package name */
        public int f33501e;

        public b(c<? super b> cVar) {
            super(cVar);
        }

        public final Object invokeSuspend(Object obj) {
            this.f33500d = obj;
            this.f33501e |= Integer.MIN_VALUE;
            return g.b((f<?>[]) null, this);
        }
    }

    public static final <T> f<T> a(kotlinx.coroutines.flow.d<? extends T> dVar) {
        return new f<>(dVar);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object b(com.sumsub.sns.internal.core.data.source.dynamic.f<?>[] r6, kotlin.coroutines.c<? super kotlin.Unit> r7) {
        /*
            boolean r0 = r7 instanceof com.sumsub.sns.internal.core.data.source.dynamic.g.b
            if (r0 == 0) goto L_0x0013
            r0 = r7
            com.sumsub.sns.internal.core.data.source.dynamic.g$b r0 = (com.sumsub.sns.internal.core.data.source.dynamic.g.b) r0
            int r1 = r0.f33501e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f33501e = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.internal.core.data.source.dynamic.g$b r0 = new com.sumsub.sns.internal.core.data.source.dynamic.g$b
            r0.<init>(r7)
        L_0x0018:
            java.lang.Object r7 = r0.f33500d
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.f33501e
            r3 = 1
            if (r2 == 0) goto L_0x003a
            if (r2 != r3) goto L_0x0032
            int r6 = r0.f33499c
            int r2 = r0.f33498b
            java.lang.Object r4 = r0.f33497a
            com.sumsub.sns.internal.core.data.source.dynamic.f[] r4 = (com.sumsub.sns.internal.core.data.source.dynamic.f[]) r4
            kotlin.k.b(r7)
            r7 = r4
            goto L_0x0056
        L_0x0032:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x003a:
            kotlin.k.b(r7)
            r7 = 0
            int r2 = r6.length
            r5 = r7
            r7 = r6
            r6 = r2
            r2 = r5
        L_0x0043:
            if (r2 >= r6) goto L_0x0058
            r4 = r7[r2]
            r0.f33497a = r7
            r0.f33498b = r2
            r0.f33499c = r6
            r0.f33501e = r3
            java.lang.Object r4 = r4.b(r0)
            if (r4 != r1) goto L_0x0056
            return r1
        L_0x0056:
            int r2 = r2 + r3
            goto L_0x0043
        L_0x0058:
            kotlin.Unit r6 = kotlin.Unit.f56620a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.data.source.dynamic.g.b(com.sumsub.sns.internal.core.data.source.dynamic.f[], kotlin.coroutines.c):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object a(com.sumsub.sns.internal.core.data.source.dynamic.f<?>[] r6, kotlin.coroutines.c<? super kotlin.Unit> r7) {
        /*
            boolean r0 = r7 instanceof com.sumsub.sns.internal.core.data.source.dynamic.g.a
            if (r0 == 0) goto L_0x0013
            r0 = r7
            com.sumsub.sns.internal.core.data.source.dynamic.g$a r0 = (com.sumsub.sns.internal.core.data.source.dynamic.g.a) r0
            int r1 = r0.f33496e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f33496e = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.internal.core.data.source.dynamic.g$a r0 = new com.sumsub.sns.internal.core.data.source.dynamic.g$a
            r0.<init>(r7)
        L_0x0018:
            java.lang.Object r7 = r0.f33495d
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.f33496e
            r3 = 1
            if (r2 == 0) goto L_0x003a
            if (r2 != r3) goto L_0x0032
            int r6 = r0.f33494c
            int r2 = r0.f33493b
            java.lang.Object r4 = r0.f33492a
            com.sumsub.sns.internal.core.data.source.dynamic.f[] r4 = (com.sumsub.sns.internal.core.data.source.dynamic.f[]) r4
            kotlin.k.b(r7)
            r7 = r4
            goto L_0x0056
        L_0x0032:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x003a:
            kotlin.k.b(r7)
            r7 = 0
            int r2 = r6.length
            r5 = r7
            r7 = r6
            r6 = r2
            r2 = r5
        L_0x0043:
            if (r2 >= r6) goto L_0x0058
            r4 = r7[r2]
            r0.f33492a = r7
            r0.f33493b = r2
            r0.f33494c = r6
            r0.f33496e = r3
            java.lang.Object r4 = r4.a((kotlin.coroutines.c<? super kotlin.Unit>) r0)
            if (r4 != r1) goto L_0x0056
            return r1
        L_0x0056:
            int r2 = r2 + r3
            goto L_0x0043
        L_0x0058:
            kotlin.Unit r6 = kotlin.Unit.f56620a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.data.source.dynamic.g.a(com.sumsub.sns.internal.core.data.source.dynamic.f[], kotlin.coroutines.c):java.lang.Object");
    }
}
