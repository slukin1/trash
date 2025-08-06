package zendesk.core;

import dagger.internal.b;
import dagger.internal.d;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import q00.a;

public final class ZendeskApplicationModule_ProvideExecutorServiceFactory implements b<ExecutorService> {
    private final a<ScheduledExecutorService> scheduledExecutorServiceProvider;

    public ZendeskApplicationModule_ProvideExecutorServiceFactory(a<ScheduledExecutorService> aVar) {
        this.scheduledExecutorServiceProvider = aVar;
    }

    public static ZendeskApplicationModule_ProvideExecutorServiceFactory create(a<ScheduledExecutorService> aVar) {
        return new ZendeskApplicationModule_ProvideExecutorServiceFactory(aVar);
    }

    public static ExecutorService provideExecutorService(ScheduledExecutorService scheduledExecutorService) {
        return (ExecutorService) d.f(ZendeskApplicationModule.provideExecutorService(scheduledExecutorService));
    }

    public ExecutorService get() {
        return provideExecutorService(this.scheduledExecutorServiceProvider.get());
    }
}
