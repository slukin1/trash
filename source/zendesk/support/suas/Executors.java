package zendesk.support.suas;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

class Executors {

    public static class AndroidExecutor implements Executor {
        private final Handler handler = new Handler(Looper.getMainLooper());

        public void execute(Runnable runnable) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                runnable.run();
            } else {
                this.handler.post(runnable);
            }
        }
    }

    public static class DefaultCurrentThreadExecutor implements Executor {
        public void execute(Runnable runnable) {
            runnable.run();
        }
    }

    public static Executor getAndroidExecutor() {
        return new AndroidExecutor();
    }

    public static Executor getDefaultExecutor() {
        return new DefaultCurrentThreadExecutor();
    }
}
