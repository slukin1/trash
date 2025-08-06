package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import androidx.savedstate.SavedStateRegistry;

public final class g0 implements r {

    /* renamed from: b  reason: collision with root package name */
    public final String f10004b;

    /* renamed from: c  reason: collision with root package name */
    public final SavedStateHandle f10005c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f10006d;

    public g0(String str, SavedStateHandle savedStateHandle) {
        this.f10004b = str;
        this.f10005c = savedStateHandle;
    }

    public final void a(SavedStateRegistry savedStateRegistry, Lifecycle lifecycle) {
        if (!this.f10006d) {
            this.f10006d = true;
            lifecycle.a(this);
            savedStateRegistry.h(this.f10004b, this.f10005c.i());
            return;
        }
        throw new IllegalStateException("Already attached to lifecycleOwner".toString());
    }

    public final SavedStateHandle b() {
        return this.f10005c;
    }

    public final boolean c() {
        return this.f10006d;
    }

    public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        if (event == Lifecycle.Event.ON_DESTROY) {
            this.f10006d = false;
            lifecycleOwner.getLifecycle().d(this);
        }
    }
}
