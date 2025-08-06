package zendesk.core;

import dagger.internal.b;
import dagger.internal.d;
import q00.a;

public final class ZendeskApplicationModule_ProvideBase64SerializerFactory implements b<Serializer> {
    private final a<Serializer> gsonSerializerProvider;
    private final ZendeskApplicationModule module;

    public ZendeskApplicationModule_ProvideBase64SerializerFactory(ZendeskApplicationModule zendeskApplicationModule, a<Serializer> aVar) {
        this.module = zendeskApplicationModule;
        this.gsonSerializerProvider = aVar;
    }

    public static ZendeskApplicationModule_ProvideBase64SerializerFactory create(ZendeskApplicationModule zendeskApplicationModule, a<Serializer> aVar) {
        return new ZendeskApplicationModule_ProvideBase64SerializerFactory(zendeskApplicationModule, aVar);
    }

    public static Serializer provideBase64Serializer(ZendeskApplicationModule zendeskApplicationModule, Object obj) {
        return (Serializer) d.f(zendeskApplicationModule.provideBase64Serializer((Serializer) obj));
    }

    public Serializer get() {
        return provideBase64Serializer(this.module, this.gsonSerializerProvider.get());
    }
}
