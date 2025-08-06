package fs;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class a {

    /* renamed from: e  reason: collision with root package name */
    public static volatile a f84130e;

    /* renamed from: f  reason: collision with root package name */
    public static final int f84131f;

    /* renamed from: g  reason: collision with root package name */
    public static final int f84132g;

    /* renamed from: h  reason: collision with root package name */
    public static final int f84133h;

    /* renamed from: a  reason: collision with root package name */
    public ThreadPoolExecutor f84134a;

    /* renamed from: b  reason: collision with root package name */
    public ExecutorService f84135b = Executors.newCachedThreadPool(Executors.defaultThreadFactory());

    /* renamed from: c  reason: collision with root package name */
    public final BlockingQueue<Runnable> f84136c;

    /* renamed from: d  reason: collision with root package name */
    public final RejectedExecutionHandler f84137d;

    /* renamed from: fs.a$a  reason: collision with other inner class name */
    public class C0863a implements RejectedExecutionHandler {
        public C0863a() {
        }

        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            Executors.newCachedThreadPool().execute(runnable);
        }
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f84131f = availableProcessors;
        int max = Math.max(2, Math.min(availableProcessors - 1, 5));
        f84132g = max;
        f84133h = max;
    }

    public a() {
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        this.f84136c = linkedBlockingQueue;
        C0863a aVar = new C0863a();
        this.f84137d = aVar;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(f84132g, f84133h, 5, TimeUnit.SECONDS, linkedBlockingQueue, Executors.defaultThreadFactory(), aVar);
        this.f84134a = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(true);
    }

    public static a c() {
        if (f84130e == null) {
            synchronized (a.class) {
                if (f84130e == null) {
                    f84130e = new a();
                }
            }
        }
        return f84130e;
    }

    public ThreadPoolExecutor a() {
        return this.f84134a;
    }

    public ExecutorService b() {
        return this.f84135b;
    }
}
