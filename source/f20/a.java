package f20;

import org.cybergarage.upnp.Argument;
import org.cybergarage.upnp.ArgumentList;
import org.cybergarage.upnp.Service;
import org.cybergarage.upnp.UPnPStatus;
import org.cybergarage.upnp.control.ActionRequest;
import org.cybergarage.upnp.control.ActionResponse;
import org.cybergarage.upnp.xml.ActionData;
import org.cybergarage.util.Debug;
import org.cybergarage.util.Mutex;
import org.cybergarage.xml.Node;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public Node f54462a;

    /* renamed from: b  reason: collision with root package name */
    public Node f54463b;

    /* renamed from: c  reason: collision with root package name */
    public Mutex f54464c = new Mutex();

    /* renamed from: d  reason: collision with root package name */
    public UPnPStatus f54465d = new UPnPStatus();

    /* renamed from: e  reason: collision with root package name */
    public Object f54466e = null;

    public a(Node node, Node node2) {
        this.f54462a = node;
        this.f54463b = node2;
    }

    public static boolean j(Node node) {
        return "action".equals(node.l());
    }

    public final void a() {
        ArgumentList e11 = e();
        int size = e11.size();
        for (int i11 = 0; i11 < size; i11++) {
            Argument argument = e11.getArgument(i11);
            if (argument.h()) {
                argument.j("");
            }
        }
    }

    public final ActionData b() {
        Node d11 = d();
        ActionData actionData = (ActionData) d11.s();
        if (actionData != null) {
            return actionData;
        }
        ActionData actionData2 = new ActionData();
        d11.E(actionData2);
        actionData2.a(d11);
        return actionData2;
    }

    public g20.a c() {
        return b().b();
    }

    public Node d() {
        return this.f54463b;
    }

    public ArgumentList e() {
        ArgumentList argumentList = new ArgumentList();
        Node n11 = d().n(ArgumentList.ELEM_NAME);
        if (n11 == null) {
            return argumentList;
        }
        int k11 = n11.k();
        for (int i11 = 0; i11 < k11; i11++) {
            Node m11 = n11.m(i11);
            if (Argument.f(m11)) {
                argumentList.add(new Argument(h(), m11));
            }
        }
        return argumentList;
    }

    public String f() {
        return d().p("name");
    }

    public Service g() {
        return new Service(h());
    }

    public final Node h() {
        return this.f54462a;
    }

    public UPnPStatus i() {
        return this.f54465d;
    }

    public boolean k(ActionRequest actionRequest) {
        g20.a c11 = c();
        if (c11 == null) {
            return false;
        }
        ActionResponse actionResponse = new ActionResponse();
        l(401);
        a();
        if (c11.a(this)) {
            actionResponse.z0(this);
        } else {
            UPnPStatus i11 = i();
            actionResponse.x0(i11.b(), i11.c());
        }
        if (Debug.b()) {
            actionResponse.o0();
        }
        actionRequest.E0(actionResponse);
        return true;
    }

    public void l(int i11) {
        m(i11, UPnPStatus.a(i11));
    }

    public void m(int i11, String str) {
        this.f54465d.d(i11);
        this.f54465d.e(str);
    }
}
