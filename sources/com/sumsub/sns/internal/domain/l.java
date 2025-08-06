package com.sumsub.sns.internal.domain;

import com.sumsub.sns.internal.core.data.model.remote.o;
import kotlin.jvm.internal.x;

public final class l {

    /* renamed from: a  reason: collision with root package name */
    public final CharSequence f34149a;

    /* renamed from: b  reason: collision with root package name */
    public final o f34150b;

    /* renamed from: c  reason: collision with root package name */
    public final CharSequence f34151c;

    /* renamed from: d  reason: collision with root package name */
    public final CharSequence f34152d;

    public l(CharSequence charSequence, o oVar, CharSequence charSequence2, CharSequence charSequence3) {
        this.f34149a = charSequence;
        this.f34150b = oVar;
        this.f34151c = charSequence2;
        this.f34152d = charSequence3;
    }

    public final CharSequence a() {
        return this.f34149a;
    }

    public final o b() {
        return this.f34150b;
    }

    public final CharSequence c() {
        return this.f34151c;
    }

    public final CharSequence d() {
        return this.f34152d;
    }

    public final CharSequence e() {
        return this.f34152d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        return x.b(this.f34149a, lVar.f34149a) && x.b(this.f34150b, lVar.f34150b) && x.b(this.f34151c, lVar.f34151c) && x.b(this.f34152d, lVar.f34152d);
    }

    public final CharSequence f() {
        return this.f34151c;
    }

    public final CharSequence g() {
        return this.f34149a;
    }

    public final o h() {
        return this.f34150b;
    }

    public int hashCode() {
        CharSequence charSequence = this.f34149a;
        int i11 = 0;
        int hashCode = (charSequence == null ? 0 : charSequence.hashCode()) * 31;
        o oVar = this.f34150b;
        int hashCode2 = (hashCode + (oVar == null ? 0 : oVar.hashCode())) * 31;
        CharSequence charSequence2 = this.f34151c;
        int hashCode3 = (hashCode2 + (charSequence2 == null ? 0 : charSequence2.hashCode())) * 31;
        CharSequence charSequence3 = this.f34152d;
        if (charSequence3 != null) {
            i11 = charSequence3.hashCode();
        }
        return hashCode3 + i11;
    }

    public String toString() {
        return "Tin(label=" + this.f34149a + ", tinInfo=" + this.f34150b + ", hint=" + this.f34151c + ", example=" + this.f34152d + ')';
    }

    public final l a(CharSequence charSequence, o oVar, CharSequence charSequence2, CharSequence charSequence3) {
        return new l(charSequence, oVar, charSequence2, charSequence3);
    }

    public static /* synthetic */ l a(l lVar, CharSequence charSequence, o oVar, CharSequence charSequence2, CharSequence charSequence3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            charSequence = lVar.f34149a;
        }
        if ((i11 & 2) != 0) {
            oVar = lVar.f34150b;
        }
        if ((i11 & 4) != 0) {
            charSequence2 = lVar.f34151c;
        }
        if ((i11 & 8) != 0) {
            charSequence3 = lVar.f34152d;
        }
        return lVar.a(charSequence, oVar, charSequence2, charSequence3);
    }
}
