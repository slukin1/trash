package zendesk.core;

import dagger.internal.b;
import dagger.internal.d;
import q00.a;

public final class ZendeskNetworkModule_ProvideSettingsInterceptorFactory implements b<ZendeskSettingsInterceptor> {
    private final a<SdkSettingsProviderInternal> sdkSettingsProvider;
    private final a<SettingsStorage> settingsStorageProvider;

    public ZendeskNetworkModule_ProvideSettingsInterceptorFactory(a<SdkSettingsProviderInternal> aVar, a<SettingsStorage> aVar2) {
        this.sdkSettingsProvider = aVar;
        this.settingsStorageProvider = aVar2;
    }

    public static ZendeskNetworkModule_ProvideSettingsInterceptorFactory create(a<SdkSettingsProviderInternal> aVar, a<SettingsStorage> aVar2) {
        return new ZendeskNetworkModule_ProvideSettingsInterceptorFactory(aVar, aVar2);
    }

    public static ZendeskSettingsInterceptor provideSettingsInterceptor(Object obj, Object obj2) {
        return (ZendeskSettingsInterceptor) d.f(ZendeskNetworkModule.provideSettingsInterceptor((SdkSettingsProviderInternal) obj, (SettingsStorage) obj2));
    }

    public ZendeskSettingsInterceptor get() {
        return provideSettingsInterceptor(this.sdkSettingsProvider.get(), this.settingsStorageProvider.get());
    }
}
