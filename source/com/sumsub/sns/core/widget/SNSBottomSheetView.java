package com.sumsub.sns.core.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.sumsub.sns.R;
import com.sumsub.sns.core.presentation.helper.a;
import com.sumsub.sns.core.theme.SNSColorElement;
import com.sumsub.sns.core.theme.SNSMetricElement;
import com.sumsub.sns.internal.core.theme.d;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.r;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/sumsub/sns/core/widget/SNSBottomSheetView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "shapeAppearanceModel", "Lcom/google/android/material/shape/ShapeAppearanceModel;", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public class SNSBottomSheetView extends FrameLayout {
    private final ShapeAppearanceModel shapeAppearanceModel;

    public SNSBottomSheetView(Context context) {
        this(context, (AttributeSet) null, 0, 0, 14, (r) null);
    }

    public SNSBottomSheetView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, (r) null);
    }

    public SNSBottomSheetView(Context context, AttributeSet attributeSet, int i11) {
        this(context, attributeSet, i11, 0, 8, (r) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SNSBottomSheetView(Context context, AttributeSet attributeSet, int i11, int i12, int i13, r rVar) {
        this(context, (i13 & 2) != 0 ? null : attributeSet, (i13 & 4) != 0 ? R.attr.sns_BottomSheetViewStyle : i11, (i13 & 8) != 0 ? R.style.Widget_SNSBottomSheetView : i12);
    }

    public SNSBottomSheetView(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11);
        Integer a11;
        ShapeAppearanceModel build = ShapeAppearanceModel.builder(context, attributeSet, i11, i12).build();
        this.shapeAppearanceModel = build;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SNSBottomSheetView, i11, i12);
        int i13 = R.styleable.SNSBottomSheetView_android_background;
        if (obtainStyledAttributes.hasValue(i13)) {
            setBackground(obtainStyledAttributes.getDrawable(i13));
        }
        int i14 = R.styleable.SNSBottomSheetView_backgroundColor;
        float f11 = 0.0f;
        if (obtainStyledAttributes.hasValue(i14)) {
            MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(build.toBuilder().setBottomLeftCorner(0, 0.0f).setBottomRightCorner(0, 0.0f).build());
            materialShapeDrawable.setFillColor(obtainStyledAttributes.getColorStateList(i14));
            setBackground(materialShapeDrawable);
        }
        Unit unit = Unit.f56620a;
        obtainStyledAttributes.recycle();
        a aVar = a.f31095a;
        Float a12 = aVar.a(SNSMetricElement.BOTTOM_SHEET_CORNER_RADIUS);
        f11 = a12 != null ? a12.floatValue() : f11;
        SNSColorElement sNSColorElement = SNSColorElement.BOTTOM_SHEET_BACKGROUND;
        d a13 = aVar.a();
        if (a13 != null && (a11 = aVar.a(a13, sNSColorElement, aVar.a((View) this))) != null) {
            int intValue = a11.intValue();
            MaterialShapeDrawable materialShapeDrawable2 = new MaterialShapeDrawable(build.toBuilder().setTopLeftCorner(0, f11).setTopRightCorner(0, f11).build());
            materialShapeDrawable2.setFillColor(ColorStateList.valueOf(intValue));
            setBackground(materialShapeDrawable2);
        }
    }
}
