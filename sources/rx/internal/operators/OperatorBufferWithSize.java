package rx.internal.operators;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.exceptions.MissingBackpressureException;

public final class OperatorBufferWithSize<T> implements Observable.Operator<List<T>, T> {
    public final int count;
    public final int skip;

    public static final class BufferExact<T> extends Subscriber<T> {
        public final Subscriber<? super List<T>> actual;
        public List<T> buffer;
        public final int count;

        public BufferExact(Subscriber<? super List<T>> subscriber, int i11) {
            this.actual = subscriber;
            this.count = i11;
            request(0);
        }

        public Producer createProducer() {
            return new Producer() {
                public void request(long j11) {
                    int i11 = (j11 > 0 ? 1 : (j11 == 0 ? 0 : -1));
                    if (i11 < 0) {
                        throw new IllegalArgumentException("n >= required but it was " + j11);
                    } else if (i11 != 0) {
                        BufferExact.this.request(BackpressureUtils.multiplyCap(j11, (long) BufferExact.this.count));
                    }
                }
            };
        }

        public void onCompleted() {
            List<T> list = this.buffer;
            if (list != null) {
                this.actual.onNext(list);
            }
            this.actual.onCompleted();
        }

        public void onError(Throwable th2) {
            this.buffer = null;
            this.actual.onError(th2);
        }

        public void onNext(T t11) {
            List list = this.buffer;
            if (list == null) {
                list = new ArrayList(this.count);
                this.buffer = list;
            }
            list.add(t11);
            if (list.size() == this.count) {
                this.buffer = null;
                this.actual.onNext(list);
            }
        }
    }

    public static final class BufferOverlap<T> extends Subscriber<T> {
        public final Subscriber<? super List<T>> actual;
        public final int count;
        public long index;
        public long produced;
        public final ArrayDeque<List<T>> queue = new ArrayDeque<>();
        public final AtomicLong requested = new AtomicLong();
        public final int skip;

        public final class BufferOverlapProducer extends AtomicBoolean implements Producer {
            private static final long serialVersionUID = -4015894850868853147L;

            public BufferOverlapProducer() {
            }

            public void request(long j11) {
                BufferOverlap bufferOverlap = BufferOverlap.this;
                if (BackpressureUtils.postCompleteRequest(bufferOverlap.requested, j11, bufferOverlap.queue, bufferOverlap.actual) && j11 != 0) {
                    if (get() || !compareAndSet(false, true)) {
                        bufferOverlap.request(BackpressureUtils.multiplyCap((long) bufferOverlap.skip, j11));
                    } else {
                        bufferOverlap.request(BackpressureUtils.addCap(BackpressureUtils.multiplyCap((long) bufferOverlap.skip, j11 - 1), (long) bufferOverlap.count));
                    }
                }
            }
        }

        public BufferOverlap(Subscriber<? super List<T>> subscriber, int i11, int i12) {
            this.actual = subscriber;
            this.count = i11;
            this.skip = i12;
            request(0);
        }

        public Producer createProducer() {
            return new BufferOverlapProducer();
        }

        public void onCompleted() {
            long j11 = this.produced;
            if (j11 != 0) {
                if (j11 > this.requested.get()) {
                    Subscriber<? super List<T>> subscriber = this.actual;
                    subscriber.onError(new MissingBackpressureException("More produced than requested? " + j11));
                    return;
                }
                this.requested.addAndGet(-j11);
            }
            BackpressureUtils.postCompleteDone(this.requested, this.queue, this.actual);
        }

        public void onError(Throwable th2) {
            this.queue.clear();
            this.actual.onError(th2);
        }

        public void onNext(T t11) {
            long j11 = this.index;
            if (j11 == 0) {
                this.queue.offer(new ArrayList(this.count));
            }
            long j12 = j11 + 1;
            if (j12 == ((long) this.skip)) {
                this.index = 0;
            } else {
                this.index = j12;
            }
            Iterator<List<T>> it2 = this.queue.iterator();
            while (it2.hasNext()) {
                it2.next().add(t11);
            }
            List peek = this.queue.peek();
            if (peek != null && peek.size() == this.count) {
                this.queue.poll();
                this.produced++;
                this.actual.onNext(peek);
            }
        }
    }

    public static final class BufferSkip<T> extends Subscriber<T> {
        public final Subscriber<? super List<T>> actual;
        public List<T> buffer;
        public final int count;
        public long index;
        public final int skip;

        public final class BufferSkipProducer extends AtomicBoolean implements Producer {
            private static final long serialVersionUID = 3428177408082367154L;

            public BufferSkipProducer() {
            }

            public void request(long j11) {
                int i11 = (j11 > 0 ? 1 : (j11 == 0 ? 0 : -1));
                if (i11 < 0) {
                    throw new IllegalArgumentException("n >= 0 required but it was " + j11);
                } else if (i11 != 0) {
                    BufferSkip bufferSkip = BufferSkip.this;
                    if (get() || !compareAndSet(false, true)) {
                        bufferSkip.request(BackpressureUtils.multiplyCap(j11, (long) bufferSkip.skip));
                    } else {
                        bufferSkip.request(BackpressureUtils.addCap(BackpressureUtils.multiplyCap(j11, (long) bufferSkip.count), BackpressureUtils.multiplyCap((long) (bufferSkip.skip - bufferSkip.count), j11 - 1)));
                    }
                }
            }
        }

        public BufferSkip(Subscriber<? super List<T>> subscriber, int i11, int i12) {
            this.actual = subscriber;
            this.count = i11;
            this.skip = i12;
            request(0);
        }

        public Producer createProducer() {
            return new BufferSkipProducer();
        }

        public void onCompleted() {
            List<T> list = this.buffer;
            if (list != null) {
                this.buffer = null;
                this.actual.onNext(list);
            }
            this.actual.onCompleted();
        }

        public void onError(Throwable th2) {
            this.buffer = null;
            this.actual.onError(th2);
        }

        public void onNext(T t11) {
            long j11 = this.index;
            List list = this.buffer;
            if (j11 == 0) {
                list = new ArrayList(this.count);
                this.buffer = list;
            }
            long j12 = j11 + 1;
            if (j12 == ((long) this.skip)) {
                this.index = 0;
            } else {
                this.index = j12;
            }
            if (list != null) {
                list.add(t11);
                if (list.size() == this.count) {
                    this.buffer = null;
                    this.actual.onNext(list);
                }
            }
        }
    }

    public OperatorBufferWithSize(int i11, int i12) {
        if (i11 <= 0) {
            throw new IllegalArgumentException("count must be greater than 0");
        } else if (i12 > 0) {
            this.count = i11;
            this.skip = i12;
        } else {
            throw new IllegalArgumentException("skip must be greater than 0");
        }
    }

    public Subscriber<? super T> call(Subscriber<? super List<T>> subscriber) {
        int i11 = this.skip;
        int i12 = this.count;
        if (i11 == i12) {
            BufferExact bufferExact = new BufferExact(subscriber, i12);
            subscriber.add(bufferExact);
            subscriber.setProducer(bufferExact.createProducer());
            return bufferExact;
        } else if (i11 > i12) {
            BufferSkip bufferSkip = new BufferSkip(subscriber, i12, i11);
            subscriber.add(bufferSkip);
            subscriber.setProducer(bufferSkip.createProducer());
            return bufferSkip;
        } else {
            BufferOverlap bufferOverlap = new BufferOverlap(subscriber, i12, i11);
            subscriber.add(bufferOverlap);
            subscriber.setProducer(bufferOverlap.createProducer());
            return bufferOverlap;
        }
    }
}
