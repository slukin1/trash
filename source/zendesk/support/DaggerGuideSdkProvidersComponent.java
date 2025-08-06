package zendesk.support;

import dagger.internal.d;
import dagger.internal.e;
import java.util.Locale;
import q00.a;
import zendesk.core.BlipsProvider;
import zendesk.core.CoreModule;
import zendesk.core.CoreModule_GetBlipsProviderFactory;
import zendesk.core.CoreModule_GetRestServiceProviderFactory;
import zendesk.core.CoreModule_GetSessionStorageFactory;
import zendesk.core.CoreModule_GetSettingsProviderFactory;
import zendesk.core.RestServiceProvider;
import zendesk.core.SessionStorage;
import zendesk.core.SettingsProvider;
import zendesk.core.ZendeskLocaleConverter;

final class DaggerGuideSdkProvidersComponent {

    public static final class Builder {
        private CoreModule coreModule;
        private GuideProviderModule guideProviderModule;

        public GuideSdkProvidersComponent build() {
            d.a(this.coreModule, CoreModule.class);
            d.a(this.guideProviderModule, GuideProviderModule.class);
            return new GuideSdkProvidersComponentImpl(this.coreModule, this.guideProviderModule);
        }

        public Builder coreModule(CoreModule coreModule2) {
            this.coreModule = (CoreModule) d.b(coreModule2);
            return this;
        }

        public Builder guideProviderModule(GuideProviderModule guideProviderModule2) {
            this.guideProviderModule = (GuideProviderModule) d.b(guideProviderModule2);
            return this;
        }

        private Builder() {
        }
    }

    public static final class GuideSdkProvidersComponentImpl implements GuideSdkProvidersComponent {
        private a<BlipsProvider> getBlipsProvider;
        private a<RestServiceProvider> getRestServiceProvider;
        private a<SessionStorage> getSessionStorageProvider;
        private a<SettingsProvider> getSettingsProvider;
        private final GuideSdkProvidersComponentImpl guideSdkProvidersComponentImpl;
        private a<ArticleVoteStorage> provideArticleVoteStorageProvider;
        private a<HelpCenterCachingNetworkConfig> provideCustomNetworkConfigProvider;
        private a<Locale> provideDeviceLocaleProvider;
        private a<GuideModule> provideGuideModuleProvider;
        private a<HelpCenterCachingInterceptor> provideHelpCenterCachingInterceptorProvider;
        private a<HelpCenterProvider> provideHelpCenterProvider;
        private a<HelpCenterSessionCache> provideHelpCenterSessionCacheProvider;
        private a<HelpCenterSettingsProvider> provideSettingsProvider;
        private a<ZendeskHelpCenterService> provideZendeskHelpCenterServiceProvider;
        private a<ZendeskLocaleConverter> provideZendeskLocaleConverterProvider;
        private a<HelpCenterBlipsProvider> providesHelpCenterBlipsProvider;
        private a<HelpCenterService> providesHelpCenterServiceProvider;

        private void initialize(CoreModule coreModule, GuideProviderModule guideProviderModule) {
            this.getSettingsProvider = CoreModule_GetSettingsProviderFactory.create(coreModule);
            this.provideZendeskLocaleConverterProvider = dagger.internal.a.a(GuideProviderModule_ProvideZendeskLocaleConverterFactory.create());
            a<Locale> a11 = dagger.internal.a.a(GuideProviderModule_ProvideDeviceLocaleFactory.create(guideProviderModule));
            this.provideDeviceLocaleProvider = a11;
            this.provideSettingsProvider = dagger.internal.a.a(GuideProviderModule_ProvideSettingsProviderFactory.create(guideProviderModule, this.getSettingsProvider, this.provideZendeskLocaleConverterProvider, a11));
            CoreModule_GetBlipsProviderFactory create = CoreModule_GetBlipsProviderFactory.create(coreModule);
            this.getBlipsProvider = create;
            this.providesHelpCenterBlipsProvider = dagger.internal.a.a(GuideProviderModule_ProvidesHelpCenterBlipsProviderFactory.create(guideProviderModule, create, this.provideDeviceLocaleProvider));
            this.getRestServiceProvider = CoreModule_GetRestServiceProviderFactory.create(coreModule);
            a<HelpCenterCachingInterceptor> a12 = e.a(GuideProviderModule_ProvideHelpCenterCachingInterceptorFactory.create());
            this.provideHelpCenterCachingInterceptorProvider = a12;
            a<HelpCenterCachingNetworkConfig> a13 = e.a(GuideProviderModule_ProvideCustomNetworkConfigFactory.create(a12));
            this.provideCustomNetworkConfigProvider = a13;
            a<HelpCenterService> a14 = dagger.internal.a.a(GuideProviderModule_ProvidesHelpCenterServiceFactory.create(this.getRestServiceProvider, a13));
            this.providesHelpCenterServiceProvider = a14;
            this.provideZendeskHelpCenterServiceProvider = dagger.internal.a.a(GuideProviderModule_ProvideZendeskHelpCenterServiceFactory.create(a14, this.provideZendeskLocaleConverterProvider));
            a<HelpCenterSessionCache> a15 = dagger.internal.a.a(GuideProviderModule_ProvideHelpCenterSessionCacheFactory.create());
            this.provideHelpCenterSessionCacheProvider = a15;
            this.provideHelpCenterProvider = dagger.internal.a.a(GuideProviderModule_ProvideHelpCenterProviderFactory.create(guideProviderModule, this.provideSettingsProvider, this.providesHelpCenterBlipsProvider, this.provideZendeskHelpCenterServiceProvider, a15));
            CoreModule_GetSessionStorageFactory create2 = CoreModule_GetSessionStorageFactory.create(coreModule);
            this.getSessionStorageProvider = create2;
            a<ArticleVoteStorage> a16 = dagger.internal.a.a(GuideProviderModule_ProvideArticleVoteStorageFactory.create(create2));
            this.provideArticleVoteStorageProvider = a16;
            this.provideGuideModuleProvider = dagger.internal.a.a(GuideProviderModule_ProvideGuideModuleFactory.create(guideProviderModule, this.provideHelpCenterProvider, this.provideSettingsProvider, this.providesHelpCenterBlipsProvider, a16, this.getRestServiceProvider));
        }

        private Guide injectGuide(Guide guide) {
            Guide_MembersInjector.injectGuideModule(guide, this.provideGuideModuleProvider.get());
            Guide_MembersInjector.injectBlipsProvider(guide, this.providesHelpCenterBlipsProvider.get());
            return guide;
        }

        public Guide inject(Guide guide) {
            return injectGuide(guide);
        }

        private GuideSdkProvidersComponentImpl(CoreModule coreModule, GuideProviderModule guideProviderModule) {
            this.guideSdkProvidersComponentImpl = this;
            initialize(coreModule, guideProviderModule);
        }
    }

    private DaggerGuideSdkProvidersComponent() {
    }

    public static Builder builder() {
        return new Builder();
    }
}
