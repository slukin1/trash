package org.cybergarage.upnp.event;

import org.cybergarage.http.HTTP;
import org.cybergarage.http.HTTPRequest;
import org.cybergarage.upnp.Device;
import org.cybergarage.upnp.Service;

public class SubscriptionRequest extends HTTPRequest {
    public SubscriptionRequest() {
        Y(0);
    }

    public String R0() {
        return w("CALLBACK", "<", ">");
    }

    public String S0() {
        String b11 = Subscription.b(s("SID"));
        return b11 == null ? "" : b11;
    }

    public long T0() {
        return Subscription.c(s("TIMEOUT"));
    }

    public boolean U0() {
        String R0 = R0();
        return R0 != null && R0.length() > 0;
    }

    public boolean V0() {
        String S0 = S0();
        return S0 != null && S0.length() > 0;
    }

    public SubscriptionResponse W0() {
        return new SubscriptionResponse(C0(p0(), q0()));
    }

    public void X0(SubscriptionResponse subscriptionResponse) {
        super.E0(subscriptionResponse);
    }

    public void Y0(String str) {
        e0("SID", Subscription.d(str));
    }

    public final void Z0(Service service) {
        Device k11;
        Device k12;
        String h11 = service.h();
        Q0(h11, true);
        Device f11 = service.f();
        String M = f11 != null ? f11.M() : "";
        if ((M == null || M.length() <= 0) && (k12 = service.k()) != null) {
            M = k12.M();
        }
        if ((M == null || M.length() <= 0) && (k11 = service.k()) != null) {
            M = k11.y();
        }
        if ((M != null && M.length() > 0) || !HTTP.f(h11)) {
            h11 = M;
        }
        String c11 = HTTP.c(h11);
        int d11 = HTTP.d(h11);
        g0(c11, d11);
        M0(c11);
        N0(d11);
    }

    public void a1(Service service) {
        L0("UNSUBSCRIBE");
        Z0(service);
        Y0(service.r());
    }

    public SubscriptionRequest(HTTPRequest hTTPRequest) {
        this();
        K0(hTTPRequest);
    }
}
