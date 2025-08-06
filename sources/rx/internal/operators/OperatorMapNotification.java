package rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.Observable;
import rx.Observer;
import rx.Producer;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Func0;
import rx.functions.Func1;

public final class OperatorMapNotification<T, R> implements Observable.Operator<R, T> {
    public final Func0<? extends R> onCompleted;
    public final Func1<? super Throwable, ? extends R> onError;
    public final Func1<? super T, ? extends R> onNext;

    public static final class MapNotificationSubscriber<T, R> extends Subscriber<T> {
        public static final long COMPLETED_FLAG = Long.MIN_VALUE;
        public static final long REQUESTED_MASK = Long.MAX_VALUE;
        public final Subscriber<? super R> actual;
        public final AtomicLong missedRequested = new AtomicLong();
        public final Func0<? extends R> onCompleted;
        public final Func1<? super Throwable, ? extends R> onError;
        public final Func1<? super T, ? extends R> onNext;
        public long produced;
        public final AtomicReference<Producer> producer = new AtomicReference<>();
        public final AtomicLong requested = new AtomicLong();
        public R value;

        public MapNotificationSubscriber(Subscriber<? super R> subscriber, Func1<? super T, ? extends R> func1, Func1<? super Throwable, ? extends R> func12, Func0<? extends R> func0) {
            this.actual = subscriber;
            this.onNext = func1;
            this.onError = func12;
            this.onCompleted = func0;
        }

        public void accountProduced() {
            long j11 = this.produced;
            if (j11 != 0 && this.producer.get() != null) {
                BackpressureUtils.produced(this.requested, j11);
            }
        }

        public void onCompleted() {
            accountProduced();
            try {
                this.value = this.onCompleted.call();
            } catch (Throwable th2) {
                Exceptions.throwOrReport(th2, (Observer<?>) this.actual);
            }
            tryEmit();
        }

        public void onError(Throwable th2) {
            accountProduced();
            try {
                this.value = this.onError.call(th2);
            } catch (Throwable th3) {
                Exceptions.throwOrReport(th3, (Observer<?>) this.actual, (Object) th2);
            }
            tryEmit();
        }

        public void onNext(T t11) {
            try {
                this.produced++;
                this.actual.onNext(this.onNext.call(t11));
            } catch (Throwable th2) {
                Exceptions.throwOrReport(th2, (Observer<?>) this.actual, (Object) t11);
            }
        }

        public void requestInner(long j11) {
            int i11 = (j11 > 0 ? 1 : (j11 == 0 ? 0 : -1));
            if (i11 < 0) {
                throw new IllegalArgumentException("n >= 0 required but it was " + j11);
            } else if (i11 != 0) {
                while (true) {
                    long j12 = this.requested.get();
                    if ((j12 & Long.MIN_VALUE) != 0) {
                        long j13 = Long.MAX_VALUE & j12;
                        if (this.requested.compareAndSet(j12, Long.MIN_VALUE | BackpressureUtils.addCap(j13, j11))) {
                            if (j13 == 0) {
                                if (!this.actual.isUnsubscribed()) {
                                    this.actual.onNext(this.value);
                                }
                                if (!this.actual.isUnsubscribed()) {
                                    this.actual.onCompleted();
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                    } else {
                        if (this.requested.compareAndSet(j12, BackpressureUtils.addCap(j12, j11))) {
                            AtomicReference<Producer> atomicReference = this.producer;
                            Producer producer2 = atomicReference.get();
                            if (producer2 != null) {
                                producer2.request(j11);
                                return;
                            }
                            BackpressureUtils.getAndAddRequest(this.missedRequested, j11);
                            Producer producer3 = atomicReference.get();
                            if (producer3 != null) {
                                long andSet = this.missedRequested.getAndSet(0);
                                if (andSet != 0) {
                                    producer3.request(andSet);
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                    }
                }
            }
        }

        public void setProducer(Producer producer2) {
            if (this.producer.compareAndSet((Object) null, producer2)) {
                long andSet = this.missedRequested.getAndSet(0);
                if (andSet != 0) {
                    producer2.request(andSet);
                    return;
                }
                return;
            }
            throw new IllegalStateException("Producer already set!");
        }

        public void tryEmit() {
            long j11;
            do {
                j11 = this.requested.get();
                if ((j11 & Long.MIN_VALUE) != 0) {
                    return;
                }
            } while (!this.requested.compareAndSet(j11, Long.MIN_VALUE | j11));
            if (j11 != 0 || this.producer.get() == null) {
                if (!this.actual.isUnsubscribed()) {
                    this.actual.onNext(this.value);
                }
                if (!this.actual.isUnsubscribed()) {
                    this.actual.onCompleted();
                }
            }
        }
    }

    public OperatorMapNotification(Func1<? super T, ? extends R> func1, Func1<? super Throwable, ? extends R> func12, Func0<? extends R> func0) {
        this.onNext = func1;
        this.onError = func12;
        this.onCompleted = func0;
    }

    public Subscriber<? super T> call(Subscriber<? super R> subscriber) {
        final MapNotificationSubscriber mapNotificationSubscriber = new MapNotificationSubscriber(subscriber, this.onNext, this.onError, this.onCompleted);
        subscriber.add(mapNotificationSubscriber);
        subscriber.setProducer(new Producer() {
            public void request(long j11) {
                mapNotificationSubscriber.requestInner(j11);
            }
        });
        return mapNotificationSubscriber;
    }
}
