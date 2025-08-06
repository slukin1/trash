package androidx.navigation;

import android.view.View;
import android.view.ViewParent;
import d10.l;
import kotlin.jvm.internal.Lambda;

public final class Navigation$findViewNavController$1 extends Lambda implements l<View, View> {
    public static final Navigation$findViewNavController$1 INSTANCE = new Navigation$findViewNavController$1();

    public Navigation$findViewNavController$1() {
        super(1);
    }

    public final View invoke(View view) {
        ViewParent parent = view.getParent();
        if (parent instanceof View) {
            return (View) parent;
        }
        return null;
    }
}
