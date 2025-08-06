package com.huobi.edgeengine.util;

import com.tencent.android.tpush.common.Constants;

public enum EdgeEngineScene {
    COPY_TRADING("copytrading"),
    SHARK_FIN("SharkFin"),
    ACCOUNT(Constants.FLAG_ACCOUNT),
    EARN("earn"),
    DOUBLE_COIN("doublecoin"),
    TRADE_BOT("tradingBot"),
    HOT_COIN_RADAR("hotcoinradar"),
    SIMPLE_EARN("simpleearn"),
    OTC_P2P("otcp2p"),
    OTC_MERCHANT_SEARCH("otcmerchantsearch");
    
    private String scene;

    private EdgeEngineScene(String str) {
        this.scene = str;
    }

    public final String getScene() {
        return this.scene;
    }

    public final void setScene(String str) {
        this.scene = str;
    }
}
