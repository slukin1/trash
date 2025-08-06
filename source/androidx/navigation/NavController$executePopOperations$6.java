package androidx.navigation;

import d10.l;
import kotlin.jvm.internal.Lambda;

public final class NavController$executePopOperations$6 extends Lambda implements l<NavDestination, Boolean> {
    public final /* synthetic */ NavController this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NavController$executePopOperations$6(NavController navController) {
        super(1);
        this.this$0 = navController;
    }

    public final Boolean invoke(NavDestination navDestination) {
        return Boolean.valueOf(!this.this$0.f10266o.containsKey(Integer.valueOf(navDestination.l())));
    }
}
