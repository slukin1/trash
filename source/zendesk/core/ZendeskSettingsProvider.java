package zendesk.core;

import android.content.Context;
import com.google.gson.JsonElement;
import com.zendesk.logger.Logger;
import com.zendesk.service.ZendeskCallback;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import lz.a;
import lz.c;
import retrofit2.Response;

class ZendeskSettingsProvider implements SettingsProvider, SdkSettingsProviderInternal {
    private static final String LOG_TAG = "ZendeskSdkSettingsProvi";
    public static final int SDK_SETTINGS_MAX_AGE_HOURS = 1;
    /* access modifiers changed from: private */
    public final ActionHandlerRegistry actionHandlerRegistry;
    private final String applicationId;
    private final Context context;
    /* access modifiers changed from: private */
    public final CoreSettingsStorage coreSettingsStorage;
    /* access modifiers changed from: private */
    public final Serializer serializer;
    private final SdkSettingsService settingsService;
    /* access modifiers changed from: private */
    public final SettingsStorage settingsStorage;
    private final ZendeskLocaleConverter zendeskLocaleConverter;

    public ZendeskSettingsProvider(SdkSettingsService sdkSettingsService, SettingsStorage settingsStorage2, CoreSettingsStorage coreSettingsStorage2, ActionHandlerRegistry actionHandlerRegistry2, Serializer serializer2, ZendeskLocaleConverter zendeskLocaleConverter2, String str, Context context2) {
        this.settingsService = sdkSettingsService;
        this.settingsStorage = settingsStorage2;
        this.coreSettingsStorage = coreSettingsStorage2;
        this.actionHandlerRegistry = actionHandlerRegistry2;
        this.serializer = serializer2;
        this.zendeskLocaleConverter = zendeskLocaleConverter2;
        this.applicationId = str;
        this.context = context2;
    }

    private void getSettingsInternal(Locale locale, ZendeskCallback<Map<String, JsonElement>> zendeskCallback) {
        this.settingsService.getSettings(this.zendeskLocaleConverter.toHelpCenterLocaleString(locale), this.applicationId).enqueue(new c(zendeskCallback));
    }

    public CoreSettings extractCoreSettings(Map<String, JsonElement> map) {
        CoreSettings coreSettings = (CoreSettings) this.serializer.deserialize(map == null ? null : map.get(ZendeskCoreSettingsStorage.CORE_KEY), CoreSettings.class);
        if (coreSettings != null) {
            return coreSettings;
        }
        return ZendeskCoreSettingsStorage.DEFAULT_CORE_SETTINGS;
    }

    public BlipsSettings getBlipsSettings() {
        return this.coreSettingsStorage.getBlipsSettings();
    }

    public void getCoreSettings(final ZendeskCallback<CoreSettings> zendeskCallback) {
        if (!this.settingsStorage.areSettingsUpToDate(1, TimeUnit.HOURS)) {
            getSettingsInternal(DeviceInfo.getCurrentLocale(this.context), new ZendeskCallback<Map<String, JsonElement>>() {
                public void onError(a aVar) {
                    ZendeskCallback zendeskCallback = zendeskCallback;
                    if (zendeskCallback != null) {
                        zendeskCallback.onSuccess(ZendeskSettingsProvider.this.coreSettingsStorage.getCoreSettings());
                    }
                }

                public void onSuccess(Map<String, JsonElement> map) {
                    ZendeskSettingsProvider.this.actionHandlerRegistry.updateSettings(map);
                    ZendeskSettingsProvider.this.settingsStorage.storeRawSettings(map);
                    if (zendeskCallback != null) {
                        zendeskCallback.onSuccess(ZendeskSettingsProvider.this.extractCoreSettings(map));
                    }
                }
            });
        } else if (zendeskCallback != null) {
            zendeskCallback.onSuccess(this.coreSettingsStorage.getCoreSettings());
        }
    }

    public <E extends Settings> void getSettingsForSdk(final String str, final Class<E> cls, final ZendeskCallback<SettingsPack<E>> zendeskCallback) {
        if (!this.settingsStorage.areSettingsUpToDate(1, TimeUnit.HOURS)) {
            getSettingsInternal(DeviceInfo.getCurrentLocale(this.context), new ZendeskCallback<Map<String, JsonElement>>() {
                public void onError(a aVar) {
                    if (zendeskCallback != null) {
                        if (ZendeskSettingsProvider.this.settingsStorage.hasStoredSettings()) {
                            zendeskCallback.onSuccess(new SettingsPack(ZendeskSettingsProvider.this.coreSettingsStorage.getCoreSettings(), (Settings) ZendeskSettingsProvider.this.settingsStorage.getSettings(str, cls)));
                            return;
                        }
                        zendeskCallback.onError(aVar);
                    }
                }

                public void onSuccess(Map<String, JsonElement> map) {
                    ZendeskSettingsProvider.this.actionHandlerRegistry.updateSettings(map);
                    ZendeskSettingsProvider.this.settingsStorage.storeRawSettings(map);
                    if (zendeskCallback != null) {
                        zendeskCallback.onSuccess(new SettingsPack(ZendeskSettingsProvider.this.extractCoreSettings(map), (Settings) ZendeskSettingsProvider.this.serializer.deserialize(map.get(str), cls)));
                    }
                }
            });
        } else if (zendeskCallback != null) {
            zendeskCallback.onSuccess(new SettingsPack(this.coreSettingsStorage.getCoreSettings(), (Settings) this.settingsStorage.getSettings(str, cls)));
            this.actionHandlerRegistry.updateSettings(this.settingsStorage.getRawSettings());
        }
    }

    public CoreSettings getCoreSettings() {
        if (this.settingsStorage.areSettingsUpToDate(1, TimeUnit.HOURS)) {
            return this.coreSettingsStorage.getCoreSettings();
        }
        Map<String, JsonElement> settingsInternal = getSettingsInternal(DeviceInfo.getCurrentLocale(this.context));
        if (settingsInternal.isEmpty()) {
            return new CoreSettings(new Date(0), (AuthenticationType) null);
        }
        this.actionHandlerRegistry.updateSettings(settingsInternal);
        this.settingsStorage.storeRawSettings(settingsInternal);
        return extractCoreSettings(settingsInternal);
    }

    private Map<String, JsonElement> getSettingsInternal(Locale locale) {
        try {
            Response<Map<String, JsonElement>> execute = this.settingsService.getSettings(this.zendeskLocaleConverter.toHelpCenterLocaleString(locale), this.applicationId).execute();
            if (execute.body() != null) {
                return new HashMap(execute.body());
            }
            return new HashMap(0);
        } catch (IOException unused) {
            Logger.d(LOG_TAG, "Settings retrieval failed, returning empty map.", new Object[0]);
            return new HashMap(0);
        }
    }
}
