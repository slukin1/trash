package rx.internal.operators;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import rx.Observable;
import rx.Observer;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.Exceptions;
import rx.functions.Action0;
import rx.functions.Func1;
import rx.internal.util.atomic.SpscAtomicArrayQueue;
import rx.internal.util.unsafe.SpscArrayQueue;
import rx.internal.util.unsafe.UnsafeAccess;
import rx.subscriptions.Subscriptions;

public final class OperatorEagerConcatMap<T, R> implements Observable.Operator<R, T> {
    public final int bufferSize;
    public final Func1<? super T, ? extends Observable<? extends R>> mapper;
    private final int maxConcurrent;

    public static final class EagerInnerSubscriber<T> extends Subscriber<T> {
        public volatile boolean done;
        public Throwable error;
        public final EagerOuterSubscriber<?, T> parent;
        public final Queue<Object> queue;

        public EagerInnerSubscriber(EagerOuterSubscriber<?, T> eagerOuterSubscriber, int i11) {
            Queue<Object> queue2;
            this.parent = eagerOuterSubscriber;
            if (UnsafeAccess.isUnsafeAvailable()) {
                queue2 = new SpscArrayQueue<>(i11);
            } else {
                queue2 = new SpscAtomicArrayQueue<>(i11);
            }
            this.queue = queue2;
            request((long) i11);
        }

        public void onCompleted() {
            this.done = true;
            this.parent.drain();
        }

        public void onError(Throwable th2) {
            this.error = th2;
            this.done = true;
            this.parent.drain();
        }

        public void onNext(T t11) {
            this.queue.offer(NotificationLite.next(t11));
            this.parent.drain();
        }

        public void requestMore(long j11) {
            request(j11);
        }
    }

    public static final class EagerOuterProducer extends AtomicLong implements Producer {
        private static final long serialVersionUID = -657299606803478389L;
        public final EagerOuterSubscriber<?, ?> parent;

        public EagerOuterProducer(EagerOuterSubscriber<?, ?> eagerOuterSubscriber) {
            this.parent = eagerOuterSubscriber;
        }

        public void request(long j11) {
            int i11 = (j11 > 0 ? 1 : (j11 == 0 ? 0 : -1));
            if (i11 < 0) {
                throw new IllegalStateException("n >= 0 required but it was " + j11);
            } else if (i11 > 0) {
                BackpressureUtils.getAndAddRequest(this, j11);
                this.parent.drain();
            }
        }
    }

    public static final class EagerOuterSubscriber<T, R> extends Subscriber<T> {
        public final Subscriber<? super R> actual;
        public final int bufferSize;
        public volatile boolean cancelled;
        public volatile boolean done;
        public Throwable error;
        public final Func1<? super T, ? extends Observable<? extends R>> mapper;
        private EagerOuterProducer sharedProducer;
        public final Queue<EagerInnerSubscriber<R>> subscribers = new LinkedList();
        public final AtomicInteger wip = new AtomicInteger();

        public EagerOuterSubscriber(Func1<? super T, ? extends Observable<? extends R>> func1, int i11, int i12, Subscriber<? super R> subscriber) {
            this.mapper = func1;
            this.bufferSize = i11;
            this.actual = subscriber;
            request(i12 == Integer.MAX_VALUE ? Long.MAX_VALUE : (long) i12);
        }

        public void cleanup() {
            ArrayList<Subscription> arrayList;
            synchronized (this.subscribers) {
                arrayList = new ArrayList<>(this.subscribers);
                this.subscribers.clear();
            }
            for (Subscription unsubscribe : arrayList) {
                unsubscribe.unsubscribe();
            }
        }

