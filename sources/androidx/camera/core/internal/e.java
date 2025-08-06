package androidx.camera.core.internal;

import java.util.concurrent.Executor;

public final /* synthetic */ class e {
    public static Executor a(ThreadConfig threadConfig) {
        return (Executor) threadConfig.retrieveOption(ThreadConfig.OPTION_BACKGROUND_EXECUTOR);
    }

    public static Executor b(ThreadConfig threadConfig, Executor executor) {
        return (Executor) threadConfig.retrieveOption(ThreadConfig.OPTION_BACKGROUND_EXECUTOR, executor);
    }
}
