package com.sumsub.sns.core.theme;

import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\u0014\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u001aH\u0016J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\u0014\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u001aH\u0016J\b\u0010!\u001a\u00020\"H\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u0010X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0010X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00180\u0010X\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/sumsub/sns/core/theme/SNSThemeImpl;", "Lcom/sumsub/sns/core/theme/SNSThemeHolder;", "()V", "ColorsScope", "Lcom/sumsub/sns/core/theme/ColorsScopeImpl;", "getColorsScope$idensic_mobile_sdk_aar_release", "()Lcom/sumsub/sns/core/theme/ColorsScopeImpl;", "FontsScope", "Lcom/sumsub/sns/core/theme/FontsScopeImpl;", "getFontsScope$idensic_mobile_sdk_aar_release", "()Lcom/sumsub/sns/core/theme/FontsScopeImpl;", "MetricsScope", "Lcom/sumsub/sns/core/theme/MetricsScopeImpl;", "getMetricsScope$idensic_mobile_sdk_aar_release", "()Lcom/sumsub/sns/core/theme/MetricsScopeImpl;", "colors", "Ljava/util/HashMap;", "Lcom/sumsub/sns/core/theme/SNSColorElement;", "Lcom/sumsub/sns/core/theme/SNSThemeColor;", "fonts", "Lcom/sumsub/sns/core/theme/SNSTypographyElement;", "Lcom/sumsub/sns/core/theme/SNSThemeFont;", "metrics", "Lcom/sumsub/sns/core/theme/SNSMetricElement;", "Ljava/lang/Object;", "getColors", "", "getColorsScope", "Lcom/sumsub/sns/core/theme/ColorsScope;", "getFonts", "getFontsScope", "Lcom/sumsub/sns/core/theme/FontsScope;", "getMetrics", "getMetricsScope", "Lcom/sumsub/sns/core/theme/MetricsScope;", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SNSThemeImpl implements SNSThemeHolder {
    private final ColorsScopeImpl ColorsScope;
    private final FontsScopeImpl FontsScope;
    private final MetricsScopeImpl MetricsScope;
    private final HashMap<SNSColorElement, SNSThemeColor> colors;
    private final HashMap<SNSTypographyElement, SNSThemeFont> fonts;
    private final HashMap<SNSMetricElement, Object> metrics;

    public SNSThemeImpl() {
        HashMap<SNSMetricElement, Object> hashMap = new HashMap<>();
        this.metrics = hashMap;
        this.MetricsScope = new MetricsScopeImpl(hashMap);
        HashMap<SNSTypographyElement, SNSThemeFont> hashMap2 = new HashMap<>();
        this.fonts = hashMap2;
        this.FontsScope = new FontsScopeImpl(hashMap2);
        HashMap<SNSColorElement, SNSThemeColor> hashMap3 = new HashMap<>();
        this.colors = hashMap3;
        this.ColorsScope = new ColorsScopeImpl(hashMap3);
    }

    public Map<SNSColorElement, SNSThemeColor> getColors() {
        return this.colors;
    }

    public ColorsScope getColorsScope() {
        return this.ColorsScope;
    }

    public final ColorsScopeImpl getColorsScope$idensic_mobile_sdk_aar_release() {
        return this.ColorsScope;
    }

    public Map<SNSTypographyElement, SNSThemeFont> getFonts() {
        return this.fonts;
    }

    public FontsScope getFontsScope() {
        return this.FontsScope;
    }

    public final FontsScopeImpl getFontsScope$idensic_mobile_sdk_aar_release() {
        return this.FontsScope;
    }

    public Map<SNSMetricElement, Object> getMetrics() {
        return this.metrics;
    }

    public MetricsScope getMetricsScope() {
        return this.MetricsScope;
    }

    public final MetricsScopeImpl getMetricsScope$idensic_mobile_sdk_aar_release() {
        return this.MetricsScope;
    }
}
