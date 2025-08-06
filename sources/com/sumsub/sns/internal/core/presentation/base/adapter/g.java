package com.sumsub.sns.internal.core.presentation.base.adapter;

import kotlin.jvm.internal.x;

public final class g extends a {

    /* renamed from: b  reason: collision with root package name */
    public final CharSequence f33714b;

    public g(CharSequence charSequence) {
        super(5);
        this.f33714b = charSequence;
    }

    public final g a(CharSequence charSequence) {
        return new g(charSequence);
    }

    public final CharSequence b() {
        return this.f33714b;
    }

    public final CharSequence c() {
        return this.f33714b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof g) && x.b(this.f33714b, ((g) obj).f33714b);
    }

    public int hashCode() {
        CharSequence charSequence = this.f33714b;
        if (charSequence == null) {
            return 0;
        }
        return charSequence.hashCode();
    }

    public String toString() {
        return "SNSTextViewItem(text=" + this.f33714b + ')';
    }

    public static /* synthetic */ g a(g gVar, CharSequence charSequence, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            charSequence = gVar.f33714b;
        }
        return gVar.a(charSequence);
    }
}
