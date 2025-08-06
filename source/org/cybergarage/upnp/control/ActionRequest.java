package org.cybergarage.upnp.control;

import org.cybergarage.http.HTTPRequest;
import org.cybergarage.upnp.Argument;
import org.cybergarage.upnp.ArgumentList;
import org.cybergarage.xml.Node;

public class ActionRequest extends ControlRequest {
    public ActionRequest() {
    }

    public String Y0() {
        String l11;
        int indexOf;
        Node Z0 = Z0();
        if (Z0 == null || (l11 = Z0.l()) == null || (indexOf = l11.indexOf(":") + 1) < 0) {
            return "";
        }
        return l11.substring(indexOf, l11.length());
    }

    public Node Z0() {
        Node R0 = R0();
        if (R0 != null && R0.u()) {
            return R0.m(0);
        }
        return null;
    }

    public ArgumentList a1() {
        Node Z0 = Z0();
        int k11 = Z0.k();
        ArgumentList argumentList = new ArgumentList();
        for (int i11 = 0; i11 < k11; i11++) {
            Argument argument = new Argument();
            Node m11 = Z0.m(i11);
            argument.i(m11.l());
            argument.j(m11.t());
            argumentList.add(argument);
        }
        return argumentList;
    }

    public ActionRequest(HTTPRequest hTTPRequest) {
        K0(hTTPRequest);
    }
}
