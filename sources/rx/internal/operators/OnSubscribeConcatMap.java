package rx.internal.operators;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.exceptions.MissingBackpressureException;
import rx.functions.Func1;
import rx.internal.producers.ProducerArbiter;
import rx.internal.util.ExceptionsUtils;
import rx.internal.util.ScalarSynchronousObservable;
import rx.internal.util.atomic.SpscAtomicArrayQueue;
import rx.internal.util.unsafe.SpscArrayQueue;
import rx.internal.util.unsafe.UnsafeAccess;
import rx.observers.SerializedSubscriber;
import rx.plugins.RxJavaHooks;
import rx.subscriptions.SerialSubscription;

public final class OnSubscribeConcatMap<T, R> implements Observable.OnSubscribe<R> {
    public static final int BOUNDARY = 1;
    public static final int END = 2;
    public static final int IMMEDIATE = 0;
    public final int delayErrorMode;
    public final Func1<? super T, ? extends Observable<? extends R>> mapper;
    public final int prefetch;
    public final Observable<? extends T> source;

    public static final class ConcatMapInnerScalarProducer<T, R> implements Producer {
        public boolean once;
        public final ConcatMapSubscriber<T, R> parent;
        public final R value;

        public ConcatMapInnerScalarProducer(R r11, ConcatMapSubscriber<T, R> concatMapSubscriber) {
            this.value = r11;
            this.parent = concatMapSubscriber;
        }

        public void request(long j11) {
            if (!this.once && j11 > 0) {
                this.once = true;
                ConcatMapSubscriber<T, R> concatMapSubscriber = this.parent;
                concatMapSubscriber.innerNext(this.value);
                concatMapSubscriber.innerCompleted(1);
            }
        }
    }

    public static final class ConcatMapInnerSubscriber<T, R> extends Subscriber<R> {
        public final ConcatMapSubscriber<T, R> parent;
        public long produced;

        public ConcatMapInnerSubscriber(ConcatMapSubscriber<T, R> concatMapSubscriber) {
            this.parent = concatMapSubscriber;
        }

        public void onCompleted() {
            this.parent.innerCompleted(this.produced);
        }

        public void onError(Throwable th2) {
            this.parent.innerError(th2, this.produced);
        }

        public void onNext(R r11) {
            this.produced++;
            this.parent.innerNext(r11);
        }

        public void setProducer(Producer producer) {
            this.parent.arbiter.setProducer(producer);
        }
    }

    public static final class ConcatMapSubscriber<T, R> extends Subscriber<T> {
        public volatile boolean active;
        public final Subscriber<? super R> actual;
        public final ProducerArbiter arbiter = new ProducerArbiter();
        public final int delayErrorMode;
        public volatile boolean done;
        public final AtomicReference<Throwable> error = new AtomicReference<>();
        public final SerialSubscription inner;
        public final Func1<? super T, ? extends Observable<? extends R>> mapper;
        public final Queue<Object> queue;
        public final AtomicInteger wip = new AtomicInteger();

        public ConcatMapSubscriber(Subscriber<? super R> subscriber, Func1<? super T, ? extends Observable<? extends R>> func1, int i11, int i12) {
            Queue<Object> queue2;
            this.actual = subscriber;
            this.mapper = func1;
            this.delayErrorMode = i12;
            if (UnsafeAccess.isUnsafeAvailable()) {
                queue2 = new SpscArrayQueue<>(i11);
            } else {
                queue2 = new SpscAtomicArrayQueue<>(i11);
            }
            this.queue = queue2;
            this.inner = new SerialSubscription();
            request((long) i11);
        }

