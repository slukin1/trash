package rx.observables;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.Observable;
import rx.Observer;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;
import rx.annotations.Beta;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Action2;
import rx.functions.Action3;
import rx.functions.Func0;
import rx.functions.Func1;
import rx.functions.Func3;
import rx.internal.operators.BufferUntilSubscriber;
import rx.observers.SerializedObserver;
import rx.plugins.RxJavaHooks;
import rx.subscriptions.CompositeSubscription;

@Beta
public abstract class AsyncOnSubscribe<S, T> implements Observable.OnSubscribe<T> {

    public static final class AsyncOuterManager<S, T> implements Producer, Subscription, Observer<Observable<? extends T>> {
        public Producer concatProducer;
        public boolean emitting;
        public long expectedDelivery;
        private boolean hasTerminated;
        public final AtomicBoolean isUnsubscribed;
        private final UnicastSubject<Observable<T>> merger;
        private boolean onNextCalled;
        private final AsyncOnSubscribe<S, T> parent;
        public List<Long> requests;
        private final SerializedObserver<Observable<? extends T>> serializedSubscriber;
        private S state;
        public final CompositeSubscription subscriptions = new CompositeSubscription();

        public AsyncOuterManager(AsyncOnSubscribe<S, T> asyncOnSubscribe, S s11, UnicastSubject<Observable<T>> unicastSubject) {
            this.parent = asyncOnSubscribe;
            this.serializedSubscriber = new SerializedObserver<>(this);
            this.state = s11;
            this.merger = unicastSubject;
            this.isUnsubscribed = new AtomicBoolean();
        }

        private void handleThrownError(Throwable th2) {
            if (this.hasTerminated) {
                RxJavaHooks.onError(th2);
                return;
            }
            this.hasTerminated = true;
            this.merger.onError(th2);
            cleanup();
        }

        private void subscribeBufferToObservable(Observable<? extends T> observable) {
            BufferUntilSubscriber create = BufferUntilSubscriber.create();
            final AnonymousClass1 r32 = new Subscriber<T>(this.expectedDelivery, create) {
                public long remaining;
                public final /* synthetic */ BufferUntilSubscriber val$buffer;
                public final /* synthetic */ long val$expected;

                {
                    this.val$expected = r2;
                    this.val$buffer = r4;
                    this.remaining = r2;
                }

                public void onCompleted() {
                    this.val$buffer.onCompleted();
                    long j11 = this.remaining;
                    if (j11 > 0) {
                        AsyncOuterManager.this.requestRemaining(j11);
                    }
                }

                public void onError(Throwable th2) {
                    this.val$buffer.onError(th2);
                }

                public void onNext(T t11) {
                    this.remaining--;
                    this.val$buffer.onNext(t11);
                }
            };
            this.subscriptions.add(r32);
            observable.doOnTerminate(new Action0() {
                public void call() {
                    AsyncOuterManager.this.subscriptions.remove(r32);
                }
            }).subscribe(r32);
            this.merger.onNext(create);
        }

        public void cleanup() {
            this.subscriptions.unsubscribe();
            try {
                this.parent.onUnsubscribe(this.state);
            } catch (Throwable th2) {
                handleThrownError(th2);
            }
        }

        public boolean isUnsubscribed() {
            return this.isUnsubscribed.get();
        }

        public void nextIteration(long j11) {
            this.state = this.parent.next(this.state, j11, this.serializedSubscriber);
        }

        public void onCompleted() {
            if (!this.hasTerminated) {
                this.hasTerminated = true;
                this.merger.onCompleted();
                return;
            }
            throw new IllegalStateException("Terminal event already emitted.");
        }

