package io.reactivex.rxjava3.internal.observers;

public final class BlockingLastObserver<T> extends BlockingBaseObserver<T> {
    public void onError(Throwable th2) {
        this.f55455b = null;
        this.f55456c = th2;
        countDown();
    }

    public void onNext(T t11) {
        this.f55455b = t11;
    }
}
