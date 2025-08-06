package com.fluttercandies.photo_manager.core.entity;

import kotlin.jvm.internal.x;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public final String f65094a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f65095b;

    public e(String str, boolean z11) {
        this.f65094a = str;
        this.f65095b = z11;
    }

    public final String a() {
        String str = this.f65095b ? "asc" : "desc";
        return this.f65094a + ' ' + str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return x.b(this.f65094a, eVar.f65094a) && this.f65095b == eVar.f65095b;
    }

    public int hashCode() {
        int hashCode = this.f65094a.hashCode() * 31;
        boolean z11 = this.f65095b;
        if (z11) {
            z11 = true;
        }
        return hashCode + (z11 ? 1 : 0);
    }

    public String toString() {
        return "OrderByCond(key=" + this.f65094a + ", asc=" + this.f65095b + ')';
    }
}
