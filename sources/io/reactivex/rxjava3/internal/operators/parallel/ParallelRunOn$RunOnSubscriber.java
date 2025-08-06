package io.reactivex.rxjava3.internal.operators.parallel;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.internal.queue.SpscArrayQueue;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import z20.c;
import z20.d;

final class ParallelRunOn$RunOnSubscriber<T> extends ParallelRunOn$BaseRunOnSubscriber<T> {
    private static final long serialVersionUID = 1075119423897941642L;
    public final c<? super T> downstream;

    public ParallelRunOn$RunOnSubscriber(c<? super T> cVar, int i11, SpscArrayQueue<T> spscArrayQueue, Scheduler.Worker worker) {
        super(i11, spscArrayQueue, worker);
        this.downstream = cVar;
    }

    public void onSubscribe(d dVar) {
        if (SubscriptionHelper.validate(this.upstream, dVar)) {
            this.upstream = dVar;
            this.downstream.onSubscribe(this);
            dVar.request((long) this.prefetch);
        }
    }

    public void run() {
        int i11;
        Throwable th2;
        int i12 = this.consumed;
        SpscArrayQueue<T> spscArrayQueue = this.queue;
        c<? super T> cVar = this.downstream;
        int i13 = this.limit;
        int i14 = 1;
        while (true) {
            long j11 = this.requested.get();
            long j12 = 0;
            while (true) {
                i11 = (j12 > j11 ? 1 : (j12 == j11 ? 0 : -1));
                if (i11 == 0) {
                    break;
                } else if (this.cancelled) {
                    spscArrayQueue.clear();
                    return;
                } else {
                    boolean z11 = this.done;
                    if (!z11 || (th2 = this.error) == null) {
                        T poll = spscArrayQueue.poll();
                        boolean z12 = poll == null;
                        if (z11 && z12) {
                            cVar.onComplete();
                            this.worker.dispose();
                            return;
                        } else if (z12) {
                            break;
                        } else {
                            cVar.onNext(poll);
                            j12++;
                            i12++;
                            if (i12 == i13) {
                                this.upstream.request((long) i12);
                                i12 = 0;
                            }
                        }
                    } else {
                        spscArrayQueue.clear();
                        cVar.onError(th2);
                        this.worker.dispose();
                        return;
                    }
                }
            }
            if (i11 == 0) {
                if (this.cancelled) {
                    spscArrayQueue.clear();
                    return;
                } else if (this.done) {
                    Throwable th3 = this.error;
                    if (th3 != null) {
                        spscArrayQueue.clear();
                        cVar.onError(th3);
                        this.worker.dispose();
                        return;
                    } else if (spscArrayQueue.isEmpty()) {
                        cVar.onComplete();
                        this.worker.dispose();
                        return;
                    }
                }
            }
            if (!(j12 == 0 || j11 == Long.MAX_VALUE)) {
                this.requested.addAndGet(-j12);
            }
            int i15 = get();
            if (i15 == i14) {
                this.consumed = i12;
                i14 = addAndGet(-i14);
                if (i14 == 0) {
                    return;
                }
            } else {
                i14 = i15;
            }
        }
    }
}
