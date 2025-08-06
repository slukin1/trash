package zendesk.support.guide;

import dagger.internal.d;
import q00.a;
import zendesk.core.ActionHandler;
import zendesk.core.CoreModule;
import zendesk.core.CoreModule_ActionHandlerRegistryFactory;
import zendesk.core.CoreModule_GetApplicationConfigurationFactory;
import zendesk.core.CoreModule_GetNetworkInfoProviderFactory;
import zendesk.support.GuideModule;
import zendesk.support.GuideModule_ProvidesArticleVoteStorageFactory;
import zendesk.support.GuideModule_ProvidesHelpCenterProviderFactory;
import zendesk.support.GuideModule_ProvidesOkHttpClientFactory;
import zendesk.support.GuideModule_ProvidesSettingsProviderFactory;

final class DaggerGuideSdkComponent {

    public static final class Builder {
        private CoreModule coreModule;
        private GuideModule guideModule;
        private GuideSdkModule guideSdkModule;

        public GuideSdkComponent build() {
            d.a(this.coreModule, CoreModule.class);
            d.a(this.guideModule, GuideModule.class);
            if (this.guideSdkModule == null) {
                this.guideSdkModule = new GuideSdkModule();
            }
            return new GuideSdkComponentImpl(this.coreModule, this.guideModule, this.guideSdkModule);
        }

        public Builder coreModule(CoreModule coreModule2) {
            this.coreModule = (CoreModule) d.b(coreModule2);
            return this;
        }

        public Builder guideModule(GuideModule guideModule2) {
            this.guideModule = (GuideModule) d.b(guideModule2);
            return this;
        }

        public Builder guideSdkModule(GuideSdkModule guideSdkModule2) {
            this.guideSdkModule = (GuideSdkModule) d.b(guideSdkModule2);
            return this;
        }

        private Builder() {
        }
    }

    public static final class GuideSdkComponentImpl implements GuideSdkComponent {
        private final CoreModule coreModule;
        private final GuideModule guideModule;
        private final GuideSdkComponentImpl guideSdkComponentImpl;
        private final GuideSdkModule guideSdkModule;
        private a<ActionHandler> viewArticleActionHandlerProvider;

        private void initialize(CoreModule coreModule2, GuideModule guideModule2, GuideSdkModule guideSdkModule2) {
            this.viewArticleActionHandlerProvider = dagger.internal.a.a(GuideSdkModule_ViewArticleActionHandlerFactory.create());
        }

        private GuideSdkDependencyProvider injectGuideSdkDependencyProvider(GuideSdkDependencyProvider guideSdkDependencyProvider) {
            GuideSdkDependencyProvider_MembersInjector.injectRegistry(guideSdkDependencyProvider, CoreModule_ActionHandlerRegistryFactory.actionHandlerRegistry(this.coreModule));
            GuideSdkDependencyProvider_MembersInjector.injectActionHandler(guideSdkDependencyProvider, this.viewArticleActionHandlerProvider.get());
            return guideSdkDependencyProvider;
        }

        private HelpCenterActivity injectHelpCenterActivity(HelpCenterActivity helpCenterActivity) {
            HelpCenterActivity_MembersInjector.injectHelpCenterProvider(helpCenterActivity, GuideModule_ProvidesHelpCenterProviderFactory.providesHelpCenterProvider(this.guideModule));
            HelpCenterActivity_MembersInjector.injectSettingsProvider(helpCenterActivity, GuideModule_ProvidesSettingsProviderFactory.providesSettingsProvider(this.guideModule));
            HelpCenterActivity_MembersInjector.injectNetworkInfoProvider(helpCenterActivity, CoreModule_GetNetworkInfoProviderFactory.getNetworkInfoProvider(this.coreModule));
            HelpCenterActivity_MembersInjector.injectActionHandlerRegistry(helpCenterActivity, CoreModule_ActionHandlerRegistryFactory.actionHandlerRegistry(this.coreModule));
            HelpCenterActivity_MembersInjector.injectConfigurationHelper(helpCenterActivity, GuideSdkModule_ConfigurationHelperFactory.configurationHelper(this.guideSdkModule));
            return helpCenterActivity;
        }

        private HelpCenterFragment injectHelpCenterFragment(HelpCenterFragment helpCenterFragment) {
            HelpCenterFragment_MembersInjector.injectHelpCenterProvider(helpCenterFragment, GuideModule_ProvidesHelpCenterProviderFactory.providesHelpCenterProvider(this.guideModule));
            HelpCenterFragment_MembersInjector.injectNetworkInfoProvider(helpCenterFragment, CoreModule_GetNetworkInfoProviderFactory.getNetworkInfoProvider(this.coreModule));
            return helpCenterFragment;
        }

        private ViewArticleActivity injectViewArticleActivity(ViewArticleActivity viewArticleActivity) {
            ViewArticleActivity_MembersInjector.injectOkHttpClient(viewArticleActivity, GuideModule_ProvidesOkHttpClientFactory.providesOkHttpClient(this.guideModule));
            ViewArticleActivity_MembersInjector.injectApplicationConfiguration(viewArticleActivity, CoreModule_GetApplicationConfigurationFactory.getApplicationConfiguration(this.coreModule));
            ViewArticleActivity_MembersInjector.injectHelpCenterProvider(viewArticleActivity, GuideModule_ProvidesHelpCenterProviderFactory.providesHelpCenterProvider(this.guideModule));
            ViewArticleActivity_MembersInjector.injectArticleVoteStorage(viewArticleActivity, GuideModule_ProvidesArticleVoteStorageFactory.providesArticleVoteStorage(this.guideModule));
            ViewArticleActivity_MembersInjector.injectNetworkInfoProvider(viewArticleActivity, CoreModule_GetNetworkInfoProviderFactory.getNetworkInfoProvider(this.coreModule));
            ViewArticleActivity_MembersInjector.injectSettingsProvider(viewArticleActivity, GuideModule_ProvidesSettingsProviderFactory.providesSettingsProvider(this.guideModule));
            ViewArticleActivity_MembersInjector.injectActionHandlerRegistry(viewArticleActivity, CoreModule_ActionHandlerRegistryFactory.actionHandlerRegistry(this.coreModule));
            ViewArticleActivity_MembersInjector.injectConfigurationHelper(viewArticleActivity, GuideSdkModule_ConfigurationHelperFactory.configurationHelper(this.guideSdkModule));
            return viewArticleActivity;
        }

        public void inject(GuideSdkDependencyProvider guideSdkDependencyProvider) {
            injectGuideSdkDependencyProvider(guideSdkDependencyProvider);
        }

        private GuideSdkComponentImpl(CoreModule coreModule2, GuideModule guideModule2, GuideSdkModule guideSdkModule2) {
            this.guideSdkComponentImpl = this;
            this.coreModule = coreModule2;
            this.guideModule = guideModule2;
            this.guideSdkModule = guideSdkModule2;
            initialize(coreModule2, guideModule2, guideSdkModule2);
        }

        public void inject(ViewArticleActivity viewArticleActivity) {
            injectViewArticleActivity(viewArticleActivity);
        }

        public void inject(HelpCenterActivity helpCenterActivity) {
            injectHelpCenterActivity(helpCenterActivity);
        }

        public void inject(HelpCenterFragment helpCenterFragment) {
            injectHelpCenterFragment(helpCenterFragment);
        }
    }

    private DaggerGuideSdkComponent() {
    }

    public static Builder builder() {
        return new Builder();
    }
}
