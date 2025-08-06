package com.sumsub.sns.core.theme.utils;

import android.view.View;
import com.google.android.material.card.MaterialCardView;
import com.sumsub.sns.core.presentation.helper.a;
import com.sumsub.sns.core.theme.SNSColorElement;
import com.sumsub.sns.core.theme.SNSThemeMetric;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"applyStyle", "", "Lcom/google/android/material/card/MaterialCardView;", "style", "Lcom/sumsub/sns/core/theme/SNSThemeMetric$CardStyle;", "idensic-mobile-sdk-aar_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class CardViewExtensionsKt {
    public static final void applyStyle(MaterialCardView materialCardView, SNSThemeMetric.CardStyle cardStyle) {
        if (cardStyle == SNSThemeMetric.CardStyle.BORDERED) {
            a aVar = a.f31095a;
            Integer a11 = aVar.a((View) materialCardView, SNSColorElement.CONTENT_INFO);
            Integer a12 = aVar.a((View) materialCardView, SNSColorElement.CONTENT_WEAK);
            if (!materialCardView.isSelected()) {
                a11 = a12;
            }
            if (a11 != null) {
                materialCardView.setStrokeColor(a11.intValue());
                return;
            }
            return;
        }
        com.sumsub.sns.internal.log.a aVar2 = com.sumsub.sns.internal.log.a.f34862a;
        com.sumsub.log.logger.a.e(aVar2, "Theme", "applyStyle: " + cardStyle + " NOT supported", (Throwable) null, 4, (Object) null);
    }
}
