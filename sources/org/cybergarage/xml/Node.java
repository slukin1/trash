package org.cybergarage.xml;

import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class Node {

    /* renamed from: a  reason: collision with root package name */
    public Node f59928a;

    /* renamed from: b  reason: collision with root package name */
    public String f59929b;

    /* renamed from: c  reason: collision with root package name */
    public String f59930c;

    /* renamed from: d  reason: collision with root package name */
    public AttributeList f59931d;

    /* renamed from: e  reason: collision with root package name */
    public NodeList f59932e;

    /* renamed from: f  reason: collision with root package name */
    public Object f59933f;

    public Node() {
        this.f59928a = null;
        this.f59929b = new String();
        this.f59930c = new String();
        this.f59931d = new AttributeList();
        this.f59932e = new NodeList();
        this.f59933f = null;
        E((Object) null);
        D((Node) null);
    }

    public void A(String str, String str2) {
        this.f59929b = String.valueOf(str) + ":" + str2;
    }

    public void B(String str, String str2) {
        y("xmlns:" + str, str2);
    }

    public void C(String str, String str2) {
        Node n11 = n(str);
        if (n11 != null) {
            n11.G(str2);
            return;
        }
        Node node = new Node(str);
        node.G(str2);
        c(node);
    }

    public void D(Node node) {
        this.f59928a = node;
    }

    public void E(Object obj) {
        this.f59933f = obj;
    }

    public void F(int i11) {
        G(Integer.toString(i11));
    }

    public void G(String str) {
        this.f59930c = str;
    }

    public String H(String str, boolean z11) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintWriter printWriter = new PrintWriter(byteArrayOutputStream);
        w(printWriter, 0, z11);
        printWriter.flush();
        if (str != null) {
            try {
                if (str.length() > 0) {
                    return byteArrayOutputStream.toString(str);
                }
            } catch (UnsupportedEncodingException unused) {
            }
        }
        return byteArrayOutputStream.toString();
    }

    public void a(String str, String str2) {
        b(new Attribute(str, str2));
    }

    public void b(Attribute attribute) {
        this.f59931d.add(attribute);
    }

    public void c(Node node) {
        node.D(this);
        this.f59932e.add(node);
    }

    public void d(String str) {
        String str2 = this.f59930c;
        if (str2 == null) {
            this.f59930c = str;
        } else if (str != null) {
            this.f59930c = String.valueOf(str2) + str;
        }
    }

    public Attribute e(int i11) {
        return this.f59931d.getAttribute(i11);
    }

    public Attribute f(String str) {
        return this.f59931d.getAttribute(str);
    }

    public String g(String str) {
        Attribute f11 = f(str);
        return f11 != null ? f11.b() : "";
    }

    public String h(int i11) {
        return i(i11, "   ");
    }

    public String i(int i11, String str) {
        StringBuffer stringBuffer = new StringBuffer(str.length() * i11);
        for (int i12 = 0; i12 < i11; i12++) {
            stringBuffer.append(str);
        }
        return stringBuffer.toString();
    }

    public int j() {
        return this.f59931d.size();
    }

    public int k() {
        return this.f59932e.size();
    }

    public String l() {
        return this.f59929b;
    }

    public Node m(int i11) {
        return this.f59932e.getNode(i11);
    }

    public Node n(String str) {
        return this.f59932e.getNode(str);
    }

    public Node o(String str) {
        return this.f59932e.getEndsWith(str);
    }

    public String p(String str) {
        Node n11 = n(str);
        return n11 != null ? n11.t() : "";
    }

    public Node q() {
        return this.f59928a;
    }

    public Node r() {
        Node node = null;
        for (Node q11 = q(); q11 != null; q11 = q11.q()) {
            node = q11;
        }
        return node;
    }

    public Object s() {
        return this.f59933f;
    }

    public String t() {
        return this.f59930c;
    }

    public String toString() {
        return H("utf-8", true);
    }

    public boolean u() {
        return k() > 0;
    }

    public void v(Node node, int i11) {
        node.D(this);
        this.f59932e.insertElementAt(node, i11);
    }

    public void w(PrintWriter printWriter, int i11, boolean z11) {
        String h11 = h(i11);
        String l11 = l();
        String t11 = t();
        if (!u() || !z11) {
            printWriter.print(String.valueOf(h11) + "<" + l11);
            x(printWriter);
            if (t11 == null || t11.length() == 0) {
                printWriter.println("></" + l11 + ">");
                return;
            }
            printWriter.println(">" + XML.a(t11) + "</" + l11 + ">");
            return;
        }
        printWriter.print(String.valueOf(h11) + "<" + l11);
        x(printWriter);
        printWriter.println(">");
        int k11 = k();
        for (int i12 = 0; i12 < k11; i12++) {
            m(i12).w(printWriter, i11 + 1, true);
        }
        printWriter.println(String.valueOf(h11) + "</" + l11 + ">");
    }

    public void x(PrintWriter printWriter) {
        int j11 = j();
        for (int i11 = 0; i11 < j11; i11++) {
            Attribute e11 = e(i11);
            printWriter.print(" " + e11.a() + "=\"" + XML.a(e11.b()) + "\"");
        }
    }

    public void y(String str, String str2) {
        Attribute f11 = f(str);
        if (f11 != null) {
            f11.d(str2);
        } else {
            b(new Attribute(str, str2));
        }
    }

    public void z(String str) {
        this.f59929b = str;
    }

    public Node(String str) {
        this();
        z(str);
    }
}
