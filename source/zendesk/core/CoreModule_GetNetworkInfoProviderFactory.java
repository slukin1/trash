package zendesk.core;

import dagger.internal.b;
import dagger.internal.d;

public final class CoreModule_GetNetworkInfoProviderFactory implements b<NetworkInfoProvider> {
    private final CoreModule module;

    public CoreModule_GetNetworkInfoProviderFactory(CoreModule coreModule) {
        this.module = coreModule;
    }

    public static CoreModule_GetNetworkInfoProviderFactory create(CoreModule coreModule) {
        return new CoreModule_GetNetworkInfoProviderFactory(coreModule);
    }

    public static NetworkInfoProvider getNetworkInfoProvider(CoreModule coreModule) {
        return (NetworkInfoProvider) d.f(coreModule.getNetworkInfoProvider());
    }

    public NetworkInfoProvider get() {
        return getNetworkInfoProvider(this.module);
    }
}
