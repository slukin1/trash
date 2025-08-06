package kotlinx.coroutines.tasks;

import java.util.concurrent.Executor;

public final class a implements Executor {

    /* renamed from: b  reason: collision with root package name */
    public static final a f57567b = new a();

    public void execute(Runnable runnable) {
        runnable.run();
    }
}
