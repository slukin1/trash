package io.reactivex.rxjava3.internal.operators.observable;

import h00.k;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.queue.a;

public final class h<T> implements k<T> {

    /* renamed from: b  reason: collision with root package name */
    public final ObservableSequenceEqual$EqualCoordinator<T> f55573b;

    /* renamed from: c  reason: collision with root package name */
    public final a<T> f55574c;

    /* renamed from: d  reason: collision with root package name */
    public final int f55575d;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f55576e;

    /* renamed from: f  reason: collision with root package name */
    public Throwable f55577f;

    public h(ObservableSequenceEqual$EqualCoordinator<T> observableSequenceEqual$EqualCoordinator, int i11, int i12) {
        this.f55573b = observableSequenceEqual$EqualCoordinator;
        this.f55575d = i11;
        this.f55574c = new a<>(i12);
    }

    public void onComplete() {
        this.f55576e = true;
        this.f55573b.drain();
    }

    public void onError(Throwable th2) {
        this.f55577f = th2;
        this.f55576e = true;
        this.f55573b.drain();
    }

    public void onNext(T t11) {
        this.f55574c.offer(t11);
        this.f55573b.drain();
    }

    public void onSubscribe(b bVar) {
        this.f55573b.setDisposable(bVar, this.f55575d);
    }
}
