package zendesk.core;

import com.google.gson.Gson;
import dagger.internal.b;
import dagger.internal.d;
import okhttp3.OkHttpClient;
import q00.a;
import retrofit2.Retrofit;

public final class ZendeskNetworkModule_ProvidePushProviderRetrofitFactory implements b<Retrofit> {
    private final a<ZendeskAuthHeaderInterceptor> authHeaderInterceptorProvider;
    private final a<ApplicationConfiguration> configurationProvider;
    private final a<Gson> gsonProvider;
    private final a<OkHttpClient> okHttpClientProvider;

    public ZendeskNetworkModule_ProvidePushProviderRetrofitFactory(a<ApplicationConfiguration> aVar, a<Gson> aVar2, a<OkHttpClient> aVar3, a<ZendeskAuthHeaderInterceptor> aVar4) {
        this.configurationProvider = aVar;
        this.gsonProvider = aVar2;
        this.okHttpClientProvider = aVar3;
        this.authHeaderInterceptorProvider = aVar4;
    }

    public static ZendeskNetworkModule_ProvidePushProviderRetrofitFactory create(a<ApplicationConfiguration> aVar, a<Gson> aVar2, a<OkHttpClient> aVar3, a<ZendeskAuthHeaderInterceptor> aVar4) {
        return new ZendeskNetworkModule_ProvidePushProviderRetrofitFactory(aVar, aVar2, aVar3, aVar4);
    }

    public static Retrofit providePushProviderRetrofit(ApplicationConfiguration applicationConfiguration, Gson gson, OkHttpClient okHttpClient, Object obj) {
        return (Retrofit) d.f(ZendeskNetworkModule.providePushProviderRetrofit(applicationConfiguration, gson, okHttpClient, (ZendeskAuthHeaderInterceptor) obj));
    }

    public Retrofit get() {
        return providePushProviderRetrofit(this.configurationProvider.get(), this.gsonProvider.get(), this.okHttpClientProvider.get(), this.authHeaderInterceptorProvider.get());
    }
}
