package zendesk.support.guide;

import oz.a;
import zendesk.core.ActionHandler;
import zendesk.core.ActionHandlerRegistry;

public final class GuideSdkDependencyProvider_MembersInjector implements a<GuideSdkDependencyProvider> {
    private final q00.a<ActionHandler> actionHandlerProvider;
    private final q00.a<ActionHandlerRegistry> registryProvider;

    public GuideSdkDependencyProvider_MembersInjector(q00.a<ActionHandlerRegistry> aVar, q00.a<ActionHandler> aVar2) {
        this.registryProvider = aVar;
        this.actionHandlerProvider = aVar2;
    }

    public static a<GuideSdkDependencyProvider> create(q00.a<ActionHandlerRegistry> aVar, q00.a<ActionHandler> aVar2) {
        return new GuideSdkDependencyProvider_MembersInjector(aVar, aVar2);
    }

    public static void injectActionHandler(Object obj, ActionHandler actionHandler) {
        ((GuideSdkDependencyProvider) obj).actionHandler = actionHandler;
    }

    public static void injectRegistry(Object obj, ActionHandlerRegistry actionHandlerRegistry) {
        ((GuideSdkDependencyProvider) obj).registry = actionHandlerRegistry;
    }

    public void injectMembers(GuideSdkDependencyProvider guideSdkDependencyProvider) {
        injectRegistry(guideSdkDependencyProvider, this.registryProvider.get());
        injectActionHandler(guideSdkDependencyProvider, this.actionHandlerProvider.get());
    }
}
