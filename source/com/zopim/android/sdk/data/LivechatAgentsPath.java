package com.zopim.android.sdk.data;

import com.google.gson.reflect.TypeToken;
import com.zendesk.logger.Logger;
import com.zopim.android.sdk.model.Agent;
import java.util.LinkedHashMap;
import java.util.Map;

public class LivechatAgentsPath extends Path<LinkedHashMap<String, Agent>> {
    private static final LivechatAgentsPath INSTANCE = new LivechatAgentsPath();
    private static final String LOG_TAG = "LivechatAgentsPath";

    private LivechatAgentsPath() {
        this.data = new LinkedHashMap();
    }

    public static LivechatAgentsPath getInstance() {
        return INSTANCE;
    }

    private void updateInternal(LinkedHashMap<String, Agent> linkedHashMap) {
        if (linkedHashMap == null) {
            Logger.g(LOG_TAG, "Passed parameter must not be null. Aborting update.", new Object[0]);
            return;
        }
        for (Map.Entry next : linkedHashMap.entrySet()) {
            String str = (String) next.getKey();
            Agent agent = (Agent) next.getValue();
            if (((LinkedHashMap) this.data).containsKey(str)) {
                if (((LinkedHashMap) this.data).get(str) == null) {
                    ((LinkedHashMap) this.data).remove(str);
                } else if (agent != null) {
                    ((LinkedHashMap) this.data).put(str, (Agent) ChatGson.performUpdate(((LinkedHashMap) this.data).get(str), agent, Agent.class));
                }
            } else if (agent != null) {
                ((LinkedHashMap) this.data).put(str, agent);
            }
        }
        broadcast(getData());
    }

    public void clear() {
        T t11 = this.data;
        if (t11 != null) {
            ((LinkedHashMap) t11).clear();
        }
    }

    public void update(String str) {
        if (isClearRequired(str)) {
            clear();
        } else if (str != null && !str.isEmpty()) {
            updateInternal((LinkedHashMap) ChatGson.get().fromJson(str, new TypeToken<LinkedHashMap<String, Agent>>() {
            }.getType()));
        }
    }

    public LinkedHashMap<String, Agent> getData() {
        if (this.data != null) {
            return new LinkedHashMap<>((Map) this.data);
        }
        return new LinkedHashMap<>();
    }
}
