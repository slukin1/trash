package zendesk.support.guide;

import com.zendesk.service.ZendeskCallback;
import java.util.List;
import zendesk.support.ArticleItem;
import zendesk.support.HelpItem;
import zendesk.support.SectionItem;

public interface HelpMvp$Model {
    void getArticles(List<Long> list, List<Long> list2, String[] strArr, ZendeskCallback<List<HelpItem>> zendeskCallback);

    void getArticlesForSection(SectionItem sectionItem, String[] strArr, ZendeskCallback<List<ArticleItem>> zendeskCallback);
}
