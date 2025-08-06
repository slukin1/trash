package k20;

import org.greenrobot.eventbus.EventBus;

public class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final g f68203b = new g();

    /* renamed from: c  reason: collision with root package name */
    public final EventBus f68204c;

    public a(EventBus eventBus) {
        this.f68204c = eventBus;
    }

    public void a(l lVar, Object obj) {
        this.f68203b.a(f.a(lVar, obj));
        this.f68204c.e().execute(this);
    }

    public void run() {
        f b11 = this.f68203b.b();
        if (b11 != null) {
            this.f68204c.g(b11);
            return;
        }
        throw new IllegalStateException("No pending post available");
    }
}
