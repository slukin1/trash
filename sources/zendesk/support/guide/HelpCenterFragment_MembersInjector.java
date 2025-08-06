package zendesk.support.guide;

import oz.a;
import zendesk.core.NetworkInfoProvider;
import zendesk.support.HelpCenterProvider;

public final class HelpCenterFragment_MembersInjector implements a<HelpCenterFragment> {
    private final q00.a<HelpCenterProvider> helpCenterProvider;
    private final q00.a<NetworkInfoProvider> networkInfoProvider;

    public HelpCenterFragment_MembersInjector(q00.a<HelpCenterProvider> aVar, q00.a<NetworkInfoProvider> aVar2) {
        this.helpCenterProvider = aVar;
        this.networkInfoProvider = aVar2;
    }

    public static a<HelpCenterFragment> create(q00.a<HelpCenterProvider> aVar, q00.a<NetworkInfoProvider> aVar2) {
        return new HelpCenterFragment_MembersInjector(aVar, aVar2);
    }

    public static void injectHelpCenterProvider(HelpCenterFragment helpCenterFragment, HelpCenterProvider helpCenterProvider2) {
        helpCenterFragment.helpCenterProvider = helpCenterProvider2;
    }

    public static void injectNetworkInfoProvider(HelpCenterFragment helpCenterFragment, NetworkInfoProvider networkInfoProvider2) {
        helpCenterFragment.networkInfoProvider = networkInfoProvider2;
    }

    public void injectMembers(HelpCenterFragment helpCenterFragment) {
        injectHelpCenterProvider(helpCenterFragment, this.helpCenterProvider.get());
        injectNetworkInfoProvider(helpCenterFragment, this.networkInfoProvider.get());
    }
}
