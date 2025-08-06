package zendesk.core;

import android.content.Context;
import dagger.internal.b;
import dagger.internal.d;
import java.util.concurrent.ScheduledExecutorService;
import q00.a;

public final class ZendeskProvidersModule_ProvideCoreSdkModuleFactory implements b<CoreModule> {
    private final a<ActionHandlerRegistry> actionHandlerRegistryProvider;
    private final a<AuthenticationProvider> authenticationProvider;
    private final a<BlipsProvider> blipsProvider;
    private final a<Context> contextProvider;
    private final a<ScheduledExecutorService> executorProvider;
    private final a<MachineIdStorage> machineIdStorageProvider;
    private final a<MemoryCache> memoryCacheProvider;
    private final a<NetworkInfoProvider> networkInfoProvider;
    private final a<PushRegistrationProvider> pushRegistrationProvider;
    private final a<RestServiceProvider> restServiceProvider;
    private final a<SessionStorage> sessionStorageProvider;
    private final a<SettingsProvider> settingsProvider;
    private final a<ApplicationConfiguration> zendeskConfigurationProvider;

    public ZendeskProvidersModule_ProvideCoreSdkModuleFactory(a<SettingsProvider> aVar, a<RestServiceProvider> aVar2, a<BlipsProvider> aVar3, a<SessionStorage> aVar4, a<NetworkInfoProvider> aVar5, a<MemoryCache> aVar6, a<ActionHandlerRegistry> aVar7, a<ScheduledExecutorService> aVar8, a<Context> aVar9, a<AuthenticationProvider> aVar10, a<ApplicationConfiguration> aVar11, a<PushRegistrationProvider> aVar12, a<MachineIdStorage> aVar13) {
        this.settingsProvider = aVar;
        this.restServiceProvider = aVar2;
        this.blipsProvider = aVar3;
        this.sessionStorageProvider = aVar4;
        this.networkInfoProvider = aVar5;
        this.memoryCacheProvider = aVar6;
        this.actionHandlerRegistryProvider = aVar7;
        this.executorProvider = aVar8;
        this.contextProvider = aVar9;
        this.authenticationProvider = aVar10;
        this.zendeskConfigurationProvider = aVar11;
        this.pushRegistrationProvider = aVar12;
        this.machineIdStorageProvider = aVar13;
    }

    public static ZendeskProvidersModule_ProvideCoreSdkModuleFactory create(a<SettingsProvider> aVar, a<RestServiceProvider> aVar2, a<BlipsProvider> aVar3, a<SessionStorage> aVar4, a<NetworkInfoProvider> aVar5, a<MemoryCache> aVar6, a<ActionHandlerRegistry> aVar7, a<ScheduledExecutorService> aVar8, a<Context> aVar9, a<AuthenticationProvider> aVar10, a<ApplicationConfiguration> aVar11, a<PushRegistrationProvider> aVar12, a<MachineIdStorage> aVar13) {
        return new ZendeskProvidersModule_ProvideCoreSdkModuleFactory(aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7, aVar8, aVar9, aVar10, aVar11, aVar12, aVar13);
    }

    public static CoreModule provideCoreSdkModule(SettingsProvider settingsProvider2, RestServiceProvider restServiceProvider2, BlipsProvider blipsProvider2, SessionStorage sessionStorage, NetworkInfoProvider networkInfoProvider2, MemoryCache memoryCache, ActionHandlerRegistry actionHandlerRegistry, ScheduledExecutorService scheduledExecutorService, Context context, AuthenticationProvider authenticationProvider2, ApplicationConfiguration applicationConfiguration, PushRegistrationProvider pushRegistrationProvider2, MachineIdStorage machineIdStorage) {
        return (CoreModule) d.f(ZendeskProvidersModule.provideCoreSdkModule(settingsProvider2, restServiceProvider2, blipsProvider2, sessionStorage, networkInfoProvider2, memoryCache, actionHandlerRegistry, scheduledExecutorService, context, authenticationProvider2, applicationConfiguration, pushRegistrationProvider2, machineIdStorage));
    }

    public CoreModule get() {
        return provideCoreSdkModule(this.settingsProvider.get(), this.restServiceProvider.get(), this.blipsProvider.get(), this.sessionStorageProvider.get(), this.networkInfoProvider.get(), this.memoryCacheProvider.get(), this.actionHandlerRegistryProvider.get(), this.executorProvider.get(), this.contextProvider.get(), this.authenticationProvider.get(), this.zendeskConfigurationProvider.get(), this.pushRegistrationProvider.get(), this.machineIdStorageProvider.get());
    }
}
