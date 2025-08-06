package org.cybergarage.upnp;

import f20.a;
import j20.b;
import java.io.File;
import java.net.URL;
import org.cybergarage.http.HTTP;
import org.cybergarage.upnp.device.ST;
import org.cybergarage.upnp.event.NotifyRequest;
import org.cybergarage.upnp.event.Subscriber;
import org.cybergarage.upnp.event.SubscriberList;
import org.cybergarage.upnp.xml.ServiceData;
import org.cybergarage.util.Debug;
import org.cybergarage.util.Mutex;
import org.cybergarage.util.StringUtil;
import org.cybergarage.xml.Node;
import org.cybergarage.xml.ParserException;

public class Service {

    /* renamed from: a  reason: collision with root package name */
    public Node f59863a;

    /* renamed from: b  reason: collision with root package name */
    public Mutex f59864b;

    /* renamed from: c  reason: collision with root package name */
    public Object f59865c;

    public Service() {
        this(new Node("service"));
        Node node = new Node("specVersion");
        Node node2 = new Node("major");
        node2.G("1");
        node.c(node2);
        Node node3 = new Node("minor");
        node3.G("0");
        node.c(node3);
        Node node4 = new Node("scpd");
        node4.a("xmlns", "urn:schemas-upnp-org:service-1-0");
        node4.c(node);
        s().e(node4);
    }

    public static boolean E(Node node) {
        return "service".equals(node.l());
    }

    public boolean A(String str) {
        return w(str) != null;
    }

    public boolean B(String str) {
        return F(e(), str);
    }

    public boolean C(String str) {
        return F(h(), str);
    }

    public boolean D(String str) {
        return F(q(), str);
    }

    public final boolean F(String str, String str2) {
        return (str == null || str2 == null || (!str2.equals(str) && !str2.equals(HTTP.h(str, false)))) ? false : true;
    }

    public void G(StateVariable stateVariable) {
        SubscriberList y11 = y();
        int size = y11.size();
        Subscriber[] subscriberArr = new Subscriber[size];
        for (int i11 = 0; i11 < size; i11++) {
            subscriberArr[i11] = y11.getSubscriber(i11);
        }
        for (int i12 = 0; i12 < size; i12++) {
            Subscriber subscriber = subscriberArr[i12];
            if (subscriber != null && subscriber.j()) {
                J(subscriber);
            }
        }
        int size2 = y11.size();
        Subscriber[] subscriberArr2 = new Subscriber[size2];
        for (int i13 = 0; i13 < size2; i13++) {
            subscriberArr2[i13] = y11.getSubscriber(i13);
        }
        for (int i14 = 0; i14 < size2; i14++) {
            Subscriber subscriber2 = subscriberArr2[i14];
            if (subscriber2 != null) {
                H(subscriber2, stateVariable);
            }
        }
    }

    public final boolean H(Subscriber subscriber, StateVariable stateVariable) {
        String c11 = stateVariable.c();
        String j11 = stateVariable.j();
        String a11 = subscriber.a();
        int c12 = subscriber.c();
        NotifyRequest notifyRequest = new NotifyRequest();
        notifyRequest.e1(subscriber, c11, j11);
        if (!notifyRequest.C0(a11, c12).n0()) {
            return false;
        }
        subscriber.i();
        return true;
    }

    public void I() {
        ServiceStateTable u11 = u();
        int size = u11.size();
        for (int i11 = 0; i11 < size; i11++) {
            StateVariable stateVariable = u11.getStateVariable(i11);
            if (stateVariable.k()) {
                G(stateVariable);
            }
        }
    }

    public void J(Subscriber subscriber) {
        y().remove(subscriber);
    }

    public boolean K(b bVar) {
        String o11 = bVar.o();
        if (o11 == null) {
            return false;
        }
        Device f11 = f();
        String i11 = i();
        String j11 = j();
        if (ST.a(o11)) {
            f11.X(bVar, i11, j11);
            return true;
        } else if (!ST.d(o11)) {
            return true;
        } else {
            String v11 = v();
            if (!o11.equals(v11)) {
                return true;
            }
            f11.X(bVar, v11, j11);
            return true;
        }
    }

    public void L(String str) {
        s().f(str);
    }

    public void M(long j11) {
        s().g(j11);
    }

    public void a(Subscriber subscriber) {
        y().add(subscriber);
    }

    public void b() {
        L("");
        M(0);
    }

    public a c(String str) {
        ActionList d11 = d();
        int size = d11.size();
        for (int i11 = 0; i11 < size; i11++) {
            a action = d11.getAction(i11);
            String f11 = action.f();
            if (f11 != null && f11.equals(str)) {
                return action;
            }
        }
        return null;
    }

