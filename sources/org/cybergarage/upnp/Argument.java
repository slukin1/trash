package org.cybergarage.upnp;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import org.cybergarage.upnp.xml.ArgumentData;
import org.cybergarage.xml.Node;

public class Argument {

    /* renamed from: a  reason: collision with root package name */
    public Node f59835a;

    /* renamed from: b  reason: collision with root package name */
    public Node f59836b;

    /* renamed from: c  reason: collision with root package name */
    public Object f59837c;

    public Argument() {
        this.f59837c = null;
        this.f59835a = new Node("argument");
        this.f59836b = null;
    }

    public static boolean f(Node node) {
        return "argument".equals(node.l());
    }

    public final ArgumentData a() {
        Node b11 = b();
        ArgumentData argumentData = (ArgumentData) b11.s();
        if (argumentData != null) {
            return argumentData;
        }
        ArgumentData argumentData2 = new ArgumentData();
        b11.E(argumentData2);
        argumentData2.a(b11);
        return argumentData2;
    }

    public Node b() {
        return this.f59835a;
    }

    public String c() {
        return b().p(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION);
    }

    public String d() {
        return b().p("name");
    }

    public String e() {
        return a().b();
    }

    public boolean g() {
        String c11 = c();
        if (c11 == null) {
            return false;
        }
        return c11.equalsIgnoreCase("in");
    }

    public boolean h() {
        return !g();
    }

    public void i(String str) {
        b().C("name", str);
    }

    public void j(String str) {
        a().c(str);
    }

    public Argument(Node node, Node node2) {
        this.f59837c = null;
        this.f59836b = node;
        this.f59835a = node2;
    }
}
