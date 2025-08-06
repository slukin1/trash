package com.hbg.module.community.multiadapter;

import com.hbg.module.community.multiadapter.d;
import d10.p;

public final class c<T> implements e<T>, d<T> {

    /* renamed from: a  reason: collision with root package name */
    public final MultiTypeAdapter f17244a;

    /* renamed from: b  reason: collision with root package name */
    public final Class<T> f17245b;

    /* renamed from: c  reason: collision with root package name */
    public ItemViewDelegate<T, ?>[] f17246c;

    public c(MultiTypeAdapter multiTypeAdapter, Class<T> cls) {
        this.f17244a = multiTypeAdapter;
        this.f17245b = cls;
    }

    public void b(p<? super Integer, ? super T, Integer> pVar) {
        d.a.a(this, pVar);
    }

    public void c(b<T> bVar) {
        d(bVar);
    }

    public final void d(b<T> bVar) {
        for (ItemViewDelegate<T, ?> fVar : this.f17246c) {
            this.f17244a.i(new f(this.f17245b, fVar, bVar));
        }
    }

    @SafeVarargs
    /* renamed from: e */
    public c<T> a(ItemViewBinder<T, ?>... itemViewBinderArr) {
        this.f17246c = itemViewBinderArr;
        return this;
    }
}
