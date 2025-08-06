package com.sumsub.sns.internal.core.data.source.dynamic;

import com.sumsub.sns.internal.core.data.source.dynamic.e;
import d10.p;
import d10.q;
import kotlin.Unit;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.internal.r;
import kotlin.k;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.a1;
import kotlinx.coroutines.flow.f1;
import kotlinx.coroutines.flow.g1;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.i;
import kotlinx.coroutines.n1;

public final class a<T, P> {

    /* renamed from: a  reason: collision with root package name */
    public final h0 f33272a;

    /* renamed from: b  reason: collision with root package name */
    public final CoroutineDispatcher f33273b;

    /* renamed from: c  reason: collision with root package name */
    public final q<P, T, kotlin.coroutines.c<? super T>, Object> f33274c;

    /* renamed from: d  reason: collision with root package name */
    public final String f33275d;

    /* renamed from: e  reason: collision with root package name */
    public n1 f33276e;

    /* renamed from: f  reason: collision with root package name */
    public final a1<e<T>> f33277f;

    /* renamed from: g  reason: collision with root package name */
    public final f1<e<T>> f33278g;

    @d(c = "com.sumsub.sns.internal.core.data.source.dynamic.DataKeeper", f = "DataKeeper.kt", l = {31, 32}, m = "get")
    /* renamed from: com.sumsub.sns.internal.core.data.source.dynamic.a$a  reason: collision with other inner class name */
    public static final class C0363a extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f33279a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f33280b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a<T, P> f33281c;

