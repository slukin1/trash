package org.cybergarage.upnp.ssdp;

public class SSDPNotifyRequest extends SSDPRequest {
    public SSDPNotifyRequest() {
        L0("NOTIFY");
        P0("*");
    }
}
