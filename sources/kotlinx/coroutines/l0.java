package kotlinx.coroutines;

import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.EventLoopImplBase;

public final class l0 extends EventLoopImplBase implements Runnable {
    private static volatile Thread _thread;
    private static volatile int debugStatus;

    /* renamed from: i  reason: collision with root package name */
    public static final l0 f57369i;

    /* renamed from: j  reason: collision with root package name */
    public static final long f57370j;

    static {
        Long l11;
        l0 l0Var = new l0();
        f57369i = l0Var;
        EventLoop.O(l0Var, false, 1, (Object) null);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        try {
            l11 = Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", 1000);
        } catch (SecurityException unused) {
            l11 = 1000L;
        }
        f57370j = timeUnit.toNanos(l11.longValue());
    }

    public Thread U() {
        Thread thread = _thread;
        return thread == null ? l0() : thread;
    }

    public void V(long j11, EventLoopImplBase.c cVar) {
        p0();
    }

    public void a0(Runnable runnable) {
        if (m0()) {
            p0();
        }
        super.a0(runnable);
    }

    public final synchronized void k0() {
        if (n0()) {
            debugStatus = 3;
            e0();
            notifyAll();
        }
    }

    public final synchronized Thread l0() {
        Thread thread;
        thread = _thread;
        if (thread == null) {
            thread = new Thread(this, "kotlinx.coroutines.DefaultExecutor");
            _thread = thread;
            thread.setDaemon(true);
            thread.start();
        }
        return thread;
    }

    public final boolean m0() {
        return debugStatus == 4;
    }

    public final boolean n0() {
        int i11 = debugStatus;
        return i11 == 2 || i11 == 3;
    }

    public final synchronized boolean o0() {
        if (n0()) {
            return false;
        }
        debugStatus = 1;
        notifyAll();
        return true;
    }

    public final void p0() {
        throw new RejectedExecutionException("DefaultExecutor was shut down. This error indicates that Dispatchers.shutdown() was invoked prior to completion of exiting coroutines, leaving coroutines in incomplete state. Please refer to Dispatchers.shutdown documentation for more details");
    }

    public void run() {
        Unit unit;
        g2.f57278a.d(this);
        AbstractTimeSource a11 = b.a();
        if (a11 != null) {
            a11.c();
        }
        try {
            if (o0()) {
                long j11 = Long.MAX_VALUE;
                while (true) {
                    Thread.interrupted();
                    long R = R();
                    if (R == Long.MAX_VALUE) {
                        AbstractTimeSource a12 = b.a();
                        long a13 = a12 != null ? a12.a() : System.nanoTime();
                        if (j11 == Long.MAX_VALUE) {
                            j11 = f57370j + a13;
                        }
                        long j12 = j11 - a13;
                        if (j12 <= 0) {
                            _thread = null;
                            k0();
                            AbstractTimeSource a14 = b.a();
                            if (a14 != null) {
                                a14.g();
                            }
                            if (!c0()) {
                                U();
                                return;
                            }
                            return;
                        }
                        R = RangesKt___RangesKt.h(R, j12);
                    } else {
                        j11 = Long.MAX_VALUE;
                    }
                    if (R > 0) {
                        if (n0()) {
                            _thread = null;
                            k0();
                            AbstractTimeSource a15 = b.a();
                            if (a15 != null) {
                                a15.g();
                            }
                            if (!c0()) {
                                U();
                                return;
                            }
                            return;
                        }
                        AbstractTimeSource a16 = b.a();
                        if (a16 != null) {
                            a16.b(this, R);
                            unit = Unit.f56620a;
                        } else {
                            unit = null;
                        }
                        if (unit == null) {
                            LockSupport.parkNanos(this, R);
                        }
                    }
                }
            }
        } finally {
            _thread = null;
            k0();
            AbstractTimeSource a17 = b.a();
            if (a17 != null) {
                a17.g();
            }
            if (!c0()) {
                U();
            }
        }
    }

    public void shutdown() {
        debugStatus = 4;
        super.shutdown();
    }

    public x0 u(long j11, Runnable runnable, CoroutineContext coroutineContext) {
        return h0(j11, runnable);
    }
}
