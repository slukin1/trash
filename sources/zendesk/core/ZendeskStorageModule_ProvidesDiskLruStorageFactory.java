package zendesk.core;

import dagger.internal.b;
import dagger.internal.d;
import java.io.File;
import q00.a;

public final class ZendeskStorageModule_ProvidesDiskLruStorageFactory implements b<BaseStorage> {
    private final a<File> fileProvider;
    private final a<Serializer> serializerProvider;

    public ZendeskStorageModule_ProvidesDiskLruStorageFactory(a<File> aVar, a<Serializer> aVar2) {
        this.fileProvider = aVar;
        this.serializerProvider = aVar2;
    }

    public static ZendeskStorageModule_ProvidesDiskLruStorageFactory create(a<File> aVar, a<Serializer> aVar2) {
        return new ZendeskStorageModule_ProvidesDiskLruStorageFactory(aVar, aVar2);
    }

    public static BaseStorage providesDiskLruStorage(File file, Object obj) {
        return (BaseStorage) d.f(ZendeskStorageModule.providesDiskLruStorage(file, (Serializer) obj));
    }

    public BaseStorage get() {
        return providesDiskLruStorage(this.fileProvider.get(), this.serializerProvider.get());
    }
}
