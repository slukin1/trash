package com.sumsub.sns.prooface;

import androidx.annotation.Keep;
import com.sumsub.sns.core.SNSModule;
import kotlin.Metadata;
import kotlin.jvm.internal.r;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0007\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0007R\u0011\u0010\b\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\b\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/sumsub/sns/prooface/SNSProoface;", "Lcom/sumsub/sns/core/SNSModule;", "feature", "", "(I)V", "isDebug", "", "()Z", "isShowSettingsDialog", "Companion", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@Keep
public final class SNSProoface extends SNSModule {
    public static final Companion Companion = new Companion((r) null);
    @Keep
    public static final int FEATURE_FACE_DETECTION_DEBUG = 1;
    public static final int FEATURE_FACE_SHOW_SETTINGS = 2;
    private final int feature;

    @Keep
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/sumsub/sns/prooface/SNSProoface$Companion;", "", "()V", "FEATURE_FACE_DETECTION_DEBUG", "", "FEATURE_FACE_SHOW_SETTINGS", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(r rVar) {
            this();
        }

        private Companion() {
        }
    }

    public SNSProoface() {
        this(0, 1, (r) null);
    }

    public final boolean isDebug() {
        return (this.feature & 1) != 0;
    }

    public final boolean isShowSettingsDialog() {
        return (this.feature & 2) != 0;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SNSProoface(int i11, int i12, r rVar) {
        this((i12 & 1) != 0 ? 0 : i11);
    }

    public SNSProoface(int i11) {
        super("Advanced 3D Face Scanning");
        this.feature = i11;
    }
}
