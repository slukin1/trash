package zendesk.core;

import dagger.internal.b;
import dagger.internal.d;

public final class CoreModule_GetMemoryCacheFactory implements b<MemoryCache> {
    private final CoreModule module;

    public CoreModule_GetMemoryCacheFactory(CoreModule coreModule) {
        this.module = coreModule;
    }

    public static CoreModule_GetMemoryCacheFactory create(CoreModule coreModule) {
        return new CoreModule_GetMemoryCacheFactory(coreModule);
    }

    public static MemoryCache getMemoryCache(CoreModule coreModule) {
        return (MemoryCache) d.f(coreModule.getMemoryCache());
    }

    public MemoryCache get() {
        return getMemoryCache(this.module);
    }
}
