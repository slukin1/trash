package org.cybergarage.soap;

import org.cybergarage.http.HTTPResponse;
import org.cybergarage.util.Debug;
import org.cybergarage.xml.Node;

public class SOAPResponse extends HTTPResponse {

    /* renamed from: g  reason: collision with root package name */
    public Node f59833g;

    public SOAPResponse() {
        u0(SOAP.a());
        a0("text/xml; charset=\"utf-8\"");
    }

    public void o0() {
        Node s02;
        Debug.c(toString());
        if (!A() && (s02 = s0()) != null) {
            Debug.c(s02.toString());
        }
    }

    public Node q0() {
        Node r02 = r0();
        if (r02 == null) {
            return null;
        }
        return r02.o("Body");
    }

    public Node r0() {
        return s0();
    }

    public final Node s0() {
        return this.f59833g;
    }

    public void t0(Node node) {
        StringBuilder sb2 = new StringBuilder(String.valueOf("" + "<?xml version=\"1.0\" encoding=\"utf-8\"?>"));
        sb2.append("\n");
        T(String.valueOf(sb2.toString()) + node.toString());
    }

    public final void u0(Node node) {
        this.f59833g = node;
    }
}
