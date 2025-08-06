package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import androidx.appcompat.R$styleable;
import t0.c;

public class z {

    /* renamed from: a  reason: collision with root package name */
    public static final ThreadLocal<TypedValue> f4726a = new ThreadLocal<>();

    /* renamed from: b  reason: collision with root package name */
    public static final int[] f4727b = {-16842910};

    /* renamed from: c  reason: collision with root package name */
    public static final int[] f4728c = {16842908};

    /* renamed from: d  reason: collision with root package name */
    public static final int[] f4729d = {16843518};

    /* renamed from: e  reason: collision with root package name */
    public static final int[] f4730e = {16842919};

    /* renamed from: f  reason: collision with root package name */
    public static final int[] f4731f = {16842912};

    /* renamed from: g  reason: collision with root package name */
    public static final int[] f4732g = {16842913};

    /* renamed from: h  reason: collision with root package name */
    public static final int[] f4733h = {-16842919, -16842908};

    /* renamed from: i  reason: collision with root package name */
    public static final int[] f4734i = new int[0];

    /* renamed from: j  reason: collision with root package name */
    public static final int[] f4735j = new int[1];

    public static void a(View view, Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(R$styleable.AppCompatTheme);
        try {
            if (!obtainStyledAttributes.hasValue(R$styleable.AppCompatTheme_windowActionBar)) {
                Log.e("ThemeUtils", "View " + view.getClass() + " is an AppCompat widget that can only be used with a Theme.AppCompat theme (or descendant).");
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public static int b(Context context, int i11) {
        ColorStateList e11 = e(context, i11);
        if (e11 != null && e11.isStateful()) {
            return e11.getColorForState(f4727b, e11.getDefaultColor());
        }
        TypedValue f11 = f();
        context.getTheme().resolveAttribute(16842803, f11, true);
        return d(context, i11, f11.getFloat());
    }

    public static int c(Context context, int i11) {
        int[] iArr = f4735j;
        iArr[0] = i11;
        d0 u11 = d0.u(context, (AttributeSet) null, iArr);
        try {
            return u11.b(0, 0);
        } finally {
            u11.w();
        }
    }

    public static int d(Context context, int i11, float f11) {
        int c11 = c(context, i11);
        return c.j(c11, Math.round(((float) Color.alpha(c11)) * f11));
    }

    public static ColorStateList e(Context context, int i11) {
        int[] iArr = f4735j;
        iArr[0] = i11;
        d0 u11 = d0.u(context, (AttributeSet) null, iArr);
        try {
            return u11.c(0);
        } finally {
            u11.w();
        }
    }

    public static TypedValue f() {
        ThreadLocal<TypedValue> threadLocal = f4726a;
        TypedValue typedValue = threadLocal.get();
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        threadLocal.set(typedValue2);
        return typedValue2;
    }
}
