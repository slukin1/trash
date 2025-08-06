package rx.internal.operators;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import rx.Notification;
import rx.Observable;
import rx.Subscriber;
import rx.exceptions.Exceptions;

public final class BlockingOperatorNext {

    public static final class NextIterator<T> implements Iterator<T> {
        private Throwable error;
        private boolean hasNext = true;
        private boolean isNextConsumed = true;
        private final Observable<? extends T> items;
        private T next;
        private final NextObserver<T> observer;
        private boolean started;

        public NextIterator(Observable<? extends T> observable, NextObserver<T> nextObserver) {
            this.items = observable;
            this.observer = nextObserver;
        }

        private boolean moveToNext() {
            try {
                if (!this.started) {
                    this.started = true;
                    this.observer.setWaiting(1);
                    this.items.materialize().subscribe(this.observer);
                }
                Notification<? extends T> takeNext = this.observer.takeNext();
                if (takeNext.isOnNext()) {
                    this.isNextConsumed = false;
                    this.next = takeNext.getValue();
                    return true;
                }
                this.hasNext = false;
                if (takeNext.isOnCompleted()) {
                    return false;
                }
                if (takeNext.isOnError()) {
                    Throwable throwable = takeNext.getThrowable();
                    this.error = throwable;
                    throw Exceptions.propagate(throwable);
                }
                throw new IllegalStateException("Should not reach here");
            } catch (InterruptedException e11) {
                this.observer.unsubscribe();
                Thread.currentThread().interrupt();
                this.error = e11;
                throw Exceptions.propagate(e11);
            }
        }

        public boolean hasNext() {
            Throwable th2 = this.error;
            if (th2 != null) {
                throw Exceptions.propagate(th2);
            } else if (!this.hasNext) {
                return false;
            } else {
                if (!this.isNextConsumed || moveToNext()) {
                    return true;
                }
                return false;
            }
        }

        public T next() {
            Throwable th2 = this.error;
            if (th2 != null) {
                throw Exceptions.propagate(th2);
            } else if (hasNext()) {
                this.isNextConsumed = true;
                return this.next;
            } else {
                throw new NoSuchElementException("No more elements");
            }
        }

        public void remove() {
            throw new UnsupportedOperationException("Read only iterator");
        }
    }

    public static final class NextObserver<T> extends Subscriber<Notification<? extends T>> {
        private final BlockingQueue<Notification<? extends T>> buf = new ArrayBlockingQueue(1);
        public final AtomicInteger waiting = new AtomicInteger();

        public void onCompleted() {
        }

        public void onError(Throwable th2) {
        }

        public void setWaiting(int i11) {
            this.waiting.set(i11);
        }

        public Notification<? extends T> takeNext() throws InterruptedException {
            setWaiting(1);
            return this.buf.take();
        }

        public void onNext(Notification<? extends T> notification) {
            if (this.waiting.getAndSet(0) == 1 || !notification.isOnNext()) {
                while (!this.buf.offer(notification)) {
                    Notification<? extends T> notification2 = (Notification) this.buf.poll();
                    if (notification2 != null && !notification2.isOnNext()) {
                        notification = notification2;
                    }
                }
            }
        }
    }

    private BlockingOperatorNext() {
        throw new IllegalStateException("No instances!");
    }

    public static <T> Iterable<T> next(final Observable<? extends T> observable) {
        return new Iterable<T>() {
            public Iterator<T> iterator() {
                return new NextIterator(observable, new NextObserver());
            }
        };
    }
}
