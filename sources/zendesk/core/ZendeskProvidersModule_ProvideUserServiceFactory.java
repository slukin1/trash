package zendesk.core;

import dagger.internal.b;
import dagger.internal.d;
import q00.a;
import retrofit2.Retrofit;

public final class ZendeskProvidersModule_ProvideUserServiceFactory implements b<UserService> {
    private final a<Retrofit> retrofitProvider;

    public ZendeskProvidersModule_ProvideUserServiceFactory(a<Retrofit> aVar) {
        this.retrofitProvider = aVar;
    }

    public static ZendeskProvidersModule_ProvideUserServiceFactory create(a<Retrofit> aVar) {
        return new ZendeskProvidersModule_ProvideUserServiceFactory(aVar);
    }

    public static UserService provideUserService(Retrofit retrofit) {
        return (UserService) d.f(ZendeskProvidersModule.provideUserService(retrofit));
    }

    public UserService get() {
        return provideUserService(this.retrofitProvider.get());
    }
}
