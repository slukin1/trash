package androidx.core.widget;

import android.os.Build;
import android.util.Log;
import android.view.View;
import android.widget.PopupWindow;
import androidx.core.view.f;
import androidx.core.view.h0;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public final class k {

    /* renamed from: a  reason: collision with root package name */
    public static Method f8732a;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f8733b;

    /* renamed from: c  reason: collision with root package name */
    public static Field f8734c;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f8735d;

    public static class a {
        public static void a(PopupWindow popupWindow, View view, int i11, int i12, int i13) {
            popupWindow.showAsDropDown(view, i11, i12, i13);
        }
    }

    public static class b {
        public static boolean a(PopupWindow popupWindow) {
            return popupWindow.getOverlapAnchor();
        }

        public static int b(PopupWindow popupWindow) {
            return popupWindow.getWindowLayoutType();
        }

        public static void c(PopupWindow popupWindow, boolean z11) {
            popupWindow.setOverlapAnchor(z11);
        }

        public static void d(PopupWindow popupWindow, int i11) {
            popupWindow.setWindowLayoutType(i11);
        }
    }

    public static void a(PopupWindow popupWindow, boolean z11) {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 23) {
            b.c(popupWindow, z11);
        } else if (i11 >= 21) {
            if (!f8735d) {
                try {
                    Field declaredField = PopupWindow.class.getDeclaredField("mOverlapAnchor");
                    f8734c = declaredField;
                    declaredField.setAccessible(true);
                } catch (NoSuchFieldException e11) {
                    Log.i("PopupWindowCompatApi21", "Could not fetch mOverlapAnchor field from PopupWindow", e11);
                }
                f8735d = true;
            }
            Field field = f8734c;
            if (field != null) {
                try {
                    field.set(popupWindow, Boolean.valueOf(z11));
                } catch (IllegalAccessException e12) {
                    Log.i("PopupWindowCompatApi21", "Could not set overlap anchor field in PopupWindow", e12);
                }
            }
        }
    }

    public static void b(PopupWindow popupWindow, int i11) {
        if (Build.VERSION.SDK_INT >= 23) {
            b.d(popupWindow, i11);
            return;
        }
        if (!f8733b) {
            Class<PopupWindow> cls = PopupWindow.class;
            try {
                Method declaredMethod = cls.getDeclaredMethod("setWindowLayoutType", new Class[]{Integer.TYPE});
                f8732a = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (Exception unused) {
            }
            f8733b = true;
        }
        Method method = f8732a;
        if (method != null) {
            try {
                method.invoke(popupWindow, new Object[]{Integer.valueOf(i11)});
            } catch (Exception unused2) {
            }
        }
    }

    public static void c(PopupWindow popupWindow, View view, int i11, int i12, int i13) {
        if (Build.VERSION.SDK_INT >= 19) {
            a.a(popupWindow, view, i11, i12, i13);
            return;
        }
        if ((f.b(i13, h0.F(view)) & 7) == 5) {
            i11 -= popupWindow.getWidth() - view.getWidth();
        }
        popupWindow.showAsDropDown(view, i11, i12);
    }
}
