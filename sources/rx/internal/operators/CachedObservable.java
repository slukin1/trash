package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import rx.Observable;
import rx.Observer;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;
import rx.internal.util.LinkedArrayList;
import rx.subscriptions.SerialSubscription;

public final class CachedObservable<T> extends Observable<T> {
    private final CacheState<T> state;

    public static final class CacheState<T> extends LinkedArrayList implements Observer<T> {
        public static final ReplayProducer<?>[] EMPTY = new ReplayProducer[0];
        public final SerialSubscription connection = new SerialSubscription();
        public volatile boolean isConnected;
        public volatile ReplayProducer<?>[] producers = EMPTY;
        public final Observable<? extends T> source;
        public boolean sourceDone;

        public CacheState(Observable<? extends T> observable, int i11) {
            super(i11);
            this.source = observable;
        }

        public void addProducer(ReplayProducer<T> replayProducer) {
            synchronized (this.connection) {
                ReplayProducer<?>[] replayProducerArr = this.producers;
                int length = replayProducerArr.length;
                ReplayProducer<?>[] replayProducerArr2 = new ReplayProducer[(length + 1)];
                System.arraycopy(replayProducerArr, 0, replayProducerArr2, 0, length);
                replayProducerArr2[length] = replayProducer;
                this.producers = replayProducerArr2;
            }
        }

        public void connect() {
            AnonymousClass1 r02 = new Subscriber<T>() {
                public void onCompleted() {
                    CacheState.this.onCompleted();
                }

                public void onError(Throwable th2) {
                    CacheState.this.onError(th2);
                }

                public void onNext(T t11) {
                    CacheState.this.onNext(t11);
                }
            };
            this.connection.set(r02);
            this.source.unsafeSubscribe(r02);
            this.isConnected = true;
        }

        public void dispatch() {
            for (ReplayProducer<?> replay : this.producers) {
                replay.replay();
            }
        }

        public void onCompleted() {
            if (!this.sourceDone) {
                this.sourceDone = true;
                add(NotificationLite.completed());
                this.connection.unsubscribe();
                dispatch();
            }
        }

        public void onError(Throwable th2) {
            if (!this.sourceDone) {
                this.sourceDone = true;
                add(NotificationLite.error(th2));
                this.connection.unsubscribe();
                dispatch();
            }
        }

        public void onNext(T t11) {
            if (!this.sourceDone) {
                add(NotificationLite.next(t11));
                dispatch();
            }
        }

        public void removeProducer(ReplayProducer<T> replayProducer) {
            synchronized (this.connection) {
                ReplayProducer<?>[] replayProducerArr = this.producers;
                int length = replayProducerArr.length;
                int i11 = -1;
                int i12 = 0;
                while (true) {
                    if (i12 >= length) {
                        break;
                    } else if (replayProducerArr[i12].equals(replayProducer)) {
                        i11 = i12;
                        break;
                    } else {
                        i12++;
                    }
                }
                if (i11 >= 0) {
                    if (length == 1) {
                        this.producers = EMPTY;
                        return;
                    }
                    ReplayProducer<?>[] replayProducerArr2 = new ReplayProducer[(length - 1)];
                    System.arraycopy(replayProducerArr, 0, replayProducerArr2, 0, i11);
                    System.arraycopy(replayProducerArr, i11 + 1, replayProducerArr2, i11, (length - i11) - 1);
                    this.producers = replayProducerArr2;
                }
            }
        }
    }

    public static final class CachedSubscribe<T> extends AtomicBoolean implements Observable.OnSubscribe<T> {
        private static final long serialVersionUID = -2817751667698696782L;
        public final CacheState<T> state;

        public CachedSubscribe(CacheState<T> cacheState) {
            this.state = cacheState;
        }

        public void call(Subscriber<? super T> subscriber) {
            ReplayProducer replayProducer = new ReplayProducer(subscriber, this.state);
            this.state.addProducer(replayProducer);
            subscriber.add(replayProducer);
            subscriber.setProducer(replayProducer);
            if (!get() && compareAndSet(false, true)) {
                this.state.connect();
            }
        }
    }

    public static final class ReplayProducer<T> extends AtomicLong implements Producer, Subscription {
        private static final long serialVersionUID = -2557562030197141021L;
        public final Subscriber<? super T> child;
        public Object[] currentBuffer;
        public int currentIndexInBuffer;
        public boolean emitting;
        public int index;
        public boolean missed;
        public final CacheState<T> state;

        public ReplayProducer(Subscriber<? super T> subscriber, CacheState<T> cacheState) {
            this.child = subscriber;
            this.state = cacheState;
        }

