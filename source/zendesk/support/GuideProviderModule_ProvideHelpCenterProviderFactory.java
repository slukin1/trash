package zendesk.support;

import dagger.internal.b;
import dagger.internal.d;
import q00.a;

public final class GuideProviderModule_ProvideHelpCenterProviderFactory implements b<HelpCenterProvider> {
    private final a<HelpCenterBlipsProvider> blipsProvider;
    private final a<ZendeskHelpCenterService> helpCenterServiceProvider;
    private final a<HelpCenterSessionCache> helpCenterSessionCacheProvider;
    private final GuideProviderModule module;
    private final a<HelpCenterSettingsProvider> settingsProvider;

    public GuideProviderModule_ProvideHelpCenterProviderFactory(GuideProviderModule guideProviderModule, a<HelpCenterSettingsProvider> aVar, a<HelpCenterBlipsProvider> aVar2, a<ZendeskHelpCenterService> aVar3, a<HelpCenterSessionCache> aVar4) {
        this.module = guideProviderModule;
        this.settingsProvider = aVar;
        this.blipsProvider = aVar2;
        this.helpCenterServiceProvider = aVar3;
        this.helpCenterSessionCacheProvider = aVar4;
    }

    public static GuideProviderModule_ProvideHelpCenterProviderFactory create(GuideProviderModule guideProviderModule, a<HelpCenterSettingsProvider> aVar, a<HelpCenterBlipsProvider> aVar2, a<ZendeskHelpCenterService> aVar3, a<HelpCenterSessionCache> aVar4) {
        return new GuideProviderModule_ProvideHelpCenterProviderFactory(guideProviderModule, aVar, aVar2, aVar3, aVar4);
    }

    public static HelpCenterProvider provideHelpCenterProvider(GuideProviderModule guideProviderModule, HelpCenterSettingsProvider helpCenterSettingsProvider, HelpCenterBlipsProvider helpCenterBlipsProvider, Object obj, Object obj2) {
        return (HelpCenterProvider) d.f(guideProviderModule.provideHelpCenterProvider(helpCenterSettingsProvider, helpCenterBlipsProvider, (ZendeskHelpCenterService) obj, (HelpCenterSessionCache) obj2));
    }

    public HelpCenterProvider get() {
        return provideHelpCenterProvider(this.module, this.settingsProvider.get(), this.blipsProvider.get(), this.helpCenterServiceProvider.get(), this.helpCenterSessionCacheProvider.get());
    }
}
