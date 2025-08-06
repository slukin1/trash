package com.sumsub.sns.core.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import com.google.android.material.R;
import kotlin.Metadata;
import kotlin.jvm.internal.r;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0007H\u0014¨\u0006\r"}, d2 = {"Lcom/sumsub/sns/core/widget/SNSProgressBarView;", "Landroid/widget/ProgressBar;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "onMeasure", "", "widthMeasureSpec", "heightMeasureSpec", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SNSProgressBarView extends ProgressBar {
    public SNSProgressBarView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (r) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0009, code lost:
        r0 = r0.c();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r4, int r5) {
        /*
            r3 = this;
            com.sumsub.sns.core.presentation.helper.a r0 = com.sumsub.sns.core.presentation.helper.a.f31095a
            com.sumsub.sns.internal.core.theme.d r0 = r0.a()
            r1 = 0
            if (r0 == 0) goto L_0x001c
            java.util.Map r0 = r0.c()
            if (r0 == 0) goto L_0x001c
            com.sumsub.sns.core.theme.SNSMetricElement r2 = com.sumsub.sns.core.theme.SNSMetricElement.ACTIVITY_INDICATOR_STYLE
            java.lang.String r2 = r2.getValue()
            java.lang.Object r0 = r0.get(r2)
            com.sumsub.sns.internal.core.theme.b r0 = (com.sumsub.sns.internal.core.theme.b) r0
            goto L_0x001d
        L_0x001c:
            r0 = r1
        L_0x001d:
            boolean r2 = r0 instanceof com.sumsub.sns.internal.core.theme.b.f
            if (r2 == 0) goto L_0x0024
            r1 = r0
            com.sumsub.sns.internal.core.theme.b$f r1 = (com.sumsub.sns.internal.core.theme.b.f) r1
        L_0x0024:
            if (r1 == 0) goto L_0x007a
            java.lang.String r4 = r1.b()
            com.sumsub.sns.core.theme.SNSThemeMetric$Size r5 = com.sumsub.sns.core.theme.SNSThemeMetric.Size.LARGE
            java.lang.String r5 = r5.getValue()
            boolean r5 = kotlin.jvm.internal.x.b(r4, r5)
            if (r5 == 0) goto L_0x0041
            android.content.res.Resources r4 = r3.getResources()
            int r5 = com.sumsub.sns.R.dimen.sns_progress_bar_size_large
            int r4 = r4.getDimensionPixelSize(r5)
            goto L_0x0062
        L_0x0041:
            com.sumsub.sns.core.theme.SNSThemeMetric$Size r5 = com.sumsub.sns.core.theme.SNSThemeMetric.Size.SMALL
            java.lang.String r5 = r5.getValue()
            boolean r4 = kotlin.jvm.internal.x.b(r4, r5)
            if (r4 == 0) goto L_0x0058
            android.content.res.Resources r4 = r3.getResources()
            int r5 = com.sumsub.sns.R.dimen.sns_progress_bar_size_small
            int r4 = r4.getDimensionPixelSize(r5)
            goto L_0x0062
        L_0x0058:
            android.content.res.Resources r4 = r3.getResources()
            int r5 = com.sumsub.sns.R.dimen.sns_progress_bar_size_medium
            int r4 = r4.getDimensionPixelSize(r5)
        L_0x0062:
            int r5 = r3.getPaddingLeft()
            int r5 = r5 + r4
            int r0 = r3.getPaddingRight()
            int r5 = r5 + r0
            int r0 = r3.getPaddingBottom()
            int r4 = r4 + r0
            int r0 = r3.getPaddingTop()
            int r4 = r4 + r0
            r3.setMeasuredDimension(r5, r4)
            goto L_0x007d
        L_0x007a:
            super.onMeasure(r4, r5)
        L_0x007d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.core.widget.SNSProgressBarView.onMeasure(int, int):void");
    }

    public SNSProgressBarView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (r) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SNSProgressBarView(Context context, AttributeSet attributeSet, int i11, int i12, r rVar) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? R.attr.progressBarStyle : i11);
    }

    public SNSProgressBarView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
    }
}
