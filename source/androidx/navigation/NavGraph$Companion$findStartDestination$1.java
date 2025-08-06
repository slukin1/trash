package androidx.navigation;

import d10.l;
import kotlin.jvm.internal.Lambda;

public final class NavGraph$Companion$findStartDestination$1 extends Lambda implements l<NavDestination, NavDestination> {
    public static final NavGraph$Companion$findStartDestination$1 INSTANCE = new NavGraph$Companion$findStartDestination$1();

    public NavGraph$Companion$findStartDestination$1() {
        super(1);
    }

    public final NavDestination invoke(NavDestination navDestination) {
        if (!(navDestination instanceof NavGraph)) {
            return null;
        }
        NavGraph navGraph = (NavGraph) navDestination;
        return navGraph.B(navGraph.H());
    }
}
