package com.sumsub.sns.internal.core.theme;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u001f\b\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b ¨\u0006!"}, d2 = {"Lcom/sumsub/sns/internal/core/theme/ImageElementName;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "Companion", "a", "ICON_CLOSE", "ICON_SEARCH", "ICON_DISCLOSURE", "ICON_TORCH_ON", "ICON_TORCH_OFF", "ICON_GALLERY", "ICON_MAIL", "ICON_SUCCESS", "ICON_WARNING", "ICON_FAILURE", "ICON_SUBMITTED", "ICON_ROTATE_CW", "ICON_ROTATE_CCW", "ICON_BIN", "ICON_CALENDAR", "PICTURE_SUCCESS", "PICTURE_WARNING", "PICTURE_FAILURE", "PICTURE_SUBMITTED", "VERIFICATION_STEP_ICONS", "DOCUMENT_TYPE_ICONS", "INSTRUCTIONS_IMAGES", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
public enum ImageElementName {
    ICON_CLOSE("iconClose"),
    ICON_SEARCH("iconSearch"),
    ICON_DISCLOSURE("iconDisclosure"),
    ICON_TORCH_ON("iconTorchOn"),
    ICON_TORCH_OFF("iconTorchOff"),
    ICON_GALLERY("iconGallery"),
    ICON_MAIL("iconMail"),
    ICON_SUCCESS("iconSuccess"),
    ICON_WARNING("iconWarning"),
    ICON_FAILURE("iconFailure"),
    ICON_SUBMITTED("iconSubmitted"),
    ICON_ROTATE_CW("iconRotateCW"),
    ICON_ROTATE_CCW("iconRotateCCW"),
    ICON_BIN("iconBin"),
    ICON_CALENDAR("iconCalendar"),
    PICTURE_SUCCESS("pictureSuccess"),
    PICTURE_WARNING("pictureWarning"),
    PICTURE_FAILURE("pictureFailure"),
    PICTURE_SUBMITTED("pictureSubmitted"),
    VERIFICATION_STEP_ICONS("verificationStepIcons"),
    DOCUMENT_TYPE_ICONS("documentTypeIcons"),
    INSTRUCTIONS_IMAGES("instructionsImages");
    
    public static final a Companion = null;
    /* access modifiers changed from: private */
    public static final List<String> names = null;
    private final String value;

    public static final class a {
        public /* synthetic */ a(r rVar) {
            this();
        }

        public final List<String> a() {
            return ImageElementName.names;
        }

        public a() {
        }

        public final ImageElementName a(String str) {
            for (ImageElementName imageElementName : ImageElementName.values()) {
                if (x.b(imageElementName.getValue(), str)) {
                    return imageElementName;
                }
            }
            return null;
        }
    }

    /* access modifiers changed from: public */
    static {
        int i11;
        Companion = new a((r) null);
        ImageElementName[] values = values();
        ArrayList arrayList = new ArrayList(values.length);
        for (ImageElementName imageElementName : values) {
            arrayList.add(imageElementName.value);
        }
        names = arrayList;
    }

    private ImageElementName(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }
}
