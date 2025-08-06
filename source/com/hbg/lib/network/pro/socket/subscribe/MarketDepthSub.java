package com.hbg.lib.network.pro.socket.subscribe;

import com.hbg.lib.network.retrofit.websocket.sub.BaseSocketSub;
import d2.b;

public class MarketDepthSub extends BaseSocketSub {
    public static final int DEFAULT_SIZE = 20;
    public static final int DEFAULT_SIZE_NEW = 150;
    private static final long serialVersionUID = -4441671119774882324L;
    private String[] pick;
    @b(serialize = false)
    private String symbol;
    @b(serialize = false)
    private String type;

    public MarketDepthSub(boolean z11, String str, String str2) {
        this(z11, str, str2, 20);
    }

    public String[] getPick() {
        return this.pick;
    }

    public MarketDepthSub(boolean z11, String str, String str2, int i11) {
        super(z11);
        this.pick = new String[]{"", ""};
        this.symbol = str;
        this.type = str2;
        setChannel("market." + str + ".depth." + str2);
        String[] strArr = this.pick;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("bids.");
        sb2.append(i11);
        strArr[0] = sb2.toString();
        String[] strArr2 = this.pick;
        strArr2[1] = "asks." + i11;
    }
}
