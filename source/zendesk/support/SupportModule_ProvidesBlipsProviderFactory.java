package zendesk.support;

import dagger.internal.b;
import dagger.internal.d;

public final class SupportModule_ProvidesBlipsProviderFactory implements b<SupportBlipsProvider> {
    private final SupportModule module;

    public SupportModule_ProvidesBlipsProviderFactory(SupportModule supportModule) {
        this.module = supportModule;
    }

    public static SupportModule_ProvidesBlipsProviderFactory create(SupportModule supportModule) {
        return new SupportModule_ProvidesBlipsProviderFactory(supportModule);
    }

    public static SupportBlipsProvider providesBlipsProvider(SupportModule supportModule) {
        return (SupportBlipsProvider) d.f(supportModule.providesBlipsProvider());
    }

    public SupportBlipsProvider get() {
        return providesBlipsProvider(this.module);
    }
}
