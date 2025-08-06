package com.hbg.lib.network.pro.socket.request;

import com.alibaba.fastjson.JSON;
import d2.b;

public class TradeDetailRequest extends BaseSocketRequest {
    private int size = 20;
    @b(serialize = false)
    private String symbol;

    public TradeDetailRequest(String str, int i11) {
        this.symbol = str;
        this.size = i11;
        setReq("market." + str + ".trade.detail");
    }

    public int getSize() {
        return this.size;
    }

    public String toString() {
        return JSON.toJSONString(this);
    }
}
