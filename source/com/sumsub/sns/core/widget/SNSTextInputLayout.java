package com.sumsub.sns.core.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import com.google.android.material.textfield.TextInputLayout;
import com.sumsub.sns.R;
import com.sumsub.sns.core.theme.SNSColorElement;
import com.sumsub.sns.core.theme.SNSMetricElement;
import com.sumsub.sns.core.theme.SNSTypographyElement;
import com.sumsub.sns.internal.core.common.i;
import com.sumsub.sns.internal.core.theme.d;
import com.sumsub.sns.internal.core.widget.SNSStepState;
import com.sumsub.sns.internal.core.widget.a;
import kotlin.Metadata;
import kotlin.jvm.internal.r;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B1\b\u0007\u0012\u0006\u0010'\u001a\u00020&\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010(\u0012\b\b\u0002\u0010*\u001a\u00020\n\u0012\b\b\u0002\u0010+\u001a\u00020\n¢\u0006\u0004\b,\u0010-J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\u0012\u0010\u0007\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J \u0010\u000e\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016J\u0012\u0010\u0011\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\nH\u0014J\b\u0010\u0016\u001a\u00020\u0015H\u0016J\u0010\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0015H\u0016J\u0018\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\nH\u0014R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001f\u001a\u00020\u001e8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010!\u001a\u00020\u001e8\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010 R\u0018\u0010\"\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010$\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b$\u0010#R\u0018\u0010%\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b%\u0010#¨\u0006."}, d2 = {"Lcom/sumsub/sns/core/widget/SNSTextInputLayout;", "Lcom/google/android/material/textfield/TextInputLayout;", "Lcom/sumsub/sns/internal/core/widget/a;", "Landroid/graphics/drawable/Drawable;", "icon", "", "setStartIconDrawable", "setEndIconDrawable", "Landroid/view/View;", "child", "", "index", "Landroid/view/ViewGroup$LayoutParams;", "params", "addView", "", "errorText", "setError", "extraSpace", "", "onCreateDrawableState", "Lcom/sumsub/sns/internal/core/widget/SNSStepState;", "getSNSStepState", "state", "setSNSStepState", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "stepState", "Lcom/sumsub/sns/internal/core/widget/SNSStepState;", "Landroid/content/res/ColorStateList;", "editorBackgroundColor", "Landroid/content/res/ColorStateList;", "errorColor", "backgroundColorNormal", "Ljava/lang/Integer;", "backgroundColorError", "hintColor", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
public class SNSTextInputLayout extends TextInputLayout implements a {
    private Integer backgroundColorError;
    private Integer backgroundColorNormal;
    private final ColorStateList editorBackgroundColor;
    private final ColorStateList errorColor;
    private Integer hintColor;
    private SNSStepState stepState;

    public SNSTextInputLayout(Context context) {
        this(context, (AttributeSet) null, 0, 0, 14, (r) null);
    }

    public void addView(View view, int i11, ViewGroup.LayoutParams layoutParams) {
        Integer a11;
        EditText editText;
        Drawable textCursorDrawable;
        super.addView(view, i11, layoutParams);
        if (view instanceof EditText) {
            EditText editText2 = getEditText();
            if (editText2 != null) {
                com.sumsub.sns.core.presentation.helper.a.f31095a.a((TextView) editText2, SNSTypographyElement.SUBTITLE2, SNSColorElement.FIELD_CONTENT);
            }
            com.sumsub.sns.core.presentation.helper.a aVar = com.sumsub.sns.core.presentation.helper.a.f31095a;
            SNSColorElement sNSColorElement = SNSColorElement.FIELD_TINT;
            d a12 = aVar.a();
            if (a12 != null && (a11 = aVar.a(a12, sNSColorElement, aVar.a((View) this))) != null) {
                int intValue = a11.intValue();
                if (!(Build.VERSION.SDK_INT < 29 || (editText = getEditText()) == null || (textCursorDrawable = editText.getTextCursorDrawable()) == null)) {
                    textCursorDrawable.setTint(intValue);
                }
                EditText editText3 = getEditText();
                if (editText3 != null) {
                    editText3.setHighlightColor(intValue);
                }
            }
        }
    }

