package com.jumio.analytics;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public final class MetaInfo extends TreeMap<String, Object> {
    public final /* bridge */ boolean containsKey(Object obj) {
        if (!(obj instanceof String)) {
            return false;
        }
        return containsKey((String) obj);
    }

    public final /* bridge */ Set<Map.Entry<String, Object>> entrySet() {
        return getEntries();
    }

    public final /* bridge */ Object get(Object obj) {
        if (!(obj instanceof String)) {
            return null;
        }
        return get((String) obj);
    }

    public /* bridge */ Set<Map.Entry<String, Object>> getEntries() {
        return super.entrySet();
    }

    public /* bridge */ Set<String> getKeys() {
        return super.keySet();
    }

    public final /* bridge */ Object getOrDefault(Object obj, Object obj2) {
        return !(obj instanceof String) ? obj2 : getOrDefault((String) obj, obj2);
    }

    public /* bridge */ int getSize() {
        return super.size();
    }

    public /* bridge */ Collection<Object> getValues() {
        return super.values();
    }

    public final /* bridge */ Set<String> keySet() {
        return getKeys();
    }

    public final /* bridge */ Object remove(Object obj) {
        if (!(obj instanceof String)) {
            return null;
        }
        return remove((String) obj);
    }

    public final /* bridge */ int size() {
        return getSize();
    }

    public final /* bridge */ Collection<Object> values() {
        return getValues();
    }

    public /* bridge */ boolean containsKey(String str) {
        return super.containsKey(str);
    }

    public /* bridge */ Object get(String str) {
        return super.get(str);
    }

    public /* bridge */ Object getOrDefault(String str, Object obj) {
        return super.getOrDefault(str, obj);
    }

    public /* bridge */ Object remove(String str) {
        return super.remove(str);
    }

    public final /* bridge */ boolean remove(Object obj, Object obj2) {
        if (!(obj == null ? true : obj instanceof String)) {
            return false;
        }
        return remove((String) obj, obj2);
    }

    public /* bridge */ boolean remove(String str, Object obj) {
        return super.remove(str, obj);
    }
}
