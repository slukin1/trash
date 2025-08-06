package g00;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import io.reactivex.rxjava3.core.Scheduler;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public final class c extends Scheduler {

    /* renamed from: c  reason: collision with root package name */
    public final Handler f54767c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f54768d;

    public static final class a extends Scheduler.Worker {

        /* renamed from: b  reason: collision with root package name */
        public final Handler f54769b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean f54770c;

        /* renamed from: d  reason: collision with root package name */
        public volatile boolean f54771d;

        public a(Handler handler, boolean z11) {
            this.f54769b = handler;
            this.f54770c = z11;
        }

        @SuppressLint({"NewApi"})
        public io.reactivex.rxjava3.disposables.b c(Runnable runnable, long j11, TimeUnit timeUnit) {
            Objects.requireNonNull(runnable, "run == null");
            Objects.requireNonNull(timeUnit, "unit == null");
            if (this.f54771d) {
                return io.reactivex.rxjava3.disposables.a.a();
            }
            b bVar = new b(this.f54769b, o00.a.p(runnable));
            Message obtain = Message.obtain(this.f54769b, bVar);
            obtain.obj = this;
            if (this.f54770c) {
                obtain.setAsynchronous(true);
            }
            this.f54769b.sendMessageDelayed(obtain, timeUnit.toMillis(j11));
            if (!this.f54771d) {
                return bVar;
            }
            this.f54769b.removeCallbacks(bVar);
            return io.reactivex.rxjava3.disposables.a.a();
        }

        public void dispose() {
            this.f54771d = true;
            this.f54769b.removeCallbacksAndMessages(this);
        }

        public boolean isDisposed() {
            return this.f54771d;
        }
    }

    public static final class b implements Runnable, io.reactivex.rxjava3.disposables.b {

        /* renamed from: b  reason: collision with root package name */
        public final Handler f54772b;

        /* renamed from: c  reason: collision with root package name */
        public final Runnable f54773c;

        /* renamed from: d  reason: collision with root package name */
        public volatile boolean f54774d;

        public b(Handler handler, Runnable runnable) {
            this.f54772b = handler;
            this.f54773c = runnable;
        }

        public void dispose() {
            this.f54772b.removeCallbacks(this);
            this.f54774d = true;
        }

        public boolean isDisposed() {
            return this.f54774d;
        }

        public void run() {
            try {
                this.f54773c.run();
            } catch (Throwable th2) {
                o00.a.n(th2);
            }
        }
    }

    public c(Handler handler, boolean z11) {
        this.f54767c = handler;
        this.f54768d = z11;
    }

    public Scheduler.Worker a() {
        return new a(this.f54767c, this.f54768d);
    }

    @SuppressLint({"NewApi"})
    public io.reactivex.rxjava3.disposables.b d(Runnable runnable, long j11, TimeUnit timeUnit) {
        Objects.requireNonNull(runnable, "run == null");
        Objects.requireNonNull(timeUnit, "unit == null");
        b bVar = new b(this.f54767c, o00.a.p(runnable));
        Message obtain = Message.obtain(this.f54767c, bVar);
        if (this.f54768d) {
            obtain.setAsynchronous(true);
        }
        this.f54767c.sendMessageDelayed(obtain, timeUnit.toMillis(j11));
        return bVar;
    }
}
