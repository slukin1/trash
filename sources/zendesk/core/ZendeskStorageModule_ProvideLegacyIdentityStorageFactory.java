package zendesk.core;

import dagger.internal.b;
import dagger.internal.d;
import q00.a;

public final class ZendeskStorageModule_ProvideLegacyIdentityStorageFactory implements b<LegacyIdentityMigrator> {
    private final a<IdentityManager> identityManagerProvider;
    private final a<IdentityStorage> identityStorageProvider;
    private final a<SharedPreferencesStorage> legacyIdentityBaseStorageProvider;
    private final a<SharedPreferencesStorage> legacyPushBaseStorageProvider;
    private final a<PushDeviceIdStorage> pushDeviceIdStorageProvider;

    public ZendeskStorageModule_ProvideLegacyIdentityStorageFactory(a<SharedPreferencesStorage> aVar, a<SharedPreferencesStorage> aVar2, a<IdentityStorage> aVar3, a<IdentityManager> aVar4, a<PushDeviceIdStorage> aVar5) {
        this.legacyIdentityBaseStorageProvider = aVar;
        this.legacyPushBaseStorageProvider = aVar2;
        this.identityStorageProvider = aVar3;
        this.identityManagerProvider = aVar4;
        this.pushDeviceIdStorageProvider = aVar5;
    }

    public static ZendeskStorageModule_ProvideLegacyIdentityStorageFactory create(a<SharedPreferencesStorage> aVar, a<SharedPreferencesStorage> aVar2, a<IdentityStorage> aVar3, a<IdentityManager> aVar4, a<PushDeviceIdStorage> aVar5) {
        return new ZendeskStorageModule_ProvideLegacyIdentityStorageFactory(aVar, aVar2, aVar3, aVar4, aVar5);
    }

    public static LegacyIdentityMigrator provideLegacyIdentityStorage(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        return (LegacyIdentityMigrator) d.f(ZendeskStorageModule.provideLegacyIdentityStorage((SharedPreferencesStorage) obj, (SharedPreferencesStorage) obj2, (IdentityStorage) obj3, (IdentityManager) obj4, (PushDeviceIdStorage) obj5));
    }

    public LegacyIdentityMigrator get() {
        return provideLegacyIdentityStorage(this.legacyIdentityBaseStorageProvider.get(), this.legacyPushBaseStorageProvider.get(), this.identityStorageProvider.get(), this.identityManagerProvider.get(), this.pushDeviceIdStorageProvider.get());
    }
}
