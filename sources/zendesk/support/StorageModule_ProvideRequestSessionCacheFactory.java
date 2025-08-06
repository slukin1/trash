package zendesk.support;

import dagger.internal.b;
import dagger.internal.d;

public final class StorageModule_ProvideRequestSessionCacheFactory implements b<RequestSessionCache> {
    private final StorageModule module;

    public StorageModule_ProvideRequestSessionCacheFactory(StorageModule storageModule) {
        this.module = storageModule;
    }

    public static StorageModule_ProvideRequestSessionCacheFactory create(StorageModule storageModule) {
        return new StorageModule_ProvideRequestSessionCacheFactory(storageModule);
    }

    public static RequestSessionCache provideRequestSessionCache(StorageModule storageModule) {
        return (RequestSessionCache) d.f(storageModule.provideRequestSessionCache());
    }

    public RequestSessionCache get() {
        return provideRequestSessionCache(this.module);
    }
}
