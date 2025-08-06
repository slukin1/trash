package fg;

import com.huawei.hmf.tasks.Task;
import eg.d;
import java.util.concurrent.Executor;

public final class c<TResult> implements eg.a<TResult> {

    /* renamed from: a  reason: collision with root package name */
    public d<TResult> f40498a;

    /* renamed from: b  reason: collision with root package name */
    public Executor f40499b;

    /* renamed from: c  reason: collision with root package name */
    public final Object f40500c = new Object();

    public class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Task f40501b;

        public a(Task task) {
            this.f40501b = task;
        }

        public final void run() {
            synchronized (c.this.f40500c) {
                if (c.this.f40498a != null) {
                    c.this.f40498a.onSuccess(this.f40501b.e());
                }
            }
        }
    }

    public c(Executor executor, d<TResult> dVar) {
        this.f40498a = dVar;
        this.f40499b = executor;
    }

    public final void cancel() {
        synchronized (this.f40500c) {
            this.f40498a = null;
        }
    }

    public final void onComplete(Task<TResult> task) {
        if (task.h() && !task.f()) {
            this.f40499b.execute(new a(task));
        }
    }
}
