package com.huawei.hmf.tasks;

import com.huawei.hmf.tasks.a.j;
import eg.e;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

public class Tasks {

    /* renamed from: a  reason: collision with root package name */
    public static j f37633a = new j();

    public static <TResult> TResult a(Task<TResult> task) throws ExecutionException, InterruptedException {
        j.c("await must not be called on the UI thread");
        if (task.g()) {
            return j.b(task);
        }
        j.a aVar = new j.a();
        task.c(aVar).b(aVar);
        aVar.f37650a.await();
        return j.b(task);
    }

    public static <TResult> Task<TResult> b(Callable<TResult> callable) {
        return f37633a.a(e.a(), callable);
    }
}
