package zendesk.support;

import dagger.internal.b;
import dagger.internal.d;
import java.util.Locale;

public final class SupportApplicationModule_ProvideLocaleFactory implements b<Locale> {
    private final SupportApplicationModule module;

    public SupportApplicationModule_ProvideLocaleFactory(SupportApplicationModule supportApplicationModule) {
        this.module = supportApplicationModule;
    }

    public static SupportApplicationModule_ProvideLocaleFactory create(SupportApplicationModule supportApplicationModule) {
        return new SupportApplicationModule_ProvideLocaleFactory(supportApplicationModule);
    }

    public static Locale provideLocale(SupportApplicationModule supportApplicationModule) {
        return (Locale) d.f(supportApplicationModule.provideLocale());
    }

    public Locale get() {
        return provideLocale(this.module);
    }
}
