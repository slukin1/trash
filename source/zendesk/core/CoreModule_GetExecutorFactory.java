package zendesk.core;

import dagger.internal.b;
import dagger.internal.d;
import java.util.concurrent.Executor;

public final class CoreModule_GetExecutorFactory implements b<Executor> {
    private final CoreModule module;

    public CoreModule_GetExecutorFactory(CoreModule coreModule) {
        this.module = coreModule;
    }

    public static CoreModule_GetExecutorFactory create(CoreModule coreModule) {
        return new CoreModule_GetExecutorFactory(coreModule);
    }

    public static Executor getExecutor(CoreModule coreModule) {
        return (Executor) d.f(coreModule.getExecutor());
    }

    public Executor get() {
        return getExecutor(this.module);
    }
}
