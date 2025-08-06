package androidx.core.view;

import android.graphics.Rect;
import android.os.Build;
import android.view.Gravity;

public final class f {

    public static class a {
        public static void a(int i11, int i12, int i13, Rect rect, int i14, int i15, Rect rect2, int i16) {
            Gravity.apply(i11, i12, i13, rect, i14, i15, rect2, i16);
        }

        public static void b(int i11, int i12, int i13, Rect rect, Rect rect2, int i14) {
            Gravity.apply(i11, i12, i13, rect, rect2, i14);
        }

        public static void c(int i11, Rect rect, Rect rect2, int i12) {
            Gravity.applyDisplay(i11, rect, rect2, i12);
        }
    }

    public static void a(int i11, int i12, int i13, Rect rect, Rect rect2, int i14) {
        if (Build.VERSION.SDK_INT >= 17) {
            a.b(i11, i12, i13, rect, rect2, i14);
        } else {
            Gravity.apply(i11, i12, i13, rect, rect2);
        }
    }

    public static int b(int i11, int i12) {
        return Build.VERSION.SDK_INT >= 17 ? Gravity.getAbsoluteGravity(i11, i12) : i11 & -8388609;
    }
}
