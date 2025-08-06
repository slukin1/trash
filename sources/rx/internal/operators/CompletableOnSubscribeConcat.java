package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import rx.Completable;
import rx.CompletableSubscriber;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.MissingBackpressureException;
import rx.internal.subscriptions.SequentialSubscription;
import rx.internal.util.unsafe.SpscArrayQueue;
import rx.plugins.RxJavaHooks;

public final class CompletableOnSubscribeConcat implements Completable.OnSubscribe {
    public final int prefetch;
    public final Observable<Completable> sources;

    public static final class CompletableConcatSubscriber extends Subscriber<Completable> {
        public volatile boolean active;
        public final CompletableSubscriber actual;
        public volatile boolean done;
        public final ConcatInnerSubscriber inner = new ConcatInnerSubscriber();
        public final AtomicBoolean once = new AtomicBoolean();
        public final SpscArrayQueue<Completable> queue;

        /* renamed from: sr  reason: collision with root package name */
        public final SequentialSubscription f53399sr;

        public final class ConcatInnerSubscriber extends AtomicInteger implements CompletableSubscriber {
            private static final long serialVersionUID = 7233503139645205620L;

            public ConcatInnerSubscriber() {
            }

            public void onCompleted() {
                CompletableConcatSubscriber.this.innerComplete();
            }

            public void onError(Throwable th2) {
                CompletableConcatSubscriber.this.innerError(th2);
            }

            public void onSubscribe(Subscription subscription) {
                CompletableConcatSubscriber.this.f53399sr.set(subscription);
            }
        }

        public CompletableConcatSubscriber(CompletableSubscriber completableSubscriber, int i11) {
            this.actual = completableSubscriber;
            this.queue = new SpscArrayQueue<>(i11);
            SequentialSubscription sequentialSubscription = new SequentialSubscription();
            this.f53399sr = sequentialSubscription;
            add(sequentialSubscription);
            request((long) i11);
        }

        public void drain() {
            ConcatInnerSubscriber concatInnerSubscriber = this.inner;
            if (concatInnerSubscriber.getAndIncrement() == 0) {
                while (!isUnsubscribed()) {
                    if (!this.active) {
                        boolean z11 = this.done;
                        Completable poll = this.queue.poll();
                        boolean z12 = poll == null;
                        if (z11 && z12) {
                            this.actual.onCompleted();
                            return;
                        } else if (!z12) {
                            this.active = true;
                            poll.subscribe((CompletableSubscriber) concatInnerSubscriber);
                            request(1);
                        }
                    }
                    if (concatInnerSubscriber.decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }

        public void innerComplete() {
            this.active = false;
            drain();
        }

        public void innerError(Throwable th2) {
            unsubscribe();
            onError(th2);
        }

        public void onCompleted() {
            if (!this.done) {
                this.done = true;
                drain();
            }
        }

        public void onError(Throwable th2) {
            if (this.once.compareAndSet(false, true)) {
                this.actual.onError(th2);
            } else {
                RxJavaHooks.onError(th2);
            }
        }

        public void onNext(Completable completable) {
            if (!this.queue.offer(completable)) {
                onError(new MissingBackpressureException());
            } else {
                drain();
            }
        }
    }

    public CompletableOnSubscribeConcat(Observable<? extends Completable> observable, int i11) {
        this.sources = observable;
        this.prefetch = i11;
    }

    public void call(CompletableSubscriber completableSubscriber) {
        CompletableConcatSubscriber completableConcatSubscriber = new CompletableConcatSubscriber(completableSubscriber, this.prefetch);
        completableSubscriber.onSubscribe(completableConcatSubscriber);
        this.sources.unsafeSubscribe(completableConcatSubscriber);
    }
}
