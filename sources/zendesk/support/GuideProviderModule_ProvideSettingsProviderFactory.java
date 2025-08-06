package zendesk.support;

import dagger.internal.b;
import dagger.internal.d;
import java.util.Locale;
import q00.a;
import zendesk.core.SettingsProvider;
import zendesk.core.ZendeskLocaleConverter;

public final class GuideProviderModule_ProvideSettingsProviderFactory implements b<HelpCenterSettingsProvider> {
    private final a<ZendeskLocaleConverter> localeConverterProvider;
    private final a<Locale> localeProvider;
    private final GuideProviderModule module;
    private final a<SettingsProvider> sdkSettingsProvider;

    public GuideProviderModule_ProvideSettingsProviderFactory(GuideProviderModule guideProviderModule, a<SettingsProvider> aVar, a<ZendeskLocaleConverter> aVar2, a<Locale> aVar3) {
        this.module = guideProviderModule;
        this.sdkSettingsProvider = aVar;
        this.localeConverterProvider = aVar2;
        this.localeProvider = aVar3;
    }

    public static GuideProviderModule_ProvideSettingsProviderFactory create(GuideProviderModule guideProviderModule, a<SettingsProvider> aVar, a<ZendeskLocaleConverter> aVar2, a<Locale> aVar3) {
        return new GuideProviderModule_ProvideSettingsProviderFactory(guideProviderModule, aVar, aVar2, aVar3);
    }

    public static HelpCenterSettingsProvider provideSettingsProvider(GuideProviderModule guideProviderModule, SettingsProvider settingsProvider, ZendeskLocaleConverter zendeskLocaleConverter, Locale locale) {
        return (HelpCenterSettingsProvider) d.f(guideProviderModule.provideSettingsProvider(settingsProvider, zendeskLocaleConverter, locale));
    }

    public HelpCenterSettingsProvider get() {
        return provideSettingsProvider(this.module, this.sdkSettingsProvider.get(), this.localeConverterProvider.get(), this.localeProvider.get());
    }
}
