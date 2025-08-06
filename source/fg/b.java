package fg;

import com.huawei.hmf.tasks.Task;
import eg.c;
import java.util.concurrent.Executor;

public final class b<TResult> implements eg.a<TResult> {

    /* renamed from: a  reason: collision with root package name */
    public c f40493a;

    /* renamed from: b  reason: collision with root package name */
    public Executor f40494b;

    /* renamed from: c  reason: collision with root package name */
    public final Object f40495c = new Object();

    public class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Task f40496b;

        public a(Task task) {
            this.f40496b = task;
        }

        public final void run() {
            synchronized (b.this.f40495c) {
                if (b.this.f40493a != null) {
                    b.this.f40493a.onFailure(this.f40496b.d());
                }
            }
        }
    }

    public b(Executor executor, c cVar) {
        this.f40493a = cVar;
        this.f40494b = executor;
    }

    public final void cancel() {
        synchronized (this.f40495c) {
            this.f40493a = null;
        }
    }

    public final void onComplete(Task<TResult> task) {
        if (!task.h() && !task.f()) {
            this.f40494b.execute(new a(task));
        }
    }
}
