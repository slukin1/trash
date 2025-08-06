package zendesk.core;

import dagger.internal.b;
import dagger.internal.d;
import java.util.concurrent.ScheduledExecutorService;

public final class CoreModule_GetScheduledExecutorServiceFactory implements b<ScheduledExecutorService> {
    private final CoreModule module;

    public CoreModule_GetScheduledExecutorServiceFactory(CoreModule coreModule) {
        this.module = coreModule;
    }

    public static CoreModule_GetScheduledExecutorServiceFactory create(CoreModule coreModule) {
        return new CoreModule_GetScheduledExecutorServiceFactory(coreModule);
    }

    public static ScheduledExecutorService getScheduledExecutorService(CoreModule coreModule) {
        return (ScheduledExecutorService) d.f(coreModule.getScheduledExecutorService());
    }

    public ScheduledExecutorService get() {
        return getScheduledExecutorService(this.module);
    }
}
