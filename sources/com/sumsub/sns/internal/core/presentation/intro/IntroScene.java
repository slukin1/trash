package com.sumsub.sns.internal.core.presentation.intro;

import androidx.annotation.Keep;
import com.sumsub.sns.internal.core.common.n0;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016¨\u0006\u0017"}, d2 = {"Lcom/sumsub/sns/internal/core/presentation/intro/IntroScene;", "", "sceneName", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getSceneName", "()Ljava/lang/String;", "FACESCAN", "VIDEOSELFIE", "PHOTOSELFIE", "SCAN_FRONTSIDE", "SCAN_BACKSIDE", "DATA", "CONFIRMATION", "QUESTIONNAIRE", "VIDEO_IDENT", "GEO", "MRTD_PREPARING", "MRTD_SCANNING", "MRTD_SCANNED", "MRTD_FAILED", "PORTRAIT_SELFIE", "EKYC", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@Keep
public enum IntroScene {
    FACESCAN("facescan"),
    VIDEOSELFIE("videoSelfie"),
    PHOTOSELFIE("photoSelfie"),
    SCAN_FRONTSIDE("scan_frontSide"),
    SCAN_BACKSIDE("scan_backSide"),
    DATA("data"),
    CONFIRMATION("confirmation"),
    QUESTIONNAIRE("questionnaire"),
    VIDEO_IDENT(n0.j.a.f32228i),
    GEO("geolocation"),
    MRTD_PREPARING("mrtd_preparing"),
    MRTD_SCANNING("mrtd_scanning"),
    MRTD_SCANNED("mrtd_scanned"),
    MRTD_FAILED("mrtd_failed"),
    PORTRAIT_SELFIE("portraitSelfie"),
    EKYC("ekyc");
    
    private final String sceneName;

    private IntroScene(String str) {
        this.sceneName = str;
    }

    public final String getSceneName() {
        return this.sceneName;
    }
}
