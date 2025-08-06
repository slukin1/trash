package zendesk.core;

import dagger.internal.b;
import dagger.internal.d;
import q00.a;

public final class ZendeskNetworkModule_ProvidePushInterceptorFactory implements b<ZendeskPushInterceptor> {
    private final a<IdentityStorage> identityStorageProvider;
    private final a<PushDeviceIdStorage> pushDeviceIdStorageProvider;
    private final a<PushRegistrationProviderInternal> pushProvider;

    public ZendeskNetworkModule_ProvidePushInterceptorFactory(a<PushRegistrationProviderInternal> aVar, a<PushDeviceIdStorage> aVar2, a<IdentityStorage> aVar3) {
        this.pushProvider = aVar;
        this.pushDeviceIdStorageProvider = aVar2;
        this.identityStorageProvider = aVar3;
    }

    public static ZendeskNetworkModule_ProvidePushInterceptorFactory create(a<PushRegistrationProviderInternal> aVar, a<PushDeviceIdStorage> aVar2, a<IdentityStorage> aVar3) {
        return new ZendeskNetworkModule_ProvidePushInterceptorFactory(aVar, aVar2, aVar3);
    }

    public static ZendeskPushInterceptor providePushInterceptor(Object obj, Object obj2, Object obj3) {
        return (ZendeskPushInterceptor) d.f(ZendeskNetworkModule.providePushInterceptor((PushRegistrationProviderInternal) obj, (PushDeviceIdStorage) obj2, (IdentityStorage) obj3));
    }

    public ZendeskPushInterceptor get() {
        return providePushInterceptor(this.pushProvider.get(), this.pushDeviceIdStorageProvider.get(), this.identityStorageProvider.get());
    }
}