    public SNSStepState getSNSStepState() {
        SNSStepState sNSStepState = this.stepState;
        return sNSStepState == null ? SNSStepState.INIT : sNSStepState;
    }

    public int[] onCreateDrawableState(int i11) {
        return View.mergeDrawableStates(super.onCreateDrawableState(i11 + 1), this.stepState != null ? SNSStepViewExtensionsKt.getSnsStepStateDrawable(this) : new int[]{R.attr.sns_stateInit});
    }

    public void onMeasure(int i11, int i12) {
        com.sumsub.sns.core.presentation.helper.a aVar = com.sumsub.sns.core.presentation.helper.a.f31095a;
        d a11 = aVar.a();
        Float a12 = a11 != null ? aVar.a(a11, SNSMetricElement.FIELD_HEIGHT) : null;
        if (a12 != null) {
            EditText editText = getEditText();
            if (editText != null) {
                editText.setHeight((int) a12.floatValue());
            }
            super.onMeasure(i11, View.MeasureSpec.makeMeasureSpec((int) a12.floatValue(), 0));
            return;
        }
        super.onMeasure(i11, i12);
    }

    public void setEndIconDrawable(Drawable drawable) {
        Integer a11;
        super.setEndIconDrawable(drawable);
        com.sumsub.sns.core.presentation.helper.a aVar = com.sumsub.sns.core.presentation.helper.a.f31095a;
        SNSColorElement sNSColorElement = SNSColorElement.CONTENT_WEAK;
        d a12 = aVar.a();
        if (a12 != null && (a11 = aVar.a(a12, sNSColorElement, aVar.a((View) this))) != null) {
            int intValue = a11.intValue();
            setEndIconTintList((ColorStateList) null);
            setEndIconTintList(ColorStateList.valueOf(intValue));
        }
    }

    public void setError(CharSequence charSequence) {
        Integer num;
        super.setError(charSequence);
        boolean z11 = false;
        setSNSStepState(charSequence == null || StringsKt__StringsJVMKt.z(charSequence) ? SNSStepState.INIT : SNSStepState.REJECTED);
        if (charSequence != null) {
            if (charSequence.length() > 0) {
                z11 = true;
            }
        }
        if (z11) {
            num = this.backgroundColorError;
        } else {
            num = this.backgroundColorNormal;
        }
        if (num != null) {
            setBoxBackgroundColor(num.intValue());
        }
        setErrorTextColor(this.errorColor);
        Integer num2 = this.hintColor;
        if (num2 != null) {
            int intValue = num2.intValue();
            EditText editText = getEditText();
            if (editText != null) {
                editText.setHintTextColor(intValue);
            }
        }
    }

    public void setSNSStepState(SNSStepState sNSStepState) {
        if (sNSStepState != this.stepState) {
            this.stepState = sNSStepState;
            setBoxBackgroundColor(this.editorBackgroundColor.getColorForState(SNSStepViewExtensionsKt.getSnsStepStateDrawable(this), getBoxBackgroundColor()));
            refreshDrawableState();
        }
    }

    public void setStartIconDrawable(Drawable drawable) {
        Integer a11;
        super.setStartIconDrawable(drawable);
        com.sumsub.sns.core.presentation.helper.a aVar = com.sumsub.sns.core.presentation.helper.a.f31095a;
        SNSColorElement sNSColorElement = SNSColorElement.CONTENT_WEAK;
        d a12 = aVar.a();
        if (a12 != null && (a11 = aVar.a(a12, sNSColorElement, aVar.a((View) this))) != null) {
            int intValue = a11.intValue();
            setStartIconTintList((ColorStateList) null);
            setStartIconTintList(ColorStateList.valueOf(intValue));
        }
    }

