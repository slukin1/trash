package com.hbg.lib.network.pro.socket.response;

import com.hbg.lib.network.pro.core.response.StringStatusResponse;
import com.hbg.lib.network.pro.socket.bean.MarketTradeDetailInfo;
import java.util.List;

public class RequestMarketTradeDetailResponse extends StringStatusResponse<List<MarketTradeDetailInfo>> {
    private static final long serialVersionUID = 5029716312428975159L;
    private String period;
    private String rep;
    private String symbol;

    public String getPeriod() {
        return this.period;
    }

    public String getRep() {
        return this.rep;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public void setRep(String str) {
        this.rep = str;
        String[] split = str.split("\\.");
        this.symbol = split[1];
        this.period = split[3];
    }
}
