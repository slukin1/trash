package io.reactivex.rxjava3.internal.operators.flowable;

import h00.e;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.internal.queue.SpscArrayQueue;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.internal.util.c;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import z20.d;

final class BlockingFlowableIterable$BlockingFlowableIterator<T> extends AtomicReference<d> implements e<T>, Iterator<T>, Runnable, b {
    private static final long serialVersionUID = 6695226475494099826L;
    public final long batchSize;
    public final Condition condition;
    public volatile boolean done;
    public volatile Throwable error;
    public final long limit;
    public final Lock lock;
    public long produced;
    public final SpscArrayQueue<T> queue;

    public BlockingFlowableIterable$BlockingFlowableIterator(int i11) {
        this.queue = new SpscArrayQueue<>(i11);
        this.batchSize = (long) i11;
        this.limit = (long) (i11 - (i11 >> 2));
        ReentrantLock reentrantLock = new ReentrantLock();
        this.lock = reentrantLock;
        this.condition = reentrantLock.newCondition();
    }

    public void dispose() {
        SubscriptionHelper.cancel(this);
        signalConsumer();
    }

    public boolean hasNext() {
        while (!isDisposed()) {
            boolean z11 = this.done;
            boolean isEmpty = this.queue.isEmpty();
            if (z11) {
                Throwable th2 = this.error;
                if (th2 != null) {
                    throw ExceptionHelper.g(th2);
                } else if (isEmpty) {
                    return false;
                }
            }
            if (!isEmpty) {
                return true;
            }
            c.a();
            this.lock.lock();
            while (!this.done && this.queue.isEmpty() && !isDisposed()) {
                try {
                    this.condition.await();
                } catch (InterruptedException e11) {
                    run();
                    throw ExceptionHelper.g(e11);
                } catch (Throwable th3) {
                    this.lock.unlock();
                    throw th3;
                }
            }
            this.lock.unlock();
        }
        Throwable th4 = this.error;
        if (th4 == null) {
            return false;
        }
        throw ExceptionHelper.g(th4);
    }

    public boolean isDisposed() {
        return get() == SubscriptionHelper.CANCELLED;
    }

    public T next() {
        if (hasNext()) {
            T poll = this.queue.poll();
            long j11 = this.produced + 1;
            if (j11 == this.limit) {
                this.produced = 0;
                ((d) get()).request(j11);
            } else {
                this.produced = j11;
            }
            return poll;
        }
        throw new NoSuchElementException();
    }

    public void onComplete() {
        this.done = true;
        signalConsumer();
    }

    public void onError(Throwable th2) {
        this.error = th2;
        this.done = true;
        signalConsumer();
    }

    public void onNext(T t11) {
        if (!this.queue.offer(t11)) {
            SubscriptionHelper.cancel(this);
            onError(new MissingBackpressureException("Queue full?!"));
            return;
        }
        signalConsumer();
    }

    public void onSubscribe(d dVar) {
        SubscriptionHelper.setOnce(this, dVar, this.batchSize);
    }

    public void remove() {
        throw new UnsupportedOperationException("remove");
    }

    public void run() {
        SubscriptionHelper.cancel(this);
        signalConsumer();
    }

    public void signalConsumer() {
        this.lock.lock();
        try {
            this.condition.signalAll();
        } finally {
            this.lock.unlock();
        }
    }
}
