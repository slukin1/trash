package com.bbc876219.runtimestatis;

import android.app.Application;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;
import android.util.Printer;
import com.bbc876219.lib.spi.annotation.MultiInstancesServiceImpl;
import com.bbc876219.lib.spi.provider.service.InsertMethodHookService;
import com.bbc876219.lib.zlog.ZLog;
import java.lang.Thread;
import java.util.concurrent.TimeoutException;

@MultiInstancesServiceImpl(dependencies = {}, hookPoints = {"com.example.maindemo.BaseApplication.attachBaseContext"}, index = 1, isCacheIns = false, isHookAfter = false, isHookBefore = true, sdkVersion = 0, serviceclass = InsertMethodHookService.class)
public class InitApplicationAttachBaseContextServiceImpl implements InsertMethodHookService {

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            while (true) {
                try {
                    Looper.loop();
                } catch (Throwable th2) {
                    ZLog.c("fatal", "Main Thread Crash: " + ZLog.e(th2));
                }
            }
        }
    }

    public class b implements Thread.UncaughtExceptionHandler {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Thread.UncaughtExceptionHandler f63274b;

        public b(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
            this.f63274b = uncaughtExceptionHandler;
        }

        public void uncaughtException(Thread thread, Throwable th2) {
            ZLog.c("fatal", "uncaughtException() called with: Thread = [" + thread + "], Throwable = [" + ZLog.e(th2) + "]");
            if (!"FinalizerWatchdogDaemon".equals(thread.getName()) || !(th2 instanceof TimeoutException)) {
                this.f63274b.uncaughtException(thread, th2);
            }
        }
    }

    public class c implements Printer {
        public c() {
        }

        public void println(String str) {
            if (str.startsWith(">>>>> Dispatching")) {
                d.b().e();
            }
            if (str.startsWith("<<<<< Finished")) {
                d.b().d();
            }
        }
    }

    public static class d {

        /* renamed from: c  reason: collision with root package name */
        public static final d f63277c = new d();

        /* renamed from: a  reason: collision with root package name */
        public final Handler f63278a;

        /* renamed from: b  reason: collision with root package name */
        public final Runnable f63279b = i3.a.f55005b;

        public d() {
            HandlerThread handlerThread = new HandlerThread("main_anr");
            handlerThread.start();
            this.f63278a = new Handler(handlerThread.getLooper());
        }

        public static d b() {
            return f63277c;
        }

        public static /* synthetic */ void c() {
            StringBuilder sb2 = new StringBuilder();
            for (StackTraceElement stackTraceElement : Looper.getMainLooper().getThread().getStackTrace()) {
                sb2.append(stackTraceElement.toString());
                sb2.append("\n");
            }
            Log.e("main_anr", sb2.toString());
        }

        public void d() {
            this.f63278a.removeCallbacks(this.f63279b);
        }

        public void e() {
            this.f63278a.postDelayed(this.f63279b, 300);
        }
    }

    public void hookAfter(Object obj, Object[] objArr) {
        ZLog.b("App.attachBaseContext", "hookAfter() called with: activity = [" + obj + "], objects = [" + objArr + "]");
    }

    public void hookBefore(Object obj, Object[] objArr) {
        Class cls = f3.a.class;
        ZLog.b("App.attachBaseContext", "hookBefore() called with: classIns = [" + obj + "], objects = [" + objArr + "]");
        if (obj instanceof Application) {
            Application application = (Application) obj;
            if (!((f3.a) com.bbc876219.lib.spi.provider.a.e(cls)).b()) {
                new Handler(application.getMainLooper()).post(new a());
                Thread.setDefaultUncaughtExceptionHandler(new b(Thread.getDefaultUncaughtExceptionHandler()));
            }
            if (!((f3.a) com.bbc876219.lib.spi.provider.a.e(cls)).c()) {
                ZLog.c("App.attachBaseContext", "hookBefore: 非主线程,不启动anr监控");
            } else if (((f3.a) com.bbc876219.lib.spi.provider.a.e(cls)).b()) {
                Looper.getMainLooper().setMessageLogging(new c());
            }
        } else {
            ZLog.c("App.attachBaseContext", "hookBefore: classIns 不是 Application 的实例");
        }
    }

    public boolean isRunInMainThread() {
        return true;
    }
}
