package zendesk.core;

import dagger.internal.b;
import dagger.internal.d;
import q00.a;

public final class ZendeskProvidersModule_ProviderBlipsCoreProviderFactory implements b<BlipsCoreProvider> {
    private final a<ZendeskBlipsProvider> zendeskBlipsProvider;

    public ZendeskProvidersModule_ProviderBlipsCoreProviderFactory(a<ZendeskBlipsProvider> aVar) {
        this.zendeskBlipsProvider = aVar;
    }

    public static ZendeskProvidersModule_ProviderBlipsCoreProviderFactory create(a<ZendeskBlipsProvider> aVar) {
        return new ZendeskProvidersModule_ProviderBlipsCoreProviderFactory(aVar);
    }

    public static BlipsCoreProvider providerBlipsCoreProvider(Object obj) {
        return (BlipsCoreProvider) d.f(ZendeskProvidersModule.providerBlipsCoreProvider((ZendeskBlipsProvider) obj));
    }

    public BlipsCoreProvider get() {
        return providerBlipsCoreProvider(this.zendeskBlipsProvider.get());
    }
}