        public void onError(Throwable th2) {
            if (!this.hasTerminated) {
                this.hasTerminated = true;
                this.merger.onError(th2);
                return;
            }
            throw new IllegalStateException("Terminal event already emitted.");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0043, code lost:
            r5 = r5.iterator();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x004b, code lost:
            if (r5.hasNext() == false) goto L_0x0036;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x005b, code lost:
            if (tryEmit(r5.next().longValue()) == false) goto L_0x0047;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x005d, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void request(long r5) {
            /*
                r4 = this;
                r0 = 0
                int r0 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
                if (r0 != 0) goto L_0x0007
                return
            L_0x0007:
                if (r0 < 0) goto L_0x0064
                monitor-enter(r4)
                boolean r0 = r4.emitting     // Catch:{ all -> 0x0061 }
                r1 = 1
                r2 = 0
                if (r0 == 0) goto L_0x0023
                java.util.List<java.lang.Long> r0 = r4.requests     // Catch:{ all -> 0x0061 }
                if (r0 != 0) goto L_0x001b
                java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x0061 }
                r0.<init>()     // Catch:{ all -> 0x0061 }
                r4.requests = r0     // Catch:{ all -> 0x0061 }
            L_0x001b:
                java.lang.Long r3 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x0061 }
                r0.add(r3)     // Catch:{ all -> 0x0061 }
                goto L_0x0026
            L_0x0023:
                r4.emitting = r1     // Catch:{ all -> 0x0061 }
                r1 = r2
            L_0x0026:
                monitor-exit(r4)     // Catch:{ all -> 0x0061 }
                rx.Producer r0 = r4.concatProducer
                r0.request(r5)
                if (r1 == 0) goto L_0x002f
                return
            L_0x002f:
                boolean r5 = r4.tryEmit(r5)
                if (r5 == 0) goto L_0x0036
                return
            L_0x0036:
                monitor-enter(r4)
                java.util.List<java.lang.Long> r5 = r4.requests     // Catch:{ all -> 0x005e }
                if (r5 != 0) goto L_0x003f
                r4.emitting = r2     // Catch:{ all -> 0x005e }
                monitor-exit(r4)     // Catch:{ all -> 0x005e }
                return
            L_0x003f:
                r6 = 0
                r4.requests = r6     // Catch:{ all -> 0x005e }
                monitor-exit(r4)     // Catch:{ all -> 0x005e }
                java.util.Iterator r5 = r5.iterator()
            L_0x0047:
                boolean r6 = r5.hasNext()
                if (r6 == 0) goto L_0x0036
                java.lang.Object r6 = r5.next()
                java.lang.Long r6 = (java.lang.Long) r6
                long r0 = r6.longValue()
                boolean r6 = r4.tryEmit(r0)
                if (r6 == 0) goto L_0x0047
                return
            L_0x005e:
                r5 = move-exception
                monitor-exit(r4)     // Catch:{ all -> 0x005e }
                throw r5
            L_0x0061:
                r5 = move-exception
                monitor-exit(r4)     // Catch:{ all -> 0x0061 }
                throw r5
            L_0x0064:
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "Request can't be negative! "
                r1.append(r2)
                r1.append(r5)
                java.lang.String r5 = r1.toString()
                r0.<init>(r5)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.observables.AsyncOnSubscribe.AsyncOuterManager.request(long):void");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:17:0x002a, code lost:
            if (tryEmit(r4) == false) goto L_0x002d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x002c, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x002d, code lost:
            monitor-enter(r3);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
            r4 = r3.requests;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0030, code lost:
            if (r4 != null) goto L_0x0037;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0032, code lost:
            r3.emitting = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0035, code lost:
            monitor-exit(r3);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0036, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0037, code lost:
            r3.requests = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x003a, code lost:
            monitor-exit(r3);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x003b, code lost:
            r4 = r4.iterator();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x0043, code lost:
            if (r4.hasNext() == false) goto L_0x002d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x0053, code lost:
            if (tryEmit(r4.next().longValue()) == false) goto L_0x003f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x0055, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void requestRemaining(long r4) {
            /*
                r3 = this;
                r0 = 0
                int r0 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
                if (r0 != 0) goto L_0x0007
                return
            L_0x0007:
                if (r0 < 0) goto L_0x005c
                monitor-enter(r3)
                boolean r0 = r3.emitting     // Catch:{ all -> 0x0059 }
                if (r0 == 0) goto L_0x0022
                java.util.List<java.lang.Long> r0 = r3.requests     // Catch:{ all -> 0x0059 }
                if (r0 != 0) goto L_0x0019
                java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x0059 }
                r0.<init>()     // Catch:{ all -> 0x0059 }
                r3.requests = r0     // Catch:{ all -> 0x0059 }
            L_0x0019:
                java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch:{ all -> 0x0059 }
                r0.add(r4)     // Catch:{ all -> 0x0059 }
                monitor-exit(r3)     // Catch:{ all -> 0x0059 }
                return
            L_0x0022:
                r0 = 1
                r3.emitting = r0     // Catch:{ all -> 0x0059 }
                monitor-exit(r3)     // Catch:{ all -> 0x0059 }
                boolean r4 = r3.tryEmit(r4)
                if (r4 == 0) goto L_0x002d
                return
            L_0x002d:
                monitor-enter(r3)
                java.util.List<java.lang.Long> r4 = r3.requests     // Catch:{ all -> 0x0056 }
                if (r4 != 0) goto L_0x0037
                r4 = 0
                r3.emitting = r4     // Catch:{ all -> 0x0056 }
                monitor-exit(r3)     // Catch:{ all -> 0x0056 }
                return
            L_0x0037:
                r5 = 0
                r3.requests = r5     // Catch:{ all -> 0x0056 }
                monitor-exit(r3)     // Catch:{ all -> 0x0056 }
                java.util.Iterator r4 = r4.iterator()
            L_0x003f:
                boolean r5 = r4.hasNext()
                if (r5 == 0) goto L_0x002d
                java.lang.Object r5 = r4.next()
                java.lang.Long r5 = (java.lang.Long) r5
                long r0 = r5.longValue()
                boolean r5 = r3.tryEmit(r0)
                if (r5 == 0) goto L_0x003f
                return
            L_0x0056:
                r4 = move-exception
                monitor-exit(r3)     // Catch:{ all -> 0x0056 }
                throw r4
            L_0x0059:
                r4 = move-exception
                monitor-exit(r3)     // Catch:{ all -> 0x0059 }
                throw r4
            L_0x005c:
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "Request can't be negative! "
                r1.append(r2)
                r1.append(r4)
                java.lang.String r4 = r1.toString()
                r0.<init>(r4)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.observables.AsyncOnSubscribe.AsyncOuterManager.requestRemaining(long):void");
        }

        public void setConcatProducer(Producer producer) {
            if (this.concatProducer == null) {
                this.concatProducer = producer;
                return;
            }
            throw new IllegalStateException("setConcatProducer may be called at most once!");
        }

        public boolean tryEmit(long j11) {
            if (isUnsubscribed()) {
                cleanup();
                return true;
            }
            try {
                this.onNextCalled = false;
                this.expectedDelivery = j11;
                nextIteration(j11);
                if (!this.hasTerminated) {
                    if (!isUnsubscribed()) {
                        if (this.onNextCalled) {
                            return false;
                        }
                        handleThrownError(new IllegalStateException("No events emitted!"));
                        return true;
                    }
                }
                cleanup();
                return true;
            } catch (Throwable th2) {
                handleThrownError(th2);
                return true;
            }
        }

        public void unsubscribe() {
            if (this.isUnsubscribed.compareAndSet(false, true)) {
                synchronized (this) {
                    if (this.emitting) {
                        ArrayList arrayList = new ArrayList();
                        this.requests = arrayList;
                        arrayList.add(0L);
                        return;
                    }
                    this.emitting = true;
                    cleanup();
                }
            }
        }

        public void onNext(Observable<? extends T> observable) {
            if (!this.onNextCalled) {
                this.onNextCalled = true;
                if (!this.hasTerminated) {
                    subscribeBufferToObservable(observable);
                    return;
                }
                return;
            }
            throw new IllegalStateException("onNext called multiple times!");
        }
    }

    public static final class UnicastSubject<T> extends Observable<T> implements Observer<T> {
        private final State<T> state;

        public static final class State<T> implements Observable.OnSubscribe<T> {
            public Subscriber<? super T> subscriber;

            public void call(Subscriber<? super T> subscriber2) {
                synchronized (this) {
                    if (this.subscriber == null) {
                        this.subscriber = subscriber2;
                    } else {
                        subscriber2.onError(new IllegalStateException("There can be only one subscriber"));
                    }
                }
            }
        }

        public UnicastSubject(State<T> state2) {
            super(state2);
            this.state = state2;
        }

        public static <T> UnicastSubject<T> create() {
            return new UnicastSubject<>(new State());
        }

        public void onCompleted() {
            this.state.subscriber.onCompleted();
        }

        public void onError(Throwable th2) {
            this.state.subscriber.onError(th2);
        }

        public void onNext(T t11) {
            this.state.subscriber.onNext(t11);
        }
    }

    public static <S, T> AsyncOnSubscribe<S, T> createSingleState(Func0<? extends S> func0, final Action3<? super S, Long, ? super Observer<Observable<? extends T>>> action3) {
        return new AsyncOnSubscribeImpl(func0, new Func3<S, Long, Observer<Observable<? extends T>>, S>() {
            public S call(S s11, Long l11, Observer<Observable<? extends T>> observer) {
                action3.call(s11, l11, observer);
                return s11;
            }
        });
    }

    public static <S, T> AsyncOnSubscribe<S, T> createStateful(Func0<? extends S> func0, Func3<? super S, Long, ? super Observer<Observable<? extends T>>, ? extends S> func3, Action1<? super S> action1) {
        return new AsyncOnSubscribeImpl(func0, func3, action1);
    }

    public static <T> AsyncOnSubscribe<Void, T> createStateless(final Action2<Long, ? super Observer<Observable<? extends T>>> action2) {
        return new AsyncOnSubscribeImpl(new Func3<Void, Long, Observer<Observable<? extends T>>, Void>() {
            public Void call(Void voidR, Long l11, Observer<Observable<? extends T>> observer) {
                action2.call(l11, observer);
                return voidR;
            }
        });
    }

    public abstract S generateState();

    public abstract S next(S s11, long j11, Observer<Observable<? extends T>> observer);

    public void onUnsubscribe(S s11) {
    }

    public static <S, T> AsyncOnSubscribe<S, T> createStateful(Func0<? extends S> func0, Func3<? super S, Long, ? super Observer<Observable<? extends T>>, ? extends S> func3) {
        return new AsyncOnSubscribeImpl(func0, func3);
    }

    public final void call(final Subscriber<? super T> subscriber) {
        try {
            Object generateState = generateState();
            UnicastSubject create = UnicastSubject.create();
            final AsyncOuterManager asyncOuterManager = new AsyncOuterManager(this, generateState, create);
            AnonymousClass6 r02 = new Subscriber<T>() {
                public void onCompleted() {
                    subscriber.onCompleted();
                }

                public void onError(Throwable th2) {
                    subscriber.onError(th2);
                }

                public void onNext(T t11) {
                    subscriber.onNext(t11);
                }

                public void setProducer(Producer producer) {
                    asyncOuterManager.setConcatProducer(producer);
                }
            };
            create.onBackpressureBuffer().concatMap(new Func1<Observable<T>, Observable<T>>() {
                public Observable<T> call(Observable<T> observable) {
                    return observable.onBackpressureBuffer();
                }
            }).unsafeSubscribe(r02);
            subscriber.add(r02);
            subscriber.add(asyncOuterManager);
            subscriber.setProducer(asyncOuterManager);
        } catch (Throwable th2) {
            subscriber.onError(th2);
        }
    }

    public static <S, T> AsyncOnSubscribe<S, T> createSingleState(Func0<? extends S> func0, final Action3<? super S, Long, ? super Observer<Observable<? extends T>>> action3, Action1<? super S> action1) {
        return new AsyncOnSubscribeImpl(func0, new Func3<S, Long, Observer<Observable<? extends T>>, S>() {
            public S call(S s11, Long l11, Observer<Observable<? extends T>> observer) {
                action3.call(s11, l11, observer);
                return s11;
            }
        }, action1);
    }

    public static <T> AsyncOnSubscribe<Void, T> createStateless(final Action2<Long, ? super Observer<Observable<? extends T>>> action2, final Action0 action0) {
        return new AsyncOnSubscribeImpl(new Func3<Void, Long, Observer<Observable<? extends T>>, Void>() {
            public Void call(Void voidR, Long l11, Observer<Observable<? extends T>> observer) {
                action2.call(l11, observer);
                return null;
            }
        }, new Action1<Void>() {
            public void call(Void voidR) {
                action0.call();
            }
        });
    }

    public static final class AsyncOnSubscribeImpl<S, T> extends AsyncOnSubscribe<S, T> {
        private final Func0<? extends S> generator;
        private final Func3<? super S, Long, ? super Observer<Observable<? extends T>>, ? extends S> next;
        private final Action1<? super S> onUnsubscribe;

        public AsyncOnSubscribeImpl(Func0<? extends S> func0, Func3<? super S, Long, ? super Observer<Observable<? extends T>>, ? extends S> func3, Action1<? super S> action1) {
            this.generator = func0;
            this.next = func3;
            this.onUnsubscribe = action1;
        }

        public /* bridge */ /* synthetic */ void call(Object obj) {
            AsyncOnSubscribe.super.call((Subscriber) obj);
        }

        public S generateState() {
            Func0<? extends S> func0 = this.generator;
            if (func0 == null) {
                return null;
            }
            return func0.call();
        }

        public S next(S s11, long j11, Observer<Observable<? extends T>> observer) {
            return this.next.call(s11, Long.valueOf(j11), observer);
        }

        public void onUnsubscribe(S s11) {
            Action1<? super S> action1 = this.onUnsubscribe;
            if (action1 != null) {
                action1.call(s11);
            }
        }

        public AsyncOnSubscribeImpl(Func0<? extends S> func0, Func3<? super S, Long, ? super Observer<Observable<? extends T>>, ? extends S> func3) {
            this(func0, func3, (Action1) null);
        }

        public AsyncOnSubscribeImpl(Func3<S, Long, Observer<Observable<? extends T>>, S> func3, Action1<? super S> action1) {
            this((Func0) null, func3, action1);
        }

        public AsyncOnSubscribeImpl(Func3<S, Long, Observer<Observable<? extends T>>, S> func3) {
            this((Func0) null, func3, (Action1) null);
        }
    }
}
