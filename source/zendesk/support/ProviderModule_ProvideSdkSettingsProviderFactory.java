package zendesk.support;

import dagger.internal.b;
import dagger.internal.d;
import java.util.Locale;
import q00.a;
import zendesk.core.SettingsProvider;
import zendesk.core.ZendeskLocaleConverter;

public final class ProviderModule_ProvideSdkSettingsProviderFactory implements b<SupportSettingsProvider> {
    private final a<ZendeskLocaleConverter> helpCenterLocaleConverterProvider;
    private final a<Locale> localeProvider;
    private final ProviderModule module;
    private final a<SettingsProvider> sdkSettingsProvider;

    public ProviderModule_ProvideSdkSettingsProviderFactory(ProviderModule providerModule, a<SettingsProvider> aVar, a<Locale> aVar2, a<ZendeskLocaleConverter> aVar3) {
        this.module = providerModule;
        this.sdkSettingsProvider = aVar;
        this.localeProvider = aVar2;
        this.helpCenterLocaleConverterProvider = aVar3;
    }

    public static ProviderModule_ProvideSdkSettingsProviderFactory create(ProviderModule providerModule, a<SettingsProvider> aVar, a<Locale> aVar2, a<ZendeskLocaleConverter> aVar3) {
        return new ProviderModule_ProvideSdkSettingsProviderFactory(providerModule, aVar, aVar2, aVar3);
    }

    public static SupportSettingsProvider provideSdkSettingsProvider(ProviderModule providerModule, SettingsProvider settingsProvider, Locale locale, ZendeskLocaleConverter zendeskLocaleConverter) {
        return (SupportSettingsProvider) d.f(providerModule.provideSdkSettingsProvider(settingsProvider, locale, zendeskLocaleConverter));
    }

    public SupportSettingsProvider get() {
        return provideSdkSettingsProvider(this.module, this.sdkSettingsProvider.get(), this.localeProvider.get(), this.helpCenterLocaleConverterProvider.get());
    }
}
