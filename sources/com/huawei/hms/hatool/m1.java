package com.huawei.hms.hatool;

import com.huawei.secure.android.common.encrypt.utils.EncryptUtil;

public class m1 {

    /* renamed from: b  reason: collision with root package name */
    private static m1 f38230b = new m1();
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public a f38231a = new a();

    public class a {

        /* renamed from: a  reason: collision with root package name */
        public String f38232a;

        /* renamed from: b  reason: collision with root package name */
        public String f38233b;

        /* renamed from: c  reason: collision with root package name */
        public long f38234c = 0;

        public a() {
        }

        public void a(long j11) {
            m1.this.f38231a.f38234c = j11;
        }

        public void a(String str) {
            m1.this.f38231a.f38233b = str;
        }

        public void b(String str) {
            m1.this.f38231a.f38232a = str;
        }
    }

    public static m1 d() {
        return f38230b;
    }

    public String a() {
        return this.f38231a.f38233b;
    }

    public void a(String str, String str2) {
        long b11 = b();
        String c11 = w0.c(str, str2);
        if (c11 == null || c11.isEmpty()) {
            v.e("WorkKeyHandler", "get rsa pubkey config error");
            return;
        }
        if (b11 == 0) {
            b11 = System.currentTimeMillis();
        } else if (System.currentTimeMillis() - b11 <= 43200000) {
            return;
        }
        String d11 = EncryptUtil.d(16);
        String a11 = h0.a(c11, d11);
        this.f38231a.a(b11);
        this.f38231a.b(d11);
        this.f38231a.a(a11);
    }

    public long b() {
        return this.f38231a.f38234c;
    }

    public String c() {
        return this.f38231a.f38232a;
    }
}
