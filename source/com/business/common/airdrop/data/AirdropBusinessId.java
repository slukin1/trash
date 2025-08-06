package com.business.common.airdrop.data;

import androidx.annotation.Keep;

@Keep
public enum AirdropBusinessId {
    OPEN("huobi_airdrop_red_rule_open"),
    CLOSE("huobi_airdrop_red_rule_close");
    

    /* renamed from: id  reason: collision with root package name */
    private final String f64275id;

    private AirdropBusinessId(String str) {
        this.f64275id = str;
    }

    public final String getId() {
        return this.f64275id;
    }
}
