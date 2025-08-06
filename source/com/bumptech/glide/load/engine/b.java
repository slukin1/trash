package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.e;
import com.bumptech.glide.load.model.d;
import java.io.File;
import java.util.List;
import o3.d;

public class b implements e, d.a<Object> {

    /* renamed from: b  reason: collision with root package name */
    public final List<n3.b> f63729b;

    /* renamed from: c  reason: collision with root package name */
    public final f<?> f63730c;

    /* renamed from: d  reason: collision with root package name */
    public final e.a f63731d;

    /* renamed from: e  reason: collision with root package name */
    public int f63732e;

    /* renamed from: f  reason: collision with root package name */
    public n3.b f63733f;

    /* renamed from: g  reason: collision with root package name */
    public List<com.bumptech.glide.load.model.d<File, ?>> f63734g;

    /* renamed from: h  reason: collision with root package name */
    public int f63735h;

    /* renamed from: i  reason: collision with root package name */
    public volatile d.a<?> f63736i;

    /* renamed from: j  reason: collision with root package name */
    public File f63737j;

    public b(f<?> fVar, e.a aVar) {
        this(fVar.c(), fVar, aVar);
    }

    public boolean a() {
        while (true) {
            boolean z11 = false;
            if (this.f63734g == null || !b()) {
                int i11 = this.f63732e + 1;
                this.f63732e = i11;
                if (i11 >= this.f63729b.size()) {
                    return false;
                }
                n3.b bVar = this.f63729b.get(this.f63732e);
                File a11 = this.f63730c.d().a(new c(bVar, this.f63730c.o()));
                this.f63737j = a11;
                if (a11 != null) {
                    this.f63733f = bVar;
                    this.f63734g = this.f63730c.j(a11);
                    this.f63735h = 0;
                }
            } else {
                this.f63736i = null;
                while (!z11 && b()) {
                    List<com.bumptech.glide.load.model.d<File, ?>> list = this.f63734g;
                    int i12 = this.f63735h;
                    this.f63735h = i12 + 1;
                    this.f63736i = list.get(i12).a(this.f63737j, this.f63730c.s(), this.f63730c.f(), this.f63730c.k());
                    if (this.f63736i != null && this.f63730c.t(this.f63736i.f63995c.a())) {
                        this.f63736i.f63995c.f(this.f63730c.l(), this);
                        z11 = true;
                    }
                }
                return z11;
            }
        }
    }

    public final boolean b() {
        return this.f63735h < this.f63734g.size();
    }

    public void cancel() {
        d.a<?> aVar = this.f63736i;
        if (aVar != null) {
            aVar.f63995c.cancel();
        }
    }

    public void d(Object obj) {
        this.f63731d.b(this.f63733f, obj, this.f63736i.f63995c, DataSource.DATA_DISK_CACHE, this.f63733f);
    }

    public void e(Exception exc) {
        this.f63731d.c(this.f63733f, exc, this.f63736i.f63995c, DataSource.DATA_DISK_CACHE);
    }

    public b(List<n3.b> list, f<?> fVar, e.a aVar) {
        this.f63732e = -1;
        this.f63729b = list;
        this.f63730c = fVar;
        this.f63731d = aVar;
    }
}
