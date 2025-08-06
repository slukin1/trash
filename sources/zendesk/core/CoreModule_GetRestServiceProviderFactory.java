package zendesk.core;

import dagger.internal.b;
import dagger.internal.d;

public final class CoreModule_GetRestServiceProviderFactory implements b<RestServiceProvider> {
    private final CoreModule module;

    public CoreModule_GetRestServiceProviderFactory(CoreModule coreModule) {
        this.module = coreModule;
    }

    public static CoreModule_GetRestServiceProviderFactory create(CoreModule coreModule) {
        return new CoreModule_GetRestServiceProviderFactory(coreModule);
    }

    public static RestServiceProvider getRestServiceProvider(CoreModule coreModule) {
        return (RestServiceProvider) d.f(coreModule.getRestServiceProvider());
    }

    public RestServiceProvider get() {
        return getRestServiceProvider(this.module);
    }
}
