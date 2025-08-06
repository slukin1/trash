package androidx.lifecycle;

import java.util.ArrayDeque;
import java.util.Queue;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.v0;

public final class DispatchQueue {

    /* renamed from: a  reason: collision with root package name */
    public boolean f9884a = true;

    /* renamed from: b  reason: collision with root package name */
    public boolean f9885b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f9886c;

    /* renamed from: d  reason: collision with root package name */
    public final Queue<Runnable> f9887d = new ArrayDeque();

    public static final void d(DispatchQueue dispatchQueue, Runnable runnable) {
        dispatchQueue.f(runnable);
    }

    public final boolean b() {
        return this.f9885b || !this.f9884a;
    }

    public final void c(CoroutineContext coroutineContext, Runnable runnable) {
        MainCoroutineDispatcher G = v0.c().G();
        if (G.B(coroutineContext) || b()) {
            G.w(coroutineContext, new l(this, runnable));
        } else {
            f(runnable);
        }
    }

    public final void e() {
        if (!this.f9886c) {
            boolean z11 = false;
            z11 = true;
            try {
                while (true) {
                    if (!(this.f9887d.isEmpty() ^ z11)) {
                        break;
                    } else if (!b()) {
                        break;
                    } else {
                        Runnable poll = this.f9887d.poll();
                        if (poll != null) {
                            poll.run();
                        }
                    }
                }
                this.f9886c = z11;
            } finally {
                this.f9886c = z11;
            }
        }
    }

    public final void f(Runnable runnable) {
        if (this.f9887d.offer(runnable)) {
            e();
            return;
        }
        throw new IllegalStateException("cannot enqueue any more runnables".toString());
    }

    public final void g() {
        this.f9885b = true;
        e();
    }

    public final void h() {
        this.f9884a = true;
    }

    public final void i() {
        if (this.f9884a) {
            if (!this.f9885b) {
                this.f9884a = false;
                e();
                return;
            }
            throw new IllegalStateException("Cannot resume a finished dispatcher".toString());
        }
    }
}
