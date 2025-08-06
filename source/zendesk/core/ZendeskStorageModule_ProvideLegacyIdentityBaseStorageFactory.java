package zendesk.core;

import android.content.Context;
import dagger.internal.b;
import dagger.internal.d;
import q00.a;

public final class ZendeskStorageModule_ProvideLegacyIdentityBaseStorageFactory implements b<SharedPreferencesStorage> {
    private final a<Context> contextProvider;
    private final a<Serializer> serializerProvider;

    public ZendeskStorageModule_ProvideLegacyIdentityBaseStorageFactory(a<Context> aVar, a<Serializer> aVar2) {
        this.contextProvider = aVar;
        this.serializerProvider = aVar2;
    }

    public static ZendeskStorageModule_ProvideLegacyIdentityBaseStorageFactory create(a<Context> aVar, a<Serializer> aVar2) {
        return new ZendeskStorageModule_ProvideLegacyIdentityBaseStorageFactory(aVar, aVar2);
    }

    public static SharedPreferencesStorage provideLegacyIdentityBaseStorage(Context context, Object obj) {
        return (SharedPreferencesStorage) d.f(ZendeskStorageModule.provideLegacyIdentityBaseStorage(context, (Serializer) obj));
    }

    public SharedPreferencesStorage get() {
        return provideLegacyIdentityBaseStorage(this.contextProvider.get(), this.serializerProvider.get());
    }
}
