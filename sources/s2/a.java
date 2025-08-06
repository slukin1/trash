package s2;

import java.util.concurrent.ThreadFactory;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final ThreadFactory f16501a = new C0101a();

    /* renamed from: s2.a$a  reason: collision with other inner class name */
    public class C0101a implements ThreadFactory {
        public C0101a() {
        }

        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, "report_thread");
            thread.setDaemon(false);
            thread.setUncaughtExceptionHandler(new com.alibaba.sdk.android.httpdns.d.a());
            return thread;
        }
    }
}