        public void drain() {
            if (this.wip.getAndIncrement() == 0) {
                int i11 = this.delayErrorMode;
                while (!this.actual.isUnsubscribed()) {
                    if (!this.active) {
                        if (i11 != 1 || this.error.get() == null) {
                            boolean z11 = this.done;
                            Object poll = this.queue.poll();
                            boolean z12 = poll == null;
                            if (z11 && z12) {
                                Throwable terminate = ExceptionsUtils.terminate(this.error);
                                if (terminate == null) {
                                    this.actual.onCompleted();
                                    return;
                                } else if (!ExceptionsUtils.isTerminated(terminate)) {
                                    this.actual.onError(terminate);
                                    return;
                                } else {
                                    return;
                                }
                            } else if (!z12) {
                                try {
                                    Observable observable = (Observable) this.mapper.call(NotificationLite.getValue(poll));
                                    if (observable == null) {
                                        drainError(new NullPointerException("The source returned by the mapper was null"));
                                        return;
                                    } else if (observable != Observable.empty()) {
                                        if (observable instanceof ScalarSynchronousObservable) {
                                            this.active = true;
                                            this.arbiter.setProducer(new ConcatMapInnerScalarProducer(((ScalarSynchronousObservable) observable).get(), this));
                                        } else {
                                            ConcatMapInnerSubscriber concatMapInnerSubscriber = new ConcatMapInnerSubscriber(this);
                                            this.inner.set(concatMapInnerSubscriber);
                                            if (!concatMapInnerSubscriber.isUnsubscribed()) {
                                                this.active = true;
                                                observable.unsafeSubscribe(concatMapInnerSubscriber);
                                            } else {
                                                return;
                                            }
                                        }
                                        request(1);
                                    } else {
                                        request(1);
                                    }
                                } catch (Throwable th2) {
                                    Exceptions.throwIfFatal(th2);
                                    drainError(th2);
                                    return;
                                }
                            }
                        } else {
                            Throwable terminate2 = ExceptionsUtils.terminate(this.error);
                            if (!ExceptionsUtils.isTerminated(terminate2)) {
                                this.actual.onError(terminate2);
                                return;
                            }
                            return;
                        }
                    }
                    if (this.wip.decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }

        public void drainError(Throwable th2) {
            unsubscribe();
            if (ExceptionsUtils.addThrowable(this.error, th2)) {
                Throwable terminate = ExceptionsUtils.terminate(this.error);
                if (!ExceptionsUtils.isTerminated(terminate)) {
                    this.actual.onError(terminate);
                    return;
                }
                return;
            }
            pluginError(th2);
        }

        public void innerCompleted(long j11) {
            if (j11 != 0) {
                this.arbiter.produced(j11);
            }
            this.active = false;
            drain();
        }

        public void innerError(Throwable th2, long j11) {
            if (!ExceptionsUtils.addThrowable(this.error, th2)) {
                pluginError(th2);
            } else if (this.delayErrorMode == 0) {
                Throwable terminate = ExceptionsUtils.terminate(this.error);
                if (!ExceptionsUtils.isTerminated(terminate)) {
                    this.actual.onError(terminate);
                }
                unsubscribe();
            } else {
                if (j11 != 0) {
                    this.arbiter.produced(j11);
                }
                this.active = false;
                drain();
            }
        }

        public void innerNext(R r11) {
            this.actual.onNext(r11);
        }

        public void onCompleted() {
            this.done = true;
            drain();
        }

        public void onError(Throwable th2) {
            if (ExceptionsUtils.addThrowable(this.error, th2)) {
                this.done = true;
                if (this.delayErrorMode == 0) {
                    Throwable terminate = ExceptionsUtils.terminate(this.error);
                    if (!ExceptionsUtils.isTerminated(terminate)) {
                        this.actual.onError(terminate);
                    }
                    this.inner.unsubscribe();
                    return;
                }
                drain();
                return;
            }
            pluginError(th2);
        }

        public void onNext(T t11) {
            if (!this.queue.offer(NotificationLite.next(t11))) {
                unsubscribe();
                onError(new MissingBackpressureException());
                return;
            }
            drain();
        }

        public void pluginError(Throwable th2) {
            RxJavaHooks.onError(th2);
        }

        public void requestMore(long j11) {
            int i11 = (j11 > 0 ? 1 : (j11 == 0 ? 0 : -1));
            if (i11 > 0) {
                this.arbiter.request(j11);
            } else if (i11 < 0) {
                throw new IllegalArgumentException("n >= 0 required but it was " + j11);
            }
        }
    }

    public OnSubscribeConcatMap(Observable<? extends T> observable, Func1<? super T, ? extends Observable<? extends R>> func1, int i11, int i12) {
        this.source = observable;
        this.mapper = func1;
        this.prefetch = i11;
        this.delayErrorMode = i12;
    }

    public void call(Subscriber<? super R> subscriber) {
        final ConcatMapSubscriber concatMapSubscriber = new ConcatMapSubscriber(this.delayErrorMode == 0 ? new SerializedSubscriber<>(subscriber) : subscriber, this.mapper, this.prefetch, this.delayErrorMode);
        subscriber.add(concatMapSubscriber);
        subscriber.add(concatMapSubscriber.inner);
        subscriber.setProducer(new Producer() {
            public void request(long j11) {
                concatMapSubscriber.requestMore(j11);
            }
        });
        if (!subscriber.isUnsubscribed()) {
            this.source.unsafeSubscribe(concatMapSubscriber);
        }
    }
}
