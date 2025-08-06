package com.sumsub.sns.core;

import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.r;

@a
@Keep
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0007\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0007R\u0011\u0010\b\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\b\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/sumsub/sns/core/SNSCoreModule;", "Lcom/sumsub/sns/core/SNSModule;", "feature", "", "(I)V", "isFullScreenCamera", "", "()Z", "isSkipGeolocationForm", "Companion", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SNSCoreModule extends SNSModule {
    public static final Companion Companion = new Companion((r) null);
    @Keep
    public static final int FEATURE_FULLSCREEN_CAMERA = 4;
    @Keep
    public static final int FEATURE_SKIP_GEOLOCATION_FORM = 2;
    private final int feature;

    @Keep
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006XT¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00048\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/sumsub/sns/core/SNSCoreModule$Companion;", "", "()V", "FEATURE_FULLSCREEN_CAMERA", "", "FEATURE_SKIP_GEOLOCATION_FORM", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(r rVar) {
            this();
        }

        private Companion() {
        }
    }

    public SNSCoreModule() {
        this(0, 1, (r) null);
    }

    public final boolean isFullScreenCamera() {
        return (this.feature & 4) != 0;
    }

    public final boolean isSkipGeolocationForm() {
        return (this.feature & 2) != 0;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SNSCoreModule(int i11, int i12, r rVar) {
        this((i12 & 1) != 0 ? 0 : i11);
    }

    public SNSCoreModule(int i11) {
        super("Core module");
        this.feature = i11;
    }
}
