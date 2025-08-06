package zendesk.core;

import dagger.internal.b;
import dagger.internal.d;
import java.io.File;
import okhttp3.Cache;
import q00.a;

public final class ZendeskStorageModule_ProvideCacheFactory implements b<Cache> {
    private final a<File> fileProvider;

    public ZendeskStorageModule_ProvideCacheFactory(a<File> aVar) {
        this.fileProvider = aVar;
    }

    public static ZendeskStorageModule_ProvideCacheFactory create(a<File> aVar) {
        return new ZendeskStorageModule_ProvideCacheFactory(aVar);
    }

    public static Cache provideCache(File file) {
        return (Cache) d.f(ZendeskStorageModule.provideCache(file));
    }

    public Cache get() {
        return provideCache(this.fileProvider.get());
    }
}
