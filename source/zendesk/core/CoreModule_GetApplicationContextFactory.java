package zendesk.core;

import android.content.Context;
import dagger.internal.b;
import dagger.internal.d;

public final class CoreModule_GetApplicationContextFactory implements b<Context> {
    private final CoreModule module;

    public CoreModule_GetApplicationContextFactory(CoreModule coreModule) {
        this.module = coreModule;
    }

    public static CoreModule_GetApplicationContextFactory create(CoreModule coreModule) {
        return new CoreModule_GetApplicationContextFactory(coreModule);
    }

    public static Context getApplicationContext(CoreModule coreModule) {
        return (Context) d.f(coreModule.getApplicationContext());
    }

    public Context get() {
        return getApplicationContext(this.module);
    }
}
