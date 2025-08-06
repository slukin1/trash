package rx.internal.operators;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.CompositeException;
import rx.functions.FuncN;
import rx.internal.util.RxRingBuffer;
import rx.internal.util.atomic.SpscLinkedArrayQueue;
import rx.plugins.RxJavaHooks;

public final class OnSubscribeCombineLatest<T, R> implements Observable.OnSubscribe<R> {
    public final int bufferSize;
    public final FuncN<? extends R> combiner;
    public final boolean delayError;
    public final Observable<? extends T>[] sources;
    public final Iterable<? extends Observable<? extends T>> sourcesIterable;

    public static final class CombinerSubscriber<T, R> extends Subscriber<T> {
        public boolean done;
        public final int index;
        public final LatestCoordinator<T, R> parent;

        public CombinerSubscriber(LatestCoordinator<T, R> latestCoordinator, int i11) {
            this.parent = latestCoordinator;
            this.index = i11;
            request((long) latestCoordinator.bufferSize);
        }

        public void onCompleted() {
            if (!this.done) {
                this.done = true;
                this.parent.combine((Object) null, this.index);
            }
        }

        public void onError(Throwable th2) {
            if (this.done) {
                RxJavaHooks.onError(th2);
                return;
            }
            this.parent.onError(th2);
            this.done = true;
            this.parent.combine((Object) null, this.index);
        }

        public void onNext(T t11) {
            if (!this.done) {
                this.parent.combine(NotificationLite.next(t11), this.index);
            }
        }

        public void requestMore(long j11) {
            request(j11);
        }
    }

    public static final class LatestCoordinator<T, R> extends AtomicInteger implements Producer, Subscription {
        public static final Object MISSING = new Object();
        private static final long serialVersionUID = 8567835998786448817L;
        public int active;
        public final Subscriber<? super R> actual;
        public final int bufferSize;
        public volatile boolean cancelled;
        public final FuncN<? extends R> combiner;
        public int complete;
        public final boolean delayError;
        public volatile boolean done;
        public final AtomicReference<Throwable> error = new AtomicReference<>();
        public final Object[] latest;
        public final SpscLinkedArrayQueue<Object> queue;
        public final AtomicLong requested = new AtomicLong();
        public final CombinerSubscriber<T, R>[] subscribers;

        public LatestCoordinator(Subscriber<? super R> subscriber, FuncN<? extends R> funcN, int i11, int i12, boolean z11) {
            this.actual = subscriber;
            this.combiner = funcN;
            this.bufferSize = i12;
            this.delayError = z11;
            Object[] objArr = new Object[i11];
            this.latest = objArr;
            Arrays.fill(objArr, MISSING);
            this.subscribers = new CombinerSubscriber[i11];
            this.queue = new SpscLinkedArrayQueue<>(i12);
        }

        public void cancel(Queue<?> queue2) {
            queue2.clear();
            for (CombinerSubscriber<T, R> unsubscribe : this.subscribers) {
                unsubscribe.unsubscribe();
            }
        }

        public boolean checkTerminated(boolean z11, boolean z12, Subscriber<?> subscriber, Queue<?> queue2, boolean z13) {
            if (this.cancelled) {
                cancel(queue2);
                return true;
            } else if (!z11) {
                return false;
            } else {
                if (!z13) {
                    Throwable th2 = this.error.get();
                    if (th2 != null) {
                        cancel(queue2);
                        subscriber.onError(th2);
                        return true;
                    } else if (!z12) {
                        return false;
                    } else {
                        subscriber.onCompleted();
                        return true;
                    }
                } else if (!z12) {
                    return false;
                } else {
                    Throwable th3 = this.error.get();
                    if (th3 != null) {
                        subscriber.onError(th3);
                    } else {
                        subscriber.onCompleted();
                    }
                    return true;
                }
            }
        }

