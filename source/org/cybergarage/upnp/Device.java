package org.cybergarage.upnp;

import e20.c;
import f20.a;
import h20.d;
import j20.b;
import java.io.File;
import java.net.URL;
import java.util.Calendar;
import org.cybergarage.http.HTTP;
import org.cybergarage.http.HTTPRequest;
import org.cybergarage.http.HTTPResponse;
import org.cybergarage.net.HostInterface;
import org.cybergarage.soap.SOAPResponse;
import org.cybergarage.upnp.control.ActionRequest;
import org.cybergarage.upnp.control.ActionResponse;
import org.cybergarage.upnp.control.ControlRequest;
import org.cybergarage.upnp.control.QueryRequest;
import org.cybergarage.upnp.device.ST;
import org.cybergarage.upnp.event.Subscriber;
import org.cybergarage.upnp.event.Subscription;
import org.cybergarage.upnp.event.SubscriptionRequest;
import org.cybergarage.upnp.event.SubscriptionResponse;
import org.cybergarage.upnp.ssdp.SSDPSearchResponse;
import org.cybergarage.upnp.ssdp.SSDPSearchResponseSocket;
import org.cybergarage.upnp.xml.DeviceData;
import org.cybergarage.util.Debug;
import org.cybergarage.util.FileUtil;
import org.cybergarage.util.Mutex;
import org.cybergarage.util.TimerUtil;
import org.cybergarage.xml.Node;

public class Device implements c, d {

    /* renamed from: g  reason: collision with root package name */
    public static Calendar f59856g = Calendar.getInstance();

    /* renamed from: a  reason: collision with root package name */
    public Node f59857a;

    /* renamed from: b  reason: collision with root package name */
    public Node f59858b;

    /* renamed from: c  reason: collision with root package name */
    public Mutex f59859c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f59860d;

    /* renamed from: e  reason: collision with root package name */
    public String f59861e;

    /* renamed from: f  reason: collision with root package name */
    public Object f59862f;

    static {
        UPnP.d();
    }

    public Device(Node node, Node node2) {
        this.f59859c = new Mutex();
        this.f59862f = null;
        this.f59857a = node;
        this.f59858b = node2;
        a0(UPnP.a());
        b0(false);
    }

    public static boolean T(Node node) {
        return "device".equals(node.l());
    }

    public final String A() {
        return !V() ? L() : "upnp:rootdevice";
    }

    public Device B() {
        Node n11;
        Node C = C();
        if (C == null || (n11 = C.n("device")) == null) {
            return null;
        }
        return new Device(C, n11);
    }

    public Node C() {
        Node node = this.f59857a;
        if (node != null) {
            return node;
        }
        Node node2 = this.f59858b;
        if (node2 == null) {
            return null;
        }
        return node2.r();
    }

    public int D() {
        return (!U() || !W()) ? 1 : 4;
    }

    public b E() {
        if (!V()) {
            return null;
        }
        return r().g();
    }

    public Service F(String str) {
        ServiceList I = I();
        int size = I.size();
        for (int i11 = 0; i11 < size; i11++) {
            Service service = I.getService(i11);
            if (service.B(str)) {
                return service;
            }
        }
        DeviceList s11 = s();
        int size2 = s11.size();
        for (int i12 = 0; i12 < size2; i12++) {
            Service F = s11.getDevice(i12).F(str);
            if (F != null) {
                return F;
            }
        }
        return null;
    }

    public Service G(String str) {
        ServiceList I = I();
        int size = I.size();
        for (int i11 = 0; i11 < size; i11++) {
            Service service = I.getService(i11);
            if (service.C(str)) {
                return service;
            }
        }
        DeviceList s11 = s();
        int size2 = s11.size();
        for (int i12 = 0; i12 < size2; i12++) {
            Service G = s11.getDevice(i12).G(str);
            if (G != null) {
                return G;
            }
        }
        return null;
    }

    public Service H(String str) {
        ServiceList I = I();
        int size = I.size();
        for (int i11 = 0; i11 < size; i11++) {
            Service service = I.getService(i11);
            if (service.D(str)) {
                return service;
            }
        }
        DeviceList s11 = s();
        int size2 = s11.size();
        for (int i12 = 0; i12 < size2; i12++) {
            Service H = s11.getDevice(i12).H(str);
            if (H != null) {
                return H;
            }
        }
        return null;
    }

    public ServiceList I() {
        ServiceList serviceList = new ServiceList();
        Node n11 = t().n(ServiceList.ELEM_NAME);
        if (n11 == null) {
            return serviceList;
        }
        int k11 = n11.k();
        for (int i11 = 0; i11 < k11; i11++) {
            Node m11 = n11.m(i11);
            if (Service.E(m11)) {
                serviceList.add(new Service(m11));
            }
        }
        return serviceList;
    }

