package zendesk.core;

import dagger.internal.b;
import dagger.internal.d;
import q00.a;

public final class ZendeskNetworkModule_ProvideCachingInterceptorFactory implements b<CachingInterceptor> {
    private final a<BaseStorage> mediaCacheProvider;

    public ZendeskNetworkModule_ProvideCachingInterceptorFactory(a<BaseStorage> aVar) {
        this.mediaCacheProvider = aVar;
    }

    public static ZendeskNetworkModule_ProvideCachingInterceptorFactory create(a<BaseStorage> aVar) {
        return new ZendeskNetworkModule_ProvideCachingInterceptorFactory(aVar);
    }

    public static CachingInterceptor provideCachingInterceptor(BaseStorage baseStorage) {
        return (CachingInterceptor) d.f(ZendeskNetworkModule.provideCachingInterceptor(baseStorage));
    }

    public CachingInterceptor get() {
        return provideCachingInterceptor(this.mediaCacheProvider.get());
    }
}
