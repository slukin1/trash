package com.huobi.lite.kyc.aliface;

import android.content.Context;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public b f75377a;

    /* renamed from: b  reason: collision with root package name */
    public AbstractCertificate f75378b;

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public AbstractCertificate f75379a;

        /* renamed from: b  reason: collision with root package name */
        public gn.a f75380b;

        /* renamed from: c  reason: collision with root package name */
        public String f75381c;

        /* renamed from: d  reason: collision with root package name */
        public Context f75382d;

        /* renamed from: e  reason: collision with root package name */
        public String f75383e;

        public b(Context context) {
            this.f75382d = context;
        }

        public a e() {
            return new a(this);
        }

        public String f() {
            return this.f75383e;
        }

        public Context g() {
            return this.f75382d;
        }

        public gn.a h() {
            return this.f75380b;
        }

        public String i() {
            return this.f75381c;
        }

        public b j(AbstractCertificate abstractCertificate) {
            if (abstractCertificate != null) {
                this.f75379a = abstractCertificate;
            }
            return this;
        }

        public b k(String str) {
            this.f75383e = str;
            return this;
        }

        public b l(gn.a aVar) {
            this.f75380b = aVar;
            return this;
        }

        public b m(String str) {
            this.f75381c = str;
            return this;
        }
    }

    public void a() {
        b bVar;
        if (!this.f75378b.f75372b && (bVar = this.f75377a) != null && bVar.f75382d != null && this.f75377a.f75380b != null && this.f75377a.f75381c != null && this.f75377a.f75379a != null) {
            this.f75378b.a(this.f75377a);
        }
    }

    public a(b bVar) {
        this.f75377a = bVar;
        this.f75378b = bVar.f75379a;
    }
}
