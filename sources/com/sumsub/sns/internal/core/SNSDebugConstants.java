package com.sumsub.sns.internal.core;

import androidx.annotation.Keep;
import com.sumsub.sns.internal.core.common.e0;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u00048FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u00020\u00048FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\f"}, d2 = {"Lcom/sumsub/sns/internal/core/SNSDebugConstants;", "", "()V", "brakeToken", "", "getBrakeToken", "()Z", "setBrakeToken", "(Z)V", "muteVideoIdent", "getMuteVideoIdent", "setMuteVideoIdent", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@Keep
public final class SNSDebugConstants {
    public static final SNSDebugConstants INSTANCE = new SNSDebugConstants();
    private static boolean brakeToken;
    private static boolean muteVideoIdent;

    private SNSDebugConstants() {
    }

    public final boolean getBrakeToken() {
        return e0.f32018a.isDebug() && brakeToken;
    }

    public final boolean getMuteVideoIdent() {
        return e0.f32018a.isDebug() && muteVideoIdent;
    }

    public final void setBrakeToken(boolean z11) {
        brakeToken = z11;
    }

    public final void setMuteVideoIdent(boolean z11) {
        muteVideoIdent = z11;
    }
}
