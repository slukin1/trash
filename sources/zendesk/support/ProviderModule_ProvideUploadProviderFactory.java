package zendesk.support;

import dagger.internal.b;
import dagger.internal.d;
import q00.a;

public final class ProviderModule_ProvideUploadProviderFactory implements b<UploadProvider> {
    private final ProviderModule module;
    private final a<ZendeskUploadService> uploadServiceProvider;

    public ProviderModule_ProvideUploadProviderFactory(ProviderModule providerModule, a<ZendeskUploadService> aVar) {
        this.module = providerModule;
        this.uploadServiceProvider = aVar;
    }

    public static ProviderModule_ProvideUploadProviderFactory create(ProviderModule providerModule, a<ZendeskUploadService> aVar) {
        return new ProviderModule_ProvideUploadProviderFactory(providerModule, aVar);
    }

    public static UploadProvider provideUploadProvider(ProviderModule providerModule, Object obj) {
        return (UploadProvider) d.f(providerModule.provideUploadProvider((ZendeskUploadService) obj));
    }

    public UploadProvider get() {
        return provideUploadProvider(this.module, this.uploadServiceProvider.get());
    }
}
