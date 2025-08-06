package androidx.core.os;

import android.os.Handler;
import androidx.core.util.h;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

public final class g {

    public static class a implements Executor {

        /* renamed from: b  reason: collision with root package name */
        public final Handler f8405b;

        public a(Handler handler) {
            this.f8405b = (Handler) h.g(handler);
        }

        public void execute(Runnable runnable) {
            if (!this.f8405b.post((Runnable) h.g(runnable))) {
                throw new RejectedExecutionException(this.f8405b + " is shutting down");
            }
        }
    }

    public static Executor a(Handler handler) {
        return new a(handler);
    }
}
