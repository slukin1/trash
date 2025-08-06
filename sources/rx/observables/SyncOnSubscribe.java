package rx.observables;

import java.util.concurrent.atomic.AtomicLong;
import rx.Observable;
import rx.Observer;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.Exceptions;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Action2;
import rx.functions.Func0;
import rx.functions.Func2;
import rx.internal.operators.BackpressureUtils;
import rx.plugins.RxJavaHooks;

public abstract class SyncOnSubscribe<S, T> implements Observable.OnSubscribe<T> {

    public static final class SubscriptionProducer<S, T> extends AtomicLong implements Producer, Subscription, Observer<T> {
        private static final long serialVersionUID = -3736864024352728072L;
        private final Subscriber<? super T> actualSubscriber;
        private boolean hasTerminated;
        private boolean onNextCalled;
        private final SyncOnSubscribe<S, T> parent;
        private S state;

        public SubscriptionProducer(Subscriber<? super T> subscriber, SyncOnSubscribe<S, T> syncOnSubscribe, S s11) {
            this.actualSubscriber = subscriber;
            this.parent = syncOnSubscribe;
            this.state = s11;
        }

        private void doUnsubscribe() {
            try {
                this.parent.onUnsubscribe(this.state);
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                RxJavaHooks.onError(th2);
            }
        }

        private void fastPath() {
            SyncOnSubscribe<S, T> syncOnSubscribe = this.parent;
            Subscriber<? super T> subscriber = this.actualSubscriber;
            do {
                try {
                    this.onNextCalled = false;
                    nextIteration(syncOnSubscribe);
                } catch (Throwable th2) {
                    handleThrownError(subscriber, th2);
                    return;
                }
            } while (!tryUnsubscribe());
        }

        private void handleThrownError(Subscriber<? super T> subscriber, Throwable th2) {
            if (this.hasTerminated) {
                RxJavaHooks.onError(th2);
                return;
            }
            this.hasTerminated = true;
            subscriber.onError(th2);
            unsubscribe();
        }

        private void nextIteration(SyncOnSubscribe<S, T> syncOnSubscribe) {
            this.state = syncOnSubscribe.next(this.state, this);
        }

        private void slowPath(long j11) {
            SyncOnSubscribe<S, T> syncOnSubscribe = this.parent;
            Subscriber<? super T> subscriber = this.actualSubscriber;
            do {
                long j12 = j11;
                do {
                    try {
                        this.onNextCalled = false;
                        nextIteration(syncOnSubscribe);
                        if (!tryUnsubscribe()) {
                            if (this.onNextCalled) {
                                j12--;
                            }
                        } else {
                            return;
                        }
                    } catch (Throwable th2) {
                        handleThrownError(subscriber, th2);
                        return;
                    }
                } while (j12 != 0);
                j11 = addAndGet(-j11);
            } while (j11 > 0);
            tryUnsubscribe();
        }

        private boolean tryUnsubscribe() {
            if (!this.hasTerminated && get() >= -1) {
                return false;
            }
            set(-1);
            doUnsubscribe();
            return true;
        }

        public boolean isUnsubscribed() {
            return get() < 0;
        }

        public void onCompleted() {
            if (!this.hasTerminated) {
                this.hasTerminated = true;
                if (!this.actualSubscriber.isUnsubscribed()) {
                    this.actualSubscriber.onCompleted();
                    return;
                }
                return;
            }
            throw new IllegalStateException("Terminal event already emitted.");
        }

        public void onError(Throwable th2) {
            if (!this.hasTerminated) {
                this.hasTerminated = true;
                if (!this.actualSubscriber.isUnsubscribed()) {
                    this.actualSubscriber.onError(th2);
                    return;
                }
                return;
            }
            throw new IllegalStateException("Terminal event already emitted.");
        }

        public void onNext(T t11) {
            if (!this.onNextCalled) {
                this.onNextCalled = true;
                this.actualSubscriber.onNext(t11);
                return;
            }
            throw new IllegalStateException("onNext called multiple times!");
        }

        public void request(long j11) {
            if (j11 > 0 && BackpressureUtils.getAndAddRequest(this, j11) == 0) {
                if (j11 == Long.MAX_VALUE) {
                    fastPath();
                } else {
                    slowPath(j11);
                }
            }
        }

        public void unsubscribe() {
            long j11;
            do {
                j11 = get();
                if (compareAndSet(0, -1)) {
                    doUnsubscribe();
                    return;
                }
            } while (!compareAndSet(j11, -2));
        }
    }

