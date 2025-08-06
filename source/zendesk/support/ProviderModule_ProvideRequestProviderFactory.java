package zendesk.support;

import dagger.internal.b;
import dagger.internal.d;
import q00.a;
import zendesk.core.AuthenticationProvider;

public final class ProviderModule_ProvideRequestProviderFactory implements b<RequestProvider> {
    private final a<AuthenticationProvider> authenticationProvider;
    private final a<SupportBlipsProvider> blipsProvider;
    private final ProviderModule module;
    private final a<ZendeskRequestService> requestServiceProvider;
    private final a<RequestSessionCache> requestSessionCacheProvider;
    private final a<RequestStorage> requestStorageProvider;
    private final a<SupportSettingsProvider> settingsProvider;
    private final a<SupportSdkMetadata> supportSdkMetadataProvider;
    private final a<ZendeskTracker> zendeskTrackerProvider;

    public ProviderModule_ProvideRequestProviderFactory(ProviderModule providerModule, a<SupportSettingsProvider> aVar, a<AuthenticationProvider> aVar2, a<ZendeskRequestService> aVar3, a<RequestStorage> aVar4, a<RequestSessionCache> aVar5, a<ZendeskTracker> aVar6, a<SupportSdkMetadata> aVar7, a<SupportBlipsProvider> aVar8) {
        this.module = providerModule;
        this.settingsProvider = aVar;
        this.authenticationProvider = aVar2;
        this.requestServiceProvider = aVar3;
        this.requestStorageProvider = aVar4;
        this.requestSessionCacheProvider = aVar5;
        this.zendeskTrackerProvider = aVar6;
        this.supportSdkMetadataProvider = aVar7;
        this.blipsProvider = aVar8;
    }

    public static ProviderModule_ProvideRequestProviderFactory create(ProviderModule providerModule, a<SupportSettingsProvider> aVar, a<AuthenticationProvider> aVar2, a<ZendeskRequestService> aVar3, a<RequestStorage> aVar4, a<RequestSessionCache> aVar5, a<ZendeskTracker> aVar6, a<SupportSdkMetadata> aVar7, a<SupportBlipsProvider> aVar8) {
        return new ProviderModule_ProvideRequestProviderFactory(providerModule, aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7, aVar8);
    }

    public static RequestProvider provideRequestProvider(ProviderModule providerModule, SupportSettingsProvider supportSettingsProvider, AuthenticationProvider authenticationProvider2, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, SupportBlipsProvider supportBlipsProvider) {
        return (RequestProvider) d.f(providerModule.provideRequestProvider(supportSettingsProvider, authenticationProvider2, (ZendeskRequestService) obj, (RequestStorage) obj2, (RequestSessionCache) obj3, (ZendeskTracker) obj4, (SupportSdkMetadata) obj5, supportBlipsProvider));
    }

    public RequestProvider get() {
        return provideRequestProvider(this.module, this.settingsProvider.get(), this.authenticationProvider.get(), this.requestServiceProvider.get(), this.requestStorageProvider.get(), this.requestSessionCacheProvider.get(), this.zendeskTrackerProvider.get(), this.supportSdkMetadataProvider.get(), this.blipsProvider.get());
    }
}
