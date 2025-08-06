package zendesk.support;

import dagger.internal.b;
import dagger.internal.d;
import q00.a;
import zendesk.core.RestServiceProvider;

public final class ProviderModule_ProvideSupportModuleFactory implements b<SupportModule> {
    private final a<ArticleVoteStorage> articleVoteStorageProvider;
    private final a<SupportBlipsProvider> blipsProvider;
    private final a<HelpCenterProvider> helpCenterProvider;
    private final ProviderModule module;
    private final a<RequestProvider> requestProvider;
    private final a<RestServiceProvider> restServiceProvider;
    private final a<SupportSettingsProvider> settingsProvider;
    private final a<UploadProvider> uploadProvider;
    private final a<ZendeskTracker> zendeskTrackerProvider;

    public ProviderModule_ProvideSupportModuleFactory(ProviderModule providerModule, a<RequestProvider> aVar, a<UploadProvider> aVar2, a<HelpCenterProvider> aVar3, a<SupportSettingsProvider> aVar4, a<RestServiceProvider> aVar5, a<SupportBlipsProvider> aVar6, a<ZendeskTracker> aVar7, a<ArticleVoteStorage> aVar8) {
        this.module = providerModule;
        this.requestProvider = aVar;
        this.uploadProvider = aVar2;
        this.helpCenterProvider = aVar3;
        this.settingsProvider = aVar4;
        this.restServiceProvider = aVar5;
        this.blipsProvider = aVar6;
        this.zendeskTrackerProvider = aVar7;
        this.articleVoteStorageProvider = aVar8;
    }

    public static ProviderModule_ProvideSupportModuleFactory create(ProviderModule providerModule, a<RequestProvider> aVar, a<UploadProvider> aVar2, a<HelpCenterProvider> aVar3, a<SupportSettingsProvider> aVar4, a<RestServiceProvider> aVar5, a<SupportBlipsProvider> aVar6, a<ZendeskTracker> aVar7, a<ArticleVoteStorage> aVar8) {
        return new ProviderModule_ProvideSupportModuleFactory(providerModule, aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7, aVar8);
    }

    public static SupportModule provideSupportModule(ProviderModule providerModule, RequestProvider requestProvider2, UploadProvider uploadProvider2, HelpCenterProvider helpCenterProvider2, SupportSettingsProvider supportSettingsProvider, RestServiceProvider restServiceProvider2, SupportBlipsProvider supportBlipsProvider, Object obj, ArticleVoteStorage articleVoteStorage) {
        return (SupportModule) d.f(providerModule.provideSupportModule(requestProvider2, uploadProvider2, helpCenterProvider2, supportSettingsProvider, restServiceProvider2, supportBlipsProvider, (ZendeskTracker) obj, articleVoteStorage));
    }

    public SupportModule get() {
        return provideSupportModule(this.module, this.requestProvider.get(), this.uploadProvider.get(), this.helpCenterProvider.get(), this.settingsProvider.get(), this.restServiceProvider.get(), this.blipsProvider.get(), this.zendeskTrackerProvider.get(), this.articleVoteStorageProvider.get());
    }
}
