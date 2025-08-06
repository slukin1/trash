package zendesk.core;

import dagger.internal.b;
import dagger.internal.d;
import q00.a;

public final class ZendeskProvidersModule_ProvideSdkSettingsProviderFactory implements b<SettingsProvider> {
    private final a<ZendeskSettingsProvider> sdkSettingsProvider;

    public ZendeskProvidersModule_ProvideSdkSettingsProviderFactory(a<ZendeskSettingsProvider> aVar) {
        this.sdkSettingsProvider = aVar;
    }

    public static ZendeskProvidersModule_ProvideSdkSettingsProviderFactory create(a<ZendeskSettingsProvider> aVar) {
        return new ZendeskProvidersModule_ProvideSdkSettingsProviderFactory(aVar);
    }

    public static SettingsProvider provideSdkSettingsProvider(Object obj) {
        return (SettingsProvider) d.f(ZendeskProvidersModule.provideSdkSettingsProvider((ZendeskSettingsProvider) obj));
    }

    public SettingsProvider get() {
        return provideSdkSettingsProvider(this.sdkSettingsProvider.get());
    }
}
