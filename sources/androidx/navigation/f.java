package androidx.navigation;

import android.os.Bundle;
import androidx.navigation.Navigator;
import java.util.List;

@Navigator.b("navigation")
public class f extends Navigator<NavGraph> {

    /* renamed from: c  reason: collision with root package name */
    public final NavigatorProvider f10390c;

    public f(NavigatorProvider navigatorProvider) {
        this.f10390c = navigatorProvider;
    }

    public void e(List<NavBackStackEntry> list, NavOptions navOptions, Navigator.a aVar) {
        for (NavBackStackEntry m11 : list) {
            m(m11, navOptions, aVar);
        }
    }

    /* renamed from: l */
    public NavGraph a() {
        return new NavGraph(this);
    }

    public final void m(NavBackStackEntry navBackStackEntry, NavOptions navOptions, Navigator.a aVar) {
        NavDestination navDestination;
        NavGraph navGraph = (NavGraph) navBackStackEntry.e();
        Bundle c11 = navBackStackEntry.c();
        int H = navGraph.H();
        String I = navGraph.I();
        if ((H == 0 && I == null) ? false : true) {
            if (I != null) {
                navDestination = navGraph.E(I, false);
            } else {
                navDestination = navGraph.C(H, false);
            }
            if (navDestination != null) {
                this.f10390c.d(navDestination.n()).e(CollectionsKt__CollectionsJVMKt.e(b().a(navDestination, navDestination.d(c11))), navOptions, aVar);
                return;
            }
            String G = navGraph.G();
            throw new IllegalArgumentException("navigation destination " + G + " is not a direct child of this NavGraph");
        }
        throw new IllegalStateException(("no start destination defined via app:startDestination for " + navGraph.k()).toString());
    }
}