        public boolean isUnsubscribed() {
            return get() < 0;
        }

        public long produced(long j11) {
            return addAndGet(-j11);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:103:0x00de, code lost:
            throw r1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:117:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:119:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
            r2 = r15.child;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0010, code lost:
            r3 = get();
            r7 = (r3 > 0 ? 1 : (r3 == 0 ? 0 : -1));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0018, code lost:
            if (r7 >= 0) goto L_0x001b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x001a, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x001b, code lost:
            r8 = r15.state.size();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0021, code lost:
            if (r8 == 0) goto L_0x00ba;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0023, code lost:
            r9 = r15.currentBuffer;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0025, code lost:
            if (r9 != null) goto L_0x002f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0027, code lost:
            r9 = r15.state.head();
            r15.currentBuffer = r9;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x002f, code lost:
            r10 = r9.length - 1;
            r11 = r15.index;
            r12 = r15.currentIndexInBuffer;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0035, code lost:
            if (r7 != 0) goto L_0x0057;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0037, code lost:
            r3 = r9[r12];
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x003d, code lost:
            if (rx.internal.operators.NotificationLite.isCompleted(r3) == false) goto L_0x0046;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x003f, code lost:
            r2.onCompleted();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
            unsubscribe();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0045, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x004a, code lost:
            if (rx.internal.operators.NotificationLite.isError(r3) == false) goto L_0x00ba;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x004c, code lost:
            r2.onError(rx.internal.operators.NotificationLite.getError(r3));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
            unsubscribe();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x0056, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x0057, code lost:
            if (r7 <= 0) goto L_0x00ba;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x0059, code lost:
            r7 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x005a, code lost:
            if (r11 >= r8) goto L_0x00a9;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:0x005e, code lost:
            if (r3 <= 0) goto L_0x00a9;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:42:0x0064, code lost:
            if (r2.isUnsubscribed() == false) goto L_0x0067;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:0x0066, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:0x0067, code lost:
            if (r12 != r10) goto L_0x006e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:45:0x0069, code lost:
            r9 = (java.lang.Object[]) r9[r10];
            r12 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:0x006e, code lost:
            r13 = r9[r12];
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:0x0074, code lost:
            if (rx.internal.operators.NotificationLite.accept(r2, r13) == false) goto L_0x007d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:51:?, code lost:
            unsubscribe();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:52:0x0079, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:53:0x007a, code lost:
            r3 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:54:0x007b, code lost:
            r4 = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:55:0x007d, code lost:
            r12 = r12 + 1;
            r11 = r11 + 1;
            r3 = r3 - 1;
            r7 = r7 + 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:56:0x0087, code lost:
            r3 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:57:0x0088, code lost:
            r4 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:59:?, code lost:
            rx.exceptions.Exceptions.throwIfFatal(r3);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:61:?, code lost:
            unsubscribe();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:62:0x0093, code lost:
            if (rx.internal.operators.NotificationLite.isError(r13) != false) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:65:0x009b, code lost:
            r2.onError(rx.exceptions.OnErrorThrowable.addValueAsLastCause(r3, rx.internal.operators.NotificationLite.getValue(r13)));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:66:0x00a7, code lost:
            r1 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:69:0x00ad, code lost:
            if (r2.isUnsubscribed() == false) goto L_0x00b0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:70:0x00af, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:71:0x00b0, code lost:
            r15.index = r11;
            r15.currentIndexInBuffer = r12;
            r15.currentBuffer = r9;
            produced((long) r7);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:72:0x00ba, code lost:
            monitor-enter(r15);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:75:0x00bd, code lost:
            if (r15.missed != false) goto L_0x00c3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:76:0x00bf, code lost:
            r15.emitting = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:78:?, code lost:
            monitor-exit(r15);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:79:0x00c2, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:81:?, code lost:
            r15.missed = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:82:0x00c5, code lost:
            monitor-exit(r15);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:83:0x00c8, code lost:
            r2 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:84:0x00c9, code lost:
            r1 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:86:?, code lost:
            monitor-exit(r15);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:88:?, code lost:
            throw r2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:89:0x00cc, code lost:
            r2 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:90:0x00cd, code lost:
            r4 = r1;
            r1 = r2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:91:0x00d0, code lost:
            r2 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:92:0x00d2, code lost:
            r1 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:93:0x00d3, code lost:
            r4 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:94:0x00d4, code lost:
            if (r4 == false) goto L_0x00d6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:95:0x00d6, code lost:
            monitor-enter(r15);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:97:?, code lost:
            r15.emitting = false;
         */
        /* JADX WARNING: Removed duplicated region for block: B:119:? A[RETURN, SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:65:0x009b A[Catch:{ all -> 0x00cc }] */
        /* JADX WARNING: Removed duplicated region for block: B:95:0x00d6  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void replay() {
            /*
                r15 = this;
                monitor-enter(r15)
                boolean r0 = r15.emitting     // Catch:{ all -> 0x00df }
                r1 = 1
                if (r0 == 0) goto L_0x000a
                r15.missed = r1     // Catch:{ all -> 0x00df }
                monitor-exit(r15)     // Catch:{ all -> 0x00df }
                return
            L_0x000a:
                r15.emitting = r1     // Catch:{ all -> 0x00df }
                monitor-exit(r15)     // Catch:{ all -> 0x00df }
                r0 = 0
                rx.Subscriber<? super T> r2 = r15.child     // Catch:{ all -> 0x00d2 }
            L_0x0010:
                long r3 = r15.get()     // Catch:{ all -> 0x00d2 }
                r5 = 0
                int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r7 >= 0) goto L_0x001b
                return
            L_0x001b:
                rx.internal.operators.CachedObservable$CacheState<T> r8 = r15.state     // Catch:{ all -> 0x00d2 }
                int r8 = r8.size()     // Catch:{ all -> 0x00d2 }
                if (r8 == 0) goto L_0x00ba
                java.lang.Object[] r9 = r15.currentBuffer     // Catch:{ all -> 0x00d2 }
                if (r9 != 0) goto L_0x002f
                rx.internal.operators.CachedObservable$CacheState<T> r9 = r15.state     // Catch:{ all -> 0x00d2 }
                java.lang.Object[] r9 = r9.head()     // Catch:{ all -> 0x00d2 }
                r15.currentBuffer = r9     // Catch:{ all -> 0x00d2 }
            L_0x002f:
                int r10 = r9.length     // Catch:{ all -> 0x00d2 }
                int r10 = r10 - r1
                int r11 = r15.index     // Catch:{ all -> 0x00d2 }
                int r12 = r15.currentIndexInBuffer     // Catch:{ all -> 0x00d2 }
                if (r7 != 0) goto L_0x0057
                r3 = r9[r12]     // Catch:{ all -> 0x00d2 }
                boolean r4 = rx.internal.operators.NotificationLite.isCompleted(r3)     // Catch:{ all -> 0x00d2 }
                if (r4 == 0) goto L_0x0046
                r2.onCompleted()     // Catch:{ all -> 0x00d2 }
                r15.unsubscribe()     // Catch:{ all -> 0x00cc }
                return
            L_0x0046:
                boolean r4 = rx.internal.operators.NotificationLite.isError(r3)     // Catch:{ all -> 0x00d2 }
                if (r4 == 0) goto L_0x00ba
                java.lang.Throwable r3 = rx.internal.operators.NotificationLite.getError(r3)     // Catch:{ all -> 0x00d2 }
                r2.onError(r3)     // Catch:{ all -> 0x00d2 }
                r15.unsubscribe()     // Catch:{ all -> 0x00cc }
                return
            L_0x0057:
                if (r7 <= 0) goto L_0x00ba
                r7 = r0
            L_0x005a:
                if (r11 >= r8) goto L_0x00a9
                int r13 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r13 <= 0) goto L_0x00a9
                boolean r13 = r2.isUnsubscribed()     // Catch:{ all -> 0x00d2 }
                if (r13 == 0) goto L_0x0067
                return
            L_0x0067:
                if (r12 != r10) goto L_0x006e
                r9 = r9[r10]     // Catch:{ all -> 0x00d2 }
                java.lang.Object[] r9 = (java.lang.Object[]) r9     // Catch:{ all -> 0x00d2 }
                r12 = r0
            L_0x006e:
                r13 = r9[r12]     // Catch:{ all -> 0x00d2 }
                boolean r14 = rx.internal.operators.NotificationLite.accept(r2, r13)     // Catch:{ all -> 0x0087 }
                if (r14 == 0) goto L_0x007d
                r15.unsubscribe()     // Catch:{ all -> 0x007a }
                return
            L_0x007a:
                r3 = move-exception
                r4 = r1
                goto L_0x0089
            L_0x007d:
                int r12 = r12 + 1
                int r11 = r11 + 1
                r13 = 1
                long r3 = r3 - r13
                int r7 = r7 + 1
                goto L_0x005a
            L_0x0087:
                r3 = move-exception
                r4 = r0
            L_0x0089:
                rx.exceptions.Exceptions.throwIfFatal(r3)     // Catch:{ all -> 0x00a7 }
                r15.unsubscribe()     // Catch:{ all -> 0x00cc }
                boolean r4 = rx.internal.operators.NotificationLite.isError(r13)     // Catch:{ all -> 0x00cc }
                if (r4 != 0) goto L_0x00a6
                boolean r4 = rx.internal.operators.NotificationLite.isCompleted(r13)     // Catch:{ all -> 0x00cc }
                if (r4 != 0) goto L_0x00a6
                java.lang.Object r4 = rx.internal.operators.NotificationLite.getValue(r13)     // Catch:{ all -> 0x00cc }
                java.lang.Throwable r3 = rx.exceptions.OnErrorThrowable.addValueAsLastCause(r3, r4)     // Catch:{ all -> 0x00cc }
                r2.onError(r3)     // Catch:{ all -> 0x00cc }
            L_0x00a6:
                return
            L_0x00a7:
                r1 = move-exception
                goto L_0x00d4
            L_0x00a9:
                boolean r3 = r2.isUnsubscribed()     // Catch:{ all -> 0x00d2 }
                if (r3 == 0) goto L_0x00b0
                return
            L_0x00b0:
                r15.index = r11     // Catch:{ all -> 0x00d2 }
                r15.currentIndexInBuffer = r12     // Catch:{ all -> 0x00d2 }
                r15.currentBuffer = r9     // Catch:{ all -> 0x00d2 }
                long r3 = (long) r7     // Catch:{ all -> 0x00d2 }
                r15.produced(r3)     // Catch:{ all -> 0x00d2 }
            L_0x00ba:
                monitor-enter(r15)     // Catch:{ all -> 0x00d2 }
                boolean r3 = r15.missed     // Catch:{ all -> 0x00c8 }
                if (r3 != 0) goto L_0x00c3
                r15.emitting = r0     // Catch:{ all -> 0x00c8 }
                monitor-exit(r15)     // Catch:{ all -> 0x00d0 }
                return
            L_0x00c3:
                r15.missed = r0     // Catch:{ all -> 0x00c8 }
                monitor-exit(r15)     // Catch:{ all -> 0x00c8 }
                goto L_0x0010
            L_0x00c8:
                r2 = move-exception
                r1 = r0
            L_0x00ca:
                monitor-exit(r15)     // Catch:{ all -> 0x00d0 }
                throw r2     // Catch:{ all -> 0x00cc }
            L_0x00cc:
                r2 = move-exception
                r4 = r1
                r1 = r2
                goto L_0x00d4
            L_0x00d0:
                r2 = move-exception
                goto L_0x00ca
            L_0x00d2:
                r1 = move-exception
                r4 = r0
            L_0x00d4:
                if (r4 != 0) goto L_0x00de
                monitor-enter(r15)
                r15.emitting = r0     // Catch:{ all -> 0x00db }
                monitor-exit(r15)     // Catch:{ all -> 0x00db }
                goto L_0x00de
            L_0x00db:
                r0 = move-exception
                monitor-exit(r15)     // Catch:{ all -> 0x00db }
                throw r0
            L_0x00de:
                throw r1
            L_0x00df:
                r0 = move-exception
                monitor-exit(r15)     // Catch:{ all -> 0x00df }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.CachedObservable.ReplayProducer.replay():void");
        }

        public void request(long j11) {
            long j12;
            long j13;
            do {
                j12 = get();
                if (j12 >= 0) {
                    j13 = j12 + j11;
                    if (j13 < 0) {
                        j13 = Long.MAX_VALUE;
                    }
                } else {
                    return;
                }
            } while (!compareAndSet(j12, j13));
            replay();
        }

        public void unsubscribe() {
            if (get() >= 0 && getAndSet(-1) >= 0) {
                this.state.removeProducer(this);
            }
        }
    }

    private CachedObservable(Observable.OnSubscribe<T> onSubscribe, CacheState<T> cacheState) {
        super(onSubscribe);
        this.state = cacheState;
    }

    public static <T> CachedObservable<T> from(Observable<? extends T> observable) {
        return from(observable, 16);
    }

    public boolean hasObservers() {
        return this.state.producers.length != 0;
    }

    public boolean isConnected() {
        return this.state.isConnected;
    }

    public static <T> CachedObservable<T> from(Observable<? extends T> observable, int i11) {
        if (i11 >= 1) {
            CacheState cacheState = new CacheState(observable, i11);
            return new CachedObservable<>(new CachedSubscribe(cacheState), cacheState);
        }
        throw new IllegalArgumentException("capacityHint > 0 required");
    }
}
