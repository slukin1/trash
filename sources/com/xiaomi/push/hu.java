package com.xiaomi.push;

import com.xiaomi.push.hx;

public class hu {

    /* renamed from: a  reason: collision with root package name */
    private final ib f52333a;

    /* renamed from: a  reason: collision with other field name */
    private final ik f3233a;

    public hu() {
        this(new hx.a());
    }

    public void a(hr hrVar, byte[] bArr) {
        try {
            this.f3233a.a(bArr);
            hrVar.a(this.f52333a);
        } finally {
            this.f52333a.k();
        }
    }

    public hu(id idVar) {
        ik ikVar = new ik();
        this.f3233a = ikVar;
        this.f52333a = idVar.a(ikVar);
    }
}
