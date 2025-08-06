package com.hbg.lib.network.pro.socket.subscribe;

import com.hbg.lib.network.retrofit.websocket.sub.BaseSocketSub;
import d2.b;

public class LastKlineSub extends BaseSocketSub {
    private static final long serialVersionUID = -6689825555670205022L;
    @b(serialize = false)
    private String period;
    @b(serialize = false)
    private String symbol;

    public LastKlineSub(boolean z11, String str, String str2) {
        super(z11);
        this.symbol = str;
        this.period = str2;
        setChannel("market." + str + ".kline." + str2);
    }
}
