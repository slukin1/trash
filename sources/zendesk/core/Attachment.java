package zendesk.core;

import java.util.List;
import mz.a;

class Attachment {
    private String contentType;
    private String contentUrl;
    private String fileName;

    /* renamed from: id  reason: collision with root package name */
    private Long f62931id;
    private String mappedContentUrl;
    private Long size;
    private List<Attachment> thumbnails;
    private String url;

    public String getContentType() {
        return this.contentType;
    }

    public String getContentUrl() {
        return this.contentUrl;
    }

    public String getFileName() {
        return this.fileName;
    }

    public Long getId() {
        return this.f62931id;
    }

    public Long getSize() {
        return this.size;
    }

    public List<Attachment> getThumbnails() {
        return a.c(this.thumbnails);
    }

    public String getUrl() {
        return this.url;
    }
}
