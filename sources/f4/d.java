package f4;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final Executor f66252a = new a();

    /* renamed from: b  reason: collision with root package name */
    public static final Executor f66253b = new b();

    public class a implements Executor {

        /* renamed from: b  reason: collision with root package name */
        public final Handler f66254b = new Handler(Looper.getMainLooper());

        public void execute(Runnable runnable) {
            this.f66254b.post(runnable);
        }
    }

    public class b implements Executor {
        public void execute(Runnable runnable) {
            runnable.run();
        }
    }

    public static Executor a() {
        return f66253b;
    }

    public static Executor b() {
        return f66252a;
    }
}
