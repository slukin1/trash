package com.sumsub.sns.core.theme;

import com.adjust.sdk.Constants;
import com.hbg.lib.network.pro.core.bean.ChainInfo;
import com.sumsub.sns.core.a;
import kotlin.Metadata;

@a
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0005À\u0006\u0001"}, d2 = {"Lcom/sumsub/sns/core/theme/SNSThemeMetric;", "", "CardStyle", "Size", "TextAlignment", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface SNSThemeMetric {

    @a
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/sumsub/sns/core/theme/SNSThemeMetric$CardStyle;", "", "Lcom/sumsub/sns/core/theme/SNSThemeMetric;", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "BORDERED", "PLAIN", "DEFAULT", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public enum CardStyle implements SNSThemeMetric {
        BORDERED("bordered"),
        PLAIN(ChainInfo.CHAIN_TYPE_PLAIN),
        DEFAULT("default");
        
        private final String value;

        private CardStyle(String str) {
            this.value = str;
        }

        public final String getValue() {
            return this.value;
        }
    }

    @a
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/sumsub/sns/core/theme/SNSThemeMetric$Size;", "", "Lcom/sumsub/sns/core/theme/SNSThemeMetric;", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "SMALL", "MEDIUM", "LARGE", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public enum Size implements SNSThemeMetric {
        SMALL(Constants.SMALL),
        MEDIUM("medium"),
        LARGE(Constants.LARGE);
        
        private final String value;

        private Size(String str) {
            this.value = str;
        }

        public final String getValue() {
            return this.value;
        }
    }

    @a
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/sumsub/sns/core/theme/SNSThemeMetric$TextAlignment;", "", "Lcom/sumsub/sns/core/theme/SNSThemeMetric;", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "LEFT", "CENTER", "RIGHT", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public enum TextAlignment implements SNSThemeMetric {
        LEFT("left"),
        CENTER(TtmlNode.CENTER),
        RIGHT(TtmlNode.RIGHT);
        
        private final String value;

        private TextAlignment(String str) {
            this.value = str;
        }

        public final String getValue() {
            return this.value;
        }
    }
}
