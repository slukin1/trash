package y1;

import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public final class c {

    /* renamed from: d  reason: collision with root package name */
    public static final c f16820d = new c();

    /* renamed from: a  reason: collision with root package name */
    public final ExecutorService f16821a;

    /* renamed from: b  reason: collision with root package name */
    public final ScheduledExecutorService f16822b;

    /* renamed from: c  reason: collision with root package name */
    public final Executor f16823c;

    public static class b implements Executor {

        /* renamed from: b  reason: collision with root package name */
        public ThreadLocal<Integer> f16824b;

        public b() {
            this.f16824b = new ThreadLocal<>();
        }

        public final int a() {
            Integer num = this.f16824b.get();
            if (num == null) {
                num = 0;
            }
            int intValue = num.intValue() - 1;
            if (intValue == 0) {
                this.f16824b.remove();
            } else {
                this.f16824b.set(Integer.valueOf(intValue));
            }
            return intValue;
        }

        public final int b() {
            Integer num = this.f16824b.get();
            if (num == null) {
                num = 0;
            }
            int intValue = num.intValue() + 1;
            this.f16824b.set(Integer.valueOf(intValue));
            return intValue;
        }

        public void execute(Runnable runnable) {
            if (b() <= 15) {
                try {
                    runnable.run();
                } catch (Throwable th2) {
                    a();
                    throw th2;
                }
            } else {
                c.a().execute(runnable);
            }
            a();
        }
    }

    public c() {
        this.f16821a = !c() ? Executors.newCachedThreadPool() : a.b();
        this.f16822b = Executors.newSingleThreadScheduledExecutor();
        this.f16823c = new b();
    }

    public static ExecutorService a() {
        return f16820d.f16821a;
    }

    public static Executor b() {
        return f16820d.f16823c;
    }

    public static boolean c() {
        String property = System.getProperty("java.runtime.name");
        if (property == null) {
            return false;
        }
        return property.toLowerCase(Locale.US).contains("android");
    }

    public static ScheduledExecutorService d() {
        return f16820d.f16822b;
    }
}
