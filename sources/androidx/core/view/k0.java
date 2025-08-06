package androidx.core.view;

import android.os.Build;
import android.view.ViewGroup;
import androidx.core.R$id;

public final class k0 {

    public static class a {
        public static int a(ViewGroup viewGroup) {
            return viewGroup.getNestedScrollAxes();
        }

        public static boolean b(ViewGroup viewGroup) {
            return viewGroup.isTransitionGroup();
        }

        public static void c(ViewGroup viewGroup, boolean z11) {
            viewGroup.setTransitionGroup(z11);
        }
    }

    public static boolean a(ViewGroup viewGroup) {
        if (Build.VERSION.SDK_INT >= 21) {
            return a.b(viewGroup);
        }
        Boolean bool = (Boolean) viewGroup.getTag(R$id.tag_transition_group);
        return ((bool == null || !bool.booleanValue()) && viewGroup.getBackground() == null && h0.P(viewGroup) == null) ? false : true;
    }
}
