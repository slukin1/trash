package androidx.core.os;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;

public final class h {

    public static class a {
        public static Handler a(Looper looper) {
            return Handler.createAsync(looper);
        }

        public static boolean b(Handler handler, Runnable runnable, Object obj, long j11) {
            return handler.postDelayed(runnable, obj, j11);
        }
    }

    public static Handler a(Looper looper) {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 28) {
            return a.a(looper);
        }
        if (i11 >= 17) {
            Class<Handler> cls = Handler.class;
            try {
                return cls.getDeclaredConstructor(new Class[]{Looper.class, Handler.Callback.class, Boolean.TYPE}).newInstance(new Object[]{looper, null, Boolean.TRUE});
            } catch (IllegalAccessException | InstantiationException | NoSuchMethodException e11) {
                Log.w("HandlerCompat", "Unable to invoke Handler(Looper, Callback, boolean) constructor", e11);
            } catch (InvocationTargetException e12) {
                Throwable cause = e12.getCause();
                if (cause instanceof RuntimeException) {
                    throw ((RuntimeException) cause);
                } else if (cause instanceof Error) {
                    throw ((Error) cause);
                } else {
                    throw new RuntimeException(cause);
                }
            }
        }
        return new Handler(looper);
    }

    public static boolean b(Handler handler, Runnable runnable, Object obj, long j11) {
        if (Build.VERSION.SDK_INT >= 28) {
            return a.b(handler, runnable, obj, j11);
        }
        Message obtain = Message.obtain(handler, runnable);
        obtain.obj = obj;
        return handler.sendMessageDelayed(obtain, j11);
    }
}
