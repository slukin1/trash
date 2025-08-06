package zendesk.support;

import dagger.internal.b;
import dagger.internal.d;

public final class GuideProviderModule_ProvideHelpCenterSessionCacheFactory implements b<HelpCenterSessionCache> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final GuideProviderModule_ProvideHelpCenterSessionCacheFactory INSTANCE = new GuideProviderModule_ProvideHelpCenterSessionCacheFactory();

        private InstanceHolder() {
        }
    }

    public static GuideProviderModule_ProvideHelpCenterSessionCacheFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static HelpCenterSessionCache provideHelpCenterSessionCache() {
        return (HelpCenterSessionCache) d.f(GuideProviderModule.provideHelpCenterSessionCache());
    }

    public HelpCenterSessionCache get() {
        return provideHelpCenterSessionCache();
    }
}
