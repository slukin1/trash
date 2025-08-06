package io.reactivex.rxjava3.internal.operators.maybe;

import h00.g;
import h00.m;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.exceptions.a;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import j00.d;
import java.util.concurrent.atomic.AtomicInteger;

final class MaybeEqualSingle$EqualCoordinator<T> extends AtomicInteger implements b {
    public final m<? super Boolean> downstream;
    public final d<? super T, ? super T> isEqual;
    public final MaybeEqualSingle$EqualObserver<T> observer1 = new MaybeEqualSingle$EqualObserver<>(this);
    public final MaybeEqualSingle$EqualObserver<T> observer2 = new MaybeEqualSingle$EqualObserver<>(this);

    public MaybeEqualSingle$EqualCoordinator(m<? super Boolean> mVar, d<? super T, ? super T> dVar) {
        super(2);
        this.downstream = mVar;
        this.isEqual = dVar;
    }

    public void dispose() {
        this.observer1.dispose();
        this.observer2.dispose();
    }

    public void done() {
        if (decrementAndGet() == 0) {
            Object obj = this.observer1.value;
            Object obj2 = this.observer2.value;
            if (obj == null || obj2 == null) {
                this.downstream.onSuccess(Boolean.valueOf(obj == null && obj2 == null));
                return;
            }
            try {
                this.downstream.onSuccess(Boolean.valueOf(this.isEqual.a(obj, obj2)));
            } catch (Throwable th2) {
                a.b(th2);
                this.downstream.onError(th2);
            }
        }
    }

    public void error(MaybeEqualSingle$EqualObserver<T> maybeEqualSingle$EqualObserver, Throwable th2) {
        if (getAndSet(0) > 0) {
            MaybeEqualSingle$EqualObserver<T> maybeEqualSingle$EqualObserver2 = this.observer1;
            if (maybeEqualSingle$EqualObserver == maybeEqualSingle$EqualObserver2) {
                this.observer2.dispose();
            } else {
                maybeEqualSingle$EqualObserver2.dispose();
            }
            this.downstream.onError(th2);
            return;
        }
        o00.a.n(th2);
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed((b) this.observer1.get());
    }

    public void subscribe(g<? extends T> gVar, g<? extends T> gVar2) {
        gVar.a(this.observer1);
        gVar2.a(this.observer2);
    }
}
