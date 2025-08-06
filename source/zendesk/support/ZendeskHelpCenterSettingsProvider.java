package zendesk.support;

import com.zendesk.logger.Logger;
import com.zendesk.service.ZendeskCallback;
import java.util.Locale;
import lz.a;
import zendesk.core.SettingsPack;
import zendesk.core.SettingsProvider;
import zendesk.core.ZendeskLocaleConverter;

class ZendeskHelpCenterSettingsProvider implements HelpCenterSettingsProvider {
    private static final String HELP_CENTER_KEY = "help_center";
    private static final String LOG_TAG = "HelpCenterSettingsProvider";
    private final Locale deviceLocale;
    private final ZendeskLocaleConverter localeConverter;
    private final SettingsProvider sdkSettingsProvider;

    public ZendeskHelpCenterSettingsProvider(SettingsProvider settingsProvider, ZendeskLocaleConverter zendeskLocaleConverter, Locale locale) {
        this.sdkSettingsProvider = settingsProvider;
        this.localeConverter = zendeskLocaleConverter;
        this.deviceLocale = locale;
    }

    /* access modifiers changed from: private */
    public void logIfLocaleNotAvailable(HelpCenterSettings helpCenterSettings) {
        if (helpCenterSettings != null && helpCenterSettings.getLocale() != null) {
            String locale = helpCenterSettings.getLocale();
            String helpCenterLocaleString = this.localeConverter.toHelpCenterLocaleString(this.deviceLocale);
            if (!helpCenterLocaleString.equals(locale)) {
                Logger.l(LOG_TAG, "No support for %s, Help Center is %s in your application settings", helpCenterLocaleString, Boolean.valueOf(helpCenterSettings.isEnabled()));
            }
        }
    }

    public void getSettings(final ZendeskCallback<HelpCenterSettings> zendeskCallback) {
        this.sdkSettingsProvider.getSettingsForSdk(HELP_CENTER_KEY, HelpCenterSettings.class, new ZendeskCallback<SettingsPack<HelpCenterSettings>>() {
            public void onError(a aVar) {
                if (zendeskCallback != null) {
                    Logger.b(ZendeskHelpCenterSettingsProvider.LOG_TAG, "Returning default Help Center Settings.", new Object[0]);
                    zendeskCallback.onSuccess(HelpCenterSettings.defaultSettings());
                }
            }

            public void onSuccess(SettingsPack<HelpCenterSettings> settingsPack) {
                ZendeskHelpCenterSettingsProvider.this.logIfLocaleNotAvailable(settingsPack.getSettings());
                Logger.b(ZendeskHelpCenterSettingsProvider.LOG_TAG, "Successfully retrieved Help Center Settings", new Object[0]);
                ZendeskCallback zendeskCallback = zendeskCallback;
                if (zendeskCallback != null) {
                    zendeskCallback.onSuccess(settingsPack.getSettings());
                }
            }
        });
    }
}
