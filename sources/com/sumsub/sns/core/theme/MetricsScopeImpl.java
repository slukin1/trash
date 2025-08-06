package com.sumsub.sns.core.theme;

import android.util.SizeF;
import com.sumsub.sns.core.theme.SNSThemeMetric;
import java.util.HashMap;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b/\n\u0002\u0018\u0002\n\u0002\b!\b\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\u0010\u0006R(\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b8V@VX\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR(\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0007\u001a\u0004\u0018\u00010\u000e8V@VX\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R(\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0007\u001a\u0004\u0018\u00010\u00148V@VX\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R(\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\b\u0010\u0007\u001a\u0004\u0018\u00010\u001a8V@VX\u000e¢\u0006\f\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR(\u0010 \u001a\u0004\u0018\u00010\u00142\b\u0010\u0007\u001a\u0004\u0018\u00010\u00148V@VX\u000e¢\u0006\f\u001a\u0004\b!\u0010\u0017\"\u0004\b\"\u0010\u0019R(\u0010#\u001a\u0004\u0018\u00010\u00142\b\u0010\u0007\u001a\u0004\u0018\u00010\u00148V@VX\u000e¢\u0006\f\u001a\u0004\b$\u0010\u0017\"\u0004\b%\u0010\u0019R(\u0010&\u001a\u0004\u0018\u00010\u00142\b\u0010\u0007\u001a\u0004\u0018\u00010\u00148V@VX\u000e¢\u0006\f\u001a\u0004\b'\u0010\u0017\"\u0004\b(\u0010\u0019R(\u0010)\u001a\u0004\u0018\u00010\u00142\b\u0010\u0007\u001a\u0004\u0018\u00010\u00148V@VX\u000e¢\u0006\f\u001a\u0004\b*\u0010\u0017\"\u0004\b+\u0010\u0019R(\u0010,\u001a\u0004\u0018\u00010\u00142\b\u0010\u0007\u001a\u0004\u0018\u00010\u00148V@VX\u000e¢\u0006\f\u001a\u0004\b-\u0010\u0017\"\u0004\b.\u0010\u0019R(\u0010/\u001a\u0004\u0018\u00010\u00142\b\u0010\u0007\u001a\u0004\u0018\u00010\u00148V@VX\u000e¢\u0006\f\u001a\u0004\b0\u0010\u0017\"\u0004\b1\u0010\u0019R(\u00102\u001a\u0004\u0018\u00010\u00142\b\u0010\u0007\u001a\u0004\u0018\u00010\u00148V@VX\u000e¢\u0006\f\u001a\u0004\b3\u0010\u0017\"\u0004\b4\u0010\u0019R(\u00105\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0007\u001a\u0004\u0018\u00010\u000e8V@VX\u000e¢\u0006\f\u001a\u0004\b6\u0010\u0011\"\u0004\b7\u0010\u0013R(\u00108\u001a\u0004\u0018\u00010\u00142\b\u0010\u0007\u001a\u0004\u0018\u00010\u00148V@VX\u000e¢\u0006\f\u001a\u0004\b9\u0010\u0017\"\u0004\b:\u0010\u0019R(\u0010;\u001a\u0004\u0018\u00010\u00142\b\u0010\u0007\u001a\u0004\u0018\u00010\u00148V@VX\u000e¢\u0006\f\u001a\u0004\b<\u0010\u0017\"\u0004\b=\u0010\u0019R(\u0010>\u001a\u0004\u0018\u00010\u00142\b\u0010\u0007\u001a\u0004\u0018\u00010\u00148V@VX\u000e¢\u0006\f\u001a\u0004\b?\u0010\u0017\"\u0004\b@\u0010\u0019R(\u0010A\u001a\u0004\u0018\u00010\u00142\b\u0010\u0007\u001a\u0004\u0018\u00010\u00148V@VX\u000e¢\u0006\f\u001a\u0004\bB\u0010\u0017\"\u0004\bC\u0010\u0019R(\u0010D\u001a\u0004\u0018\u00010\u00142\b\u0010\u0007\u001a\u0004\u0018\u00010\u00148V@VX\u000e¢\u0006\f\u001a\u0004\bE\u0010\u0017\"\u0004\bF\u0010\u0019R(\u0010G\u001a\u0004\u0018\u00010\u00142\b\u0010\u0007\u001a\u0004\u0018\u00010\u00148V@VX\u000e¢\u0006\f\u001a\u0004\bH\u0010\u0017\"\u0004\bI\u0010\u0019R\u001a\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0004¢\u0006\u0002\n\u0000R(\u0010K\u001a\u0004\u0018\u00010J2\b\u0010\u0007\u001a\u0004\u0018\u00010J8V@VX\u000e¢\u0006\f\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR(\u0010P\u001a\u0004\u0018\u00010\u00142\b\u0010\u0007\u001a\u0004\u0018\u00010\u00148V@VX\u000e¢\u0006\f\u001a\u0004\bQ\u0010\u0017\"\u0004\bR\u0010\u0019R(\u0010S\u001a\u0004\u0018\u00010J2\b\u0010\u0007\u001a\u0004\u0018\u00010J8V@VX\u000e¢\u0006\f\u001a\u0004\bT\u0010M\"\u0004\bU\u0010OR(\u0010V\u001a\u0004\u0018\u00010\u00142\b\u0010\u0007\u001a\u0004\u0018\u00010\u00148V@VX\u000e¢\u0006\f\u001a\u0004\bW\u0010\u0017\"\u0004\bX\u0010\u0019R(\u0010Y\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0007\u001a\u0004\u0018\u00010\u000e8V@VX\u000e¢\u0006\f\u001a\u0004\bZ\u0010\u0011\"\u0004\b[\u0010\u0013R(\u0010\\\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0007\u001a\u0004\u0018\u00010\u000e8V@VX\u000e¢\u0006\f\u001a\u0004\b]\u0010\u0011\"\u0004\b^\u0010\u0013R(\u0010_\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0007\u001a\u0004\u0018\u00010\u000e8V@VX\u000e¢\u0006\f\u001a\u0004\b`\u0010\u0011\"\u0004\ba\u0010\u0013R(\u0010b\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0007\u001a\u0004\u0018\u00010\u000e8V@VX\u000e¢\u0006\f\u001a\u0004\bc\u0010\u0011\"\u0004\bd\u0010\u0013R(\u0010e\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0007\u001a\u0004\u0018\u00010\u000e8V@VX\u000e¢\u0006\f\u001a\u0004\bf\u0010\u0011\"\u0004\bg\u0010\u0013R(\u0010h\u001a\u0004\u0018\u00010\u00142\b\u0010\u0007\u001a\u0004\u0018\u00010\u00148V@VX\u000e¢\u0006\f\u001a\u0004\bi\u0010\u0017\"\u0004\bj\u0010\u0019¨\u0006k"}, d2 = {"Lcom/sumsub/sns/core/theme/MetricsScopeImpl;", "Lcom/sumsub/sns/core/theme/MetricsScope;", "map", "Ljava/util/HashMap;", "Lcom/sumsub/sns/core/theme/SNSMetricElement;", "Ljava/lang/Object;", "(Ljava/util/HashMap;)V", "v", "Lcom/sumsub/sns/core/theme/SNSThemeMetric$Size;", "activityIndicatorStyle", "getActivityIndicatorStyle", "()Lcom/sumsub/sns/core/theme/SNSThemeMetric$Size;", "setActivityIndicatorStyle", "(Lcom/sumsub/sns/core/theme/SNSThemeMetric$Size;)V", "Lcom/sumsub/sns/core/theme/SNSThemeMetric$CardStyle;", "agreementCardStyle", "getAgreementCardStyle", "()Lcom/sumsub/sns/core/theme/SNSThemeMetric$CardStyle;", "setAgreementCardStyle", "(Lcom/sumsub/sns/core/theme/SNSThemeMetric$CardStyle;)V", "", "bottomSheetCornerRadius", "getBottomSheetCornerRadius", "()Ljava/lang/Float;", "setBottomSheetCornerRadius", "(Ljava/lang/Float;)V", "Landroid/util/SizeF;", "bottomSheetHandleSize", "getBottomSheetHandleSize", "()Landroid/util/SizeF;", "setBottomSheetHandleSize", "(Landroid/util/SizeF;)V", "buttonBorderWidth", "getButtonBorderWidth", "setButtonBorderWidth", "buttonCornerRadius", "getButtonCornerRadius", "setButtonCornerRadius", "buttonHeight", "getButtonHeight", "setButtonHeight", "cardBorderWidth", "getCardBorderWidth", "setCardBorderWidth", "cardCornerRadius", "getCardCornerRadius", "setCardCornerRadius", "documentFrameBorderWidth", "getDocumentFrameBorderWidth", "setDocumentFrameBorderWidth", "documentFrameCornerRadius", "getDocumentFrameCornerRadius", "setDocumentFrameCornerRadius", "documentTypeCardStyle", "getDocumentTypeCardStyle", "setDocumentTypeCardStyle", "fieldBorderWidth", "getFieldBorderWidth", "setFieldBorderWidth", "fieldCornerRadius", "getFieldCornerRadius", "setFieldCornerRadius", "fieldHeight", "getFieldHeight", "setFieldHeight", "listSeparatorHeight", "getListSeparatorHeight", "setListSeparatorHeight", "listSeparatorMarginLeft", "getListSeparatorMarginLeft", "setListSeparatorMarginLeft", "listSeparatorMarginRight", "getListSeparatorMarginRight", "setListSeparatorMarginRight", "Lcom/sumsub/sns/core/theme/SNSThemeMetric$TextAlignment;", "screenHeaderAlignment", "getScreenHeaderAlignment", "()Lcom/sumsub/sns/core/theme/SNSThemeMetric$TextAlignment;", "setScreenHeaderAlignment", "(Lcom/sumsub/sns/core/theme/SNSThemeMetric$TextAlignment;)V", "screenHorizontalMargin", "getScreenHorizontalMargin", "setScreenHorizontalMargin", "sectionHeaderAlignment", "getSectionHeaderAlignment", "setSectionHeaderAlignment", "segmentedControlCornerRadius", "getSegmentedControlCornerRadius", "setSegmentedControlCornerRadius", "selectedCountryCardStyle", "getSelectedCountryCardStyle", "setSelectedCountryCardStyle", "supportItemCardStyle", "getSupportItemCardStyle", "setSupportItemCardStyle", "verificationStepCardStyle", "getVerificationStepCardStyle", "setVerificationStepCardStyle", "videoIdentLanguageCardStyle", "getVideoIdentLanguageCardStyle", "setVideoIdentLanguageCardStyle", "videoIdentStepCardStyle", "getVideoIdentStepCardStyle", "setVideoIdentStepCardStyle", "viewportBorderWidth", "getViewportBorderWidth", "setViewportBorderWidth", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class MetricsScopeImpl implements MetricsScope {
    private final HashMap<SNSMetricElement, Object> map;

    public MetricsScopeImpl(HashMap<SNSMetricElement, Object> hashMap) {
        this.map = hashMap;
    }

    public SNSThemeMetric.Size getActivityIndicatorStyle() {
        return (SNSThemeMetric.Size) this.map.get(SNSMetricElement.ACTIVITY_INDICATOR_STYLE);
    }

    public SNSThemeMetric.CardStyle getAgreementCardStyle() {
        return (SNSThemeMetric.CardStyle) this.map.get(SNSMetricElement.AGREEMENT_CARD_STYLE);
    }

    public Float getBottomSheetCornerRadius() {
        return (Float) this.map.get(SNSMetricElement.BOTTOM_SHEET_CORNER_RADIUS);
    }

    public SizeF getBottomSheetHandleSize() {
        return (SizeF) this.map.get(SNSMetricElement.BOTTOM_SHEET_HANDLE_SIZE);
    }

    public Float getButtonBorderWidth() {
        return (Float) this.map.get(SNSMetricElement.BUTTON_BORDER_WIDTH);
    }

    public Float getButtonCornerRadius() {
        return (Float) this.map.get(SNSMetricElement.BUTTON_CORNER_RADIUS);
    }

    public Float getButtonHeight() {
        return (Float) this.map.get(SNSMetricElement.BUTTON_HEIGHT);
    }

    public Float getCardBorderWidth() {
        return (Float) this.map.get(SNSMetricElement.CARD_BORDER_WIDTH);
    }

    public Float getCardCornerRadius() {
        return (Float) this.map.get(SNSMetricElement.CARD_CORNER_RADIUS);
    }

    public Float getDocumentFrameBorderWidth() {
        return (Float) this.map.get(SNSMetricElement.DOCUMENT_FRAME_BORDER_WIDTH);
    }

    public Float getDocumentFrameCornerRadius() {
        return (Float) this.map.get(SNSMetricElement.DOCUMENT_FRAME_CORNER_RADIUS);
    }

    public SNSThemeMetric.CardStyle getDocumentTypeCardStyle() {
        return (SNSThemeMetric.CardStyle) this.map.get(SNSMetricElement.DOCUMENT_TYPE_CARD_STYLE);
    }

    public Float getFieldBorderWidth() {
        return (Float) this.map.get(SNSMetricElement.FIELD_BORDER_WIDTH);
    }

    public Float getFieldCornerRadius() {
        return (Float) this.map.get(SNSMetricElement.FIELD_CORNER_RADIUS);
    }

    public Float getFieldHeight() {
        return (Float) this.map.get(SNSMetricElement.FIELD_HEIGHT);
    }

    public Float getListSeparatorHeight() {
        return (Float) this.map.get(SNSMetricElement.LIST_SEPARATOR_HEIGHT);
    }

    public Float getListSeparatorMarginLeft() {
        return (Float) this.map.get(SNSMetricElement.LIST_SEPARATOR_MARGIN_LEFT);
    }

    public Float getListSeparatorMarginRight() {
        return (Float) this.map.get(SNSMetricElement.LIST_SEPARATOR_MARGIN_RIGHT);
    }

    public SNSThemeMetric.TextAlignment getScreenHeaderAlignment() {
        return (SNSThemeMetric.TextAlignment) this.map.get(SNSMetricElement.SCREEN_HEADER_ALIGNMENT);
    }

    public Float getScreenHorizontalMargin() {
        return (Float) this.map.get(SNSMetricElement.SCREEN_HORIZONTAL_MARGIN);
    }

    public SNSThemeMetric.TextAlignment getSectionHeaderAlignment() {
        return (SNSThemeMetric.TextAlignment) this.map.get(SNSMetricElement.SECTION_HEADER_ALIGNMENT);
    }

    public Float getSegmentedControlCornerRadius() {
        return (Float) this.map.get(SNSMetricElement.SEGMENTED_CONTROL_CORNER_RADIUS);
    }

    public SNSThemeMetric.CardStyle getSelectedCountryCardStyle() {
        return (SNSThemeMetric.CardStyle) this.map.get(SNSMetricElement.SELECTED_COUNTRY_CARD_STYLE);
    }

    public SNSThemeMetric.CardStyle getSupportItemCardStyle() {
        return (SNSThemeMetric.CardStyle) this.map.get(SNSMetricElement.SUPPORT_ITEM_CARD_STYLE);
    }

    public SNSThemeMetric.CardStyle getVerificationStepCardStyle() {
        return (SNSThemeMetric.CardStyle) this.map.get(SNSMetricElement.VERIFICATION_STEP_CARD_STYLE);
    }

    public SNSThemeMetric.CardStyle getVideoIdentLanguageCardStyle() {
        return (SNSThemeMetric.CardStyle) this.map.get(SNSMetricElement.VIDEO_IDENT_LANGUAGE_CARD_STYLE);
    }

    public SNSThemeMetric.CardStyle getVideoIdentStepCardStyle() {
        return (SNSThemeMetric.CardStyle) this.map.get(SNSMetricElement.VIDEO_IDENT_STEP_CARD_STYLE);
    }

    public Float getViewportBorderWidth() {
        return (Float) this.map.get(SNSMetricElement.VIEWPORT_BORDER_WIDTH);
    }

    public void setActivityIndicatorStyle(SNSThemeMetric.Size size) {
        if (size != null) {
            this.map.put(SNSMetricElement.ACTIVITY_INDICATOR_STYLE, size);
        }
    }

    public void setAgreementCardStyle(SNSThemeMetric.CardStyle cardStyle) {
        if (cardStyle != null) {
            this.map.put(SNSMetricElement.AGREEMENT_CARD_STYLE, cardStyle);
        }
    }

    public void setBottomSheetCornerRadius(Float f11) {
        if (f11 != null) {
            this.map.put(SNSMetricElement.BOTTOM_SHEET_CORNER_RADIUS, Float.valueOf(f11.floatValue()));
        }
    }

    public void setBottomSheetHandleSize(SizeF sizeF) {
        if (sizeF != null) {
            this.map.put(SNSMetricElement.BOTTOM_SHEET_HANDLE_SIZE, sizeF);
        }
    }

    public void setButtonBorderWidth(Float f11) {
        if (f11 != null) {
            this.map.put(SNSMetricElement.BUTTON_BORDER_WIDTH, Float.valueOf(f11.floatValue()));
        }
    }

    public void setButtonCornerRadius(Float f11) {
        if (f11 != null) {
            this.map.put(SNSMetricElement.BUTTON_CORNER_RADIUS, Float.valueOf(f11.floatValue()));
        }
    }

    public void setButtonHeight(Float f11) {
        if (f11 != null) {
            this.map.put(SNSMetricElement.BUTTON_HEIGHT, Float.valueOf(f11.floatValue()));
        }
    }

    public void setCardBorderWidth(Float f11) {
        if (f11 != null) {
            this.map.put(SNSMetricElement.CARD_BORDER_WIDTH, Float.valueOf(f11.floatValue()));
        }
    }

    public void setCardCornerRadius(Float f11) {
        if (f11 != null) {
            this.map.put(SNSMetricElement.CARD_CORNER_RADIUS, Float.valueOf(f11.floatValue()));
        }
    }

    public void setDocumentFrameBorderWidth(Float f11) {
        if (f11 != null) {
            this.map.put(SNSMetricElement.DOCUMENT_FRAME_BORDER_WIDTH, Float.valueOf(f11.floatValue()));
        }
    }

    public void setDocumentFrameCornerRadius(Float f11) {
        if (f11 != null) {
            this.map.put(SNSMetricElement.DOCUMENT_FRAME_CORNER_RADIUS, Float.valueOf(f11.floatValue()));
        }
    }

    public void setDocumentTypeCardStyle(SNSThemeMetric.CardStyle cardStyle) {
        if (cardStyle != null) {
            this.map.put(SNSMetricElement.DOCUMENT_TYPE_CARD_STYLE, cardStyle);
        }
    }

    public void setFieldBorderWidth(Float f11) {
        if (f11 != null) {
            this.map.put(SNSMetricElement.FIELD_BORDER_WIDTH, Float.valueOf(f11.floatValue()));
        }
    }

    public void setFieldCornerRadius(Float f11) {
        if (f11 != null) {
            this.map.put(SNSMetricElement.FIELD_CORNER_RADIUS, Float.valueOf(f11.floatValue()));
        }
    }

    public void setFieldHeight(Float f11) {
        if (f11 != null) {
            this.map.put(SNSMetricElement.FIELD_HEIGHT, Float.valueOf(f11.floatValue()));
        }
    }

    public void setListSeparatorHeight(Float f11) {
        if (f11 != null) {
            this.map.put(SNSMetricElement.LIST_SEPARATOR_HEIGHT, Float.valueOf(f11.floatValue()));
        }
    }

    public void setListSeparatorMarginLeft(Float f11) {
        if (f11 != null) {
            this.map.put(SNSMetricElement.LIST_SEPARATOR_MARGIN_LEFT, Float.valueOf(f11.floatValue()));
        }
    }

    public void setListSeparatorMarginRight(Float f11) {
        if (f11 != null) {
            this.map.put(SNSMetricElement.LIST_SEPARATOR_MARGIN_RIGHT, Float.valueOf(f11.floatValue()));
        }
    }

    public void setScreenHeaderAlignment(SNSThemeMetric.TextAlignment textAlignment) {
        if (textAlignment != null) {
            this.map.put(SNSMetricElement.SCREEN_HEADER_ALIGNMENT, textAlignment);
        }
    }

    public void setScreenHorizontalMargin(Float f11) {
        if (f11 != null) {
            this.map.put(SNSMetricElement.SCREEN_HORIZONTAL_MARGIN, Float.valueOf(f11.floatValue()));
        }
    }

    public void setSectionHeaderAlignment(SNSThemeMetric.TextAlignment textAlignment) {
        if (textAlignment != null) {
            this.map.put(SNSMetricElement.SECTION_HEADER_ALIGNMENT, textAlignment);
        }
    }

    public void setSegmentedControlCornerRadius(Float f11) {
        if (f11 != null) {
            this.map.put(SNSMetricElement.SEGMENTED_CONTROL_CORNER_RADIUS, Float.valueOf(f11.floatValue()));
        }
    }

    public void setSelectedCountryCardStyle(SNSThemeMetric.CardStyle cardStyle) {
        if (cardStyle != null) {
            this.map.put(SNSMetricElement.SELECTED_COUNTRY_CARD_STYLE, cardStyle);
        }
    }

    public void setSupportItemCardStyle(SNSThemeMetric.CardStyle cardStyle) {
        if (cardStyle != null) {
            this.map.put(SNSMetricElement.SUPPORT_ITEM_CARD_STYLE, cardStyle);
        }
    }

    public void setVerificationStepCardStyle(SNSThemeMetric.CardStyle cardStyle) {
        if (cardStyle != null) {
            this.map.put(SNSMetricElement.VERIFICATION_STEP_CARD_STYLE, cardStyle);
        }
    }

    public void setVideoIdentLanguageCardStyle(SNSThemeMetric.CardStyle cardStyle) {
        if (cardStyle != null) {
            this.map.put(SNSMetricElement.VIDEO_IDENT_LANGUAGE_CARD_STYLE, cardStyle);
        }
    }

    public void setVideoIdentStepCardStyle(SNSThemeMetric.CardStyle cardStyle) {
        if (cardStyle != null) {
            this.map.put(SNSMetricElement.VIDEO_IDENT_STEP_CARD_STYLE, cardStyle);
        }
    }

    public void setViewportBorderWidth(Float f11) {
        if (f11 != null) {
            this.map.put(SNSMetricElement.VIEWPORT_BORDER_WIDTH, Float.valueOf(f11.floatValue()));
        }
    }
}
