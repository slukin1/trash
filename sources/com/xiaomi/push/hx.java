package com.xiaomi.push;

import com.google.common.base.Ascii;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

public class hx extends ib {

    /* renamed from: a  reason: collision with root package name */
    private static final ig f52335a = new ig();

    /* renamed from: a  reason: collision with other field name */
    public int f3236a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f3237a = false;

    /* renamed from: a  reason: collision with other field name */
    private byte[] f3238a = new byte[1];

    /* renamed from: b  reason: collision with root package name */
    public boolean f52336b = true;

    /* renamed from: b  reason: collision with other field name */
    private byte[] f3239b = new byte[2];

    /* renamed from: c  reason: collision with root package name */
    public boolean f52337c = false;

    /* renamed from: c  reason: collision with other field name */
    private byte[] f3240c = new byte[4];

    /* renamed from: d  reason: collision with root package name */
    private byte[] f52338d = new byte[8];

    /* renamed from: e  reason: collision with root package name */
    private byte[] f52339e = new byte[1];

    /* renamed from: f  reason: collision with root package name */
    private byte[] f52340f = new byte[2];

    /* renamed from: g  reason: collision with root package name */
    private byte[] f52341g = new byte[4];

    /* renamed from: h  reason: collision with root package name */
    private byte[] f52342h = new byte[8];

    public static class a implements id {

        /* renamed from: a  reason: collision with root package name */
        public int f52343a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f3241a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f52344b;

        public a() {
            this(false, true);
        }

        public ib a(il ilVar) {
            hx hxVar = new hx(ilVar, this.f3241a, this.f52344b);
            int i11 = this.f52343a;
            if (i11 != 0) {
                hxVar.b(i11);
            }
            return hxVar;
        }

        public a(boolean z11, boolean z12) {
            this(z11, z12, 0);
        }

        public a(boolean z11, boolean z12, int i11) {
            this.f3241a = false;
            this.f52344b = true;
            this.f3241a = z11;
            this.f52344b = z12;
            this.f52343a = i11;
        }
    }

