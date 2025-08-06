package androidx.navigation;

import android.view.View;
import d10.l;
import kotlin.jvm.internal.Lambda;

public final class Navigation$findViewNavController$2 extends Lambda implements l<View, NavController> {
    public static final Navigation$findViewNavController$2 INSTANCE = new Navigation$findViewNavController$2();

    public Navigation$findViewNavController$2() {
        super(1);
    }

    public final NavController invoke(View view) {
        return Navigation.f10365a.d(view);
    }
}
