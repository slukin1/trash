package com.huobi.data;

import androidx.annotation.Keep;
import kotlin.jvm.internal.r;

@Keep
public final class PassKeyModel {
    private final PassKeyAuthResultModel data;
    private final boolean success;

    public PassKeyModel(boolean z11, PassKeyAuthResultModel passKeyAuthResultModel) {
        this.success = z11;
        this.data = passKeyAuthResultModel;
    }

    public final PassKeyAuthResultModel getData() {
        return this.data;
    }

    public final boolean getSuccess() {
        return this.success;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PassKeyModel(boolean z11, PassKeyAuthResultModel passKeyAuthResultModel, int i11, r rVar) {
        this(z11, (i11 & 2) != 0 ? null : passKeyAuthResultModel);
    }
}
