package com.huobi.data;

import androidx.annotation.Keep;
import kotlin.jvm.internal.r;

@Keep
public final class Verify2FAModel {
    private final Verify2FATokenModel data;
    private final boolean success;

    public Verify2FAModel(boolean z11, Verify2FATokenModel verify2FATokenModel) {
        this.success = z11;
        this.data = verify2FATokenModel;
    }

    public final Verify2FATokenModel getData() {
        return this.data;
    }

    public final boolean getSuccess() {
        return this.success;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Verify2FAModel(boolean z11, Verify2FATokenModel verify2FATokenModel, int i11, r rVar) {
        this(z11, (i11 & 2) != 0 ? null : verify2FATokenModel);
    }
}
