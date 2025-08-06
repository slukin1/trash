package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.observables.ConnectableObservable;
import rx.subscriptions.CompositeSubscription;
import rx.subscriptions.Subscriptions;

public final class OnSubscribeRefCount<T> implements Observable.OnSubscribe<T> {
    public volatile CompositeSubscription baseSubscription = new CompositeSubscription();
    public final ReentrantLock lock = new ReentrantLock();
    /* access modifiers changed from: private */
    public final ConnectableObservable<? extends T> source;
    public final AtomicInteger subscriptionCount = new AtomicInteger(0);

    public OnSubscribeRefCount(ConnectableObservable<? extends T> connectableObservable) {
        this.source = connectableObservable;
    }

    private Subscription disconnect(final CompositeSubscription compositeSubscription) {
        return Subscriptions.create(new Action0() {
            public void call() {
                OnSubscribeRefCount.this.lock.lock();
                try {
                    if (OnSubscribeRefCount.this.baseSubscription == compositeSubscription && OnSubscribeRefCount.this.subscriptionCount.decrementAndGet() == 0) {
                        if (OnSubscribeRefCount.this.source instanceof Subscription) {
                            ((Subscription) OnSubscribeRefCount.this.source).unsubscribe();
                        }
                        OnSubscribeRefCount.this.baseSubscription.unsubscribe();
                        OnSubscribeRefCount.this.baseSubscription = new CompositeSubscription();
                    }
                } finally {
                    OnSubscribeRefCount.this.lock.unlock();
                }
            }
        });
    }

    private Action1<Subscription> onSubscribe(final Subscriber<? super T> subscriber, final AtomicBoolean atomicBoolean) {
        return new Action1<Subscription>() {
            public void call(Subscription subscription) {
                try {
                    OnSubscribeRefCount.this.baseSubscription.add(subscription);
                    OnSubscribeRefCount onSubscribeRefCount = OnSubscribeRefCount.this;
                    onSubscribeRefCount.doSubscribe(subscriber, onSubscribeRefCount.baseSubscription);
                } finally {
                    OnSubscribeRefCount.this.lock.unlock();
                    atomicBoolean.set(false);
                }
            }
        };
    }

    public void doSubscribe(final Subscriber<? super T> subscriber, final CompositeSubscription compositeSubscription) {
        subscriber.add(disconnect(compositeSubscription));
        this.source.unsafeSubscribe(new Subscriber<T>(subscriber) {
            public void cleanup() {
                OnSubscribeRefCount.this.lock.lock();
                try {
                    if (OnSubscribeRefCount.this.baseSubscription == compositeSubscription) {
                        if (OnSubscribeRefCount.this.source instanceof Subscription) {
                            ((Subscription) OnSubscribeRefCount.this.source).unsubscribe();
                        }
                        OnSubscribeRefCount.this.baseSubscription.unsubscribe();
                        OnSubscribeRefCount.this.baseSubscription = new CompositeSubscription();
                        OnSubscribeRefCount.this.subscriptionCount.set(0);
                    }
                } finally {
                    OnSubscribeRefCount.this.lock.unlock();
                }
            }

            public void onCompleted() {
                cleanup();
                subscriber.onCompleted();
            }

            public void onError(Throwable th2) {
                cleanup();
                subscriber.onError(th2);
            }

            public void onNext(T t11) {
                subscriber.onNext(t11);
            }
        });
    }

    public void call(Subscriber<? super T> subscriber) {
        this.lock.lock();
        if (this.subscriptionCount.incrementAndGet() == 1) {
            AtomicBoolean atomicBoolean = new AtomicBoolean(true);
            try {
                this.source.connect(onSubscribe(subscriber, atomicBoolean));
            } finally {
                if (atomicBoolean.get()) {
                    this.lock.unlock();
                }
            }
        } else {
            try {
                doSubscribe(subscriber, this.baseSubscription);
            } finally {
                this.lock.unlock();
            }
        }
    }
}
