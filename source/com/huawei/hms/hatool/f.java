package com.huawei.hms.hatool;

import java.util.List;
import java.util.Map;

public class f implements g {

    /* renamed from: a  reason: collision with root package name */
    private byte[] f38147a;

    /* renamed from: b  reason: collision with root package name */
    private String f38148b;

    /* renamed from: c  reason: collision with root package name */
    private String f38149c;

    /* renamed from: d  reason: collision with root package name */
    private String f38150d;

    /* renamed from: e  reason: collision with root package name */
    private String f38151e;

    /* renamed from: f  reason: collision with root package name */
    private List<b1> f38152f;

    public f(byte[] bArr, String str, String str2, String str3, String str4, List<b1> list) {
        this.f38147a = (byte[]) bArr.clone();
        this.f38148b = str;
        this.f38149c = str2;
        this.f38151e = str3;
        this.f38150d = str4;
        this.f38152f = list;
    }

    private n0 a(Map<String, String> map) {
        return w.a(this.f38148b, this.f38147a, map);
    }

    private Map<String, String> a() {
        return k.b(this.f38149c, this.f38151e, this.f38150d);
    }

    private void b() {
        b0.c().a(new d1(this.f38152f, this.f38149c, this.f38150d, this.f38151e));
    }

    public void run() {
        v.c("hmsSdk", "send data running");
        int b11 = a(a()).b();
        if (b11 != 200) {
            b();
            return;
        }
        v.b("hmsSdk", "events PostRequest sendevent TYPE : %s, TAG : %s, resultCode: %d ,reqID:" + this.f38150d, this.f38151e, this.f38149c, Integer.valueOf(b11));
    }
}
