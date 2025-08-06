package zendesk.core;

import android.content.Context;
import dagger.internal.b;
import dagger.internal.d;
import q00.a;

public final class ZendeskProvidersModule_ProvidePushRegistrationProviderFactory implements b<PushRegistrationProvider> {
    private final a<BlipsCoreProvider> blipsProvider;
    private final a<Context> contextProvider;
    private final a<IdentityManager> identityManagerProvider;
    private final a<PushDeviceIdStorage> pushDeviceIdStorageProvider;
    private final a<PushRegistrationService> pushRegistrationServiceProvider;
    private final a<SettingsProvider> settingsProvider;

    public ZendeskProvidersModule_ProvidePushRegistrationProviderFactory(a<PushRegistrationService> aVar, a<IdentityManager> aVar2, a<SettingsProvider> aVar3, a<BlipsCoreProvider> aVar4, a<PushDeviceIdStorage> aVar5, a<Context> aVar6) {
        this.pushRegistrationServiceProvider = aVar;
        this.identityManagerProvider = aVar2;
        this.settingsProvider = aVar3;
        this.blipsProvider = aVar4;
        this.pushDeviceIdStorageProvider = aVar5;
        this.contextProvider = aVar6;
    }

    public static ZendeskProvidersModule_ProvidePushRegistrationProviderFactory create(a<PushRegistrationService> aVar, a<IdentityManager> aVar2, a<SettingsProvider> aVar3, a<BlipsCoreProvider> aVar4, a<PushDeviceIdStorage> aVar5, a<Context> aVar6) {
        return new ZendeskProvidersModule_ProvidePushRegistrationProviderFactory(aVar, aVar2, aVar3, aVar4, aVar5, aVar6);
    }

    public static PushRegistrationProvider providePushRegistrationProvider(Object obj, Object obj2, SettingsProvider settingsProvider2, Object obj3, Object obj4, Context context) {
        return (PushRegistrationProvider) d.f(ZendeskProvidersModule.providePushRegistrationProvider((PushRegistrationService) obj, (IdentityManager) obj2, settingsProvider2, (BlipsCoreProvider) obj3, (PushDeviceIdStorage) obj4, context));
    }

    public PushRegistrationProvider get() {
        return providePushRegistrationProvider(this.pushRegistrationServiceProvider.get(), this.identityManagerProvider.get(), this.settingsProvider.get(), this.blipsProvider.get(), this.pushDeviceIdStorageProvider.get(), this.contextProvider.get());
    }
}
