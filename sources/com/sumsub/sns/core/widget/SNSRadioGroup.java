package com.sumsub.sns.core.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.sumsub.sns.R;
import com.sumsub.sns.core.theme.SNSColorElement;
import com.sumsub.sns.core.theme.SNSMetricElement;
import com.sumsub.sns.internal.core.common.i;
import com.sumsub.sns.internal.core.theme.d;
import com.sumsub.sns.internal.core.widget.SNSStepState;
import com.sumsub.sns.internal.core.widget.a;
import kotlin.Metadata;
import kotlin.jvm.internal.r;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B1\b\u0007\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001e\u0012\b\b\u0002\u0010 \u001a\u00020\b\u0012\b\b\u0002\u0010!\u001a\u00020\b¢\u0006\u0004\b\"\u0010#J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0003H\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0014J \u0010\u0011\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016R\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0018\u001a\u00020\u00178\u0000X\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006$"}, d2 = {"Lcom/sumsub/sns/core/widget/SNSRadioGroup;", "Landroid/widget/RadioGroup;", "Lcom/sumsub/sns/internal/core/widget/a;", "Lcom/sumsub/sns/internal/core/widget/SNSStepState;", "getSNSStepState", "state", "", "setSNSStepState", "", "extraSpace", "", "onCreateDrawableState", "Landroid/view/View;", "child", "index", "Landroid/view/ViewGroup$LayoutParams;", "params", "addView", "Lcom/google/android/material/shape/ShapeAppearanceModel;", "shapeAppearanceModel", "Lcom/google/android/material/shape/ShapeAppearanceModel;", "stepState", "Lcom/sumsub/sns/internal/core/widget/SNSStepState;", "Lcom/google/android/material/shape/MaterialShapeDrawable;", "boxBackground", "Lcom/google/android/material/shape/MaterialShapeDrawable;", "getBoxBackground$idensic_mobile_sdk_aar_release", "()Lcom/google/android/material/shape/MaterialShapeDrawable;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
public final class SNSRadioGroup extends RadioGroup implements a {
    private final MaterialShapeDrawable boxBackground;
    private final ShapeAppearanceModel shapeAppearanceModel;
    private SNSStepState stepState;

    public SNSRadioGroup(Context context) {
        this(context, (AttributeSet) null, 0, 0, 14, (r) null);
    }

    public void addView(View view, int i11, ViewGroup.LayoutParams layoutParams) {
        Integer a11;
        super.addView(view, i11, layoutParams);
        com.sumsub.sns.core.presentation.helper.a aVar = com.sumsub.sns.core.presentation.helper.a.f31095a;
        d a12 = aVar.a();
        if ((view instanceof RadioButton) && a12 != null) {
            SNSColorElement sNSColorElement = SNSColorElement.CONTENT_WEAK;
            d a13 = aVar.a();
            if (a13 != null && (a11 = aVar.a(a13, sNSColorElement, aVar.a((View) this))) != null) {
                int intValue = a11.intValue();
                int[][] iArr = {new int[]{-16842912}, new int[]{16842912}};
                int[] iArr2 = new int[2];
                iArr2[0] = intValue;
                Integer a14 = aVar.a((View) this, SNSColorElement.FIELD_TINT);
                if (a14 != null) {
                    intValue = a14.intValue();
                }
                iArr2[1] = intValue;
                ((RadioButton) view).setButtonTintList(new ColorStateList(iArr, iArr2));
            }
        }
    }

    public final MaterialShapeDrawable getBoxBackground$idensic_mobile_sdk_aar_release() {
        return this.boxBackground;
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
            this.boxBackground.setState(SNSStepViewExtensionsKt.getSnsStepStateDrawable(this));
            refreshDrawableState();
        }
    }

    public SNSRadioGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, (r) null);
    }

    public SNSRadioGroup(Context context, AttributeSet attributeSet, int i11) {
        this(context, attributeSet, i11, 0, 8, (r) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SNSRadioGroup(Context context, AttributeSet attributeSet, int i11, int i12, int i13, r rVar) {
        this(context, (i13 & 2) != 0 ? null : attributeSet, (i13 & 4) != 0 ? R.attr.sns_RadioGroupStyle : i11, (i13 & 8) != 0 ? R.style.Widget_SNSRadioGroup : i12);
    }

    public SNSRadioGroup(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet);
        Float a11;
        Integer a12;
        ShapeAppearanceModel build = ShapeAppearanceModel.builder(context, attributeSet, i11, i12).build();
        this.shapeAppearanceModel = build;
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(build);
        this.boxBackground = materialShapeDrawable;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SNSRadioGroup, i11, i12);
        materialShapeDrawable.setFillColor(i.a(obtainStyledAttributes, context, R.styleable.SNSRadioGroup_sns_radioBackgroundColor));
        setBackground(materialShapeDrawable);
        setShowDividers(obtainStyledAttributes.getInt(R.styleable.SNSRadioGroup_android_showDividers, 0));
        setDividerDrawable(obtainStyledAttributes.getDrawable(R.styleable.SNSRadioGroup_android_divider));
        obtainStyledAttributes.recycle();
        int[][] iArr = {new int[]{R.attr.sns_stateInit}, new int[]{R.attr.sns_stateRejected}, new int[0]};
        com.sumsub.sns.core.presentation.helper.a aVar = com.sumsub.sns.core.presentation.helper.a.f31095a;
        Integer a13 = aVar.a((View) this, SNSColorElement.FIELD_BACKGROUND_INVALID);
        a13 = a13 == null ? aVar.a((View) this, SNSColorElement.BACKGROUND_CRITICAL) : a13;
        if (a13 != null) {
            materialShapeDrawable.setFillColor(new ColorStateList(iArr, new int[]{0, a13.intValue(), 0}));
        }
        SNSColorElement sNSColorElement = SNSColorElement.LIST_SEPARATOR;
        d a14 = aVar.a();
        if (!(a14 == null || (a12 = aVar.a(a14, sNSColorElement, aVar.a((View) this))) == null)) {
            getDividerDrawable().setColorFilter(new PorterDuffColorFilter(a12.intValue(), PorterDuff.Mode.SRC));
        }
        SNSMetricElement sNSMetricElement = SNSMetricElement.FIELD_CORNER_RADIUS;
        d a15 = aVar.a();
        if (a15 != null && (a11 = aVar.a(a15, sNSMetricElement)) != null) {
            materialShapeDrawable.setCornerSize(a11.floatValue());
        }
    }
}
