package org.commonmark.node;

import a20.a;

public class Image extends Node {

    /* renamed from: f  reason: collision with root package name */
    public String f59768f;

    /* renamed from: g  reason: collision with root package name */
    public String f59769g;

    public Image() {
    }

    public void a(a aVar) {
        aVar.x(this);
    }

    public String k() {
        return "destination=" + this.f59768f + ", title=" + this.f59769g;
    }

    public String m() {
        return this.f59768f;
    }

    public Image(String str, String str2) {
        this.f59768f = str;
        this.f59769g = str2;
    }
}
