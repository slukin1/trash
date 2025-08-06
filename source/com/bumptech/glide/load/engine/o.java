package com.bumptech.glide.load.engine;

import java.util.HashMap;
import java.util.Map;
import n3.b;

public final class o {

    /* renamed from: a  reason: collision with root package name */
    public final Map<b, i<?>> f63903a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public final Map<b, i<?>> f63904b = new HashMap();

    public i<?> a(b bVar, boolean z11) {
        return b(z11).get(bVar);
    }

    public final Map<b, i<?>> b(boolean z11) {
        return z11 ? this.f63904b : this.f63903a;
    }

    public void c(b bVar, i<?> iVar) {
        b(iVar.p()).put(bVar, iVar);
    }

    public void d(b bVar, i<?> iVar) {
        Map<b, i<?>> b11 = b(iVar.p());
        if (iVar.equals(b11.get(bVar))) {
            b11.remove(bVar);
        }
    }
}
