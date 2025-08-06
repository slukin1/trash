package com.sumsub.sns.core.presentation.form.viewutils;

import android.content.Context;
import android.util.AttributeSet;
import com.sumsub.sns.core.presentation.form.c;
import com.sumsub.sns.core.presentation.form.f;
import com.sumsub.sns.core.widget.applicantData.SNSApplicantDataBaseFieldView;
import com.sumsub.sns.core.widget.applicantData.SNSApplicantDataBoolFieldView;
import com.sumsub.sns.internal.core.presentation.form.model.FormItem;
import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.r;

public final class a {

    /* renamed from: com.sumsub.sns.core.presentation.form.viewutils.a$a  reason: collision with other inner class name */
    public static final class C0294a extends Lambda implements l<Boolean, Unit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f31051a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FormItem.a f31052b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ SNSApplicantDataBoolFieldView f31053c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C0294a(c cVar, FormItem.a aVar, SNSApplicantDataBoolFieldView sNSApplicantDataBoolFieldView) {
            super(1);
            this.f31051a = cVar;
            this.f31052b = aVar;
            this.f31053c = sNSApplicantDataBoolFieldView;
        }

        public final void a(boolean z11) {
            c cVar = this.f31051a;
            if (cVar != null) {
                FormItem.a aVar = this.f31052b;
                cVar.b(aVar, f.b(this.f31053c, aVar));
            }
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a(((Boolean) obj).booleanValue());
            return Unit.f56620a;
        }
    }

    public static final SNSApplicantDataBaseFieldView a(FormItem.a aVar, Context context, c cVar) {
        SNSApplicantDataBoolFieldView sNSApplicantDataBoolFieldView = new SNSApplicantDataBoolFieldView(context, (AttributeSet) null, 0, 0, 14, (r) null);
        sNSApplicantDataBoolFieldView.setOnCheckedChanged(new C0294a(cVar, aVar, sNSApplicantDataBoolFieldView));
        return sNSApplicantDataBoolFieldView;
    }
}
