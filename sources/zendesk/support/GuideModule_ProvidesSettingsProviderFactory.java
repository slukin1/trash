package zendesk.support;

import dagger.internal.b;
import dagger.internal.d;

public final class GuideModule_ProvidesSettingsProviderFactory implements b<HelpCenterSettingsProvider> {
    private final GuideModule module;

    public GuideModule_ProvidesSettingsProviderFactory(GuideModule guideModule) {
        this.module = guideModule;
    }

    public static GuideModule_ProvidesSettingsProviderFactory create(GuideModule guideModule) {
        return new GuideModule_ProvidesSettingsProviderFactory(guideModule);
    }

    public static HelpCenterSettingsProvider providesSettingsProvider(GuideModule guideModule) {
        return (HelpCenterSettingsProvider) d.f(guideModule.providesSettingsProvider());
    }

    public HelpCenterSettingsProvider get() {
        return providesSettingsProvider(this.module);
    }
}
