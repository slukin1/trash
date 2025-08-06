package androidx.navigation;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.r;

public final /* synthetic */ class d implements r {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ NavController f10382b;

    public /* synthetic */ d(NavController navController) {
        this.f10382b = navController;
    }

    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        NavController.M(this.f10382b, lifecycleOwner, event);
    }
}
