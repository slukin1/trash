package androidx.lifecycle;

import android.os.Handler;
import androidx.lifecycle.Lifecycle;

public class j0 {

    /* renamed from: a  reason: collision with root package name */
    public final LifecycleRegistry f10013a;

    /* renamed from: b  reason: collision with root package name */
    public final Handler f10014b = new Handler();

    /* renamed from: c  reason: collision with root package name */
    public a f10015c;

    public static final class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final LifecycleRegistry f10016b;

        /* renamed from: c  reason: collision with root package name */
        public final Lifecycle.Event f10017c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f10018d;

        public a(LifecycleRegistry lifecycleRegistry, Lifecycle.Event event) {
            this.f10016b = lifecycleRegistry;
            this.f10017c = event;
        }

        public void run() {
            if (!this.f10018d) {
                this.f10016b.i(this.f10017c);
                this.f10018d = true;
            }
        }
    }

    public j0(LifecycleOwner lifecycleOwner) {
        this.f10013a = new LifecycleRegistry(lifecycleOwner);
    }

    public Lifecycle a() {
        return this.f10013a;
    }

    public void b() {
        f(Lifecycle.Event.ON_START);
    }

    public void c() {
        f(Lifecycle.Event.ON_CREATE);
    }

    public void d() {
        f(Lifecycle.Event.ON_STOP);
        f(Lifecycle.Event.ON_DESTROY);
    }

    public void e() {
        f(Lifecycle.Event.ON_START);
    }

    public final void f(Lifecycle.Event event) {
        a aVar = this.f10015c;
        if (aVar != null) {
            aVar.run();
        }
        a aVar2 = new a(this.f10013a, event);
        this.f10015c = aVar2;
        this.f10014b.postAtFrontOfQueue(aVar2);
    }
}
