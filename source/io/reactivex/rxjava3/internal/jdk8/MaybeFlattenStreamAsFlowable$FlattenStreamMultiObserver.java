package io.reactivex.rxjava3.internal.jdk8;

import h00.f;
import h00.m;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.exceptions.a;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import j00.h;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Stream;
import z20.c;

final class MaybeFlattenStreamAsFlowable$FlattenStreamMultiObserver<T, R> extends BasicIntQueueSubscription<R> implements f<T>, m<T> {
    private static final long serialVersionUID = 7363336003027148283L;
    public volatile boolean cancelled;
    public AutoCloseable close;
    public final c<? super R> downstream;
    public long emitted;
    public volatile Iterator<? extends R> iterator;
    public final h<? super T, ? extends Stream<? extends R>> mapper;
    public boolean once;
    public boolean outputFused;
    public final AtomicLong requested = new AtomicLong();
    public b upstream;

    public MaybeFlattenStreamAsFlowable$FlattenStreamMultiObserver(c<? super R> cVar, h<? super T, ? extends Stream<? extends R>> hVar) {
        this.downstream = cVar;
        this.mapper = hVar;
    }

    public void cancel() {
        this.cancelled = true;
        this.upstream.dispose();
        if (!this.outputFused) {
            drain();
        }
    }

    public void clear() {
        this.iterator = null;
        AutoCloseable autoCloseable = this.close;
        this.close = null;
        close(autoCloseable);
    }

    public void close(AutoCloseable autoCloseable) {
        if (autoCloseable != null) {
            try {
                autoCloseable.close();
            } catch (Throwable th2) {
                a.b(th2);
                o00.a.n(th2);
            }
        }
    }

    public void drain() {
        if (getAndIncrement() == 0) {
            c<? super R> cVar = this.downstream;
            long j11 = this.emitted;
            long j12 = this.requested.get();
            Iterator<? extends R> it2 = this.iterator;
            int i11 = 1;
            while (true) {
                if (this.cancelled) {
                    clear();
                } else if (this.outputFused) {
                    if (it2 != null) {
                        cVar.onNext(null);
                        cVar.onComplete();
                    }
                } else if (!(it2 == null || j11 == j12)) {
                    try {
                        Object next = it2.next();
                        if (!this.cancelled) {
                            cVar.onNext(next);
                            j11++;
                            if (!this.cancelled) {
                                try {
                                    boolean hasNext = it2.hasNext();
                                    if (!this.cancelled && !hasNext) {
                                        cVar.onComplete();
                                        this.cancelled = true;
                                    }
                                } catch (Throwable th2) {
                                    a.b(th2);
                                    cVar.onError(th2);
                                    this.cancelled = true;
                                }
                            }
                        }
                    } catch (Throwable th3) {
                        a.b(th3);
                        cVar.onError(th3);
                        this.cancelled = true;
                    }
                }
                this.emitted = j11;
                i11 = addAndGet(-i11);
                if (i11 != 0) {
                    j12 = this.requested.get();
                    if (it2 == null) {
                        it2 = this.iterator;
                    }
                } else {
                    return;
                }
            }
        }
    }

    public boolean isEmpty() {
        Iterator<? extends R> it2 = this.iterator;
        if (it2 == null) {
            return true;
        }
        if (!this.once || it2.hasNext()) {
            return false;
        }
        clear();
        return true;
    }

    public void onComplete() {
        this.downstream.onComplete();
    }

    public void onError(Throwable th2) {
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
            Object apply = this.mapper.apply(t11);
            Objects.requireNonNull(apply, "The mapper returned a null Stream");
            Stream stream = (Stream) apply;
            Iterator<? extends R> it2 = stream.iterator();
            if (!it2.hasNext()) {
                this.downstream.onComplete();
                close(stream);
                return;
            }
            this.iterator = it2;
            this.close = stream;
            drain();
        } catch (Throwable th2) {
            a.b(th2);
            this.downstream.onError(th2);
        }
    }

    public R poll() throws Throwable {
        Iterator<? extends R> it2 = this.iterator;
        if (it2 == null) {
            return null;
        }
        if (!this.once) {
            this.once = true;
        } else if (!it2.hasNext()) {
            clear();
            return null;
        }
        return it2.next();
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
