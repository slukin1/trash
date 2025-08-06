package zendesk.core;

import dagger.internal.b;
import dagger.internal.d;
import q00.a;

public final class ZendeskProvidersModule_ProviderBlipsProviderFactory implements b<BlipsProvider> {
    private final a<ZendeskBlipsProvider> zendeskBlipsProvider;

    public ZendeskProvidersModule_ProviderBlipsProviderFactory(a<ZendeskBlipsProvider> aVar) {
        this.zendeskBlipsProvider = aVar;
    }

    public static ZendeskProvidersModule_ProviderBlipsProviderFactory create(a<ZendeskBlipsProvider> aVar) {
        return new ZendeskProvidersModule_ProviderBlipsProviderFactory(aVar);
    }

    public static BlipsProvider providerBlipsProvider(Object obj) {
        return (BlipsProvider) d.f(ZendeskProvidersModule.providerBlipsProvider((ZendeskBlipsProvider) obj));
    }

    public BlipsProvider get() {
        return providerBlipsProvider(this.zendeskBlipsProvider.get());
    }
}
