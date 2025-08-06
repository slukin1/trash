package zendesk.support;

import dagger.internal.b;
import dagger.internal.d;
import q00.a;
import zendesk.core.SessionStorage;

public final class GuideProviderModule_ProvideArticleVoteStorageFactory implements b<ArticleVoteStorage> {
    private final a<SessionStorage> baseStorageProvider;

    public GuideProviderModule_ProvideArticleVoteStorageFactory(a<SessionStorage> aVar) {
        this.baseStorageProvider = aVar;
    }

    public static GuideProviderModule_ProvideArticleVoteStorageFactory create(a<SessionStorage> aVar) {
        return new GuideProviderModule_ProvideArticleVoteStorageFactory(aVar);
    }

    public static ArticleVoteStorage provideArticleVoteStorage(SessionStorage sessionStorage) {
        return (ArticleVoteStorage) d.f(GuideProviderModule.provideArticleVoteStorage(sessionStorage));
    }

    public ArticleVoteStorage get() {
        return provideArticleVoteStorage(this.baseStorageProvider.get());
    }
}
