package org.cybergarage.upnp.xml;

import org.cybergarage.upnp.event.SubscriberList;
import org.cybergarage.util.ListenerList;
import org.cybergarage.xml.Node;

public class ServiceData extends NodeData {

    /* renamed from: b  reason: collision with root package name */
    public ListenerList f59912b = new ListenerList();

    /* renamed from: c  reason: collision with root package name */
    public Node f59913c = null;

    /* renamed from: d  reason: collision with root package name */
    public SubscriberList f59914d = new SubscriberList();

    /* renamed from: e  reason: collision with root package name */
    public String f59915e = "";

    /* renamed from: f  reason: collision with root package name */
    public String f59916f = "";

    /* renamed from: g  reason: collision with root package name */
    public long f59917g = 0;

    public Node b() {
        return this.f59913c;
    }

    public String c() {
        return this.f59916f;
    }

    public SubscriberList d() {
        return this.f59914d;
    }

    public void e(Node node) {
        this.f59913c = node;
    }

    public void f(String str) {
        this.f59916f = str;
    }

    public void g(long j11) {
        this.f59917g = j11;
    }
}
