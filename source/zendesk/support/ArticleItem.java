package zendesk.support;

import com.google.gson.annotations.SerializedName;

public class ArticleItem implements HelpItem {

    /* renamed from: id  reason: collision with root package name */
    private Long f62936id;
    private String name;
    @SerializedName("section_id")
    private Long sectionId;

    public ArticleItem(Long l11, Long l12, String str) {
        this.f62936id = l11;
        this.sectionId = l12;
        this.name = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ArticleItem articleItem = (ArticleItem) obj;
        Long l11 = this.f62936id;
        if (l11 == null ? articleItem.f62936id != null : !l11.equals(articleItem.f62936id)) {
            return false;
        }
        Long l12 = this.sectionId;
        Long l13 = articleItem.sectionId;
        if (l12 != null) {
            return l12.equals(l13);
        }
        if (l13 == null) {
            return true;
        }
        return false;
    }

    public Long getId() {
        return this.f62936id;
    }

    public String getName() {
        String str = this.name;
        return str == null ? "" : str;
    }

    public Long getParentId() {
        return this.sectionId;
    }

    public int getViewType() {
        return 3;
    }

    public int hashCode() {
        Long l11 = this.f62936id;
        int i11 = 0;
        int hashCode = (l11 != null ? l11.hashCode() : 0) * 31;
        Long l12 = this.sectionId;
        if (l12 != null) {
            i11 = l12.hashCode();
        }
        return hashCode + i11;
    }
}
