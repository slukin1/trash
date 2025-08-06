package io.reactivex.rxjava3.internal.fuseable;

import k00.b;
import k00.d;

public abstract class AbstractEmptyQueueFuseable<T> implements d<T>, b<T> {
    public void cancel() {
    }

    public final void clear() {
    }

    public void dispose() {
    }

    public boolean isDisposed() {
        return false;
    }

    public final boolean isEmpty() {
        return true;
    }

    public final boolean offer(T t11) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public final T poll() throws Throwable {
        return null;
    }

    public final void request(long j11) {
    }

    public final int requestFusion(int i11) {
        return i11 & 2;
    }
}