    public ActionList d() {
        Node n11;
        ActionList actionList = new ActionList();
        Node n12 = n();
        if (n12 == null || (n11 = n12.n(ActionList.ELEM_NAME)) == null) {
            return actionList;
        }
        int k11 = n11.k();
        for (int i11 = 0; i11 < k11; i11++) {
            Node m11 = n11.m(i11);
            if (a.j(m11)) {
                actionList.add(new a(this.f59863a, m11));
            }
        }
        return actionList;
    }

    public String e() {
        return t().p("controlURL");
    }

    public Device f() {
        return new Device(l(), g());
    }

    public final Node g() {
        Node q11 = t().q();
        if (q11 == null) {
            return null;
        }
        return q11.q();
    }

    public String h() {
        return t().p("eventSubURL");
    }

    public final String i() {
        return v();
    }

    public final String j() {
        return String.valueOf(f().L()) + "::" + v();
    }

    public Device k() {
        return f().B();
    }

    public final Node l() {
        return t().r();
    }

    public byte[] m() {
        Node n11 = n();
        if (n11 == null) {
            return new byte[0];
        }
        StringBuilder sb2 = new StringBuilder(String.valueOf(new String() + "<?xml version=\"1.0\" encoding=\"utf-8\"?>"));
        sb2.append("\n");
        return (String.valueOf(sb2.toString()) + n11.toString()).getBytes();
    }

    public final Node n() {
        ServiceData s11 = s();
        Node b11 = s11.b();
        if (b11 != null) {
            return b11;
        }
        Device k11 = k();
        if (k11 == null) {
            return null;
        }
        String q11 = q();
        String n11 = k11.n();
        if (n11 != null) {
            File file = new File(n11.concat(q11));
            if (file.exists()) {
                try {
                    b11 = o(file);
                } catch (ParserException e11) {
                    e11.printStackTrace();
                }
                if (b11 != null) {
                    s11.e(b11);
                    return b11;
                }
            }
        }
        try {
            Node p11 = p(new URL(k11.k(q11)));
            if (p11 != null) {
                s11.e(p11);
                return p11;
            }
        } catch (Exception unused) {
        }
        try {
            return o(new File(String.valueOf(k11.n()) + HTTP.g(q11)));
        } catch (Exception e12) {
            Debug.d(e12);
            return null;
        }
    }

    public final Node o(File file) throws ParserException {
        return UPnP.c().a(file);
    }

    public final Node p(URL url) throws ParserException {
        return UPnP.c().c(url);
    }

    public String q() {
        return t().p("SCPDURL");
    }

    public String r() {
        return s().c();
    }

    public final ServiceData s() {
        Node t11 = t();
        ServiceData serviceData = (ServiceData) t11.s();
        if (serviceData != null) {
            return serviceData;
        }
        ServiceData serviceData2 = new ServiceData();
        t11.E(serviceData2);
        serviceData2.a(t11);
        return serviceData2;
    }

    public Node t() {
        return this.f59863a;
    }

    public ServiceStateTable u() {
        ServiceStateTable serviceStateTable = new ServiceStateTable();
        Node n11 = n().n(ServiceStateTable.ELEM_NAME);
        if (n11 == null) {
            return serviceStateTable;
        }
        Node t11 = t();
        int k11 = n11.k();
        for (int i11 = 0; i11 < k11; i11++) {
            Node m11 = n11.m(i11);
            if (StateVariable.l(m11)) {
                serviceStateTable.add(new StateVariable(t11, m11));
            }
        }
        return serviceStateTable;
    }

    public String v() {
        return t().p("serviceType");
    }

    public StateVariable w(String str) {
        ServiceStateTable u11 = u();
        int size = u11.size();
        for (int i11 = 0; i11 < size; i11++) {
            StateVariable stateVariable = u11.getStateVariable(i11);
            String c11 = stateVariable.c();
            if (c11 != null && c11.equals(str)) {
                return stateVariable;
            }
        }
        return null;
    }

    public Subscriber x(String str) {
        String f11;
        SubscriberList y11 = y();
        int size = y11.size();
        for (int i11 = 0; i11 < size; i11++) {
            Subscriber subscriber = y11.getSubscriber(i11);
            if (subscriber != null && (f11 = subscriber.f()) != null && f11.equals(str)) {
                return subscriber;
            }
        }
        return null;
    }

    public SubscriberList y() {
        return s().d();
    }

    public boolean z() {
        return StringUtil.a(r());
    }

    public Service(Node node) {
        this.f59864b = new Mutex();
        this.f59865c = null;
        this.f59863a = node;
    }
}
