package com.sumsub.sns.core.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.widget.l;
import com.google.android.material.textview.MaterialTextView;
import com.sumsub.sns.R;
import com.sumsub.sns.core.theme.SNSColorElement;
import com.sumsub.sns.core.theme.SNSTypographyElement;
import com.sumsub.sns.internal.core.widget.SNSStepState;
import com.sumsub.sns.internal.core.widget.a;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.r;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002BE\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0014J\b\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0007H\u0016R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u001a"}, d2 = {"Lcom/sumsub/sns/core/widget/SNSTextView;", "Lcom/google/android/material/textview/MaterialTextView;", "Lcom/sumsub/sns/internal/core/widget/a;", "", "extraSpace", "", "onCreateDrawableState", "Lcom/sumsub/sns/internal/core/widget/SNSStepState;", "getSNSStepState", "state", "", "setSNSStepState", "stepState", "Lcom/sumsub/sns/internal/core/widget/SNSStepState;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "defStyleRes", "Lcom/sumsub/sns/core/theme/SNSTypographyElement;", "typographyElementName", "Lcom/sumsub/sns/core/theme/SNSColorElement;", "colorElementName", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;IILcom/sumsub/sns/core/theme/SNSTypographyElement;Lcom/sumsub/sns/core/theme/SNSColorElement;)V", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
public class SNSTextView extends MaterialTextView implements a {
    private SNSStepState stepState;

    public SNSTextView(Context context) {
        this(context, (AttributeSet) null, 0, 0, (SNSTypographyElement) null, (SNSColorElement) null, 62, (r) null);
    }

    public SNSStepState getSNSStepState() {
        SNSStepState sNSStepState = this.stepState;
        return sNSStepState == null ? SNSStepState.INIT : sNSStepState;
    }

    public int[] onCreateDrawableState(int i11) {
        return View.mergeDrawableStates(super.onCreateDrawableState(i11 + 1), this.stepState != null ? SNSStepViewExtensionsKt.getSnsStepStateDrawable(this) : new int[]{R.attr.sns_stateInit});
    }

    public void setSNSStepState(SNSStepState sNSStepState) {
        if (sNSStepState != this.stepState) {
            this.stepState = sNSStepState;
            refreshDrawableState();
        }
    }

    public SNSTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, (SNSTypographyElement) null, (SNSColorElement) null, 60, (r) null);
    }

    public SNSTextView(Context context, AttributeSet attributeSet, int i11) {
        this(context, attributeSet, i11, 0, (SNSTypographyElement) null, (SNSColorElement) null, 56, (r) null);
    }

    public SNSTextView(Context context, AttributeSet attributeSet, int i11, int i12) {
        this(context, attributeSet, i11, i12, (SNSTypographyElement) null, (SNSColorElement) null, 48, (r) null);
    }

    public SNSTextView(Context context, AttributeSet attributeSet, int i11, int i12, SNSTypographyElement sNSTypographyElement) {
        this(context, attributeSet, i11, i12, sNSTypographyElement, (SNSColorElement) null, 32, (r) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SNSTextView(Context context, AttributeSet attributeSet, int i11, int i12, SNSTypographyElement sNSTypographyElement, SNSColorElement sNSColorElement, int i13, r rVar) {
        this(context, (i13 & 2) != 0 ? null : attributeSet, (i13 & 4) != 0 ? R.attr.sns_BodyTextViewStyle : i11, (i13 & 8) != 0 ? R.style.Widget_SNSTextView_Body : i12, (i13 & 16) != 0 ? SNSTypographyElement.BODY : sNSTypographyElement, (i13 & 32) != 0 ? SNSColorElement.CONTENT_NEUTRAL : sNSColorElement);
    }

    public SNSTextView(Context context, AttributeSet attributeSet, int i11, int i12, SNSTypographyElement sNSTypographyElement, SNSColorElement sNSColorElement) {
        super(context, attributeSet, i11, i12);
        this.stepState = SNSStepState.INIT;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SNSTextView, i11, i12);
        int i13 = R.styleable.SNSTextView_android_textAppearance;
        if (obtainStyledAttributes.hasValue(i13)) {
            l.s(this, obtainStyledAttributes.getResourceId(i13, 0));
        }
        int i14 = R.styleable.SNSTextView_android_gravity;
        if (obtainStyledAttributes.hasValue(i14)) {
            setGravity(obtainStyledAttributes.getInteger(i14, 8388611));
        }
        int i15 = R.styleable.SNSTextView_android_background;
        if (obtainStyledAttributes.hasValue(i15)) {
            setBackground(obtainStyledAttributes.getDrawable(i15));
        }
        int i16 = R.styleable.SNSTextView_sns_textColor;
        if (obtainStyledAttributes.hasValue(i16)) {
            setTextColor(obtainStyledAttributes.getColor(i16, ContextCompat.getColor(context, 17170443)));
        }
        int i17 = R.styleable.SNSTextView_android_drawableStart;
        if (obtainStyledAttributes.hasValue(i17)) {
            Drawable[] compoundDrawables = getCompoundDrawables();
            Drawable drawable = obtainStyledAttributes.getDrawable(i17);
            if (drawable != null) {
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                Unit unit = Unit.f56620a;
            } else {
                drawable = null;
            }
            compoundDrawables[0] = drawable;
            setCompoundDrawables(drawable, compoundDrawables[1], compoundDrawables[2], compoundDrawables[3]);
        }
        int i18 = R.styleable.SNSTextView_android_drawablePadding;
        if (obtainStyledAttributes.hasValue(i18)) {
            setCompoundDrawablePadding(obtainStyledAttributes.getDimensionPixelSize(i18, 0));
        }
        Unit unit2 = Unit.f56620a;
        obtainStyledAttributes.recycle();
        com.sumsub.sns.core.presentation.helper.a.f31095a.a((TextView) this, sNSTypographyElement, sNSColorElement);
    }
}
