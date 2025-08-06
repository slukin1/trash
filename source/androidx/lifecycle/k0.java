package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;

public final class k0 implements r {

    /* renamed from: b  reason: collision with root package name */
    public final n f10022b;

    public k0(n nVar) {
        this.f10022b = nVar;
    }

    public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        this.f10022b.a(lifecycleOwner, event, false, (MethodCallsLogger) null);
        this.f10022b.a(lifecycleOwner, event, true, (MethodCallsLogger) null);
    }
}
