package io.reactivex.rxjava3.internal.subscribers;

public final class BlockingLastSubscriber<T> extends BlockingBaseSubscriber<T> {
    public void onError(Throwable th2) {
        this.f55694b = null;
        this.f55695c = th2;
        countDown();
    }

    public void onNext(T t11) {
        this.f55694b = t11;
    }
}
