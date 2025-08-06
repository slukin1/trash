package qiu.niorgai;

import a30.a;
import a30.b;
import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.Window;

public class StatusBarCompat {
    public static void a(Activity activity) {
        Window window;
        View decorView;
        if (Build.VERSION.SDK_INT >= 23 && activity != null && (window = activity.getWindow()) != null && (decorView = window.getDecorView()) != null) {
            decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() & -8193);
        }
    }

    public static void b(Activity activity) {
        Window window;
        View decorView;
        if (Build.VERSION.SDK_INT >= 23 && activity != null && (window = activity.getWindow()) != null && (decorView = window.getDecorView()) != null) {
            decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | 8192);
        }
    }

    public static void c(Activity activity, int i11) {
        int i12 = Build.VERSION.SDK_INT;
        if (i12 >= 21) {
            b.a(activity, i11);
        } else if (i12 >= 19) {
            a.f(activity, i11);
        }
    }

    public static void d(Activity activity, boolean z11) {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 21) {
            b.b(activity, z11);
        } else if (i11 >= 19) {
            a.g(activity);
        }
    }
}
