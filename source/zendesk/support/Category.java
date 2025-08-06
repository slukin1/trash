package zendesk.support;

import java.io.Serializable;
import java.util.Date;

public class Category implements Serializable {
    private Date createdAt;
    private String description;
    private String htmlUrl;

    /* renamed from: id  reason: collision with root package name */
    private Long f62939id;
    private String locale;
    private String name;
    private boolean outdated;
    private int position;
    private String sourceLocale;
    private Date updatedAt;
    private String url;

    public Date getCreatedAt() {
        if (this.createdAt == null) {
            return null;
        }
        return new Date(this.createdAt.getTime());
    }

    public String getDescription() {
        return this.description;
    }

    public String getHtmlUrl() {
        return this.htmlUrl;
    }

    public Long getId() {
        return this.f62939id;
    }

    public String getLocale() {
        return this.locale;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    public String getSourceLocale() {
        return this.sourceLocale;
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

    public boolean isOutdated() {
        return this.outdated;
    }
}
