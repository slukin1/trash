package zendesk.core;

import dagger.internal.b;
import dagger.internal.d;
import okhttp3.OkHttpClient;
import q00.a;
import retrofit2.Retrofit;

public final class ZendeskNetworkModule_ProvideRestServiceProviderFactory implements b<RestServiceProvider> {
    private final a<OkHttpClient> coreOkHttpClientProvider;
    private final a<OkHttpClient> mediaOkHttpClientProvider;
    private final ZendeskNetworkModule module;
    private final a<Retrofit> retrofitProvider;
    private final a<OkHttpClient> standardOkHttpClientProvider;

    public ZendeskNetworkModule_ProvideRestServiceProviderFactory(ZendeskNetworkModule zendeskNetworkModule, a<Retrofit> aVar, a<OkHttpClient> aVar2, a<OkHttpClient> aVar3, a<OkHttpClient> aVar4) {
        this.module = zendeskNetworkModule;
        this.retrofitProvider = aVar;
        this.mediaOkHttpClientProvider = aVar2;
        this.standardOkHttpClientProvider = aVar3;
        this.coreOkHttpClientProvider = aVar4;
    }

    public static ZendeskNetworkModule_ProvideRestServiceProviderFactory create(ZendeskNetworkModule zendeskNetworkModule, a<Retrofit> aVar, a<OkHttpClient> aVar2, a<OkHttpClient> aVar3, a<OkHttpClient> aVar4) {
        return new ZendeskNetworkModule_ProvideRestServiceProviderFactory(zendeskNetworkModule, aVar, aVar2, aVar3, aVar4);
    }

    public static RestServiceProvider provideRestServiceProvider(ZendeskNetworkModule zendeskNetworkModule, Retrofit retrofit, OkHttpClient okHttpClient, OkHttpClient okHttpClient2, OkHttpClient okHttpClient3) {
        return (RestServiceProvider) d.f(zendeskNetworkModule.provideRestServiceProvider(retrofit, okHttpClient, okHttpClient2, okHttpClient3));
    }

    public RestServiceProvider get() {
        return provideRestServiceProvider(this.module, this.retrofitProvider.get(), this.mediaOkHttpClientProvider.get(), this.standardOkHttpClientProvider.get(), this.coreOkHttpClientProvider.get());
    }
}
