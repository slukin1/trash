package com.sumsub.sns.core.widget.applicantData;

import android.widget.EditText;
import com.google.android.material.textfield.TextInputLayout;
import com.sumsub.sns.core.data.listener.SNSCountryPicker;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"com/sumsub/sns/core/widget/applicantData/SNSApplicantDataSelectionCountryFieldView$picker$1$1", "Lcom/sumsub/sns/core/data/listener/SNSCountryPicker$SNSCountryPickerCallBack;", "onDismiss", "", "onItemSelected", "item", "Lcom/sumsub/sns/core/data/listener/SNSCountryPicker$CountryItem;", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SNSApplicantDataSelectionCountryFieldView$picker$1$1 implements SNSCountryPicker.SNSCountryPickerCallBack {
    public final /* synthetic */ SNSApplicantDataSelectionCountryFieldView this$0;

    public SNSApplicantDataSelectionCountryFieldView$picker$1$1(SNSApplicantDataSelectionCountryFieldView sNSApplicantDataSelectionCountryFieldView) {
        this.this$0 = sNSApplicantDataSelectionCountryFieldView;
    }

    public void onDismiss() {
        EditText editText;
        TextInputLayout inputLayout = this.this$0.getInputLayout();
        if (inputLayout != null && (editText = inputLayout.getEditText()) != null) {
            editText.clearFocus();
        }
    }

    public void onItemSelected(SNSCountryPicker.CountryItem countryItem) {
        this.this$0.onCountrySelected(countryItem);
    }
}
