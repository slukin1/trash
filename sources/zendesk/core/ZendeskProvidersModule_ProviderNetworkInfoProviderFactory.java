package zendesk.core;

import android.net.ConnectivityManager;
import dagger.internal.b;
import dagger.internal.d;
import q00.a;

public final class ZendeskProvidersModule_ProviderNetworkInfoProviderFactory implements b<NetworkInfoProvider> {
    private final a<ConnectivityManager> connectivityManagerProvider;

    public ZendeskProvidersModule_ProviderNetworkInfoProviderFactory(a<ConnectivityManager> aVar) {
        this.connectivityManagerProvider = aVar;
    }

    public static ZendeskProvidersModule_ProviderNetworkInfoProviderFactory create(a<ConnectivityManager> aVar) {
        return new ZendeskProvidersModule_ProviderNetworkInfoProviderFactory(aVar);
    }

    public static NetworkInfoProvider providerNetworkInfoProvider(ConnectivityManager connectivityManager) {
        return (NetworkInfoProvider) d.f(ZendeskProvidersModule.providerNetworkInfoProvider(connectivityManager));
    }

    public NetworkInfoProvider get() {
        return providerNetworkInfoProvider(this.connectivityManagerProvider.get());
    }
}
