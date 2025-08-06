package io.reactivex.rxjava3.internal.subscribers;

import o00.a;

public final class BlockingFirstSubscriber<T> extends BlockingBaseSubscriber<T> {
    public void onError(Throwable th2) {
        if (this.f55694b == null) {
            this.f55695c = th2;
        } else {
            a.n(th2);
        }
        countDown();
    }

    public void onNext(T t11) {
        if (this.f55694b == null) {
            this.f55694b = t11;
            this.f55696d.cancel();
            countDown();
        }
    }
}
