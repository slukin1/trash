package zendesk.support;

import dagger.internal.b;
import dagger.internal.d;
import java.util.Locale;

public final class GuideProviderModule_ProvideDeviceLocaleFactory implements b<Locale> {
    private final GuideProviderModule module;

    public GuideProviderModule_ProvideDeviceLocaleFactory(GuideProviderModule guideProviderModule) {
        this.module = guideProviderModule;
    }

    public static GuideProviderModule_ProvideDeviceLocaleFactory create(GuideProviderModule guideProviderModule) {
        return new GuideProviderModule_ProvideDeviceLocaleFactory(guideProviderModule);
    }

    public static Locale provideDeviceLocale(GuideProviderModule guideProviderModule) {
        return (Locale) d.f(guideProviderModule.provideDeviceLocale());
    }

    public Locale get() {
        return provideDeviceLocale(this.module);
    }
}
