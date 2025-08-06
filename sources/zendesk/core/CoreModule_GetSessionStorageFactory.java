package zendesk.core;

import dagger.internal.b;
import dagger.internal.d;

public final class CoreModule_GetSessionStorageFactory implements b<SessionStorage> {
    private final CoreModule module;

    public CoreModule_GetSessionStorageFactory(CoreModule coreModule) {
        this.module = coreModule;
    }

    public static CoreModule_GetSessionStorageFactory create(CoreModule coreModule) {
        return new CoreModule_GetSessionStorageFactory(coreModule);
    }

    public static SessionStorage getSessionStorage(CoreModule coreModule) {
        return (SessionStorage) d.f(coreModule.getSessionStorage());
    }

    public SessionStorage get() {
        return getSessionStorage(this.module);
    }
}
