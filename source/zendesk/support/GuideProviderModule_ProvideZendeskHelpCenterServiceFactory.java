package zendesk.support;

import dagger.internal.b;
import dagger.internal.d;
import q00.a;
import zendesk.core.ZendeskLocaleConverter;

public final class GuideProviderModule_ProvideZendeskHelpCenterServiceFactory implements b<ZendeskHelpCenterService> {
    private final a<HelpCenterService> helpCenterServiceProvider;
    private final a<ZendeskLocaleConverter> localeConverterProvider;

    public GuideProviderModule_ProvideZendeskHelpCenterServiceFactory(a<HelpCenterService> aVar, a<ZendeskLocaleConverter> aVar2) {
        this.helpCenterServiceProvider = aVar;
        this.localeConverterProvider = aVar2;
    }

    public static GuideProviderModule_ProvideZendeskHelpCenterServiceFactory create(a<HelpCenterService> aVar, a<ZendeskLocaleConverter> aVar2) {
        return new GuideProviderModule_ProvideZendeskHelpCenterServiceFactory(aVar, aVar2);
    }

    public static ZendeskHelpCenterService provideZendeskHelpCenterService(Object obj, ZendeskLocaleConverter zendeskLocaleConverter) {
        return (ZendeskHelpCenterService) d.f(GuideProviderModule.provideZendeskHelpCenterService((HelpCenterService) obj, zendeskLocaleConverter));
    }

    public ZendeskHelpCenterService get() {
        return provideZendeskHelpCenterService(this.helpCenterServiceProvider.get(), this.localeConverterProvider.get());
    }
}
