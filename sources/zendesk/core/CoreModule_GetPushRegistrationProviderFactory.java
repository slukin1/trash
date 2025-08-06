package zendesk.core;

import dagger.internal.b;
import dagger.internal.d;

public final class CoreModule_GetPushRegistrationProviderFactory implements b<PushRegistrationProvider> {
    private final CoreModule module;

    public CoreModule_GetPushRegistrationProviderFactory(CoreModule coreModule) {
        this.module = coreModule;
    }

    public static CoreModule_GetPushRegistrationProviderFactory create(CoreModule coreModule) {
        return new CoreModule_GetPushRegistrationProviderFactory(coreModule);
    }

    public static PushRegistrationProvider getPushRegistrationProvider(CoreModule coreModule) {
        return (PushRegistrationProvider) d.f(coreModule.getPushRegistrationProvider());
    }

    public PushRegistrationProvider get() {
        return getPushRegistrationProvider(this.module);
    }
}
