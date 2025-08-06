package io.reactivex.rxjava3.internal.operators.parallel;

import h00.e;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.internal.queue.SpscArrayQueue;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.b;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import o00.a;
import z20.d;

abstract class ParallelRunOn$BaseRunOnSubscriber<T> extends AtomicInteger implements e<T>, d, Runnable {
    private static final long serialVersionUID = 9222303586456402150L;
    public volatile boolean cancelled;
    public int consumed;
    public volatile boolean done;
    public Throwable error;
    public final int limit;
    public final int prefetch;
    public final SpscArrayQueue<T> queue;
    public final AtomicLong requested = new AtomicLong();
    public d upstream;
    public final Scheduler.Worker worker;

    public ParallelRunOn$BaseRunOnSubscriber(int i11, SpscArrayQueue<T> spscArrayQueue, Scheduler.Worker worker2) {
        this.prefetch = i11;
        this.queue = spscArrayQueue;
        this.limit = i11 - (i11 >> 2);
        this.worker = worker2;
    }

    public final void cancel() {
        if (!this.cancelled) {
            this.cancelled = true;
            this.upstream.cancel();
            this.worker.dispose();
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }
    }

    public final void onComplete() {
        if (!this.done) {
            this.done = true;
            schedule();
        }
    }

    public final void onError(Throwable th2) {
        if (this.done) {
            a.n(th2);
            return;
        }
        this.error = th2;
        this.done = true;
        schedule();
    }

    public final void onNext(T t11) {
        if (!this.done) {
            if (!this.queue.offer(t11)) {
                this.upstream.cancel();
                onError(new MissingBackpressureException("Queue is full?!"));
                return;
            }
            schedule();
        }
    }

    public abstract /* synthetic */ void onSubscribe(d dVar);

    public final void request(long j11) {
        if (SubscriptionHelper.validate(j11)) {
            b.a(this.requested, j11);
            schedule();
        }
    }

    public final void schedule() {
        if (getAndIncrement() == 0) {
            this.worker.b(this);
        }
    }
}
