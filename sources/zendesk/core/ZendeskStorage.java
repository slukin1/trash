package zendesk.core;

import com.zendesk.util.DigestUtils;
import java.util.Locale;

class ZendeskStorage implements Storage {
    private static final String SDK_HASH_FORMAT = "%s_%s_%s";
    private static final String SDK_HASH_KEY = "sdk_hash";
    private final MemoryCache memoryCache;
    private final BaseStorage sdkDetailsStorage;
    private final SessionStorage sessionStorage;
    private final SettingsStorage settingsStorage;

    public ZendeskStorage(SessionStorage sessionStorage2, SettingsStorage settingsStorage2, BaseStorage baseStorage, MemoryCache memoryCache2) {
        this.sessionStorage = sessionStorage2;
        this.settingsStorage = settingsStorage2;
        this.sdkDetailsStorage = baseStorage;
        this.memoryCache = memoryCache2;
    }

    private String generateSdkHash(ApplicationConfiguration applicationConfiguration) {
        Locale locale = Locale.US;
        return DigestUtils.c(String.format(locale, SDK_HASH_FORMAT, new Object[]{applicationConfiguration.getZendeskUrl().toLowerCase(locale), applicationConfiguration.getApplicationId().toLowerCase(locale), applicationConfiguration.getOauthClientId().toLowerCase(locale)}));
    }

    public void clear() {
        this.sessionStorage.clear();
        this.settingsStorage.clear();
        this.memoryCache.clear();
    }

    public SessionStorage getSessionStorage() {
        return this.sessionStorage;
    }

    public boolean hasSdkConfigChanged(ApplicationConfiguration applicationConfiguration) {
        return !generateSdkHash(applicationConfiguration).equals(this.sdkDetailsStorage.get(SDK_HASH_KEY));
    }

    public void storeSdkHash(ApplicationConfiguration applicationConfiguration) {
        this.sdkDetailsStorage.put(SDK_HASH_KEY, generateSdkHash(applicationConfiguration));
    }
}
