package com.hbg.module.community.multiadapter;

import kotlin.jvm.internal.x;

public final class f<T> {

    /* renamed from: a  reason: collision with root package name */
    public final Class<? extends T> f17248a;

    /* renamed from: b  reason: collision with root package name */
    public final ItemViewDelegate<T, ?> f17249b;

    /* renamed from: c  reason: collision with root package name */
    public final b<T> f17250c;

    public f(Class<? extends T> cls, ItemViewDelegate<T, ?> itemViewDelegate, b<T> bVar) {
        this.f17248a = cls;
        this.f17249b = itemViewDelegate;
        this.f17250c = bVar;
    }

    public final Class<? extends T> a() {
        return this.f17248a;
    }

    public final ItemViewDelegate<T, ?> b() {
        return this.f17249b;
    }

    public final b<T> c() {
        return this.f17250c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return x.b(this.f17248a, fVar.f17248a) && x.b(this.f17249b, fVar.f17249b) && x.b(this.f17250c, fVar.f17250c);
    }

    public int hashCode() {
        return (((this.f17248a.hashCode() * 31) + this.f17249b.hashCode()) * 31) + this.f17250c.hashCode();
    }

    public String toString() {
        return "Type(clazz=" + this.f17248a + ", delegate=" + this.f17249b + ", linker=" + this.f17250c + ')';
    }
}
