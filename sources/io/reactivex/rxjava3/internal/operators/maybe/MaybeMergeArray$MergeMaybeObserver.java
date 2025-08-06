package io.reactivex.rxjava3.internal.operators.maybe;

import h00.f;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.NotificationLite;
import java.util.concurrent.atomic.AtomicLong;
import z20.c;

final class MaybeMergeArray$MergeMaybeObserver<T> extends BasicIntQueueSubscription<T> implements f<T> {
    private static final long serialVersionUID = -660395290758764731L;
    public volatile boolean cancelled;
    public long consumed;
    public final c<? super T> downstream;
    public final AtomicThrowable errors = new AtomicThrowable();
    public boolean outputFused;
    public final c<Object> queue;
    public final AtomicLong requested = new AtomicLong();
    public final CompositeDisposable set = new CompositeDisposable();
    public final int sourceCount;

    public MaybeMergeArray$MergeMaybeObserver(c<? super T> cVar, int i11, c<Object> cVar2) {
        this.downstream = cVar;
        this.sourceCount = i11;
        this.queue = cVar2;
    }

    public void cancel() {
        if (!this.cancelled) {
            this.cancelled = true;
            this.set.dispose();
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }
    }

    public void clear() {
        this.queue.clear();
    }

    public void drain() {
        if (getAndIncrement() == 0) {
            if (this.outputFused) {
                drainFused();
            } else {
                drainNormal();
            }
        }
    }

    public void drainFused() {
        c<? super T> cVar = this.downstream;
        c<Object> cVar2 = this.queue;
        int i11 = 1;
        while (!this.cancelled) {
            Throwable th2 = (Throwable) this.errors.get();
            if (th2 != null) {
                cVar2.clear();
                cVar.onError(th2);
                return;
            }
            boolean z11 = cVar2.producerIndex() == this.sourceCount;
            if (!cVar2.isEmpty()) {
                cVar.onNext(null);
            }
            if (z11) {
                cVar.onComplete();
                return;
            }
            i11 = addAndGet(-i11);
            if (i11 == 0) {
                return;
            }
        }
        cVar2.clear();
    }

    public void drainNormal() {
        int i11;
        c<? super T> cVar = this.downstream;
        c<Object> cVar2 = this.queue;
        long j11 = this.consumed;
        int i12 = 1;
        do {
            long j12 = this.requested.get();
            while (true) {
                i11 = (j11 > j12 ? 1 : (j11 == j12 ? 0 : -1));
                if (i11 == 0) {
                    break;
                } else if (this.cancelled) {
                    cVar2.clear();
                    return;
                } else if (((Throwable) this.errors.get()) != null) {
                    cVar2.clear();
                    this.errors.tryTerminateConsumer((c<?>) this.downstream);
                    return;
                } else if (cVar2.consumerIndex() == this.sourceCount) {
                    cVar.onComplete();
                    return;
                } else {
                    Object poll = cVar2.poll();
                    if (poll == null) {
                        break;
                    } else if (poll != NotificationLite.COMPLETE) {
                        cVar.onNext(poll);
                        j11++;
                    }
                }
            }
            if (i11 == 0) {
                if (((Throwable) this.errors.get()) != null) {
                    cVar2.clear();
                    this.errors.tryTerminateConsumer((c<?>) this.downstream);
                    return;
                }
                while (cVar2.peek() == NotificationLite.COMPLETE) {
                    cVar2.drop();
                }
                if (cVar2.consumerIndex() == this.sourceCount) {
                    cVar.onComplete();
                    return;
                }
            }
            this.consumed = j11;
            i12 = addAndGet(-i12);
        } while (i12 != 0);
    }

    public boolean isCancelled() {
        return this.cancelled;
    }

    public boolean isEmpty() {
        return this.queue.isEmpty();
    }

    public void onComplete() {
        this.queue.offer(NotificationLite.COMPLETE);
        drain();
    }

    public void onError(Throwable th2) {
        if (this.errors.tryAddThrowableOrReport(th2)) {
            this.set.dispose();
            this.queue.offer(NotificationLite.COMPLETE);
            drain();
        }
    }

    public void onSubscribe(b bVar) {
        this.set.a(bVar);
    }

    public void onSuccess(T t11) {
        this.queue.offer(t11);
        drain();
    }

    public T poll() {
        T poll;
        do {
            poll = this.queue.poll();
        } while (poll == NotificationLite.COMPLETE);
        return poll;
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
