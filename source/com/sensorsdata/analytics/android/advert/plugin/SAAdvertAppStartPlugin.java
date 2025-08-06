package com.sensorsdata.analytics.android.advert.plugin;

import com.sensorsdata.analytics.android.advert.deeplink.DeepLinkManager;
import com.sensorsdata.analytics.android.sdk.plugin.property.SAPropertyPlugin;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

public class SAAdvertAppStartPlugin extends SAPropertyPlugin {
    public void appendDynamicProperties(Map<String, Object> map) {
        JSONObject jSONObject = new JSONObject();
        DeepLinkManager.mergeCacheProperties(jSONObject);
        if (jSONObject.length() > 0) {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                map.put(next, jSONObject.opt(next));
            }
        }
    }

    public void appendProperties(Map<String, Object> map) {
    }

    public void eventNameFilter(Set<String> set) {
        set.add("$AppStart");
    }
}
