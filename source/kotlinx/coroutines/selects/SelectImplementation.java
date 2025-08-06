package kotlinx.coroutines.selects;

import d10.l;
import d10.p;
import d10.q;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.f;
import kotlin.jvm.internal.x;
import kotlinx.coroutines.CancelHandler;
import kotlinx.coroutines.internal.z;
import kotlinx.coroutines.j0;
import kotlinx.coroutines.k;
import kotlinx.coroutines.x0;

public class SelectImplementation<R> extends CancelHandler implements b<R>, l<R> {

    /* renamed from: g  reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f57503g = AtomicReferenceFieldUpdater.newUpdater(SelectImplementation.class, Object.class, "state");

    /* renamed from: b  reason: collision with root package name */
    public final CoroutineContext f57504b;

    /* renamed from: c  reason: collision with root package name */
    public List<SelectImplementation<R>.a> f57505c = new ArrayList(2);

    /* renamed from: d  reason: collision with root package name */
    public Object f57506d;

    /* renamed from: e  reason: collision with root package name */
    public int f57507e = -1;

    /* renamed from: f  reason: collision with root package name */
    public Object f57508f = SelectKt.f57522e;
    private volatile Object state = SelectKt.f57519b;

    public final class a {

        /* renamed from: a  reason: collision with root package name */
        public final Object f57509a;

        /* renamed from: b  reason: collision with root package name */
        public final q<Object, k<?>, Object, Unit> f57510b;

        /* renamed from: c  reason: collision with root package name */
        public final q<Object, Object, Object, Object> f57511c;

        /* renamed from: d  reason: collision with root package name */
        public final Object f57512d;

        /* renamed from: e  reason: collision with root package name */
        public final Object f57513e;

        /* renamed from: f  reason: collision with root package name */
        public final q<k<?>, Object, Object, l<Throwable, Unit>> f57514f;

        /* renamed from: g  reason: collision with root package name */
        public Object f57515g;

        /* renamed from: h  reason: collision with root package name */
        public int f57516h = -1;

        public a(Object obj, q<Object, ? super k<?>, Object, Unit> qVar, q<Object, Object, Object, ? extends Object> qVar2, Object obj2, Object obj3, q<? super k<?>, Object, Object, ? extends l<? super Throwable, Unit>> qVar3) {
            this.f57509a = obj;
            this.f57510b = qVar;
            this.f57511c = qVar2;
            this.f57512d = obj2;
            this.f57513e = obj3;
            this.f57514f = qVar3;
        }

        public final l<Throwable, Unit> a(k<?> kVar, Object obj) {
            q<k<?>, Object, Object, l<Throwable, Unit>> qVar = this.f57514f;
            if (qVar != null) {
                return qVar.invoke(kVar, this.f57512d, obj);
            }
            return null;
        }

        public final void b() {
            Object obj = this.f57515g;
            SelectImplementation<R> selectImplementation = SelectImplementation.this;
            x0 x0Var = null;
            if (obj instanceof z) {
                ((z) obj).o(this.f57516h, (Throwable) null, selectImplementation.getContext());
                return;
            }
            if (obj instanceof x0) {
                x0Var = (x0) obj;
            }
            if (x0Var != null) {
                x0Var.dispose();
            }
        }

        public final Object c(Object obj, c<? super R> cVar) {
            Object obj2 = this.f57513e;
            if (this.f57512d == SelectKt.i()) {
                return ((l) obj2).invoke(cVar);
            }
            return ((p) obj2).invoke(obj, cVar);
        }

        public final Object d(Object obj) {
            return this.f57511c.invoke(this.f57509a, this.f57512d, obj);
        }

        public final boolean e(SelectImplementation<R> selectImplementation) {
            if (j0.a()) {
                if (!(selectImplementation.v() || selectImplementation.w())) {
                    throw new AssertionError();
                }
            }
            if (j0.a()) {
                if (!(selectImplementation.f57508f == SelectKt.f57522e)) {
                    throw new AssertionError();
                }
            }
            this.f57510b.invoke(this.f57509a, selectImplementation, this.f57512d);
            if (selectImplementation.f57508f == SelectKt.f57522e) {
                return true;
            }
            return false;
        }
    }