        public void combine(Object obj, int i11) {
            boolean z11;
            CombinerSubscriber<T, R> combinerSubscriber = this.subscribers[i11];
            synchronized (this) {
                Object[] objArr = this.latest;
                int length = objArr.length;
                Object obj2 = objArr[i11];
                int i12 = this.active;
                Object obj3 = MISSING;
                if (obj2 == obj3) {
                    i12++;
                    this.active = i12;
                }
                int i13 = this.complete;
                if (obj == null) {
                    i13++;
                    this.complete = i13;
                } else {
                    objArr[i11] = NotificationLite.getValue(obj);
                }
                boolean z12 = false;
                z11 = i12 == length;
                if (i13 == length || (obj == null && obj2 == obj3)) {
                    z12 = true;
                }
                if (z12) {
                    this.done = true;
                } else if (obj != null && z11) {
                    this.queue.offer(combinerSubscriber, this.latest.clone());
                } else if (obj == null && this.error.get() != null && (obj2 == obj3 || !this.delayError)) {
                    this.done = true;
                }
            }
            if (z11 || obj == null) {
                drain();
            } else {
                combinerSubscriber.requestMore(1);
            }
        }

        public void drain() {
            long j11;
            if (getAndIncrement() == 0) {
                SpscLinkedArrayQueue<Object> spscLinkedArrayQueue = this.queue;
                Subscriber<? super R> subscriber = this.actual;
                boolean z11 = this.delayError;
                AtomicLong atomicLong = this.requested;
                int i11 = 1;
                do {
                    if (!checkTerminated(this.done, spscLinkedArrayQueue.isEmpty(), subscriber, spscLinkedArrayQueue, z11)) {
                        long j12 = atomicLong.get();
                        long j13 = 0;
                        while (true) {
                            if (j13 == j12) {
                                j11 = j13;
                                break;
                            }
                            boolean z12 = this.done;
                            CombinerSubscriber combinerSubscriber = (CombinerSubscriber) spscLinkedArrayQueue.peek();
                            boolean z13 = combinerSubscriber == null;
                            CombinerSubscriber combinerSubscriber2 = combinerSubscriber;
                            long j14 = j13;
                            if (!checkTerminated(z12, z13, subscriber, spscLinkedArrayQueue, z11)) {
                                if (z13) {
                                    j11 = j14;
                                    break;
                                }
                                spscLinkedArrayQueue.poll();
                                Object[] objArr = (Object[]) spscLinkedArrayQueue.poll();
                                if (objArr == null) {
                                    this.cancelled = true;
                                    cancel(spscLinkedArrayQueue);
                                    subscriber.onError(new IllegalStateException("Broken queue?! Sender received but not the array."));
                                    return;
                                }
                                try {
                                    subscriber.onNext(this.combiner.call(objArr));
                                    combinerSubscriber2.requestMore(1);
                                    j13 = j14 + 1;
                                } catch (Throwable th2) {
                                    this.cancelled = true;
                                    cancel(spscLinkedArrayQueue);
                                    subscriber.onError(th2);
                                    return;
                                }
                            } else {
                                return;
                            }
                        }
                        if (!(j11 == 0 || j12 == Long.MAX_VALUE)) {
                            BackpressureUtils.produced(atomicLong, j11);
                        }
                        i11 = addAndGet(-i11);
                    } else {
                        return;
                    }
                } while (i11 != 0);
            }
        }

        public boolean isUnsubscribed() {
            return this.cancelled;
        }

        public void onError(Throwable th2) {
            Throwable th3;
            Throwable th4;
            AtomicReference<Throwable> atomicReference = this.error;
            do {
                th3 = atomicReference.get();
                if (th3 == null) {
                    th4 = th2;
                } else if (th3 instanceof CompositeException) {
                    ArrayList arrayList = new ArrayList(((CompositeException) th3).getExceptions());
                    arrayList.add(th2);
                    th4 = new CompositeException((Collection<? extends Throwable>) arrayList);
                } else {
                    th4 = new CompositeException((Collection<? extends Throwable>) Arrays.asList(new Throwable[]{th3, th2}));
                }
            } while (!atomicReference.compareAndSet(th3, th4));
        }

