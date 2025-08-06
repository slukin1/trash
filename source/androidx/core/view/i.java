package androidx.core.view;

import android.os.Build;
import android.view.ViewGroup;

public final class i {

    public static class a {
        public static int a(ViewGroup.MarginLayoutParams marginLayoutParams) {
            return marginLayoutParams.getLayoutDirection();
        }

        public static int b(ViewGroup.MarginLayoutParams marginLayoutParams) {
            return marginLayoutParams.getMarginEnd();
        }

        public static int c(ViewGroup.MarginLayoutParams marginLayoutParams) {
            return marginLayoutParams.getMarginStart();
        }

        public static boolean d(ViewGroup.MarginLayoutParams marginLayoutParams) {
            return marginLayoutParams.isMarginRelative();
        }

        public static void e(ViewGroup.MarginLayoutParams marginLayoutParams, int i11) {
            marginLayoutParams.resolveLayoutDirection(i11);
        }

        public static void f(ViewGroup.MarginLayoutParams marginLayoutParams, int i11) {
            marginLayoutParams.setLayoutDirection(i11);
        }

        public static void g(ViewGroup.MarginLayoutParams marginLayoutParams, int i11) {
            marginLayoutParams.setMarginEnd(i11);
        }

        public static void h(ViewGroup.MarginLayoutParams marginLayoutParams, int i11) {
            marginLayoutParams.setMarginStart(i11);
        }
    }

    public static int a(ViewGroup.MarginLayoutParams marginLayoutParams) {
        if (Build.VERSION.SDK_INT >= 17) {
            return a.b(marginLayoutParams);
        }
        return marginLayoutParams.rightMargin;
    }

    public static int b(ViewGroup.MarginLayoutParams marginLayoutParams) {
        if (Build.VERSION.SDK_INT >= 17) {
            return a.c(marginLayoutParams);
        }
        return marginLayoutParams.leftMargin;
    }

    public static void c(ViewGroup.MarginLayoutParams marginLayoutParams, int i11) {
        if (Build.VERSION.SDK_INT >= 17) {
            a.e(marginLayoutParams, i11);
        }
    }

    public static void d(ViewGroup.MarginLayoutParams marginLayoutParams, int i11) {
        if (Build.VERSION.SDK_INT >= 17) {
            a.g(marginLayoutParams, i11);
        } else {
            marginLayoutParams.rightMargin = i11;
        }
    }

    public static void e(ViewGroup.MarginLayoutParams marginLayoutParams, int i11) {
        if (Build.VERSION.SDK_INT >= 17) {
            a.h(marginLayoutParams, i11);
        } else {
            marginLayoutParams.leftMargin = i11;
        }
    }
}
