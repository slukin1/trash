package rx.internal.operators;

import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import rx.Observable;
import rx.Observer;
import rx.Producer;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Func0;
import rx.functions.Func2;
import rx.internal.util.atomic.SpscLinkedAtomicQueue;
import rx.internal.util.unsafe.SpscLinkedQueue;
import rx.internal.util.unsafe.UnsafeAccess;

public final class OperatorScan<R, T> implements Observable.Operator<R, T> {
    private static final Object NO_INITIAL_VALUE = new Object();
    public final Func2<R, ? super T, R> accumulator;
    private final Func0<R> initialValueFactory;

    public static final class InitialProducer<R> implements Producer, Observer<R> {
        public final Subscriber<? super R> child;
        public volatile boolean done;
        public boolean emitting;
        public Throwable error;
        public boolean missed;
        public long missedRequested;
        public volatile Producer producer;
        public final Queue<Object> queue;
        public final AtomicLong requested;

        public InitialProducer(R r11, Subscriber<? super R> subscriber) {
            Queue<Object> queue2;
            this.child = subscriber;
            if (UnsafeAccess.isUnsafeAvailable()) {
                queue2 = new SpscLinkedQueue<>();
            } else {
                queue2 = new SpscLinkedAtomicQueue<>();
            }
            this.queue = queue2;
            queue2.offer(NotificationLite.next(r11));
            this.requested = new AtomicLong();
        }

        public boolean checkTerminated(boolean z11, boolean z12, Subscriber<? super R> subscriber) {
            if (subscriber.isUnsubscribed()) {
                return true;
            }
            if (!z11) {
                return false;
            }
            Throwable th2 = this.error;
            if (th2 != null) {
                subscriber.onError(th2);
                return true;
            } else if (!z12) {
                return false;
            } else {
                subscriber.onCompleted();
                return true;
            }
        }

        public void emit() {
            synchronized (this) {
                if (this.emitting) {
                    this.missed = true;
                    return;
                }
                this.emitting = true;
                emitLoop();
            }
        }

        public void emitLoop() {
            Subscriber<? super R> subscriber = this.child;
            Queue<Object> queue2 = this.queue;
            AtomicLong atomicLong = this.requested;
            long j11 = atomicLong.get();
            while (!checkTerminated(this.done, queue2.isEmpty(), subscriber)) {
                long j12 = 0;
                while (j12 != j11) {
                    boolean z11 = this.done;
                    Object poll = queue2.poll();
                    boolean z12 = poll == null;
                    if (!checkTerminated(z11, z12, subscriber)) {
                        if (z12) {
                            break;
                        }
                        Object value = NotificationLite.getValue(poll);
                        try {
                            subscriber.onNext(value);
                            j12++;
                        } catch (Throwable th2) {
                            Exceptions.throwOrReport(th2, (Observer<?>) subscriber, value);
                            return;
                        }
                    } else {
                        return;
                    }
                }
                if (!(j12 == 0 || j11 == Long.MAX_VALUE)) {
                    j11 = BackpressureUtils.produced(atomicLong, j12);
                }
                synchronized (this) {
                    if (!this.missed) {
                        this.emitting = false;
                        return;
                    }
                    this.missed = false;
                }
            }
        }

        public void onCompleted() {
            this.done = true;
            emit();
        }

        public void onError(Throwable th2) {
            this.error = th2;
            this.done = true;
            emit();
        }

        public void onNext(R r11) {
            this.queue.offer(NotificationLite.next(r11));
            emit();
        }

        public void request(long j11) {
            int i11 = (j11 > 0 ? 1 : (j11 == 0 ? 0 : -1));
            if (i11 < 0) {
                throw new IllegalArgumentException("n >= required but it was " + j11);
            } else if (i11 != 0) {
                BackpressureUtils.getAndAddRequest(this.requested, j11);
                Producer producer2 = this.producer;
                if (producer2 == null) {
                    synchronized (this.requested) {
                        producer2 = this.producer;
                        if (producer2 == null) {
                            this.missedRequested = BackpressureUtils.addCap(this.missedRequested, j11);
                        }
                    }
                }
                if (producer2 != null) {
                    producer2.request(j11);
                }
                emit();
            }
        }

        public void setProducer(Producer producer2) {
            long j11;
            Objects.requireNonNull(producer2);
            synchronized (this.requested) {
                if (this.producer == null) {
                    j11 = this.missedRequested;
                    if (j11 != Long.MAX_VALUE) {
                        j11--;
                    }
                    this.missedRequested = 0;
                    this.producer = producer2;
                } else {
                    throw new IllegalStateException("Can't set more than one Producer!");
                }
            }
            if (j11 > 0) {
                producer2.request(j11);
            }
            emit();
        }
    }

    public OperatorScan(final R r11, Func2<R, ? super T, R> func2) {
        this(new Func0<R>() {
            public R call() {
                return r11;
            }
        }, func2);
    }

    public OperatorScan(Func0<R> func0, Func2<R, ? super T, R> func2) {
        this.initialValueFactory = func0;
        this.accumulator = func2;
    }

    public Subscriber<? super T> call(final Subscriber<? super R> subscriber) {
        R call = this.initialValueFactory.call();
        if (call == NO_INITIAL_VALUE) {
            return new Subscriber<T>(subscriber) {
                public boolean once;
                public R value;

                public void onCompleted() {
                    subscriber.onCompleted();
                }

                public void onError(Throwable th2) {
                    subscriber.onError(th2);
                }

                public void onNext(T t11) {
                    Object obj;
                    if (!this.once) {
                        this.once = true;
                        obj = t11;
                    } else {
                        try {
                            obj = OperatorScan.this.accumulator.call(this.value, t11);
                        } catch (Throwable th2) {
                            Exceptions.throwOrReport(th2, (Observer<?>) subscriber, (Object) t11);
                            return;
                        }
                    }
                    this.value = obj;
                    subscriber.onNext(obj);
                }
            };
        }
        InitialProducer initialProducer = new InitialProducer(call, subscriber);
        AnonymousClass3 r22 = new Subscriber<T>(call, initialProducer) {
            public final /* synthetic */ Object val$initialValue;
            public final /* synthetic */ InitialProducer val$ip;
            private R value;

            {
                this.val$initialValue = r2;
                this.val$ip = r3;
                this.value = r2;
            }

            public void onCompleted() {
                this.val$ip.onCompleted();
            }

            public void onError(Throwable th2) {
                this.val$ip.onError(th2);
            }

            public void onNext(T t11) {
                try {
                    R call = OperatorScan.this.accumulator.call(this.value, t11);
                    this.value = call;
                    this.val$ip.onNext(call);
                } catch (Throwable th2) {
                    Exceptions.throwOrReport(th2, (Observer<?>) this, (Object) t11);
                }
            }

            public void setProducer(Producer producer) {
                this.val$ip.setProducer(producer);
            }
        };
        subscriber.add(r22);
        subscriber.setProducer(initialProducer);
        return r22;
    }

    public OperatorScan(Func2<R, ? super T, R> func2) {
        this(NO_INITIAL_VALUE, func2);
    }
}
