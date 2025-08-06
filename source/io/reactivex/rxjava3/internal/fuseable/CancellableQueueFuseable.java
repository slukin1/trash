package io.reactivex.rxjava3.internal.fuseable;

public final class CancellableQueueFuseable<T> extends AbstractEmptyQueueFuseable<T> {

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f55454b;

    public void cancel() {
        this.f55454b = true;
    }

    public void dispose() {
        this.f55454b = true;
    }

    public boolean isDisposed() {
        return this.f55454b;
    }
}
