package rx.internal.operators;

import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.Observable;
import rx.Producer;
import rx.Single;
import rx.SingleSubscriber;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.Exceptions;
import rx.functions.Func1;
import rx.internal.util.ExceptionsUtils;
import rx.internal.util.atomic.MpscLinkedAtomicQueue;
import rx.internal.util.unsafe.MpscLinkedQueue;
import rx.internal.util.unsafe.UnsafeAccess;
import rx.plugins.RxJavaHooks;
import rx.subscriptions.CompositeSubscription;

public final class OnSubscribeFlatMapSingle<T, R> implements Observable.OnSubscribe<R> {
    public final boolean delayErrors;
    public final Func1<? super T, ? extends Single<? extends R>> mapper;
    public final int maxConcurrency;
    public final Observable<T> source;

    public static final class FlatMapSingleSubscriber<T, R> extends Subscriber<T> {
        public final AtomicInteger active = new AtomicInteger();
        public final Subscriber<? super R> actual;
        public volatile boolean cancelled;
        public final boolean delayErrors;
        public volatile boolean done;
        public final AtomicReference<Throwable> errors = new AtomicReference<>();
        public final Func1<? super T, ? extends Single<? extends R>> mapper;
        public final int maxConcurrency;
        public final Queue<Object> queue;
        public final FlatMapSingleSubscriber<T, R>.Requested requested = new Requested();
        public final CompositeSubscription set = new CompositeSubscription();
        public final AtomicInteger wip = new AtomicInteger();

        public final class InnerSubscriber extends SingleSubscriber<R> {
            public InnerSubscriber() {
            }

            public void onError(Throwable th2) {
                FlatMapSingleSubscriber.this.innerError(this, th2);
            }

            public void onSuccess(R r11) {
                FlatMapSingleSubscriber.this.innerSuccess(this, r11);
            }
        }

        public final class Requested extends AtomicLong implements Producer, Subscription {
            private static final long serialVersionUID = -887187595446742742L;

            public Requested() {
            }

            public boolean isUnsubscribed() {
                return FlatMapSingleSubscriber.this.cancelled;
            }

            public void produced(long j11) {
                BackpressureUtils.produced(this, j11);
            }

            public void request(long j11) {
                if (j11 > 0) {
                    BackpressureUtils.getAndAddRequest(this, j11);
                    FlatMapSingleSubscriber.this.drain();
                }
            }

            public void unsubscribe() {
                FlatMapSingleSubscriber.this.cancelled = true;
                FlatMapSingleSubscriber.this.unsubscribe();
                if (FlatMapSingleSubscriber.this.wip.getAndIncrement() == 0) {
                    FlatMapSingleSubscriber.this.queue.clear();
                }
            }
        }

        public FlatMapSingleSubscriber(Subscriber<? super R> subscriber, Func1<? super T, ? extends Single<? extends R>> func1, boolean z11, int i11) {
            this.actual = subscriber;
            this.mapper = func1;
            this.delayErrors = z11;
            this.maxConcurrency = i11;
            if (UnsafeAccess.isUnsafeAvailable()) {
                this.queue = new MpscLinkedQueue();
            } else {
                this.queue = new MpscLinkedAtomicQueue();
            }
            request(i11 != Integer.MAX_VALUE ? (long) i11 : Long.MAX_VALUE);
        }

