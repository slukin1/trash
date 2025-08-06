package zendesk.core;

import dagger.internal.b;
import dagger.internal.d;
import q00.a;
import retrofit2.Retrofit;

public final class ZendeskProvidersModule_ProvideAccessServiceFactory implements b<AccessService> {
    private final a<Retrofit> retrofitProvider;

    public ZendeskProvidersModule_ProvideAccessServiceFactory(a<Retrofit> aVar) {
        this.retrofitProvider = aVar;
    }

    public static ZendeskProvidersModule_ProvideAccessServiceFactory create(a<Retrofit> aVar) {
        return new ZendeskProvidersModule_ProvideAccessServiceFactory(aVar);
    }

    public static AccessService provideAccessService(Retrofit retrofit) {
        return (AccessService) d.f(ZendeskProvidersModule.provideAccessService(retrofit));
    }

    public AccessService get() {
        return provideAccessService(this.retrofitProvider.get());
    }
}
