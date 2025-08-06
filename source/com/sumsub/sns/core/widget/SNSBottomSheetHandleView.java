package com.sumsub.sns.core.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.widget.h;
import com.sumsub.sns.R;
import com.sumsub.sns.core.presentation.helper.a;
import com.sumsub.sns.core.theme.SNSColorElement;
import com.sumsub.sns.core.theme.SNSMetricElement;
import com.sumsub.sns.internal.core.theme.b;
import com.sumsub.sns.internal.core.theme.d;
import kotlin.Metadata;
import kotlin.jvm.internal.r;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0007H\u0014¨\u0006\r"}, d2 = {"Lcom/sumsub/sns/core/widget/SNSBottomSheetHandleView;", "Landroidx/appcompat/widget/AppCompatImageView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "onMeasure", "", "widthMeasureSpec", "heightMeasureSpec", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SNSBottomSheetHandleView extends AppCompatImageView {
    public SNSBottomSheetHandleView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (r) null);
    }

    public void onMeasure(int i11, int i12) {
        a aVar = a.f31095a;
        d a11 = aVar.a();
        Float f11 = null;
        b.e b11 = a11 != null ? aVar.b(a11, SNSMetricElement.BOTTOM_SHEET_HANDLE_SIZE) : null;
        Float d11 = b11 != null ? b11.d() : null;
        if (b11 != null) {
            f11 = b11.c();
        }
        if (d11 == null || f11 == null) {
            super.onMeasure(i11, i12);
        } else {
            setMeasuredDimension(View.resolveSizeAndState((int) d11.floatValue(), i11, 0), View.resolveSizeAndState((int) f11.floatValue(), i12, 0));
        }
    }

    public SNSBottomSheetHandleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (r) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SNSBottomSheetHandleView(Context context, AttributeSet attributeSet, int i11, int i12, r rVar) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? R.attr.sns_BottomSheetHandleStyle : i11);
    }

    public SNSBottomSheetHandleView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Integer a11;
        Float c11;
        a aVar = a.f31095a;
        b.e b11 = aVar.b(SNSMetricElement.BOTTOM_SHEET_HANDLE_SIZE);
        if (!(b11 == null || (c11 = b11.c()) == null)) {
            float floatValue = c11.floatValue();
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius(floatValue / 2.0f);
            setImageDrawable(gradientDrawable);
        }
        SNSColorElement sNSColorElement = SNSColorElement.BOTTOM_SHEET_HANDLE;
        d a12 = aVar.a();
        if (a12 != null && (a11 = aVar.a(a12, sNSColorElement, aVar.a((View) this))) != null) {
            h.c(this, ColorStateList.valueOf(a11.intValue()));
        }
    }
}
