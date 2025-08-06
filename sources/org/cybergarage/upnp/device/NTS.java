package org.cybergarage.upnp.device;

public class NTS {
    public static final boolean a(String str) {
        if (str == null) {
            return false;
        }
        return str.startsWith("ssdp:alive");
    }

    public static final boolean b(String str) {
        if (str == null) {
            return false;
        }
        return str.startsWith("ssdp:byebye");
    }
}
