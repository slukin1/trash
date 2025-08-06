package io.reactivex.rxjava3.internal.operators.observable;

import h00.k;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.queue.a;

public final class i<T> implements k<T> {

    /* renamed from: b  reason: collision with root package name */
    public final ObservableSequenceEqualSingle$EqualCoordinator<T> f55578b;

    /* renamed from: c  reason: collision with root package name */
    public final a<T> f55579c;

    /* renamed from: d  reason: collision with root package name */
    public final int f55580d;

    /* renamed from: e  reason: collision with root package name */
    public volatile boolean f55581e;

    /* renamed from: f  reason: collision with root package name */
    public Throwable f55582f;

    public i(ObservableSequenceEqualSingle$EqualCoordinator<T> observableSequenceEqualSingle$EqualCoordinator, int i11, int i12) {
        this.f55578b = observableSequenceEqualSingle$EqualCoordinator;
        this.f55580d = i11;
        this.f55579c = new a<>(i12);
    }

    public void onComplete() {
        this.f55581e = true;
        this.f55578b.drain();
    }

    public void onError(Throwable th2) {
        this.f55582f = th2;
        this.f55581e = true;
        this.f55578b.drain();
    }

    public void onNext(T t11) {
        this.f55579c.offer(t11);
        this.f55578b.drain();
    }

    public void onSubscribe(b bVar) {
        this.f55578b.setDisposable(bVar, this.f55580d);
    }
}
