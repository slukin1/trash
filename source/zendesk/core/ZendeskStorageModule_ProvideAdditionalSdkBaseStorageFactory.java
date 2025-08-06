package zendesk.core;

import android.content.Context;
import dagger.internal.b;
import dagger.internal.d;
import q00.a;

public final class ZendeskStorageModule_ProvideAdditionalSdkBaseStorageFactory implements b<BaseStorage> {
    private final a<Context> contextProvider;
    private final a<Serializer> serializerProvider;

    public ZendeskStorageModule_ProvideAdditionalSdkBaseStorageFactory(a<Context> aVar, a<Serializer> aVar2) {
        this.contextProvider = aVar;
        this.serializerProvider = aVar2;
    }

    public static ZendeskStorageModule_ProvideAdditionalSdkBaseStorageFactory create(a<Context> aVar, a<Serializer> aVar2) {
        return new ZendeskStorageModule_ProvideAdditionalSdkBaseStorageFactory(aVar, aVar2);
    }

    public static BaseStorage provideAdditionalSdkBaseStorage(Context context, Object obj) {
        return (BaseStorage) d.f(ZendeskStorageModule.provideAdditionalSdkBaseStorage(context, (Serializer) obj));
    }

    public BaseStorage get() {
        return provideAdditionalSdkBaseStorage(this.contextProvider.get(), this.serializerProvider.get());
    }
}
