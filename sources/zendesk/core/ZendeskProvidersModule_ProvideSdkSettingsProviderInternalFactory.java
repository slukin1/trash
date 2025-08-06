package zendesk.core;

import dagger.internal.b;
import dagger.internal.d;
import q00.a;

public final class ZendeskProvidersModule_ProvideSdkSettingsProviderInternalFactory implements b<SdkSettingsProviderInternal> {
    private final a<ZendeskSettingsProvider> sdkSettingsProvider;

    public ZendeskProvidersModule_ProvideSdkSettingsProviderInternalFactory(a<ZendeskSettingsProvider> aVar) {
        this.sdkSettingsProvider = aVar;
    }

    public static ZendeskProvidersModule_ProvideSdkSettingsProviderInternalFactory create(a<ZendeskSettingsProvider> aVar) {
        return new ZendeskProvidersModule_ProvideSdkSettingsProviderInternalFactory(aVar);
    }

    public static SdkSettingsProviderInternal provideSdkSettingsProviderInternal(Object obj) {
        return (SdkSettingsProviderInternal) d.f(ZendeskProvidersModule.provideSdkSettingsProviderInternal((ZendeskSettingsProvider) obj));
    }

    public SdkSettingsProviderInternal get() {
        return provideSdkSettingsProviderInternal(this.sdkSettingsProvider.get());
    }
}
