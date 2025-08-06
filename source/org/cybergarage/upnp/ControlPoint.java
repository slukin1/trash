package org.cybergarage.upnp;

import e20.c;
import h20.a;
import h20.b;
import h20.e;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import org.cybergarage.http.HTTPRequest;
import org.cybergarage.http.HTTPServerList;
import org.cybergarage.upnp.device.USN;
import org.cybergarage.upnp.event.NotifyRequest;
import org.cybergarage.upnp.event.Property;
import org.cybergarage.upnp.event.PropertyList;
import org.cybergarage.upnp.event.SubscriptionRequest;
import org.cybergarage.upnp.ssdp.SSDPNotifySocketList;
import org.cybergarage.upnp.ssdp.SSDPSearchResponseSocketList;
import org.cybergarage.util.Debug;
import org.cybergarage.util.ListenerList;
import org.cybergarage.util.Mutex;
import org.cybergarage.xml.Node;
import org.cybergarage.xml.NodeList;
import org.cybergarage.xml.ParserException;

public class ControlPoint implements c {

    /* renamed from: a  reason: collision with root package name */
    public SSDPNotifySocketList f59838a;

    /* renamed from: b  reason: collision with root package name */
    public SSDPSearchResponseSocketList f59839b;

    /* renamed from: c  reason: collision with root package name */
    public Mutex f59840c;

    /* renamed from: d  reason: collision with root package name */
    public int f59841d;

    /* renamed from: e  reason: collision with root package name */
    public int f59842e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f59843f;

    /* renamed from: g  reason: collision with root package name */
    public NodeList f59844g;

    /* renamed from: h  reason: collision with root package name */
    public b f59845h;

    /* renamed from: i  reason: collision with root package name */
    public long f59846i;

    /* renamed from: j  reason: collision with root package name */
    public ListenerList f59847j;

    /* renamed from: k  reason: collision with root package name */
    public ListenerList f59848k;

    /* renamed from: l  reason: collision with root package name */
    public ListenerList f59849l;

    /* renamed from: m  reason: collision with root package name */
    public int f59850m;

    /* renamed from: n  reason: collision with root package name */
    public HTTPServerList f59851n;

    /* renamed from: o  reason: collision with root package name */
    public ListenerList f59852o;

    /* renamed from: p  reason: collision with root package name */
    public String f59853p;

    /* renamed from: q  reason: collision with root package name */
    public g20.c f59854q;

    /* renamed from: r  reason: collision with root package name */
    public Object f59855r;

    static {
        UPnP.d();
    }

    public ControlPoint(int i11, int i12, InetAddress[] inetAddressArr) {
        this.f59840c = new Mutex();
        this.f59841d = 0;
        this.f59842e = 0;
        this.f59844g = new NodeList();
        this.f59847j = new ListenerList();
        this.f59848k = new ListenerList();
        this.f59849l = new ListenerList();
        this.f59850m = 3;
        this.f59851n = new HTTPServerList();
        this.f59852o = new ListenerList();
        this.f59853p = "/evetSub";
        this.f59855r = null;
        this.f59838a = new SSDPNotifySocketList(inetAddressArr);
        this.f59839b = new SSDPSearchResponseSocketList(inetAddressArr);
        B(i11);
        y(i12);
        w((b) null);
        x(60);
        A((g20.c) null);
        z(false);
        A((g20.c) null);
    }

    public void A(g20.c cVar) {
    }

    public void B(int i11) {
        this.f59841d = i11;
    }

    public boolean C() {
        D();
        SSDPNotifySocketList j11 = j();
        j11.stop();
        j11.close();
        j11.clear();
        SSDPSearchResponseSocketList k11 = k();
        k11.stop();
        k11.close();
        k11.clear();
        HTTPServerList h11 = h();
        h11.stop();
        h11.close();
        h11.clear();
        f();
        i();
        return true;
    }

    public void D() {
        DeviceList g11 = g();
        int size = g11.size();
        for (int i11 = 0; i11 < size; i11++) {
            E(g11.getDevice(i11));
        }
    }

    public void E(Device device) {
        ServiceList I = device.I();
        int size = I.size();
        for (int i11 = 0; i11 < size; i11++) {
            Service service = I.getService(i11);
            if (service.z()) {
                F(service);
            }
        }
        DeviceList s11 = device.s();
        int size2 = s11.size();
        for (int i12 = 0; i12 < size2; i12++) {
            E(s11.getDevice(i12));
        }
    }

    public boolean F(Service service) {
        SubscriptionRequest subscriptionRequest = new SubscriptionRequest();
        subscriptionRequest.a1(service);
        if (!subscriptionRequest.W0().n0()) {
            return false;
        }
        service.b();
        return true;
    }

