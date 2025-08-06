package com.sumsub.sns.core.theme;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.r;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b4\b\u0001\u0018\u0000 62\b\u0012\u0004\u0012\u00020\u00000\u0001:\u00016B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/j\u0002\b0j\u0002\b1j\u0002\b2j\u0002\b3j\u0002\b4j\u0002\b5¨\u00067"}, d2 = {"Lcom/sumsub/sns/core/theme/SNSColorElement;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "NAVIGATION_BAR_ITEM", "BACKGROUND_COMMON", "BACKGROUND_NEUTRAL", "BACKGROUND_SUCCESS", "BACKGROUND_WARNING", "BACKGROUND_CRITICAL", "CONTENT_LINK", "CONTENT_STRONG", "CONTENT_NEUTRAL", "CONTENT_WEAK", "CONTENT_INFO", "CONTENT_SUCCESS", "CONTENT_WARNING", "CONTENT_CRITICAL", "PRIMARY_BUTTON_BACKGROUND", "PRIMARY_BUTTON_BACKGROUND_HIGHLIGHTED", "PRIMARY_BUTTON_BACKGROUND_DISABLED", "PRIMARY_BUTTON_CONTENT", "PRIMARY_BUTTON_CONTENT_HIGHLIGHTED", "PRIMARY_BUTTON_CONTENT_DISABLED", "SECONDARY_BUTTON_BACKGROUND", "SECONDARY_BUTTON_BACKGROUND_HIGHLIGHTED", "SECONDARY_BUTTON_BACKGROUND_DISABLED", "SECONDARY_BUTTON_CONTENT", "SECONDARY_BUTTON_CONTENT_HIGHLIGHTED", "SECONDARY_BUTTON_CONTENT_DISABLED", "CAMERA_BACKGROUND", "CAMERA_BACKGROUND_OVERLAY", "CAMERA_CONTENT", "CARD_BORDERED_BACKGROUND", "CARD_PLAIN_BACKGROUND", "FIELD_BACKGROUND", "FIELD_BACKGROUND_INVALID", "FIELD_BORDER", "FIELD_BORDER_FOCUSED", "FIELD_BORDER_DISABLED", "FIELD_PLACEHOLDER", "FIELD_CONTENT", "FIELD_TINT", "LIST_SEPARATOR", "LIST_SELECTED_ITEM_BACKGROUND", "BOTTOM_SHEET_HANDLE", "BOTTOM_SHEET_BACKGROUND", "STATUS_BAR_COLOR", "ALERT_TINT", "PROGRESS_BAR_TINT", "PROGRESS_BAR_BACKGROUND", "Companion", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public enum SNSColorElement {
    NAVIGATION_BAR_ITEM("navigationBarItem"),
    BACKGROUND_COMMON("backgroundCommon"),
    BACKGROUND_NEUTRAL("backgroundNeutral"),
    BACKGROUND_SUCCESS("backgroundSuccess"),
    BACKGROUND_WARNING("backgroundWarning"),
    BACKGROUND_CRITICAL("backgroundCritical"),
    CONTENT_LINK("contentLink"),
    CONTENT_STRONG("contentStrong"),
    CONTENT_NEUTRAL("contentNeutral"),
    CONTENT_WEAK("contentWeak"),
    CONTENT_INFO("contentInfo"),
    CONTENT_SUCCESS("contentSuccess"),
    CONTENT_WARNING("contentWarning"),
    CONTENT_CRITICAL("contentCritical"),
    PRIMARY_BUTTON_BACKGROUND("primaryButtonBackground"),
    PRIMARY_BUTTON_BACKGROUND_HIGHLIGHTED("primaryButtonBackgroundHighlighted"),
    PRIMARY_BUTTON_BACKGROUND_DISABLED("primaryButtonBackgroundDisabled"),
    PRIMARY_BUTTON_CONTENT("primaryButtonContent"),
    PRIMARY_BUTTON_CONTENT_HIGHLIGHTED("primaryButtonContentHighlighted"),
    PRIMARY_BUTTON_CONTENT_DISABLED("primaryButtonContentDisabled"),
    SECONDARY_BUTTON_BACKGROUND("secondaryButtonBackground"),
    SECONDARY_BUTTON_BACKGROUND_HIGHLIGHTED("secondaryButtonBackgroundHighlighted"),
    SECONDARY_BUTTON_BACKGROUND_DISABLED("secondaryButtonBackgroundDisabled"),
    SECONDARY_BUTTON_CONTENT("secondaryButtonContent"),
    SECONDARY_BUTTON_CONTENT_HIGHLIGHTED("secondaryButtonContentHighlighted"),
    SECONDARY_BUTTON_CONTENT_DISABLED("secondaryButtonContentDisabled"),
    CAMERA_BACKGROUND("cameraBackground"),
    CAMERA_BACKGROUND_OVERLAY("cameraBackgroundOverlay"),
    CAMERA_CONTENT("cameraContent"),
    CARD_BORDERED_BACKGROUND("cardBorderedBackground"),
    CARD_PLAIN_BACKGROUND("cardPlainBackground"),
    FIELD_BACKGROUND("fieldBackground"),
    FIELD_BACKGROUND_INVALID("fieldBackgroundInvalid"),
    FIELD_BORDER("fieldBorder"),
    FIELD_BORDER_FOCUSED("fieldBorderFocused"),
    FIELD_BORDER_DISABLED("fieldBorderDisabled"),
    FIELD_PLACEHOLDER("fieldPlaceholder"),
    FIELD_CONTENT("fieldContent"),
    FIELD_TINT("fieldTint"),
    LIST_SEPARATOR("listSeparator"),
    LIST_SELECTED_ITEM_BACKGROUND("listSelectedItemBackground"),
    BOTTOM_SHEET_HANDLE("bottomSheetHandle"),
    BOTTOM_SHEET_BACKGROUND("bottomSheetBackground"),
    STATUS_BAR_COLOR("statusBarColor"),
    ALERT_TINT("alertTint"),
    PROGRESS_BAR_TINT("progressBarTint"),
    PROGRESS_BAR_BACKGROUND("progressBarBackground");
    
    public static final Companion Companion = null;
    /* access modifiers changed from: private */
    public static final List<String> names = null;
    private final String value;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/sumsub/sns/core/theme/SNSColorElement$Companion;", "", "()V", "names", "", "", "getNames", "()Ljava/util/List;", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(r rVar) {
            this();
        }

        public final List<String> getNames() {
            return SNSColorElement.names;
        }

        private Companion() {
        }
    }

    /* access modifiers changed from: public */
    static {
        int i11;
        Companion = new Companion((r) null);
        SNSColorElement[] values = values();
        ArrayList arrayList = new ArrayList(values.length);
        for (SNSColorElement sNSColorElement : values) {
            arrayList.add(sNSColorElement.value);
        }
        names = arrayList;
    }

    private SNSColorElement(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }
}
