package androidx.navigation;

import android.os.Bundle;
import androidx.navigation.Navigator;

final class NavDeepLinkBuilder$PermissiveNavigatorProvider extends NavigatorProvider {

    /* renamed from: d  reason: collision with root package name */
    public final Navigator<NavDestination> f10311d = new a();

    public static final class a extends Navigator<NavDestination> {
        public NavDestination a() {
            return new NavDestination("permissive");
        }

        public NavDestination d(NavDestination navDestination, Bundle bundle, NavOptions navOptions, Navigator.a aVar) {
            throw new IllegalStateException("navigate is not supported");
        }

        public boolean k() {
            throw new IllegalStateException("popBackStack is not supported");
        }
    }

    public NavDeepLinkBuilder$PermissiveNavigatorProvider() {
        b(new f(this));
    }

    public <T extends Navigator<? extends NavDestination>> T d(String str) {
        try {
            return super.d(str);
        } catch (IllegalStateException unused) {
            return this.f10311d;
        }
    }
}
