package com.huobi.data;

import androidx.annotation.Keep;
import kotlin.jvm.internal.r;

@Keep
public final class Verify2FATokenModel {
    private final String token;

    public Verify2FATokenModel() {
        this((String) null, 1, (r) null);
    }

    public Verify2FATokenModel(String str) {
        this.token = str;
    }

    public final String getToken() {
        return this.token;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Verify2FATokenModel(String str, int i11, r rVar) {
        this((i11 & 1) != 0 ? null : str);
    }
}
