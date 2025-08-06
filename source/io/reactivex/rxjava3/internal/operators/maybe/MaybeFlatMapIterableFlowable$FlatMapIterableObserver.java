package io.reactivex.rxjava3.internal.operators.maybe;

import h00.f;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.exceptions.a;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import j00.h;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import z20.c;

final class MaybeFlatMapIterableFlowable$FlatMapIterableObserver<T, R> extends BasicIntQueueSubscription<R> implements f<T> {
    private static final long serialVersionUID = -8938804753851907758L;
    public volatile boolean cancelled;
    public final c<? super R> downstream;

    /* renamed from: it  reason: collision with root package name */
    public volatile Iterator<? extends R> f55537it;
    public final h<? super T, ? extends Iterable<? extends R>> mapper;
    public boolean outputFused;
    public final AtomicLong requested = new AtomicLong();
    public b upstream;

    public MaybeFlatMapIterableFlowable$FlatMapIterableObserver(c<? super R> cVar, h<? super T, ? extends Iterable<? extends R>> hVar) {
        this.downstream = cVar;
        this.mapper = hVar;
    }

    public void cancel() {
        this.cancelled = true;
        this.upstream.dispose();
        this.upstream = DisposableHelper.DISPOSED;
    }

    public void clear() {
        this.f55537it = null;
    }

    public void drain() {
        if (getAndIncrement() == 0) {
            c<? super R> cVar = this.downstream;
            Iterator<? extends R> it2 = this.f55537it;
            if (!this.outputFused || it2 == null) {
                int i11 = 1;
                while (true) {
                    if (it2 != null) {
                        long j11 = this.requested.get();
                        if (j11 == Long.MAX_VALUE) {
                            fastPath(cVar, it2);
                            return;
                        }
                        long j12 = 0;
                        while (j12 != j11) {
                            if (!this.cancelled) {
                                try {
                                    Object next = it2.next();
                                    Objects.requireNonNull(next, "The iterator returned a null value");
                                    cVar.onNext(next);
                                    if (!this.cancelled) {
                                        j12++;
                                        try {
                                            if (!it2.hasNext()) {
                                                cVar.onComplete();
                                                return;
                                            }
                                        } catch (Throwable th2) {
                                            a.b(th2);
                                            cVar.onError(th2);
                                            return;
                                        }
                                    } else {
                                        return;
                                    }
                                } catch (Throwable th3) {
                                    a.b(th3);
                                    cVar.onError(th3);
                                    return;
                                }
                            } else {
                                return;
                            }
                        }
                        if (j12 != 0) {
                            io.reactivex.rxjava3.internal.util.b.e(this.requested, j12);
                        }
                    }
                    i11 = addAndGet(-i11);
                    if (i11 != 0) {
                        if (it2 == null) {
                            it2 = this.f55537it;
                        }
                    } else {
                        return;
                    }
                }
            } else {
                cVar.onNext(null);
                cVar.onComplete();
            }
        }
    }

    public void fastPath(c<? super R> cVar, Iterator<? extends R> it2) {
        while (!this.cancelled) {
            try {
                cVar.onNext(it2.next());
                if (!this.cancelled) {
                    try {
                        if (!it2.hasNext()) {
                            cVar.onComplete();
                            return;
                        }
                    } catch (Throwable th2) {
                        a.b(th2);
                        cVar.onError(th2);
                        return;
                    }
                } else {
                    return;
                }
            } catch (Throwable th3) {
                a.b(th3);
                cVar.onError(th3);
                return;
            }
        }
    }

    public boolean isEmpty() {
        return this.f55537it == null;
    }

    public void onComplete() {
        this.downstream.onComplete();
    }

    public void onError(Throwable th2) {
        this.upstream = DisposableHelper.DISPOSED;
        this.downstream.onError(th2);
    }

    public void onSubscribe(b bVar) {
        if (DisposableHelper.validate(this.upstream, bVar)) {
            this.upstream = bVar;
            this.downstream.onSubscribe(this);
        }
    }

    public void onSuccess(T t11) {
        try {
            Iterator<? extends R> it2 = ((Iterable) this.mapper.apply(t11)).iterator();
            if (!it2.hasNext()) {
                this.downstream.onComplete();
                return;
            }
            this.f55537it = it2;
            drain();
        } catch (Throwable th2) {
            a.b(th2);
            this.downstream.onError(th2);
        }
    }

    public R poll() {
        Iterator<? extends R> it2 = this.f55537it;
        if (it2 == null) {
            return null;
        }
        R next = it2.next();
        Objects.requireNonNull(next, "The iterator returned a null value");
        if (!it2.hasNext()) {
            this.f55537it = null;
        }
        return next;
    }

    public void request(long j11) {
        if (SubscriptionHelper.validate(j11)) {
            io.reactivex.rxjava3.internal.util.b.a(this.requested, j11);
            drain();
        }
    }

    public int requestFusion(int i11) {
        if ((i11 & 2) == 0) {
            return 0;
        }
        this.outputFused = true;
        return 2;
    }
}
