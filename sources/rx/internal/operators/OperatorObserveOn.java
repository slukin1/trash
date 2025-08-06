package rx.internal.operators;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import rx.Observable;
import rx.Producer;
import rx.Scheduler;
import rx.Subscriber;
import rx.exceptions.MissingBackpressureException;
import rx.functions.Action0;
import rx.internal.schedulers.ImmediateScheduler;
import rx.internal.schedulers.TrampolineScheduler;
import rx.internal.util.RxRingBuffer;
import rx.internal.util.atomic.SpscAtomicArrayQueue;
import rx.internal.util.unsafe.SpscArrayQueue;
import rx.internal.util.unsafe.UnsafeAccess;
import rx.plugins.RxJavaHooks;
import rx.schedulers.Schedulers;

public final class OperatorObserveOn<T> implements Observable.Operator<T, T> {
    private final int bufferSize;
    private final boolean delayError;
    private final Scheduler scheduler;

    public static final class ObserveOnSubscriber<T> extends Subscriber<T> implements Action0 {
        public final Subscriber<? super T> child;
        public final AtomicLong counter = new AtomicLong();
        public final boolean delayError;
        public long emitted;
        public Throwable error;
        public volatile boolean finished;
        public final int limit;
        public final Queue<Object> queue;
        public final Scheduler.Worker recursiveScheduler;
        public final AtomicLong requested = new AtomicLong();

        public ObserveOnSubscriber(Scheduler scheduler, Subscriber<? super T> subscriber, boolean z11, int i11) {
            this.child = subscriber;
            this.recursiveScheduler = scheduler.createWorker();
            this.delayError = z11;
            i11 = i11 <= 0 ? RxRingBuffer.SIZE : i11;
            this.limit = i11 - (i11 >> 2);
            if (UnsafeAccess.isUnsafeAvailable()) {
                this.queue = new SpscArrayQueue(i11);
            } else {
                this.queue = new SpscAtomicArrayQueue(i11);
            }
            request((long) i11);
        }

        public void call() {
            int i11;
            long j11 = this.emitted;
            Queue<Object> queue2 = this.queue;
            Subscriber<? super T> subscriber = this.child;
            long j12 = 1;
            do {
                long j13 = this.requested.get();
                while (true) {
                    i11 = (j13 > j11 ? 1 : (j13 == j11 ? 0 : -1));
                    if (i11 == 0) {
                        break;
                    }
                    boolean z11 = this.finished;
                    Object poll = queue2.poll();
                    boolean z12 = poll == null;
                    if (!checkTerminated(z11, z12, subscriber, queue2)) {
                        if (z12) {
                            break;
                        }
                        subscriber.onNext(NotificationLite.getValue(poll));
                        j11++;
                        if (j11 == ((long) this.limit)) {
                            j13 = BackpressureUtils.produced(this.requested, j11);
                            request(j11);
                            j11 = 0;
                        }
                    } else {
                        return;
                    }
                }
                if (i11 != 0 || !checkTerminated(this.finished, queue2.isEmpty(), subscriber, queue2)) {
                    this.emitted = j11;
                    j12 = this.counter.addAndGet(-j12);
                } else {
                    return;
                }
            } while (j12 != 0);
        }

        public boolean checkTerminated(boolean z11, boolean z12, Subscriber<? super T> subscriber, Queue<Object> queue2) {
            if (subscriber.isUnsubscribed()) {
                queue2.clear();
                return true;
            } else if (!z11) {
                return false;
            } else {
                if (!this.delayError) {
                    Throwable th2 = this.error;
                    if (th2 != null) {
                        queue2.clear();
                        try {
                            subscriber.onError(th2);
                            return true;
                        } finally {
                            this.recursiveScheduler.unsubscribe();
                        }
                    } else if (!z12) {
                        return false;
                    } else {
                        try {
                            subscriber.onCompleted();
                            return true;
                        } finally {
                            this.recursiveScheduler.unsubscribe();
                        }
                    }
                } else if (!z12) {
                    return false;
                } else {
                    Throwable th3 = this.error;
                    if (th3 != null) {
                        try {
                            subscriber.onError(th3);
                        } catch (Throwable th4) {
                            this.recursiveScheduler.unsubscribe();
                            throw th4;
                        }
                    } else {
                        subscriber.onCompleted();
                    }
                    this.recursiveScheduler.unsubscribe();
                    return false;
                }
            }
        }

        public void init() {
            Subscriber<? super T> subscriber = this.child;
            subscriber.setProducer(new Producer() {
                public void request(long j11) {
                    if (j11 > 0) {
                        BackpressureUtils.getAndAddRequest(ObserveOnSubscriber.this.requested, j11);
                        ObserveOnSubscriber.this.schedule();
                    }
                }
            });
            subscriber.add(this.recursiveScheduler);
            subscriber.add(this);
        }

        public void onCompleted() {
            if (!isUnsubscribed() && !this.finished) {
                this.finished = true;
                schedule();
            }
        }

        public void onError(Throwable th2) {
            if (isUnsubscribed() || this.finished) {
                RxJavaHooks.onError(th2);
                return;
            }
            this.error = th2;
            this.finished = true;
            schedule();
        }

        public void onNext(T t11) {
            if (!isUnsubscribed() && !this.finished) {
                if (!this.queue.offer(NotificationLite.next(t11))) {
                    onError(new MissingBackpressureException());
                } else {
                    schedule();
                }
            }
        }

        public void schedule() {
            if (this.counter.getAndIncrement() == 0) {
                this.recursiveScheduler.schedule(this);
            }
        }
    }

    public OperatorObserveOn(Scheduler scheduler2, boolean z11) {
        this(scheduler2, z11, RxRingBuffer.SIZE);
    }

    public static <T> Observable.Operator<T, T> rebatch(final int i11) {
        return new Observable.Operator<T, T>() {
            public Subscriber<? super T> call(Subscriber<? super T> subscriber) {
                ObserveOnSubscriber observeOnSubscriber = new ObserveOnSubscriber(Schedulers.immediate(), subscriber, false, i11);
                observeOnSubscriber.init();
                return observeOnSubscriber;
            }
        };
    }

    public OperatorObserveOn(Scheduler scheduler2, boolean z11, int i11) {
        this.scheduler = scheduler2;
        this.delayError = z11;
        this.bufferSize = i11 <= 0 ? RxRingBuffer.SIZE : i11;
    }

    public Subscriber<? super T> call(Subscriber<? super T> subscriber) {
        Scheduler scheduler2 = this.scheduler;
        if ((scheduler2 instanceof ImmediateScheduler) || (scheduler2 instanceof TrampolineScheduler)) {
            return subscriber;
        }
        ObserveOnSubscriber observeOnSubscriber = new ObserveOnSubscriber(scheduler2, subscriber, this.delayError, this.bufferSize);
        observeOnSubscriber.init();
        return observeOnSubscriber;
    }
}
