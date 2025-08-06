package com.sensorsdata.analytics.android.sdk.plugin.property;

import com.sensorsdata.analytics.android.sdk.internal.beans.EventType;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class SAPropertyPlugin implements ISAPropertyPlugin {
    private final Map<String, Object> mDynamicProperties = new HashMap();
    private final Set<String> mEventNameFilter = new HashSet();
    private final Set<EventType> mEventTypeFilter = new HashSet();
    private final Map<String, Object> mProperties = new HashMap();
    private final Set<String> mPropertyKeyFilter = new HashSet();

    public void appendDynamicProperties(Map<String, Object> map) {
    }

    public abstract void appendProperties(Map<String, Object> map);

    public void eventNameFilter(Set<String> set) {
    }

    public void eventTypeFilter(Set<EventType> set) {
    }

    public final Set<String> getEventNameFilter() {
        this.mEventNameFilter.clear();
        eventNameFilter(this.mEventNameFilter);
        return this.mEventNameFilter;
    }

    public final Set<EventType> getEventTypeFilter() {
        this.mEventTypeFilter.clear();
        eventTypeFilter(this.mEventTypeFilter);
        return this.mEventTypeFilter;
    }

    public final Set<String> getPropertyKeyFilter() {
        this.mPropertyKeyFilter.clear();
        propertyKeyFilter(this.mPropertyKeyFilter);
        return this.mPropertyKeyFilter;
    }

    public SAPropertyPluginPriority priority() {
        return SAPropertyPluginPriority.DEFAULT;
    }

    public final Map<String, Object> properties() {
        this.mDynamicProperties.clear();
        appendDynamicProperties(this.mDynamicProperties);
        if (this.mDynamicProperties.isEmpty()) {
            if (this.mProperties.isEmpty()) {
                appendProperties(this.mProperties);
            }
            return this.mProperties;
        }
        HashMap hashMap = new HashMap(this.mDynamicProperties.size() + this.mProperties.size());
        hashMap.putAll(this.mProperties);
        hashMap.putAll(this.mDynamicProperties);
        return hashMap;
    }

    public void propertyKeyFilter(Set<String> set) {
    }

    public final void start() {
        appendProperties(this.mProperties);
    }
}
