package zendesk.core;

import android.content.Context;
import dagger.internal.b;
import dagger.internal.d;

public final class ZendeskApplicationModule_ProvideApplicationContextFactory implements b<Context> {
    private final ZendeskApplicationModule module;

    public ZendeskApplicationModule_ProvideApplicationContextFactory(ZendeskApplicationModule zendeskApplicationModule) {
        this.module = zendeskApplicationModule;
    }

    public static ZendeskApplicationModule_ProvideApplicationContextFactory create(ZendeskApplicationModule zendeskApplicationModule) {
        return new ZendeskApplicationModule_ProvideApplicationContextFactory(zendeskApplicationModule);
    }

    public static Context provideApplicationContext(ZendeskApplicationModule zendeskApplicationModule) {
        return (Context) d.f(zendeskApplicationModule.provideApplicationContext());
    }

    public Context get() {
        return provideApplicationContext(this.module);
    }
}
