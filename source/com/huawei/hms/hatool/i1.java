package com.huawei.hms.hatool;

import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.UUID;

public class i1 {

    /* renamed from: a  reason: collision with root package name */
    private String f38184a;

    /* renamed from: b  reason: collision with root package name */
    private String f38185b;

    /* renamed from: c  reason: collision with root package name */
    private String f38186c;

    /* renamed from: d  reason: collision with root package name */
    private String f38187d;

    /* renamed from: e  reason: collision with root package name */
    private long f38188e;

    public i1(String str, String str2, String str3, String str4, long j11) {
        this.f38184a = str;
        this.f38185b = str2;
        this.f38186c = str3;
        this.f38187d = str4;
        this.f38188e = j11;
    }

    public void a() {
        v.c("StreamEventHandler", "Begin to handle stream events...");
        b1 b1Var = new b1();
        b1Var.b(this.f38186c);
        b1Var.d(this.f38185b);
        b1Var.a(this.f38187d);
        b1Var.c(String.valueOf(this.f38188e));
        if ("oper".equals(this.f38185b) && z.i(this.f38184a, "oper")) {
            p0 a11 = y.a().a(this.f38184a, this.f38188e);
            String a12 = a11.a();
            Boolean valueOf = Boolean.valueOf(a11.b());
            b1Var.f(a12);
            b1Var.e(String.valueOf(valueOf));
        }
        String replace = UUID.randomUUID().toString().replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, "");
        ArrayList arrayList = new ArrayList();
        arrayList.add(b1Var);
        new l0(this.f38184a, this.f38185b, q0.g(), arrayList, replace).a();
    }
}
