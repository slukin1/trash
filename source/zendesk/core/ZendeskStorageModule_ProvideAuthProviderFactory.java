package zendesk.core;

import dagger.internal.b;
import dagger.internal.d;
import q00.a;

public final class ZendeskStorageModule_ProvideAuthProviderFactory implements b<AuthenticationProvider> {
    private final a<IdentityManager> identityManagerProvider;

    public ZendeskStorageModule_ProvideAuthProviderFactory(a<IdentityManager> aVar) {
        this.identityManagerProvider = aVar;
    }

    public static ZendeskStorageModule_ProvideAuthProviderFactory create(a<IdentityManager> aVar) {
        return new ZendeskStorageModule_ProvideAuthProviderFactory(aVar);
    }

    public static AuthenticationProvider provideAuthProvider(Object obj) {
        return (AuthenticationProvider) d.f(ZendeskStorageModule.provideAuthProvider((IdentityManager) obj));
    }

    public AuthenticationProvider get() {
        return provideAuthProvider(this.identityManagerProvider.get());
    }
}
