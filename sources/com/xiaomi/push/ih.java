package com.xiaomi.push;

import com.xiaomi.push.hx;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

public class ih extends hx {

    /* renamed from: b  reason: collision with root package name */
    private static int f52360b = 10000;

    /* renamed from: c  reason: collision with root package name */
    private static int f52361c = 10000;

    /* renamed from: d  reason: collision with root package name */
    private static int f52362d = 10000;

    /* renamed from: e  reason: collision with root package name */
    private static int f52363e = 10485760;

    /* renamed from: f  reason: collision with root package name */
    private static int f52364f = 104857600;

    public static class a extends hx.a {
        public a() {
            super(false, true);
        }

        public ib a(il ilVar) {
            ih ihVar = new ih(ilVar, this.f3241a, this.f52344b);
            int i11 = this.f52343a;
            if (i11 != 0) {
                ihVar.b(i11);
            }
            return ihVar;
        }

        public a(boolean z11, boolean z12, int i11) {
            super(z11, z12, i11);
        }
    }

    public ih(il ilVar, boolean z11, boolean z12) {
        super(ilVar, z11, z12);
    }

    /* renamed from: a  reason: collision with other method in class */
    public ia m2897a() {
        byte a11 = a();
        byte a12 = a();
        int a13 = a();
        if (a13 <= f52360b) {
            return new ia(a11, a12, a13);
        }
        throw new ic(3, "Thrift map size " + a13 + " out of range!");
    }

    public hz a() {
        byte a11 = a();
        int a12 = a();
        if (a12 <= f52361c) {
            return new hz(a11, a12);
        }
        throw new ic(3, "Thrift list size " + a12 + " out of range!");
    }

    /* renamed from: a  reason: collision with other method in class */
    public Cif m2898a() {
        byte a11 = a();
        int a12 = a();
        if (a12 <= f52362d) {
            return new Cif(a11, a12);
        }
        throw new ic(3, "Thrift set size " + a12 + " out of range!");
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m2899a() {
        int a11 = a();
        if (a11 > f52363e) {
            throw new ic(3, "Thrift string size " + a11 + " out of range!");
        } else if (this.f52355a.b() < a11) {
            return a(a11);
        } else {
            try {
                String str = new String(this.f52355a.a(), this.f52355a.a_(), a11, "UTF-8");
                this.f52355a.a(a11);
                return str;
            } catch (UnsupportedEncodingException unused) {
                throw new hv("JVM DOES NOT SUPPORT UTF-8");
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public ByteBuffer m2900a() {
        int a11 = a();
        if (a11 <= f52364f) {
            c(a11);
            if (this.f52355a.b() >= a11) {
                ByteBuffer wrap = ByteBuffer.wrap(this.f52355a.a(), this.f52355a.a_(), a11);
                this.f52355a.a(a11);
                return wrap;
            }
            byte[] bArr = new byte[a11];
            this.f52355a.b(bArr, 0, a11);
            return ByteBuffer.wrap(bArr);
        }
        throw new ic(3, "Thrift binary size " + a11 + " out of range!");
    }
}
