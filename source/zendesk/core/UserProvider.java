package zendesk.core;

import com.zendesk.service.ZendeskCallback;
import java.util.List;
import java.util.Map;

public interface UserProvider {
    void addTags(List<String> list, ZendeskCallback<List<String>> zendeskCallback);

    void deleteTags(List<String> list, ZendeskCallback<List<String>> zendeskCallback);

    void getUser(ZendeskCallback<User> zendeskCallback);

    void getUserFields(ZendeskCallback<List<UserField>> zendeskCallback);

    void setUserFields(Map<String, String> map, ZendeskCallback<Map<String, String>> zendeskCallback);
}
