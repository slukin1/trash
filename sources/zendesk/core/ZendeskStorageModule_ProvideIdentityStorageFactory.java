package zendesk.core;

import dagger.internal.b;
import dagger.internal.d;
import q00.a;

public final class ZendeskStorageModule_ProvideIdentityStorageFactory implements b<IdentityStorage> {
    private final a<BaseStorage> baseStorageProvider;

    public ZendeskStorageModule_ProvideIdentityStorageFactory(a<BaseStorage> aVar) {
        this.baseStorageProvider = aVar;
    }

    public static ZendeskStorageModule_ProvideIdentityStorageFactory create(a<BaseStorage> aVar) {
        return new ZendeskStorageModule_ProvideIdentityStorageFactory(aVar);
    }

    public static IdentityStorage provideIdentityStorage(BaseStorage baseStorage) {
        return (IdentityStorage) d.f(ZendeskStorageModule.provideIdentityStorage(baseStorage));
    }

    public IdentityStorage get() {
        return provideIdentityStorage(this.baseStorageProvider.get());
    }
}
