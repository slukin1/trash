package zendesk.support;

import dagger.internal.b;
import dagger.internal.d;
import q00.a;
import zendesk.core.RestServiceProvider;

public final class GuideProviderModule_ProvidesHelpCenterServiceFactory implements b<HelpCenterService> {
    private final a<HelpCenterCachingNetworkConfig> helpCenterCachingNetworkConfigProvider;
    private final a<RestServiceProvider> restServiceProvider;

    public GuideProviderModule_ProvidesHelpCenterServiceFactory(a<RestServiceProvider> aVar, a<HelpCenterCachingNetworkConfig> aVar2) {
        this.restServiceProvider = aVar;
        this.helpCenterCachingNetworkConfigProvider = aVar2;
    }

    public static GuideProviderModule_ProvidesHelpCenterServiceFactory create(a<RestServiceProvider> aVar, a<HelpCenterCachingNetworkConfig> aVar2) {
        return new GuideProviderModule_ProvidesHelpCenterServiceFactory(aVar, aVar2);
    }

    public static HelpCenterService providesHelpCenterService(RestServiceProvider restServiceProvider2, Object obj) {
        return (HelpCenterService) d.f(GuideProviderModule.providesHelpCenterService(restServiceProvider2, (HelpCenterCachingNetworkConfig) obj));
    }

    public HelpCenterService get() {
        return providesHelpCenterService(this.restServiceProvider.get(), this.helpCenterCachingNetworkConfigProvider.get());
    }
}
