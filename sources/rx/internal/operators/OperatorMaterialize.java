package rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;
import rx.Notification;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.plugins.RxJavaHooks;

public final class OperatorMaterialize<T> implements Observable.Operator<Notification<T>, T> {

    public static final class Holder {
        public static final OperatorMaterialize<Object> INSTANCE = new OperatorMaterialize<>();
    }

    public static class ParentSubscriber<T> extends Subscriber<T> {
        private boolean busy;
        private final Subscriber<? super Notification<T>> child;
        private boolean missed;
        private final AtomicLong requested = new AtomicLong();
        private volatile Notification<T> terminalNotification;

        public ParentSubscriber(Subscriber<? super Notification<T>> subscriber) {
            this.child = subscriber;
        }

        private void decrementRequested() {
            long j11;
            AtomicLong atomicLong = this.requested;
            do {
                j11 = atomicLong.get();
                if (j11 == Long.MAX_VALUE || atomicLong.compareAndSet(j11, j11 - 1)) {
                }
                j11 = atomicLong.get();
                return;
            } while (atomicLong.compareAndSet(j11, j11 - 1));
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0013, code lost:
            if (r6.child.isUnsubscribed() != false) goto L_0x0048;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0015, code lost:
            r1 = r6.terminalNotification;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0017, code lost:
            if (r1 == null) goto L_0x0039;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0021, code lost:
            if (r0.get() <= 0) goto L_0x0039;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0023, code lost:
            r6.terminalNotification = null;
            r6.child.onNext(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0031, code lost:
            if (r6.child.isUnsubscribed() != false) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0033, code lost:
            r6.child.onCompleted();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0039, code lost:
            monitor-enter(r6);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x003c, code lost:
            if (r6.missed != false) goto L_0x0043;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x003e, code lost:
            r6.busy = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0041, code lost:
            monitor-exit(r6);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0042, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0043, code lost:
            monitor-exit(r6);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x0048, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:42:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x000b, code lost:
            r0 = r6.requested;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void drain() {
            /*
                r6 = this;
                monitor-enter(r6)
                boolean r0 = r6.busy     // Catch:{ all -> 0x0049 }
                if (r0 == 0) goto L_0x000a
                r0 = 1
                r6.missed = r0     // Catch:{ all -> 0x0049 }
                monitor-exit(r6)     // Catch:{ all -> 0x0049 }
                return
            L_0x000a:
                monitor-exit(r6)     // Catch:{ all -> 0x0049 }
                java.util.concurrent.atomic.AtomicLong r0 = r6.requested
            L_0x000d:
                rx.Subscriber<? super rx.Notification<T>> r1 = r6.child
                boolean r1 = r1.isUnsubscribed()
                if (r1 != 0) goto L_0x0048
                rx.Notification<T> r1 = r6.terminalNotification
                if (r1 == 0) goto L_0x0039
                long r2 = r0.get()
                r4 = 0
                int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r2 <= 0) goto L_0x0039
                r0 = 0
                r6.terminalNotification = r0
                rx.Subscriber<? super rx.Notification<T>> r0 = r6.child
                r0.onNext(r1)
                rx.Subscriber<? super rx.Notification<T>> r0 = r6.child
                boolean r0 = r0.isUnsubscribed()
                if (r0 != 0) goto L_0x0038
                rx.Subscriber<? super rx.Notification<T>> r0 = r6.child
                r0.onCompleted()
            L_0x0038:
                return
            L_0x0039:
                monitor-enter(r6)
                boolean r1 = r6.missed     // Catch:{ all -> 0x0045 }
                if (r1 != 0) goto L_0x0043
                r0 = 0
                r6.busy = r0     // Catch:{ all -> 0x0045 }
                monitor-exit(r6)     // Catch:{ all -> 0x0045 }
                return
            L_0x0043:
                monitor-exit(r6)     // Catch:{ all -> 0x0045 }
                goto L_0x000d
            L_0x0045:
                r0 = move-exception
                monitor-exit(r6)     // Catch:{ all -> 0x0045 }
                throw r0
            L_0x0048:
                return
            L_0x0049:
                r0 = move-exception
                monitor-exit(r6)     // Catch:{ all -> 0x0049 }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.OperatorMaterialize.ParentSubscriber.drain():void");
        }

        public void onCompleted() {
            this.terminalNotification = Notification.createOnCompleted();
            drain();
        }

        public void onError(Throwable th2) {
            this.terminalNotification = Notification.createOnError(th2);
            RxJavaHooks.onError(th2);
            drain();
        }

        public void onNext(T t11) {
            this.child.onNext(Notification.createOnNext(t11));
            decrementRequested();
        }

        public void onStart() {
            request(0);
        }

        public void requestMore(long j11) {
            BackpressureUtils.getAndAddRequest(this.requested, j11);
            request(j11);
            drain();
        }
    }

    public static <T> OperatorMaterialize<T> instance() {
        return Holder.INSTANCE;
    }

    public Subscriber<? super T> call(Subscriber<? super Notification<T>> subscriber) {
        final ParentSubscriber parentSubscriber = new ParentSubscriber(subscriber);
        subscriber.add(parentSubscriber);
        subscriber.setProducer(new Producer() {
            public void request(long j11) {
                if (j11 > 0) {
                    parentSubscriber.requestMore(j11);
                }
            }
        });
        return parentSubscriber;
    }
}
