package com.tencent.wxop.stat;

import com.tencent.wxop.stat.a.c;
import java.lang.Thread;

final class n implements Thread.UncaughtExceptionHandler {
    public final void uncaughtException(Thread thread, Throwable th2) {
        if (c.l() && e.aY != null) {
            if (c.x()) {
                t.s(e.aY).b(new c(e.aY, e.a(e.aY, false, (f) null), th2, thread), (aj) null, false, true);
                e.aV.debug("MTA has caught the following uncaught exception:");
                e.aV.a(th2);
            }
            e.p(e.aY);
            if (e.aW != null) {
                e.aV.e("Call the original uncaught exception handler.");
                if (!(e.aW instanceof n)) {
                    e.aW.uncaughtException(thread, th2);
                }
            }
        }
    }
}
