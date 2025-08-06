package io.reactivex.rxjava3.internal.jdk8;

import h00.f;
import h00.k;
import h00.m;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.exceptions.a;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.observers.BasicIntQueueDisposable;
import j00.h;
import java.util.Iterator;
import java.util.Objects;
import java.util.stream.Stream;

final class MaybeFlattenStreamAsObservable$FlattenStreamMultiObserver<T, R> extends BasicIntQueueDisposable<R> implements f<T>, m<T> {
    private static final long serialVersionUID = 7363336003027148283L;
    public AutoCloseable close;
    public volatile boolean disposed;
    public final k<? super R> downstream;
    public volatile Iterator<? extends R> iterator;
    public final h<? super T, ? extends Stream<? extends R>> mapper;
    public boolean once;
    public boolean outputFused;
    public b upstream;

    public MaybeFlattenStreamAsObservable$FlattenStreamMultiObserver(k<? super R> kVar, h<? super T, ? extends Stream<? extends R>> hVar) {
        this.downstream = kVar;
        this.mapper = hVar;
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

    public void dispose() {
        this.disposed = true;
        this.upstream.dispose();
        if (!this.outputFused) {
            drain();
        }
    }

    public void drain() {
        if (getAndIncrement() == 0) {
            k<? super R> kVar = this.downstream;
            Iterator<? extends R> it2 = this.iterator;
            int i11 = 1;
            while (true) {
                if (this.disposed) {
                    clear();
                } else if (this.outputFused) {
                    kVar.onNext(null);
                    kVar.onComplete();
                } else {
                    try {
                        Object next = it2.next();
                        if (!this.disposed) {
                            kVar.onNext(next);
                            if (!this.disposed) {
                                try {
                                    boolean hasNext = it2.hasNext();
                                    if (!this.disposed && !hasNext) {
                                        kVar.onComplete();
                                        this.disposed = true;
                                    }
                                } catch (Throwable th2) {
                                    a.b(th2);
                                    kVar.onError(th2);
                                    this.disposed = true;
                                }
                            }
                        }
                    } catch (Throwable th3) {
                        a.b(th3);
                        kVar.onError(th3);
                        this.disposed = true;
                    }
                }
                i11 = addAndGet(-i11);
                if (i11 == 0) {
                    return;
                }
            }
        }
    }

    public boolean isDisposed() {
        return this.disposed;
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

    public int requestFusion(int i11) {
        if ((i11 & 2) == 0) {
            return 0;
        }
        this.outputFused = true;
        return 2;
    }
}
