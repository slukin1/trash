package androidx.navigation;

import d10.l;
import kotlin.jvm.internal.Lambda;

public final class NavController$executePopOperations$2 extends Lambda implements l<NavDestination, NavDestination> {
    public static final NavController$executePopOperations$2 INSTANCE = new NavController$executePopOperations$2();

    public NavController$executePopOperations$2() {
        super(1);
    }

    public final NavDestination invoke(NavDestination navDestination) {
        NavGraph o11 = navDestination.o();
        boolean z11 = false;
        if (o11 != null && o11.H() == navDestination.l()) {
            z11 = true;
        }
        if (z11) {
            return navDestination.o();
        }
        return null;
    }
}
