package zendesk.support;

import dagger.internal.b;
import dagger.internal.d;
import q00.a;
import zendesk.core.MemoryCache;
import zendesk.core.SessionStorage;

public final class StorageModule_ProvideRequestStorageFactory implements b<RequestStorage> {
    private final a<SessionStorage> baseStorageProvider;
    private final a<MemoryCache> memoryCacheProvider;
    private final StorageModule module;
    private final a<RequestMigrator> requestMigratorProvider;

    public StorageModule_ProvideRequestStorageFactory(StorageModule storageModule, a<SessionStorage> aVar, a<RequestMigrator> aVar2, a<MemoryCache> aVar3) {
        this.module = storageModule;
        this.baseStorageProvider = aVar;
        this.requestMigratorProvider = aVar2;
        this.memoryCacheProvider = aVar3;
    }

    public static StorageModule_ProvideRequestStorageFactory create(StorageModule storageModule, a<SessionStorage> aVar, a<RequestMigrator> aVar2, a<MemoryCache> aVar3) {
        return new StorageModule_ProvideRequestStorageFactory(storageModule, aVar, aVar2, aVar3);
    }

    public static RequestStorage provideRequestStorage(StorageModule storageModule, SessionStorage sessionStorage, Object obj, MemoryCache memoryCache) {
        return (RequestStorage) d.f(storageModule.provideRequestStorage(sessionStorage, (RequestMigrator) obj, memoryCache));
    }

    public RequestStorage get() {
        return provideRequestStorage(this.module, this.baseStorageProvider.get(), this.requestMigratorProvider.get(), this.memoryCacheProvider.get());
    }
}
