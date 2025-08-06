package eg;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

public final class e {

    /* renamed from: d  reason: collision with root package name */
    public static final e f40479d = new e();

    /* renamed from: a  reason: collision with root package name */
    public final Executor f40480a = new a();

    /* renamed from: b  reason: collision with root package name */
    public final ExecutorService f40481b = com.huawei.hmf.tasks.a.a.a();

    /* renamed from: c  reason: collision with root package name */
    public final Executor f40482c = com.huawei.hmf.tasks.a.a.b();

    public static final class a implements Executor {
        public final void execute(Runnable runnable) {
            runnable.run();
        }
    }

    public static ExecutorService a() {
        return f40479d.f40481b;
    }

    public static Executor b() {
        return f40479d.f40482c;
    }
}
