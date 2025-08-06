package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.widget.CheckedTextView;
import java.lang.reflect.Field;

public final class c {

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static Field f8724a;

        /* renamed from: b  reason: collision with root package name */
        public static boolean f8725b;

        public static Drawable a(CheckedTextView checkedTextView) {
            if (!f8725b) {
                try {
                    Field declaredField = CheckedTextView.class.getDeclaredField("mCheckMarkDrawable");
                    f8724a = declaredField;
                    declaredField.setAccessible(true);
                } catch (NoSuchFieldException e11) {
                    Log.i("CheckedTextViewCompat", "Failed to retrieve mCheckMarkDrawable field", e11);
                }
                f8725b = true;
            }
            Field field = f8724a;
            if (field != null) {
                try {
                    return (Drawable) field.get(checkedTextView);
                } catch (IllegalAccessException e12) {
                    Log.i("CheckedTextViewCompat", "Failed to get check mark drawable via reflection", e12);
                    f8724a = null;
                }
            }
            return null;
        }
    }

    public static class b {
        public static Drawable a(CheckedTextView checkedTextView) {
            return checkedTextView.getCheckMarkDrawable();
        }
    }

    /* renamed from: androidx.core.widget.c$c  reason: collision with other inner class name */
    public static class C0029c {
        public static void a(CheckedTextView checkedTextView, ColorStateList colorStateList) {
            checkedTextView.setCheckMarkTintList(colorStateList);
        }

        public static void b(CheckedTextView checkedTextView, PorterDuff.Mode mode) {
            checkedTextView.setCheckMarkTintMode(mode);
        }
    }

    public static Drawable a(CheckedTextView checkedTextView) {
        if (Build.VERSION.SDK_INT >= 16) {
            return b.a(checkedTextView);
        }
        return a.a(checkedTextView);
    }

    public static void b(CheckedTextView checkedTextView, ColorStateList colorStateList) {
        if (Build.VERSION.SDK_INT >= 21) {
            C0029c.a(checkedTextView, colorStateList);
        } else if (checkedTextView instanceof m) {
            ((m) checkedTextView).setSupportCheckMarkTintList(colorStateList);
        }
    }

    public static void c(CheckedTextView checkedTextView, PorterDuff.Mode mode) {
        if (Build.VERSION.SDK_INT >= 21) {
            C0029c.b(checkedTextView, mode);
        } else if (checkedTextView instanceof m) {
            ((m) checkedTextView).setSupportCheckMarkTintMode(mode);
        }
    }
}
