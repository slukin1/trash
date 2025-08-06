package com.hbg.lib.network.content.core.bean;

import java.io.Serializable;
import java.util.Map;

public class WorkOrderConfig implements Serializable {
    private static final long serialVersionUID = -3908945991460638818L;
    private Map<String, Object> link;
    private Map<String, Object> state;

    public boolean canEqual(Object obj) {
        return obj instanceof WorkOrderConfig;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof WorkOrderConfig)) {
            return false;
        }
        WorkOrderConfig workOrderConfig = (WorkOrderConfig) obj;
        if (!workOrderConfig.canEqual(this)) {
            return false;
        }
        Map<String, Object> link2 = getLink();
        Map<String, Object> link3 = workOrderConfig.getLink();
        if (link2 != null ? !link2.equals(link3) : link3 != null) {
            return false;
        }
        Map<String, Object> state2 = getState();
        Map<String, Object> state3 = workOrderConfig.getState();
        return state2 != null ? state2.equals(state3) : state3 == null;
    }

    public Map<String, Object> getLink() {
        return this.link;
    }

    public Map<String, Object> getState() {
        return this.state;
    }

    public int hashCode() {
        Map<String, Object> link2 = getLink();
        int i11 = 43;
        int hashCode = link2 == null ? 43 : link2.hashCode();
        Map<String, Object> state2 = getState();
        int i12 = (hashCode + 59) * 59;
        if (state2 != null) {
            i11 = state2.hashCode();
        }
        return i12 + i11;
    }

    public void setLink(Map<String, Object> map) {
        this.link = map;
    }

    public void setState(Map<String, Object> map) {
        this.state = map;
    }

    public String toString() {
        return "WorkOrderConfig(link=" + getLink() + ", state=" + getState() + ")";
    }
}
