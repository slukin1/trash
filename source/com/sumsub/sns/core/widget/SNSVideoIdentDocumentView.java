package com.sumsub.sns.core.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.sumsub.sns.R;
import com.sumsub.sns.core.presentation.helper.a;
import com.sumsub.sns.core.theme.SNSThemeMetric;
import com.sumsub.sns.core.theme.utils.CardViewExtensionsKt;
import com.sumsub.sns.internal.core.theme.d;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\b\u0010\f\u001a\u00020\rH\u0014R\u000e\u0010\n\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/sumsub/sns/core/widget/SNSVideoIdentDocumentView;", "Lcom/sumsub/sns/core/widget/SNSStepView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "activatedStrokeWidth", "defaultStrokeWidth", "drawableStateChanged", "", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SNSVideoIdentDocumentView extends SNSStepView {
    private int activatedStrokeWidth;
    private int defaultStrokeWidth;

    public SNSVideoIdentDocumentView(Context context) {
        this(context, (AttributeSet) null, 0, 0, 14, (r) null);
    }

    public void drawableStateChanged() {
        int i11;
        super.drawableStateChanged();
        if (isActivated()) {
            i11 = this.activatedStrokeWidth;
        } else {
            i11 = this.defaultStrokeWidth;
        }
        setStrokeWidth(i11);
        a aVar = a.f31095a;
        d a11 = aVar.a();
        if (a11 != null) {
            String c11 = aVar.c(a11, SNSVideoIdentDocumentViewKt.DEFAULT_CARD_STYLE);
            SNSThemeMetric.CardStyle cardStyle = SNSThemeMetric.CardStyle.BORDERED;
            if (x.b(c11, cardStyle.getValue())) {
                CardViewExtensionsKt.applyStyle(this, cardStyle);
            }
        }
    }

    public SNSVideoIdentDocumentView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, (r) null);
    }

    public SNSVideoIdentDocumentView(Context context, AttributeSet attributeSet, int i11) {
        this(context, attributeSet, i11, 0, 8, (r) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SNSVideoIdentDocumentView(Context context, AttributeSet attributeSet, int i11, int i12, int i13, r rVar) {
        this(context, (i13 & 2) != 0 ? null : attributeSet, (i13 & 4) != 0 ? R.attr.sns_VideoIdentDocumentViewStyle : i11, (i13 & 8) != 0 ? R.style.Widget_SNSVideoIdentDocumentView : i12);
    }

    public SNSVideoIdentDocumentView(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12, SNSVideoIdentDocumentViewKt.DEFAULT_CARD_STYLE);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SNSVideoIdentDocumentView, i11, i12);
        int i13 = R.styleable.SNSVideoIdentDocumentView_sns_stepStrokeWidthDefault;
        if (obtainStyledAttributes.hasValue(i13)) {
            int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(i13, 0);
            this.defaultStrokeWidth = dimensionPixelSize;
            setStrokeWidth(dimensionPixelSize);
        }
        int i14 = R.styleable.SNSVideoIdentDocumentView_sns_stepStrokeWidthActivated;
        if (obtainStyledAttributes.hasValue(i14)) {
            this.activatedStrokeWidth = obtainStyledAttributes.getDimensionPixelSize(i14, 0);
        }
        Unit unit = Unit.f56620a;
        obtainStyledAttributes.recycle();
    }
}
