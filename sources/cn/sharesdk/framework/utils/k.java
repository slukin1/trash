package cn.sharesdk.framework.utils;

import android.text.TextUtils;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class k {

    /* renamed from: a  reason: collision with root package name */
    public static ThreadPoolExecutor f13532a;

    /* renamed from: b  reason: collision with root package name */
    private static ScheduledExecutorService f13533b = Executors.newSingleThreadScheduledExecutor();

    public static abstract class a implements Runnable {
        public abstract void a() throws Throwable;

        public void a(Throwable th2) {
        }

        public String b() {
            return "";
        }

        public final void run() {
            try {
                if (!TextUtils.isEmpty(b())) {
                    Thread.currentThread().setName(b());
                }
                a();
                return;
            } catch (Throwable unused) {
            }
            SSDKLog.b().d(th);
        }
    }

    static {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3, 3, 3, TimeUnit.MINUTES, new LinkedBlockingQueue());
        f13532a = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(true);
    }

    public static void a(Runnable runnable) {
        try {
            f13532a.execute(runnable);
        } catch (Throwable th2) {
            SSDKLog.b().d(th2);
        }
    }

    public static <T extends a> void a(T t11) {
        try {
            f13533b.execute(t11);
        } catch (Throwable th2) {
            SSDKLog.b().d(th2);
        }
    }
}
