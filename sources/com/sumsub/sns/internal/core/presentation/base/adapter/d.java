package com.sumsub.sns.internal.core.presentation.base.adapter;

import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

public final class d extends a {

    /* renamed from: b  reason: collision with root package name */
    public final CharSequence f33709b;

    public d() {
        this((CharSequence) null, 1, (r) null);
    }

    public final d a(CharSequence charSequence) {
        return new d(charSequence);
    }

    public final CharSequence b() {
        return this.f33709b;
    }

    public final CharSequence c() {
        return this.f33709b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof d) && x.b(this.f33709b, ((d) obj).f33709b);
    }

    public int hashCode() {
        CharSequence charSequence = this.f33709b;
        if (charSequence == null) {
            return 0;
        }
        return charSequence.hashCode();
    }

    public String toString() {
        return "SNSDocumentsModeratorCommentViewItem(moderatorComment=" + this.f33709b + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ d(CharSequence charSequence, int i11, r rVar) {
        this((i11 & 1) != 0 ? null : charSequence);
    }

    public static /* synthetic */ d a(d dVar, CharSequence charSequence, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            charSequence = dVar.f33709b;
        }
        return dVar.a(charSequence);
    }

    public d(CharSequence charSequence) {
        super(6);
        this.f33709b = charSequence;
    }
}
