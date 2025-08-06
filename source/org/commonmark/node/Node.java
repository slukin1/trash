package org.commonmark.node;

import a20.a;

public abstract class Node {

    /* renamed from: a  reason: collision with root package name */
    public Node f59777a = null;

    /* renamed from: b  reason: collision with root package name */
    public Node f59778b = null;

    /* renamed from: c  reason: collision with root package name */
    public Node f59779c = null;

    /* renamed from: d  reason: collision with root package name */
    public Node f59780d = null;

    /* renamed from: e  reason: collision with root package name */
    public Node f59781e = null;

    public abstract void a(a aVar);

    public void b(Node node) {
        node.l();
        node.j(this);
        Node node2 = this.f59779c;
        if (node2 != null) {
            node2.f59781e = node;
            node.f59780d = node2;
            this.f59779c = node;
            return;
        }
        this.f59778b = node;
        this.f59779c = node;
    }

    public Node c() {
        return this.f59778b;
    }

    public Node d() {
        return this.f59779c;
    }

    public Node e() {
        return this.f59781e;
    }

    public Node f() {
        return this.f59777a;
    }

    public Node g() {
        return this.f59780d;
    }

    public void h(Node node) {
        node.l();
        Node node2 = this.f59781e;
        node.f59781e = node2;
        if (node2 != null) {
            node2.f59780d = node;
        }
        node.f59780d = this;
        this.f59781e = node;
        Node node3 = this.f59777a;
        node.f59777a = node3;
        if (node.f59781e == null) {
            node3.f59779c = node;
        }
    }

    public void i(Node node) {
        node.l();
        Node node2 = this.f59780d;
        node.f59780d = node2;
        if (node2 != null) {
            node2.f59781e = node;
        }
        node.f59781e = this;
        this.f59780d = node;
        Node node3 = this.f59777a;
        node.f59777a = node3;
        if (node.f59780d == null) {
            node3.f59778b = node;
        }
    }

    public void j(Node node) {
        this.f59777a = node;
    }

    public String k() {
        return "";
    }

    public void l() {
        Node node = this.f59780d;
        if (node != null) {
            node.f59781e = this.f59781e;
        } else {
            Node node2 = this.f59777a;
            if (node2 != null) {
                node2.f59778b = this.f59781e;
            }
        }
        Node node3 = this.f59781e;
        if (node3 != null) {
            node3.f59780d = node;
        } else {
            Node node4 = this.f59777a;
            if (node4 != null) {
                node4.f59779c = node;
            }
        }
        this.f59777a = null;
        this.f59781e = null;
        this.f59780d = null;
    }

    public String toString() {
        return getClass().getSimpleName() + "{" + k() + "}";
    }
}
