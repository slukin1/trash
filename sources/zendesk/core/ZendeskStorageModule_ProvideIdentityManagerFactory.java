package zendesk.core;

import dagger.internal.b;
import dagger.internal.d;
import q00.a;

public final class ZendeskStorageModule_ProvideIdentityManagerFactory implements b<IdentityManager> {
    private final a<IdentityStorage> identityStorageProvider;

    public ZendeskStorageModule_ProvideIdentityManagerFactory(a<IdentityStorage> aVar) {
        this.identityStorageProvider = aVar;
    }

    public static ZendeskStorageModule_ProvideIdentityManagerFactory create(a<IdentityStorage> aVar) {
        return new ZendeskStorageModule_ProvideIdentityManagerFactory(aVar);
    }

    public static IdentityManager provideIdentityManager(Object obj) {
        return (IdentityManager) d.f(ZendeskStorageModule.provideIdentityManager((IdentityStorage) obj));
    }

    public IdentityManager get() {
        return provideIdentityManager(this.identityStorageProvider.get());
    }
}
