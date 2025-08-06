package androidx.navigation;

import androidx.navigation.NavController;
import d10.a;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class NavController$NavControllerNavigatorState$pop$1 extends Lambda implements a<Unit> {
    public final /* synthetic */ NavBackStackEntry $popUpTo;
    public final /* synthetic */ boolean $saveState;
    public final /* synthetic */ NavController.NavControllerNavigatorState this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NavController$NavControllerNavigatorState$pop$1(NavController.NavControllerNavigatorState navControllerNavigatorState, NavBackStackEntry navBackStackEntry, boolean z11) {
        super(0);
        this.this$0 = navControllerNavigatorState;
        this.$popUpTo = navBackStackEntry;
        this.$saveState = z11;
    }

    public final void invoke() {
        NavController$NavControllerNavigatorState$pop$1.super.h(this.$popUpTo, this.$saveState);
    }
}
