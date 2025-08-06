package v1;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.os.Build;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public static Method f16627a;

    /* renamed from: b  reason: collision with root package name */
    public static Method f16628b;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f16629c;

    @SuppressLint({"SoonBlockedPrivateApi"})
    public static void a(Canvas canvas, boolean z11) {
        Method method;
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 21) {
            if (i11 >= 29) {
                if (z11) {
                    canvas.enableZ();
                } else {
                    canvas.disableZ();
                }
            } else if (i11 != 28) {
                if (!f16629c) {
                    try {
                        Method declaredMethod = Canvas.class.getDeclaredMethod("insertReorderBarrier", new Class[0]);
                        f16627a = declaredMethod;
                        declaredMethod.setAccessible(true);
                        Method declaredMethod2 = Canvas.class.getDeclaredMethod("insertInorderBarrier", new Class[0]);
                        f16628b = declaredMethod2;
                        declaredMethod2.setAccessible(true);
                    } catch (NoSuchMethodException unused) {
                    }
                    f16629c = true;
                }
                if (z11) {
                    try {
                        Method method2 = f16627a;
                        if (method2 != null) {
                            method2.invoke(canvas, new Object[0]);
                        }
                    } catch (IllegalAccessException unused2) {
                        return;
                    } catch (InvocationTargetException e11) {
                        throw new RuntimeException(e11.getCause());
                    }
                }
                if (!z11 && (method = f16628b) != null) {
                    method.invoke(canvas, new Object[0]);
                }
            } else {
                throw new IllegalStateException("This method doesn't work on Pie!");
            }
        }
    }
}
