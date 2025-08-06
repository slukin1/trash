package androidx.navigation;

import androidx.navigation.Navigator;
import d10.l;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.x;

public final class Navigator$navigate$1 extends Lambda implements l<NavBackStackEntry, NavBackStackEntry> {
    public final /* synthetic */ NavOptions $navOptions;
    public final /* synthetic */ Navigator.a $navigatorExtras;
    public final /* synthetic */ Navigator<D> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Navigator$navigate$1(Navigator<D> navigator, NavOptions navOptions, Navigator.a aVar) {
        super(1);
        this.this$0 = navigator;
        this.$navOptions = navOptions;
        this.$navigatorExtras = aVar;
    }

    public final NavBackStackEntry invoke(NavBackStackEntry navBackStackEntry) {
        NavDestination e11 = navBackStackEntry.e();
        if (!(e11 instanceof NavDestination)) {
            e11 = null;
        }
        if (e11 == null) {
            return null;
        }
        NavDestination d11 = this.this$0.d(e11, navBackStackEntry.c(), this.$navOptions, this.$navigatorExtras);
        if (d11 == null) {
            return null;
        }
        return x.b(d11, e11) ? navBackStackEntry : this.this$0.b().a(d11, d11.d(navBackStackEntry.c()));
    }
}
