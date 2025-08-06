package zendesk.core;

import dagger.internal.b;
import dagger.internal.d;
import okhttp3.OkHttpClient;
import q00.a;

public final class ZendeskNetworkModule_ProvideMediaOkHttpClientFactory implements b<OkHttpClient> {
    private final a<ZendeskAccessInterceptor> accessInterceptorProvider;
    private final a<ZendeskAuthHeaderInterceptor> authHeaderInterceptorProvider;
    private final a<CachingInterceptor> cachingInterceptorProvider;
    private final ZendeskNetworkModule module;
    private final a<OkHttpClient> okHttpClientProvider;
    private final a<ZendeskSettingsInterceptor> settingsInterceptorProvider;
    private final a<ZendeskUnauthorizedInterceptor> unauthorizedInterceptorProvider;

    public ZendeskNetworkModule_ProvideMediaOkHttpClientFactory(ZendeskNetworkModule zendeskNetworkModule, a<OkHttpClient> aVar, a<ZendeskAccessInterceptor> aVar2, a<ZendeskAuthHeaderInterceptor> aVar3, a<ZendeskSettingsInterceptor> aVar4, a<CachingInterceptor> aVar5, a<ZendeskUnauthorizedInterceptor> aVar6) {
        this.module = zendeskNetworkModule;
        this.okHttpClientProvider = aVar;
        this.accessInterceptorProvider = aVar2;
        this.authHeaderInterceptorProvider = aVar3;
        this.settingsInterceptorProvider = aVar4;
        this.cachingInterceptorProvider = aVar5;
        this.unauthorizedInterceptorProvider = aVar6;
    }

    public static ZendeskNetworkModule_ProvideMediaOkHttpClientFactory create(ZendeskNetworkModule zendeskNetworkModule, a<OkHttpClient> aVar, a<ZendeskAccessInterceptor> aVar2, a<ZendeskAuthHeaderInterceptor> aVar3, a<ZendeskSettingsInterceptor> aVar4, a<CachingInterceptor> aVar5, a<ZendeskUnauthorizedInterceptor> aVar6) {
        return new ZendeskNetworkModule_ProvideMediaOkHttpClientFactory(zendeskNetworkModule, aVar, aVar2, aVar3, aVar4, aVar5, aVar6);
    }

    public static OkHttpClient provideMediaOkHttpClient(ZendeskNetworkModule zendeskNetworkModule, OkHttpClient okHttpClient, Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        return (OkHttpClient) d.f(zendeskNetworkModule.provideMediaOkHttpClient(okHttpClient, (ZendeskAccessInterceptor) obj, (ZendeskAuthHeaderInterceptor) obj2, (ZendeskSettingsInterceptor) obj3, (CachingInterceptor) obj4, (ZendeskUnauthorizedInterceptor) obj5));
    }

    public OkHttpClient get() {
        return provideMediaOkHttpClient(this.module, this.okHttpClientProvider.get(), this.accessInterceptorProvider.get(), this.authHeaderInterceptorProvider.get(), this.settingsInterceptorProvider.get(), this.cachingInterceptorProvider.get(), this.unauthorizedInterceptorProvider.get());
    }
}
