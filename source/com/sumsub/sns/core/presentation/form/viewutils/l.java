package com.sumsub.sns.core.presentation.form.viewutils;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.widget.EditText;
import com.sumsub.sns.core.presentation.form.c;
import com.sumsub.sns.core.presentation.form.f;
import com.sumsub.sns.core.widget.applicantData.SNSApplicantDataBaseFieldView;
import com.sumsub.sns.core.widget.applicantData.SNSApplicantDataTextAreaFieldView;
import com.sumsub.sns.internal.core.presentation.form.model.FormItem;
import kotlin.jvm.internal.r;

public final class l {

    public static final class a implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f31089a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ FormItem.q f31090b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ SNSApplicantDataTextAreaFieldView f31091c;

        public a(c cVar, FormItem.q qVar, SNSApplicantDataTextAreaFieldView sNSApplicantDataTextAreaFieldView) {
            this.f31089a = cVar;
            this.f31090b = qVar;
            this.f31091c = sNSApplicantDataTextAreaFieldView;
        }

        public void afterTextChanged(Editable editable) {
            c cVar;
            c cVar2 = this.f31089a;
            if (cVar2 != null) {
                FormItem.q qVar = this.f31090b;
                cVar2.b(qVar, f.b(this.f31091c, qVar));
            }
            EditText editText = this.f31091c.getEditText();
            Editable text = editText != null ? editText.getText() : null;
            if (!(text == null || text.length() == 0) && (cVar = this.f31089a) != null) {
                cVar.c(this.f31090b);
            }
        }

        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }
    }

    public static final SNSApplicantDataBaseFieldView a(FormItem.q qVar, Context context, c cVar) {
        SNSApplicantDataTextAreaFieldView sNSApplicantDataTextAreaFieldView = new SNSApplicantDataTextAreaFieldView(context, (AttributeSet) null, 0, 0, 14, (r) null);
        EditText editText = sNSApplicantDataTextAreaFieldView.getEditText();
        if (editText != null) {
            editText.addTextChangedListener(new a(cVar, qVar, sNSApplicantDataTextAreaFieldView));
        }
        return sNSApplicantDataTextAreaFieldView;
    }
}
