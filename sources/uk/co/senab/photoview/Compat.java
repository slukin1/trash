package uk.co.senab.photoview;

import android.annotation.TargetApi;
import android.os.Build;
import android.view.View;

public class Compat {
    public static int a(int i11) {
        if (Build.VERSION.SDK_INT >= 11) {
            return c(i11);
        }
        return b(i11);
    }

    @TargetApi(5)
    public static int b(int i11) {
        return (i11 & 65280) >> 8;
    }

    @TargetApi(11)
    public static int c(int i11) {
        return (i11 & 65280) >> 8;
    }

    public static void d(View view, Runnable runnable) {
        if (Build.VERSION.SDK_INT >= 16) {
            e(view, runnable);
        } else {
            view.postDelayed(runnable, 16);
        }
    }

    @TargetApi(16)
    public static void e(View view, Runnable runnable) {
        view.postOnAnimation(runnable);
    }
}
