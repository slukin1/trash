package com.hbg.lib.data.main.bean;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class TimeStampMap<T> implements Serializable {
    private Map<String, T> map = new HashMap();

    /* renamed from: ts  reason: collision with root package name */
    private String f68853ts;

    public boolean canEqual(Object obj) {
        return obj instanceof TimeStampMap;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TimeStampMap)) {
            return false;
        }
        TimeStampMap timeStampMap = (TimeStampMap) obj;
        if (!timeStampMap.canEqual(this)) {
            return false;
        }
        String ts2 = getTs();
        String ts3 = timeStampMap.getTs();
        if (ts2 != null ? !ts2.equals(ts3) : ts3 != null) {
            return false;
        }
        Map map2 = getMap();
        Map map3 = timeStampMap.getMap();
        return map2 != null ? map2.equals(map3) : map3 == null;
    }

    public Map<String, T> getMap() {
        return this.map;
    }

    public String getTs() {
        return this.f68853ts;
    }

    public int hashCode() {
        String ts2 = getTs();
        int i11 = 43;
        int hashCode = ts2 == null ? 43 : ts2.hashCode();
        Map map2 = getMap();
        int i12 = (hashCode + 59) * 59;
        if (map2 != null) {
            i11 = map2.hashCode();
        }
        return i12 + i11;
    }

    public void setMap(Map<String, T> map2) {
        this.map = map2;
    }

    public void setTs(String str) {
        this.f68853ts = str;
    }

    public String toString() {
        return "TimeStampMap(ts=" + getTs() + ", map=" + getMap() + ")";
    }
}
