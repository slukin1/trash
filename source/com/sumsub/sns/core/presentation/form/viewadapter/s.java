package com.sumsub.sns.core.presentation.form.viewadapter;

import android.text.Editable;
import android.widget.EditText;
import com.sumsub.sns.core.presentation.form.c;
import com.sumsub.sns.core.presentation.form.f;
import com.sumsub.sns.core.widget.applicantData.SNSApplicantDataTextAreaFieldView;
import com.sumsub.sns.internal.core.presentation.form.model.FormItem;
import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class s extends k<FormItem.q, SNSApplicantDataTextAreaFieldView> {

    /* renamed from: b  reason: collision with root package name */
    public c f31047b;

    public static final class a extends Lambda implements l<String, Unit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SNSApplicantDataTextAreaFieldView f31048a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ s f31049b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ FormItem.q f31050c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(SNSApplicantDataTextAreaFieldView sNSApplicantDataTextAreaFieldView, s sVar, FormItem.q qVar) {
            super(1);
            this.f31048a = sNSApplicantDataTextAreaFieldView;
            this.f31049b = sVar;
            this.f31050c = qVar;
        }

        public final void a(String str) {
            c d11;
            EditText editText = this.f31048a.getEditText();
            Editable text = editText != null ? editText.getText() : null;
            if (!(text == null || text.length() == 0) && (d11 = this.f31049b.d()) != null) {
                d11.c(this.f31050c);
            }
            c d12 = this.f31049b.d();
            if (d12 != null) {
                FormItem.q qVar = this.f31050c;
                d12.b(qVar, f.b(this.f31048a, qVar));
            }
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((String) obj);
            return Unit.f56620a;
        }
    }

    public s(SNSApplicantDataTextAreaFieldView sNSApplicantDataTextAreaFieldView, c cVar) {
        super(sNSApplicantDataTextAreaFieldView);
        this.f31047b = cVar;
    }

    public final c d() {
        return this.f31047b;
    }

    public final void a(c cVar) {
        this.f31047b = cVar;
    }

    public void a(SNSApplicantDataTextAreaFieldView sNSApplicantDataTextAreaFieldView, FormItem.q qVar, int i11) {
        sNSApplicantDataTextAreaFieldView.setTextChangedCallback(new a(sNSApplicantDataTextAreaFieldView, this, qVar));
    }
}