    public StateVariable J(String str) {
        return K((String) null, str);
    }

    public StateVariable K(String str, String str2) {
        StateVariable w11;
        if (str == null && str2 == null) {
            return null;
        }
        ServiceList I = I();
        int size = I.size();
        for (int i11 = 0; i11 < size; i11++) {
            Service service = I.getService(i11);
            if ((str == null || service.v().equals(str)) && (w11 = service.w(str2)) != null) {
                return w11;
            }
        }
        DeviceList s11 = s();
        int size2 = s11.size();
        for (int i12 = 0; i12 < size2; i12++) {
            StateVariable K = s11.getDevice(i12).K(str, str2);
            if (K != null) {
                return K;
            }
        }
        return null;
    }

    public String L() {
        return t().p("UDN");
    }

    public String M() {
        return V() ? C().p("URLBase") : "";
    }

    public final void N(HTTPRequest hTTPRequest) {
        byte[] bArr;
        String s02 = hTTPRequest.s0();
        Debug.c("httpGetRequestRecieved = " + s02);
        if (s02 == null) {
            hTTPRequest.H0();
            return;
        }
        if (R(s02)) {
            String n02 = hTTPRequest.n0();
            if (n02 == null || n02.length() <= 0) {
                n02 = HostInterface.c();
            }
            bArr = l(n02);
        } else {
            Device q11 = q(s02);
            if (q11 != null) {
                bArr = q11.l(hTTPRequest.n0());
            } else {
                Service H = H(s02);
                if (H != null) {
                    bArr = H.m();
                } else {
                    hTTPRequest.H0();
                    return;
                }
            }
        }
        HTTPResponse hTTPResponse = new HTTPResponse();
        if (FileUtil.a(s02)) {
            hTTPResponse.a0("text/xml; charset=\"utf-8\"");
        }
        hTTPResponse.p0(200);
        hTTPResponse.V(bArr);
        hTTPRequest.E0(hTTPResponse);
    }

    public final void O(HTTPRequest hTTPRequest) {
        if (hTTPRequest.z0()) {
            c0(hTTPRequest);
        } else {
            hTTPRequest.H0();
        }
    }

    public final void P(ControlRequest controlRequest) {
        ActionResponse actionResponse = new ActionResponse();
        actionResponse.w0(401);
        controlRequest.E0(actionResponse);
    }

    public final void Q(ControlRequest controlRequest) {
        ActionResponse actionResponse = new ActionResponse();
        actionResponse.w0(402);
        controlRequest.E0(actionResponse);
    }

    public final boolean R(String str) {
        String o11 = o();
        if (str == null || o11 == null) {
            return false;
        }
        return o11.equals(str);
    }

    public boolean S(String str) {
        if (str == null) {
            return false;
        }
        return str.endsWith(L()) || str.equals(v()) || str.endsWith(u());
    }

    public boolean U() {
        Node t11 = t();
        if (t11 == null || t11.n("INMPR03") == null) {
            return false;
        }
        return true;
    }

    public boolean V() {
        return C().n("device").p("UDN").equals(L());
    }

    public boolean W() {
        return this.f59860d;
    }

    public boolean X(b bVar, String str, String str2) {
        String z11 = B().z(bVar.g());
        SSDPSearchResponse sSDPSearchResponse = new SSDPSearchResponse();
        sSDPSearchResponse.q0(x());
        sSDPSearchResponse.b0(f59856g);
        sSDPSearchResponse.t0(str);
        sSDPSearchResponse.u0(str2);
        sSDPSearchResponse.r0(z11);
        sSDPSearchResponse.s0(v());
        TimerUtil.a(bVar.j() * 1000);
        String m11 = bVar.m();
        int n11 = bVar.n();
        SSDPSearchResponseSocket sSDPSearchResponseSocket = new SSDPSearchResponseSocket();
        if (Debug.b()) {
            sSDPSearchResponse.o0();
        }
        int D = D();
        for (int i11 = 0; i11 < D; i11++) {
            sSDPSearchResponseSocket.k(m11, n11, sSDPSearchResponse);
        }
        return true;
    }

    public void Y(b bVar) {
        r().h(bVar);
    }

    public final void Z(String str) {
        if (V()) {
            Node n11 = C().n("URLBase");
            if (n11 != null) {
                n11.G(str);
                return;
            }
            Node node = new Node("URLBase");
            node.G(str);
            C().u();
            C().v(node, 1);
        }
    }

    public void a(HTTPRequest hTTPRequest) {
        if (Debug.b()) {
            hTTPRequest.F0();
        }
        if (hTTPRequest.t0() || hTTPRequest.u0()) {
            N(hTTPRequest);
        } else if (hTTPRequest.y0()) {
            O(hTTPRequest);
        } else if (hTTPRequest.A0() || hTTPRequest.B0()) {
            g(new SubscriptionRequest(hTTPRequest));
        } else {
            hTTPRequest.H0();
        }
    }

