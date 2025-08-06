package zendesk.support;

import com.zendesk.logger.Logger;
import com.zendesk.service.ZendeskCallback;
import java.util.Locale;
import lz.a;
import zendesk.core.AuthenticationType;
import zendesk.core.SettingsPack;
import zendesk.core.SettingsProvider;
import zendesk.core.ZendeskLocaleConverter;

class ZendeskSupportSettingsProvider implements SupportSettingsProvider {
    private static final String HELP_CENTER_KEY = "help_center";
    private static final String LOG_TAG = "ZendeskSettingsProvider";
    public static final String SUPPORT_KEY = "support";
    /* access modifiers changed from: private */
    public final Locale deviceLocale;
    /* access modifiers changed from: private */
    public final ZendeskLocaleConverter localeConverter;
    /* access modifiers changed from: private */
    public final SettingsProvider sdkSettingsProvider;

    public class LoadSupportSettings extends ZendeskCallback<SettingsPack<SupportSettings>> {
        private final ZendeskCallback<SupportSdkSettings> callback;

        public class LoadHelpCenterSettings extends ZendeskCallback<SettingsPack<HelpCenterSettings>> {
            private final ZendeskCallback<SupportSdkSettings> callback;
            private final SettingsPack<SupportSettings> supportSettingsPack;

            public LoadHelpCenterSettings(ZendeskCallback<SupportSdkSettings> zendeskCallback, SettingsPack<SupportSettings> settingsPack) {
                this.callback = zendeskCallback;
                this.supportSettingsPack = settingsPack;
            }

            public void onError(a aVar) {
                if (this.callback != null) {
                    Logger.b(ZendeskSupportSettingsProvider.LOG_TAG, "Returning default Help Center Settings.", new Object[0]);
                    this.callback.onSuccess(new SupportSdkSettings(this.supportSettingsPack.getSettings(), HelpCenterSettings.defaultSettings(), this.supportSettingsPack.getCoreSettings().getAuthentication()));
                }
            }

            public void onSuccess(SettingsPack<HelpCenterSettings> settingsPack) {
                HelpCenterSettings settings = settingsPack.getSettings();
                AuthenticationType authentication = settingsPack.getCoreSettings().getAuthentication();
                LoadSupportSettings.this.logIfLocaleNotAvailable(settings);
                Logger.b(ZendeskSupportSettingsProvider.LOG_TAG, "Successfully retrieved Settings", new Object[0]);
                ZendeskCallback<SupportSdkSettings> zendeskCallback = this.callback;
                if (zendeskCallback != null) {
                    zendeskCallback.onSuccess(new SupportSdkSettings(this.supportSettingsPack.getSettings(), settings, authentication));
                }
            }
        }

        public LoadSupportSettings(ZendeskCallback<SupportSdkSettings> zendeskCallback) {
            this.callback = zendeskCallback;
        }

        /* access modifiers changed from: private */
        public void logIfLocaleNotAvailable(HelpCenterSettings helpCenterSettings) {
            if (helpCenterSettings != null && helpCenterSettings.getLocale() != null) {
                String locale = helpCenterSettings.getLocale();
                String helpCenterLocaleString = ZendeskSupportSettingsProvider.this.localeConverter.toHelpCenterLocaleString(ZendeskSupportSettingsProvider.this.deviceLocale);
                if (!helpCenterLocaleString.equals(locale)) {
                    Logger.l(ZendeskSupportSettingsProvider.LOG_TAG, "No support for %s, Help Center is %s in your application settings", helpCenterLocaleString, Boolean.valueOf(helpCenterSettings.isEnabled()));
                }
            }
        }

        public void onError(a aVar) {
            if (this.callback != null) {
                Logger.b(ZendeskSupportSettingsProvider.LOG_TAG, "Returning default Support Settings.", new Object[0]);
                this.callback.onSuccess(new SupportSdkSettings(SupportSettings.defaultSettings(), HelpCenterSettings.defaultSettings(), (AuthenticationType) null));
            }
        }

        public void onSuccess(SettingsPack<SupportSettings> settingsPack) {
            ZendeskSupportSettingsProvider.this.sdkSettingsProvider.getSettingsForSdk(ZendeskSupportSettingsProvider.HELP_CENTER_KEY, HelpCenterSettings.class, new LoadHelpCenterSettings(this.callback, settingsPack));
        }
    }

    public ZendeskSupportSettingsProvider(SettingsProvider settingsProvider, ZendeskLocaleConverter zendeskLocaleConverter, Locale locale) {
        this.sdkSettingsProvider = settingsProvider;
        this.localeConverter = zendeskLocaleConverter;
        this.deviceLocale = locale;
    }

    public void getSettings(ZendeskCallback<SupportSdkSettings> zendeskCallback) {
        this.sdkSettingsProvider.getSettingsForSdk("support", SupportSettings.class, new LoadSupportSettings(zendeskCallback));
    }
}
