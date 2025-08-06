package zendesk.support;

import dagger.internal.b;
import dagger.internal.d;

public final class SupportModule_ProvidesRequestProviderFactory implements b<RequestProvider> {
    private final SupportModule module;

    public SupportModule_ProvidesRequestProviderFactory(SupportModule supportModule) {
        this.module = supportModule;
    }

    public static SupportModule_ProvidesRequestProviderFactory create(SupportModule supportModule) {
        return new SupportModule_ProvidesRequestProviderFactory(supportModule);
    }

    public static RequestProvider providesRequestProvider(SupportModule supportModule) {
        return (RequestProvider) d.f(supportModule.providesRequestProvider());
    }

    public RequestProvider get() {
        return providesRequestProvider(this.module);
    }
}
