package zendesk.support;

import dagger.internal.b;
import dagger.internal.d;

public final class SupportModule_ProvidesSettingsProviderFactory implements b<SupportSettingsProvider> {
    private final SupportModule module;

    public SupportModule_ProvidesSettingsProviderFactory(SupportModule supportModule) {
        this.module = supportModule;
    }

    public static SupportModule_ProvidesSettingsProviderFactory create(SupportModule supportModule) {
        return new SupportModule_ProvidesSettingsProviderFactory(supportModule);
    }

    public static SupportSettingsProvider providesSettingsProvider(SupportModule supportModule) {
        return (SupportSettingsProvider) d.f(supportModule.providesSettingsProvider());
    }

    public SupportSettingsProvider get() {
        return providesSettingsProvider(this.module);
    }
}
