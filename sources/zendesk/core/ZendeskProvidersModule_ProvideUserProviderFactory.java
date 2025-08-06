package zendesk.core;

import dagger.internal.b;
import dagger.internal.d;
import q00.a;

public final class ZendeskProvidersModule_ProvideUserProviderFactory implements b<UserProvider> {
    private final a<UserService> userServiceProvider;

    public ZendeskProvidersModule_ProvideUserProviderFactory(a<UserService> aVar) {
        this.userServiceProvider = aVar;
    }

    public static ZendeskProvidersModule_ProvideUserProviderFactory create(a<UserService> aVar) {
        return new ZendeskProvidersModule_ProvideUserProviderFactory(aVar);
    }

    public static UserProvider provideUserProvider(Object obj) {
        return (UserProvider) d.f(ZendeskProvidersModule.provideUserProvider((UserService) obj));
    }

    public UserProvider get() {
        return provideUserProvider(this.userServiceProvider.get());
    }
}
