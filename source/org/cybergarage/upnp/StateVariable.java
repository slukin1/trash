package org.cybergarage.upnp;

import g20.b;
import org.cybergarage.upnp.control.QueryRequest;
import org.cybergarage.upnp.control.QueryResponse;
import org.cybergarage.upnp.xml.NodeData;
import org.cybergarage.upnp.xml.StateVariableData;
import org.cybergarage.xml.Node;

public class StateVariable extends NodeData {

    /* renamed from: b  reason: collision with root package name */
    public Node f59866b;

    /* renamed from: c  reason: collision with root package name */
    public Node f59867c;

    /* renamed from: d  reason: collision with root package name */
    public UPnPStatus f59868d;

    /* renamed from: e  reason: collision with root package name */
    public Object f59869e;

    public StateVariable() {
        this.f59868d = new UPnPStatus();
        this.f59869e = null;
        this.f59867c = null;
        this.f59866b = new Node("stateVariable");
    }

    public static boolean l(Node node) {
        return "stateVariable".equals(node.l());
    }

    public String b() {
        return h().p("dataType");
    }

    public String c() {
        return h().p("name");
    }

    public b d() {
        return g().b();
    }

    public Service e() {
        Node f11 = f();
        if (f11 == null) {
            return null;
        }
        return new Service(f11);
    }

    public Node f() {
        return this.f59867c;
    }

    public StateVariableData g() {
        Node h11 = h();
        StateVariableData stateVariableData = (StateVariableData) h11.s();
        if (stateVariableData != null) {
            return stateVariableData;
        }
        StateVariableData stateVariableData2 = new StateVariableData();
        h11.E(stateVariableData2);
        stateVariableData2.a(h11);
        return stateVariableData2;
    }

    public Node h() {
        return this.f59866b;
    }

    public UPnPStatus i() {
        return this.f59868d;
    }

    public String j() {
        return g().c();
    }

    public boolean k() {
        String g11 = h().g("sendEvents");
        if (g11 != null && g11.equalsIgnoreCase("yes")) {
            return true;
        }
        return false;
    }

    public boolean m(QueryRequest queryRequest) {
        b d11 = d();
        if (d11 == null) {
            return false;
        }
        QueryResponse queryResponse = new QueryResponse();
        StateVariable stateVariable = new StateVariable();
        stateVariable.n(this);
        stateVariable.t("");
        stateVariable.r(404);
        if (d11.a(stateVariable)) {
            queryResponse.z0(stateVariable);
        } else {
            UPnPStatus i11 = stateVariable.i();
            queryResponse.x0(i11.b(), i11.c());
        }
        queryRequest.E0(queryResponse);
        return true;
    }

    public void n(StateVariable stateVariable) {
        p(stateVariable.c());
        t(stateVariable.j());
        o(stateVariable.b());
        q(stateVariable.k());
    }

    public void o(String str) {
        h().C("dataType", str);
    }

    public void p(String str) {
        h().C("name", str);
    }

    public void q(boolean z11) {
        h().y("sendEvents", z11 ? "yes" : "no");
    }

    public void r(int i11) {
        s(i11, UPnPStatus.a(i11));
    }

    public void s(int i11, String str) {
        this.f59868d.d(i11);
        this.f59868d.e(str);
    }

    public void t(String str) {
        String c11 = g().c();
        if (c11 == null || !c11.equals(str)) {
            g().d(str);
            Service e11 = e();
            if (e11 != null && k()) {
                e11.G(this);
            }
        }
    }

    public StateVariable(Node node, Node node2) {
        this.f59868d = new UPnPStatus();
        this.f59869e = null;
        this.f59867c = node;
        this.f59866b = node2;
    }
}
