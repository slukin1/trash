package rx.internal.operators;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicLong;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.CompositeException;
import rx.functions.Action0;
import rx.internal.util.RxRingBuffer;
import rx.internal.util.atomic.SpscLinkedArrayQueue;
import rx.plugins.RxJavaHooks;
import rx.subscriptions.SerialSubscription;
import rx.subscriptions.Subscriptions;

public final class OperatorSwitch<T> implements Observable.Operator<T, Observable<? extends T>> {
    public final boolean delayError;

    public static final class Holder {
        public static final OperatorSwitch<Object> INSTANCE = new OperatorSwitch<>(false);
    }

    public static final class HolderDelayError {
        public static final OperatorSwitch<Object> INSTANCE = new OperatorSwitch<>(true);
    }

    public static final class InnerSubscriber<T> extends Subscriber<T> {
        /* access modifiers changed from: private */

        /* renamed from: id  reason: collision with root package name */
        public final long f53415id;
        private final SwitchSubscriber<T> parent;

        public InnerSubscriber(long j11, SwitchSubscriber<T> switchSubscriber) {
            this.f53415id = j11;
            this.parent = switchSubscriber;
        }

        public void onCompleted() {
            this.parent.complete(this.f53415id);
        }

        public void onError(Throwable th2) {
            this.parent.error(th2, this.f53415id);
        }

        public void onNext(T t11) {
            this.parent.emit(t11, this);
        }

        public void setProducer(Producer producer) {
            this.parent.innerProducer(producer, this.f53415id);
        }
    }

    public static final class SwitchSubscriber<T> extends Subscriber<Observable<? extends T>> {
        public static final Throwable TERMINAL_ERROR = new Throwable("Terminal error");
        public final Subscriber<? super T> child;
        public final boolean delayError;
        public boolean emitting;
        public Throwable error;
        public final AtomicLong index;
        public boolean innerActive;
        public volatile boolean mainDone;
        public boolean missed;
        public Producer producer;
        public final SpscLinkedArrayQueue<Object> queue;
        public long requested;
        public final SerialSubscription serial = new SerialSubscription();

        public SwitchSubscriber(Subscriber<? super T> subscriber, boolean z11) {
            this.child = subscriber;
            this.delayError = z11;
            this.index = new AtomicLong();
            this.queue = new SpscLinkedArrayQueue<>(RxRingBuffer.SIZE);
        }

        public boolean checkTerminated(boolean z11, boolean z12, Throwable th2, SpscLinkedArrayQueue<Object> spscLinkedArrayQueue, Subscriber<? super T> subscriber, boolean z13) {
            if (this.delayError) {
                if (!z11 || z12 || !z13) {
                    return false;
                }
                if (th2 != null) {
                    subscriber.onError(th2);
                } else {
                    subscriber.onCompleted();
                }
                return true;
            } else if (th2 != null) {
                spscLinkedArrayQueue.clear();
                subscriber.onError(th2);
                return true;
            } else if (!z11 || z12 || !z13) {
                return false;
            } else {
                subscriber.onCompleted();
                return true;
            }
        }

        public void childRequested(long j11) {
            Producer producer2;
            synchronized (this) {
                producer2 = this.producer;
                this.requested = BackpressureUtils.addCap(this.requested, j11);
            }
            if (producer2 != null) {
                producer2.request(j11);
            }
            drain();
        }

        public void clearProducer() {
            synchronized (this) {
                this.producer = null;
            }
        }

