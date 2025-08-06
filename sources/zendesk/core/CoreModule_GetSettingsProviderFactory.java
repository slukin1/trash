package zendesk.core;

import dagger.internal.b;
import dagger.internal.d;

public final class CoreModule_GetSettingsProviderFactory implements b<SettingsProvider> {
    private final CoreModule module;

    public CoreModule_GetSettingsProviderFactory(CoreModule coreModule) {
        this.module = coreModule;
    }

    public static CoreModule_GetSettingsProviderFactory create(CoreModule coreModule) {
        return new CoreModule_GetSettingsProviderFactory(coreModule);
    }

    public static SettingsProvider getSettingsProvider(CoreModule coreModule) {
        return (SettingsProvider) d.f(coreModule.getSettingsProvider());
    }

    public SettingsProvider get() {
        return getSettingsProvider(this.module);
    }
}
