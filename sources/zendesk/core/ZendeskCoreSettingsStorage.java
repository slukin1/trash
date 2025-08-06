package zendesk.core;

import com.zendesk.logger.Logger;
import java.util.Date;

class ZendeskCoreSettingsStorage implements CoreSettingsStorage {
    public static final String BLIPS_KEY = "blips";
    public static final String CORE_KEY = "core";
    public static final BlipsSettings DEFAULT_BLIPS_SETTINGS = new BlipsSettings(new BlipsPermissions());
    public static final CoreSettings DEFAULT_CORE_SETTINGS = new CoreSettings(new Date(0), (AuthenticationType) null);
    private static final String LOG_TAG = "ZendeskCoreSettingsStorage";
    private final SettingsStorage settingsStorage;

    public ZendeskCoreSettingsStorage(SettingsStorage settingsStorage2) {
        this.settingsStorage = settingsStorage2;
    }

    public BlipsSettings getBlipsSettings() {
        BlipsSettings blipsSettings = (BlipsSettings) this.settingsStorage.getSettings(BLIPS_KEY, BlipsSettings.class);
        if (blipsSettings != null) {
            return blipsSettings;
        }
        Logger.b(LOG_TAG, "Unable to load blips settings, returning defaults.", new Object[0]);
        return DEFAULT_BLIPS_SETTINGS;
    }

    public CoreSettings getCoreSettings() {
        CoreSettings coreSettings = (CoreSettings) this.settingsStorage.getSettings(CORE_KEY, CoreSettings.class);
        if (coreSettings != null) {
            return coreSettings;
        }
        Logger.b(LOG_TAG, "Unable to load Core SDK Settings, returning default settings.", new Object[0]);
        return DEFAULT_CORE_SETTINGS;
    }
}
