package zendesk.support.guide;

import oz.a;
import zendesk.configurations.ConfigurationHelper;
import zendesk.core.ActionHandlerRegistry;
import zendesk.core.NetworkInfoProvider;
import zendesk.support.HelpCenterProvider;
import zendesk.support.HelpCenterSettingsProvider;

public final class HelpCenterActivity_MembersInjector implements a<HelpCenterActivity> {
    private final q00.a<ActionHandlerRegistry> actionHandlerRegistryProvider;
    private final q00.a<ConfigurationHelper> configurationHelperProvider;
    private final q00.a<HelpCenterProvider> helpCenterProvider;
    private final q00.a<NetworkInfoProvider> networkInfoProvider;
    private final q00.a<HelpCenterSettingsProvider> settingsProvider;

    public HelpCenterActivity_MembersInjector(q00.a<HelpCenterProvider> aVar, q00.a<HelpCenterSettingsProvider> aVar2, q00.a<NetworkInfoProvider> aVar3, q00.a<ActionHandlerRegistry> aVar4, q00.a<ConfigurationHelper> aVar5) {
        this.helpCenterProvider = aVar;
        this.settingsProvider = aVar2;
        this.networkInfoProvider = aVar3;
        this.actionHandlerRegistryProvider = aVar4;
        this.configurationHelperProvider = aVar5;
    }

    public static a<HelpCenterActivity> create(q00.a<HelpCenterProvider> aVar, q00.a<HelpCenterSettingsProvider> aVar2, q00.a<NetworkInfoProvider> aVar3, q00.a<ActionHandlerRegistry> aVar4, q00.a<ConfigurationHelper> aVar5) {
        return new HelpCenterActivity_MembersInjector(aVar, aVar2, aVar3, aVar4, aVar5);
    }

    public static void injectActionHandlerRegistry(HelpCenterActivity helpCenterActivity, ActionHandlerRegistry actionHandlerRegistry) {
        helpCenterActivity.actionHandlerRegistry = actionHandlerRegistry;
    }

    public static void injectConfigurationHelper(HelpCenterActivity helpCenterActivity, ConfigurationHelper configurationHelper) {
        helpCenterActivity.configurationHelper = configurationHelper;
    }

    public static void injectHelpCenterProvider(HelpCenterActivity helpCenterActivity, HelpCenterProvider helpCenterProvider2) {
        helpCenterActivity.helpCenterProvider = helpCenterProvider2;
    }

    public static void injectNetworkInfoProvider(HelpCenterActivity helpCenterActivity, NetworkInfoProvider networkInfoProvider2) {
        helpCenterActivity.networkInfoProvider = networkInfoProvider2;
    }

    public static void injectSettingsProvider(HelpCenterActivity helpCenterActivity, HelpCenterSettingsProvider helpCenterSettingsProvider) {
        helpCenterActivity.settingsProvider = helpCenterSettingsProvider;
    }

    public void injectMembers(HelpCenterActivity helpCenterActivity) {
        injectHelpCenterProvider(helpCenterActivity, this.helpCenterProvider.get());
        injectSettingsProvider(helpCenterActivity, this.settingsProvider.get());
        injectNetworkInfoProvider(helpCenterActivity, this.networkInfoProvider.get());
        injectActionHandlerRegistry(helpCenterActivity, this.actionHandlerRegistryProvider.get());
        injectConfigurationHelper(helpCenterActivity, this.configurationHelperProvider.get());
    }
}
