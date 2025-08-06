package org.commonmark.node;

import a20.a;

public class Text extends Node {

    /* renamed from: f  reason: collision with root package name */
    public String f59785f;

    public Text() {
    }

    public void a(a aVar) {
        aVar.v(this);
    }

    public String k() {
        return "literal=" + this.f59785f;
    }

    public String m() {
        return this.f59785f;
    }

    public void n(String str) {
        this.f59785f = str;
    }

    public Text(String str) {
        this.f59785f = str;
    }
}
