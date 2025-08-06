package com.sumsub.sns.core.widget;

import android.animation.StateListAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import com.google.android.material.R;
import com.google.android.material.button.MaterialButton;
import com.sumsub.sns.core.presentation.helper.a;
import com.sumsub.sns.core.theme.SNSColorElement;
import com.sumsub.sns.core.theme.SNSMetricElement;
import com.sumsub.sns.core.theme.SNSTypographyElement;
import com.sumsub.sns.internal.core.theme.b;
import com.sumsub.sns.internal.core.theme.d;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.r;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0007H\u0014¨\u0006\r"}, d2 = {"Lcom/sumsub/sns/core/widget/SNSPrimaryButton;", "Lcom/google/android/material/button/MaterialButton;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "onMeasure", "", "widthMeasureSpec", "heightMeasureSpec", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SNSPrimaryButton extends MaterialButton {
    public SNSPrimaryButton(Context context) {
        this(context, (AttributeSet) null, 0, 6, (r) null);
    }

    public void onMeasure(int i11, int i12) {
        a aVar = a.f31095a;
        d a11 = aVar.a();
        Float a12 = a11 != null ? aVar.a(a11, SNSMetricElement.BUTTON_HEIGHT) : null;
        if (a12 != null) {
            super.onMeasure(i11, View.MeasureSpec.makeMeasureSpec((int) a12.floatValue(), 1073741824));
        } else {
            super.onMeasure(i11, i12);
        }
    }

    public SNSPrimaryButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (r) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SNSPrimaryButton(Context context, AttributeSet attributeSet, int i11, int i12, r rVar) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? R.attr.materialButtonStyle : i11);
    }

    public SNSPrimaryButton(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        b.g gVar;
        a aVar = a.f31095a;
        d a11 = aVar.a();
        if (a11 != null) {
            Map<String, b.g> d11 = a11.d();
            if (!(d11 == null || (gVar = d11.get(SNSTypographyElement.SUBTITLE1.getValue())) == null)) {
                Typeface h11 = gVar.h();
                if (h11 != null) {
                    setTypeface(h11);
                }
                setTextSize((float) gVar.g());
            }
            int i12 = 0;
            int[][] iArr = {new int[]{-16842910}, new int[]{16842919}, new int[0]};
            Integer a12 = aVar.a((View) this, SNSColorElement.PRIMARY_BUTTON_CONTENT);
            Integer a13 = aVar.a((View) this, SNSColorElement.PRIMARY_BUTTON_CONTENT_DISABLED);
            Integer a14 = aVar.a((View) this, SNSColorElement.PRIMARY_BUTTON_CONTENT_HIGHLIGHTED);
            if (!(a12 == null && a13 == null && a14 == null)) {
                int[] iArr2 = new int[3];
                iArr2[0] = a13 != null ? a13.intValue() : 0;
                iArr2[1] = a14 != null ? a14.intValue() : 0;
                iArr2[2] = a12 != null ? a12.intValue() : 0;
                ColorStateList colorStateList = new ColorStateList(iArr, iArr2);
                setTextColor(colorStateList);
                setStrokeColor(colorStateList);
            }
            Integer a15 = aVar.a((View) this, SNSColorElement.PRIMARY_BUTTON_BACKGROUND);
            Integer a16 = aVar.a((View) this, SNSColorElement.PRIMARY_BUTTON_BACKGROUND_DISABLED);
            Integer a17 = aVar.a((View) this, SNSColorElement.PRIMARY_BUTTON_BACKGROUND_HIGHLIGHTED);
            if (!(a15 == null && a16 == null && a17 == null)) {
                setElevation(0.0f);
                setStateListAnimator((StateListAnimator) null);
                int[] iArr3 = new int[3];
                iArr3[0] = a16 != null ? a16.intValue() : 0;
                iArr3[1] = a17 != null ? a17.intValue() : 0;
                iArr3[2] = a15 != null ? a15.intValue() : i12;
                setBackgroundTintList(new ColorStateList(iArr, iArr3));
            }
            Float a18 = aVar.a(a11, SNSMetricElement.BUTTON_CORNER_RADIUS);
            if (a18 != null) {
                setCornerRadius((int) a18.floatValue());
            }
            Float a19 = aVar.a(a11, SNSMetricElement.BUTTON_BORDER_WIDTH);
            if (a19 != null) {
                setStrokeWidth((int) a19.floatValue());
            }
        }
    }
}
