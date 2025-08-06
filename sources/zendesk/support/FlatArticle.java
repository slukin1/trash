package zendesk.support;

public class FlatArticle implements Comparable<FlatArticle> {
    private Article article;
    private Category category;
    private Section section;

    public FlatArticle(Category category2, Section section2, Article article2) {
        this.category = category2 == null ? new Category() : category2;
        this.section = section2 == null ? new Section() : section2;
        this.article = article2 == null ? new Article() : article2;
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

    public String toString() {
        return this.category.getName() + ", " + this.section.getName() + ", " + this.article.getTitle();
    }

    public int compareTo(FlatArticle flatArticle) {
        if (flatArticle == null) {
            return -1;
        }
        return toString().compareTo(flatArticle.toString());
    }
}
