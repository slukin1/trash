package org.cybergarage.soap;

import java.io.ByteArrayInputStream;
import org.cybergarage.http.HTTPRequest;
import org.cybergarage.util.Debug;
import org.cybergarage.xml.Node;
import org.cybergarage.xml.ParserException;

public class SOAPRequest extends HTTPRequest {

    /* renamed from: l  reason: collision with root package name */
    public Node f59832l;

    public SOAPRequest() {
        a0("text/xml; charset=\"utf-8\"");
        L0("POST");
    }

    public void F0() {
        Node T0;
        Debug.c(toString());
        if (!A() && (T0 = T0()) != null) {
            Debug.c(T0.toString());
        }
    }

    public Node R0() {
        Node S0 = S0();
        if (S0 != null && S0.u()) {
            return S0.m(0);
        }
        return null;
    }

    public Node S0() {
        return T0();
    }

    public final synchronized Node T0() {
        Node node = this.f59832l;
        if (node != null) {
            return node;
        }
        try {
            this.f59832l = SOAP.b().b(new ByteArrayInputStream(f()));
        } catch (ParserException e11) {
            Debug.d(e11);
        }
        return this.f59832l;
    }

    public String U0() {
        return v("SOAPACTION");
    }

    public boolean V0(String str) {
        String s11 = s("SOAPACTION");
        if (s11 == null) {
            return false;
        }
        if (s11.equals(str)) {
            return true;
        }
        String U0 = U0();
        if (U0 == null) {
            return false;
        }
        return U0.equals(str);
    }

    public void W0(Node node) {
        StringBuilder sb2 = new StringBuilder(String.valueOf("" + "<?xml version=\"1.0\" encoding=\"utf-8\"?>"));
        sb2.append("\n");
        T(String.valueOf(sb2.toString()) + node.toString());
    }
}
