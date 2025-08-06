package zendesk.support;

import dagger.internal.b;
import dagger.internal.d;
import q00.a;
import zendesk.core.RestServiceProvider;

public final class GuideProviderModule_ProvideGuideModuleFactory implements b<GuideModule> {
    private final a<ArticleVoteStorage> articleVoteStorageProvider;
    private final a<HelpCenterBlipsProvider> blipsProvider;
    private final a<HelpCenterProvider> helpCenterProvider;
    private final GuideProviderModule module;
    private final a<RestServiceProvider> restServiceProvider;
    private final a<HelpCenterSettingsProvider> settingsProvider;

    public GuideProviderModule_ProvideGuideModuleFactory(GuideProviderModule guideProviderModule, a<HelpCenterProvider> aVar, a<HelpCenterSettingsProvider> aVar2, a<HelpCenterBlipsProvider> aVar3, a<ArticleVoteStorage> aVar4, a<RestServiceProvider> aVar5) {
        this.module = guideProviderModule;
        this.helpCenterProvider = aVar;
        this.settingsProvider = aVar2;
        this.blipsProvider = aVar3;
        this.articleVoteStorageProvider = aVar4;
        this.restServiceProvider = aVar5;
    }

    public static GuideProviderModule_ProvideGuideModuleFactory create(GuideProviderModule guideProviderModule, a<HelpCenterProvider> aVar, a<HelpCenterSettingsProvider> aVar2, a<HelpCenterBlipsProvider> aVar3, a<ArticleVoteStorage> aVar4, a<RestServiceProvider> aVar5) {
        return new GuideProviderModule_ProvideGuideModuleFactory(guideProviderModule, aVar, aVar2, aVar3, aVar4, aVar5);
    }

    public static GuideModule provideGuideModule(GuideProviderModule guideProviderModule, HelpCenterProvider helpCenterProvider2, HelpCenterSettingsProvider helpCenterSettingsProvider, HelpCenterBlipsProvider helpCenterBlipsProvider, ArticleVoteStorage articleVoteStorage, RestServiceProvider restServiceProvider2) {
        return (GuideModule) d.f(guideProviderModule.provideGuideModule(helpCenterProvider2, helpCenterSettingsProvider, helpCenterBlipsProvider, articleVoteStorage, restServiceProvider2));
    }

    public GuideModule get() {
        return provideGuideModule(this.module, this.helpCenterProvider.get(), this.settingsProvider.get(), this.blipsProvider.get(), this.articleVoteStorageProvider.get(), this.restServiceProvider.get());
    }
}
