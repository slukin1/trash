package zendesk.core;

import dagger.internal.b;
import dagger.internal.d;
import q00.a;

public final class ZendeskStorageModule_ProvideSettingsStorageFactory implements b<SettingsStorage> {
    private final a<BaseStorage> baseStorageProvider;

    public ZendeskStorageModule_ProvideSettingsStorageFactory(a<BaseStorage> aVar) {
        this.baseStorageProvider = aVar;
    }

    public static ZendeskStorageModule_ProvideSettingsStorageFactory create(a<BaseStorage> aVar) {
        return new ZendeskStorageModule_ProvideSettingsStorageFactory(aVar);
    }

    public static SettingsStorage provideSettingsStorage(BaseStorage baseStorage) {
        return (SettingsStorage) d.f(ZendeskStorageModule.provideSettingsStorage(baseStorage));
    }

    public SettingsStorage get() {
        return provideSettingsStorage(this.baseStorageProvider.get());
    }
}