    public final void a0(String str) {
        this.f59861e = str;
    }

    public void b(b bVar) {
        j(bVar);
    }

    public void b0(boolean z11) {
        this.f59860d = z11;
    }

    public final void c(ActionRequest actionRequest, Service service) {
        if (Debug.b()) {
            actionRequest.F0();
        }
        a c11 = service.c(actionRequest.Y0());
        if (c11 == null) {
            P(actionRequest);
            return;
        }
        try {
            c11.e().setReqArgs(actionRequest.a1());
            if (!c11.k(actionRequest)) {
                P(actionRequest);
            }
        } catch (IllegalArgumentException unused) {
            Q(actionRequest);
        }
    }

    public final void c0(HTTPRequest hTTPRequest) {
        Service F = F(hTTPRequest.s0());
        if (F != null) {
            d(new ActionRequest(hTTPRequest), F);
        } else {
            d0(hTTPRequest);
        }
    }

    public final void d(ControlRequest controlRequest, Service service) {
        if (controlRequest.X0()) {
            i(new QueryRequest(controlRequest), service);
        } else {
            c(new ActionRequest(controlRequest), service);
        }
    }

    public final void d0(HTTPRequest hTTPRequest) {
        SOAPResponse sOAPResponse = new SOAPResponse();
        sOAPResponse.p0(400);
        hTTPRequest.E0(sOAPResponse);
    }

    public final void e(Service service, SubscriptionRequest subscriptionRequest) {
        String R0 = subscriptionRequest.R0();
        try {
            new URL(R0);
            long T0 = subscriptionRequest.T0();
            String a11 = Subscription.a();
            Subscriber subscriber = new Subscriber();
            subscriber.l(R0);
            subscriber.p(T0);
            subscriber.n(a11);
            service.a(subscriber);
            SubscriptionResponse subscriptionResponse = new SubscriptionResponse();
            subscriptionResponse.p0(200);
            subscriptionResponse.r0(a11);
            subscriptionResponse.s0(T0);
            if (Debug.b()) {
                subscriptionResponse.o0();
            }
            subscriptionRequest.X0(subscriptionResponse);
            if (Debug.b()) {
                subscriptionResponse.o0();
            }
            service.I();
        } catch (Exception unused) {
            f0(subscriptionRequest, 412);
        }
    }

    public final void e0(String str) {
        Z(HostInterface.b(str, w(), ""));
    }

    public final void f(Service service, SubscriptionRequest subscriptionRequest) {
        String S0 = subscriptionRequest.S0();
        Subscriber x11 = service.x(S0);
        if (x11 == null) {
            f0(subscriptionRequest, 412);
            return;
        }
        long T0 = subscriptionRequest.T0();
        x11.p(T0);
        x11.k();
        SubscriptionResponse subscriptionResponse = new SubscriptionResponse();
        subscriptionResponse.p0(200);
        subscriptionResponse.r0(S0);
        subscriptionResponse.s0(T0);
        subscriptionRequest.X0(subscriptionResponse);
        if (Debug.b()) {
            subscriptionResponse.o0();
        }
    }

    public final void f0(SubscriptionRequest subscriptionRequest, int i11) {
        SubscriptionResponse subscriptionResponse = new SubscriptionResponse();
        subscriptionResponse.q0(i11);
        subscriptionRequest.X0(subscriptionResponse);
    }

    public final void g(SubscriptionRequest subscriptionRequest) {
        Service G = G(subscriptionRequest.s0());
        if (G == null) {
            subscriptionRequest.H0();
        } else if (!subscriptionRequest.U0() && !subscriptionRequest.V0()) {
            f0(subscriptionRequest, 412);
        } else if (subscriptionRequest.B0()) {
            h(G, subscriptionRequest);
        } else if (subscriptionRequest.U0()) {
            e(G, subscriptionRequest);
        } else if (subscriptionRequest.V0()) {
            f(G, subscriptionRequest);
        } else {
            f0(subscriptionRequest, 412);
        }
    }

    public final void h(Service service, SubscriptionRequest subscriptionRequest) {
        Subscriber x11 = service.x(subscriptionRequest.S0());
        if (x11 == null) {
            f0(subscriptionRequest, 412);
            return;
        }
        service.J(x11);
        SubscriptionResponse subscriptionResponse = new SubscriptionResponse();
        subscriptionResponse.p0(200);
        subscriptionRequest.X0(subscriptionResponse);
        if (Debug.b()) {
            subscriptionResponse.o0();
        }
    }

