package zendesk.core;

import com.google.gson.Gson;
import dagger.internal.b;
import dagger.internal.d;
import okhttp3.OkHttpClient;
import q00.a;
import retrofit2.Retrofit;

public final class ZendeskNetworkModule_ProvideCoreRetrofitFactory implements b<Retrofit> {
    private final a<ApplicationConfiguration> configurationProvider;
    private final a<Gson> gsonProvider;
    private final a<OkHttpClient> okHttpClientProvider;

    public ZendeskNetworkModule_ProvideCoreRetrofitFactory(a<ApplicationConfiguration> aVar, a<Gson> aVar2, a<OkHttpClient> aVar3) {
        this.configurationProvider = aVar;
        this.gsonProvider = aVar2;
        this.okHttpClientProvider = aVar3;
    }

    public static ZendeskNetworkModule_ProvideCoreRetrofitFactory create(a<ApplicationConfiguration> aVar, a<Gson> aVar2, a<OkHttpClient> aVar3) {
        return new ZendeskNetworkModule_ProvideCoreRetrofitFactory(aVar, aVar2, aVar3);
    }

    public static Retrofit provideCoreRetrofit(ApplicationConfiguration applicationConfiguration, Gson gson, OkHttpClient okHttpClient) {
        return (Retrofit) d.f(ZendeskNetworkModule.provideCoreRetrofit(applicationConfiguration, gson, okHttpClient));
    }

    public Retrofit get() {
        return provideCoreRetrofit(this.configurationProvider.get(), this.gsonProvider.get(), this.okHttpClientProvider.get());
    }
}
