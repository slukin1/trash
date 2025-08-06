package com.sumsub.sns.internal.log.cacher;

import d10.p;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executors;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.k;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.f1;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.i;
import kotlinx.coroutines.i0;
import kotlinx.coroutines.n1;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final d f34872a = new d();

    /* renamed from: b  reason: collision with root package name */
    public static final h0 f34873b = i0.a(f1.b(Executors.newSingleThreadExecutor()));

    /* renamed from: c  reason: collision with root package name */
    public static final Set<b> f34874c = new LinkedHashSet();

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.log.cacher.SinkCache$flush$1", f = "SinkCache.kt", l = {135}, m = "invokeSuspend")
    public static final class a extends SuspendLambda implements p<h0, c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f34875a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f34876b;

        @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.internal.log.cacher.SinkCache$flush$1$1$1", f = "SinkCache.kt", l = {134}, m = "invokeSuspend")
        /* renamed from: com.sumsub.sns.internal.log.cacher.d$a$a  reason: collision with other inner class name */
        public static final class C0403a extends SuspendLambda implements p<h0, c<? super Unit>, Object> {

            /* renamed from: a  reason: collision with root package name */
            public int f34877a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ b f34878b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0403a(b bVar, c<? super C0403a> cVar) {
                super(2, cVar);
                this.f34878b = bVar;
            }

            /* renamed from: a */
            public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
                return ((C0403a) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
            }

            public final c<Unit> create(Object obj, c<?> cVar) {
                return new C0403a(this.f34878b, cVar);
            }

            public final Object invokeSuspend(Object obj) {
                Object d11 = IntrinsicsKt__IntrinsicsKt.d();
                int i11 = this.f34877a;
                if (i11 == 0) {
                    k.b(obj);
                    b bVar = this.f34878b;
                    this.f34877a = 1;
                    if (bVar.a(this) == d11) {
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

        public a(c<? super a> cVar) {
            super(2, cVar);
        }

        /* renamed from: a */
        public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
            return ((a) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final c<Unit> create(Object obj, c<?> cVar) {
            a aVar = new a(cVar);
            aVar.f34876b = obj;
            return aVar;
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f34875a;
            if (i11 == 0) {
                k.b(obj);
                h0 h0Var = (h0) this.f34876b;
                Set<b> a11 = d.f34874c;
                ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.u(a11, 10));
                for (b aVar : a11) {
                    arrayList.add(i.b(h0Var, (CoroutineContext) null, (CoroutineStart) null, new C0403a(aVar, (c<? super C0403a>) null), 3, (Object) null));
                }
                this.f34875a = 1;
                if (AwaitKt.a(arrayList, this) == d11) {
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

    public final boolean b(b bVar) {
        return f34874c.remove(bVar);
    }

    public final void c() {
        i0.f(f34873b, (CancellationException) null, 1, (Object) null);
    }

    public final boolean a(b bVar) {
        return f34874c.add(bVar);
    }

    public final void b() {
        n1 unused = i.d(f34873b, (CoroutineContext) null, (CoroutineStart) null, new a((c<? super a>) null), 3, (Object) null);
    }
}
