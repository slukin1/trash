package com.bumptech.glide.load.engine.cache;

import android.annotation.SuppressLint;
import com.bumptech.glide.load.engine.cache.g;
import com.bumptech.glide.load.engine.r;
import n3.b;

public class f extends f4.f<b, r<?>> implements g {

    /* renamed from: e  reason: collision with root package name */
    public g.a f63802e;

    public f(long j11) {
        super(j11);
    }

    @SuppressLint({"InlinedApi"})
    public void a(int i11) {
        if (i11 >= 40) {
            b();
        } else if (i11 >= 20 || i11 == 15) {
            m(h() / 2);
        }
    }

    public /* bridge */ /* synthetic */ r c(b bVar, r rVar) {
        return (r) super.k(bVar, rVar);
    }

    public /* bridge */ /* synthetic */ r d(b bVar) {
        return (r) super.l(bVar);
    }

    public void e(g.a aVar) {
        this.f63802e = aVar;
    }

    /* renamed from: n */
    public int i(r<?> rVar) {
        if (rVar == null) {
            return super.i(null);
        }
        return rVar.getSize();
    }

    /* renamed from: o */
    public void j(b bVar, r<?> rVar) {
        g.a aVar = this.f63802e;
        if (aVar != null && rVar != null) {
            aVar.c(rVar);
        }
    }
}
