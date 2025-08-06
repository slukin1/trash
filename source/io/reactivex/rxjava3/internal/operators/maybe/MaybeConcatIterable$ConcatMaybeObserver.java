package io.reactivex.rxjava3.internal.operators.maybe;

import h00.f;
import h00.g;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.exceptions.a;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.NotificationLite;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import z20.c;
import z20.d;

final class MaybeConcatIterable$ConcatMaybeObserver<T> extends AtomicInteger implements f<T>, d {
    private static final long serialVersionUID = 3520831347801429610L;
    public final AtomicReference<Object> current = new AtomicReference<>(NotificationLite.COMPLETE);
    public final SequentialDisposable disposables = new SequentialDisposable();
    public final c<? super T> downstream;
    public long produced;
    public final AtomicLong requested = new AtomicLong();
    public final Iterator<? extends g<? extends T>> sources;

    public MaybeConcatIterable$ConcatMaybeObserver(c<? super T> cVar, Iterator<? extends g<? extends T>> it2) {
        this.downstream = cVar;
        this.sources = it2;
    }

    public void cancel() {
        this.disposables.dispose();
    }

    public void drain() {
        if (getAndIncrement() == 0) {
            AtomicReference<Object> atomicReference = this.current;
            c<? super T> cVar = this.downstream;
            SequentialDisposable sequentialDisposable = this.disposables;
            while (!sequentialDisposable.isDisposed()) {
                Object obj = atomicReference.get();
                if (obj != null) {
                    boolean z11 = true;
                    if (obj != NotificationLite.COMPLETE) {
                        long j11 = this.produced;
                        if (j11 != this.requested.get()) {
                            this.produced = j11 + 1;
                            atomicReference.lazySet((Object) null);
                            cVar.onNext(obj);
                        } else {
                            z11 = false;
                        }
                    } else {
                        atomicReference.lazySet((Object) null);
                    }
                    if (z11 && !sequentialDisposable.isDisposed()) {
                        try {
                            if (this.sources.hasNext()) {
                                try {
                                    Object next = this.sources.next();
                                    Objects.requireNonNull(next, "The source Iterator returned a null MaybeSource");
                                    ((g) next).a(this);
                                } catch (Throwable th2) {
                                    a.b(th2);
                                    cVar.onError(th2);
                                    return;
                                }
                            } else {
                                cVar.onComplete();
                            }
                        } catch (Throwable th3) {
                            a.b(th3);
                            cVar.onError(th3);
                            return;
                        }
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            }
            atomicReference.lazySet((Object) null);
        }
    }

    public void onComplete() {
        this.current.lazySet(NotificationLite.COMPLETE);
        drain();
    }

    public void onError(Throwable th2) {
        this.downstream.onError(th2);
    }

    public void onSubscribe(b bVar) {
        this.disposables.replace(bVar);
    }

    public void onSuccess(T t11) {
        this.current.lazySet(t11);
        drain();
    }

    public void request(long j11) {
        if (SubscriptionHelper.validate(j11)) {
            io.reactivex.rxjava3.internal.util.b.a(this.requested, j11);
            drain();
        }
    }
}
