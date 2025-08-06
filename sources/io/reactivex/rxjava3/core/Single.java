package io.reactivex.rxjava3.core;

import h00.m;
import h00.n;
import h00.o;
import io.reactivex.rxjava3.internal.functions.Functions;
import io.reactivex.rxjava3.internal.observers.ConsumerSingleObserver;
import io.reactivex.rxjava3.internal.operators.single.SingleCreate;
import io.reactivex.rxjava3.internal.operators.single.b;
import j00.g;
import java.util.Objects;
import o00.a;

public abstract class Single<T> implements o<T> {
    public static <T> Single<T> b(n<T> nVar) {
        Objects.requireNonNull(nVar, "source is null");
        return a.l(new SingleCreate(nVar));
    }

    public static <T> Single<T> c(T t11) {
        Objects.requireNonNull(t11, "item is null");
        return a.l(new b(t11));
    }

    public final void a(m<? super T> mVar) {
        Objects.requireNonNull(mVar, "observer is null");
        m<? super Object> t11 = a.t(this, mVar);
        Objects.requireNonNull(t11, "The RxJavaPlugins.onSubscribe hook returned a null SingleObserver. Please check the handler provided to RxJavaPlugins.setOnSingleSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
        try {
            f(t11);
        } catch (NullPointerException e11) {
            throw e11;
        } catch (Throwable th2) {
            io.reactivex.rxjava3.exceptions.a.b(th2);
            NullPointerException nullPointerException = new NullPointerException("subscribeActual failed");
            nullPointerException.initCause(th2);
            throw nullPointerException;
        }
    }

    public final io.reactivex.rxjava3.disposables.b d() {
        return e(Functions.a(), Functions.f55447f);
    }

    public final io.reactivex.rxjava3.disposables.b e(g<? super T> gVar, g<? super Throwable> gVar2) {
        Objects.requireNonNull(gVar, "onSuccess is null");
        Objects.requireNonNull(gVar2, "onError is null");
        ConsumerSingleObserver consumerSingleObserver = new ConsumerSingleObserver(gVar, gVar2);
        a(consumerSingleObserver);
        return consumerSingleObserver;
    }

    public abstract void f(m<? super T> mVar);
}
