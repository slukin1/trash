package io.reactivex.rxjava3.internal.observers;

public final class BlockingFirstObserver<T> extends BlockingBaseObserver<T> {
    public void onError(Throwable th2) {
        if (this.f55455b == null) {
            this.f55456c = th2;
        }
        countDown();
    }

    public void onNext(T t11) {
        if (this.f55455b == null) {
            this.f55455b = t11;
            this.f55457d.dispose();
            countDown();
        }
    }
}
