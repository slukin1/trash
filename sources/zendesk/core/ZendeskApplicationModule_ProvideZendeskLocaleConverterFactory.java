package zendesk.core;

import dagger.internal.b;
import dagger.internal.d;

public final class ZendeskApplicationModule_ProvideZendeskLocaleConverterFactory implements b<ZendeskLocaleConverter> {
    private final ZendeskApplicationModule module;

    public ZendeskApplicationModule_ProvideZendeskLocaleConverterFactory(ZendeskApplicationModule zendeskApplicationModule) {
        this.module = zendeskApplicationModule;
    }

    public static ZendeskApplicationModule_ProvideZendeskLocaleConverterFactory create(ZendeskApplicationModule zendeskApplicationModule) {
        return new ZendeskApplicationModule_ProvideZendeskLocaleConverterFactory(zendeskApplicationModule);
    }

    public static ZendeskLocaleConverter provideZendeskLocaleConverter(ZendeskApplicationModule zendeskApplicationModule) {
        return (ZendeskLocaleConverter) d.f(zendeskApplicationModule.provideZendeskLocaleConverter());
    }

    public ZendeskLocaleConverter get() {
        return provideZendeskLocaleConverter(this.module);
    }
}
