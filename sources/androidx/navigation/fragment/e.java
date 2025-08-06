package androidx.navigation.fragment;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.r;

public final /* synthetic */ class e implements r {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FragmentNavigator f10428b;

    public /* synthetic */ e(FragmentNavigator fragmentNavigator) {
        this.f10428b = fragmentNavigator;
    }

    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        FragmentNavigator.t(this.f10428b, lifecycleOwner, event);
    }
}
