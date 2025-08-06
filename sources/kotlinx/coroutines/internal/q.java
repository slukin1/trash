package kotlinx.coroutines.internal;

import androidx.concurrent.futures.a;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public class q<E> {

    /* renamed from: a  reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f57334a = AtomicReferenceFieldUpdater.newUpdater(q.class, Object.class, "_cur");
    private volatile Object _cur;

    public q(boolean z11) {
        this._cur = new r(8, z11);
    }

    public final boolean a(E e11) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f57334a;
        while (true) {
            r rVar = (r) atomicReferenceFieldUpdater.get(this);
            int a11 = rVar.a(e11);
            if (a11 == 0) {
                return true;
            }
            if (a11 == 1) {
                a.a(f57334a, this, rVar, rVar.i());
            } else if (a11 == 2) {
                return false;
            }
        }
    }

    public final void b() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f57334a;
        while (true) {
            r rVar = (r) atomicReferenceFieldUpdater.get(this);
            if (!rVar.d()) {
                a.a(f57334a, this, rVar, rVar.i());
            } else {
                return;
            }
        }
    }

    public final int c() {
        return ((r) f57334a.get(this)).f();
    }

    public final E d() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f57334a;
        while (true) {
            r rVar = (r) atomicReferenceFieldUpdater.get(this);
            E j11 = rVar.j();
            if (j11 != r.f57338h) {
                return j11;
            }
            a.a(f57334a, this, rVar, rVar.i());
        }
    }
}
