package zendesk.support.guide;

import com.zendesk.service.ZendeskCallback;
import java.util.List;
import zendesk.support.HelpCenterSettings;
import zendesk.support.SearchArticle;

public interface HelpCenterMvp$Model {
    void getSettings(ZendeskCallback<HelpCenterSettings> zendeskCallback);

    void search(List<Long> list, List<Long> list2, String str, String[] strArr, ZendeskCallback<List<SearchArticle>> zendeskCallback);
}