    public final void i(QueryRequest queryRequest, Service service) {
        if (Debug.b()) {
            queryRequest.F0();
        }
        String Y0 = queryRequest.Y0();
        if (!service.A(Y0)) {
            P(queryRequest);
        } else if (!J(Y0).m(queryRequest)) {
            P(queryRequest);
        }
    }

    public void j(b bVar) {
        String o11 = bVar.o();
        if (o11 != null) {
            boolean V = V();
            String L = L();
            if (V) {
                L = String.valueOf(L) + "::upnp:rootdevice";
            }
            if (ST.a(o11)) {
                String A = A();
                int i11 = V ? 3 : 2;
                for (int i12 = 0; i12 < i11; i12++) {
                    X(bVar, A, L);
                }
            } else if (ST.b(o11)) {
                if (V) {
                    X(bVar, "upnp:rootdevice", L);
                }
            } else if (ST.e(o11)) {
                String L2 = L();
                if (o11.equals(L2)) {
                    X(bVar, L2, L);
                }
            } else if (ST.c(o11)) {
                String u11 = u();
                if (o11.equals(u11)) {
                    X(bVar, u11, String.valueOf(L()) + "::" + u11);
                }
            }
            ServiceList I = I();
            int size = I.size();
            for (int i13 = 0; i13 < size; i13++) {
                I.getService(i13).K(bVar);
            }
            DeviceList s11 = s();
            int size2 = s11.size();
            for (int i14 = 0; i14 < size2; i14++) {
                s11.getDevice(i14).j(bVar);
            }
        }
    }

    public String k(String str) {
        try {
            return new URL(str).toString();
        } catch (Exception unused) {
            Device B = B();
            String M = B.M();
            if (M == null || M.length() <= 0) {
                String y11 = B.y();
                M = HTTP.e(HTTP.c(y11), HTTP.d(y11));
            }
            String g11 = HTTP.g(str);
            try {
                return new URL(String.valueOf(M) + g11).toString();
            } catch (Exception unused2) {
                try {
                    return new URL(HTTP.a(M, g11)).toString();
                } catch (Exception unused3) {
                    return "";
                }
            }
        }
    }

    public final synchronized byte[] l(String str) {
        if (!U()) {
            e0(str);
        }
        Node C = C();
        if (C == null) {
            return new byte[0];
        }
        StringBuilder sb2 = new StringBuilder(String.valueOf(new String() + "<?xml version=\"1.0\" encoding=\"utf-8\"?>"));
        sb2.append("\n");
        return (String.valueOf(sb2.toString()) + C.toString()).getBytes();
    }

    public File m() {
        return r().b();
    }

    public String n() {
        File m11 = m();
        if (m11 == null) {
            return "";
        }
        return m11.getAbsoluteFile().getParent();
    }

    public final String o() {
        return r().c();
    }

    public Device p(String str) {
        DeviceList s11 = s();
        int size = s11.size();
        for (int i11 = 0; i11 < size; i11++) {
            Device device = s11.getDevice(i11);
            if (device.S(str)) {
                return device;
            }
            Device p11 = device.p(str);
            if (p11 != null) {
                return p11;
            }
        }
        return null;
    }

    public Device q(String str) {
        DeviceList s11 = s();
        int size = s11.size();
        for (int i11 = 0; i11 < size; i11++) {
            Device device = s11.getDevice(i11);
            if (device.R(str)) {
                return device;
            }
            Device q11 = device.q(str);
            if (q11 != null) {
                return q11;
            }
        }
        return null;
    }

    public final DeviceData r() {
        Node t11 = t();
        DeviceData deviceData = (DeviceData) t11.s();
        if (deviceData != null) {
            return deviceData;
        }
        DeviceData deviceData2 = new DeviceData();
        t11.E(deviceData2);
        deviceData2.a(t11);
        return deviceData2;
    }

    public DeviceList s() {
        DeviceList deviceList = new DeviceList();
        Node n11 = t().n(DeviceList.ELEM_NAME);
        if (n11 == null) {
            return deviceList;
        }
        int k11 = n11.k();
        for (int i11 = 0; i11 < k11; i11++) {
            Node m11 = n11.m(i11);
            if (T(m11)) {
                deviceList.add(new Device(m11));
            }
        }
        return deviceList;
    }

    public Node t() {
        return this.f59858b;
    }

    public String u() {
        return t().p("deviceType");
    }

    public String v() {
        return t().p("friendlyName");
    }

    public int w() {
        return r().d();
    }

    public int x() {
        b E = E();
        if (E != null) {
            return E.f();
        }
        return r().e();
    }

    public String y() {
        b E = E();
        if (E != null) {
            return E.h();
        }
        return r().f();
    }

    public String z(String str) {
        return HostInterface.b(str, w(), o());
    }

    public Device() {
        this((Node) null, (Node) null);
    }

    public Device(Node node) {
        this((Node) null, node);
    }
}
