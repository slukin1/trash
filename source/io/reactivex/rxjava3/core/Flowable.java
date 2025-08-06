package io.reactivex.rxjava3.core;

import io.reactivex.rxjava3.internal.functions.Functions;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableInternalHelper$RequestMax;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableObserveOn;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableSubscribeOn;
import io.reactivex.rxjava3.internal.operators.flowable.e;
import io.reactivex.rxjava3.internal.subscribers.BlockingFirstSubscriber;
import io.reactivex.rxjava3.internal.subscribers.LambdaSubscriber;
import io.reactivex.rxjava3.internal.subscribers.StrictSubscriber;
import j00.g;
import j00.h;
import java.util.NoSuchElementException;
import java.util.Objects;
import o00.a;
import z20.b;
import z20.c;

public abstract class Flowable<T> implements b<T> {

    /* renamed from: b  reason: collision with root package name */
    public static final int f55420b = Math.max(1, Integer.getInteger("rx3.buffer-size", 128).intValue());

    public static int b() {
        return f55420b;
    }

    public static <T> Flowable<T> c(b<? extends T> bVar) {
        if (bVar instanceof Flowable) {
            return a.k((Flowable) bVar);
        }
        Objects.requireNonNull(bVar, "publisher is null");
        return a.k(new e(bVar));
    }

    public final T a() {
        BlockingFirstSubscriber blockingFirstSubscriber = new BlockingFirstSubscriber();
        i(blockingFirstSubscriber);
        T a11 = blockingFirstSubscriber.a();
        if (a11 != null) {
            return a11;
        }
        throw new NoSuchElementException();
    }

    public final <R> Flowable<R> d(h<? super T, ? extends R> hVar) {
        Objects.requireNonNull(hVar, "mapper is null");
        return a.k(new io.reactivex.rxjava3.internal.operators.flowable.h(this, hVar));
    }

    public final Flowable<T> e(Scheduler scheduler) {
        return f(scheduler, false, b());
    }

    public final Flowable<T> f(Scheduler scheduler, boolean z11, int i11) {
        Objects.requireNonNull(scheduler, "scheduler is null");
        io.reactivex.rxjava3.internal.functions.a.a(i11, "bufferSize");
        return a.k(new FlowableObserveOn(this, scheduler, z11, i11));
    }

    public final io.reactivex.rxjava3.disposables.b g(g<? super T> gVar, g<? super Throwable> gVar2) {
        return h(gVar, gVar2, Functions.f55444c);
    }

    public final io.reactivex.rxjava3.disposables.b h(g<? super T> gVar, g<? super Throwable> gVar2, j00.a aVar) {
        Objects.requireNonNull(gVar, "onNext is null");
        Objects.requireNonNull(gVar2, "onError is null");
        Objects.requireNonNull(aVar, "onComplete is null");
        LambdaSubscriber lambdaSubscriber = new LambdaSubscriber(gVar, gVar2, aVar, FlowableInternalHelper$RequestMax.INSTANCE);
        i(lambdaSubscriber);
        return lambdaSubscriber;
    }

    public final void i(h00.e<? super T> eVar) {
        Objects.requireNonNull(eVar, "subscriber is null");
        try {
            c<? super Object> u11 = a.u(this, eVar);
            Objects.requireNonNull(u11, "The RxJavaPlugins.onSubscribe hook returned a null FlowableSubscriber. Please check the handler provided to RxJavaPlugins.setOnFlowableSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
            j(u11);
        } catch (NullPointerException e11) {
            throw e11;
        } catch (Throwable th2) {
            io.reactivex.rxjava3.exceptions.a.b(th2);
            a.n(th2);
            NullPointerException nullPointerException = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
            nullPointerException.initCause(th2);
            throw nullPointerException;
        }
    }

    public abstract void j(c<? super T> cVar);

    public final Flowable<T> k(Scheduler scheduler) {
        Objects.requireNonNull(scheduler, "scheduler is null");
        return l(scheduler, true);
    }

    public final Flowable<T> l(Scheduler scheduler, boolean z11) {
        Objects.requireNonNull(scheduler, "scheduler is null");
        return a.k(new FlowableSubscribeOn(this, scheduler, z11));
    }

    public final void subscribe(c<? super T> cVar) {
        if (cVar instanceof h00.e) {
            i((h00.e) cVar);
            return;
        }
        Objects.requireNonNull(cVar, "subscriber is null");
        i(new StrictSubscriber(cVar));
    }
}
