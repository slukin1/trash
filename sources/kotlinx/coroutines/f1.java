package kotlinx.coroutines;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

public final class f1 {
    public static final CoroutineDispatcher a(Executor executor) {
        CoroutineDispatcher coroutineDispatcher;
        u0 u0Var = executor instanceof u0 ? (u0) executor : null;
        return (u0Var == null || (coroutineDispatcher = u0Var.f57568b) == null) ? new e1(executor) : coroutineDispatcher;
    }

    public static final ExecutorCoroutineDispatcher b(ExecutorService executorService) {
        return new e1(executorService);
    }
}
