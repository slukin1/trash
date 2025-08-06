package org.cybergarage.upnp.device;

public class MAN {
    public static final boolean a(String str) {
        if (str == null) {
            return false;
        }
        if (str.equals("ssdp:discover")) {
            return true;
        }
        return str.equals("\"ssdp:discover\"");
    }
}
