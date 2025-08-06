package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.exceptions.a;
import io.reactivex.rxjava3.internal.subscribers.SinglePostCompleteSubscriber;
import j00.h;
import j00.k;
import java.util.Objects;
import z20.c;

final class FlowableMapNotification$MapNotificationSubscriber<T, R> extends SinglePostCompleteSubscriber<T, R> {
    private static final long serialVersionUID = 2757120512858778108L;
    public final k<? extends R> onCompleteSupplier;
    public final h<? super Throwable, ? extends R> onErrorMapper;
    public final h<? super T, ? extends R> onNextMapper;

    public FlowableMapNotification$MapNotificationSubscriber(c<? super R> cVar, h<? super T, ? extends R> hVar, h<? super Throwable, ? extends R> hVar2, k<? extends R> kVar) {
        super(cVar);
        this.onNextMapper = hVar;
        this.onErrorMapper = hVar2;
        this.onCompleteSupplier = kVar;
    }

    public void onComplete() {
        try {
            Object obj = this.onCompleteSupplier.get();
            Objects.requireNonNull(obj, "The onComplete publisher returned is null");
            complete(obj);
        } catch (Throwable th2) {
            a.b(th2);
            this.downstream.onError(th2);
        }
    }

    public void onError(Throwable th2) {
        try {
            Object apply = this.onErrorMapper.apply(th2);
            Objects.requireNonNull(apply, "The onError publisher returned is null");
            complete(apply);
        } catch (Throwable th3) {
            a.b(th3);
            this.downstream.onError(new CompositeException(th2, th3));
        }
    }

    public void onNext(T t11) {
        try {
            Object apply = this.onNextMapper.apply(t11);
            Objects.requireNonNull(apply, "The onNext publisher returned is null");
            this.produced++;
            this.downstream.onNext(apply);
        } catch (Throwable th2) {
            a.b(th2);
            this.downstream.onError(th2);
        }
    }
}
