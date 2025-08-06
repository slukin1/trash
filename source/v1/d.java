package v1;

import android.graphics.Matrix;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class d implements c {

    /* renamed from: c  reason: collision with root package name */
    public static Class<?> f16638c;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f16639d;

    /* renamed from: e  reason: collision with root package name */
    public static Method f16640e;

    /* renamed from: f  reason: collision with root package name */
    public static boolean f16641f;

    /* renamed from: g  reason: collision with root package name */
    public static Method f16642g;

    /* renamed from: h  reason: collision with root package name */
    public static boolean f16643h;

    /* renamed from: b  reason: collision with root package name */
    public final View f16644b;

    public d(View view) {
        this.f16644b = view;
    }

    public static c b(View view, ViewGroup viewGroup, Matrix matrix) {
        c();
        Method method = f16640e;
        if (method != null) {
            try {
                return new d((View) method.invoke((Object) null, new Object[]{view, viewGroup, matrix}));
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e11) {
                throw new RuntimeException(e11.getCause());
            }
        }
        return null;
    }

    public static void c() {
        if (!f16641f) {
            try {
                d();
                Method declaredMethod = f16638c.getDeclaredMethod("addGhost", new Class[]{View.class, ViewGroup.class, Matrix.class});
                f16640e = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException e11) {
                Log.i("GhostViewApi21", "Failed to retrieve addGhost method", e11);
            }
            f16641f = true;
        }
    }

    public static void d() {
        if (!f16639d) {
            try {
                f16638c = Class.forName("android.view.GhostView");
            } catch (ClassNotFoundException e11) {
                Log.i("GhostViewApi21", "Failed to retrieve GhostView class", e11);
            }
            f16639d = true;
        }
    }

    public static void e() {
        if (!f16643h) {
            try {
                d();
                Method declaredMethod = f16638c.getDeclaredMethod("removeGhost", new Class[]{View.class});
                f16642g = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException e11) {
                Log.i("GhostViewApi21", "Failed to retrieve removeGhost method", e11);
            }
            f16643h = true;
        }
    }

    public static void f(View view) {
        e();
        Method method = f16642g;
        if (method != null) {
            try {
                method.invoke((Object) null, new Object[]{view});
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e11) {
                throw new RuntimeException(e11.getCause());
            }
        }
    }

    public void a(ViewGroup viewGroup, View view) {
    }

    public void setVisibility(int i11) {
        this.f16644b.setVisibility(i11);
    }
}
