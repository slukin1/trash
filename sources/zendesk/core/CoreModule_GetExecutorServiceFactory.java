package zendesk.core;

import dagger.internal.b;
import dagger.internal.d;
import java.util.concurrent.ExecutorService;

public final class CoreModule_GetExecutorServiceFactory implements b<ExecutorService> {
    private final CoreModule module;

    public CoreModule_GetExecutorServiceFactory(CoreModule coreModule) {
        this.module = coreModule;
    }

    public static CoreModule_GetExecutorServiceFactory create(CoreModule coreModule) {
        return new CoreModule_GetExecutorServiceFactory(coreModule);
    }

    public static ExecutorService getExecutorService(CoreModule coreModule) {
        return (ExecutorService) d.f(coreModule.getExecutorService());
    }

    public ExecutorService get() {
        return getExecutorService(this.module);
    }
}
