package zendesk.support;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mz.a;

public class User implements Serializable {
    private boolean agent;

    /* renamed from: id  reason: collision with root package name */
    private Long f62961id;
    private String name;
    private Long organizationId;
    private Attachment photo;
    private List<String> tags;
    private Map<String, String> userFields;

    public User(Long l11, String str, Attachment attachment, boolean z11, Long l12, List<String> list, Map<String, String> map) {
        this.f62961id = l11;
        this.name = str;
        this.photo = attachment;
        this.agent = z11;
        this.organizationId = l12;
        this.tags = list;
        this.userFields = map;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        User user = (User) obj;
        if (this.agent != user.agent) {
            return false;
        }
        Long l11 = this.f62961id;
        if (l11 == null ? user.f62961id != null : !l11.equals(user.f62961id)) {
            return false;
        }
        Attachment attachment = this.photo;
        if (attachment == null ? user.photo != null : !attachment.equals(user.photo)) {
            return false;
        }
        Long l12 = this.organizationId;
        if (l12 == null ? user.organizationId != null : !l12.equals(user.organizationId)) {
            return false;
        }
        List<String> list = this.tags;
        if (list == null ? user.tags != null : !list.equals(user.tags)) {
            return false;
        }
        Map<String, String> map = this.userFields;
        Map<String, String> map2 = user.userFields;
        if (map != null) {
            return map.equals(map2);
        }
        if (map2 == null) {
            return true;
        }
        return false;
    }

    public Long getId() {
        return this.f62961id;
    }

    public String getName() {
        return this.name;
    }

    public Long getOrganizationId() {
        return this.organizationId;
    }

    public Attachment getPhoto() {
        return this.photo;
    }

    public List<String> getTags() {
        return a.c(this.tags);
    }

    public Map<String, String> getUserFields() {
        return a.d(this.userFields);
    }

    public int hashCode() {
        Long l11 = this.f62961id;
        int i11 = 0;
        int hashCode = (l11 != null ? l11.hashCode() : 0) * 31;
        Attachment attachment = this.photo;
        int hashCode2 = (((hashCode + (attachment != null ? attachment.hashCode() : 0)) * 31) + (this.agent ? 1 : 0)) * 31;
        Long l12 = this.organizationId;
        int hashCode3 = (hashCode2 + (l12 != null ? l12.hashCode() : 0)) * 31;
        List<String> list = this.tags;
        int hashCode4 = (hashCode3 + (list != null ? list.hashCode() : 0)) * 31;
        Map<String, String> map = this.userFields;
        if (map != null) {
            i11 = map.hashCode();
        }
        return hashCode4 + i11;
    }

    public boolean isAgent() {
        return this.agent;
    }

    public User() {
        this.f62961id = -1L;
        this.name = "";
        this.photo = null;
        this.agent = false;
        this.organizationId = -1L;
        this.tags = new ArrayList();
        this.userFields = new HashMap();
    }
}
