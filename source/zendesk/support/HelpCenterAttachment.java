package zendesk.support;

import java.util.Date;

public class HelpCenterAttachment {
    private Long articleId;
    private String contentType;
    private String contentUrl;
    private Date createdAt;
    private String fileName;

    /* renamed from: id  reason: collision with root package name */
    private Long f62946id;
    private Long size;
    private Date updatedAt;
    private String url;

    public Long getArticleId() {
        return this.articleId;
    }

    public String getContentType() {
        return this.contentType;
    }

    public String getContentUrl() {
        return this.contentUrl;
    }

    public Date getCreatedAt() {
        if (this.createdAt == null) {
            return null;
        }
        return new Date(this.createdAt.getTime());
    }

    public String getFileName() {
        return this.fileName;
    }

    public Long getId() {
        return this.f62946id;
    }

    public Long getSize() {
        return this.size;
    }

    public Date getUpdatedAt() {
        if (this.updatedAt == null) {
            return null;
        }
        return new Date(this.updatedAt.getTime());
    }

    public String getUrl() {
        return this.url;
    }
}
