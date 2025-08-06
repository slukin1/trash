package com.sumsub.sns.internal.core.data.source.dynamic;

import d10.p;
import d10.q;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.k;
import kotlinx.coroutines.flow.AbstractFlow;
import kotlinx.coroutines.flow.b1;
import kotlinx.coroutines.flow.d;
import kotlinx.coroutines.flow.e;
import kotlinx.coroutines.flow.k1;

public final class f<T> extends AbstractFlow<T> {

    /* renamed from: a  reason: collision with root package name */
    public final d<T> f33478a;

    /* renamed from: b  reason: collision with root package name */
    public final b1<Boolean> f33479b = k1.a(Boolean.FALSE);

    /* renamed from: c  reason: collision with root package name */
    public final AtomicInteger f33480c = new AtomicInteger(0);

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.core.data.source.dynamic.SuspendableFlow$collectSafely$2", f = "SuspendableFlow.kt", l = {43, 44}, m = "invokeSuspend")
    public static final class a extends SuspendLambda implements q<e<? super T>, T, c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f33481a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f33482b;

        /* renamed from: c  reason: collision with root package name */
        public /* synthetic */ Object f33483c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ f<T> f33484d;

        @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.core.data.source.dynamic.SuspendableFlow$collectSafely$2$1", f = "SuspendableFlow.kt", l = {}, m = "invokeSuspend")
        /* renamed from: com.sumsub.sns.internal.core.data.source.dynamic.f$a$a  reason: collision with other inner class name */
        public static final class C0369a extends SuspendLambda implements p<Boolean, c<? super Boolean>, Object> {

            /* renamed from: a  reason: collision with root package name */
            public int f33485a;

            /* renamed from: b  reason: collision with root package name */
            public /* synthetic */ boolean f33486b;

            public C0369a(c<? super C0369a> cVar) {
                super(2, cVar);
            }

            public final Object a(boolean z11, c<? super Boolean> cVar) {
                return ((C0369a) create(Boolean.valueOf(z11), cVar)).invokeSuspend(Unit.f56620a);
            }

            public final c<Unit> create(Object obj, c<?> cVar) {
                C0369a aVar = new C0369a(cVar);
                aVar.f33486b = ((Boolean) obj).booleanValue();
                return aVar;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return a(((Boolean) obj).booleanValue(), (c) obj2);
            }

