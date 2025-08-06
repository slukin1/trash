package zendesk.core;

import dagger.internal.b;
import dagger.internal.d;
import okhttp3.OkHttpClient;
import q00.a;

public final class ZendeskNetworkModule_ProvideCoreOkHttpClientFactory implements b<OkHttpClient> {
    private final a<AcceptHeaderInterceptor> acceptHeaderInterceptorProvider;
    private final a<AcceptLanguageHeaderInterceptor> acceptLanguageHeaderInterceptorProvider;
    private final ZendeskNetworkModule module;
    private final a<OkHttpClient> okHttpClientProvider;

    public ZendeskNetworkModule_ProvideCoreOkHttpClientFactory(ZendeskNetworkModule zendeskNetworkModule, a<OkHttpClient> aVar, a<AcceptLanguageHeaderInterceptor> aVar2, a<AcceptHeaderInterceptor> aVar3) {
        this.module = zendeskNetworkModule;
        this.okHttpClientProvider = aVar;
        this.acceptLanguageHeaderInterceptorProvider = aVar2;
        this.acceptHeaderInterceptorProvider = aVar3;
    }

    public static ZendeskNetworkModule_ProvideCoreOkHttpClientFactory create(ZendeskNetworkModule zendeskNetworkModule, a<OkHttpClient> aVar, a<AcceptLanguageHeaderInterceptor> aVar2, a<AcceptHeaderInterceptor> aVar3) {
        return new ZendeskNetworkModule_ProvideCoreOkHttpClientFactory(zendeskNetworkModule, aVar, aVar2, aVar3);
    }

    public static OkHttpClient provideCoreOkHttpClient(ZendeskNetworkModule zendeskNetworkModule, OkHttpClient okHttpClient, Object obj, Object obj2) {
        return (OkHttpClient) d.f(zendeskNetworkModule.provideCoreOkHttpClient(okHttpClient, (AcceptLanguageHeaderInterceptor) obj, (AcceptHeaderInterceptor) obj2));
    }

    public OkHttpClient get() {
        return provideCoreOkHttpClient(this.module, this.okHttpClientProvider.get(), this.acceptLanguageHeaderInterceptorProvider.get(), this.acceptHeaderInterceptorProvider.get());
    }
}
