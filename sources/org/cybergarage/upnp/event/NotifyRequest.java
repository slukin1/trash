package org.cybergarage.upnp.event;

import org.cybergarage.http.HTTPRequest;
import org.cybergarage.soap.SOAPRequest;
import org.cybergarage.xml.Node;

public class NotifyRequest extends SOAPRequest {
    public NotifyRequest() {
    }

    public final Node X0(String str, String str2) {
        Node node = new Node("propertyset");
        node.B("e", "urn:schemas-upnp-org:event-1-0");
        Node node2 = new Node("property");
        node.c(node2);
        Node node3 = new Node(str);
        node3.G(str2);
        node2.c(node3);
        return node;
    }

    public final Property Y0(Node node) {
        Property property = new Property();
        if (node == null) {
            return property;
        }
        String l11 = node.l();
        int lastIndexOf = l11.lastIndexOf(58);
        if (lastIndexOf != -1) {
            l11 = l11.substring(lastIndexOf + 1);
        }
        property.c(l11);
        property.d(node.t());
        return property;
    }

    public PropertyList Z0() {
        PropertyList propertyList = new PropertyList();
        Node S0 = S0();
        for (int i11 = 0; i11 < S0.k(); i11++) {
            Node m11 = S0.m(i11);
            if (m11 != null) {
                propertyList.add(Y0(m11.m(0)));
            }
        }
        return propertyList;
    }

    public long a1() {
        return t("SEQ");
    }

    public String b1() {
        return Subscription.b(s("SID"));
    }

    public void c1(String str) {
        e0("NT", str);
    }

    public void d1(String str) {
        e0("NTS", str);
    }

    public boolean e1(Subscriber subscriber, String str, String str2) {
        subscriber.d();
        String f11 = subscriber.f();
        long e11 = subscriber.e();
        String a11 = subscriber.a();
        String b11 = subscriber.b();
        int c11 = subscriber.c();
        L0("NOTIFY");
        P0(b11);
        g0(a11, c11);
        c1("upnp:event");
        d1("upnp:propchange");
        g1(f11);
        f1(e11);
        a0("text/xml; charset=\"utf-8\"");
        W0(X0(str, str2));
        return true;
    }

    public void f1(long j11) {
        e0("SEQ", Long.toString(j11));
    }

    public void g1(String str) {
        e0("SID", Subscription.d(str));
    }

    public NotifyRequest(HTTPRequest hTTPRequest) {
        K0(hTTPRequest);
    }
}
