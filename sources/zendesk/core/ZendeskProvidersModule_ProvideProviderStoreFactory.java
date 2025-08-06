package zendesk.core;

import dagger.internal.b;
import dagger.internal.d;
import q00.a;

public final class ZendeskProvidersModule_ProvideProviderStoreFactory implements b<ProviderStore> {
    private final a<PushRegistrationProvider> pushRegistrationProvider;
    private final a<UserProvider> userProvider;

    public ZendeskProvidersModule_ProvideProviderStoreFactory(a<UserProvider> aVar, a<PushRegistrationProvider> aVar2) {
        this.userProvider = aVar;
        this.pushRegistrationProvider = aVar2;
    }

    public static ZendeskProvidersModule_ProvideProviderStoreFactory create(a<UserProvider> aVar, a<PushRegistrationProvider> aVar2) {
        return new ZendeskProvidersModule_ProvideProviderStoreFactory(aVar, aVar2);
    }

    public static ProviderStore provideProviderStore(UserProvider userProvider2, PushRegistrationProvider pushRegistrationProvider2) {
        return (ProviderStore) d.f(ZendeskProvidersModule.provideProviderStore(userProvider2, pushRegistrationProvider2));
    }

    public ProviderStore get() {
        return provideProviderStore(this.userProvider.get(), this.pushRegistrationProvider.get());
    }
}
