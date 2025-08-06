package zendesk.support;

import android.content.Context;
import android.content.Intent;
import androidx.core.app.TaskStackBuilder;
import com.google.gson.JsonElement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import zendesk.configurations.Configuration;
import zendesk.core.ActionDescription;
import zendesk.core.ActionHandler;
import zendesk.support.requestlist.RequestListActivity;

class DeepLinkToRequestActionHandler implements ActionHandler {
    private static final String BACK_STACK_ACTIVITIES = "back_stack_activities";
    private static final String REQUEST_INTENT = "request_ui_config";
    public static final String REQUEST_VIEW_CONVERSATION = "request_view_conversation";

    public static Map<String, Object> data(Intent intent, List<Intent> list) {
        HashMap hashMap = new HashMap();
        hashMap.put(REQUEST_INTENT, intent);
        hashMap.put(BACK_STACK_ACTIVITIES, list);
        return hashMap;
    }

    public boolean canHandle(String str) {
        return str.equals(REQUEST_VIEW_CONVERSATION);
    }

    public ActionDescription getActionDescription() {
        return null;
    }

    public int getPriority() {
        return 0;
    }

    public void handle(Map<String, Object> map, Context context) {
        TaskStackBuilder e11 = TaskStackBuilder.e(context);
        if (map != null) {
            for (Intent b11 : (List) map.get(BACK_STACK_ACTIVITIES)) {
                e11.b(b11);
            }
        }
        e11.b(RequestListActivity.builder().intent(context, new Configuration[0]));
        if (map != null) {
            e11.b((Intent) map.get(REQUEST_INTENT));
        }
        e11.g();
    }

    public void updateSettings(Map<String, JsonElement> map) {
    }
}
