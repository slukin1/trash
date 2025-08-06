package org.cybergarage.upnp.control;

import f20.a;
import org.cybergarage.upnp.Argument;
import org.cybergarage.upnp.ArgumentList;
import org.cybergarage.upnp.Service;
import org.cybergarage.xml.Node;

public class ActionResponse extends ControlResponse {
    public ActionResponse() {
        e0("EXT", "");
    }

    public final Node y0(a aVar) {
        String f11 = aVar.f();
        Node node = new Node("u:" + f11 + "Response");
        Service g11 = aVar.g();
        if (g11 != null) {
            node.y("xmlns:u", g11.v());
        }
        ArgumentList e11 = aVar.e();
        int size = e11.size();
        for (int i11 = 0; i11 < size; i11++) {
            Argument argument = e11.getArgument(i11);
            if (argument.h()) {
                Node node2 = new Node();
                node2.z(argument.d());
                node2.G(argument.e());
                node.c(node2);
            }
        }
        return node;
    }

    public void z0(a aVar) {
        p0(200);
        q0().c(y0(aVar));
        t0(r0());
    }
}
