package com.xiaomi.push;

import android.os.Bundle;
import java.util.Objects;

public class fr extends fp {

    /* renamed from: a  reason: collision with root package name */
    private int f51828a = Integer.MIN_VALUE;

    /* renamed from: a  reason: collision with other field name */
    private a f2878a = null;

    /* renamed from: a  reason: collision with other field name */
    private b f2879a = b.available;

    /* renamed from: b  reason: collision with root package name */
    private String f51829b = null;

    public enum a {
        chat,
        available,
        away,
        xa,
        dnd
    }

    public enum b {
        available,
        unavailable,
        subscribe,
        subscribed,
        unsubscribe,
        unsubscribed,
        error,
        probe
    }

    public fr(b bVar) {
        a(bVar);
    }

    public Bundle a() {
        Bundle a11 = super.a();
        b bVar = this.f2879a;
        if (bVar != null) {
            a11.putString("ext_pres_type", bVar.toString());
        }
        String str = this.f51829b;
        if (str != null) {
            a11.putString("ext_pres_status", str);
        }
        int i11 = this.f51828a;
        if (i11 != Integer.MIN_VALUE) {
            a11.putInt("ext_pres_prio", i11);
        }
        a aVar = this.f2878a;
        if (!(aVar == null || aVar == a.available)) {
            a11.putString("ext_pres_mode", aVar.toString());
        }
        return a11;
    }

    public fr(Bundle bundle) {
        super(bundle);
        if (bundle.containsKey("ext_pres_type")) {
            this.f2879a = b.valueOf(bundle.getString("ext_pres_type"));
        }
        if (bundle.containsKey("ext_pres_status")) {
            this.f51829b = bundle.getString("ext_pres_status");
        }
        if (bundle.containsKey("ext_pres_prio")) {
            this.f51828a = bundle.getInt("ext_pres_prio");
        }
        if (bundle.containsKey("ext_pres_mode")) {
            this.f2878a = a.valueOf(bundle.getString("ext_pres_mode"));
        }
    }

    public void a(b bVar) {
        Objects.requireNonNull(bVar, "Type cannot be null");
        this.f2879a = bVar;
    }

    public void a(String str) {
        this.f51829b = str;
    }

    public void a(int i11) {
        if (i11 < -128 || i11 > 128) {
            throw new IllegalArgumentException("Priority value " + i11 + " is not valid. Valid range is -128 through 128.");
        }
        this.f51828a = i11;
    }

    public void a(a aVar) {
        this.f2878a = aVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m2699a() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("<presence");
        if (p() != null) {
            sb2.append(" xmlns=\"");
            sb2.append(p());
            sb2.append("\"");
        }
        if (j() != null) {
            sb2.append(" id=\"");
            sb2.append(j());
            sb2.append("\"");
        }
        if (l() != null) {
            sb2.append(" to=\"");
            sb2.append(fy.a(l()));
            sb2.append("\"");
        }
        if (m() != null) {
            sb2.append(" from=\"");
            sb2.append(fy.a(m()));
            sb2.append("\"");
        }
        if (k() != null) {
            sb2.append(" chid=\"");
            sb2.append(fy.a(k()));
            sb2.append("\"");
        }
        if (this.f2879a != null) {
            sb2.append(" type=\"");
            sb2.append(this.f2879a);
            sb2.append("\"");
        }
        sb2.append(">");
        if (this.f51829b != null) {
            sb2.append("<status>");
            sb2.append(fy.a(this.f51829b));
            sb2.append("</status>");
        }
        if (this.f51828a != Integer.MIN_VALUE) {
            sb2.append("<priority>");
            sb2.append(this.f51828a);
            sb2.append("</priority>");
        }
        a aVar = this.f2878a;
        if (!(aVar == null || aVar == a.available)) {
            sb2.append("<show>");
            sb2.append(this.f2878a);
            sb2.append("</show>");
        }
        sb2.append(o());
        ft a11 = a();
        if (a11 != null) {
            sb2.append(a11.a());
        }
        sb2.append("</presence>");
        return sb2.toString();
    }
}
