package io.reactivex.rxjava3.internal.operators.parallel;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.internal.queue.SpscArrayQueue;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.b;
import k00.a;
import z20.d;

final class ParallelRunOn$RunOnConditionalSubscriber<T> extends ParallelRunOn$BaseRunOnSubscriber<T> {
    private static final long serialVersionUID = 1075119423897941642L;
    public final a<? super T> downstream;

    public ParallelRunOn$RunOnConditionalSubscriber(a<? super T> aVar, int i11, SpscArrayQueue<T> spscArrayQueue, Scheduler.Worker worker) {
        super(i11, spscArrayQueue, worker);
        this.downstream = aVar;
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
        a<? super T> aVar = this.downstream;
        int i13 = this.limit;
        int i14 = 1;
        do {
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
                            aVar.onComplete();
                            this.worker.dispose();
                            return;
                        } else if (z12) {
                            break;
                        } else {
                            if (aVar.tryOnNext(poll)) {
                                j12++;
                            }
                            i12++;
                            if (i12 == i13) {
                                this.upstream.request((long) i12);
                                i12 = 0;
                            }
                        }
                    } else {
                        spscArrayQueue.clear();
                        aVar.onError(th2);
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
                        aVar.onError(th3);
                        this.worker.dispose();
                        return;
                    } else if (spscArrayQueue.isEmpty()) {
                        aVar.onComplete();
                        this.worker.dispose();
                        return;
                    }
                }
            }
            if (j12 != 0) {
                b.e(this.requested, j12);
            }
            this.consumed = i12;
            i14 = addAndGet(-i14);
        } while (i14 != 0);
    }
}
