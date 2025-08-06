package androidx.navigation;

import android.view.View;
import java.lang.ref.WeakReference;

public final class Navigation {

    /* renamed from: a  reason: collision with root package name */
    public static final Navigation f10365a = new Navigation();

    public static final NavController b(View view) {
        NavController c11 = f10365a.c(view);
        if (c11 != null) {
            return c11;
        }
        throw new IllegalStateException("View " + view + " does not have a NavController set");
    }

    public static final void e(View view, NavController navController) {
        view.setTag(R$id.nav_controller_view_tag, navController);
    }

    public final NavController c(View view) {
        return (NavController) SequencesKt___SequencesKt.n(SequencesKt___SequencesKt.t(SequencesKt__SequencesKt.g(view, Navigation$findViewNavController$1.INSTANCE), Navigation$findViewNavController$2.INSTANCE));
    }

    public final NavController d(View view) {
        Object tag = view.getTag(R$id.nav_controller_view_tag);
        if (tag instanceof WeakReference) {
            return (NavController) ((WeakReference) tag).get();
        }
        if (tag instanceof NavController) {
            return (NavController) tag;
        }
        return null;
    }
}
