package y0;

import android.os.Handler;
import android.os.Process;
import androidx.core.util.Consumer;
import com.iproov.sdk.bridge.OptionsBridge;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class d {

    public static class a implements ThreadFactory {

        /* renamed from: b  reason: collision with root package name */
        public String f16799b;

        /* renamed from: c  reason: collision with root package name */
        public int f16800c;

        /* renamed from: y0.d$a$a  reason: collision with other inner class name */
        public static class C0111a extends Thread {

            /* renamed from: b  reason: collision with root package name */
            public final int f16801b;

            public C0111a(Runnable runnable, String str, int i11) {
                super(runnable, str);
                this.f16801b = i11;
            }

            public void run() {
                Process.setThreadPriority(this.f16801b);
                super.run();
            }
        }

        public a(String str, int i11) {
            this.f16799b = str;
            this.f16800c = i11;
        }

        public Thread newThread(Runnable runnable) {
            return new C0111a(runnable, this.f16799b, this.f16800c);
        }
    }

    public static class b<T> implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public Callable<T> f16802b;

        /* renamed from: c  reason: collision with root package name */
        public Consumer<T> f16803c;

        /* renamed from: d  reason: collision with root package name */
        public Handler f16804d;

        public class a implements Runnable {

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ Consumer f16805b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ Object f16806c;

            public a(Consumer consumer, Object obj) {
                this.f16805b = consumer;
                this.f16806c = obj;
            }

            public void run() {
                this.f16805b.accept(this.f16806c);
            }
        }

        public b(Handler handler, Callable<T> callable, Consumer<T> consumer) {
            this.f16802b = callable;
            this.f16803c = consumer;
            this.f16804d = handler;
        }

        public void run() {
            T t11;
            try {
                t11 = this.f16802b.call();
            } catch (Exception unused) {
                t11 = null;
            }
            this.f16804d.post(new a(this.f16803c, t11));
        }
    }

    public static ThreadPoolExecutor a(String str, int i11, int i12) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, (long) i12, TimeUnit.MILLISECONDS, new LinkedBlockingDeque(), new a(str, i11));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }

    public static <T> void b(Executor executor, Callable<T> callable, Consumer<T> consumer) {
        executor.execute(new b(a.a(), callable, consumer));
    }

    public static <T> T c(ExecutorService executorService, Callable<T> callable, int i11) throws InterruptedException {
        try {
            return executorService.submit(callable).get((long) i11, TimeUnit.MILLISECONDS);
        } catch (ExecutionException e11) {
            throw new RuntimeException(e11);
        } catch (InterruptedException e12) {
            throw e12;
        } catch (TimeoutException unused) {
            throw new InterruptedException(OptionsBridge.TIMEOUT_KEY);
        }
    }
}
