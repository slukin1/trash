package i;

import androidx.arch.core.executor.DefaultTaskExecutor;
import androidx.arch.core.executor.TaskExecutor;
import java.util.concurrent.Executor;

public class a extends TaskExecutor {

    /* renamed from: c  reason: collision with root package name */
    public static volatile a f15934c;

    /* renamed from: d  reason: collision with root package name */
    public static final Executor f15935d = new C0084a();

    /* renamed from: e  reason: collision with root package name */
    public static final Executor f15936e = new b();

    /* renamed from: a  reason: collision with root package name */
    public TaskExecutor f15937a;

    /* renamed from: b  reason: collision with root package name */
    public TaskExecutor f15938b;

    /* renamed from: i.a$a  reason: collision with other inner class name */
    public static class C0084a implements Executor {
        public void execute(Runnable runnable) {
            a.e().c(runnable);
        }
    }

    public static class b implements Executor {
        public void execute(Runnable runnable) {
            a.e().a(runnable);
        }
    }

    public a() {
        DefaultTaskExecutor defaultTaskExecutor = new DefaultTaskExecutor();
        this.f15938b = defaultTaskExecutor;
        this.f15937a = defaultTaskExecutor;
    }

    public static Executor d() {
        return f15936e;
    }

    public static a e() {
        if (f15934c != null) {
            return f15934c;
        }
        synchronized (a.class) {
            if (f15934c == null) {
                f15934c = new a();
            }
        }
        return f15934c;
    }

    public void a(Runnable runnable) {
        this.f15937a.a(runnable);
    }

    public boolean b() {
        return this.f15937a.b();
    }

    public void c(Runnable runnable) {
        this.f15937a.c(runnable);
    }
}
