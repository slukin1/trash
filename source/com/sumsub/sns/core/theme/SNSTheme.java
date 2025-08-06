package com.sumsub.sns.core.theme;

import com.sumsub.sns.core.a;
import java.util.Map;
import kotlin.Metadata;

@a
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H&J\u0014\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0003H&J\u0014\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\u0003H&ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\fÀ\u0006\u0001"}, d2 = {"Lcom/sumsub/sns/core/theme/SNSTheme;", "", "getColors", "", "Lcom/sumsub/sns/core/theme/SNSColorElement;", "Lcom/sumsub/sns/core/theme/SNSThemeColor;", "getFonts", "Lcom/sumsub/sns/core/theme/SNSTypographyElement;", "Lcom/sumsub/sns/core/theme/SNSThemeFont;", "getMetrics", "Lcom/sumsub/sns/core/theme/SNSMetricElement;", "Ljava/lang/Object;", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface SNSTheme {
    Map<SNSColorElement, SNSThemeColor> getColors();

    Map<SNSTypographyElement, SNSThemeFont> getFonts();

    Map<SNSMetricElement, Object> getMetrics();
}
