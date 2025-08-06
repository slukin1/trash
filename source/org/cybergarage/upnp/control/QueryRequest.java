package org.cybergarage.upnp.control;

import org.cybergarage.http.HTTPRequest;
import org.cybergarage.xml.Node;

public class QueryRequest extends ControlRequest {
    public QueryRequest() {
    }

    public String Y0() {
        Node Z0 = Z0();
        if (Z0 == null) {
            return "";
        }
        return Z0.t();
    }

    public final Node Z0() {
        Node m11;
        Node R0 = R0();
        if (R0 != null && R0.u() && (m11 = R0.m(0)) != null && m11.u()) {
            return m11.m(0);
        }
        return null;
    }

    public QueryRequest(HTTPRequest hTTPRequest) {
        K0(hTTPRequest);
    }
}
