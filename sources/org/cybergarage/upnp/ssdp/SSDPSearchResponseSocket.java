package org.cybergarage.upnp.ssdp;

import j20.b;
import java.net.DatagramSocket;
import org.cybergarage.upnp.ControlPoint;

public class SSDPSearchResponseSocket extends HTTPUSocket implements Runnable {

    /* renamed from: d  reason: collision with root package name */
    public ControlPoint f59892d = null;

    /* renamed from: e  reason: collision with root package name */
    public Thread f59893e = null;

    public SSDPSearchResponseSocket() {
        l((ControlPoint) null);
    }

    public ControlPoint i() {
        return this.f59892d;
    }

    public boolean j(String str, int i11, SSDPSearchRequest sSDPSearchRequest) {
        return f(str, i11, sSDPSearchRequest.toString());
    }

    public boolean k(String str, int i11, SSDPSearchResponse sSDPSearchResponse) {
        return f(str, i11, sSDPSearchResponse.k0());
    }

    public void l(ControlPoint controlPoint) {
        this.f59892d = controlPoint;
    }

    public void m() {
        StringBuffer stringBuffer = new StringBuffer("Cyber.SSDPSearchResponseSocket/");
        DatagramSocket b11 = b();
        if (b11.getLocalAddress() != null) {
            stringBuffer.append(b11.getLocalAddress());
            stringBuffer.append(':');
            stringBuffer.append(b11.getLocalPort());
        }
        Thread thread = new Thread(this, stringBuffer.toString());
        this.f59893e = thread;
        thread.start();
    }

    public void n() {
        this.f59893e = null;
    }

    public void run() {
        Thread currentThread = Thread.currentThread();
        ControlPoint i11 = i();
        while (this.f59893e == currentThread) {
            Thread.yield();
            b g11 = g();
            if (g11 != null) {
                if (i11 != null) {
                    i11.v(g11);
                }
            } else {
                return;
            }
        }
    }

    public SSDPSearchResponseSocket(String str, int i11) {
        super(str, i11);
        l((ControlPoint) null);
    }
}
