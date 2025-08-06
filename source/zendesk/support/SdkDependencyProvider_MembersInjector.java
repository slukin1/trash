package zendesk.support;

import java.util.List;
import oz.a;
import zendesk.core.ActionHandler;
import zendesk.core.ActionHandlerRegistry;

public final class SdkDependencyProvider_MembersInjector implements a<SdkDependencyProvider> {
    private final q00.a<List<ActionHandler>> actionHandlersProvider;
    private final q00.a<ActionHandlerRegistry> registryProvider;

    public SdkDependencyProvider_MembersInjector(q00.a<ActionHandlerRegistry> aVar, q00.a<List<ActionHandler>> aVar2) {
        this.registryProvider = aVar;
        this.actionHandlersProvider = aVar2;
    }

    public static a<SdkDependencyProvider> create(q00.a<ActionHandlerRegistry> aVar, q00.a<List<ActionHandler>> aVar2) {
        return new SdkDependencyProvider_MembersInjector(aVar, aVar2);
    }

    public static void injectActionHandlers(SdkDependencyProvider sdkDependencyProvider, List<ActionHandler> list) {
        sdkDependencyProvider.actionHandlers = list;
    }

    public static void injectRegistry(SdkDependencyProvider sdkDependencyProvider, ActionHandlerRegistry actionHandlerRegistry) {
        sdkDependencyProvider.registry = actionHandlerRegistry;
    }

    public void injectMembers(SdkDependencyProvider sdkDependencyProvider) {
        injectRegistry(sdkDependencyProvider, this.registryProvider.get());
        injectActionHandlers(sdkDependencyProvider, this.actionHandlersProvider.get());
    }
}
