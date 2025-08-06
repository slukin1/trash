package v1;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Build;
import android.util.Property;
import android.view.View;
import androidx.core.view.h0;
import androidx.transition.ViewOverlayApi14;

public class u {

    /* renamed from: a  reason: collision with root package name */
    public static final a0 f16690a;

    /* renamed from: b  reason: collision with root package name */
    public static final Property<View, Float> f16691b = new a(Float.class, "translationAlpha");

    /* renamed from: c  reason: collision with root package name */
    public static final Property<View, Rect> f16692c = new b(Rect.class, "clipBounds");

    public static class a extends Property<View, Float> {
        public a(Class cls, String str) {
            super(cls, str);
        }

        /* renamed from: a */
        public Float get(View view) {
            return Float.valueOf(u.c(view));
        }

        /* renamed from: b */
        public void set(View view, Float f11) {
            u.h(view, f11.floatValue());
        }
    }

    public static class b extends Property<View, Rect> {
        public b(Class cls, String str) {
            super(cls, str);
        }

        /* renamed from: a */
        public Rect get(View view) {
            return h0.x(view);
        }

        /* renamed from: b */
        public void set(View view, Rect rect) {
            h0.E0(view, rect);
        }
    }

    static {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 29) {
            f16690a = new z();
        } else if (i11 >= 23) {
            f16690a = new y();
        } else if (i11 >= 22) {
            f16690a = new x();
        } else if (i11 >= 21) {
            f16690a = new w();
        } else if (i11 >= 19) {
            f16690a = new v();
        } else {
            f16690a = new a0();
        }
    }

    public static void a(View view) {
        f16690a.a(view);
    }

    public static t b(View view) {
        if (Build.VERSION.SDK_INT >= 18) {
            return new s(view);
        }
        return ViewOverlayApi14.a(view);
    }

    public static float c(View view) {
        return f16690a.c(view);
    }

    public static d0 d(View view) {
        if (Build.VERSION.SDK_INT >= 18) {
            return new c0(view);
        }
        return new b0(view.getWindowToken());
    }

    public static void e(View view) {
        f16690a.d(view);
    }

    public static void f(View view, Matrix matrix) {
        f16690a.e(view, matrix);
    }

    public static void g(View view, int i11, int i12, int i13, int i14) {
        f16690a.f(view, i11, i12, i13, i14);
    }

    public static void h(View view, float f11) {
        f16690a.g(view, f11);
    }

    public static void i(View view, int i11) {
        f16690a.h(view, i11);
    }

    public static void j(View view, Matrix matrix) {
        f16690a.i(view, matrix);
    }

    public static void k(View view, Matrix matrix) {
        f16690a.j(view, matrix);
    }
}
