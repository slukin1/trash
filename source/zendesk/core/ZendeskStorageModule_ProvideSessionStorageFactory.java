package zendesk.core;

import dagger.internal.b;
import dagger.internal.d;
import java.io.File;
import okhttp3.Cache;
import q00.a;

public final class ZendeskStorageModule_ProvideSessionStorageFactory implements b<SessionStorage> {
    private final a<BaseStorage> additionalSdkStorageProvider;
    private final a<File> belvedereDirProvider;
    private final a<File> cacheDirProvider;
    private final a<Cache> cacheProvider;
    private final a<File> dataDirProvider;
    private final a<IdentityStorage> identityStorageProvider;
    private final a<BaseStorage> mediaCacheProvider;

    public ZendeskStorageModule_ProvideSessionStorageFactory(a<IdentityStorage> aVar, a<BaseStorage> aVar2, a<BaseStorage> aVar3, a<Cache> aVar4, a<File> aVar5, a<File> aVar6, a<File> aVar7) {
        this.identityStorageProvider = aVar;
        this.additionalSdkStorageProvider = aVar2;
        this.mediaCacheProvider = aVar3;
        this.cacheProvider = aVar4;
        this.cacheDirProvider = aVar5;
        this.dataDirProvider = aVar6;
        this.belvedereDirProvider = aVar7;
    }

    public static ZendeskStorageModule_ProvideSessionStorageFactory create(a<IdentityStorage> aVar, a<BaseStorage> aVar2, a<BaseStorage> aVar3, a<Cache> aVar4, a<File> aVar5, a<File> aVar6, a<File> aVar7) {
        return new ZendeskStorageModule_ProvideSessionStorageFactory(aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7);
    }

    public static SessionStorage provideSessionStorage(Object obj, BaseStorage baseStorage, BaseStorage baseStorage2, Cache cache, File file, File file2, File file3) {
        return (SessionStorage) d.f(ZendeskStorageModule.provideSessionStorage((IdentityStorage) obj, baseStorage, baseStorage2, cache, file, file2, file3));
    }

    public SessionStorage get() {
        return provideSessionStorage(this.identityStorageProvider.get(), this.additionalSdkStorageProvider.get(), this.mediaCacheProvider.get(), this.cacheProvider.get(), this.cacheDirProvider.get(), this.dataDirProvider.get(), this.belvedereDirProvider.get());
    }
}
