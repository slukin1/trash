package io.reactivex.rxjava3.internal.jdk8;

import java.util.concurrent.atomic.AtomicReference;
import java.util.function.BiConsumer;

final class ObservableFromCompletionStage$BiConsumerAtomicReference<T> extends AtomicReference<BiConsumer<T, Throwable>> implements BiConsumer<T, Throwable> {
    private static final long serialVersionUID = 45838553147237545L;

    public void accept(T t11, Throwable th2) {
        BiConsumer biConsumer = (BiConsumer) get();
        if (biConsumer != null) {
            biConsumer.accept(t11, th2);
        }
    }
}
