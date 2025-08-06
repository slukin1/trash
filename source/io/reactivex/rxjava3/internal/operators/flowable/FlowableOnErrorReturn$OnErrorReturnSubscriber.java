package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.a;
import io.reactivex.rxjava3.internal.subscribers.SinglePostCompleteSubscriber;
import j00.h;
import java.util.Objects;
import z20.c;

final class FlowableOnErrorReturn$OnErrorReturnSubscriber<T> extends SinglePostCompleteSubscriber<T, T> {
    private static final long serialVersionUID = -3740826063558713822L;
    public final h<? super Throwable, ? extends T> valueSupplier;

    public FlowableOnErrorReturn$OnErrorReturnSubscriber(c<? super T> cVar, h<? super Throwable, ? extends T> hVar) {
        super(cVar);
        this.valueSupplier = hVar;
    }

    public void onComplete() {
        this.downstream.onComplete();
    }

    public void onError(Throwable th2) {
        try {
            Object apply = this.valueSupplier.apply(th2);
            Objects.requireNonNull(apply, "The valueSupplier returned a null value");
            complete(apply);
        } catch (Throwable th3) {
            a.b(th3);
            this.downstream.onError(new CompositeException(th2, th3));
        }
    }

    public void onNext(T t11) {
        this.produced++;
        this.downstream.onNext(t11);
    }
}
