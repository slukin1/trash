package com.sumsub.sns.internal.domain;

import com.sumsub.sns.internal.core.data.model.h;
import kotlin.jvm.internal.x;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public final h f34064a;

    /* renamed from: b  reason: collision with root package name */
    public final CharSequence f34065b;

    public b(h hVar, CharSequence charSequence) {
        this.f34064a = hVar;
        this.f34065b = charSequence;
    }

    public final h a() {
        return this.f34064a;
    }

    public final CharSequence b() {
        return this.f34065b;
    }

    public final h c() {
        return this.f34064a;
    }

    public final CharSequence d() {
        return this.f34065b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return x.b(this.f34064a, bVar.f34064a) && x.b(this.f34065b, bVar.f34065b);
    }

    public int hashCode() {
        int hashCode = this.f34064a.hashCode() * 31;
        CharSequence charSequence = this.f34065b;
        return hashCode + (charSequence == null ? 0 : charSequence.hashCode());
    }

    public String toString() {
        return "ApplicantDataError(field=" + this.f34064a + ", text=" + this.f34065b + ')';
    }

    public final b a(h hVar, CharSequence charSequence) {
        return new b(hVar, charSequence);
    }

    public static /* synthetic */ b a(b bVar, h hVar, CharSequence charSequence, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            hVar = bVar.f34064a;
        }
        if ((i11 & 2) != 0) {
            charSequence = bVar.f34065b;
        }
        return bVar.a(hVar, charSequence);
    }
}
