package rx.internal.operators;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.Emitter;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.MissingBackpressureException;
import rx.functions.Action1;
import rx.functions.Cancellable;
import rx.internal.subscriptions.CancellableSubscription;
import rx.internal.util.RxRingBuffer;
import rx.internal.util.atomic.SpscUnboundedAtomicArrayQueue;
import rx.internal.util.unsafe.SpscUnboundedArrayQueue;
import rx.internal.util.unsafe.UnsafeAccess;
import rx.plugins.RxJavaHooks;
import rx.subscriptions.SerialSubscription;

public final class OnSubscribeCreate<T> implements Observable.OnSubscribe<T> {
    public final Action1<Emitter<T>> Emitter;
    public final Emitter.BackpressureMode backpressure;

    /* renamed from: rx.internal.operators.OnSubscribeCreate$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$rx$Emitter$BackpressureMode;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                rx.Emitter$BackpressureMode[] r0 = rx.Emitter.BackpressureMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$rx$Emitter$BackpressureMode = r0
                rx.Emitter$BackpressureMode r1 = rx.Emitter.BackpressureMode.NONE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$rx$Emitter$BackpressureMode     // Catch:{ NoSuchFieldError -> 0x001d }
                rx.Emitter$BackpressureMode r1 = rx.Emitter.BackpressureMode.ERROR     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$rx$Emitter$BackpressureMode     // Catch:{ NoSuchFieldError -> 0x0028 }
                rx.Emitter$BackpressureMode r1 = rx.Emitter.BackpressureMode.DROP     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$rx$Emitter$BackpressureMode     // Catch:{ NoSuchFieldError -> 0x0033 }
                rx.Emitter$BackpressureMode r1 = rx.Emitter.BackpressureMode.LATEST     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.OnSubscribeCreate.AnonymousClass1.<clinit>():void");
        }
    }

    public static abstract class BaseEmitter<T> extends AtomicLong implements Emitter<T>, Producer, Subscription {
        private static final long serialVersionUID = 7326289992464377023L;
        public final Subscriber<? super T> actual;
        public final SerialSubscription serial = new SerialSubscription();

        public BaseEmitter(Subscriber<? super T> subscriber) {
            this.actual = subscriber;
        }

        public final boolean isUnsubscribed() {
            return this.serial.isUnsubscribed();
        }

        public void onCompleted() {
            if (!this.actual.isUnsubscribed()) {
                try {
                    this.actual.onCompleted();
                } finally {
                    this.serial.unsubscribe();
                }
            }
        }

        public void onError(Throwable th2) {
            if (!this.actual.isUnsubscribed()) {
                try {
                    this.actual.onError(th2);
                } finally {
                    this.serial.unsubscribe();
                }
            }
        }

        public void onRequested() {
        }

        public void onUnsubscribed() {
        }

        public final void request(long j11) {
            if (BackpressureUtils.validate(j11)) {
                BackpressureUtils.getAndAddRequest(this, j11);
                onRequested();
            }
        }

        public final long requested() {
            return get();
        }

        public final void setCancellation(Cancellable cancellable) {
            setSubscription(new CancellableSubscription(cancellable));
        }

        public final void setSubscription(Subscription subscription) {
            this.serial.set(subscription);
        }

        public final void unsubscribe() {
            this.serial.unsubscribe();
            onUnsubscribed();
        }
    }

    public static final class BufferEmitter<T> extends BaseEmitter<T> {
        private static final long serialVersionUID = 2427151001689639875L;
        public volatile boolean done;
        public Throwable error;
        public final Queue<Object> queue;
        public final AtomicInteger wip;

        public BufferEmitter(Subscriber<? super T> subscriber, int i11) {
            super(subscriber);
            this.queue = UnsafeAccess.isUnsafeAvailable() ? new SpscUnboundedArrayQueue<>(i11) : new SpscUnboundedAtomicArrayQueue<>(i11);
            this.wip = new AtomicInteger();
        }

        public void drain() {
            int i11;
            if (this.wip.getAndIncrement() == 0) {
                Subscriber<? super T> subscriber = this.actual;
                Queue<Object> queue2 = this.queue;
                int i12 = 1;
                do {
                    long j11 = get();
                    long j12 = 0;
                    while (true) {
                        i11 = (j12 > j11 ? 1 : (j12 == j11 ? 0 : -1));
                        if (i11 == 0) {
                            break;
                        } else if (subscriber.isUnsubscribed()) {
                            queue2.clear();
                            return;
                        } else {
                            boolean z11 = this.done;
                            Object poll = queue2.poll();
                            boolean z12 = poll == null;
                            if (z11 && z12) {
                                Throwable th2 = this.error;
                                if (th2 != null) {
                                    super.onError(th2);
                                    return;
                                } else {
                                    super.onCompleted();
                                    return;
                                }
                            } else if (z12) {
                                break;
                            } else {
                                subscriber.onNext(NotificationLite.getValue(poll));
                                j12++;
                            }
                        }
                    }
                    if (i11 == 0) {
                        if (subscriber.isUnsubscribed()) {
                            queue2.clear();
                            return;
                        }
                        boolean z13 = this.done;
                        boolean isEmpty = queue2.isEmpty();
                        if (z13 && isEmpty) {
                            Throwable th3 = this.error;
                            if (th3 != null) {
                                super.onError(th3);
                                return;
                            } else {
                                super.onCompleted();
                                return;
                            }
                        }
                    }
                    if (j12 != 0) {
                        BackpressureUtils.produced(this, j12);
                    }
                    i12 = this.wip.addAndGet(-i12);
                } while (i12 != 0);
            }
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

        public void onNext(T t11) {
            this.queue.offer(NotificationLite.next(t11));
            drain();
        }

        public void onRequested() {
            drain();
        }

        public void onUnsubscribed() {
            if (this.wip.getAndIncrement() == 0) {
                this.queue.clear();
            }
        }
    }

    public static final class DropEmitter<T> extends NoOverflowBaseEmitter<T> {
        private static final long serialVersionUID = 8360058422307496563L;

        public DropEmitter(Subscriber<? super T> subscriber) {
            super(subscriber);
        }

        public void onOverflow() {
        }
    }

    public static final class ErrorEmitter<T> extends NoOverflowBaseEmitter<T> {
        private static final long serialVersionUID = 338953216916120960L;
        private boolean done;

        public ErrorEmitter(Subscriber<? super T> subscriber) {
            super(subscriber);
        }

        public void onCompleted() {
            if (!this.done) {
                this.done = true;
                super.onCompleted();
            }
        }

        public void onError(Throwable th2) {
            if (this.done) {
                RxJavaHooks.onError(th2);
                return;
            }
            this.done = true;
            super.onError(th2);
        }

        public void onNext(T t11) {
            if (!this.done) {
                super.onNext(t11);
            }
        }

        public void onOverflow() {
            onError(new MissingBackpressureException("create: could not emit value due to lack of requests"));
        }
    }

    public static final class LatestEmitter<T> extends BaseEmitter<T> {
        private static final long serialVersionUID = 4023437720691792495L;
        public volatile boolean done;
        public Throwable error;
        public final AtomicReference<Object> queue = new AtomicReference<>();
        public final AtomicInteger wip = new AtomicInteger();

        public LatestEmitter(Subscriber<? super T> subscriber) {
            super(subscriber);
        }

        public void drain() {
            int i11;
            boolean z11;
            if (this.wip.getAndIncrement() == 0) {
                Subscriber<? super T> subscriber = this.actual;
                AtomicReference<Object> atomicReference = this.queue;
                int i12 = 1;
                do {
                    long j11 = get();
                    long j12 = 0;
                    while (true) {
                        i11 = (j12 > j11 ? 1 : (j12 == j11 ? 0 : -1));
                        z11 = false;
                        if (i11 == 0) {
                            break;
                        } else if (subscriber.isUnsubscribed()) {
                            atomicReference.lazySet((Object) null);
                            return;
                        } else {
                            boolean z12 = this.done;
                            Object andSet = atomicReference.getAndSet((Object) null);
                            boolean z13 = andSet == null;
                            if (z12 && z13) {
                                Throwable th2 = this.error;
                                if (th2 != null) {
                                    super.onError(th2);
                                    return;
                                } else {
                                    super.onCompleted();
                                    return;
                                }
                            } else if (z13) {
                                break;
                            } else {
                                subscriber.onNext(NotificationLite.getValue(andSet));
                                j12++;
                            }
                        }
                    }
                    if (i11 == 0) {
                        if (subscriber.isUnsubscribed()) {
                            atomicReference.lazySet((Object) null);
                            return;
                        }
                        boolean z14 = this.done;
                        if (atomicReference.get() == null) {
                            z11 = true;
                        }
                        if (z14 && z11) {
                            Throwable th3 = this.error;
                            if (th3 != null) {
                                super.onError(th3);
                                return;
                            } else {
                                super.onCompleted();
                                return;
                            }
                        }
                    }
                    if (j12 != 0) {
                        BackpressureUtils.produced(this, j12);
                    }
                    i12 = this.wip.addAndGet(-i12);
                } while (i12 != 0);
            }
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

        public void onNext(T t11) {
            this.queue.set(NotificationLite.next(t11));
            drain();
        }

        public void onRequested() {
            drain();
        }

        public void onUnsubscribed() {
            if (this.wip.getAndIncrement() == 0) {
                this.queue.lazySet((Object) null);
            }
        }
    }

    public static abstract class NoOverflowBaseEmitter<T> extends BaseEmitter<T> {
        private static final long serialVersionUID = 4127754106204442833L;

        public NoOverflowBaseEmitter(Subscriber<? super T> subscriber) {
            super(subscriber);
        }

        public void onNext(T t11) {
            if (!this.actual.isUnsubscribed()) {
                if (get() != 0) {
                    this.actual.onNext(t11);
                    BackpressureUtils.produced(this, 1);
                    return;
                }
                onOverflow();
            }
        }

        public abstract void onOverflow();
    }

    public static final class NoneEmitter<T> extends BaseEmitter<T> {
        private static final long serialVersionUID = 3776720187248809713L;

        public NoneEmitter(Subscriber<? super T> subscriber) {
            super(subscriber);
        }

        public void onNext(T t11) {
            long j11;
            if (!this.actual.isUnsubscribed()) {
                this.actual.onNext(t11);
                do {
                    j11 = get();
                    if (j11 == 0 || compareAndSet(j11, j11 - 1)) {
                    }
                    j11 = get();
                    return;
                } while (compareAndSet(j11, j11 - 1));
            }
        }
    }

    public OnSubscribeCreate(Action1<Emitter<T>> action1, Emitter.BackpressureMode backpressureMode) {
        this.Emitter = action1;
        this.backpressure = backpressureMode;
    }

    public void call(Subscriber<? super T> subscriber) {
        BaseEmitter baseEmitter;
        int i11 = AnonymousClass1.$SwitchMap$rx$Emitter$BackpressureMode[this.backpressure.ordinal()];
        if (i11 == 1) {
            baseEmitter = new NoneEmitter(subscriber);
        } else if (i11 == 2) {
            baseEmitter = new ErrorEmitter(subscriber);
        } else if (i11 == 3) {
            baseEmitter = new DropEmitter(subscriber);
        } else if (i11 != 4) {
            baseEmitter = new BufferEmitter(subscriber, RxRingBuffer.SIZE);
        } else {
            baseEmitter = new LatestEmitter(subscriber);
        }
        subscriber.add(baseEmitter);
        subscriber.setProducer(baseEmitter);
        this.Emitter.call(baseEmitter);
    }
}
