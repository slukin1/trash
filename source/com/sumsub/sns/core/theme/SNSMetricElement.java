package com.sumsub.sns.core.theme;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.r;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b!\b\u0001\u0018\u0000 #2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001#B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"¨\u0006$"}, d2 = {"Lcom/sumsub/sns/core/theme/SNSMetricElement;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "SCREEN_HORIZONTAL_MARGIN", "BUTTON_HEIGHT", "BUTTON_CORNER_RADIUS", "BUTTON_BORDER_WIDTH", "FIELD_HEIGHT", "FIELD_CORNER_RADIUS", "FIELD_BORDER_WIDTH", "VIEWPORT_BORDER_WIDTH", "BOTTOM_SHEET_CORNER_RADIUS", "CARD_CORNER_RADIUS", "CARD_BORDER_WIDTH", "LIST_SEPARATOR_HEIGHT", "LIST_SEPARATOR_MARGIN_LEFT", "LIST_SEPARATOR_MARGIN_RIGHT", "VERIFICATION_STEP_CARD_STYLE", "SUPPORT_ITEM_CARD_STYLE", "DOCUMENT_TYPE_CARD_STYLE", "SELECTED_COUNTRY_CARD_STYLE", "AGREEMENT_CARD_STYLE", "VIDEO_IDENT_LANGUAGE_CARD_STYLE", "VIDEO_IDENT_STEP_CARD_STYLE", "SCREEN_HEADER_ALIGNMENT", "SECTION_HEADER_ALIGNMENT", "ACTIVITY_INDICATOR_STYLE", "BOTTOM_SHEET_HANDLE_SIZE", "SEGMENTED_CONTROL_CORNER_RADIUS", "DOCUMENT_FRAME_BORDER_WIDTH", "DOCUMENT_FRAME_CORNER_RADIUS", "Companion", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public enum SNSMetricElement {
    SCREEN_HORIZONTAL_MARGIN("screenHorizontalMargin"),
    BUTTON_HEIGHT("buttonHeight"),
    BUTTON_CORNER_RADIUS("buttonCornerRadius"),
    BUTTON_BORDER_WIDTH("buttonBorderWidth"),
    FIELD_HEIGHT("fieldHeight"),
    FIELD_CORNER_RADIUS("fieldCornerRadius"),
    FIELD_BORDER_WIDTH("fieldBorderWidth"),
    VIEWPORT_BORDER_WIDTH("viewportBorderWidth"),
    BOTTOM_SHEET_CORNER_RADIUS("bottomSheetCornerRadius"),
    CARD_CORNER_RADIUS("cardCornerRadius"),
    CARD_BORDER_WIDTH("cardBorderWidth"),
    LIST_SEPARATOR_HEIGHT("listSeparatorHeight"),
    LIST_SEPARATOR_MARGIN_LEFT("listSeparatorMarginLeft"),
    LIST_SEPARATOR_MARGIN_RIGHT("listSeparatorMarginRight"),
    VERIFICATION_STEP_CARD_STYLE("verificationStepCardStyle"),
    SUPPORT_ITEM_CARD_STYLE("supportItemCardStyle"),
    DOCUMENT_TYPE_CARD_STYLE("documentTypeCardStyle"),
    SELECTED_COUNTRY_CARD_STYLE("selectedCountryCardStyle"),
    AGREEMENT_CARD_STYLE("agreementItemCardStyle"),
    VIDEO_IDENT_LANGUAGE_CARD_STYLE("videoIdentLanguageCardStyle"),
    VIDEO_IDENT_STEP_CARD_STYLE("videoIdentStepCardStyle"),
    SCREEN_HEADER_ALIGNMENT("screenHeaderAlignment"),
    SECTION_HEADER_ALIGNMENT("sectionHeaderAlignment"),
    ACTIVITY_INDICATOR_STYLE("activityIndicatorStyle"),
    BOTTOM_SHEET_HANDLE_SIZE("bottomSheetHandleSize"),
    SEGMENTED_CONTROL_CORNER_RADIUS("segmentedControlCornerRadius"),
    DOCUMENT_FRAME_BORDER_WIDTH("documentFrameBorderWidth"),
    DOCUMENT_FRAME_CORNER_RADIUS("documentFrameCornerRadius");
    
    public static final Companion Companion = null;
    /* access modifiers changed from: private */
    public static final List<String> names = null;
    private final String value;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/sumsub/sns/core/theme/SNSMetricElement$Companion;", "", "()V", "names", "", "", "getNames", "()Ljava/util/List;", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(r rVar) {
            this();
        }

        public final List<String> getNames() {
            return SNSMetricElement.names;
        }

        private Companion() {
        }
    }

    /* access modifiers changed from: public */
    static {
        int i11;
        Companion = new Companion((r) null);
        SNSMetricElement[] values = values();
        ArrayList arrayList = new ArrayList(values.length);
        for (SNSMetricElement sNSMetricElement : values) {
            arrayList.add(sNSMetricElement.value);
        }
        names = arrayList;
    }

    private SNSMetricElement(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }
}
