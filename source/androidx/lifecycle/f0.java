package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;

public final class f0 implements r {

    /* renamed from: b  reason: collision with root package name */
    public final SavedStateHandlesProvider f10002b;

    public f0(SavedStateHandlesProvider savedStateHandlesProvider) {
        this.f10002b = savedStateHandlesProvider;
    }

    public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        if (event == Lifecycle.Event.ON_CREATE) {
            lifecycleOwner.getLifecycle().d(this);
            this.f10002b.c();
            return;
        }
        throw new IllegalStateException(("Next event must be ON_CREATE, it was " + event).toString());
    }
}
