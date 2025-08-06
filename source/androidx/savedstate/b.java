package androidx.savedstate;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.r;

public final /* synthetic */ class b implements r {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SavedStateRegistry f10946b;

    public /* synthetic */ b(SavedStateRegistry savedStateRegistry) {
        this.f10946b = savedStateRegistry;
    }

    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        SavedStateRegistry.d(this.f10946b, lifecycleOwner, event);
    }
}
