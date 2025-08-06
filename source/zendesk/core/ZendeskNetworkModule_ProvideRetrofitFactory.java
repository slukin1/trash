package zendesk.core;

import com.google.gson.Gson;
import dagger.internal.b;
import dagger.internal.d;
import okhttp3.OkHttpClient;
import q00.a;
import retrofit2.Retrofit;

public final class ZendeskNetworkModule_ProvideRetrofitFactory implements b<Retrofit> {
    private final a<ApplicationConfiguration> configurationProvider;
    private final a<Gson> gsonProvider;
    private final a<OkHttpClient> okHttpClientProvider;

    public ZendeskNetworkModule_ProvideRetrofitFactory(a<ApplicationConfiguration> aVar, a<Gson> aVar2, a<OkHttpClient> aVar3) {
        this.configurationProvider = aVar;
        this.gsonProvider = aVar2;
        this.okHttpClientProvider = aVar3;
    }

    public static ZendeskNetworkModule_ProvideRetrofitFactory create(a<ApplicationConfiguration> aVar, a<Gson> aVar2, a<OkHttpClient> aVar3) {
        return new ZendeskNetworkModule_ProvideRetrofitFactory(aVar, aVar2, aVar3);
    }

    public static Retrofit provideRetrofit(ApplicationConfiguration applicationConfiguration, Gson gson, OkHttpClient okHttpClient) {
        return (Retrofit) d.f(ZendeskNetworkModule.provideRetrofit(applicationConfiguration, gson, okHttpClient));
    }

    public Retrofit get() {
        return provideRetrofit(this.configurationProvider.get(), this.gsonProvider.get(), this.okHttpClientProvider.get());
    }
}
