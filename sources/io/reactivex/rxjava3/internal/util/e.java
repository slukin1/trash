package io.reactivex.rxjava3.internal.util;

import h00.k;
import java.util.concurrent.atomic.AtomicInteger;
import z20.c;

public final class e {
    public static void a(k<?> kVar, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        if (atomicInteger.getAndIncrement() == 0) {
            atomicThrowable.tryTerminateConsumer(kVar);
        }
    }

    public static void b(c<?> cVar, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        if (atomicInteger.getAndIncrement() == 0) {
            atomicThrowable.tryTerminateConsumer(cVar);
        }
    }

    public static void c(k<?> kVar, Throwable th2, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        if (atomicThrowable.tryAddThrowableOrReport(th2) && atomicInteger.getAndIncrement() == 0) {
            atomicThrowable.tryTerminateConsumer(kVar);
        }
    }

    public static void d(c<?> cVar, Throwable th2, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        if (atomicThrowable.tryAddThrowableOrReport(th2) && atomicInteger.getAndIncrement() == 0) {
            atomicThrowable.tryTerminateConsumer(cVar);
        }
    }

    public static <T> void e(k<? super T> kVar, T t11, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        if (atomicInteger.get() == 0 && atomicInteger.compareAndSet(0, 1)) {
            kVar.onNext(t11);
            if (atomicInteger.decrementAndGet() != 0) {
                atomicThrowable.tryTerminateConsumer((k<?>) kVar);
            }
        }
    }

    public static <T> boolean f(c<? super T> cVar, T t11, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        if (atomicInteger.get() == 0 && atomicInteger.compareAndSet(0, 1)) {
            cVar.onNext(t11);
            if (atomicInteger.decrementAndGet() == 0) {
                return true;
            }
            atomicThrowable.tryTerminateConsumer((c<?>) cVar);
        }
        return false;
    }
}
