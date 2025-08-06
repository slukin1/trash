package androidx.navigation;

import android.os.Bundle;
import d10.l;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref$BooleanRef;

public final class NavController$navigate$4 extends Lambda implements l<NavBackStackEntry, Unit> {
    public final /* synthetic */ Bundle $finalArgs;
    public final /* synthetic */ Ref$BooleanRef $navigated;
    public final /* synthetic */ NavDestination $node;
    public final /* synthetic */ NavController this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NavController$navigate$4(Ref$BooleanRef ref$BooleanRef, NavController navController, NavDestination navDestination, Bundle bundle) {
        super(1);
        this.$navigated = ref$BooleanRef;
        this.this$0 = navController;
        this.$node = navDestination;
        this.$finalArgs = bundle;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((NavBackStackEntry) obj);
        return Unit.f56620a;
    }

    public final void invoke(NavBackStackEntry navBackStackEntry) {
        this.$navigated.element = true;
        NavController.q(this.this$0, this.$node, this.$finalArgs, navBackStackEntry, (List) null, 8, (Object) null);
    }
}
