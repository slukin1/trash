package com.huobi.otc.event;

import java.io.Serializable;
import java.util.HashMap;

public class OnFilterEvent implements Serializable {
    private HashMap<String, Object> jsonToMap;

    public boolean canEqual(Object obj) {
        return obj instanceof OnFilterEvent;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OnFilterEvent)) {
            return false;
        }
        OnFilterEvent onFilterEvent = (OnFilterEvent) obj;
        if (!onFilterEvent.canEqual(this)) {
            return false;
        }
        HashMap<String, Object> jsonToMap2 = getJsonToMap();
        HashMap<String, Object> jsonToMap3 = onFilterEvent.getJsonToMap();
        return jsonToMap2 != null ? jsonToMap2.equals(jsonToMap3) : jsonToMap3 == null;
    }

    public HashMap<String, Object> getJsonToMap() {
        return this.jsonToMap;
    }

    public int hashCode() {
        HashMap<String, Object> jsonToMap2 = getJsonToMap();
        return 59 + (jsonToMap2 == null ? 43 : jsonToMap2.hashCode());
    }

    public void setJsonToMap(HashMap<String, Object> hashMap) {
        this.jsonToMap = hashMap;
    }

    public String toString() {
        return "OnFilterEvent(jsonToMap=" + getJsonToMap() + ")";
    }
}
