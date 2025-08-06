package zendesk.support;

import oz.a;

public final class Guide_MembersInjector implements a<Guide> {
    private final q00.a<HelpCenterBlipsProvider> blipsProvider;
    private final q00.a<GuideModule> guideModuleProvider;

    public Guide_MembersInjector(q00.a<GuideModule> aVar, q00.a<HelpCenterBlipsProvider> aVar2) {
        this.guideModuleProvider = aVar;
        this.blipsProvider = aVar2;
    }

    public static a<Guide> create(q00.a<GuideModule> aVar, q00.a<HelpCenterBlipsProvider> aVar2) {
        return new Guide_MembersInjector(aVar, aVar2);
    }

    public static void injectBlipsProvider(Guide guide, HelpCenterBlipsProvider helpCenterBlipsProvider) {
        guide.blipsProvider = helpCenterBlipsProvider;
    }

    public static void injectGuideModule(Guide guide, GuideModule guideModule) {
        guide.guideModule = guideModule;
    }

    public void injectMembers(Guide guide) {
        injectGuideModule(guide, this.guideModuleProvider.get());
        injectBlipsProvider(guide, this.blipsProvider.get());
    }
}
