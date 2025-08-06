package zendesk.core;

import android.content.Context;
import dagger.internal.b;
import dagger.internal.d;
import q00.a;

public final class ZendeskStorageModule_ProvideSettingsBaseStorageFactory implements b<BaseStorage> {
    private final a<Context> contextProvider;
    private final a<Serializer> serializerProvider;

    public ZendeskStorageModule_ProvideSettingsBaseStorageFactory(a<Context> aVar, a<Serializer> aVar2) {
        this.contextProvider = aVar;
        this.serializerProvider = aVar2;
    }

    public static ZendeskStorageModule_ProvideSettingsBaseStorageFactory create(a<Context> aVar, a<Serializer> aVar2) {
        return new ZendeskStorageModule_ProvideSettingsBaseStorageFactory(aVar, aVar2);
    }

    public static BaseStorage provideSettingsBaseStorage(Context context, Object obj) {
        return (BaseStorage) d.f(ZendeskStorageModule.provideSettingsBaseStorage(context, (Serializer) obj));
    }

    public BaseStorage get() {
        return provideSettingsBaseStorage(this.contextProvider.get(), this.serializerProvider.get());
    }
}
