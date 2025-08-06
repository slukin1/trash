package androidx.navigation;

import android.os.Bundle;
import androidx.navigation.Navigator;

@Navigator.b("NoOp")
public final class NoOpNavigator extends Navigator<NavDestination> {
    public NavDestination a() {
        return new NavDestination((Navigator<? extends NavDestination>) this);
    }

    public NavDestination d(NavDestination navDestination, Bundle bundle, NavOptions navOptions, Navigator.a aVar) {
        return navDestination;
    }

    public boolean k() {
        return true;
    }
}
