package zendesk.support;

import android.content.Context;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonSyntaxException;
import com.zendesk.logger.Logger;
import h30.a;
import java.util.Map;
import zendesk.core.ActionDescription;
import zendesk.core.ActionHandler;
import zendesk.support.requestlist.RequestListActivity;
import zendesk.support.requestlist.RequestListConfiguration;

class RequestListActionHandler implements ActionHandler {
    private static final String LOG_TAG = "RequestListActionHandler";
    private boolean conversationsEnabled;

    public boolean canHandle(String str) {
        return str.equals("action_conversation_list") && this.conversationsEnabled;
    }

    public ActionDescription getActionDescription() {
        return null;
    }

    public int getPriority() {
        return 0;
    }

    public void handle(Map<String, Object> map, Context context) {
        RequestListActivity.builder().show(context, (RequestListConfiguration) a.f(map, RequestListConfiguration.class));
    }

    public void updateSettings(Map<String, JsonElement> map) {
        JsonElement jsonElement;
        if (map == null) {
            jsonElement = null;
        } else {
            try {
                jsonElement = map.get("support");
            } catch (JsonSyntaxException e11) {
                Logger.k(LOG_TAG, "Unable to read settings.", e11, new Object[0]);
                return;
            }
        }
        SupportSettings supportSettings = (SupportSettings) new GsonBuilder().create().fromJson(jsonElement, SupportSettings.class);
        if (supportSettings != null) {
            this.conversationsEnabled = supportSettings.getConversations().isEnabled();
        }
    }
}
