package com.fluttercandies.photo_manager.core.entity;

import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public final String f65088a;

    /* renamed from: b  reason: collision with root package name */
    public final String f65089b;

    /* renamed from: c  reason: collision with root package name */
    public int f65090c;

    /* renamed from: d  reason: collision with root package name */
    public final int f65091d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f65092e;

    /* renamed from: f  reason: collision with root package name */
    public Long f65093f;

    public d(String str, String str2, int i11, int i12, boolean z11, Long l11) {
        this.f65088a = str;
        this.f65089b = str2;
        this.f65090c = i11;
        this.f65091d = i12;
        this.f65092e = z11;
        this.f65093f = l11;
    }

    public final String a() {
        return this.f65088a;
    }

    public final int b() {
        return this.f65090c;
    }

    public final Long c() {
        return this.f65093f;
    }

    public final String d() {
        return this.f65089b;
    }

    public final boolean e() {
        return this.f65092e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return x.b(this.f65088a, dVar.f65088a) && x.b(this.f65089b, dVar.f65089b) && this.f65090c == dVar.f65090c && this.f65091d == dVar.f65091d && this.f65092e == dVar.f65092e && x.b(this.f65093f, dVar.f65093f);
    }

    public final void f(Long l11) {
        this.f65093f = l11;
    }

    public int hashCode() {
        int hashCode = ((((((this.f65088a.hashCode() * 31) + this.f65089b.hashCode()) * 31) + this.f65090c) * 31) + this.f65091d) * 31;
        boolean z11 = this.f65092e;
        if (z11) {
            z11 = true;
        }
        int i11 = (hashCode + (z11 ? 1 : 0)) * 31;
        Long l11 = this.f65093f;
        return i11 + (l11 == null ? 0 : l11.hashCode());
    }

    public String toString() {
        return "GalleryEntity(id=" + this.f65088a + ", name=" + this.f65089b + ", length=" + this.f65090c + ", typeInt=" + this.f65091d + ", isAll=" + this.f65092e + ", modifiedDate=" + this.f65093f + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ d(String str, String str2, int i11, int i12, boolean z11, Long l11, int i13, r rVar) {
        this(str, str2, i11, i12, (i13 & 16) != 0 ? false : z11, (i13 & 32) != 0 ? null : l11);
    }
}
