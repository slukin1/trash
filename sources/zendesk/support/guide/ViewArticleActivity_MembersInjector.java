package zendesk.support.guide;

import okhttp3.OkHttpClient;
import oz.a;
import zendesk.configurations.ConfigurationHelper;
import zendesk.core.ActionHandlerRegistry;
import zendesk.core.ApplicationConfiguration;
import zendesk.core.NetworkInfoProvider;
import zendesk.support.ArticleVoteStorage;
import zendesk.support.HelpCenterProvider;
import zendesk.support.HelpCenterSettingsProvider;

public final class ViewArticleActivity_MembersInjector implements a<ViewArticleActivity> {
    private final q00.a<ActionHandlerRegistry> actionHandlerRegistryProvider;
    private final q00.a<ApplicationConfiguration> applicationConfigurationProvider;
    private final q00.a<ArticleVoteStorage> articleVoteStorageProvider;
    private final q00.a<ConfigurationHelper> configurationHelperProvider;
    private final q00.a<HelpCenterProvider> helpCenterProvider;
    private final q00.a<NetworkInfoProvider> networkInfoProvider;
    private final q00.a<OkHttpClient> okHttpClientProvider;
    private final q00.a<HelpCenterSettingsProvider> settingsProvider;

    public ViewArticleActivity_MembersInjector(q00.a<OkHttpClient> aVar, q00.a<ApplicationConfiguration> aVar2, q00.a<HelpCenterProvider> aVar3, q00.a<ArticleVoteStorage> aVar4, q00.a<NetworkInfoProvider> aVar5, q00.a<HelpCenterSettingsProvider> aVar6, q00.a<ActionHandlerRegistry> aVar7, q00.a<ConfigurationHelper> aVar8) {
        this.okHttpClientProvider = aVar;
        this.applicationConfigurationProvider = aVar2;
        this.helpCenterProvider = aVar3;
        this.articleVoteStorageProvider = aVar4;
        this.networkInfoProvider = aVar5;
        this.settingsProvider = aVar6;
        this.actionHandlerRegistryProvider = aVar7;
        this.configurationHelperProvider = aVar8;
    }

    public static a<ViewArticleActivity> create(q00.a<OkHttpClient> aVar, q00.a<ApplicationConfiguration> aVar2, q00.a<HelpCenterProvider> aVar3, q00.a<ArticleVoteStorage> aVar4, q00.a<NetworkInfoProvider> aVar5, q00.a<HelpCenterSettingsProvider> aVar6, q00.a<ActionHandlerRegistry> aVar7, q00.a<ConfigurationHelper> aVar8) {
        return new ViewArticleActivity_MembersInjector(aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7, aVar8);
    }

    public static void injectActionHandlerRegistry(ViewArticleActivity viewArticleActivity, ActionHandlerRegistry actionHandlerRegistry) {
        viewArticleActivity.actionHandlerRegistry = actionHandlerRegistry;
    }

    public static void injectApplicationConfiguration(ViewArticleActivity viewArticleActivity, ApplicationConfiguration applicationConfiguration) {
        viewArticleActivity.applicationConfiguration = applicationConfiguration;
    }

    public static void injectArticleVoteStorage(ViewArticleActivity viewArticleActivity, ArticleVoteStorage articleVoteStorage) {
        viewArticleActivity.articleVoteStorage = articleVoteStorage;
    }

    public static void injectConfigurationHelper(ViewArticleActivity viewArticleActivity, ConfigurationHelper configurationHelper) {
        viewArticleActivity.configurationHelper = configurationHelper;
    }

    public static void injectHelpCenterProvider(ViewArticleActivity viewArticleActivity, HelpCenterProvider helpCenterProvider2) {
        viewArticleActivity.helpCenterProvider = helpCenterProvider2;
    }

    public static void injectNetworkInfoProvider(ViewArticleActivity viewArticleActivity, NetworkInfoProvider networkInfoProvider2) {
        viewArticleActivity.networkInfoProvider = networkInfoProvider2;
    }

    public static void injectOkHttpClient(ViewArticleActivity viewArticleActivity, OkHttpClient okHttpClient) {
        viewArticleActivity.okHttpClient = okHttpClient;
    }

    public static void injectSettingsProvider(ViewArticleActivity viewArticleActivity, HelpCenterSettingsProvider helpCenterSettingsProvider) {
        viewArticleActivity.settingsProvider = helpCenterSettingsProvider;
    }

    public void injectMembers(ViewArticleActivity viewArticleActivity) {
        injectOkHttpClient(viewArticleActivity, this.okHttpClientProvider.get());
        injectApplicationConfiguration(viewArticleActivity, this.applicationConfigurationProvider.get());
        injectHelpCenterProvider(viewArticleActivity, this.helpCenterProvider.get());
        injectArticleVoteStorage(viewArticleActivity, this.articleVoteStorageProvider.get());
        injectNetworkInfoProvider(viewArticleActivity, this.networkInfoProvider.get());
        injectSettingsProvider(viewArticleActivity, this.settingsProvider.get());
        injectActionHandlerRegistry(viewArticleActivity, this.actionHandlerRegistryProvider.get());
        injectConfigurationHelper(viewArticleActivity, this.configurationHelperProvider.get());
    }
}
