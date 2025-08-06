package zendesk.support;

import java.io.Serializable;
import java.util.List;
import mz.a;

public class Attachment implements Serializable {
    private String contentType;
    private String contentUrl;
    private String fileName;
    private Long height;

    /* renamed from: id  reason: collision with root package name */
    private Long f62938id;
    private String mappedContentUrl;
    private Long size;
    private List<Attachment> thumbnails;
    private String url;
    private Long width;

    public String getContentType() {
        return this.contentType;
    }

    public String getContentUrl() {
        return this.contentUrl;
    }

    public String getFileName() {
        return this.fileName;
    }

    public Long getHeight() {
        return this.height;
    }

    public Long getId() {
        return this.f62938id;
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

    public Long getWidth() {
        return this.width;
    }
}
