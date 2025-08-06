package zendesk.core;

import dagger.internal.b;
import dagger.internal.d;
import q00.a;

public final class ZendeskStorageModule_ProvideCoreSettingsStorageFactory implements b<CoreSettingsStorage> {
    private final a<SettingsStorage> settingsStorageProvider;

    public ZendeskStorageModule_ProvideCoreSettingsStorageFactory(a<SettingsStorage> aVar) {
        this.settingsStorageProvider = aVar;
    }

    public static ZendeskStorageModule_ProvideCoreSettingsStorageFactory create(a<SettingsStorage> aVar) {
        return new ZendeskStorageModule_ProvideCoreSettingsStorageFactory(aVar);
    }

    public static CoreSettingsStorage provideCoreSettingsStorage(Object obj) {
        return (CoreSettingsStorage) d.f(ZendeskStorageModule.provideCoreSettingsStorage((SettingsStorage) obj));
    }

    public CoreSettingsStorage get() {
        return provideCoreSettingsStorage(this.settingsStorageProvider.get());
    }
}
