package zendesk.support;

import java.util.List;
import zendesk.core.User;

interface ArticlesResponse {
    List<Article> getArticles();

    List<Category> getCategories();

    List<Section> getSections();

    List<User> getUsers();
}
