package org.cybergarage.upnp.event;

import org.cybergarage.http.HTTPResponse;
import org.cybergarage.upnp.UPnP;

public class SubscriptionResponse extends HTTPResponse {
    public SubscriptionResponse() {
        i0(UPnP.b());
    }

    public void q0(int i11) {
        p0(i11);
        Y(0);
    }

    public void r0(String str) {
        e0("SID", Subscription.d(str));
    }

    public void s0(long j11) {
        e0("TIMEOUT", Subscription.e(j11));
    }

    public SubscriptionResponse(HTTPResponse hTTPResponse) {
        super(hTTPResponse);
    }
}
