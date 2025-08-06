package com.sumsub.sns.core.widget;

import android.animation.StateListAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.core.widget.l;
import com.google.android.material.button.MaterialButton;
import com.sumsub.sns.R;
import com.sumsub.sns.core.presentation.helper.a;
import com.sumsub.sns.core.theme.SNSColorElement;
import com.sumsub.sns.core.theme.SNSMetricElement;
import com.sumsub.sns.core.theme.SNSTypographyElement;
import com.sumsub.sns.internal.core.common.i;
import com.sumsub.sns.internal.core.theme.b;
import com.sumsub.sns.internal.core.theme.d;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.r;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0007H\u0014¨\u0006\u000e"}, d2 = {"Lcom/sumsub/sns/core/widget/SNSTextButton;", "Lcom/google/android/material/button/MaterialButton;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "onMeasure", "", "widthMeasureSpec", "heightMeasureSpec", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SNSTextButton extends MaterialButton {
    public SNSTextButton(Context context) {
        this(context, (AttributeSet) null, 0, 0, 14, (r) null);
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

    public SNSTextButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, (r) null);
    }

    public SNSTextButton(Context context, AttributeSet attributeSet, int i11) {
        this(context, attributeSet, i11, 0, 8, (r) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SNSTextButton(Context context, AttributeSet attributeSet, int i11, int i12, int i13, r rVar) {
        this(context, (i13 & 2) != 0 ? null : attributeSet, (i13 & 4) != 0 ? R.attr.sns_TextButtonStyle : i11, (i13 & 8) != 0 ? R.style.Widget_SNSTextView_TextButton : i12);
    }

    public SNSTextButton(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11);
        b.g gVar;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SNSTextButton, i11, i12);
        int i13 = R.styleable.SNSTextButton_android_textAppearance;
        int i14 = 0;
        if (obtainStyledAttributes.hasValue(i13)) {
            l.s(this, obtainStyledAttributes.getResourceId(i13, 0));
        }
        int i15 = R.styleable.SNSTextButton_android_gravity;
        if (obtainStyledAttributes.hasValue(i15)) {
            setGravity(obtainStyledAttributes.getInteger(i15, 17));
        }
        int i16 = R.styleable.SNSTextButton_android_minHeight;
        if (obtainStyledAttributes.hasValue(i16)) {
            setMinHeight(obtainStyledAttributes.getDimensionPixelSize(i16, 0));
        }
        int i17 = R.styleable.SNSTextButton_backgroundTint;
        if (obtainStyledAttributes.hasValue(i17)) {
            setBackgroundTintList(i.a(obtainStyledAttributes, context, i17));
        }
        int i18 = R.styleable.SNSTextButton_rippleColor;
        if (obtainStyledAttributes.hasValue(i18)) {
            setRippleColor(i.a(obtainStyledAttributes, context, i18));
        }
        int i19 = R.styleable.SNSTextButton_android_paddingLeft;
        if (obtainStyledAttributes.hasValue(i19)) {
            setPadding(obtainStyledAttributes.getDimensionPixelSize(i19, getPaddingLeft()), getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        int i21 = R.styleable.SNSTextButton_android_paddingRight;
        if (obtainStyledAttributes.hasValue(i21)) {
            setPadding(getPaddingLeft(), getPaddingTop(), obtainStyledAttributes.getDimensionPixelSize(i21, getPaddingRight()), getPaddingBottom());
        }
        int i22 = R.styleable.SNSTextButton_android_textColor;
        if (obtainStyledAttributes.hasValue(i22)) {
            setTextColor(obtainStyledAttributes.getColor(i22, ContextCompat.getColor(context, 17170443)));
        }
        Unit unit = Unit.f56620a;
        obtainStyledAttributes.recycle();
        a aVar = a.f31095a;
        d a11 = aVar.a();
        if (a11 != null) {
            Map<String, b.g> d11 = a11.d();
            if (!(d11 == null || (gVar = d11.get(SNSTypographyElement.SUBTITLE2.getValue())) == null)) {
                Typeface h11 = gVar.h();
                if (h11 != null) {
                    setTypeface(h11);
                }
                setTextSize((float) gVar.g());
            }
            int[][] iArr = {new int[]{-16842910}, new int[]{16842919}, new int[0]};
            Integer a12 = aVar.a((View) this, SNSColorElement.SECONDARY_BUTTON_CONTENT);
            Integer a13 = aVar.a((View) this, SNSColorElement.SECONDARY_BUTTON_CONTENT_DISABLED);
            Integer a14 = aVar.a((View) this, SNSColorElement.SECONDARY_BUTTON_CONTENT_HIGHLIGHTED);
            if (!(a12 == null && a13 == null && a14 == null)) {
                int[] iArr2 = new int[3];
                iArr2[0] = a13 != null ? a13.intValue() : 0;
                iArr2[1] = a14 != null ? a14.intValue() : 0;
                iArr2[2] = a12 != null ? a12.intValue() : 0;
                setTextColor(new ColorStateList(iArr, iArr2));
            }
            setElevation(0.0f);
            setStateListAnimator((StateListAnimator) null);
            Integer a15 = aVar.a((View) this, SNSColorElement.SECONDARY_BUTTON_BACKGROUND);
            Integer a16 = aVar.a((View) this, SNSColorElement.SECONDARY_BUTTON_BACKGROUND_DISABLED);
            Integer a17 = aVar.a((View) this, SNSColorElement.SECONDARY_BUTTON_BACKGROUND_HIGHLIGHTED);
            if (!(a15 == null && a16 == null && a17 == null)) {
                int[] iArr3 = new int[3];
                iArr3[0] = a16 != null ? a16.intValue() : 0;
                iArr3[1] = a17 != null ? a17.intValue() : 0;
                iArr3[2] = a15 != null ? a15.intValue() : i14;
                setBackgroundTintList(new ColorStateList(iArr, iArr3));
            }
            Float a18 = aVar.a(a11, SNSMetricElement.BUTTON_CORNER_RADIUS);
            if (a18 != null) {
                setCornerRadius((int) a18.floatValue());
            }
        }
    }
}
