package zendesk.support;

import android.content.Context;
import zendesk.core.MemoryCache;
import zendesk.core.SessionStorage;

class StorageModule {
    private static final String LEGACY_REQUEST_STORAGE_PREFS_NAME = "zendesk-authorization";

    public RequestMigrator provideRequestMigrator(Context context) {
        return new LegacyRequestMigrator(context.getSharedPreferences(LEGACY_REQUEST_STORAGE_PREFS_NAME, 0));
    }

    public RequestSessionCache provideRequestSessionCache() {
        return new ZendeskRequestSessionCache();
    }

    public RequestStorage provideRequestStorage(SessionStorage sessionStorage, RequestMigrator requestMigrator, MemoryCache memoryCache) {
        return new ZendeskRequestStorage(sessionStorage.getAdditionalSdkStorage(), requestMigrator, memoryCache);
    }
}
