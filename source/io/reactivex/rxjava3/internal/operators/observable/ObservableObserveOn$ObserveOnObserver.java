package io.reactivex.rxjava3.internal.operators.observable;

import h00.k;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.exceptions.a;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.observers.BasicIntQueueDisposable;
import k00.f;

final class ObservableObserveOn$ObserveOnObserver<T> extends BasicIntQueueDisposable<T> implements k<T>, Runnable {
    private static final long serialVersionUID = 6576896619930983584L;
    public final int bufferSize;
    public final boolean delayError;
    public volatile boolean disposed;
    public volatile boolean done;
    public final k<? super T> downstream;
    public Throwable error;
    public boolean outputFused;
    public f<T> queue;
    public int sourceMode;
    public b upstream;
    public final Scheduler.Worker worker;

    public ObservableObserveOn$ObserveOnObserver(k<? super T> kVar, Scheduler.Worker worker2, boolean z11, int i11) {
        this.downstream = kVar;
        this.worker = worker2;
        this.delayError = z11;
        this.bufferSize = i11;
    }

    public boolean checkTerminated(boolean z11, boolean z12, k<? super T> kVar) {
        if (this.disposed) {
            this.queue.clear();
            return true;
        } else if (!z11) {
            return false;
        } else {
            Throwable th2 = this.error;
            if (this.delayError) {
                if (!z12) {
                    return false;
                }
                this.disposed = true;
                if (th2 != null) {
                    kVar.onError(th2);
                } else {
                    kVar.onComplete();
                }
                this.worker.dispose();
                return true;
            } else if (th2 != null) {
                this.disposed = true;
                this.queue.clear();
                kVar.onError(th2);
                this.worker.dispose();
                return true;
            } else if (!z12) {
                return false;
            } else {
                this.disposed = true;
                kVar.onComplete();
                this.worker.dispose();
                return true;
            }
        }
    }

    public void clear() {
        this.queue.clear();
    }

    public void dispose() {
        if (!this.disposed) {
            this.disposed = true;
            this.upstream.dispose();
            this.worker.dispose();
            if (!this.outputFused && getAndIncrement() == 0) {
                this.queue.clear();
            }
        }
    }

    public void drainFused() {
        int i11 = 1;
        while (!this.disposed) {
            boolean z11 = this.done;
            Throwable th2 = this.error;
            if (this.delayError || !z11 || th2 == null) {
                this.downstream.onNext(null);
                if (z11) {
                    this.disposed = true;
                    Throwable th3 = this.error;
                    if (th3 != null) {
                        this.downstream.onError(th3);
                    } else {
                        this.downstream.onComplete();
                    }
                    this.worker.dispose();
                    return;
                }
                i11 = addAndGet(-i11);
                if (i11 == 0) {
                    return;
                }
            } else {
                this.disposed = true;
                this.downstream.onError(this.error);
                this.worker.dispose();
                return;
            }
        }
    }

    public void drainNormal() {
        f<T> fVar = this.queue;
        k<? super T> kVar = this.downstream;
        int i11 = 1;
        while (!checkTerminated(this.done, fVar.isEmpty(), kVar)) {
            while (true) {
                boolean z11 = this.done;
                try {
                    T poll = fVar.poll();
                    boolean z12 = poll == null;
                    if (!checkTerminated(z11, z12, kVar)) {
                        if (z12) {
                            i11 = addAndGet(-i11);
                            if (i11 == 0) {
                                return;
                            }
                        } else {
                            kVar.onNext(poll);
                        }
                    } else {
                        return;
                    }
                } catch (Throwable th2) {
                    a.b(th2);
                    this.disposed = true;
                    this.upstream.dispose();
                    fVar.clear();
                    kVar.onError(th2);
                    this.worker.dispose();
                    return;
                }
            }
        }
    }

    public boolean isDisposed() {
        return this.disposed;
    }

    public boolean isEmpty() {
        return this.queue.isEmpty();
    }

    public void onComplete() {
        if (!this.done) {
            this.done = true;
            schedule();
        }
    }

    public void onError(Throwable th2) {
        if (this.done) {
            o00.a.n(th2);
            return;
        }
        this.error = th2;
        this.done = true;
        schedule();
    }

    public void onNext(T t11) {
        if (!this.done) {
            if (this.sourceMode != 2) {
                this.queue.offer(t11);
            }
            schedule();
        }
    }

    public void onSubscribe(b bVar) {
        if (DisposableHelper.validate(this.upstream, bVar)) {
            this.upstream = bVar;
            if (bVar instanceof k00.b) {
                k00.b bVar2 = (k00.b) bVar;
                int requestFusion = bVar2.requestFusion(7);
                if (requestFusion == 1) {
                    this.sourceMode = requestFusion;
                    this.queue = bVar2;
                    this.done = true;
                    this.downstream.onSubscribe(this);
                    schedule();
                    return;
                } else if (requestFusion == 2) {
                    this.sourceMode = requestFusion;
                    this.queue = bVar2;
                    this.downstream.onSubscribe(this);
                    return;
                }
            }
            this.queue = new io.reactivex.rxjava3.internal.queue.a(this.bufferSize);
            this.downstream.onSubscribe(this);
        }
    }

    public T poll() throws Throwable {
        return this.queue.poll();
    }

    public int requestFusion(int i11) {
        if ((i11 & 2) == 0) {
            return 0;
        }
        this.outputFused = true;
        return 2;
    }

    public void run() {
        if (this.outputFused) {
            drainFused();
        } else {
            drainNormal();
        }
    }

    public void schedule() {
        if (getAndIncrement() == 0) {
            this.worker.b(this);
        }
    }
}
