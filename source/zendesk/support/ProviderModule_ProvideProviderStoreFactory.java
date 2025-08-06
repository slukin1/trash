package zendesk.support;

import dagger.internal.b;
import dagger.internal.d;
import q00.a;

public final class ProviderModule_ProvideProviderStoreFactory implements b<ProviderStore> {
    private final a<HelpCenterProvider> helpCenterProvider;
    private final ProviderModule module;
    private final a<RequestProvider> requestProvider;
    private final a<UploadProvider> uploadProvider;

    public ProviderModule_ProvideProviderStoreFactory(ProviderModule providerModule, a<HelpCenterProvider> aVar, a<RequestProvider> aVar2, a<UploadProvider> aVar3) {
        this.module = providerModule;
        this.helpCenterProvider = aVar;
        this.requestProvider = aVar2;
        this.uploadProvider = aVar3;
    }

    public static ProviderModule_ProvideProviderStoreFactory create(ProviderModule providerModule, a<HelpCenterProvider> aVar, a<RequestProvider> aVar2, a<UploadProvider> aVar3) {
        return new ProviderModule_ProvideProviderStoreFactory(providerModule, aVar, aVar2, aVar3);
    }

    public static ProviderStore provideProviderStore(ProviderModule providerModule, HelpCenterProvider helpCenterProvider2, RequestProvider requestProvider2, UploadProvider uploadProvider2) {
        return (ProviderStore) d.f(providerModule.provideProviderStore(helpCenterProvider2, requestProvider2, uploadProvider2));
    }

    public ProviderStore get() {
        return provideProviderStore(this.module, this.helpCenterProvider.get(), this.requestProvider.get(), this.uploadProvider.get());
    }
}
