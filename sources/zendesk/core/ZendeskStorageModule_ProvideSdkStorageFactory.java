package zendesk.core;

import dagger.internal.b;
import dagger.internal.d;
import q00.a;

public final class ZendeskStorageModule_ProvideSdkStorageFactory implements b<Storage> {
    private final a<MemoryCache> memoryCacheProvider;
    private final a<BaseStorage> sdkBaseStorageProvider;
    private final a<SessionStorage> sessionStorageProvider;
    private final a<SettingsStorage> settingsStorageProvider;

    public ZendeskStorageModule_ProvideSdkStorageFactory(a<SettingsStorage> aVar, a<SessionStorage> aVar2, a<BaseStorage> aVar3, a<MemoryCache> aVar4) {
        this.settingsStorageProvider = aVar;
        this.sessionStorageProvider = aVar2;
        this.sdkBaseStorageProvider = aVar3;
        this.memoryCacheProvider = aVar4;
    }

    public static ZendeskStorageModule_ProvideSdkStorageFactory create(a<SettingsStorage> aVar, a<SessionStorage> aVar2, a<BaseStorage> aVar3, a<MemoryCache> aVar4) {
        return new ZendeskStorageModule_ProvideSdkStorageFactory(aVar, aVar2, aVar3, aVar4);
    }

    public static Storage provideSdkStorage(Object obj, SessionStorage sessionStorage, BaseStorage baseStorage, MemoryCache memoryCache) {
        return (Storage) d.f(ZendeskStorageModule.provideSdkStorage((SettingsStorage) obj, sessionStorage, baseStorage, memoryCache));
    }

    public Storage get() {
        return provideSdkStorage(this.settingsStorageProvider.get(), this.sessionStorageProvider.get(), this.sdkBaseStorageProvider.get(), this.memoryCacheProvider.get());
    }
}
