package androidx.appcompat.widget;

import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import androidx.core.view.h0;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class o0 {

    /* renamed from: a  reason: collision with root package name */
    public static Method f4668a;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f4669b;

    static {
        int i11 = Build.VERSION.SDK_INT;
        f4669b = i11 >= 27;
        if (i11 >= 18) {
            try {
                Method declaredMethod = View.class.getDeclaredMethod("computeFitSystemWindows", new Class[]{Rect.class, Rect.class});
                f4668a = declaredMethod;
                if (!declaredMethod.isAccessible()) {
                    f4668a.setAccessible(true);
                }
            } catch (NoSuchMethodException unused) {
                Log.d("ViewUtils", "Could not find method computeFitSystemWindows. Oh well.");
            }
        }
    }

    public static void a(View view, Rect rect, Rect rect2) {
        Method method = f4668a;
        if (method != null) {
            try {
                method.invoke(view, new Object[]{rect, rect2});
            } catch (Exception e11) {
                Log.d("ViewUtils", "Could not invoke computeFitSystemWindows", e11);
            }
        }
    }

    public static boolean b(View view) {
        return h0.F(view) == 1;
    }

    public static void c(View view) {
        if (Build.VERSION.SDK_INT >= 16) {
            try {
                Method method = view.getClass().getMethod("makeOptionalFitsSystemWindows", new Class[0]);
                if (!method.isAccessible()) {
                    method.setAccessible(true);
                }
                method.invoke(view, new Object[0]);
            } catch (NoSuchMethodException unused) {
                Log.d("ViewUtils", "Could not find method makeOptionalFitsSystemWindows. Oh well...");
            } catch (InvocationTargetException e11) {
                Log.d("ViewUtils", "Could not invoke makeOptionalFitsSystemWindows", e11);
            } catch (IllegalAccessException e12) {
                Log.d("ViewUtils", "Could not invoke makeOptionalFitsSystemWindows", e12);
            }
        }
    }
}
