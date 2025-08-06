package org.commonmark.internal;

import d20.b;
import org.commonmark.node.Text;

public class d implements b {

    /* renamed from: a  reason: collision with root package name */
    public final Text f59689a;

    /* renamed from: b  reason: collision with root package name */
    public final char f59690b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f59691c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f59692d;

    /* renamed from: e  reason: collision with root package name */
    public d f59693e;

    /* renamed from: f  reason: collision with root package name */
    public d f59694f;

    /* renamed from: g  reason: collision with root package name */
    public int f59695g = 1;

    /* renamed from: h  reason: collision with root package name */
    public int f59696h = 1;

    public d(Text text, char c11, boolean z11, boolean z12, d dVar) {
        this.f59689a = text;
        this.f59690b = c11;
        this.f59691c = z11;
        this.f59692d = z12;
        this.f59693e = dVar;
    }

    public boolean a() {
        return this.f59692d;
    }

    public int b() {
        return this.f59696h;
    }

    public boolean c() {
        return this.f59691c;
    }

    public int length() {
        return this.f59695g;
    }
}
