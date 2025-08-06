package androidx.navigation.fragment;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.r;
import androidx.navigation.NavBackStackEntry;
import d10.l;
import kotlin.jvm.internal.Lambda;

public final class FragmentNavigator$fragmentViewObserver$1 extends Lambda implements l<NavBackStackEntry, r> {
    public final /* synthetic */ FragmentNavigator this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FragmentNavigator$fragmentViewObserver$1(FragmentNavigator fragmentNavigator) {
        super(1);
        this.this$0 = fragmentNavigator;
    }

    /* access modifiers changed from: private */
    public static final void invoke$lambda$0(FragmentNavigator fragmentNavigator, NavBackStackEntry navBackStackEntry, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        if (event == Lifecycle.Event.ON_RESUME && fragmentNavigator.b().b().getValue().contains(navBackStackEntry)) {
            fragmentNavigator.b().e(navBackStackEntry);
        }
        if (event == Lifecycle.Event.ON_DESTROY && !fragmentNavigator.b().b().getValue().contains(navBackStackEntry)) {
            fragmentNavigator.b().e(navBackStackEntry);
        }
    }

    public final r invoke(NavBackStackEntry navBackStackEntry) {
        return new f(this.this$0, navBackStackEntry);
    }
}
