package org.cybergarage.upnp.ssdp;

import com.google.common.net.HttpHeaders;
import org.cybergarage.upnp.UPnP;

public class SSDPSearchResponse extends SSDPResponse {
    public SSDPSearchResponse() {
        p0(200);
        Q(1800);
        e0(HttpHeaders.SERVER, UPnP.b());
        e0("EXT", "");
    }
}
