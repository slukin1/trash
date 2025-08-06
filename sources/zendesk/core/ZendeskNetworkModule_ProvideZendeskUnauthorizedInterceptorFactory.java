package zendesk.core;

import dagger.internal.b;
import dagger.internal.d;
import q00.a;

public final class ZendeskNetworkModule_ProvideZendeskUnauthorizedInterceptorFactory implements b<ZendeskUnauthorizedInterceptor> {
    private final a<IdentityManager> identityManagerProvider;
    private final a<SessionStorage> sessionStorageProvider;

    public ZendeskNetworkModule_ProvideZendeskUnauthorizedInterceptorFactory(a<SessionStorage> aVar, a<IdentityManager> aVar2) {
        this.sessionStorageProvider = aVar;
        this.identityManagerProvider = aVar2;
    }

    public static ZendeskNetworkModule_ProvideZendeskUnauthorizedInterceptorFactory create(a<SessionStorage> aVar, a<IdentityManager> aVar2) {
        return new ZendeskNetworkModule_ProvideZendeskUnauthorizedInterceptorFactory(aVar, aVar2);
    }

    public static ZendeskUnauthorizedInterceptor provideZendeskUnauthorizedInterceptor(SessionStorage sessionStorage, Object obj) {
        return (ZendeskUnauthorizedInterceptor) d.f(ZendeskNetworkModule.provideZendeskUnauthorizedInterceptor(sessionStorage, (IdentityManager) obj));
    }

    public ZendeskUnauthorizedInterceptor get() {
        return provideZendeskUnauthorizedInterceptor(this.sessionStorageProvider.get(), this.identityManagerProvider.get());
    }
}