    public static <S, T> SyncOnSubscribe<S, T> createSingleState(Func0<? extends S> func0, final Action2<? super S, ? super Observer<? super T>> action2) {
        return new SyncOnSubscribeImpl(func0, new Func2<S, Observer<? super T>, S>() {
            public S call(S s11, Observer<? super T> observer) {
                action2.call(s11, observer);
                return s11;
            }
        });
    }

    public static <S, T> SyncOnSubscribe<S, T> createStateful(Func0<? extends S> func0, Func2<? super S, ? super Observer<? super T>, ? extends S> func2, Action1<? super S> action1) {
        return new SyncOnSubscribeImpl(func0, func2, action1);
    }

    public static <T> SyncOnSubscribe<Void, T> createStateless(final Action1<? super Observer<? super T>> action1) {
        return new SyncOnSubscribeImpl(new Func2<Void, Observer<? super T>, Void>() {
            public Void call(Void voidR, Observer<? super T> observer) {
                action1.call(observer);
                return voidR;
            }
        });
    }

    public abstract S generateState();

    public abstract S next(S s11, Observer<? super T> observer);

    public void onUnsubscribe(S s11) {
    }

    public static <S, T> SyncOnSubscribe<S, T> createStateful(Func0<? extends S> func0, Func2<? super S, ? super Observer<? super T>, ? extends S> func2) {
        return new SyncOnSubscribeImpl(func0, func2);
    }

    public final void call(Subscriber<? super T> subscriber) {
        try {
            SubscriptionProducer subscriptionProducer = new SubscriptionProducer(subscriber, this, generateState());
            subscriber.add(subscriptionProducer);
            subscriber.setProducer(subscriptionProducer);
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            subscriber.onError(th2);
        }
    }

    public static <S, T> SyncOnSubscribe<S, T> createSingleState(Func0<? extends S> func0, final Action2<? super S, ? super Observer<? super T>> action2, Action1<? super S> action1) {
        return new SyncOnSubscribeImpl(func0, new Func2<S, Observer<? super T>, S>() {
            public S call(S s11, Observer<? super T> observer) {
                action2.call(s11, observer);
                return s11;
            }
        }, action1);
    }

    public static <T> SyncOnSubscribe<Void, T> createStateless(final Action1<? super Observer<? super T>> action1, final Action0 action0) {
        return new SyncOnSubscribeImpl(new Func2<Void, Observer<? super T>, Void>() {
            public Void call(Void voidR, Observer<? super T> observer) {
                action1.call(observer);
                return null;
            }
        }, new Action1<Void>() {
            public void call(Void voidR) {
                action0.call();
            }
        });
    }

    public static final class SyncOnSubscribeImpl<S, T> extends SyncOnSubscribe<S, T> {
        private final Func0<? extends S> generator;
        private final Func2<? super S, ? super Observer<? super T>, ? extends S> next;
        private final Action1<? super S> onUnsubscribe;

        public SyncOnSubscribeImpl(Func0<? extends S> func0, Func2<? super S, ? super Observer<? super T>, ? extends S> func2, Action1<? super S> action1) {
            this.generator = func0;
            this.next = func2;
            this.onUnsubscribe = action1;
        }

        public /* bridge */ /* synthetic */ void call(Object obj) {
            SyncOnSubscribe.super.call((Subscriber) obj);
        }

        public S generateState() {
            Func0<? extends S> func0 = this.generator;
            if (func0 == null) {
                return null;
            }
            return func0.call();
        }

        public S next(S s11, Observer<? super T> observer) {
            return this.next.call(s11, observer);
        }

        public void onUnsubscribe(S s11) {
            Action1<? super S> action1 = this.onUnsubscribe;
            if (action1 != null) {
                action1.call(s11);
            }
        }

        public SyncOnSubscribeImpl(Func0<? extends S> func0, Func2<? super S, ? super Observer<? super T>, ? extends S> func2) {
            this(func0, func2, (Action1) null);
        }

        public SyncOnSubscribeImpl(Func2<S, Observer<? super T>, S> func2, Action1<? super S> action1) {
            this((Func0) null, func2, action1);
        }

        public SyncOnSubscribeImpl(Func2<S, Observer<? super T>, S> func2) {
            this((Func0) null, func2, (Action1) null);
        }
    }
}
