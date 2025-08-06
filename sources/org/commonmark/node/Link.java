package org.commonmark.node;

import a20.a;

public class Link extends Node {

    /* renamed from: f  reason: collision with root package name */
    public String f59771f;

    /* renamed from: g  reason: collision with root package name */
    public String f59772g;

    public Link() {
    }

    public void a(a aVar) {
        aVar.m(this);
    }

    public String k() {
        return "destination=" + this.f59771f + ", title=" + this.f59772g;
    }

    public String m() {
        return this.f59771f;
    }

    public Link(String str, String str2) {
        this.f59771f = str;
        this.f59772g = str2;
    }
}
