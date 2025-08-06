package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import java.util.concurrent.CancellationException;
import kotlinx.coroutines.n1;

public final class q {

    /* renamed from: a  reason: collision with root package name */
    public final Lifecycle f10034a;

    /* renamed from: b  reason: collision with root package name */
    public final Lifecycle.State f10035b;

    /* renamed from: c  reason: collision with root package name */
    public final DispatchQueue f10036c;

    /* renamed from: d  reason: collision with root package name */
    public final r f10037d;

    public q(Lifecycle lifecycle, Lifecycle.State state, DispatchQueue dispatchQueue, n1 n1Var) {
        this.f10034a = lifecycle;
        this.f10035b = state;
        this.f10036c = dispatchQueue;
        p pVar = new p(this, n1Var);
        this.f10037d = pVar;
        if (lifecycle.b() == Lifecycle.State.DESTROYED) {
            n1.a.a(n1Var, (CancellationException) null, 1, (Object) null);
            b();
            return;
        }
        lifecycle.a(pVar);
    }

    public static final void c(q qVar, n1 n1Var, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        if (lifecycleOwner.getLifecycle().b() == Lifecycle.State.DESTROYED) {
            n1.a.a(n1Var, (CancellationException) null, 1, (Object) null);
            qVar.b();
        } else if (lifecycleOwner.getLifecycle().b().compareTo(qVar.f10035b) < 0) {
            qVar.f10036c.h();
        } else {
            qVar.f10036c.i();
        }
    }

    public final void b() {
        this.f10034a.d(this.f10037d);
        this.f10036c.g();
    }
}
