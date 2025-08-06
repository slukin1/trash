package zendesk.core;

import android.content.Context;
import android.net.ConnectivityManager;
import com.google.gson.Gson;
import dagger.internal.d;
import dagger.internal.e;
import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import q00.a;
import retrofit2.Retrofit;

final class DaggerZendeskApplicationComponent {

    public static final class Builder {
        private ZendeskApplicationModule zendeskApplicationModule;
        private ZendeskNetworkModule zendeskNetworkModule;

        public ZendeskApplicationComponent build() {
            d.a(this.zendeskApplicationModule, ZendeskApplicationModule.class);
            if (this.zendeskNetworkModule == null) {
                this.zendeskNetworkModule = new ZendeskNetworkModule();
            }
            return new ZendeskApplicationComponentImpl(this.zendeskApplicationModule, this.zendeskNetworkModule);
        }

        public Builder zendeskApplicationModule(ZendeskApplicationModule zendeskApplicationModule2) {
            this.zendeskApplicationModule = (ZendeskApplicationModule) d.b(zendeskApplicationModule2);
            return this;
        }

        public Builder zendeskNetworkModule(ZendeskNetworkModule zendeskNetworkModule2) {
            this.zendeskNetworkModule = (ZendeskNetworkModule) d.b(zendeskNetworkModule2);
            return this;
        }

        @Deprecated
        public Builder zendeskProvidersModule(ZendeskProvidersModule zendeskProvidersModule) {
            d.b(zendeskProvidersModule);
            return this;
        }

        @Deprecated
        public Builder zendeskStorageModule(ZendeskStorageModule zendeskStorageModule) {
            d.b(zendeskStorageModule);
            return this;
        }

        private Builder() {
        }
    }

