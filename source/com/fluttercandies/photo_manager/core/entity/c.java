package com.fluttercandies.photo_manager.core.entity;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public final long f65085a;

    /* renamed from: b  reason: collision with root package name */
    public final long f65086b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f65087c;

    public c(long j11, long j12, boolean z11) {
        this.f65085a = j11;
        this.f65086b = j12;
        this.f65087c = z11;
    }

    public final boolean a() {
        return this.f65087c;
    }

    public final long b() {
        return this.f65086b;
    }

    public final long c() {
        return this.f65085a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.f65085a == cVar.f65085a && this.f65086b == cVar.f65086b && this.f65087c == cVar.f65087c;
    }

    public int hashCode() {
        int a11 = ((a.a(this.f65085a) * 31) + a.a(this.f65086b)) * 31;
        boolean z11 = this.f65087c;
        if (z11) {
            z11 = true;
        }
        return a11 + (z11 ? 1 : 0);
    }

    public String toString() {
        return "DateCond(minMs=" + this.f65085a + ", maxMs=" + this.f65086b + ", ignore=" + this.f65087c + ')';
    }
}
