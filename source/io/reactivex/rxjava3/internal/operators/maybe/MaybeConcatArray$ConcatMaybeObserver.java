package io.reactivex.rxjava3.internal.operators.maybe;

import h00.f;
import h00.g;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.NotificationLite;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import z20.c;
import z20.d;

final class MaybeConcatArray$ConcatMaybeObserver<T> extends AtomicInteger implements f<T>, d {
    private static final long serialVersionUID = 3520831347801429610L;
    public final AtomicReference<Object> current = new AtomicReference<>(NotificationLite.COMPLETE);
    public final SequentialDisposable disposables = new SequentialDisposable();
    public final c<? super T> downstream;
    public int index;
    public long produced;
    public final AtomicLong requested = new AtomicLong();
    public final g<? extends T>[] sources;

    public MaybeConcatArray$ConcatMaybeObserver(c<? super T> cVar, g<? extends T>[] gVarArr) {
        this.downstream = cVar;
        this.sources = gVarArr;
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
                        int i11 = this.index;
                        g<? extends T>[] gVarArr = this.sources;
                        if (i11 == gVarArr.length) {
                            cVar.onComplete();
                            return;
                        } else {
                            this.index = i11 + 1;
                            gVarArr[i11].a(this);
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
