package com.sumsub.sns.core.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.view.h0;
import androidx.core.widget.h;
import com.sumsub.sns.R;
import com.sumsub.sns.core.theme.SNSColorElement;
import com.sumsub.sns.internal.core.common.i;
import com.sumsub.sns.internal.core.widget.SNSStepState;
import com.sumsub.sns.internal.core.widget.a;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.r;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B1\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0007H\u0016R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0016"}, d2 = {"Lcom/sumsub/sns/core/widget/SNSImageView;", "Landroidx/appcompat/widget/AppCompatImageView;", "Lcom/sumsub/sns/internal/core/widget/a;", "", "extraSpace", "", "onCreateDrawableState", "Lcom/sumsub/sns/internal/core/widget/SNSStepState;", "getSNSStepState", "state", "", "setSNSStepState", "stepState", "Lcom/sumsub/sns/internal/core/widget/SNSStepState;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
public final class SNSImageView extends AppCompatImageView implements a {
    private SNSStepState stepState;

    public SNSImageView(Context context) {
        this(context, (AttributeSet) null, 0, 0, 14, (r) null);
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

    public SNSImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, (r) null);
    }

    public SNSImageView(Context context, AttributeSet attributeSet, int i11) {
        this(context, attributeSet, i11, 0, 8, (r) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SNSImageView(Context context, AttributeSet attributeSet, int i11, int i12, int i13, r rVar) {
        this(context, (i13 & 2) != 0 ? null : attributeSet, (i13 & 4) != 0 ? R.attr.sns_ImageViewStyle : i11, (i13 & 8) != 0 ? R.style.Widget_SNSImageView : i12);
    }

    public SNSImageView(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11);
        this.stepState = SNSStepState.INIT;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SNSImageView, i11, i12);
        int i13 = R.styleable.SNSImageView_android_tint;
        if (obtainStyledAttributes.hasValue(i13)) {
            h.c(this, i.a(obtainStyledAttributes, context, i13));
        }
        int i14 = R.styleable.SNSImageView_android_backgroundTint;
        if (obtainStyledAttributes.hasValue(i14)) {
            h0.C0(this, i.a(obtainStyledAttributes, context, i14));
        }
        Unit unit = Unit.f56620a;
        obtainStyledAttributes.recycle();
        com.sumsub.sns.core.presentation.helper.a aVar = com.sumsub.sns.core.presentation.helper.a.f31095a;
        if (aVar.a() != null) {
            int[][] b11 = aVar.b();
            SNSColorElement sNSColorElement = SNSColorElement.BACKGROUND_NEUTRAL;
            Integer a11 = aVar.a((View) this, sNSColorElement);
            int intValue = a11 != null ? a11.intValue() : 0;
            SNSColorElement sNSColorElement2 = SNSColorElement.BACKGROUND_WARNING;
            Integer a12 = aVar.a((View) this, sNSColorElement2);
            int intValue2 = a12 != null ? a12.intValue() : 0;
            Integer a13 = aVar.a((View) this, SNSColorElement.BACKGROUND_SUCCESS);
            int intValue3 = a13 != null ? a13.intValue() : 0;
            Integer a14 = aVar.a((View) this, SNSColorElement.BACKGROUND_CRITICAL);
            int intValue4 = a14 != null ? a14.intValue() : 0;
            Integer a15 = aVar.a((View) this, sNSColorElement2);
            int intValue5 = a15 != null ? a15.intValue() : 0;
            Integer a16 = aVar.a((View) this, sNSColorElement);
            h0.C0(this, new ColorStateList(b11, new int[]{intValue, intValue2, intValue3, intValue4, intValue5, a16 != null ? a16.intValue() : 0}));
        }
    }
}
