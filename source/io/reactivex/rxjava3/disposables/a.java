package io.reactivex.rxjava3.disposables;

import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import java.util.Objects;

public final /* synthetic */ class a {
    public static b a() {
        return EmptyDisposable.INSTANCE;
    }

    public static b b(Runnable runnable) {
        Objects.requireNonNull(runnable, "run is null");
        return new RunnableDisposable(runnable);
    }
}
