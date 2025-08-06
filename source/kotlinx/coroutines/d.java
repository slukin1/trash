package kotlinx.coroutines;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.f;

public final class d<T> {

    /* renamed from: b  reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f57055b = AtomicIntegerFieldUpdater.newUpdater(d.class, "notCompletedCount");

    /* renamed from: a  reason: collision with root package name */
    public final n0<T>[] f57056a;
    private volatile int notCompletedCount;

    public final class a extends JobNode {

        /* renamed from: i  reason: collision with root package name */
        public static final AtomicReferenceFieldUpdater f57057i = AtomicReferenceFieldUpdater.newUpdater(a.class, Object.class, "_disposer");
        private volatile Object _disposer;

        /* renamed from: f  reason: collision with root package name */
        public final k<List<? extends T>> f57058f;

        /* renamed from: g  reason: collision with root package name */
        public x0 f57059g;

        public a(k<? super List<? extends T>> kVar) {
            this.f57058f = kVar;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            q((Throwable) obj);
            return Unit.f56620a;
        }

        public void q(Throwable th2) {
            if (th2 != null) {
                Object B = this.f57058f.B(th2);
                if (B != null) {
                    this.f57058f.w(B);
                    d<T>.b t11 = t();
                    if (t11 != null) {
                        t11.h();
                    }
                }
            } else if (d.f57055b.decrementAndGet(d.this) == 0) {
                k<List<? extends T>> kVar = this.f57058f;
                n0[] a11 = d.this.f57056a;
                ArrayList arrayList = new ArrayList(a11.length);
                for (n0 f11 : a11) {
                    arrayList.add(f11.f());
                }
                Result.a aVar = Result.Companion;
                kVar.resumeWith(Result.m3072constructorimpl(arrayList));
            }
        }

        public final d<T>.b t() {
            return (b) f57057i.get(this);
        }

        public final x0 u() {
            x0 x0Var = this.f57059g;
            if (x0Var != null) {
                return x0Var;
            }
            return null;
        }

        public final void v(d<T>.b bVar) {
            f57057i.set(this, bVar);
        }

        public final void w(x0 x0Var) {
            this.f57059g = x0Var;
        }
    }

    public final class b extends CancelHandler {

        /* renamed from: b  reason: collision with root package name */
        public final d<T>.a[] f57061b;

        public b(d<T>.a[] aVarArr) {
            this.f57061b = aVarArr;
        }

        public void g(Throwable th2) {
            h();
        }

        public final void h() {
            for (d<T>.a u11 : this.f57061b) {
                u11.u().dispose();
            }
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            g((Throwable) obj);
            return Unit.f56620a;
        }

        public String toString() {
            return "DisposeHandlersOnCancel[" + this.f57061b + ']';
        }
    }

    public d(n0<? extends T>[] n0VarArr) {
        this.f57056a = n0VarArr;
        this.notCompletedCount = n0VarArr.length;
    }

    public final Object c(c<? super List<? extends T>> cVar) {
        l lVar = new l(IntrinsicsKt__IntrinsicsJvmKt.c(cVar), 1);
        lVar.A();
        int length = this.f57056a.length;
        a[] aVarArr = new a[length];
        for (int i11 = 0; i11 < length; i11++) {
            n0 n0Var = this.f57056a[i11];
            n0Var.start();
            a aVar = new a(lVar);
            aVar.w(n0Var.L(aVar));
            Unit unit = Unit.f56620a;
            aVarArr[i11] = aVar;
        }
        b bVar = new b(aVarArr);
        for (int i12 = 0; i12 < length; i12++) {
            aVarArr[i12].v(bVar);
        }
        if (lVar.a()) {
            bVar.h();
        } else {
            lVar.x(bVar);
        }
        Object v11 = lVar.v();
        if (v11 == IntrinsicsKt__IntrinsicsKt.d()) {
            f.c(cVar);
        }
        return v11;
    }
}
