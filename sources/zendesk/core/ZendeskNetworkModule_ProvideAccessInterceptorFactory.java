package zendesk.core;

import dagger.internal.b;
import dagger.internal.d;
import q00.a;

public final class ZendeskNetworkModule_ProvideAccessInterceptorFactory implements b<ZendeskAccessInterceptor> {
    private final a<AccessProvider> accessProvider;
    private final a<CoreSettingsStorage> coreSettingsStorageProvider;
    private final a<IdentityManager> identityManagerProvider;
    private final a<Storage> storageProvider;

    public ZendeskNetworkModule_ProvideAccessInterceptorFactory(a<IdentityManager> aVar, a<AccessProvider> aVar2, a<Storage> aVar3, a<CoreSettingsStorage> aVar4) {
        this.identityManagerProvider = aVar;
        this.accessProvider = aVar2;
        this.storageProvider = aVar3;
        this.coreSettingsStorageProvider = aVar4;
    }

    public static ZendeskNetworkModule_ProvideAccessInterceptorFactory create(a<IdentityManager> aVar, a<AccessProvider> aVar2, a<Storage> aVar3, a<CoreSettingsStorage> aVar4) {
        return new ZendeskNetworkModule_ProvideAccessInterceptorFactory(aVar, aVar2, aVar3, aVar4);
    }

    public static ZendeskAccessInterceptor provideAccessInterceptor(Object obj, Object obj2, Object obj3, Object obj4) {
        return (ZendeskAccessInterceptor) d.f(ZendeskNetworkModule.provideAccessInterceptor((IdentityManager) obj, (AccessProvider) obj2, (Storage) obj3, (CoreSettingsStorage) obj4));
    }

    public ZendeskAccessInterceptor get() {
        return provideAccessInterceptor(this.identityManagerProvider.get(), this.accessProvider.get(), this.storageProvider.get(), this.coreSettingsStorageProvider.get());
    }
}
