package io.reactivex.rxjava3.internal.jdk8;

import h00.k;
import io.reactivex.rxjava3.internal.observers.DeferredScalarDisposable;
import java.util.function.BiConsumer;

final class ObservableFromCompletionStage$CompletionStageHandler<T> extends DeferredScalarDisposable<T> implements BiConsumer<T, Throwable> {
    private static final long serialVersionUID = 4665335664328839859L;
    public final ObservableFromCompletionStage$BiConsumerAtomicReference<T> whenReference;

    public ObservableFromCompletionStage$CompletionStageHandler(k<? super T> kVar, ObservableFromCompletionStage$BiConsumerAtomicReference<T> observableFromCompletionStage$BiConsumerAtomicReference) {
        super(kVar);
        this.whenReference = observableFromCompletionStage$BiConsumerAtomicReference;
    }

    public void dispose() {
        super.dispose();
        this.whenReference.set((Object) null);
    }

    public void accept(T t11, Throwable th2) {
        if (th2 != null) {
            this.downstream.onError(th2);
        } else if (t11 != null) {
            complete(t11);
        } else {
            this.downstream.onError(new NullPointerException("The CompletionStage terminated with null."));
        }
    }
}
