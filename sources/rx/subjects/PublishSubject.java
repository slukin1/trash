package rx.subjects;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.Observable;
import rx.Observer;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.Exceptions;
import rx.exceptions.MissingBackpressureException;
import rx.internal.operators.BackpressureUtils;

public final class PublishSubject<T> extends Subject<T, T> {
    public final PublishSubjectState<T> state;

    public static final class PublishSubjectProducer<T> extends AtomicLong implements Producer, Subscription, Observer<T> {
        private static final long serialVersionUID = 6451806817170721536L;
        public final Subscriber<? super T> actual;
        public final PublishSubjectState<T> parent;
        public long produced;

        public PublishSubjectProducer(PublishSubjectState<T> publishSubjectState, Subscriber<? super T> subscriber) {
            this.parent = publishSubjectState;
            this.actual = subscriber;
        }

        public boolean isUnsubscribed() {
            return get() == Long.MIN_VALUE;
        }

        public void onCompleted() {
            if (get() != Long.MIN_VALUE) {
                this.actual.onCompleted();
            }
        }

        public void onError(Throwable th2) {
            if (get() != Long.MIN_VALUE) {
                this.actual.onError(th2);
            }
        }

        public void onNext(T t11) {
            long j11 = get();
            if (j11 != Long.MIN_VALUE) {
                long j12 = this.produced;
                if (j11 != j12) {
                    this.produced = j12 + 1;
                    this.actual.onNext(t11);
                    return;
                }
                unsubscribe();
                this.actual.onError(new MissingBackpressureException("PublishSubject: could not emit value due to lack of requests"));
            }
        }

        public void request(long j11) {
            long j12;
            if (BackpressureUtils.validate(j11)) {
                do {
                    j12 = get();
                    if (j12 == Long.MIN_VALUE || compareAndSet(j12, BackpressureUtils.addCap(j12, j11))) {
                    }
                    j12 = get();
                    return;
                } while (compareAndSet(j12, BackpressureUtils.addCap(j12, j11)));
            }
        }

        public void unsubscribe() {
            if (getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.parent.remove(this);
            }
        }
    }

    public static final class PublishSubjectState<T> extends AtomicReference<PublishSubjectProducer<T>[]> implements Observable.OnSubscribe<T>, Observer<T> {
        public static final PublishSubjectProducer[] EMPTY = new PublishSubjectProducer[0];
        public static final PublishSubjectProducer[] TERMINATED = new PublishSubjectProducer[0];
        private static final long serialVersionUID = -7568940796666027140L;
        public Throwable error;

        public PublishSubjectState() {
            lazySet(EMPTY);
        }

        public boolean add(PublishSubjectProducer<T> publishSubjectProducer) {
            PublishSubjectProducer[] publishSubjectProducerArr;
            PublishSubjectProducer[] publishSubjectProducerArr2;
            do {
                publishSubjectProducerArr = (PublishSubjectProducer[]) get();
                if (publishSubjectProducerArr == TERMINATED) {
                    return false;
                }
                int length = publishSubjectProducerArr.length;
                publishSubjectProducerArr2 = new PublishSubjectProducer[(length + 1)];
                System.arraycopy(publishSubjectProducerArr, 0, publishSubjectProducerArr2, 0, length);
                publishSubjectProducerArr2[length] = publishSubjectProducer;
            } while (!compareAndSet(publishSubjectProducerArr, publishSubjectProducerArr2));
            return true;
        }

        public void onCompleted() {
            for (PublishSubjectProducer onCompleted : (PublishSubjectProducer[]) getAndSet(TERMINATED)) {
                onCompleted.onCompleted();
            }
        }

        public void onError(Throwable th2) {
            this.error = th2;
            ArrayList arrayList = null;
            for (PublishSubjectProducer onError : (PublishSubjectProducer[]) getAndSet(TERMINATED)) {
                try {
                    onError.onError(th2);
                } catch (Throwable th3) {
                    if (arrayList == null) {
                        arrayList = new ArrayList(1);
                    }
                    arrayList.add(th3);
                }
            }
            Exceptions.throwIfAny(arrayList);
        }

        public void onNext(T t11) {
            for (PublishSubjectProducer onNext : (PublishSubjectProducer[]) get()) {
                onNext.onNext(t11);
            }
        }

        public void remove(PublishSubjectProducer<T> publishSubjectProducer) {
            PublishSubjectProducer<T>[] publishSubjectProducerArr;
            PublishSubjectProducer[] publishSubjectProducerArr2;
            do {
                publishSubjectProducerArr = (PublishSubjectProducer[]) get();
                if (publishSubjectProducerArr != TERMINATED && publishSubjectProducerArr != EMPTY) {
                    int length = publishSubjectProducerArr.length;
                    int i11 = -1;
                    int i12 = 0;
                    while (true) {
                        if (i12 >= length) {
                            break;
                        } else if (publishSubjectProducerArr[i12] == publishSubjectProducer) {
                            i11 = i12;
                            break;
                        } else {
                            i12++;
                        }
                    }
                    if (i11 >= 0) {
                        if (length == 1) {
                            publishSubjectProducerArr2 = EMPTY;
                        } else {
                            PublishSubjectProducer[] publishSubjectProducerArr3 = new PublishSubjectProducer[(length - 1)];
                            System.arraycopy(publishSubjectProducerArr, 0, publishSubjectProducerArr3, 0, i11);
                            System.arraycopy(publishSubjectProducerArr, i11 + 1, publishSubjectProducerArr3, i11, (length - i11) - 1);
                            publishSubjectProducerArr2 = publishSubjectProducerArr3;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            } while (!compareAndSet(publishSubjectProducerArr, publishSubjectProducerArr2));
        }

        public void call(Subscriber<? super T> subscriber) {
            PublishSubjectProducer publishSubjectProducer = new PublishSubjectProducer(this, subscriber);
            subscriber.add(publishSubjectProducer);
            subscriber.setProducer(publishSubjectProducer);
            if (!add(publishSubjectProducer)) {
                Throwable th2 = this.error;
                if (th2 != null) {
                    subscriber.onError(th2);
                } else {
                    subscriber.onCompleted();
                }
            } else if (publishSubjectProducer.isUnsubscribed()) {
                remove(publishSubjectProducer);
            }
        }
    }

    public PublishSubject(PublishSubjectState<T> publishSubjectState) {
        super(publishSubjectState);
        this.state = publishSubjectState;
    }

    public static <T> PublishSubject<T> create() {
        return new PublishSubject<>(new PublishSubjectState());
    }

    public Throwable getThrowable() {
        if (this.state.get() == PublishSubjectState.TERMINATED) {
            return this.state.error;
        }
        return null;
    }

    public boolean hasCompleted() {
        return this.state.get() == PublishSubjectState.TERMINATED && this.state.error == null;
    }

    public boolean hasObservers() {
        return ((PublishSubjectProducer[]) this.state.get()).length != 0;
    }

    public boolean hasThrowable() {
        return this.state.get() == PublishSubjectState.TERMINATED && this.state.error != null;
    }

    public void onCompleted() {
        this.state.onCompleted();
    }

    public void onError(Throwable th2) {
        this.state.onError(th2);
    }

    public void onNext(T t11) {
        this.state.onNext(t11);
    }
}
