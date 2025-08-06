package zendesk.support;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

public class SectionItem implements HelpItem {
    private List<ArticleItem> articles;
    @SerializedName("category_id")
    private Long categoryId;
    @SerializedName("name")
    private String name;
    @SerializedName("id")
    private Long sectionId;
    @SerializedName("article_count")
    private int totalArticlesCount;

    public void addArticle(ArticleItem articleItem) {
        if (this.articles == null) {
            this.articles = new ArrayList();
        }
        this.articles.add(articleItem);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        SectionItem sectionItem = (SectionItem) obj;
        Long l11 = this.sectionId;
        if (l11 == null ? sectionItem.sectionId != null : !l11.equals(sectionItem.sectionId)) {
            return false;
        }
        Long l12 = this.categoryId;
        Long l13 = sectionItem.categoryId;
        if (l12 != null) {
            return l12.equals(l13);
        }
        if (l13 == null) {
            return true;
        }
        return false;
    }

    public List<HelpItem> getChildren() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.articles);
        if (this.articles.size() < this.totalArticlesCount) {
            arrayList.add(new SeeAllArticlesItem(this));
        }
        return arrayList;
    }

    public Long getId() {
        return this.sectionId;
    }

    public String getName() {
        String str = this.name;
        return str == null ? "" : str;
    }

    public Long getParentId() {
        return this.categoryId;
    }

    public int getTotalArticlesCount() {
        return this.totalArticlesCount;
    }

    public int getViewType() {
        return 2;
    }

    public int hashCode() {
        Long l11 = this.sectionId;
        int i11 = 0;
        int hashCode = (l11 != null ? l11.hashCode() : 0) * 31;
        Long l12 = this.categoryId;
        if (l12 != null) {
            i11 = l12.hashCode();
        }
        return hashCode + i11;
    }
}
