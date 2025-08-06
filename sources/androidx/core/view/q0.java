package androidx.core.view;

import android.os.Build;
import android.view.View;
import android.view.Window;

public final class q0 {

    public static class a {
        public static void a(Window window, boolean z11) {
            View decorView = window.getDecorView();
            int systemUiVisibility = decorView.getSystemUiVisibility();
            decorView.setSystemUiVisibility(z11 ? systemUiVisibility & -1793 : systemUiVisibility | Params.POLY_BYTES);
        }
    }

    public static class b {
        public static void a(Window window, boolean z11) {
            window.setDecorFitsSystemWindows(z11);
        }
    }

    public static void a(Window window, boolean z11) {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 30) {
            b.a(window, z11);
        } else if (i11 >= 16) {
            a.a(window, z11);
        }
    }
}
