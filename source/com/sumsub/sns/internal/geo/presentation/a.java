package com.sumsub.sns.internal.geo.presentation;

import com.sumsub.sns.internal.core.data.model.h;
import kotlin.jvm.internal.x;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final h.d f34720a;

    /* renamed from: b  reason: collision with root package name */
    public final CharSequence f34721b;

    /* renamed from: c  reason: collision with root package name */
    public final CharSequence f34722c;

    /* renamed from: d  reason: collision with root package name */
    public final CharSequence f34723d;

    /* renamed from: e  reason: collision with root package name */
    public final CharSequence f34724e;

    public a(h.d dVar, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4) {
        this.f34720a = dVar;
        this.f34721b = charSequence;
        this.f34722c = charSequence2;
        this.f34723d = charSequence3;
        this.f34724e = charSequence4;
    }

    public final h.d a() {
        return this.f34720a;
    }

    public final CharSequence b() {
        return this.f34721b;
    }

    public final CharSequence c() {
        return this.f34722c;
    }

    public final CharSequence d() {
        return this.f34723d;
    }

    public final CharSequence e() {
        return this.f34724e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return x.b(this.f34720a, aVar.f34720a) && x.b(this.f34721b, aVar.f34721b) && x.b(this.f34722c, aVar.f34722c) && x.b(this.f34723d, aVar.f34723d) && x.b(this.f34724e, aVar.f34724e);
    }

    public final CharSequence f() {
        return this.f34724e;
    }

    public final h.d g() {
        return this.f34720a;
    }

    public final CharSequence h() {
        return this.f34723d;
    }

    public int hashCode() {
        int hashCode = this.f34720a.hashCode() * 31;
        CharSequence charSequence = this.f34721b;
        int i11 = 0;
        int hashCode2 = (hashCode + (charSequence == null ? 0 : charSequence.hashCode())) * 31;
        CharSequence charSequence2 = this.f34722c;
        int hashCode3 = (hashCode2 + (charSequence2 == null ? 0 : charSequence2.hashCode())) * 31;
        CharSequence charSequence3 = this.f34723d;
        int hashCode4 = (hashCode3 + (charSequence3 == null ? 0 : charSequence3.hashCode())) * 31;
        CharSequence charSequence4 = this.f34724e;
        if (charSequence4 != null) {
            i11 = charSequence4.hashCode();
        }
        return hashCode4 + i11;
    }

    public final CharSequence i() {
        return this.f34722c;
    }

    public final CharSequence j() {
        return this.f34721b;
    }

    public String toString() {
        return "LocationItem(field=" + this.f34720a + ", value=" + this.f34721b + ", title=" + this.f34722c + ", hint=" + this.f34723d + ", error=" + this.f34724e + ')';
    }

    public final a a(h.d dVar, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4) {
        return new a(dVar, charSequence, charSequence2, charSequence3, charSequence4);
    }

    public static /* synthetic */ a a(a aVar, h.d dVar, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            dVar = aVar.f34720a;
        }
        if ((i11 & 2) != 0) {
            charSequence = aVar.f34721b;
        }
        CharSequence charSequence5 = charSequence;
        if ((i11 & 4) != 0) {
            charSequence2 = aVar.f34722c;
        }
        CharSequence charSequence6 = charSequence2;
        if ((i11 & 8) != 0) {
            charSequence3 = aVar.f34723d;
        }
        CharSequence charSequence7 = charSequence3;
        if ((i11 & 16) != 0) {
            charSequence4 = aVar.f34724e;
        }
        return aVar.a(dVar, charSequence5, charSequence6, charSequence7, charSequence4);
    }
}
