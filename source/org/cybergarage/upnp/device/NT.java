package org.cybergarage.upnp.device;

public class NT {
    public static final boolean a(String str) {
        if (str == null) {
            return false;
        }
        return str.startsWith("upnp:rootdevice");
    }
}
