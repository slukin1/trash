package androidx.arch.core.executor;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class DefaultTaskExecutor extends TaskExecutor {

    /* renamed from: a  reason: collision with root package name */
    public final Object f4736a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public final ExecutorService f4737b = Executors.newFixedThreadPool(4, new a());

    /* renamed from: c  reason: collision with root package name */
    public volatile Handler f4738c;

    public class a implements ThreadFactory {

        /* renamed from: b  reason: collision with root package name */
        public final AtomicInteger f4739b = new AtomicInteger(0);

        public a() {
        }

        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName(String.format("arch_disk_io_%d", new Object[]{Integer.valueOf(this.f4739b.getAndIncrement())}));
            return thread;
        }
    }

    public static Handler d(Looper looper) {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 28) {
            return Handler.createAsync(looper);
        }
        if (i11 >= 16) {
            Class<Handler> cls = Handler.class;
            try {
                return cls.getDeclaredConstructor(new Class[]{Looper.class, Handler.Callback.class, Boolean.TYPE}).newInstance(new Object[]{looper, null, Boolean.TRUE});
            } catch (IllegalAccessException | InstantiationException | NoSuchMethodException unused) {
            } catch (InvocationTargetException unused2) {
                return new Handler(looper);
            }
        }
        return new Handler(looper);
    }

    public void a(Runnable runnable) {
        this.f4737b.execute(runnable);
    }

    public boolean b() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    public void c(Runnable runnable) {
        if (this.f4738c == null) {
            synchronized (this.f4736a) {
                if (this.f4738c == null) {
                    this.f4738c = d(Looper.getMainLooper());
                }
            }
        }
        this.f4738c.post(runnable);
    }
}