    public void a(HTTPRequest hTTPRequest) {
        if (Debug.b()) {
            hTTPRequest.F0();
        }
        if (hTTPRequest.x0()) {
            NotifyRequest notifyRequest = new NotifyRequest(hTTPRequest);
            String b12 = notifyRequest.b1();
            long a12 = notifyRequest.a1();
            PropertyList Z0 = notifyRequest.Z0();
            int size = Z0.size();
            for (int i11 = 0; i11 < size; i11++) {
                Property property = Z0.getProperty(i11);
                n(b12, a12, property.a(), property.b());
            }
            hTTPRequest.I0();
            return;
        }
        hTTPRequest.H0();
    }

    public final synchronized void b(j20.b bVar) {
        if (bVar.t()) {
            Device d11 = d(USN.a(bVar.p()));
            if (d11 != null) {
                d11.Y(bVar);
                return;
            }
            try {
                Node c11 = UPnP.c().c(new URL(bVar.h()));
                Device e11 = e(c11);
                if (e11 != null) {
                    e11.Y(bVar);
                    c(c11);
                    m(e11);
                }
            } catch (MalformedURLException e12) {
                Debug.e(bVar.toString());
                Debug.d(e12);
            } catch (ParserException e13) {
                Debug.e(bVar.toString());
                Debug.d(e13);
            }
        }
    }

    public final void c(Node node) {
        this.f59844g.add(node);
    }

    public Device d(String str) {
        int size = this.f59844g.size();
        for (int i11 = 0; i11 < size; i11++) {
            Device e11 = e(this.f59844g.getNode(i11));
            if (e11 != null) {
                if (e11.S(str)) {
                    return e11;
                }
                Device p11 = e11.p(str);
                if (p11 != null) {
                    return p11;
                }
            }
        }
        return null;
    }

    public final Device e(Node node) {
        Node n11;
        if (node == null || (n11 = node.n("device")) == null) {
            return null;
        }
        return new Device(node, n11);
    }

    public b f() {
        return this.f59845h;
    }

    public void finalize() {
        C();
    }

    public DeviceList g() {
        DeviceList deviceList = new DeviceList();
        int size = this.f59844g.size();
        for (int i11 = 0; i11 < size; i11++) {
            Device e11 = e(this.f59844g.getNode(i11));
            if (e11 != null) {
                deviceList.add(e11);
            }
        }
        return deviceList;
    }

    public final HTTPServerList h() {
        return this.f59851n;
    }

    public g20.c i() {
        return this.f59854q;
    }

    public final SSDPNotifySocketList j() {
        return this.f59838a;
    }

    public final SSDPSearchResponseSocketList k() {
        return this.f59839b;
    }

    public void l(j20.b bVar) {
        if (bVar.t()) {
            if (bVar.q()) {
                b(bVar);
            } else if (bVar.r()) {
                r(bVar);
            }
        }
        o(bVar);
    }

    public void m(Device device) {
        int size = this.f59849l.size();
        for (int i11 = 0; i11 < size; i11++) {
            ((a) this.f59849l.get(i11)).b(device);
        }
    }

    public void n(String str, long j11, String str2, String str3) {
        int size = this.f59852o.size();
        for (int i11 = 0; i11 < size; i11++) {
            ((i20.a) this.f59852o.get(i11)).a(str, j11, str2, str3);
        }
    }

    public void o(j20.b bVar) {
        int size = this.f59847j.size();
        for (int i11 = 0; i11 < size; i11++) {
            try {
                ((h20.c) this.f59847j.get(i11)).a(bVar);
            } catch (Exception e11) {
                Debug.f("NotifyListener returned an error:", e11);
            }
        }
    }

    public void p(Device device) {
        int size = this.f59849l.size();
        for (int i11 = 0; i11 < size; i11++) {
            ((a) this.f59849l.get(i11)).a(device);
        }
    }

    public void q(j20.b bVar) {
        int size = this.f59848k.size();
        for (int i11 = 0; i11 < size; i11++) {
            try {
                ((e) this.f59848k.get(i11)).a(bVar);
            } catch (Exception e11) {
                Debug.f("SearchResponseListener returned an error:", e11);
            }
        }
    }

    public final void r(j20.b bVar) {
        if (bVar.r()) {
            s(USN.a(bVar.p()));
        }
    }

    public void s(String str) {
        t(d(str));
    }

    public void t(Device device) {
        if (device != null) {
            u(device.C());
        }
    }

    public final void u(Node node) {
        Device e11 = e(node);
        if (e11 != null && e11.V()) {
            p(e11);
        }
        this.f59844g.remove(node);
    }

    public void v(j20.b bVar) {
        if (bVar.t()) {
            b(bVar);
        }
        q(bVar);
    }

    public void w(b bVar) {
    }

    public void x(long j11) {
        this.f59846i = j11;
    }

    public void y(int i11) {
        this.f59842e = i11;
    }

    public void z(boolean z11) {
        this.f59843f = z11;
    }

    public ControlPoint(int i11, int i12) {
        this(i11, i12, (InetAddress[]) null);
    }

    public ControlPoint() {
        this(8008, 8058);
    }
}
