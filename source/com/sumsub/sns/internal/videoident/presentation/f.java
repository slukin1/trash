package com.sumsub.sns.internal.videoident.presentation;

import kotlin.jvm.internal.x;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    public final CharSequence f36692a;

    /* renamed from: b  reason: collision with root package name */
    public final CharSequence f36693b;

    /* renamed from: c  reason: collision with root package name */
    public final CharSequence f36694c;

    public f(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3) {
        this.f36692a = charSequence;
        this.f36693b = charSequence2;
        this.f36694c = charSequence3;
    }

    public final CharSequence a() {
        return this.f36692a;
    }

    public final CharSequence b() {
        return this.f36693b;
    }

    public final CharSequence c() {
        return this.f36694c;
    }

    public final CharSequence d() {
        return this.f36692a;
    }

    public final CharSequence e() {
        return this.f36694c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return x.b(this.f36692a, fVar.f36692a) && x.b(this.f36693b, fVar.f36693b) && x.b(this.f36694c, fVar.f36694c);
    }

    public final CharSequence f() {
        return this.f36693b;
    }

    public int hashCode() {
        CharSequence charSequence = this.f36692a;
        int i11 = 0;
        int hashCode = (charSequence == null ? 0 : charSequence.hashCode()) * 31;
        CharSequence charSequence2 = this.f36693b;
        int hashCode2 = (hashCode + (charSequence2 == null ? 0 : charSequence2.hashCode())) * 31;
        CharSequence charSequence3 = this.f36694c;
        if (charSequence3 != null) {
            i11 = charSequence3.hashCode();
        }
        return hashCode2 + i11;
    }

    public String toString() {
        return "SNSPermissionDialog(message=" + this.f36692a + ", positiveButton=" + this.f36693b + ", negativeButton=" + this.f36694c + ')';
    }

    public final f a(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3) {
        return new f(charSequence, charSequence2, charSequence3);
    }

    public static /* synthetic */ f a(f fVar, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            charSequence = fVar.f36692a;
        }
        if ((i11 & 2) != 0) {
            charSequence2 = fVar.f36693b;
        }
        if ((i11 & 4) != 0) {
            charSequence3 = fVar.f36694c;
        }
        return fVar.a(charSequence, charSequence2, charSequence3);
    }
}
