package com.sumsub.sns.internal.presentation.screen.verification;

import kotlin.jvm.internal.x;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final CharSequence f36335a;

    /* renamed from: b  reason: collision with root package name */
    public final CharSequence f36336b;

    /* renamed from: c  reason: collision with root package name */
    public final CharSequence f36337c;

    public a(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3) {
        this.f36335a = charSequence;
        this.f36336b = charSequence2;
        this.f36337c = charSequence3;
    }

    public final CharSequence a() {
        return this.f36335a;
    }

    public final CharSequence b() {
        return this.f36336b;
    }

    public final CharSequence c() {
        return this.f36337c;
    }

    public final CharSequence d() {
        return this.f36337c;
    }

    public final CharSequence e() {
        return this.f36336b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return x.b(this.f36335a, aVar.f36335a) && x.b(this.f36336b, aVar.f36336b) && x.b(this.f36337c, aVar.f36337c);
    }

    public final CharSequence f() {
        return this.f36335a;
    }

    public int hashCode() {
        CharSequence charSequence = this.f36335a;
        int i11 = 0;
        int hashCode = (charSequence == null ? 0 : charSequence.hashCode()) * 31;
        CharSequence charSequence2 = this.f36336b;
        int hashCode2 = (hashCode + (charSequence2 == null ? 0 : charSequence2.hashCode())) * 31;
        CharSequence charSequence3 = this.f36337c;
        if (charSequence3 != null) {
            i11 = charSequence3.hashCode();
        }
        return hashCode2 + i11;
    }

    public String toString() {
        return "ConfirmExitDialog(message=" + this.f36335a + ", buttonPositive=" + this.f36336b + ", buttonNegative=" + this.f36337c + ')';
    }

    public final a a(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3) {
        return new a(charSequence, charSequence2, charSequence3);
    }

    public static /* synthetic */ a a(a aVar, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            charSequence = aVar.f36335a;
        }
        if ((i11 & 2) != 0) {
            charSequence2 = aVar.f36336b;
        }
        if ((i11 & 4) != 0) {
            charSequence3 = aVar.f36337c;
        }
        return aVar.a(charSequence, charSequence2, charSequence3);
    }
}
