package zendesk.core;

import dagger.internal.b;
import dagger.internal.d;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import q00.a;

public final class ZendeskNetworkModule_ProvideOkHttpClientFactory implements b<OkHttpClient> {
    private final a<AcceptHeaderInterceptor> acceptHeaderInterceptorProvider;
    private final a<ZendeskAccessInterceptor> accessInterceptorProvider;
    private final a<ZendeskAuthHeaderInterceptor> authHeaderInterceptorProvider;
    private final a<Cache> cacheProvider;
    private final ZendeskNetworkModule module;
    private final a<OkHttpClient> okHttpClientProvider;
    private final a<ZendeskPushInterceptor> pushInterceptorProvider;
    private final a<ZendeskSettingsInterceptor> settingsInterceptorProvider;
    private final a<ZendeskUnauthorizedInterceptor> unauthorizedInterceptorProvider;

    public ZendeskNetworkModule_ProvideOkHttpClientFactory(ZendeskNetworkModule zendeskNetworkModule, a<OkHttpClient> aVar, a<ZendeskAccessInterceptor> aVar2, a<ZendeskUnauthorizedInterceptor> aVar3, a<ZendeskAuthHeaderInterceptor> aVar4, a<ZendeskSettingsInterceptor> aVar5, a<AcceptHeaderInterceptor> aVar6, a<ZendeskPushInterceptor> aVar7, a<Cache> aVar8) {
        this.module = zendeskNetworkModule;
        this.okHttpClientProvider = aVar;
        this.accessInterceptorProvider = aVar2;
        this.unauthorizedInterceptorProvider = aVar3;
        this.authHeaderInterceptorProvider = aVar4;
        this.settingsInterceptorProvider = aVar5;
        this.acceptHeaderInterceptorProvider = aVar6;
        this.pushInterceptorProvider = aVar7;
        this.cacheProvider = aVar8;
    }

    public static ZendeskNetworkModule_ProvideOkHttpClientFactory create(ZendeskNetworkModule zendeskNetworkModule, a<OkHttpClient> aVar, a<ZendeskAccessInterceptor> aVar2, a<ZendeskUnauthorizedInterceptor> aVar3, a<ZendeskAuthHeaderInterceptor> aVar4, a<ZendeskSettingsInterceptor> aVar5, a<AcceptHeaderInterceptor> aVar6, a<ZendeskPushInterceptor> aVar7, a<Cache> aVar8) {
        return new ZendeskNetworkModule_ProvideOkHttpClientFactory(zendeskNetworkModule, aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7, aVar8);
    }

    public static OkHttpClient provideOkHttpClient(ZendeskNetworkModule zendeskNetworkModule, OkHttpClient okHttpClient, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Cache cache) {
        return (OkHttpClient) d.f(zendeskNetworkModule.provideOkHttpClient(okHttpClient, (ZendeskAccessInterceptor) obj, (ZendeskUnauthorizedInterceptor) obj2, (ZendeskAuthHeaderInterceptor) obj3, (ZendeskSettingsInterceptor) obj4, (AcceptHeaderInterceptor) obj5, (ZendeskPushInterceptor) obj6, cache));
    }

    public OkHttpClient get() {
        return provideOkHttpClient(this.module, this.okHttpClientProvider.get(), this.accessInterceptorProvider.get(), this.unauthorizedInterceptorProvider.get(), this.authHeaderInterceptorProvider.get(), this.settingsInterceptorProvider.get(), this.acceptHeaderInterceptorProvider.get(), this.pushInterceptorProvider.get(), this.cacheProvider.get());
    }
}
