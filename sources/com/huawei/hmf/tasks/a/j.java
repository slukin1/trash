package com.huawei.hmf.tasks.a;

import android.os.Looper;
import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.TaskCompletionSource;
import eg.c;
import eg.d;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

public final class j {

    public static class a<TResult> implements c, d<TResult> {

        /* renamed from: a  reason: collision with root package name */
        public final CountDownLatch f37650a = new CountDownLatch(1);

        public final void onFailure(Exception exc) {
            this.f37650a.countDown();
        }

        public final void onSuccess(TResult tresult) {
            this.f37650a.countDown();
        }
    }

    public class b implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ TaskCompletionSource f37651b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Callable f37652c;

        public b(TaskCompletionSource taskCompletionSource, Callable callable) {
            this.f37651b = taskCompletionSource;
            this.f37652c = callable;
        }

        public final void run() {
            try {
                this.f37651b.d(this.f37652c.call());
            } catch (Exception e11) {
                this.f37651b.c(e11);
            }
        }
    }

    public static <TResult> TResult b(Task<TResult> task) throws ExecutionException {
        if (task.h()) {
            return task.e();
        }
        throw new ExecutionException(task.d());
    }

    public static void c(String str) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException(str);
        }
    }

    public final <TResult> Task<TResult> a(Executor executor, Callable<TResult> callable) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        try {
            executor.execute(new b(taskCompletionSource, callable));
        } catch (Exception e11) {
            taskCompletionSource.c(e11);
        }
        return taskCompletionSource.b();
    }
}
