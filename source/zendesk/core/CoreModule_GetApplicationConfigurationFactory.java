package zendesk.core;

import dagger.internal.b;
import dagger.internal.d;

public final class CoreModule_GetApplicationConfigurationFactory implements b<ApplicationConfiguration> {
    private final CoreModule module;

    public CoreModule_GetApplicationConfigurationFactory(CoreModule coreModule) {
        this.module = coreModule;
    }

    public static CoreModule_GetApplicationConfigurationFactory create(CoreModule coreModule) {
        return new CoreModule_GetApplicationConfigurationFactory(coreModule);
    }

    public static ApplicationConfiguration getApplicationConfiguration(CoreModule coreModule) {
        return (ApplicationConfiguration) d.f(coreModule.getApplicationConfiguration());
    }

    public ApplicationConfiguration get() {
        return getApplicationConfiguration(this.module);
    }
}
