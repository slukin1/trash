package jumio.core;

import com.jumio.analytics.Analytics;
import com.jumio.analytics.MobileEvents;
import com.jumio.commons.log.Log;
import java.lang.Thread;

public final class e1 implements Thread.UncaughtExceptionHandler {

    /* renamed from: a  reason: collision with root package name */
    public final Thread.UncaughtExceptionHandler f56182a;

    public e1(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.f56182a = uncaughtExceptionHandler;
        Class<?> cls = uncaughtExceptionHandler != null ? uncaughtExceptionHandler.getClass() : null;
        Log.v("Wrapping handler :" + cls);
    }

    public final void uncaughtException(Thread thread, Throwable th2) {
        if (th2 instanceof Exception) {
            Log.d("uncaught exception: " + th2);
            Analytics.Companion companion = Analytics.Companion;
            companion.add(MobileEvents.exception((Exception) th2));
            companion.add(MobileEvents.lifecycle$default(q1.ABORTED, (Object) null, 2, (Object) null));
            companion.flush();
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f56182a;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th2);
        }
    }
}
