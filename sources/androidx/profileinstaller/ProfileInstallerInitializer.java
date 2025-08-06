package androidx.profileinstaller;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ProfileInstallerInitializer implements t1.b<Result> {

    public static class Result {
    }

    public static class a {
        public static void c(Runnable runnable) {
            Choreographer.getInstance().postFrameCallback(new l(runnable));
        }
    }

    public static class b {
        public static Handler a(Looper looper) {
            return Handler.createAsync(looper);
        }
    }

    public static void j(Context context) {
        new ThreadPoolExecutor(0, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue()).execute(new j(context));
    }

    /* renamed from: d */
    public Result create(Context context) {
        if (Build.VERSION.SDK_INT < 24) {
            return new Result();
        }
        e(context.getApplicationContext());
        return new Result();
    }

    public List<Class<? extends t1.b<?>>> dependencies() {
        return Collections.emptyList();
    }

    public void e(Context context) {
        a.c(new k(this, context));
    }

    /* renamed from: f */
    public void g(Context context) {
        Handler handler;
        if (Build.VERSION.SDK_INT >= 28) {
            handler = b.a(Looper.getMainLooper());
        } else {
            handler = new Handler(Looper.getMainLooper());
        }
        handler.postDelayed(new i(context), (long) (new Random().nextInt(Math.max(1000, 1)) + 5000));
    }
}
