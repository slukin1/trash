package androidx.appcompat.widget;

import android.os.Build;
import android.view.View;

public class i0 {

    public static class a {
        public static void a(View view, CharSequence charSequence) {
            view.setTooltipText(charSequence);
        }
    }

    public static void a(View view, CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 26) {
            a.a(view, charSequence);
        } else {
            l0.h(view, charSequence);
        }
    }
}
