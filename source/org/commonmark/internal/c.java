package org.commonmark.internal;

import org.commonmark.node.Text;

public class c {

    /* renamed from: a  reason: collision with root package name */
    public final Text f59682a;

    /* renamed from: b  reason: collision with root package name */
    public final int f59683b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f59684c;

    /* renamed from: d  reason: collision with root package name */
    public final c f59685d;

    /* renamed from: e  reason: collision with root package name */
    public final d f59686e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f59687f = true;

    /* renamed from: g  reason: collision with root package name */
    public boolean f59688g = false;

    public c(Text text, int i11, c cVar, d dVar, boolean z11) {
        this.f59682a = text;
        this.f59683b = i11;
        this.f59684c = z11;
        this.f59685d = cVar;
        this.f59686e = dVar;
    }

    public static c a(Text text, int i11, c cVar, d dVar) {
        return new c(text, i11, cVar, dVar, true);
    }

    public static c b(Text text, int i11, c cVar, d dVar) {
        return new c(text, i11, cVar, dVar, false);
    }
}
