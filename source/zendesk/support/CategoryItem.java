package zendesk.support;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import mz.a;

public class CategoryItem implements HelpItem {
    private boolean expanded = true;
    @SerializedName("id")

    /* renamed from: id  reason: collision with root package name */
    private Long f62940id;
    @SerializedName("name")
    private String name;
    @SerializedName("section_count")
    private int sectionCount;
    private List<SectionItem> sections;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Long l11 = this.f62940id;
        Long l12 = ((CategoryItem) obj).f62940id;
        if (l11 != null) {
            return l11.equals(l12);
        }
        if (l12 == null) {
            return true;
        }
        return false;
    }

    public Long getId() {
        return this.f62940id;
    }

    public String getName() {
        String str = this.name;
        return str == null ? "" : str;
    }

    public Long getParentId() {
        return null;
    }

    public List<SectionItem> getSections() {
        return a.c(this.sections);
    }

    public int getViewType() {
        return 1;
    }

    public int hashCode() {
        Long l11 = this.f62940id;
        if (l11 != null) {
            return l11.hashCode();
        }
        return 0;
    }

    public boolean isExpanded() {
        return this.expanded;
    }

    public boolean setExpanded(boolean z11) {
        this.expanded = z11;
        return z11;
    }

    public void setSections(List<SectionItem> list) {
        this.sections = a.c(list);
    }
}
