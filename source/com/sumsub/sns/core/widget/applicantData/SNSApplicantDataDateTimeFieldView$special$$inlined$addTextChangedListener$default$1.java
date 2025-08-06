package com.sumsub.sns.core.widget.applicantData;

import android.text.Editable;
import android.text.TextWatcher;
import d10.l;
import kotlin.Metadata;
import kotlin.Unit;

@Metadata(bv = {}, d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J*\u0010\f\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0016J*\u0010\u000e\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016¨\u0006\u000f"}, d2 = {"com/sumsub/sns/core/widget/applicantData/SNSApplicantDataDateTimeFieldView$special$$inlined$addTextChangedListener$default$1", "Landroid/text/TextWatcher;", "Landroid/text/Editable;", "s", "", "afterTextChanged", "", "text", "", "start", "count", "after", "beforeTextChanged", "before", "onTextChanged", "core-ktx_release"}, k = 1, mv = {1, 7, 1})
public final class SNSApplicantDataDateTimeFieldView$special$$inlined$addTextChangedListener$default$1 implements TextWatcher {
    public final /* synthetic */ SNSApplicantDataDateTimeFieldView this$0;

    public SNSApplicantDataDateTimeFieldView$special$$inlined$addTextChangedListener$default$1(SNSApplicantDataDateTimeFieldView sNSApplicantDataDateTimeFieldView) {
        this.this$0 = sNSApplicantDataDateTimeFieldView;
    }

    public void afterTextChanged(Editable editable) {
        String str = null;
        this.this$0.setError((CharSequence) null);
        l<String, Unit> textChangedCallback = this.this$0.getTextChangedCallback();
        if (textChangedCallback != null) {
            if (editable != null) {
                str = editable.toString();
            }
            textChangedCallback.invoke(str);
        }
    }

    public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
    }

    public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
    }
}
