package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import f4.i;

public class c implements h {

    /* renamed from: a  reason: collision with root package name */
    public final b f63759a = new b();

    /* renamed from: b  reason: collision with root package name */
    public final f<a, Bitmap> f63760b = new f<>();

    public static class a implements i {

        /* renamed from: a  reason: collision with root package name */
        public final b f63761a;

        /* renamed from: b  reason: collision with root package name */
        public int f63762b;

        /* renamed from: c  reason: collision with root package name */
        public int f63763c;

        /* renamed from: d  reason: collision with root package name */
        public Bitmap.Config f63764d;

        public a(b bVar) {
            this.f63761a = bVar;
        }

        public void a() {
            this.f63761a.c(this);
        }

        public void b(int i11, int i12, Bitmap.Config config) {
            this.f63762b = i11;
            this.f63763c = i12;
            this.f63764d = config;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (this.f63762b == aVar.f63762b && this.f63763c == aVar.f63763c && this.f63764d == aVar.f63764d) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i11 = ((this.f63762b * 31) + this.f63763c) * 31;
            Bitmap.Config config = this.f63764d;
            return i11 + (config != null ? config.hashCode() : 0);
        }

        public String toString() {
            return c.f(this.f63762b, this.f63763c, this.f63764d);
        }
    }

    public static class b extends d<a> {
        /* renamed from: d */
        public a a() {
            return new a(this);
        }

        public a e(int i11, int i12, Bitmap.Config config) {
            a aVar = (a) b();
            aVar.b(i11, i12, config);
            return aVar;
        }
    }

    public static String f(int i11, int i12, Bitmap.Config config) {
        return "[" + i11 + "x" + i12 + "], " + config;
    }

    public static String g(Bitmap bitmap) {
        return f(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
    }

    public String a(int i11, int i12, Bitmap.Config config) {
        return f(i11, i12, config);
    }

    public int b(Bitmap bitmap) {
        return i.h(bitmap);
    }

    public void c(Bitmap bitmap) {
        this.f63760b.d(this.f63759a.e(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig()), bitmap);
    }

    public Bitmap d(int i11, int i12, Bitmap.Config config) {
        return this.f63760b.a(this.f63759a.e(i11, i12, config));
    }

    public String e(Bitmap bitmap) {
        return g(bitmap);
    }

    public Bitmap removeLast() {
        return this.f63760b.f();
    }

    public String toString() {
        return "AttributeStrategy:\n  " + this.f63760b;
    }
}
