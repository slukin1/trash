package com.hbg.lib.network.pro.socket.response;

import com.hbg.lib.network.pro.core.response.StringStatusResponse;
import com.hbg.lib.network.pro.socket.bean.SymbolPrice;
import com.hbg.lib.network.pro.socket.bean.SymbolPriceV2;
import java.util.ArrayList;
import java.util.Map;

public class MarketOverviewV2Response extends StringStatusResponse<Map<String, SymbolPriceV2>> {
    private static final long serialVersionUID = -7375644434402511885L;

    /* renamed from: ch  reason: collision with root package name */
    private String f70649ch;

    /* renamed from: ts  reason: collision with root package name */
    private long f70650ts;

    public String getCh() {
        return this.f70649ch;
    }

    public long getTs() {
        return this.f70650ts;
    }

    public void setCh(String str) {
        this.f70649ch = str;
    }

    public void setTs(long j11) {
        this.f70650ts = j11;
    }

    public MarketOverviewResponse unify() {
        MarketOverviewResponse marketOverviewResponse = new MarketOverviewResponse();
        marketOverviewResponse.setCh(this.f70649ch);
        marketOverviewResponse.setTs(this.f70650ts);
        marketOverviewResponse.setStatus(getStatus());
        marketOverviewResponse.setErrCode(getErrCode());
        marketOverviewResponse.setErrMsg(getErrMsg());
        ArrayList arrayList = new ArrayList();
        marketOverviewResponse.setData(arrayList);
        for (Map.Entry entry : ((Map) getData()).entrySet()) {
            SymbolPriceV2 symbolPriceV2 = (SymbolPriceV2) entry.getValue();
            SymbolPrice symbolPrice = new SymbolPrice();
            symbolPrice.setSymbol((String) entry.getKey());
            symbolPrice.setHigh(symbolPriceV2.getHigh());
            symbolPrice.setOpen(symbolPriceV2.getOpen());
            symbolPrice.setLow(symbolPriceV2.getLow());
            symbolPrice.setClose(symbolPriceV2.getClose());
            symbolPrice.setAmount(symbolPriceV2.getAmount());
            symbolPrice.setCount(symbolPriceV2.getCount());
            symbolPrice.setVol(symbolPriceV2.getVol());
            symbolPrice.setRise(symbolPriceV2.getRise());
            arrayList.add(symbolPrice);
        }
        return marketOverviewResponse;
    }
}
