package com.sumsub.sns.core.theme;

import d10.l;
import kotlin.Metadata;
import kotlin.Unit;

@Metadata(bv = {}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u001a\u001e\u0010\u0005\u001a\u00020\u0003*\u00020\u00002\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001\u001a\u001e\u0010\u0007\u001a\u00020\u0003*\u00020\u00002\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u0001\u001a\u001e\u0010\t\u001a\u00020\u0003*\u00020\u00002\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00030\u0001\u001a\u001a\u0010\n\u001a\u00020\u00002\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00030\u0001\u001a\u0006\u0010\f\u001a\u00020\u000b\"\u0015\u0010\u0005\u001a\u00020\u0002*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e\"\u0015\u0010\u0007\u001a\u00020\u0006*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010\"\u0015\u0010\t\u001a\u00020\b*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/sumsub/sns/core/theme/SNSTheme;", "Lkotlin/Function1;", "Lcom/sumsub/sns/core/theme/MetricsScope;", "", "block", "metrics", "Lcom/sumsub/sns/core/theme/FontsScope;", "fonts", "Lcom/sumsub/sns/core/theme/ColorsScope;", "colors", "SNSTheme", "Lcom/sumsub/sns/core/theme/SNSThemeHolder;", "newSNSTheme", "getMetrics", "(Lcom/sumsub/sns/core/theme/SNSTheme;)Lcom/sumsub/sns/core/theme/MetricsScope;", "getFonts", "(Lcom/sumsub/sns/core/theme/SNSTheme;)Lcom/sumsub/sns/core/theme/FontsScope;", "getColors", "(Lcom/sumsub/sns/core/theme/SNSTheme;)Lcom/sumsub/sns/core/theme/ColorsScope;", "idensic-mobile-sdk-aar_release"}, k = 2, mv = {1, 7, 1})
public final class SNSThemeKt {
    public static final SNSTheme SNSTheme(l<? super SNSTheme, Unit> lVar) {
        SNSThemeImpl sNSThemeImpl = new SNSThemeImpl();
        lVar.invoke(sNSThemeImpl);
        return sNSThemeImpl;
    }

    public static final void colors(SNSTheme sNSTheme, l<? super ColorsScope, Unit> lVar) {
        lVar.invoke(((SNSThemeImpl) sNSTheme).getColorsScope$idensic_mobile_sdk_aar_release());
    }

    public static final void fonts(SNSTheme sNSTheme, l<? super FontsScope, Unit> lVar) {
        lVar.invoke(((SNSThemeImpl) sNSTheme).getFontsScope$idensic_mobile_sdk_aar_release());
    }

    public static final ColorsScope getColors(SNSTheme sNSTheme) {
        return ((SNSThemeImpl) sNSTheme).getColorsScope$idensic_mobile_sdk_aar_release();
    }

    public static final FontsScope getFonts(SNSTheme sNSTheme) {
        return ((SNSThemeImpl) sNSTheme).getFontsScope$idensic_mobile_sdk_aar_release();
    }

    public static final MetricsScope getMetrics(SNSTheme sNSTheme) {
        return ((SNSThemeImpl) sNSTheme).getMetricsScope$idensic_mobile_sdk_aar_release();
    }

    public static final void metrics(SNSTheme sNSTheme, l<? super MetricsScope, Unit> lVar) {
        lVar.invoke(((SNSThemeImpl) sNSTheme).getMetricsScope$idensic_mobile_sdk_aar_release());
    }

    public static final SNSThemeHolder newSNSTheme() {
        return new SNSThemeImpl();
    }
}
