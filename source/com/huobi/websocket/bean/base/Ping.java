package com.huobi.websocket.bean.base;

import java.io.Serializable;

public class Ping implements Serializable {
    private String ping = ("" + System.currentTimeMillis());

    public boolean canEqual(Object obj) {
        return obj instanceof Ping;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Ping)) {
            return false;
        }
        Ping ping2 = (Ping) obj;
        if (!ping2.canEqual(this)) {
            return false;
        }
        String ping3 = getPing();
        String ping4 = ping2.getPing();
        return ping3 != null ? ping3.equals(ping4) : ping4 == null;
    }

    public String getPing() {
        return this.ping;
    }

    public int hashCode() {
        String ping2 = getPing();
        return 59 + (ping2 == null ? 43 : ping2.hashCode());
    }

    public void setPing(String str) {
        this.ping = str;
    }

    public String toString() {
        return "Ping(ping=" + getPing() + ")";
    }
}
