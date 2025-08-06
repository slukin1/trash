package zendesk.core;

import dagger.internal.b;
import dagger.internal.d;
import q00.a;
import retrofit2.Retrofit;

public final class ZendeskProvidersModule_ProvideSdkSettingsServiceFactory implements b<SdkSettingsService> {
    private final a<Retrofit> retrofitProvider;

    public ZendeskProvidersModule_ProvideSdkSettingsServiceFactory(a<Retrofit> aVar) {
        this.retrofitProvider = aVar;
    }

    public static ZendeskProvidersModule_ProvideSdkSettingsServiceFactory create(a<Retrofit> aVar) {
        return new ZendeskProvidersModule_ProvideSdkSettingsServiceFactory(aVar);
    }

    public static SdkSettingsService provideSdkSettingsService(Retrofit retrofit) {
        return (SdkSettingsService) d.f(ZendeskProvidersModule.provideSdkSettingsService(retrofit));
    }

    public SdkSettingsService get() {
        return provideSdkSettingsService(this.retrofitProvider.get());
    }
}
