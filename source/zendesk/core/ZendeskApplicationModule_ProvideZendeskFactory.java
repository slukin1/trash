package zendesk.core;

import dagger.internal.b;
import dagger.internal.d;
import q00.a;

public final class ZendeskApplicationModule_ProvideZendeskFactory implements b<ZendeskShadow> {
    private final a<BlipsCoreProvider> blipsCoreProvider;
    private final a<CoreModule> coreModuleProvider;
    private final a<IdentityManager> identityManagerProvider;
    private final a<LegacyIdentityMigrator> legacyIdentityMigratorProvider;
    private final a<ProviderStore> providerStoreProvider;
    private final a<PushRegistrationProvider> pushRegistrationProvider;
    private final a<Storage> storageProvider;

    public ZendeskApplicationModule_ProvideZendeskFactory(a<Storage> aVar, a<LegacyIdentityMigrator> aVar2, a<IdentityManager> aVar3, a<BlipsCoreProvider> aVar4, a<PushRegistrationProvider> aVar5, a<CoreModule> aVar6, a<ProviderStore> aVar7) {
        this.storageProvider = aVar;
        this.legacyIdentityMigratorProvider = aVar2;
        this.identityManagerProvider = aVar3;
        this.blipsCoreProvider = aVar4;
        this.pushRegistrationProvider = aVar5;
        this.coreModuleProvider = aVar6;
        this.providerStoreProvider = aVar7;
    }

    public static ZendeskApplicationModule_ProvideZendeskFactory create(a<Storage> aVar, a<LegacyIdentityMigrator> aVar2, a<IdentityManager> aVar3, a<BlipsCoreProvider> aVar4, a<PushRegistrationProvider> aVar5, a<CoreModule> aVar6, a<ProviderStore> aVar7) {
        return new ZendeskApplicationModule_ProvideZendeskFactory(aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7);
    }

    public static ZendeskShadow provideZendesk(Object obj, Object obj2, Object obj3, Object obj4, PushRegistrationProvider pushRegistrationProvider2, CoreModule coreModule, ProviderStore providerStore) {
        return (ZendeskShadow) d.f(ZendeskApplicationModule.provideZendesk((Storage) obj, (LegacyIdentityMigrator) obj2, (IdentityManager) obj3, (BlipsCoreProvider) obj4, pushRegistrationProvider2, coreModule, providerStore));
    }

    public ZendeskShadow get() {
        return provideZendesk(this.storageProvider.get(), this.legacyIdentityMigratorProvider.get(), this.identityManagerProvider.get(), this.blipsCoreProvider.get(), this.pushRegistrationProvider.get(), this.coreModuleProvider.get(), this.providerStoreProvider.get());
    }
}