        public void drain() {
            int i11;
            if (this.wip.getAndIncrement() == 0) {
                Subscriber<? super R> subscriber = this.actual;
                Queue<Object> queue2 = this.queue;
                boolean z11 = this.delayErrors;
                AtomicInteger atomicInteger = this.active;
                int i12 = 1;
                do {
                    long j11 = this.requested.get();
                    long j12 = 0;
                    while (true) {
                        i11 = (j12 > j11 ? 1 : (j12 == j11 ? 0 : -1));
                        if (i11 == 0) {
                            break;
                        } else if (this.cancelled) {
                            queue2.clear();
                            return;
                        } else {
                            boolean z12 = this.done;
                            if (z11 || !z12 || this.errors.get() == null) {
                                Object poll = queue2.poll();
                                boolean z13 = poll == null;
                                if (!z12 || atomicInteger.get() != 0 || !z13) {
                                    if (z13) {
                                        break;
                                    }
                                    subscriber.onNext(NotificationLite.getValue(poll));
                                    j12++;
                                } else if (this.errors.get() != null) {
                                    subscriber.onError(ExceptionsUtils.terminate(this.errors));
                                    return;
                                } else {
                                    subscriber.onCompleted();
                                    return;
                                }
                            } else {
                                queue2.clear();
                                subscriber.onError(ExceptionsUtils.terminate(this.errors));
                                return;
                            }
                        }
                    }
                    if (i11 == 0) {
                        if (this.cancelled) {
                            queue2.clear();
                            return;
                        } else if (this.done) {
                            if (z11) {
                                if (atomicInteger.get() == 0 && queue2.isEmpty()) {
                                    if (this.errors.get() != null) {
                                        subscriber.onError(ExceptionsUtils.terminate(this.errors));
                                        return;
                                    } else {
                                        subscriber.onCompleted();
                                        return;
                                    }
                                }
                            } else if (this.errors.get() != null) {
                                queue2.clear();
                                subscriber.onError(ExceptionsUtils.terminate(this.errors));
                                return;
                            } else if (atomicInteger.get() == 0 && queue2.isEmpty()) {
                                subscriber.onCompleted();
                                return;
                            }
                        }
                    }
                    if (j12 != 0) {
                        this.requested.produced(j12);
                        if (!this.done && this.maxConcurrency != Integer.MAX_VALUE) {
                            request(j12);
                        }
                    }
                    i12 = this.wip.addAndGet(-i12);
                } while (i12 != 0);
            }
        }

        public void innerError(FlatMapSingleSubscriber<T, R>.InnerSubscriber innerSubscriber, Throwable th2) {
            if (this.delayErrors) {
                ExceptionsUtils.addThrowable(this.errors, th2);
                this.set.remove(innerSubscriber);
                if (!this.done && this.maxConcurrency != Integer.MAX_VALUE) {
                    request(1);
                }
            } else {
                this.set.unsubscribe();
                unsubscribe();
                if (!this.errors.compareAndSet((Object) null, th2)) {
                    RxJavaHooks.onError(th2);
                    return;
                }
                this.done = true;
            }
            this.active.decrementAndGet();
            drain();
        }

        public void innerSuccess(FlatMapSingleSubscriber<T, R>.InnerSubscriber innerSubscriber, R r11) {
            this.queue.offer(NotificationLite.next(r11));
            this.set.remove(innerSubscriber);
            this.active.decrementAndGet();
            drain();
        }

        public void onCompleted() {
            this.done = true;
            drain();
        }

        public void onError(Throwable th2) {
            if (this.delayErrors) {
                ExceptionsUtils.addThrowable(this.errors, th2);
            } else {
                this.set.unsubscribe();
                if (!this.errors.compareAndSet((Object) null, th2)) {
                    RxJavaHooks.onError(th2);
                    return;
                }
            }
            this.done = true;
            drain();
        }

        public void onNext(T t11) {
            try {
                Single single = (Single) this.mapper.call(t11);
                if (single != null) {
                    InnerSubscriber innerSubscriber = new InnerSubscriber();
                    this.set.add(innerSubscriber);
                    this.active.incrementAndGet();
                    single.subscribe(innerSubscriber);
                    return;
                }
                throw new NullPointerException("The mapper returned a null Single");
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                unsubscribe();
                onError(th2);
            }
        }
    }

    public OnSubscribeFlatMapSingle(Observable<T> observable, Func1<? super T, ? extends Single<? extends R>> func1, boolean z11, int i11) {
        Objects.requireNonNull(func1, "mapper is null");
        if (i11 > 0) {
            this.source = observable;
            this.mapper = func1;
            this.delayErrors = z11;
            this.maxConcurrency = i11;
            return;
        }
        throw new IllegalArgumentException("maxConcurrency > 0 required but it was " + i11);
    }

    public void call(Subscriber<? super R> subscriber) {
        FlatMapSingleSubscriber flatMapSingleSubscriber = new FlatMapSingleSubscriber(subscriber, this.mapper, this.delayErrors, this.maxConcurrency);
        subscriber.add(flatMapSingleSubscriber.set);
        subscriber.add(flatMapSingleSubscriber.requested);
        subscriber.setProducer(flatMapSingleSubscriber.requested);
        this.source.unsafeSubscribe(flatMapSingleSubscriber);
    }
}
