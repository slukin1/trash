package zendesk.core;

import dagger.internal.b;
import dagger.internal.d;
import q00.a;

public final class ZendeskProvidersModule_ProvideAccessProviderFactory implements b<AccessProvider> {
    private final a<AccessService> accessServiceProvider;
    private final a<IdentityManager> identityManagerProvider;

    public ZendeskProvidersModule_ProvideAccessProviderFactory(a<IdentityManager> aVar, a<AccessService> aVar2) {
        this.identityManagerProvider = aVar;
        this.accessServiceProvider = aVar2;
    }

    public static ZendeskProvidersModule_ProvideAccessProviderFactory create(a<IdentityManager> aVar, a<AccessService> aVar2) {
        return new ZendeskProvidersModule_ProvideAccessProviderFactory(aVar, aVar2);
    }

    public static AccessProvider provideAccessProvider(Object obj, Object obj2) {
        return (AccessProvider) d.f(ZendeskProvidersModule.provideAccessProvider((IdentityManager) obj, (AccessService) obj2));
    }

    public AccessProvider get() {
        return provideAccessProvider(this.identityManagerProvider.get(), this.accessServiceProvider.get());
    }
}
