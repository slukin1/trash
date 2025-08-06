package zendesk.support;

import dagger.internal.b;
import dagger.internal.d;
import java.util.Locale;
import q00.a;
import zendesk.core.BlipsProvider;

public final class GuideProviderModule_ProvidesHelpCenterBlipsProviderFactory implements b<HelpCenterBlipsProvider> {
    private final a<BlipsProvider> blipsProvider;
    private final a<Locale> localeProvider;
    private final GuideProviderModule module;

    public GuideProviderModule_ProvidesHelpCenterBlipsProviderFactory(GuideProviderModule guideProviderModule, a<BlipsProvider> aVar, a<Locale> aVar2) {
        this.module = guideProviderModule;
        this.blipsProvider = aVar;
        this.localeProvider = aVar2;
    }

    public static GuideProviderModule_ProvidesHelpCenterBlipsProviderFactory create(GuideProviderModule guideProviderModule, a<BlipsProvider> aVar, a<Locale> aVar2) {
        return new GuideProviderModule_ProvidesHelpCenterBlipsProviderFactory(guideProviderModule, aVar, aVar2);
    }

    public static HelpCenterBlipsProvider providesHelpCenterBlipsProvider(GuideProviderModule guideProviderModule, BlipsProvider blipsProvider2, Locale locale) {
        return (HelpCenterBlipsProvider) d.f(guideProviderModule.providesHelpCenterBlipsProvider(blipsProvider2, locale));
    }

    public HelpCenterBlipsProvider get() {
        return providesHelpCenterBlipsProvider(this.module, this.blipsProvider.get(), this.localeProvider.get());
    }
}
