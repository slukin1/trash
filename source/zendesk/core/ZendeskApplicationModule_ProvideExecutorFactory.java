package zendesk.core;

import dagger.internal.b;
import dagger.internal.d;
import java.util.concurrent.ScheduledExecutorService;

public final class ZendeskApplicationModule_ProvideExecutorFactory implements b<ScheduledExecutorService> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final ZendeskApplicationModule_ProvideExecutorFactory INSTANCE = new ZendeskApplicationModule_ProvideExecutorFactory();

        private InstanceHolder() {
        }
    }

    public static ZendeskApplicationModule_ProvideExecutorFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static ScheduledExecutorService provideExecutor() {
        return (ScheduledExecutorService) d.f(ZendeskApplicationModule.provideExecutor());
    }

    public ScheduledExecutorService get() {
        return provideExecutor();
    }
}
