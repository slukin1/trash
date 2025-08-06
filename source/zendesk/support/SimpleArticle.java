package zendesk.support;

import java.io.Serializable;

public class SimpleArticle implements Serializable {

    /* renamed from: id  reason: collision with root package name */
    private Long f62956id;
    private String title;

    public SimpleArticle(Long l11, String str) {
        this.f62956id = l11;
        this.title = str;
    }

    public Long getId() {
        return this.f62956id;
    }

    public String getTitle() {
        return this.title;
    }
}