    public SelectImplementation(CoroutineContext coroutineContext) {
        this.f57504b = coroutineContext;
    }

    public static /* synthetic */ void A(SelectImplementation selectImplementation, a aVar, boolean z11, int i11, Object obj) {
        if (obj == null) {
            if ((i11 & 1) != 0) {
                z11 = false;
            }
            selectImplementation.z(aVar, z11);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: register");
    }

    public static /* synthetic */ <R> Object s(SelectImplementation<R> selectImplementation, c<? super R> cVar) {
        if (selectImplementation.x()) {
            return selectImplementation.q(cVar);
        }
        return selectImplementation.t(cVar);
    }

    public final void B(Object obj) {
        SelectImplementation<R>.a u11 = u(obj);
        u11.f57515g = null;
        u11.f57516h = -1;
        z(u11, true);
    }

    public final TrySelectDetailedResult C(Object obj, Object obj2) {
        return SelectKt.a(D(obj, obj2));
    }

    public final int D(Object obj, Object obj2) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f57503g;
            Object obj3 = atomicReferenceFieldUpdater.get(this);
            if (obj3 instanceof k) {
                SelectImplementation<R>.a u11 = u(obj);
                if (u11 == null) {
                    continue;
                } else {
                    l<Throwable, Unit> a11 = u11.a(this, obj2);
                    if (androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, this, obj3, u11)) {
                        this.f57508f = obj2;
                        if (SelectKt.j((k) obj3, a11)) {
                            return 0;
                        }
                        this.f57508f = null;
                        return 2;
                    }
                }
            } else {
                if (x.b(obj3, SelectKt.f57520c) ? true : obj3 instanceof a) {
                    return 3;
                }
                if (x.b(obj3, SelectKt.f57521d)) {
                    return 2;
                }
                if (x.b(obj3, SelectKt.f57519b)) {
                    if (androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, this, obj3, CollectionsKt__CollectionsJVMKt.e(obj))) {
                        return 1;
                    }
                } else if (!(obj3 instanceof List)) {
                    throw new IllegalStateException(("Unexpected state: " + obj3).toString());
                } else if (androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, this, obj3, CollectionsKt___CollectionsKt.r0((Collection) obj3, obj))) {
                    return 1;
                }
            }
        }
    }

    public final Object E(c<? super Unit> cVar) {
        kotlinx.coroutines.l lVar = new kotlinx.coroutines.l(IntrinsicsKt__IntrinsicsJvmKt.c(cVar), 1);
        lVar.A();
        AtomicReferenceFieldUpdater k11 = f57503g;
        while (true) {
            Object obj = k11.get(this);
            if (obj == SelectKt.f57519b) {
                if (androidx.concurrent.futures.a.a(f57503g, this, obj, lVar)) {
                    lVar.x(this);
                    break;
                }
            } else if (obj instanceof List) {
                if (androidx.concurrent.futures.a.a(f57503g, this, obj, SelectKt.f57519b)) {
                    List list = (List) obj;
                    for (Object n11 : (Iterable) obj) {
                        B(n11);
                    }
                }
            } else if (obj instanceof a) {
                lVar.h(Unit.f56620a, ((a) obj).a(this, this.f57508f));
            } else {
                throw new IllegalStateException(("unexpected state: " + obj).toString());
            }
        }
        Object v11 = lVar.v();
        if (v11 == IntrinsicsKt__IntrinsicsKt.d()) {
            f.c(cVar);
        }
        if (v11 == IntrinsicsKt__IntrinsicsKt.d()) {
            return v11;
        }
        return Unit.f56620a;
    }

    public void a(d dVar, l<? super c<? super R>, ? extends Object> lVar) {
        A(this, new a(dVar.d(), dVar.c(), dVar.b(), SelectKt.i(), lVar, dVar.a()), false, 1, (Object) null);
    }

    public void b(z<?> zVar, int i11) {
        this.f57506d = zVar;
        this.f57507e = i11;
    }

    public <Q> void c(f<? extends Q> fVar, p<? super Q, ? super c<? super R>, ? extends Object> pVar) {
        A(this, new a(fVar.d(), fVar.c(), fVar.b(), (Object) null, pVar, fVar.a()), false, 1, (Object) null);
    }

    public void d(Object obj) {
        this.f57508f = obj;
    }

    public void e(x0 x0Var) {
        this.f57506d = x0Var;
    }

    public boolean f(Object obj, Object obj2) {
        return D(obj, obj2) == 0;
    }

    public void g(Throwable th2) {
        Object obj;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f57503g;
        do {
            obj = atomicReferenceFieldUpdater.get(this);
            if (obj == SelectKt.f57520c) {
                return;
            }
        } while (!androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, this, obj, SelectKt.f57521d));
        List<SelectImplementation<R>.a> list = this.f57505c;
        if (list != null) {
            for (a b11 : list) {
                b11.b();
            }
            this.f57508f = SelectKt.f57522e;
            this.f57505c = null;
        }
    }

    public CoroutineContext getContext() {
        return this.f57504b;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        g((Throwable) obj);
        return Unit.f56620a;
    }

    public final void o(Object obj) {
        boolean z11;
        List<SelectImplementation<R>.a> list = this.f57505c;
        boolean z12 = false;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it2 = list.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                if (((a) it2.next()).f57509a == obj) {
                    z11 = true;
                    continue;
                } else {
                    z11 = false;
                    continue;
                }
                if (z11) {
                    break;
                }
            }
        }
        z12 = true;
        if (!z12) {
            throw new IllegalStateException(("Cannot use select clauses on the same object: " + obj).toString());
        }
    }

    public final void p(SelectImplementation<R>.a aVar) {
        if (!j0.a() || x.b(f57503g.get(this), aVar)) {
            List<SelectImplementation<R>.a> list = this.f57505c;
            if (list != null) {
                for (SelectImplementation<R>.a aVar2 : list) {
                    if (aVar2 != aVar) {
                        aVar2.b();
                    }
                }
                f57503g.set(this, SelectKt.f57520c);
                this.f57508f = SelectKt.f57522e;
                this.f57505c = null;
                return;
            }
            return;
        }
        throw new AssertionError();
    }

    public final Object q(c<? super R> cVar) {
        if (!j0.a() || x()) {
            a aVar = (a) f57503g.get(this);
            Object obj = this.f57508f;
            p(aVar);
            if (!j0.d()) {
                return aVar.c(aVar.d(obj), cVar);
            }
            return y(aVar, obj, cVar);
        }
        throw new AssertionError();
    }

    public Object r(c<? super R> cVar) {
        return s(this, cVar);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0056 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0057 A[PHI: r6 
      PHI: (r6v2 java.lang.Object) = (r6v4 java.lang.Object), (r6v1 java.lang.Object) binds: [B:19:0x0054, B:10:0x0028] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object t(kotlin.coroutines.c<? super R> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof kotlinx.coroutines.selects.SelectImplementation$doSelectSuspend$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            kotlinx.coroutines.selects.SelectImplementation$doSelectSuspend$1 r0 = (kotlinx.coroutines.selects.SelectImplementation$doSelectSuspend$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.selects.SelectImplementation$doSelectSuspend$1 r0 = new kotlinx.coroutines.selects.SelectImplementation$doSelectSuspend$1
            r0.<init>(r5, r6)
        L_0x0018:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x003c
            if (r2 == r4) goto L_0x0034
            if (r2 != r3) goto L_0x002c
            kotlin.k.b(r6)
            goto L_0x0057
        L_0x002c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x0034:
            java.lang.Object r2 = r0.L$0
            kotlinx.coroutines.selects.SelectImplementation r2 = (kotlinx.coroutines.selects.SelectImplementation) r2
            kotlin.k.b(r6)
            goto L_0x004b
        L_0x003c:
            kotlin.k.b(r6)
            r0.L$0 = r5
            r0.label = r4
            java.lang.Object r6 = r5.E(r0)
            if (r6 != r1) goto L_0x004a
            return r1
        L_0x004a:
            r2 = r5
        L_0x004b:
            r6 = 0
            r0.L$0 = r6
            r0.label = r3
            java.lang.Object r6 = r2.q(r0)
            if (r6 != r1) goto L_0x0057
            return r1
        L_0x0057:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.selects.SelectImplementation.t(kotlin.coroutines.c):java.lang.Object");
    }

    public final SelectImplementation<R>.a u(Object obj) {
        boolean z11;
        List<SelectImplementation<R>.a> list = this.f57505c;
        T t11 = null;
        if (list == null) {
            return null;
        }
        Iterator<T> it2 = list.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            T next = it2.next();
            if (((a) next).f57509a == obj) {
                z11 = true;
                continue;
            } else {
                z11 = false;
                continue;
            }
            if (z11) {
                t11 = next;
                break;
            }
        }
        SelectImplementation<R>.a aVar = (a) t11;
        if (aVar != null) {
            return aVar;
        }
        throw new IllegalStateException(("Clause with object " + obj + " is not found").toString());
    }

    public final boolean v() {
        Object obj = f57503g.get(this);
        return obj == SelectKt.f57519b || (obj instanceof List);
    }

    public final boolean w() {
        return f57503g.get(this) == SelectKt.f57521d;
    }

    public final boolean x() {
        return f57503g.get(this) instanceof a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object y(kotlinx.coroutines.selects.SelectImplementation<R>.a r5, java.lang.Object r6, kotlin.coroutines.c<? super R> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof kotlinx.coroutines.selects.SelectImplementation$processResultAndInvokeBlockRecoveringException$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            kotlinx.coroutines.selects.SelectImplementation$processResultAndInvokeBlockRecoveringException$1 r0 = (kotlinx.coroutines.selects.SelectImplementation$processResultAndInvokeBlockRecoveringException$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.selects.SelectImplementation$processResultAndInvokeBlockRecoveringException$1 r0 = new kotlinx.coroutines.selects.SelectImplementation$processResultAndInvokeBlockRecoveringException$1
            r0.<init>(r4, r7)
        L_0x0018:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0033
            if (r2 != r3) goto L_0x002b
            kotlin.k.b(r7)     // Catch:{ all -> 0x0029 }
            goto L_0x0043
        L_0x0029:
            r5 = move-exception
            goto L_0x0044
        L_0x002b:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0033:
            kotlin.k.b(r7)
            java.lang.Object r6 = r5.d(r6)     // Catch:{ all -> 0x0029 }
            r0.label = r3     // Catch:{ all -> 0x0029 }
            java.lang.Object r7 = r5.c(r6, r0)     // Catch:{ all -> 0x0029 }
            if (r7 != r1) goto L_0x0043
            return r1
        L_0x0043:
            return r7
        L_0x0044:
            boolean r6 = kotlinx.coroutines.j0.d()
            if (r6 == 0) goto L_0x004f
            java.lang.Throwable r5 = kotlinx.coroutines.internal.b0.i(r5, r0)
            throw r5
        L_0x004f:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.selects.SelectImplementation.y(kotlinx.coroutines.selects.SelectImplementation$a, java.lang.Object, kotlin.coroutines.c):java.lang.Object");
    }

    public final void z(SelectImplementation<R>.a aVar, boolean z11) {
        if (j0.a()) {
            if (!(f57503g.get(this) != SelectKt.f57521d)) {
                throw new AssertionError();
            }
        }
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f57503g;
        if (!(atomicReferenceFieldUpdater.get(this) instanceof a)) {
            if (!z11) {
                o(aVar.f57509a);
            }
            if (aVar.e(this)) {
                if (!z11) {
                    this.f57505c.add(aVar);
                }
                aVar.f57515g = this.f57506d;
                aVar.f57516h = this.f57507e;
                this.f57506d = null;
                this.f57507e = -1;
                return;
            }
            atomicReferenceFieldUpdater.set(this, aVar);
        }
    }
}
