package zendesk.support;

import aw.a;
import dagger.internal.b;
import dagger.internal.d;
import zendesk.core.SessionStorage;

public final class SupportSdkModule_ProvidesRequestDiskLruCacheFactory implements b<a> {
    private final SupportSdkModule module;
    private final q00.a<SessionStorage> sessionStorageProvider;

    public SupportSdkModule_ProvidesRequestDiskLruCacheFactory(SupportSdkModule supportSdkModule, q00.a<SessionStorage> aVar) {
        this.module = supportSdkModule;
        this.sessionStorageProvider = aVar;
    }

    public static SupportSdkModule_ProvidesRequestDiskLruCacheFactory create(SupportSdkModule supportSdkModule, q00.a<SessionStorage> aVar) {
        return new SupportSdkModule_ProvidesRequestDiskLruCacheFactory(supportSdkModule, aVar);
    }

    public static a providesRequestDiskLruCache(SupportSdkModule supportSdkModule, SessionStorage sessionStorage) {
        return (a) d.f(supportSdkModule.providesRequestDiskLruCache(sessionStorage));
    }

    public a get() {
        return providesRequestDiskLruCache(this.module, this.sessionStorageProvider.get());
    }
}
