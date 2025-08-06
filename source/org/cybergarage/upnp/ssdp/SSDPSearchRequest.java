package org.cybergarage.upnp.ssdp;

import org.cybergarage.net.HostInterface;

public class SSDPSearchRequest extends SSDPRequest {
    public SSDPSearchRequest(String str, int i11) {
        L0("M-SEARCH");
        P0("*");
        e0("ST", str);
        e0("MX", Integer.toString(i11));
        e0("MAN", "\"ssdp:discover\"");
    }

    public void R0(String str) {
        g0(HostInterface.g(str) ? SSDP.a() : "239.255.255.250", 1900);
    }

    public SSDPSearchRequest(String str) {
        this(str, 3);
    }

    public SSDPSearchRequest() {
        this("upnp:rootdevice");
    }
}
