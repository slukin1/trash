package rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.Observable;
import rx.Observer;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;

public final class OperatorOnBackpressureLatest<T> implements Observable.Operator<T, T> {

    public static final class Holder {
        public static final OperatorOnBackpressureLatest<Object> INSTANCE = new OperatorOnBackpressureLatest<>();
    }

    public static final class LatestEmitter<T> extends AtomicLong implements Producer, Subscription, Observer<T> {
        public static final Object EMPTY = new Object();
        public static final long NOT_REQUESTED = -4611686018427387904L;
        private static final long serialVersionUID = -1364393685005146274L;
        public final Subscriber<? super T> child;
        public volatile boolean done;
        public boolean emitting;
        public boolean missed;
        public LatestSubscriber<? super T> parent;
        public Throwable terminal;
        public final AtomicReference<Object> value = new AtomicReference<>(EMPTY);

        public LatestEmitter(Subscriber<? super T> subscriber) {
            this.child = subscriber;
            lazySet(-4611686018427387904L);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
            r2 = get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0018, code lost:
            if (r2 != Long.MIN_VALUE) goto L_0x001b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x001b, code lost:
            r4 = r8.value.get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0025, code lost:
            if (r2 <= 0) goto L_0x003b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0027, code lost:
            r2 = EMPTY;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0029, code lost:
            if (r4 == r2) goto L_0x003b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x002b, code lost:
            r8.child.onNext(r4);
            r8.value.compareAndSet(r4, r2);
            produced(1);
            r4 = r2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x003d, code lost:
            if (r4 != EMPTY) goto L_0x0052;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0041, code lost:
            if (r8.done == false) goto L_0x0052;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0043, code lost:
            r2 = r8.terminal;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0045, code lost:
            if (r2 == null) goto L_0x004d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0047, code lost:
            r8.child.onError(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x004d, code lost:
            r8.child.onCompleted();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0052, code lost:
            monitor-enter(r8);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0055, code lost:
            if (r8.missed != false) goto L_0x005b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x0057, code lost:
            r8.emitting = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:?, code lost:
            monitor-exit(r8);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
            r8.missed = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x005d, code lost:
            monitor-exit(r8);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x005f, code lost:
            r2 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x0060, code lost:
            r1 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
            monitor-exit(r8);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
            throw r2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:42:0x0063, code lost:
            r2 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:0x0064, code lost:
            r7 = r2;
            r2 = r1;
            r1 = r7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:0x0068, code lost:
            r2 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:45:0x006a, code lost:
            r1 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:0x006b, code lost:
            r2 = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:47:0x006c, code lost:
            if (r2 == false) goto L_0x006e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:48:0x006e, code lost:
            monitor-enter(r8);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:50:?, code lost:
            r8.emitting = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:56:0x0076, code lost:
            throw r1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:66:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:67:?, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void emit() {
            /*
                r8 = this;
                monitor-enter(r8)
                boolean r0 = r8.emitting     // Catch:{ all -> 0x0077 }
                r1 = 1
                if (r0 == 0) goto L_0x000a
                r8.missed = r1     // Catch:{ all -> 0x0077 }
                monitor-exit(r8)     // Catch:{ all -> 0x0077 }
                return
            L_0x000a:
                r8.emitting = r1     // Catch:{ all -> 0x0077 }
                r0 = 0
                r8.missed = r0     // Catch:{ all -> 0x0077 }
                monitor-exit(r8)     // Catch:{ all -> 0x0077 }
            L_0x0010:
                long r2 = r8.get()     // Catch:{ all -> 0x006a }
                r4 = -9223372036854775808
                int r4 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r4 != 0) goto L_0x001b
                goto L_0x005a
            L_0x001b:
                java.util.concurrent.atomic.AtomicReference<java.lang.Object> r4 = r8.value     // Catch:{ all -> 0x006a }
                java.lang.Object r4 = r4.get()     // Catch:{ all -> 0x006a }
                r5 = 0
                int r2 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
                if (r2 <= 0) goto L_0x003b
                java.lang.Object r2 = EMPTY     // Catch:{ all -> 0x006a }
                if (r4 == r2) goto L_0x003b
                rx.Subscriber<? super T> r3 = r8.child     // Catch:{ all -> 0x006a }
                r3.onNext(r4)     // Catch:{ all -> 0x006a }
                java.util.concurrent.atomic.AtomicReference<java.lang.Object> r3 = r8.value     // Catch:{ all -> 0x006a }
                r3.compareAndSet(r4, r2)     // Catch:{ all -> 0x006a }
                r3 = 1
                r8.produced(r3)     // Catch:{ all -> 0x006a }
                r4 = r2
            L_0x003b:
                java.lang.Object r2 = EMPTY     // Catch:{ all -> 0x006a }
                if (r4 != r2) goto L_0x0052
                boolean r2 = r8.done     // Catch:{ all -> 0x006a }
                if (r2 == 0) goto L_0x0052
                java.lang.Throwable r2 = r8.terminal     // Catch:{ all -> 0x006a }
                if (r2 == 0) goto L_0x004d
                rx.Subscriber<? super T> r3 = r8.child     // Catch:{ all -> 0x006a }
                r3.onError(r2)     // Catch:{ all -> 0x006a }
                goto L_0x0052
            L_0x004d:
                rx.Subscriber<? super T> r2 = r8.child     // Catch:{ all -> 0x006a }
                r2.onCompleted()     // Catch:{ all -> 0x006a }
            L_0x0052:
                monitor-enter(r8)     // Catch:{ all -> 0x006a }
                boolean r2 = r8.missed     // Catch:{ all -> 0x005f }
                if (r2 != 0) goto L_0x005b
                r8.emitting = r0     // Catch:{ all -> 0x005f }
                monitor-exit(r8)     // Catch:{ all -> 0x0068 }
            L_0x005a:
                return
            L_0x005b:
                r8.missed = r0     // Catch:{ all -> 0x005f }
                monitor-exit(r8)     // Catch:{ all -> 0x005f }
                goto L_0x0010
            L_0x005f:
                r2 = move-exception
                r1 = r0
            L_0x0061:
                monitor-exit(r8)     // Catch:{ all -> 0x0068 }
                throw r2     // Catch:{ all -> 0x0063 }
            L_0x0063:
                r2 = move-exception
                r7 = r2
                r2 = r1
                r1 = r7
                goto L_0x006c
            L_0x0068:
                r2 = move-exception
                goto L_0x0061
            L_0x006a:
                r1 = move-exception
                r2 = r0
            L_0x006c:
                if (r2 != 0) goto L_0x0076
                monitor-enter(r8)
                r8.emitting = r0     // Catch:{ all -> 0x0073 }
                monitor-exit(r8)     // Catch:{ all -> 0x0073 }
                goto L_0x0076
            L_0x0073:
                r0 = move-exception
                monitor-exit(r8)     // Catch:{ all -> 0x0073 }
                throw r0
            L_0x0076:
                throw r1
            L_0x0077:
                r0 = move-exception
                monitor-exit(r8)     // Catch:{ all -> 0x0077 }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.OperatorOnBackpressureLatest.LatestEmitter.emit():void");
        }

        public boolean isUnsubscribed() {
            return get() == Long.MIN_VALUE;
        }

        public void onCompleted() {
            this.done = true;
            emit();
        }

        public void onError(Throwable th2) {
            this.terminal = th2;
            this.done = true;
            emit();
        }

        public void onNext(T t11) {
            this.value.lazySet(t11);
            emit();
        }

        public long produced(long j11) {
            long j12;
            long j13;
            do {
                j12 = get();
                if (j12 < 0) {
                    return j12;
                }
                j13 = j12 - j11;
            } while (!compareAndSet(j12, j13));
            return j13;
        }

        public void request(long j11) {
            long j12;
            int i11;
            long j13;
            if (j11 >= 0) {
                do {
                    j12 = get();
                    if (j12 != Long.MIN_VALUE) {
                        i11 = (j12 > -4611686018427387904L ? 1 : (j12 == -4611686018427387904L ? 0 : -1));
                        if (i11 == 0) {
                            j13 = j11;
                        } else {
                            j13 = j12 + j11;
                            if (j13 < 0) {
                                j13 = Long.MAX_VALUE;
                            }
                        }
                    } else {
                        return;
                    }
                } while (!compareAndSet(j12, j13));
                if (i11 == 0) {
                    this.parent.requestMore(Long.MAX_VALUE);
                }
                emit();
            }
        }

        public void unsubscribe() {
            if (get() >= 0) {
                getAndSet(Long.MIN_VALUE);
            }
        }
    }

    public static final class LatestSubscriber<T> extends Subscriber<T> {
        private final LatestEmitter<T> producer;

        public LatestSubscriber(LatestEmitter<T> latestEmitter) {
            this.producer = latestEmitter;
        }

        public void onCompleted() {
            this.producer.onCompleted();
        }

        public void onError(Throwable th2) {
            this.producer.onError(th2);
        }

        public void onNext(T t11) {
            this.producer.onNext(t11);
        }

        public void onStart() {
            request(0);
        }

        public void requestMore(long j11) {
            request(j11);
        }
    }

    public static <T> OperatorOnBackpressureLatest<T> instance() {
        return Holder.INSTANCE;
    }

    public Subscriber<? super T> call(Subscriber<? super T> subscriber) {
        LatestEmitter latestEmitter = new LatestEmitter(subscriber);
        LatestSubscriber<? super T> latestSubscriber = new LatestSubscriber<>(latestEmitter);
        latestEmitter.parent = latestSubscriber;
        subscriber.add(latestSubscriber);
        subscriber.add(latestEmitter);
        subscriber.setProducer(latestEmitter);
        return latestSubscriber;
    }
}
