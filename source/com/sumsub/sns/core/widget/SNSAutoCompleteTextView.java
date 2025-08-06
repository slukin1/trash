package com.sumsub.sns.core.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.google.android.material.textfield.MaterialAutoCompleteTextView;
import com.sumsub.sns.R;
import kotlin.Metadata;
import kotlin.jvm.internal.r;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, d2 = {"Lcom/sumsub/sns/core/widget/SNSAutoCompleteTextView;", "Lcom/google/android/material/textfield/MaterialAutoCompleteTextView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "enoughToFilter", "", "showDropDown", "", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SNSAutoCompleteTextView extends MaterialAutoCompleteTextView {
    public SNSAutoCompleteTextView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (r) null);
    }

    public boolean enoughToFilter() {
        return true;
    }

    public void showDropDown() {
        postDelayed(new SNSAutoCompleteTextView$showDropDown$$inlined$postDelayed$1(this), 200);
    }

    public SNSAutoCompleteTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (r) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SNSAutoCompleteTextView(Context context, AttributeSet attributeSet, int i11, int i12, r rVar) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? R.attr.sns_AutoCompleteTextViewStyle : i11);
    }

    public SNSAutoCompleteTextView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
    }
}
