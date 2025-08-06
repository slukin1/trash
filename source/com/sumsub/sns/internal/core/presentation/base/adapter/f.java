package com.sumsub.sns.internal.core.presentation.base.adapter;

import com.sumsub.sns.internal.core.widget.SNSStepState;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

public final class f extends a {

    /* renamed from: b  reason: collision with root package name */
    public final CharSequence f33711b;

    /* renamed from: c  reason: collision with root package name */
    public final CharSequence f33712c;

    /* renamed from: d  reason: collision with root package name */
    public final SNSStepState f33713d;

    public f() {
        this((CharSequence) null, (CharSequence) null, (SNSStepState) null, 7, (r) null);
    }

    public final f a(CharSequence charSequence, CharSequence charSequence2, SNSStepState sNSStepState) {
        return new f(charSequence, charSequence2, sNSStepState);
    }

    public final CharSequence b() {
        return this.f33711b;
    }

    public final CharSequence c() {
        return this.f33712c;
    }

    public final SNSStepState d() {
        return this.f33713d;
    }

    public final CharSequence e() {
        return this.f33712c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return x.b(this.f33711b, fVar.f33711b) && x.b(this.f33712c, fVar.f33712c) && this.f33713d == fVar.f33713d;
    }

    public final CharSequence f() {
        return this.f33711b;
    }

    public final SNSStepState g() {
        return this.f33713d;
    }

    public int hashCode() {
        CharSequence charSequence = this.f33711b;
        int i11 = 0;
        int hashCode = (charSequence == null ? 0 : charSequence.hashCode()) * 31;
        CharSequence charSequence2 = this.f33712c;
        int hashCode2 = (hashCode + (charSequence2 == null ? 0 : charSequence2.hashCode())) * 31;
        SNSStepState sNSStepState = this.f33713d;
        if (sNSStepState != null) {
            i11 = sNSStepState.hashCode();
        }
        return hashCode2 + i11;
    }

    public String toString() {
        return "SNSModeratorCommentViewItem(moderationTitle=" + this.f33711b + ", moderationComment=" + this.f33712c + ", state=" + this.f33713d + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ f(CharSequence charSequence, CharSequence charSequence2, SNSStepState sNSStepState, int i11, r rVar) {
        this((i11 & 1) != 0 ? null : charSequence, (i11 & 2) != 0 ? null : charSequence2, (i11 & 4) != 0 ? null : sNSStepState);
    }

    public static /* synthetic */ f a(f fVar, CharSequence charSequence, CharSequence charSequence2, SNSStepState sNSStepState, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            charSequence = fVar.f33711b;
        }
        if ((i11 & 2) != 0) {
            charSequence2 = fVar.f33712c;
        }
        if ((i11 & 4) != 0) {
            sNSStepState = fVar.f33713d;
        }
        return fVar.a(charSequence, charSequence2, sNSStepState);
    }

    public f(CharSequence charSequence, CharSequence charSequence2, SNSStepState sNSStepState) {
        super(2);
        this.f33711b = charSequence;
        this.f33712c = charSequence2;
        this.f33713d = sNSStepState;
    }
}
