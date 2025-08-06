package zendesk.support;

import oz.a;
import zendesk.core.ActionHandlerRegistry;
import zendesk.core.AuthenticationProvider;

public final class Support_MembersInjector implements a<Support> {
    private final q00.a<ActionHandlerRegistry> actionHandlerRegistryProvider;
    private final q00.a<AuthenticationProvider> authenticationProvider;
    private final q00.a<SupportBlipsProvider> blipsProvider;
    private final q00.a<ProviderStore> providerStoreProvider;
    private final q00.a<RequestMigrator> requestMigratorProvider;
    private final q00.a<RequestProvider> requestProvider;
    private final q00.a<SupportModule> supportModuleProvider;

    public Support_MembersInjector(q00.a<ProviderStore> aVar, q00.a<SupportModule> aVar2, q00.a<RequestMigrator> aVar3, q00.a<SupportBlipsProvider> aVar4, q00.a<ActionHandlerRegistry> aVar5, q00.a<RequestProvider> aVar6, q00.a<AuthenticationProvider> aVar7) {
        this.providerStoreProvider = aVar;
        this.supportModuleProvider = aVar2;
        this.requestMigratorProvider = aVar3;
        this.blipsProvider = aVar4;
        this.actionHandlerRegistryProvider = aVar5;
        this.requestProvider = aVar6;
        this.authenticationProvider = aVar7;
    }

    public static a<Support> create(q00.a<ProviderStore> aVar, q00.a<SupportModule> aVar2, q00.a<RequestMigrator> aVar3, q00.a<SupportBlipsProvider> aVar4, q00.a<ActionHandlerRegistry> aVar5, q00.a<RequestProvider> aVar6, q00.a<AuthenticationProvider> aVar7) {
        return new Support_MembersInjector(aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7);
    }

    public static void injectActionHandlerRegistry(Support support, ActionHandlerRegistry actionHandlerRegistry) {
        support.actionHandlerRegistry = actionHandlerRegistry;
    }

    public static void injectAuthenticationProvider(Support support, AuthenticationProvider authenticationProvider2) {
        support.authenticationProvider = authenticationProvider2;
    }

    public static void injectBlipsProvider(Support support, SupportBlipsProvider supportBlipsProvider) {
        support.blipsProvider = supportBlipsProvider;
    }

    public static void injectProviderStore(Support support, ProviderStore providerStore) {
        support.providerStore = providerStore;
    }

    public static void injectRequestMigrator(Support support, Object obj) {
        support.requestMigrator = (RequestMigrator) obj;
    }

    public static void injectRequestProvider(Support support, RequestProvider requestProvider2) {
        support.requestProvider = requestProvider2;
    }

    public static void injectSupportModule(Support support, SupportModule supportModule) {
        support.supportModule = supportModule;
    }

    public void injectMembers(Support support) {
        injectProviderStore(support, this.providerStoreProvider.get());
        injectSupportModule(support, this.supportModuleProvider.get());
        injectRequestMigrator(support, this.requestMigratorProvider.get());
        injectBlipsProvider(support, this.blipsProvider.get());
        injectActionHandlerRegistry(support, this.actionHandlerRegistryProvider.get());
        injectRequestProvider(support, this.requestProvider.get());
        injectAuthenticationProvider(support, this.authenticationProvider.get());
    }
}
