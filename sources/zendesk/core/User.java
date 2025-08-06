package zendesk.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mz.a;

public class User {
    private final boolean agent = false;

    /* renamed from: id  reason: collision with root package name */
    private final Long f62932id = -1L;
    private final String name = "";
    private final Attachment photo = null;
    private final List<String> tags = new ArrayList();
    private final Map<String, String> userFields = new HashMap();

    public Long getId() {
        return this.f62932id;
    }

    public String getName() {
        return this.name;
    }

    public String getPhoto() {
        Attachment attachment = this.photo;
        if (attachment == null) {
            return null;
        }
        return attachment.getContentUrl();
    }

    public List<String> getTags() {
        return a.c(this.tags);
    }

    public Map<String, String> getUserFields() {
        return a.d(this.userFields);
    }

    public boolean isAgent() {
        return this.agent;
    }
}
