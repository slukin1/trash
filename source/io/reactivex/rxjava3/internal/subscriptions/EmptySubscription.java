package io.reactivex.rxjava3.internal.subscriptions;

import k00.d;
import z20.c;

public enum EmptySubscription implements d<Object> {
    INSTANCE;

    public static void complete(c<?> cVar) {
        cVar.onSubscribe(INSTANCE);
        cVar.onComplete();
    }

    public static void error(Throwable th2, c<?> cVar) {
        cVar.onSubscribe(INSTANCE);
        cVar.onError(th2);
    }

    public void cancel() {
    }

    public void clear() {
    }

    public boolean isEmpty() {
        return true;
    }

    public boolean offer(Object obj) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public Object poll() {
        return null;
    }

    public void request(long j11) {
        SubscriptionHelper.validate(j11);
    }

    public int requestFusion(int i11) {
        return i11 & 2;
    }

    public String toString() {
        return "EmptySubscription";
    }

    public boolean offer(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Should not be called!");
    }
}
