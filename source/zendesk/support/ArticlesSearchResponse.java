package zendesk.support;

import java.util.List;
import mz.a;
import zendesk.core.User;

class ArticlesSearchResponse implements ArticlesResponse {
    private List<Category> categories;
    private String nextPage;
    private String previousPage;
    private List<Article> results;
    private List<Section> sections;
    private List<User> users;

    public List<Article> getArticles() {
        return a.c(this.results);
    }

    public List<Category> getCategories() {
        return a.c(this.categories);
    }

    public String getNextPage() {
        return this.nextPage;
    }

    public String getPreviousPage() {
        return this.previousPage;
    }

    public List<Section> getSections() {
        return a.c(this.sections);
    }

    public List<User> getUsers() {
        return a.c(this.users);
    }
}
