package zendesk.core;

import android.content.Context;
import dagger.internal.b;
import dagger.internal.d;
import q00.a;

public final class ZendeskStorageModule_ProvideLegacyPushBaseStorageFactory implements b<SharedPreferencesStorage> {
    private final a<Context> contextProvider;
    private final a<Serializer> serializerProvider;

    public ZendeskStorageModule_ProvideLegacyPushBaseStorageFactory(a<Context> aVar, a<Serializer> aVar2) {
        this.contextProvider = aVar;
        this.serializerProvider = aVar2;
    }

    public static ZendeskStorageModule_ProvideLegacyPushBaseStorageFactory create(a<Context> aVar, a<Serializer> aVar2) {
        return new ZendeskStorageModule_ProvideLegacyPushBaseStorageFactory(aVar, aVar2);
    }

    public static SharedPreferencesStorage provideLegacyPushBaseStorage(Context context, Object obj) {
        return (SharedPreferencesStorage) d.f(ZendeskStorageModule.provideLegacyPushBaseStorage(context, (Serializer) obj));
    }

    public SharedPreferencesStorage get() {
        return provideLegacyPushBaseStorage(this.contextProvider.get(), this.serializerProvider.get());
    }
}
