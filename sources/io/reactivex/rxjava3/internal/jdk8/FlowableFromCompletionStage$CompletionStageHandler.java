package io.reactivex.rxjava3.internal.jdk8;

import io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription;
import java.util.function.BiConsumer;
import z20.c;

final class FlowableFromCompletionStage$CompletionStageHandler<T> extends DeferredScalarSubscription<T> implements BiConsumer<T, Throwable> {
    private static final long serialVersionUID = 4665335664328839859L;
    public final FlowableFromCompletionStage$BiConsumerAtomicReference<T> whenReference;

    public FlowableFromCompletionStage$CompletionStageHandler(c<? super T> cVar, FlowableFromCompletionStage$BiConsumerAtomicReference<T> flowableFromCompletionStage$BiConsumerAtomicReference) {
        super(cVar);
        this.whenReference = flowableFromCompletionStage$BiConsumerAtomicReference;
    }

    public void cancel() {
        super.cancel();
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
