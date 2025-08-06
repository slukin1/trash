package u0;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import java.io.IOException;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static Method f16572a;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f16573b;

    /* renamed from: c  reason: collision with root package name */
    public static Method f16574c;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f16575d;

    /* renamed from: u0.a$a  reason: collision with other inner class name */
    public static class C0104a {
        public static int a(Drawable drawable) {
            return drawable.getAlpha();
        }

        public static Drawable b(DrawableContainer.DrawableContainerState drawableContainerState, int i11) {
            return drawableContainerState.getChild(i11);
        }

        public static Drawable c(InsetDrawable insetDrawable) {
            return insetDrawable.getDrawable();
        }

        public static boolean d(Drawable drawable) {
            return drawable.isAutoMirrored();
        }

        public static void e(Drawable drawable, boolean z11) {
            drawable.setAutoMirrored(z11);
        }
    }

    public static class b {
        public static void a(Drawable drawable, Resources.Theme theme) {
            drawable.applyTheme(theme);
        }

        public static boolean b(Drawable drawable) {
            return drawable.canApplyTheme();
        }

        public static ColorFilter c(Drawable drawable) {
            return drawable.getColorFilter();
        }

        public static void d(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
            drawable.inflate(resources, xmlPullParser, attributeSet, theme);
        }

        public static void e(Drawable drawable, float f11, float f12) {
            drawable.setHotspot(f11, f12);
        }

        public static void f(Drawable drawable, int i11, int i12, int i13, int i14) {
            drawable.setHotspotBounds(i11, i12, i13, i14);
        }

        public static void g(Drawable drawable, int i11) {
            drawable.setTint(i11);
        }

        public static void h(Drawable drawable, ColorStateList colorStateList) {
            drawable.setTintList(colorStateList);
        }

        public static void i(Drawable drawable, PorterDuff.Mode mode) {
            drawable.setTintMode(mode);
        }
    }

    public static class c {
        public static int a(Drawable drawable) {
            return drawable.getLayoutDirection();
        }

        public static boolean b(Drawable drawable, int i11) {
            return drawable.setLayoutDirection(i11);
        }
    }

    public static void a(Drawable drawable, Resources.Theme theme) {
        if (Build.VERSION.SDK_INT >= 21) {
            b.a(drawable, theme);
        }
    }

    public static boolean b(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 21) {
            return b.b(drawable);
        }
        return false;
    }

    public static void c(Drawable drawable) {
        DrawableContainer.DrawableContainerState drawableContainerState;
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 23) {
            drawable.clearColorFilter();
        } else if (i11 >= 21) {
            drawable.clearColorFilter();
            if (drawable instanceof InsetDrawable) {
                c(C0104a.c((InsetDrawable) drawable));
            } else if (drawable instanceof g) {
                c(((g) drawable).b());
            } else if ((drawable instanceof DrawableContainer) && (drawableContainerState = (DrawableContainer.DrawableContainerState) ((DrawableContainer) drawable).getConstantState()) != null) {
                int childCount = drawableContainerState.getChildCount();
                for (int i12 = 0; i12 < childCount; i12++) {
                    Drawable b11 = C0104a.b(drawableContainerState, i12);
                    if (b11 != null) {
                        c(b11);
                    }
                }
            }
        } else {
            drawable.clearColorFilter();
        }
    }

    public static int d(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 19) {
            return C0104a.a(drawable);
        }
        return 0;
    }

    public static ColorFilter e(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 21) {
            return b.c(drawable);
        }
        return null;
    }

    public static int f(Drawable drawable) {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 23) {
            return c.a(drawable);
        }
        if (i11 >= 17) {
            if (!f16575d) {
                try {
                    Method declaredMethod = Drawable.class.getDeclaredMethod("getLayoutDirection", new Class[0]);
                    f16574c = declaredMethod;
                    declaredMethod.setAccessible(true);
                } catch (NoSuchMethodException e11) {
                    Log.i("DrawableCompat", "Failed to retrieve getLayoutDirection() method", e11);
                }
                f16575d = true;
            }
            Method method = f16574c;
            if (method != null) {
                try {
                    return ((Integer) method.invoke(drawable, new Object[0])).intValue();
                } catch (Exception e12) {
                    Log.i("DrawableCompat", "Failed to invoke getLayoutDirection() via reflection", e12);
                    f16574c = null;
                }
            }
        }
        return 0;
    }

    public static void g(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        if (Build.VERSION.SDK_INT >= 21) {
            b.d(drawable, resources, xmlPullParser, attributeSet, theme);
        } else {
            drawable.inflate(resources, xmlPullParser, attributeSet);
        }
    }

    public static boolean h(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 19) {
            return C0104a.d(drawable);
        }
        return false;
    }

    @Deprecated
    public static void i(Drawable drawable) {
        drawable.jumpToCurrentState();
    }

    public static void j(Drawable drawable, boolean z11) {
        if (Build.VERSION.SDK_INT >= 19) {
            C0104a.e(drawable, z11);
        }
    }

    public static void k(Drawable drawable, float f11, float f12) {
        if (Build.VERSION.SDK_INT >= 21) {
            b.e(drawable, f11, f12);
        }
    }

    public static void l(Drawable drawable, int i11, int i12, int i13, int i14) {
        if (Build.VERSION.SDK_INT >= 21) {
            b.f(drawable, i11, i12, i13, i14);
        }
    }

    public static boolean m(Drawable drawable, int i11) {
        int i12 = Build.VERSION.SDK_INT;
        if (i12 >= 23) {
            return c.b(drawable, i11);
        }
        if (i12 >= 17) {
            if (!f16573b) {
                Class<Drawable> cls = Drawable.class;
                try {
                    Method declaredMethod = cls.getDeclaredMethod("setLayoutDirection", new Class[]{Integer.TYPE});
                    f16572a = declaredMethod;
                    declaredMethod.setAccessible(true);
                } catch (NoSuchMethodException e11) {
                    Log.i("DrawableCompat", "Failed to retrieve setLayoutDirection(int) method", e11);
                }
                f16573b = true;
            }
            Method method = f16572a;
            if (method != null) {
                try {
                    method.invoke(drawable, new Object[]{Integer.valueOf(i11)});
                    return true;
                } catch (Exception e12) {
                    Log.i("DrawableCompat", "Failed to invoke setLayoutDirection(int) via reflection", e12);
                    f16572a = null;
                }
            }
        }
        return false;
    }

    public static void n(Drawable drawable, int i11) {
        if (Build.VERSION.SDK_INT >= 21) {
            b.g(drawable, i11);
        } else if (drawable instanceof f) {
            ((f) drawable).setTint(i11);
        }
    }

    public static void o(Drawable drawable, ColorStateList colorStateList) {
        if (Build.VERSION.SDK_INT >= 21) {
            b.h(drawable, colorStateList);
        } else if (drawable instanceof f) {
            ((f) drawable).setTintList(colorStateList);
        }
    }

    public static void p(Drawable drawable, PorterDuff.Mode mode) {
        if (Build.VERSION.SDK_INT >= 21) {
            b.i(drawable, mode);
        } else if (drawable instanceof f) {
            ((f) drawable).setTintMode(mode);
        }
    }

    public static <T extends Drawable> T q(Drawable drawable) {
        return drawable instanceof g ? ((g) drawable).b() : drawable;
    }

    public static Drawable r(Drawable drawable) {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 23) {
            return drawable;
        }
        return i11 >= 21 ? !(drawable instanceof f) ? new i(drawable) : drawable : !(drawable instanceof f) ? new h(drawable) : drawable;
    }
}
