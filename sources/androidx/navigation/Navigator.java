package androidx.navigation;

import android.os.Bundle;
import androidx.navigation.NavDestination;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.List;
import java.util.ListIterator;
import kotlin.jvm.internal.x;

public abstract class Navigator<D extends NavDestination> {

    /* renamed from: a  reason: collision with root package name */
    public NavigatorState f10366a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f10367b;

    public interface a {
    }

    @Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface b {
        String value();
    }

    public abstract D a();

    public final NavigatorState b() {
        NavigatorState navigatorState = this.f10366a;
        if (navigatorState != null) {
            return navigatorState;
        }
        throw new IllegalStateException("You cannot access the Navigator's state until the Navigator is attached".toString());
    }

    public final boolean c() {
        return this.f10367b;
    }

    public NavDestination d(D d11, Bundle bundle, NavOptions navOptions, a aVar) {
        return d11;
    }

    public void e(List<NavBackStackEntry> list, NavOptions navOptions, a aVar) {
        for (NavBackStackEntry k11 : SequencesKt___SequencesKt.m(SequencesKt___SequencesKt.s(CollectionsKt___CollectionsKt.P(list), new Navigator$navigate$1(this, navOptions, aVar)))) {
            b().k(k11);
        }
    }

    public void f(NavigatorState navigatorState) {
        this.f10366a = navigatorState;
        this.f10367b = true;
    }

    public void g(NavBackStackEntry navBackStackEntry) {
        NavDestination e11 = navBackStackEntry.e();
        if (!(e11 instanceof NavDestination)) {
            e11 = null;
        }
        if (e11 != null) {
            d(e11, (Bundle) null, j.a(Navigator$onLaunchSingleTop$1.INSTANCE), (a) null);
            b().f(navBackStackEntry);
        }
    }

    public void h(Bundle bundle) {
    }

    public Bundle i() {
        return null;
    }

    public void j(NavBackStackEntry navBackStackEntry, boolean z11) {
        List value = b().b().getValue();
        if (value.contains(navBackStackEntry)) {
            ListIterator listIterator = value.listIterator(value.size());
            NavBackStackEntry navBackStackEntry2 = null;
            while (k()) {
                navBackStackEntry2 = (NavBackStackEntry) listIterator.previous();
                if (x.b(navBackStackEntry2, navBackStackEntry)) {
                    break;
                }
            }
            if (navBackStackEntry2 != null) {
                b().h(navBackStackEntry2, z11);
                return;
            }
            return;
        }
        throw new IllegalStateException(("popBackStack was called with " + navBackStackEntry + " which does not exist in back stack " + value).toString());
    }

    public boolean k() {
        return true;
    }
}
