package com.hbg.lib.network.pro.socket.response;

import com.hbg.lib.network.pro.core.response.StringStatusResponse;
import com.hbg.lib.network.pro.socket.bean.KlineInfo;
import java.util.List;

public class KLineResponse extends StringStatusResponse<List<KlineInfo>> {
    private static final long serialVersionUID = 7977461040434241427L;
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

    public String toString() {
        return "{status='" + getStatus() + '\'' + ", symbol='" + this.symbol + '\'' + ", period='" + this.period + '\'' + ", rep='" + this.rep + '\'' + ", errMsg='" + getErrMsg() + '\'' + ", errCode='" + getErrCode() + '\'' + ", data='" + getData() + '\'' + '}';
    }
}
