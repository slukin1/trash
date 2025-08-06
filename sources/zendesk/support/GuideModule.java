package zendesk.support;

import java.util.UUID;
import okhttp3.OkHttpClient;

public class GuideModule {
    private final ArticleVoteStorage articleVoteStorage;
    private final HelpCenterBlipsProvider blipsProvider;
    private final HelpCenterProvider helpCenterProvider;
    private final HelpCenterTracker helpCenterTracker;

    /* renamed from: id  reason: collision with root package name */
    private final UUID f62945id = UUID.randomUUID();
    private final OkHttpClient okHttpClient;
    private final HelpCenterSettingsProvider settingsProvider;

    public GuideModule(HelpCenterProvider helpCenterProvider2, HelpCenterSettingsProvider helpCenterSettingsProvider, HelpCenterBlipsProvider helpCenterBlipsProvider, HelpCenterTracker helpCenterTracker2, ArticleVoteStorage articleVoteStorage2, OkHttpClient okHttpClient2) {
        this.helpCenterProvider = helpCenterProvider2;
        this.settingsProvider = helpCenterSettingsProvider;
        this.blipsProvider = helpCenterBlipsProvider;
        this.helpCenterTracker = helpCenterTracker2;
        this.articleVoteStorage = articleVoteStorage2;
        this.okHttpClient = okHttpClient2;
    }

    public UUID getId() {
        return this.f62945id;
    }

    public ArticleVoteStorage providesArticleVoteStorage() {
        return this.articleVoteStorage;
    }

    public HelpCenterBlipsProvider providesBlipsProvider() {
        return this.blipsProvider;
    }

    public HelpCenterProvider providesHelpCenterProvider() {
        return this.helpCenterProvider;
    }

    public HelpCenterTracker providesHelpCenterTracker() {
        return this.helpCenterTracker;
    }

    public OkHttpClient providesOkHttpClient() {
        return this.okHttpClient;
    }

    public HelpCenterSettingsProvider providesSettingsProvider() {
        return this.settingsProvider;
    }
}
