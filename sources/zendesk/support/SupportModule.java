package zendesk.support;

import java.util.UUID;
import okhttp3.OkHttpClient;

public class SupportModule {
    private final ArticleVoteStorage articleVoteStorage;
    private final SupportBlipsProvider blipsProvider;
    private final HelpCenterProvider helpCenterProvider;

    /* renamed from: id  reason: collision with root package name */
    private final UUID f62957id = UUID.randomUUID();
    private final OkHttpClient okHttpClient;
    private final RequestProvider requestProvider;
    private final SupportSettingsProvider settingsProvider;
    private final UploadProvider uploadProvider;
    private final ZendeskTracker zendeskTracker;

    public SupportModule(RequestProvider requestProvider2, UploadProvider uploadProvider2, HelpCenterProvider helpCenterProvider2, SupportSettingsProvider supportSettingsProvider, SupportBlipsProvider supportBlipsProvider, OkHttpClient okHttpClient2, ZendeskTracker zendeskTracker2, ArticleVoteStorage articleVoteStorage2) {
        this.requestProvider = requestProvider2;
        this.uploadProvider = uploadProvider2;
        this.helpCenterProvider = helpCenterProvider2;
        this.settingsProvider = supportSettingsProvider;
        this.blipsProvider = supportBlipsProvider;
        this.okHttpClient = okHttpClient2;
        this.zendeskTracker = zendeskTracker2;
        this.articleVoteStorage = articleVoteStorage2;
    }

    public UUID getId() {
        return this.f62957id;
    }

    public ArticleVoteStorage providesArticleVoteStorage() {
        return this.articleVoteStorage;
    }

    public SupportBlipsProvider providesBlipsProvider() {
        return this.blipsProvider;
    }

    public HelpCenterProvider providesHelpCenterProvider() {
        return this.helpCenterProvider;
    }

    public OkHttpClient providesOkHttpClient() {
        return this.okHttpClient;
    }

    public RequestProvider providesRequestProvider() {
        return this.requestProvider;
    }

    public SupportSettingsProvider providesSettingsProvider() {
        return this.settingsProvider;
    }

    public UploadProvider providesUploadProvider() {
        return this.uploadProvider;
    }

    public ZendeskTracker providesZendeskTracker() {
        return this.zendeskTracker;
    }
}
