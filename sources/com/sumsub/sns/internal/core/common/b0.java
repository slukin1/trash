package com.sumsub.sns.internal.core.common;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.RepeatOnLifecycleKt;
import androidx.lifecycle.v;
import d10.l;
import d10.p;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.u;
import kotlin.jvm.internal.x;
import kotlin.k;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.flow.b1;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.i;
import kotlinx.coroutines.n1;

public final class b0 {

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.core.common.LifecycleExtensionsKt$collectEvents$1", f = "LifecycleExtensions.kt", l = {17}, m = "invokeSuspend")
    public static final class a extends SuspendLambda implements p<h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f31967a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ LifecycleOwner f31968b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ kotlinx.coroutines.flow.d<T> f31969c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ p<T, kotlin.coroutines.c<? super Unit>, Object> f31970d;

        @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.core.common.LifecycleExtensionsKt$collectEvents$1$1", f = "LifecycleExtensions.kt", l = {18}, m = "invokeSuspend")
        /* renamed from: com.sumsub.sns.internal.core.common.b0$a$a  reason: collision with other inner class name */
        public static final class C0323a extends SuspendLambda implements p<h0, kotlin.coroutines.c<? super Unit>, Object> {

            /* renamed from: a  reason: collision with root package name */
            public int f31971a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ kotlinx.coroutines.flow.d<T> f31972b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ p<T, kotlin.coroutines.c<? super Unit>, Object> f31973c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0323a(kotlinx.coroutines.flow.d<? extends T> dVar, p<? super T, ? super kotlin.coroutines.c<? super Unit>, ? extends Object> pVar, kotlin.coroutines.c<? super C0323a> cVar) {
                super(2, cVar);
                this.f31972b = dVar;
                this.f31973c = pVar;
            }

            /* renamed from: a */
            public final Object invoke(h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
                return ((C0323a) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
            }

            public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
                return new C0323a(this.f31972b, this.f31973c, cVar);
            }

