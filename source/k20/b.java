package k20;

import android.util.Log;
import org.greenrobot.eventbus.EventBus;

public final class b implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final g f68205b = new g();

    /* renamed from: c  reason: collision with root package name */
    public final EventBus f68206c;

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f68207d;

    public b(EventBus eventBus) {
        this.f68206c = eventBus;
    }

    public void a(l lVar, Object obj) {
        f a11 = f.a(lVar, obj);
        synchronized (this) {
            this.f68205b.a(a11);
            if (!this.f68207d) {
                this.f68207d = true;
                this.f68206c.e().execute(this);
            }
        }
    }

    public void run() {
        while (true) {
            try {
                f c11 = this.f68205b.c(1000);
                if (c11 == null) {
                    synchronized (this) {
                        c11 = this.f68205b.b();
                        if (c11 == null) {
                            this.f68207d = false;
                            this.f68207d = false;
                            return;
                        }
                    }
                }
                this.f68206c.g(c11);
            } catch (InterruptedException e11) {
                try {
                    Log.w("Event", Thread.currentThread().getName() + " was interruppted", e11);
                    return;
                } finally {
                    this.f68207d = false;
                }
            }
        }
    }
}
