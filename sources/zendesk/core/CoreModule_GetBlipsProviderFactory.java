package zendesk.core;

import dagger.internal.b;
import dagger.internal.d;

public final class CoreModule_GetBlipsProviderFactory implements b<BlipsProvider> {
    private final CoreModule module;

    public CoreModule_GetBlipsProviderFactory(CoreModule coreModule) {
        this.module = coreModule;
    }

    public static CoreModule_GetBlipsProviderFactory create(CoreModule coreModule) {
        return new CoreModule_GetBlipsProviderFactory(coreModule);
    }

    public static BlipsProvider getBlipsProvider(CoreModule coreModule) {
        return (BlipsProvider) d.f(coreModule.getBlipsProvider());
    }

    public BlipsProvider get() {
        return getBlipsProvider(this.module);
    }
}
