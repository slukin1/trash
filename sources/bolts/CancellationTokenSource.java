package bolts;

import java.io.Closeable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import y1.c;
import y1.e;

public class CancellationTokenSource implements Closeable {

    /* renamed from: b  reason: collision with root package name */
    public final Object f12858b = new Object();

    /* renamed from: c  reason: collision with root package name */
    public final List<e> f12859c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public final ScheduledExecutorService f12860d = c.d();

    /* renamed from: e  reason: collision with root package name */
    public ScheduledFuture<?> f12861e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f12862f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f12863g;

    public final void a() {
        ScheduledFuture<?> scheduledFuture = this.f12861e;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
            this.f12861e = null;
        }
    }

    public boolean b() {
        boolean z11;
        synchronized (this.f12858b) {
            e();
            z11 = this.f12862f;
        }
        return z11;
    }

    public void close() {
        synchronized (this.f12858b) {
            if (!this.f12863g) {
                a();
                for (e close : this.f12859c) {
                    close.close();
                }
                this.f12859c.clear();
                this.f12863g = true;
            }
        }
    }

    public final void e() {
        if (this.f12863g) {
            throw new IllegalStateException("Object already closed");
        }
    }

    public void f(e eVar) {
        synchronized (this.f12858b) {
            e();
            this.f12859c.remove(eVar);
        }
    }

    public String toString() {
        return String.format(Locale.US, "%s@%s[cancellationRequested=%s]", new Object[]{getClass().getName(), Integer.toHexString(hashCode()), Boolean.toString(b())});
    }
}
