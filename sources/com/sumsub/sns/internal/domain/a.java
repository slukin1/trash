package com.sumsub.sns.internal.domain;

import com.sumsub.sns.internal.core.data.model.h;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final h f34059a;

    /* renamed from: b  reason: collision with root package name */
    public final String f34060b;

    /* renamed from: c  reason: collision with root package name */
    public final CharSequence f34061c;

    /* renamed from: d  reason: collision with root package name */
    public final CharSequence f34062d;

    /* renamed from: e  reason: collision with root package name */
    public final CharSequence f34063e;

    public a(h hVar, String str, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3) {
        this.f34059a = hVar;
        this.f34060b = str;
        this.f34061c = charSequence;
        this.f34062d = charSequence2;
        this.f34063e = charSequence3;
    }

    public final h a() {
        return this.f34059a;
    }

    public final String b() {
        return this.f34060b;
    }

    public final CharSequence c() {
        return this.f34061c;
    }

    public final CharSequence d() {
        return this.f34062d;
    }

    public final CharSequence e() {
        return this.f34063e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return x.b(this.f34059a, aVar.f34059a) && x.b(this.f34060b, aVar.f34060b) && x.b(this.f34061c, aVar.f34061c) && x.b(this.f34062d, aVar.f34062d) && x.b(this.f34063e, aVar.f34063e);
    }

    public final CharSequence f() {
        return this.f34063e;
    }

    public final h g() {
        return this.f34059a;
    }

    public final CharSequence h() {
        return this.f34062d;
    }

    public int hashCode() {
        int hashCode = ((this.f34059a.hashCode() * 31) + this.f34060b.hashCode()) * 31;
        CharSequence charSequence = this.f34061c;
        int i11 = 0;
        int hashCode2 = (hashCode + (charSequence == null ? 0 : charSequence.hashCode())) * 31;
        CharSequence charSequence2 = this.f34062d;
        int hashCode3 = (hashCode2 + (charSequence2 == null ? 0 : charSequence2.hashCode())) * 31;
        CharSequence charSequence3 = this.f34063e;
        if (charSequence3 != null) {
            i11 = charSequence3.hashCode();
        }
        return hashCode3 + i11;
    }

    public final CharSequence i() {
        return this.f34061c;
    }

    public final String j() {
        return this.f34060b;
    }

    public String toString() {
        return "ApplicantData(field=" + this.f34059a + ", value=" + this.f34060b + ", label=" + this.f34061c + ", hint=" + this.f34062d + ", example=" + this.f34063e + ')';
    }

    public final a a(h hVar, String str, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3) {
        return new a(hVar, str, charSequence, charSequence2, charSequence3);
    }

    public static /* synthetic */ a a(a aVar, h hVar, String str, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            hVar = aVar.f34059a;
        }
        if ((i11 & 2) != 0) {
            str = aVar.f34060b;
        }
        String str2 = str;
        if ((i11 & 4) != 0) {
            charSequence = aVar.f34061c;
        }
        CharSequence charSequence4 = charSequence;
        if ((i11 & 8) != 0) {
            charSequence2 = aVar.f34062d;
        }
        CharSequence charSequence5 = charSequence2;
        if ((i11 & 16) != 0) {
            charSequence3 = aVar.f34063e;
        }
        return aVar.a(hVar, str2, charSequence4, charSequence5, charSequence3);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a(h hVar, String str, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i11, r rVar) {
        this(hVar, (i11 & 2) != 0 ? "" : str, (i11 & 4) != 0 ? null : charSequence, (i11 & 8) != 0 ? null : charSequence2, (i11 & 16) != 0 ? null : charSequence3);
    }
}
