package com.sumsub.sns.core.presentation.form.viewadapter;

import android.text.InputFilter;
import android.widget.EditText;
import com.sumsub.sns.core.presentation.form.c;
import com.sumsub.sns.core.widget.SNSTextInputEditText;
import com.sumsub.sns.core.widget.applicantData.SNSApplicantDataBaseFieldView;
import com.sumsub.sns.internal.core.data.model.p;
import com.sumsub.sns.internal.core.data.source.applicant.remote.k;
import com.sumsub.sns.internal.core.presentation.form.model.FormItem;
import com.sumsub.sns.internal.core.presentation.form.model.g;
import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class f extends k<FormItem, SNSApplicantDataBaseFieldView> {

    /* renamed from: b  reason: collision with root package name */
    public c f30982b;

    /* renamed from: c  reason: collision with root package name */
    public FormItem f30983c;

    public static final class a extends Lambda implements l<String, Unit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ f f30984a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FormItem f30985b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(f fVar, FormItem formItem) {
            super(1);
            this.f30984a = fVar;
            this.f30985b = formItem;
        }

        public final void a(String str) {
            c d11;
            c d12 = this.f30984a.d();
            if (d12 != null) {
                d12.b(this.f30985b, com.sumsub.sns.core.presentation.form.f.b(this.f30984a.b(), this.f30985b));
            }
            if (!(str == null || str.length() == 0) && (d11 = this.f30984a.d()) != null) {
                d11.c(this.f30985b);
            }
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((String) obj);
            return Unit.f56620a;
        }
    }

    public f(SNSApplicantDataBaseFieldView sNSApplicantDataBaseFieldView, c cVar) {
        super(sNSApplicantDataBaseFieldView);
        this.f30982b = cVar;
    }

    public final void a(c cVar) {
        this.f30982b = cVar;
    }

    public final c d() {
        return this.f30982b;
    }

    public void a(SNSApplicantDataBaseFieldView sNSApplicantDataBaseFieldView, FormItem formItem, int i11) {
        this.f30983c = formItem;
        k d11 = formItem.d();
        p a11 = g.a(d11);
        if (a11 instanceof p.g) {
            InputFilter[] inputFilterArr = {new InputFilter.LengthFilter(((p.g) a11).a())};
            EditText editText = sNSApplicantDataBaseFieldView.getEditText();
            if (editText != null) {
                editText.setFilters(inputFilterArr);
            }
        }
        EditText editText2 = sNSApplicantDataBaseFieldView.getEditText();
        if (editText2 != null) {
            editText2.setInputType(g.b(d11));
        }
        sNSApplicantDataBaseFieldView.setTextChangedCallback(new a(this, formItem));
        if (formItem instanceof FormItem.p) {
            EditText editText3 = sNSApplicantDataBaseFieldView.getEditText();
            SNSTextInputEditText sNSTextInputEditText = editText3 instanceof SNSTextInputEditText ? (SNSTextInputEditText) editText3 : null;
            if (sNSTextInputEditText != null) {
                sNSTextInputEditText.setMasksString(((FormItem.p) formItem).r());
            }
        }
    }
}
