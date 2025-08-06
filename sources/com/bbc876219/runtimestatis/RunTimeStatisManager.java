package com.bbc876219.runtimestatis;

import android.app.Application;
import android.os.Looper;
import androidx.annotation.Keep;
import com.bbc876219.lib.zlog.ZLog;
import j3.a;

@Keep
public class RunTimeStatisManager {
    private static final String TAG = "runtimestatis";
    private static IRunTimeStatisHandler iRunTimeStatisHandler = IRunTimeStatisHandler.DEFAULT;
    private static long times = System.currentTimeMillis();

    public static void clear() {
        iRunTimeStatisHandler.clear();
        times = System.currentTimeMillis();
    }

    public static void dump() {
        iRunTimeStatisHandler.dump();
        ZLog.c(TAG, "dump() called  use time=" + (System.currentTimeMillis() - times));
    }

    public static void installBlockManager(Application application, IRunTimeStatisHandler iRunTimeStatisHandler2) {
        iRunTimeStatisHandler = iRunTimeStatisHandler2;
        application.registerActivityLifecycleCallbacks(new RunTimeStatisActivityLifecycleListener());
    }

    private static boolean isStatisticSubThread() {
        return iRunTimeStatisHandler.isStatisticSubThread();
    }

    public static void statisticMethod(String str, long j11) {
        if (iRunTimeStatisHandler == null) {
            iRunTimeStatisHandler = new a(50);
            ZLog.b(TAG, "statisticMethod() called with: method = [" + str + "], cost = [" + j11 + "],iRunTimeStatisHandler=" + iRunTimeStatisHandler);
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            iRunTimeStatisHandler.statisticMethod(str, (int) j11);
        } else if (!isStatisticSubThread()) {
        } else {
            if (ZLog.f63264a) {
                iRunTimeStatisHandler.statisticMethod(str, (int) j11);
                return;
            }
            IRunTimeStatisHandler iRunTimeStatisHandler2 = iRunTimeStatisHandler;
            iRunTimeStatisHandler2.statisticMethod("[" + Thread.currentThread().getName() + "]" + str, (int) j11);
        }
    }
}