    public hx(il ilVar, boolean z11, boolean z12) {
        super(ilVar);
        this.f3237a = z11;
        this.f52336b = z12;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m2874a() {
    }

    public void a(hy hyVar) {
        a(hyVar.f52345a);
        a(hyVar.f3243a);
    }

    public void a(ig igVar) {
    }

    public void b() {
    }

    public void b(int i11) {
        this.f3236a = i11;
        this.f52337c = true;
    }

    public void c() {
        a((byte) 0);
    }

    public void d() {
    }

    public void e() {
    }

    public void f() {
    }

    public void g() {
    }

    public void h() {
    }

    public void i() {
    }

    public void j() {
    }

    public void c(int i11) {
        if (i11 < 0) {
            throw new hv("Negative length: " + i11);
        } else if (this.f52337c) {
            int i12 = this.f3236a - i11;
            this.f3236a = i12;
            if (i12 < 0) {
                throw new hv("Message length exceeded: " + i11);
            }
        }
    }

    public void a(ia iaVar) {
        a(iaVar.f52353a);
        a(iaVar.f52354b);
        a(iaVar.f3247a);
    }

    public void a(hz hzVar) {
        a(hzVar.f52346a);
        a(hzVar.f3244a);
    }

    public void a(boolean z11) {
        a(z11 ? (byte) 1 : 0);
    }

    public void a(byte b11) {
        byte[] bArr = this.f3238a;
        bArr[0] = b11;
        this.f52355a.a(bArr, 0, 1);
    }

    public void a(short s11) {
        byte[] bArr = this.f3239b;
        bArr[0] = (byte) ((s11 >> 8) & 255);
        bArr[1] = (byte) (s11 & 255);
        this.f52355a.a(bArr, 0, 2);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m2875a(int i11) {
        byte[] bArr = this.f3240c;
        bArr[0] = (byte) ((i11 >> 24) & 255);
        bArr[1] = (byte) ((i11 >> 16) & 255);
        bArr[2] = (byte) ((i11 >> 8) & 255);
        bArr[3] = (byte) (i11 & 255);
        this.f52355a.a(bArr, 0, 4);
    }

    public void a(long j11) {
        byte[] bArr = this.f52338d;
        bArr[0] = (byte) ((int) ((j11 >> 56) & 255));
        bArr[1] = (byte) ((int) ((j11 >> 48) & 255));
        bArr[2] = (byte) ((int) ((j11 >> 40) & 255));
        bArr[3] = (byte) ((int) ((j11 >> 32) & 255));
        bArr[4] = (byte) ((int) ((j11 >> 24) & 255));
        bArr[5] = (byte) ((int) ((j11 >> 16) & 255));
        bArr[6] = (byte) ((int) ((j11 >> 8) & 255));
        bArr[7] = (byte) ((int) (j11 & 255));
        this.f52355a.a(bArr, 0, 8);
    }

    public void a(String str) {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            a(bytes.length);
            this.f52355a.a(bytes, 0, bytes.length);
        } catch (UnsupportedEncodingException unused) {
            throw new hv("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    public void a(ByteBuffer byteBuffer) {
        int limit = (byteBuffer.limit() - byteBuffer.position()) - byteBuffer.arrayOffset();
        a(limit);
        this.f52355a.a(byteBuffer.array(), byteBuffer.position() + byteBuffer.arrayOffset(), limit);
    }

    /* renamed from: a  reason: collision with other method in class */
    public ig m2870a() {
        return f52335a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public hy m2866a() {
        short s11;
        byte a11 = a();
        if (a11 == 0) {
            s11 = 0;
        } else {
            s11 = a();
        }
        return new hy("", a11, s11);
    }

    /* renamed from: a  reason: collision with other method in class */
    public ia m2868a() {
        return new ia(a(), a(), a());
    }

    /* renamed from: a  reason: collision with other method in class */
    public hz m2867a() {
        return new hz(a(), a());
    }

    /* renamed from: a  reason: collision with other method in class */
    public Cif m2869a() {
        return new Cif(a(), a());
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m2876a() {
        return a() == 1;
    }

    public byte a() {
        if (this.f52355a.b() >= 1) {
            byte b11 = this.f52355a.a()[this.f52355a.a_()];
            this.f52355a.a(1);
            return b11;
        }
        a(this.f52339e, 0, 1);
        return this.f52339e[0];
    }

    /* renamed from: a  reason: collision with other method in class */
    public short m2873a() {
        byte[] bArr = this.f52340f;
        int i11 = 0;
        if (this.f52355a.b() >= 2) {
            bArr = this.f52355a.a();
            i11 = this.f52355a.a_();
            this.f52355a.a(2);
        } else {
            a(this.f52340f, 0, 2);
        }
        return (short) ((bArr[i11 + 1] & 255) | ((bArr[i11] & 255) << 8));
    }

    /* renamed from: a  reason: collision with other method in class */
    public int m2864a() {
        byte[] bArr = this.f52341g;
        int i11 = 0;
        if (this.f52355a.b() >= 4) {
            bArr = this.f52355a.a();
            i11 = this.f52355a.a_();
            this.f52355a.a(4);
        } else {
            a(this.f52341g, 0, 4);
        }
        return (bArr[i11 + 3] & 255) | ((bArr[i11] & 255) << Ascii.CAN) | ((bArr[i11 + 1] & 255) << 16) | ((bArr[i11 + 2] & 255) << 8);
    }

    /* renamed from: a  reason: collision with other method in class */
    public long m2865a() {
        byte[] bArr = this.f52342h;
        int i11 = 0;
        if (this.f52355a.b() >= 8) {
            bArr = this.f52355a.a();
            i11 = this.f52355a.a_();
            this.f52355a.a(8);
        } else {
            a(this.f52342h, 0, 8);
        }
        return ((long) (bArr[i11 + 7] & 255)) | (((long) (bArr[i11] & 255)) << 56) | (((long) (bArr[i11 + 1] & 255)) << 48) | (((long) (bArr[i11 + 2] & 255)) << 40) | (((long) (bArr[i11 + 3] & 255)) << 32) | (((long) (bArr[i11 + 4] & 255)) << 24) | (((long) (bArr[i11 + 5] & 255)) << 16) | (((long) (bArr[i11 + 6] & 255)) << 8);
    }

    /* renamed from: a  reason: collision with other method in class */
    public double m2863a() {
        return Double.longBitsToDouble(a());
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m2871a() {
        int a11 = a();
        if (this.f52355a.b() < a11) {
            return a(a11);
        }
        try {
            String str = new String(this.f52355a.a(), this.f52355a.a_(), a11, "UTF-8");
            this.f52355a.a(a11);
            return str;
        } catch (UnsupportedEncodingException unused) {
            throw new hv("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    public String a(int i11) {
        try {
            c(i11);
            byte[] bArr = new byte[i11];
            this.f52355a.b(bArr, 0, i11);
            return new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            throw new hv("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public ByteBuffer m2872a() {
        int a11 = a();
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

    private int a(byte[] bArr, int i11, int i12) {
        c(i12);
        return this.f52355a.b(bArr, i11, i12);
    }
}
