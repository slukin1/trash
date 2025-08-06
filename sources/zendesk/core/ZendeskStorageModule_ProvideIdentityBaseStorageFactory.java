package zendesk.core;

import android.content.Context;
import dagger.internal.b;
import dagger.internal.d;
import q00.a;

public final class ZendeskStorageModule_ProvideIdentityBaseStorageFactory implements b<BaseStorage> {
    private final a<Context> contextProvider;
    private final a<Serializer> serializerProvider;

    public ZendeskStorageModule_ProvideIdentityBaseStorageFactory(a<Context> aVar, a<Serializer> aVar2) {
        this.contextProvider = aVar;
        this.serializerProvider = aVar2;
    }

    public static ZendeskStorageModule_ProvideIdentityBaseStorageFactory create(a<Context> aVar, a<Serializer> aVar2) {
        return new ZendeskStorageModule_ProvideIdentityBaseStorageFactory(aVar, aVar2);
    }

    public static BaseStorage provideIdentityBaseStorage(Context context, Object obj) {
        return (BaseStorage) d.f(ZendeskStorageModule.provideIdentityBaseStorage(context, (Serializer) obj));
    }

    public BaseStorage get() {
        return provideIdentityBaseStorage(this.contextProvider.get(), this.serializerProvider.get());
    }
}
