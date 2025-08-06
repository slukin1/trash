package com.alibaba.sdk.android.httpdns.d;

import com.alibaba.sdk.android.httpdns.log.HttpDnsLog;
import java.lang.Thread;
import s2.b;

public class a implements Thread.UncaughtExceptionHandler {
    public final void a(Throwable th2) {
        b a11 = b.a();
        if (a11 != null) {
            a11.h(th2.getMessage());
        }
    }

    public void uncaughtException(Thread thread, Throwable th2) {
        try {
            HttpDnsLog.d("Catch an uncaught exception, " + thread.getName() + ", error message: " + th2.getMessage(), th2);
            a(th2);
            th2.printStackTrace();
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }
}
