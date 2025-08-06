package zendesk.core;

import com.zendesk.logger.Logger;
import com.zendesk.service.ZendeskCallback;
import mz.f;

final class ZendeskShadow {
    private static final String LOG_TAG = "ZendeskShadow";
    private final BlipsCoreProvider blipsCoreProvider;
    private final CoreModule coreModule;
    private final IdentityManager identityManager;
    private final LegacyIdentityMigrator legacyIdentityMigrator;
    private final ProviderStore providerStore;
    private final PushRegistrationProvider pushRegistrationProvider;
    private final Storage storage;

    public ZendeskShadow(Storage storage2, LegacyIdentityMigrator legacyIdentityMigrator2, IdentityManager identityManager2, BlipsCoreProvider blipsCoreProvider2, PushRegistrationProvider pushRegistrationProvider2, CoreModule coreModule2, ProviderStore providerStore2) {
        this.storage = storage2;
        this.legacyIdentityMigrator = legacyIdentityMigrator2;
        this.identityManager = identityManager2;
        this.blipsCoreProvider = blipsCoreProvider2;
        this.pushRegistrationProvider = pushRegistrationProvider2;
        this.coreModule = coreModule2;
        this.providerStore = providerStore2;
    }

    private static boolean checkIdentityValid(Identity identity) {
        if (identity == null) {
            Logger.l(LOG_TAG, "setIdentity(): The provided Identity object must be an Anonymous Identity or a JwtIdentity with a non-empty JWT identifier. Returning.", new Object[0]);
            return false;
        } else if (!(identity instanceof AnonymousIdentity) && !(identity instanceof JwtIdentity)) {
            Logger.l(LOG_TAG, "setIdentity(): The provided Identity object must be an Anonymous Identity or a JwtIdentity with a non-empty JWT identifier. Returning.", new Object[0]);
            return false;
        } else if (!(identity instanceof JwtIdentity) || !f.e(((JwtIdentity) identity).getJwtUserIdentifier())) {
            return true;
        } else {
            Logger.l(LOG_TAG, "setIdentity(): The provided Identity object must be an Anonymous Identity or a JwtIdentity with a non-empty JWT identifier. Returning.", new Object[0]);
            return false;
        }
    }

    public void cleanupIfNewConfig(ApplicationConfiguration applicationConfiguration) {
        if (this.storage.hasSdkConfigChanged(applicationConfiguration)) {
            this.pushRegistrationProvider.unregisterDevice((ZendeskCallback<Void>) null);
        }
    }

    public CoreModule coreModule() {
        return this.coreModule;
    }

    public Identity getIdentity() {
        return this.identityManager.getIdentity();
    }

    public void init(ApplicationConfiguration applicationConfiguration, boolean z11) {
        if (this.storage.hasSdkConfigChanged(applicationConfiguration)) {
            Logger.b(LOG_TAG, "SDK app config details have changed, cleaning up old config storage.", new Object[0]);
            this.storage.clear();
            this.storage.storeSdkHash(applicationConfiguration);
        } else if (z11) {
            Logger.g(LOG_TAG, "Zendesk is already initialized with these details, skipping.", new Object[0]);
            return;
        }
        this.blipsCoreProvider.coreInitialized();
    }

    public ProviderStore providers() {
        return this.providerStore;
    }

    public void reset() {
        this.pushRegistrationProvider.unregisterDevice((ZendeskCallback<Void>) null);
        this.storage.getSessionStorage().clear();
        this.storage.clear();
    }

    public void setIdentity(Identity identity) {
        if (checkIdentityValid(identity)) {
            this.legacyIdentityMigrator.checkAndMigrateIdentity();
            if (this.identityManager.identityIsDifferent(identity)) {
                this.pushRegistrationProvider.unregisterDevice((ZendeskCallback<Void>) null);
                this.storage.getSessionStorage().clear();
                this.identityManager.updateAndPersistIdentity(identity);
                return;
            }
            Logger.g(LOG_TAG, "Zendesk is already initialized with this identity, skipping.", new Object[0]);
        }
    }
}