    public static final class ZendeskApplicationComponentImpl implements ZendeskApplicationComponent {
        private a<ActionHandlerRegistry> actionHandlerRegistryProvider;
        private a<AcceptLanguageHeaderInterceptor> provideAcceptLanguageHeaderInterceptorProvider;
        private a<ZendeskAccessInterceptor> provideAccessInterceptorProvider;
        private a<AccessProvider> provideAccessProvider;
        private a<AccessService> provideAccessServiceProvider;
        private a<BaseStorage> provideAdditionalSdkBaseStorageProvider;
        private a<ApplicationConfiguration> provideApplicationConfigurationProvider;
        private a<Context> provideApplicationContextProvider;
        private a<ZendeskAuthHeaderInterceptor> provideAuthHeaderInterceptorProvider;
        private a<AuthenticationProvider> provideAuthProvider;
        private a<Serializer> provideBase64SerializerProvider;
        private a<OkHttpClient> provideBaseOkHttpClientProvider;
        private a<BlipsService> provideBlipsServiceProvider;
        private a<Cache> provideCacheProvider;
        private a<CachingInterceptor> provideCachingInterceptorProvider;
        private a<OkHttpClient> provideCoreOkHttpClientProvider;
        private a<Retrofit> provideCoreRetrofitProvider;
        private a<CoreModule> provideCoreSdkModuleProvider;
        private a<CoreSettingsStorage> provideCoreSettingsStorageProvider;
        private a<DeviceInfo> provideDeviceInfoProvider;
        private a<ScheduledExecutorService> provideExecutorProvider;
        private a<ExecutorService> provideExecutorServiceProvider;
        private a<Gson> provideGsonProvider;
        private a<HttpLoggingInterceptor> provideHttpLoggingInterceptorProvider;
        private a<BaseStorage> provideIdentityBaseStorageProvider;
        private a<IdentityManager> provideIdentityManagerProvider;
        private a<IdentityStorage> provideIdentityStorageProvider;
        private a<SharedPreferencesStorage> provideLegacyIdentityBaseStorageProvider;
        private a<LegacyIdentityMigrator> provideLegacyIdentityStorageProvider;
        private a<SharedPreferencesStorage> provideLegacyPushBaseStorageProvider;
        private a<MachineIdStorage> provideMachineIdStorageProvider;
        private a<OkHttpClient> provideMediaOkHttpClientProvider;
        private a<MemoryCache> provideMemoryCacheProvider;
        private a<OkHttpClient> provideOkHttpClientProvider;
        private a<ProviderStore> provideProviderStoreProvider;
        private a<PushDeviceIdStorage> providePushDeviceIdStorageProvider;
        private a<ZendeskPushInterceptor> providePushInterceptorProvider;
        private a<Retrofit> providePushProviderRetrofitProvider;
        private a<PushRegistrationProvider> providePushRegistrationProvider;
        private a<PushRegistrationProviderInternal> providePushRegistrationProviderInternalProvider;
        private a<PushRegistrationService> providePushRegistrationServiceProvider;
        private a<RestServiceProvider> provideRestServiceProvider;
        private a<Retrofit> provideRetrofitProvider;
        private a<BaseStorage> provideSdkBaseStorageProvider;
        private a<SettingsProvider> provideSdkSettingsProvider;
        private a<SdkSettingsProviderInternal> provideSdkSettingsProviderInternalProvider;
        private a<SdkSettingsService> provideSdkSettingsServiceProvider;
        private a<Storage> provideSdkStorageProvider;
        private a<Serializer> provideSerializerProvider;
        private a<SessionStorage> provideSessionStorageProvider;
        private a<BaseStorage> provideSettingsBaseStorageProvider;
        private a<ZendeskSettingsInterceptor> provideSettingsInterceptorProvider;
        private a<SettingsStorage> provideSettingsStorageProvider;
        private a<UserProvider> provideUserProvider;
        private a<UserService> provideUserServiceProvider;
        private a<ZendeskOauthIdHeaderInterceptor> provideZendeskBasicHeadersInterceptorProvider;
        private a<ZendeskLocaleConverter> provideZendeskLocaleConverterProvider;
        private a<ZendeskShadow> provideZendeskProvider;
        private a<ZendeskSettingsProvider> provideZendeskSdkSettingsProvider;
        private a<ZendeskUnauthorizedInterceptor> provideZendeskUnauthorizedInterceptorProvider;
        private a<BlipsCoreProvider> providerBlipsCoreProvider;
        private a<BlipsProvider> providerBlipsProvider;
        private a<ConnectivityManager> providerConnectivityManagerProvider;
        private a<NetworkInfoProvider> providerNetworkInfoProvider;
        private a<ZendeskBlipsProvider> providerZendeskBlipsProvider;
        private a<AcceptHeaderInterceptor> providesAcceptHeaderInterceptorProvider;
        private a<File> providesBelvedereDirProvider;
        private a<File> providesCacheDirProvider;
        private a<File> providesDataDirProvider;
        private a<BaseStorage> providesDiskLruStorageProvider;
        private a<UserAgentAndClientHeadersInterceptor> providesUserAgentHeaderInterceptorProvider;
        private final ZendeskApplicationComponentImpl zendeskApplicationComponentImpl;

