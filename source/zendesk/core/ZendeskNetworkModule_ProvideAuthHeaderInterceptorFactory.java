package zendesk.core;

import dagger.internal.b;
import dagger.internal.d;
import q00.a;

public final class ZendeskNetworkModule_ProvideAuthHeaderInterceptorFactory implements b<ZendeskAuthHeaderInterceptor> {
    private final a<IdentityManager> identityManagerProvider;

    public ZendeskNetworkModule_ProvideAuthHeaderInterceptorFactory(a<IdentityManager> aVar) {
        this.identityManagerProvider = aVar;
    }

    public static ZendeskNetworkModule_ProvideAuthHeaderInterceptorFactory create(a<IdentityManager> aVar) {
        return new ZendeskNetworkModule_ProvideAuthHeaderInterceptorFactory(aVar);
    }

    public static ZendeskAuthHeaderInterceptor provideAuthHeaderInterceptor(Object obj) {
        return (ZendeskAuthHeaderInterceptor) d.f(ZendeskNetworkModule.provideAuthHeaderInterceptor((IdentityManager) obj));
    }

    public ZendeskAuthHeaderInterceptor get() {
        return provideAuthHeaderInterceptor(this.identityManagerProvider.get());
    }
}
