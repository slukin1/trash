package kotlinx.coroutines.android;

import android.os.Build;
import java.lang.Thread;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.a;
import kotlinx.coroutines.d0;

public final class AndroidExceptionPreHandler extends a implements d0 {
    private volatile Object _preHandler = this;

    public AndroidExceptionPreHandler() {
        super(d0.f57063q0);
    }

    public void handleException(CoroutineContext coroutineContext, Throwable th2) {
        int i11 = Build.VERSION.SDK_INT;
        if (26 <= i11 && i11 < 28) {
            Method w11 = w();
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = null;
            Object invoke = w11 != null ? w11.invoke((Object) null, new Object[0]) : null;
            if (invoke instanceof Thread.UncaughtExceptionHandler) {
                uncaughtExceptionHandler = (Thread.UncaughtExceptionHandler) invoke;
            }
            if (uncaughtExceptionHandler != null) {
                uncaughtExceptionHandler.uncaughtException(Thread.currentThread(), th2);
            }
        }
    }

    public final Method w() {
        Object obj = this._preHandler;
        if (obj != this) {
            return (Method) obj;
        }
        Method method = null;
        boolean z11 = false;
        try {
            Method declaredMethod = Thread.class.getDeclaredMethod("getUncaughtExceptionPreHandler", new Class[0]);
            if (Modifier.isPublic(declaredMethod.getModifiers()) && Modifier.isStatic(declaredMethod.getModifiers())) {
                z11 = true;
            }
            if (z11) {
                method = declaredMethod;
            }
        } catch (Throwable unused) {
        }
        this._preHandler = method;
        return method;
    }
}