        private void initialize(ZendeskApplicationModule zendeskApplicationModule, ZendeskNetworkModule zendeskNetworkModule) {
            this.provideApplicationContextProvider = dagger.internal.a.a(ZendeskApplicationModule_ProvideApplicationContextFactory.create(zendeskApplicationModule));
            a<Gson> a11 = e.a(ZendeskApplicationModule_ProvideGsonFactory.create());
            this.provideGsonProvider = a11;
            a<Serializer> a12 = dagger.internal.a.a(ZendeskStorageModule_ProvideSerializerFactory.create(a11));
            this.provideSerializerProvider = a12;
            a<BaseStorage> a13 = dagger.internal.a.a(ZendeskStorageModule_ProvideSettingsBaseStorageFactory.create(this.provideApplicationContextProvider, a12));
            this.provideSettingsBaseStorageProvider = a13;
            this.provideSettingsStorageProvider = dagger.internal.a.a(ZendeskStorageModule_ProvideSettingsStorageFactory.create(a13));
            a<BaseStorage> a14 = dagger.internal.a.a(ZendeskStorageModule_ProvideIdentityBaseStorageFactory.create(this.provideApplicationContextProvider, this.provideSerializerProvider));
            this.provideIdentityBaseStorageProvider = a14;
            this.provideIdentityStorageProvider = dagger.internal.a.a(ZendeskStorageModule_ProvideIdentityStorageFactory.create(a14));
            this.provideAdditionalSdkBaseStorageProvider = dagger.internal.a.a(ZendeskStorageModule_ProvideAdditionalSdkBaseStorageFactory.create(this.provideApplicationContextProvider, this.provideSerializerProvider));
            a<File> a15 = dagger.internal.a.a(ZendeskStorageModule_ProvidesCacheDirFactory.create(this.provideApplicationContextProvider));
            this.providesCacheDirProvider = a15;
            this.providesDiskLruStorageProvider = dagger.internal.a.a(ZendeskStorageModule_ProvidesDiskLruStorageFactory.create(a15, this.provideSerializerProvider));
            this.provideCacheProvider = dagger.internal.a.a(ZendeskStorageModule_ProvideCacheFactory.create(this.providesCacheDirProvider));
            this.providesDataDirProvider = dagger.internal.a.a(ZendeskStorageModule_ProvidesDataDirFactory.create(this.provideApplicationContextProvider));
            a<File> a16 = dagger.internal.a.a(ZendeskStorageModule_ProvidesBelvedereDirFactory.create(this.provideApplicationContextProvider));
            this.providesBelvedereDirProvider = a16;
            this.provideSessionStorageProvider = dagger.internal.a.a(ZendeskStorageModule_ProvideSessionStorageFactory.create(this.provideIdentityStorageProvider, this.provideAdditionalSdkBaseStorageProvider, this.providesDiskLruStorageProvider, this.provideCacheProvider, this.providesCacheDirProvider, this.providesDataDirProvider, a16));
            this.provideSdkBaseStorageProvider = dagger.internal.a.a(ZendeskStorageModule_ProvideSdkBaseStorageFactory.create(this.provideApplicationContextProvider, this.provideSerializerProvider));
            a<MemoryCache> a17 = dagger.internal.a.a(ZendeskStorageModule_ProvideMemoryCacheFactory.create());
            this.provideMemoryCacheProvider = a17;
            this.provideSdkStorageProvider = dagger.internal.a.a(ZendeskStorageModule_ProvideSdkStorageFactory.create(this.provideSettingsStorageProvider, this.provideSessionStorageProvider, this.provideSdkBaseStorageProvider, a17));
            this.provideLegacyIdentityBaseStorageProvider = dagger.internal.a.a(ZendeskStorageModule_ProvideLegacyIdentityBaseStorageFactory.create(this.provideApplicationContextProvider, this.provideSerializerProvider));
            this.provideLegacyPushBaseStorageProvider = dagger.internal.a.a(ZendeskStorageModule_ProvideLegacyPushBaseStorageFactory.create(this.provideApplicationContextProvider, this.provideSerializerProvider));
            this.provideIdentityManagerProvider = dagger.internal.a.a(ZendeskStorageModule_ProvideIdentityManagerFactory.create(this.provideIdentityStorageProvider));
            a<PushDeviceIdStorage> a18 = dagger.internal.a.a(ZendeskStorageModule_ProvidePushDeviceIdStorageFactory.create(this.provideAdditionalSdkBaseStorageProvider));
            this.providePushDeviceIdStorageProvider = a18;
            this.provideLegacyIdentityStorageProvider = dagger.internal.a.a(ZendeskStorageModule_ProvideLegacyIdentityStorageFactory.create(this.provideLegacyIdentityBaseStorageProvider, this.provideLegacyPushBaseStorageProvider, this.provideIdentityStorageProvider, this.provideIdentityManagerProvider, a18));
            this.provideApplicationConfigurationProvider = dagger.internal.a.a(ZendeskApplicationModule_ProvideApplicationConfigurationFactory.create(zendeskApplicationModule));
            this.provideHttpLoggingInterceptorProvider = e.a(ZendeskApplicationModule_ProvideHttpLoggingInterceptorFactory.create());
            this.provideZendeskBasicHeadersInterceptorProvider = e.a(ZendeskNetworkModule_ProvideZendeskBasicHeadersInterceptorFactory.create(zendeskNetworkModule, this.provideApplicationConfigurationProvider));
            this.providesUserAgentHeaderInterceptorProvider = e.a(ZendeskNetworkModule_ProvidesUserAgentHeaderInterceptorFactory.create(zendeskNetworkModule));
            a<ScheduledExecutorService> a19 = dagger.internal.a.a(ZendeskApplicationModule_ProvideExecutorFactory.create());
            this.provideExecutorProvider = a19;
            a<ExecutorService> a21 = dagger.internal.a.a(ZendeskApplicationModule_ProvideExecutorServiceFactory.create(a19));
            this.provideExecutorServiceProvider = a21;
            this.provideBaseOkHttpClientProvider = dagger.internal.a.a(ZendeskNetworkModule_ProvideBaseOkHttpClientFactory.create(zendeskNetworkModule, this.provideHttpLoggingInterceptorProvider, this.provideZendeskBasicHeadersInterceptorProvider, this.providesUserAgentHeaderInterceptorProvider, a21));
            this.provideAcceptLanguageHeaderInterceptorProvider = e.a(ZendeskNetworkModule_ProvideAcceptLanguageHeaderInterceptorFactory.create(this.provideApplicationContextProvider));
            a<AcceptHeaderInterceptor> a22 = e.a(ZendeskNetworkModule_ProvidesAcceptHeaderInterceptorFactory.create());
            this.providesAcceptHeaderInterceptorProvider = a22;
            a<OkHttpClient> a23 = dagger.internal.a.a(ZendeskNetworkModule_ProvideCoreOkHttpClientFactory.create(zendeskNetworkModule, this.provideBaseOkHttpClientProvider, this.provideAcceptLanguageHeaderInterceptorProvider, a22));
            this.provideCoreOkHttpClientProvider = a23;
            a<Retrofit> a24 = dagger.internal.a.a(ZendeskNetworkModule_ProvideCoreRetrofitFactory.create(this.provideApplicationConfigurationProvider, this.provideGsonProvider, a23));
            this.provideCoreRetrofitProvider = a24;
            this.provideBlipsServiceProvider = dagger.internal.a.a(ZendeskProvidersModule_ProvideBlipsServiceFactory.create(a24));
            this.provideDeviceInfoProvider = dagger.internal.a.a(ZendeskApplicationModule_ProvideDeviceInfoFactory.create(this.provideApplicationContextProvider));
            this.provideBase64SerializerProvider = e.a(ZendeskApplicationModule_ProvideBase64SerializerFactory.create(zendeskApplicationModule, this.provideSerializerProvider));
            a<CoreSettingsStorage> a25 = dagger.internal.a.a(ZendeskStorageModule_ProvideCoreSettingsStorageFactory.create(this.provideSettingsStorageProvider));
            this.provideCoreSettingsStorageProvider = a25;
            a<ZendeskBlipsProvider> a26 = dagger.internal.a.a(ZendeskProvidersModule_ProviderZendeskBlipsProviderFactory.create(this.provideBlipsServiceProvider, this.provideDeviceInfoProvider, this.provideBase64SerializerProvider, this.provideIdentityManagerProvider, this.provideApplicationConfigurationProvider, a25, this.provideExecutorServiceProvider));
            this.providerZendeskBlipsProvider = a26;
            this.providerBlipsCoreProvider = dagger.internal.a.a(ZendeskProvidersModule_ProviderBlipsCoreProviderFactory.create(a26));
            a<ZendeskAuthHeaderInterceptor> a27 = e.a(ZendeskNetworkModule_ProvideAuthHeaderInterceptorFactory.create(this.provideIdentityManagerProvider));
            this.provideAuthHeaderInterceptorProvider = a27;
            a<Retrofit> a28 = dagger.internal.a.a(ZendeskNetworkModule_ProvidePushProviderRetrofitFactory.create(this.provideApplicationConfigurationProvider, this.provideGsonProvider, this.provideCoreOkHttpClientProvider, a27));
            this.providePushProviderRetrofitProvider = a28;
            this.providePushRegistrationServiceProvider = e.a(ZendeskProvidersModule_ProvidePushRegistrationServiceFactory.create(a28));
            this.provideSdkSettingsServiceProvider = e.a(ZendeskProvidersModule_ProvideSdkSettingsServiceFactory.create(this.provideCoreRetrofitProvider));
            this.actionHandlerRegistryProvider = dagger.internal.a.a(ZendeskProvidersModule_ActionHandlerRegistryFactory.create());
            a<ZendeskLocaleConverter> a29 = dagger.internal.a.a(ZendeskApplicationModule_ProvideZendeskLocaleConverterFactory.create(zendeskApplicationModule));
            this.provideZendeskLocaleConverterProvider = a29;
            a<ZendeskSettingsProvider> a31 = dagger.internal.a.a(ZendeskProvidersModule_ProvideZendeskSdkSettingsProviderFactory.create(this.provideSdkSettingsServiceProvider, this.provideSettingsStorageProvider, this.provideCoreSettingsStorageProvider, this.actionHandlerRegistryProvider, this.provideSerializerProvider, a29, this.provideApplicationConfigurationProvider, this.provideApplicationContextProvider));
            this.provideZendeskSdkSettingsProvider = a31;
            a<SettingsProvider> a32 = dagger.internal.a.a(ZendeskProvidersModule_ProvideSdkSettingsProviderFactory.create(a31));
            this.provideSdkSettingsProvider = a32;
            this.providePushRegistrationProvider = dagger.internal.a.a(ZendeskProvidersModule_ProvidePushRegistrationProviderFactory.create(this.providePushRegistrationServiceProvider, this.provideIdentityManagerProvider, a32, this.providerBlipsCoreProvider, this.providePushDeviceIdStorageProvider, this.provideApplicationContextProvider));
            a<AccessService> a33 = e.a(ZendeskProvidersModule_ProvideAccessServiceFactory.create(this.provideCoreRetrofitProvider));
            this.provideAccessServiceProvider = a33;
            a<AccessProvider> a34 = dagger.internal.a.a(ZendeskProvidersModule_ProvideAccessProviderFactory.create(this.provideIdentityManagerProvider, a33));
            this.provideAccessProvider = a34;
            this.provideAccessInterceptorProvider = e.a(ZendeskNetworkModule_ProvideAccessInterceptorFactory.create(this.provideIdentityManagerProvider, a34, this.provideSdkStorageProvider, this.provideCoreSettingsStorageProvider));
            this.provideZendeskUnauthorizedInterceptorProvider = e.a(ZendeskNetworkModule_ProvideZendeskUnauthorizedInterceptorFactory.create(this.provideSessionStorageProvider, this.provideIdentityManagerProvider));
            a<SdkSettingsProviderInternal> a35 = dagger.internal.a.a(ZendeskProvidersModule_ProvideSdkSettingsProviderInternalFactory.create(this.provideZendeskSdkSettingsProvider));
            this.provideSdkSettingsProviderInternalProvider = a35;
            this.provideSettingsInterceptorProvider = e.a(ZendeskNetworkModule_ProvideSettingsInterceptorFactory.create(a35, this.provideSettingsStorageProvider));
            a<PushRegistrationProviderInternal> a36 = dagger.internal.a.a(ZendeskProvidersModule_ProvidePushRegistrationProviderInternalFactory.create(this.providePushRegistrationProvider));
            this.providePushRegistrationProviderInternalProvider = a36;
            a<ZendeskPushInterceptor> a37 = e.a(ZendeskNetworkModule_ProvidePushInterceptorFactory.create(a36, this.providePushDeviceIdStorageProvider, this.provideIdentityStorageProvider));
            this.providePushInterceptorProvider = a37;
            a<OkHttpClient> a38 = dagger.internal.a.a(ZendeskNetworkModule_ProvideOkHttpClientFactory.create(zendeskNetworkModule, this.provideBaseOkHttpClientProvider, this.provideAccessInterceptorProvider, this.provideZendeskUnauthorizedInterceptorProvider, this.provideAuthHeaderInterceptorProvider, this.provideSettingsInterceptorProvider, this.providesAcceptHeaderInterceptorProvider, a37, this.provideCacheProvider));
            this.provideOkHttpClientProvider = a38;
            this.provideRetrofitProvider = dagger.internal.a.a(ZendeskNetworkModule_ProvideRetrofitFactory.create(this.provideApplicationConfigurationProvider, this.provideGsonProvider, a38));
            a<CachingInterceptor> a39 = e.a(ZendeskNetworkModule_ProvideCachingInterceptorFactory.create(this.providesDiskLruStorageProvider));
            this.provideCachingInterceptorProvider = a39;
            a<OkHttpClient> a40 = dagger.internal.a.a(ZendeskNetworkModule_ProvideMediaOkHttpClientFactory.create(zendeskNetworkModule, this.provideBaseOkHttpClientProvider, this.provideAccessInterceptorProvider, this.provideAuthHeaderInterceptorProvider, this.provideSettingsInterceptorProvider, a39, this.provideZendeskUnauthorizedInterceptorProvider));
            this.provideMediaOkHttpClientProvider = a40;
            this.provideRestServiceProvider = dagger.internal.a.a(ZendeskNetworkModule_ProvideRestServiceProviderFactory.create(zendeskNetworkModule, this.provideRetrofitProvider, a40, this.provideOkHttpClientProvider, this.provideCoreOkHttpClientProvider));
            this.providerBlipsProvider = dagger.internal.a.a(ZendeskProvidersModule_ProviderBlipsProviderFactory.create(this.providerZendeskBlipsProvider));
            a<ConnectivityManager> a41 = dagger.internal.a.a(ZendeskProvidersModule_ProviderConnectivityManagerFactory.create(this.provideApplicationContextProvider));
            this.providerConnectivityManagerProvider = a41;
            this.providerNetworkInfoProvider = dagger.internal.a.a(ZendeskProvidersModule_ProviderNetworkInfoProviderFactory.create(a41));
            this.provideAuthProvider = dagger.internal.a.a(ZendeskStorageModule_ProvideAuthProviderFactory.create(this.provideIdentityManagerProvider));
            a<MachineIdStorage> a42 = dagger.internal.a.a(ZendeskStorageModule_ProvideMachineIdStorageFactory.create(this.provideApplicationContextProvider));
            this.provideMachineIdStorageProvider = a42;
            this.provideCoreSdkModuleProvider = e.a(ZendeskProvidersModule_ProvideCoreSdkModuleFactory.create(this.provideSdkSettingsProvider, this.provideRestServiceProvider, this.providerBlipsProvider, this.provideSessionStorageProvider, this.providerNetworkInfoProvider, this.provideMemoryCacheProvider, this.actionHandlerRegistryProvider, this.provideExecutorProvider, this.provideApplicationContextProvider, this.provideAuthProvider, this.provideApplicationConfigurationProvider, this.providePushRegistrationProvider, a42));
            a<UserService> a43 = e.a(ZendeskProvidersModule_ProvideUserServiceFactory.create(this.provideRetrofitProvider));
            this.provideUserServiceProvider = a43;
            a<UserProvider> a44 = dagger.internal.a.a(ZendeskProvidersModule_ProvideUserProviderFactory.create(a43));
            this.provideUserProvider = a44;
            a<ProviderStore> a45 = dagger.internal.a.a(ZendeskProvidersModule_ProvideProviderStoreFactory.create(a44, this.providePushRegistrationProvider));
            this.provideProviderStoreProvider = a45;
            this.provideZendeskProvider = dagger.internal.a.a(ZendeskApplicationModule_ProvideZendeskFactory.create(this.provideSdkStorageProvider, this.provideLegacyIdentityStorageProvider, this.provideIdentityManagerProvider, this.providerBlipsCoreProvider, this.providePushRegistrationProvider, this.provideCoreSdkModuleProvider, a45));
        }

        public ZendeskShadow zendeskShadow() {
            return this.provideZendeskProvider.get();
        }

        private ZendeskApplicationComponentImpl(ZendeskApplicationModule zendeskApplicationModule, ZendeskNetworkModule zendeskNetworkModule) {
            this.zendeskApplicationComponentImpl = this;
            initialize(zendeskApplicationModule, zendeskNetworkModule);
        }
    }

    private DaggerZendeskApplicationComponent() {
    }

    public static Builder builder() {
        return new Builder();
    }
}
