package zendesk.core;

import android.content.Context;
import dagger.internal.b;
import dagger.internal.d;
import q00.a;

public final class ZendeskStorageModule_ProvideSdkBaseStorageFactory implements b<BaseStorage> {
    private final a<Context> contextProvider;
    private final a<Serializer> serializerProvider;

    public ZendeskStorageModule_ProvideSdkBaseStorageFactory(a<Context> aVar, a<Serializer> aVar2) {
        this.contextProvider = aVar;
        this.serializerProvider = aVar2;
    }

    public static ZendeskStorageModule_ProvideSdkBaseStorageFactory create(a<Context> aVar, a<Serializer> aVar2) {
        return new ZendeskStorageModule_ProvideSdkBaseStorageFactory(aVar, aVar2);
    }

    public static BaseStorage provideSdkBaseStorage(Context context, Object obj) {
        return (BaseStorage) d.f(ZendeskStorageModule.provideSdkBaseStorage(context, (Serializer) obj));
    }

    public BaseStorage get() {
        return provideSdkBaseStorage(this.contextProvider.get(), this.serializerProvider.get());
    }
}
