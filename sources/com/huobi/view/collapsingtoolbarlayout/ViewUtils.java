package com.huobi.view.collapsingtoolbarlayout;

import android.graphics.PorterDuff;
import android.os.Build;
import com.huobi.view.collapsingtoolbarlayout.ValueAnimatorCompat;

class ViewUtils {
    public static final ValueAnimatorCompat.Creator DEFAULT_ANIMATOR_CREATOR = new ValueAnimatorCompat.Creator() {
        public ValueAnimatorCompat createAnimator() {
            ValueAnimatorCompat.Impl impl;
            if (Build.VERSION.SDK_INT >= 12) {
                impl = new ValueAnimatorCompatImplHoneycombMr1();
            } else {
                impl = new ValueAnimatorCompatImplGingerbread();
            }
            return new ValueAnimatorCompat(impl);
        }
    };

    public static ValueAnimatorCompat createAnimator() {
        return DEFAULT_ANIMATOR_CREATOR.createAnimator();
    }

    public static boolean objectEquals(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static PorterDuff.Mode parseTintMode(int i11, PorterDuff.Mode mode) {
        if (i11 == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i11 == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i11 == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        if (i11 != 14) {
            return i11 != 15 ? mode : PorterDuff.Mode.SCREEN;
        }
        return PorterDuff.Mode.MULTIPLY;
    }
}
