package zendesk.support;

import dagger.internal.b;
import dagger.internal.d;
import java.util.List;
import zendesk.core.ActionHandler;

public final class SupportSdkModule_ProvidesActionHandlersFactory implements b<List<ActionHandler>> {
    private final SupportSdkModule module;

    public SupportSdkModule_ProvidesActionHandlersFactory(SupportSdkModule supportSdkModule) {
        this.module = supportSdkModule;
    }

    public static SupportSdkModule_ProvidesActionHandlersFactory create(SupportSdkModule supportSdkModule) {
        return new SupportSdkModule_ProvidesActionHandlersFactory(supportSdkModule);
    }

    public static List<ActionHandler> providesActionHandlers(SupportSdkModule supportSdkModule) {
        return (List) d.f(supportSdkModule.providesActionHandlers());
    }

    public List<ActionHandler> get() {
        return providesActionHandlers(this.module);
    }
}
