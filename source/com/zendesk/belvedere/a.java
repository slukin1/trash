package com.zendesk.belvedere;

import android.content.Context;
import iz.b;
import iz.f;
import java.util.Arrays;
import java.util.TreeSet;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f52750a;

    /* renamed from: b  reason: collision with root package name */
    public int f52751b;

    /* renamed from: c  reason: collision with root package name */
    public int f52752c;

    /* renamed from: d  reason: collision with root package name */
    public int f52753d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f52754e;

    /* renamed from: f  reason: collision with root package name */
    public String f52755f;

    /* renamed from: g  reason: collision with root package name */
    public b f52756g;

    /* renamed from: h  reason: collision with root package name */
    public TreeSet<BelvedereSource> f52757h;

    /* renamed from: com.zendesk.belvedere.a$a  reason: collision with other inner class name */
    public static class C0643a {

        /* renamed from: a  reason: collision with root package name */
        public Context f52758a;

        /* renamed from: b  reason: collision with root package name */
        public String f52759b = "belvedere-data";

        /* renamed from: c  reason: collision with root package name */
        public int f52760c = 1602;

        /* renamed from: d  reason: collision with root package name */
        public int f52761d = 1603;

        /* renamed from: e  reason: collision with root package name */
        public int f52762e = 1653;

        /* renamed from: f  reason: collision with root package name */
        public boolean f52763f = true;

        /* renamed from: g  reason: collision with root package name */
        public String f52764g = "*/*";

        /* renamed from: h  reason: collision with root package name */
        public b f52765h = new f();

        /* renamed from: i  reason: collision with root package name */
        public boolean f52766i = false;

        /* renamed from: j  reason: collision with root package name */
        public TreeSet<BelvedereSource> f52767j = new TreeSet<>(Arrays.asList(new BelvedereSource[]{BelvedereSource.Camera, BelvedereSource.Gallery}));

        public C0643a(Context context) {
            this.f52758a = context;
        }

        public Belvedere i() {
            this.f52765h.a(this.f52766i);
            return new Belvedere(this.f52758a, new a(this));
        }

        public C0643a j(boolean z11) {
            this.f52763f = z11;
            return this;
        }

        public C0643a k(String str) {
            this.f52764g = str;
            return this;
        }

        public C0643a l(boolean z11) {
            this.f52766i = z11;
            return this;
        }
    }

    public a(C0643a aVar) {
        this.f52750a = aVar.f52759b;
        this.f52751b = aVar.f52760c;
        this.f52752c = aVar.f52761d;
        this.f52753d = aVar.f52762e;
        this.f52754e = aVar.f52763f;
        this.f52755f = aVar.f52764g;
        this.f52756g = aVar.f52765h;
        this.f52757h = aVar.f52767j;
    }

    public boolean a() {
        return this.f52754e;
    }

    public b b() {
        return this.f52756g;
    }

    public TreeSet<BelvedereSource> c() {
        return this.f52757h;
    }

    public int d() {
        return this.f52753d;
    }

    public int e() {
        return this.f52752c;
    }

    public String f() {
        return this.f52755f;
    }

    public String g() {
        return this.f52750a;
    }

    public int h() {
        return this.f52751b;
    }
}
