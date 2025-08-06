package zendesk.support;

import dagger.internal.b;
import dagger.internal.d;

public final class GuideModule_ProvidesArticleVoteStorageFactory implements b<ArticleVoteStorage> {
    private final GuideModule module;

    public GuideModule_ProvidesArticleVoteStorageFactory(GuideModule guideModule) {
        this.module = guideModule;
    }

    public static GuideModule_ProvidesArticleVoteStorageFactory create(GuideModule guideModule) {
        return new GuideModule_ProvidesArticleVoteStorageFactory(guideModule);
    }

    public static ArticleVoteStorage providesArticleVoteStorage(GuideModule guideModule) {
        return (ArticleVoteStorage) d.f(guideModule.providesArticleVoteStorage());
    }

    public ArticleVoteStorage get() {
        return providesArticleVoteStorage(this.module);
    }
}
