package zendesk.support;

import dagger.internal.b;
import dagger.internal.d;

public final class SupportModule_ProvidesUploadProviderFactory implements b<UploadProvider> {
    private final SupportModule module;

    public SupportModule_ProvidesUploadProviderFactory(SupportModule supportModule) {
        this.module = supportModule;
    }

    public static SupportModule_ProvidesUploadProviderFactory create(SupportModule supportModule) {
        return new SupportModule_ProvidesUploadProviderFactory(supportModule);
    }

    public static UploadProvider providesUploadProvider(SupportModule supportModule) {
        return (UploadProvider) d.f(supportModule.providesUploadProvider());
    }

    public UploadProvider get() {
        return providesUploadProvider(this.module);
    }
}
