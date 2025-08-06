package io.reactivex.rxjava3.internal.operators.observable;

import h00.k;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.subjects.Subject;
import java.util.concurrent.atomic.AtomicBoolean;

public final class o<T> extends Observable<T> {

    /* renamed from: b  reason: collision with root package name */
    public final Subject<T> f55589b;

    /* renamed from: c  reason: collision with root package name */
    public final AtomicBoolean f55590c = new AtomicBoolean();

    public o(Subject<T> subject) {
        this.f55589b = subject;
    }

    public void b(k<? super T> kVar) {
        this.f55589b.subscribe(kVar);
        this.f55590c.set(true);
    }

    public boolean c() {
        return !this.f55590c.get() && this.f55590c.compareAndSet(false, true);
    }
}
