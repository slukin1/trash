package kotlinx.coroutines;

import java.util.concurrent.locks.LockSupport;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.x;

public final class e<T> extends a<T> {

    /* renamed from: e  reason: collision with root package name */
    public final Thread f57115e;

    /* renamed from: f  reason: collision with root package name */
    public final EventLoop f57116f;

    public e(CoroutineContext coroutineContext, Thread thread, EventLoop eventLoop) {
        super(coroutineContext, true, true);
        this.f57115e = thread;
        this.f57116f = eventLoop;
    }

    public void U(Object obj) {
        Unit unit;
        if (!x.b(Thread.currentThread(), this.f57115e)) {
            Thread thread = this.f57115e;
            AbstractTimeSource a11 = b.a();
            if (a11 != null) {
                a11.f(thread);
                unit = Unit.f56620a;
            } else {
                unit = null;
            }
            if (unit == null) {
                LockSupport.unpark(thread);
            }
        }
    }

    public final T f1() {
        Unit unit;
        AbstractTimeSource a11 = b.a();
        if (a11 != null) {
            a11.c();
        }
        try {
            EventLoop eventLoop = this.f57116f;
            y yVar = null;
            if (eventLoop != null) {
                EventLoop.O(eventLoop, false, 1, (Object) null);
            }
            while (!Thread.interrupted()) {
                EventLoop eventLoop2 = this.f57116f;
                long R = eventLoop2 != null ? eventLoop2.R() : Long.MAX_VALUE;
                if (!a()) {
                    AbstractTimeSource a12 = b.a();
                    if (a12 != null) {
                        a12.b(this, R);
                        unit = Unit.f56620a;
                    } else {
                        unit = null;
                    }
                    if (unit == null) {
                        LockSupport.parkNanos(this, R);
                    }
                } else {
                    EventLoop eventLoop3 = this.f57116f;
                    if (eventLoop3 != null) {
                        EventLoop.H(eventLoop3, false, 1, (Object) null);
                    }
                    AbstractTimeSource a13 = b.a();
                    if (a13 != null) {
                        a13.g();
                    }
                    T h11 = s1.h(s0());
                    if (h11 instanceof y) {
                        yVar = (y) h11;
                    }
                    if (yVar == null) {
                        return h11;
                    }
                    throw yVar.f57583a;
                }
            }
            InterruptedException interruptedException = new InterruptedException();
            X(interruptedException);
            throw interruptedException;
        } catch (Throwable th2) {
            AbstractTimeSource a14 = b.a();
            if (a14 != null) {
                a14.g();
            }
            throw th2;
        }
    }

    public boolean w0() {
        return true;
    }
}
