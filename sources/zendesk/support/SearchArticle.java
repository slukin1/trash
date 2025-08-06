package zendesk.support;

import java.io.Serializable;

public class SearchArticle implements Serializable {
    private final Article article;
    private final Category category;
    private final Section section;

    public SearchArticle(Article article2, Section section2, Category category2) {
        this.article = article2;
        this.section = section2;
        this.category = category2;
    }

    public Article getArticle() {
        return this.article;
    }

    public Category getCategory() {
        return this.category;
    }

    public Section getSection() {
        return this.section;
    }
}
