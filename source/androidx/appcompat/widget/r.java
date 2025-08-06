package androidx.appcompat.widget;

import android.graphics.Insets;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ScaleDrawable;
import android.os.Build;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import u0.g;

public class r {

    /* renamed from: a  reason: collision with root package name */
    public static final int[] f4670a = {16842912};

    /* renamed from: b  reason: collision with root package name */
    public static final int[] f4671b = new int[0];

    /* renamed from: c  reason: collision with root package name */
    public static final Rect f4672c = new Rect();

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final boolean f4673a;

        /* renamed from: b  reason: collision with root package name */
        public static final Method f4674b;

        /* renamed from: c  reason: collision with root package name */
        public static final Field f4675c;

        /* renamed from: d  reason: collision with root package name */
        public static final Field f4676d;

        /* renamed from: e  reason: collision with root package name */
        public static final Field f4677e;

        /* renamed from: f  reason: collision with root package name */
        public static final Field f4678f;

        /* JADX WARNING: Removed duplicated region for block: B:43:0x004b  */
        /* JADX WARNING: Removed duplicated region for block: B:44:0x0058  */
        static {
            /*
                r0 = 1
                r1 = 0
                r2 = 0
                java.lang.String r3 = "android.graphics.Insets"
                java.lang.Class r3 = java.lang.Class.forName(r3)     // Catch:{ NoSuchMethodException -> 0x0043, ClassNotFoundException -> 0x003f, NoSuchFieldException -> 0x003b }
                java.lang.Class<android.graphics.drawable.Drawable> r4 = android.graphics.drawable.Drawable.class
                java.lang.String r5 = "getOpticalInsets"
                java.lang.Class[] r6 = new java.lang.Class[r1]     // Catch:{ NoSuchMethodException -> 0x0043, ClassNotFoundException -> 0x003f, NoSuchFieldException -> 0x003b }
                java.lang.reflect.Method r4 = r4.getMethod(r5, r6)     // Catch:{ NoSuchMethodException -> 0x0043, ClassNotFoundException -> 0x003f, NoSuchFieldException -> 0x003b }
                java.lang.String r5 = "left"
                java.lang.reflect.Field r5 = r3.getField(r5)     // Catch:{ NoSuchMethodException -> 0x0039, ClassNotFoundException -> 0x0037, NoSuchFieldException -> 0x0035 }
                java.lang.String r6 = "top"
                java.lang.reflect.Field r6 = r3.getField(r6)     // Catch:{ NoSuchMethodException -> 0x0033, ClassNotFoundException -> 0x0031, NoSuchFieldException -> 0x002f }
                java.lang.String r7 = "right"
                java.lang.reflect.Field r7 = r3.getField(r7)     // Catch:{ ClassNotFoundException | NoSuchFieldException | NoSuchMethodException -> 0x002d }
                java.lang.String r8 = "bottom"
                java.lang.reflect.Field r3 = r3.getField(r8)     // Catch:{ ClassNotFoundException | NoSuchFieldException | NoSuchMethodException -> 0x0047 }
                r8 = r0
                goto L_0x0049
            L_0x002d:
                r7 = r2
                goto L_0x0047
            L_0x002f:
                r6 = r2
                goto L_0x0046
            L_0x0031:
                r6 = r2
                goto L_0x0046
            L_0x0033:
                r6 = r2
                goto L_0x0046
            L_0x0035:
                r5 = r2
                goto L_0x003d
            L_0x0037:
                r5 = r2
                goto L_0x0041
            L_0x0039:
                r5 = r2
                goto L_0x0045
            L_0x003b:
                r4 = r2
                r5 = r4
            L_0x003d:
                r6 = r5
                goto L_0x0046
            L_0x003f:
                r4 = r2
                r5 = r4
            L_0x0041:
                r6 = r5
                goto L_0x0046
            L_0x0043:
                r4 = r2
                r5 = r4
            L_0x0045:
                r6 = r5
            L_0x0046:
                r7 = r6
            L_0x0047:
                r8 = r1
                r3 = r2
            L_0x0049:
                if (r8 == 0) goto L_0x0058
                f4674b = r4
                f4675c = r5
                f4676d = r6
                f4677e = r7
                f4678f = r3
                f4673a = r0
                goto L_0x0064
            L_0x0058:
                f4674b = r2
                f4675c = r2
                f4676d = r2
                f4677e = r2
                f4678f = r2
                f4673a = r1
            L_0x0064:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.r.a.<clinit>():void");
        }

        public static Rect a(Drawable drawable) {
            if (Build.VERSION.SDK_INT < 29 && f4673a) {
                try {
                    Object invoke = f4674b.invoke(drawable, new Object[0]);
                    if (invoke != null) {
                        return new Rect(f4675c.getInt(invoke), f4676d.getInt(invoke), f4677e.getInt(invoke), f4678f.getInt(invoke));
                    }
                } catch (IllegalAccessException | InvocationTargetException unused) {
                }
            }
            return r.f4672c;
        }
    }

    public static class b {
        public static Insets a(Drawable drawable) {
            return drawable.getOpticalInsets();
        }
    }

    public static boolean a(Drawable drawable) {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 17) {
            return true;
        }
        if (i11 < 15 && (drawable instanceof InsetDrawable)) {
            return false;
        }
        if (i11 < 15 && (drawable instanceof GradientDrawable)) {
            return false;
        }
        if (i11 < 17 && (drawable instanceof LayerDrawable)) {
            return false;
        }
        if (drawable instanceof DrawableContainer) {
            Drawable.ConstantState constantState = drawable.getConstantState();
            if (constantState instanceof DrawableContainer.DrawableContainerState) {
                for (Drawable a11 : ((DrawableContainer.DrawableContainerState) constantState).getChildren()) {
                    if (!a(a11)) {
                        return false;
                    }
                }
            }
        } else if (drawable instanceof g) {
            return a(((g) drawable).b());
        } else {
            if (drawable instanceof d.a) {
                return a(((d.a) drawable).a());
            }
            if (drawable instanceof ScaleDrawable) {
                return a(((ScaleDrawable) drawable).getDrawable());
            }
        }
        return true;
    }

    public static void b(Drawable drawable) {
        String name = drawable.getClass().getName();
        int i11 = Build.VERSION.SDK_INT;
        if (i11 == 21 && "android.graphics.drawable.VectorDrawable".equals(name)) {
            c(drawable);
        } else if (i11 >= 29 && i11 < 31 && "android.graphics.drawable.ColorStateListDrawable".equals(name)) {
            c(drawable);
        }
    }

    public static void c(Drawable drawable) {
        int[] state = drawable.getState();
        if (state == null || state.length == 0) {
            drawable.setState(f4670a);
        } else {
            drawable.setState(f4671b);
        }
        drawable.setState(state);
    }

    public static Rect d(Drawable drawable) {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 29) {
            Insets a11 = b.a(drawable);
            return new Rect(a11.left, a11.top, a11.right, a11.bottom);
        } else if (i11 >= 18) {
            return a.a(u0.a.q(drawable));
        } else {
            return f4672c;
        }
    }

    public static PorterDuff.Mode e(int i11, PorterDuff.Mode mode) {
        if (i11 == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i11 == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i11 == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i11) {
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }
}
