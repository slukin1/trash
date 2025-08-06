package zendesk.core;

import dagger.internal.b;
import dagger.internal.d;
import q00.a;

public final class ZendeskNetworkModule_ProvideZendeskBasicHeadersInterceptorFactory implements b<ZendeskOauthIdHeaderInterceptor> {
    private final a<ApplicationConfiguration> configurationProvider;
    private final ZendeskNetworkModule module;

    public ZendeskNetworkModule_ProvideZendeskBasicHeadersInterceptorFactory(ZendeskNetworkModule zendeskNetworkModule, a<ApplicationConfiguration> aVar) {
        this.module = zendeskNetworkModule;
        this.configurationProvider = aVar;
    }

    public static ZendeskNetworkModule_ProvideZendeskBasicHeadersInterceptorFactory create(ZendeskNetworkModule zendeskNetworkModule, a<ApplicationConfiguration> aVar) {
        return new ZendeskNetworkModule_ProvideZendeskBasicHeadersInterceptorFactory(zendeskNetworkModule, aVar);
    }

    public static ZendeskOauthIdHeaderInterceptor provideZendeskBasicHeadersInterceptor(ZendeskNetworkModule zendeskNetworkModule, ApplicationConfiguration applicationConfiguration) {
        return (ZendeskOauthIdHeaderInterceptor) d.f(zendeskNetworkModule.provideZendeskBasicHeadersInterceptor(applicationConfiguration));
    }

    public ZendeskOauthIdHeaderInterceptor get() {
        return provideZendeskBasicHeadersInterceptor(this.module, this.configurationProvider.get());
    }
}
