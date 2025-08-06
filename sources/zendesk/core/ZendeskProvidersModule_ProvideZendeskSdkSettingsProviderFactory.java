package zendesk.core;

import android.content.Context;
import dagger.internal.b;
import dagger.internal.d;
import q00.a;

public final class ZendeskProvidersModule_ProvideZendeskSdkSettingsProviderFactory implements b<ZendeskSettingsProvider> {
    private final a<ActionHandlerRegistry> actionHandlerRegistryProvider;
    private final a<ApplicationConfiguration> configurationProvider;
    private final a<Context> contextProvider;
    private final a<CoreSettingsStorage> coreSettingsStorageProvider;
    private final a<SdkSettingsService> sdkSettingsServiceProvider;
    private final a<Serializer> serializerProvider;
    private final a<SettingsStorage> settingsStorageProvider;
    private final a<ZendeskLocaleConverter> zendeskLocaleConverterProvider;

    public ZendeskProvidersModule_ProvideZendeskSdkSettingsProviderFactory(a<SdkSettingsService> aVar, a<SettingsStorage> aVar2, a<CoreSettingsStorage> aVar3, a<ActionHandlerRegistry> aVar4, a<Serializer> aVar5, a<ZendeskLocaleConverter> aVar6, a<ApplicationConfiguration> aVar7, a<Context> aVar8) {
        this.sdkSettingsServiceProvider = aVar;
        this.settingsStorageProvider = aVar2;
        this.coreSettingsStorageProvider = aVar3;
        this.actionHandlerRegistryProvider = aVar4;
        this.serializerProvider = aVar5;
        this.zendeskLocaleConverterProvider = aVar6;
        this.configurationProvider = aVar7;
        this.contextProvider = aVar8;
    }

    public static ZendeskProvidersModule_ProvideZendeskSdkSettingsProviderFactory create(a<SdkSettingsService> aVar, a<SettingsStorage> aVar2, a<CoreSettingsStorage> aVar3, a<ActionHandlerRegistry> aVar4, a<Serializer> aVar5, a<ZendeskLocaleConverter> aVar6, a<ApplicationConfiguration> aVar7, a<Context> aVar8) {
        return new ZendeskProvidersModule_ProvideZendeskSdkSettingsProviderFactory(aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7, aVar8);
    }

    public static ZendeskSettingsProvider provideZendeskSdkSettingsProvider(Object obj, Object obj2, Object obj3, ActionHandlerRegistry actionHandlerRegistry, Object obj4, ZendeskLocaleConverter zendeskLocaleConverter, ApplicationConfiguration applicationConfiguration, Context context) {
        return (ZendeskSettingsProvider) d.f(ZendeskProvidersModule.provideZendeskSdkSettingsProvider((SdkSettingsService) obj, (SettingsStorage) obj2, (CoreSettingsStorage) obj3, actionHandlerRegistry, (Serializer) obj4, zendeskLocaleConverter, applicationConfiguration, context));
    }

    public ZendeskSettingsProvider get() {
        return provideZendeskSdkSettingsProvider(this.sdkSettingsServiceProvider.get(), this.settingsStorageProvider.get(), this.coreSettingsStorageProvider.get(), this.actionHandlerRegistryProvider.get(), this.serializerProvider.get(), this.zendeskLocaleConverterProvider.get(), this.configurationProvider.get(), this.contextProvider.get());
    }
}
