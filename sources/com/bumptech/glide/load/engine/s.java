package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.e;
import com.bumptech.glide.load.model.d;
import java.io.File;
import java.util.List;
import n3.b;
import o3.d;

public class s implements e, d.a<Object> {

    /* renamed from: b  reason: collision with root package name */
    public final e.a f63914b;

    /* renamed from: c  reason: collision with root package name */
    public final f<?> f63915c;

    /* renamed from: d  reason: collision with root package name */
    public int f63916d;

    /* renamed from: e  reason: collision with root package name */
    public int f63917e = -1;

    /* renamed from: f  reason: collision with root package name */
    public b f63918f;

    /* renamed from: g  reason: collision with root package name */
    public List<com.bumptech.glide.load.model.d<File, ?>> f63919g;

    /* renamed from: h  reason: collision with root package name */
    public int f63920h;

    /* renamed from: i  reason: collision with root package name */
    public volatile d.a<?> f63921i;

    /* renamed from: j  reason: collision with root package name */
    public File f63922j;

    /* renamed from: k  reason: collision with root package name */
    public t f63923k;

    public s(f<?> fVar, e.a aVar) {
        this.f63915c = fVar;
        this.f63914b = aVar;
    }

    public boolean a() {
        List<b> c11 = this.f63915c.c();
        boolean z11 = false;
        if (c11.isEmpty()) {
            return false;
        }
        List<Class<?>> m11 = this.f63915c.m();
        if (!m11.isEmpty()) {
            while (true) {
                if (this.f63919g == null || !b()) {
                    int i11 = this.f63917e + 1;
                    this.f63917e = i11;
                    if (i11 >= m11.size()) {
                        int i12 = this.f63916d + 1;
                        this.f63916d = i12;
                        if (i12 >= c11.size()) {
                            return false;
                        }
                        this.f63917e = 0;
                    }
                    b bVar = c11.get(this.f63916d);
                    Class cls = m11.get(this.f63917e);
                    this.f63923k = new t(this.f63915c.b(), bVar, this.f63915c.o(), this.f63915c.s(), this.f63915c.f(), this.f63915c.r(cls), cls, this.f63915c.k());
                    File a11 = this.f63915c.d().a(this.f63923k);
                    this.f63922j = a11;
                    if (a11 != null) {
                        this.f63918f = bVar;
                        this.f63919g = this.f63915c.j(a11);
                        this.f63920h = 0;
                    }
                } else {
                    this.f63921i = null;
                    while (!z11 && b()) {
                        List<com.bumptech.glide.load.model.d<File, ?>> list = this.f63919g;
                        int i13 = this.f63920h;
                        this.f63920h = i13 + 1;
                        this.f63921i = list.get(i13).a(this.f63922j, this.f63915c.s(), this.f63915c.f(), this.f63915c.k());
                        if (this.f63921i != null && this.f63915c.t(this.f63921i.f63995c.a())) {
                            this.f63921i.f63995c.f(this.f63915c.l(), this);
                            z11 = true;
                        }
                    }
                    return z11;
                }
            }
        } else if (File.class.equals(this.f63915c.q())) {
            return false;
        } else {
            throw new IllegalStateException("Failed to find any load path from " + this.f63915c.i() + " to " + this.f63915c.q());
        }
    }

    public final boolean b() {
        return this.f63920h < this.f63919g.size();
    }

    public void cancel() {
        d.a<?> aVar = this.f63921i;
        if (aVar != null) {
            aVar.f63995c.cancel();
        }
    }

    public void d(Object obj) {
        this.f63914b.b(this.f63918f, obj, this.f63921i.f63995c, DataSource.RESOURCE_DISK_CACHE, this.f63923k);
    }

    public void e(Exception exc) {
        this.f63914b.c(this.f63923k, exc, this.f63921i.f63995c, DataSource.RESOURCE_DISK_CACHE);
    }
}