            public final Object invokeSuspend(Object obj) {
                Object d11 = IntrinsicsKt__IntrinsicsKt.d();
                int i11 = this.f31971a;
                if (i11 == 0) {
                    k.b(obj);
                    kotlinx.coroutines.flow.d<T> dVar = this.f31972b;
                    e eVar = new e(this.f31973c);
                    this.f31971a = 1;
                    if (dVar.collect(eVar, this) == d11) {
                        return d11;
                    }
                } else if (i11 == 1) {
                    k.b(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return Unit.f56620a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(LifecycleOwner lifecycleOwner, kotlinx.coroutines.flow.d<? extends T> dVar, p<? super T, ? super kotlin.coroutines.c<? super Unit>, ? extends Object> pVar, kotlin.coroutines.c<? super a> cVar) {
            super(2, cVar);
            this.f31968b = lifecycleOwner;
            this.f31969c = dVar;
            this.f31970d = pVar;
        }

        /* renamed from: a */
        public final Object invoke(h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((a) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new a(this.f31968b, this.f31969c, this.f31970d, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f31967a;
            if (i11 == 0) {
                k.b(obj);
                Lifecycle lifecycle = this.f31968b.getLifecycle();
                Lifecycle.State state = Lifecycle.State.STARTED;
                C0323a aVar = new C0323a(this.f31969c, this.f31970d, (kotlin.coroutines.c<? super C0323a>) null);
                this.f31967a = 1;
                if (RepeatOnLifecycleKt.a(lifecycle, state, aVar, this) == d11) {
                    return d11;
                }
            } else if (i11 == 1) {
                k.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.f56620a;
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.core.common.LifecycleExtensionsKt$collectIn$1", f = "LifecycleExtensions.kt", l = {33, 34}, m = "invokeSuspend")
    public static final class b extends SuspendLambda implements p<h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f31974a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ p<T, kotlin.coroutines.c<? super Unit>, Object> f31975b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ kotlinx.coroutines.flow.d<T> f31976c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(p<? super T, ? super kotlin.coroutines.c<? super Unit>, ? extends Object> pVar, kotlinx.coroutines.flow.d<? extends T> dVar, kotlin.coroutines.c<? super b> cVar) {
            super(2, cVar);
            this.f31975b = pVar;
            this.f31976c = dVar;
        }

        /* renamed from: a */
        public final Object invoke(h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((b) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new b(this.f31975b, this.f31976c, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f31974a;
            if (i11 == 0) {
                k.b(obj);
                p<T, kotlin.coroutines.c<? super Unit>, Object> pVar = this.f31975b;
                if (pVar == null) {
                    kotlinx.coroutines.flow.d<T> dVar = this.f31976c;
                    this.f31974a = 1;
                    if (kotlinx.coroutines.flow.f.h(dVar, this) == d11) {
                        return d11;
                    }
                } else {
                    kotlinx.coroutines.flow.d<T> dVar2 = this.f31976c;
                    e eVar = new e(pVar);
                    this.f31974a = 2;
                    if (dVar2.collect(eVar, this) == d11) {
                        return d11;
                    }
                }
            } else if (i11 == 1 || i11 == 2) {
                k.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.f56620a;
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.core.common.LifecycleExtensionsKt$collectLatestIn$1", f = "LifecycleExtensions.kt", l = {40}, m = "invokeSuspend")
    public static final class c extends SuspendLambda implements p<h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f31977a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ kotlinx.coroutines.flow.d<T> f31978b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ p<T, kotlin.coroutines.c<? super Unit>, Object> f31979c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(kotlinx.coroutines.flow.d<? extends T> dVar, p<? super T, ? super kotlin.coroutines.c<? super Unit>, ? extends Object> pVar, kotlin.coroutines.c<? super c> cVar) {
            super(2, cVar);
            this.f31978b = dVar;
            this.f31979c = pVar;
        }

        /* renamed from: a */
        public final Object invoke(h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((c) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new c(this.f31978b, this.f31979c, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f31977a;
            if (i11 == 0) {
                k.b(obj);
                kotlinx.coroutines.flow.d<T> dVar = this.f31978b;
                p<T, kotlin.coroutines.c<? super Unit>, Object> pVar = this.f31979c;
                this.f31977a = 1;
                if (kotlinx.coroutines.flow.f.i(dVar, pVar, this) == d11) {
                    return d11;
                }
            } else if (i11 == 1) {
                k.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.f56620a;
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.core.common.LifecycleExtensionsKt$collectState$1", f = "LifecycleExtensions.kt", l = {25}, m = "invokeSuspend")
    public static final class d extends SuspendLambda implements p<h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f31980a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ LifecycleOwner f31981b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ kotlinx.coroutines.flow.d<T> f31982c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ p<T, kotlin.coroutines.c<? super Unit>, Object> f31983d;

        @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.core.common.LifecycleExtensionsKt$collectState$1$1", f = "LifecycleExtensions.kt", l = {26}, m = "invokeSuspend")
        public static final class a extends SuspendLambda implements p<h0, kotlin.coroutines.c<? super Unit>, Object> {

            /* renamed from: a  reason: collision with root package name */
            public int f31984a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ kotlinx.coroutines.flow.d<T> f31985b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ p<T, kotlin.coroutines.c<? super Unit>, Object> f31986c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(kotlinx.coroutines.flow.d<? extends T> dVar, p<? super T, ? super kotlin.coroutines.c<? super Unit>, ? extends Object> pVar, kotlin.coroutines.c<? super a> cVar) {
                super(2, cVar);
                this.f31985b = dVar;
                this.f31986c = pVar;
            }

            /* renamed from: a */
            public final Object invoke(h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
                return ((a) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
            }

            public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
                return new a(this.f31985b, this.f31986c, cVar);
            }

            public final Object invokeSuspend(Object obj) {
                Object d11 = IntrinsicsKt__IntrinsicsKt.d();
                int i11 = this.f31984a;
                if (i11 == 0) {
                    k.b(obj);
                    kotlinx.coroutines.flow.d<T> dVar = this.f31985b;
                    p<T, kotlin.coroutines.c<? super Unit>, Object> pVar = this.f31986c;
                    this.f31984a = 1;
                    if (kotlinx.coroutines.flow.f.i(dVar, pVar, this) == d11) {
                        return d11;
                    }
                } else if (i11 == 1) {
                    k.b(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return Unit.f56620a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(LifecycleOwner lifecycleOwner, kotlinx.coroutines.flow.d<? extends T> dVar, p<? super T, ? super kotlin.coroutines.c<? super Unit>, ? extends Object> pVar, kotlin.coroutines.c<? super d> cVar) {
            super(2, cVar);
            this.f31981b = lifecycleOwner;
            this.f31982c = dVar;
            this.f31983d = pVar;
        }

        /* renamed from: a */
        public final Object invoke(h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((d) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new d(this.f31981b, this.f31982c, this.f31983d, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f31980a;
            if (i11 == 0) {
                k.b(obj);
                Lifecycle lifecycle = this.f31981b.getLifecycle();
                Lifecycle.State state = Lifecycle.State.STARTED;
                a aVar = new a(this.f31982c, this.f31983d, (kotlin.coroutines.c<? super a>) null);
                this.f31980a = 1;
                if (RepeatOnLifecycleKt.a(lifecycle, state, aVar, this) == d11) {
                    return d11;
                }
            } else if (i11 == 1) {
                k.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.f56620a;
        }
    }

    public static final class e implements kotlinx.coroutines.flow.e, u {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ p<Object, kotlin.coroutines.c<Object>, Object> f31987a;

        public e(p<Object, ? super kotlin.coroutines.c<Object>, ? extends Object> pVar) {
            this.f31987a = pVar;
        }

        public final /* synthetic */ Object emit(Object obj, kotlin.coroutines.c cVar) {
            Object invoke = this.f31987a.invoke(obj, cVar);
            return invoke == IntrinsicsKt__IntrinsicsKt.d() ? invoke : Unit.f56620a;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof kotlinx.coroutines.flow.e) || !(obj instanceof u)) {
                return false;
            }
            return x.b(getFunctionDelegate(), ((u) obj).getFunctionDelegate());
        }

        public final kotlin.f<?> getFunctionDelegate() {
            return this.f31987a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.core.common.LifecycleExtensionsKt$updateStateIn$1", f = "LifecycleExtensions.kt", l = {50}, m = "invokeSuspend")
    public static final class f extends SuspendLambda implements p<h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public Object f31988a;

        /* renamed from: b  reason: collision with root package name */
        public int f31989b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b1<T> f31990c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ p<T, kotlin.coroutines.c<? super T>, Object> f31991d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(b1<T> b1Var, p<? super T, ? super kotlin.coroutines.c<? super T>, ? extends Object> pVar, kotlin.coroutines.c<? super f> cVar) {
            super(2, cVar);
            this.f31990c = b1Var;
            this.f31991d = pVar;
        }

        /* renamed from: a */
        public final Object invoke(h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((f) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new f(this.f31990c, this.f31991d, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            b1<T> b1Var;
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f31989b;
            if (i11 == 0) {
                k.b(obj);
                b1<T> b1Var2 = this.f31990c;
                p<T, kotlin.coroutines.c<? super T>, Object> pVar = this.f31991d;
                T value = b1Var2.getValue();
                this.f31988a = b1Var2;
                this.f31989b = 1;
                Object invoke = pVar.invoke(value, this);
                if (invoke == d11) {
                    return d11;
                }
                b1Var = b1Var2;
                obj = invoke;
            } else if (i11 == 1) {
                b1Var = (b1) this.f31988a;
                k.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            b1Var.setValue(obj);
            return Unit.f56620a;
        }
    }

    public static final <T> void a(kotlinx.coroutines.flow.d<? extends T> dVar, LifecycleOwner lifecycleOwner, p<? super T, ? super kotlin.coroutines.c<? super Unit>, ? extends Object> pVar) {
        n1 unused = i.d(v.a(lifecycleOwner), (CoroutineContext) null, (CoroutineStart) null, new a(lifecycleOwner, dVar, pVar, (kotlin.coroutines.c<? super a>) null), 3, (Object) null);
    }

    public static final <T> n1 b(kotlinx.coroutines.flow.d<? extends T> dVar, LifecycleOwner lifecycleOwner, p<? super T, ? super kotlin.coroutines.c<? super Unit>, ? extends Object> pVar) {
        return i.d(v.a(lifecycleOwner), (CoroutineContext) null, (CoroutineStart) null, new d(lifecycleOwner, dVar, pVar, (kotlin.coroutines.c<? super d>) null), 3, (Object) null);
    }

    public static /* synthetic */ void a(kotlinx.coroutines.flow.d dVar, h0 h0Var, p pVar, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            pVar = null;
        }
        a(dVar, h0Var, pVar);
    }

    public static final <T> void b(kotlinx.coroutines.flow.d<? extends T> dVar, h0 h0Var, p<? super T, ? super kotlin.coroutines.c<? super Unit>, ? extends Object> pVar) {
        n1 unused = i.d(h0Var, (CoroutineContext) null, (CoroutineStart) null, new c(dVar, pVar, (kotlin.coroutines.c<? super c>) null), 3, (Object) null);
    }

    public static final <T> void a(kotlinx.coroutines.flow.d<? extends T> dVar, h0 h0Var, p<? super T, ? super kotlin.coroutines.c<? super Unit>, ? extends Object> pVar) {
        n1 unused = i.d(h0Var, (CoroutineContext) null, (CoroutineStart) null, new b(pVar, dVar, (kotlin.coroutines.c<? super b>) null), 3, (Object) null);
    }

    public static final <T> void a(b1<T> b1Var, l<? super T, ? extends T> lVar) {
        b1Var.setValue(lVar.invoke(b1Var.getValue()));
    }

    public static final <T> void a(b1<T> b1Var, h0 h0Var, p<? super T, ? super kotlin.coroutines.c<? super T>, ? extends Object> pVar) {
        n1 unused = i.d(h0Var, (CoroutineContext) null, (CoroutineStart) null, new f(b1Var, pVar, (kotlin.coroutines.c<? super f>) null), 3, (Object) null);
    }
}
