package com.hbg.lib.widgets.utils;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import com.hbg.lib.common.BaseApplication;
import i6.d;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import na.b;
import oa.c;

public class HuobiToastUtil {

    /* renamed from: a  reason: collision with root package name */
    public static Object f72411a;

    public static class a extends Handler {

        /* renamed from: a  reason: collision with root package name */
        public Handler f72412a;

        public a(Handler handler) {
            this.f72412a = handler;
        }

        public void dispatchMessage(Message message) {
            try {
                this.f72412a.dispatchMessage(message);
            } catch (Exception unused) {
            }
        }

        public void handleMessage(Message message) {
            try {
                this.f72412a.handleMessage(message);
            } catch (Exception unused) {
            }
        }
    }

    public static void b(Toast toast) {
        if (d() && toast != null && f72411a == null) {
            try {
                Method declaredMethod = Toast.class.getDeclaredMethod("getService", new Class[0]);
                declaredMethod.setAccessible(true);
                Object invoke = declaredMethod.invoke((Object) null, new Object[0]);
                Class<?> cls = Class.forName("android.app.INotificationManager");
                f72411a = Proxy.newProxyInstance(toast.getClass().getClassLoader(), new Class[]{cls}, new c(invoke));
                Field declaredField = Toast.class.getDeclaredField("sService");
                declaredField.setAccessible(true);
                declaredField.set(toast, f72411a);
            } catch (Exception unused) {
                f72411a = null;
            }
        }
    }

    public static void c(Toast toast) {
        Field declaredField;
        if (d()) {
            try {
                Field declaredField2 = Toast.class.getDeclaredField("mTN");
                if (declaredField2 != null) {
                    declaredField2.setAccessible(true);
                    Object obj = declaredField2.get(toast);
                    if (obj != null && (declaredField = obj.getClass().getDeclaredField("mHandler")) != null) {
                        declaredField.setAccessible(true);
                        declaredField.set(obj, new a((Handler) declaredField.get(obj)));
                    }
                }
            } catch (NoSuchFieldException e11) {
                e11.printStackTrace();
            } catch (IllegalAccessException e12) {
                e12.printStackTrace();
            }
        }
    }

    public static boolean d() {
        return Build.VERSION.SDK_INT <= 27;
    }

    public static /* synthetic */ Object e(Object obj, Object obj2, Method method, Object[] objArr) throws Throwable {
        d.b("INotificationManager--invoke method=" + method.getName());
        if ("enqueueToast".equals(method.getName()) || "enqueueToastEx".equals(method.getName()) || "cancelToast".equals(method.getName())) {
            objArr[0] = "android";
        }
        return method.invoke(obj, objArr);
    }

    public static void f(Context context, String str, int i11, int i12) {
        if (i11 == 1) {
            na.a.d(context, str, i12);
        } else if (i11 == 3) {
            b.f(context, str, i12);
        } else {
            na.c.d(context, str, i12);
        }
    }

    public static void g(int i11) {
        f(BaseApplication.b(), BaseApplication.b().getString(i11), 1, 1);
    }

    public static void h(int i11, String str) {
        n(BaseApplication.b(), i11, str, 1);
    }

    public static void i(String str) {
        f(BaseApplication.b(), str, 1, 1);
    }

    public static void j(int i11) {
        f(BaseApplication.b(), BaseApplication.b().getString(i11), 1, 0);
    }

    public static void k(Context context, int i11) {
        f(context, context.getString(i11), 1, 0);
    }

    public static void l(Context context, String str) {
        f(context, str, 1, 0);
    }

    public static void m(String str) {
        f(BaseApplication.b(), str, 1, 0);
    }

    public static void n(Context context, int i11, String str, int i12) {
        na.a.c(context, i11, str, i12);
    }

    public static void o(int i11) {
        f(BaseApplication.b(), BaseApplication.b().getString(i11), 3, 0);
    }

    public static void p(int i11) {
        f(BaseApplication.b(), BaseApplication.b().getString(i11), 2, 1);
    }

    public static void q(Context context, String str) {
        f(context, str, 2, 1);
    }

    public static void r(String str) {
        f(BaseApplication.b(), str, 2, 1);
    }

    public static void s(int i11) {
        f(BaseApplication.b(), BaseApplication.b().getString(i11), 2, 0);
    }

    public static void t(Context context, int i11) {
        f(context, context.getString(i11), 2, 0);
    }

    public static void u(Context context, String str) {
        f(context, str, 2, 0);
    }

    public static void v(String str) {
        f(BaseApplication.b(), str, 2, 0);
    }
}
