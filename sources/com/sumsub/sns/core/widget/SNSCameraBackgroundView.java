package com.sumsub.sns.core.widget;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.View;
import com.sumsub.sns.R;
import com.sumsub.sns.core.presentation.helper.a;
import com.sumsub.sns.core.theme.SNSColorElement;
import com.sumsub.sns.internal.core.theme.d;
import kotlin.Metadata;
import kotlin.jvm.internal.r;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"Lcom/sumsub/sns/core/widget/SNSCameraBackgroundView;", "Lcom/sumsub/sns/core/widget/SNSBackgroundView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SNSCameraBackgroundView extends SNSBackgroundView {
    public SNSCameraBackgroundView(Context context) {
        this(context, (AttributeSet) null, 0, 0, 14, (r) null);
    }

    public SNSCameraBackgroundView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, (r) null);
    }

    public SNSCameraBackgroundView(Context context, AttributeSet attributeSet, int i11) {
        this(context, attributeSet, i11, 0, 8, (r) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SNSCameraBackgroundView(Context context, AttributeSet attributeSet, int i11, int i12, int i13, r rVar) {
        this(context, (i13 & 2) != 0 ? null : attributeSet, (i13 & 4) != 0 ? R.attr.sns_CameraBackgroundViewStyle : i11, (i13 & 8) != 0 ? R.style.Widget_SNSCameraBackgroundView : i12);
    }

    public SNSCameraBackgroundView(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
        Integer a11;
        a aVar = a.f31095a;
        SNSColorElement sNSColorElement = SNSColorElement.CAMERA_BACKGROUND;
        d a12 = aVar.a();
        if (a12 != null && (a11 = aVar.a(a12, sNSColorElement, aVar.a((View) this))) != null) {
            setBackground(new ColorDrawable(a11.intValue()));
        }
    }
}
