package zendesk.support;

import java.util.HashMap;
import java.util.Map;
import mz.f;
import zendesk.core.BlipsGroup;
import zendesk.core.BlipsProvider;
import zendesk.core.UserAction;

class ZendeskSupportBlipsProvider implements SupportBlipsProvider {
    private static final String BLIPS_FIELD_NAME_REQUEST_ID = "requestId";
    private static final String BLIPS_SUPPORT_ACTION_INIT = "init";
    private static final String BLIPS_SUPPORT_ACTION_REQUEST_CREATED = "requestCreated";
    private static final String BLIPS_SUPPORT_ACTION_REQUEST_LIST_VIEWED = "requestListViewed";
    private static final String BLIPS_SUPPORT_ACTION_REQUEST_UPDATED = "requestUpdated";
    private static final String BLIPS_SUPPORT_ACTION_REQUEST_VIEWED = "requestViewed";
    private static final String BLIPS_SUPPORT_CATEGORY = "SupportSDK";
    private static final String BLIPS_SUPPORT_CHANNEL = "support_sdk";
    private static final String BLIPS_SUPPORT_VERSION = "5.2.0";
    private BlipsProvider blipsProvider;

    public ZendeskSupportBlipsProvider(BlipsProvider blipsProvider2) {
        this.blipsProvider = blipsProvider2;
    }

    private void sendUserAction(BlipsGroup blipsGroup, String str, Map<String, Object> map) {
        this.blipsProvider.sendBlip(new UserAction(BLIPS_SUPPORT_VERSION, BLIPS_SUPPORT_CHANNEL, BLIPS_SUPPORT_CATEGORY, str, (String) null, map), blipsGroup);
    }

    public void requestCreated(String str) {
        if (!f.e(str)) {
            HashMap hashMap = new HashMap();
            hashMap.put(BLIPS_FIELD_NAME_REQUEST_ID, str);
            sendUserAction(BlipsGroup.BEHAVIOURAL, BLIPS_SUPPORT_ACTION_REQUEST_CREATED, hashMap);
        }
    }

    public void requestListViewed() {
        sendUserAction(BlipsGroup.BEHAVIOURAL, BLIPS_SUPPORT_ACTION_REQUEST_LIST_VIEWED, (Map<String, Object>) null);
    }

    public void requestUpdated(String str) {
        if (!f.e(str)) {
            HashMap hashMap = new HashMap();
            hashMap.put(BLIPS_FIELD_NAME_REQUEST_ID, str);
            sendUserAction(BlipsGroup.BEHAVIOURAL, BLIPS_SUPPORT_ACTION_REQUEST_UPDATED, hashMap);
        }
    }

    public void requestViewed(String str) {
        if (!f.e(str)) {
            HashMap hashMap = new HashMap();
            hashMap.put(BLIPS_FIELD_NAME_REQUEST_ID, str);
            sendUserAction(BlipsGroup.BEHAVIOURAL, BLIPS_SUPPORT_ACTION_REQUEST_VIEWED, hashMap);
        }
    }

    public void supportSdkInit() {
        sendUserAction(BlipsGroup.REQUIRED, "init", (Map<String, Object>) null);
    }
}
