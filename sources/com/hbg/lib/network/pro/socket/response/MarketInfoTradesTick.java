package com.hbg.lib.network.pro.socket.response;

import com.hbg.lib.network.pro.socket.bean.MarketTradeDetailInfo;
import java.io.Serializable;
import java.util.List;

public class MarketInfoTradesTick implements Serializable {
    private static final long serialVersionUID = -7929603367725189282L;
    private List<MarketTradeDetailInfo> data;

    /* renamed from: id  reason: collision with root package name */
    private String f70645id;

    /* renamed from: ts  reason: collision with root package name */
    private long f70646ts;

    public List<MarketTradeDetailInfo> getData() {
        return this.data;
    }

    public String getId() {
        return this.f70645id;
    }

    public long getTs() {
        return this.f70646ts;
    }

    public void setData(List<MarketTradeDetailInfo> list) {
        this.data = list;
    }

    public void setId(String str) {
        this.f70645id = str;
    }

    public void setTs(long j11) {
        this.f70646ts = j11;
    }
}
