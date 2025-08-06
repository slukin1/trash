package zendesk.support;

import dagger.internal.b;
import dagger.internal.d;

public final class GuideModule_ProvidesHelpCenterProviderFactory implements b<HelpCenterProvider> {
    private final GuideModule module;

    public GuideModule_ProvidesHelpCenterProviderFactory(GuideModule guideModule) {
        this.module = guideModule;
    }

    public static GuideModule_ProvidesHelpCenterProviderFactory create(GuideModule guideModule) {
        return new GuideModule_ProvidesHelpCenterProviderFactory(guideModule);
    }

    public static HelpCenterProvider providesHelpCenterProvider(GuideModule guideModule) {
        return (HelpCenterProvider) d.f(guideModule.providesHelpCenterProvider());
    }

    public HelpCenterProvider get() {
        return providesHelpCenterProvider(this.module);
    }
}
