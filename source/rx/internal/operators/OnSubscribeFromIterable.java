package rx.internal.operators;

import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import rx.Observable;
import rx.Observer;
import rx.Producer;
import rx.Subscriber;
import rx.exceptions.Exceptions;

public final class OnSubscribeFromIterable<T> implements Observable.OnSubscribe<T> {

    /* renamed from: is  reason: collision with root package name */
    public final Iterable<? extends T> f53404is;

    public static final class IterableProducer<T> extends AtomicLong implements Producer {
        private static final long serialVersionUID = -8730475647105475802L;

        /* renamed from: it  reason: collision with root package name */
        private final Iterator<? extends T> f53405it;

        /* renamed from: o  reason: collision with root package name */
        private final Subscriber<? super T> f53406o;

        public IterableProducer(Subscriber<? super T> subscriber, Iterator<? extends T> it2) {
            this.f53406o = subscriber;
            this.f53405it = it2;
        }

        public void fastPath() {
            Subscriber<? super T> subscriber = this.f53406o;
            Iterator<? extends T> it2 = this.f53405it;
            while (!subscriber.isUnsubscribed()) {
                try {
                    subscriber.onNext(it2.next());
                    if (!subscriber.isUnsubscribed()) {
                        try {
                            if (!it2.hasNext()) {
                                if (!subscriber.isUnsubscribed()) {
                                    subscriber.onCompleted();
                                    return;
                                }
                                return;
                            }
                        } catch (Throwable th2) {
                            Exceptions.throwOrReport(th2, (Observer<?>) subscriber);
                            return;
                        }
                    } else {
                        return;
                    }
                } catch (Throwable th3) {
                    Exceptions.throwOrReport(th3, (Observer<?>) subscriber);
                    return;
                }
            }
        }

        public void request(long j11) {
            if (get() != Long.MAX_VALUE) {
                if (j11 == Long.MAX_VALUE && compareAndSet(0, Long.MAX_VALUE)) {
                    fastPath();
                } else if (j11 > 0 && BackpressureUtils.getAndAddRequest(this, j11) == 0) {
                    slowPath(j11);
                }
            }
        }

        public void slowPath(long j11) {
            Subscriber<? super T> subscriber = this.f53406o;
            Iterator<? extends T> it2 = this.f53405it;
            do {
                long j12 = 0;
                while (true) {
                    if (j12 == j11) {
                        j11 = get();
                        if (j12 == j11) {
                            j11 = BackpressureUtils.produced(this, j12);
                        }
                    } else if (!subscriber.isUnsubscribed()) {
                        try {
                            subscriber.onNext(it2.next());
                            if (!subscriber.isUnsubscribed()) {
                                try {
                                    if (it2.hasNext()) {
                                        j12++;
                                    } else if (!subscriber.isUnsubscribed()) {
                                        subscriber.onCompleted();
                                        return;
                                    } else {
                                        return;
                                    }
                                } catch (Throwable th2) {
                                    Exceptions.throwOrReport(th2, (Observer<?>) subscriber);
                                    return;
                                }
                            } else {
                                return;
                            }
                        } catch (Throwable th3) {
                            Exceptions.throwOrReport(th3, (Observer<?>) subscriber);
                            return;
                        }
                    } else {
                        return;
                    }
                }
            } while (j11 != 0);
        }
    }

    public OnSubscribeFromIterable(Iterable<? extends T> iterable) {
        Objects.requireNonNull(iterable, "iterable must not be null");
        this.f53404is = iterable;
    }

    public void call(Subscriber<? super T> subscriber) {
        try {
            Iterator<? extends T> it2 = this.f53404is.iterator();
            boolean hasNext = it2.hasNext();
            if (subscriber.isUnsubscribed()) {
                return;
            }
            if (!hasNext) {
                subscriber.onCompleted();
            } else {
                subscriber.setProducer(new IterableProducer(subscriber, it2));
            }
        } catch (Throwable th2) {
            Exceptions.throwOrReport(th2, (Observer<?>) subscriber);
        }
    }
}
