package zendesk.core;

import dagger.internal.b;
import dagger.internal.d;

public final class CoreModule_ActionHandlerRegistryFactory implements b<ActionHandlerRegistry> {
    private final CoreModule module;

    public CoreModule_ActionHandlerRegistryFactory(CoreModule coreModule) {
        this.module = coreModule;
    }

    public static ActionHandlerRegistry actionHandlerRegistry(CoreModule coreModule) {
        return (ActionHandlerRegistry) d.f(coreModule.actionHandlerRegistry());
    }

    public static CoreModule_ActionHandlerRegistryFactory create(CoreModule coreModule) {
        return new CoreModule_ActionHandlerRegistryFactory(coreModule);
    }

    public ActionHandlerRegistry get() {
        return actionHandlerRegistry(this.module);
    }
}
