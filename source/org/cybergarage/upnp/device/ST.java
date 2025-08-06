package org.cybergarage.upnp.device;

public class ST {
    public static final boolean a(String str) {
        if (str == null) {
            return false;
        }
        if (str.equals("ssdp:all")) {
            return true;
        }
        return str.equals("\"ssdp:all\"");
    }

    public static final boolean b(String str) {
        if (str == null) {
            return false;
        }
        if (str.equals("upnp:rootdevice")) {
            return true;
        }
        return str.equals("\"upnp:rootdevice\"");
    }

    public static final boolean c(String str) {
        if (str == null) {
            return false;
        }
        if (str.startsWith("urn:schemas-upnp-org:device:")) {
            return true;
        }
        return str.startsWith("\"urn:schemas-upnp-org:device:");
    }

    public static final boolean d(String str) {
        if (str == null) {
            return false;
        }
        if (str.startsWith("urn:schemas-upnp-org:service:")) {
            return true;
        }
        return str.startsWith("\"urn:schemas-upnp-org:service:");
    }

    public static final boolean e(String str) {
        if (str == null) {
            return false;
        }
        if (str.startsWith(ZendeskIdentityStorage.UUID_KEY)) {
            return true;
        }
        return str.startsWith("\"uuid");
    }
}
