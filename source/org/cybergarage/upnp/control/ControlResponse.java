package org.cybergarage.upnp.control;

import org.cybergarage.soap.SOAPResponse;
import org.cybergarage.upnp.UPnP;
import org.cybergarage.upnp.UPnPStatus;
import org.cybergarage.xml.Node;

public class ControlResponse extends SOAPResponse {

    /* renamed from: h  reason: collision with root package name */
    public UPnPStatus f59874h = new UPnPStatus();

    public ControlResponse() {
        i0(UPnP.b());
    }

    public final Node v0(int i11, String str) {
        Node node = new Node("s:Fault");
        Node node2 = new Node("faultcode");
        node2.G("s:Client");
        node.c(node2);
        Node node3 = new Node("faultstring");
        node3.G("UPnPError");
        node.c(node3);
        Node node4 = new Node("detail");
        node.c(node4);
        Node node5 = new Node("UPnPError");
        node5.y("xmlns", "urn:schemas-upnp-org:control-1-0");
        node4.c(node5);
        Node node6 = new Node("errorCode");
        node6.F(i11);
        node5.c(node6);
        Node node7 = new Node("errorDescription");
        node7.G(str);
        node5.c(node7);
        return node;
    }

    public void w0(int i11) {
        x0(i11, UPnPStatus.a(i11));
    }

    public void x0(int i11, String str) {
        p0(500);
        q0().c(v0(i11, str));
        t0(r0());
    }
}