    public SNSTextInputLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, (r) null);
    }

    public SNSTextInputLayout(Context context, AttributeSet attributeSet, int i11) {
        this(context, attributeSet, i11, 0, 8, (r) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SNSTextInputLayout(Context context, AttributeSet attributeSet, int i11, int i12, int i13, r rVar) {
        this(context, (i13 & 2) != 0 ? null : attributeSet, (i13 & 4) != 0 ? R.attr.sns_TextInputLayoutStyle : i11, (i13 & 8) != 0 ? R.style.Widget_SNSTextInputLayout : i12);
    }

    public SNSTextInputLayout(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11);
        ColorStateList colorStateList;
        Float a11;
        Integer a12;
        Integer a13;
        Integer a14;
        this.stepState = SNSStepState.INIT;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SNSTextInputLayout, i11, i12);
        int i13 = R.styleable.SNSTextInputLayout_sns_editorBackgroundColor;
        if (obtainStyledAttributes.hasValue(i13)) {
            colorStateList = i.a(obtainStyledAttributes, context, i13);
        } else {
            colorStateList = ColorStateList.valueOf(getBoxBackgroundColor());
        }
        this.editorBackgroundColor = colorStateList;
        obtainStyledAttributes.recycle();
        this.errorColor = ColorStateList.valueOf(i.a(context, com.google.android.material.R.attr.colorOnError));
        com.sumsub.sns.core.presentation.helper.a aVar = com.sumsub.sns.core.presentation.helper.a.f31095a;
        SNSColorElement sNSColorElement = SNSColorElement.CONTENT_WEAK;
        d a15 = aVar.a();
        if (!(a15 == null || (a14 = aVar.a(a15, sNSColorElement, aVar.a((View) this))) == null)) {
            int intValue = a14.intValue();
            setEndIconTintList(ColorStateList.valueOf(intValue));
            setStartIconTintList(ColorStateList.valueOf(intValue));
        }
        SNSColorElement sNSColorElement2 = SNSColorElement.FIELD_BACKGROUND;
        d a16 = aVar.a();
        if (!(a16 == null || (a13 = aVar.a(a16, sNSColorElement2, aVar.a((View) this))) == null)) {
            int intValue2 = a13.intValue();
            this.backgroundColorNormal = Integer.valueOf(intValue2);
            setBoxBackgroundColor(intValue2);
        }
        Integer a17 = aVar.a((View) this, SNSColorElement.FIELD_BACKGROUND_INVALID);
        a17 = a17 == null ? aVar.a((View) this, SNSColorElement.BACKGROUND_CRITICAL) : a17;
        if (a17 != null) {
            this.backgroundColorError = Integer.valueOf(a17.intValue());
        }
        Integer a18 = aVar.a((View) this, SNSColorElement.FIELD_BORDER);
        Float a19 = aVar.a(SNSMetricElement.FIELD_BORDER_WIDTH);
        int floatValue = a19 != null ? (int) a19.floatValue() : 0;
        if (a18 != null && floatValue > 0) {
            Integer a21 = aVar.a((View) this, SNSColorElement.FIELD_BORDER_FOCUSED);
            int intValue3 = a21 != null ? a21.intValue() : a18.intValue();
            Integer a22 = aVar.a((View) this, SNSColorElement.FIELD_BORDER_DISABLED);
            setBoxStrokeColorStateList(new ColorStateList(new int[][]{new int[]{-16842910}, new int[]{16842908}, new int[0]}, new int[]{a22 != null ? a22.intValue() : a18.intValue(), intValue3, a18.intValue()}));
            setBoxStrokeWidth(floatValue);
            setBoxStrokeWidthFocused(floatValue);
        }
        SNSColorElement sNSColorElement3 = SNSColorElement.FIELD_PLACEHOLDER;
        d a23 = aVar.a();
        if (!(a23 == null || (a12 = aVar.a(a23, sNSColorElement3, aVar.a((View) this))) == null)) {
            this.hintColor = Integer.valueOf(a12.intValue());
        }
        SNSMetricElement sNSMetricElement = SNSMetricElement.FIELD_CORNER_RADIUS;
        d a24 = aVar.a();
        if (a24 != null && (a11 = aVar.a(a24, sNSMetricElement)) != null) {
            float floatValue2 = a11.floatValue();
            setBoxCornerRadii(floatValue2, floatValue2, floatValue2, floatValue2);
        }
    }
}
