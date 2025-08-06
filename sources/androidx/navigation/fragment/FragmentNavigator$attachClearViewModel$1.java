package androidx.navigation.fragment;

import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavigatorState;
import d10.a;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class FragmentNavigator$attachClearViewModel$1 extends Lambda implements a<Unit> {
    public final /* synthetic */ NavBackStackEntry $entry;
    public final /* synthetic */ NavigatorState $state;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FragmentNavigator$attachClearViewModel$1(NavBackStackEntry navBackStackEntry, NavigatorState navigatorState) {
        super(0);
        this.$entry = navBackStackEntry;
        this.$state = navigatorState;
    }

    public final void invoke() {
        NavigatorState navigatorState = this.$state;
        for (NavBackStackEntry e11 : navigatorState.c().getValue()) {
            navigatorState.e(e11);
        }
    }
}
