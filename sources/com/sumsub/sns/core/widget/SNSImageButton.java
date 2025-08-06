package com.sumsub.sns.core.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.core.view.h0;
import androidx.core.widget.h;
import com.sumsub.sns.R;
import com.sumsub.sns.core.presentation.helper.a;
import com.sumsub.sns.core.theme.SNSColorElement;
import com.sumsub.sns.internal.core.common.i;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.r;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"Lcom/sumsub/sns/core/widget/SNSImageButton;", "Landroidx/appcompat/widget/AppCompatImageButton;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SNSImageButton extends AppCompatImageButton {
    public SNSImageButton(Context context) {
        this(context, (AttributeSet) null, 0, 0, 14, (r) null);
    }

    public SNSImageButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, (r) null);
    }

    public SNSImageButton(Context context, AttributeSet attributeSet, int i11) {
        this(context, attributeSet, i11, 0, 8, (r) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SNSImageButton(Context context, AttributeSet attributeSet, int i11, int i12, int i13, r rVar) {
        this(context, (i13 & 2) != 0 ? null : attributeSet, (i13 & 4) != 0 ? R.attr.sns_ImageButtonStyle : i11, (i13 & 8) != 0 ? R.style.Widget_SNSImageButton : i12);
    }

    public SNSImageButton(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SNSImageButton, i11, i12);
        int i13 = R.styleable.SNSImageButton_android_tint;
        if (obtainStyledAttributes.hasValue(i13)) {
            h.c(this, i.a(obtainStyledAttributes, context, i13));
        }
        int i14 = R.styleable.SNSImageButton_android_backgroundTint;
        if (obtainStyledAttributes.hasValue(i14)) {
            h0.C0(this, i.a(obtainStyledAttributes, context, i14));
        }
        int i15 = R.styleable.SNSImageButton_android_background;
        if (obtainStyledAttributes.hasValue(i15)) {
            setBackground(obtainStyledAttributes.getDrawable(i15));
        }
        Unit unit = Unit.f56620a;
        obtainStyledAttributes.recycle();
        a aVar = a.f31095a;
        if (aVar.a() != null) {
            Integer a11 = aVar.a((View) this, SNSColorElement.SECONDARY_BUTTON_CONTENT);
            int intValue = a11 != null ? a11.intValue() : 0;
            Integer a12 = aVar.a((View) this, SNSColorElement.SECONDARY_BUTTON_CONTENT_DISABLED);
            int intValue2 = a12 != null ? a12.intValue() : 0;
            Integer a13 = aVar.a((View) this, SNSColorElement.SECONDARY_BUTTON_CONTENT_HIGHLIGHTED);
            h.c(this, new ColorStateList(new int[][]{new int[]{-16842910}, new int[]{16842919}, new int[0]}, new int[]{intValue2, a13 != null ? a13.intValue() : 0, intValue}));
        }
    }
}
