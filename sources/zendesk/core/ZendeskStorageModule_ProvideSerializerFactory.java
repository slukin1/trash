package zendesk.core;

import com.google.gson.Gson;
import dagger.internal.b;
import dagger.internal.d;
import q00.a;

public final class ZendeskStorageModule_ProvideSerializerFactory implements b<Serializer> {
    private final a<Gson> gsonProvider;

    public ZendeskStorageModule_ProvideSerializerFactory(a<Gson> aVar) {
        this.gsonProvider = aVar;
    }

    public static ZendeskStorageModule_ProvideSerializerFactory create(a<Gson> aVar) {
        return new ZendeskStorageModule_ProvideSerializerFactory(aVar);
    }

    public static Serializer provideSerializer(Gson gson) {
        return (Serializer) d.f(ZendeskStorageModule.provideSerializer(gson));
    }

    public Serializer get() {
        return provideSerializer(this.gsonProvider.get());
    }
}