            public final Object invokeSuspend(Object obj) {
                Object unused = IntrinsicsKt__IntrinsicsKt.d();
                if (this.f33485a == 0) {
                    k.b(obj);
                    return kotlin.coroutines.jvm.internal.a.a(!this.f33486b);
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(f<T> fVar, c<? super a> cVar) {
            super(3, cVar);
            this.f33484d = fVar;
        }

        /* renamed from: a */
        public final Object invoke(e<? super T> eVar, T t11, c<? super Unit> cVar) {
            a aVar = new a(this.f33484d, cVar);
            aVar.f33482b = eVar;
            aVar.f33483c = t11;
            return aVar.invokeSuspend(Unit.f56620a);
        }

        public final Object invokeSuspend(Object obj) {
            e eVar;
            Object obj2;
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f33481a;
            if (i11 == 0) {
                k.b(obj);
                e eVar2 = (e) this.f33482b;
                obj2 = this.f33483c;
                b1 a11 = this.f33484d.f33479b;
                C0369a aVar = new C0369a((c<? super C0369a>) null);
                this.f33482b = eVar2;
                this.f33483c = obj2;
                this.f33481a = 1;
                if (kotlinx.coroutines.flow.f.z(a11, aVar, this) == d11) {
                    return d11;
                }
                eVar = eVar2;
            } else if (i11 == 1) {
                obj2 = this.f33483c;
                eVar = (e) this.f33482b;
                k.b(obj);
            } else if (i11 == 2) {
                k.b(obj);
                return Unit.f56620a;
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            this.f33482b = null;
            this.f33483c = null;
            this.f33481a = 2;
            if (eVar.emit(obj2, this) == d11) {
                return d11;
            }
            return Unit.f56620a;
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.core.data.source.dynamic.SuspendableFlow", f = "SuspendableFlow.kt", l = {29, 33}, m = "resume")
    public static final class b extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        public Object f33487a;

        /* renamed from: b  reason: collision with root package name */
        public int f33488b;

        /* renamed from: c  reason: collision with root package name */
        public /* synthetic */ Object f33489c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ f<T> f33490d;

        /* renamed from: e  reason: collision with root package name */
        public int f33491e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(f<T> fVar, c<? super b> cVar) {
            super(cVar);
            this.f33490d = fVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.f33489c = obj;
            this.f33491e |= Integer.MIN_VALUE;
            return this.f33490d.a((c<? super Unit>) this);
        }
    }

    public f(d<? extends T> dVar) {
        this.f33478a = dVar;
    }

    public final Object b(c<? super Unit> cVar) {
        int incrementAndGet = this.f33480c.incrementAndGet();
        com.sumsub.sns.internal.log.a aVar = com.sumsub.sns.internal.log.a.f34862a;
        String a11 = com.sumsub.sns.internal.log.c.a(this);
        com.sumsub.log.logger.a.c(aVar, a11, "Suspendable flow suspend, value = " + incrementAndGet, (Throwable) null, 4, (Object) null);
        Object emit = this.f33479b.emit(kotlin.coroutines.jvm.internal.a.a(true), cVar);
        return emit == IntrinsicsKt__IntrinsicsKt.d() ? emit : Unit.f56620a;
    }

    public Object collectSafely(e<? super T> eVar, c<? super Unit> cVar) {
        Object collect = kotlinx.coroutines.flow.f.c0(this.f33478a, new a(this, (c<? super a>) null)).collect(eVar, cVar);
        return collect == IntrinsicsKt__IntrinsicsKt.d() ? collect : Unit.f56620a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(kotlin.coroutines.c<? super kotlin.Unit> r12) {
        /*
            r11 = this;
            boolean r0 = r12 instanceof com.sumsub.sns.internal.core.data.source.dynamic.f.b
            if (r0 == 0) goto L_0x0013
            r0 = r12
            com.sumsub.sns.internal.core.data.source.dynamic.f$b r0 = (com.sumsub.sns.internal.core.data.source.dynamic.f.b) r0
            int r1 = r0.f33491e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f33491e = r1
            goto L_0x0018
        L_0x0013:
            com.sumsub.sns.internal.core.data.source.dynamic.f$b r0 = new com.sumsub.sns.internal.core.data.source.dynamic.f$b
            r0.<init>(r11, r12)
        L_0x0018:
            java.lang.Object r12 = r0.f33489c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.f33491e
            r3 = 0
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x0043
            if (r2 == r5) goto L_0x003b
            if (r2 != r4) goto L_0x0033
            int r1 = r0.f33488b
            java.lang.Object r0 = r0.f33487a
            com.sumsub.sns.internal.core.data.source.dynamic.f r0 = (com.sumsub.sns.internal.core.data.source.dynamic.f) r0
            kotlin.k.b(r12)
            goto L_0x008e
        L_0x0033:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L_0x003b:
            java.lang.Object r2 = r0.f33487a
            com.sumsub.sns.internal.core.data.source.dynamic.f r2 = (com.sumsub.sns.internal.core.data.source.dynamic.f) r2
            kotlin.k.b(r12)
            goto L_0x0054
        L_0x0043:
            kotlin.k.b(r12)
            r0.f33487a = r11
            r0.f33491e = r5
            r5 = 100
            java.lang.Object r12 = kotlinx.coroutines.DelayKt.b(r5, r0)
            if (r12 != r1) goto L_0x0053
            return r1
        L_0x0053:
            r2 = r11
        L_0x0054:
            java.util.concurrent.atomic.AtomicInteger r12 = r2.f33480c
            int r12 = r12.decrementAndGet()
            com.sumsub.sns.internal.log.a r5 = com.sumsub.sns.internal.log.a.f34862a
            java.lang.String r6 = com.sumsub.sns.internal.log.c.a(r2)
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "Suspendable flow resume, value = "
            r7.append(r8)
            r7.append(r12)
            java.lang.String r7 = r7.toString()
            r8 = 0
            r9 = 4
            r10 = 0
            com.sumsub.log.logger.a.c(r5, r6, r7, r8, r9, r10)
            if (r12 > 0) goto L_0x008c
            kotlinx.coroutines.flow.b1<java.lang.Boolean> r5 = r2.f33479b
            java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.a.a(r3)
            r0.f33487a = r2
            r0.f33488b = r12
            r0.f33491e = r4
            java.lang.Object r0 = r5.emit(r6, r0)
            if (r0 != r1) goto L_0x008c
            return r1
        L_0x008c:
            r1 = r12
            r0 = r2
        L_0x008e:
            if (r1 >= 0) goto L_0x0095
            java.util.concurrent.atomic.AtomicInteger r12 = r0.f33480c
            r12.set(r3)
        L_0x0095:
            kotlin.Unit r12 = kotlin.Unit.f56620a
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.data.source.dynamic.f.a(kotlin.coroutines.c):java.lang.Object");
    }
}
