package zendesk.core;

import dagger.internal.b;
import dagger.internal.d;

public final class CoreModule_GetAuthenticationProviderFactory implements b<AuthenticationProvider> {
    private final CoreModule module;

    public CoreModule_GetAuthenticationProviderFactory(CoreModule coreModule) {
        this.module = coreModule;
    }

    public static CoreModule_GetAuthenticationProviderFactory create(CoreModule coreModule) {
        return new CoreModule_GetAuthenticationProviderFactory(coreModule);
    }

    public static AuthenticationProvider getAuthenticationProvider(CoreModule coreModule) {
        return (AuthenticationProvider) d.f(coreModule.getAuthenticationProvider());
    }

    public AuthenticationProvider get() {
        return getAuthenticationProvider(this.module);
    }
}
