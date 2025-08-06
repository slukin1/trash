package org.cybergarage.upnp.xml;

import j20.b;
import java.io.File;
import java.net.InetAddress;
import org.cybergarage.http.HTTPServerList;
import org.cybergarage.upnp.ssdp.SSDP;
import org.cybergarage.upnp.ssdp.SSDPSearchSocketList;
import org.cybergarage.util.ListenerList;

public class DeviceData extends NodeData {

    /* renamed from: b  reason: collision with root package name */
    public String f59897b = null;

    /* renamed from: c  reason: collision with root package name */
    public File f59898c = null;

    /* renamed from: d  reason: collision with root package name */
    public String f59899d = "";

    /* renamed from: e  reason: collision with root package name */
    public int f59900e = 1800;

    /* renamed from: f  reason: collision with root package name */
    public HTTPServerList f59901f = null;

    /* renamed from: g  reason: collision with root package name */
    public InetAddress[] f59902g = null;

    /* renamed from: h  reason: collision with root package name */
    public int f59903h = 4004;

    /* renamed from: i  reason: collision with root package name */
    public ListenerList f59904i = new ListenerList();

    /* renamed from: j  reason: collision with root package name */
    public SSDPSearchSocketList f59905j = null;

    /* renamed from: k  reason: collision with root package name */
    public String f59906k = "239.255.255.250";

    /* renamed from: l  reason: collision with root package name */
    public String f59907l = SSDP.a();

    /* renamed from: m  reason: collision with root package name */
    public int f59908m = 1900;

    /* renamed from: n  reason: collision with root package name */
    public InetAddress[] f59909n = null;

    /* renamed from: o  reason: collision with root package name */
    public b f59910o = null;

    public File b() {
        return this.f59898c;
    }

    public String c() {
        return this.f59897b;
    }

    public int d() {
        return this.f59903h;
    }

    public int e() {
        return this.f59900e;
    }

    public String f() {
        return this.f59899d;
    }

    public b g() {
        return this.f59910o;
    }

    public void h(b bVar) {
        this.f59910o = bVar;
    }
}
