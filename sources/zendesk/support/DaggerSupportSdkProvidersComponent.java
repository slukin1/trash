package zendesk.support;

import android.content.Context;
import dagger.internal.d;
import java.util.Locale;
import q00.a;
import zendesk.core.AuthenticationProvider;
import zendesk.core.BlipsProvider;
import zendesk.core.CoreModule;
import zendesk.core.CoreModule_ActionHandlerRegistryFactory;
import zendesk.core.CoreModule_GetApplicationContextFactory;
import zendesk.core.CoreModule_GetAuthenticationProviderFactory;
import zendesk.core.CoreModule_GetBlipsProviderFactory;
import zendesk.core.CoreModule_GetMemoryCacheFactory;
import zendesk.core.CoreModule_GetRestServiceProviderFactory;
import zendesk.core.CoreModule_GetSessionStorageFactory;
import zendesk.core.CoreModule_GetSettingsProviderFactory;
import zendesk.core.MemoryCache;
import zendesk.core.RestServiceProvider;
import zendesk.core.SessionStorage;
import zendesk.core.SettingsProvider;
import zendesk.core.ZendeskLocaleConverter;

final class DaggerSupportSdkProvidersComponent {

    public static final class Builder {
        private CoreModule coreModule;
        private GuideModule guideModule;
        private ProviderModule providerModule;
        private StorageModule storageModule;
        private SupportApplicationModule supportApplicationModule;

        public SupportSdkProvidersComponent build() {
            d.a(this.supportApplicationModule, SupportApplicationModule.class);
            d.a(this.coreModule, CoreModule.class);
            if (this.providerModule == null) {
                this.providerModule = new ProviderModule();
            }
            d.a(this.guideModule, GuideModule.class);
            if (this.storageModule == null) {
                this.storageModule = new StorageModule();
            }
            return new SupportSdkProvidersComponentImpl(this.supportApplicationModule, this.coreModule, this.providerModule, this.guideModule, this.storageModule);
        }

        public Builder coreModule(CoreModule coreModule2) {
            this.coreModule = (CoreModule) d.b(coreModule2);
            return this;
        }

        public Builder guideModule(GuideModule guideModule2) {
            this.guideModule = (GuideModule) d.b(guideModule2);
            return this;
        }

        public Builder providerModule(ProviderModule providerModule2) {
            this.providerModule = (ProviderModule) d.b(providerModule2);
            return this;
        }

        @Deprecated
        public Builder serviceModule(ServiceModule serviceModule) {
            d.b(serviceModule);
            return this;
        }

        public Builder storageModule(StorageModule storageModule2) {
            this.storageModule = (StorageModule) d.b(storageModule2);
            return this;
        }

        public Builder supportApplicationModule(SupportApplicationModule supportApplicationModule2) {
            this.supportApplicationModule = (SupportApplicationModule) d.b(supportApplicationModule2);
            return this;
        }

        private Builder() {
        }
    }

    public static final class SupportSdkProvidersComponentImpl implements SupportSdkProvidersComponent {
        private final CoreModule coreModule;
        private a<Context> getApplicationContextProvider;
        private a<AuthenticationProvider> getAuthenticationProvider;
        private a<BlipsProvider> getBlipsProvider;
        private a<MemoryCache> getMemoryCacheProvider;
        private a<RestServiceProvider> getRestServiceProvider;
        private a<SessionStorage> getSessionStorageProvider;
        private a<SettingsProvider> getSettingsProvider;
        private a<Locale> provideLocaleProvider;
        private a<SupportSdkMetadata> provideMetadataProvider;
        private a<ProviderStore> provideProviderStoreProvider;
        private a<RequestMigrator> provideRequestMigratorProvider;
        private a<RequestProvider> provideRequestProvider;
        private a<RequestSessionCache> provideRequestSessionCacheProvider;
        private a<RequestStorage> provideRequestStorageProvider;
        private a<SupportSettingsProvider> provideSdkSettingsProvider;
        private a<SupportBlipsProvider> provideSupportBlipsProvider;
        private a<SupportModule> provideSupportModuleProvider;
        private a<UploadProvider> provideUploadProvider;
        private a<ZendeskLocaleConverter> provideZendeskLocaleConverterProvider;
        private a<ZendeskRequestService> provideZendeskRequestServiceProvider;
        private a<ZendeskUploadService> provideZendeskUploadServiceProvider;
        private a<ArticleVoteStorage> providesArticleVoteStorageProvider;
        private a<HelpCenterProvider> providesHelpCenterProvider;
        private a<RequestService> providesRequestServiceProvider;
        private a<UploadService> providesUploadServiceProvider;
        private a<ZendeskTracker> providesZendeskTrackerProvider;
        private final SupportSdkProvidersComponentImpl supportSdkProvidersComponentImpl;

