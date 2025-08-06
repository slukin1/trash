package androidx.navigation.fragment;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.u;
import androidx.navigation.NavBackStackEntry;
import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class FragmentNavigator$attachObservers$1 extends Lambda implements l<LifecycleOwner, Unit> {
    public final /* synthetic */ NavBackStackEntry $entry;
    public final /* synthetic */ Fragment $fragment;
    public final /* synthetic */ FragmentNavigator this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FragmentNavigator$attachObservers$1(FragmentNavigator fragmentNavigator, Fragment fragment, NavBackStackEntry navBackStackEntry) {
        super(1);
        this.this$0 = fragmentNavigator;
        this.$fragment = fragment;
        this.$entry = navBackStackEntry;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((LifecycleOwner) obj);
        return Unit.f56620a;
    }

    public final void invoke(LifecycleOwner lifecycleOwner) {
        if (lifecycleOwner != null && !CollectionsKt___CollectionsKt.R(this.this$0.u(), this.$fragment.getTag())) {
            Lifecycle lifecycle = this.$fragment.getViewLifecycleOwner().getLifecycle();
            if (lifecycle.b().isAtLeast(Lifecycle.State.CREATED)) {
                lifecycle.a((u) this.this$0.f10403h.invoke(this.$entry));
            }
        }
    }
}
