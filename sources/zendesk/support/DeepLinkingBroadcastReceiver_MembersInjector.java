package zendesk.support;

import oz.a;
import zendesk.core.ActionHandlerRegistry;

public final class DeepLinkingBroadcastReceiver_MembersInjector implements a<DeepLinkingBroadcastReceiver> {
    private final q00.a<ActionHandlerRegistry> registryProvider;

    public DeepLinkingBroadcastReceiver_MembersInjector(q00.a<ActionHandlerRegistry> aVar) {
        this.registryProvider = aVar;
    }

    public static a<DeepLinkingBroadcastReceiver> create(q00.a<ActionHandlerRegistry> aVar) {
        return new DeepLinkingBroadcastReceiver_MembersInjector(aVar);
    }

    public static void injectRegistry(DeepLinkingBroadcastReceiver deepLinkingBroadcastReceiver, ActionHandlerRegistry actionHandlerRegistry) {
        deepLinkingBroadcastReceiver.registry = actionHandlerRegistry;
    }

    public void injectMembers(DeepLinkingBroadcastReceiver deepLinkingBroadcastReceiver) {
        injectRegistry(deepLinkingBroadcastReceiver, this.registryProvider.get());
    }
}
