package zendesk.core;

import dagger.internal.b;
import dagger.internal.d;

public final class ZendeskApplicationModule_ProvideApplicationConfigurationFactory implements b<ApplicationConfiguration> {
    private final ZendeskApplicationModule module;

    public ZendeskApplicationModule_ProvideApplicationConfigurationFactory(ZendeskApplicationModule zendeskApplicationModule) {
        this.module = zendeskApplicationModule;
    }

    public static ZendeskApplicationModule_ProvideApplicationConfigurationFactory create(ZendeskApplicationModule zendeskApplicationModule) {
        return new ZendeskApplicationModule_ProvideApplicationConfigurationFactory(zendeskApplicationModule);
    }

    public static ApplicationConfiguration provideApplicationConfiguration(ZendeskApplicationModule zendeskApplicationModule) {
        return (ApplicationConfiguration) d.f(zendeskApplicationModule.provideApplicationConfiguration());
    }

    public ApplicationConfiguration get() {
        return provideApplicationConfiguration(this.module);
    }
}
