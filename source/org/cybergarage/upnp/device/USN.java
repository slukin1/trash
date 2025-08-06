package org.cybergarage.upnp.device;

public class USN {
    public static final String a(String str) {
        if (str == null) {
            return "";
        }
        int indexOf = str.indexOf("::");
        if (indexOf < 0) {
            return str.trim();
        }
        return new String(str.getBytes(), 0, indexOf).trim();
    }

    public static final boolean b(String str) {
        if (str == null) {
            return false;
        }
        return str.endsWith("upnp:rootdevice");
    }
}
