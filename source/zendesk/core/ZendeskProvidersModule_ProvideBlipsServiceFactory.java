package zendesk.core;

import dagger.internal.b;
import dagger.internal.d;
import q00.a;
import retrofit2.Retrofit;

public final class ZendeskProvidersModule_ProvideBlipsServiceFactory implements b<BlipsService> {
    private final a<Retrofit> retrofitProvider;

    public ZendeskProvidersModule_ProvideBlipsServiceFactory(a<Retrofit> aVar) {
        this.retrofitProvider = aVar;
    }

    public static ZendeskProvidersModule_ProvideBlipsServiceFactory create(a<Retrofit> aVar) {
        return new ZendeskProvidersModule_ProvideBlipsServiceFactory(aVar);
    }

    public static BlipsService provideBlipsService(Retrofit retrofit) {
        return (BlipsService) d.f(ZendeskProvidersModule.provideBlipsService(retrofit));
    }

    public BlipsService get() {
        return provideBlipsService(this.retrofitProvider.get());
    }
}
