package zendesk.support;

import dagger.internal.b;
import dagger.internal.d;
import q00.a;

public final class GuideProviderModule_ProvideCustomNetworkConfigFactory implements b<HelpCenterCachingNetworkConfig> {
    private final a<HelpCenterCachingInterceptor> helpCenterCachingInterceptorProvider;

    public GuideProviderModule_ProvideCustomNetworkConfigFactory(a<HelpCenterCachingInterceptor> aVar) {
        this.helpCenterCachingInterceptorProvider = aVar;
    }

    public static GuideProviderModule_ProvideCustomNetworkConfigFactory create(a<HelpCenterCachingInterceptor> aVar) {
        return new GuideProviderModule_ProvideCustomNetworkConfigFactory(aVar);
    }

    public static HelpCenterCachingNetworkConfig provideCustomNetworkConfig(Object obj) {
        return (HelpCenterCachingNetworkConfig) d.f(GuideProviderModule.provideCustomNetworkConfig((HelpCenterCachingInterceptor) obj));
    }

    public HelpCenterCachingNetworkConfig get() {
        return provideCustomNetworkConfig(this.helpCenterCachingInterceptorProvider.get());
    }
}
