package com.sumsub.sns.internal.videoident.presentation;

import kotlin.jvm.internal.x;

public final class k {

    /* renamed from: a  reason: collision with root package name */
    public final CharSequence f36977a;

    /* renamed from: b  reason: collision with root package name */
    public CharSequence f36978b;

    public k(CharSequence charSequence, CharSequence charSequence2) {
        this.f36977a = charSequence;
        this.f36978b = charSequence2;
    }

    public final CharSequence a() {
        return this.f36977a;
    }

    public final CharSequence b() {
        return this.f36978b;
    }

    public final CharSequence c() {
        return this.f36978b;
    }

    public final CharSequence d() {
        return this.f36977a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        return x.b(this.f36977a, kVar.f36977a) && x.b(this.f36978b, kVar.f36978b);
    }

    public int hashCode() {
        CharSequence charSequence = this.f36977a;
        int i11 = 0;
        int hashCode = (charSequence == null ? 0 : charSequence.hashCode()) * 31;
        CharSequence charSequence2 = this.f36978b;
        if (charSequence2 != null) {
            i11 = charSequence2.hashCode();
        }
        return hashCode + i11;
    }

    public String toString() {
        return "SNSWarning(title=" + this.f36977a + ", text=" + this.f36978b + ')';
    }

    public final k a(CharSequence charSequence, CharSequence charSequence2) {
        return new k(charSequence, charSequence2);
    }

    public static /* synthetic */ k a(k kVar, CharSequence charSequence, CharSequence charSequence2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            charSequence = kVar.f36977a;
        }
        if ((i11 & 2) != 0) {
            charSequence2 = kVar.f36978b;
        }
        return kVar.a(charSequence, charSequence2);
    }

    public final void a(CharSequence charSequence) {
        this.f36978b = charSequence;
    }
}
