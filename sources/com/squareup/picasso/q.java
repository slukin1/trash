package com.squareup.picasso;

import android.graphics.Bitmap;
import android.net.Uri;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public final class q {

    /* renamed from: u  reason: collision with root package name */
    public static final long f30081u = TimeUnit.SECONDS.toNanos(5);

    /* renamed from: a  reason: collision with root package name */
    public int f30082a;

    /* renamed from: b  reason: collision with root package name */
    public long f30083b;

    /* renamed from: c  reason: collision with root package name */
    public int f30084c;

    /* renamed from: d  reason: collision with root package name */
    public final Uri f30085d;

    /* renamed from: e  reason: collision with root package name */
    public final int f30086e;

    /* renamed from: f  reason: collision with root package name */
    public final String f30087f;

    /* renamed from: g  reason: collision with root package name */
    public final List<x> f30088g;

    /* renamed from: h  reason: collision with root package name */
    public final int f30089h;

    /* renamed from: i  reason: collision with root package name */
    public final int f30090i;

    /* renamed from: j  reason: collision with root package name */
    public final boolean f30091j;

    /* renamed from: k  reason: collision with root package name */
    public final int f30092k;

    /* renamed from: l  reason: collision with root package name */
    public final boolean f30093l;

    /* renamed from: m  reason: collision with root package name */
    public final boolean f30094m;

    /* renamed from: n  reason: collision with root package name */
    public final float f30095n;

    /* renamed from: o  reason: collision with root package name */
    public final float f30096o;

    /* renamed from: p  reason: collision with root package name */
    public final float f30097p;

    /* renamed from: q  reason: collision with root package name */
    public final boolean f30098q;

    /* renamed from: r  reason: collision with root package name */
    public final boolean f30099r;

    /* renamed from: s  reason: collision with root package name */
    public final Bitmap.Config f30100s;

    /* renamed from: t  reason: collision with root package name */
    public final Picasso.Priority f30101t;

    public String a() {
        Uri uri = this.f30085d;
        if (uri != null) {
            return String.valueOf(uri.getPath());
        }
        return Integer.toHexString(this.f30086e);
    }

    public boolean b() {
        return this.f30088g != null;
    }

    public boolean c() {
        return (this.f30089h == 0 && this.f30090i == 0) ? false : true;
    }

    public String d() {
        long nanoTime = System.nanoTime() - this.f30083b;
        if (nanoTime > f30081u) {
            return g() + '+' + TimeUnit.NANOSECONDS.toSeconds(nanoTime) + 's';
        }
        return g() + '+' + TimeUnit.NANOSECONDS.toMillis(nanoTime) + "ms";
    }

    public boolean e() {
        return c() || this.f30095n != 0.0f;
    }

    public boolean f() {
        return e() || b();
    }

    public String g() {
        return "[R" + this.f30082a + ']';
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("Request{");
        int i11 = this.f30086e;
        if (i11 > 0) {
            sb2.append(i11);
        } else {
            sb2.append(this.f30085d);
        }
        List<x> list = this.f30088g;
        if (list != null && !list.isEmpty()) {
            for (x key : this.f30088g) {
                sb2.append(' ');
                sb2.append(key.key());
            }
        }
        if (this.f30087f != null) {
            sb2.append(" stableKey(");
            sb2.append(this.f30087f);
            sb2.append(')');
        }
        if (this.f30089h > 0) {
            sb2.append(" resize(");
            sb2.append(this.f30089h);
            sb2.append(',');
            sb2.append(this.f30090i);
            sb2.append(')');
        }
        if (this.f30091j) {
            sb2.append(" centerCrop");
        }
        if (this.f30093l) {
            sb2.append(" centerInside");
        }
        if (this.f30095n != 0.0f) {
            sb2.append(" rotation(");
            sb2.append(this.f30095n);
            if (this.f30098q) {
                sb2.append(" @ ");
                sb2.append(this.f30096o);
                sb2.append(',');
                sb2.append(this.f30097p);
            }
            sb2.append(')');
        }
        if (this.f30099r) {
            sb2.append(" purgeable");
        }
        if (this.f30100s != null) {
            sb2.append(' ');
            sb2.append(this.f30100s);
        }
        sb2.append('}');
        return sb2.toString();
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public Uri f30102a;

        /* renamed from: b  reason: collision with root package name */
        public int f30103b;

        /* renamed from: c  reason: collision with root package name */
        public String f30104c;

        /* renamed from: d  reason: collision with root package name */
        public int f30105d;

        /* renamed from: e  reason: collision with root package name */
        public int f30106e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f30107f;

        /* renamed from: g  reason: collision with root package name */
        public int f30108g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f30109h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f30110i;

        /* renamed from: j  reason: collision with root package name */
        public float f30111j;

        /* renamed from: k  reason: collision with root package name */
        public float f30112k;

        /* renamed from: l  reason: collision with root package name */
        public float f30113l;

        /* renamed from: m  reason: collision with root package name */
        public boolean f30114m;

        /* renamed from: n  reason: collision with root package name */
        public boolean f30115n;

        /* renamed from: o  reason: collision with root package name */
        public List<x> f30116o;

        /* renamed from: p  reason: collision with root package name */
        public Bitmap.Config f30117p;

        /* renamed from: q  reason: collision with root package name */
        public Picasso.Priority f30118q;

        public b(Uri uri) {
            f(uri);
        }

        public q a() {
            boolean z11 = this.f30109h;
            if (z11 && this.f30107f) {
                throw new IllegalStateException("Center crop and center inside can not be used together.");
            } else if (this.f30107f && this.f30105d == 0 && this.f30106e == 0) {
                throw new IllegalStateException("Center crop requires calling resize with positive width and height.");
            } else if (z11 && this.f30105d == 0 && this.f30106e == 0) {
                throw new IllegalStateException("Center inside requires calling resize with positive width and height.");
            } else {
                if (this.f30118q == null) {
                    this.f30118q = Picasso.Priority.NORMAL;
                }
                q qVar = r2;
                q qVar2 = new q(this.f30102a, this.f30103b, this.f30104c, this.f30116o, this.f30105d, this.f30106e, this.f30107f, this.f30109h, this.f30108g, this.f30110i, this.f30111j, this.f30112k, this.f30113l, this.f30114m, this.f30115n, this.f30117p, this.f30118q);
                return qVar;
            }
        }

        public b b(int i11) {
            if (!this.f30109h) {
                this.f30107f = true;
                this.f30108g = i11;
                return this;
            }
            throw new IllegalStateException("Center crop can not be used after calling centerInside");
        }

        public boolean c() {
            return (this.f30102a == null && this.f30103b == 0) ? false : true;
        }

        public boolean d() {
            return (this.f30105d == 0 && this.f30106e == 0) ? false : true;
        }

        public b e(int i11, int i12) {
            if (i11 < 0) {
                throw new IllegalArgumentException("Width must be positive number or 0.");
            } else if (i12 < 0) {
                throw new IllegalArgumentException("Height must be positive number or 0.");
            } else if (i12 == 0 && i11 == 0) {
                throw new IllegalArgumentException("At least one dimension has to be positive number.");
            } else {
                this.f30105d = i11;
                this.f30106e = i12;
                return this;
            }
        }

        public b f(Uri uri) {
            if (uri != null) {
                this.f30102a = uri;
                this.f30103b = 0;
                return this;
            }
            throw new IllegalArgumentException("Image URI may not be null.");
        }

        public b g(x xVar) {
            if (xVar == null) {
                throw new IllegalArgumentException("Transformation must not be null.");
            } else if (xVar.key() != null) {
                if (this.f30116o == null) {
                    this.f30116o = new ArrayList(2);
                }
                this.f30116o.add(xVar);
                return this;
            } else {
                throw new IllegalArgumentException("Transformation key must not be null.");
            }
        }

        public b(Uri uri, int i11, Bitmap.Config config) {
            this.f30102a = uri;
            this.f30103b = i11;
            this.f30117p = config;
        }
    }

    public q(Uri uri, int i11, String str, List<x> list, int i12, int i13, boolean z11, boolean z12, int i14, boolean z13, float f11, float f12, float f13, boolean z14, boolean z15, Bitmap.Config config, Picasso.Priority priority) {
        this.f30085d = uri;
        this.f30086e = i11;
        this.f30087f = str;
        if (list == null) {
            this.f30088g = null;
        } else {
            this.f30088g = Collections.unmodifiableList(list);
        }
        this.f30089h = i12;
        this.f30090i = i13;
        this.f30091j = z11;
        this.f30093l = z12;
        this.f30092k = i14;
        this.f30094m = z13;
        this.f30095n = f11;
        this.f30096o = f12;
        this.f30097p = f13;
        this.f30098q = z14;
        this.f30099r = z15;
        this.f30100s = config;
        this.f30101t = priority;
    }
}
