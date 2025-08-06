package com.sumsub.sns.core.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import android.view.View;
import com.sumsub.sns.R;
import com.sumsub.sns.core.presentation.helper.a;
import com.sumsub.sns.core.theme.SNSColorElement;
import com.sumsub.sns.core.theme.SNSMetricElement;
import kotlin.Metadata;
import kotlin.jvm.internal.r;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"Lcom/sumsub/sns/core/widget/SNSIntroLivenessItemView;", "Lcom/sumsub/sns/core/widget/SNSStepView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public class SNSIntroLivenessItemView extends SNSStepView {
    public SNSIntroLivenessItemView(Context context) {
        this(context, (AttributeSet) null, 0, 0, 14, (r) null);
    }

    public SNSIntroLivenessItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, (r) null);
    }

    public SNSIntroLivenessItemView(Context context, AttributeSet attributeSet, int i11) {
        this(context, attributeSet, i11, 0, 8, (r) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SNSIntroLivenessItemView(Context context, AttributeSet attributeSet, int i11, int i12, int i13, r rVar) {
        this(context, (i13 & 2) != 0 ? null : attributeSet, (i13 & 4) != 0 ? R.attr.sns_introLivenessItemViewStyle : i11, (i13 & 8) != 0 ? R.style.Widget_SNSIntroLivenessItemView : i12);
    }

    public SNSIntroLivenessItemView(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12, (SNSMetricElement) null);
        a aVar = a.f31095a;
        if (aVar.a() != null) {
            Integer a11 = aVar.a((View) this, SNSColorElement.CONTENT_SUCCESS);
            Integer a12 = aVar.a((View) this, SNSColorElement.CONTENT_CRITICAL);
            Integer a13 = aVar.a((View) this, SNSColorElement.CONTENT_NEUTRAL);
            int[][] iArr = {new int[]{R.attr.sns_stateApproved}, new int[]{R.attr.sns_stateRejected}, new int[0]};
            if (a11 != null && a12 != null && a13 != null) {
                setTitleTextColor(new ColorStateList(iArr, new int[]{a11.intValue(), a12.intValue(), a13.intValue()}));
                setSubtitleTextColor(ColorStateList.valueOf(a13.intValue()));
            }
        }
    }
}
