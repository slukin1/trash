package io.reactivex.rxjava3.internal.subscribers;

import h00.e;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.internal.functions.Functions;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import j00.a;
import j00.g;
import java.util.concurrent.atomic.AtomicReference;
import z20.d;

public final class LambdaSubscriber<T> extends AtomicReference<d> implements e<T>, d, b {
    private static final long serialVersionUID = -7251123623727029452L;
    public final a onComplete;
    public final g<? super Throwable> onError;
    public final g<? super T> onNext;
    public final g<? super d> onSubscribe;

    public LambdaSubscriber(g<? super T> gVar, g<? super Throwable> gVar2, a aVar, g<? super d> gVar3) {
        this.onNext = gVar;
        this.onError = gVar2;
        this.onComplete = aVar;
        this.onSubscribe = gVar3;
    }

    public void cancel() {
        SubscriptionHelper.cancel(this);
    }

    public void dispose() {
        cancel();
    }

    public boolean hasCustomOnError() {
        return this.onError != Functions.f55447f;
    }

    public boolean isDisposed() {
        return get() == SubscriptionHelper.CANCELLED;
    }

    public void onComplete() {
        Object obj = get();
        SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
        if (obj != subscriptionHelper) {
            lazySet(subscriptionHelper);
            try {
                this.onComplete.run();
            } catch (Throwable th2) {
                io.reactivex.rxjava3.exceptions.a.b(th2);
                o00.a.n(th2);
            }
        }
    }

    public void onError(Throwable th2) {
        Object obj = get();
        SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
        if (obj != subscriptionHelper) {
            lazySet(subscriptionHelper);
            try {
                this.onError.accept(th2);
            } catch (Throwable th3) {
                io.reactivex.rxjava3.exceptions.a.b(th3);
                o00.a.n(new CompositeException(th2, th3));
            }
        } else {
            o00.a.n(th2);
        }
    }

    public void onNext(T t11) {
        if (!isDisposed()) {
            try {
                this.onNext.accept(t11);
            } catch (Throwable th2) {
                io.reactivex.rxjava3.exceptions.a.b(th2);
                ((d) get()).cancel();
                onError(th2);
            }
        }
    }

    public void onSubscribe(d dVar) {
        if (SubscriptionHelper.setOnce(this, dVar)) {
            try {
                this.onSubscribe.accept(this);
            } catch (Throwable th2) {
                io.reactivex.rxjava3.exceptions.a.b(th2);
                dVar.cancel();
                onError(th2);
            }
        }
    }

    public void request(long j11) {
        ((d) get()).request(j11);
    }
}