        public void complete(long j11) {
            synchronized (this) {
                if (this.index.get() == j11) {
                    this.innerActive = false;
                    this.producer = null;
                    drain();
                }
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0021, code lost:
            r9 = r8.queue;
            r10 = r8.index;
            r11 = r8.child;
            r12 = r1;
            r14 = r3;
            r15 = r8.mainDone;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x002c, code lost:
            r16 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0030, code lost:
            r18 = (r16 > r12 ? 1 : (r16 == r12 ? 0 : -1));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0032, code lost:
            if (r18 == 0) goto L_0x0074;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0038, code lost:
            if (r11.isUnsubscribed() == false) goto L_0x003b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x003a, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x003b, code lost:
            r19 = r9.isEmpty();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x004c, code lost:
            if (checkTerminated(r15, r0, r14, r9, r11, r19) == false) goto L_0x004f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x004e, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x004f, code lost:
            if (r19 == false) goto L_0x0052;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0052, code lost:
            r2 = rx.internal.operators.NotificationLite.getValue(r9.poll());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x006a, code lost:
            if (r10.get() != rx.internal.operators.OperatorSwitch.InnerSubscriber.access$000((rx.internal.operators.OperatorSwitch.InnerSubscriber) r9.poll())) goto L_0x0030;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x006c, code lost:
            r11.onNext(r2);
            r16 = r16 + 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x0074, code lost:
            if (r18 != 0) goto L_0x0090;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x007a, code lost:
            if (r11.isUnsubscribed() == false) goto L_0x007d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x007c, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x008d, code lost:
            if (checkTerminated(r8.mainDone, r0, r14, r9, r11, r9.isEmpty()) == false) goto L_0x0090;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x008f, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x0090, code lost:
            monitor-enter(r20);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
            r0 = r8.requested;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:0x009a, code lost:
            if (r0 == Long.MAX_VALUE) goto L_0x00a0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:0x009c, code lost:
            r0 = r0 - r16;
            r8.requested = r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:42:0x00a0, code lost:
            r12 = r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:0x00a4, code lost:
            if (r8.missed != false) goto L_0x00aa;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:0x00a6, code lost:
            r8.emitting = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:45:0x00a8, code lost:
            monitor-exit(r20);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:0x00a9, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:47:0x00aa, code lost:
            r8.missed = false;
            r15 = r8.mainDone;
            r0 = r8.innerActive;
            r14 = r8.error;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:48:0x00b2, code lost:
            if (r14 == null) goto L_0x00be;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:0x00b4, code lost:
            r1 = TERMINAL_ERROR;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:50:0x00b6, code lost:
            if (r14 == r1) goto L_0x00be;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:52:0x00ba, code lost:
            if (r8.delayError != false) goto L_0x00be;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:53:0x00bc, code lost:
            r8.error = r1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:54:0x00be, code lost:
            monitor-exit(r20);
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void drain() {
            /*
                r20 = this;
                r8 = r20
                monitor-enter(r20)
                boolean r0 = r8.emitting     // Catch:{ all -> 0x00c4 }
                r1 = 1
                if (r0 == 0) goto L_0x000c
                r8.missed = r1     // Catch:{ all -> 0x00c4 }
                monitor-exit(r20)     // Catch:{ all -> 0x00c4 }
                return
            L_0x000c:
                r8.emitting = r1     // Catch:{ all -> 0x00c4 }
                boolean r0 = r8.innerActive     // Catch:{ all -> 0x00c4 }
                long r1 = r8.requested     // Catch:{ all -> 0x00c4 }
                java.lang.Throwable r3 = r8.error     // Catch:{ all -> 0x00c4 }
                if (r3 == 0) goto L_0x0020
                java.lang.Throwable r4 = TERMINAL_ERROR     // Catch:{ all -> 0x00c4 }
                if (r3 == r4) goto L_0x0020
                boolean r5 = r8.delayError     // Catch:{ all -> 0x00c4 }
                if (r5 != 0) goto L_0x0020
                r8.error = r4     // Catch:{ all -> 0x00c4 }
            L_0x0020:
                monitor-exit(r20)     // Catch:{ all -> 0x00c4 }
                rx.internal.util.atomic.SpscLinkedArrayQueue<java.lang.Object> r9 = r8.queue
                java.util.concurrent.atomic.AtomicLong r10 = r8.index
                rx.Subscriber<? super T> r11 = r8.child
                boolean r4 = r8.mainDone
                r12 = r1
                r14 = r3
                r15 = r4
            L_0x002c:
                r1 = 0
                r16 = r1
            L_0x0030:
                int r18 = (r16 > r12 ? 1 : (r16 == r12 ? 0 : -1))
                if (r18 == 0) goto L_0x0074
                boolean r1 = r11.isUnsubscribed()
                if (r1 == 0) goto L_0x003b
                return
            L_0x003b:
                boolean r19 = r9.isEmpty()
                r1 = r20
                r2 = r15
                r3 = r0
                r4 = r14
                r5 = r9
                r6 = r11
                r7 = r19
                boolean r1 = r1.checkTerminated(r2, r3, r4, r5, r6, r7)
                if (r1 == 0) goto L_0x004f
                return
            L_0x004f:
                if (r19 == 0) goto L_0x0052
                goto L_0x0074
            L_0x0052:
                java.lang.Object r1 = r9.poll()
                rx.internal.operators.OperatorSwitch$InnerSubscriber r1 = (rx.internal.operators.OperatorSwitch.InnerSubscriber) r1
                java.lang.Object r2 = r9.poll()
                java.lang.Object r2 = rx.internal.operators.NotificationLite.getValue(r2)
                long r3 = r10.get()
                long r5 = r1.f53415id
                int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r1 != 0) goto L_0x0030
                r11.onNext(r2)
                r1 = 1
                long r16 = r16 + r1
                goto L_0x0030
            L_0x0074:
                if (r18 != 0) goto L_0x0090
                boolean r1 = r11.isUnsubscribed()
                if (r1 == 0) goto L_0x007d
                return
            L_0x007d:
                boolean r2 = r8.mainDone
                boolean r7 = r9.isEmpty()
                r1 = r20
                r3 = r0
                r4 = r14
                r5 = r9
                r6 = r11
                boolean r0 = r1.checkTerminated(r2, r3, r4, r5, r6, r7)
                if (r0 == 0) goto L_0x0090
                return
            L_0x0090:
                monitor-enter(r20)
                long r0 = r8.requested     // Catch:{ all -> 0x00c1 }
                r2 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                if (r2 == 0) goto L_0x00a0
                long r0 = r0 - r16
                r8.requested = r0     // Catch:{ all -> 0x00c1 }
            L_0x00a0:
                r12 = r0
                boolean r0 = r8.missed     // Catch:{ all -> 0x00c1 }
                r1 = 0
                if (r0 != 0) goto L_0x00aa
                r8.emitting = r1     // Catch:{ all -> 0x00c1 }
                monitor-exit(r20)     // Catch:{ all -> 0x00c1 }
                return
            L_0x00aa:
                r8.missed = r1     // Catch:{ all -> 0x00c1 }
                boolean r15 = r8.mainDone     // Catch:{ all -> 0x00c1 }
                boolean r0 = r8.innerActive     // Catch:{ all -> 0x00c1 }
                java.lang.Throwable r14 = r8.error     // Catch:{ all -> 0x00c1 }
                if (r14 == 0) goto L_0x00be
                java.lang.Throwable r1 = TERMINAL_ERROR     // Catch:{ all -> 0x00c1 }
                if (r14 == r1) goto L_0x00be
                boolean r2 = r8.delayError     // Catch:{ all -> 0x00c1 }
                if (r2 != 0) goto L_0x00be
                r8.error = r1     // Catch:{ all -> 0x00c1 }
            L_0x00be:
                monitor-exit(r20)     // Catch:{ all -> 0x00c1 }
                goto L_0x002c
            L_0x00c1:
                r0 = move-exception
                monitor-exit(r20)     // Catch:{ all -> 0x00c1 }
                throw r0
            L_0x00c4:
                r0 = move-exception
                monitor-exit(r20)     // Catch:{ all -> 0x00c4 }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.OperatorSwitch.SwitchSubscriber.drain():void");
        }

        public void emit(T t11, InnerSubscriber<T> innerSubscriber) {
            synchronized (this) {
                if (this.index.get() == innerSubscriber.f53415id) {
                    this.queue.offer(innerSubscriber, NotificationLite.next(t11));
                    drain();
                }
            }
        }

        public void error(Throwable th2, long j11) {
            boolean z11;
            synchronized (this) {
                if (this.index.get() == j11) {
                    z11 = updateError(th2);
                    this.innerActive = false;
                    this.producer = null;
                } else {
                    z11 = true;
                }
            }
            if (z11) {
                drain();
            } else {
                pluginError(th2);
            }
        }

        public void init() {
            this.child.add(this.serial);
            this.child.add(Subscriptions.create(new Action0() {
                public void call() {
                    SwitchSubscriber.this.clearProducer();
                }
            }));
            this.child.setProducer(new Producer() {
                public void request(long j11) {
                    int i11 = (j11 > 0 ? 1 : (j11 == 0 ? 0 : -1));
                    if (i11 > 0) {
                        SwitchSubscriber.this.childRequested(j11);
                    } else if (i11 < 0) {
                        throw new IllegalArgumentException("n >= 0 expected but it was " + j11);
                    }
                }
            });
        }

        public void innerProducer(Producer producer2, long j11) {
            synchronized (this) {
                if (this.index.get() == j11) {
                    long j12 = this.requested;
                    this.producer = producer2;
                    producer2.request(j12);
                }
            }
        }

        public void onCompleted() {
            this.mainDone = true;
            drain();
        }

        public void onError(Throwable th2) {
            boolean updateError;
            synchronized (this) {
                updateError = updateError(th2);
            }
            if (updateError) {
                this.mainDone = true;
                drain();
                return;
            }
            pluginError(th2);
        }

        public void pluginError(Throwable th2) {
            RxJavaHooks.onError(th2);
        }

        public boolean updateError(Throwable th2) {
            Throwable th3 = this.error;
            if (th3 == TERMINAL_ERROR) {
                return false;
            }
            if (th3 == null) {
                this.error = th2;
            } else if (th3 instanceof CompositeException) {
                ArrayList arrayList = new ArrayList(((CompositeException) th3).getExceptions());
                arrayList.add(th2);
                this.error = new CompositeException((Collection<? extends Throwable>) arrayList);
            } else {
                this.error = new CompositeException(th3, th2);
            }
            return true;
        }

        public void onNext(Observable<? extends T> observable) {
            InnerSubscriber innerSubscriber;
            long incrementAndGet = this.index.incrementAndGet();
            Subscription subscription = this.serial.get();
            if (subscription != null) {
                subscription.unsubscribe();
            }
            synchronized (this) {
                innerSubscriber = new InnerSubscriber(incrementAndGet, this);
                this.innerActive = true;
                this.producer = null;
            }
            this.serial.set(innerSubscriber);
            observable.unsafeSubscribe(innerSubscriber);
        }
    }

    public OperatorSwitch(boolean z11) {
        this.delayError = z11;
    }

    public static <T> OperatorSwitch<T> instance(boolean z11) {
        if (z11) {
            return HolderDelayError.INSTANCE;
        }
        return Holder.INSTANCE;
    }

    public Subscriber<? super Observable<? extends T>> call(Subscriber<? super T> subscriber) {
        SwitchSubscriber switchSubscriber = new SwitchSubscriber(subscriber, this.delayError);
        subscriber.add(switchSubscriber);
        switchSubscriber.init();
        return switchSubscriber;
    }
}