        public void drain() {
            EagerInnerSubscriber peek;
            int i11;
            if (this.wip.getAndIncrement() == 0) {
                EagerOuterProducer eagerOuterProducer = this.sharedProducer;
                Subscriber<? super R> subscriber = this.actual;
                int i12 = 1;
                while (!this.cancelled) {
                    boolean z11 = this.done;
                    synchronized (this.subscribers) {
                        peek = this.subscribers.peek();
                    }
                    boolean z12 = false;
                    boolean z13 = peek == null;
                    if (z11) {
                        Throwable th2 = this.error;
                        if (th2 != null) {
                            cleanup();
                            subscriber.onError(th2);
                            return;
                        } else if (z13) {
                            subscriber.onCompleted();
                            return;
                        }
                    }
                    if (!z13) {
                        long j11 = eagerOuterProducer.get();
                        Queue<Object> queue = peek.queue;
                        long j12 = 0;
                        while (true) {
                            boolean z14 = peek.done;
                            Object peek2 = queue.peek();
                            i11 = i12;
                            boolean z15 = peek2 == null;
                            if (z14) {
                                Throwable th3 = peek.error;
                                if (th3 == null) {
                                    if (z15) {
                                        synchronized (this.subscribers) {
                                            this.subscribers.poll();
                                        }
                                        peek.unsubscribe();
                                        request(1);
                                        z12 = true;
                                        break;
                                    }
                                } else {
                                    cleanup();
                                    subscriber.onError(th3);
                                    return;
                                }
                            }
                            if (z15 || j11 == j12) {
                                break;
                            }
                            queue.poll();
                            try {
                                subscriber.onNext(NotificationLite.getValue(peek2));
                                j12++;
                                i12 = i11;
                            } catch (Throwable th4) {
                                Exceptions.throwOrReport(th4, (Observer<?>) subscriber, peek2);
                                return;
                            }
                        }
                        if (j12 != 0) {
                            if (j11 != Long.MAX_VALUE) {
                                BackpressureUtils.produced(eagerOuterProducer, j12);
                            }
                            if (!z12) {
                                peek.requestMore(j12);
                            }
                        }
                        if (z12) {
                            i12 = i11;
                        }
                    } else {
                        i11 = i12;
                    }
                    i12 = this.wip.addAndGet(-i11);
                    if (i12 == 0) {
                        return;
                    }
                }
                cleanup();
            }
        }

        public void init() {
            this.sharedProducer = new EagerOuterProducer(this);
            add(Subscriptions.create(new Action0() {
                public void call() {
                    EagerOuterSubscriber.this.cancelled = true;
                    if (EagerOuterSubscriber.this.wip.getAndIncrement() == 0) {
                        EagerOuterSubscriber.this.cleanup();
                    }
                }
            }));
            this.actual.add(this);
            this.actual.setProducer(this.sharedProducer);
        }

        public void onCompleted() {
            this.done = true;
            drain();
        }

        public void onError(Throwable th2) {
            this.error = th2;
            this.done = true;
            drain();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0025, code lost:
            if (r3.cancelled == false) goto L_0x0028;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0027, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0028, code lost:
            r0.unsafeSubscribe(r4);
            drain();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x002e, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onNext(T r4) {
            /*
                r3 = this;
                rx.functions.Func1<? super T, ? extends rx.Observable<? extends R>> r0 = r3.mapper     // Catch:{ all -> 0x0032 }
                java.lang.Object r0 = r0.call(r4)     // Catch:{ all -> 0x0032 }
                rx.Observable r0 = (rx.Observable) r0     // Catch:{ all -> 0x0032 }
                boolean r4 = r3.cancelled
                if (r4 == 0) goto L_0x000d
                return
            L_0x000d:
                rx.internal.operators.OperatorEagerConcatMap$EagerInnerSubscriber r4 = new rx.internal.operators.OperatorEagerConcatMap$EagerInnerSubscriber
                int r1 = r3.bufferSize
                r4.<init>(r3, r1)
                java.util.Queue<rx.internal.operators.OperatorEagerConcatMap$EagerInnerSubscriber<R>> r1 = r3.subscribers
                monitor-enter(r1)
                boolean r2 = r3.cancelled     // Catch:{ all -> 0x002f }
                if (r2 == 0) goto L_0x001d
                monitor-exit(r1)     // Catch:{ all -> 0x002f }
                return
            L_0x001d:
                java.util.Queue<rx.internal.operators.OperatorEagerConcatMap$EagerInnerSubscriber<R>> r2 = r3.subscribers     // Catch:{ all -> 0x002f }
                r2.add(r4)     // Catch:{ all -> 0x002f }
                monitor-exit(r1)     // Catch:{ all -> 0x002f }
                boolean r1 = r3.cancelled
                if (r1 == 0) goto L_0x0028
                return
            L_0x0028:
                r0.unsafeSubscribe(r4)
                r3.drain()
                return
            L_0x002f:
                r4 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x002f }
                throw r4
            L_0x0032:
                r0 = move-exception
                rx.Subscriber<? super R> r1 = r3.actual
                rx.exceptions.Exceptions.throwOrReport((java.lang.Throwable) r0, (rx.Observer<?>) r1, (java.lang.Object) r4)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.OperatorEagerConcatMap.EagerOuterSubscriber.onNext(java.lang.Object):void");
        }
    }

    public OperatorEagerConcatMap(Func1<? super T, ? extends Observable<? extends R>> func1, int i11, int i12) {
        this.mapper = func1;
        this.bufferSize = i11;
        this.maxConcurrent = i12;
    }

    public Subscriber<? super T> call(Subscriber<? super R> subscriber) {
        EagerOuterSubscriber eagerOuterSubscriber = new EagerOuterSubscriber(this.mapper, this.bufferSize, this.maxConcurrent, subscriber);
        eagerOuterSubscriber.init();
        return eagerOuterSubscriber;
    }
}
