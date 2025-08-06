package androidx.test.espresso.core.internal.deps.guava.util.concurrent;

import java.util.concurrent.Executor;

public final class MoreExecutors {
    public static Executor a() {
        return DirectExecutor.INSTANCE;
    }
}
