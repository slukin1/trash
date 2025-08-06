package org.cybergarage.upnp.event;

import java.net.URL;

public class Subscriber {

    /* renamed from: a  reason: collision with root package name */
    public String f59877a = null;

    /* renamed from: b  reason: collision with root package name */
    public String f59878b = "";

    /* renamed from: c  reason: collision with root package name */
    public String f59879c = "";

    /* renamed from: d  reason: collision with root package name */
    public String f59880d = "";

    /* renamed from: e  reason: collision with root package name */
    public String f59881e = "";

    /* renamed from: f  reason: collision with root package name */
    public int f59882f = 0;

    /* renamed from: g  reason: collision with root package name */
    public long f59883g = 0;

    /* renamed from: h  reason: collision with root package name */
    public long f59884h = 0;

    /* renamed from: i  reason: collision with root package name */
    public long f59885i = 0;

    public Subscriber() {
        k();
    }

    public String a() {
        return this.f59880d;
    }

    public String b() {
        return this.f59881e;
    }

    public int c() {
        return this.f59882f;
    }

    public String d() {
        return this.f59879c;
    }

    public long e() {
        return this.f59885i;
    }

    public String f() {
        return this.f59877a;
    }

    public long g() {
        return this.f59884h;
    }

    public long h() {
        return this.f59883g;
    }

    public void i() {
        long j11 = this.f59885i;
        if (j11 == Long.MAX_VALUE) {
            this.f59885i = 1;
        } else {
            this.f59885i = j11 + 1;
        }
    }

    public boolean j() {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.f59883g != -1 && g() + (h() * 1000) < currentTimeMillis) {
            return true;
        }
        return false;
    }

    public void k() {
        o(System.currentTimeMillis());
        m(0);
    }

    public void l(String str) {
        this.f59879c = str;
        try {
            URL url = new URL(str);
            this.f59880d = url.getHost();
            this.f59881e = url.getPath();
            this.f59882f = url.getPort();
        } catch (Exception unused) {
        }
    }

    public void m(int i11) {
        this.f59885i = (long) i11;
    }

    public void n(String str) {
        this.f59877a = str;
    }

    public void o(long j11) {
        this.f59884h = j11;
    }

    public void p(long j11) {
        this.f59883g = j11;
    }
}
