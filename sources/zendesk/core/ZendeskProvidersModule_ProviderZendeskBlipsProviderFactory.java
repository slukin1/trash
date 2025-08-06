package zendesk.core;

import dagger.internal.b;
import dagger.internal.d;
import java.util.concurrent.ExecutorService;
import q00.a;

public final class ZendeskProvidersModule_ProviderZendeskBlipsProviderFactory implements b<ZendeskBlipsProvider> {
    private final a<ApplicationConfiguration> applicationConfigurationProvider;
    private final a<BlipsService> blipsServiceProvider;
    private final a<CoreSettingsStorage> coreSettingsStorageProvider;
    private final a<DeviceInfo> deviceInfoProvider;
    private final a<ExecutorService> executorProvider;
    private final a<IdentityManager> identityManagerProvider;
    private final a<Serializer> serializerProvider;

    public ZendeskProvidersModule_ProviderZendeskBlipsProviderFactory(a<BlipsService> aVar, a<DeviceInfo> aVar2, a<Serializer> aVar3, a<IdentityManager> aVar4, a<ApplicationConfiguration> aVar5, a<CoreSettingsStorage> aVar6, a<ExecutorService> aVar7) {
        this.blipsServiceProvider = aVar;
        this.deviceInfoProvider = aVar2;
        this.serializerProvider = aVar3;
        this.identityManagerProvider = aVar4;
        this.applicationConfigurationProvider = aVar5;
        this.coreSettingsStorageProvider = aVar6;
        this.executorProvider = aVar7;
    }

    public static ZendeskProvidersModule_ProviderZendeskBlipsProviderFactory create(a<BlipsService> aVar, a<DeviceInfo> aVar2, a<Serializer> aVar3, a<IdentityManager> aVar4, a<ApplicationConfiguration> aVar5, a<CoreSettingsStorage> aVar6, a<ExecutorService> aVar7) {
        return new ZendeskProvidersModule_ProviderZendeskBlipsProviderFactory(aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7);
    }

    public static ZendeskBlipsProvider providerZendeskBlipsProvider(Object obj, Object obj2, Object obj3, Object obj4, ApplicationConfiguration applicationConfiguration, Object obj5, ExecutorService executorService) {
        return (ZendeskBlipsProvider) d.f(ZendeskProvidersModule.providerZendeskBlipsProvider((BlipsService) obj, (DeviceInfo) obj2, (Serializer) obj3, (IdentityManager) obj4, applicationConfiguration, (CoreSettingsStorage) obj5, executorService));
    }

    public ZendeskBlipsProvider get() {
        return providerZendeskBlipsProvider(this.blipsServiceProvider.get(), this.deviceInfoProvider.get(), this.serializerProvider.get(), this.identityManagerProvider.get(), this.applicationConfigurationProvider.get(), this.coreSettingsStorageProvider.get(), this.executorProvider.get());
    }
}