        /* renamed from: d  reason: collision with root package name */
        public int f33282d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C0363a(a<T, P> aVar, kotlin.coroutines.c<? super C0363a> cVar) {
            super(cVar);
            this.f33281c = aVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f33280b = obj;
            this.f33282d |= Integer.MIN_VALUE;
            return this.f33281c.a(false, null, this);
        }
    }

    @d(c = "com.sumsub.sns.internal.core.data.source.dynamic.DataKeeper", f = "DataKeeper.kt", l = {42, 43}, m = "getAsResult")
    public static final class b extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f33283a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f33284b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a<T, P> f33285c;

        /* renamed from: d  reason: collision with root package name */
        public int f33286d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(a<T, P> aVar, kotlin.coroutines.c<? super b> cVar) {
            super(cVar);
            this.f33285c = aVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f33284b = obj;
            this.f33286d |= Integer.MIN_VALUE;
            return this.f33285c.b(false, null, this);
        }
    }

    @d(c = "com.sumsub.sns.internal.core.data.source.dynamic.DataKeeper$refreshInternal$1", f = "DataKeeper.kt", l = {62, 63, 67}, m = "invokeSuspend")
    public static final class c extends SuspendLambda implements p<h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public Object f33287a;

        /* renamed from: b  reason: collision with root package name */
        public int f33288b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ a<T, P> f33289c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ P f33290d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(a<T, P> aVar, P p11, kotlin.coroutines.c<? super c> cVar) {
            super(2, cVar);
            this.f33289c = aVar;
            this.f33290d = p11;
        }

        /* renamed from: a */
        public final Object invoke(h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((c) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new c(this.f33289c, this.f33290d, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object obj2;
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f33288b;
            if (i11 == 0) {
                k.b(obj);
                e eVar = (e) CollectionsKt___CollectionsKt.c0(this.f33289c.f33277f.a());
                obj2 = eVar != null ? eVar.d() : null;
                q b11 = this.f33289c.f33274c;
                P p11 = this.f33290d;
                this.f33287a = obj2;
                this.f33288b = 1;
                obj = b11.invoke(p11, obj2, this);
                if (obj == d11) {
                    return d11;
                }
            } else if (i11 == 1) {
                obj2 = this.f33287a;
                k.b(obj);
            } else if (i11 == 2) {
                obj2 = this.f33287a;
                try {
                    k.b(obj);
                    com.sumsub.sns.core.c.b(com.sumsub.sns.core.c.f30748a, this.f33289c.f33275d, "Updated", (Throwable) null, 4, (Object) null);
                } catch (Throwable th2) {
                    com.sumsub.sns.core.c cVar = com.sumsub.sns.core.c.f30748a;
                    String a11 = this.f33289c.f33275d;
                    com.sumsub.sns.core.c.a(cVar, a11, "updating failed: " + th2.getMessage(), (Throwable) null, 4, (Object) null);
                    a1 c11 = this.f33289c.f33277f;
                    e.c a12 = e.f33474a.a(obj2, th2);
                    this.f33287a = null;
                    this.f33288b = 3;
                    if (c11.emit(a12, this) == d11) {
                        return d11;
                    }
                }
                return Unit.f56620a;
            } else if (i11 == 3) {
                k.b(obj);
                return Unit.f56620a;
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            a1 c12 = this.f33289c.f33277f;
            e.d a13 = e.f33474a.a(obj);
            this.f33287a = obj2;
            this.f33288b = 2;
            if (c12.emit(a13, this) == d11) {
                return d11;
            }
            com.sumsub.sns.core.c.b(com.sumsub.sns.core.c.f30748a, this.f33289c.f33275d, "Updated", (Throwable) null, 4, (Object) null);
            return Unit.f56620a;
        }
    }

    public a(h0 h0Var, CoroutineDispatcher coroutineDispatcher, q<? super P, ? super T, ? super kotlin.coroutines.c<? super T>, ? extends Object> qVar, String str) {
        this.f33272a = h0Var;
        this.f33273b = coroutineDispatcher;
        this.f33274c = qVar;
        this.f33275d = str;
        a1<e<T>> b11 = g1.b(1, 0, (BufferOverflow) null, 6, (Object) null);
        this.f33277f = b11;
        this.f33278g = b11;
    }

    public final f1<e<T>> a() {
        return this.f33278g;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0074 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0075 A[PHI: r8 
      PHI: (r8v2 java.lang.Object) = (r8v3 java.lang.Object), (r8v1 java.lang.Object) binds: [B:29:0x0072, B:10:0x0028] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object b(boolean r6, P r7, kotlin.coroutines.c<? super com.sumsub.sns.internal.core.data.source.dynamic.e<T>> r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof com.sumsub.sns.internal.core.data.source.dynamic.a.b
            if (r0 == 0) goto L_0x0013
            r0 = r8
            com.sumsub.sns.internal.core.data.source.dynamic.a$b r0 = (com.sumsub.sns.internal.core.data.source.dynamic.a.b) r0
            int r1 = r0.f33286d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f33286d = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.internal.core.data.source.dynamic.a$b r0 = new com.sumsub.sns.internal.core.data.source.dynamic.a$b
            r0.<init>(r5, r8)
        L_0x0018:
            java.lang.Object r8 = r0.f33284b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.f33286d
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x003c
            if (r2 == r4) goto L_0x0034
            if (r2 != r3) goto L_0x002c
            kotlin.k.b(r8)
            goto L_0x0075
        L_0x002c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0034:
            java.lang.Object r6 = r0.f33283a
            com.sumsub.sns.internal.core.data.source.dynamic.a r6 = (com.sumsub.sns.internal.core.data.source.dynamic.a) r6
            kotlin.k.b(r8)
            goto L_0x0067
        L_0x003c:
            kotlin.k.b(r8)
            if (r6 != 0) goto L_0x005b
            kotlinx.coroutines.flow.a1<com.sumsub.sns.internal.core.data.source.dynamic.e<T>> r6 = r5.f33277f
            java.util.List r6 = r6.a()
            java.lang.Object r6 = kotlin.collections.CollectionsKt___CollectionsKt.c0(r6)
            com.sumsub.sns.internal.core.data.source.dynamic.e r6 = (com.sumsub.sns.internal.core.data.source.dynamic.e) r6
            if (r6 == 0) goto L_0x0057
            boolean r8 = r6.b()
            if (r8 != r4) goto L_0x0057
            r8 = r4
            goto L_0x0058
        L_0x0057:
            r8 = 0
        L_0x0058:
            if (r8 == 0) goto L_0x005b
            return r6
        L_0x005b:
            r0.f33283a = r5
            r0.f33286d = r4
            java.lang.Object r6 = r5.a(r7, r0)
            if (r6 != r1) goto L_0x0066
            return r1
        L_0x0066:
            r6 = r5
        L_0x0067:
            kotlinx.coroutines.flow.a1<com.sumsub.sns.internal.core.data.source.dynamic.e<T>> r6 = r6.f33277f
            r7 = 0
            r0.f33283a = r7
            r0.f33286d = r3
            java.lang.Object r8 = kotlinx.coroutines.flow.f.A(r6, r0)
            if (r8 != r1) goto L_0x0075
            return r1
        L_0x0075:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.data.source.dynamic.a.b(boolean, java.lang.Object, kotlin.coroutines.c):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0071 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(boolean r7, P r8, kotlin.coroutines.c<? super T> r9) {
        /*
            r6 = this;
            boolean r0 = r9 instanceof com.sumsub.sns.internal.core.data.source.dynamic.a.C0363a
            if (r0 == 0) goto L_0x0013
            r0 = r9
            com.sumsub.sns.internal.core.data.source.dynamic.a$a r0 = (com.sumsub.sns.internal.core.data.source.dynamic.a.C0363a) r0
            int r1 = r0.f33282d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f33282d = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.internal.core.data.source.dynamic.a$a r0 = new com.sumsub.sns.internal.core.data.source.dynamic.a$a
            r0.<init>(r6, r9)
        L_0x0018:
            java.lang.Object r9 = r0.f33280b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.f33282d
            r3 = 0
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x003d
            if (r2 == r5) goto L_0x0035
            if (r2 != r4) goto L_0x002d
            kotlin.k.b(r9)
            goto L_0x0072
        L_0x002d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0035:
            java.lang.Object r7 = r0.f33279a
            com.sumsub.sns.internal.core.data.source.dynamic.a r7 = (com.sumsub.sns.internal.core.data.source.dynamic.a) r7
            kotlin.k.b(r9)
            goto L_0x0065
        L_0x003d:
            kotlin.k.b(r9)
            if (r7 != 0) goto L_0x0059
            kotlinx.coroutines.flow.a1<com.sumsub.sns.internal.core.data.source.dynamic.e<T>> r7 = r6.f33277f
            java.util.List r7 = r7.a()
            java.lang.Object r7 = kotlin.collections.CollectionsKt___CollectionsKt.c0(r7)
            com.sumsub.sns.internal.core.data.source.dynamic.e r7 = (com.sumsub.sns.internal.core.data.source.dynamic.e) r7
            if (r7 == 0) goto L_0x0055
            java.lang.Object r7 = r7.d()
            goto L_0x0056
        L_0x0055:
            r7 = r3
        L_0x0056:
            if (r7 == 0) goto L_0x0059
            return r7
        L_0x0059:
            r0.f33279a = r6
            r0.f33282d = r5
            java.lang.Object r7 = r6.a(r8, r0)
            if (r7 != r1) goto L_0x0064
            return r1
        L_0x0064:
            r7 = r6
        L_0x0065:
            kotlinx.coroutines.flow.a1<com.sumsub.sns.internal.core.data.source.dynamic.e<T>> r7 = r7.f33277f
            r0.f33279a = r3
            r0.f33282d = r4
            java.lang.Object r9 = kotlinx.coroutines.flow.f.A(r7, r0)
            if (r9 != r1) goto L_0x0072
            return r1
        L_0x0072:
            com.sumsub.sns.internal.core.data.source.dynamic.e r9 = (com.sumsub.sns.internal.core.data.source.dynamic.e) r9
            java.lang.Object r7 = r9.e()
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.data.source.dynamic.a.a(boolean, java.lang.Object, kotlin.coroutines.c):java.lang.Object");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a(h0 h0Var, CoroutineDispatcher coroutineDispatcher, q qVar, String str, int i11, r rVar) {
        this(h0Var, coroutineDispatcher, qVar, (i11 & 8) != 0 ? "DataKeeper" : str);
    }

    public static /* synthetic */ Object b(a aVar, boolean z11, Object obj, kotlin.coroutines.c cVar, int i11, Object obj2) {
        if ((i11 & 2) != 0) {
            obj = null;
        }
        return aVar.b(z11, obj, cVar);
    }

    public static /* synthetic */ Object a(a aVar, boolean z11, Object obj, kotlin.coroutines.c cVar, int i11, Object obj2) {
        if ((i11 & 2) != 0) {
            obj = null;
        }
        return aVar.a(z11, obj, cVar);
    }

    public final boolean b() {
        return CollectionsKt___CollectionsKt.c0(this.f33277f.a()) != null;
    }

    public static /* synthetic */ Object a(a aVar, Object obj, kotlin.coroutines.c cVar, int i11, Object obj2) {
        if ((i11 & 1) != 0) {
            obj = null;
        }
        return aVar.a(obj, cVar);
    }

    public final Object b(T t11, kotlin.coroutines.c<? super Unit> cVar) {
        Object emit = this.f33277f.emit(e.f33474a.a(t11), cVar);
        return emit == IntrinsicsKt__IntrinsicsKt.d() ? emit : Unit.f56620a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0050  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(P r9, kotlin.coroutines.c<? super kotlin.Unit> r10) {
        /*
            r8 = this;
            kotlinx.coroutines.n1 r0 = r8.f33276e
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x000e
            boolean r0 = r0.isActive()
            if (r0 != r2) goto L_0x000e
            r0 = r2
            goto L_0x000f
        L_0x000e:
            r0 = r1
        L_0x000f:
            if (r0 != 0) goto L_0x0032
            kotlinx.coroutines.n1 r0 = r8.f33276e
            if (r0 == 0) goto L_0x001c
            boolean r0 = r0.a()
            if (r0 != 0) goto L_0x001c
            r1 = r2
        L_0x001c:
            if (r1 == 0) goto L_0x001f
            goto L_0x0032
        L_0x001f:
            com.sumsub.sns.core.c r2 = com.sumsub.sns.core.c.f30748a
            java.lang.String r3 = r8.f33275d
            r5 = 0
            r6 = 4
            r7 = 0
            java.lang.String r4 = "Updating ..."
            com.sumsub.sns.core.c.b(r2, r3, r4, r5, r6, r7)
            kotlinx.coroutines.n1 r9 = r8.a(r9)
            r8.f33276e = r9
            goto L_0x003e
        L_0x0032:
            com.sumsub.sns.core.c r0 = com.sumsub.sns.core.c.f30748a
            java.lang.String r1 = r8.f33275d
            r3 = 0
            r4 = 4
            r5 = 0
            java.lang.String r2 = "refresh: waiting for existing update job to finish"
            com.sumsub.sns.core.c.b(r0, r1, r2, r3, r4, r5)
        L_0x003e:
            kotlinx.coroutines.n1 r9 = r8.f33276e
            if (r9 == 0) goto L_0x0050
            java.lang.Object r9 = r9.F(r10)
            java.lang.Object r10 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            if (r9 != r10) goto L_0x004d
            return r9
        L_0x004d:
            kotlin.Unit r9 = kotlin.Unit.f56620a
            return r9
        L_0x0050:
            kotlin.Unit r9 = kotlin.Unit.f56620a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.data.source.dynamic.a.a(java.lang.Object, kotlin.coroutines.c):java.lang.Object");
    }

    public final n1 a(P p11) {
        return i.d(this.f33272a, this.f33273b, (CoroutineStart) null, new c(this, p11, (kotlin.coroutines.c<? super c>) null), 2, (Object) null);
    }

    public static /* synthetic */ n1 a(a aVar, Object obj, int i11, Object obj2) {
        if ((i11 & 1) != 0) {
            obj = null;
        }
        return aVar.a(obj);
    }

    public final Object a(kotlin.coroutines.c<? super Unit> cVar) {
        e eVar = (e) CollectionsKt___CollectionsKt.c0(this.f33277f.a());
        if (eVar != null && eVar.b()) {
            return Unit.f56620a;
        }
        Object a11 = a(this, (Object) null, cVar, 1, (Object) null);
        return a11 == IntrinsicsKt__IntrinsicsKt.d() ? a11 : Unit.f56620a;
    }
}
