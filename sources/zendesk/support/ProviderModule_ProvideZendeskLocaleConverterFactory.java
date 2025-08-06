package zendesk.support;

import dagger.internal.b;
import dagger.internal.d;
import zendesk.core.ZendeskLocaleConverter;

public final class ProviderModule_ProvideZendeskLocaleConverterFactory implements b<ZendeskLocaleConverter> {
    private final ProviderModule module;

    public ProviderModule_ProvideZendeskLocaleConverterFactory(ProviderModule providerModule) {
        this.module = providerModule;
    }

    public static ProviderModule_ProvideZendeskLocaleConverterFactory create(ProviderModule providerModule) {
        return new ProviderModule_ProvideZendeskLocaleConverterFactory(providerModule);
    }

    public static ZendeskLocaleConverter provideZendeskLocaleConverter(ProviderModule providerModule) {
        return (ZendeskLocaleConverter) d.f(providerModule.provideZendeskLocaleConverter());
    }

    public ZendeskLocaleConverter get() {
        return provideZendeskLocaleConverter(this.module);
    }
}