        public void request(long j11) {
            int i11 = (j11 > 0 ? 1 : (j11 == 0 ? 0 : -1));
            if (i11 < 0) {
                throw new IllegalArgumentException("n >= required but it was " + j11);
            } else if (i11 != 0) {
                BackpressureUtils.getAndAddRequest(this.requested, j11);
                drain();
            }
        }

        public void subscribe(Observable<? extends T>[] observableArr) {
            CombinerSubscriber<T, R>[] combinerSubscriberArr = this.subscribers;
            int length = combinerSubscriberArr.length;
            for (int i11 = 0; i11 < length; i11++) {
                combinerSubscriberArr[i11] = new CombinerSubscriber<>(this, i11);
            }
            lazySet(0);
            this.actual.add(this);
            this.actual.setProducer(this);
            for (int i12 = 0; i12 < length && !this.cancelled; i12++) {
                observableArr[i12].subscribe(combinerSubscriberArr[i12]);
            }
        }

        public void unsubscribe() {
            if (!this.cancelled) {
                this.cancelled = true;
                if (getAndIncrement() == 0) {
                    cancel(this.queue);
                }
            }
        }
    }

    public OnSubscribeCombineLatest(Iterable<? extends Observable<? extends T>> iterable, FuncN<? extends R> funcN) {
        this((Observable<? extends T>[]) null, iterable, funcN, RxRingBuffer.SIZE, false);
    }

    public OnSubscribeCombineLatest(Observable<? extends T>[] observableArr, Iterable<? extends Observable<? extends T>> iterable, FuncN<? extends R> funcN, int i11, boolean z11) {
        this.sources = observableArr;
        this.sourcesIterable = iterable;
        this.combiner = funcN;
        this.bufferSize = i11;
        this.delayError = z11;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x004d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void call(rx.Subscriber<? super R> r9) {
        /*
            r8 = this;
            rx.Observable<? extends T>[] r0 = r8.sources
            if (r0 != 0) goto L_0x0045
            java.lang.Iterable<? extends rx.Observable<? extends T>> r0 = r8.sourcesIterable
            boolean r1 = r0 instanceof java.util.List
            if (r1 == 0) goto L_0x001a
            java.util.List r0 = (java.util.List) r0
            int r1 = r0.size()
            rx.Observable[] r1 = new rx.Observable[r1]
            java.lang.Object[] r0 = r0.toArray(r1)
            rx.Observable[] r0 = (rx.Observable[]) r0
            int r1 = r0.length
            goto L_0x0046
        L_0x001a:
            r1 = 8
            rx.Observable[] r1 = new rx.Observable[r1]
            java.util.Iterator r0 = r0.iterator()
            r2 = 0
            r3 = r2
        L_0x0024:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto L_0x0042
            java.lang.Object r4 = r0.next()
            rx.Observable r4 = (rx.Observable) r4
            int r5 = r1.length
            if (r3 != r5) goto L_0x003c
            int r5 = r3 >> 2
            int r5 = r5 + r3
            rx.Observable[] r5 = new rx.Observable[r5]
            java.lang.System.arraycopy(r1, r2, r5, r2, r3)
            r1 = r5
        L_0x003c:
            int r5 = r3 + 1
            r1[r3] = r4
            r3 = r5
            goto L_0x0024
        L_0x0042:
            r0 = r1
            r4 = r3
            goto L_0x0047
        L_0x0045:
            int r1 = r0.length
        L_0x0046:
            r4 = r1
        L_0x0047:
            if (r4 != 0) goto L_0x004d
            r9.onCompleted()
            return
        L_0x004d:
            rx.internal.operators.OnSubscribeCombineLatest$LatestCoordinator r7 = new rx.internal.operators.OnSubscribeCombineLatest$LatestCoordinator
            rx.functions.FuncN<? extends R> r3 = r8.combiner
            int r5 = r8.bufferSize
            boolean r6 = r8.delayError
            r1 = r7
            r2 = r9
            r1.<init>(r2, r3, r4, r5, r6)
            r7.subscribe(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.OnSubscribeCombineLatest.call(rx.Subscriber):void");
    }
}
