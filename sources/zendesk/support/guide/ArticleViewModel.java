package zendesk.support.guide;

import java.io.Serializable;
import java.util.Date;
import zendesk.support.Article;

class ArticleViewModel implements Serializable {
    private final String authorName;
    private final String body;
    private final Date createdAt;

    /* renamed from: id  reason: collision with root package name */
    private final long f62962id;
    private final String title;

    public ArticleViewModel(Article article) {
        this.f62962id = article.getId().longValue();
        this.title = article.getTitle();
        this.body = article.getBody();
        this.createdAt = article.getCreatedAt();
        this.authorName = article.getAuthor() == null ? null : article.getAuthor().getName();
    }

    public String getAuthorName() {
        return this.authorName;
    }

    public String getBody() {
        return this.body;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public long getId() {
        return this.f62962id;
    }

    public String getTitle() {
        return this.title;
    }
}
