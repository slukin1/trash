package com.tencent.qcloud.tuikit.timcommon.bean;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class MessageReactBean implements Serializable {
    public static final int VERSION = 1;
    private transient Map<String, ReactUserBean> reactUserBeanMap;
    private Map<String, Set<String>> reacts;
    private int version = 1;

    public int getReactSize() {
        Map<String, Set<String>> map = this.reacts;
        if (map != null) {
            return map.size();
        }
        return 0;
    }

    public Map<String, ReactUserBean> getReactUserBeanMap() {
        return this.reactUserBeanMap;
    }

    public Map<String, Set<String>> getReacts() {
        return this.reacts;
    }

    public int getVersion() {
        return this.version;
    }

    public void operateUser(String str, String str2) {
        if (this.reacts == null) {
            this.reacts = new LinkedHashMap();
        }
        Set set = this.reacts.get(str);
        if (set == null) {
            set = new LinkedHashSet();
            this.reacts.put(str, set);
        }
        if (set.contains(str2)) {
            set.remove(str2);
        } else {
            set.add(str2);
        }
        if (set.isEmpty()) {
            this.reacts.remove(str);
        }
    }

    public void setReactUserBeanMap(Map<String, ReactUserBean> map) {
        this.reactUserBeanMap = map;
    }

    public void setReacts(Map<String, Set<String>> map) {
        this.reacts = map;
    }

    public void setVersion(int i11) {
        this.version = i11;
    }
}
