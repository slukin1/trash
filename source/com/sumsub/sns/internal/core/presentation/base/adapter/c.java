package com.sumsub.sns.internal.core.presentation.base.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.sumsub.sns.internal.core.common.e0;
import com.sumsub.sns.internal.core.data.model.DocumentType;
import com.sumsub.sns.internal.core.presentation.base.adapter.SNSDocumentViewTypeInfo;
import com.sumsub.sns.internal.core.widget.SNSStepState;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

public final class c extends a {

    /* renamed from: b  reason: collision with root package name */
    public final SNSStepState f33704b;

    /* renamed from: c  reason: collision with root package name */
    public final CharSequence f33705c;

    /* renamed from: d  reason: collision with root package name */
    public final CharSequence f33706d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f33707e;

    /* renamed from: f  reason: collision with root package name */
    public final SNSDocumentViewTypeInfo f33708f;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ c(SNSStepState sNSStepState, CharSequence charSequence, CharSequence charSequence2, boolean z11, SNSDocumentViewTypeInfo sNSDocumentViewTypeInfo, int i11, r rVar) {
        this(sNSStepState, charSequence, charSequence2, (i11 & 8) != 0 ? false : z11, sNSDocumentViewTypeInfo);
    }

    public final c a(SNSStepState sNSStepState, CharSequence charSequence, CharSequence charSequence2, boolean z11, SNSDocumentViewTypeInfo sNSDocumentViewTypeInfo) {
        return new c(sNSStepState, charSequence, charSequence2, z11, sNSDocumentViewTypeInfo);
    }

    public final SNSStepState b() {
        return this.f33704b;
    }

    public final CharSequence c() {
        return this.f33705c;
    }

    public final CharSequence d() {
        return this.f33706d;
    }

    public final boolean e() {
        return this.f33707e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.f33704b == cVar.f33704b && x.b(this.f33705c, cVar.f33705c) && x.b(this.f33706d, cVar.f33706d) && this.f33707e == cVar.f33707e && x.b(this.f33708f, cVar.f33708f);
    }

    public final SNSDocumentViewTypeInfo f() {
        return this.f33708f;
    }

    public final SNSStepState g() {
        return this.f33704b;
    }

    public final CharSequence h() {
        return this.f33706d;
    }

    public int hashCode() {
        int hashCode = ((this.f33704b.hashCode() * 31) + this.f33705c.hashCode()) * 31;
        CharSequence charSequence = this.f33706d;
        int hashCode2 = (hashCode + (charSequence == null ? 0 : charSequence.hashCode())) * 31;
        boolean z11 = this.f33707e;
        if (z11) {
            z11 = true;
        }
        return ((hashCode2 + (z11 ? 1 : 0)) * 31) + this.f33708f.hashCode();
    }

    public final CharSequence i() {
        return this.f33705c;
    }

    public final SNSDocumentViewTypeInfo j() {
        return this.f33708f;
    }

    public final boolean k() {
        return this.f33707e;
    }

    public String toString() {
        return "SNSDocumentViewItem(state=" + this.f33704b + ", title=" + this.f33705c + ", subtitle=" + this.f33706d + ", isClickable=" + this.f33707e + ", typeInfo=" + this.f33708f + ')';
    }

    public c(SNSStepState sNSStepState, CharSequence charSequence, CharSequence charSequence2, boolean z11, SNSDocumentViewTypeInfo sNSDocumentViewTypeInfo) {
        super(1);
        this.f33704b = sNSStepState;
        this.f33705c = charSequence;
        this.f33706d = charSequence2;
        this.f33707e = z11;
        this.f33708f = sNSDocumentViewTypeInfo;
    }

    public static /* synthetic */ c a(c cVar, SNSStepState sNSStepState, CharSequence charSequence, CharSequence charSequence2, boolean z11, SNSDocumentViewTypeInfo sNSDocumentViewTypeInfo, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            sNSStepState = cVar.f33704b;
        }
        if ((i11 & 2) != 0) {
            charSequence = cVar.f33705c;
        }
        CharSequence charSequence3 = charSequence;
        if ((i11 & 4) != 0) {
            charSequence2 = cVar.f33706d;
        }
        CharSequence charSequence4 = charSequence2;
        if ((i11 & 8) != 0) {
            z11 = cVar.f33707e;
        }
        boolean z12 = z11;
        if ((i11 & 16) != 0) {
            sNSDocumentViewTypeInfo = cVar.f33708f;
        }
        return cVar.a(sNSStepState, charSequence3, charSequence4, z12, sNSDocumentViewTypeInfo);
    }

    public final Drawable a(Context context) {
        if (this.f33708f.d() == SNSDocumentViewTypeInfo.Type.VIDEO_IDENTIFICATION) {
            return e0.f32018a.getIconHandler().onResolveIcon(context, new DocumentType(DocumentType.f32356k).b());
        }
        return e0.f32018a.getIconHandler().onResolveIcon(context, this.f33708f.c().getType().b());
    }
}
