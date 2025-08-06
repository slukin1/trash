package io.reactivex.rxjava3.internal.util;

import io.reactivex.rxjava3.internal.queue.SpscArrayQueue;
import io.reactivex.rxjava3.internal.queue.a;
import j00.e;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import k00.f;
import z20.c;
import z20.d;

public final class g {
    public static <T> f<T> a(int i11) {
        if (i11 < 0) {
            return new a(-i11);
        }
        return new SpscArrayQueue(i11);
    }

    public static boolean b(e eVar) {
        try {
            return eVar.getAsBoolean();
        } catch (Throwable th2) {
            io.reactivex.rxjava3.exceptions.a.b(th2);
            return true;
        }
    }

    public static <T> void c(c<? super T> cVar, Queue<T> queue, AtomicLong atomicLong, e eVar) {
        long j11;
        long j12;
        if (queue.isEmpty()) {
            cVar.onComplete();
        } else if (!d(atomicLong.get(), cVar, queue, atomicLong, eVar)) {
            do {
                j11 = atomicLong.get();
                if ((j11 & Long.MIN_VALUE) == 0) {
                    j12 = j11 | Long.MIN_VALUE;
                } else {
                    return;
                }
            } while (!atomicLong.compareAndSet(j11, j12));
            if (j11 != 0) {
                d(j12, cVar, queue, atomicLong, eVar);
            }
        }
    }

    public static <T> boolean d(long j11, c<? super T> cVar, Queue<T> queue, AtomicLong atomicLong, e eVar) {
        long j12 = j11 & Long.MIN_VALUE;
        while (true) {
            if (j12 != j11) {
                if (b(eVar)) {
                    return true;
                }
                T poll = queue.poll();
                if (poll == null) {
                    cVar.onComplete();
                    return true;
                }
                cVar.onNext(poll);
                j12++;
            } else if (b(eVar)) {
                return true;
            } else {
                if (queue.isEmpty()) {
                    cVar.onComplete();
                    return true;
                }
                j11 = atomicLong.get();
                if (j11 == j12) {
                    long addAndGet = atomicLong.addAndGet(-(j12 & Long.MAX_VALUE));
                    if ((Long.MAX_VALUE & addAndGet) == 0) {
                        return false;
                    }
                    j11 = addAndGet;
                    j12 = addAndGet & Long.MIN_VALUE;
                } else {
                    continue;
                }
            }
        }
    }

    public static <T> boolean e(long j11, c<? super T> cVar, Queue<T> queue, AtomicLong atomicLong, e eVar) {
        long j12;
        long j13 = j11;
        do {
            j12 = atomicLong.get();
        } while (!atomicLong.compareAndSet(j12, b.c(Long.MAX_VALUE & j12, j11) | (j12 & Long.MIN_VALUE)));
        if (j12 != Long.MIN_VALUE) {
            return false;
        }
        d(j13 | Long.MIN_VALUE, cVar, queue, atomicLong, eVar);
        return true;
    }

    public static void f(d dVar, int i11) {
        dVar.request(i11 < 0 ? Long.MAX_VALUE : (long) i11);
    }
}
