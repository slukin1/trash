package com.hbg.lib.network.pro.socket.response;

import com.hbg.lib.network.pro.core.response.StringStatusResponse;
import com.hbg.lib.network.pro.socket.bean.SymbolPrice;
import java.util.List;

public class MarketOverviewResponse extends StringStatusResponse<List<SymbolPrice>> {
    private static final long serialVersionUID = 7977461040434241427L;

    /* renamed from: ch  reason: collision with root package name */
    private String f70647ch;

    /* renamed from: ts  reason: collision with root package name */
    private long f70648ts;

    public String getCh() {
        return this.f70647ch;
    }

    public long getTs() {
        return this.f70648ts;
    }

    public void setCh(String str) {
        this.f70647ch = str;
    }

    public void setTs(long j11) {
        this.f70648ts = j11;
    }
}
