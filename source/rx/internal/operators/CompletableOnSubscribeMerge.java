package rx.internal.operators;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import rx.Completable;
import rx.CompletableSubscriber;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.CompositeException;
import rx.plugins.RxJavaHooks;
import rx.subscriptions.CompositeSubscription;

public final class CompletableOnSubscribeMerge implements Completable.OnSubscribe {
    public final boolean delayErrors;
    public final int maxConcurrency;
    public final Observable<Completable> source;

    public static final class CompletableMergeSubscriber extends Subscriber<Completable> {
        public final CompletableSubscriber actual;
        public final boolean delayErrors;
        public volatile boolean done;
        public final AtomicReference<Queue<Throwable>> errors = new AtomicReference<>();
        public final AtomicBoolean once = new AtomicBoolean();
        public final CompositeSubscription set = new CompositeSubscription();
        public final AtomicInteger wip = new AtomicInteger(1);

        public CompletableMergeSubscriber(CompletableSubscriber completableSubscriber, int i11, boolean z11) {
            this.actual = completableSubscriber;
            this.delayErrors = z11;
            if (i11 == Integer.MAX_VALUE) {
                request(Long.MAX_VALUE);
            } else {
                request((long) i11);
            }
        }

        public Queue<Throwable> getOrCreateErrors() {
            Queue<Throwable> queue = this.errors.get();
            if (queue != null) {
                return queue;
            }
            ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue();
            if (this.errors.compareAndSet((Object) null, concurrentLinkedQueue)) {
                return concurrentLinkedQueue;
            }
            return this.errors.get();
        }

        public void onCompleted() {
            if (!this.done) {
                this.done = true;
                terminate();
            }
        }

        public void onError(Throwable th2) {
            if (this.done) {
                RxJavaHooks.onError(th2);
                return;
            }
            getOrCreateErrors().offer(th2);
            this.done = true;
            terminate();
        }

        public void terminate() {
            Queue queue;
            if (this.wip.decrementAndGet() == 0) {
                Queue queue2 = this.errors.get();
                if (queue2 == null || queue2.isEmpty()) {
                    this.actual.onCompleted();
                    return;
                }
                Throwable collectErrors = CompletableOnSubscribeMerge.collectErrors(queue2);
                if (this.once.compareAndSet(false, true)) {
                    this.actual.onError(collectErrors);
                } else {
                    RxJavaHooks.onError(collectErrors);
                }
            } else if (!this.delayErrors && (queue = this.errors.get()) != null && !queue.isEmpty()) {
                Throwable collectErrors2 = CompletableOnSubscribeMerge.collectErrors(queue);
                if (this.once.compareAndSet(false, true)) {
                    this.actual.onError(collectErrors2);
                } else {
                    RxJavaHooks.onError(collectErrors2);
                }
            }
        }

        public void onNext(Completable completable) {
            if (!this.done) {
                this.wip.getAndIncrement();
                completable.unsafeSubscribe((CompletableSubscriber) new CompletableSubscriber() {

                    /* renamed from: d  reason: collision with root package name */
                    public Subscription f53402d;
                    public boolean innerDone;

                    public void onCompleted() {
                        if (!this.innerDone) {
                            this.innerDone = true;
                            CompletableMergeSubscriber.this.set.remove(this.f53402d);
                            CompletableMergeSubscriber.this.terminate();
                            if (!CompletableMergeSubscriber.this.done) {
                                CompletableMergeSubscriber.this.request(1);
                            }
                        }
                    }

                    public void onError(Throwable th2) {
                        if (this.innerDone) {
                            RxJavaHooks.onError(th2);
                            return;
                        }
                        this.innerDone = true;
                        CompletableMergeSubscriber.this.set.remove(this.f53402d);
                        CompletableMergeSubscriber.this.getOrCreateErrors().offer(th2);
                        CompletableMergeSubscriber.this.terminate();
                        CompletableMergeSubscriber completableMergeSubscriber = CompletableMergeSubscriber.this;
                        if (completableMergeSubscriber.delayErrors && !completableMergeSubscriber.done) {
                            CompletableMergeSubscriber.this.request(1);
                        }
                    }

                    public void onSubscribe(Subscription subscription) {
                        this.f53402d = subscription;
                        CompletableMergeSubscriber.this.set.add(subscription);
                    }
                });
            }
        }
    }

    public CompletableOnSubscribeMerge(Observable<? extends Completable> observable, int i11, boolean z11) {
        this.source = observable;
        this.maxConcurrency = i11;
        this.delayErrors = z11;
    }

    public static Throwable collectErrors(Queue<Throwable> queue) {
        ArrayList arrayList = new ArrayList();
        while (true) {
            Throwable poll = queue.poll();
            if (poll == null) {
                break;
            }
            arrayList.add(poll);
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        if (arrayList.size() == 1) {
            return (Throwable) arrayList.get(0);
        }
        return new CompositeException((Collection<? extends Throwable>) arrayList);
    }

    public void call(CompletableSubscriber completableSubscriber) {
        CompletableMergeSubscriber completableMergeSubscriber = new CompletableMergeSubscriber(completableSubscriber, this.maxConcurrency, this.delayErrors);
        completableSubscriber.onSubscribe(completableMergeSubscriber);
        this.source.unsafeSubscribe(completableMergeSubscriber);
    }
}
