package com.huobi.trade.service;

import com.hbg.lib.core.network.response.UcIntCodeResponse;
import com.hbg.lib.network.pro.socket.bean.SymbolPrice;
import java.util.List;
import java.util.Map;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import rx.Observable;

public interface TradeService {
    @GET("quotation/market/history/kline")
    Observable<UcIntCodeResponse<List<SymbolPrice>>> historyKline(@QueryMap Map<String, Object> map);
}
