package io.reactivex.rxjava3.internal.operators.observable;

import h00.k;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.queue.a;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.internal.util.c;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

final class BlockingObservableIterable$BlockingObservableIterator<T> extends AtomicReference<b> implements k<T>, Iterator<T>, b {
    private static final long serialVersionUID = 6695226475494099826L;
    public final Condition condition;
    public volatile boolean done;
    public volatile Throwable error;
    public final Lock lock;
    public final a<T> queue;

    public BlockingObservableIterable$BlockingObservableIterator(int i11) {
        this.queue = new a<>(i11);
        ReentrantLock reentrantLock = new ReentrantLock();
        this.lock = reentrantLock;
        this.condition = reentrantLock.newCondition();
    }

    public void dispose() {
        DisposableHelper.dispose(this);
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
                    DisposableHelper.dispose(this);
                    signalConsumer();
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
        return DisposableHelper.isDisposed((b) get());
    }

    public T next() {
        if (hasNext()) {
            return this.queue.poll();
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
        this.queue.offer(t11);
        signalConsumer();
    }

    public void onSubscribe(b bVar) {
        DisposableHelper.setOnce(this, bVar);
    }

    public void remove() {
        throw new UnsupportedOperationException("remove");
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
