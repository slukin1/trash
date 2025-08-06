package com.sumsub.sns.core.widget.applicantData;

import android.widget.RadioButton;
import d10.l;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\u0010\u0006\u001a\n \u0003*\u0004\u0018\u00010\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/widget/RadioButton;", "it", "", "kotlin.jvm.PlatformType", "invoke", "(Landroid/widget/RadioButton;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
public final class SNSApplicantDataRadioGroupView$selectedItem$2 extends Lambda implements l<RadioButton, Object> {
    public static final SNSApplicantDataRadioGroupView$selectedItem$2 INSTANCE = new SNSApplicantDataRadioGroupView$selectedItem$2();

    public SNSApplicantDataRadioGroupView$selectedItem$2() {
        super(1);
    }

    public final Object invoke(RadioButton radioButton) {
        return radioButton.getTag();
    }
}
