package fg;

import com.huawei.hmf.tasks.Task;
import eg.b;
import java.util.concurrent.Executor;

public final class a<TResult> implements eg.a<TResult> {

    /* renamed from: a  reason: collision with root package name */
    public b<TResult> f40488a;

    /* renamed from: b  reason: collision with root package name */
    public Executor f40489b;

    /* renamed from: c  reason: collision with root package name */
    public final Object f40490c = new Object();

    /* renamed from: fg.a$a  reason: collision with other inner class name */
    public class C0547a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Task f40491b;

        public C0547a(Task task) {
            this.f40491b = task;
        }

        public final void run() {
            synchronized (a.this.f40490c) {
                if (a.this.f40488a != null) {
                    a.this.f40488a.onComplete(this.f40491b);
                }
            }
        }
    }

    public a(Executor executor, b<TResult> bVar) {
        this.f40488a = bVar;
        this.f40489b = executor;
    }

    public final void cancel() {
        synchronized (this.f40490c) {
            this.f40488a = null;
        }
    }

    public final void onComplete(Task<TResult> task) {
        this.f40489b.execute(new C0547a(task));
    }
}
