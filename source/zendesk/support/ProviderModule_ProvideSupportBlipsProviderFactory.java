package zendesk.support;

import dagger.internal.b;
import dagger.internal.d;
import q00.a;
import zendesk.core.BlipsProvider;

public final class ProviderModule_ProvideSupportBlipsProviderFactory implements b<SupportBlipsProvider> {
    private final a<BlipsProvider> blipsProvider;
    private final ProviderModule module;

    public ProviderModule_ProvideSupportBlipsProviderFactory(ProviderModule providerModule, a<BlipsProvider> aVar) {
        this.module = providerModule;
        this.blipsProvider = aVar;
    }

    public static ProviderModule_ProvideSupportBlipsProviderFactory create(ProviderModule providerModule, a<BlipsProvider> aVar) {
        return new ProviderModule_ProvideSupportBlipsProviderFactory(providerModule, aVar);
    }

    public static SupportBlipsProvider provideSupportBlipsProvider(ProviderModule providerModule, BlipsProvider blipsProvider2) {
        return (SupportBlipsProvider) d.f(providerModule.provideSupportBlipsProvider(blipsProvider2));
    }

    public SupportBlipsProvider get() {
        return provideSupportBlipsProvider(this.module, this.blipsProvider.get());
    }
}
