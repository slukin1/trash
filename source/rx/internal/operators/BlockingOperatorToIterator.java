package rx.internal.operators;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import rx.Notification;
import rx.Observable;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.internal.util.RxRingBuffer;

public final class BlockingOperatorToIterator {

    public static final class SubscriberIterator<T> extends Subscriber<Notification<? extends T>> implements Iterator<T> {
        public static final int LIMIT = ((RxRingBuffer.SIZE * 3) / 4);
        private Notification<? extends T> buf;
        private final BlockingQueue<Notification<? extends T>> notifications = new LinkedBlockingQueue();
        private int received;

        private Notification<? extends T> take() {
            try {
                Notification<? extends T> notification = (Notification) this.notifications.poll();
                if (notification != null) {
                    return notification;
                }
                return this.notifications.take();
            } catch (InterruptedException e11) {
                unsubscribe();
                throw Exceptions.propagate(e11);
            }
        }

        public boolean hasNext() {
            if (this.buf == null) {
                this.buf = take();
                int i11 = this.received + 1;
                this.received = i11;
                if (i11 >= LIMIT) {
                    request((long) i11);
                    this.received = 0;
                }
            }
            if (!this.buf.isOnError()) {
                return !this.buf.isOnCompleted();
            }
            throw Exceptions.propagate(this.buf.getThrowable());
        }

        public T next() {
            if (hasNext()) {
                T value = this.buf.getValue();
                this.buf = null;
                return value;
            }
            throw new NoSuchElementException();
        }

        public void onCompleted() {
        }

        public void onError(Throwable th2) {
            this.notifications.offer(Notification.createOnError(th2));
        }

        public void onStart() {
            request((long) RxRingBuffer.SIZE);
        }

        public void remove() {
            throw new UnsupportedOperationException("Read-only iterator");
        }

        public void onNext(Notification<? extends T> notification) {
            this.notifications.offer(notification);
        }
    }

    private BlockingOperatorToIterator() {
        throw new IllegalStateException("No instances!");
    }

    public static <T> Iterator<T> toIterator(Observable<? extends T> observable) {
        SubscriberIterator subscriberIterator = new SubscriberIterator();
        observable.materialize().subscribe(subscriberIterator);
        return subscriberIterator;
    }
}
