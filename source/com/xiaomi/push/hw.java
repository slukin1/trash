package com.xiaomi.push;

import com.xiaomi.push.hx;
import java.io.ByteArrayOutputStream;

public class hw {

    /* renamed from: a  reason: collision with root package name */
    private ib f52334a;

    /* renamed from: a  reason: collision with other field name */
    private final ii f3234a;

    /* renamed from: a  reason: collision with other field name */
    private final ByteArrayOutputStream f3235a;

    public hw() {
        this(new hx.a());
    }

    public byte[] a(hr hrVar) {
        this.f3235a.reset();
        hrVar.b(this.f52334a);
        return this.f3235a.toByteArray();
    }

    public hw(id idVar) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        this.f3235a = byteArrayOutputStream;
        ii iiVar = new ii(byteArrayOutputStream);
        this.f3234a = iiVar;
        this.f52334a = idVar.a(iiVar);
    }
}
