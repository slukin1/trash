package com.sumsub.sns.core.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import com.sumsub.sns.R;
import com.sumsub.sns.core.presentation.helper.a;
import com.sumsub.sns.core.theme.SNSColorElement;
import com.sumsub.sns.core.theme.SNSMetricElement;
import com.sumsub.sns.core.theme.SNSThemeMetric;
import com.sumsub.sns.core.theme.SNSTypographyElement;
import com.sumsub.sns.internal.core.theme.d;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.i;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

@Metadata(bv = {}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0015¢\u0006\u0004\b\u0018\u0010\u0019J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006R\u001d\u0010\r\u001a\u0004\u0018\u00010\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u001a"}, d2 = {"Lcom/sumsub/sns/core/widget/SNSCardRadioButton;", "Landroid/widget/RadioButton;", "", "cardStyle", "", "setBackground", "Landroid/graphics/drawable/Drawable;", "drawable", "setStartDrawable", "radioDrawable$delegate", "Lkotlin/i;", "getRadioDrawable", "()Landroid/graphics/drawable/Drawable;", "radioDrawable", "Landroid/graphics/drawable/GradientDrawable;", "backgroundDrawable", "Landroid/graphics/drawable/GradientDrawable;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
@SuppressLint({"AppCompatCustomView"})
public final class SNSCardRadioButton extends RadioButton {
    private final GradientDrawable backgroundDrawable;
    private final i radioDrawable$delegate;

    public SNSCardRadioButton(Context context) {
        this(context, (AttributeSet) null, 0, 0, 14, (r) null);
    }

    private final Drawable getRadioDrawable() {
        return (Drawable) this.radioDrawable$delegate.getValue();
    }

    private final void setBackground(String str) {
        float f11;
        Float a11;
        float f12;
        int i11;
        float f13;
        Float a12;
        Float a13;
        int i12 = 0;
        if (x.b(str, SNSThemeMetric.CardStyle.BORDERED.getValue())) {
            GradientDrawable gradientDrawable = this.backgroundDrawable;
            a aVar = a.f31095a;
            Integer a14 = aVar.a((View) this, SNSColorElement.CARD_BORDERED_BACKGROUND);
            if (a14 != null) {
                i12 = a14.intValue();
            }
            gradientDrawable.setColor(i12);
            d a15 = aVar.a();
            if (a15 == null || (a13 = aVar.a(a15, SNSMetricElement.CARD_BORDER_WIDTH)) == null) {
                f12 = getResources().getDimension(R.dimen.sns_agreement_card_stroke_width);
            } else {
                f12 = a13.floatValue();
            }
            int i13 = (int) f12;
            Integer a16 = aVar.a((View) this, SNSColorElement.CONTENT_WEAK);
            if (a16 != null) {
                i11 = a16.intValue();
            } else {
                i11 = getResources().getColor(R.color.sns_color_neutral_20);
            }
            gradientDrawable.setStroke(i13, i11);
            d a17 = aVar.a();
            if (a17 == null || (a12 = aVar.a(a17, SNSMetricElement.CARD_CORNER_RADIUS)) == null) {
                f13 = getResources().getDimension(R.dimen.sns_agreement_card_corner_radius);
            } else {
                f13 = a12.floatValue();
            }
            gradientDrawable.setCornerRadius(f13);
            setBackground(this.backgroundDrawable);
        } else if (x.b(str, SNSThemeMetric.CardStyle.PLAIN.getValue())) {
            GradientDrawable gradientDrawable2 = this.backgroundDrawable;
            a aVar2 = a.f31095a;
            Integer a18 = aVar2.a((View) this, SNSColorElement.CARD_PLAIN_BACKGROUND);
            if (a18 != null) {
                i12 = a18.intValue();
            }
            gradientDrawable2.setColor(i12);
            d a19 = aVar2.a();
            if (a19 == null || (a11 = aVar2.a(a19, SNSMetricElement.CARD_CORNER_RADIUS)) == null) {
                f11 = getResources().getDimension(R.dimen.sns_agreement_card_corner_radius);
            } else {
                f11 = a11.floatValue();
            }
            gradientDrawable2.setCornerRadius(f11);
            setBackground(this.backgroundDrawable);
        } else {
            setBackground((Drawable) null);
        }
    }

    public final void setStartDrawable(Drawable drawable) {
        setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, getRadioDrawable(), (Drawable) null);
    }

    public SNSCardRadioButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, (r) null);
    }

    public SNSCardRadioButton(Context context, AttributeSet attributeSet, int i11) {
        this(context, attributeSet, i11, 0, 8, (r) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SNSCardRadioButton(Context context, AttributeSet attributeSet, int i11, int i12, int i13, r rVar) {
        this(context, (i13 & 2) != 0 ? null : attributeSet, (i13 & 4) != 0 ? R.attr.sns_cardRadioButtonViewStyle : i11, (i13 & 8) != 0 ? R.style.Widget_SNSCardRadioButton : i12);
    }

    public SNSCardRadioButton(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(MaterialThemeOverlay.wrap(context, attributeSet, i11, i12), attributeSet, i11, i12);
        Integer a11;
        this.radioDrawable$delegate = LazyKt__LazyJVMKt.a(new SNSCardRadioButton$radioDrawable$2(this, context));
        GradientDrawable gradientDrawable = new GradientDrawable();
        this.backgroundDrawable = gradientDrawable;
        Integer num = null;
        setButtonDrawable((Drawable) null);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.sns_margin_medium);
        setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        setStartDrawable((Drawable) null);
        setCompoundDrawablePadding(getResources().getDimensionPixelSize(R.dimen.sns_margin_small));
        setBackground(gradientDrawable);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SNSCardRadioButton, i11, i12);
        int i13 = R.styleable.SNSCardRadioButton_sns_cardRadioButtonBackgroundColor;
        if (obtainStyledAttributes.hasValue(i13)) {
            gradientDrawable.setColor(obtainStyledAttributes.getColor(i13, ContextCompat.getColor(context, 17170445)));
        }
        int i14 = R.styleable.SNSCardRadioButton_sns_cardRadioButtonStrokeColor;
        Integer valueOf = obtainStyledAttributes.hasValue(i14) ? Integer.valueOf(obtainStyledAttributes.getColor(i14, ContextCompat.getColor(context, 17170445))) : null;
        int i15 = R.styleable.SNSCardRadioButton_sns_cardRadioButtonStrokeWidth;
        num = obtainStyledAttributes.hasValue(i15) ? Integer.valueOf(obtainStyledAttributes.getDimensionPixelSize(i15, 0)) : num;
        if (!(valueOf == null || num == null)) {
            gradientDrawable.setStroke(num.intValue(), valueOf.intValue());
        }
        int i16 = R.styleable.SNSCardRadioButton_sns_cardRadioButtonCornerRadius;
        if (obtainStyledAttributes.hasValue(i16)) {
            gradientDrawable.setCornerRadius((float) obtainStyledAttributes.getDimensionPixelSize(i16, 0));
        }
        Unit unit = Unit.f56620a;
        obtainStyledAttributes.recycle();
        a aVar = a.f31095a;
        d a12 = aVar.a();
        if (a12 != null) {
            aVar.a((TextView) this, SNSTypographyElement.SUBTITLE2, SNSColorElement.CONTENT_STRONG);
            String c11 = aVar.c(a12, SNSMetricElement.AGREEMENT_CARD_STYLE);
            if (c11 != null) {
                setBackground(c11);
            }
            SNSColorElement sNSColorElement = SNSColorElement.CONTENT_WEAK;
            d a13 = aVar.a();
            if (a13 != null && (a11 = aVar.a(a13, sNSColorElement, aVar.a((View) this))) != null) {
                int intValue = a11.intValue();
                int[][] iArr = {new int[]{-16842912}, new int[]{16842912}};
                int[] iArr2 = new int[2];
                iArr2[0] = intValue;
                Integer a14 = aVar.a((View) this, SNSColorElement.FIELD_TINT);
                iArr2[1] = a14 != null ? a14.intValue() : intValue;
                Drawable radioDrawable = getRadioDrawable();
                if (radioDrawable != null) {
                    radioDrawable.setTintList(new ColorStateList(iArr, iArr2));
                }
            }
        }
    }
}
