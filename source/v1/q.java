package v1;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.ViewGroup;
import androidx.transition.e;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class q {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f16681a = true;

    /* renamed from: b  reason: collision with root package name */
    public static Method f16682b;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f16683c;

    public static int a(ViewGroup viewGroup, int i11) {
        if (Build.VERSION.SDK_INT >= 29) {
            return viewGroup.getChildDrawingOrder(i11);
        }
        if (!f16683c) {
            Class<ViewGroup> cls = ViewGroup.class;
            try {
                Class cls2 = Integer.TYPE;
                Method declaredMethod = cls.getDeclaredMethod("getChildDrawingOrder", new Class[]{cls2, cls2});
                f16682b = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException unused) {
            }
            f16683c = true;
        }
        Method method = f16682b;
        if (method != null) {
            try {
                return ((Integer) method.invoke(viewGroup, new Object[]{Integer.valueOf(viewGroup.getChildCount()), Integer.valueOf(i11)})).intValue();
            } catch (IllegalAccessException | InvocationTargetException unused2) {
            }
        }
        return i11;
    }

    public static p b(ViewGroup viewGroup) {
        if (Build.VERSION.SDK_INT >= 18) {
            return new o(viewGroup);
        }
        return e.c(viewGroup);
    }

    @SuppressLint({"NewApi"})
    public static void c(ViewGroup viewGroup, boolean z11) {
        if (f16681a) {
            try {
                viewGroup.suppressLayout(z11);
            } catch (NoSuchMethodError unused) {
                f16681a = false;
            }
        }
    }

    public static void d(ViewGroup viewGroup, boolean z11) {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 29) {
            viewGroup.suppressLayout(z11);
        } else if (i11 >= 18) {
            c(viewGroup, z11);
        } else {
            r.b(viewGroup, z11);
        }
    }
}
