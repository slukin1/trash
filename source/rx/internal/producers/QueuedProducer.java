package rx.internal.producers;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import rx.Observer;
import rx.Producer;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.exceptions.MissingBackpressureException;
import rx.internal.operators.BackpressureUtils;
import rx.internal.util.atomic.SpscLinkedAtomicQueue;
import rx.internal.util.unsafe.SpscLinkedQueue;
import rx.internal.util.unsafe.UnsafeAccess;

public final class QueuedProducer<T> extends AtomicLong implements Producer, Observer<T> {
    public static final Object NULL_SENTINEL = new Object();
    private static final long serialVersionUID = 7277121710709137047L;
    public final Subscriber<? super T> child;
    public volatile boolean done;
    public Throwable error;
    public final Queue<Object> queue;
    public final AtomicInteger wip;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public QueuedProducer(Subscriber<? super T> subscriber) {
        this(subscriber, UnsafeAccess.isUnsafeAvailable() ? new SpscLinkedQueue() : new SpscLinkedAtomicQueue());
    }

    private boolean checkTerminated(boolean z11, boolean z12) {
        if (this.child.isUnsubscribed()) {
            return true;
        }
        if (!z11) {
            return false;
        }
        Throwable th2 = this.error;
        if (th2 != null) {
            this.queue.clear();
            this.child.onError(th2);
            return true;
        } else if (!z12) {
            return false;
        } else {
            this.child.onCompleted();
            return true;
        }
    }

    private void drain() {
        if (this.wip.getAndIncrement() == 0) {
            Subscriber<? super T> subscriber = this.child;
            Queue<Object> queue2 = this.queue;
            while (!checkTerminated(this.done, queue2.isEmpty())) {
                this.wip.lazySet(1);
                long j11 = get();
                long j12 = 0;
                while (j11 != 0) {
                    boolean z11 = this.done;
                    Object poll = queue2.poll();
                    if (!checkTerminated(z11, poll == null)) {
                        if (poll == null) {
                            break;
                        }
                        try {
                            if (poll == NULL_SENTINEL) {
                                subscriber.onNext(null);
                            } else {
                                subscriber.onNext(poll);
                            }
                            j11--;
                            j12++;
                        } catch (Throwable th2) {
                            if (poll == NULL_SENTINEL) {
                                poll = null;
                            }
                            Exceptions.throwOrReport(th2, (Observer<?>) subscriber, poll);
                            return;
                        }
                    } else {
                        return;
                    }
                }
                if (!(j12 == 0 || get() == Long.MAX_VALUE)) {
                    addAndGet(-j12);
                }
                if (this.wip.decrementAndGet() == 0) {
                    return;
                }
            }
        }
    }

    public boolean offer(T t11) {
        if (t11 == null) {
            if (!this.queue.offer(NULL_SENTINEL)) {
                return false;
            }
        } else if (!this.queue.offer(t11)) {
            return false;
        }
        drain();
        return true;
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
        if (!offer(t11)) {
            onError(new MissingBackpressureException());
        }
    }

    public void request(long j11) {
        int i11 = (j11 > 0 ? 1 : (j11 == 0 ? 0 : -1));
        if (i11 < 0) {
            throw new IllegalArgumentException("n >= 0 required");
        } else if (i11 > 0) {
            BackpressureUtils.getAndAddRequest(this, j11);
            drain();
        }
    }

    public QueuedProducer(Subscriber<? super T> subscriber, Queue<Object> queue2) {
        this.child = subscriber;
        this.queue = queue2;
        this.wip = new AtomicInteger();
    }
}
