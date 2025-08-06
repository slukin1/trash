package rx.internal.operators;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import rx.Subscriber;
import rx.functions.Func1;
import rx.internal.util.UtilityFunctions;

public final class BackpressureUtils {
    public static final long COMPLETED_MASK = Long.MIN_VALUE;
    public static final long REQUESTED_MASK = Long.MAX_VALUE;

    private BackpressureUtils() {
        throw new IllegalStateException("No instances!");
    }

    public static long addCap(long j11, long j12) {
        long j13 = j11 + j12;
        if (j13 < 0) {
            return Long.MAX_VALUE;
        }
        return j13;
    }

    public static long getAndAddRequest(AtomicLong atomicLong, long j11) {
        long j12;
        do {
            j12 = atomicLong.get();
        } while (!atomicLong.compareAndSet(j12, addCap(j12, j11)));
        return j12;
    }

    public static long multiplyCap(long j11, long j12) {
        long j13 = j11 * j12;
        if (((j11 | j12) >>> 31) == 0 || j12 == 0 || j13 / j12 == j11) {
            return j13;
        }
        return Long.MAX_VALUE;
    }

    public static <T> void postCompleteDone(AtomicLong atomicLong, Queue<T> queue, Subscriber<? super T> subscriber) {
        postCompleteDone(atomicLong, queue, subscriber, UtilityFunctions.identity());
    }

    public static <T, R> void postCompleteDrain(AtomicLong atomicLong, Queue<T> queue, Subscriber<? super R> subscriber, Func1<? super T, ? extends R> func1) {
        long j11 = atomicLong.get();
        if (j11 == Long.MAX_VALUE) {
            while (!subscriber.isUnsubscribed()) {
                T poll = queue.poll();
                if (poll == null) {
                    subscriber.onCompleted();
                    return;
                }
                subscriber.onNext(func1.call(poll));
            }
            return;
        }
        do {
            long j12 = Long.MIN_VALUE;
            while (true) {
                int i11 = (j12 > j11 ? 1 : (j12 == j11 ? 0 : -1));
                if (i11 == 0) {
                    if (i11 == 0) {
                        if (!subscriber.isUnsubscribed()) {
                            if (queue.isEmpty()) {
                                subscriber.onCompleted();
                                return;
                            }
                        } else {
                            return;
                        }
                    }
                    j11 = atomicLong.get();
                    if (j11 == j12) {
                        j11 = atomicLong.addAndGet(-(j12 & Long.MAX_VALUE));
                    }
                } else if (!subscriber.isUnsubscribed()) {
                    T poll2 = queue.poll();
                    if (poll2 == null) {
                        subscriber.onCompleted();
                        return;
                    } else {
                        subscriber.onNext(func1.call(poll2));
                        j12++;
                    }
                } else {
                    return;
                }
            }
        } while (j11 != Long.MIN_VALUE);
    }

    public static <T> boolean postCompleteRequest(AtomicLong atomicLong, long j11, Queue<T> queue, Subscriber<? super T> subscriber) {
        return postCompleteRequest(atomicLong, j11, queue, subscriber, UtilityFunctions.identity());
    }

    public static long produced(AtomicLong atomicLong, long j11) {
        long j12;
        long j13;
        do {
            j12 = atomicLong.get();
            if (j12 == Long.MAX_VALUE) {
                return Long.MAX_VALUE;
            }
            j13 = j12 - j11;
            if (j13 < 0) {
                throw new IllegalStateException("More produced than requested: " + j13);
            }
        } while (!atomicLong.compareAndSet(j12, j13));
        return j13;
    }

    public static boolean validate(long j11) {
        int i11 = (j11 > 0 ? 1 : (j11 == 0 ? 0 : -1));
        if (i11 >= 0) {
            return i11 != 0;
        }
        throw new IllegalArgumentException("n >= 0 required but it was " + j11);
    }

    public static <T, R> void postCompleteDone(AtomicLong atomicLong, Queue<T> queue, Subscriber<? super R> subscriber, Func1<? super T, ? extends R> func1) {
        long j11;
        do {
            j11 = atomicLong.get();
            if ((j11 & Long.MIN_VALUE) != 0) {
                return;
            }
        } while (!atomicLong.compareAndSet(j11, Long.MIN_VALUE | j11));
        if (j11 != 0) {
            postCompleteDrain(atomicLong, queue, subscriber, func1);
        }
    }

    public static <T, R> boolean postCompleteRequest(AtomicLong atomicLong, long j11, Queue<T> queue, Subscriber<? super R> subscriber, Func1<? super T, ? extends R> func1) {
        long j12;
        long j13;
        AtomicLong atomicLong2 = atomicLong;
        long j14 = j11;
        int i11 = (j14 > 0 ? 1 : (j14 == 0 ? 0 : -1));
        if (i11 < 0) {
            throw new IllegalArgumentException("n >= 0 required but it was " + j14);
        } else if (i11 == 0) {
            return (atomicLong.get() & Long.MIN_VALUE) == 0;
        } else {
            while (true) {
                j12 = atomicLong.get();
                j13 = j12 & Long.MIN_VALUE;
                if (atomicLong2.compareAndSet(j12, addCap(Long.MAX_VALUE & j12, j14) | j13)) {
                    break;
                }
                Queue<T> queue2 = queue;
                Subscriber<? super R> subscriber2 = subscriber;
                Func1<? super T, ? extends R> func12 = func1;
            }
            if (j12 == Long.MIN_VALUE) {
                postCompleteDrain(atomicLong2, queue, subscriber, func1);
                return false;
            } else if (j13 == 0) {
                return true;
            } else {
                return false;
            }
        }
    }
}
