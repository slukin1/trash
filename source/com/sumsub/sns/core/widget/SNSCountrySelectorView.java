package com.sumsub.sns.core.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.core.widget.h;
import com.sumsub.sns.R;
import com.sumsub.sns.core.theme.SNSMetricElement;
import kotlin.Metadata;
import kotlin.jvm.internal.r;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\n\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000bH\u0016¨\u0006\u000f"}, d2 = {"Lcom/sumsub/sns/core/widget/SNSCountrySelectorView;", "Lcom/sumsub/sns/core/widget/SNSStepView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "getIconTintColor", "Landroid/content/res/ColorStateList;", "setIconTintColor", "", "tintColor", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SNSCountrySelectorView extends SNSStepView {
    public SNSCountrySelectorView(Context context) {
        this(context, (AttributeSet) null, 0, 0, 14, (r) null);
    }

    public ColorStateList getIconTintColor() {
        ImageView iconEndView = getIconEndView();
        if (iconEndView != null) {
            return iconEndView.getImageTintList();
        }
        return null;
    }

    public void setIconTintColor(ColorStateList colorStateList) {
        ImageView iconEndView = getIconEndView();
        if (iconEndView != null) {
            h.c(iconEndView, colorStateList);
        }
    }

    public SNSCountrySelectorView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, (r) null);
    }

    public SNSCountrySelectorView(Context context, AttributeSet attributeSet, int i11) {
        this(context, attributeSet, i11, 0, 8, (r) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SNSCountrySelectorView(Context context, AttributeSet attributeSet, int i11, int i12, int i13, r rVar) {
        this(context, (i13 & 2) != 0 ? null : attributeSet, (i13 & 4) != 0 ? R.attr.sns_CountrySelectorViewStyle : i11, (i13 & 8) != 0 ? R.style.Widget_SNSCountrySelectorView : i12);
    }

    public SNSCountrySelectorView(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12, SNSMetricElement.SELECTED_COUNTRY_CARD_STYLE);
    }
}
