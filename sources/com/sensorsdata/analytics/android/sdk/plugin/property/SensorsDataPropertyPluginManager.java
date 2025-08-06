package com.sensorsdata.analytics.android.sdk.plugin.property;

import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.exceptions.InvalidDataException;
import com.sensorsdata.analytics.android.sdk.internal.beans.EventType;
import com.sensorsdata.analytics.android.sdk.util.SADataHelper;
import com.sensorsdata.analytics.android.sdk.util.SensorsDataUtils;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

public final class SensorsDataPropertyPluginManager {
    private static final String TAG = "SA.SAPropertyPluginManager";
    private final Map<String, SAPropertyPlugin> plugins;

    public static class SingleHolder {
        /* access modifiers changed from: private */
        public static final SensorsDataPropertyPluginManager INSTANCE = new SensorsDataPropertyPluginManager();

        private SingleHolder() {
        }
    }

    private List<SAPropertyPlugin> filter(String str, EventType eventType, JSONObject jSONObject) {
        LinkedList linkedList = new LinkedList();
        for (SAPropertyPlugin next : this.plugins.values()) {
            if (isMatchEventType(next.getEventTypeFilter(), eventType) && isMatchEventName(next.getEventNameFilter(), str) && isMatchPropertyKey(next.getPropertyKeyFilter(), jSONObject)) {
                linkedList.add(next);
            }
        }
        Collections.sort(linkedList, new Comparator<SAPropertyPlugin>() {
            public int compare(SAPropertyPlugin sAPropertyPlugin, SAPropertyPlugin sAPropertyPlugin2) {
                return sAPropertyPlugin.priority().getPriority() >= sAPropertyPlugin2.priority().getPriority() ? 0 : -1;
            }
        });
        return linkedList;
    }

    public static SensorsDataPropertyPluginManager getInstance() {
        return SingleHolder.INSTANCE;
    }

    private String getPluginType(SAPropertyPlugin sAPropertyPlugin) {
        return sAPropertyPlugin == null ? "" : sAPropertyPlugin.getClass().getName();
    }

    private boolean isMatchEventName(Set<String> set, String str) {
        if (set == null || set.size() == 0) {
            return true;
        }
        return set.contains(str);
    }

    private boolean isMatchEventType(Set<EventType> set, EventType eventType) {
        if (((set == null || set.isEmpty()) && eventType == EventType.TRACK) || set.contains(EventType.ALL)) {
            return true;
        }
        return set.contains(eventType);
    }

    private boolean isMatchPropertyKey(Set<String> set, JSONObject jSONObject) {
        if (set == null || set.size() == 0) {
            return true;
        }
        if (jSONObject == null) {
            return false;
        }
        for (String has : set) {
            if (jSONObject.has(has)) {
                return true;
            }
        }
        return false;
    }

    public final Map<String, Object> getPropertiesByPlugin(Class<?> cls) {
        SAPropertyPlugin sAPropertyPlugin;
        HashMap hashMap = new HashMap();
        if (cls == null) {
            return hashMap;
        }
        String name = cls.getName();
        if (this.plugins.containsKey(name) && (sAPropertyPlugin = this.plugins.get(name)) != null) {
            hashMap.putAll(sAPropertyPlugin.properties());
        }
        return hashMap;
    }

    public final JSONObject properties(String str, EventType eventType, JSONObject jSONObject) {
        JSONObject jSONObject2;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            jSONObject2 = properties(filter(str, eventType, jSONObject));
        } catch (Exception e11) {
            SALog.i(TAG, String.format("Event [%s] error is happened when matching property-plugins, e=%s", new Object[]{str, e11.toString()}));
            jSONObject2 = new JSONObject();
        }
        SALog.i(TAG, String.format("Event [%s] spend [%sms] on matching property-plugins", new Object[]{str, Long.valueOf(System.currentTimeMillis() - currentTimeMillis)}));
        return jSONObject2;
    }

    public final void registerPropertyPlugin(SAPropertyPlugin sAPropertyPlugin) {
        if (sAPropertyPlugin != null) {
            try {
                String pluginType = getPluginType(sAPropertyPlugin);
                if (!this.plugins.containsKey(pluginType)) {
                    this.plugins.put(pluginType, sAPropertyPlugin);
                    sAPropertyPlugin.start();
                    return;
                }
                SALog.i(TAG, String.format("plugin [ %s ] has exist!", new Object[]{pluginType}));
            } catch (Exception e11) {
                SALog.i(TAG, "register property plugin exception! " + e11.toString());
            }
        }
    }

    public final void unregisterPropertyPlugin(SAPropertyPlugin sAPropertyPlugin) {
        if (sAPropertyPlugin != null) {
            this.plugins.remove(getPluginType(sAPropertyPlugin));
        }
    }

    private SensorsDataPropertyPluginManager() {
        this.plugins = new LinkedHashMap();
    }

    private JSONObject properties(List<SAPropertyPlugin> list) {
        JSONObject jSONObject = new JSONObject();
        if (list == null) {
            return jSONObject;
        }
        for (SAPropertyPlugin properties : list) {
            Map<String, Object> properties2 = properties.properties();
            if (properties2 != null && !properties2.isEmpty()) {
                JSONObject jSONObject2 = new JSONObject(properties2);
                try {
                    SADataHelper.assertPropertyTypes(jSONObject2);
                    SensorsDataUtils.mergeJSONObject(jSONObject2, jSONObject);
                } catch (InvalidDataException e11) {
                    SALog.printStackTrace(e11);
                }
            }
        }
        return jSONObject;
    }
}