        private void initialize(SupportApplicationModule supportApplicationModule, CoreModule coreModule2, ProviderModule providerModule, GuideModule guideModule, StorageModule storageModule) {
            this.providesHelpCenterProvider = GuideModule_ProvidesHelpCenterProviderFactory.create(guideModule);
            this.getSettingsProvider = CoreModule_GetSettingsProviderFactory.create(coreModule2);
            this.provideLocaleProvider = dagger.internal.a.a(SupportApplicationModule_ProvideLocaleFactory.create(supportApplicationModule));
            a<ZendeskLocaleConverter> a11 = dagger.internal.a.a(ProviderModule_ProvideZendeskLocaleConverterFactory.create(providerModule));
            this.provideZendeskLocaleConverterProvider = a11;
            this.provideSdkSettingsProvider = dagger.internal.a.a(ProviderModule_ProvideSdkSettingsProviderFactory.create(providerModule, this.getSettingsProvider, this.provideLocaleProvider, a11));
            this.getAuthenticationProvider = CoreModule_GetAuthenticationProviderFactory.create(coreModule2);
            CoreModule_GetRestServiceProviderFactory create = CoreModule_GetRestServiceProviderFactory.create(coreModule2);
            this.getRestServiceProvider = create;
            a<RequestService> a12 = dagger.internal.a.a(ServiceModule_ProvidesRequestServiceFactory.create(create));
            this.providesRequestServiceProvider = a12;
            this.provideZendeskRequestServiceProvider = dagger.internal.a.a(ServiceModule_ProvideZendeskRequestServiceFactory.create(a12));
            this.getSessionStorageProvider = CoreModule_GetSessionStorageFactory.create(coreModule2);
            CoreModule_GetApplicationContextFactory create2 = CoreModule_GetApplicationContextFactory.create(coreModule2);
            this.getApplicationContextProvider = create2;
            this.provideRequestMigratorProvider = dagger.internal.a.a(StorageModule_ProvideRequestMigratorFactory.create(storageModule, create2));
            CoreModule_GetMemoryCacheFactory create3 = CoreModule_GetMemoryCacheFactory.create(coreModule2);
            this.getMemoryCacheProvider = create3;
            this.provideRequestStorageProvider = dagger.internal.a.a(StorageModule_ProvideRequestStorageFactory.create(storageModule, this.getSessionStorageProvider, this.provideRequestMigratorProvider, create3));
            this.provideRequestSessionCacheProvider = dagger.internal.a.a(StorageModule_ProvideRequestSessionCacheFactory.create(storageModule));
            this.providesZendeskTrackerProvider = dagger.internal.a.a(SupportApplicationModule_ProvidesZendeskTrackerFactory.create(supportApplicationModule));
            this.provideMetadataProvider = dagger.internal.a.a(SupportApplicationModule_ProvideMetadataFactory.create(supportApplicationModule, this.getApplicationContextProvider));
            CoreModule_GetBlipsProviderFactory create4 = CoreModule_GetBlipsProviderFactory.create(coreModule2);
            this.getBlipsProvider = create4;
            a<SupportBlipsProvider> a13 = dagger.internal.a.a(ProviderModule_ProvideSupportBlipsProviderFactory.create(providerModule, create4));
            this.provideSupportBlipsProvider = a13;
            ProviderModule providerModule2 = providerModule;
            this.provideRequestProvider = dagger.internal.a.a(ProviderModule_ProvideRequestProviderFactory.create(providerModule2, this.provideSdkSettingsProvider, this.getAuthenticationProvider, this.provideZendeskRequestServiceProvider, this.provideRequestStorageProvider, this.provideRequestSessionCacheProvider, this.providesZendeskTrackerProvider, this.provideMetadataProvider, a13));
            a<UploadService> a14 = dagger.internal.a.a(ServiceModule_ProvidesUploadServiceFactory.create(this.getRestServiceProvider));
            this.providesUploadServiceProvider = a14;
            a<ZendeskUploadService> a15 = dagger.internal.a.a(ServiceModule_ProvideZendeskUploadServiceFactory.create(a14));
            this.provideZendeskUploadServiceProvider = a15;
            a<UploadProvider> a16 = dagger.internal.a.a(ProviderModule_ProvideUploadProviderFactory.create(providerModule, a15));
            this.provideUploadProvider = a16;
            this.provideProviderStoreProvider = dagger.internal.a.a(ProviderModule_ProvideProviderStoreFactory.create(providerModule, this.providesHelpCenterProvider, this.provideRequestProvider, a16));
            GuideModule_ProvidesArticleVoteStorageFactory create5 = GuideModule_ProvidesArticleVoteStorageFactory.create(guideModule);
            this.providesArticleVoteStorageProvider = create5;
            this.provideSupportModuleProvider = dagger.internal.a.a(ProviderModule_ProvideSupportModuleFactory.create(providerModule2, this.provideRequestProvider, this.provideUploadProvider, this.providesHelpCenterProvider, this.provideSdkSettingsProvider, this.getRestServiceProvider, this.provideSupportBlipsProvider, this.providesZendeskTrackerProvider, create5));
        }

        private Support injectSupport(Support support) {
            Support_MembersInjector.injectProviderStore(support, this.provideProviderStoreProvider.get());
            Support_MembersInjector.injectSupportModule(support, this.provideSupportModuleProvider.get());
            Support_MembersInjector.injectRequestMigrator(support, this.provideRequestMigratorProvider.get());
            Support_MembersInjector.injectBlipsProvider(support, this.provideSupportBlipsProvider.get());
            Support_MembersInjector.injectActionHandlerRegistry(support, CoreModule_ActionHandlerRegistryFactory.actionHandlerRegistry(this.coreModule));
            Support_MembersInjector.injectRequestProvider(support, this.provideRequestProvider.get());
            Support_MembersInjector.injectAuthenticationProvider(support, CoreModule_GetAuthenticationProviderFactory.getAuthenticationProvider(this.coreModule));
            return support;
        }

        public Support inject(Support support) {
            return injectSupport(support);
        }

        private SupportSdkProvidersComponentImpl(SupportApplicationModule supportApplicationModule, CoreModule coreModule2, ProviderModule providerModule, GuideModule guideModule, StorageModule storageModule) {
            this.supportSdkProvidersComponentImpl = this;
            this.coreModule = coreModule2;
            initialize(supportApplicationModule, coreModule2, providerModule, guideModule, storageModule);
        }
    }

    private DaggerSupportSdkProvidersComponent() {
    }

    public static Builder builder() {
        return new Builder();
    }
}
