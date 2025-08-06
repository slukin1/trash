package zendesk.core;

import dagger.internal.b;
import dagger.internal.d;
import q00.a;
import retrofit2.Retrofit;

public final class ZendeskProvidersModule_ProvidePushRegistrationServiceFactory implements b<PushRegistrationService> {
    private final a<Retrofit> retrofitProvider;

    public ZendeskProvidersModule_ProvidePushRegistrationServiceFactory(a<Retrofit> aVar) {
        this.retrofitProvider = aVar;
    }

    public static ZendeskProvidersModule_ProvidePushRegistrationServiceFactory create(a<Retrofit> aVar) {
        return new ZendeskProvidersModule_ProvidePushRegistrationServiceFactory(aVar);
    }

    public static PushRegistrationService providePushRegistrationService(Retrofit retrofit) {
        return (PushRegistrationService) d.f(ZendeskProvidersModule.providePushRegistrationService(retrofit));
    }

    public PushRegistrationService get() {
        return providePushRegistrationService(this.retrofitProvider.get());
    }
}
