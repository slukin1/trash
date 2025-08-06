package io.reactivex.rxjava3.disposables;

final class RunnableDisposable extends ReferenceDisposable<Runnable> {
    private static final long serialVersionUID = -8219729196779211169L;

    public RunnableDisposable(Runnable runnable) {
        super(runnable);
    }

    public String toString() {
        return "RunnableDisposable(disposed=" + isDisposed() + ", " + get() + ")";
    }

    public void onDisposed(Runnable runnable) {
        runnable.run();
    }
}
