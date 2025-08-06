package com.sumsub.sns.core.presentation.form.viewutils;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.widget.EditText;
import com.sumsub.sns.core.presentation.form.c;
import com.sumsub.sns.core.presentation.form.f;
import com.sumsub.sns.core.widget.SNSApplicantDataFieldView;
import com.sumsub.sns.core.widget.applicantData.SNSApplicantDataBaseFieldView;
import com.sumsub.sns.internal.core.data.model.p;
import com.sumsub.sns.internal.core.presentation.form.model.FormItem;
import com.sumsub.sns.internal.core.presentation.form.model.g;
import java.util.List;
import kotlin.jvm.internal.r;

public final class m {

    public static final class a implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SNSApplicantDataFieldView f31092a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f31093b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ FormItem.p f31094c;

        public a(SNSApplicantDataFieldView sNSApplicantDataFieldView, c cVar, FormItem.p pVar) {
            this.f31092a = sNSApplicantDataFieldView;
            this.f31093b = cVar;
            this.f31094c = pVar;
        }

        public void afterTextChanged(Editable editable) {
            c cVar;
            EditText editText = this.f31092a.getEditText();
            Editable text = editText != null ? editText.getText() : null;
            if (!(text == null || text.length() == 0) && (cVar = this.f31093b) != null) {
                cVar.c(this.f31094c);
            }
            c cVar2 = this.f31093b;
            if (cVar2 != null) {
                FormItem.p pVar = this.f31094c;
                cVar2.b(pVar, f.b(this.f31092a, pVar));
            }
        }

        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }
    }

    public static final SNSApplicantDataBaseFieldView a(FormItem.p pVar, Context context, c cVar) {
        SNSApplicantDataFieldView sNSApplicantDataFieldView = new SNSApplicantDataFieldView(context, (AttributeSet) null, 0, 0, 14, (r) null);
        p a11 = g.a(pVar.d());
        if (a11 instanceof p.g) {
            InputFilter[] inputFilterArr = {new InputFilter.LengthFilter(((p.g) a11).a())};
            EditText editText = sNSApplicantDataFieldView.getEditText();
            if (editText != null) {
                editText.setFilters(inputFilterArr);
            }
        }
        EditText editText2 = sNSApplicantDataFieldView.getEditText();
        if (editText2 != null) {
            editText2.setInputType(g.b(pVar.d()));
        }
        EditText editText3 = sNSApplicantDataFieldView.getEditText();
        if (editText3 != null) {
            editText3.addTextChangedListener(new a(sNSApplicantDataFieldView, cVar, pVar));
        }
        List<String> r11 = pVar.r();
        if (r11 != null) {
            sNSApplicantDataFieldView.setMasks(r11);
        }
        return sNSApplicantDataFieldView;
    }
}
