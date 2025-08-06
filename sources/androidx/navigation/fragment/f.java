package androidx.navigation.fragment;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.r;
import androidx.navigation.NavBackStackEntry;

public final /* synthetic */ class f implements r {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FragmentNavigator f10429b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ NavBackStackEntry f10430c;

    public /* synthetic */ f(FragmentNavigator fragmentNavigator, NavBackStackEntry navBackStackEntry) {
        this.f10429b = fragmentNavigator;
        this.f10430c = navBackStackEntry;
    }

    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        FragmentNavigator$fragmentViewObserver$1.invoke$lambda$0(this.f10429b, this.f10430c, lifecycleOwner, event);
    }
}
