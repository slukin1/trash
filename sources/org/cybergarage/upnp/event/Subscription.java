package org.cybergarage.upnp.event;

import org.cybergarage.upnp.UPnP;

public class Subscription {
    public static final String a() {
        return UPnP.a();
    }

    public static final String b(String str) {
        if (str == null) {
            return "";
        }
        if (!str.startsWith("uuid:")) {
            return str;
        }
        return str.substring(5, str.length());
    }

    public static final long c(String str) {
        try {
            return Long.parseLong(str.substring(str.indexOf(45) + 1, str.length()));
        } catch (Exception unused) {
            return -1;
        }
    }

    public static final String d(String str) {
        return "uuid:" + str;
    }

    public static final String e(long j11) {
        if (j11 == -1) {
            return "infinite";
        }
        return "Second-" + Long.toString(j11);
    }
}
