package com.sumsub.sns.core.widget;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import com.sumsub.sns.R;
import com.sumsub.sns.core.presentation.helper.a;
import com.sumsub.sns.core.theme.SNSColorElement;
import com.sumsub.sns.core.theme.SNSMetricElement;
import com.sumsub.sns.internal.core.theme.d;
import kotlin.Metadata;
import kotlin.jvm.internal.r;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"Lcom/sumsub/sns/core/widget/SNSVideoSelfieFrameView;", "Lcom/sumsub/sns/core/widget/SNSFrameView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SNSVideoSelfieFrameView extends SNSFrameView {
    public SNSVideoSelfieFrameView(Context context) {
        this(context, (AttributeSet) null, 0, 0, 14, (r) null);
    }

    public SNSVideoSelfieFrameView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, (r) null);
    }

    public SNSVideoSelfieFrameView(Context context, AttributeSet attributeSet, int i11) {
        this(context, attributeSet, i11, 0, 8, (r) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SNSVideoSelfieFrameView(Context context, AttributeSet attributeSet, int i11, int i12, int i13, r rVar) {
        this(context, (i13 & 2) != 0 ? null : attributeSet, (i13 & 4) != 0 ? R.attr.sns_FrameViewStyle : i11, (i13 & 8) != 0 ? R.style.SNSVideoSelfieFrameViewStyle : i12);
    }

    public SNSVideoSelfieFrameView(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
        int i13;
        int i14;
        Integer a11;
        a aVar = a.f31095a;
        Integer a12 = aVar.a((View) this, SNSColorElement.CONTENT_INFO);
        if (a12 != null) {
            i13 = a12.intValue();
        } else if (Build.VERSION.SDK_INT >= 23) {
            i13 = context.getResources().getColor(R.color.sns_color_primary_50, context.getTheme());
        } else {
            i13 = context.getResources().getColor(R.color.sns_color_primary_50);
        }
        Float a13 = aVar.a(SNSMetricElement.VIEWPORT_BORDER_WIDTH);
        if (a13 != null) {
            i14 = (int) a13.floatValue();
        } else {
            i14 = context.getResources().getDimensionPixelSize(R.dimen.sns_viewport_border_width);
        }
        setStroke(i14, i13);
        SNSColorElement sNSColorElement = SNSColorElement.BACKGROUND_COMMON;
        d a14 = aVar.a();
        if (a14 != null && (a11 = aVar.a(a14, sNSColorElement, aVar.a((View) this))) != null) {
            setFillColor(a11.intValue());
        }
    }
}
