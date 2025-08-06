package zendesk.core;

import dagger.internal.b;
import dagger.internal.d;

public final class ZendeskProvidersModule_ActionHandlerRegistryFactory implements b<ActionHandlerRegistry> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final ZendeskProvidersModule_ActionHandlerRegistryFactory INSTANCE = new ZendeskProvidersModule_ActionHandlerRegistryFactory();

        private InstanceHolder() {
        }
    }

    public static ActionHandlerRegistry actionHandlerRegistry() {
        return (ActionHandlerRegistry) d.f(ZendeskProvidersModule.actionHandlerRegistry());
    }

    public static ZendeskProvidersModule_ActionHandlerRegistryFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public ActionHandlerRegistry get() {
        return actionHandlerRegistry();
    }
}
