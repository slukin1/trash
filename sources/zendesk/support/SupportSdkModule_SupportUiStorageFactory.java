package zendesk.support;

import com.google.gson.Gson;
import dagger.internal.b;
import dagger.internal.d;
import q00.a;

public final class SupportSdkModule_SupportUiStorageFactory implements b<SupportUiStorage> {
    private final a<aw.a> diskLruCacheProvider;
    private final a<Gson> gsonProvider;
    private final SupportSdkModule module;

    public SupportSdkModule_SupportUiStorageFactory(SupportSdkModule supportSdkModule, a<aw.a> aVar, a<Gson> aVar2) {
        this.module = supportSdkModule;
        this.diskLruCacheProvider = aVar;
        this.gsonProvider = aVar2;
    }

    public static SupportSdkModule_SupportUiStorageFactory create(SupportSdkModule supportSdkModule, a<aw.a> aVar, a<Gson> aVar2) {
        return new SupportSdkModule_SupportUiStorageFactory(supportSdkModule, aVar, aVar2);
    }

    public static SupportUiStorage supportUiStorage(SupportSdkModule supportSdkModule, aw.a aVar, Gson gson) {
        return (SupportUiStorage) d.f(supportSdkModule.supportUiStorage(aVar, gson));
    }

    public SupportUiStorage get() {
        return supportUiStorage(this.module, this.diskLruCacheProvider.get(), this.gsonProvider.get());
    }
}
