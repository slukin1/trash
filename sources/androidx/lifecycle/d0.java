package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.c;

@Deprecated
public class d0 implements r {

    /* renamed from: b  reason: collision with root package name */
    public final Object f9997b;

    /* renamed from: c  reason: collision with root package name */
    public final c.a f9998c;

    public d0(Object obj) {
        this.f9997b = obj;
        this.f9998c = c.f9977c.c(obj.getClass());
    }

    public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        this.f9998c.a(lifecycleOwner, event, this.f9997b);
    }
}
