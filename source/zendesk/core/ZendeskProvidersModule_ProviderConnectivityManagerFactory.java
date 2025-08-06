package zendesk.core;

import android.content.Context;
import android.net.ConnectivityManager;
import dagger.internal.b;
import dagger.internal.d;
import q00.a;

public final class ZendeskProvidersModule_ProviderConnectivityManagerFactory implements b<ConnectivityManager> {
    private final a<Context> contextProvider;

    public ZendeskProvidersModule_ProviderConnectivityManagerFactory(a<Context> aVar) {
        this.contextProvider = aVar;
    }

    public static ZendeskProvidersModule_ProviderConnectivityManagerFactory create(a<Context> aVar) {
        return new ZendeskProvidersModule_ProviderConnectivityManagerFactory(aVar);
    }

    public static ConnectivityManager providerConnectivityManager(Context context) {
        return (ConnectivityManager) d.f(ZendeskProvidersModule.providerConnectivityManager(context));
    }

    public ConnectivityManager get() {
        return providerConnectivityManager(this.contextProvider.get());
    }
}
