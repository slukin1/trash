package zendesk.support;

public interface ArticleVoteStorage {
    ArticleVote getStoredArticleVote(Long l11);

    void removeStoredArticleVote(Long l11);

    void storeArticleVote(Long l11, ArticleVote articleVote);
}
