package org.cybergarage.upnp.control;

import org.cybergarage.upnp.StateVariable;
import org.cybergarage.xml.Node;

public class QueryResponse extends ControlResponse {
    public final Node y0(String str) {
        Node node = new Node();
        node.A("u", "QueryStateVariableResponse");
        node.B("u", "urn:schemas-upnp-org:control-1-0");
        Node node2 = new Node();
        node2.z("return");
        node2.G(str);
        node.c(node2);
        return node;
    }

    public void z0(StateVariable stateVariable) {
        String j11 = stateVariable.j();
        p0(200);
        q0().c(y0(j11));
        t0(r0());
    }
}
