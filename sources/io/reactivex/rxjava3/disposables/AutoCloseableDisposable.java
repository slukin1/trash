package io.reactivex.rxjava3.disposables;

import io.reactivex.rxjava3.internal.util.ExceptionHelper;

final class AutoCloseableDisposable extends ReferenceDisposable<AutoCloseable> {
    private static final long serialVersionUID = -6646144244598696847L;

    public AutoCloseableDisposable(AutoCloseable autoCloseable) {
        super(autoCloseable);
    }

    public String toString() {
        return "AutoCloseableDisposable(disposed=" + isDisposed() + ", " + get() + ")";
    }

    public void onDisposed(AutoCloseable autoCloseable) {
        try {
            autoCloseable.close();
        } catch (Throwable th2) {
            throw ExceptionHelper.g(th2);
        }
    }
}
