package zendesk.support;

import java.util.List;
import mz.a;
import zendesk.core.User;

class ArticleResponse {
    private Article article;
    private List<User> users;

    public Article getArticle() {
        return this.article;
    }

    public List<User> getUsers() {
        return a.c(this.users);
    }
}
